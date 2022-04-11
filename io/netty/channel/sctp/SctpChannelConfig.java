package io.netty.channel.sctp;

import com.sun.nio.sctp.SctpStandardSocketOptions.InitMaxStreams;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public abstract interface SctpChannelConfig
  extends ChannelConfig
{
  public abstract SctpStandardSocketOptions.InitMaxStreams getInitMaxStreams();
  
  public abstract int getReceiveBufferSize();
  
  public abstract int getSendBufferSize();
  
  public abstract boolean isSctpNoDelay();
  
  public abstract SctpChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract SctpChannelConfig setAutoClose(boolean paramBoolean);
  
  public abstract SctpChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract SctpChannelConfig setConnectTimeoutMillis(int paramInt);
  
  public abstract SctpChannelConfig setInitMaxStreams(SctpStandardSocketOptions.InitMaxStreams paramInitMaxStreams);
  
  @Deprecated
  public abstract SctpChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract SctpChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract SctpChannelConfig setReceiveBufferSize(int paramInt);
  
  public abstract SctpChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  public abstract SctpChannelConfig setSctpNoDelay(boolean paramBoolean);
  
  public abstract SctpChannelConfig setSendBufferSize(int paramInt);
  
  public abstract SctpChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  public abstract SctpChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  public abstract SctpChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract SctpChannelConfig setWriteSpinCount(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\SctpChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */