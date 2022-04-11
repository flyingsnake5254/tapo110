package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

public class DefaultBinaryMemcacheResponse
  extends AbstractBinaryMemcacheMessage
  implements BinaryMemcacheResponse
{
  public static final byte RESPONSE_MAGIC_BYTE = -127;
  private short status;
  
  public DefaultBinaryMemcacheResponse()
  {
    this(null, null);
  }
  
  public DefaultBinaryMemcacheResponse(ByteBuf paramByteBuf)
  {
    this(paramByteBuf, null);
  }
  
  public DefaultBinaryMemcacheResponse(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    super(paramByteBuf1, paramByteBuf2);
    setMagic((byte)-127);
  }
  
  void copyMeta(DefaultBinaryMemcacheResponse paramDefaultBinaryMemcacheResponse)
  {
    super.copyMeta(paramDefaultBinaryMemcacheResponse);
    paramDefaultBinaryMemcacheResponse.status = ((short)this.status);
  }
  
  public BinaryMemcacheResponse retain()
  {
    super.retain();
    return this;
  }
  
  public BinaryMemcacheResponse retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public BinaryMemcacheResponse setStatus(short paramShort)
  {
    this.status = ((short)paramShort);
    return this;
  }
  
  public short status()
  {
    return this.status;
  }
  
  public BinaryMemcacheResponse touch()
  {
    super.touch();
    return this;
  }
  
  public BinaryMemcacheResponse touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\DefaultBinaryMemcacheResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */