package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.AbstractMemcacheObject;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;

public abstract class AbstractBinaryMemcacheMessage
  extends AbstractMemcacheObject
  implements BinaryMemcacheMessage
{
  private long cas;
  private byte dataType;
  private ByteBuf extras;
  private byte extrasLength;
  private ByteBuf key;
  private short keyLength;
  private byte magic;
  private int opaque;
  private byte opcode;
  private int totalBodyLength;
  
  protected AbstractBinaryMemcacheMessage(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    this.key = paramByteBuf1;
    int i = 0;
    int j;
    if (paramByteBuf1 == null) {
      j = 0;
    } else {
      j = (short)paramByteBuf1.readableBytes();
    }
    this.keyLength = ((short)j);
    this.extras = paramByteBuf2;
    if (paramByteBuf2 == null) {
      j = i;
    } else {
      j = (byte)paramByteBuf2.readableBytes();
    }
    this.extrasLength = ((byte)j);
    this.totalBodyLength = (this.keyLength + j);
  }
  
  public long cas()
  {
    return this.cas;
  }
  
  void copyMeta(AbstractBinaryMemcacheMessage paramAbstractBinaryMemcacheMessage)
  {
    paramAbstractBinaryMemcacheMessage.magic = ((byte)this.magic);
    paramAbstractBinaryMemcacheMessage.opcode = ((byte)this.opcode);
    paramAbstractBinaryMemcacheMessage.keyLength = ((short)this.keyLength);
    paramAbstractBinaryMemcacheMessage.extrasLength = ((byte)this.extrasLength);
    paramAbstractBinaryMemcacheMessage.dataType = ((byte)this.dataType);
    paramAbstractBinaryMemcacheMessage.totalBodyLength = this.totalBodyLength;
    paramAbstractBinaryMemcacheMessage.opaque = this.opaque;
    paramAbstractBinaryMemcacheMessage.cas = this.cas;
  }
  
  public byte dataType()
  {
    return this.dataType;
  }
  
  protected void deallocate()
  {
    ByteBuf localByteBuf = this.key;
    if (localByteBuf != null) {
      localByteBuf.release();
    }
    localByteBuf = this.extras;
    if (localByteBuf != null) {
      localByteBuf.release();
    }
  }
  
  public ByteBuf extras()
  {
    return this.extras;
  }
  
  public byte extrasLength()
  {
    return this.extrasLength;
  }
  
  public ByteBuf key()
  {
    return this.key;
  }
  
  public short keyLength()
  {
    return this.keyLength;
  }
  
  public byte magic()
  {
    return this.magic;
  }
  
  public int opaque()
  {
    return this.opaque;
  }
  
  public byte opcode()
  {
    return this.opcode;
  }
  
  public BinaryMemcacheMessage retain()
  {
    super.retain();
    return this;
  }
  
  public BinaryMemcacheMessage retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public BinaryMemcacheMessage setCas(long paramLong)
  {
    this.cas = paramLong;
    return this;
  }
  
  public BinaryMemcacheMessage setDataType(byte paramByte)
  {
    this.dataType = ((byte)paramByte);
    return this;
  }
  
  public BinaryMemcacheMessage setExtras(ByteBuf paramByteBuf)
  {
    ByteBuf localByteBuf = this.extras;
    if (localByteBuf != null) {
      localByteBuf.release();
    }
    this.extras = paramByteBuf;
    int i = (short)this.extrasLength;
    int j;
    if (paramByteBuf == null) {
      j = 0;
    } else {
      j = (byte)paramByteBuf.readableBytes();
    }
    this.extrasLength = ((byte)j);
    this.totalBodyLength = (this.totalBodyLength + j - i);
    return this;
  }
  
  BinaryMemcacheMessage setExtrasLength(byte paramByte)
  {
    this.extrasLength = ((byte)paramByte);
    return this;
  }
  
  public BinaryMemcacheMessage setKey(ByteBuf paramByteBuf)
  {
    ByteBuf localByteBuf = this.key;
    if (localByteBuf != null) {
      localByteBuf.release();
    }
    this.key = paramByteBuf;
    int i = this.keyLength;
    int j;
    if (paramByteBuf == null) {
      j = 0;
    } else {
      j = (short)paramByteBuf.readableBytes();
    }
    this.keyLength = ((short)j);
    this.totalBodyLength = (this.totalBodyLength + j - i);
    return this;
  }
  
  BinaryMemcacheMessage setKeyLength(short paramShort)
  {
    this.keyLength = ((short)paramShort);
    return this;
  }
  
  public BinaryMemcacheMessage setMagic(byte paramByte)
  {
    this.magic = ((byte)paramByte);
    return this;
  }
  
  public BinaryMemcacheMessage setOpaque(int paramInt)
  {
    this.opaque = paramInt;
    return this;
  }
  
  public BinaryMemcacheMessage setOpcode(byte paramByte)
  {
    this.opcode = ((byte)paramByte);
    return this;
  }
  
  public BinaryMemcacheMessage setTotalBodyLength(int paramInt)
  {
    this.totalBodyLength = paramInt;
    return this;
  }
  
  public int totalBodyLength()
  {
    return this.totalBodyLength;
  }
  
  public BinaryMemcacheMessage touch()
  {
    super.touch();
    return this;
  }
  
  public BinaryMemcacheMessage touch(Object paramObject)
  {
    ByteBuf localByteBuf = this.key;
    if (localByteBuf != null) {
      localByteBuf.touch(paramObject);
    }
    localByteBuf = this.extras;
    if (localByteBuf != null) {
      localByteBuf.touch(paramObject);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\AbstractBinaryMemcacheMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */