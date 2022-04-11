package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class DatagramPacketDecoder
  extends MessageToMessageDecoder<DatagramPacket>
{
  private final MessageToMessageDecoder<ByteBuf> decoder;
  
  public DatagramPacketDecoder(MessageToMessageDecoder<ByteBuf> paramMessageToMessageDecoder)
  {
    this.decoder = ((MessageToMessageDecoder)ObjectUtil.checkNotNull(paramMessageToMessageDecoder, "decoder"));
  }
  
  public boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof DatagramPacket)) {
      return this.decoder.acceptInboundMessage(((DatagramPacket)paramObject).content());
    }
    return false;
  }
  
  public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.channelActive(paramChannelHandlerContext);
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.channelInactive(paramChannelHandlerContext);
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.channelReadComplete(paramChannelHandlerContext);
  }
  
  public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.channelRegistered(paramChannelHandlerContext);
  }
  
  public void channelUnregistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.channelUnregistered(paramChannelHandlerContext);
  }
  
  public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.channelWritabilityChanged(paramChannelHandlerContext);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, DatagramPacket paramDatagramPacket, List<Object> paramList)
    throws Exception
  {
    this.decoder.decode(paramChannelHandlerContext, paramDatagramPacket.content(), paramList);
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    this.decoder.exceptionCaught(paramChannelHandlerContext, paramThrowable);
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.handlerAdded(paramChannelHandlerContext);
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.handlerRemoved(paramChannelHandlerContext);
  }
  
  public boolean isSharable()
  {
    return this.decoder.isSharable();
  }
  
  public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    this.decoder.userEventTriggered(paramChannelHandlerContext, paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\DatagramPacketDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */