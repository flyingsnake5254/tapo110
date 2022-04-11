package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public abstract interface SocketChannelConfig
  extends ChannelConfig
{
  public abstract int getReceiveBufferSize();
  
  public abstract int getSendBufferSize();
  
  public abstract int getSoLinger();
  
  public abstract int getTrafficClass();
  
  public abstract boolean isAllowHalfClosure();
  
  public abstract boolean isKeepAlive();
  
  public abstract boolean isReuseAddress();
  
  public abstract boolean isTcpNoDelay();
  
  public abstract SocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract SocketChannelConfig setAllowHalfClosure(boolean paramBoolean);
  
  public abstract SocketChannelConfig setAutoClose(boolean paramBoolean);
  
  public abstract SocketChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract SocketChannelConfig setConnectTimeoutMillis(int paramInt);
  
  public abstract SocketChannelConfig setKeepAlive(boolean paramBoolean);
  
  @Deprecated
  public abstract SocketChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract SocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract SocketChannelConfig setReceiveBufferSize(int paramInt);
  
  public abstract SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  public abstract SocketChannelConfig setReuseAddress(boolean paramBoolean);
  
  public abstract SocketChannelConfig setSendBufferSize(int paramInt);
  
  public abstract SocketChannelConfig setSoLinger(int paramInt);
  
  public abstract SocketChannelConfig setTcpNoDelay(boolean paramBoolean);
  
  public abstract SocketChannelConfig setTrafficClass(int paramInt);
  
  public abstract SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract SocketChannelConfig setWriteSpinCount(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\SocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */