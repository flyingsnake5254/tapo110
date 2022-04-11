package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DefaultLastMemcacheContent
  extends DefaultMemcacheContent
  implements LastMemcacheContent
{
  public DefaultLastMemcacheContent()
  {
    super(Unpooled.buffer());
  }
  
  public DefaultLastMemcacheContent(ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
  }
  
  public LastMemcacheContent copy()
  {
    return replace(content().copy());
  }
  
  public LastMemcacheContent duplicate()
  {
    return replace(content().duplicate());
  }
  
  public LastMemcacheContent replace(ByteBuf paramByteBuf)
  {
    return new DefaultLastMemcacheContent(paramByteBuf);
  }
  
  public LastMemcacheContent retain()
  {
    super.retain();
    return this;
  }
  
  public LastMemcacheContent retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public LastMemcacheContent retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public LastMemcacheContent touch()
  {
    super.touch();
    return this;
  }
  
  public LastMemcacheContent touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\DefaultLastMemcacheContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */