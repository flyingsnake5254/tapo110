package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2HeadersFrame
  extends AbstractHttp2StreamFrame
  implements Http2HeadersFrame
{
  private final boolean endStream;
  private final Http2Headers headers;
  private final int padding;
  
  public DefaultHttp2HeadersFrame(Http2Headers paramHttp2Headers)
  {
    this(paramHttp2Headers, false);
  }
  
  public DefaultHttp2HeadersFrame(Http2Headers paramHttp2Headers, boolean paramBoolean)
  {
    this(paramHttp2Headers, paramBoolean, 0);
  }
  
  public DefaultHttp2HeadersFrame(Http2Headers paramHttp2Headers, boolean paramBoolean, int paramInt)
  {
    this.headers = ((Http2Headers)ObjectUtil.checkNotNull(paramHttp2Headers, "headers"));
    this.endStream = paramBoolean;
    Http2CodecUtil.verifyPadding(paramInt);
    this.padding = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultHttp2HeadersFrame;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DefaultHttp2HeadersFrame)paramObject;
    bool1 = bool2;
    if (super.equals(paramObject))
    {
      bool1 = bool2;
      if (this.headers.equals(((DefaultHttp2HeadersFrame)paramObject).headers))
      {
        bool1 = bool2;
        if (this.endStream == ((DefaultHttp2HeadersFrame)paramObject).endStream)
        {
          bool1 = bool2;
          if (this.padding == ((DefaultHttp2HeadersFrame)paramObject).padding) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return ((super.hashCode() * 31 + this.headers.hashCode()) * 31 + (this.endStream ^ true)) * 31 + this.padding;
  }
  
  public Http2Headers headers()
  {
    return this.headers;
  }
  
  public boolean isEndStream()
  {
    return this.endStream;
  }
  
  public String name()
  {
    return "HEADERS";
  }
  
  public int padding()
  {
    return this.padding;
  }
  
  public DefaultHttp2HeadersFrame stream(Http2FrameStream paramHttp2FrameStream)
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
    localStringBuilder.append(", headers=");
    localStringBuilder.append(this.headers);
    localStringBuilder.append(", endStream=");
    localStringBuilder.append(this.endStream);
    localStringBuilder.append(", padding=");
    localStringBuilder.append(this.padding);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2HeadersFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */