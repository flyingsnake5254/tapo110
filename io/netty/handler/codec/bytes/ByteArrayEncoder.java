package io.netty.handler.codec.bytes;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

@ChannelHandler.a
public class ByteArrayEncoder
  extends MessageToMessageEncoder<byte[]>
{
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, byte[] paramArrayOfByte, List<Object> paramList)
    throws Exception
  {
    paramList.add(Unpooled.wrappedBuffer(paramArrayOfByte));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\bytes\ByteArrayEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */