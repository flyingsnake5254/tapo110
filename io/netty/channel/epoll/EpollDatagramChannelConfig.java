package io.netty.channel.epoll;

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
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;

public final class EpollDatagramChannelConfig
  extends EpollChannelConfig
  implements DatagramChannelConfig
{
  private static final RecvByteBufAllocator DEFAULT_RCVBUF_ALLOCATOR = new FixedRecvByteBufAllocator(2048);
  private boolean activeOnOpen;
  private volatile int maxDatagramSize;
  
  EpollDatagramChannelConfig(EpollDatagramChannel paramEpollDatagramChannel)
  {
    super(paramEpollDatagramChannel);
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
    try
    {
      InetAddress localInetAddress = ((EpollDatagramChannel)this.channel).socket.getInterface();
      return localInetAddress;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getMaxDatagramPayloadSize()
  {
    return this.maxDatagramSize;
  }
  
  public NetworkInterface getNetworkInterface()
  {
    try
    {
      NetworkInterface localNetworkInterface = ((EpollDatagramChannel)this.channel).socket.getNetworkInterface();
      return localNetworkInterface;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
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
    if (paramChannelOption == EpollChannelOption.IP_TRANSPARENT) {
      return Boolean.valueOf(isIpTransparent());
    }
    if (paramChannelOption == EpollChannelOption.IP_FREEBIND) {
      return Boolean.valueOf(isFreeBind());
    }
    if (paramChannelOption == EpollChannelOption.IP_RECVORIGDSTADDR) {
      return Boolean.valueOf(isIpRecvOrigDestAddr());
    }
    if (paramChannelOption == EpollChannelOption.MAX_DATAGRAM_PAYLOAD_SIZE) {
      return Integer.valueOf(getMaxDatagramPayloadSize());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_BROADCAST, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.IP_MULTICAST_LOOP_DISABLED, ChannelOption.IP_MULTICAST_ADDR, ChannelOption.IP_MULTICAST_IF, ChannelOption.IP_MULTICAST_TTL, ChannelOption.IP_TOS, ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, UnixChannelOption.SO_REUSEPORT, EpollChannelOption.IP_FREEBIND, EpollChannelOption.IP_TRANSPARENT, EpollChannelOption.IP_RECVORIGDSTADDR, EpollChannelOption.MAX_DATAGRAM_PAYLOAD_SIZE });
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = ((EpollDatagramChannel)this.channel).socket.getReceiveBufferSize();
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
      int i = ((EpollDatagramChannel)this.channel).socket.getSendBufferSize();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getTimeToLive()
  {
    try
    {
      int i = ((EpollDatagramChannel)this.channel).socket.getTimeToLive();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getTrafficClass()
  {
    try
    {
      int i = ((EpollDatagramChannel)this.channel).socket.getTrafficClass();
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
      boolean bool = ((EpollDatagramChannel)this.channel).socket.isBroadcast();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isFreeBind()
  {
    try
    {
      boolean bool = ((EpollDatagramChannel)this.channel).socket.isIpFreeBind();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isIpRecvOrigDestAddr()
  {
    try
    {
      boolean bool = ((EpollDatagramChannel)this.channel).socket.isIpRecvOrigDestAddr();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isIpTransparent()
  {
    try
    {
      boolean bool = ((EpollDatagramChannel)this.channel).socket.isIpTransparent();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isLoopbackModeDisabled()
  {
    try
    {
      boolean bool = ((EpollDatagramChannel)this.channel).socket.isLoopbackModeDisabled();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isReuseAddress()
  {
    try
    {
      boolean bool = ((EpollDatagramChannel)this.channel).socket.isReuseAddress();
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
      boolean bool = ((EpollDatagramChannel)this.channel).socket.isReusePort();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public EpollDatagramChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public EpollDatagramChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public EpollDatagramChannelConfig setBroadcast(boolean paramBoolean)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setBroadcast(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public EpollDatagramChannelConfig setEpollMode(EpollMode paramEpollMode)
  {
    super.setEpollMode(paramEpollMode);
    return this;
  }
  
  public EpollDatagramChannelConfig setFreeBind(boolean paramBoolean)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setIpFreeBind(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setInterface(InetAddress paramInetAddress)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setInterface(paramInetAddress);
      return this;
    }
    catch (IOException paramInetAddress)
    {
      throw new ChannelException(paramInetAddress);
    }
  }
  
  public EpollDatagramChannelConfig setIpRecvOrigDestAddr(boolean paramBoolean)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setIpRecvOrigDestAddr(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setIpTransparent(boolean paramBoolean)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setIpTransparent(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public DatagramChannelConfig setLoopbackModeDisabled(boolean paramBoolean)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setLoopbackModeDisabled(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setMaxDatagramPayloadSize(int paramInt)
  {
    this.maxDatagramSize = ObjectUtil.checkPositiveOrZero(paramInt, "maxDatagramSize");
    return this;
  }
  
  @Deprecated
  public EpollDatagramChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public EpollDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public EpollDatagramChannelConfig setNetworkInterface(NetworkInterface paramNetworkInterface)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setNetworkInterface(paramNetworkInterface);
      return this;
    }
    catch (IOException paramNetworkInterface)
    {
      throw new ChannelException(paramNetworkInterface);
    }
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
    else if (paramChannelOption == UnixChannelOption.SO_REUSEPORT)
    {
      setReusePort(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == EpollChannelOption.IP_FREEBIND)
    {
      setFreeBind(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == EpollChannelOption.IP_TRANSPARENT)
    {
      setIpTransparent(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == EpollChannelOption.IP_RECVORIGDSTADDR)
    {
      setIpRecvOrigDestAddr(((Boolean)paramT).booleanValue());
    }
    else
    {
      if (paramChannelOption != EpollChannelOption.MAX_DATAGRAM_PAYLOAD_SIZE) {
        break label328;
      }
      setMaxDatagramPayloadSize(((Integer)paramT).intValue());
    }
    return true;
    label328:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public EpollDatagramChannelConfig setReceiveBufferSize(int paramInt)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setReceiveBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public EpollDatagramChannelConfig setReuseAddress(boolean paramBoolean)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setReuseAddress(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setReusePort(boolean paramBoolean)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setReusePort(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setSendBufferSize(int paramInt)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setSendBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setTimeToLive(int paramInt)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setTimeToLive(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollDatagramChannelConfig setTrafficClass(int paramInt)
  {
    try
    {
      ((EpollDatagramChannel)this.channel).socket.setTrafficClass(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public EpollDatagramChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public EpollDatagramChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public EpollDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public EpollDatagramChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollDatagramChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */