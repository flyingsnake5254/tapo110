package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;
import java.util.List;

class PerMessageDeflateDecoder
  extends DeflateDecoder
{
  private boolean compressing;
  
  PerMessageDeflateDecoder(boolean paramBoolean)
  {
    super(paramBoolean, WebSocketExtensionFilter.NEVER_SKIP);
  }
  
  PerMessageDeflateDecoder(boolean paramBoolean, WebSocketExtensionFilter paramWebSocketExtensionFilter)
  {
    super(paramBoolean, paramWebSocketExtensionFilter);
  }
  
  public boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool1 = super.acceptInboundMessage(paramObject);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (WebSocketFrame)paramObject;
    if (extensionDecoderFilter().mustSkip((WebSocketFrame)paramObject))
    {
      if (!this.compressing) {
        return false;
      }
      throw new IllegalStateException("Cannot skip per message deflate decoder, compression in progress");
    }
    if (((!(paramObject instanceof TextWebSocketFrame)) && (!(paramObject instanceof BinaryWebSocketFrame))) || ((((WebSocketFrame)paramObject).rsv() & 0x4) <= 0))
    {
      bool1 = bool2;
      if ((paramObject instanceof ContinuationWebSocketFrame))
      {
        bool1 = bool2;
        if (!this.compressing) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  protected boolean appendFrameTail(WebSocketFrame paramWebSocketFrame)
  {
    return paramWebSocketFrame.isFinalFragment();
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame, List<Object> paramList)
    throws Exception
  {
    super.decode(paramChannelHandlerContext, paramWebSocketFrame, paramList);
    if (paramWebSocketFrame.isFinalFragment()) {
      this.compressing = false;
    } else if (((paramWebSocketFrame instanceof TextWebSocketFrame)) || ((paramWebSocketFrame instanceof BinaryWebSocketFrame))) {
      this.compressing = true;
    }
  }
  
  protected int newRsv(WebSocketFrame paramWebSocketFrame)
  {
    int i;
    if ((paramWebSocketFrame.rsv() & 0x4) > 0) {
      i = paramWebSocketFrame.rsv() ^ 0x4;
    } else {
      i = paramWebSocketFrame.rsv();
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\PerMessageDeflateDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */