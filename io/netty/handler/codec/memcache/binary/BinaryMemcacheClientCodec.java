package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectEncoder;
import io.netty.handler.codec.memcache.LastMemcacheContent;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class BinaryMemcacheClientCodec
  extends CombinedChannelDuplexHandler<BinaryMemcacheResponseDecoder, BinaryMemcacheRequestEncoder>
{
  private final boolean failOnMissingResponse;
  private final AtomicLong requestResponseCounter = new AtomicLong();
  
  public BinaryMemcacheClientCodec()
  {
    this(8192);
  }
  
  public BinaryMemcacheClientCodec(int paramInt)
  {
    this(paramInt, false);
  }
  
  public BinaryMemcacheClientCodec(int paramInt, boolean paramBoolean)
  {
    this.failOnMissingResponse = paramBoolean;
    init(new Decoder(paramInt), new Encoder(null));
  }
  
  private final class Decoder
    extends BinaryMemcacheResponseDecoder
  {
    Decoder(int paramInt)
    {
      super();
    }
    
    public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      super.channelInactive(paramChannelHandlerContext);
      if (BinaryMemcacheClientCodec.this.failOnMissingResponse)
      {
        long l = BinaryMemcacheClientCodec.this.requestResponseCounter.get();
        if (l > 0L)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("channel gone inactive with ");
          localStringBuilder.append(l);
          localStringBuilder.append(" missing response(s)");
          paramChannelHandlerContext.fireExceptionCaught(new PrematureChannelClosureException(localStringBuilder.toString()));
        }
      }
    }
    
    protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
      throws Exception
    {
      int i = paramList.size();
      super.decode(paramChannelHandlerContext, paramByteBuf, paramList);
      if (BinaryMemcacheClientCodec.this.failOnMissingResponse)
      {
        int j = paramList.size();
        while (i < j)
        {
          if ((paramList.get(i) instanceof LastMemcacheContent)) {
            BinaryMemcacheClientCodec.this.requestResponseCounter.decrementAndGet();
          }
          i++;
        }
      }
    }
  }
  
  private final class Encoder
    extends BinaryMemcacheRequestEncoder
  {
    private Encoder() {}
    
    protected void encode(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, List<Object> paramList)
      throws Exception
    {
      super.encode(paramChannelHandlerContext, paramObject, paramList);
      if ((BinaryMemcacheClientCodec.this.failOnMissingResponse) && ((paramObject instanceof LastMemcacheContent))) {
        BinaryMemcacheClientCodec.this.requestResponseCounter.incrementAndGet();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\BinaryMemcacheClientCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */