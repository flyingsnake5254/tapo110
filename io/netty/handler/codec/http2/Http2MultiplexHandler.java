package io.netty.handler.codec.http2;

import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.a;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

public final class Http2MultiplexHandler
  extends Http2ChannelDuplexHandler
{
  static final ChannelFutureListener CHILD_CHANNEL_REGISTRATION_LISTENER = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
    {
      Http2MultiplexHandler.registerDone(paramAnonymousChannelFuture);
    }
  };
  private volatile ChannelHandlerContext ctx;
  private int idCount;
  private final ChannelHandler inboundStreamHandler;
  private boolean parentReadInProgress;
  private final Queue<AbstractHttp2StreamChannel> readCompletePendingQueue = new MaxCapacityQueue(new ArrayDeque(8), 100);
  private final ChannelHandler upgradeStreamHandler;
  
  public Http2MultiplexHandler(ChannelHandler paramChannelHandler)
  {
    this(paramChannelHandler, null);
  }
  
  public Http2MultiplexHandler(ChannelHandler paramChannelHandler1, ChannelHandler paramChannelHandler2)
  {
    this.inboundStreamHandler = ((ChannelHandler)ObjectUtil.checkNotNull(paramChannelHandler1, "inboundStreamHandler"));
    this.upgradeStreamHandler = paramChannelHandler2;
  }
  
  private static boolean isServer(ChannelHandlerContext paramChannelHandlerContext)
  {
    return paramChannelHandlerContext.channel().parent() instanceof a;
  }
  
  private void onHttp2GoAwayFrame(ChannelHandlerContext paramChannelHandlerContext, Http2GoAwayFrame paramHttp2GoAwayFrame)
  {
    try
    {
      boolean bool = isServer(paramChannelHandlerContext);
      Http2FrameStreamVisitor local2 = new io/netty/handler/codec/http2/Http2MultiplexHandler$2;
      local2.<init>(this, paramHttp2GoAwayFrame, bool);
      forEachActiveStream(local2);
    }
    catch (Http2Exception paramHttp2GoAwayFrame)
    {
      paramChannelHandlerContext.fireExceptionCaught(paramHttp2GoAwayFrame);
      paramChannelHandlerContext.close();
    }
  }
  
  /* Error */
  private void processPendingReadCompleteQueue()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 73	io/netty/handler/codec/http2/Http2MultiplexHandler:parentReadInProgress	Z
    //   5: aload_0
    //   6: getfield 52	io/netty/handler/codec/http2/Http2MultiplexHandler:readCompletePendingQueue	Ljava/util/Queue;
    //   9: invokeinterface 128 1 0
    //   14: checkcast 130	io/netty/handler/codec/http2/AbstractHttp2StreamChannel
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull +80 -> 99
    //   22: aload_1
    //   23: invokevirtual 133	io/netty/handler/codec/http2/AbstractHttp2StreamChannel:fireChildReadComplete	()V
    //   26: aload_0
    //   27: getfield 52	io/netty/handler/codec/http2/Http2MultiplexHandler:readCompletePendingQueue	Ljava/util/Queue;
    //   30: invokeinterface 128 1 0
    //   35: checkcast 130	io/netty/handler/codec/http2/AbstractHttp2StreamChannel
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: ifnonnull -20 -> 22
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 73	io/netty/handler/codec/http2/Http2MultiplexHandler:parentReadInProgress	Z
    //   50: aload_0
    //   51: getfield 52	io/netty/handler/codec/http2/Http2MultiplexHandler:readCompletePendingQueue	Ljava/util/Queue;
    //   54: invokeinterface 136 1 0
    //   59: aload_0
    //   60: getfield 84	io/netty/handler/codec/http2/Http2MultiplexHandler:ctx	Lio/netty/channel/ChannelHandlerContext;
    //   63: invokeinterface 140 1 0
    //   68: pop
    //   69: goto +35 -> 104
    //   72: astore_1
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 73	io/netty/handler/codec/http2/Http2MultiplexHandler:parentReadInProgress	Z
    //   78: aload_0
    //   79: getfield 52	io/netty/handler/codec/http2/Http2MultiplexHandler:readCompletePendingQueue	Ljava/util/Queue;
    //   82: invokeinterface 136 1 0
    //   87: aload_0
    //   88: getfield 84	io/netty/handler/codec/http2/Http2MultiplexHandler:ctx	Lio/netty/channel/ChannelHandlerContext;
    //   91: invokeinterface 140 1 0
    //   96: pop
    //   97: aload_1
    //   98: athrow
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 73	io/netty/handler/codec/http2/Http2MultiplexHandler:parentReadInProgress	Z
    //   104: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	Http2MultiplexHandler
    //   17	24	1	localObject1	Object
    //   72	26	1	localObject2	Object
    //   38	4	2	localAbstractHttp2StreamChannel	AbstractHttp2StreamChannel
    // Exception table:
    //   from	to	target	type
    //   22	39	72	finally
  }
  
  static void registerDone(ChannelFuture paramChannelFuture)
  {
    if (!paramChannelFuture.isSuccess())
    {
      paramChannelFuture = paramChannelFuture.channel();
      if (paramChannelFuture.isRegistered()) {
        paramChannelFuture.close();
      } else {
        paramChannelFuture.unsafe().closeForcibly();
      }
    }
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    this.parentReadInProgress = true;
    if ((paramObject instanceof Http2StreamFrame))
    {
      if ((paramObject instanceof Http2WindowUpdateFrame)) {
        return;
      }
      Http2StreamFrame localHttp2StreamFrame = (Http2StreamFrame)paramObject;
      paramChannelHandlerContext = (AbstractHttp2StreamChannel)((Http2FrameCodec.DefaultHttp2FrameStream)localHttp2StreamFrame.stream()).attachment;
      if ((paramObject instanceof Http2ResetFrame)) {
        paramChannelHandlerContext.pipeline().fireUserEventTriggered(paramObject);
      } else {
        paramChannelHandlerContext.fireChildRead(localHttp2StreamFrame);
      }
      return;
    }
    if ((paramObject instanceof Http2GoAwayFrame)) {
      onHttp2GoAwayFrame(paramChannelHandlerContext, (Http2GoAwayFrame)paramObject);
    }
    paramChannelHandlerContext.fireChannelRead(paramObject);
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    processPendingReadCompleteQueue();
    paramChannelHandlerContext.fireChannelReadComplete();
  }
  
  public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (paramChannelHandlerContext.channel().isWritable()) {
      forEachActiveStream(AbstractHttp2StreamChannel.WRITABLE_VISITOR);
    }
    paramChannelHandlerContext.fireChannelWritabilityChanged();
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    if ((paramThrowable instanceof Http2FrameStreamException))
    {
      paramChannelHandlerContext = (AbstractHttp2StreamChannel)((Http2FrameCodec.DefaultHttp2FrameStream)((Http2FrameStreamException)paramThrowable).stream()).attachment;
      try
      {
        paramChannelHandlerContext.pipeline().fireExceptionCaught(paramThrowable.getCause());
        return;
      }
      finally
      {
        paramChannelHandlerContext.unsafe().closeForcibly();
      }
    }
    paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
  }
  
  protected void handlerAdded0(ChannelHandlerContext paramChannelHandlerContext)
  {
    if (paramChannelHandlerContext.executor() == paramChannelHandlerContext.channel().eventLoop())
    {
      this.ctx = paramChannelHandlerContext;
      return;
    }
    throw new IllegalStateException("EventExecutor must be EventLoop of Channel");
  }
  
  protected void handlerRemoved0(ChannelHandlerContext paramChannelHandlerContext)
  {
    this.readCompletePendingQueue.clear();
  }
  
  Http2StreamChannel newOutboundStream()
  {
    return new Http2MultiplexHandlerStreamChannel((Http2FrameCodec.DefaultHttp2FrameStream)newStream(), null);
  }
  
  public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof Http2FrameStreamEvent))
    {
      Http2FrameStreamEvent localHttp2FrameStreamEvent = (Http2FrameStreamEvent)paramObject;
      paramObject = (Http2FrameCodec.DefaultHttp2FrameStream)localHttp2FrameStreamEvent.stream();
      if (localHttp2FrameStreamEvent.type() == Http2FrameStreamEvent.Type.State)
      {
        int i = 3.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[paramObject.state().ordinal()];
        if (i != 1)
        {
          if ((i != 2) && (i != 3))
          {
            if (i != 4) {
              break label225;
            }
            paramChannelHandlerContext = (AbstractHttp2StreamChannel)((Http2FrameCodec.DefaultHttp2FrameStream)paramObject).attachment;
            if (paramChannelHandlerContext == null) {
              break label225;
            }
            paramChannelHandlerContext.streamClosed();
            break label225;
          }
        }
        else {
          if (((Http2FrameCodec.DefaultHttp2FrameStream)paramObject).id() != 1) {
            break label225;
          }
        }
        if (((Http2FrameCodec.DefaultHttp2FrameStream)paramObject).attachment == null)
        {
          if ((((Http2FrameCodec.DefaultHttp2FrameStream)paramObject).id() == 1) && (!isServer(paramChannelHandlerContext)))
          {
            if (this.upgradeStreamHandler != null)
            {
              paramObject = new Http2MultiplexHandlerStreamChannel((Http2FrameCodec.DefaultHttp2FrameStream)paramObject, this.upgradeStreamHandler);
              ((AbstractHttp2StreamChannel)paramObject).closeOutbound();
            }
            else
            {
              throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Client is misconfigured for upgrade requests", new Object[0]);
            }
          }
          else {
            paramObject = new Http2MultiplexHandlerStreamChannel((Http2FrameCodec.DefaultHttp2FrameStream)paramObject, this.inboundStreamHandler);
          }
          paramChannelHandlerContext = paramChannelHandlerContext.channel().eventLoop().register((Channel)paramObject);
          if (paramChannelHandlerContext.isDone()) {
            registerDone(paramChannelHandlerContext);
          } else {
            paramChannelHandlerContext.addListener(CHILD_CHANNEL_REGISTRATION_LISTENER);
          }
        }
      }
      label225:
      return;
    }
    paramChannelHandlerContext.fireUserEventTriggered(paramObject);
  }
  
  private final class Http2MultiplexHandlerStreamChannel
    extends AbstractHttp2StreamChannel
  {
    Http2MultiplexHandlerStreamChannel(Http2FrameCodec.DefaultHttp2FrameStream paramDefaultHttp2FrameStream, ChannelHandler paramChannelHandler)
    {
      super(Http2MultiplexHandler.access$004(Http2MultiplexHandler.this), paramChannelHandler);
    }
    
    protected void addChannelToReadCompletePendingQueue()
    {
      while (!Http2MultiplexHandler.this.readCompletePendingQueue.offer(this)) {
        Http2MultiplexHandler.this.processPendingReadCompleteQueue();
      }
    }
    
    protected boolean isParentReadInProgress()
    {
      return Http2MultiplexHandler.this.parentReadInProgress;
    }
    
    protected ChannelHandlerContext parentContext()
    {
      return Http2MultiplexHandler.this.ctx;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2MultiplexHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */