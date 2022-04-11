package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

@ChannelHandler.a
public class Base64Encoder
  extends MessageToMessageEncoder<ByteBuf>
{
  private final boolean breakLines;
  private final Base64Dialect dialect;
  
  public Base64Encoder()
  {
    this(true);
  }
  
  public Base64Encoder(boolean paramBoolean)
  {
    this(paramBoolean, Base64Dialect.STANDARD);
  }
  
  public Base64Encoder(boolean paramBoolean, Base64Dialect paramBase64Dialect)
  {
    this.dialect = ((Base64Dialect)ObjectUtil.checkNotNull(paramBase64Dialect, "dialect"));
    this.breakLines = paramBoolean;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    paramList.add(Base64.encode(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes(), this.breakLines, this.dialect));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\base64\Base64Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */