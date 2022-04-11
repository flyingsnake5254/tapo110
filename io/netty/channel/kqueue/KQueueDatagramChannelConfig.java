package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannelOption;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;

public final class KQueueDatagramChannelConfig
  extends KQueueChannelConfig
  implements DatagramChannelConfig
{
  private static final RecvByteBufAllocator DEFAULT_RCVBUF_ALLOCATOR = new FixedRecvByteBufAllocator(2048);
  private boolean activeOnOpen;
  
  KQueueDatagramChannelConfig(KQueueDatagramChannel paramKQueueDatagramChannel)
  {
    super(paramKQueueDatagramChannel);
    setRecvByteBufAllocator(DEFAULT_RCVBUF_ALLOCATOR);
  }
  
  private void setActiveOnOpen(boolean paramBoolean)
  {
    if (!this.channel.isRegistered())
    {
      this.activeOnOpen = paramBoolean;
      return;
    }
    throw new IllegalStateException("Can only changed before channel was registered");
  }
  
  boolean getActiveOnOpen()
  {
    return this.activeOnOpen;
  }
  
  public InetAddress getInterface()
  {
    return null;
  }
  
  public NetworkInterface getNetworkInterface()
  {
    return null;
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == ChannelOption.SO_BROADCAST) {
      return Boolean.valueOf(isBroadcast());
    }
    if (paramChannelOption == ChannelOption.SO_RCVBUF) {
      return Integer.valueOf(getReceiveBufferSize());
    }
    if (paramChannelOption == ChannelOption.SO_SNDBUF) {
      return Integer.valueOf(getSendBufferSize());
    }
    if (paramChannelOption == ChannelOption.SO_REUSEADDR) {
      return Boolean.valueOf(isReuseAddress());
    }
    if (paramChannelOption == ChannelOption.IP_MULTICAST_LOOP_DISABLED) {
      return Boolean.valueOf(isLoopbackModeDisabled());
    }
    if (paramChannelOption == ChannelOption.IP_MULTICAST_ADDR) {
      return getInterface();
    }
    if (paramChannelOption == ChannelOption.IP_MULTICAST_IF) {
      return getNetworkInterface();
    }
    if (paramChannelOption == ChannelOption.IP_MULTICAST_TTL) {
      return Integer.valueOf(getTimeToLive());
    }
    if (paramChannelOption == ChannelOption.IP_TOS) {
      return Integer.valueOf(getTrafficClass());
    }
    if (paramChannelOption == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
      return Boolean.valueOf(this.activeOnOpen);
    }
    if (paramChannelOption == UnixChannelOption.SO_REUSEPORT) {
      return Boolean.valueOf(isReusePort());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_BROADCAST, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.IP_MULTICAST_LOOP_DISABLED, ChannelOption.IP_MULTICAST_ADDR, ChannelOption.IP_MULTICAST_IF, ChannelOption.IP_MULTICAST_TTL, ChannelOption.IP_TOS, ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, UnixChannelOption.SO_REUSEPORT });
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = ((KQueueDatagramChannel)this.channel).socket.getReceiveBufferSize();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getSendBufferSize()
  {
    try
    {
      int i = ((KQueueDatagramChannel)this.channel).socket.getSendBufferSize();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getTimeToLive()
  {
    return -1;
  }
  
  public int getTrafficClass()
  {
    try
    {
      int i = ((KQueueDatagramChannel)this.channel).socket.getTrafficClass();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isBroadcast()
  {
    try
    {
      boolean bool = ((KQueueDatagramChannel)this.channel).socket.isBroadcast();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isLoopbackModeDisabled()
  {
    return false;
  }
  
  public boolean isReuseAddress()
  {
    try
    {
      boolean bool = ((KQueueDatagramChannel)this.channel).socket.isReuseAddress();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isReusePort()
  {
    try
    {
      boolean bool = ((KQueueDatagramChannel)this.channel).socket.isReusePort();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueDatagramChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public KQueueDatagramChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public KQueueDatagramChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public KQueueDatagramChannelConfig setBroadcast(boolean paramBoolean)
  {
    try
    {
      ((KQueueDatagramChannel)this.channel).socket.setBroadcast(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueDatagramChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public KQueueDatagramChannelConfig setInterface(InetAddress paramInetAddress)
  {
    throw new UnsupportedOperationException("Multicast not supported");
  }
  
  public DatagramChannelConfig setLoopbackModeDisabled(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Multicast not supported");
  }
  
  @Deprecated
  public KQueueDatagramChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public KQueueDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public KQueueDatagramChannelConfig setNetworkInterface(NetworkInterface paramNetworkInterface)
  {
    throw new UnsupportedOperationException("Multicast not supported");
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == ChannelOption.SO_BROADCAST)
    {
      setBroadcast(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.SO_RCVBUF)
    {
      setReceiveBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.SO_SNDBUF)
    {
      setSendBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.SO_REUSEADDR)
    {
      setReuseAddress(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.IP_MULTICAST_LOOP_DISABLED)
    {
      setLoopbackModeDisabled(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.IP_MULTICAST_ADDR)
    {
      setInterface((InetAddress)paramT);
    }
    else if (paramChannelOption == ChannelOption.IP_MULTICAST_IF)
    {
      setNetworkInterface((NetworkInterface)paramT);
    }
    else if (paramChannelOption == ChannelOption.IP_MULTICAST_TTL)
    {
      setTimeToLive(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.IP_TOS)
    {
      setTrafficClass(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)
    {
      setActiveOnOpen(((Boolean)paramT).booleanValue());
    }
    else
    {
      if (paramChannelOption != UnixChannelOption.SO_REUSEPORT) {
        break label240;
      }
      setReusePort(((Boolean)paramT).booleanValue());
    }
    return true;
    label240:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public KQueueDatagramChannelConfig setRcvAllocTransportProvidesGuess(boolean paramBoolean)
  {
    super.setRcvAllocTransportProvidesGuess(paramBoolean);
    return this;
  }
  
  public KQueueDatagramChannelConfig setReceiveBufferSize(int paramInt)
  {
    try
    {
      ((KQueueDatagramChannel)this.channel).socket.setReceiveBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public KQueueDatagramChannelConfig setReuseAddress(boolean paramBoolean)
  {
    try
    {
      ((KQueueDatagramChannel)this.channel).socket.setReuseAddress(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueDatagramChannelConfig setReusePort(boolean paramBoolean)
  {
    try
    {
      ((KQueueDatagramChannel)this.channel).socket.setReusePort(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueDatagramChannelConfig setSendBufferSize(int paramInt)
  {
    try
    {
      ((KQueueDatagramChannel)this.channel).socket.setSendBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueDatagramChannelConfig setTimeToLive(int paramInt)
  {
    throw new UnsupportedOperationException("Multicast not supported");
  }
  
  public KQueueDatagramChannelConfig setTrafficClass(int paramInt)
  {
    try
    {
      ((KQueueDatagramChannel)this.channel).socket.setTrafficClass(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public KQueueDatagramChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public KQueueDatagramChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public KQueueDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public KQueueDatagramChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueDatagramChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */