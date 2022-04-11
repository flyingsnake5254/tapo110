package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;

public class DefaultSmtpContent
  extends DefaultByteBufHolder
  implements SmtpContent
{
  public DefaultSmtpContent(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public SmtpContent copy()
  {
    return (SmtpContent)super.copy();
  }
  
  public SmtpContent duplicate()
  {
    return (SmtpContent)super.duplicate();
  }
  
  public SmtpContent replace(ByteBuf paramByteBuf)
  {
    return new DefaultSmtpContent(paramByteBuf);
  }
  
  public SmtpContent retain()
  {
    super.retain();
    return this;
  }
  
  public SmtpContent retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public SmtpContent retainedDuplicate()
  {
    return (SmtpContent)super.retainedDuplicate();
  }
  
  public SmtpContent touch()
  {
    super.touch();
    return this;
  }
  
  public SmtpContent touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\DefaultSmtpContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */