package io.netty.channel.udt;

import com.barchart.udt.OptionUDT;
import com.barchart.udt.SocketUDT;
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
public class DefaultUdtChannelConfig
  extends DefaultChannelConfig
  implements UdtChannelConfig
{
  private static final int K = 1024;
  private static final int M = 1048576;
  private volatile int allocatorReceiveBufferSize = 131072;
  private volatile int allocatorSendBufferSize = 131072;
  private volatile int protocolReceiveBufferSize = 10485760;
  private volatile int protocolSendBufferSize = 10485760;
  private volatile boolean reuseAddress = true;
  private volatile int soLinger;
  private volatile int systemReceiveBufferSize = 1048576;
  private volatile int systemSendBufferSize = 1048576;
  
  public DefaultUdtChannelConfig(UdtChannel paramUdtChannel, ChannelUDT paramChannelUDT, boolean paramBoolean)
    throws IOException
  {
    super(paramUdtChannel);
    if (paramBoolean) {
      apply(paramChannelUDT);
    }
  }
  
  protected void apply(ChannelUDT paramChannelUDT)
    throws IOException
  {
    paramChannelUDT = paramChannelUDT.socketUDT();
    paramChannelUDT.setReuseAddress(isReuseAddress());
    paramChannelUDT.setSendBufferSize(getSendBufferSize());
    if (getSoLinger() <= 0) {
      paramChannelUDT.setSoLinger(false, 0);
    } else {
      paramChannelUDT.setSoLinger(true, getSoLinger());
    }
    paramChannelUDT.setOption(OptionUDT.Protocol_Receive_Buffer_Size, Integer.valueOf(getProtocolReceiveBufferSize()));
    paramChannelUDT.setOption(OptionUDT.Protocol_Send_Buffer_Size, Integer.valueOf(getProtocolSendBufferSize()));
    paramChannelUDT.setOption(OptionUDT.System_Receive_Buffer_Size, Integer.valueOf(getSystemReceiveBufferSize()));
    paramChannelUDT.setOption(OptionUDT.System_Send_Buffer_Size, Integer.valueOf(getSystemSendBufferSize()));
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE) {
      return Integer.valueOf(getProtocolReceiveBufferSize());
    }
    if (paramChannelOption == UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE) {
      return Integer.valueOf(getProtocolSendBufferSize());
    }
    if (paramChannelOption == UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE) {
      return Integer.valueOf(getSystemReceiveBufferSize());
    }
    if (paramChannelOption == UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE) {
      return Integer.valueOf(getSystemSendBufferSize());
    }
    if (paramChannelOption == ChannelOption.SO_RCVBUF) {
      return Integer.valueOf(getReceiveBufferSize());
    }
    if (paramChannelOption == ChannelOption.SO_SNDBUF) {
      return Integer.valueOf(getSendBufferSize());
    }
    if (paramChannelOption == ChannelOption.SO_REUSEADDR) {
      return Boolean.valueOf(isReuseAddress());
    }
    if (paramChannelOption == ChannelOption.SO_LINGER) {
      return Integer.valueOf(getSoLinger());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE, UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE, UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE, UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER });
  }
  
  public int getProtocolReceiveBufferSize()
  {
    return this.protocolReceiveBufferSize;
  }
  
  public int getProtocolSendBufferSize()
  {
    return this.protocolSendBufferSize;
  }
  
  public int getReceiveBufferSize()
  {
    return this.allocatorReceiveBufferSize;
  }
  
  public int getSendBufferSize()
  {
    return this.allocatorSendBufferSize;
  }
  
  public int getSoLinger()
  {
    return this.soLinger;
  }
  
  public int getSystemReceiveBufferSize()
  {
    return this.systemReceiveBufferSize;
  }
  
  public int getSystemSendBufferSize()
  {
    return this.systemSendBufferSize;
  }
  
  public boolean isReuseAddress()
  {
    return this.reuseAddress;
  }
  
  public UdtChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public UdtChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public UdtChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public UdtChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  @Deprecated
  public UdtChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public UdtChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE)
    {
      setProtocolReceiveBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE)
    {
      setProtocolSendBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE)
    {
      setSystemReceiveBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE)
    {
      setSystemSendBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.SO_RCVBUF)
    {
      setReceiveBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.SO_SNDBUF)
    {
      setSendBufferSize(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.SO_REUSEADDR)
    {
      setReuseAddress(((Boolean)paramT).booleanValue());
    }
    else
    {
      if (paramChannelOption != ChannelOption.SO_LINGER) {
        break label181;
      }
      setSoLinger(((Integer)paramT).intValue());
    }
    return true;
    label181:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public UdtChannelConfig setProtocolReceiveBufferSize(int paramInt)
  {
    this.protocolReceiveBufferSize = paramInt;
    return this;
  }
  
  public UdtChannelConfig setProtocolSendBufferSize(int paramInt)
  {
    this.protocolSendBufferSize = paramInt;
    return this;
  }
  
  public UdtChannelConfig setReceiveBufferSize(int paramInt)
  {
    this.allocatorReceiveBufferSize = paramInt;
    return this;
  }
  
  public UdtChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public UdtChannelConfig setReuseAddress(boolean paramBoolean)
  {
    this.reuseAddress = paramBoolean;
    return this;
  }
  
  public UdtChannelConfig setSendBufferSize(int paramInt)
  {
    this.allocatorSendBufferSize = paramInt;
    return this;
  }
  
  public UdtChannelConfig setSoLinger(int paramInt)
  {
    this.soLinger = paramInt;
    return this;
  }
  
  public UdtChannelConfig setSystemReceiveBufferSize(int paramInt)
  {
    this.systemSendBufferSize = paramInt;
    return this;
  }
  
  public UdtChannelConfig setSystemSendBufferSize(int paramInt)
  {
    this.systemReceiveBufferSize = paramInt;
    return this;
  }
  
  public UdtChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public UdtChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public UdtChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public UdtChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\udt\DefaultUdtChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */