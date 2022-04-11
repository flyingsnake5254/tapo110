package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpServerUpgradeHandler.UpgradeCodec;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.CharBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Http2ServerUpgradeCodec
  implements HttpServerUpgradeHandler.UpgradeCodec
{
  private static final ChannelHandler[] EMPTY_HANDLERS = new ChannelHandler[0];
  private static final List<CharSequence> REQUIRED_UPGRADE_HEADERS;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2ServerUpgradeCodec.class);
  private final Http2ConnectionHandler connectionHandler;
  private final Http2FrameReader frameReader;
  private final String handlerName;
  private final ChannelHandler[] handlers;
  private Http2Settings settings;
  
  static
  {
    REQUIRED_UPGRADE_HEADERS = Collections.singletonList(Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER);
  }
  
  public Http2ServerUpgradeCodec(Http2ConnectionHandler paramHttp2ConnectionHandler)
  {
    this(null, paramHttp2ConnectionHandler, EMPTY_HANDLERS);
  }
  
  public Http2ServerUpgradeCodec(Http2FrameCodec paramHttp2FrameCodec, ChannelHandler... paramVarArgs)
  {
    this(null, paramHttp2FrameCodec, paramVarArgs);
  }
  
  public Http2ServerUpgradeCodec(Http2MultiplexCodec paramHttp2MultiplexCodec)
  {
    this(null, paramHttp2MultiplexCodec, EMPTY_HANDLERS);
  }
  
  public Http2ServerUpgradeCodec(String paramString, Http2ConnectionHandler paramHttp2ConnectionHandler)
  {
    this(paramString, paramHttp2ConnectionHandler, EMPTY_HANDLERS);
  }
  
  private Http2ServerUpgradeCodec(String paramString, Http2ConnectionHandler paramHttp2ConnectionHandler, ChannelHandler... paramVarArgs)
  {
    this.handlerName = paramString;
    this.connectionHandler = paramHttp2ConnectionHandler;
    this.handlers = paramVarArgs;
    this.frameReader = new DefaultHttp2FrameReader();
  }
  
  public Http2ServerUpgradeCodec(String paramString, Http2MultiplexCodec paramHttp2MultiplexCodec)
  {
    this(paramString, paramHttp2MultiplexCodec, EMPTY_HANDLERS);
  }
  
  private static ByteBuf createSettingsFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.alloc().buffer(paramByteBuf.readableBytes() + 9);
    Http2CodecUtil.writeFrameHeader(paramChannelHandlerContext, paramByteBuf.readableBytes(), (byte)4, new Http2Flags(), 0);
    paramChannelHandlerContext.writeBytes(paramByteBuf);
    paramByteBuf.release();
    return paramChannelHandlerContext;
  }
  
  private Http2Settings decodeSettings(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Http2Exception
  {
    try
    {
      Http2Settings localHttp2Settings = new io/netty/handler/codec/http2/Http2Settings;
      localHttp2Settings.<init>();
      Http2FrameReader localHttp2FrameReader = this.frameReader;
      Http2FrameAdapter local1 = new io/netty/handler/codec/http2/Http2ServerUpgradeCodec$1;
      local1.<init>(this, localHttp2Settings);
      localHttp2FrameReader.readFrame(paramChannelHandlerContext, paramByteBuf, local1);
      return localHttp2Settings;
    }
    finally
    {
      paramByteBuf.release();
    }
  }
  
  private Http2Settings decodeSettingsHeader(ChannelHandlerContext paramChannelHandlerContext, CharSequence paramCharSequence)
    throws Http2Exception
  {
    paramCharSequence = ByteBufUtil.encodeString(paramChannelHandlerContext.alloc(), CharBuffer.wrap(paramCharSequence), CharsetUtil.UTF_8);
    try
    {
      paramChannelHandlerContext = decodeSettings(paramChannelHandlerContext, createSettingsFrame(paramChannelHandlerContext, Base64.decode(paramCharSequence, Base64Dialect.URL_SAFE)));
      return paramChannelHandlerContext;
    }
    finally
    {
      paramCharSequence.release();
    }
  }
  
  public boolean prepareUpgradeResponse(ChannelHandlerContext paramChannelHandlerContext, FullHttpRequest paramFullHttpRequest, HttpHeaders paramHttpHeaders)
  {
    try
    {
      paramHttpHeaders = paramFullHttpRequest.headers();
      paramFullHttpRequest = Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER;
      paramHttpHeaders = paramHttpHeaders.getAll(paramFullHttpRequest);
      if ((!paramHttpHeaders.isEmpty()) && (paramHttpHeaders.size() <= 1))
      {
        this.settings = decodeSettingsHeader(paramChannelHandlerContext, (CharSequence)paramHttpHeaders.get(0));
        return true;
      }
      paramHttpHeaders = new java/lang/IllegalArgumentException;
      paramChannelHandlerContext = new java/lang/StringBuilder;
      paramChannelHandlerContext.<init>();
      paramChannelHandlerContext.append("There must be 1 and only 1 ");
      paramChannelHandlerContext.append(paramFullHttpRequest);
      paramChannelHandlerContext.append(" header.");
      paramHttpHeaders.<init>(paramChannelHandlerContext.toString());
      throw paramHttpHeaders;
    }
    finally
    {
      logger.info("Error during upgrade to HTTP/2", paramChannelHandlerContext);
    }
    return false;
  }
  
  public Collection<CharSequence> requiredUpgradeHeaders()
  {
    return REQUIRED_UPGRADE_HEADERS;
  }
  
  public void upgradeTo(ChannelHandlerContext paramChannelHandlerContext, FullHttpRequest paramFullHttpRequest)
  {
    try
    {
      paramChannelHandlerContext.pipeline().addAfter(paramChannelHandlerContext.name(), this.handlerName, this.connectionHandler);
      if (this.handlers != null)
      {
        paramFullHttpRequest = paramChannelHandlerContext.pipeline().context(this.connectionHandler).name();
        for (int i = this.handlers.length - 1; i >= 0; i--) {
          paramChannelHandlerContext.pipeline().addAfter(paramFullHttpRequest, null, this.handlers[i]);
        }
      }
      this.connectionHandler.onHttpServerUpgrade(this.settings);
    }
    catch (Http2Exception paramFullHttpRequest)
    {
      paramChannelHandlerContext.fireExceptionCaught(paramFullHttpRequest);
      paramChannelHandlerContext.close();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2ServerUpgradeCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */