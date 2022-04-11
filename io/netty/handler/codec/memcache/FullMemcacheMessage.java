package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;

public abstract interface FullMemcacheMessage
  extends MemcacheMessage, LastMemcacheContent
{
  public abstract FullMemcacheMessage copy();
  
  public abstract FullMemcacheMessage duplicate();
  
  public abstract FullMemcacheMessage replace(ByteBuf paramByteBuf);
  
  public abstract FullMemcacheMessage retain();
  
  public abstract FullMemcacheMessage retain(int paramInt);
  
  public abstract FullMemcacheMessage retainedDuplicate();
  
  public abstract FullMemcacheMessage touch();
  
  public abstract FullMemcacheMessage touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\FullMemcacheMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */