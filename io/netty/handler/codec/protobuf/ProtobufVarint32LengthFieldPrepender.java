package io.netty.handler.codec.protobuf;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.a
public class ProtobufVarint32LengthFieldPrepender
  extends MessageToByteEncoder<ByteBuf>
{
  static int computeRawVarint32Size(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  static void writeRawVarint32(ByteBuf paramByteBuf, int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        paramByteBuf.writeByte(paramInt);
        return;
      }
      paramByteBuf.writeByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
    throws Exception
  {
    int i = paramByteBuf1.readableBytes();
    paramByteBuf2.ensureWritable(computeRawVarint32Size(i) + i);
    writeRawVarint32(paramByteBuf2, i);
    paramByteBuf2.writeBytes(paramByteBuf1, paramByteBuf1.readerIndex(), i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\protobuf\ProtobufVarint32LengthFieldPrepender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */