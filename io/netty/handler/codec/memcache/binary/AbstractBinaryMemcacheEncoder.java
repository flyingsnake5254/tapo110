package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectEncoder;

public abstract class AbstractBinaryMemcacheEncoder<M extends BinaryMemcacheMessage>
  extends AbstractMemcacheObjectEncoder<M>
{
  private static final int MINIMUM_HEADER_SIZE = 24;
  
  private static void encodeExtras(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    if ((paramByteBuf2 != null) && (paramByteBuf2.isReadable())) {
      paramByteBuf1.writeBytes(paramByteBuf2);
    }
  }
  
  private static void encodeKey(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    if ((paramByteBuf2 != null) && (paramByteBuf2.isReadable())) {
      paramByteBuf1.writeBytes(paramByteBuf2);
    }
  }
  
  protected abstract void encodeHeader(ByteBuf paramByteBuf, M paramM);
  
  protected ByteBuf encodeMessage(ChannelHandlerContext paramChannelHandlerContext, M paramM)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.alloc().buffer(paramM.extrasLength() + 24 + paramM.keyLength());
    encodeHeader(paramChannelHandlerContext, paramM);
    encodeExtras(paramChannelHandlerContext, paramM.extras());
    encodeKey(paramChannelHandlerContext, paramM.key());
    return paramChannelHandlerContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\AbstractBinaryMemcacheEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */