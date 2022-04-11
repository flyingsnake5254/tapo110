package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSpdyDataFrame
  extends DefaultSpdyStreamFrame
  implements SpdyDataFrame
{
  private final ByteBuf data;
  
  public DefaultSpdyDataFrame(int paramInt)
  {
    this(paramInt, Unpooled.buffer(0));
  }
  
  public DefaultSpdyDataFrame(int paramInt, ByteBuf paramByteBuf)
  {
    super(paramInt);
    this.data = validate((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "data"));
  }
  
  private static ByteBuf validate(ByteBuf paramByteBuf)
  {
    if (paramByteBuf.readableBytes() <= 16777215) {
      return paramByteBuf;
    }
    throw new IllegalArgumentException("data payload cannot exceed 16777215 bytes");
  }
  
  public ByteBuf content()
  {
    if (this.data.refCnt() > 0) {
      return this.data;
    }
    throw new IllegalReferenceCountException(this.data.refCnt());
  }
  
  public SpdyDataFrame copy()
  {
    return replace(content().copy());
  }
  
  public SpdyDataFrame duplicate()
  {
    return replace(content().duplicate());
  }
  
  public int refCnt()
  {
    return this.data.refCnt();
  }
  
  public boolean release()
  {
    return this.data.release();
  }
  
  public boolean release(int paramInt)
  {
    return this.data.release(paramInt);
  }
  
  public SpdyDataFrame replace(ByteBuf paramByteBuf)
  {
    paramByteBuf = new DefaultSpdyDataFrame(streamId(), paramByteBuf);
    paramByteBuf.setLast(isLast());
    return paramByteBuf;
  }
  
  public SpdyDataFrame retain()
  {
    this.data.retain();
    return this;
  }
  
  public SpdyDataFrame retain(int paramInt)
  {
    this.data.retain(paramInt);
    return this;
  }
  
  public SpdyDataFrame retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public SpdyDataFrame setLast(boolean paramBoolean)
  {
    super.setLast(paramBoolean);
    return this;
  }
  
  public SpdyDataFrame setStreamId(int paramInt)
  {
    super.setStreamId(paramInt);
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(last: ");
    localStringBuilder.append(isLast());
    localStringBuilder.append(')');
    String str = StringUtil.NEWLINE;
    localStringBuilder.append(str);
    localStringBuilder.append("--> Stream-ID = ");
    localStringBuilder.append(streamId());
    localStringBuilder.append(str);
    localStringBuilder.append("--> Size = ");
    if (refCnt() == 0) {
      localStringBuilder.append("(freed)");
    } else {
      localStringBuilder.append(content().readableBytes());
    }
    return localStringBuilder.toString();
  }
  
  public SpdyDataFrame touch()
  {
    this.data.touch();
    return this;
  }
  
  public SpdyDataFrame touch(Object paramObject)
  {
    this.data.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdyDataFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */