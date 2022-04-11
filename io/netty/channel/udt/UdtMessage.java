package io.netty.channel.udt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;

@Deprecated
public final class UdtMessage
  extends DefaultByteBufHolder
{
  public UdtMessage(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public UdtMessage copy()
  {
    return (UdtMessage)super.copy();
  }
  
  public UdtMessage duplicate()
  {
    return (UdtMessage)super.duplicate();
  }
  
  public UdtMessage replace(ByteBuf paramByteBuf)
  {
    return new UdtMessage(paramByteBuf);
  }
  
  public UdtMessage retain()
  {
    super.retain();
    return this;
  }
  
  public UdtMessage retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public UdtMessage retainedDuplicate()
  {
    return (UdtMessage)super.retainedDuplicate();
  }
  
  public UdtMessage touch()
  {
    super.touch();
    return this;
  }
  
  public UdtMessage touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\udt\UdtMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */