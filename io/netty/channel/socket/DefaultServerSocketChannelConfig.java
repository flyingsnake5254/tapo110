package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Map;

public class DefaultServerSocketChannelConfig
  extends DefaultChannelConfig
  implements ServerSocketChannelConfig
{
  private volatile int backlog = NetUtil.SOMAXCONN;
  protected final ServerSocket javaSocket;
  
  public DefaultServerSocketChannelConfig(ServerSocketChannel paramServerSocketChannel, ServerSocket paramServerSocket)
  {
    super(paramServerSocketChannel);
    this.javaSocket = ((ServerSocket)ObjectUtil.checkNotNull(paramServerSocket, "javaSocket"));
  }
  
  public int getBacklog()
  {
    return this.backlog;
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == ChannelOption.SO_RCVBUF) {
      return Integer.valueOf(getReceiveBufferSize());
    }
    if (paramChannelOption == ChannelOption.SO_REUSEADDR) {
      return Boolean.valueOf(isReuseAddress());
    }
    if (paramChannelOption == ChannelOption.SO_BACKLOG) {
      return Integer.valueOf(getBacklog());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_RCVBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_BACKLOG });
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
  
  public ServerSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public ServerSocketChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public ServerSocketChannelConfig setBacklog(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "backlog");
    this.backlog = paramInt;
    return this;
  }
  
  public ServerSocketChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  @Deprecated
  public ServerSocketChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public ServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
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
    else if (paramChannelOption == ChannelOption.SO_REUSEADDR)
    {
      setReuseAddress(((Boolean)paramT).booleanValue());
    }
    else
    {
      if (paramChannelOption != ChannelOption.SO_BACKLOG) {
        break label71;
      }
      setBacklog(((Integer)paramT).intValue());
    }
    return true;
    label71:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public ServerSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    this.javaSocket.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
    return this;
  }
  
  public ServerSocketChannelConfig setReceiveBufferSize(int paramInt)
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
  
  public ServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public ServerSocketChannelConfig setReuseAddress(boolean paramBoolean)
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
  
  public ServerSocketChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public ServerSocketChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public ServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public ServerSocketChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\DefaultServerSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */