package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.MemcacheMessage;

public abstract interface BinaryMemcacheMessage
  extends MemcacheMessage
{
  public abstract long cas();
  
  public abstract byte dataType();
  
  public abstract ByteBuf extras();
  
  public abstract byte extrasLength();
  
  public abstract ByteBuf key();
  
  public abstract short keyLength();
  
  public abstract byte magic();
  
  public abstract int opaque();
  
  public abstract byte opcode();
  
  public abstract BinaryMemcacheMessage retain();
  
  public abstract BinaryMemcacheMessage retain(int paramInt);
  
  public abstract BinaryMemcacheMessage setCas(long paramLong);
  
  public abstract BinaryMemcacheMessage setDataType(byte paramByte);
  
  public abstract BinaryMemcacheMessage setExtras(ByteBuf paramByteBuf);
  
  public abstract BinaryMemcacheMessage setKey(ByteBuf paramByteBuf);
  
  public abstract BinaryMemcacheMessage setMagic(byte paramByte);
  
  public abstract BinaryMemcacheMessage setOpaque(int paramInt);
  
  public abstract BinaryMemcacheMessage setOpcode(byte paramByte);
  
  public abstract BinaryMemcacheMessage setTotalBodyLength(int paramInt);
  
  public abstract int totalBodyLength();
  
  public abstract BinaryMemcacheMessage touch();
  
  public abstract BinaryMemcacheMessage touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\BinaryMemcacheMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */