package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientUpgradeHandler.UpgradeCodec;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.internal.ObjectUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Http2ClientUpgradeCodec
  implements HttpClientUpgradeHandler.UpgradeCodec
{
  private static final List<CharSequence> UPGRADE_HEADERS = Collections.singletonList(Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER);
  private final Http2ConnectionHandler connectionHandler;
  private final String handlerName;
  private final ChannelHandler http2MultiplexHandler;
  private final ChannelHandler upgradeToHandler;
  
  public Http2ClientUpgradeCodec(Http2ConnectionHandler paramHttp2ConnectionHandler)
  {
    this(null, paramHttp2ConnectionHandler);
  }
  
  public Http2ClientUpgradeCodec(Http2ConnectionHandler paramHttp2ConnectionHandler, Http2MultiplexHandler paramHttp2MultiplexHandler)
  {
    this(null, paramHttp2ConnectionHandler, paramHttp2MultiplexHandler);
  }
  
  public Http2ClientUpgradeCodec(Http2FrameCodec paramHttp2FrameCodec, ChannelHandler paramChannelHandler)
  {
    this(null, paramHttp2FrameCodec, paramChannelHandler);
  }
  
  public Http2ClientUpgradeCodec(String paramString, Http2ConnectionHandler paramHttp2ConnectionHandler)
  {
    this(paramString, paramHttp2ConnectionHandler, paramHttp2ConnectionHandler, null);
  }
  
  private Http2ClientUpgradeCodec(String paramString, Http2ConnectionHandler paramHttp2ConnectionHandler, ChannelHandler paramChannelHandler, Http2MultiplexHandler paramHttp2MultiplexHandler)
  {
    this.handlerName = paramString;
    this.connectionHandler = ((Http2ConnectionHandler)ObjectUtil.checkNotNull(paramHttp2ConnectionHandler, "connectionHandler"));
    this.upgradeToHandler = ((ChannelHandler)ObjectUtil.checkNotNull(paramChannelHandler, "upgradeToHandler"));
    this.http2MultiplexHandler = paramHttp2MultiplexHandler;
  }
  
  public Http2ClientUpgradeCodec(String paramString, Http2ConnectionHandler paramHttp2ConnectionHandler, Http2MultiplexHandler paramHttp2MultiplexHandler)
  {
    this(paramString, paramHttp2ConnectionHandler, paramHttp2ConnectionHandler, paramHttp2MultiplexHandler);
  }
  
  public Http2ClientUpgradeCodec(String paramString, Http2FrameCodec paramHttp2FrameCodec, ChannelHandler paramChannelHandler)
  {
    this(paramString, paramHttp2FrameCodec, paramChannelHandler, null);
  }
  
  /* Error */
  private CharSequence getSettingsHeaderValue(ChannelHandlerContext paramChannelHandlerContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 64	io/netty/handler/codec/http2/Http2ClientUpgradeCodec:connectionHandler	Lio/netty/handler/codec/http2/Http2ConnectionHandler;
    //   8: invokevirtual 77	io/netty/handler/codec/http2/Http2ConnectionHandler:decoder	()Lio/netty/handler/codec/http2/Http2ConnectionDecoder;
    //   11: invokeinterface 83 1 0
    //   16: astore 4
    //   18: aload 4
    //   20: invokevirtual 89	io/netty/util/collection/CharObjectHashMap:size	()I
    //   23: istore 5
    //   25: aload_1
    //   26: invokeinterface 95 1 0
    //   31: iload 5
    //   33: bipush 6
    //   35: imul
    //   36: invokeinterface 101 2 0
    //   41: astore 6
    //   43: aload_3
    //   44: astore_1
    //   45: aload 4
    //   47: invokevirtual 105	io/netty/util/collection/CharObjectHashMap:entries	()Ljava/lang/Iterable;
    //   50: invokeinterface 111 1 0
    //   55: astore 4
    //   57: aload_3
    //   58: astore_1
    //   59: aload 4
    //   61: invokeinterface 117 1 0
    //   66: ifeq +53 -> 119
    //   69: aload_3
    //   70: astore_1
    //   71: aload 4
    //   73: invokeinterface 121 1 0
    //   78: checkcast 123	io/netty/util/collection/CharObjectMap$PrimitiveEntry
    //   81: astore_2
    //   82: aload_3
    //   83: astore_1
    //   84: aload 6
    //   86: aload_2
    //   87: invokeinterface 127 1 0
    //   92: invokevirtual 132	io/netty/buffer/ByteBuf:writeChar	(I)Lio/netty/buffer/ByteBuf;
    //   95: pop
    //   96: aload_3
    //   97: astore_1
    //   98: aload 6
    //   100: aload_2
    //   101: invokeinterface 135 1 0
    //   106: checkcast 137	java/lang/Long
    //   109: invokevirtual 140	java/lang/Long:intValue	()I
    //   112: invokevirtual 143	io/netty/buffer/ByteBuf:writeInt	(I)Lio/netty/buffer/ByteBuf;
    //   115: pop
    //   116: goto -59 -> 57
    //   119: aload_3
    //   120: astore_1
    //   121: aload 6
    //   123: getstatic 149	io/netty/handler/codec/base64/Base64Dialect:URL_SAFE	Lio/netty/handler/codec/base64/Base64Dialect;
    //   126: invokestatic 155	io/netty/handler/codec/base64/Base64:encode	(Lio/netty/buffer/ByteBuf;Lio/netty/handler/codec/base64/Base64Dialect;)Lio/netty/buffer/ByteBuf;
    //   129: astore_3
    //   130: aload_3
    //   131: astore_1
    //   132: aload_3
    //   133: getstatic 161	io/netty/util/CharsetUtil:UTF_8	Ljava/nio/charset/Charset;
    //   136: invokevirtual 165	io/netty/buffer/ByteBuf:toString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   139: astore_2
    //   140: aload 6
    //   142: invokestatic 171	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   145: pop
    //   146: aload_3
    //   147: invokestatic 171	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   150: pop
    //   151: aload_2
    //   152: areturn
    //   153: astore_3
    //   154: goto +9 -> 163
    //   157: astore_3
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_2
    //   161: astore 6
    //   163: aload 6
    //   165: invokestatic 171	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: aload_1
    //   170: invokestatic 171	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   173: pop
    //   174: aload_3
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	Http2ClientUpgradeCodec
    //   0	176	1	paramChannelHandlerContext	ChannelHandlerContext
    //   1	160	2	localObject1	Object
    //   3	144	3	localByteBuf	io.netty.buffer.ByteBuf
    //   153	1	3	localObject2	Object
    //   157	18	3	localObject3	Object
    //   16	56	4	localObject4	Object
    //   23	13	5	i	int
    //   41	123	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   45	57	153	finally
    //   59	69	153	finally
    //   71	82	153	finally
    //   84	96	153	finally
    //   98	116	153	finally
    //   121	130	153	finally
    //   132	140	153	finally
    //   4	43	157	finally
  }
  
  public CharSequence protocol()
  {
    return Http2CodecUtil.HTTP_UPGRADE_PROTOCOL_NAME;
  }
  
  public Collection<CharSequence> setUpgradeHeaders(ChannelHandlerContext paramChannelHandlerContext, HttpRequest paramHttpRequest)
  {
    paramChannelHandlerContext = getSettingsHeaderValue(paramChannelHandlerContext);
    paramHttpRequest.headers().set(Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER, paramChannelHandlerContext);
    return UPGRADE_HEADERS;
  }
  
  public void upgradeTo(ChannelHandlerContext paramChannelHandlerContext, FullHttpResponse paramFullHttpResponse)
    throws Exception
  {
    try
    {
      paramChannelHandlerContext.pipeline().addAfter(paramChannelHandlerContext.name(), this.handlerName, this.upgradeToHandler);
      if (this.http2MultiplexHandler != null)
      {
        paramFullHttpResponse = paramChannelHandlerContext.pipeline().context(this.connectionHandler).name();
        paramChannelHandlerContext.pipeline().addAfter(paramFullHttpResponse, null, this.http2MultiplexHandler);
      }
      this.connectionHandler.onHttpClientUpgrade();
    }
    catch (Http2Exception paramFullHttpResponse)
    {
      paramChannelHandlerContext.fireExceptionCaught(paramFullHttpResponse);
      paramChannelHandlerContext.close();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2ClientUpgradeCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */