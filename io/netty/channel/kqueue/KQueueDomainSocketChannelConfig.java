package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.unix.DomainSocketChannelConfig;
import io.netty.channel.unix.DomainSocketReadMode;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannelOption;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.util.Map;

public final class KQueueDomainSocketChannelConfig
  extends KQueueChannelConfig
  implements DomainSocketChannelConfig
{
  private volatile boolean allowHalfClosure;
  private volatile DomainSocketReadMode mode = DomainSocketReadMode.BYTES;
  
  KQueueDomainSocketChannelConfig(AbstractKQueueChannel paramAbstractKQueueChannel)
  {
    super(paramAbstractKQueueChannel);
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == UnixChannelOption.DOMAIN_SOCKET_READ_MODE) {
      return getReadMode();
    }
    if (paramChannelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
      return Boolean.valueOf(isAllowHalfClosure());
    }
    if (paramChannelOption == ChannelOption.SO_SNDBUF) {
      return Integer.valueOf(getSendBufferSize());
    }
    if (paramChannelOption == ChannelOption.SO_RCVBUF) {
      return Integer.valueOf(getReceiveBufferSize());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { UnixChannelOption.DOMAIN_SOCKET_READ_MODE, ChannelOption.ALLOW_HALF_CLOSURE, ChannelOption.SO_SNDBUF, ChannelOption.SO_RCVBUF });
  }
  
  public DomainSocketReadMode getReadMode()
  {
    return this.mode;
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = ((KQueueDomainSocketChannel)this.channel).socket.getReceiveBufferSize();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public int getSendBufferSize()
  {
    try
    {
      int i = ((KQueueDomainSocketChannel)this.channel).socket.getSendBufferSize();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public boolean isAllowHalfClosure()
  {
    return this.allowHalfClosure;
  }
  
  public KQueueDomainSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setAllowHalfClosure(boolean paramBoolean)
  {
    this.allowHalfClosure = paramBoolean;
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  @Deprecated
  public KQueueDomainSocketChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == UnixChannelOption.DOMAIN_SOCKET_READ_MODE)
    {
      setReadMode((DomainSocketReadMode)paramT);
    }
    else if (paramChannelOption == ChannelOption.ALLOW_HALF_CLOSURE)
    {
      setAllowHalfClosure(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.SO_SNDBUF)
    {
      setSendBufferSize(((Integer)paramT).intValue());
    }
    else
    {
      if (paramChannelOption != ChannelOption.SO_RCVBUF) {
        break label90;
      }
      setReceiveBufferSize(((Integer)paramT).intValue());
    }
    return true;
    label90:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public KQueueDomainSocketChannelConfig setRcvAllocTransportProvidesGuess(boolean paramBoolean)
  {
    super.setRcvAllocTransportProvidesGuess(paramBoolean);
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setReadMode(DomainSocketReadMode paramDomainSocketReadMode)
  {
    this.mode = ((DomainSocketReadMode)ObjectUtil.checkNotNull(paramDomainSocketReadMode, "mode"));
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setReceiveBufferSize(int paramInt)
  {
    try
    {
      ((KQueueDomainSocketChannel)this.channel).socket.setReceiveBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public KQueueDomainSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setSendBufferSize(int paramInt)
  {
    try
    {
      ((KQueueDomainSocketChannel)this.channel).socket.setSendBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  @Deprecated
  public KQueueDomainSocketChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public KQueueDomainSocketChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public KQueueDomainSocketChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueDomainSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */