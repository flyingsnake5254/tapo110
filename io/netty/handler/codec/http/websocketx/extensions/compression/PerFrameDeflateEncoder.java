package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;

class PerFrameDeflateEncoder
  extends DeflateEncoder
{
  PerFrameDeflateEncoder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramBoolean, WebSocketExtensionFilter.NEVER_SKIP);
  }
  
  PerFrameDeflateEncoder(int paramInt1, int paramInt2, boolean paramBoolean, WebSocketExtensionFilter paramWebSocketExtensionFilter)
  {
    super(paramInt1, paramInt2, paramBoolean, paramWebSocketExtensionFilter);
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool1 = super.acceptOutboundMessage(paramObject);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    WebSocketFrame localWebSocketFrame = (WebSocketFrame)paramObject;
    if (extensionEncoderFilter().mustSkip(localWebSocketFrame)) {
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
      if (localWebSocketFrame.content().readableBytes() > 0)
      {
        bool1 = bool2;
        if ((localWebSocketFrame.rsv() & 0x4) == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected boolean removeFrameTail(WebSocketFrame paramWebSocketFrame)
  {
    return true;
  }
  
  protected int rsv(WebSocketFrame paramWebSocketFrame)
  {
    return paramWebSocketFrame.rsv() | 0x4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\PerFrameDeflateEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */