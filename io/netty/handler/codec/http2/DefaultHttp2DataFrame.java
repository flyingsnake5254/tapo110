package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2DataFrame
  extends AbstractHttp2StreamFrame
  implements Http2DataFrame
{
  private final ByteBuf content;
  private final boolean endStream;
  private final int initialFlowControlledBytes;
  private final int padding;
  
  public DefaultHttp2DataFrame(ByteBuf paramByteBuf)
  {
    this(paramByteBuf, false);
  }
  
  public DefaultHttp2DataFrame(ByteBuf paramByteBuf, boolean paramBoolean)
  {
    this(paramByteBuf, paramBoolean, 0);
  }
  
  public DefaultHttp2DataFrame(ByteBuf paramByteBuf, boolean paramBoolean, int paramInt)
  {
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
    this.endStream = paramBoolean;
    Http2CodecUtil.verifyPadding(paramInt);
    this.padding = paramInt;
    if (content().readableBytes() + paramInt <= 2147483647L)
    {
      this.initialFlowControlledBytes = (content().readableBytes() + paramInt);
      return;
    }
    throw new IllegalArgumentException("content + padding must be <= Integer.MAX_VALUE");
  }
  
  public DefaultHttp2DataFrame(boolean paramBoolean)
  {
    this(Unpooled.EMPTY_BUFFER, paramBoolean);
  }
  
  public ByteBuf content()
  {
    if (this.content.refCnt() > 0) {
      return this.content;
    }
    throw new IllegalReferenceCountException(this.content.refCnt());
  }
  
  public DefaultHttp2DataFrame copy()
  {
    return replace(content().copy());
  }
  
  public DefaultHttp2DataFrame duplicate()
  {
    return replace(content().duplicate());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultHttp2DataFrame;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DefaultHttp2DataFrame)paramObject;
    bool1 = bool2;
    if (super.equals(paramObject))
    {
      bool1 = bool2;
      if (this.content.equals(((DefaultHttp2DataFrame)paramObject).content()))
      {
        bool1 = bool2;
        if (this.endStream == ((DefaultHttp2DataFrame)paramObject).endStream)
        {
          bool1 = bool2;
          if (this.padding == ((DefaultHttp2DataFrame)paramObject).padding) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return ((super.hashCode() * 31 + this.content.hashCode()) * 31 + (this.endStream ^ true)) * 31 + this.padding;
  }
  
  public int initialFlowControlledBytes()
  {
    return this.initialFlowControlledBytes;
  }
  
  public boolean isEndStream()
  {
    return this.endStream;
  }
  
  public String name()
  {
    return "DATA";
  }
  
  public int padding()
  {
    return this.padding;
  }
  
  public int refCnt()
  {
    return this.content.refCnt();
  }
  
  public boolean release()
  {
    return this.content.release();
  }
  
  public boolean release(int paramInt)
  {
    return this.content.release(paramInt);
  }
  
  public DefaultHttp2DataFrame replace(ByteBuf paramByteBuf)
  {
    return new DefaultHttp2DataFrame(paramByteBuf, this.endStream, this.padding);
  }
  
  public DefaultHttp2DataFrame retain()
  {
    this.content.retain();
    return this;
  }
  
  public DefaultHttp2DataFrame retain(int paramInt)
  {
    this.content.retain(paramInt);
    return this;
  }
  
  public DefaultHttp2DataFrame retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public DefaultHttp2DataFrame stream(Http2FrameStream paramHttp2FrameStream)
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
    localStringBuilder.append(", content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append(", endStream=");
    localStringBuilder.append(this.endStream);
    localStringBuilder.append(", padding=");
    localStringBuilder.append(this.padding);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public DefaultHttp2DataFrame touch()
  {
    this.content.touch();
    return this;
  }
  
  public DefaultHttp2DataFrame touch(Object paramObject)
  {
    this.content.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2DataFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */