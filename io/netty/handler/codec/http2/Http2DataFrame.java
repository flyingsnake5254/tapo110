package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

public abstract interface Http2DataFrame
  extends Http2StreamFrame, ByteBufHolder
{
  public abstract ByteBuf content();
  
  public abstract Http2DataFrame copy();
  
  public abstract Http2DataFrame duplicate();
  
  public abstract int initialFlowControlledBytes();
  
  public abstract boolean isEndStream();
  
  public abstract int padding();
  
  public abstract Http2DataFrame replace(ByteBuf paramByteBuf);
  
  public abstract Http2DataFrame retain();
  
  public abstract Http2DataFrame retain(int paramInt);
  
  public abstract Http2DataFrame retainedDuplicate();
  
  public abstract Http2DataFrame touch();
  
  public abstract Http2DataFrame touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2DataFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */