package com.tplink.ssh2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

public class y
  extends ByteToMessageDecoder
{
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    while (paramByteBuf.isReadable())
    {
      paramChannelHandlerContext = new byte[paramByteBuf.readableBytes()];
      paramByteBuf.readBytes(paramChannelHandlerContext);
      paramList.add(paramChannelHandlerContext);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ssh2\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */