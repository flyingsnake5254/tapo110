package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaders;

public class HttpToHttp2ConnectionHandler
  extends Http2ConnectionHandler
{
  private int currentStreamId;
  private final boolean validateHeaders;
  
  protected HttpToHttp2ConnectionHandler(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2Settings paramHttp2Settings, boolean paramBoolean)
  {
    super(paramHttp2ConnectionDecoder, paramHttp2ConnectionEncoder, paramHttp2Settings);
    this.validateHeaders = paramBoolean;
  }
  
  protected HttpToHttp2ConnectionHandler(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2Settings paramHttp2Settings, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramHttp2ConnectionDecoder, paramHttp2ConnectionEncoder, paramHttp2Settings, paramBoolean2);
    this.validateHeaders = paramBoolean1;
  }
  
  private int getStreamId(HttpHeaders paramHttpHeaders)
    throws Exception
  {
    return paramHttpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), connection().local().incrementAndGetNextStreamId());
  }
  
  private static void writeHeaders(ChannelHandlerContext paramChannelHandlerContext, Http2ConnectionEncoder paramHttp2ConnectionEncoder, int paramInt, HttpHeaders paramHttpHeaders, Http2Headers paramHttp2Headers, boolean paramBoolean, Http2CodecUtil.SimpleChannelPromiseAggregator paramSimpleChannelPromiseAggregator)
  {
    paramHttp2ConnectionEncoder.writeHeaders(paramChannelHandlerContext, paramInt, paramHttp2Headers, paramHttpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), 0), paramHttpHeaders.getShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), (short)16), false, 0, paramBoolean, paramSimpleChannelPromiseAggregator.newPromise());
  }
  
  /* Error */
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, io.netty.channel.ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 83
    //   4: ifne +20 -> 24
    //   7: aload_2
    //   8: instanceof 85
    //   11: ifne +13 -> 24
    //   14: aload_1
    //   15: aload_2
    //   16: aload_3
    //   17: invokeinterface 90 3 0
    //   22: pop
    //   23: return
    //   24: new 70	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator
    //   27: dup
    //   28: aload_3
    //   29: aload_1
    //   30: invokeinterface 96 1 0
    //   35: aload_1
    //   36: invokeinterface 100 1 0
    //   41: invokespecial 103	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:<init>	(Lio/netty/channel/ChannelPromise;Lio/netty/channel/Channel;Lio/netty/util/concurrent/EventExecutor;)V
    //   44: astore 4
    //   46: iconst_0
    //   47: istore 5
    //   49: aload_0
    //   50: invokevirtual 107	io/netty/handler/codec/http2/Http2ConnectionHandler:encoder	()Lio/netty/handler/codec/http2/Http2ConnectionEncoder;
    //   53: astore 6
    //   55: aload_2
    //   56: instanceof 83
    //   59: ifeq +88 -> 147
    //   62: aload_2
    //   63: checkcast 83	io/netty/handler/codec/http/HttpMessage
    //   66: astore_3
    //   67: aload_0
    //   68: aload_0
    //   69: aload_3
    //   70: invokeinterface 111 1 0
    //   75: invokespecial 113	io/netty/handler/codec/http2/HttpToHttp2ConnectionHandler:getStreamId	(Lio/netty/handler/codec/http/HttpHeaders;)I
    //   78: putfield 115	io/netty/handler/codec/http2/HttpToHttp2ConnectionHandler:currentStreamId	I
    //   81: aload_3
    //   82: aload_0
    //   83: getfield 15	io/netty/handler/codec/http2/HttpToHttp2ConnectionHandler:validateHeaders	Z
    //   86: invokestatic 121	io/netty/handler/codec/http2/HttpConversionUtil:toHttp2Headers	(Lio/netty/handler/codec/http/HttpMessage;Z)Lio/netty/handler/codec/http2/Http2Headers;
    //   89: astore 7
    //   91: aload_2
    //   92: instanceof 123
    //   95: ifeq +24 -> 119
    //   98: aload_2
    //   99: checkcast 123	io/netty/handler/codec/http/FullHttpMessage
    //   102: invokeinterface 129 1 0
    //   107: invokevirtual 135	io/netty/buffer/ByteBuf:isReadable	()Z
    //   110: ifne +9 -> 119
    //   113: iconst_1
    //   114: istore 8
    //   116: goto +6 -> 122
    //   119: iconst_0
    //   120: istore 8
    //   122: aload_1
    //   123: aload 6
    //   125: aload_0
    //   126: getfield 115	io/netty/handler/codec/http2/HttpToHttp2ConnectionHandler:currentStreamId	I
    //   129: aload_3
    //   130: invokeinterface 111 1 0
    //   135: aload 7
    //   137: iload 8
    //   139: aload 4
    //   141: invokestatic 137	io/netty/handler/codec/http2/HttpToHttp2ConnectionHandler:writeHeaders	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/http2/Http2ConnectionEncoder;ILio/netty/handler/codec/http/HttpHeaders;Lio/netty/handler/codec/http2/Http2Headers;ZLio/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator;)V
    //   144: goto +6 -> 150
    //   147: iconst_0
    //   148: istore 8
    //   150: iload 8
    //   152: ifne +151 -> 303
    //   155: aload_2
    //   156: instanceof 85
    //   159: ifeq +144 -> 303
    //   162: getstatic 143	io/netty/handler/codec/http/EmptyHttpHeaders:INSTANCE	Lio/netty/handler/codec/http/EmptyHttpHeaders;
    //   165: astore_3
    //   166: getstatic 148	io/netty/handler/codec/http2/EmptyHttp2Headers:INSTANCE	Lio/netty/handler/codec/http2/EmptyHttp2Headers;
    //   169: astore 7
    //   171: aload_2
    //   172: instanceof 150
    //   175: ifeq +29 -> 204
    //   178: aload_2
    //   179: checkcast 150	io/netty/handler/codec/http/LastHttpContent
    //   182: invokeinterface 153 1 0
    //   187: astore_3
    //   188: aload_3
    //   189: aload_0
    //   190: getfield 15	io/netty/handler/codec/http2/HttpToHttp2ConnectionHandler:validateHeaders	Z
    //   193: invokestatic 156	io/netty/handler/codec/http2/HttpConversionUtil:toHttp2Headers	(Lio/netty/handler/codec/http/HttpHeaders;Z)Lio/netty/handler/codec/http2/Http2Headers;
    //   196: astore 7
    //   198: iconst_1
    //   199: istore 9
    //   201: goto +6 -> 207
    //   204: iconst_0
    //   205: istore 9
    //   207: aload_2
    //   208: checkcast 85	io/netty/handler/codec/http/HttpContent
    //   211: invokeinterface 129 1 0
    //   216: astore 10
    //   218: iload 9
    //   220: ifeq +16 -> 236
    //   223: aload_3
    //   224: invokevirtual 159	io/netty/handler/codec/http/HttpHeaders:isEmpty	()Z
    //   227: ifeq +9 -> 236
    //   230: iconst_1
    //   231: istore 8
    //   233: goto +6 -> 239
    //   236: iconst_0
    //   237: istore 8
    //   239: aload 6
    //   241: aload_1
    //   242: aload_0
    //   243: getfield 115	io/netty/handler/codec/http2/HttpToHttp2ConnectionHandler:currentStreamId	I
    //   246: aload 10
    //   248: iconst_0
    //   249: iload 8
    //   251: aload 4
    //   253: invokevirtual 74	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   256: invokeinterface 165 7 0
    //   261: pop
    //   262: iload 5
    //   264: istore 9
    //   266: aload_3
    //   267: invokevirtual 159	io/netty/handler/codec/http/HttpHeaders:isEmpty	()Z
    //   270: ifne +36 -> 306
    //   273: aload_1
    //   274: aload 6
    //   276: aload_0
    //   277: getfield 115	io/netty/handler/codec/http2/HttpToHttp2ConnectionHandler:currentStreamId	I
    //   280: aload_3
    //   281: aload 7
    //   283: iconst_1
    //   284: aload 4
    //   286: invokestatic 137	io/netty/handler/codec/http2/HttpToHttp2ConnectionHandler:writeHeaders	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/http2/Http2ConnectionEncoder;ILio/netty/handler/codec/http/HttpHeaders;Lio/netty/handler/codec/http2/Http2Headers;ZLio/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator;)V
    //   289: iload 5
    //   291: istore 9
    //   293: goto +13 -> 306
    //   296: astore_3
    //   297: iconst_0
    //   298: istore 9
    //   300: goto +18 -> 318
    //   303: iconst_1
    //   304: istore 9
    //   306: iload 9
    //   308: ifeq +34 -> 342
    //   311: goto +26 -> 337
    //   314: astore_3
    //   315: iconst_1
    //   316: istore 9
    //   318: aload_0
    //   319: aload_1
    //   320: iconst_1
    //   321: aload_3
    //   322: invokevirtual 169	io/netty/handler/codec/http2/Http2ConnectionHandler:onError	(Lio/netty/channel/ChannelHandlerContext;ZLjava/lang/Throwable;)V
    //   325: aload 4
    //   327: aload_3
    //   328: invokevirtual 173	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   331: pop
    //   332: iload 9
    //   334: ifeq +8 -> 342
    //   337: aload_2
    //   338: invokestatic 179	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload 4
    //   344: invokevirtual 182	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   347: pop
    //   348: return
    //   349: astore_1
    //   350: iload 9
    //   352: ifeq +8 -> 360
    //   355: aload_2
    //   356: invokestatic 179	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   359: pop
    //   360: aload 4
    //   362: invokevirtual 182	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   365: pop
    //   366: aload_1
    //   367: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	HttpToHttp2ConnectionHandler
    //   0	368	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	368	2	paramObject	Object
    //   0	368	3	paramChannelPromise	io.netty.channel.ChannelPromise
    //   44	317	4	localSimpleChannelPromiseAggregator	Http2CodecUtil.SimpleChannelPromiseAggregator
    //   47	243	5	i	int
    //   53	222	6	localHttp2ConnectionEncoder	Http2ConnectionEncoder
    //   89	193	7	localObject	Object
    //   114	136	8	bool	boolean
    //   199	152	9	j	int
    //   216	31	10	localByteBuf	io.netty.buffer.ByteBuf
    // Exception table:
    //   from	to	target	type
    //   266	289	296	finally
    //   49	113	314	finally
    //   122	144	314	finally
    //   155	198	314	finally
    //   207	218	314	finally
    //   223	230	314	finally
    //   239	262	314	finally
    //   318	332	349	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\HttpToHttp2ConnectionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */