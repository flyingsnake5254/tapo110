package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;

public class HttpContentCompressor
  extends HttpContentEncoder
{
  private final int compressionLevel;
  private final int contentSizeThreshold;
  private ChannelHandlerContext ctx;
  private final int memLevel;
  private final int windowBits;
  
  public HttpContentCompressor()
  {
    this(6);
  }
  
  public HttpContentCompressor(int paramInt)
  {
    this(paramInt, 15, 8, 0);
  }
  
  public HttpContentCompressor(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, 0);
  }
  
  public HttpContentCompressor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= 9))
    {
      if ((paramInt2 >= 9) && (paramInt2 <= 15))
      {
        if ((paramInt3 >= 1) && (paramInt3 <= 9))
        {
          if (paramInt4 >= 0)
          {
            this.compressionLevel = paramInt1;
            this.windowBits = paramInt2;
            this.memLevel = paramInt3;
            this.contentSizeThreshold = paramInt4;
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("contentSizeThreshold: ");
          localStringBuilder.append(paramInt4);
          localStringBuilder.append(" (expected: non negative number)");
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("memLevel: ");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(" (expected: 1-9)");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("windowBits: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" (expected: 9-15)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compressionLevel: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" (expected: 0-9)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected HttpContentEncoder.Result beginEncode(HttpResponse paramHttpResponse, String paramString)
    throws Exception
  {
    if ((this.contentSizeThreshold > 0) && ((paramHttpResponse instanceof HttpContent)) && (((HttpContent)paramHttpResponse).content().readableBytes() < this.contentSizeThreshold)) {
      return null;
    }
    if (paramHttpResponse.headers().get(HttpHeaderNames.CONTENT_ENCODING) != null) {
      return null;
    }
    paramString = determineWrapper(paramString);
    if (paramString == null) {
      return null;
    }
    int i = 1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[paramString.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        paramHttpResponse = "deflate";
      } else {
        throw new Error();
      }
    }
    else {
      paramHttpResponse = "gzip";
    }
    return new HttpContentEncoder.Result(paramHttpResponse, new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), new ChannelHandler[] { ZlibCodecFactory.newZlibEncoder(paramString, this.compressionLevel, this.windowBits, this.memLevel) }));
  }
  
  protected ZlibWrapper determineWrapper(String paramString)
  {
    paramString = paramString.split(",");
    int i = paramString.length;
    int j = 0;
    float f1 = -1.0F;
    float f2 = -1.0F;
    float f7;
    for (float f3 = -1.0F;; f3 = f7)
    {
      float f4 = 0.0F;
      if (j >= i) {
        break;
      }
      Object localObject = paramString[j];
      int k = ((String)localObject).indexOf('=');
      float f5;
      if (k != -1) {
        try
        {
          f5 = Float.parseFloat(((String)localObject).substring(k + 1));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          f5 = f4;
        }
      } else {
        f5 = 1.0F;
      }
      float f6;
      if (((String)localObject).contains("*"))
      {
        f6 = f1;
        f4 = f2;
        f7 = f5;
      }
      else if ((((String)localObject).contains("gzip")) && (f5 > f1))
      {
        f6 = f5;
        f4 = f2;
        f7 = f3;
      }
      else
      {
        f6 = f1;
        f4 = f2;
        f7 = f3;
        if (((String)localObject).contains("deflate"))
        {
          f6 = f1;
          f4 = f2;
          f7 = f3;
          if (f5 > f2)
          {
            f7 = f3;
            f4 = f5;
            f6 = f1;
          }
        }
      }
      j++;
      f1 = f6;
      f2 = f4;
    }
    if ((f1 <= 0.0F) && (f2 <= 0.0F))
    {
      if (f3 > 0.0F)
      {
        if (f1 == -1.0F) {
          return ZlibWrapper.GZIP;
        }
        if (f2 == -1.0F) {
          return ZlibWrapper.ZLIB;
        }
      }
      return null;
    }
    if (f1 >= f2) {
      return ZlibWrapper.GZIP;
    }
    return ZlibWrapper.ZLIB;
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpContentCompressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */