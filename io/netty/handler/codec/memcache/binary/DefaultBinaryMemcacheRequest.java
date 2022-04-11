package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

public class DefaultBinaryMemcacheRequest
  extends AbstractBinaryMemcacheMessage
  implements BinaryMemcacheRequest
{
  public static final byte REQUEST_MAGIC_BYTE = -128;
  private short reserved;
  
  public DefaultBinaryMemcacheRequest()
  {
    this(null, null);
  }
  
  public DefaultBinaryMemcacheRequest(ByteBuf paramByteBuf)
  {
    this(paramByteBuf, null);
  }
  
  public DefaultBinaryMemcacheRequest(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    super(paramByteBuf1, paramByteBuf2);
    setMagic((byte)Byte.MIN_VALUE);
  }
  
  void copyMeta(DefaultBinaryMemcacheRequest paramDefaultBinaryMemcacheRequest)
  {
    super.copyMeta(paramDefaultBinaryMemcacheRequest);
    paramDefaultBinaryMemcacheRequest.reserved = ((short)this.reserved);
  }
  
  public short reserved()
  {
    return this.reserved;
  }
  
  public BinaryMemcacheRequest retain()
  {
    super.retain();
    return this;
  }
  
  public BinaryMemcacheRequest retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public BinaryMemcacheRequest setReserved(short paramShort)
  {
    this.reserved = ((short)paramShort);
    return this;
  }
  
  public BinaryMemcacheRequest touch()
  {
    super.touch();
    return this;
  }
  
  public BinaryMemcacheRequest touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\DefaultBinaryMemcacheRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */