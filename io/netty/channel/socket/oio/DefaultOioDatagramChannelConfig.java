package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DefaultDatagramChannelConfig;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;

final class DefaultOioDatagramChannelConfig
  extends DefaultDatagramChannelConfig
  implements OioDatagramChannelConfig
{
  DefaultOioDatagramChannelConfig(DatagramChannel paramDatagramChannel, DatagramSocket paramDatagramSocket)
  {
    super(paramDatagramChannel, paramDatagramSocket);
    setAllocator(new PreferHeapByteBufAllocator(getAllocator()));
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == ChannelOption.SO_TIMEOUT) {
      return Integer.valueOf(getSoTimeout());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_TIMEOUT });
  }
  
  public int getSoTimeout()
  {
    try
    {
      int i = javaSocket().getSoTimeout();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public OioDatagramChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public OioDatagramChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public OioDatagramChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public OioDatagramChannelConfig setBroadcast(boolean paramBoolean)
  {
    super.setBroadcast(paramBoolean);
    return this;
  }
  
  public OioDatagramChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public OioDatagramChannelConfig setInterface(InetAddress paramInetAddress)
  {
    super.setInterface(paramInetAddress);
    return this;
  }
  
  public OioDatagramChannelConfig setLoopbackModeDisabled(boolean paramBoolean)
  {
    super.setLoopbackModeDisabled(paramBoolean);
    return this;
  }
  
  public OioDatagramChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public OioDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public OioDatagramChannelConfig setNetworkInterface(NetworkInterface paramNetworkInterface)
  {
    super.setNetworkInterface(paramNetworkInterface);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == ChannelOption.SO_TIMEOUT)
    {
      setSoTimeout(((Integer)paramT).intValue());
      return true;
    }
    return super.setOption(paramChannelOption, paramT);
  }
  
  public OioDatagramChannelConfig setReceiveBufferSize(int paramInt)
  {
    super.setReceiveBufferSize(paramInt);
    return this;
  }
  
  public OioDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public OioDatagramChannelConfig setReuseAddress(boolean paramBoolean)
  {
    super.setReuseAddress(paramBoolean);
    return this;
  }
  
  public OioDatagramChannelConfig setSendBufferSize(int paramInt)
  {
    super.setSendBufferSize(paramInt);
    return this;
  }
  
  public OioDatagramChannelConfig setSoTimeout(int paramInt)
  {
    try
    {
      javaSocket().setSoTimeout(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public OioDatagramChannelConfig setTimeToLive(int paramInt)
  {
    super.setTimeToLive(paramInt);
    return this;
  }
  
  public OioDatagramChannelConfig setTrafficClass(int paramInt)
  {
    super.setTrafficClass(paramInt);
    return this;
  }
  
  public OioDatagramChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public OioDatagramChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public OioDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public OioDatagramChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\oio\DefaultOioDatagramChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */