package io.netty.handler.codec.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite.Builder;
import com.google.protobuf.MessageLiteOrBuilder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

@ChannelHandler.a
public class ProtobufEncoder
  extends MessageToMessageEncoder<MessageLiteOrBuilder>
{
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, MessageLiteOrBuilder paramMessageLiteOrBuilder, List<Object> paramList)
    throws Exception
  {
    if ((paramMessageLiteOrBuilder instanceof MessageLite))
    {
      paramList.add(Unpooled.wrappedBuffer(((MessageLite)paramMessageLiteOrBuilder).toByteArray()));
      return;
    }
    if ((paramMessageLiteOrBuilder instanceof MessageLite.Builder)) {
      paramList.add(Unpooled.wrappedBuffer(((MessageLite.Builder)paramMessageLiteOrBuilder).build().toByteArray()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\protobuf\ProtobufEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */