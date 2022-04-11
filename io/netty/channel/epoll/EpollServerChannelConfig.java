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
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.util.Map;

public class EpollServerChannelConfig
  extends EpollChannelConfig
  implements ServerSocketChannelConfig
{
  private volatile int backlog = NetUtil.SOMAXCONN;
  private volatile int pendingFastOpenRequestsThreshold;
  
  EpollServerChannelConfig(AbstractEpollChannel paramAbstractEpollChannel)
  {
    super(paramAbstractEpollChannel);
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
    if (paramChannelOption == EpollChannelOption.TCP_FASTOPEN) {
      return Integer.valueOf(getTcpFastopen());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_RCVBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_BACKLOG, EpollChannelOption.TCP_FASTOPEN });
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = ((AbstractEpollChannel)this.channel).socket.getReceiveBufferSize();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getTcpFastopen()
  {
    return this.pendingFastOpenRequestsThreshold;
  }
  
  public boolean isReuseAddress()
  {
    try
    {
      boolean bool = ((AbstractEpollChannel)this.channel).socket.isReuseAddress();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollServerChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public EpollServerChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public EpollServerChannelConfig setBacklog(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "backlog");
    this.backlog = paramInt;
    return this;
  }
  
  public EpollServerChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public EpollServerChannelConfig setEpollMode(EpollMode paramEpollMode)
  {
    super.setEpollMode(paramEpollMode);
    return this;
  }
  
  @Deprecated
  public EpollServerChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public EpollServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
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
    else if (paramChannelOption == ChannelOption.SO_BACKLOG)
    {
      setBacklog(((Integer)paramT).intValue());
    }
    else
    {
      if (paramChannelOption != EpollChannelOption.TCP_FASTOPEN) {
        break label93;
      }
      setTcpFastopen(((Integer)paramT).intValue());
    }
    return true;
    label93:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public EpollServerChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    return this;
  }
  
  public EpollServerChannelConfig setReceiveBufferSize(int paramInt)
  {
    try
    {
      ((AbstractEpollChannel)this.channel).socket.setReceiveBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public EpollServerChannelConfig setReuseAddress(boolean paramBoolean)
  {
    try
    {
      ((AbstractEpollChannel)this.channel).socket.setReuseAddress(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollServerChannelConfig setTcpFastopen(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(this.pendingFastOpenRequestsThreshold, "pendingFastOpenRequestsThreshold");
    this.pendingFastOpenRequestsThreshold = paramInt;
    return this;
  }
  
  @Deprecated
  public EpollServerChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public EpollServerChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public EpollServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public EpollServerChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollServerChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */