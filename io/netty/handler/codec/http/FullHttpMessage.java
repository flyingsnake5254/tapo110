package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;

public abstract interface FullHttpMessage
  extends HttpMessage, LastHttpContent
{
  public abstract FullHttpMessage copy();
  
  public abstract FullHttpMessage duplicate();
  
  public abstract FullHttpMessage replace(ByteBuf paramByteBuf);
  
  public abstract FullHttpMessage retain();
  
  public abstract FullHttpMessage retain(int paramInt);
  
  public abstract FullHttpMessage retainedDuplicate();
  
  public abstract FullHttpMessage touch();
  
  public abstract FullHttpMessage touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\FullHttpMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */