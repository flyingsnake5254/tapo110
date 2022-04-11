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
import io.netty.channel.unix.UnixChannelOption;
import java.io.IOException;
import java.util.Map;

public class KQueueServerSocketChannelConfig
  extends KQueueServerChannelConfig
  implements ServerSocketChannelConfig
{
  KQueueServerSocketChannelConfig(KQueueServerSocketChannel paramKQueueServerSocketChannel)
  {
    super(paramKQueueServerSocketChannel);
    setReuseAddress(true);
  }
  
  public AcceptFilter getAcceptFilter()
  {
    try
    {
      AcceptFilter localAcceptFilter = ((KQueueServerSocketChannel)this.channel).socket.getAcceptFilter();
      return localAcceptFilter;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == UnixChannelOption.SO_REUSEPORT) {
      return Boolean.valueOf(isReusePort());
    }
    if (paramChannelOption == KQueueChannelOption.SO_ACCEPTFILTER) {
      return getAcceptFilter();
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { UnixChannelOption.SO_REUSEPORT, KQueueChannelOption.SO_ACCEPTFILTER });
  }
  
  public boolean isReusePort()
  {
    try
    {
      boolean bool = ((KQueueServerSocketChannel)this.channel).socket.isReusePort();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueServerSocketChannelConfig setAcceptFilter(AcceptFilter paramAcceptFilter)
  {
    try
    {
      ((KQueueServerSocketChannel)this.channel).socket.setAcceptFilter(paramAcceptFilter);
      return this;
    }
    catch (IOException paramAcceptFilter)
    {
      throw new ChannelException(paramAcceptFilter);
    }
  }
  
  public KQueueServerSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setBacklog(int paramInt)
  {
    super.setBacklog(paramInt);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  @Deprecated
  public KQueueServerSocketChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == UnixChannelOption.SO_REUSEPORT)
    {
      setReusePort(((Boolean)paramT).booleanValue());
    }
    else
    {
      if (paramChannelOption != KQueueChannelOption.SO_ACCEPTFILTER) {
        break label46;
      }
      setAcceptFilter((AcceptFilter)paramT);
    }
    return true;
    label46:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public KQueueServerSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    return this;
  }
  
  public KQueueServerSocketChannelConfig setRcvAllocTransportProvidesGuess(boolean paramBoolean)
  {
    super.setRcvAllocTransportProvidesGuess(paramBoolean);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setReceiveBufferSize(int paramInt)
  {
    super.setReceiveBufferSize(paramInt);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setReuseAddress(boolean paramBoolean)
  {
    super.setReuseAddress(paramBoolean);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setReusePort(boolean paramBoolean)
  {
    try
    {
      ((KQueueServerSocketChannel)this.channel).socket.setReusePort(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public KQueueServerSocketChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public KQueueServerSocketChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public KQueueServerSocketChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueServerSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */