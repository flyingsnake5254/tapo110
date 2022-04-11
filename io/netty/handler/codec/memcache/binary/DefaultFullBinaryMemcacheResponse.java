package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public class DefaultFullBinaryMemcacheResponse
  extends DefaultBinaryMemcacheResponse
  implements FullBinaryMemcacheResponse
{
  private final ByteBuf content;
  
  public DefaultFullBinaryMemcacheResponse(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    this(paramByteBuf1, paramByteBuf2, Unpooled.buffer(0));
  }
  
  public DefaultFullBinaryMemcacheResponse(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, ByteBuf paramByteBuf3)
  {
    super(paramByteBuf1, paramByteBuf2);
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf3, "content"));
    setTotalBodyLength(keyLength() + extrasLength() + paramByteBuf3.readableBytes());
  }
  
  private FullBinaryMemcacheResponse newInstance(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, ByteBuf paramByteBuf3)
  {
    paramByteBuf1 = new DefaultFullBinaryMemcacheResponse(paramByteBuf1, paramByteBuf2, paramByteBuf3);
    copyMeta(paramByteBuf1);
    return paramByteBuf1;
  }
  
  public ByteBuf content()
  {
    return this.content;
  }
  
  public FullBinaryMemcacheResponse copy()
  {
    Object localObject1 = key();
    Object localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((ByteBuf)localObject1).copy();
    }
    ByteBuf localByteBuf = extras();
    localObject1 = localByteBuf;
    if (localByteBuf != null) {
      localObject1 = localByteBuf.copy();
    }
    return newInstance((ByteBuf)localObject2, (ByteBuf)localObject1, content().copy());
  }
  
  protected void deallocate()
  {
    super.deallocate();
    this.content.release();
  }
  
  public FullBinaryMemcacheResponse duplicate()
  {
    Object localObject1 = key();
    Object localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((ByteBuf)localObject1).duplicate();
    }
    ByteBuf localByteBuf = extras();
    localObject1 = localByteBuf;
    if (localByteBuf != null) {
      localObject1 = localByteBuf.duplicate();
    }
    return newInstance((ByteBuf)localObject2, (ByteBuf)localObject1, content().duplicate());
  }
  
  public FullBinaryMemcacheResponse replace(ByteBuf paramByteBuf)
  {
    Object localObject1 = key();
    Object localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((ByteBuf)localObject1).retainedDuplicate();
    }
    ByteBuf localByteBuf = extras();
    localObject1 = localByteBuf;
    if (localByteBuf != null) {
      localObject1 = localByteBuf.retainedDuplicate();
    }
    return newInstance((ByteBuf)localObject2, (ByteBuf)localObject1, paramByteBuf);
  }
  
  public FullBinaryMemcacheResponse retain()
  {
    super.retain();
    return this;
  }
  
  public FullBinaryMemcacheResponse retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public FullBinaryMemcacheResponse retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public FullBinaryMemcacheResponse touch()
  {
    super.touch();
    return this;
  }
  
  public FullBinaryMemcacheResponse touch(Object paramObject)
  {
    super.touch(paramObject);
    this.content.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\DefaultFullBinaryMemcacheResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */