package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

public class DatagramPacketEncoder<M>
  extends MessageToMessageEncoder<AddressedEnvelope<M, InetSocketAddress>>
{
  private final MessageToMessageEncoder<? super M> encoder;
  
  public DatagramPacketEncoder(MessageToMessageEncoder<? super M> paramMessageToMessageEncoder)
  {
    this.encoder = ((MessageToMessageEncoder)ObjectUtil.checkNotNull(paramMessageToMessageEncoder, "encoder"));
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool1 = super.acceptOutboundMessage(paramObject);
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (AddressedEnvelope)paramObject;
      bool3 = bool2;
      if (this.encoder.acceptOutboundMessage(((AddressedEnvelope)paramObject).content())) {
        if (!(((AddressedEnvelope)paramObject).sender() instanceof InetSocketAddress))
        {
          bool3 = bool2;
          if (((AddressedEnvelope)paramObject).sender() != null) {}
        }
        else
        {
          bool3 = bool2;
          if ((((AddressedEnvelope)paramObject).recipient() instanceof InetSocketAddress)) {
            bool3 = true;
          }
        }
      }
    }
    return bool3;
  }
  
  public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    throws Exception
  {
    this.encoder.bind(paramChannelHandlerContext, paramSocketAddress, paramChannelPromise);
  }
  
  public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    this.encoder.close(paramChannelHandlerContext, paramChannelPromise);
  }
  
  public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    throws Exception
  {
    this.encoder.connect(paramChannelHandlerContext, paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    this.encoder.deregister(paramChannelHandlerContext, paramChannelPromise);
  }
  
  public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    this.encoder.disconnect(paramChannelHandlerContext, paramChannelPromise);
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, AddressedEnvelope<M, InetSocketAddress> paramAddressedEnvelope, List<Object> paramList)
    throws Exception
  {
    this.encoder.encode(paramChannelHandlerContext, paramAddressedEnvelope.content(), paramList);
    if (paramList.size() == 1)
    {
      paramChannelHandlerContext = paramList.get(0);
      if ((paramChannelHandlerContext instanceof ByteBuf))
      {
        paramList.set(0, new DatagramPacket((ByteBuf)paramChannelHandlerContext, (InetSocketAddress)paramAddressedEnvelope.recipient(), (InetSocketAddress)paramAddressedEnvelope.sender()));
        return;
      }
      paramChannelHandlerContext = new StringBuilder();
      paramChannelHandlerContext.append(StringUtil.simpleClassName(this.encoder));
      paramChannelHandlerContext.append(" must produce only ByteBuf.");
      throw new EncoderException(paramChannelHandlerContext.toString());
    }
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append(StringUtil.simpleClassName(this.encoder));
    paramChannelHandlerContext.append(" must produce only one message.");
    throw new EncoderException(paramChannelHandlerContext.toString());
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    this.encoder.exceptionCaught(paramChannelHandlerContext, paramThrowable);
  }
  
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.encoder.flush(paramChannelHandlerContext);
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.encoder.handlerAdded(paramChannelHandlerContext);
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.encoder.handlerRemoved(paramChannelHandlerContext);
  }
  
  public boolean isSharable()
  {
    return this.encoder.isSharable();
  }
  
  public void read(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.encoder.read(paramChannelHandlerContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\DatagramPacketEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */