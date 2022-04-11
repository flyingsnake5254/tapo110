package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;

public abstract interface FullHttpResponse
  extends HttpResponse, FullHttpMessage
{
  public abstract FullHttpResponse copy();
  
  public abstract FullHttpResponse duplicate();
  
  public abstract FullHttpResponse replace(ByteBuf paramByteBuf);
  
  public abstract FullHttpResponse retain();
  
  public abstract FullHttpResponse retain(int paramInt);
  
  public abstract FullHttpResponse retainedDuplicate();
  
  public abstract FullHttpResponse setProtocolVersion(HttpVersion paramHttpVersion);
  
  public abstract FullHttpResponse setStatus(HttpResponseStatus paramHttpResponseStatus);
  
  public abstract FullHttpResponse touch();
  
  public abstract FullHttpResponse touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\FullHttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */