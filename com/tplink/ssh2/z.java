package com.tplink.ssh2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class z
  extends MessageToByteEncoder<byte[]>
{
  protected void a(ChannelHandlerContext paramChannelHandlerContext, byte[] paramArrayOfByte, ByteBuf paramByteBuf)
    throws Exception
  {
    if (paramArrayOfByte == null) {
      return;
    }
    paramChannelHandlerContext = ByteBufAllocator.DEFAULT.ioBuffer(paramArrayOfByte.length);
    paramChannelHandlerContext.writeBytes(paramArrayOfByte);
    paramByteBuf.writeBytes(paramChannelHandlerContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ssh2\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */