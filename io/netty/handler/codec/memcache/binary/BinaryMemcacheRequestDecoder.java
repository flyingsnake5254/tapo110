package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BinaryMemcacheRequestDecoder
  extends AbstractBinaryMemcacheDecoder<BinaryMemcacheRequest>
{
  public BinaryMemcacheRequestDecoder()
  {
    this(8192);
  }
  
  public BinaryMemcacheRequestDecoder(int paramInt)
  {
    super(paramInt);
  }
  
  protected BinaryMemcacheRequest buildInvalidMessage()
  {
    ByteBuf localByteBuf = Unpooled.EMPTY_BUFFER;
    return new DefaultBinaryMemcacheRequest(localByteBuf, localByteBuf);
  }
  
  protected BinaryMemcacheRequest decodeHeader(ByteBuf paramByteBuf)
  {
    DefaultBinaryMemcacheRequest localDefaultBinaryMemcacheRequest = new DefaultBinaryMemcacheRequest();
    localDefaultBinaryMemcacheRequest.setMagic(paramByteBuf.readByte());
    localDefaultBinaryMemcacheRequest.setOpcode(paramByteBuf.readByte());
    localDefaultBinaryMemcacheRequest.setKeyLength(paramByteBuf.readShort());
    localDefaultBinaryMemcacheRequest.setExtrasLength(paramByteBuf.readByte());
    localDefaultBinaryMemcacheRequest.setDataType(paramByteBuf.readByte());
    localDefaultBinaryMemcacheRequest.setReserved(paramByteBuf.readShort());
    localDefaultBinaryMemcacheRequest.setTotalBodyLength(paramByteBuf.readInt());
    localDefaultBinaryMemcacheRequest.setOpaque(paramByteBuf.readInt());
    localDefaultBinaryMemcacheRequest.setCas(paramByteBuf.readLong());
    return localDefaultBinaryMemcacheRequest;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\BinaryMemcacheRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */