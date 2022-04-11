package io.netty.handler.codec.protobuf;

import com.google.protobuf.nano.MessageNano;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.lang.reflect.Constructor;
import java.util.List;

@ChannelHandler.a
public class ProtobufDecoderNano
  extends MessageToMessageDecoder<ByteBuf>
{
  private final Class<? extends MessageNano> clazz;
  
  public ProtobufDecoderNano(Class<? extends MessageNano> paramClass)
  {
    this.clazz = ((Class)ObjectUtil.checkNotNull(paramClass, "You must provide a Class"));
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = paramByteBuf.readableBytes();
    int j;
    if (paramByteBuf.hasArray())
    {
      paramChannelHandlerContext = paramByteBuf.array();
      j = paramByteBuf.arrayOffset() + paramByteBuf.readerIndex();
    }
    else
    {
      paramChannelHandlerContext = ByteBufUtil.getBytes(paramByteBuf, paramByteBuf.readerIndex(), i, false);
      j = 0;
    }
    paramList.add(MessageNano.mergeFrom((MessageNano)this.clazz.getConstructor(new Class[0]).newInstance(new Object[0]), paramChannelHandlerContext, j, i));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\protobuf\ProtobufDecoderNano.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */