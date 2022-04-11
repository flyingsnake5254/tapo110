package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.MessageAggregator;

public class StompSubframeAggregator
  extends MessageAggregator<a, StompHeadersSubframe, StompContentSubframe, StompFrame>
{
  public StompSubframeAggregator(int paramInt)
  {
    super(paramInt);
  }
  
  protected StompFrame beginAggregation(StompHeadersSubframe paramStompHeadersSubframe, ByteBuf paramByteBuf)
    throws Exception
  {
    paramByteBuf = new DefaultStompFrame(paramStompHeadersSubframe.command(), paramByteBuf);
    paramByteBuf.headers().set(paramStompHeadersSubframe.headers());
    return paramByteBuf;
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
  
  protected boolean isAggregated(a parama)
    throws Exception
  {
    return parama instanceof StompFrame;
  }
  
  protected boolean isContentLengthInvalid(StompHeadersSubframe paramStompHeadersSubframe, int paramInt)
  {
    boolean bool;
    if ((int)Math.min(2147483647L, paramStompHeadersSubframe.headers().getLong(StompHeaders.CONTENT_LENGTH, -1L)) > paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean isContentMessage(a parama)
    throws Exception
  {
    return parama instanceof StompContentSubframe;
  }
  
  protected boolean isLastContentMessage(StompContentSubframe paramStompContentSubframe)
    throws Exception
  {
    return paramStompContentSubframe instanceof LastStompContentSubframe;
  }
  
  protected boolean isStartMessage(a parama)
    throws Exception
  {
    return parama instanceof StompHeadersSubframe;
  }
  
  protected Object newContinueResponse(StompHeadersSubframe paramStompHeadersSubframe, int paramInt, ChannelPipeline paramChannelPipeline)
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\StompSubframeAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */