package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2UnknownFrame
  extends DefaultByteBufHolder
  implements Http2UnknownFrame
{
  private final Http2Flags flags;
  private final byte frameType;
  private Http2FrameStream stream;
  
  public DefaultHttp2UnknownFrame(byte paramByte, Http2Flags paramHttp2Flags)
  {
    this(paramByte, paramHttp2Flags, Unpooled.EMPTY_BUFFER);
  }
  
  public DefaultHttp2UnknownFrame(byte paramByte, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
    this.frameType = ((byte)paramByte);
    this.flags = paramHttp2Flags;
  }
  
  public DefaultHttp2UnknownFrame copy()
  {
    return replace(content().copy());
  }
  
  public DefaultHttp2UnknownFrame duplicate()
  {
    return replace(content().duplicate());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultHttp2UnknownFrame;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DefaultHttp2UnknownFrame)paramObject;
    Http2FrameStream localHttp2FrameStream1 = ((DefaultHttp2UnknownFrame)paramObject).stream();
    Http2FrameStream localHttp2FrameStream2 = this.stream;
    if (localHttp2FrameStream2 != localHttp2FrameStream1)
    {
      bool1 = bool2;
      if (localHttp2FrameStream1 != null)
      {
        bool1 = bool2;
        if (!localHttp2FrameStream1.equals(localHttp2FrameStream2)) {}
      }
    }
    else
    {
      bool1 = bool2;
      if (this.flags.equals(((DefaultHttp2UnknownFrame)paramObject).flags()))
      {
        bool1 = bool2;
        if (this.frameType == ((DefaultHttp2UnknownFrame)paramObject).frameType())
        {
          bool1 = bool2;
          if (super.equals(paramObject)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public Http2Flags flags()
  {
    return this.flags;
  }
  
  public byte frameType()
  {
    return this.frameType;
  }
  
  public int hashCode()
  {
    int i = (super.hashCode() * 31 + this.frameType) * 31 + this.flags.hashCode();
    Http2FrameStream localHttp2FrameStream = this.stream;
    int j = i;
    if (localHttp2FrameStream != null) {
      j = i * 31 + localHttp2FrameStream.hashCode();
    }
    return j;
  }
  
  public String name()
  {
    return "UNKNOWN";
  }
  
  public DefaultHttp2UnknownFrame replace(ByteBuf paramByteBuf)
  {
    return new DefaultHttp2UnknownFrame(this.frameType, this.flags, paramByteBuf).stream(this.stream);
  }
  
  public DefaultHttp2UnknownFrame retain()
  {
    super.retain();
    return this;
  }
  
  public DefaultHttp2UnknownFrame retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public DefaultHttp2UnknownFrame retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public DefaultHttp2UnknownFrame stream(Http2FrameStream paramHttp2FrameStream)
  {
    this.stream = paramHttp2FrameStream;
    return this;
  }
  
  public Http2FrameStream stream()
  {
    return this.stream;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(frameType=");
    localStringBuilder.append(this.frameType);
    localStringBuilder.append(", stream=");
    localStringBuilder.append(this.stream);
    localStringBuilder.append(", flags=");
    localStringBuilder.append(this.flags);
    localStringBuilder.append(", content=");
    localStringBuilder.append(contentToString());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public DefaultHttp2UnknownFrame touch()
  {
    super.touch();
    return this;
  }
  
  public DefaultHttp2UnknownFrame touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2UnknownFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */