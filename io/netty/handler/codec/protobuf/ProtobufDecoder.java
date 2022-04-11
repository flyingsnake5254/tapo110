package io.netty.handler.codec.protobuf;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite.Builder;
import com.google.protobuf.Parser;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

@ChannelHandler.a
public class ProtobufDecoder
  extends MessageToMessageDecoder<ByteBuf>
{
  private static final boolean HAS_PARSER;
  private final ExtensionRegistryLite extensionRegistry;
  private final MessageLite prototype;
  
  static
  {
    boolean bool = false;
    try
    {
      MessageLite.class.getDeclaredMethod("getParserForType", new Class[0]);
      bool = true;
    }
    finally
    {
      for (;;) {}
    }
    HAS_PARSER = bool;
  }
  
  public ProtobufDecoder(MessageLite paramMessageLite)
  {
    this(paramMessageLite, null);
  }
  
  public ProtobufDecoder(MessageLite paramMessageLite, ExtensionRegistry paramExtensionRegistry)
  {
    this(paramMessageLite, paramExtensionRegistry);
  }
  
  public ProtobufDecoder(MessageLite paramMessageLite, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    this.prototype = ((MessageLite)ObjectUtil.checkNotNull(paramMessageLite, "prototype")).getDefaultInstanceForType();
    this.extensionRegistry = paramExtensionRegistryLite;
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = paramByteBuf.readableBytes();
    boolean bool = paramByteBuf.hasArray();
    int j = 0;
    if (bool)
    {
      paramChannelHandlerContext = paramByteBuf.array();
      j = paramByteBuf.arrayOffset() + paramByteBuf.readerIndex();
    }
    else
    {
      paramChannelHandlerContext = ByteBufUtil.getBytes(paramByteBuf, paramByteBuf.readerIndex(), i, false);
    }
    if (this.extensionRegistry == null)
    {
      if (HAS_PARSER) {
        paramList.add(this.prototype.getParserForType().parseFrom(paramChannelHandlerContext, j, i));
      } else {
        paramList.add(this.prototype.newBuilderForType().mergeFrom(paramChannelHandlerContext, j, i).build());
      }
    }
    else if (HAS_PARSER) {
      paramList.add(this.prototype.getParserForType().parseFrom(paramChannelHandlerContext, j, i, this.extensionRegistry));
    } else {
      paramList.add(this.prototype.newBuilderForType().mergeFrom(paramChannelHandlerContext, j, i, this.extensionRegistry).build());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\protobuf\ProtobufDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */