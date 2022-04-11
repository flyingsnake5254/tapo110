package io.netty.channel.unix;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public abstract interface DomainSocketChannelConfig
  extends ChannelConfig
{
  public abstract DomainSocketReadMode getReadMode();
  
  public abstract DomainSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract DomainSocketChannelConfig setAutoClose(boolean paramBoolean);
  
  public abstract DomainSocketChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract DomainSocketChannelConfig setConnectTimeoutMillis(int paramInt);
  
  @Deprecated
  public abstract DomainSocketChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract DomainSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract DomainSocketChannelConfig setReadMode(DomainSocketReadMode paramDomainSocketReadMode);
  
  public abstract DomainSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  @Deprecated
  public abstract DomainSocketChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  @Deprecated
  public abstract DomainSocketChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  public abstract DomainSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract DomainSocketChannelConfig setWriteSpinCount(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\DomainSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */