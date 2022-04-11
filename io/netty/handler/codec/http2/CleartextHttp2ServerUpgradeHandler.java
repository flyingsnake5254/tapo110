package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public final class CleartextHttp2ServerUpgradeHandler
  extends ByteToMessageDecoder
{
  private static final ByteBuf CONNECTION_PREFACE = Unpooled.unreleasableBuffer(Http2CodecUtil.connectionPrefaceBuf());
  private final ChannelHandler http2ServerHandler;
  private final HttpServerCodec httpServerCodec;
  private final HttpServerUpgradeHandler httpServerUpgradeHandler;
  
  public CleartextHttp2ServerUpgradeHandler(HttpServerCodec paramHttpServerCodec, HttpServerUpgradeHandler paramHttpServerUpgradeHandler, ChannelHandler paramChannelHandler)
  {
    this.httpServerCodec = ((HttpServerCodec)ObjectUtil.checkNotNull(paramHttpServerCodec, "httpServerCodec"));
    this.httpServerUpgradeHandler = ((HttpServerUpgradeHandler)ObjectUtil.checkNotNull(paramHttpServerUpgradeHandler, "httpServerUpgradeHandler"));
    this.http2ServerHandler = ((ChannelHandler)ObjectUtil.checkNotNull(paramChannelHandler, "http2ServerHandler"));
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    paramList = CONNECTION_PREFACE;
    int i = paramList.readableBytes();
    int j = Math.min(paramByteBuf.readableBytes(), i);
    if (!ByteBufUtil.equals(paramList, paramList.readerIndex(), paramByteBuf, paramByteBuf.readerIndex(), j))
    {
      paramChannelHandlerContext.pipeline().remove(this);
    }
    else if (j == i)
    {
      paramChannelHandlerContext.pipeline().remove(this.httpServerCodec).remove(this.httpServerUpgradeHandler);
      paramChannelHandlerContext.pipeline().addAfter(paramChannelHandlerContext.name(), null, this.http2ServerHandler);
      paramChannelHandlerContext.pipeline().remove(this);
      paramChannelHandlerContext.fireUserEventTriggered(PriorKnowledgeUpgradeEvent.INSTANCE);
    }
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.pipeline().addAfter(paramChannelHandlerContext.name(), null, this.httpServerUpgradeHandler).addAfter(paramChannelHandlerContext.name(), null, this.httpServerCodec);
  }
  
  public static final class PriorKnowledgeUpgradeEvent
  {
    private static final PriorKnowledgeUpgradeEvent INSTANCE = new PriorKnowledgeUpgradeEvent();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\CleartextHttp2ServerUpgradeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */