package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Map;

public class DefaultDatagramChannelConfig
  extends DefaultChannelConfig
  implements DatagramChannelConfig
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultDatagramChannelConfig.class);
  private volatile boolean activeOnOpen;
  private final DatagramSocket javaSocket;
  
  public DefaultDatagramChannelConfig(DatagramChannel paramDatagramChannel, DatagramSocket paramDatagramSocket)
  {
    super(paramDatagramChannel, new FixedRecvByteBufAllocator(2048));
    this.javaSocket = ((DatagramSocket)ObjectUtil.checkNotNull(paramDatagramSocket, "javaSocket"));
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
  
  public InetAddress getInterface()
  {
    Object localObject = this.javaSocket;
    if ((localObject instanceof MulticastSocket)) {
      try
      {
        localObject = ((MulticastSocket)localObject).getInterface();
        return (InetAddress)localObject;
      }
      catch (SocketException localSocketException)
      {
        throw new ChannelException(localSocketException);
      }
    }
    throw new UnsupportedOperationException();
  }
  
  public NetworkInterface getNetworkInterface()
  {
    Object localObject = this.javaSocket;
    if ((localObject instanceof MulticastSocket)) {
      try
      {
        localObject = ((MulticastSocket)localObject).getNetworkInterface();
        return (NetworkInterface)localObject;
      }
      catch (SocketException localSocketException)
      {
        throw new ChannelException(localSocketException);
      }
    }
    throw new UnsupportedOperationException();
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
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_BROADCAST, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.IP_MULTICAST_LOOP_DISABLED, ChannelOption.IP_MULTICAST_ADDR, ChannelOption.IP_MULTICAST_IF, ChannelOption.IP_MULTICAST_TTL, ChannelOption.IP_TOS, ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION });
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = this.javaSocket.getReceiveBufferSize();
      return i;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public int getSendBufferSize()
  {
    try
    {
      int i = this.javaSocket.getSendBufferSize();
      return i;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public int getTimeToLive()
  {
    DatagramSocket localDatagramSocket = this.javaSocket;
    if ((localDatagramSocket instanceof MulticastSocket)) {
      try
      {
        int i = ((MulticastSocket)localDatagramSocket).getTimeToLive();
        return i;
      }
      catch (IOException localIOException)
      {
        throw new ChannelException(localIOException);
      }
    }
    throw new UnsupportedOperationException();
  }
  
  public int getTrafficClass()
  {
    try
    {
      int i = this.javaSocket.getTrafficClass();
      return i;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public boolean isBroadcast()
  {
    try
    {
      boolean bool = this.javaSocket.getBroadcast();
      return bool;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public boolean isLoopbackModeDisabled()
  {
    DatagramSocket localDatagramSocket = this.javaSocket;
    if ((localDatagramSocket instanceof MulticastSocket)) {
      try
      {
        boolean bool = ((MulticastSocket)localDatagramSocket).getLoopbackMode();
        return bool;
      }
      catch (SocketException localSocketException)
      {
        throw new ChannelException(localSocketException);
      }
    }
    throw new UnsupportedOperationException();
  }
  
  public boolean isReuseAddress()
  {
    try
    {
      boolean bool = this.javaSocket.getReuseAddress();
      return bool;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  protected final DatagramSocket javaSocket()
  {
    return this.javaSocket;
  }
  
  public DatagramChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public DatagramChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public DatagramChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public DatagramChannelConfig setBroadcast(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if ((!this.javaSocket.getLocalAddress().isAnyLocalAddress()) && (!PlatformDependent.isWindows()) && (!PlatformDependent.maybeSuperUser()))
      {
        InternalLogger localInternalLogger = logger;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; setting the SO_BROADCAST flag anyway as requested on the socket which is bound to ");
        localStringBuilder.append(this.javaSocket.getLocalSocketAddress());
        localStringBuilder.append('.');
        localInternalLogger.warn(localStringBuilder.toString());
      }
      this.javaSocket.setBroadcast(paramBoolean);
      return this;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public DatagramChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public DatagramChannelConfig setInterface(InetAddress paramInetAddress)
  {
    DatagramSocket localDatagramSocket = this.javaSocket;
    if ((localDatagramSocket instanceof MulticastSocket)) {
      try
      {
        ((MulticastSocket)localDatagramSocket).setInterface(paramInetAddress);
        return this;
      }
      catch (SocketException paramInetAddress)
      {
        throw new ChannelException(paramInetAddress);
      }
    }
    throw new UnsupportedOperationException();
  }
  
  public DatagramChannelConfig setLoopbackModeDisabled(boolean paramBoolean)
  {
    DatagramSocket localDatagramSocket = this.javaSocket;
    if ((localDatagramSocket instanceof MulticastSocket)) {
      try
      {
        ((MulticastSocket)localDatagramSocket).setLoopbackMode(paramBoolean);
        return this;
      }
      catch (SocketException localSocketException)
      {
        throw new ChannelException(localSocketException);
      }
    }
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public DatagramChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public DatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public DatagramChannelConfig setNetworkInterface(NetworkInterface paramNetworkInterface)
  {
    DatagramSocket localDatagramSocket = this.javaSocket;
    if ((localDatagramSocket instanceof MulticastSocket)) {
      try
      {
        ((MulticastSocket)localDatagramSocket).setNetworkInterface(paramNetworkInterface);
        return this;
      }
      catch (SocketException paramNetworkInterface)
      {
        throw new ChannelException(paramNetworkInterface);
      }
    }
    throw new UnsupportedOperationException();
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
    else
    {
      if (paramChannelOption != ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
        break label218;
      }
      setActiveOnOpen(((Boolean)paramT).booleanValue());
    }
    return true;
    label218:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public DatagramChannelConfig setReceiveBufferSize(int paramInt)
  {
    try
    {
      this.javaSocket.setReceiveBufferSize(paramInt);
      return this;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public DatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public DatagramChannelConfig setReuseAddress(boolean paramBoolean)
  {
    try
    {
      this.javaSocket.setReuseAddress(paramBoolean);
      return this;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public DatagramChannelConfig setSendBufferSize(int paramInt)
  {
    try
    {
      this.javaSocket.setSendBufferSize(paramInt);
      return this;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public DatagramChannelConfig setTimeToLive(int paramInt)
  {
    DatagramSocket localDatagramSocket = this.javaSocket;
    if ((localDatagramSocket instanceof MulticastSocket)) {
      try
      {
        ((MulticastSocket)localDatagramSocket).setTimeToLive(paramInt);
        return this;
      }
      catch (IOException localIOException)
      {
        throw new ChannelException(localIOException);
      }
    }
    throw new UnsupportedOperationException();
  }
  
  public DatagramChannelConfig setTrafficClass(int paramInt)
  {
    try
    {
      this.javaSocket.setTrafficClass(paramInt);
      return this;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public DatagramChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public DatagramChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public DatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public DatagramChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\DefaultDatagramChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */