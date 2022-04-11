package io.netty.channel.epoll;

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
import java.net.InetAddress;
import java.util.Map;

public final class EpollSocketChannelConfig
  extends EpollChannelConfig
  implements SocketChannelConfig
{
  private volatile boolean allowHalfClosure;
  
  EpollSocketChannelConfig(EpollSocketChannel paramEpollSocketChannel)
  {
    super(paramEpollSocketChannel);
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
    if (paramChannelOption == EpollChannelOption.TCP_CORK) {
      return Boolean.valueOf(isTcpCork());
    }
    if (paramChannelOption == EpollChannelOption.TCP_NOTSENT_LOWAT) {
      return Long.valueOf(getTcpNotSentLowAt());
    }
    if (paramChannelOption == EpollChannelOption.TCP_KEEPIDLE) {
      return Integer.valueOf(getTcpKeepIdle());
    }
    if (paramChannelOption == EpollChannelOption.TCP_KEEPINTVL) {
      return Integer.valueOf(getTcpKeepIntvl());
    }
    if (paramChannelOption == EpollChannelOption.TCP_KEEPCNT) {
      return Integer.valueOf(getTcpKeepCnt());
    }
    if (paramChannelOption == EpollChannelOption.TCP_USER_TIMEOUT) {
      return Integer.valueOf(getTcpUserTimeout());
    }
    if (paramChannelOption == EpollChannelOption.TCP_QUICKACK) {
      return Boolean.valueOf(isTcpQuickAck());
    }
    if (paramChannelOption == EpollChannelOption.IP_TRANSPARENT) {
      return Boolean.valueOf(isIpTransparent());
    }
    if (paramChannelOption == EpollChannelOption.TCP_FASTOPEN_CONNECT) {
      return Boolean.valueOf(isTcpFastOpenConnect());
    }
    if (paramChannelOption == EpollChannelOption.SO_BUSY_POLL) {
      return Integer.valueOf(getSoBusyPoll());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE, EpollChannelOption.TCP_CORK, EpollChannelOption.TCP_NOTSENT_LOWAT, EpollChannelOption.TCP_KEEPCNT, EpollChannelOption.TCP_KEEPIDLE, EpollChannelOption.TCP_KEEPINTVL, EpollChannelOption.TCP_MD5SIG, EpollChannelOption.TCP_QUICKACK, EpollChannelOption.IP_TRANSPARENT, EpollChannelOption.TCP_FASTOPEN_CONNECT, EpollChannelOption.SO_BUSY_POLL });
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = ((EpollSocketChannel)this.channel).socket.getReceiveBufferSize();
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
      int i = ((EpollSocketChannel)this.channel).socket.getSendBufferSize();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getSoBusyPoll()
  {
    try
    {
      int i = ((EpollSocketChannel)this.channel).socket.getSoBusyPoll();
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
      int i = ((EpollSocketChannel)this.channel).socket.getSoLinger();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getTcpKeepCnt()
  {
    try
    {
      int i = ((EpollSocketChannel)this.channel).socket.getTcpKeepCnt();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getTcpKeepIdle()
  {
    try
    {
      int i = ((EpollSocketChannel)this.channel).socket.getTcpKeepIdle();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getTcpKeepIntvl()
  {
    try
    {
      int i = ((EpollSocketChannel)this.channel).socket.getTcpKeepIntvl();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public long getTcpNotSentLowAt()
  {
    try
    {
      long l = ((EpollSocketChannel)this.channel).socket.getTcpNotSentLowAt();
      return l;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public int getTcpUserTimeout()
  {
    try
    {
      int i = ((EpollSocketChannel)this.channel).socket.getTcpUserTimeout();
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
      int i = ((EpollSocketChannel)this.channel).socket.getTrafficClass();
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
  
  public boolean isIpTransparent()
  {
    try
    {
      boolean bool = ((EpollSocketChannel)this.channel).socket.isIpTransparent();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isKeepAlive()
  {
    try
    {
      boolean bool = ((EpollSocketChannel)this.channel).socket.isKeepAlive();
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
      boolean bool = ((EpollSocketChannel)this.channel).socket.isReuseAddress();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isTcpCork()
  {
    try
    {
      boolean bool = ((EpollSocketChannel)this.channel).socket.isTcpCork();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isTcpFastOpenConnect()
  {
    try
    {
      boolean bool = ((EpollSocketChannel)this.channel).socket.isTcpFastOpenConnect();
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
      boolean bool = ((EpollSocketChannel)this.channel).socket.isTcpNoDelay();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public boolean isTcpQuickAck()
  {
    try
    {
      boolean bool = ((EpollSocketChannel)this.channel).socket.isTcpQuickAck();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public EpollSocketChannelConfig setAllowHalfClosure(boolean paramBoolean)
  {
    this.allowHalfClosure = paramBoolean;
    return this;
  }
  
  public EpollSocketChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public EpollSocketChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public EpollSocketChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public EpollSocketChannelConfig setEpollMode(EpollMode paramEpollMode)
  {
    super.setEpollMode(paramEpollMode);
    return this;
  }
  
  public EpollSocketChannelConfig setIpTransparent(boolean paramBoolean)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setIpTransparent(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setKeepAlive(boolean paramBoolean)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setKeepAlive(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public EpollSocketChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public EpollSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
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
    else if (paramChannelOption == EpollChannelOption.TCP_CORK)
    {
      setTcpCork(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == EpollChannelOption.TCP_NOTSENT_LOWAT)
    {
      setTcpNotSentLowAt(((Long)paramT).longValue());
    }
    else if (paramChannelOption == EpollChannelOption.TCP_KEEPIDLE)
    {
      setTcpKeepIdle(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == EpollChannelOption.TCP_KEEPCNT)
    {
      setTcpKeepCnt(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == EpollChannelOption.TCP_KEEPINTVL)
    {
      setTcpKeepIntvl(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == EpollChannelOption.TCP_USER_TIMEOUT)
    {
      setTcpUserTimeout(((Integer)paramT).intValue());
    }
    else if (paramChannelOption == EpollChannelOption.IP_TRANSPARENT)
    {
      setIpTransparent(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == EpollChannelOption.TCP_MD5SIG)
    {
      setTcpMd5Sig((Map)paramT);
    }
    else if (paramChannelOption == EpollChannelOption.TCP_QUICKACK)
    {
      setTcpQuickAck(((Boolean)paramT).booleanValue());
    }
    else if (paramChannelOption == EpollChannelOption.TCP_FASTOPEN_CONNECT)
    {
      setTcpFastOpenConnect(((Boolean)paramT).booleanValue());
    }
    else
    {
      if (paramChannelOption != EpollChannelOption.SO_BUSY_POLL) {
        break label420;
      }
      setSoBusyPoll(((Integer)paramT).intValue());
    }
    return true;
    label420:
    return super.setOption(paramChannelOption, paramT);
  }
  
  public EpollSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    return this;
  }
  
  public EpollSocketChannelConfig setReceiveBufferSize(int paramInt)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setReceiveBufferSize(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public EpollSocketChannelConfig setReuseAddress(boolean paramBoolean)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setReuseAddress(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setSendBufferSize(int paramInt)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setSendBufferSize(paramInt);
      calculateMaxBytesPerGatheringWrite();
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setSoBusyPoll(int paramInt)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setSoBusyPoll(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setSoLinger(int paramInt)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setSoLinger(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setTcpCork(boolean paramBoolean)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTcpCork(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setTcpFastOpenConnect(boolean paramBoolean)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTcpFastOpenConnect(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setTcpKeepCnt(int paramInt)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTcpKeepCnt(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public EpollSocketChannelConfig setTcpKeepCntl(int paramInt)
  {
    return setTcpKeepCnt(paramInt);
  }
  
  public EpollSocketChannelConfig setTcpKeepIdle(int paramInt)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTcpKeepIdle(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setTcpKeepIntvl(int paramInt)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTcpKeepIntvl(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setTcpMd5Sig(Map<InetAddress, byte[]> paramMap)
  {
    try
    {
      ((EpollSocketChannel)this.channel).setTcpMd5Sig(paramMap);
      return this;
    }
    catch (IOException paramMap)
    {
      throw new ChannelException(paramMap);
    }
  }
  
  public EpollSocketChannelConfig setTcpNoDelay(boolean paramBoolean)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTcpNoDelay(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setTcpNotSentLowAt(long paramLong)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTcpNotSentLowAt(paramLong);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setTcpQuickAck(boolean paramBoolean)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTcpQuickAck(paramBoolean);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setTcpUserTimeout(int paramInt)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTcpUserTimeout(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public EpollSocketChannelConfig setTrafficClass(int paramInt)
  {
    try
    {
      ((EpollSocketChannel)this.channel).socket.setTrafficClass(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  @Deprecated
  public EpollSocketChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  @Deprecated
  public EpollSocketChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public EpollSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public EpollSocketChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */