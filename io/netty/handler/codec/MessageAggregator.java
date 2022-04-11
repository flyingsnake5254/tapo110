package io.netty.handler.codec;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public abstract class MessageAggregator<I, S, C extends ByteBufHolder, O extends ByteBufHolder>
  extends MessageToMessageDecoder<I>
{
  private static final int DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS = 1024;
  private boolean aggregating;
  private ChannelFutureListener continueResponseWriteListener;
  private ChannelHandlerContext ctx;
  private O currentMessage;
  private boolean handlingOversizedMessage;
  private final int maxContentLength;
  private int maxCumulationBufferComponents = 1024;
  
  protected MessageAggregator(int paramInt)
  {
    validateMaxContentLength(paramInt);
    this.maxContentLength = paramInt;
  }
  
  protected MessageAggregator(int paramInt, Class<? extends I> paramClass)
  {
    super(paramClass);
    validateMaxContentLength(paramInt);
    this.maxContentLength = paramInt;
  }
  
  private static void appendPartialContent(CompositeByteBuf paramCompositeByteBuf, ByteBuf paramByteBuf)
  {
    if (paramByteBuf.isReadable()) {
      paramCompositeByteBuf.addComponent(true, paramByteBuf.retain());
    }
  }
  
  private void finishAggregation0(O paramO)
    throws Exception
  {
    this.aggregating = false;
    finishAggregation(paramO);
  }
  
  private void invokeHandleOversizedMessage(ChannelHandlerContext paramChannelHandlerContext, S paramS)
    throws Exception
  {
    this.handlingOversizedMessage = true;
    this.currentMessage = null;
    try
    {
      handleOversizedMessage(paramChannelHandlerContext, paramS);
      return;
    }
    finally
    {
      ReferenceCountUtil.release(paramS);
    }
  }
  
  private void releaseCurrentMessage()
  {
    ByteBufHolder localByteBufHolder = this.currentMessage;
    if (localByteBufHolder != null)
    {
      localByteBufHolder.release();
      this.currentMessage = null;
      this.handlingOversizedMessage = false;
      this.aggregating = false;
    }
  }
  
  private static void validateMaxContentLength(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "maxContentLength");
  }
  
  public boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    if (!super.acceptInboundMessage(paramObject)) {
      return false;
    }
    if (isAggregated(paramObject)) {
      return false;
    }
    if (isStartMessage(paramObject))
    {
      this.aggregating = true;
      return true;
    }
    return (this.aggregating) && (isContentMessage(paramObject));
  }
  
  protected void aggregate(O paramO, C paramC)
    throws Exception
  {}
  
  protected abstract O beginAggregation(S paramS, ByteBuf paramByteBuf)
    throws Exception;
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    try
    {
      super.channelInactive(paramChannelHandlerContext);
      return;
    }
    finally
    {
      releaseCurrentMessage();
    }
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if ((this.currentMessage != null) && (!paramChannelHandlerContext.channel().config().isAutoRead())) {
      paramChannelHandlerContext.read();
    }
    paramChannelHandlerContext.fireChannelReadComplete();
  }
  
  protected abstract boolean closeAfterContinueResponse(Object paramObject)
    throws Exception;
  
  protected final ChannelHandlerContext ctx()
  {
    ChannelHandlerContext localChannelHandlerContext = this.ctx;
    if (localChannelHandlerContext != null) {
      return localChannelHandlerContext;
    }
    throw new IllegalStateException("not added to a pipeline yet");
  }
  
  protected void decode(final ChannelHandlerContext paramChannelHandlerContext, I paramI, List<Object> paramList)
    throws Exception
  {
    Object localObject1;
    boolean bool;
    if (isStartMessage(paramI))
    {
      this.handlingOversizedMessage = false;
      localObject1 = this.currentMessage;
      if (localObject1 == null)
      {
        Object localObject2 = newContinueResponse(paramI, this.maxContentLength, paramChannelHandlerContext.pipeline());
        if (localObject2 != null)
        {
          ChannelFutureListener localChannelFutureListener = this.continueResponseWriteListener;
          localObject1 = localChannelFutureListener;
          if (localChannelFutureListener == null)
          {
            localObject1 = new ChannelFutureListener()
            {
              public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
                throws Exception
              {
                if (!paramAnonymousChannelFuture.isSuccess()) {
                  paramChannelHandlerContext.fireExceptionCaught(paramAnonymousChannelFuture.cause());
                }
              }
            };
            this.continueResponseWriteListener = ((ChannelFutureListener)localObject1);
          }
          bool = closeAfterContinueResponse(localObject2);
          this.handlingOversizedMessage = ignoreContentAfterContinueResponse(localObject2);
          localObject1 = paramChannelHandlerContext.writeAndFlush(localObject2).addListener((GenericFutureListener)localObject1);
          if (bool)
          {
            ((ChannelFuture)localObject1).addListener(ChannelFutureListener.CLOSE);
            return;
          }
          if (!this.handlingOversizedMessage) {}
        }
        else if (isContentLengthInvalid(paramI, this.maxContentLength))
        {
          invokeHandleOversizedMessage(paramChannelHandlerContext, paramI);
          return;
        }
        if (((paramI instanceof DecoderResultProvider)) && (!((DecoderResultProvider)paramI).decoderResult().isSuccess()))
        {
          if ((paramI instanceof ByteBufHolder)) {
            paramChannelHandlerContext = beginAggregation(paramI, ((ByteBufHolder)paramI).content().retain());
          } else {
            paramChannelHandlerContext = beginAggregation(paramI, Unpooled.EMPTY_BUFFER);
          }
          finishAggregation0(paramChannelHandlerContext);
          paramList.add(paramChannelHandlerContext);
          return;
        }
        paramChannelHandlerContext = paramChannelHandlerContext.alloc().compositeBuffer(this.maxCumulationBufferComponents);
        if ((paramI instanceof ByteBufHolder)) {
          appendPartialContent(paramChannelHandlerContext, ((ByteBufHolder)paramI).content());
        }
        this.currentMessage = beginAggregation(paramI, paramChannelHandlerContext);
      }
      else
      {
        ((ReferenceCounted)localObject1).release();
        this.currentMessage = null;
        throw new MessageAggregationException();
      }
    }
    else
    {
      if (!isContentMessage(paramI)) {
        break label494;
      }
      localObject1 = this.currentMessage;
      if (localObject1 == null) {
        return;
      }
      localObject1 = (CompositeByteBuf)((ByteBufHolder)localObject1).content();
      paramI = (ByteBufHolder)paramI;
      if (((AbstractByteBuf)localObject1).readableBytes() > this.maxContentLength - paramI.content().readableBytes())
      {
        invokeHandleOversizedMessage(paramChannelHandlerContext, this.currentMessage);
        return;
      }
      appendPartialContent((CompositeByteBuf)localObject1, paramI.content());
      aggregate(this.currentMessage, paramI);
      if ((paramI instanceof DecoderResultProvider))
      {
        paramChannelHandlerContext = ((DecoderResultProvider)paramI).decoderResult();
        if (!paramChannelHandlerContext.isSuccess())
        {
          paramI = this.currentMessage;
          if ((paramI instanceof DecoderResultProvider)) {
            ((DecoderResultProvider)paramI).setDecoderResult(DecoderResult.failure(paramChannelHandlerContext.cause()));
          }
          bool = true;
        }
        else
        {
          bool = isLastContentMessage(paramI);
        }
      }
      else
      {
        bool = isLastContentMessage(paramI);
      }
      if (bool)
      {
        finishAggregation0(this.currentMessage);
        paramList.add(this.currentMessage);
        this.currentMessage = null;
      }
    }
    return;
    label494:
    throw new MessageAggregationException();
  }
  
  protected void finishAggregation(O paramO)
    throws Exception
  {}
  
  protected void handleOversizedMessage(ChannelHandlerContext paramChannelHandlerContext, S paramS)
    throws Exception
  {
    paramS = new StringBuilder();
    paramS.append("content length exceeded ");
    paramS.append(maxContentLength());
    paramS.append(" bytes.");
    paramChannelHandlerContext.fireExceptionCaught(new TooLongFrameException(paramS.toString()));
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    try
    {
      super.handlerRemoved(paramChannelHandlerContext);
      return;
    }
    finally
    {
      releaseCurrentMessage();
    }
  }
  
  protected abstract boolean ignoreContentAfterContinueResponse(Object paramObject)
    throws Exception;
  
  protected abstract boolean isAggregated(I paramI)
    throws Exception;
  
  protected abstract boolean isContentLengthInvalid(S paramS, int paramInt)
    throws Exception;
  
  protected abstract boolean isContentMessage(I paramI)
    throws Exception;
  
  @Deprecated
  public final boolean isHandlingOversizedMessage()
  {
    return this.handlingOversizedMessage;
  }
  
  protected abstract boolean isLastContentMessage(C paramC)
    throws Exception;
  
  protected abstract boolean isStartMessage(I paramI)
    throws Exception;
  
  public final int maxContentLength()
  {
    return this.maxContentLength;
  }
  
  public final int maxCumulationBufferComponents()
  {
    return this.maxCumulationBufferComponents;
  }
  
  protected abstract Object newContinueResponse(S paramS, int paramInt, ChannelPipeline paramChannelPipeline)
    throws Exception;
  
  public final void setMaxCumulationBufferComponents(int paramInt)
  {
    if (paramInt >= 2)
    {
      if (this.ctx == null)
      {
        this.maxCumulationBufferComponents = paramInt;
        return;
      }
      throw new IllegalStateException("decoder properties cannot be changed once the decoder is added to a pipeline.");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxCumulationBufferComponents: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: >= 2)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\MessageAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */