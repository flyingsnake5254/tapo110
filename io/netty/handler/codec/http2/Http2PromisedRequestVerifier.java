package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;

public abstract interface Http2PromisedRequestVerifier
{
  public static final Http2PromisedRequestVerifier ALWAYS_VERIFY = new Http2PromisedRequestVerifier()
  {
    public boolean isAuthoritative(ChannelHandlerContext paramAnonymousChannelHandlerContext, Http2Headers paramAnonymousHttp2Headers)
    {
      return true;
    }
    
    public boolean isCacheable(Http2Headers paramAnonymousHttp2Headers)
    {
      return true;
    }
    
    public boolean isSafe(Http2Headers paramAnonymousHttp2Headers)
    {
      return true;
    }
  };
  
  public abstract boolean isAuthoritative(ChannelHandlerContext paramChannelHandlerContext, Http2Headers paramHttp2Headers);
  
  public abstract boolean isCacheable(Http2Headers paramHttp2Headers);
  
  public abstract boolean isSafe(Http2Headers paramHttp2Headers);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2PromisedRequestVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */