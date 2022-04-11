package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public final class HttpClientCodec
  extends CombinedChannelDuplexHandler<HttpResponseDecoder, HttpRequestEncoder>
  implements HttpClientUpgradeHandler.SourceCodec
{
  public static final boolean DEFAULT_FAIL_ON_MISSING_RESPONSE = false;
  public static final boolean DEFAULT_PARSE_HTTP_AFTER_CONNECT_REQUEST = false;
  private boolean done;
  private final boolean failOnMissingResponse;
  private final boolean parseHttpAfterConnectRequest;
  private final Queue<HttpMethod> queue = new ArrayDeque();
  private final AtomicLong requestResponseCounter = new AtomicLong();
  
  public HttpClientCodec()
  {
    this(4096, 8192, 8192, false);
  }
  
  public HttpClientCodec(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, false);
  }
  
  public HttpClientCodec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramInt3, paramBoolean, true);
  }
  
  public HttpClientCodec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, false);
  }
  
  public HttpClientCodec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4, false);
  }
  
  public HttpClientCodec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, boolean paramBoolean3)
  {
    this(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4, paramBoolean3, false);
  }
  
  public HttpClientCodec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, boolean paramBoolean3, boolean paramBoolean4)
  {
    init(new Decoder(paramInt1, paramInt2, paramInt3, paramBoolean2, paramInt4, paramBoolean4), new Encoder(null));
    this.parseHttpAfterConnectRequest = paramBoolean3;
    this.failOnMissingResponse = paramBoolean1;
  }
  
  public HttpClientCodec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    init(new Decoder(paramInt1, paramInt2, paramInt3, paramBoolean2), new Encoder(null));
    this.failOnMissingResponse = paramBoolean1;
    this.parseHttpAfterConnectRequest = paramBoolean3;
  }
  
  public boolean isSingleDecode()
  {
    return ((HttpResponseDecoder)inboundHandler()).isSingleDecode();
  }
  
  public void prepareUpgradeFrom(ChannelHandlerContext paramChannelHandlerContext)
  {
    ((Encoder)outboundHandler()).upgraded = true;
  }
  
  public void setSingleDecode(boolean paramBoolean)
  {
    ((HttpResponseDecoder)inboundHandler()).setSingleDecode(paramBoolean);
  }
  
  public void upgradeFrom(ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext.pipeline().remove(this);
  }
  
  private final class Decoder
    extends HttpResponseDecoder
  {
    Decoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      super(paramInt2, paramInt3, paramBoolean);
    }
    
    Decoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
    {
      super(paramInt2, paramInt3, paramBoolean1, paramInt4, paramBoolean2);
    }
    
    private void decrement(Object paramObject)
    {
      if (paramObject == null) {
        return;
      }
      if ((paramObject instanceof LastHttpContent)) {
        HttpClientCodec.this.requestResponseCounter.decrementAndGet();
      }
    }
    
    public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      super.channelInactive(paramChannelHandlerContext);
      if (HttpClientCodec.this.failOnMissingResponse)
      {
        long l = HttpClientCodec.this.requestResponseCounter.get();
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
      int i;
      if (HttpClientCodec.this.done)
      {
        i = actualReadableBytes();
        if (i == 0) {
          return;
        }
        paramList.add(paramByteBuf.readBytes(i));
      }
      else
      {
        i = paramList.size();
        super.decode(paramChannelHandlerContext, paramByteBuf, paramList);
        if (HttpClientCodec.this.failOnMissingResponse)
        {
          int j = paramList.size();
          while (i < j)
          {
            decrement(paramList.get(i));
            i++;
          }
        }
      }
    }
    
    protected boolean isContentAlwaysEmpty(HttpMessage paramHttpMessage)
    {
      HttpMethod localHttpMethod = (HttpMethod)HttpClientCodec.this.queue.poll();
      int i = ((HttpResponse)paramHttpMessage).status().code();
      if ((i >= 100) && (i < 200)) {
        return super.isContentAlwaysEmpty(paramHttpMessage);
      }
      if (localHttpMethod != null)
      {
        int j = localHttpMethod.name().charAt(0);
        if (j != 67)
        {
          if ((j == 72) && (HttpMethod.HEAD.equals(localHttpMethod))) {
            return true;
          }
        }
        else if ((i == 200) && (HttpMethod.CONNECT.equals(localHttpMethod)))
        {
          if (!HttpClientCodec.this.parseHttpAfterConnectRequest)
          {
            HttpClientCodec.access$302(HttpClientCodec.this, true);
            HttpClientCodec.this.queue.clear();
          }
          return true;
        }
      }
      return super.isContentAlwaysEmpty(paramHttpMessage);
    }
  }
  
  private final class Encoder
    extends HttpRequestEncoder
  {
    boolean upgraded;
    
    private Encoder() {}
    
    protected void encode(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, List<Object> paramList)
      throws Exception
    {
      if (this.upgraded)
      {
        paramList.add(ReferenceCountUtil.retain(paramObject));
        return;
      }
      if ((paramObject instanceof HttpRequest)) {
        HttpClientCodec.this.queue.offer(((HttpRequest)paramObject).method());
      }
      super.encode(paramChannelHandlerContext, paramObject, paramList);
      if ((HttpClientCodec.this.failOnMissingResponse) && (!HttpClientCodec.this.done) && ((paramObject instanceof LastHttpContent))) {
        HttpClientCodec.this.requestResponseCounter.incrementAndGet();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpClientCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */