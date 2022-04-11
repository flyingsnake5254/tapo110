package io.netty.handler.codec.memcache;

import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;

public abstract class AbstractMemcacheObjectAggregator<H extends MemcacheMessage>
  extends MessageAggregator<a, H, MemcacheContent, FullMemcacheMessage>
{
  protected AbstractMemcacheObjectAggregator(int paramInt)
  {
    super(paramInt);
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
    return parama instanceof FullMemcacheMessage;
  }
  
  protected boolean isContentLengthInvalid(H paramH, int paramInt)
  {
    return false;
  }
  
  protected boolean isContentMessage(a parama)
    throws Exception
  {
    return parama instanceof MemcacheContent;
  }
  
  protected boolean isLastContentMessage(MemcacheContent paramMemcacheContent)
    throws Exception
  {
    return paramMemcacheContent instanceof LastMemcacheContent;
  }
  
  protected Object newContinueResponse(H paramH, int paramInt, ChannelPipeline paramChannelPipeline)
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\AbstractMemcacheObjectAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */