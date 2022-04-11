package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;

final class CompressionUtil
{
  static void checkChecksum(ByteBufChecksum paramByteBufChecksum, ByteBuf paramByteBuf, int paramInt)
  {
    paramByteBufChecksum.reset();
    paramByteBufChecksum.update(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
    int i = (int)paramByteBufChecksum.getValue();
    if (i == paramInt) {
      return;
    }
    throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
  }
  
  static ByteBuffer safeNioBuffer(ByteBuf paramByteBuf)
  {
    if (paramByteBuf.nioBufferCount() == 1) {
      paramByteBuf = paramByteBuf.internalNioBuffer(paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
    } else {
      paramByteBuf = paramByteBuf.nioBuffer();
    }
    return paramByteBuf;
  }
  
  static ByteBuffer safeNioBuffer(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    if (paramByteBuf.nioBufferCount() == 1) {
      paramByteBuf = paramByteBuf.internalNioBuffer(paramInt1, paramInt2);
    } else {
      paramByteBuf = paramByteBuf.nioBuffer(paramInt1, paramInt2);
    }
    return paramByteBuf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\CompressionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */