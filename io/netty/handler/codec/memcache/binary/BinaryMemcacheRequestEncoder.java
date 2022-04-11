package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

public class BinaryMemcacheRequestEncoder
  extends AbstractBinaryMemcacheEncoder<BinaryMemcacheRequest>
{
  protected void encodeHeader(ByteBuf paramByteBuf, BinaryMemcacheRequest paramBinaryMemcacheRequest)
  {
    paramByteBuf.writeByte(paramBinaryMemcacheRequest.magic());
    paramByteBuf.writeByte(paramBinaryMemcacheRequest.opcode());
    paramByteBuf.writeShort(paramBinaryMemcacheRequest.keyLength());
    paramByteBuf.writeByte(paramBinaryMemcacheRequest.extrasLength());
    paramByteBuf.writeByte(paramBinaryMemcacheRequest.dataType());
    paramByteBuf.writeShort(paramBinaryMemcacheRequest.reserved());
    paramByteBuf.writeInt(paramBinaryMemcacheRequest.totalBodyLength());
    paramByteBuf.writeInt(paramBinaryMemcacheRequest.opaque());
    paramByteBuf.writeLong(paramBinaryMemcacheRequest.cas());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\BinaryMemcacheRequestEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */