package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

@ChannelHandler.a
public class Base64Decoder
  extends MessageToMessageDecoder<ByteBuf>
{
  private final Base64Dialect dialect;
  
  public Base64Decoder()
  {
    this(Base64Dialect.STANDARD);
  }
  
  public Base64Decoder(Base64Dialect paramBase64Dialect)
  {
    this.dialect = ((Base64Dialect)ObjectUtil.checkNotNull(paramBase64Dialect, "dialect"));
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    paramList.add(Base64.decode(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes(), this.dialect));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\base64\Base64Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */