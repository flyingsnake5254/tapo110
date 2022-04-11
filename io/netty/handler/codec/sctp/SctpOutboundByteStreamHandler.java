package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

public class SctpOutboundByteStreamHandler
  extends MessageToMessageEncoder<ByteBuf>
{
  private final int protocolIdentifier;
  private final int streamIdentifier;
  private final boolean unordered;
  
  public SctpOutboundByteStreamHandler(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, false);
  }
  
  public SctpOutboundByteStreamHandler(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.streamIdentifier = paramInt1;
    this.protocolIdentifier = paramInt2;
    this.unordered = paramBoolean;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    paramList.add(new SctpMessage(this.protocolIdentifier, this.streamIdentifier, this.unordered, paramByteBuf.retain()));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\sctp\SctpOutboundByteStreamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */