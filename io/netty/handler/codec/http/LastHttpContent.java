package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;

public abstract interface LastHttpContent
  extends HttpContent
{
  public static final LastHttpContent EMPTY_LAST_CONTENT = new LastHttpContent()
  {
    public ByteBuf content()
    {
      return Unpooled.EMPTY_BUFFER;
    }
    
    public LastHttpContent copy()
    {
      return LastHttpContent.EMPTY_LAST_CONTENT;
    }
    
    public DecoderResult decoderResult()
    {
      return DecoderResult.SUCCESS;
    }
    
    public LastHttpContent duplicate()
    {
      return this;
    }
    
    @Deprecated
    public DecoderResult getDecoderResult()
    {
      return decoderResult();
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
    
    public LastHttpContent replace(ByteBuf paramAnonymousByteBuf)
    {
      return new DefaultLastHttpContent(paramAnonymousByteBuf);
    }
    
    public LastHttpContent retain()
    {
      return this;
    }
    
    public LastHttpContent retain(int paramAnonymousInt)
    {
      return this;
    }
    
    public LastHttpContent retainedDuplicate()
    {
      return this;
    }
    
    public void setDecoderResult(DecoderResult paramAnonymousDecoderResult)
    {
      throw new UnsupportedOperationException("read only");
    }
    
    public String toString()
    {
      return "EmptyLastHttpContent";
    }
    
    public LastHttpContent touch()
    {
      return this;
    }
    
    public LastHttpContent touch(Object paramAnonymousObject)
    {
      return this;
    }
    
    public HttpHeaders trailingHeaders()
    {
      return EmptyHttpHeaders.INSTANCE;
    }
  };
  
  public abstract LastHttpContent copy();
  
  public abstract LastHttpContent duplicate();
  
  public abstract LastHttpContent replace(ByteBuf paramByteBuf);
  
  public abstract LastHttpContent retain();
  
  public abstract LastHttpContent retain(int paramInt);
  
  public abstract LastHttpContent retainedDuplicate();
  
  public abstract LastHttpContent touch();
  
  public abstract LastHttpContent touch(Object paramObject);
  
  public abstract HttpHeaders trailingHeaders();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\LastHttpContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */