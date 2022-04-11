package io.netty.buffer;

import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.ByteProcessor.IndexOfProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Locale;

public final class ByteBufUtil
{
  private static final FastThreadLocal<byte[]> BYTE_ARRAYS;
  static final ByteBufAllocator DEFAULT_ALLOCATOR;
  private static final ByteProcessor FIND_NON_ASCII = new ByteProcessor()
  {
    public boolean process(byte paramAnonymousByte)
    {
      boolean bool;
      if (paramAnonymousByte >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  };
  private static final int MAX_BYTES_PER_CHAR_UTF8;
  private static final int MAX_CHAR_BUFFER_SIZE;
  static final int MAX_TL_ARRAY_LEN = 1024;
  private static final int THREAD_LOCAL_BUFFER_SIZE;
  static final int WRITE_CHUNK_SIZE = 8192;
  private static final byte WRITE_UTF_UNKNOWN = 63;
  private static final InternalLogger logger;
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(ByteBufUtil.class);
    logger = localInternalLogger;
    BYTE_ARRAYS = new FastThreadLocal()
    {
      protected byte[] initialValue()
        throws Exception
      {
        return PlatformDependent.allocateUninitializedArray(1024);
      }
    };
    MAX_BYTES_PER_CHAR_UTF8 = (int)CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar();
    Object localObject;
    if (PlatformDependent.isAndroid()) {
      localObject = "unpooled";
    } else {
      localObject = "pooled";
    }
    String str = SystemPropertyUtil.get("io.netty.allocator.type", (String)localObject).toLowerCase(Locale.US).trim();
    if ("unpooled".equals(str))
    {
      localObject = UnpooledByteBufAllocator.DEFAULT;
      localInternalLogger.debug("-Dio.netty.allocator.type: {}", str);
    }
    else if ("pooled".equals(str))
    {
      localObject = PooledByteBufAllocator.DEFAULT;
      localInternalLogger.debug("-Dio.netty.allocator.type: {}", str);
    }
    else
    {
      localObject = PooledByteBufAllocator.DEFAULT;
      localInternalLogger.debug("-Dio.netty.allocator.type: pooled (unknown: {})", str);
    }
    DEFAULT_ALLOCATOR = (ByteBufAllocator)localObject;
    int i = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 0);
    THREAD_LOCAL_BUFFER_SIZE = i;
    localInternalLogger.debug("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(i));
    i = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
    MAX_CHAR_BUFFER_SIZE = i;
    localInternalLogger.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(i));
  }
  
  public static void appendPrettyHexDump(StringBuilder paramStringBuilder, ByteBuf paramByteBuf)
  {
    appendPrettyHexDump(paramStringBuilder, paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
  }
  
  public static void appendPrettyHexDump(StringBuilder paramStringBuilder, ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    HexUtil.appendPrettyHexDump(paramStringBuilder, paramByteBuf, paramInt1, paramInt2);
  }
  
  private static CharSequence checkCharSequenceBounds(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2 - paramInt1, paramCharSequence.length())) {
      return paramCharSequence;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected: 0 <= start(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") <= end (");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") <= seq.length(");
    localStringBuilder.append(paramCharSequence.length());
    localStringBuilder.append(')');
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public static int compare(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    int i = paramByteBuf1.readableBytes();
    int j = paramByteBuf2.readableBytes();
    int k = Math.min(i, j);
    int m = k >>> 2;
    int n = paramByteBuf1.readerIndex();
    int i1 = paramByteBuf2.readerIndex();
    int i2 = n;
    int i3 = i1;
    if (m > 0)
    {
      if (paramByteBuf1.order() == ByteOrder.BIG_ENDIAN) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      i3 = m << 2;
      long l;
      if (paramByteBuf1.order() == paramByteBuf2.order())
      {
        if (i2 != 0) {
          l = compareUintBigEndian(paramByteBuf1, paramByteBuf2, n, i1, i3);
        } else {
          l = compareUintLittleEndian(paramByteBuf1, paramByteBuf2, n, i1, i3);
        }
      }
      else if (i2 != 0) {
        l = compareUintBigEndianA(paramByteBuf1, paramByteBuf2, n, i1, i3);
      } else {
        l = compareUintBigEndianB(paramByteBuf1, paramByteBuf2, n, i1, i3);
      }
      if (l != 0L) {
        return (int)Math.min(2147483647L, Math.max(-2147483648L, l));
      }
      i2 = n + i3;
      i3 = i1 + i3;
    }
    i1 = i3;
    i3 = i2;
    while (i3 < (k & 0x3) + i2)
    {
      n = paramByteBuf1.getUnsignedByte(i3) - paramByteBuf2.getUnsignedByte(i1);
      if (n != 0) {
        return n;
      }
      i3++;
      i1++;
    }
    return i - j;
  }
  
  private static long compareUintBigEndian(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt3 + paramInt1)
    {
      long l = paramByteBuf1.getUnsignedInt(paramInt2) - paramByteBuf2.getUnsignedInt(i);
      if (l != 0L) {
        return l;
      }
      paramInt2 += 4;
      i += 4;
    }
    return 0L;
  }
  
  private static long compareUintBigEndianA(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt3 + paramInt1)
    {
      long l = paramByteBuf1.getUnsignedInt(paramInt2) - paramByteBuf2.getUnsignedIntLE(i);
      if (l != 0L) {
        return l;
      }
      paramInt2 += 4;
      i += 4;
    }
    return 0L;
  }
  
  private static long compareUintBigEndianB(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt3 + paramInt1)
    {
      long l = paramByteBuf1.getUnsignedIntLE(paramInt2) - paramByteBuf2.getUnsignedInt(i);
      if (l != 0L) {
        return l;
      }
      paramInt2 += 4;
      i += 4;
    }
    return 0L;
  }
  
  private static long compareUintLittleEndian(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt3 + paramInt1)
    {
      long l = paramByteBuf1.getUnsignedIntLE(paramInt2) - paramByteBuf2.getUnsignedIntLE(i);
      if (l != 0L) {
        return l;
      }
      paramInt2 += 4;
      i += 4;
    }
    return 0L;
  }
  
  public static void copy(AsciiString paramAsciiString, int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, paramAsciiString.length()))
    {
      ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "dst")).writeBytes(paramAsciiString.array(), paramInt1 + paramAsciiString.arrayOffset(), paramInt2);
      return;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("expected: 0 <= srcIdx(");
    paramByteBuf.append(paramInt1);
    paramByteBuf.append(") <= srcIdx + length(");
    paramByteBuf.append(paramInt2);
    paramByteBuf.append(") <= srcLen(");
    paramByteBuf.append(paramAsciiString.length());
    paramByteBuf.append(')');
    throw new IndexOutOfBoundsException(paramByteBuf.toString());
  }
  
  public static void copy(AsciiString paramAsciiString, int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt3, paramAsciiString.length()))
    {
      ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "dst")).setBytes(paramInt2, paramAsciiString.array(), paramInt1 + paramAsciiString.arrayOffset(), paramInt3);
      return;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("expected: 0 <= srcIdx(");
    paramByteBuf.append(paramInt1);
    paramByteBuf.append(") <= srcIdx + length(");
    paramByteBuf.append(paramInt3);
    paramByteBuf.append(") <= srcLen(");
    paramByteBuf.append(paramAsciiString.length());
    paramByteBuf.append(')');
    throw new IndexOutOfBoundsException(paramByteBuf.toString());
  }
  
  public static void copy(AsciiString paramAsciiString, ByteBuf paramByteBuf)
  {
    copy(paramAsciiString, 0, paramByteBuf, paramAsciiString.length());
  }
  
  public static byte decodeHexByte(CharSequence paramCharSequence, int paramInt)
  {
    return StringUtil.decodeHexByte(paramCharSequence, paramInt);
  }
  
  public static byte[] decodeHexDump(CharSequence paramCharSequence)
  {
    return StringUtil.decodeHexDump(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public static byte[] decodeHexDump(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return StringUtil.decodeHexDump(paramCharSequence, paramInt1, paramInt2);
  }
  
  static String decodeString(ByteBuf paramByteBuf, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (paramInt2 == 0) {
      return "";
    }
    byte[] arrayOfByte;
    if (paramByteBuf.hasArray())
    {
      arrayOfByte = paramByteBuf.array();
      paramInt1 = paramByteBuf.arrayOffset() + paramInt1;
      paramByteBuf = arrayOfByte;
    }
    else
    {
      arrayOfByte = threadLocalTempArray(paramInt2);
      paramByteBuf.getBytes(paramInt1, arrayOfByte, 0, paramInt2);
      paramInt1 = 0;
      paramByteBuf = arrayOfByte;
    }
    if (CharsetUtil.US_ASCII.equals(paramCharset)) {
      return new String(paramByteBuf, 0, paramInt1, paramInt2);
    }
    return new String(paramByteBuf, paramInt1, paramInt2, paramCharset);
  }
  
  public static ByteBuf encodeString(ByteBufAllocator paramByteBufAllocator, CharBuffer paramCharBuffer, Charset paramCharset)
  {
    return encodeString0(paramByteBufAllocator, false, paramCharBuffer, paramCharset, 0);
  }
  
  public static ByteBuf encodeString(ByteBufAllocator paramByteBufAllocator, CharBuffer paramCharBuffer, Charset paramCharset, int paramInt)
  {
    return encodeString0(paramByteBufAllocator, false, paramCharBuffer, paramCharset, paramInt);
  }
  
  /* Error */
  static ByteBuf encodeString0(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, CharBuffer paramCharBuffer, Charset paramCharset, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 66	io/netty/util/CharsetUtil:encoder	(Ljava/nio/charset/Charset;)Ljava/nio/charset/CharsetEncoder;
    //   4: astore_3
    //   5: aload_2
    //   6: invokevirtual 363	java/nio/CharBuffer:remaining	()I
    //   9: i2d
    //   10: aload_3
    //   11: invokevirtual 72	java/nio/charset/CharsetEncoder:maxBytesPerChar	()F
    //   14: f2d
    //   15: dmul
    //   16: d2i
    //   17: iload 4
    //   19: iadd
    //   20: istore 4
    //   22: iload_1
    //   23: ifeq +15 -> 38
    //   26: aload_0
    //   27: iload 4
    //   29: invokeinterface 369 2 0
    //   34: astore_0
    //   35: goto +12 -> 47
    //   38: aload_0
    //   39: iload 4
    //   41: invokeinterface 372 2 0
    //   46: astore_0
    //   47: aload_0
    //   48: aload_0
    //   49: invokevirtual 171	io/netty/buffer/ByteBuf:readerIndex	()I
    //   52: iload 4
    //   54: invokevirtual 376	io/netty/buffer/ByteBuf:internalNioBuffer	(II)Ljava/nio/ByteBuffer;
    //   57: astore 5
    //   59: aload 5
    //   61: invokevirtual 381	java/nio/ByteBuffer:position	()I
    //   64: istore 4
    //   66: aload_3
    //   67: aload_2
    //   68: aload 5
    //   70: iconst_1
    //   71: invokevirtual 385	java/nio/charset/CharsetEncoder:encode	(Ljava/nio/CharBuffer;Ljava/nio/ByteBuffer;Z)Ljava/nio/charset/CoderResult;
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 390	java/nio/charset/CoderResult:isUnderflow	()Z
    //   79: ifne +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 393	java/nio/charset/CoderResult:throwException	()V
    //   86: aload_3
    //   87: aload 5
    //   89: invokevirtual 397	java/nio/charset/CharsetEncoder:flush	(Ljava/nio/ByteBuffer;)Ljava/nio/charset/CoderResult;
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 390	java/nio/charset/CoderResult:isUnderflow	()Z
    //   97: ifne +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 393	java/nio/charset/CoderResult:throwException	()V
    //   104: aload_0
    //   105: aload_0
    //   106: invokevirtual 400	io/netty/buffer/ByteBuf:writerIndex	()I
    //   109: aload 5
    //   111: invokevirtual 381	java/nio/ByteBuffer:position	()I
    //   114: iadd
    //   115: iload 4
    //   117: isub
    //   118: invokevirtual 402	io/netty/buffer/ByteBuf:writerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   121: pop
    //   122: aload_0
    //   123: areturn
    //   124: astore_2
    //   125: goto +15 -> 140
    //   128: astore_2
    //   129: new 404	java/lang/IllegalStateException
    //   132: astore_3
    //   133: aload_3
    //   134: aload_2
    //   135: invokespecial 407	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   138: aload_3
    //   139: athrow
    //   140: aload_0
    //   141: invokeinterface 412 1 0
    //   146: pop
    //   147: aload_2
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramByteBufAllocator	ByteBufAllocator
    //   0	149	1	paramBoolean	boolean
    //   0	149	2	paramCharBuffer	CharBuffer
    //   0	149	3	paramCharset	Charset
    //   0	149	4	paramInt	int
    //   57	53	5	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   47	86	124	finally
    //   86	104	124	finally
    //   104	122	124	finally
    //   129	140	124	finally
    //   47	86	128	java/nio/charset/CharacterCodingException
    //   86	104	128	java/nio/charset/CharacterCodingException
    //   104	122	128	java/nio/charset/CharacterCodingException
  }
  
  public static boolean ensureWritableSuccess(int paramInt)
  {
    boolean bool;
    if ((paramInt != 0) && (paramInt != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean equals(ByteBuf paramByteBuf1, int paramInt1, ByteBuf paramByteBuf2, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= 0))
    {
      if ((paramByteBuf1.writerIndex() - paramInt3 >= paramInt1) && (paramByteBuf2.writerIndex() - paramInt3 >= paramInt2))
      {
        int i = paramInt3 >>> 3;
        int j = paramInt3 & 0x7;
        int k = i;
        paramInt3 = paramInt1;
        int m = paramInt2;
        if (paramByteBuf1.order() == paramByteBuf2.order())
        {
          paramInt3 = paramInt2;
          m = paramInt1;
          for (k = i;; k--)
          {
            paramInt2 = m;
            paramInt1 = paramInt3;
            i = j;
            if (k <= 0) {
              break;
            }
            if (paramByteBuf1.getLong(m) != paramByteBuf2.getLong(paramInt3)) {
              return false;
            }
            m += 8;
            paramInt3 += 8;
          }
        }
        for (;;)
        {
          paramInt2 = paramInt3;
          paramInt1 = m;
          i = j;
          if (k <= 0) {
            break;
          }
          if (paramByteBuf1.getLong(paramInt3) != swapLong(paramByteBuf2.getLong(m))) {
            return false;
          }
          paramInt3 += 8;
          m += 8;
          k--;
        }
        while (i > 0)
        {
          if (paramByteBuf1.getByte(paramInt2) != paramByteBuf2.getByte(paramInt1)) {
            return false;
          }
          paramInt2++;
          paramInt1++;
          i--;
        }
        return true;
      }
      return false;
    }
    throw new IllegalArgumentException("All indexes and lengths must be non-negative");
  }
  
  public static boolean equals(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    int i = paramByteBuf1.readableBytes();
    if (i != paramByteBuf2.readableBytes()) {
      return false;
    }
    return equals(paramByteBuf1, paramByteBuf1.readerIndex(), paramByteBuf2, paramByteBuf2.readerIndex(), i);
  }
  
  private static int firstIndexOf(ByteBuf paramByteBuf, int paramInt1, int paramInt2, byte paramByte)
  {
    paramInt1 = Math.max(paramInt1, 0);
    if ((paramInt1 < paramInt2) && (paramByteBuf.capacity() != 0)) {
      return paramByteBuf.forEachByte(paramInt1, paramInt2 - paramInt1, new ByteProcessor.IndexOfProcessor(paramByte));
    }
    return -1;
  }
  
  private static void getBytes(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream, int paramInt3)
    throws IOException
  {
    int i;
    do
    {
      i = Math.min(paramInt2, paramInt3);
      paramByteBuffer.get(paramArrayOfByte, paramInt1, i);
      paramOutputStream.write(paramArrayOfByte, paramInt1, i);
      i = paramInt3 - i;
      paramInt3 = i;
    } while (i > 0);
  }
  
  public static byte[] getBytes(ByteBuf paramByteBuf)
  {
    return getBytes(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
  }
  
  public static byte[] getBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return getBytes(paramByteBuf, paramInt1, paramInt2, true);
  }
  
  public static byte[] getBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramByteBuf.capacity();
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, i))
    {
      if (paramByteBuf.hasArray())
      {
        if ((!paramBoolean) && (paramInt1 == 0) && (paramInt2 == i)) {
          return paramByteBuf.array();
        }
        paramInt1 = paramByteBuf.arrayOffset() + paramInt1;
        return Arrays.copyOfRange(paramByteBuf.array(), paramInt1, paramInt2 + paramInt1);
      }
      byte[] arrayOfByte = PlatformDependent.allocateUninitializedArray(paramInt2);
      paramByteBuf.getBytes(paramInt1, arrayOfByte);
      return arrayOfByte;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("expected: 0 <= start(");
    paramByteBuf.append(paramInt1);
    paramByteBuf.append(") <= start + length(");
    paramByteBuf.append(paramInt2);
    paramByteBuf.append(") <= buf.capacity(");
    paramByteBuf.append(i);
    paramByteBuf.append(')');
    throw new IndexOutOfBoundsException(paramByteBuf.toString());
  }
  
  public static int hashCode(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    int j = i >>> 2;
    int k = i & 0x3;
    i = paramByteBuf.readerIndex();
    ByteOrder localByteOrder1 = paramByteBuf.order();
    ByteOrder localByteOrder2 = ByteOrder.BIG_ENDIAN;
    int m = 1;
    int i3;
    if (localByteOrder1 == localByteOrder2)
    {
      n = 1;
      i1 = i;
      for (i2 = j;; i2--)
      {
        i3 = k;
        i = i1;
        j = n;
        if (i2 <= 0) {
          break;
        }
        n = n * 31 + paramByteBuf.getInt(i1);
        i1 += 4;
      }
    }
    int i1 = 1;
    int n = i;
    for (int i2 = j;; i2--)
    {
      i3 = k;
      i = n;
      j = i1;
      if (i2 <= 0) {
        break;
      }
      i1 = i1 * 31 + swapInt(paramByteBuf.getInt(n));
      n += 4;
    }
    while (i3 > 0)
    {
      j = j * 31 + paramByteBuf.getByte(i);
      i3--;
      i++;
    }
    if (j == 0) {
      j = m;
    }
    return j;
  }
  
  public static String hexDump(ByteBuf paramByteBuf)
  {
    return hexDump(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
  }
  
  public static String hexDump(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return HexUtil.hexDump(paramByteBuf, paramInt1, paramInt2);
  }
  
  public static String hexDump(byte[] paramArrayOfByte)
  {
    return hexDump(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String hexDump(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return HexUtil.hexDump(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int indexOf(ByteBuf paramByteBuf, int paramInt1, int paramInt2, byte paramByte)
  {
    if (paramInt1 <= paramInt2) {
      return firstIndexOf(paramByteBuf, paramInt1, paramInt2, paramByte);
    }
    return lastIndexOf(paramByteBuf, paramInt1, paramInt2, paramByte);
  }
  
  public static int indexOf(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    int i = paramByteBuf2.readableBytes();
    int j = paramByteBuf1.readableBytes();
    for (int k = 0; k < i - j + 1; k++) {
      if (equals(paramByteBuf1, paramByteBuf1.readerIndex(), paramByteBuf2, paramByteBuf2.readerIndex() + k, paramByteBuf1.readableBytes())) {
        return paramByteBuf2.readerIndex() + k;
      }
    }
    return -1;
  }
  
  private static boolean isAscii(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramByteBuf.forEachByte(paramInt1, paramInt2, FIND_NON_ASCII) == -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isText(ByteBuf paramByteBuf, int paramInt1, int paramInt2, Charset paramCharset)
  {
    ObjectUtil.checkNotNull(paramByteBuf, "buf");
    ObjectUtil.checkNotNull(paramCharset, "charset");
    int i = paramByteBuf.readerIndex();
    int j = paramByteBuf.readableBytes();
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= i + j - paramInt2))
    {
      if (paramCharset.equals(CharsetUtil.UTF_8)) {
        return isUtf8(paramByteBuf, paramInt1, paramInt2);
      }
      if (paramCharset.equals(CharsetUtil.US_ASCII)) {
        return isAscii(paramByteBuf, paramInt1, paramInt2);
      }
      Object localObject = CodingErrorAction.REPORT;
      localObject = CharsetUtil.decoder(paramCharset, (CodingErrorAction)localObject, (CodingErrorAction)localObject);
      try
      {
        if (paramByteBuf.nioBufferCount() == 1) {
          ((CharsetDecoder)localObject).decode(paramByteBuf.nioBuffer(paramInt1, paramInt2));
        } else {
          paramCharset = paramByteBuf.alloc().heapBuffer(paramInt2);
        }
        try
        {
          paramCharset.writeBytes(paramByteBuf, paramInt1, paramInt2);
          ((CharsetDecoder)localObject).decode(paramCharset.internalNioBuffer(paramCharset.readerIndex(), paramInt2));
          return true;
        }
        finally
        {
          paramCharset.release();
        }
        paramByteBuf = new StringBuilder();
      }
      catch (CharacterCodingException paramByteBuf)
      {
        return false;
      }
    }
    paramByteBuf.append("index: ");
    paramByteBuf.append(paramInt1);
    paramByteBuf.append(" length: ");
    paramByteBuf.append(paramInt2);
    throw new IndexOutOfBoundsException(paramByteBuf.toString());
  }
  
  public static boolean isText(ByteBuf paramByteBuf, Charset paramCharset)
  {
    return isText(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes(), paramCharset);
  }
  
  private static boolean isUtf8(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    int i = paramInt2 + paramInt1;
    while (paramInt1 < i)
    {
      paramInt2 = paramInt1 + 1;
      paramInt1 = paramByteBuf.getByte(paramInt1);
      if ((paramInt1 & 0x80) == 0)
      {
        paramInt1 = paramInt2;
      }
      else if ((paramInt1 & 0xE0) == 192)
      {
        if (paramInt2 >= i) {
          return false;
        }
        if ((paramByteBuf.getByte(paramInt2) & 0xC0) != 128) {
          return false;
        }
        if ((paramInt1 & 0xFF) < 194) {
          return false;
        }
        paramInt1 = paramInt2 + 1;
      }
      else
      {
        int j;
        int k;
        if ((paramInt1 & 0xF0) == 224)
        {
          if (paramInt2 > i - 2) {
            return false;
          }
          j = paramInt2 + 1;
          paramInt2 = paramByteBuf.getByte(paramInt2);
          k = paramByteBuf.getByte(j);
          if (((paramInt2 & 0xC0) == 128) && ((k & 0xC0) == 128))
          {
            paramInt1 &= 0xF;
            if ((paramInt1 == 0) && ((paramInt2 & 0xFF) < 160)) {
              return false;
            }
            if ((paramInt1 == 13) && ((paramInt2 & 0xFF) > 159)) {
              return false;
            }
            paramInt1 = j + 1;
          }
          else
          {
            return false;
          }
        }
        else
        {
          if ((paramInt1 & 0xF8) == 240)
          {
            if (paramInt2 > i - 3) {
              return false;
            }
            k = paramInt2 + 1;
            paramInt2 = paramByteBuf.getByte(paramInt2);
            j = k + 1;
            int m = paramByteBuf.getByte(k);
            k = paramByteBuf.getByte(j);
            if (((paramInt2 & 0xC0) == 128) && ((m & 0xC0) == 128) && ((k & 0xC0) == 128))
            {
              paramInt1 &= 0xFF;
              if ((paramInt1 <= 244) && ((paramInt1 != 240) || ((paramInt2 & 0xFF) >= 144)) && ((paramInt1 != 244) || ((paramInt2 & 0xFF) <= 143)))
              {
                paramInt1 = j + 1;
                continue;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }
  
  private static int lastIndexOf(ByteBuf paramByteBuf, int paramInt1, int paramInt2, byte paramByte)
  {
    int i = paramByteBuf.capacity();
    paramInt1 = Math.min(paramInt1, i);
    if ((paramInt1 >= 0) && (i != 0)) {
      return paramByteBuf.forEachByteDesc(paramInt2, paramInt1 - paramInt2, new ByteProcessor.IndexOfProcessor(paramByte));
    }
    return -1;
  }
  
  public static String prettyHexDump(ByteBuf paramByteBuf)
  {
    return prettyHexDump(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
  }
  
  public static String prettyHexDump(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return HexUtil.prettyHexDump(paramByteBuf, paramInt1, paramInt2);
  }
  
  public static ByteBuf readBytes(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf, int paramInt)
  {
    paramByteBufAllocator = paramByteBufAllocator.buffer(paramInt);
    try
    {
      return paramByteBufAllocator;
    }
    finally
    {
      paramByteBufAllocator.release();
    }
  }
  
  static void readBytes(ByteBufAllocator paramByteBufAllocator, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramByteBuffer.hasArray())
    {
      paramOutputStream.write(paramByteBuffer.array(), paramInt1 + paramByteBuffer.arrayOffset(), paramInt2);
    }
    else
    {
      int i = Math.min(paramInt2, 8192);
      paramByteBuffer.clear().position(paramInt1);
      if ((paramInt2 > 1024) && (paramByteBufAllocator.isDirectBufferPooled())) {
        paramByteBufAllocator = paramByteBufAllocator.heapBuffer(i);
      }
      try
      {
        getBytes(paramByteBuffer, paramByteBufAllocator.array(), paramByteBufAllocator.arrayOffset(), i, paramOutputStream, paramInt2);
        paramByteBufAllocator.release();
      }
      finally
      {
        paramByteBufAllocator.release();
      }
    }
  }
  
  public static int reserveAndWriteUtf8(ByteBuf paramByteBuf, CharSequence paramCharSequence, int paramInt)
  {
    return reserveAndWriteUtf8Seq(paramByteBuf, paramCharSequence, 0, paramCharSequence.length(), paramInt);
  }
  
  public static int reserveAndWriteUtf8(ByteBuf paramByteBuf, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    return reserveAndWriteUtf8Seq(paramByteBuf, checkCharSequenceBounds(paramCharSequence, paramInt1, paramInt2), paramInt1, paramInt2, paramInt3);
  }
  
  private static int reserveAndWriteUtf8Seq(ByteBuf paramByteBuf, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      if ((paramByteBuf instanceof WrappedCompositeByteBuf))
      {
        paramByteBuf = paramByteBuf.unwrap();
      }
      else
      {
        if ((paramByteBuf instanceof AbstractByteBuf))
        {
          paramByteBuf = (AbstractByteBuf)paramByteBuf;
          paramByteBuf.ensureWritable0(paramInt3);
          paramInt1 = writeUtf8(paramByteBuf, paramByteBuf.writerIndex, paramCharSequence, paramInt1, paramInt2);
          paramByteBuf.writerIndex += paramInt1;
          return paramInt1;
        }
        if (!(paramByteBuf instanceof WrappedByteBuf)) {
          break;
        }
        paramByteBuf = paramByteBuf.unwrap();
      }
    }
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2).toString().getBytes(CharsetUtil.UTF_8);
    paramByteBuf.writeBytes(paramCharSequence);
    return paramCharSequence.length;
  }
  
  public static ByteBuf setShortBE(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    if (paramByteBuf.order() == ByteOrder.BIG_ENDIAN) {
      paramByteBuf = paramByteBuf.setShort(paramInt1, paramInt2);
    } else {
      paramByteBuf = paramByteBuf.setShortLE(paramInt1, paramInt2);
    }
    return paramByteBuf;
  }
  
  public static int swapInt(int paramInt)
  {
    return Integer.reverseBytes(paramInt);
  }
  
  public static long swapLong(long paramLong)
  {
    return Long.reverseBytes(paramLong);
  }
  
  public static int swapMedium(int paramInt)
  {
    int i = paramInt >>> 16 & 0xFF | paramInt << 16 & 0xFF0000 | 0xFF00 & paramInt;
    paramInt = i;
    if ((0x800000 & i) != 0) {
      paramInt = i | 0xFF000000;
    }
    return paramInt;
  }
  
  public static short swapShort(short paramShort)
  {
    return Short.reverseBytes(paramShort);
  }
  
  public static ByteBuf threadLocalDirectBuffer()
  {
    if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
      return null;
    }
    if (PlatformDependent.hasUnsafe()) {
      return ThreadLocalUnsafeDirectByteBuf.newInstance();
    }
    return ThreadLocalDirectByteBuf.newInstance();
  }
  
  static byte[] threadLocalTempArray(int paramInt)
  {
    byte[] arrayOfByte;
    if (paramInt <= 1024) {
      arrayOfByte = (byte[])BYTE_ARRAYS.get();
    } else {
      arrayOfByte = PlatformDependent.allocateUninitializedArray(paramInt);
    }
    return arrayOfByte;
  }
  
  private static int utf8ByteCount(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      return paramInt2 - paramInt1;
    }
    for (int i = paramInt1; (i < paramInt2) && (paramCharSequence.charAt(i) < ''); i++) {}
    int j = i - paramInt1;
    paramInt1 = j;
    if (i < paramInt2) {
      paramInt1 = j + utf8BytesNonAscii(paramCharSequence, i, paramInt2);
    }
    return paramInt1;
  }
  
  public static int utf8Bytes(CharSequence paramCharSequence)
  {
    return utf8ByteCount(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public static int utf8Bytes(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return utf8ByteCount(checkCharSequenceBounds(paramCharSequence, paramInt1, paramInt2), paramInt1, paramInt2);
  }
  
  private static int utf8BytesNonAscii(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1;
    paramInt1 = i;
    for (;;)
    {
      i = paramInt1;
      if (j >= paramInt2) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      if (c < 'ࠀ') {
        paramInt1 += ('' - c >>> 31) + 1;
      } else if (StringUtil.isSurrogate(c))
      {
        if (!Character.isHighSurrogate(c))
        {
          paramInt1++;
        }
        else
        {
          j++;
          if (j == paramInt2)
          {
            i = paramInt1 + 1;
            break;
          }
          if (!Character.isLowSurrogate(paramCharSequence.charAt(j))) {
            paramInt1 += 2;
          } else {
            paramInt1 += 4;
          }
        }
      }
      else {
        paramInt1 += 3;
      }
      j++;
    }
    return i;
  }
  
  public static int utf8MaxBytes(int paramInt)
  {
    return paramInt * MAX_BYTES_PER_CHAR_UTF8;
  }
  
  public static int utf8MaxBytes(CharSequence paramCharSequence)
  {
    return utf8MaxBytes(paramCharSequence.length());
  }
  
  static int writeAscii(AbstractByteBuf paramAbstractByteBuf, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      paramAbstractByteBuf._setByte(paramInt1, AsciiString.c2b(paramCharSequence.charAt(i)));
      i++;
      paramInt1++;
    }
    return paramInt2;
  }
  
  public static int writeAscii(ByteBuf paramByteBuf, CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    ByteBuf localByteBuf = paramByteBuf;
    if ((paramCharSequence instanceof AsciiString))
    {
      paramCharSequence = (AsciiString)paramCharSequence;
      paramByteBuf.writeBytes(paramCharSequence.array(), paramCharSequence.arrayOffset(), i);
      return i;
    }
    for (;;)
    {
      if ((localByteBuf instanceof WrappedCompositeByteBuf))
      {
        localByteBuf = localByteBuf.unwrap();
      }
      else
      {
        if ((localByteBuf instanceof AbstractByteBuf))
        {
          paramByteBuf = (AbstractByteBuf)localByteBuf;
          paramByteBuf.ensureWritable0(i);
          i = writeAscii(paramByteBuf, paramByteBuf.writerIndex, paramCharSequence, i);
          paramByteBuf.writerIndex += i;
          return i;
        }
        if (!(localByteBuf instanceof WrappedByteBuf)) {
          break;
        }
        localByteBuf = localByteBuf.unwrap();
      }
    }
    paramByteBuf = paramCharSequence.toString().getBytes(CharsetUtil.US_ASCII);
    localByteBuf.writeBytes(paramByteBuf);
    return paramByteBuf.length;
  }
  
  public static ByteBuf writeAscii(ByteBufAllocator paramByteBufAllocator, CharSequence paramCharSequence)
  {
    paramByteBufAllocator = paramByteBufAllocator.buffer(paramCharSequence.length());
    writeAscii(paramByteBufAllocator, paramCharSequence);
    return paramByteBufAllocator;
  }
  
  public static ByteBuf writeMediumBE(ByteBuf paramByteBuf, int paramInt)
  {
    if (paramByteBuf.order() == ByteOrder.BIG_ENDIAN) {
      paramByteBuf = paramByteBuf.writeMedium(paramInt);
    } else {
      paramByteBuf = paramByteBuf.writeMediumLE(paramInt);
    }
    return paramByteBuf;
  }
  
  public static ByteBuf writeShortBE(ByteBuf paramByteBuf, int paramInt)
  {
    if (paramByteBuf.order() == ByteOrder.BIG_ENDIAN) {
      paramByteBuf = paramByteBuf.writeShort(paramInt);
    } else {
      paramByteBuf = paramByteBuf.writeShortLE(paramInt);
    }
    return paramByteBuf;
  }
  
  static int writeUtf8(AbstractByteBuf paramAbstractByteBuf, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    return writeUtf8(paramAbstractByteBuf, paramInt1, paramCharSequence, 0, paramInt2);
  }
  
  static int writeUtf8(AbstractByteBuf paramAbstractByteBuf, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    int j = paramInt2;
    paramInt2 = i;
    for (;;)
    {
      i = paramInt2;
      if (j >= paramInt3) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      if (c < '')
      {
        paramAbstractByteBuf._setByte(paramInt2, (byte)c);
        paramInt2++;
      }
      else if (c < 'ࠀ')
      {
        i = paramInt2 + 1;
        paramAbstractByteBuf._setByte(paramInt2, (byte)(c >> '\006' | 0xC0));
        paramInt2 = i + 1;
        paramAbstractByteBuf._setByte(i, (byte)(c & 0x3F | 0x80));
      }
      else if (StringUtil.isSurrogate(c))
      {
        if (!Character.isHighSurrogate(c))
        {
          paramAbstractByteBuf._setByte(paramInt2, 63);
          paramInt2++;
        }
        else
        {
          j++;
          if (j == paramInt3)
          {
            paramAbstractByteBuf._setByte(paramInt2, 63);
            i = paramInt2 + 1;
            break;
          }
          paramInt2 = writeUtf8Surrogate(paramAbstractByteBuf, paramInt2, c, paramCharSequence.charAt(j));
        }
      }
      else
      {
        i = paramInt2 + 1;
        paramAbstractByteBuf._setByte(paramInt2, (byte)(c >> '\f' | 0xE0));
        paramInt2 = i + 1;
        paramAbstractByteBuf._setByte(i, (byte)(0x3F & c >> '\006' | 0x80));
        paramAbstractByteBuf._setByte(paramInt2, (byte)(c & 0x3F | 0x80));
        paramInt2++;
      }
      j++;
    }
    return i - paramInt1;
  }
  
  public static int writeUtf8(ByteBuf paramByteBuf, CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    return reserveAndWriteUtf8Seq(paramByteBuf, paramCharSequence, 0, i, utf8MaxBytes(i));
  }
  
  public static int writeUtf8(ByteBuf paramByteBuf, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    checkCharSequenceBounds(paramCharSequence, paramInt1, paramInt2);
    return reserveAndWriteUtf8Seq(paramByteBuf, paramCharSequence, paramInt1, paramInt2, utf8MaxBytes(paramInt2 - paramInt1));
  }
  
  public static ByteBuf writeUtf8(ByteBufAllocator paramByteBufAllocator, CharSequence paramCharSequence)
  {
    paramByteBufAllocator = paramByteBufAllocator.buffer(utf8MaxBytes(paramCharSequence));
    writeUtf8(paramByteBufAllocator, paramCharSequence);
    return paramByteBufAllocator;
  }
  
  private static int writeUtf8Surrogate(AbstractByteBuf paramAbstractByteBuf, int paramInt, char paramChar1, char paramChar2)
  {
    if (!Character.isLowSurrogate(paramChar2))
    {
      i = paramInt + 1;
      paramAbstractByteBuf._setByte(paramInt, 63);
      paramInt = paramChar2;
      if (Character.isHighSurrogate(paramChar2)) {
        paramInt = 63;
      }
      paramAbstractByteBuf._setByte(i, paramInt);
      return i + 1;
    }
    int i = Character.toCodePoint(paramChar1, paramChar2);
    int j = paramInt + 1;
    paramAbstractByteBuf._setByte(paramInt, (byte)(i >> 18 | 0xF0));
    paramInt = j + 1;
    paramAbstractByteBuf._setByte(j, (byte)(i >> 12 & 0x3F | 0x80));
    j = paramInt + 1;
    paramAbstractByteBuf._setByte(paramInt, (byte)(i >> 6 & 0x3F | 0x80));
    paramAbstractByteBuf._setByte(j, (byte)(i & 0x3F | 0x80));
    return j + 1;
  }
  
  private static final class HexUtil
  {
    private static final char[] BYTE2CHAR = new char['Ā'];
    private static final String[] BYTE2HEX;
    private static final String[] BYTEPADDING;
    private static final String[] HEXDUMP_ROWPREFIXES;
    private static final char[] HEXDUMP_TABLE = new char['Ѐ'];
    private static final String[] HEXPADDING = new String[16];
    
    static
    {
      HEXDUMP_ROWPREFIXES = new String['က'];
      BYTE2HEX = new String['Ā'];
      BYTEPADDING = new String[16];
      Object localObject1 = "0123456789abcdef".toCharArray();
      int i = 0;
      Object localObject2;
      int k;
      for (int j = 0; j < 256; j++)
      {
        localObject2 = HEXDUMP_TABLE;
        k = j << 1;
        localObject2[k] = ((char)localObject1[(j >>> 4 & 0xF)]);
        localObject2[(k + 1)] = ((char)localObject1[(j & 0xF)]);
      }
      int m;
      for (j = 0;; j++)
      {
        localObject2 = HEXPADDING;
        if (j >= localObject2.length) {
          break;
        }
        m = localObject2.length - j;
        localObject2 = new StringBuilder(m * 3);
        for (k = 0; k < m; k++) {
          ((StringBuilder)localObject2).append("   ");
        }
        HEXPADDING[j] = ((StringBuilder)localObject2).toString();
      }
      for (j = 0;; j++)
      {
        localObject2 = HEXDUMP_ROWPREFIXES;
        if (j >= localObject2.length) {
          break;
        }
        localObject1 = new StringBuilder(12);
        ((StringBuilder)localObject1).append(StringUtil.NEWLINE);
        ((StringBuilder)localObject1).append(Long.toHexString(j << 4 & 0xFFFFFFFF | 0x100000000));
        ((StringBuilder)localObject1).setCharAt(((StringBuilder)localObject1).length() - 9, '|');
        ((StringBuilder)localObject1).append('|');
        localObject2[j] = ((StringBuilder)localObject1).toString();
      }
      for (j = 0;; j++)
      {
        localObject1 = BYTE2HEX;
        if (j >= localObject1.length) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(' ');
        ((StringBuilder)localObject2).append(StringUtil.byteToHexStringPadded(j));
        localObject1[j] = ((StringBuilder)localObject2).toString();
      }
      for (j = 0;; j++)
      {
        localObject2 = BYTEPADDING;
        k = i;
        if (j >= localObject2.length) {
          break;
        }
        m = localObject2.length - j;
        localObject2 = new StringBuilder(m);
        for (k = 0; k < m; k++) {
          ((StringBuilder)localObject2).append(' ');
        }
        BYTEPADDING[j] = ((StringBuilder)localObject2).toString();
      }
      for (;;)
      {
        localObject2 = BYTE2CHAR;
        if (k >= localObject2.length) {
          break;
        }
        if ((k > 31) && (k < 127)) {
          localObject2[k] = ((char)(char)k);
        } else {
          localObject2[k] = ((char)46);
        }
        k++;
      }
    }
    
    private static void appendHexDumpRowPrefix(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
    {
      String[] arrayOfString = HEXDUMP_ROWPREFIXES;
      if (paramInt1 < arrayOfString.length)
      {
        paramStringBuilder.append(arrayOfString[paramInt1]);
      }
      else
      {
        paramStringBuilder.append(StringUtil.NEWLINE);
        paramStringBuilder.append(Long.toHexString(paramInt2 & 0xFFFFFFFF | 0x100000000));
        paramStringBuilder.setCharAt(paramStringBuilder.length() - 9, '|');
        paramStringBuilder.append('|');
      }
    }
    
    private static void appendPrettyHexDump(StringBuilder paramStringBuilder, ByteBuf paramByteBuf, int paramInt1, int paramInt2)
    {
      if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, paramByteBuf.capacity()))
      {
        if (paramInt2 == 0) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("         +-------------------------------------------------+");
        String str = StringUtil.NEWLINE;
        localStringBuilder.append(str);
        localStringBuilder.append("         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |");
        localStringBuilder.append(str);
        localStringBuilder.append("+--------+-------------------------------------------------+----------------+");
        paramStringBuilder.append(localStringBuilder.toString());
        int i = paramInt2 >>> 4;
        int j = paramInt2 & 0xF;
        int k;
        for (paramInt2 = 0; paramInt2 < i; paramInt2++)
        {
          k = (paramInt2 << 4) + paramInt1;
          appendHexDumpRowPrefix(paramStringBuilder, paramInt2, k);
          int m = k + 16;
          for (int n = k; n < m; n++) {
            paramStringBuilder.append(BYTE2HEX[paramByteBuf.getUnsignedByte(n)]);
          }
          paramStringBuilder.append(" |");
          while (k < m)
          {
            paramStringBuilder.append(BYTE2CHAR[paramByteBuf.getUnsignedByte(k)]);
            k++;
          }
          paramStringBuilder.append('|');
        }
        if (j != 0)
        {
          paramInt1 = (i << 4) + paramInt1;
          appendHexDumpRowPrefix(paramStringBuilder, i, paramInt1);
          k = paramInt1 + j;
          for (paramInt2 = paramInt1; paramInt2 < k; paramInt2++) {
            paramStringBuilder.append(BYTE2HEX[paramByteBuf.getUnsignedByte(paramInt2)]);
          }
          paramStringBuilder.append(HEXPADDING[j]);
          paramStringBuilder.append(" |");
          while (paramInt1 < k)
          {
            paramStringBuilder.append(BYTE2CHAR[paramByteBuf.getUnsignedByte(paramInt1)]);
            paramInt1++;
          }
          paramStringBuilder.append(BYTEPADDING[j]);
          paramStringBuilder.append('|');
        }
        paramByteBuf = new StringBuilder();
        paramByteBuf.append(StringUtil.NEWLINE);
        paramByteBuf.append("+--------+-------------------------------------------------+----------------+");
        paramStringBuilder.append(paramByteBuf.toString());
        return;
      }
      paramStringBuilder = new StringBuilder();
      paramStringBuilder.append("expected: 0 <= offset(");
      paramStringBuilder.append(paramInt1);
      paramStringBuilder.append(") <= offset + length(");
      paramStringBuilder.append(paramInt2);
      paramStringBuilder.append(") <= buf.capacity(");
      paramStringBuilder.append(paramByteBuf.capacity());
      paramStringBuilder.append(')');
      throw new IndexOutOfBoundsException(paramStringBuilder.toString());
    }
    
    private static String hexDump(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
    {
      ObjectUtil.checkPositiveOrZero(paramInt2, "length");
      if (paramInt2 == 0) {
        return "";
      }
      char[] arrayOfChar = new char[paramInt2 << 1];
      int i = 0;
      int j = paramInt1;
      while (j < paramInt1 + paramInt2)
      {
        System.arraycopy(HEXDUMP_TABLE, paramByteBuf.getUnsignedByte(j) << 1, arrayOfChar, i, 2);
        j++;
        i += 2;
      }
      return new String(arrayOfChar);
    }
    
    private static String hexDump(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      ObjectUtil.checkPositiveOrZero(paramInt2, "length");
      if (paramInt2 == 0) {
        return "";
      }
      char[] arrayOfChar = new char[paramInt2 << 1];
      int i = 0;
      int j = paramInt1;
      while (j < paramInt1 + paramInt2)
      {
        System.arraycopy(HEXDUMP_TABLE, (paramArrayOfByte[j] & 0xFF) << 1, arrayOfChar, i, 2);
        j++;
        i += 2;
      }
      return new String(arrayOfChar);
    }
    
    private static String prettyHexDump(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0) {
        return "";
      }
      int i = paramInt2 / 16;
      int j;
      if ((paramInt2 & 0xF) == 0) {
        j = 0;
      } else {
        j = 1;
      }
      StringBuilder localStringBuilder = new StringBuilder((i + j + 4) * 80);
      appendPrettyHexDump(localStringBuilder, paramByteBuf, paramInt1, paramInt2);
      return localStringBuilder.toString();
    }
  }
  
  static final class ThreadLocalDirectByteBuf
    extends UnpooledDirectByteBuf
  {
    private static final ObjectPool<ThreadLocalDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
    {
      public ByteBufUtil.ThreadLocalDirectByteBuf newObject(ObjectPool.Handle<ByteBufUtil.ThreadLocalDirectByteBuf> paramAnonymousHandle)
      {
        return new ByteBufUtil.ThreadLocalDirectByteBuf(paramAnonymousHandle, null);
      }
    });
    private final ObjectPool.Handle<ThreadLocalDirectByteBuf> handle;
    
    private ThreadLocalDirectByteBuf(ObjectPool.Handle<ThreadLocalDirectByteBuf> paramHandle)
    {
      super(256, Integer.MAX_VALUE);
      this.handle = paramHandle;
    }
    
    static ThreadLocalDirectByteBuf newInstance()
    {
      ThreadLocalDirectByteBuf localThreadLocalDirectByteBuf = (ThreadLocalDirectByteBuf)RECYCLER.get();
      localThreadLocalDirectByteBuf.resetRefCnt();
      return localThreadLocalDirectByteBuf;
    }
    
    protected void deallocate()
    {
      if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE)
      {
        super.deallocate();
      }
      else
      {
        clear();
        this.handle.recycle(this);
      }
    }
  }
  
  static final class ThreadLocalUnsafeDirectByteBuf
    extends UnpooledUnsafeDirectByteBuf
  {
    private static final ObjectPool<ThreadLocalUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
    {
      public ByteBufUtil.ThreadLocalUnsafeDirectByteBuf newObject(ObjectPool.Handle<ByteBufUtil.ThreadLocalUnsafeDirectByteBuf> paramAnonymousHandle)
      {
        return new ByteBufUtil.ThreadLocalUnsafeDirectByteBuf(paramAnonymousHandle, null);
      }
    });
    private final ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle;
    
    private ThreadLocalUnsafeDirectByteBuf(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> paramHandle)
    {
      super(256, Integer.MAX_VALUE);
      this.handle = paramHandle;
    }
    
    static ThreadLocalUnsafeDirectByteBuf newInstance()
    {
      ThreadLocalUnsafeDirectByteBuf localThreadLocalUnsafeDirectByteBuf = (ThreadLocalUnsafeDirectByteBuf)RECYCLER.get();
      localThreadLocalUnsafeDirectByteBuf.resetRefCnt();
      return localThreadLocalUnsafeDirectByteBuf;
    }
    
    protected void deallocate()
    {
      if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE)
      {
        super.deallocate();
      }
      else
      {
        clear();
        this.handle.recycle(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\ByteBufUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */