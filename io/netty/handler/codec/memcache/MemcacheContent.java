package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

public abstract interface MemcacheContent
  extends a, ByteBufHolder
{
  public abstract MemcacheContent copy();
  
  public abstract MemcacheContent duplicate();
  
  public abstract MemcacheContent replace(ByteBuf paramByteBuf);
  
  public abstract MemcacheContent retain();
  
  public abstract MemcacheContent retain(int paramInt);
  
  public abstract MemcacheContent retainedDuplicate();
  
  public abstract MemcacheContent touch();
  
  public abstract MemcacheContent touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\MemcacheContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */