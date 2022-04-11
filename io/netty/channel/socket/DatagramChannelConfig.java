package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.net.InetAddress;
import java.net.NetworkInterface;

public abstract interface DatagramChannelConfig
  extends ChannelConfig
{
  public abstract InetAddress getInterface();
  
  public abstract NetworkInterface getNetworkInterface();
  
  public abstract int getReceiveBufferSize();
  
  public abstract int getSendBufferSize();
  
  public abstract int getTimeToLive();
  
  public abstract int getTrafficClass();
  
  public abstract boolean isBroadcast();
  
  public abstract boolean isLoopbackModeDisabled();
  
  public abstract boolean isReuseAddress();
  
  public abstract DatagramChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract DatagramChannelConfig setAutoClose(boolean paramBoolean);
  
  public abstract DatagramChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract DatagramChannelConfig setBroadcast(boolean paramBoolean);
  
  public abstract DatagramChannelConfig setConnectTimeoutMillis(int paramInt);
  
  public abstract DatagramChannelConfig setInterface(InetAddress paramInetAddress);
  
  public abstract DatagramChannelConfig setLoopbackModeDisabled(boolean paramBoolean);
  
  @Deprecated
  public abstract DatagramChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract DatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract DatagramChannelConfig setNetworkInterface(NetworkInterface paramNetworkInterface);
  
  public abstract DatagramChannelConfig setReceiveBufferSize(int paramInt);
  
  public abstract DatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  public abstract DatagramChannelConfig setReuseAddress(boolean paramBoolean);
  
  public abstract DatagramChannelConfig setSendBufferSize(int paramInt);
  
  public abstract DatagramChannelConfig setTimeToLive(int paramInt);
  
  public abstract DatagramChannelConfig setTrafficClass(int paramInt);
  
  public abstract DatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract DatagramChannelConfig setWriteSpinCount(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\DatagramChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */