package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.jboss.marshalling.Marshaller;

@ChannelHandler.a
public class MarshallingEncoder
  extends MessageToByteEncoder<Object>
{
  private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
  private final MarshallerProvider provider;
  
  public MarshallingEncoder(MarshallerProvider paramMarshallerProvider)
  {
    this.provider = paramMarshallerProvider;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ByteBuf paramByteBuf)
    throws Exception
  {
    paramChannelHandlerContext = this.provider.getMarshaller(paramChannelHandlerContext);
    int i = paramByteBuf.writerIndex();
    paramByteBuf.writeBytes(LENGTH_PLACEHOLDER);
    paramChannelHandlerContext.start(new ChannelBufferByteOutput(paramByteBuf));
    paramChannelHandlerContext.writeObject(paramObject);
    paramChannelHandlerContext.finish();
    paramChannelHandlerContext.close();
    paramByteBuf.setInt(i, paramByteBuf.writerIndex() - i - 4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\MarshallingEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */