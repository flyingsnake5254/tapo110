package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import java.util.List;

public abstract class HttpContentDecoder
  extends MessageToMessageDecoder<HttpObject>
{
  static final String IDENTITY = HttpHeaderValues.IDENTITY.toString();
  private boolean continueResponse;
  protected ChannelHandlerContext ctx;
  private EmbeddedChannel decoder;
  private boolean needRead = true;
  
  private void cleanup()
  {
    EmbeddedChannel localEmbeddedChannel = this.decoder;
    if (localEmbeddedChannel != null)
    {
      localEmbeddedChannel.finishAndReleaseAll();
      this.decoder = null;
    }
  }
  
  /* Error */
  private void cleanupSafely(ChannelHandlerContext paramChannelHandlerContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 48	io/netty/handler/codec/http/HttpContentDecoder:cleanup	()V
    //   4: goto +12 -> 16
    //   7: astore_2
    //   8: aload_1
    //   9: aload_2
    //   10: invokeinterface 54 2 0
    //   15: pop
    //   16: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17	0	this	HttpContentDecoder
    //   0	17	1	paramChannelHandlerContext	ChannelHandlerContext
    //   7	3	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	4	7	finally
  }
  
  private void decode(ByteBuf paramByteBuf, List<Object> paramList)
  {
    this.decoder.writeInbound(new Object[] { paramByteBuf.retain() });
    fetchDecoderOutput(paramList);
  }
  
  private void decodeContent(HttpContent paramHttpContent, List<Object> paramList)
  {
    decode(paramHttpContent.content(), paramList);
    if ((paramHttpContent instanceof LastHttpContent))
    {
      finishDecode(paramList);
      paramHttpContent = ((LastHttpContent)paramHttpContent).trailingHeaders();
      if (paramHttpContent.isEmpty()) {
        paramList.add(LastHttpContent.EMPTY_LAST_CONTENT);
      } else {
        paramList.add(new ComposedLastHttpContent(paramHttpContent, DecoderResult.SUCCESS));
      }
    }
  }
  
  private void fetchDecoderOutput(List<Object> paramList)
  {
    for (;;)
    {
      ByteBuf localByteBuf = (ByteBuf)this.decoder.readInbound();
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
  
  private void finishDecode(List<Object> paramList)
  {
    if (this.decoder.finish()) {
      fetchDecoderOutput(paramList);
    }
    this.decoder = null;
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    cleanupSafely(paramChannelHandlerContext);
    super.channelInactive(paramChannelHandlerContext);
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    boolean bool = this.needRead;
    this.needRead = true;
    try
    {
      paramChannelHandlerContext.fireChannelReadComplete();
      return;
    }
    finally
    {
      if ((bool) && (!paramChannelHandlerContext.channel().config().isAutoRead())) {
        paramChannelHandlerContext.read();
      }
    }
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, HttpObject paramHttpObject, List<Object> paramList)
    throws Exception
  {
    try
    {
      if (((paramHttpObject instanceof HttpResponse)) && (((HttpResponse)paramHttpObject).status().code() == 100))
      {
        if (!(paramHttpObject instanceof LastHttpContent)) {
          this.continueResponse = true;
        }
        paramList.add(ReferenceCountUtil.retain(paramHttpObject));
      }
      HttpMessage localHttpMessage;
      Object localObject1;
      AsciiString localAsciiString;
      for (;;)
      {
        return;
        if (this.continueResponse)
        {
          if ((paramHttpObject instanceof LastHttpContent)) {
            this.continueResponse = false;
          }
          paramList.add(ReferenceCountUtil.retain(paramHttpObject));
        }
        else
        {
          if (!(paramHttpObject instanceof HttpMessage)) {
            break label505;
          }
          cleanup();
          localHttpMessage = (HttpMessage)paramHttpObject;
          localObject1 = localHttpMessage.headers();
          localAsciiString = HttpHeaderNames.CONTENT_ENCODING;
          paramChannelHandlerContext = ((HttpHeaders)localObject1).get(localAsciiString);
          if (paramChannelHandlerContext != null)
          {
            paramChannelHandlerContext = paramChannelHandlerContext.trim();
          }
          else
          {
            paramChannelHandlerContext = ((HttpHeaders)localObject1).get(HttpHeaderNames.TRANSFER_ENCODING);
            if (paramChannelHandlerContext != null)
            {
              int i = paramChannelHandlerContext.indexOf(",");
              if (i != -1) {
                paramChannelHandlerContext = paramChannelHandlerContext.substring(0, i).trim();
              } else {
                paramChannelHandlerContext = paramChannelHandlerContext.trim();
              }
            }
            else
            {
              paramChannelHandlerContext = IDENTITY;
            }
          }
          localObject2 = newContentDecoder(paramChannelHandlerContext);
          this.decoder = ((EmbeddedChannel)localObject2);
          if (localObject2 != null) {
            break;
          }
          if ((localHttpMessage instanceof HttpContent)) {
            ((HttpContent)localHttpMessage).retain();
          }
          paramList.add(localHttpMessage);
        }
      }
      Object localObject2 = HttpHeaderNames.CONTENT_LENGTH;
      if (((HttpHeaders)localObject1).contains((CharSequence)localObject2))
      {
        ((HttpHeaders)localObject1).remove((CharSequence)localObject2);
        ((HttpHeaders)localObject1).set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
      }
      paramChannelHandlerContext = getTargetContentEncoding(paramChannelHandlerContext);
      if (HttpHeaderValues.IDENTITY.contentEquals(paramChannelHandlerContext)) {
        ((HttpHeaders)localObject1).remove(localAsciiString);
      } else {
        ((HttpHeaders)localObject1).set(localAsciiString, paramChannelHandlerContext);
      }
      if ((localHttpMessage instanceof HttpContent))
      {
        if ((localHttpMessage instanceof HttpRequest))
        {
          localObject1 = (HttpRequest)localHttpMessage;
          paramChannelHandlerContext = new io/netty/handler/codec/http/DefaultHttpRequest;
          paramChannelHandlerContext.<init>(((HttpMessage)localObject1).protocolVersion(), ((HttpRequest)localObject1).method(), ((HttpRequest)localObject1).uri());
        }
        else
        {
          if (!(localHttpMessage instanceof HttpResponse)) {
            break label445;
          }
          paramChannelHandlerContext = (HttpResponse)localHttpMessage;
          paramChannelHandlerContext = new DefaultHttpResponse(paramChannelHandlerContext.protocolVersion(), paramChannelHandlerContext.status());
        }
        paramChannelHandlerContext.headers().set(localHttpMessage.headers());
        paramChannelHandlerContext.setDecoderResult(localHttpMessage.decoderResult());
        paramList.add(paramChannelHandlerContext);
        break label505;
        label445:
        paramHttpObject = new io/netty/handler/codec/CodecException;
        paramChannelHandlerContext = new java/lang/StringBuilder;
        paramChannelHandlerContext.<init>();
        paramChannelHandlerContext.append("Object of class ");
        paramChannelHandlerContext.append(localHttpMessage.getClass().getName());
        paramChannelHandlerContext.append(" is not an HttpRequest or HttpResponse");
        paramHttpObject.<init>(paramChannelHandlerContext.toString());
        throw paramHttpObject;
      }
      else
      {
        paramList.add(localHttpMessage);
      }
      label505:
      if ((paramHttpObject instanceof HttpContent))
      {
        paramChannelHandlerContext = (HttpContent)paramHttpObject;
        if (this.decoder == null) {
          paramList.add(paramChannelHandlerContext.retain());
        } else {
          decodeContent(paramChannelHandlerContext, paramList);
        }
      }
      return;
    }
    finally
    {
      this.needRead = paramList.isEmpty();
    }
  }
  
  protected String getTargetContentEncoding(String paramString)
    throws Exception
  {
    return IDENTITY;
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
    super.handlerAdded(paramChannelHandlerContext);
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    cleanupSafely(paramChannelHandlerContext);
    super.handlerRemoved(paramChannelHandlerContext);
  }
  
  protected abstract EmbeddedChannel newContentDecoder(String paramString)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpContentDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */