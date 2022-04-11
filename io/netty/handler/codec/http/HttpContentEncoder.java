package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public abstract class HttpContentEncoder
  extends MessageToMessageCodec<HttpRequest, HttpObject>
{
  private static final int CONTINUE_CODE = HttpResponseStatus.CONTINUE.code();
  private static final CharSequence ZERO_LENGTH_CONNECT;
  private static final CharSequence ZERO_LENGTH_HEAD = "HEAD";
  private final Queue<CharSequence> acceptEncodingQueue = new ArrayDeque();
  private EmbeddedChannel encoder;
  private State state = State.AWAIT_HEADERS;
  
  static
  {
    ZERO_LENGTH_CONNECT = "CONNECT";
  }
  
  private void cleanup()
  {
    EmbeddedChannel localEmbeddedChannel = this.encoder;
    if (localEmbeddedChannel != null)
    {
      localEmbeddedChannel.finishAndReleaseAll();
      this.encoder = null;
    }
  }
  
  /* Error */
  private void cleanupSafely(ChannelHandlerContext paramChannelHandlerContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 77	io/netty/handler/codec/http/HttpContentEncoder:cleanup	()V
    //   4: goto +12 -> 16
    //   7: astore_2
    //   8: aload_1
    //   9: aload_2
    //   10: invokeinterface 83 2 0
    //   15: pop
    //   16: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17	0	this	HttpContentEncoder
    //   0	17	1	paramChannelHandlerContext	ChannelHandlerContext
    //   7	3	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	4	7	finally
  }
  
  private void encode(ByteBuf paramByteBuf, List<Object> paramList)
  {
    this.encoder.writeOutbound(new Object[] { paramByteBuf.retain() });
    fetchEncoderOutput(paramList);
  }
  
  private boolean encodeContent(HttpContent paramHttpContent, List<Object> paramList)
  {
    encode(paramHttpContent.content(), paramList);
    if ((paramHttpContent instanceof LastHttpContent))
    {
      finishEncode(paramList);
      paramHttpContent = ((LastHttpContent)paramHttpContent).trailingHeaders();
      if (paramHttpContent.isEmpty()) {
        paramList.add(LastHttpContent.EMPTY_LAST_CONTENT);
      } else {
        paramList.add(new ComposedLastHttpContent(paramHttpContent, DecoderResult.SUCCESS));
      }
      return true;
    }
    return false;
  }
  
  private void encodeFullResponse(HttpResponse paramHttpResponse, HttpContent paramHttpContent, List<Object> paramList)
  {
    int i = paramList.size();
    encodeContent(paramHttpContent, paramList);
    if (HttpUtil.isContentLengthSet(paramHttpResponse))
    {
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        paramHttpContent = paramList.get(i);
        k = j;
        if ((paramHttpContent instanceof HttpContent)) {
          k = j + ((HttpContent)paramHttpContent).content().readableBytes();
        }
        i++;
      }
      HttpUtil.setContentLength(paramHttpResponse, j);
    }
    else
    {
      paramHttpResponse.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
    }
  }
  
  private static void ensureContent(HttpObject paramHttpObject)
  {
    if ((paramHttpObject instanceof HttpContent)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected message type: ");
    localStringBuilder.append(paramHttpObject.getClass().getName());
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(HttpContent.class.getSimpleName());
    localStringBuilder.append(')');
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private static void ensureHeaders(HttpObject paramHttpObject)
  {
    if ((paramHttpObject instanceof HttpResponse)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected message type: ");
    localStringBuilder.append(paramHttpObject.getClass().getName());
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(HttpResponse.class.getSimpleName());
    localStringBuilder.append(')');
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void fetchEncoderOutput(List<Object> paramList)
  {
    for (;;)
    {
      ByteBuf localByteBuf = (ByteBuf)this.encoder.readOutbound();
      if (localByteBuf == null) {
        return;
      }
      if (!localByteBuf.isReadable()) {
        localByteBuf.release();
      } else {
        paramList.add(new DefaultHttpContent(localByteBuf));
      }
    }
  }
  
  private void finishEncode(List<Object> paramList)
  {
    if (this.encoder.finish()) {
      fetchEncoderOutput(paramList);
    }
    this.encoder = null;
  }
  
  private static boolean isPassthru(HttpVersion paramHttpVersion, int paramInt, CharSequence paramCharSequence)
  {
    boolean bool;
    if ((paramInt >= 200) && (paramInt != 204) && (paramInt != 304) && (paramCharSequence != ZERO_LENGTH_HEAD) && ((paramCharSequence != ZERO_LENGTH_CONNECT) || (paramInt != 200)) && (paramHttpVersion != HttpVersion.HTTP_1_0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool;
    if ((!(paramObject instanceof HttpContent)) && (!(paramObject instanceof HttpResponse))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected abstract Result beginEncode(HttpResponse paramHttpResponse, String paramString)
    throws Exception;
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    cleanupSafely(paramChannelHandlerContext);
    super.channelInactive(paramChannelHandlerContext);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, HttpRequest paramHttpRequest, List<Object> paramList)
    throws Exception
  {
    paramChannelHandlerContext = paramHttpRequest.headers().getAll(HttpHeaderNames.ACCEPT_ENCODING);
    int i = paramChannelHandlerContext.size();
    if (i != 0)
    {
      if (i != 1) {
        paramChannelHandlerContext = StringUtil.join(",", paramChannelHandlerContext);
      } else {
        paramChannelHandlerContext = (CharSequence)paramChannelHandlerContext.get(0);
      }
    }
    else {
      paramChannelHandlerContext = HttpContentDecoder.IDENTITY;
    }
    HttpMethod localHttpMethod = paramHttpRequest.method();
    if (HttpMethod.HEAD.equals(localHttpMethod)) {
      paramChannelHandlerContext = ZERO_LENGTH_HEAD;
    } else if (HttpMethod.CONNECT.equals(localHttpMethod)) {
      paramChannelHandlerContext = ZERO_LENGTH_CONNECT;
    }
    this.acceptEncodingQueue.add(paramChannelHandlerContext);
    paramList.add(ReferenceCountUtil.retain(paramHttpRequest));
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, HttpObject paramHttpObject, List<Object> paramList)
    throws Exception
  {
    int i;
    if (((paramHttpObject instanceof HttpResponse)) && ((paramHttpObject instanceof LastHttpContent))) {
      i = 1;
    } else {
      i = 0;
    }
    int j = 1.$SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State[this.state.ordinal()];
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          break label465;
        }
        ensureContent(paramHttpObject);
        paramList.add(ReferenceCountUtil.retain(paramHttpObject));
        if (!(paramHttpObject instanceof LastHttpContent)) {
          break label465;
        }
        this.state = State.AWAIT_HEADERS;
        break label465;
      }
    }
    else
    {
      ensureHeaders(paramHttpObject);
      HttpResponse localHttpResponse = (HttpResponse)paramHttpObject;
      j = localHttpResponse.status().code();
      if (j == CONTINUE_CODE)
      {
        paramChannelHandlerContext = null;
      }
      else
      {
        paramChannelHandlerContext = (CharSequence)this.acceptEncodingQueue.poll();
        if (paramChannelHandlerContext == null) {
          break label466;
        }
      }
      if (isPassthru(localHttpResponse.protocolVersion(), j, paramChannelHandlerContext))
      {
        if (i != 0)
        {
          paramList.add(ReferenceCountUtil.retain(localHttpResponse));
        }
        else
        {
          paramList.add(localHttpResponse);
          this.state = State.PASS_THROUGH;
        }
      }
      else if ((i != 0) && (!((ByteBufHolder)localHttpResponse).content().isReadable()))
      {
        paramList.add(ReferenceCountUtil.retain(localHttpResponse));
      }
      else
      {
        paramChannelHandlerContext = beginEncode(localHttpResponse, paramChannelHandlerContext.toString());
        if (paramChannelHandlerContext == null)
        {
          if (i != 0)
          {
            paramList.add(ReferenceCountUtil.retain(localHttpResponse));
          }
          else
          {
            paramList.add(localHttpResponse);
            this.state = State.PASS_THROUGH;
          }
        }
        else
        {
          this.encoder = paramChannelHandlerContext.contentEncoder();
          localHttpResponse.headers().set(HttpHeaderNames.CONTENT_ENCODING, paramChannelHandlerContext.targetContentEncoding());
          if (i != 0)
          {
            paramChannelHandlerContext = new DefaultHttpResponse(localHttpResponse.protocolVersion(), localHttpResponse.status());
            paramChannelHandlerContext.headers().set(localHttpResponse.headers());
            paramList.add(paramChannelHandlerContext);
            ensureContent(localHttpResponse);
            encodeFullResponse(paramChannelHandlerContext, (HttpContent)localHttpResponse, paramList);
          }
          else
          {
            localHttpResponse.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
            localHttpResponse.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            paramList.add(localHttpResponse);
            this.state = State.AWAIT_CONTENT;
            if (!(paramHttpObject instanceof HttpContent)) {}
          }
        }
      }
    }
    ensureContent(paramHttpObject);
    if (encodeContent((HttpContent)paramHttpObject, paramList)) {
      this.state = State.AWAIT_HEADERS;
    }
    label465:
    return;
    label466:
    throw new IllegalStateException("cannot send more responses than requests");
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    cleanupSafely(paramChannelHandlerContext);
    super.handlerRemoved(paramChannelHandlerContext);
  }
  
  public static final class Result
  {
    private final EmbeddedChannel contentEncoder;
    private final String targetContentEncoding;
    
    public Result(String paramString, EmbeddedChannel paramEmbeddedChannel)
    {
      this.targetContentEncoding = ((String)ObjectUtil.checkNotNull(paramString, "targetContentEncoding"));
      this.contentEncoder = ((EmbeddedChannel)ObjectUtil.checkNotNull(paramEmbeddedChannel, "contentEncoder"));
    }
    
    public EmbeddedChannel contentEncoder()
    {
      return this.contentEncoder;
    }
    
    public String targetContentEncoding()
    {
      return this.targetContentEncoding;
    }
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("PASS_THROUGH", 0);
      PASS_THROUGH = localState1;
      State localState2 = new State("AWAIT_HEADERS", 1);
      AWAIT_HEADERS = localState2;
      State localState3 = new State("AWAIT_CONTENT", 2);
      AWAIT_CONTENT = localState3;
      $VALUES = new State[] { localState1, localState2, localState3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpContentEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */