package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ReferenceCounted;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SctpMessageCompletionHandler
  extends MessageToMessageDecoder<SctpMessage>
{
  private final IntObjectMap<ByteBuf> fragments = new IntObjectHashMap();
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, SctpMessage paramSctpMessage, List<Object> paramList)
    throws Exception
  {
    ByteBuf localByteBuf1 = paramSctpMessage.content();
    int i = paramSctpMessage.protocolIdentifier();
    int j = paramSctpMessage.streamIdentifier();
    boolean bool1 = paramSctpMessage.isComplete();
    boolean bool2 = paramSctpMessage.isUnordered();
    ByteBuf localByteBuf2 = (ByteBuf)this.fragments.remove(j);
    paramChannelHandlerContext = localByteBuf2;
    if (localByteBuf2 == null) {
      paramChannelHandlerContext = Unpooled.EMPTY_BUFFER;
    }
    if ((bool1) && (!paramChannelHandlerContext.isReadable())) {
      paramList.add(paramSctpMessage);
    } else if ((!bool1) && (paramChannelHandlerContext.isReadable())) {
      this.fragments.put(j, Unpooled.wrappedBuffer(new ByteBuf[] { paramChannelHandlerContext, localByteBuf1 }));
    } else if ((bool1) && (paramChannelHandlerContext.isReadable())) {
      paramList.add(new SctpMessage(i, j, bool2, Unpooled.wrappedBuffer(new ByteBuf[] { paramChannelHandlerContext, localByteBuf1 })));
    } else {
      this.fragments.put(j, localByteBuf1);
    }
    localByteBuf1.retain();
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Iterator localIterator = this.fragments.values().iterator();
    while (localIterator.hasNext()) {
      ((ByteBuf)localIterator.next()).release();
    }
    this.fragments.clear();
    super.handlerRemoved(paramChannelHandlerContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\sctp\SctpMessageCompletionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */