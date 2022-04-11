package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public class DelegatingDecompressorFrameListener
  extends Http2FrameListenerDecorator
{
  private final Http2Connection connection;
  private boolean flowControllerInitialized;
  private final Http2Connection.a propertyKey;
  private final boolean strict;
  
  public DelegatingDecompressorFrameListener(Http2Connection paramHttp2Connection, Http2FrameListener paramHttp2FrameListener)
  {
    this(paramHttp2Connection, paramHttp2FrameListener, true);
  }
  
  public DelegatingDecompressorFrameListener(Http2Connection paramHttp2Connection, Http2FrameListener paramHttp2FrameListener, boolean paramBoolean)
  {
    super(paramHttp2FrameListener);
    this.connection = paramHttp2Connection;
    this.strict = paramBoolean;
    this.propertyKey = paramHttp2Connection.newKey();
    paramHttp2Connection.addListener(new Http2ConnectionAdapter()
    {
      public void onStreamRemoved(Http2Stream paramAnonymousHttp2Stream)
      {
        paramAnonymousHttp2Stream = DelegatingDecompressorFrameListener.this.decompressor(paramAnonymousHttp2Stream);
        if (paramAnonymousHttp2Stream != null) {
          DelegatingDecompressorFrameListener.cleanup(paramAnonymousHttp2Stream);
        }
      }
    });
  }
  
  private static void cleanup(Http2Decompressor paramHttp2Decompressor)
  {
    paramHttp2Decompressor.decompressor().finishAndReleaseAll();
  }
  
  private void initDecompressor(ChannelHandlerContext paramChannelHandlerContext, int paramInt, Http2Headers paramHttp2Headers, boolean paramBoolean)
    throws Http2Exception
  {
    Http2Stream localHttp2Stream = this.connection.stream(paramInt);
    if (localHttp2Stream == null) {
      return;
    }
    Http2Decompressor localHttp2Decompressor = decompressor(localHttp2Stream);
    Object localObject1 = localHttp2Decompressor;
    if (localHttp2Decompressor == null)
    {
      localObject1 = localHttp2Decompressor;
      if (!paramBoolean)
      {
        AsciiString localAsciiString = HttpHeaderNames.CONTENT_ENCODING;
        localObject1 = (CharSequence)paramHttp2Headers.get(localAsciiString);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = HttpHeaderValues.IDENTITY;
        }
        paramChannelHandlerContext = newContentDecompressor(paramChannelHandlerContext, (CharSequence)localObject2);
        localObject1 = localHttp2Decompressor;
        if (paramChannelHandlerContext != null)
        {
          localObject1 = new Http2Decompressor(paramChannelHandlerContext);
          localHttp2Stream.setProperty(this.propertyKey, localObject1);
          paramChannelHandlerContext = getTargetContentEncoding((CharSequence)localObject2);
          if (HttpHeaderValues.IDENTITY.contentEqualsIgnoreCase(paramChannelHandlerContext)) {
            paramHttp2Headers.remove(localAsciiString);
          } else {
            paramHttp2Headers.set(localAsciiString, paramChannelHandlerContext);
          }
        }
      }
    }
    if (localObject1 != null)
    {
      paramHttp2Headers.remove(HttpHeaderNames.CONTENT_LENGTH);
      if (!this.flowControllerInitialized)
      {
        this.flowControllerInitialized = true;
        this.connection.local().flowController(new ConsumedBytesConverter((Http2LocalFlowController)this.connection.local().flowController()));
      }
    }
  }
  
  private static ByteBuf nextReadableBuf(EmbeddedChannel paramEmbeddedChannel)
  {
    ByteBuf localByteBuf;
    for (;;)
    {
      localByteBuf = (ByteBuf)paramEmbeddedChannel.readInbound();
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
  
  Http2Decompressor decompressor(Http2Stream paramHttp2Stream)
  {
    if (paramHttp2Stream == null) {
      paramHttp2Stream = null;
    } else {
      paramHttp2Stream = (Http2Decompressor)paramHttp2Stream.getProperty(this.propertyKey);
    }
    return paramHttp2Stream;
  }
  
  protected CharSequence getTargetContentEncoding(CharSequence paramCharSequence)
    throws Http2Exception
  {
    return HttpHeaderValues.IDENTITY;
  }
  
  protected EmbeddedChannel newContentDecompressor(ChannelHandlerContext paramChannelHandlerContext, CharSequence paramCharSequence)
    throws Http2Exception
  {
    if ((!HttpHeaderValues.GZIP.contentEqualsIgnoreCase(paramCharSequence)) && (!HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(paramCharSequence)))
    {
      if ((!HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(paramCharSequence)) && (!HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(paramCharSequence))) {
        return null;
      }
      if (this.strict) {
        paramCharSequence = ZlibWrapper.ZLIB;
      } else {
        paramCharSequence = ZlibWrapper.ZLIB_OR_NONE;
      }
      return new EmbeddedChannel(paramChannelHandlerContext.channel().id(), paramChannelHandlerContext.channel().metadata().hasDisconnect(), paramChannelHandlerContext.channel().config(), new ChannelHandler[] { ZlibCodecFactory.newZlibDecoder(paramCharSequence) });
    }
    return new EmbeddedChannel(paramChannelHandlerContext.channel().id(), paramChannelHandlerContext.channel().metadata().hasDisconnect(), paramChannelHandlerContext.channel().config(), new ChannelHandler[] { ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP) });
  }
  
  /* Error */
  public int onDataRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener:connection	Lio/netty/handler/codec/http2/Http2Connection;
    //   4: iload_2
    //   5: invokeinterface 70 2 0
    //   10: astore 6
    //   12: aload_0
    //   13: aload 6
    //   15: invokevirtual 73	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener:decompressor	(Lio/netty/handler/codec/http2/Http2Stream;)Lio/netty/handler/codec/http2/DelegatingDecompressorFrameListener$Http2Decompressor;
    //   18: astore 7
    //   20: aload 7
    //   22: ifnonnull +20 -> 42
    //   25: aload_0
    //   26: getfield 232	io/netty/handler/codec/http2/Http2FrameListenerDecorator:listener	Lio/netty/handler/codec/http2/Http2FrameListener;
    //   29: aload_1
    //   30: iload_2
    //   31: aload_3
    //   32: iload 4
    //   34: iload 5
    //   36: invokeinterface 236 6 0
    //   41: ireturn
    //   42: aload 7
    //   44: invokevirtual 56	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener$Http2Decompressor:decompressor	()Lio/netty/channel/embedded/EmbeddedChannel;
    //   47: astore 8
    //   49: aload_3
    //   50: invokevirtual 240	io/netty/buffer/ByteBuf:readableBytes	()I
    //   53: iload 4
    //   55: iadd
    //   56: istore 9
    //   58: aload 7
    //   60: iload 9
    //   62: invokevirtual 244	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener$Http2Decompressor:incrementCompressedBytes	(I)V
    //   65: aload 8
    //   67: iconst_1
    //   68: anewarray 246	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_3
    //   74: invokevirtual 250	io/netty/buffer/ByteBuf:retain	()Lio/netty/buffer/ByteBuf;
    //   77: aastore
    //   78: invokevirtual 254	io/netty/channel/embedded/EmbeddedChannel:writeInbound	([Ljava/lang/Object;)Z
    //   81: pop
    //   82: aload 8
    //   84: invokestatic 256	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener:nextReadableBuf	(Lio/netty/channel/embedded/EmbeddedChannel;)Lio/netty/buffer/ByteBuf;
    //   87: astore 10
    //   89: aload 10
    //   91: astore_3
    //   92: aload 10
    //   94: ifnonnull +28 -> 122
    //   97: aload 10
    //   99: astore_3
    //   100: iload 5
    //   102: ifeq +20 -> 122
    //   105: aload 10
    //   107: astore_3
    //   108: aload 8
    //   110: invokevirtual 259	io/netty/channel/embedded/EmbeddedChannel:finish	()Z
    //   113: ifeq +9 -> 122
    //   116: aload 8
    //   118: invokestatic 256	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener:nextReadableBuf	(Lio/netty/channel/embedded/EmbeddedChannel;)Lio/netty/buffer/ByteBuf;
    //   121: astore_3
    //   122: aload_3
    //   123: ifnonnull +36 -> 159
    //   126: iload 5
    //   128: ifeq +21 -> 149
    //   131: aload_0
    //   132: getfield 232	io/netty/handler/codec/http2/Http2FrameListenerDecorator:listener	Lio/netty/handler/codec/http2/Http2FrameListener;
    //   135: aload_1
    //   136: iload_2
    //   137: getstatic 265	io/netty/buffer/Unpooled:EMPTY_BUFFER	Lio/netty/buffer/ByteBuf;
    //   140: iload 4
    //   142: iconst_1
    //   143: invokeinterface 236 6 0
    //   148: pop
    //   149: aload 7
    //   151: iload 9
    //   153: invokevirtual 268	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener$Http2Decompressor:incrementDecompressedBytes	(I)V
    //   156: iload 9
    //   158: ireturn
    //   159: aload_0
    //   160: getfield 30	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener:connection	Lio/netty/handler/codec/http2/Http2Connection;
    //   163: invokeinterface 132 1 0
    //   168: invokeinterface 138 1 0
    //   173: checkcast 140	io/netty/handler/codec/http2/Http2LocalFlowController
    //   176: astore 11
    //   178: aload 7
    //   180: iload 4
    //   182: invokevirtual 268	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener$Http2Decompressor:incrementDecompressedBytes	(I)V
    //   185: aload 8
    //   187: invokestatic 256	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener:nextReadableBuf	(Lio/netty/channel/embedded/EmbeddedChannel;)Lio/netty/buffer/ByteBuf;
    //   190: astore 12
    //   192: aload 12
    //   194: ifnonnull +14 -> 208
    //   197: iload 5
    //   199: ifeq +9 -> 208
    //   202: iconst_1
    //   203: istore 13
    //   205: goto +6 -> 211
    //   208: iconst_0
    //   209: istore 13
    //   211: aload 12
    //   213: astore 10
    //   215: iload 13
    //   217: istore 14
    //   219: iload 13
    //   221: ifeq +40 -> 261
    //   224: aload 12
    //   226: astore 10
    //   228: iload 13
    //   230: istore 14
    //   232: aload 8
    //   234: invokevirtual 259	io/netty/channel/embedded/EmbeddedChannel:finish	()Z
    //   237: ifeq +24 -> 261
    //   240: aload 8
    //   242: invokestatic 256	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener:nextReadableBuf	(Lio/netty/channel/embedded/EmbeddedChannel;)Lio/netty/buffer/ByteBuf;
    //   245: astore 10
    //   247: aload 10
    //   249: ifnonnull +9 -> 258
    //   252: iconst_1
    //   253: istore 14
    //   255: goto +6 -> 261
    //   258: iconst_0
    //   259: istore 14
    //   261: aload 7
    //   263: aload_3
    //   264: invokevirtual 240	io/netty/buffer/ByteBuf:readableBytes	()I
    //   267: invokevirtual 268	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener$Http2Decompressor:incrementDecompressedBytes	(I)V
    //   270: aload 11
    //   272: aload 6
    //   274: aload_0
    //   275: getfield 232	io/netty/handler/codec/http2/Http2FrameListenerDecorator:listener	Lio/netty/handler/codec/http2/Http2FrameListener;
    //   278: aload_1
    //   279: iload_2
    //   280: aload_3
    //   281: iload 4
    //   283: iload 14
    //   285: invokeinterface 236 6 0
    //   290: invokeinterface 272 3 0
    //   295: pop
    //   296: aload 10
    //   298: ifnonnull +12 -> 310
    //   301: aload_3
    //   302: invokeinterface 163 1 0
    //   307: pop
    //   308: iconst_0
    //   309: ireturn
    //   310: aload_3
    //   311: invokeinterface 163 1 0
    //   316: pop
    //   317: aload 10
    //   319: astore_3
    //   320: iconst_0
    //   321: istore 4
    //   323: goto -138 -> 185
    //   326: astore_1
    //   327: goto +4 -> 331
    //   330: astore_1
    //   331: aload_3
    //   332: invokeinterface 163 1 0
    //   337: pop
    //   338: aload_1
    //   339: athrow
    //   340: astore_1
    //   341: aload 6
    //   343: invokeinterface 274 1 0
    //   348: getstatic 280	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   351: aload_1
    //   352: ldc_w 282
    //   355: iconst_1
    //   356: anewarray 246	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: aload 6
    //   363: invokeinterface 274 1 0
    //   368: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   371: aastore
    //   372: invokestatic 292	io/netty/handler/codec/http2/Http2Exception:streamError	(ILio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   375: athrow
    //   376: astore_1
    //   377: aload_1
    //   378: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	DelegatingDecompressorFrameListener
    //   0	379	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	379	2	paramInt1	int
    //   0	379	3	paramByteBuf	ByteBuf
    //   0	379	4	paramInt2	int
    //   0	379	5	paramBoolean	boolean
    //   10	352	6	localHttp2Stream	Http2Stream
    //   18	244	7	localHttp2Decompressor	Http2Decompressor
    //   47	194	8	localEmbeddedChannel	EmbeddedChannel
    //   56	101	9	i	int
    //   87	231	10	localObject	Object
    //   176	95	11	localHttp2LocalFlowController	Http2LocalFlowController
    //   190	35	12	localByteBuf	ByteBuf
    //   203	26	13	bool1	boolean
    //   217	67	14	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   185	192	326	finally
    //   232	247	326	finally
    //   261	296	326	finally
    //   310	317	326	finally
    //   159	185	330	finally
    //   65	89	340	finally
    //   108	122	340	finally
    //   131	149	340	finally
    //   149	156	340	finally
    //   301	308	340	finally
    //   331	340	340	finally
    //   65	89	376	io/netty/handler/codec/http2/Http2Exception
    //   108	122	376	io/netty/handler/codec/http2/Http2Exception
    //   131	149	376	io/netty/handler/codec/http2/Http2Exception
    //   149	156	376	io/netty/handler/codec/http2/Http2Exception
    //   301	308	376	io/netty/handler/codec/http2/Http2Exception
    //   331	340	376	io/netty/handler/codec/http2/Http2Exception
  }
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
    throws Http2Exception
  {
    initDecompressor(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramBoolean2);
    this.listener.onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2);
  }
  
  public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean)
    throws Http2Exception
  {
    initDecompressor(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramBoolean);
    this.listener.onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramBoolean);
  }
  
  private final class ConsumedBytesConverter
    implements Http2LocalFlowController
  {
    private final Http2LocalFlowController flowController;
    
    ConsumedBytesConverter(Http2LocalFlowController paramHttp2LocalFlowController)
    {
      this.flowController = ((Http2LocalFlowController)ObjectUtil.checkNotNull(paramHttp2LocalFlowController, "flowController"));
    }
    
    public void channelHandlerContext(ChannelHandlerContext paramChannelHandlerContext)
      throws Http2Exception
    {
      this.flowController.channelHandlerContext(paramChannelHandlerContext);
    }
    
    /* Error */
    public boolean consumeBytes(Http2Stream paramHttp2Stream, int paramInt)
      throws Http2Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener$ConsumedBytesConverter:this$0	Lio/netty/handler/codec/http2/DelegatingDecompressorFrameListener;
      //   4: aload_1
      //   5: invokevirtual 45	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener:decompressor	(Lio/netty/handler/codec/http2/Http2Stream;)Lio/netty/handler/codec/http2/DelegatingDecompressorFrameListener$Http2Decompressor;
      //   8: astore_3
      //   9: iload_2
      //   10: istore 4
      //   12: aload_3
      //   13: ifnull +16 -> 29
      //   16: aload_3
      //   17: aload_1
      //   18: invokeinterface 51 1 0
      //   23: iload_2
      //   24: invokevirtual 56	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener$Http2Decompressor:consumeBytes	(II)I
      //   27: istore 4
      //   29: aload_0
      //   30: getfield 29	io/netty/handler/codec/http2/DelegatingDecompressorFrameListener$ConsumedBytesConverter:flowController	Lio/netty/handler/codec/http2/Http2LocalFlowController;
      //   33: aload_1
      //   34: iload 4
      //   36: invokeinterface 58 3 0
      //   41: istore 5
      //   43: iload 5
      //   45: ireturn
      //   46: astore_3
      //   47: aload_1
      //   48: invokeinterface 51 1 0
      //   53: getstatic 64	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   56: aload_3
      //   57: ldc 66
      //   59: iconst_0
      //   60: anewarray 4	java/lang/Object
      //   63: invokestatic 70	io/netty/handler/codec/http2/Http2Exception:streamError	(ILio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
      //   66: athrow
      //   67: astore_1
      //   68: aload_1
      //   69: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	70	0	this	ConsumedBytesConverter
      //   0	70	1	paramHttp2Stream	Http2Stream
      //   0	70	2	paramInt	int
      //   8	9	3	localHttp2Decompressor	DelegatingDecompressorFrameListener.Http2Decompressor
      //   46	11	3	localThrowable	Throwable
      //   10	25	4	i	int
      //   41	3	5	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   29	43	46	finally
      //   29	43	67	io/netty/handler/codec/http2/Http2Exception
    }
    
    public Http2LocalFlowController frameWriter(Http2FrameWriter paramHttp2FrameWriter)
    {
      return this.flowController.frameWriter(paramHttp2FrameWriter);
    }
    
    public void incrementWindowSize(Http2Stream paramHttp2Stream, int paramInt)
      throws Http2Exception
    {
      this.flowController.incrementWindowSize(paramHttp2Stream, paramInt);
    }
    
    public int initialWindowSize()
    {
      return this.flowController.initialWindowSize();
    }
    
    public int initialWindowSize(Http2Stream paramHttp2Stream)
    {
      return this.flowController.initialWindowSize(paramHttp2Stream);
    }
    
    public void initialWindowSize(int paramInt)
      throws Http2Exception
    {
      this.flowController.initialWindowSize(paramInt);
    }
    
    public void receiveFlowControlledFrame(Http2Stream paramHttp2Stream, ByteBuf paramByteBuf, int paramInt, boolean paramBoolean)
      throws Http2Exception
    {
      this.flowController.receiveFlowControlledFrame(paramHttp2Stream, paramByteBuf, paramInt, paramBoolean);
    }
    
    public int unconsumedBytes(Http2Stream paramHttp2Stream)
    {
      return this.flowController.unconsumedBytes(paramHttp2Stream);
    }
    
    public int windowSize(Http2Stream paramHttp2Stream)
    {
      return this.flowController.windowSize(paramHttp2Stream);
    }
  }
  
  private static final class Http2Decompressor
  {
    private int compressed;
    private int decompressed;
    private final EmbeddedChannel decompressor;
    
    Http2Decompressor(EmbeddedChannel paramEmbeddedChannel)
    {
      this.decompressor = paramEmbeddedChannel;
    }
    
    int consumeBytes(int paramInt1, int paramInt2)
      throws Http2Exception
    {
      ObjectUtil.checkPositiveOrZero(paramInt2, "decompressedBytes");
      int i = this.decompressed;
      if (i - paramInt2 >= 0)
      {
        double d = paramInt2 / i;
        i = this.compressed;
        int j = Math.min(i, (int)Math.ceil(i * d));
        i = this.compressed;
        if (i - j >= 0)
        {
          this.decompressed -= paramInt2;
          this.compressed = (i - j);
          return j;
        }
        throw Http2Exception.streamError(paramInt1, Http2Error.INTERNAL_ERROR, "overflow when converting decompressed bytes to compressed bytes for stream %d.decompressedBytes: %d decompressed: %d compressed: %d consumedCompressed: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.decompressed), Integer.valueOf(this.compressed), Integer.valueOf(j) });
      }
      throw Http2Exception.streamError(paramInt1, Http2Error.INTERNAL_ERROR, "Attempting to return too many bytes for stream %d. decompressed: %d decompressedBytes: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.decompressed), Integer.valueOf(paramInt2) });
    }
    
    EmbeddedChannel decompressor()
    {
      return this.decompressor;
    }
    
    void incrementCompressedBytes(int paramInt)
    {
      this.compressed += paramInt;
    }
    
    void incrementDecompressedBytes(int paramInt)
    {
      this.decompressed += paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DelegatingDecompressorFrameListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */