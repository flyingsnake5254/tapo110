package io.netty.handler.codec.spdy;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.compression.CompressionException;
import io.netty.util.ReferenceCounted;

class SpdyHeaderBlockJZlibEncoder
  extends SpdyHeaderBlockRawEncoder
{
  private boolean finished;
  private final Deflater z;
  
  SpdyHeaderBlockJZlibEncoder(SpdyVersion paramSpdyVersion, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramSpdyVersion);
    Deflater localDeflater = new Deflater();
    this.z = localDeflater;
    if ((paramInt1 >= 0) && (paramInt1 <= 9))
    {
      if ((paramInt2 >= 9) && (paramInt2 <= 15))
      {
        if ((paramInt3 >= 1) && (paramInt3 <= 9))
        {
          paramInt1 = localDeflater.deflateInit(paramInt1, paramInt2, paramInt3, JZlib.W_ZLIB);
          if (paramInt1 == 0)
          {
            paramSpdyVersion = SpdyCodecUtil.SPDY_DICT;
            paramInt1 = localDeflater.deflateSetDictionary(paramSpdyVersion, paramSpdyVersion.length);
            if (paramInt1 == 0) {
              return;
            }
            paramSpdyVersion = new StringBuilder();
            paramSpdyVersion.append("failed to set the SPDY dictionary: ");
            paramSpdyVersion.append(paramInt1);
            throw new CompressionException(paramSpdyVersion.toString());
          }
          paramSpdyVersion = new StringBuilder();
          paramSpdyVersion.append("failed to initialize an SPDY header block deflater: ");
          paramSpdyVersion.append(paramInt1);
          throw new CompressionException(paramSpdyVersion.toString());
        }
        paramSpdyVersion = new StringBuilder();
        paramSpdyVersion.append("memLevel: ");
        paramSpdyVersion.append(paramInt3);
        paramSpdyVersion.append(" (expected: 1-9)");
        throw new IllegalArgumentException(paramSpdyVersion.toString());
      }
      paramSpdyVersion = new StringBuilder();
      paramSpdyVersion.append("windowBits: ");
      paramSpdyVersion.append(paramInt2);
      paramSpdyVersion.append(" (expected: 9-15)");
      throw new IllegalArgumentException(paramSpdyVersion.toString());
    }
    paramSpdyVersion = new StringBuilder();
    paramSpdyVersion.append("compressionLevel: ");
    paramSpdyVersion.append(paramInt1);
    paramSpdyVersion.append(" (expected: 0-9)");
    throw new IllegalArgumentException(paramSpdyVersion.toString());
  }
  
  /* Error */
  private ByteBuf encode(ByteBufAllocator paramByteBufAllocator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   4: getfield 85	com/jcraft/jzlib/Deflater:next_in_index	I
    //   7: istore_2
    //   8: aload_0
    //   9: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   12: getfield 88	com/jcraft/jzlib/Deflater:next_out_index	I
    //   15: istore_3
    //   16: aload_0
    //   17: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   20: getfield 91	com/jcraft/jzlib/Deflater:next_in	[B
    //   23: arraylength
    //   24: i2d
    //   25: ldc2_w 92
    //   28: dmul
    //   29: invokestatic 99	java/lang/Math:ceil	(D)D
    //   32: d2i
    //   33: bipush 12
    //   35: iadd
    //   36: istore 4
    //   38: aload_1
    //   39: iload 4
    //   41: invokeinterface 105 2 0
    //   46: astore 5
    //   48: aload_0
    //   49: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   52: aload 5
    //   54: invokevirtual 111	io/netty/buffer/ByteBuf:array	()[B
    //   57: putfield 114	com/jcraft/jzlib/Deflater:next_out	[B
    //   60: aload_0
    //   61: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   64: aload 5
    //   66: invokevirtual 118	io/netty/buffer/ByteBuf:arrayOffset	()I
    //   69: aload 5
    //   71: invokevirtual 121	io/netty/buffer/ByteBuf:writerIndex	()I
    //   74: iadd
    //   75: putfield 88	com/jcraft/jzlib/Deflater:next_out_index	I
    //   78: aload_0
    //   79: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   82: iload 4
    //   84: putfield 124	com/jcraft/jzlib/Deflater:avail_out	I
    //   87: aload_0
    //   88: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   91: iconst_2
    //   92: invokevirtual 128	com/jcraft/jzlib/Deflater:deflate	(I)I
    //   95: istore 4
    //   97: aload 5
    //   99: aload_0
    //   100: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   103: getfield 85	com/jcraft/jzlib/Deflater:next_in_index	I
    //   106: iload_2
    //   107: isub
    //   108: invokevirtual 131	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   111: pop
    //   112: iload 4
    //   114: ifne +49 -> 163
    //   117: aload_0
    //   118: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   121: getfield 88	com/jcraft/jzlib/Deflater:next_out_index	I
    //   124: iload_3
    //   125: isub
    //   126: istore_3
    //   127: iload_3
    //   128: ifle +16 -> 144
    //   131: aload 5
    //   133: aload 5
    //   135: invokevirtual 121	io/netty/buffer/ByteBuf:writerIndex	()I
    //   138: iload_3
    //   139: iadd
    //   140: invokevirtual 133	io/netty/buffer/ByteBuf:writerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   143: pop
    //   144: aload_0
    //   145: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   148: aconst_null
    //   149: putfield 91	com/jcraft/jzlib/Deflater:next_in	[B
    //   152: aload_0
    //   153: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   156: aconst_null
    //   157: putfield 114	com/jcraft/jzlib/Deflater:next_out	[B
    //   160: aload 5
    //   162: areturn
    //   163: new 54	io/netty/handler/codec/compression/CompressionException
    //   166: astore 6
    //   168: new 42	java/lang/StringBuilder
    //   171: astore_1
    //   172: aload_1
    //   173: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   176: aload_1
    //   177: ldc -121
    //   179: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: iload 4
    //   186: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 6
    //   192: aload_1
    //   193: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokespecial 61	io/netty/handler/codec/compression/CompressionException:<init>	(Ljava/lang/String;)V
    //   199: aload 6
    //   201: athrow
    //   202: astore_1
    //   203: aload 5
    //   205: aload_0
    //   206: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   209: getfield 85	com/jcraft/jzlib/Deflater:next_in_index	I
    //   212: iload_2
    //   213: isub
    //   214: invokevirtual 131	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   217: pop
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: goto +7 -> 228
    //   224: astore_1
    //   225: aconst_null
    //   226: astore 5
    //   228: aload_0
    //   229: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   232: aconst_null
    //   233: putfield 91	com/jcraft/jzlib/Deflater:next_in	[B
    //   236: aload_0
    //   237: getfield 20	io/netty/handler/codec/spdy/SpdyHeaderBlockJZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   240: aconst_null
    //   241: putfield 114	com/jcraft/jzlib/Deflater:next_out	[B
    //   244: aload 5
    //   246: ifnull +11 -> 257
    //   249: aload 5
    //   251: invokeinterface 141 1 0
    //   256: pop
    //   257: aload_1
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	SpdyHeaderBlockJZlibEncoder
    //   0	259	1	paramByteBufAllocator	ByteBufAllocator
    //   7	207	2	i	int
    //   15	125	3	j	int
    //   36	149	4	k	int
    //   46	204	5	localByteBuf	ByteBuf
    //   166	34	6	localCompressionException	CompressionException
    // Exception table:
    //   from	to	target	type
    //   87	97	202	finally
    //   48	87	220	finally
    //   97	112	220	finally
    //   117	127	220	finally
    //   131	144	220	finally
    //   163	202	220	finally
    //   203	220	220	finally
    //   0	48	224	finally
  }
  
  private void setInput(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    byte[] arrayOfByte;
    int j;
    if (paramByteBuf.hasArray())
    {
      arrayOfByte = paramByteBuf.array();
      j = paramByteBuf.arrayOffset() + paramByteBuf.readerIndex();
      paramByteBuf = arrayOfByte;
    }
    else
    {
      arrayOfByte = new byte[i];
      paramByteBuf.getBytes(paramByteBuf.readerIndex(), arrayOfByte);
      j = 0;
      paramByteBuf = arrayOfByte;
    }
    this.z.next_in = paramByteBuf;
    this.z.next_in_index = j;
    this.z.avail_in = i;
  }
  
  public ByteBuf encode(ByteBufAllocator paramByteBufAllocator, SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception
  {
    if (paramSpdyHeadersFrame != null)
    {
      if (this.finished) {
        return Unpooled.EMPTY_BUFFER;
      }
      paramSpdyHeadersFrame = super.encode(paramByteBufAllocator, paramSpdyHeadersFrame);
      try
      {
        if (!paramSpdyHeadersFrame.isReadable())
        {
          paramByteBufAllocator = Unpooled.EMPTY_BUFFER;
          return paramByteBufAllocator;
        }
        setInput(paramSpdyHeadersFrame);
        paramByteBufAllocator = encode(paramByteBufAllocator);
        return paramByteBufAllocator;
      }
      finally
      {
        paramSpdyHeadersFrame.release();
      }
    }
    throw new IllegalArgumentException("frame");
  }
  
  public void end()
  {
    if (this.finished) {
      return;
    }
    this.finished = true;
    this.z.deflateEnd();
    this.z.next_in = null;
    this.z.next_out = null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHeaderBlockJZlibEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */