package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

public abstract interface SmtpContent
  extends ByteBufHolder
{
  public abstract SmtpContent copy();
  
  public abstract SmtpContent duplicate();
  
  public abstract SmtpContent replace(ByteBuf paramByteBuf);
  
  public abstract SmtpContent retain();
  
  public abstract SmtpContent retain(int paramInt);
  
  public abstract SmtpContent retainedDuplicate();
  
  public abstract SmtpContent touch();
  
  public abstract SmtpContent touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\SmtpContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */