package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectAggregator;
import io.netty.handler.codec.memcache.FullMemcacheMessage;
import io.netty.handler.codec.memcache.a;

public class BinaryMemcacheObjectAggregator
  extends AbstractMemcacheObjectAggregator<BinaryMemcacheMessage>
{
  public BinaryMemcacheObjectAggregator(int paramInt)
  {
    super(paramInt);
  }
  
  private static FullBinaryMemcacheRequest toFullRequest(BinaryMemcacheRequest paramBinaryMemcacheRequest, ByteBuf paramByteBuf)
  {
    ByteBuf localByteBuf1 = paramBinaryMemcacheRequest.key();
    ByteBuf localByteBuf2 = null;
    if (localByteBuf1 == null) {
      localByteBuf1 = null;
    } else {
      localByteBuf1 = paramBinaryMemcacheRequest.key().retain();
    }
    if (paramBinaryMemcacheRequest.extras() != null) {
      localByteBuf2 = paramBinaryMemcacheRequest.extras().retain();
    }
    paramByteBuf = new DefaultFullBinaryMemcacheRequest(localByteBuf1, localByteBuf2, paramByteBuf);
    paramByteBuf.setMagic(paramBinaryMemcacheRequest.magic());
    paramByteBuf.setOpcode(paramBinaryMemcacheRequest.opcode());
    paramByteBuf.setKeyLength(paramBinaryMemcacheRequest.keyLength());
    paramByteBuf.setExtrasLength(paramBinaryMemcacheRequest.extrasLength());
    paramByteBuf.setDataType(paramBinaryMemcacheRequest.dataType());
    paramByteBuf.setTotalBodyLength(paramBinaryMemcacheRequest.totalBodyLength());
    paramByteBuf.setOpaque(paramBinaryMemcacheRequest.opaque());
    paramByteBuf.setCas(paramBinaryMemcacheRequest.cas());
    paramByteBuf.setReserved(paramBinaryMemcacheRequest.reserved());
    return paramByteBuf;
  }
  
  private static FullBinaryMemcacheResponse toFullResponse(BinaryMemcacheResponse paramBinaryMemcacheResponse, ByteBuf paramByteBuf)
  {
    ByteBuf localByteBuf1 = paramBinaryMemcacheResponse.key();
    ByteBuf localByteBuf2 = null;
    if (localByteBuf1 == null) {
      localByteBuf1 = null;
    } else {
      localByteBuf1 = paramBinaryMemcacheResponse.key().retain();
    }
    if (paramBinaryMemcacheResponse.extras() != null) {
      localByteBuf2 = paramBinaryMemcacheResponse.extras().retain();
    }
    paramByteBuf = new DefaultFullBinaryMemcacheResponse(localByteBuf1, localByteBuf2, paramByteBuf);
    paramByteBuf.setMagic(paramBinaryMemcacheResponse.magic());
    paramByteBuf.setOpcode(paramBinaryMemcacheResponse.opcode());
    paramByteBuf.setKeyLength(paramBinaryMemcacheResponse.keyLength());
    paramByteBuf.setExtrasLength(paramBinaryMemcacheResponse.extrasLength());
    paramByteBuf.setDataType(paramBinaryMemcacheResponse.dataType());
    paramByteBuf.setTotalBodyLength(paramBinaryMemcacheResponse.totalBodyLength());
    paramByteBuf.setOpaque(paramBinaryMemcacheResponse.opaque());
    paramByteBuf.setCas(paramBinaryMemcacheResponse.cas());
    paramByteBuf.setStatus(paramBinaryMemcacheResponse.status());
    return paramByteBuf;
  }
  
  protected FullMemcacheMessage beginAggregation(BinaryMemcacheMessage paramBinaryMemcacheMessage, ByteBuf paramByteBuf)
    throws Exception
  {
    if ((paramBinaryMemcacheMessage instanceof BinaryMemcacheRequest)) {
      return toFullRequest((BinaryMemcacheRequest)paramBinaryMemcacheMessage, paramByteBuf);
    }
    if ((paramBinaryMemcacheMessage instanceof BinaryMemcacheResponse)) {
      return toFullResponse((BinaryMemcacheResponse)paramBinaryMemcacheMessage, paramByteBuf);
    }
    throw new Error();
  }
  
  protected boolean isStartMessage(a parama)
    throws Exception
  {
    return parama instanceof BinaryMemcacheMessage;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\BinaryMemcacheObjectAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */