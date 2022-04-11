package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BinaryMemcacheResponseDecoder
  extends AbstractBinaryMemcacheDecoder<BinaryMemcacheResponse>
{
  public BinaryMemcacheResponseDecoder()
  {
    this(8192);
  }
  
  public BinaryMemcacheResponseDecoder(int paramInt)
  {
    super(paramInt);
  }
  
  protected BinaryMemcacheResponse buildInvalidMessage()
  {
    ByteBuf localByteBuf = Unpooled.EMPTY_BUFFER;
    return new DefaultBinaryMemcacheResponse(localByteBuf, localByteBuf);
  }
  
  protected BinaryMemcacheResponse decodeHeader(ByteBuf paramByteBuf)
  {
    DefaultBinaryMemcacheResponse localDefaultBinaryMemcacheResponse = new DefaultBinaryMemcacheResponse();
    localDefaultBinaryMemcacheResponse.setMagic(paramByteBuf.readByte());
    localDefaultBinaryMemcacheResponse.setOpcode(paramByteBuf.readByte());
    localDefaultBinaryMemcacheResponse.setKeyLength(paramByteBuf.readShort());
    localDefaultBinaryMemcacheResponse.setExtrasLength(paramByteBuf.readByte());
    localDefaultBinaryMemcacheResponse.setDataType(paramByteBuf.readByte());
    localDefaultBinaryMemcacheResponse.setStatus(paramByteBuf.readShort());
    localDefaultBinaryMemcacheResponse.setTotalBodyLength(paramByteBuf.readInt());
    localDefaultBinaryMemcacheResponse.setOpaque(paramByteBuf.readInt());
    localDefaultBinaryMemcacheResponse.setCas(paramByteBuf.readLong());
    return localDefaultBinaryMemcacheResponse;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\BinaryMemcacheResponseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */