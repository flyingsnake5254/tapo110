package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public abstract interface LastSmtpContent
  extends SmtpContent
{
  public static final LastSmtpContent EMPTY_LAST_CONTENT = new LastSmtpContent()
  {
    public ByteBuf content()
    {
      return Unpooled.EMPTY_BUFFER;
    }
    
    public LastSmtpContent copy()
    {
      return this;
    }
    
    public LastSmtpContent duplicate()
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
    
    public LastSmtpContent replace(ByteBuf paramAnonymousByteBuf)
    {
      return new DefaultLastSmtpContent(paramAnonymousByteBuf);
    }
    
    public LastSmtpContent retain()
    {
      return this;
    }
    
    public LastSmtpContent retain(int paramAnonymousInt)
    {
      return this;
    }
    
    public LastSmtpContent retainedDuplicate()
    {
      return this;
    }
    
    public LastSmtpContent touch()
    {
      return this;
    }
    
    public LastSmtpContent touch(Object paramAnonymousObject)
    {
      return this;
    }
  };
  
  public abstract LastSmtpContent copy();
  
  public abstract LastSmtpContent duplicate();
  
  public abstract LastSmtpContent replace(ByteBuf paramByteBuf);
  
  public abstract LastSmtpContent retain();
  
  public abstract LastSmtpContent retain(int paramInt);
  
  public abstract LastSmtpContent retainedDuplicate();
  
  public abstract LastSmtpContent touch();
  
  public abstract LastSmtpContent touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\LastSmtpContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */