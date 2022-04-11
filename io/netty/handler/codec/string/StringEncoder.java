package io.netty.handler.codec.string;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;

@ChannelHandler.a
public class StringEncoder
  extends MessageToMessageEncoder<CharSequence>
{
  private final Charset charset;
  
  public StringEncoder()
  {
    this(Charset.defaultCharset());
  }
  
  public StringEncoder(Charset paramCharset)
  {
    this.charset = ((Charset)ObjectUtil.checkNotNull(paramCharset, "charset"));
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, CharSequence paramCharSequence, List<Object> paramList)
    throws Exception
  {
    if (paramCharSequence.length() == 0) {
      return;
    }
    paramList.add(ByteBufUtil.encodeString(paramChannelHandlerContext.alloc(), CharBuffer.wrap(paramCharSequence), this.charset));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\string\StringEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */