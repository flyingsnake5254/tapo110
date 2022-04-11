package io.netty.channel.rxtx;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.util.Map;

@Deprecated
final class DefaultRxtxChannelConfig
  extends DefaultChannelConfig
  implements RxtxChannelConfig
{
  private volatile int baudrate = 115200;
  private volatile RxtxChannelConfig.Databits databits = RxtxChannelConfig.Databits.DATABITS_8;
  private volatile boolean dtr;
  private volatile RxtxChannelConfig.Paritybit paritybit = RxtxChannelConfig.Paritybit.NONE;
  private volatile int readTimeout = 1000;
  private volatile boolean rts;
  private volatile RxtxChannelConfig.Stopbits stopbits = RxtxChannelConfig.Stopbits.STOPBITS_1;
  private volatile int waitTime;
  
  DefaultRxtxChannelConfig(RxtxChannel paramRxtxChannel)
  {
    super(paramRxtxChannel);
    setAllocator(new PreferHeapByteBufAllocator(getAllocator()));
  }
  
  public int getBaudrate()
  {
    return this.baudrate;
  }
  
  public RxtxChannelConfig.Databits getDatabits()
  {
    return this.databits;
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == RxtxChannelOption.BAUD_RATE) {
      return Integer.valueOf(getBaudrate());
    }
    if (paramChannelOption == RxtxChannelOption.DTR) {
      return Boolean.valueOf(isDtr());
    }
    if (paramChannelOption == RxtxChannelOption.RTS) {
      return Boolean.valueOf(isRts());
    }
    if (paramChannelOption == RxtxChannelOption.STOP_BITS) {
      return getStopbits();
    }
    if (paramChannelOption == RxtxChannelOption.DATA_BITS) {
      return getDatabits();
    }
    if (paramChannelOption == RxtxChannelOption.PARITY_BIT) {
      return getParitybit();
    }
    if (paramChannelOption == RxtxChannelOption.WAIT_TIME) {
      return Integer.valueOf(getWaitTimeMillis());
    }
    if (paramChannelOption == RxtxChannelOption.READ_TIMEOUT) {
      return Integer.valueOf(getReadTimeout());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { RxtxChannelOption.BAUD_RATE, RxtxChannelOption.DTR, RxtxChannelOption.RTS, RxtxChannelOption.STOP_BITS, RxtxChannelOption.DATA_BITS, RxtxChannelOption.PARITY_BIT, RxtxChannelOption.WAIT_TIME });
  }
  
  public RxtxChannelConfig.Paritybit getParitybit()
  {
    return this.paritybit;
  }
  
  public int getReadTimeout()
  {
    return this.readTimeout;
  }
  
  public RxtxChannelConfig.Stopbits getStopbits()
  {
    return this.stopbits;
  }
  
  public int getWaitTimeMillis()
  {
    return this.waitTime;
  }
  
  public boolean isDtr()
  {
    return this.dtr;
  }
  
  public boolean isRts()
  {
    return this.rts;
  }
  
  public RxtxChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public RxtxChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public RxtxChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public RxtxChannelConfig setBaudrate(int paramInt)
  {
    this.baudrate = paramInt;
    return this;
  }
  
  public RxtxChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public RxtxChannelConfig setDatabits(RxtxChannelConfig.Databits paramDatabits)
  {
    this.databits = paramDatabits;
    return this;
  }
  
  public RxtxChannelConfig setDtr(boolean paramBoolean)
  {
    this.dtr = paramBoolean;
    return this;
  }
  
  @Deprecated
  public RxtxChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public RxtxChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == RxtxChannelOption.BAUD_RATE)
    {
      setBaudrate(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == RxtxChannelOption.DTR)
    {
      setDtr(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == RxtxChannelOption.RTS)
    {
      setRts(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == RxtxChannelOption.STOP_BITS)
    {
      setStopbits((RxtxChannelConfig.Stopbits)paramT);
    }
    else if (paramChannelOption == RxtxChannelOption.DATA_BITS)
    {
      setDatabits((RxtxChannelConfig.Databits)paramT);
    }
    else if (paramChannelOption == RxtxChannelOption.PARITY_BIT)
    {
      setParitybit((RxtxChannelConfig.Paritybit)paramT);
    }
    else if (paramChannelOption == RxtxChannelOption.WAIT_TIME)
    {
      setWaitTimeMillis(((Integer)paramT).intValue());
    }
    else
    {
      if (paramChannelOption != RxtxChannelOption.READ_TIMEOUT) {
        break label172;
      }
      setReadTimeout(((Integer)paramT).intValue());
    }
    return true;
    label172:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public RxtxChannelConfig setParitybit(RxtxChannelConfig.Paritybit paramParitybit)
  {
    this.paritybit = paramParitybit;
    return this;
  }
  
  public RxtxChannelConfig setReadTimeout(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.readTimeout = paramInt;
      return this;
    }
    throw new IllegalArgumentException("readTime must be >= 0");
  }
  
  public RxtxChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public RxtxChannelConfig setRts(boolean paramBoolean)
  {
    this.rts = paramBoolean;
    return this;
  }
  
  public RxtxChannelConfig setStopbits(RxtxChannelConfig.Stopbits paramStopbits)
  {
    this.stopbits = paramStopbits;
    return this;
  }
  
  public RxtxChannelConfig setWaitTimeMillis(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.waitTime = paramInt;
      return this;
    }
    throw new IllegalArgumentException("Wait time must be >= 0");
  }
  
  public RxtxChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public RxtxChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public RxtxChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public RxtxChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\rxtx\DefaultRxtxChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */