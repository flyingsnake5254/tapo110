package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class SpdyHttpResponseStreamIdHandler
  extends MessageToMessageCodec<Object, HttpMessage>
{
  private static final Integer NO_ID = Integer.valueOf(-1);
  private final Queue<Integer> ids = new ArrayDeque();
  
  public boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool;
    if ((!(paramObject instanceof HttpMessage)) && (!(paramObject instanceof SpdyRstStreamFrame))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, List<Object> paramList)
    throws Exception
  {
    if ((paramObject instanceof HttpMessage))
    {
      HttpMessage localHttpMessage = (HttpMessage)paramObject;
      HttpHeaders localHttpHeaders = localHttpMessage.headers();
      paramChannelHandlerContext = SpdyHttpHeaders.Names.STREAM_ID;
      if (!localHttpHeaders.contains(paramChannelHandlerContext)) {
        this.ids.add(NO_ID);
      } else {
        this.ids.add(localHttpMessage.headers().getInt(paramChannelHandlerContext));
      }
    }
    else if ((paramObject instanceof SpdyRstStreamFrame))
    {
      this.ids.remove(Integer.valueOf(((SpdyRstStreamFrame)paramObject).streamId()));
    }
    paramList.add(ReferenceCountUtil.retain(paramObject));
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, HttpMessage paramHttpMessage, List<Object> paramList)
    throws Exception
  {
    Integer localInteger = (Integer)this.ids.poll();
    if ((localInteger != null) && (localInteger.intValue() != NO_ID.intValue()))
    {
      HttpHeaders localHttpHeaders = paramHttpMessage.headers();
      paramChannelHandlerContext = SpdyHttpHeaders.Names.STREAM_ID;
      if (!localHttpHeaders.contains(paramChannelHandlerContext)) {
        paramHttpMessage.headers().setInt(paramChannelHandlerContext, localInteger.intValue());
      }
    }
    paramList.add(ReferenceCountUtil.retain(paramHttpMessage));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHttpResponseStreamIdHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */