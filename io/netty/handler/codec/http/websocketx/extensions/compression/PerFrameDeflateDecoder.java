package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;

class PerFrameDeflateDecoder
  extends DeflateDecoder
{
  PerFrameDeflateDecoder(boolean paramBoolean)
  {
    super(paramBoolean, WebSocketExtensionFilter.NEVER_SKIP);
  }
  
  PerFrameDeflateDecoder(boolean paramBoolean, WebSocketExtensionFilter paramWebSocketExtensionFilter)
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
    WebSocketFrame localWebSocketFrame = (WebSocketFrame)paramObject;
    if (extensionDecoderFilter().mustSkip(localWebSocketFrame)) {
      return false;
    }
    if ((!(paramObject instanceof TextWebSocketFrame)) && (!(paramObject instanceof BinaryWebSocketFrame)))
    {
      bool1 = bool2;
      if (!(paramObject instanceof ContinuationWebSocketFrame)) {}
    }
    else
    {
      bool1 = bool2;
      if ((localWebSocketFrame.rsv() & 0x4) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean appendFrameTail(WebSocketFrame paramWebSocketFrame)
  {
    return true;
  }
  
  protected int newRsv(WebSocketFrame paramWebSocketFrame)
  {
    return paramWebSocketFrame.rsv() ^ 0x4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\PerFrameDeflateDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */