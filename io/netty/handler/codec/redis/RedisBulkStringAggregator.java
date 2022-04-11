package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;

public final class RedisBulkStringAggregator
  extends MessageAggregator<a, BulkStringHeaderRedisMessage, BulkStringRedisContent, FullBulkStringRedisMessage>
{
  public RedisBulkStringAggregator()
  {
    super(536870912);
  }
  
  protected FullBulkStringRedisMessage beginAggregation(BulkStringHeaderRedisMessage paramBulkStringHeaderRedisMessage, ByteBuf paramByteBuf)
    throws Exception
  {
    return new FullBulkStringRedisMessage(paramByteBuf);
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
    return parama instanceof FullBulkStringRedisMessage;
  }
  
  protected boolean isContentLengthInvalid(BulkStringHeaderRedisMessage paramBulkStringHeaderRedisMessage, int paramInt)
    throws Exception
  {
    boolean bool;
    if (paramBulkStringHeaderRedisMessage.bulkStringLength() > paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean isContentMessage(a parama)
    throws Exception
  {
    return parama instanceof BulkStringRedisContent;
  }
  
  protected boolean isLastContentMessage(BulkStringRedisContent paramBulkStringRedisContent)
    throws Exception
  {
    return paramBulkStringRedisContent instanceof LastBulkStringRedisContent;
  }
  
  protected boolean isStartMessage(a parama)
    throws Exception
  {
    boolean bool;
    if (((parama instanceof BulkStringHeaderRedisMessage)) && (!isAggregated(parama))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected Object newContinueResponse(BulkStringHeaderRedisMessage paramBulkStringHeaderRedisMessage, int paramInt, ChannelPipeline paramChannelPipeline)
    throws Exception
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\RedisBulkStringAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */