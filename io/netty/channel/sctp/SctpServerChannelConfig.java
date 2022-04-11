package io.netty.channel.sctp;

import com.sun.nio.sctp.SctpStandardSocketOptions.InitMaxStreams;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public abstract interface SctpServerChannelConfig
  extends ChannelConfig
{
  public abstract int getBacklog();
  
  public abstract SctpStandardSocketOptions.InitMaxStreams getInitMaxStreams();
  
  public abstract int getReceiveBufferSize();
  
  public abstract int getSendBufferSize();
  
  public abstract SctpServerChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  public abstract SctpServerChannelConfig setAutoClose(boolean paramBoolean);
  
  public abstract SctpServerChannelConfig setAutoRead(boolean paramBoolean);
  
  public abstract SctpServerChannelConfig setBacklog(int paramInt);
  
  public abstract SctpServerChannelConfig setConnectTimeoutMillis(int paramInt);
  
  public abstract SctpServerChannelConfig setInitMaxStreams(SctpStandardSocketOptions.InitMaxStreams paramInitMaxStreams);
  
  @Deprecated
  public abstract SctpServerChannelConfig setMaxMessagesPerRead(int paramInt);
  
  public abstract SctpServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  public abstract SctpServerChannelConfig setReceiveBufferSize(int paramInt);
  
  public abstract SctpServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  public abstract SctpServerChannelConfig setSendBufferSize(int paramInt);
  
  public abstract SctpServerChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  public abstract SctpServerChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  public abstract SctpServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  public abstract SctpServerChannelConfig setWriteSpinCount(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\SctpServerChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */