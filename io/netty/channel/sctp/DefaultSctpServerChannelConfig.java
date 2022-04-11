package io.netty.channel.sctp;

import com.sun.nio.sctp.SctpStandardSocketOptions;
import com.sun.nio.sctp.SctpStandardSocketOptions.InitMaxStreams;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.util.Map;

public class DefaultSctpServerChannelConfig
  extends DefaultChannelConfig
  implements SctpServerChannelConfig
{
  private volatile int backlog = NetUtil.SOMAXCONN;
  private final com.sun.nio.sctp.SctpServerChannel javaChannel;
  
  public DefaultSctpServerChannelConfig(SctpServerChannel paramSctpServerChannel, com.sun.nio.sctp.SctpServerChannel paramSctpServerChannel1)
  {
    super(paramSctpServerChannel);
    this.javaChannel = ((com.sun.nio.sctp.SctpServerChannel)ObjectUtil.checkNotNull(paramSctpServerChannel1, "javaChannel"));
  }
  
  public int getBacklog()
  {
    return this.backlog;
  }
  
  public SctpStandardSocketOptions.InitMaxStreams getInitMaxStreams()
  {
    try
    {
      SctpStandardSocketOptions.InitMaxStreams localInitMaxStreams = (SctpStandardSocketOptions.InitMaxStreams)this.javaChannel.getOption(SctpStandardSocketOptions.SCTP_INIT_MAXSTREAMS);
      return localInitMaxStreams;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == ChannelOption.SO_RCVBUF) {
      return Integer.valueOf(getReceiveBufferSize());
    }
    if (paramChannelOption == ChannelOption.SO_SNDBUF) {
      return Integer.valueOf(getSendBufferSize());
    }
    if (paramChannelOption == SctpChannelOption.SCTP_INIT_MAXSTREAMS) {
      return getInitMaxStreams();
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, SctpChannelOption.SCTP_INIT_MAXSTREAMS });
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = ((Integer)this.javaChannel.getOption(SctpStandardSocketOptions.SO_RCVBUF)).intValue();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getSendBufferSize()
  {
    try
    {
      int i = ((Integer)this.javaChannel.getOption(SctpStandardSocketOptions.SO_SNDBUF)).intValue();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public SctpServerChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public SctpServerChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public SctpServerChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public SctpServerChannelConfig setBacklog(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "backlog");
    this.backlog = paramInt;
    return this;
  }
  
  public SctpServerChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public SctpServerChannelConfig setInitMaxStreams(SctpStandardSocketOptions.InitMaxStreams paramInitMaxStreams)
  {
    try
    {
      this.javaChannel.setOption(SctpStandardSocketOptions.SCTP_INIT_MAXSTREAMS, paramInitMaxStreams);
      return this;
    }
    catch (IOException paramInitMaxStreams)
    {
      throw new ChannelException(paramInitMaxStreams);
    }
  }
  
  @Deprecated
  public SctpServerChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public SctpServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
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
    else if (paramChannelOption == ChannelOption.SO_SNDBUF)
    {
      setSendBufferSize(((Integer)paramT).intValue());
    }
    else
    {
      if (paramChannelOption != SctpChannelOption.SCTP_INIT_MAXSTREAMS) {
        break label68;
      }
      setInitMaxStreams((SctpStandardSocketOptions.InitMaxStreams)paramT);
    }
    return true;
    label68:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public SctpServerChannelConfig setReceiveBufferSize(int paramInt)
  {
    try
    {
      this.javaChannel.setOption(SctpStandardSocketOptions.SO_RCVBUF, Integer.valueOf(paramInt));
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public SctpServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public SctpServerChannelConfig setSendBufferSize(int paramInt)
  {
    try
    {
      this.javaChannel.setOption(SctpStandardSocketOptions.SO_SNDBUF, Integer.valueOf(paramInt));
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public SctpServerChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public SctpServerChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public SctpServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public SctpServerChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\DefaultSctpServerChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */