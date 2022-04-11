package io.netty.channel.epoll;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator.ExtendedHandle;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.unix.Limits;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.util.Map;

public class EpollChannelConfig
  extends DefaultChannelConfig
{
  private volatile long maxBytesPerGatheringWrite = Limits.SSIZE_MAX;
  
  EpollChannelConfig(AbstractEpollChannel paramAbstractEpollChannel)
  {
    super(paramAbstractEpollChannel);
  }
  
  private void checkChannelNotRegistered()
  {
    if (!this.channel.isRegistered()) {
      return;
    }
    throw new IllegalStateException("EpollMode can only be changed before channel is registered");
  }
  
  protected final void autoReadCleared()
  {
    ((AbstractEpollChannel)this.channel).clearEpollIn();
  }
  
  public EpollMode getEpollMode()
  {
    EpollMode localEpollMode;
    if (((AbstractEpollChannel)this.channel).isFlagSet(Native.EPOLLET)) {
      localEpollMode = EpollMode.EDGE_TRIGGERED;
    } else {
      localEpollMode = EpollMode.LEVEL_TRIGGERED;
    }
    return localEpollMode;
  }
  
  final long getMaxBytesPerGatheringWrite()
  {
    return this.maxBytesPerGatheringWrite;
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == EpollChannelOption.EPOLL_MODE) {
      return getEpollMode();
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { EpollChannelOption.EPOLL_MODE });
  }
  
  public EpollChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public EpollChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public EpollChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public EpollChannelConfig setEpollMode(EpollMode paramEpollMode)
  {
    ObjectUtil.checkNotNull(paramEpollMode, "mode");
    try
    {
      int i = 1.$SwitchMap$io$netty$channel$epoll$EpollMode[paramEpollMode.ordinal()];
      if (i != 1)
      {
        if (i == 2)
        {
          checkChannelNotRegistered();
          ((AbstractEpollChannel)this.channel).clearFlag(Native.EPOLLET);
        }
        else
        {
          paramEpollMode = new java/lang/Error;
          paramEpollMode.<init>();
          throw paramEpollMode;
        }
      }
      else
      {
        checkChannelNotRegistered();
        ((AbstractEpollChannel)this.channel).setFlag(Native.EPOLLET);
      }
      return this;
    }
    catch (IOException paramEpollMode)
    {
      throw new ChannelException(paramEpollMode);
    }
  }
  
  final void setMaxBytesPerGatheringWrite(long paramLong)
  {
    this.maxBytesPerGatheringWrite = paramLong;
  }
  
  @Deprecated
  public EpollChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public EpollChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == EpollChannelOption.EPOLL_MODE)
    {
      setEpollMode((EpollMode)paramT);
      return true;
    }
    return super.setOption(paramChannelOption, paramT);
  }
  
  public EpollChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    if ((paramRecvByteBufAllocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle))
    {
      super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
      return this;
    }
    paramRecvByteBufAllocator = new StringBuilder();
    paramRecvByteBufAllocator.append("allocator.newHandle() must return an object of type: ");
    paramRecvByteBufAllocator.append(RecvByteBufAllocator.ExtendedHandle.class);
    throw new IllegalArgumentException(paramRecvByteBufAllocator.toString());
  }
  
  @Deprecated
  public EpollChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public EpollChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public EpollChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public EpollChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */