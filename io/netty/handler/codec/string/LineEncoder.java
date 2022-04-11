package io.netty.handler.codec.string;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;

@ChannelHandler.a
public class LineEncoder
  extends MessageToMessageEncoder<CharSequence>
{
  private final Charset charset;
  private final byte[] lineSeparator;
  
  public LineEncoder()
  {
    this(LineSeparator.DEFAULT, CharsetUtil.UTF_8);
  }
  
  public LineEncoder(LineSeparator paramLineSeparator)
  {
    this(paramLineSeparator, CharsetUtil.UTF_8);
  }
  
  public LineEncoder(LineSeparator paramLineSeparator, Charset paramCharset)
  {
    this.charset = ((Charset)ObjectUtil.checkNotNull(paramCharset, "charset"));
    this.lineSeparator = ((LineSeparator)ObjectUtil.checkNotNull(paramLineSeparator, "lineSeparator")).value().getBytes(paramCharset);
  }
  
  public LineEncoder(Charset paramCharset)
  {
    this(LineSeparator.DEFAULT, paramCharset);
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, CharSequence paramCharSequence, List<Object> paramList)
    throws Exception
  {
    paramChannelHandlerContext = ByteBufUtil.encodeString(paramChannelHandlerContext.alloc(), CharBuffer.wrap(paramCharSequence), this.charset, this.lineSeparator.length);
    paramChannelHandlerContext.writeBytes(this.lineSeparator);
    paramList.add(paramChannelHandlerContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\string\LineEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */