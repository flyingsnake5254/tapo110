package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2GoAwayFrame
  extends DefaultByteBufHolder
  implements Http2GoAwayFrame
{
  private final long errorCode;
  private int extraStreamIds;
  private final int lastStreamId;
  
  DefaultHttp2GoAwayFrame(int paramInt, long paramLong, ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
    this.errorCode = paramLong;
    this.lastStreamId = paramInt;
  }
  
  public DefaultHttp2GoAwayFrame(long paramLong)
  {
    this(paramLong, Unpooled.EMPTY_BUFFER);
  }
  
  public DefaultHttp2GoAwayFrame(long paramLong, ByteBuf paramByteBuf)
  {
    this(-1, paramLong, paramByteBuf);
  }
  
  public DefaultHttp2GoAwayFrame(Http2Error paramHttp2Error)
  {
    this(paramHttp2Error.code());
  }
  
  public DefaultHttp2GoAwayFrame(Http2Error paramHttp2Error, ByteBuf paramByteBuf)
  {
    this(paramHttp2Error.code(), paramByteBuf);
  }
  
  public Http2GoAwayFrame copy()
  {
    return new DefaultHttp2GoAwayFrame(this.lastStreamId, this.errorCode, content().copy());
  }
  
  public Http2GoAwayFrame duplicate()
  {
    return (Http2GoAwayFrame)super.duplicate();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultHttp2GoAwayFrame;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DefaultHttp2GoAwayFrame)paramObject;
    bool1 = bool2;
    if (this.errorCode == ((DefaultHttp2GoAwayFrame)paramObject).errorCode)
    {
      bool1 = bool2;
      if (this.extraStreamIds == ((DefaultHttp2GoAwayFrame)paramObject).extraStreamIds)
      {
        bool1 = bool2;
        if (super.equals(paramObject)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public long errorCode()
  {
    return this.errorCode;
  }
  
  public int extraStreamIds()
  {
    return this.extraStreamIds;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    long l = this.errorCode;
    return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.extraStreamIds;
  }
  
  public int lastStreamId()
  {
    return this.lastStreamId;
  }
  
  public String name()
  {
    return "GOAWAY";
  }
  
  public Http2GoAwayFrame replace(ByteBuf paramByteBuf)
  {
    return new DefaultHttp2GoAwayFrame(this.errorCode, paramByteBuf).setExtraStreamIds(this.extraStreamIds);
  }
  
  public Http2GoAwayFrame retain()
  {
    super.retain();
    return this;
  }
  
  public Http2GoAwayFrame retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public Http2GoAwayFrame retainedDuplicate()
  {
    return (Http2GoAwayFrame)super.retainedDuplicate();
  }
  
  public Http2GoAwayFrame setExtraStreamIds(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "extraStreamIds");
    this.extraStreamIds = paramInt;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(errorCode=");
    localStringBuilder.append(this.errorCode);
    localStringBuilder.append(", content=");
    localStringBuilder.append(content());
    localStringBuilder.append(", extraStreamIds=");
    localStringBuilder.append(this.extraStreamIds);
    localStringBuilder.append(", lastStreamId=");
    localStringBuilder.append(this.lastStreamId);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public Http2GoAwayFrame touch()
  {
    super.touch();
    return this;
  }
  
  public Http2GoAwayFrame touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2GoAwayFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */