package io.netty.channel.kqueue;

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

public class KQueueServerChannelConfig
  extends KQueueChannelConfig
  implements ServerSocketChannelConfig
{
  private volatile int backlog = NetUtil.SOMAXCONN;
  
  KQueueServerChannelConfig(AbstractKQueueChannel paramAbstractKQueueChannel)
  {
    super(paramAbstractKQueueChannel);
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
      int i = ((AbstractKQueueChannel)this.channel).socket.getReceiveBufferSize();
      return i;
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
      boolean bool = ((AbstractKQueueChannel)this.channel).socket.isReuseAddress();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueServerChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public KQueueServerChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public KQueueServerChannelConfig setBacklog(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "backlog");
    this.backlog = paramInt;
    return this;
  }
  
  public KQueueServerChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  @Deprecated
  public KQueueServerChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public KQueueServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
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
  
  public KQueueServerChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    return this;
  }
  
  public KQueueServerChannelConfig setRcvAllocTransportProvidesGuess(boolean paramBoolean)
  {
    super.setRcvAllocTransportProvidesGuess(paramBoolean);
    return this;
  }
  
  public KQueueServerChannelConfig setReceiveBufferSize(int paramInt)
  {
    try
    {
      ((AbstractKQueueChannel)this.channel).socket.setReceiveBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public KQueueServerChannelConfig setReuseAddress(boolean paramBoolean)
  {
    try
    {
      ((AbstractKQueueChannel)this.channel).socket.setReuseAddress(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public KQueueServerChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public KQueueServerChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public KQueueServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public KQueueServerChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueServerChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */