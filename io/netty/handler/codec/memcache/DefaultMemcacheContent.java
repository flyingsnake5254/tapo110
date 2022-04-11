package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultMemcacheContent
  extends AbstractMemcacheObject
  implements MemcacheContent
{
  private final ByteBuf content;
  
  public DefaultMemcacheContent(ByteBuf paramByteBuf)
  {
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
  }
  
  public ByteBuf content()
  {
    return this.content;
  }
  
  public MemcacheContent copy()
  {
    return replace(this.content.copy());
  }
  
  protected void deallocate()
  {
    this.content.release();
  }
  
  public MemcacheContent duplicate()
  {
    return replace(this.content.duplicate());
  }
  
  public MemcacheContent replace(ByteBuf paramByteBuf)
  {
    return new DefaultMemcacheContent(paramByteBuf);
  }
  
  public MemcacheContent retain()
  {
    super.retain();
    return this;
  }
  
  public MemcacheContent retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public MemcacheContent retainedDuplicate()
  {
    return replace(this.content.retainedDuplicate());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(data: ");
    localStringBuilder.append(content());
    localStringBuilder.append(", decoderResult: ");
    localStringBuilder.append(decoderResult());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public MemcacheContent touch()
  {
    super.touch();
    return this;
  }
  
  public MemcacheContent touch(Object paramObject)
  {
    this.content.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\DefaultMemcacheContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */