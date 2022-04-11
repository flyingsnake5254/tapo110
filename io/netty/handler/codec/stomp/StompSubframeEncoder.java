package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class StompSubframeEncoder
  extends MessageToMessageEncoder<a>
{
  private static ByteBuf encodeContent(StompContentSubframe paramStompContentSubframe, ChannelHandlerContext paramChannelHandlerContext)
  {
    if ((paramStompContentSubframe instanceof LastStompContentSubframe))
    {
      paramChannelHandlerContext = paramChannelHandlerContext.alloc().buffer(paramStompContentSubframe.content().readableBytes() + 1);
      paramChannelHandlerContext.writeBytes(paramStompContentSubframe.content());
      paramChannelHandlerContext.writeByte(0);
      return paramChannelHandlerContext;
    }
    return paramStompContentSubframe.content().retain();
  }
  
  private static ByteBuf encodeFrame(StompHeadersSubframe paramStompHeadersSubframe, ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.alloc().buffer();
    paramChannelHandlerContext.writeCharSequence(paramStompHeadersSubframe.command().toString(), CharsetUtil.UTF_8);
    paramChannelHandlerContext.writeByte(10);
    paramStompHeadersSubframe = paramStompHeadersSubframe.headers().iterator();
    while (paramStompHeadersSubframe.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramStompHeadersSubframe.next();
      ByteBufUtil.writeUtf8(paramChannelHandlerContext, (CharSequence)localEntry.getKey());
      paramChannelHandlerContext.writeByte(58);
      ByteBufUtil.writeUtf8(paramChannelHandlerContext, (CharSequence)localEntry.getValue());
      paramChannelHandlerContext.writeByte(10);
    }
    paramChannelHandlerContext.writeByte(10);
    return paramChannelHandlerContext;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, a parama, List<Object> paramList)
    throws Exception
  {
    if ((parama instanceof StompFrame))
    {
      StompFrame localStompFrame = (StompFrame)parama;
      parama = encodeFrame(localStompFrame, paramChannelHandlerContext);
      if (localStompFrame.content().isReadable())
      {
        paramList.add(parama);
        paramList.add(encodeContent(localStompFrame, paramChannelHandlerContext));
      }
      else
      {
        parama.writeByte(0);
        paramList.add(parama);
      }
    }
    else if ((parama instanceof StompHeadersSubframe))
    {
      paramList.add(encodeFrame((StompHeadersSubframe)parama, paramChannelHandlerContext));
    }
    else if ((parama instanceof StompContentSubframe))
    {
      paramList.add(encodeContent((StompContentSubframe)parama, paramChannelHandlerContext));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\StompSubframeEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */