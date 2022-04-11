package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.SocketChannel;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

@Deprecated
public class DefaultOioSocketChannelConfig
  extends DefaultSocketChannelConfig
  implements OioSocketChannelConfig
{
  @Deprecated
  public DefaultOioSocketChannelConfig(SocketChannel paramSocketChannel, Socket paramSocket)
  {
    super(paramSocketChannel, paramSocket);
    setAllocator(new PreferHeapByteBufAllocator(getAllocator()));
  }
  
  DefaultOioSocketChannelConfig(OioSocketChannel paramOioSocketChannel, Socket paramSocket)
  {
    super(paramOioSocketChannel, paramSocket);
    setAllocator(new PreferHeapByteBufAllocator(getAllocator()));
  }
  
  protected void autoReadCleared()
  {
    Channel localChannel = this.channel;
    if ((localChannel instanceof OioSocketChannel)) {
      ((OioSocketChannel)localChannel).clearReadPending0();
    }
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if (paramChannelOption == ChannelOption.SO_TIMEOUT) {
      return Integer.valueOf(getSoTimeout());
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    return getOptions(super.getOptions(), new ChannelOption[] { ChannelOption.SO_TIMEOUT });
  }
  
  public int getSoTimeout()
  {
    try
    {
      int i = this.javaSocket.getSoTimeout();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public OioSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public OioSocketChannelConfig setAllowHalfClosure(boolean paramBoolean)
  {
    super.setAllowHalfClosure(paramBoolean);
    return this;
  }
  
  public OioSocketChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public OioSocketChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public OioSocketChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  public OioSocketChannelConfig setKeepAlive(boolean paramBoolean)
  {
    super.setKeepAlive(paramBoolean);
    return this;
  }
  
  @Deprecated
  public OioSocketChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public OioSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
  {
    super.setMessageSizeEstimator(paramMessageSizeEstimator);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    validate(paramChannelOption, paramT);
    if (paramChannelOption == ChannelOption.SO_TIMEOUT)
    {
      setSoTimeout(((Integer)paramT).intValue());
      return true;
    }
    return super.setOption(paramChannelOption, paramT);
  }
  
  public OioSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    super.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
    return this;
  }
  
  public OioSocketChannelConfig setReceiveBufferSize(int paramInt)
  {
    super.setReceiveBufferSize(paramInt);
    return this;
  }
  
  public OioSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public OioSocketChannelConfig setReuseAddress(boolean paramBoolean)
  {
    super.setReuseAddress(paramBoolean);
    return this;
  }
  
  public OioSocketChannelConfig setSendBufferSize(int paramInt)
  {
    super.setSendBufferSize(paramInt);
    return this;
  }
  
  public OioSocketChannelConfig setSoLinger(int paramInt)
  {
    super.setSoLinger(paramInt);
    return this;
  }
  
  public OioSocketChannelConfig setSoTimeout(int paramInt)
  {
    try
    {
      this.javaSocket.setSoTimeout(paramInt);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  public OioSocketChannelConfig setTcpNoDelay(boolean paramBoolean)
  {
    super.setTcpNoDelay(paramBoolean);
    return this;
  }
  
  public OioSocketChannelConfig setTrafficClass(int paramInt)
  {
    super.setTrafficClass(paramInt);
    return this;
  }
  
  public OioSocketChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public OioSocketChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public OioSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public OioSocketChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\oio\DefaultOioSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */