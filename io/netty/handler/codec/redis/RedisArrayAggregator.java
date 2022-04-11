package io.netty.handler.codec.redis;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class RedisArrayAggregator
  extends MessageToMessageDecoder<a>
{
  private final Deque<AggregateState> depths = new ArrayDeque(4);
  
  private a decodeRedisArrayHeader(ArrayHeaderRedisMessage paramArrayHeaderRedisMessage)
  {
    if (paramArrayHeaderRedisMessage.isNull()) {
      return ArrayRedisMessage.NULL_INSTANCE;
    }
    if (paramArrayHeaderRedisMessage.length() == 0L) {
      return ArrayRedisMessage.EMPTY_INSTANCE;
    }
    if (paramArrayHeaderRedisMessage.length() > 0L)
    {
      if (paramArrayHeaderRedisMessage.length() <= 2147483647L)
      {
        this.depths.push(new AggregateState((int)paramArrayHeaderRedisMessage.length()));
        return null;
      }
      throw new CodecException("this codec doesn't support longer length than 2147483647");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bad length: ");
    localStringBuilder.append(paramArrayHeaderRedisMessage.length());
    throw new CodecException(localStringBuilder.toString());
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, a parama, List<Object> paramList)
    throws Exception
  {
    if ((parama instanceof ArrayHeaderRedisMessage))
    {
      paramChannelHandlerContext = decodeRedisArrayHeader((ArrayHeaderRedisMessage)parama);
      parama = paramChannelHandlerContext;
      if (paramChannelHandlerContext != null) {}
    }
    else
    {
      ReferenceCountUtil.retain(parama);
    }
    while (!this.depths.isEmpty())
    {
      paramChannelHandlerContext = (AggregateState)this.depths.peek();
      paramChannelHandlerContext.children.add(parama);
      if (paramChannelHandlerContext.children.size() == paramChannelHandlerContext.length)
      {
        parama = new ArrayRedisMessage(paramChannelHandlerContext.children);
        this.depths.pop();
      }
      else
      {
        return;
      }
    }
    paramList.add(parama);
  }
  
  private static final class AggregateState
  {
    private final List<a> children;
    private final int length;
    
    AggregateState(int paramInt)
    {
      this.length = paramInt;
      this.children = new ArrayList(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\RedisArrayAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */