package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;

public abstract interface LastMemcacheContent
  extends MemcacheContent
{
  public static final LastMemcacheContent EMPTY_LAST_CONTENT = new LastMemcacheContent()
  {
    public ByteBuf content()
    {
      return Unpooled.EMPTY_BUFFER;
    }
    
    public LastMemcacheContent copy()
    {
      return LastMemcacheContent.EMPTY_LAST_CONTENT;
    }
    
    public DecoderResult decoderResult()
    {
      return DecoderResult.SUCCESS;
    }
    
    public LastMemcacheContent duplicate()
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
    
    public LastMemcacheContent replace(ByteBuf paramAnonymousByteBuf)
    {
      return new DefaultLastMemcacheContent(paramAnonymousByteBuf);
    }
    
    public LastMemcacheContent retain()
    {
      return this;
    }
    
    public LastMemcacheContent retain(int paramAnonymousInt)
    {
      return this;
    }
    
    public LastMemcacheContent retainedDuplicate()
    {
      return this;
    }
    
    public void setDecoderResult(DecoderResult paramAnonymousDecoderResult)
    {
      throw new UnsupportedOperationException("read only");
    }
    
    public LastMemcacheContent touch()
    {
      return this;
    }
    
    public LastMemcacheContent touch(Object paramAnonymousObject)
    {
      return this;
    }
  };
  
  public abstract LastMemcacheContent copy();
  
  public abstract LastMemcacheContent duplicate();
  
  public abstract LastMemcacheContent replace(ByteBuf paramByteBuf);
  
  public abstract LastMemcacheContent retain();
  
  public abstract LastMemcacheContent retain(int paramInt);
  
  public abstract LastMemcacheContent retainedDuplicate();
  
  public abstract LastMemcacheContent touch();
  
  public abstract LastMemcacheContent touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\LastMemcacheContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */