package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator.ExtendedHandle;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.unix.Limits;
import java.util.Map;

public class KQueueChannelConfig
  extends DefaultChannelConfig
{
  private volatile long maxBytesPerGatheringWrite = Limits.SSIZE_MAX;
  private volatile boolean transportProvidesGuess;
  
  KQueueChannelConfig(AbstractKQueueChannel paramAbstractKQueueChannel)
  {
    super(paramAbstractKQueueChannel);
  }
  
  protected final void autoReadCleared()
  {
    ((AbstractKQueueChannel)this.channel).clearReadFilter();
  }
  
  final long getMaxBytesPerGatheringWrite()
  {
    return this.maxBytesPerGatheringWrite;
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS) {
      return Boolean.valueOf(getRcvAllocTransportProvidesGuess());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS });
  }
  
  public boolean getRcvAllocTransportProvidesGuess()
  {
    return this.transportProvidesGuess;
  }
  
  public KQueueChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public KQueueChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public KQueueChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  final void setMaxBytesPerGatheringWrite(long paramLong)
  {
    this.maxBytesPerGatheringWrite = Math.min(Limits.SSIZE_MAX, paramLong);
  }
  
  @Deprecated
  public KQueueChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public KQueueChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS)
    {
      setRcvAllocTransportProvidesGuess(((Boolean)paramT).booleanValue());
      return true;
    }
    return super.setOption(paramChannelOption, paramT);
  }
  
  public KQueueChannelConfig setRcvAllocTransportProvidesGuess(boolean paramBoolean)
  {
    this.transportProvidesGuess = paramBoolean;
    return this;
  }
  
  public KQueueChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
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
  public KQueueChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public KQueueChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public KQueueChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public KQueueChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */