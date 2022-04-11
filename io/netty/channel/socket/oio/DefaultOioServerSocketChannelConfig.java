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
import io.netty.channel.socket.DefaultServerSocketChannelConfig;
import io.netty.channel.socket.ServerSocketChannel;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;

@Deprecated
public class DefaultOioServerSocketChannelConfig
  extends DefaultServerSocketChannelConfig
  implements OioServerSocketChannelConfig
{
  @Deprecated
  public DefaultOioServerSocketChannelConfig(ServerSocketChannel paramServerSocketChannel, ServerSocket paramServerSocket)
  {
    super(paramServerSocketChannel, paramServerSocket);
    setAllocator(new PreferHeapByteBufAllocator(getAllocator()));
  }
  
  DefaultOioServerSocketChannelConfig(OioServerSocketChannel paramOioServerSocketChannel, ServerSocket paramServerSocket)
  {
    super(paramOioServerSocketChannel, paramServerSocket);
    setAllocator(new PreferHeapByteBufAllocator(getAllocator()));
  }
  
  protected void autoReadCleared()
  {
    Channel localChannel = this.channel;
    if ((localChannel instanceof OioServerSocketChannel)) {
      ((OioServerSocketChannel)localChannel).clearReadPending0();
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
  
  public OioServerSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator)
  {
    super.setAllocator(paramByteBufAllocator);
    return this;
  }
  
  public OioServerSocketChannelConfig setAutoClose(boolean paramBoolean)
  {
    super.setAutoClose(paramBoolean);
    return this;
  }
  
  public OioServerSocketChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public OioServerSocketChannelConfig setBacklog(int paramInt)
  {
    super.setBacklog(paramInt);
    return this;
  }
  
  public OioServerSocketChannelConfig setConnectTimeoutMillis(int paramInt)
  {
    super.setConnectTimeoutMillis(paramInt);
    return this;
  }
  
  @Deprecated
  public OioServerSocketChannelConfig setMaxMessagesPerRead(int paramInt)
  {
    super.setMaxMessagesPerRead(paramInt);
    return this;
  }
  
  public OioServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
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
  
  public OioServerSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    super.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
    return this;
  }
  
  public OioServerSocketChannelConfig setReceiveBufferSize(int paramInt)
  {
    super.setReceiveBufferSize(paramInt);
    return this;
  }
  
  public OioServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
  {
    super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
    return this;
  }
  
  public OioServerSocketChannelConfig setReuseAddress(boolean paramBoolean)
  {
    super.setReuseAddress(paramBoolean);
    return this;
  }
  
  public OioServerSocketChannelConfig setSoTimeout(int paramInt)
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
  
  public OioServerSocketChannelConfig setWriteBufferHighWaterMark(int paramInt)
  {
    super.setWriteBufferHighWaterMark(paramInt);
    return this;
  }
  
  public OioServerSocketChannelConfig setWriteBufferLowWaterMark(int paramInt)
  {
    super.setWriteBufferLowWaterMark(paramInt);
    return this;
  }
  
  public OioServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark)
  {
    super.setWriteBufferWaterMark(paramWriteBufferWaterMark);
    return this;
  }
  
  public OioServerSocketChannelConfig setWriteSpinCount(int paramInt)
  {
    super.setWriteSpinCount(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\oio\DefaultOioServerSocketChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */