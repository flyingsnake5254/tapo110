package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.jboss.marshalling.Marshaller;

@ChannelHandler.a
public class CompatibleMarshallingEncoder
  extends MessageToByteEncoder<Object>
{
  private final MarshallerProvider provider;
  
  public CompatibleMarshallingEncoder(MarshallerProvider paramMarshallerProvider)
  {
    this.provider = paramMarshallerProvider;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ByteBuf paramByteBuf)
    throws Exception
  {
    paramChannelHandlerContext = this.provider.getMarshaller(paramChannelHandlerContext);
    paramChannelHandlerContext.start(new ChannelBufferByteOutput(paramByteBuf));
    paramChannelHandlerContext.writeObject(paramObject);
    paramChannelHandlerContext.finish();
    paramChannelHandlerContext.close();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\CompatibleMarshallingEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */