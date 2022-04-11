package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public abstract interface LastBulkStringRedisContent
  extends BulkStringRedisContent
{
  public static final LastBulkStringRedisContent EMPTY_LAST_CONTENT = new LastBulkStringRedisContent()
  {
    public ByteBuf content()
    {
      return Unpooled.EMPTY_BUFFER;
    }
    
    public LastBulkStringRedisContent copy()
    {
      return this;
    }
    
    public LastBulkStringRedisContent duplicate()
    {
      return this;
    }
    
    public int refCnt()
    {
      return 1;
    }
    
    public boolean release()
    {
      return false;
    }
    
    public boolean release(int paramAnonymousInt)
    {
      return false;
    }
    
    public LastBulkStringRedisContent replace(ByteBuf paramAnonymousByteBuf)
    {
      return new DefaultLastBulkStringRedisContent(paramAnonymousByteBuf);
    }
    
    public LastBulkStringRedisContent retain()
    {
      return this;
    }
    
    public LastBulkStringRedisContent retain(int paramAnonymousInt)
    {
      return this;
    }
    
    public LastBulkStringRedisContent retainedDuplicate()
    {
      return this;
    }
    
    public LastBulkStringRedisContent touch()
    {
      return this;
    }
    
    public LastBulkStringRedisContent touch(Object paramAnonymousObject)
    {
      return this;
    }
  };
  
  public abstract LastBulkStringRedisContent copy();
  
  public abstract LastBulkStringRedisContent duplicate();
  
  public abstract LastBulkStringRedisContent replace(ByteBuf paramByteBuf);
  
  public abstract LastBulkStringRedisContent retain();
  
  public abstract LastBulkStringRedisContent retain(int paramInt);
  
  public abstract LastBulkStringRedisContent retainedDuplicate();
  
  public abstract LastBulkStringRedisContent touch();
  
  public abstract LastBulkStringRedisContent touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\LastBulkStringRedisContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */