package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

public class BinaryMemcacheResponseEncoder
  extends AbstractBinaryMemcacheEncoder<BinaryMemcacheResponse>
{
  protected void encodeHeader(ByteBuf paramByteBuf, BinaryMemcacheResponse paramBinaryMemcacheResponse)
  {
    paramByteBuf.writeByte(paramBinaryMemcacheResponse.magic());
    paramByteBuf.writeByte(paramBinaryMemcacheResponse.opcode());
    paramByteBuf.writeShort(paramBinaryMemcacheResponse.keyLength());
    paramByteBuf.writeByte(paramBinaryMemcacheResponse.extrasLength());
    paramByteBuf.writeByte(paramBinaryMemcacheResponse.dataType());
    paramByteBuf.writeShort(paramBinaryMemcacheResponse.status());
    paramByteBuf.writeInt(paramBinaryMemcacheResponse.totalBodyLength());
    paramByteBuf.writeInt(paramBinaryMemcacheResponse.opaque());
    paramByteBuf.writeLong(paramBinaryMemcacheResponse.cas());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\BinaryMemcacheResponseEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */