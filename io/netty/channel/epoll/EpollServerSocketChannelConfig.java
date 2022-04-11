package io.netty.channel.epoll;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannelOption;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

public final class EpollServerSocketChannelConfig
  extends EpollServerChannelConfig
  implements ServerSocketChannelConfig
{
  EpollServerSocketChannelConfig(EpollServerSocketChannel paramEpollServerSocketChannel)
  {
    super(paramEpollServerSocketChannel);
    setReuseAddress(true);
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == UnixChannelOption.SO_REUSEPORT) {
      return Boolean.valueOf(isReusePort());
    }
    if (paramChannelOption == EpollChannelOption.IP_FREEBIND) {
      return Boolean.valueOf(isFreeBind());
    }
    if (paramChannelOption == EpollChannelOption.IP_TRANSPARENT) {
      return Boolean.valueOf(isIpTransparent());
    }
    if (paramChannelOption == EpollChannelOption.TCP_DEFER_ACCEPT) {
      return Integer.valueOf(getTcpDeferAccept());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { UnixChannelOption.SO_REUSEPORT, EpollChannelOption.IP_FREEBIND, EpollChannelOption.IP_TRANSPARENT, EpollChannelOption.TCP_DEFER_ACCEPT });
  }
  
  public int getTcpDeferAccept()
  {
    try
    {
      int i = ((EpollServerSocketChannel)this.channel).socket.getTcpDeferAccept();
      return i;
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
      boolean bool = ((EpollServerSocketChannel)this.channel).socket.isIpFreeBind();
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
      boolean bool = ((EpollServerSocketChannel)this.channel).socket.isIpTransparent();
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
      boolean bool = ((EpollServerSocketChannel)this.channel).socket.isReusePort();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollServerSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public EpollServerSocketChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public EpollServerSocketChannelConfig setBacklog(int paramInt)
  {
    super.setBacklog(paramInt);
    return this;
  }
  
  public EpollServerSocketChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public EpollServerSocketChannelConfig setFreeBind(boolean paramBoolean)
  {
    try
    {
      ((EpollServerSocketChannel)this.channel).socket.setIpFreeBind(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollServerSocketChannelConfig setIpTransparent(boolean paramBoolean)
  {
    try
    {
      ((EpollServerSocketChannel)this.channel).socket.setIpTransparent(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public EpollServerSocketChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public EpollServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == UnixChannelOption.SO_REUSEPORT)
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
    else if (paramChannelOption == EpollChannelOption.TCP_MD5SIG)
    {
      setTcpMd5Sig((Map)paramT);
    }
    else
    {
      if (paramChannelOption != EpollChannelOption.TCP_DEFER_ACCEPT) {
        break label112;
      }
      setTcpDeferAccept(((Integer)paramT).intValue());
    }
    return true;
    label112:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public EpollServerSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    return this;
  }
  
  public EpollServerSocketChannelConfig setReceiveBufferSize(int paramInt)
  {
    super.setReceiveBufferSize(paramInt);
    return this;
  }
  
  public EpollServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public EpollServerSocketChannelConfig setReuseAddress(boolean paramBoolean)
  {
    super.setReuseAddress(paramBoolean);
    return this;
  }
  
  public EpollServerSocketChannelConfig setReusePort(boolean paramBoolean)
  {
    try
    {
      ((EpollServerSocketChannel)this.channel).socket.setReusePort(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollServerSocketChannelConfig setTcpDeferAccept(int paramInt)
  {
    try
    {
      ((EpollServerSocketChannel)this.channel).socket.setTcpDeferAccept(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollServerSocketChannelConfig setTcpMd5Sig(Map<InetAddress, byte[]> paramMap)
  {
    try
    {
      ((EpollServerSocketChannel)this.channel).setTcpMd5Sig(paramMap);
      return this;
    }
    catch (IOException paramMap)
    {
      throw new ChannelException(paramMap);
    }
  }
  
  @Deprecated
  public EpollServerSocketChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public EpollServerSocketChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public EpollServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public EpollServerSocketChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollServerSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */