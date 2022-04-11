package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;

public class WebSocketFrameAggregator
  extends MessageAggregator<WebSocketFrame, WebSocketFrame, ContinuationWebSocketFrame, WebSocketFrame>
{
  public WebSocketFrameAggregator(int paramInt)
  {
    super(paramInt);
  }
  
  protected WebSocketFrame beginAggregation(WebSocketFrame paramWebSocketFrame, ByteBuf paramByteBuf)
    throws Exception
  {
    if ((paramWebSocketFrame instanceof TextWebSocketFrame)) {
      return new TextWebSocketFrame(true, paramWebSocketFrame.rsv(), paramByteBuf);
    }
    if ((paramWebSocketFrame instanceof BinaryWebSocketFrame)) {
      return new BinaryWebSocketFrame(true, paramWebSocketFrame.rsv(), paramByteBuf);
    }
    throw new Error();
  }
  
  protected boolean closeAfterContinueResponse(Object paramObject)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected boolean ignoreContentAfterContinueResponse(Object paramObject)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected boolean isAggregated(WebSocketFrame paramWebSocketFrame)
    throws Exception
  {
    boolean bool1 = paramWebSocketFrame.isFinalFragment();
    boolean bool2 = true;
    if (bool1) {
      return isContentMessage(paramWebSocketFrame) ^ true;
    }
    if ((isStartMessage(paramWebSocketFrame)) || (isContentMessage(paramWebSocketFrame))) {
      bool2 = false;
    }
    return bool2;
  }
  
  protected boolean isContentLengthInvalid(WebSocketFrame paramWebSocketFrame, int paramInt)
  {
    return false;
  }
  
  protected boolean isContentMessage(WebSocketFrame paramWebSocketFrame)
    throws Exception
  {
    return paramWebSocketFrame instanceof ContinuationWebSocketFrame;
  }
  
  protected boolean isLastContentMessage(ContinuationWebSocketFrame paramContinuationWebSocketFrame)
    throws Exception
  {
    boolean bool;
    if ((isContentMessage(paramContinuationWebSocketFrame)) && (paramContinuationWebSocketFrame.isFinalFragment())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean isStartMessage(WebSocketFrame paramWebSocketFrame)
    throws Exception
  {
    boolean bool;
    if ((!(paramWebSocketFrame instanceof TextWebSocketFrame)) && (!(paramWebSocketFrame instanceof BinaryWebSocketFrame))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected Object newContinueResponse(WebSocketFrame paramWebSocketFrame, int paramInt, ChannelPipeline paramChannelPipeline)
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketFrameAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */