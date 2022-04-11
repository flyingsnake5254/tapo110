package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.util.Map;

public final class KQueueSocketChannelConfig
  extends KQueueChannelConfig
  implements SocketChannelConfig
{
  private volatile boolean allowHalfClosure;
  
  KQueueSocketChannelConfig(KQueueSocketChannel paramKQueueSocketChannel)
  {
    super(paramKQueueSocketChannel);
    if (PlatformDependent.canEnableTcpNoDelayByDefault()) {
      setTcpNoDelay(true);
    }
    calculateMaxBytesPerGatheringWrite();
  }
  
  private void calculateMaxBytesPerGatheringWrite()
  {
    if (getSendBufferSize() << 1 > 0) {
      setMaxBytesPerGatheringWrite(getSendBufferSize() << 1);
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
    if (paramChannelOption == ChannelOption.TCP_NODELAY) {
      return Boolean.valueOf(isTcpNoDelay());
    }
    if (paramChannelOption == ChannelOption.SO_KEEPALIVE) {
      return Boolean.valueOf(isKeepAlive());
    }
    if (paramChannelOption == ChannelOption.SO_REUSEADDR) {
      return Boolean.valueOf(isReuseAddress());
    }
    if (paramChannelOption == ChannelOption.SO_LINGER) {
      return Integer.valueOf(getSoLinger());
    }
    if (paramChannelOption == ChannelOption.IP_TOS) {
      return Integer.valueOf(getTrafficClass());
    }
    if (paramChannelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
      return Boolean.valueOf(isAllowHalfClosure());
    }
    if (paramChannelOption == KQueueChannelOption.SO_SNDLOWAT) {
      return Integer.valueOf(getSndLowAt());
    }
    if (paramChannelOption == KQueueChannelOption.TCP_NOPUSH) {
      return Boolean.valueOf(isTcpNoPush());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE, KQueueChannelOption.SO_SNDLOWAT, KQueueChannelOption.TCP_NOPUSH });
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = ((KQueueSocketChannel)this.channel).socket.getReceiveBufferSize();
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
      int i = ((KQueueSocketChannel)this.channel).socket.getSendBufferSize();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getSndLowAt()
  {
    try
    {
      int i = ((KQueueSocketChannel)this.channel).socket.getSndLowAt();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getSoLinger()
  {
    try
    {
      int i = ((KQueueSocketChannel)this.channel).socket.getSoLinger();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getTrafficClass()
  {
    try
    {
      int i = ((KQueueSocketChannel)this.channel).socket.getTrafficClass();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isAllowHalfClosure()
  {
    return this.allowHalfClosure;
  }
  
  public boolean isKeepAlive()
  {
    try
    {
      boolean bool = ((KQueueSocketChannel)this.channel).socket.isKeepAlive();
      return bool;
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
      boolean bool = ((KQueueSocketChannel)this.channel).socket.isReuseAddress();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isTcpNoDelay()
  {
    try
    {
      boolean bool = ((KQueueSocketChannel)this.channel).socket.isTcpNoDelay();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isTcpNoPush()
  {
    try
    {
      boolean bool = ((KQueueSocketChannel)this.channel).socket.isTcpNoPush();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public KQueueSocketChannelConfig setAllowHalfClosure(boolean paramBoolean)
  {
    this.allowHalfClosure = paramBoolean;
    return this;
  }
  
  public KQueueSocketChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public KQueueSocketChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public KQueueSocketChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public KQueueSocketChannelConfig setKeepAlive(boolean paramBoolean)
  {
    try
    {
      ((KQueueSocketChannel)this.channel).socket.setKeepAlive(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public KQueueSocketChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public KQueueSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
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
    else if (paramChannelOption == ChannelOption.TCP_NODELAY)
    {
      setTcpNoDelay(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.SO_KEEPALIVE)
    {
      setKeepAlive(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.SO_REUSEADDR)
    {
      setReuseAddress(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == ChannelOption.SO_LINGER)
    {
      setSoLinger(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.IP_TOS)
    {
      setTrafficClass(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == ChannelOption.ALLOW_HALF_CLOSURE)
    {
      setAllowHalfClosure(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == KQueueChannelOption.SO_SNDLOWAT)
    {
      setSndLowAt(((Integer)paramT).intValue());
    }
    else
    {
      if (paramChannelOption != KQueueChannelOption.TCP_NOPUSH) {
        break label223;
      }
      setTcpNoPush(((Boolean)paramT).booleanValue());
    }
    return true;
    label223:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public KQueueSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    return this;
  }
  
  public KQueueSocketChannelConfig setRcvAllocTransportProvidesGuess(boolean paramBoolean)
  {
    super.setRcvAllocTransportProvidesGuess(paramBoolean);
    return this;
  }
  
  public KQueueSocketChannelConfig setReceiveBufferSize(int paramInt)
  {
    try
    {
      ((KQueueSocketChannel)this.channel).socket.setReceiveBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public KQueueSocketChannelConfig setReuseAddress(boolean paramBoolean)
  {
    try
    {
      ((KQueueSocketChannel)this.channel).socket.setReuseAddress(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueSocketChannelConfig setSendBufferSize(int paramInt)
  {
    try
    {
      ((KQueueSocketChannel)this.channel).socket.setSendBufferSize(paramInt);
      calculateMaxBytesPerGatheringWrite();
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public void setSndLowAt(int paramInt)
  {
    try
    {
      ((KQueueSocketChannel)this.channel).socket.setSndLowAt(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueSocketChannelConfig setSoLinger(int paramInt)
  {
    try
    {
      ((KQueueSocketChannel)this.channel).socket.setSoLinger(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueSocketChannelConfig setTcpNoDelay(boolean paramBoolean)
  {
    try
    {
      ((KQueueSocketChannel)this.channel).socket.setTcpNoDelay(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public void setTcpNoPush(boolean paramBoolean)
  {
    try
    {
      ((KQueueSocketChannel)this.channel).socket.setTcpNoPush(paramBoolean);
      return;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public KQueueSocketChannelConfig setTrafficClass(int paramInt)
  {
    try
    {
      ((KQueueSocketChannel)this.channel).socket.setTrafficClass(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public KQueueSocketChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public KQueueSocketChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public KQueueSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public KQueueSocketChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */