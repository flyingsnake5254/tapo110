package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public abstract interface ServerSocketChannelConfig
  extends ChannelConfig
{
  public abstract int getBacklog();
  
  public abstract int getReceiveBufferSize();
  
  public abstract boolean isReuseAddress();
  
  public abstract ServerSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract ServerSocketChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract ServerSocketChannelConfig setBacklog(int paramInt);
  
  public abstract ServerSocketChannelConfig setConnectTimeoutMillis(int paramInt);
  
  @Deprecated
  public abstract ServerSocketChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract ServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract ServerSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract ServerSocketChannelConfig setReceiveBufferSize(int paramInt);
  
  public abstract ServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  public abstract ServerSocketChannelConfig setReuseAddress(boolean paramBoolean);
  
  public abstract ServerSocketChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  public abstract ServerSocketChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  public abstract ServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract ServerSocketChannelConfig setWriteSpinCount(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\ServerSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */