package io.netty.handler.codec.http2;

import io.netty.util.internal.StringUtil;

public class DefaultHttp2PingFrame
  implements Http2PingFrame
{
  private final boolean ack;
  private final long content;
  
  public DefaultHttp2PingFrame(long paramLong)
  {
    this(paramLong, false);
  }
  
  public DefaultHttp2PingFrame(long paramLong, boolean paramBoolean)
  {
    this.content = paramLong;
    this.ack = paramBoolean;
  }
  
  public boolean ack()
  {
    return this.ack;
  }
  
  public long content()
  {
    return this.content;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Http2PingFrame;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Http2PingFrame)paramObject;
    bool1 = bool2;
    if (this.ack == ((Http2PingFrame)paramObject).ack())
    {
      bool1 = bool2;
      if (this.content == ((Http2PingFrame)paramObject).content()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return super.hashCode() * 31 + this.ack;
  }
  
  public String name()
  {
    return "PING";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append(", ack=");
    localStringBuilder.append(this.ack);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2PingFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */