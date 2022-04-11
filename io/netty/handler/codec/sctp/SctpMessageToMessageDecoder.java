package io.netty.handler.codec.sctp;

import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageDecoder;

public abstract class SctpMessageToMessageDecoder
  extends MessageToMessageDecoder<SctpMessage>
{
  public boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof SctpMessage))
    {
      if (((SctpMessage)paramObject).isComplete()) {
        return true;
      }
      throw new CodecException(String.format("Received SctpMessage is not complete, please add %s in the pipeline before this handler", new Object[] { SctpMessageCompletionHandler.class.getSimpleName() }));
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\sctp\SctpMessageToMessageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */