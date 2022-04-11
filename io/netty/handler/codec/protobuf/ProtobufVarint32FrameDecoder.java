package io.netty.handler.codec.protobuf;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import java.util.List;

public class ProtobufVarint32FrameDecoder
  extends ByteToMessageDecoder
{
  private static int readRawVarint32(ByteBuf paramByteBuf)
  {
    if (!paramByteBuf.isReadable()) {
      return 0;
    }
    paramByteBuf.markReaderIndex();
    int i = paramByteBuf.readByte();
    if (i >= 0) {
      return i;
    }
    i &= 0x7F;
    if (!paramByteBuf.isReadable())
    {
      paramByteBuf.resetReaderIndex();
      return 0;
    }
    int j = paramByteBuf.readByte();
    if (j >= 0) {
      j <<= 7;
    }
    for (;;)
    {
      i = j | i;
      break label185;
      i |= (j & 0x7F) << 7;
      if (!paramByteBuf.isReadable())
      {
        paramByteBuf.resetReaderIndex();
        return 0;
      }
      j = paramByteBuf.readByte();
      if (j >= 0)
      {
        j <<= 14;
      }
      else
      {
        i |= (j & 0x7F) << 14;
        if (!paramByteBuf.isReadable())
        {
          paramByteBuf.resetReaderIndex();
          return 0;
        }
        j = paramByteBuf.readByte();
        if (j < 0) {
          break;
        }
        j <<= 21;
      }
    }
    if (!paramByteBuf.isReadable())
    {
      paramByteBuf.resetReaderIndex();
      return 0;
    }
    int k = paramByteBuf.readByte();
    if (k >= 0)
    {
      i = i | (j & 0x7F) << 21 | k << 28;
      label185:
      return i;
    }
    throw new CorruptedFrameException("malformed varint.");
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    paramByteBuf.markReaderIndex();
    int i = paramByteBuf.readerIndex();
    int j = readRawVarint32(paramByteBuf);
    if (i == paramByteBuf.readerIndex()) {
      return;
    }
    if (j >= 0)
    {
      if (paramByteBuf.readableBytes() < j) {
        paramByteBuf.resetReaderIndex();
      } else {
        paramList.add(paramByteBuf.readRetainedSlice(j));
      }
      return;
    }
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("negative length: ");
    paramChannelHandlerContext.append(j);
    throw new CorruptedFrameException(paramChannelHandlerContext.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\protobuf\ProtobufVarint32FrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */