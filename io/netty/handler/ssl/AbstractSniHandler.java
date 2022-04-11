package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import java.util.Locale;

public abstract class AbstractSniHandler<T>
  extends SslClientHelloHandler<T>
{
  private String hostname;
  
  private static String extractSniHostname(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readerIndex();
    int j = paramByteBuf.writerIndex();
    i += 34;
    if (j - i >= 6)
    {
      i += paramByteBuf.getUnsignedByte(i) + 1;
      i += paramByteBuf.getUnsignedShort(i) + 2;
      i += paramByteBuf.getUnsignedByte(i) + 1;
      int k = paramByteBuf.getUnsignedShort(i);
      i += 2;
      k += i;
      if (k <= j) {
        while (k - i >= 4)
        {
          j = paramByteBuf.getUnsignedShort(i);
          int m = i + 2;
          i = paramByteBuf.getUnsignedShort(m);
          m += 2;
          if (k - m < i) {
            break;
          }
          if (j == 0)
          {
            j = m + 2;
            if (k - j < 3) {
              break;
            }
            i = paramByteBuf.getUnsignedByte(j);
            j++;
            if (i != 0) {
              break;
            }
            i = paramByteBuf.getUnsignedShort(j);
            j += 2;
            if (k - j < i) {
              break;
            }
            return paramByteBuf.toString(j, i, CharsetUtil.US_ASCII).toLowerCase(Locale.US);
          }
          i = m + i;
        }
      }
    }
    return null;
  }
  
  private void fireSniCompletionEvent(ChannelHandlerContext paramChannelHandlerContext, String paramString, Future<T> paramFuture)
  {
    paramFuture = paramFuture.cause();
    if (paramFuture == null) {
      paramChannelHandlerContext.fireUserEventTriggered(new SniCompletionEvent(paramString));
    } else {
      paramChannelHandlerContext.fireUserEventTriggered(new SniCompletionEvent(paramString, paramFuture));
    }
  }
  
  protected Future<T> lookup(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    if (paramByteBuf == null) {
      paramByteBuf = null;
    } else {
      paramByteBuf = extractSniHostname(paramByteBuf);
    }
    this.hostname = paramByteBuf;
    return lookup(paramChannelHandlerContext, paramByteBuf);
  }
  
  protected abstract Future<T> lookup(ChannelHandlerContext paramChannelHandlerContext, String paramString)
    throws Exception;
  
  protected void onLookupComplete(ChannelHandlerContext paramChannelHandlerContext, Future<T> paramFuture)
    throws Exception
  {
    fireSniCompletionEvent(paramChannelHandlerContext, this.hostname, paramFuture);
    onLookupComplete(paramChannelHandlerContext, this.hostname, paramFuture);
  }
  
  protected abstract void onLookupComplete(ChannelHandlerContext paramChannelHandlerContext, String paramString, Future<T> paramFuture)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\AbstractSniHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */