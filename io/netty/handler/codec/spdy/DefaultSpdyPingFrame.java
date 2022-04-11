package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

public class DefaultSpdyPingFrame
  implements SpdyPingFrame
{
  private int id;
  
  public DefaultSpdyPingFrame(int paramInt)
  {
    setId(paramInt);
  }
  
  public int id()
  {
    return this.id;
  }
  
  public SpdyPingFrame setId(int paramInt)
  {
    this.id = paramInt;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append(StringUtil.NEWLINE);
    localStringBuilder.append("--> ID = ");
    localStringBuilder.append(id());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdyPingFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */