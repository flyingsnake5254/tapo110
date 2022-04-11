package io.netty.handler.codec.protobuf;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

@ChannelHandler.a
public class ProtobufEncoderNano
  extends MessageToMessageEncoder<MessageNano>
{
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, MessageNano paramMessageNano, List<Object> paramList)
    throws Exception
  {
    int i = paramMessageNano.getSerializedSize();
    paramChannelHandlerContext = paramChannelHandlerContext.alloc().heapBuffer(i, i);
    paramMessageNano.writeTo(CodedOutputByteBufferNano.newInstance(paramChannelHandlerContext.array(), paramChannelHandlerContext.arrayOffset(), paramChannelHandlerContext.capacity()));
    paramChannelHandlerContext.writerIndex(i);
    paramList.add(paramChannelHandlerContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\protobuf\ProtobufEncoderNano.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */