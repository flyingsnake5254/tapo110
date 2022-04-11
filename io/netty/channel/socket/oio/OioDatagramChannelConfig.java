package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DatagramChannelConfig;
import java.net.InetAddress;
import java.net.NetworkInterface;

@Deprecated
public abstract interface OioDatagramChannelConfig
  extends DatagramChannelConfig
{
  public abstract int getSoTimeout();
  
  public abstract OioDatagramChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract OioDatagramChannelConfig setAutoClose(boolean paramBoolean);
  
  public abstract OioDatagramChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract OioDatagramChannelConfig setBroadcast(boolean paramBoolean);
  
  public abstract OioDatagramChannelConfig setConnectTimeoutMillis(int paramInt);
  
  public abstract OioDatagramChannelConfig setInterface(InetAddress paramInetAddress);
  
  public abstract OioDatagramChannelConfig setLoopbackModeDisabled(boolean paramBoolean);
  
  public abstract OioDatagramChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract OioDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract OioDatagramChannelConfig setNetworkInterface(NetworkInterface paramNetworkInterface);
  
  public abstract OioDatagramChannelConfig setReceiveBufferSize(int paramInt);
  
  public abstract OioDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  public abstract OioDatagramChannelConfig setReuseAddress(boolean paramBoolean);
  
  public abstract OioDatagramChannelConfig setSendBufferSize(int paramInt);
  
  public abstract OioDatagramChannelConfig setSoTimeout(int paramInt);
  
  public abstract OioDatagramChannelConfig setTimeToLive(int paramInt);
  
  public abstract OioDatagramChannelConfig setTrafficClass(int paramInt);
  
  public abstract OioDatagramChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  public abstract OioDatagramChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  public abstract OioDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract OioDatagramChannelConfig setWriteSpinCount(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\oio\OioDatagramChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */