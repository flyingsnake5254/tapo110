package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.MessageAggregator;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class HttpObjectAggregator
  extends MessageAggregator<HttpObject, HttpMessage, HttpContent, FullHttpMessage>
{
  private static final FullHttpResponse CONTINUE;
  private static final FullHttpResponse EXPECTATION_FAILED;
  private static final FullHttpResponse TOO_LARGE;
  private static final FullHttpResponse TOO_LARGE_CLOSE;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(HttpObjectAggregator.class);
  private final boolean closeOnExpectationFailed;
  
  static
  {
    Object localObject1 = HttpVersion.HTTP_1_1;
    Object localObject2 = HttpResponseStatus.CONTINUE;
    Object localObject3 = Unpooled.EMPTY_BUFFER;
    CONTINUE = new DefaultFullHttpResponse((HttpVersion)localObject1, (HttpResponseStatus)localObject2, (ByteBuf)localObject3);
    Object localObject4 = new DefaultFullHttpResponse((HttpVersion)localObject1, HttpResponseStatus.EXPECTATION_FAILED, (ByteBuf)localObject3);
    EXPECTATION_FAILED = (FullHttpResponse)localObject4;
    HttpResponseStatus localHttpResponseStatus = HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE;
    localObject2 = new DefaultFullHttpResponse((HttpVersion)localObject1, localHttpResponseStatus, (ByteBuf)localObject3);
    TOO_LARGE_CLOSE = (FullHttpResponse)localObject2;
    localObject1 = new DefaultFullHttpResponse((HttpVersion)localObject1, localHttpResponseStatus, (ByteBuf)localObject3);
    TOO_LARGE = (FullHttpResponse)localObject1;
    localObject3 = ((HttpMessage)localObject4).headers();
    localObject4 = HttpHeaderNames.CONTENT_LENGTH;
    ((HttpHeaders)localObject3).set((CharSequence)localObject4, Integer.valueOf(0));
    ((HttpMessage)localObject1).headers().set((CharSequence)localObject4, Integer.valueOf(0));
    ((HttpMessage)localObject2).headers().set((CharSequence)localObject4, Integer.valueOf(0));
    ((HttpMessage)localObject2).headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
  }
  
  public HttpObjectAggregator(int paramInt)
  {
    this(paramInt, false);
  }
  
  public HttpObjectAggregator(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.closeOnExpectationFailed = paramBoolean;
  }
  
  private static Object continueResponse(HttpMessage paramHttpMessage, int paramInt, ChannelPipeline paramChannelPipeline)
  {
    if (HttpUtil.isUnsupportedExpectation(paramHttpMessage))
    {
      paramChannelPipeline.fireUserEventTriggered(HttpExpectationFailedEvent.INSTANCE);
      return EXPECTATION_FAILED.retainedDuplicate();
    }
    if (HttpUtil.is100ContinueExpected(paramHttpMessage))
    {
      if (HttpUtil.getContentLength(paramHttpMessage, -1L) <= paramInt) {
        return CONTINUE.retainedDuplicate();
      }
      paramChannelPipeline.fireUserEventTriggered(HttpExpectationFailedEvent.INSTANCE);
      return TOO_LARGE.retainedDuplicate();
    }
    return null;
  }
  
  protected void aggregate(FullHttpMessage paramFullHttpMessage, HttpContent paramHttpContent)
    throws Exception
  {
    if ((paramHttpContent instanceof LastHttpContent)) {
      ((AggregatedFullHttpMessage)paramFullHttpMessage).setTrailingHeaders(((LastHttpContent)paramHttpContent).trailingHeaders());
    }
  }
  
  protected FullHttpMessage beginAggregation(HttpMessage paramHttpMessage, ByteBuf paramByteBuf)
    throws Exception
  {
    HttpUtil.setTransferEncodingChunked(paramHttpMessage, false);
    if ((paramHttpMessage instanceof HttpRequest))
    {
      paramHttpMessage = new AggregatedFullHttpRequest((HttpRequest)paramHttpMessage, paramByteBuf, null);
    }
    else
    {
      if (!(paramHttpMessage instanceof HttpResponse)) {
        break label52;
      }
      paramHttpMessage = new AggregatedFullHttpResponse((HttpResponse)paramHttpMessage, paramByteBuf, null);
    }
    return paramHttpMessage;
    label52:
    throw new Error();
  }
  
  protected boolean closeAfterContinueResponse(Object paramObject)
  {
    boolean bool;
    if ((this.closeOnExpectationFailed) && (ignoreContentAfterContinueResponse(paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void finishAggregation(FullHttpMessage paramFullHttpMessage)
    throws Exception
  {
    if (!HttpUtil.isContentLengthSet(paramFullHttpMessage)) {
      paramFullHttpMessage.headers().set(HttpHeaderNames.CONTENT_LENGTH, String.valueOf(paramFullHttpMessage.content().readableBytes()));
    }
  }
  
  protected void handleOversizedMessage(final ChannelHandlerContext paramChannelHandlerContext, HttpMessage paramHttpMessage)
    throws Exception
  {
    if ((paramHttpMessage instanceof HttpRequest))
    {
      if ((!(paramHttpMessage instanceof FullHttpMessage)) && ((HttpUtil.is100ContinueExpected(paramHttpMessage)) || (HttpUtil.isKeepAlive(paramHttpMessage)))) {
        paramChannelHandlerContext.writeAndFlush(TOO_LARGE.retainedDuplicate()).addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
            throws Exception
          {
            if (!paramAnonymousChannelFuture.isSuccess())
            {
              HttpObjectAggregator.logger.debug("Failed to send a 413 Request Entity Too Large.", paramAnonymousChannelFuture.cause());
              paramChannelHandlerContext.close();
            }
          }
        });
      } else {
        paramChannelHandlerContext.writeAndFlush(TOO_LARGE_CLOSE.retainedDuplicate()).addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
            throws Exception
          {
            if (!paramAnonymousChannelFuture.isSuccess()) {
              HttpObjectAggregator.logger.debug("Failed to send a 413 Request Entity Too Large.", paramAnonymousChannelFuture.cause());
            }
            paramChannelHandlerContext.close();
          }
        });
      }
      return;
    }
    if ((paramHttpMessage instanceof HttpResponse))
    {
      paramChannelHandlerContext.close();
      paramChannelHandlerContext = new StringBuilder();
      paramChannelHandlerContext.append("Response entity too large: ");
      paramChannelHandlerContext.append(paramHttpMessage);
      throw new TooLongFrameException(paramChannelHandlerContext.toString());
    }
    throw new IllegalStateException();
  }
  
  protected boolean ignoreContentAfterContinueResponse(Object paramObject)
  {
    if ((paramObject instanceof HttpResponse)) {
      return ((HttpResponse)paramObject).status().codeClass().equals(HttpStatusClass.CLIENT_ERROR);
    }
    return false;
  }
  
  protected boolean isAggregated(HttpObject paramHttpObject)
    throws Exception
  {
    return paramHttpObject instanceof FullHttpMessage;
  }
  
  protected boolean isContentLengthInvalid(HttpMessage paramHttpMessage, int paramInt)
  {
    boolean bool = false;
    try
    {
      long l = HttpUtil.getContentLength(paramHttpMessage, -1L);
      if (l > paramInt) {
        bool = true;
      }
    }
    catch (NumberFormatException paramHttpMessage)
    {
      for (;;) {}
    }
    return bool;
  }
  
  protected boolean isContentMessage(HttpObject paramHttpObject)
    throws Exception
  {
    return paramHttpObject instanceof HttpContent;
  }
  
  protected boolean isLastContentMessage(HttpContent paramHttpContent)
    throws Exception
  {
    return paramHttpContent instanceof LastHttpContent;
  }
  
  protected boolean isStartMessage(HttpObject paramHttpObject)
    throws Exception
  {
    return paramHttpObject instanceof HttpMessage;
  }
  
  protected Object newContinueResponse(HttpMessage paramHttpMessage, int paramInt, ChannelPipeline paramChannelPipeline)
  {
    paramChannelPipeline = continueResponse(paramHttpMessage, paramInt, paramChannelPipeline);
    if (paramChannelPipeline != null) {
      paramHttpMessage.headers().remove(HttpHeaderNames.EXPECT);
    }
    return paramChannelPipeline;
  }
  
  private static abstract class AggregatedFullHttpMessage
    implements FullHttpMessage
  {
    private final ByteBuf content;
    protected final HttpMessage message;
    private HttpHeaders trailingHeaders;
    
    AggregatedFullHttpMessage(HttpMessage paramHttpMessage, ByteBuf paramByteBuf, HttpHeaders paramHttpHeaders)
    {
      this.message = paramHttpMessage;
      this.content = paramByteBuf;
      this.trailingHeaders = paramHttpHeaders;
    }
    
    public ByteBuf content()
    {
      return this.content;
    }
    
    public abstract FullHttpMessage copy();
    
    public DecoderResult decoderResult()
    {
      return this.message.decoderResult();
    }
    
    public abstract FullHttpMessage duplicate();
    
    public DecoderResult getDecoderResult()
    {
      return this.message.decoderResult();
    }
    
    public HttpVersion getProtocolVersion()
    {
      return this.message.protocolVersion();
    }
    
    public HttpHeaders headers()
    {
      return this.message.headers();
    }
    
    public HttpVersion protocolVersion()
    {
      return this.message.protocolVersion();
    }
    
    public int refCnt()
    {
      return this.content.refCnt();
    }
    
    public boolean release()
    {
      return this.content.release();
    }
    
    public boolean release(int paramInt)
    {
      return this.content.release(paramInt);
    }
    
    public FullHttpMessage retain()
    {
      this.content.retain();
      return this;
    }
    
    public FullHttpMessage retain(int paramInt)
    {
      this.content.retain(paramInt);
      return this;
    }
    
    public abstract FullHttpMessage retainedDuplicate();
    
    public void setDecoderResult(DecoderResult paramDecoderResult)
    {
      this.message.setDecoderResult(paramDecoderResult);
    }
    
    public FullHttpMessage setProtocolVersion(HttpVersion paramHttpVersion)
    {
      this.message.setProtocolVersion(paramHttpVersion);
      return this;
    }
    
    void setTrailingHeaders(HttpHeaders paramHttpHeaders)
    {
      this.trailingHeaders = paramHttpHeaders;
    }
    
    public FullHttpMessage touch()
    {
      this.content.touch();
      return this;
    }
    
    public FullHttpMessage touch(Object paramObject)
    {
      this.content.touch(paramObject);
      return this;
    }
    
    public HttpHeaders trailingHeaders()
    {
      HttpHeaders localHttpHeaders = this.trailingHeaders;
      Object localObject = localHttpHeaders;
      if (localHttpHeaders == null) {
        localObject = EmptyHttpHeaders.INSTANCE;
      }
      return (HttpHeaders)localObject;
    }
  }
  
  private static final class AggregatedFullHttpRequest
    extends HttpObjectAggregator.AggregatedFullHttpMessage
    implements FullHttpRequest
  {
    AggregatedFullHttpRequest(HttpRequest paramHttpRequest, ByteBuf paramByteBuf, HttpHeaders paramHttpHeaders)
    {
      super(paramByteBuf, paramHttpHeaders);
    }
    
    public FullHttpRequest copy()
    {
      return replace(content().copy());
    }
    
    public FullHttpRequest duplicate()
    {
      return replace(content().duplicate());
    }
    
    public HttpMethod getMethod()
    {
      return ((HttpRequest)this.message).method();
    }
    
    public String getUri()
    {
      return ((HttpRequest)this.message).uri();
    }
    
    public HttpMethod method()
    {
      return getMethod();
    }
    
    public FullHttpRequest replace(ByteBuf paramByteBuf)
    {
      paramByteBuf = new DefaultFullHttpRequest(protocolVersion(), method(), uri(), paramByteBuf, headers().copy(), trailingHeaders().copy());
      paramByteBuf.setDecoderResult(decoderResult());
      return paramByteBuf;
    }
    
    public FullHttpRequest retain()
    {
      super.retain();
      return this;
    }
    
    public FullHttpRequest retain(int paramInt)
    {
      super.retain(paramInt);
      return this;
    }
    
    public FullHttpRequest retainedDuplicate()
    {
      return replace(content().retainedDuplicate());
    }
    
    public FullHttpRequest setMethod(HttpMethod paramHttpMethod)
    {
      ((HttpRequest)this.message).setMethod(paramHttpMethod);
      return this;
    }
    
    public FullHttpRequest setProtocolVersion(HttpVersion paramHttpVersion)
    {
      super.setProtocolVersion(paramHttpVersion);
      return this;
    }
    
    public FullHttpRequest setUri(String paramString)
    {
      ((HttpRequest)this.message).setUri(paramString);
      return this;
    }
    
    public String toString()
    {
      return HttpMessageUtil.appendFullRequest(new StringBuilder(256), this).toString();
    }
    
    public FullHttpRequest touch()
    {
      super.touch();
      return this;
    }
    
    public FullHttpRequest touch(Object paramObject)
    {
      super.touch(paramObject);
      return this;
    }
    
    public String uri()
    {
      return getUri();
    }
  }
  
  private static final class AggregatedFullHttpResponse
    extends HttpObjectAggregator.AggregatedFullHttpMessage
    implements FullHttpResponse
  {
    AggregatedFullHttpResponse(HttpResponse paramHttpResponse, ByteBuf paramByteBuf, HttpHeaders paramHttpHeaders)
    {
      super(paramByteBuf, paramHttpHeaders);
    }
    
    public FullHttpResponse copy()
    {
      return replace(content().copy());
    }
    
    public FullHttpResponse duplicate()
    {
      return replace(content().duplicate());
    }
    
    public HttpResponseStatus getStatus()
    {
      return ((HttpResponse)this.message).status();
    }
    
    public FullHttpResponse replace(ByteBuf paramByteBuf)
    {
      paramByteBuf = new DefaultFullHttpResponse(getProtocolVersion(), getStatus(), paramByteBuf, headers().copy(), trailingHeaders().copy());
      paramByteBuf.setDecoderResult(decoderResult());
      return paramByteBuf;
    }
    
    public FullHttpResponse retain()
    {
      super.retain();
      return this;
    }
    
    public FullHttpResponse retain(int paramInt)
    {
      super.retain(paramInt);
      return this;
    }
    
    public FullHttpResponse retainedDuplicate()
    {
      return replace(content().retainedDuplicate());
    }
    
    public FullHttpResponse setProtocolVersion(HttpVersion paramHttpVersion)
    {
      super.setProtocolVersion(paramHttpVersion);
      return this;
    }
    
    public FullHttpResponse setStatus(HttpResponseStatus paramHttpResponseStatus)
    {
      ((HttpResponse)this.message).setStatus(paramHttpResponseStatus);
      return this;
    }
    
    public HttpResponseStatus status()
    {
      return getStatus();
    }
    
    public String toString()
    {
      return HttpMessageUtil.appendFullResponse(new StringBuilder(256), this).toString();
    }
    
    public FullHttpResponse touch()
    {
      super.touch();
      return this;
    }
    
    public FullHttpResponse touch(Object paramObject)
    {
      super.touch(paramObject);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpObjectAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */