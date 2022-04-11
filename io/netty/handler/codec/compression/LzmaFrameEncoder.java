package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import lzma.sdk.lzma.Encoder;

public class LzmaFrameEncoder
  extends MessageToByteEncoder<ByteBuf>
{
  private static final int DEFAULT_LC = 3;
  private static final int DEFAULT_LP = 0;
  private static final int DEFAULT_MATCH_FINDER = 1;
  private static final int DEFAULT_PB = 2;
  private static final int MAX_FAST_BYTES = 273;
  private static final int MEDIUM_DICTIONARY_SIZE = 65536;
  private static final int MEDIUM_FAST_BYTES = 32;
  private static final int MIN_FAST_BYTES = 5;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(LzmaFrameEncoder.class);
  private static boolean warningLogged;
  private final Encoder encoder;
  private final int littleEndianDictionarySize;
  private final byte properties;
  
  public LzmaFrameEncoder()
  {
    this(65536);
  }
  
  public LzmaFrameEncoder(int paramInt)
  {
    this(3, 0, 2, paramInt);
  }
  
  public LzmaFrameEncoder(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, 65536);
  }
  
  public LzmaFrameEncoder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, false, 32);
  }
  
  public LzmaFrameEncoder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= 8))
    {
      if ((paramInt2 >= 0) && (paramInt2 <= 4))
      {
        if ((paramInt3 >= 0) && (paramInt3 <= 4))
        {
          if ((paramInt1 + paramInt2 > 4) && (!warningLogged))
          {
            logger.warn("The latest versions of LZMA libraries (for example, XZ Utils) has an additional requirement: lc + lp <= 4. Data which don't follow this requirement cannot be decompressed with this libraries.");
            warningLogged = true;
          }
          if (paramInt4 >= 0)
          {
            if ((paramInt5 >= 5) && (paramInt5 <= 273))
            {
              localObject = new Encoder();
              this.encoder = ((Encoder)localObject);
              ((Encoder)localObject).setDictionarySize(paramInt4);
              ((Encoder)localObject).setEndMarkerMode(paramBoolean);
              ((Encoder)localObject).setMatchFinder(1);
              ((Encoder)localObject).setNumFastBytes(paramInt5);
              ((Encoder)localObject).setLcLpPb(paramInt1, paramInt2, paramInt3);
              this.properties = ((byte)(byte)((paramInt3 * 5 + paramInt2) * 9 + paramInt1));
              this.littleEndianDictionarySize = Integer.reverseBytes(paramInt4);
              return;
            }
            throw new IllegalArgumentException(String.format("numFastBytes: %d (expected: %d-%d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(5), Integer.valueOf(273) }));
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dictionarySize: ");
          ((StringBuilder)localObject).append(paramInt4);
          ((StringBuilder)localObject).append(" (expected: 0+)");
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pb: ");
        ((StringBuilder)localObject).append(paramInt3);
        ((StringBuilder)localObject).append(" (expected: 0-4)");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lp: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" (expected: 0-4)");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("lc: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" (expected: 0-8)");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static int maxOutputBufferLength(int paramInt)
  {
    double d;
    if (paramInt < 200) {
      d = 1.5D;
    } else if (paramInt < 500) {
      d = 1.2D;
    } else if (paramInt < 1000) {
      d = 1.1D;
    } else if (paramInt < 10000) {
      d = 1.05D;
    } else {
      d = 1.02D;
    }
    return (int)(paramInt * d) + 13;
  }
  
  protected ByteBuf allocateBuffer(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, boolean paramBoolean)
    throws Exception
  {
    int i = maxOutputBufferLength(paramByteBuf.readableBytes());
    return paramChannelHandlerContext.alloc().ioBuffer(i);
  }
  
  /* Error */
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 165	io/netty/buffer/ByteBuf:readableBytes	()I
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: new 187	io/netty/buffer/ByteBufInputStream
    //   12: astore 6
    //   14: aload 6
    //   16: aload_2
    //   17: invokespecial 190	io/netty/buffer/ByteBufInputStream:<init>	(Lio/netty/buffer/ByteBuf;)V
    //   20: new 192	io/netty/buffer/ByteBufOutputStream
    //   23: astore_1
    //   24: aload_1
    //   25: aload_3
    //   26: invokespecial 193	io/netty/buffer/ByteBufOutputStream:<init>	(Lio/netty/buffer/ByteBuf;)V
    //   29: aload_1
    //   30: aload_0
    //   31: getfield 90	io/netty/handler/codec/compression/LzmaFrameEncoder:properties	B
    //   34: invokevirtual 196	io/netty/buffer/ByteBufOutputStream:writeByte	(I)V
    //   37: aload_1
    //   38: aload_0
    //   39: getfield 98	io/netty/handler/codec/compression/LzmaFrameEncoder:littleEndianDictionarySize	I
    //   42: invokevirtual 199	io/netty/buffer/ByteBufOutputStream:writeInt	(I)V
    //   45: aload_1
    //   46: iload 4
    //   48: i2l
    //   49: invokestatic 204	java/lang/Long:reverseBytes	(J)J
    //   52: invokevirtual 208	io/netty/buffer/ByteBufOutputStream:writeLong	(J)V
    //   55: aload_0
    //   56: getfield 70	io/netty/handler/codec/compression/LzmaFrameEncoder:encoder	Llzma/sdk/lzma/Encoder;
    //   59: aload 6
    //   61: aload_1
    //   62: ldc2_w 209
    //   65: ldc2_w 209
    //   68: aconst_null
    //   69: invokevirtual 214	lzma/sdk/lzma/Encoder:code	(Ljava/io/InputStream;Ljava/io/OutputStream;JJLlzma/sdk/ICodeProgress;)V
    //   72: aload 6
    //   74: invokevirtual 219	java/io/InputStream:close	()V
    //   77: aload_1
    //   78: invokevirtual 222	java/io/OutputStream:close	()V
    //   81: return
    //   82: astore_2
    //   83: goto +6 -> 89
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload 6
    //   91: astore_3
    //   92: goto +9 -> 101
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: aload 5
    //   100: astore_3
    //   101: aload_3
    //   102: ifnull +7 -> 109
    //   105: aload_3
    //   106: invokevirtual 219	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 222	java/io/OutputStream:close	()V
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	LzmaFrameEncoder
    //   0	119	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	119	2	paramByteBuf1	ByteBuf
    //   0	119	3	paramByteBuf2	ByteBuf
    //   4	43	4	i	int
    //   7	92	5	localObject	Object
    //   12	78	6	localByteBufInputStream	io.netty.buffer.ByteBufInputStream
    // Exception table:
    //   from	to	target	type
    //   29	72	82	finally
    //   20	29	86	finally
    //   9	20	95	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\LzmaFrameEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */