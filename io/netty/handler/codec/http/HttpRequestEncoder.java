package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.CharsetUtil;

public class HttpRequestEncoder
  extends HttpObjectEncoder<HttpRequest>
{
  private static final char QUESTION_MARK = '?';
  private static final char SLASH = '/';
  private static final int SLASH_AND_SPACE_SHORT = 12064;
  private static final int SPACE_SLASH_AND_SPACE_MEDIUM = 2109216;
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool;
    if ((super.acceptOutboundMessage(paramObject)) && (!(paramObject instanceof HttpResponse))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void encodeInitialLine(ByteBuf paramByteBuf, HttpRequest paramHttpRequest)
    throws Exception
  {
    ByteBufUtil.copy(paramHttpRequest.method().asciiName(), paramByteBuf);
    String str = paramHttpRequest.uri();
    if (str.isEmpty())
    {
      ByteBufUtil.writeMediumBE(paramByteBuf, 2109216);
    }
    else
    {
      int i = str.indexOf("://");
      int j = 0;
      Object localObject = str;
      int k = j;
      if (i != -1)
      {
        localObject = str;
        k = j;
        if (str.charAt(0) != '/')
        {
          i += 3;
          int m = str.indexOf('?', i);
          if (m == -1)
          {
            localObject = str;
            k = j;
            if (str.lastIndexOf('/') < i)
            {
              k = 1;
              localObject = str;
            }
          }
          else
          {
            localObject = str;
            k = j;
            if (str.lastIndexOf('/', m) < i)
            {
              localObject = new StringBuilder(str).insert(m, '/');
              k = j;
            }
          }
        }
      }
      paramByteBuf.writeByte(32).writeCharSequence((CharSequence)localObject, CharsetUtil.UTF_8);
      if (k != 0) {
        ByteBufUtil.writeShortBE(paramByteBuf, 12064);
      } else {
        paramByteBuf.writeByte(32);
      }
    }
    paramHttpRequest.protocolVersion().encode(paramByteBuf);
    ByteBufUtil.writeShortBE(paramByteBuf, 3338);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpRequestEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */