package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

public class HttpResponseEncoder
  extends HttpObjectEncoder<HttpResponse>
{
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool;
    if ((super.acceptOutboundMessage(paramObject)) && (!(paramObject instanceof HttpRequest))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void encodeInitialLine(ByteBuf paramByteBuf, HttpResponse paramHttpResponse)
    throws Exception
  {
    paramHttpResponse.protocolVersion().encode(paramByteBuf);
    paramByteBuf.writeByte(32);
    paramHttpResponse.status().encode(paramByteBuf);
    ByteBufUtil.writeShortBE(paramByteBuf, 3338);
  }
  
  protected boolean isContentAlwaysEmpty(HttpResponse paramHttpResponse)
  {
    HttpResponseStatus localHttpResponseStatus = paramHttpResponse.status();
    HttpStatusClass localHttpStatusClass1 = localHttpResponseStatus.codeClass();
    HttpStatusClass localHttpStatusClass2 = HttpStatusClass.INFORMATIONAL;
    boolean bool1 = true;
    if (localHttpStatusClass1 == localHttpStatusClass2)
    {
      if (localHttpResponseStatus.code() == HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
        return paramHttpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_VERSION);
      }
      return true;
    }
    boolean bool2 = bool1;
    if (localHttpResponseStatus.code() != HttpResponseStatus.NO_CONTENT.code())
    {
      bool2 = bool1;
      if (localHttpResponseStatus.code() != HttpResponseStatus.NOT_MODIFIED.code()) {
        if (localHttpResponseStatus.code() == HttpResponseStatus.RESET_CONTENT.code()) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
    }
    return bool2;
  }
  
  protected void sanitizeHeadersBeforeEncode(HttpResponse paramHttpResponse, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      HttpResponseStatus localHttpResponseStatus = paramHttpResponse.status();
      if ((localHttpResponseStatus.codeClass() != HttpStatusClass.INFORMATIONAL) && (localHttpResponseStatus.code() != HttpResponseStatus.NO_CONTENT.code()))
      {
        if (localHttpResponseStatus.code() == HttpResponseStatus.RESET_CONTENT.code())
        {
          paramHttpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
          paramHttpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, 0);
        }
      }
      else
      {
        paramHttpResponse.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
        paramHttpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpResponseEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */