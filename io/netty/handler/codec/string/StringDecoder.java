package io.netty.handler.codec.string;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.util.List;

@ChannelHandler.a
public class StringDecoder
  extends MessageToMessageDecoder<ByteBuf>
{
  private final Charset charset;
  
  public StringDecoder()
  {
    this(Charset.defaultCharset());
  }
  
  public StringDecoder(Charset paramCharset)
  {
    this.charset = ((Charset)ObjectUtil.checkNotNull(paramCharset, "charset"));
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    paramList.add(paramByteBuf.toString(this.charset));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\string\StringDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */