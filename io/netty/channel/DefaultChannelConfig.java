package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultChannelConfig
  implements ChannelConfig
{
  private static final AtomicIntegerFieldUpdater<DefaultChannelConfig> AUTOREAD_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DefaultChannelConfig.class, "autoRead");
  private static final int DEFAULT_CONNECT_TIMEOUT = 30000;
  private static final MessageSizeEstimator DEFAULT_MSG_SIZE_ESTIMATOR = DefaultMessageSizeEstimator.DEFAULT;
  private static final AtomicReferenceFieldUpdater<DefaultChannelConfig, WriteBufferWaterMark> WATERMARK_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultChannelConfig.class, WriteBufferWaterMark.class, "writeBufferWaterMark");
  private volatile ByteBufAllocator allocator = ByteBufAllocator.DEFAULT;
  private volatile boolean autoClose = true;
  private volatile int autoRead = 1;
  protected final Channel channel;
  private volatile int connectTimeoutMillis = 30000;
  private volatile MessageSizeEstimator msgSizeEstimator = DEFAULT_MSG_SIZE_ESTIMATOR;
  private volatile boolean pinEventExecutor = true;
  private volatile RecvByteBufAllocator rcvBufAllocator;
  private volatile WriteBufferWaterMark writeBufferWaterMark = WriteBufferWaterMark.DEFAULT;
  private volatile int writeSpinCount = 16;
  
  public DefaultChannelConfig(Channel paramChannel)
  {
    this(paramChannel, new AdaptiveRecvByteBufAllocator());
  }
  
  protected DefaultChannelConfig(Channel paramChannel, RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    setRecvByteBufAllocator(paramRecvByteBufAllocator, paramChannel.metadata());
    this.channel = paramChannel;
  }
  
  private boolean getPinEventExecutorPerGroup()
  {
    return this.pinEventExecutor;
  }
  
  private ChannelConfig setPinEventExecutorPerGroup(boolean paramBoolean)
  {
    this.pinEventExecutor = paramBoolean;
    return this;
  }
  
  private void setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator, ChannelMetadata paramChannelMetadata)
  {
    if ((paramRecvByteBufAllocator instanceof MaxMessagesRecvByteBufAllocator)) {
      ((MaxMessagesRecvByteBufAllocator)paramRecvByteBufAllocator).maxMessagesPerRead(paramChannelMetadata.defaultMaxMessagesPerRead());
    } else {
      Objects.requireNonNull(paramRecvByteBufAllocator, "allocator");
    }
    setRecvByteBufAllocator(paramRecvByteBufAllocator);
  }
  
  protected void autoReadCleared() {}
  
  public ByteBufAllocator getAllocator()
  {
    return this.allocator;
  }
  
  public int getConnectTimeoutMillis()
  {
    return this.connectTimeoutMillis;
  }
  
  @Deprecated
  public int getMaxMessagesPerRead()
  {
    try
    {
      int i = ((MaxMessagesRecvByteBufAllocator)getRecvByteBufAllocator()).maxMessagesPerRead();
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", localClassCastException);
    }
  }
  
  public MessageSizeEstimator getMessageSizeEstimator()
  {
    return this.msgSizeEstimator;
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    ObjectUtil.checkNotNull(paramChannelOption, "option");
    if (paramChannelOption == ChannelOption.CONNECT_TIMEOUT_MILLIS) {
      return Integer.valueOf(getConnectTimeoutMillis());
    }
    if (paramChannelOption == ChannelOption.MAX_MESSAGES_PER_READ) {
      return Integer.valueOf(getMaxMessagesPerRead());
    }
    if (paramChannelOption == ChannelOption.WRITE_SPIN_COUNT) {
      return Integer.valueOf(getWriteSpinCount());
    }
    if (paramChannelOption == ChannelOption.ALLOCATOR) {
      return getAllocator();
    }
    if (paramChannelOption == ChannelOption.RCVBUF_ALLOCATOR) {
      return getRecvByteBufAllocator();
    }
    if (paramChannelOption == ChannelOption.AUTO_READ) {
      return Boolean.valueOf(isAutoRead());
    }
    if (paramChannelOption == ChannelOption.AUTO_CLOSE) {
      return Boolean.valueOf(isAutoClose());
    }
    if (paramChannelOption == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK) {
      return Integer.valueOf(getWriteBufferHighWaterMark());
    }
    if (paramChannelOption == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK) {
      return Integer.valueOf(getWriteBufferLowWaterMark());
    }
    if (paramChannelOption == ChannelOption.WRITE_BUFFER_WATER_MARK) {
      return getWriteBufferWaterMark();
    }
    if (paramChannelOption == ChannelOption.MESSAGE_SIZE_ESTIMATOR) {
      return getMessageSizeEstimator();
    }
    if (paramChannelOption == ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
      return Boolean.valueOf(getPinEventExecutorPerGroup());
    }
    return null;
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(null, new ChannelOption[] { ChannelOption.CONNECT_TIMEOUT_MILLIS, ChannelOption.MAX_MESSAGES_PER_READ, ChannelOption.WRITE_SPIN_COUNT, ChannelOption.ALLOCATOR, ChannelOption.AUTO_READ, ChannelOption.AUTO_CLOSE, ChannelOption.RCVBUF_ALLOCATOR, ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK, ChannelOption.WRITE_BUFFER_LOW_WATER_MARK, ChannelOption.WRITE_BUFFER_WATER_MARK, ChannelOption.MESSAGE_SIZE_ESTIMATOR, ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP });
  }
  
  protected Map<ChannelOption<?>, Object> getOptions(Map<ChannelOption<?>, Object> paramMap, ChannelOption<?>... paramVarArgs)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new IdentityHashMap();
    }
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      paramMap = paramVarArgs[j];
      ((Map)localObject).put(paramMap, getOption(paramMap));
    }
    return (Map<ChannelOption<?>, Object>)localObject;
  }
  
  public <T extends RecvByteBufAllocator> T getRecvByteBufAllocator()
  {
    return this.rcvBufAllocator;
  }
  
  public int getWriteBufferHighWaterMark()
  {
    return this.writeBufferWaterMark.high();
  }
  
  public int getWriteBufferLowWaterMark()
  {
    return this.writeBufferWaterMark.low();
  }
  
  public WriteBufferWaterMark getWriteBufferWaterMark()
  {
    return this.writeBufferWaterMark;
  }
  
  public int getWriteSpinCount()
  {
    return this.writeSpinCount;
  }
  
  public boolean isAutoClose()
  {
    return this.autoClose;
  }
  
  public boolean isAutoRead()
  {
    int i = this.autoRead;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public ChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    this.allocator = ((ByteBufAllocator)ObjectUtil.checkNotNull(paramByteBufAllocator, "allocator"));
    return this;
  }
  
  public ChannelConfig setAutoClose(boolean paramBoolean)
  {
    this.autoClose = paramBoolean;
    return this;
  }
  
  public ChannelConfig setAutoRead(boolean paramBoolean)
  {
    int i = AUTOREAD_UPDATER.getAndSet(this, paramBoolean);
    int j = 1;
    if (i != 1) {
      j = 0;
    }
    if ((paramBoolean) && (j == 0)) {
      this.channel.read();
    } else if ((!paramBoolean) && (j != 0)) {
      autoReadCleared();
    }
    return this;
  }
  
  public ChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "connectTimeoutMillis");
    this.connectTimeoutMillis = paramInt;
    return this;
  }
  
  @Deprecated
  public ChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    try
    {
      ((MaxMessagesRecvByteBufAllocator)getRecvByteBufAllocator()).maxMessagesPerRead(paramInt);
      return this;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", localClassCastException);
    }
  }
  
  public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    this.msgSizeEstimator = ((MessageSizeEstimator)ObjectUtil.checkNotNull(paramMessageSizeEstimator, "estimator"));
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == ChannelOption.CONNECT_TIMEOUT_MILLIS)
    {
      setConnectTimeoutMillis(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.MAX_MESSAGES_PER_READ)
    {
      setMaxMessagesPerRead(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.WRITE_SPIN_COUNT)
    {
      setWriteSpinCount(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.ALLOCATOR)
    {
      setAllocator((ByteBufAllocator)paramT);
    }
    else if (paramChannelOption == ChannelOption.RCVBUF_ALLOCATOR)
    {
      setRecvByteBufAllocator((RecvByteBufAllocator)paramT);
    }
    else if (paramChannelOption == ChannelOption.AUTO_READ)
    {
      setAutoRead(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.AUTO_CLOSE)
    {
      setAutoClose(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK)
    {
      setWriteBufferHighWaterMark(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.WRITE_BUFFER_LOW_WATER_MARK)
    {
      setWriteBufferLowWaterMark(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.WRITE_BUFFER_WATER_MARK)
    {
      setWriteBufferWaterMark((WriteBufferWaterMark)paramT);
    }
    else if (paramChannelOption == ChannelOption.MESSAGE_SIZE_ESTIMATOR)
    {
      setMessageSizeEstimator((MessageSizeEstimator)paramT);
    }
    else
    {
      if (paramChannelOption != ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP) {
        break label257;
      }
      setPinEventExecutorPerGroup(((Boolean)paramT).booleanValue());
    }
    return true;
    label257:
    return false;
  }
  
  public boolean setOptions(Map<ChannelOption<?>, ?> paramMap)
  {
    ObjectUtil.checkNotNull(paramMap, "options");
    paramMap = paramMap.entrySet().iterator();
    boolean bool = true;
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!setOption((ChannelOption)localEntry.getKey(), localEntry.getValue())) {
        bool = false;
      }
    }
    return bool;
  }
  
  public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    this.rcvBufAllocator = ((RecvByteBufAllocator)ObjectUtil.checkNotNull(paramRecvByteBufAllocator, "allocator"));
    return this;
  }
  
  public ChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "writeBufferHighWaterMark");
    WriteBufferWaterMark localWriteBufferWaterMark;
    do
    {
      localWriteBufferWaterMark = this.writeBufferWaterMark;
      if (paramInt < localWriteBufferWaterMark.low()) {
        break;
      }
    } while (!WATERMARK_UPDATER.compareAndSet(this, localWriteBufferWaterMark, new WriteBufferWaterMark(localWriteBufferWaterMark.low(), paramInt, false)));
    return this;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("writeBufferHighWaterMark cannot be less than writeBufferLowWaterMark (");
    localStringBuilder.append(localWriteBufferWaterMark.low());
    localStringBuilder.append("): ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "writeBufferLowWaterMark");
    WriteBufferWaterMark localWriteBufferWaterMark;
    do
    {
      localWriteBufferWaterMark = this.writeBufferWaterMark;
      if (paramInt > localWriteBufferWaterMark.high()) {
        break;
      }
    } while (!WATERMARK_UPDATER.compareAndSet(this, localWriteBufferWaterMark, new WriteBufferWaterMark(paramInt, localWriteBufferWaterMark.high(), false)));
    return this;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark (");
    localStringBuilder.append(localWriteBufferWaterMark.high());
    localStringBuilder.append("): ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    this.writeBufferWaterMark = ((WriteBufferWaterMark)ObjectUtil.checkNotNull(paramWriteBufferWaterMark, "writeBufferWaterMark"));
    return this;
  }
  
  public ChannelConfig setWriteSpinCount(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "writeSpinCount");
    int i = paramInt;
    if (paramInt == Integer.MAX_VALUE) {
      i = paramInt - 1;
    }
    this.writeSpinCount = i;
    return this;
  }
  
  protected <T> void validate(ChannelOption<T> paramChannelOption, T paramT)
  {
    ((ChannelOption)ObjectUtil.checkNotNull(paramChannelOption, "option")).validate(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */