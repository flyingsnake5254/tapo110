package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import java.util.Map;

public abstract interface ChannelConfig
{
  public abstract ByteBufAllocator getAllocator();
  
  public abstract int getConnectTimeoutMillis();
  
  @Deprecated
  public abstract int getMaxMessagesPerRead();
  
  public abstract MessageSizeEstimator getMessageSizeEstimator();
  
  public abstract <T> T getOption(ChannelOption<T> paramChannelOption);
  
  public abstract Map<ChannelOption<?>, Object> getOptions();
  
  public abstract <T extends RecvByteBufAllocator> T getRecvByteBufAllocator();
  
  public abstract int getWriteBufferHighWaterMark();
  
  public abstract int getWriteBufferLowWaterMark();
  
  public abstract WriteBufferWaterMark getWriteBufferWaterMark();
  
  public abstract int getWriteSpinCount();
  
  public abstract boolean isAutoClose();
  
  public abstract boolean isAutoRead();
  
  public abstract ChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract ChannelConfig setAutoClose(boolean paramBoolean);
  
  public abstract ChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract ChannelConfig setConnectTimeoutMillis(int paramInt);
  
  @Deprecated
  public abstract ChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract ChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT);
  
  public abstract boolean setOptions(Map<ChannelOption<?>, ?> paramMap);
  
  public abstract ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  public abstract ChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  public abstract ChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  public abstract ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract ChannelConfig setWriteSpinCount(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */