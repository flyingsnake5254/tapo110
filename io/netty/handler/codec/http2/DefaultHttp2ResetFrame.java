package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2ResetFrame
  extends AbstractHttp2StreamFrame
  implements Http2ResetFrame
{
  private final long errorCode;
  
  public DefaultHttp2ResetFrame(long paramLong)
  {
    this.errorCode = paramLong;
  }
  
  public DefaultHttp2ResetFrame(Http2Error paramHttp2Error)
  {
    this.errorCode = ((Http2Error)ObjectUtil.checkNotNull(paramHttp2Error, "error")).code();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultHttp2ResetFrame;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    DefaultHttp2ResetFrame localDefaultHttp2ResetFrame = (DefaultHttp2ResetFrame)paramObject;
    bool1 = bool2;
    if (super.equals(paramObject))
    {
      bool1 = bool2;
      if (this.errorCode == localDefaultHttp2ResetFrame.errorCode) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long errorCode()
  {
    return this.errorCode;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    long l = this.errorCode;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public String name()
  {
    return "RST_STREAM";
  }
  
  public DefaultHttp2ResetFrame stream(Http2FrameStream paramHttp2FrameStream)
  {
    super.stream(paramHttp2FrameStream);
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(stream=");
    localStringBuilder.append(stream());
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.errorCode);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2ResetFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */