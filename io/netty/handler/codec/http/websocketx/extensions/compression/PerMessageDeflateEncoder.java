package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;
import java.util.List;

class PerMessageDeflateEncoder
  extends DeflateEncoder
{
  private boolean compressing;
  
  PerMessageDeflateEncoder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramBoolean, WebSocketExtensionFilter.NEVER_SKIP);
  }
  
  PerMessageDeflateEncoder(int paramInt1, int paramInt2, boolean paramBoolean, WebSocketExtensionFilter paramWebSocketExtensionFilter)
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
    paramObject = (WebSocketFrame)paramObject;
    if (extensionEncoderFilter().mustSkip((WebSocketFrame)paramObject))
    {
      if (!this.compressing) {
        return false;
      }
      throw new IllegalStateException("Cannot skip per message deflate encoder, compression in progress");
    }
    if (((!(paramObject instanceof TextWebSocketFrame)) && (!(paramObject instanceof BinaryWebSocketFrame))) || ((((WebSocketFrame)paramObject).rsv() & 0x4) != 0))
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
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame, List<Object> paramList)
    throws Exception
  {
    super.encode(paramChannelHandlerContext, paramWebSocketFrame, paramList);
    if (paramWebSocketFrame.isFinalFragment()) {
      this.compressing = false;
    } else if (((paramWebSocketFrame instanceof TextWebSocketFrame)) || ((paramWebSocketFrame instanceof BinaryWebSocketFrame))) {
      this.compressing = true;
    }
  }
  
  protected boolean removeFrameTail(WebSocketFrame paramWebSocketFrame)
  {
    return paramWebSocketFrame.isFinalFragment();
  }
  
  protected int rsv(WebSocketFrame paramWebSocketFrame)
  {
    int i;
    if ((!(paramWebSocketFrame instanceof TextWebSocketFrame)) && (!(paramWebSocketFrame instanceof BinaryWebSocketFrame))) {
      i = paramWebSocketFrame.rsv();
    } else {
      i = paramWebSocketFrame.rsv() | 0x4;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\PerMessageDeflateEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */