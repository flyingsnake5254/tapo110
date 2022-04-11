package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.StringUtil;
import java.util.List;

public abstract class AbstractMemcacheObjectEncoder<M extends MemcacheMessage>
  extends MessageToMessageEncoder<Object>
{
  private boolean expectingMoreContent;
  
  private static int contentLength(Object paramObject)
  {
    if ((paramObject instanceof MemcacheContent)) {
      return ((MemcacheContent)paramObject).content().readableBytes();
    }
    if ((paramObject instanceof ByteBuf)) {
      return ((ByteBuf)paramObject).readableBytes();
    }
    if ((paramObject instanceof FileRegion)) {
      return (int)((FileRegion)paramObject).count();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected message type: ");
    localStringBuilder.append(StringUtil.simpleClassName(paramObject));
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private static Object encodeAndRetain(Object paramObject)
  {
    if ((paramObject instanceof ByteBuf)) {
      return ((ByteBuf)paramObject).retain();
    }
    if ((paramObject instanceof MemcacheContent)) {
      return ((MemcacheContent)paramObject).content().retain();
    }
    if ((paramObject instanceof FileRegion)) {
      return ((FileRegion)paramObject).retain();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected message type: ");
    localStringBuilder.append(StringUtil.simpleClassName(paramObject));
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool;
    if ((!(paramObject instanceof a)) && (!(paramObject instanceof ByteBuf)) && (!(paramObject instanceof FileRegion))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, List<Object> paramList)
    throws Exception
  {
    if ((paramObject instanceof MemcacheMessage)) {
      if (!this.expectingMoreContent)
      {
        paramList.add(encodeMessage(paramChannelHandlerContext, (MemcacheMessage)paramObject));
      }
      else
      {
        paramChannelHandlerContext = new StringBuilder();
        paramChannelHandlerContext.append("unexpected message type: ");
        paramChannelHandlerContext.append(StringUtil.simpleClassName(paramObject));
        throw new IllegalStateException(paramChannelHandlerContext.toString());
      }
    }
    if (((paramObject instanceof MemcacheContent)) || ((paramObject instanceof ByteBuf)) || ((paramObject instanceof FileRegion)))
    {
      if (contentLength(paramObject) > 0) {
        paramList.add(encodeAndRetain(paramObject));
      } else {
        paramList.add(Unpooled.EMPTY_BUFFER);
      }
      this.expectingMoreContent = (paramObject instanceof LastMemcacheContent ^ true);
    }
  }
  
  protected abstract ByteBuf encodeMessage(ChannelHandlerContext paramChannelHandlerContext, M paramM);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\AbstractMemcacheObjectEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */