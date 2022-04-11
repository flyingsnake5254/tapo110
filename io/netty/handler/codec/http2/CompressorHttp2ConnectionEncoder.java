package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Promise;

public class CompressorHttp2ConnectionEncoder
  extends DecoratingHttp2ConnectionEncoder
{
  public static final int DEFAULT_COMPRESSION_LEVEL = 6;
  public static final int DEFAULT_MEM_LEVEL = 8;
  public static final int DEFAULT_WINDOW_BITS = 15;
  private final int compressionLevel;
  private final int memLevel;
  private final Http2Connection.a propertyKey;
  private final int windowBits;
  
  public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder paramHttp2ConnectionEncoder)
  {
    this(paramHttp2ConnectionEncoder, 6, 15, 8);
  }
  
  public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder paramHttp2ConnectionEncoder, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramHttp2ConnectionEncoder);
    if ((paramInt1 >= 0) && (paramInt1 <= 9))
    {
      if ((paramInt2 >= 9) && (paramInt2 <= 15))
      {
        if ((paramInt3 >= 1) && (paramInt3 <= 9))
        {
          this.compressionLevel = paramInt1;
          this.windowBits = paramInt2;
          this.memLevel = paramInt3;
          this.propertyKey = connection().newKey();
          connection().addListener(new Http2ConnectionAdapter()
          {
            public void onStreamRemoved(Http2Stream paramAnonymousHttp2Stream)
            {
              EmbeddedChannel localEmbeddedChannel = (EmbeddedChannel)paramAnonymousHttp2Stream.getProperty(CompressorHttp2ConnectionEncoder.this.propertyKey);
              if (localEmbeddedChannel != null) {
                CompressorHttp2ConnectionEncoder.this.cleanup(paramAnonymousHttp2Stream, localEmbeddedChannel);
              }
            }
          });
          return;
        }
        paramHttp2ConnectionEncoder = new StringBuilder();
        paramHttp2ConnectionEncoder.append("memLevel: ");
        paramHttp2ConnectionEncoder.append(paramInt3);
        paramHttp2ConnectionEncoder.append(" (expected: 1-9)");
        throw new IllegalArgumentException(paramHttp2ConnectionEncoder.toString());
      }
      paramHttp2ConnectionEncoder = new StringBuilder();
      paramHttp2ConnectionEncoder.append("windowBits: ");
      paramHttp2ConnectionEncoder.append(paramInt2);
      paramHttp2ConnectionEncoder.append(" (expected: 9-15)");
      throw new IllegalArgumentException(paramHttp2ConnectionEncoder.toString());
    }
    paramHttp2ConnectionEncoder = new StringBuilder();
    paramHttp2ConnectionEncoder.append("compressionLevel: ");
    paramHttp2ConnectionEncoder.append(paramInt1);
    paramHttp2ConnectionEncoder.append(" (expected: 0-9)");
    throw new IllegalArgumentException(paramHttp2ConnectionEncoder.toString());
  }
  
  private void bindCompressorToStream(EmbeddedChannel paramEmbeddedChannel, int paramInt)
  {
    if (paramEmbeddedChannel != null)
    {
      Http2Stream localHttp2Stream = connection().stream(paramInt);
      if (localHttp2Stream != null) {
        localHttp2Stream.setProperty(this.propertyKey, paramEmbeddedChannel);
      }
    }
  }
  
  private EmbeddedChannel newCompressionChannel(ChannelHandlerContext paramChannelHandlerContext, ZlibWrapper paramZlibWrapper)
  {
    return new EmbeddedChannel(paramChannelHandlerContext.channel().id(), paramChannelHandlerContext.channel().metadata().hasDisconnect(), paramChannelHandlerContext.channel().config(), new ChannelHandler[] { ZlibCodecFactory.newZlibEncoder(paramZlibWrapper, this.compressionLevel, this.windowBits, this.memLevel) });
  }
  
  private EmbeddedChannel newCompressor(ChannelHandlerContext paramChannelHandlerContext, Http2Headers paramHttp2Headers, boolean paramBoolean)
    throws Http2Exception
  {
    if (paramBoolean) {
      return null;
    }
    AsciiString localAsciiString = HttpHeaderNames.CONTENT_ENCODING;
    CharSequence localCharSequence = (CharSequence)paramHttp2Headers.get(localAsciiString);
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = HttpHeaderValues.IDENTITY;
    }
    paramChannelHandlerContext = newContentCompressor(paramChannelHandlerContext, (CharSequence)localObject);
    if (paramChannelHandlerContext != null)
    {
      localObject = getTargetContentEncoding((CharSequence)localObject);
      if (HttpHeaderValues.IDENTITY.contentEqualsIgnoreCase((CharSequence)localObject)) {
        paramHttp2Headers.remove(localAsciiString);
      } else {
        paramHttp2Headers.set(localAsciiString, localObject);
      }
      paramHttp2Headers.remove(HttpHeaderNames.CONTENT_LENGTH);
    }
    return paramChannelHandlerContext;
  }
  
  private static ByteBuf nextReadableBuf(EmbeddedChannel paramEmbeddedChannel)
  {
    ByteBuf localByteBuf;
    for (;;)
    {
      localByteBuf = (ByteBuf)paramEmbeddedChannel.readOutbound();
      if (localByteBuf == null) {
        return null;
      }
      if (localByteBuf.isReadable()) {
        break;
      }
      localByteBuf.release();
    }
    return localByteBuf;
  }
  
  void cleanup(Http2Stream paramHttp2Stream, EmbeddedChannel paramEmbeddedChannel)
  {
    paramEmbeddedChannel.finishAndReleaseAll();
    paramHttp2Stream.removeProperty(this.propertyKey);
  }
  
  protected CharSequence getTargetContentEncoding(CharSequence paramCharSequence)
    throws Http2Exception
  {
    return paramCharSequence;
  }
  
  protected EmbeddedChannel newContentCompressor(ChannelHandlerContext paramChannelHandlerContext, CharSequence paramCharSequence)
    throws Http2Exception
  {
    if ((!HttpHeaderValues.GZIP.contentEqualsIgnoreCase(paramCharSequence)) && (!HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(paramCharSequence)))
    {
      if ((!HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(paramCharSequence)) && (!HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(paramCharSequence))) {
        return null;
      }
      return newCompressionChannel(paramChannelHandlerContext, ZlibWrapper.ZLIB);
    }
    return newCompressionChannel(paramChannelHandlerContext, ZlibWrapper.GZIP);
  }
  
  /* Error */
  public ChannelFuture writeData(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 36	io/netty/handler/codec/http2/DecoratingHttp2ConnectionEncoder:connection	()Lio/netty/handler/codec/http2/Http2Connection;
    //   4: iload_2
    //   5: invokeinterface 92 2 0
    //   10: astore 7
    //   12: aload 7
    //   14: ifnonnull +9 -> 23
    //   17: aconst_null
    //   18: astore 8
    //   20: goto +19 -> 39
    //   23: aload 7
    //   25: aload_0
    //   26: getfield 44	io/netty/handler/codec/http2/CompressorHttp2ConnectionEncoder:propertyKey	Lio/netty/handler/codec/http2/Http2Connection$a;
    //   29: invokeinterface 240 2 0
    //   34: checkcast 102	io/netty/channel/embedded/EmbeddedChannel
    //   37: astore 8
    //   39: aload 8
    //   41: ifnonnull +17 -> 58
    //   44: aload_0
    //   45: aload_1
    //   46: iload_2
    //   47: aload_3
    //   48: iload 4
    //   50: iload 5
    //   52: aload 6
    //   54: invokespecial 244	io/netty/handler/codec/http2/DecoratingHttp2FrameWriter:writeData	(Lio/netty/channel/ChannelHandlerContext;ILio/netty/buffer/ByteBuf;IZLio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   57: areturn
    //   58: aload 8
    //   60: iconst_1
    //   61: anewarray 246	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_3
    //   67: aastore
    //   68: invokevirtual 250	io/netty/channel/embedded/EmbeddedChannel:writeOutbound	([Ljava/lang/Object;)Z
    //   71: pop
    //   72: aload 8
    //   74: invokestatic 252	io/netty/handler/codec/http2/CompressorHttp2ConnectionEncoder:nextReadableBuf	(Lio/netty/channel/embedded/EmbeddedChannel;)Lio/netty/buffer/ByteBuf;
    //   77: astore_3
    //   78: aload_3
    //   79: ifnonnull +85 -> 164
    //   82: iload 5
    //   84: ifeq +56 -> 140
    //   87: aload 8
    //   89: invokevirtual 255	io/netty/channel/embedded/EmbeddedChannel:finish	()Z
    //   92: ifeq +9 -> 101
    //   95: aload 8
    //   97: invokestatic 252	io/netty/handler/codec/http2/CompressorHttp2ConnectionEncoder:nextReadableBuf	(Lio/netty/channel/embedded/EmbeddedChannel;)Lio/netty/buffer/ByteBuf;
    //   100: astore_3
    //   101: aload_3
    //   102: ifnonnull +10 -> 112
    //   105: getstatic 261	io/netty/buffer/Unpooled:EMPTY_BUFFER	Lio/netty/buffer/ByteBuf;
    //   108: astore_3
    //   109: goto +3 -> 112
    //   112: aload_0
    //   113: aload_1
    //   114: iload_2
    //   115: aload_3
    //   116: iload 4
    //   118: iconst_1
    //   119: aload 6
    //   121: invokespecial 244	io/netty/handler/codec/http2/DecoratingHttp2FrameWriter:writeData	(Lio/netty/channel/ChannelHandlerContext;ILio/netty/buffer/ByteBuf;IZLio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   124: astore_1
    //   125: iload 5
    //   127: ifeq +11 -> 138
    //   130: aload_0
    //   131: aload 7
    //   133: aload 8
    //   135: invokevirtual 263	io/netty/handler/codec/http2/CompressorHttp2ConnectionEncoder:cleanup	(Lio/netty/handler/codec/http2/Http2Stream;Lio/netty/channel/embedded/EmbeddedChannel;)V
    //   138: aload_1
    //   139: areturn
    //   140: aload 6
    //   142: invokeinterface 269 1 0
    //   147: pop
    //   148: iload 5
    //   150: ifeq +11 -> 161
    //   153: aload_0
    //   154: aload 7
    //   156: aload 8
    //   158: invokevirtual 263	io/netty/handler/codec/http2/CompressorHttp2ConnectionEncoder:cleanup	(Lio/netty/handler/codec/http2/Http2Stream;Lio/netty/channel/embedded/EmbeddedChannel;)V
    //   161: aload 6
    //   163: areturn
    //   164: new 271	io/netty/util/concurrent/PromiseCombiner
    //   167: astore 9
    //   169: aload 9
    //   171: aload_1
    //   172: invokeinterface 275 1 0
    //   177: invokespecial 278	io/netty/util/concurrent/PromiseCombiner:<init>	(Lio/netty/util/concurrent/EventExecutor;)V
    //   180: aload_3
    //   181: astore 10
    //   183: aload 8
    //   185: invokestatic 252	io/netty/handler/codec/http2/CompressorHttp2ConnectionEncoder:nextReadableBuf	(Lio/netty/channel/embedded/EmbeddedChannel;)Lio/netty/buffer/ByteBuf;
    //   188: astore 11
    //   190: aload 11
    //   192: ifnonnull +14 -> 206
    //   195: iload 5
    //   197: ifeq +9 -> 206
    //   200: iconst_1
    //   201: istore 12
    //   203: goto +6 -> 209
    //   206: iconst_0
    //   207: istore 12
    //   209: aload 11
    //   211: astore_3
    //   212: iload 12
    //   214: istore 13
    //   216: iload 12
    //   218: ifeq +37 -> 255
    //   221: aload 11
    //   223: astore_3
    //   224: iload 12
    //   226: istore 13
    //   228: aload 8
    //   230: invokevirtual 255	io/netty/channel/embedded/EmbeddedChannel:finish	()Z
    //   233: ifeq +22 -> 255
    //   236: aload 8
    //   238: invokestatic 252	io/netty/handler/codec/http2/CompressorHttp2ConnectionEncoder:nextReadableBuf	(Lio/netty/channel/embedded/EmbeddedChannel;)Lio/netty/buffer/ByteBuf;
    //   241: astore_3
    //   242: aload_3
    //   243: ifnonnull +9 -> 252
    //   246: iconst_1
    //   247: istore 13
    //   249: goto +6 -> 255
    //   252: iconst_0
    //   253: istore 13
    //   255: aload_1
    //   256: invokeinterface 283 1 0
    //   261: astore 11
    //   263: aload 9
    //   265: aload 11
    //   267: invokevirtual 287	io/netty/util/concurrent/PromiseCombiner:add	(Lio/netty/util/concurrent/Promise;)V
    //   270: aload_0
    //   271: aload_1
    //   272: iload_2
    //   273: aload 10
    //   275: iload 4
    //   277: iload 13
    //   279: aload 11
    //   281: invokespecial 244	io/netty/handler/codec/http2/DecoratingHttp2FrameWriter:writeData	(Lio/netty/channel/ChannelHandlerContext;ILio/netty/buffer/ByteBuf;IZLio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   284: pop
    //   285: aload_3
    //   286: ifnonnull +18 -> 304
    //   289: aload 9
    //   291: aload 6
    //   293: invokevirtual 289	io/netty/util/concurrent/PromiseCombiner:finish	(Lio/netty/util/concurrent/Promise;)V
    //   296: iload 5
    //   298: ifeq +38 -> 336
    //   301: goto +27 -> 328
    //   304: iconst_0
    //   305: istore 4
    //   307: aload_3
    //   308: astore 10
    //   310: goto -127 -> 183
    //   313: astore_1
    //   314: aload 6
    //   316: aload_1
    //   317: invokeinterface 295 2 0
    //   322: pop
    //   323: iload 5
    //   325: ifeq +11 -> 336
    //   328: aload_0
    //   329: aload 7
    //   331: aload 8
    //   333: invokevirtual 263	io/netty/handler/codec/http2/CompressorHttp2ConnectionEncoder:cleanup	(Lio/netty/handler/codec/http2/Http2Stream;Lio/netty/channel/embedded/EmbeddedChannel;)V
    //   336: aload 6
    //   338: areturn
    //   339: astore_1
    //   340: iload 5
    //   342: ifeq +11 -> 353
    //   345: aload_0
    //   346: aload 7
    //   348: aload 8
    //   350: invokevirtual 263	io/netty/handler/codec/http2/CompressorHttp2ConnectionEncoder:cleanup	(Lio/netty/handler/codec/http2/Http2Stream;Lio/netty/channel/embedded/EmbeddedChannel;)V
    //   353: aload_1
    //   354: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	CompressorHttp2ConnectionEncoder
    //   0	355	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	355	2	paramInt1	int
    //   0	355	3	paramByteBuf	ByteBuf
    //   0	355	4	paramInt2	int
    //   0	355	5	paramBoolean	boolean
    //   0	355	6	paramChannelPromise	ChannelPromise
    //   10	337	7	localHttp2Stream	Http2Stream
    //   18	331	8	localEmbeddedChannel	EmbeddedChannel
    //   167	123	9	localPromiseCombiner	io.netty.util.concurrent.PromiseCombiner
    //   181	128	10	localByteBuf	ByteBuf
    //   188	92	11	localObject	Object
    //   201	24	12	bool1	boolean
    //   214	64	13	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   58	78	313	finally
    //   87	101	313	finally
    //   105	109	313	finally
    //   112	125	313	finally
    //   140	148	313	finally
    //   164	180	313	finally
    //   183	190	313	finally
    //   228	242	313	finally
    //   255	285	313	finally
    //   289	296	313	finally
    //   314	323	339	finally
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, ChannelPromise paramChannelPromise)
  {
    try
    {
      EmbeddedChannel localEmbeddedChannel = newCompressor(paramChannelHandlerContext, paramHttp2Headers, paramBoolean2);
      paramChannelHandlerContext = super.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2, paramChannelPromise);
      bindCompressorToStream(localEmbeddedChannel, paramInt1);
      return paramChannelHandlerContext;
    }
    finally
    {
      paramChannelPromise.tryFailure(paramChannelHandlerContext);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    try
    {
      EmbeddedChannel localEmbeddedChannel = newCompressor(paramChannelHandlerContext, paramHttp2Headers, paramBoolean);
      paramChannelHandlerContext = super.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramBoolean, paramChannelPromise);
      bindCompressorToStream(localEmbeddedChannel, paramInt1);
      return paramChannelHandlerContext;
    }
    finally
    {
      paramChannelPromise.tryFailure(paramChannelHandlerContext);
    }
    return paramChannelPromise;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\CompressorHttp2ConnectionEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */