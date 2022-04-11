package io.netty.buffer;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultByteBufHolder
  implements ByteBufHolder
{
  private final ByteBuf data;
  
  public DefaultByteBufHolder(ByteBuf paramByteBuf)
  {
    this.data = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "data"));
  }
  
  public ByteBuf content()
  {
    if (this.data.refCnt() > 0) {
      return this.data;
    }
    throw new IllegalReferenceCountException(this.data.refCnt());
  }
  
  protected final String contentToString()
  {
    return this.data.toString();
  }
  
  public ByteBufHolder copy()
  {
    return replace(this.data.copy());
  }
  
  public ByteBufHolder duplicate()
  {
    return replace(this.data.duplicate());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass())) {
      return this.data.equals(((DefaultByteBufHolder)paramObject).data);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.data.hashCode();
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
  
  public ByteBufHolder replace(ByteBuf paramByteBuf)
  {
    return new DefaultByteBufHolder(paramByteBuf);
  }
  
  public ByteBufHolder retain()
  {
    this.data.retain();
    return this;
  }
  
  public ByteBufHolder retain(int paramInt)
  {
    this.data.retain(paramInt);
    return this;
  }
  
  public ByteBufHolder retainedDuplicate()
  {
    return replace(this.data.retainedDuplicate());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    localStringBuilder.append(contentToString());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public ByteBufHolder touch()
  {
    this.data.touch();
    return this;
  }
  
  public ByteBufHolder touch(Object paramObject)
  {
    this.data.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\DefaultByteBufHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */