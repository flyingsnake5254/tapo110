package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;

public final class DefaultLastSmtpContent
  extends DefaultSmtpContent
  implements LastSmtpContent
{
  public DefaultLastSmtpContent(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public LastSmtpContent copy()
  {
    return (LastSmtpContent)super.copy();
  }
  
  public LastSmtpContent duplicate()
  {
    return (LastSmtpContent)super.duplicate();
  }
  
  public LastSmtpContent replace(ByteBuf paramByteBuf)
  {
    return new DefaultLastSmtpContent(paramByteBuf);
  }
  
  public DefaultLastSmtpContent retain()
  {
    super.retain();
    return this;
  }
  
  public DefaultLastSmtpContent retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public LastSmtpContent retainedDuplicate()
  {
    return (LastSmtpContent)super.retainedDuplicate();
  }
  
  public DefaultLastSmtpContent touch()
  {
    super.touch();
    return this;
  }
  
  public DefaultLastSmtpContent touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\DefaultLastSmtpContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */