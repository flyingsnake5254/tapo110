package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;

@Deprecated
public abstract interface OioServerSocketChannelConfig
  extends ServerSocketChannelConfig
{
  public abstract int getSoTimeout();
  
  public abstract OioServerSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract OioServerSocketChannelConfig setAutoClose(boolean paramBoolean);
  
  public abstract OioServerSocketChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract OioServerSocketChannelConfig setBacklog(int paramInt);
  
  public abstract OioServerSocketChannelConfig setConnectTimeoutMillis(int paramInt);
  
  @Deprecated
  public abstract OioServerSocketChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract OioServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract OioServerSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract OioServerSocketChannelConfig setReceiveBufferSize(int paramInt);
  
  public abstract OioServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  public abstract OioServerSocketChannelConfig setReuseAddress(boolean paramBoolean);
  
  public abstract OioServerSocketChannelConfig setSoTimeout(int paramInt);
  
  public abstract OioServerSocketChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  public abstract OioServerSocketChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  public abstract OioServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract OioServerSocketChannelConfig setWriteSpinCount(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\oio\OioServerSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */