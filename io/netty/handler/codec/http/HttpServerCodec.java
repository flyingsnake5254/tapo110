package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.CombinedChannelDuplexHandler;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public final class HttpServerCodec
  extends CombinedChannelDuplexHandler<HttpRequestDecoder, HttpResponseEncoder>
  implements HttpServerUpgradeHandler.SourceCodec
{
  private final Queue<HttpMethod> queue = new ArrayDeque();
  
  public HttpServerCodec()
  {
    this(4096, 8192, 8192);
  }
  
  public HttpServerCodec(int paramInt1, int paramInt2, int paramInt3)
  {
    init(new HttpServerRequestDecoder(paramInt1, paramInt2, paramInt3), new HttpServerResponseEncoder(null));
  }
  
  public HttpServerCodec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    init(new HttpServerRequestDecoder(paramInt1, paramInt2, paramInt3, paramBoolean), new HttpServerResponseEncoder(null));
  }
  
  public HttpServerCodec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    init(new HttpServerRequestDecoder(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4), new HttpServerResponseEncoder(null));
  }
  
  public HttpServerCodec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    init(new HttpServerRequestDecoder(paramInt1, paramInt2, paramInt3, paramBoolean1, paramInt4, paramBoolean2), new HttpServerResponseEncoder(null));
  }
  
  public void upgradeFrom(ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext.pipeline().remove(this);
  }
  
  private final class HttpServerRequestDecoder
    extends HttpRequestDecoder
  {
    HttpServerRequestDecoder(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }
    
    HttpServerRequestDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      super(paramInt2, paramInt3, paramBoolean);
    }
    
    HttpServerRequestDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
    {
      super(paramInt2, paramInt3, paramBoolean, paramInt4);
    }
    
    HttpServerRequestDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
    {
      super(paramInt2, paramInt3, paramBoolean1, paramInt4, paramBoolean2);
    }
    
    protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
      throws Exception
    {
      int i = paramList.size();
      super.decode(paramChannelHandlerContext, paramByteBuf, paramList);
      int j = paramList.size();
      while (i < j)
      {
        paramChannelHandlerContext = paramList.get(i);
        if ((paramChannelHandlerContext instanceof HttpRequest)) {
          HttpServerCodec.this.queue.add(((HttpRequest)paramChannelHandlerContext).method());
        }
        i++;
      }
    }
  }
  
  private final class HttpServerResponseEncoder
    extends HttpResponseEncoder
  {
    private HttpMethod method;
    
    private HttpServerResponseEncoder() {}
    
    protected boolean isContentAlwaysEmpty(HttpResponse paramHttpResponse)
    {
      HttpMethod localHttpMethod = (HttpMethod)HttpServerCodec.this.queue.poll();
      this.method = localHttpMethod;
      boolean bool;
      if ((!HttpMethod.HEAD.equals(localHttpMethod)) && (!super.isContentAlwaysEmpty(paramHttpResponse))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    protected void sanitizeHeadersBeforeEncode(HttpResponse paramHttpResponse, boolean paramBoolean)
    {
      if ((!paramBoolean) && (HttpMethod.CONNECT.equals(this.method)) && (paramHttpResponse.status().codeClass() == HttpStatusClass.SUCCESS))
      {
        paramHttpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
        return;
      }
      super.sanitizeHeadersBeforeEncode(paramHttpResponse, paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpServerCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */