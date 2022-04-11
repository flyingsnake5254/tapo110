package io.netty.handler.codec.rtsp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObjectEncoder;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;

public class RtspEncoder
  extends HttpObjectEncoder<HttpMessage>
{
  private static final int CRLF_SHORT = 3338;
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool;
    if ((super.acceptOutboundMessage(paramObject)) && (((paramObject instanceof HttpRequest)) || ((paramObject instanceof HttpResponse)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void encodeInitialLine(ByteBuf paramByteBuf, HttpMessage paramHttpMessage)
    throws Exception
  {
    if ((paramHttpMessage instanceof HttpRequest))
    {
      paramHttpMessage = (HttpRequest)paramHttpMessage;
      ByteBufUtil.copy(paramHttpMessage.method().asciiName(), paramByteBuf);
      paramByteBuf.writeByte(32);
      paramByteBuf.writeCharSequence(paramHttpMessage.uri(), CharsetUtil.UTF_8);
      paramByteBuf.writeByte(32);
      paramByteBuf.writeCharSequence(paramHttpMessage.protocolVersion().toString(), CharsetUtil.US_ASCII);
      ByteBufUtil.writeShortBE(paramByteBuf, 3338);
    }
    else
    {
      if (!(paramHttpMessage instanceof HttpResponse)) {
        break label168;
      }
      paramHttpMessage = (HttpResponse)paramHttpMessage;
      String str = paramHttpMessage.protocolVersion().toString();
      Charset localCharset = CharsetUtil.US_ASCII;
      paramByteBuf.writeCharSequence(str, localCharset);
      paramByteBuf.writeByte(32);
      ByteBufUtil.copy(paramHttpMessage.status().codeAsText(), paramByteBuf);
      paramByteBuf.writeByte(32);
      paramByteBuf.writeCharSequence(paramHttpMessage.status().reasonPhrase(), localCharset);
      ByteBufUtil.writeShortBE(paramByteBuf, 3338);
    }
    return;
    label168:
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("Unsupported type ");
    paramByteBuf.append(StringUtil.simpleClassName(paramHttpMessage));
    throw new UnsupportedMessageTypeException(paramByteBuf.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\rtsp\RtspEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */