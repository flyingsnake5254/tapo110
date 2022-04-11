package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

public class SctpInboundByteStreamHandler
  extends MessageToMessageDecoder<SctpMessage>
{
  private final int protocolIdentifier;
  private final int streamIdentifier;
  
  public SctpInboundByteStreamHandler(int paramInt1, int paramInt2)
  {
    this.protocolIdentifier = paramInt1;
    this.streamIdentifier = paramInt2;
  }
  
  protected boolean acceptInboundMessage(SctpMessage paramSctpMessage)
  {
    boolean bool;
    if ((paramSctpMessage.protocolIdentifier() == this.protocolIdentifier) && (paramSctpMessage.streamIdentifier() == this.streamIdentifier)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    if (super.acceptInboundMessage(paramObject)) {
      return acceptInboundMessage((SctpMessage)paramObject);
    }
    return false;
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, SctpMessage paramSctpMessage, List<Object> paramList)
    throws Exception
  {
    if (paramSctpMessage.isComplete())
    {
      paramList.add(paramSctpMessage.content().retain());
      return;
    }
    throw new CodecException(String.format("Received SctpMessage is not complete, please add %s in the pipeline before this handler", new Object[] { SctpMessageCompletionHandler.class.getSimpleName() }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\sctp\SctpInboundByteStreamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */