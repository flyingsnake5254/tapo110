package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;

public abstract interface LastStompContentSubframe
  extends StompContentSubframe
{
  public static final LastStompContentSubframe EMPTY_LAST_CONTENT = new LastStompContentSubframe()
  {
    public ByteBuf content()
    {
      return Unpooled.EMPTY_BUFFER;
    }
    
    public LastStompContentSubframe copy()
    {
      return LastStompContentSubframe.EMPTY_LAST_CONTENT;
    }
    
    public DecoderResult decoderResult()
    {
      return DecoderResult.SUCCESS;
    }
    
    public LastStompContentSubframe duplicate()
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
    
    public LastStompContentSubframe replace(ByteBuf paramAnonymousByteBuf)
    {
      return new DefaultLastStompContentSubframe(paramAnonymousByteBuf);
    }
    
    public LastStompContentSubframe retain()
    {
      return this;
    }
    
    public LastStompContentSubframe retain(int paramAnonymousInt)
    {
      return this;
    }
    
    public LastStompContentSubframe retainedDuplicate()
    {
      return this;
    }
    
    public void setDecoderResult(DecoderResult paramAnonymousDecoderResult)
    {
      throw new UnsupportedOperationException("read only");
    }
    
    public LastStompContentSubframe touch()
    {
      return this;
    }
    
    public LastStompContentSubframe touch(Object paramAnonymousObject)
    {
      return this;
    }
  };
  
  public abstract LastStompContentSubframe copy();
  
  public abstract LastStompContentSubframe duplicate();
  
  public abstract LastStompContentSubframe replace(ByteBuf paramByteBuf);
  
  public abstract LastStompContentSubframe retain();
  
  public abstract LastStompContentSubframe retain(int paramInt);
  
  public abstract LastStompContentSubframe retainedDuplicate();
  
  public abstract LastStompContentSubframe touch();
  
  public abstract LastStompContentSubframe touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\LastStompContentSubframe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */