package io.netty.channel.udt;

import com.barchart.udt.nio.ChannelUDT;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.io.IOException;
import java.util.Map;

@Deprecated
public class DefaultUdtServerChannelConfig
  extends DefaultUdtChannelConfig
  implements UdtServerChannelConfig
{
  private volatile int backlog = 64;
  
  public DefaultUdtServerChannelConfig(UdtChannel paramUdtChannel, ChannelUDT paramChannelUDT, boolean paramBoolean)
    throws IOException
  {
    super(paramUdtChannel, paramChannelUDT, paramBoolean);
    if (paramBoolean) {
      apply(paramChannelUDT);
    }
  }
  
  protected void apply(ChannelUDT paramChannelUDT)
    throws IOException
  {}
  
  public int getBacklog()
  {
    return this.backlog;
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == ChannelOption.SO_BACKLOG) {
      return Integer.valueOf(getBacklog());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_BACKLOG });
  }
  
  public UdtServerChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public UdtServerChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public UdtServerChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public UdtServerChannelConfig setBacklog(int paramInt)
  {
    this.backlog = paramInt;
    return this;
  }
  
  public UdtServerChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  @Deprecated
  public UdtServerChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == ChannelOption.SO_BACKLOG)
    {
      setBacklog(((Integer)paramT).intValue());
      return true;
    }
    return super.setOption(paramChannelOption, paramT);
  }
  
  public UdtServerChannelConfig setProtocolReceiveBufferSize(int paramInt)
  {
    super.setProtocolReceiveBufferSize(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setProtocolSendBufferSize(int paramInt)
  {
    super.setProtocolSendBufferSize(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setReceiveBufferSize(int paramInt)
  {
    super.setReceiveBufferSize(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public UdtServerChannelConfig setReuseAddress(boolean paramBoolean)
  {
    super.setReuseAddress(paramBoolean);
    return this;
  }
  
  public UdtServerChannelConfig setSendBufferSize(int paramInt)
  {
    super.setSendBufferSize(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setSoLinger(int paramInt)
  {
    super.setSoLinger(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setSystemReceiveBufferSize(int paramInt)
  {
    super.setSystemReceiveBufferSize(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setSystemSendBufferSize(int paramInt)
  {
    super.setSystemSendBufferSize(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public UdtServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public UdtServerChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\udt\DefaultUdtServerChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */