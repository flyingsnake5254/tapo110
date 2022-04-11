package io.netty.handler.codec.bytes;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

public class ByteArrayDecoder
  extends MessageToMessageDecoder<ByteBuf>
{
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    paramList.add(ByteBufUtil.getBytes(paramByteBuf));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\bytes\ByteArrayDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */