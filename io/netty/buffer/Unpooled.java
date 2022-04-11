package io.netty.buffer;

import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class Unpooled
{
  private static final ByteBufAllocator ALLOC;
  public static final ByteOrder BIG_ENDIAN;
  public static final ByteBuf EMPTY_BUFFER;
  public static final ByteOrder LITTLE_ENDIAN;
  
  static
  {
    UnpooledByteBufAllocator localUnpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
    ALLOC = localUnpooledByteBufAllocator;
    BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    EMPTY_BUFFER = localUnpooledByteBufAllocator.buffer(0, 0);
  }
  
  public static ByteBuf buffer()
  {
    return ALLOC.heapBuffer();
  }
  
  public static ByteBuf buffer(int paramInt)
  {
    return ALLOC.heapBuffer(paramInt);
  }
  
  public static ByteBuf buffer(int paramInt1, int paramInt2)
  {
    return ALLOC.heapBuffer(paramInt1, paramInt2);
  }
  
  public static CompositeByteBuf compositeBuffer()
  {
    return compositeBuffer(16);
  }
  
  public static CompositeByteBuf compositeBuffer(int paramInt)
  {
    return new CompositeByteBuf(ALLOC, false, paramInt);
  }
  
  public static ByteBuf copiedBuffer(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    if (i > 0)
    {
      ByteBuf localByteBuf = buffer(i);
      localByteBuf.writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
      return localByteBuf;
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copiedBuffer(CharSequence paramCharSequence, int paramInt1, int paramInt2, Charset paramCharset)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "string");
    if (paramInt2 == 0) {
      return EMPTY_BUFFER;
    }
    if ((paramCharSequence instanceof CharBuffer))
    {
      paramCharSequence = (CharBuffer)paramCharSequence;
      if (paramCharSequence.hasArray()) {
        return copiedBuffer(paramCharSequence.array(), paramCharSequence.arrayOffset() + paramCharSequence.position() + paramInt1, paramInt2, paramCharset);
      }
      paramCharSequence = paramCharSequence.slice();
      paramCharSequence.limit(paramInt2);
      paramCharSequence.position(paramInt1);
      return copiedBuffer(paramCharSequence, paramCharset);
    }
    return copiedBuffer(CharBuffer.wrap(paramCharSequence, paramInt1, paramInt2 + paramInt1), paramCharset);
  }
  
  public static ByteBuf copiedBuffer(CharSequence paramCharSequence, Charset paramCharset)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "string");
    if (CharsetUtil.UTF_8.equals(paramCharset)) {
      return copiedBufferUtf8(paramCharSequence);
    }
    if (CharsetUtil.US_ASCII.equals(paramCharset)) {
      return copiedBufferAscii(paramCharSequence);
    }
    if ((paramCharSequence instanceof CharBuffer)) {
      return copiedBuffer((CharBuffer)paramCharSequence, paramCharset);
    }
    return copiedBuffer(CharBuffer.wrap(paramCharSequence), paramCharset);
  }
  
  public static ByteBuf copiedBuffer(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    if (i == 0) {
      return EMPTY_BUFFER;
    }
    byte[] arrayOfByte = PlatformDependent.allocateUninitializedArray(i);
    paramByteBuffer = paramByteBuffer.duplicate();
    paramByteBuffer.get(arrayOfByte);
    return wrappedBuffer(arrayOfByte).order(paramByteBuffer.order());
  }
  
  private static ByteBuf copiedBuffer(CharBuffer paramCharBuffer, Charset paramCharset)
  {
    return ByteBufUtil.encodeString0(ALLOC, true, paramCharBuffer, paramCharset, 0);
  }
  
  public static ByteBuf copiedBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0) {
      return EMPTY_BUFFER;
    }
    return wrappedBuffer((byte[])paramArrayOfByte.clone());
  }
  
  public static ByteBuf copiedBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return EMPTY_BUFFER;
    }
    byte[] arrayOfByte = PlatformDependent.allocateUninitializedArray(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return wrappedBuffer(arrayOfByte);
  }
  
  public static ByteBuf copiedBuffer(char[] paramArrayOfChar, int paramInt1, int paramInt2, Charset paramCharset)
  {
    ObjectUtil.checkNotNull(paramArrayOfChar, "array");
    if (paramInt2 == 0) {
      return EMPTY_BUFFER;
    }
    return copiedBuffer(CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2), paramCharset);
  }
  
  public static ByteBuf copiedBuffer(char[] paramArrayOfChar, Charset paramCharset)
  {
    ObjectUtil.checkNotNull(paramArrayOfChar, "array");
    return copiedBuffer(paramArrayOfChar, 0, paramArrayOfChar.length, paramCharset);
  }
  
  public static ByteBuf copiedBuffer(ByteBuf... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      int j = 0;
      if (i != 1)
      {
        ByteOrder localByteOrder = null;
        int k = paramVarArgs.length;
        i = 0;
        int m = 0;
        while (i < k)
        {
          localObject = paramVarArgs[i];
          int n = ((ByteBuf)localObject).readableBytes();
          if (n > 0)
          {
            if (Integer.MAX_VALUE - m < n) {
              break label109;
            }
            m += n;
            if (localByteOrder != null)
            {
              if (!localByteOrder.equals(((ByteBuf)localObject).order())) {
                throw new IllegalArgumentException("inconsistent byte order");
              }
            }
            else {
              localByteOrder = ((ByteBuf)localObject).order();
            }
          }
          i++;
          continue;
          label109:
          throw new IllegalArgumentException("The total length of the specified buffers is too big.");
        }
        if (m == 0) {
          return EMPTY_BUFFER;
        }
        Object localObject = PlatformDependent.allocateUninitializedArray(m);
        i = 0;
        for (m = j; m < paramVarArgs.length; m++)
        {
          ByteBuf localByteBuf = paramVarArgs[m];
          j = localByteBuf.readableBytes();
          localByteBuf.getBytes(localByteBuf.readerIndex(), (byte[])localObject, i, j);
          i += j;
        }
        return wrappedBuffer((byte[])localObject).order(localByteOrder);
      }
      return copiedBuffer(paramVarArgs[0]);
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copiedBuffer(ByteBuffer... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      int j = 0;
      if (i != 1)
      {
        ByteOrder localByteOrder = null;
        int k = paramVarArgs.length;
        i = 0;
        int m = 0;
        ByteBuffer localByteBuffer;
        while (i < k)
        {
          localByteBuffer = paramVarArgs[i];
          int n = localByteBuffer.remaining();
          if (n > 0)
          {
            if (Integer.MAX_VALUE - m < n) {
              break label109;
            }
            m += n;
            if (localByteOrder != null)
            {
              if (!localByteOrder.equals(localByteBuffer.order())) {
                throw new IllegalArgumentException("inconsistent byte order");
              }
            }
            else {
              localByteOrder = localByteBuffer.order();
            }
          }
          i++;
          continue;
          label109:
          throw new IllegalArgumentException("The total length of the specified buffers is too big.");
        }
        if (m == 0) {
          return EMPTY_BUFFER;
        }
        byte[] arrayOfByte = PlatformDependent.allocateUninitializedArray(m);
        i = 0;
        for (m = j; m < paramVarArgs.length; m++)
        {
          localByteBuffer = paramVarArgs[m].duplicate();
          j = localByteBuffer.remaining();
          localByteBuffer.get(arrayOfByte, i, j);
          i += j;
        }
        return wrappedBuffer(arrayOfByte).order(localByteOrder);
      }
      return copiedBuffer(paramVarArgs[0]);
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copiedBuffer(byte[]... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      if (i != 1)
      {
        int j = paramVarArgs.length;
        i = 0;
        int k = 0;
        while (i < j)
        {
          arrayOfByte1 = paramVarArgs[i];
          if (Integer.MAX_VALUE - k >= arrayOfByte1.length)
          {
            k += arrayOfByte1.length;
            i++;
          }
          else
          {
            throw new IllegalArgumentException("The total length of the specified arrays is too big.");
          }
        }
        if (k == 0) {
          return EMPTY_BUFFER;
        }
        byte[] arrayOfByte1 = PlatformDependent.allocateUninitializedArray(k);
        k = 0;
        i = 0;
        while (k < paramVarArgs.length)
        {
          byte[] arrayOfByte2 = paramVarArgs[k];
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
          i += arrayOfByte2.length;
          k++;
        }
        return wrappedBuffer(arrayOfByte1);
      }
      if (paramVarArgs[0].length == 0) {
        return EMPTY_BUFFER;
      }
      return copiedBuffer(paramVarArgs[0]);
    }
    return EMPTY_BUFFER;
  }
  
  private static ByteBuf copiedBufferAscii(CharSequence paramCharSequence)
  {
    ByteBuf localByteBuf = ALLOC.heapBuffer(paramCharSequence.length());
    try
    {
      return localByteBuf;
    }
    finally
    {
      localByteBuf.release();
    }
  }
  
  private static ByteBuf copiedBufferUtf8(CharSequence paramCharSequence)
  {
    ByteBuf localByteBuf = ALLOC.heapBuffer(ByteBufUtil.utf8Bytes(paramCharSequence));
    try
    {
      return localByteBuf;
    }
    finally
    {
      localByteBuf.release();
    }
  }
  
  public static ByteBuf copyBoolean(boolean paramBoolean)
  {
    ByteBuf localByteBuf = buffer(1);
    localByteBuf.writeBoolean(paramBoolean);
    return localByteBuf;
  }
  
  public static ByteBuf copyBoolean(boolean... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      ByteBuf localByteBuf = buffer(paramVarArgs.length);
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        localByteBuf.writeBoolean(paramVarArgs[j]);
      }
      return localByteBuf;
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copyDouble(double paramDouble)
  {
    ByteBuf localByteBuf = buffer(8);
    localByteBuf.writeDouble(paramDouble);
    return localByteBuf;
  }
  
  public static ByteBuf copyDouble(double... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      ByteBuf localByteBuf = buffer(paramVarArgs.length * 8);
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        localByteBuf.writeDouble(paramVarArgs[j]);
      }
      return localByteBuf;
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copyFloat(float paramFloat)
  {
    ByteBuf localByteBuf = buffer(4);
    localByteBuf.writeFloat(paramFloat);
    return localByteBuf;
  }
  
  public static ByteBuf copyFloat(float... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      ByteBuf localByteBuf = buffer(paramVarArgs.length * 4);
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        localByteBuf.writeFloat(paramVarArgs[j]);
      }
      return localByteBuf;
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copyInt(int paramInt)
  {
    ByteBuf localByteBuf = buffer(4);
    localByteBuf.writeInt(paramInt);
    return localByteBuf;
  }
  
  public static ByteBuf copyInt(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      ByteBuf localByteBuf = buffer(paramVarArgs.length * 4);
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        localByteBuf.writeInt(paramVarArgs[j]);
      }
      return localByteBuf;
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copyLong(long paramLong)
  {
    ByteBuf localByteBuf = buffer(8);
    localByteBuf.writeLong(paramLong);
    return localByteBuf;
  }
  
  public static ByteBuf copyLong(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      ByteBuf localByteBuf = buffer(paramVarArgs.length * 8);
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        localByteBuf.writeLong(paramVarArgs[j]);
      }
      return localByteBuf;
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copyMedium(int paramInt)
  {
    ByteBuf localByteBuf = buffer(3);
    localByteBuf.writeMedium(paramInt);
    return localByteBuf;
  }
  
  public static ByteBuf copyMedium(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      ByteBuf localByteBuf = buffer(paramVarArgs.length * 3);
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        localByteBuf.writeMedium(paramVarArgs[j]);
      }
      return localByteBuf;
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copyShort(int paramInt)
  {
    ByteBuf localByteBuf = buffer(2);
    localByteBuf.writeShort(paramInt);
    return localByteBuf;
  }
  
  public static ByteBuf copyShort(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      ByteBuf localByteBuf = buffer(paramVarArgs.length * 2);
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        localByteBuf.writeShort(paramVarArgs[j]);
      }
      return localByteBuf;
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf copyShort(short... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      ByteBuf localByteBuf = buffer(paramVarArgs.length * 2);
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        localByteBuf.writeShort(paramVarArgs[j]);
      }
      return localByteBuf;
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf directBuffer()
  {
    return ALLOC.directBuffer();
  }
  
  public static ByteBuf directBuffer(int paramInt)
  {
    return ALLOC.directBuffer(paramInt);
  }
  
  public static ByteBuf directBuffer(int paramInt1, int paramInt2)
  {
    return ALLOC.directBuffer(paramInt1, paramInt2);
  }
  
  @Deprecated
  public static ByteBuf unmodifiableBuffer(ByteBuf paramByteBuf)
  {
    ByteOrder localByteOrder1 = paramByteBuf.order();
    ByteOrder localByteOrder2 = BIG_ENDIAN;
    if (localByteOrder1 == localByteOrder2) {
      return new ReadOnlyByteBuf(paramByteBuf);
    }
    return new ReadOnlyByteBuf(paramByteBuf.order(localByteOrder2)).order(LITTLE_ENDIAN);
  }
  
  @Deprecated
  public static ByteBuf unmodifiableBuffer(ByteBuf... paramVarArgs)
  {
    return wrappedUnmodifiableBuffer(true, paramVarArgs);
  }
  
  public static ByteBuf unreleasableBuffer(ByteBuf paramByteBuf)
  {
    return new UnreleasableByteBuf(paramByteBuf);
  }
  
  static <T> ByteBuf wrappedBuffer(int paramInt, CompositeByteBuf.ByteWrapper<T> paramByteWrapper, T[] paramArrayOfT)
  {
    int i = paramArrayOfT.length;
    if (i != 0)
    {
      if (i != 1)
      {
        int j = paramArrayOfT.length;
        for (i = 0; i < j; i++)
        {
          T ? = paramArrayOfT[i];
          if (? == null) {
            return EMPTY_BUFFER;
          }
          if (!paramByteWrapper.isEmpty(?)) {
            return new CompositeByteBuf(ALLOC, false, paramInt, paramByteWrapper, paramArrayOfT, i);
          }
        }
      }
      if (!paramByteWrapper.isEmpty(paramArrayOfT[0])) {
        return paramByteWrapper.wrap(paramArrayOfT[0]);
      }
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf wrappedBuffer(int paramInt, ByteBuf... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      if (i != 1) {
        for (i = 0; i < paramVarArgs.length; i++)
        {
          ByteBuf localByteBuf = paramVarArgs[i];
          if (localByteBuf.isReadable()) {
            return new CompositeByteBuf(ALLOC, false, paramInt, paramVarArgs, i);
          }
          localByteBuf.release();
        }
      }
      paramVarArgs = paramVarArgs[0];
      if (paramVarArgs.isReadable()) {
        return wrappedBuffer(paramVarArgs.order(BIG_ENDIAN));
      }
      paramVarArgs.release();
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf wrappedBuffer(int paramInt, ByteBuffer... paramVarArgs)
  {
    return wrappedBuffer(paramInt, CompositeByteBuf.BYTE_BUFFER_WRAPPER, paramVarArgs);
  }
  
  public static ByteBuf wrappedBuffer(int paramInt, byte[]... paramVarArgs)
  {
    return wrappedBuffer(paramInt, CompositeByteBuf.BYTE_ARRAY_WRAPPER, paramVarArgs);
  }
  
  public static ByteBuf wrappedBuffer(long paramLong, int paramInt, boolean paramBoolean)
  {
    return new WrappedUnpooledUnsafeDirectByteBuf(ALLOC, paramLong, paramInt, paramBoolean);
  }
  
  public static ByteBuf wrappedBuffer(ByteBuf paramByteBuf)
  {
    if (paramByteBuf.isReadable()) {
      return paramByteBuf.slice();
    }
    paramByteBuf.release();
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf wrappedBuffer(ByteBuffer paramByteBuffer)
  {
    if (!paramByteBuffer.hasRemaining()) {
      return EMPTY_BUFFER;
    }
    if ((!paramByteBuffer.isDirect()) && (paramByteBuffer.hasArray())) {
      return wrappedBuffer(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()).order(paramByteBuffer.order());
    }
    if (PlatformDependent.hasUnsafe())
    {
      if (paramByteBuffer.isReadOnly())
      {
        if (paramByteBuffer.isDirect()) {
          return new ReadOnlyUnsafeDirectByteBuf(ALLOC, paramByteBuffer);
        }
        return new ReadOnlyByteBufferBuf(ALLOC, paramByteBuffer);
      }
      return new UnpooledUnsafeDirectByteBuf(ALLOC, paramByteBuffer, paramByteBuffer.remaining());
    }
    if (paramByteBuffer.isReadOnly()) {
      return new ReadOnlyByteBufferBuf(ALLOC, paramByteBuffer);
    }
    return new UnpooledDirectByteBuf(ALLOC, paramByteBuffer, paramByteBuffer.remaining());
  }
  
  public static ByteBuf wrappedBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0) {
      return EMPTY_BUFFER;
    }
    return new UnpooledHeapByteBuf(ALLOC, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static ByteBuf wrappedBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return EMPTY_BUFFER;
    }
    if ((paramInt1 == 0) && (paramInt2 == paramArrayOfByte.length)) {
      return wrappedBuffer(paramArrayOfByte);
    }
    return wrappedBuffer(paramArrayOfByte).slice(paramInt1, paramInt2);
  }
  
  public static ByteBuf wrappedBuffer(ByteBuf... paramVarArgs)
  {
    return wrappedBuffer(paramVarArgs.length, paramVarArgs);
  }
  
  public static ByteBuf wrappedBuffer(ByteBuffer... paramVarArgs)
  {
    return wrappedBuffer(paramVarArgs.length, paramVarArgs);
  }
  
  public static ByteBuf wrappedBuffer(byte[]... paramVarArgs)
  {
    return wrappedBuffer(paramVarArgs.length, paramVarArgs);
  }
  
  private static ByteBuf wrappedUnmodifiableBuffer(boolean paramBoolean, ByteBuf... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      if (i != 1)
      {
        ByteBuf[] arrayOfByteBuf = paramVarArgs;
        if (paramBoolean) {
          arrayOfByteBuf = (ByteBuf[])Arrays.copyOf(paramVarArgs, paramVarArgs.length, ByteBuf[].class);
        }
        return new FixedCompositeByteBuf(ALLOC, arrayOfByteBuf);
      }
      return paramVarArgs[0].asReadOnly();
    }
    return EMPTY_BUFFER;
  }
  
  public static ByteBuf wrappedUnmodifiableBuffer(ByteBuf... paramVarArgs)
  {
    return wrappedUnmodifiableBuffer(false, paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\Unpooled.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */