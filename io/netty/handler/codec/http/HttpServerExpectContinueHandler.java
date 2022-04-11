package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;

public class HttpServerExpectContinueHandler
  extends ChannelInboundHandlerAdapter
{
  private static final FullHttpResponse ACCEPT;
  private static final FullHttpResponse EXPECTATION_FAILED;
  
  static
  {
    Object localObject1 = HttpVersion.HTTP_1_1;
    Object localObject2 = HttpResponseStatus.EXPECTATION_FAILED;
    Object localObject3 = Unpooled.EMPTY_BUFFER;
    localObject2 = new DefaultFullHttpResponse((HttpVersion)localObject1, (HttpResponseStatus)localObject2, (ByteBuf)localObject3);
    EXPECTATION_FAILED = (FullHttpResponse)localObject2;
    localObject3 = new DefaultFullHttpResponse((HttpVersion)localObject1, HttpResponseStatus.CONTINUE, (ByteBuf)localObject3);
    ACCEPT = (FullHttpResponse)localObject3;
    localObject2 = ((HttpMessage)localObject2).headers();
    AsciiString localAsciiString = HttpHeaderNames.CONTENT_LENGTH;
    localObject1 = Integer.valueOf(0);
    ((HttpHeaders)localObject2).set(localAsciiString, localObject1);
    ((HttpMessage)localObject3).headers().set(localAsciiString, localObject1);
  }
  
  protected HttpResponse acceptMessage(HttpRequest paramHttpRequest)
  {
    return ACCEPT.retainedDuplicate();
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof HttpRequest))
    {
      Object localObject = (HttpRequest)paramObject;
      if (HttpUtil.is100ContinueExpected((HttpMessage)localObject))
      {
        HttpResponse localHttpResponse = acceptMessage((HttpRequest)localObject);
        if (localHttpResponse == null)
        {
          localObject = rejectResponse((HttpRequest)localObject);
          ReferenceCountUtil.release(paramObject);
          paramChannelHandlerContext.writeAndFlush(localObject).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
          return;
        }
        paramChannelHandlerContext.writeAndFlush(localHttpResponse).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        ((HttpMessage)localObject).headers().remove(HttpHeaderNames.EXPECT);
      }
    }
    super.channelRead(paramChannelHandlerContext, paramObject);
  }
  
  protected HttpResponse rejectResponse(HttpRequest paramHttpRequest)
  {
    return EXPECTATION_FAILED.retainedDuplicate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpServerExpectContinueHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */