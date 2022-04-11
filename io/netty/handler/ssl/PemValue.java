package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

class PemValue
  extends AbstractReferenceCounted
  implements PemEncoded
{
  private final ByteBuf content;
  private final boolean sensitive;
  
  PemValue(ByteBuf paramByteBuf, boolean paramBoolean)
  {
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
    this.sensitive = paramBoolean;
  }
  
  public ByteBuf content()
  {
    int i = refCnt();
    if (i > 0) {
      return this.content;
    }
    throw new IllegalReferenceCountException(i);
  }
  
  public PemValue copy()
  {
    return replace(this.content.copy());
  }
  
  protected void deallocate()
  {
    if (this.sensitive) {
      SslUtils.zeroout(this.content);
    }
    this.content.release();
  }
  
  public PemValue duplicate()
  {
    return replace(this.content.duplicate());
  }
  
  public boolean isSensitive()
  {
    return this.sensitive;
  }
  
  public PemValue replace(ByteBuf paramByteBuf)
  {
    return new PemValue(paramByteBuf, this.sensitive);
  }
  
  public PemValue retain()
  {
    return (PemValue)super.retain();
  }
  
  public PemValue retain(int paramInt)
  {
    return (PemValue)super.retain(paramInt);
  }
  
  public PemValue retainedDuplicate()
  {
    return replace(this.content.retainedDuplicate());
  }
  
  public PemValue touch()
  {
    return (PemValue)super.touch();
  }
  
  public PemValue touch(Object paramObject)
  {
    this.content.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\PemValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */