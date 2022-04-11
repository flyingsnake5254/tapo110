package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

public class DefaultSocketChannelConfig
  extends DefaultChannelConfig
  implements SocketChannelConfig
{
  private volatile boolean allowHalfClosure;
  protected final Socket javaSocket;
  
  public DefaultSocketChannelConfig(SocketChannel paramSocketChannel, Socket paramSocket)
  {
    super(paramSocketChannel);
    this.javaSocket = ((Socket)ObjectUtil.checkNotNull(paramSocket, "javaSocket"));
    if (PlatformDependent.canEnableTcpNoDelayByDefault()) {}
    try
    {
      setTcpNoDelay(true);
      return;
    }
    catch (Exception paramSocketChannel)
    {
      for (;;) {}
    }
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == ChannelOption.SO_RCVBUF) {
      return Integer.valueOf(getReceiveBufferSize());
    }
    if (paramChannelOption == ChannelOption.SO_SNDBUF) {
      return Integer.valueOf(getSendBufferSize());
    }
    if (paramChannelOption == ChannelOption.TCP_NODELAY) {
      return Boolean.valueOf(isTcpNoDelay());
    }
    if (paramChannelOption == ChannelOption.SO_KEEPALIVE) {
      return Boolean.valueOf(isKeepAlive());
    }
    if (paramChannelOption == ChannelOption.SO_REUSEADDR) {
      return Boolean.valueOf(isReuseAddress());
    }
    if (paramChannelOption == ChannelOption.SO_LINGER) {
      return Integer.valueOf(getSoLinger());
    }
    if (paramChannelOption == ChannelOption.IP_TOS) {
      return Integer.valueOf(getTrafficClass());
    }
    if (paramChannelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
      return Boolean.valueOf(isAllowHalfClosure());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE });
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
  
  public int getSoLinger()
  {
    try
    {
      int i = this.javaSocket.getSoLinger();
      return i;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
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
  
  public boolean isAllowHalfClosure()
  {
    return this.allowHalfClosure;
  }
  
  public boolean isKeepAlive()
  {
    try
    {
      boolean bool = this.javaSocket.getKeepAlive();
      return bool;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
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
  
  public boolean isTcpNoDelay()
  {
    try
    {
      boolean bool = this.javaSocket.getTcpNoDelay();
      return bool;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public SocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public SocketChannelConfig setAllowHalfClosure(boolean paramBoolean)
  {
    this.allowHalfClosure = paramBoolean;
    return this;
  }
  
  public SocketChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public SocketChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public SocketChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public SocketChannelConfig setKeepAlive(boolean paramBoolean)
  {
    try
    {
      this.javaSocket.setKeepAlive(paramBoolean);
      return this;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  @Deprecated
  public SocketChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == ChannelOption.SO_RCVBUF)
    {
      setReceiveBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.SO_SNDBUF)
    {
      setSendBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.TCP_NODELAY)
    {
      setTcpNoDelay(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.SO_KEEPALIVE)
    {
      setKeepAlive(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.SO_REUSEADDR)
    {
      setReuseAddress(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.SO_LINGER)
    {
      setSoLinger(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.IP_TOS)
    {
      setTrafficClass(((Integer)paramT).intValue());
    }
    else
    {
      if (paramChannelOption != ChannelOption.ALLOW_HALF_CLOSURE) {
        break label181;
      }
      setAllowHalfClosure(((Boolean)paramT).booleanValue());
    }
    return true;
    label181:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public SocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    this.javaSocket.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
    return this;
  }
  
  public SocketChannelConfig setReceiveBufferSize(int paramInt)
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
  
  public SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public SocketChannelConfig setReuseAddress(boolean paramBoolean)
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
  
  public SocketChannelConfig setSendBufferSize(int paramInt)
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
  
  public SocketChannelConfig setSoLinger(int paramInt)
  {
    if (paramInt < 0) {}
    try
    {
      this.javaSocket.setSoLinger(false, 0);
      break label25;
      this.javaSocket.setSoLinger(true, paramInt);
      label25:
      return this;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public SocketChannelConfig setTcpNoDelay(boolean paramBoolean)
  {
    try
    {
      this.javaSocket.setTcpNoDelay(paramBoolean);
      return this;
    }
    catch (SocketException localSocketException)
    {
      throw new ChannelException(localSocketException);
    }
  }
  
  public SocketChannelConfig setTrafficClass(int paramInt)
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
  
  public SocketChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public SocketChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public SocketChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\DefaultSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */