package io.netty.handler.codec.http2;

import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Future;

@Deprecated
public class Http2MultiplexCodec
  extends Http2FrameCodec
{
  volatile ChannelHandlerContext ctx;
  private int idCount;
  private final ChannelHandler inboundStreamHandler;
  private boolean parentReadInProgress;
  private final Queue<AbstractHttp2StreamChannel> readCompletePendingQueue = new MaxCapacityQueue(new ArrayDeque(8), 100);
  private final ChannelHandler upgradeStreamHandler;
  
  Http2MultiplexCodec(Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2Settings paramHttp2Settings, ChannelHandler paramChannelHandler1, ChannelHandler paramChannelHandler2, boolean paramBoolean)
  {
    super(paramHttp2ConnectionEncoder, paramHttp2ConnectionDecoder, paramHttp2Settings, paramBoolean);
    this.inboundStreamHandler = paramChannelHandler1;
    this.upgradeStreamHandler = paramChannelHandler2;
  }
  
  private void onHttp2GoAwayFrame(ChannelHandlerContext paramChannelHandlerContext, Http2GoAwayFrame paramHttp2GoAwayFrame)
  {
    try
    {
      Http2FrameStreamVisitor local1 = new io/netty/handler/codec/http2/Http2MultiplexCodec$1;
      local1.<init>(this, paramHttp2GoAwayFrame);
      forEachActiveStream(local1);
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
    //   2: putfield 58	io/netty/handler/codec/http2/Http2MultiplexCodec:parentReadInProgress	Z
    //   5: aload_0
    //   6: getfield 46	io/netty/handler/codec/http2/Http2MultiplexCodec:readCompletePendingQueue	Ljava/util/Queue;
    //   9: invokeinterface 94 1 0
    //   14: checkcast 96	io/netty/handler/codec/http2/AbstractHttp2StreamChannel
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +26 -> 45
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 58	io/netty/handler/codec/http2/Http2MultiplexCodec:parentReadInProgress	Z
    //   27: aload_0
    //   28: getfield 46	io/netty/handler/codec/http2/Http2MultiplexCodec:readCompletePendingQueue	Ljava/util/Queue;
    //   31: invokeinterface 99 1 0
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 101	io/netty/handler/codec/http2/Http2MultiplexCodec:ctx	Lio/netty/channel/ChannelHandlerContext;
    //   41: invokevirtual 105	io/netty/handler/codec/http2/Http2MultiplexCodec:flush0	(Lio/netty/channel/ChannelHandlerContext;)V
    //   44: return
    //   45: aload_1
    //   46: invokevirtual 108	io/netty/handler/codec/http2/AbstractHttp2StreamChannel:fireChildReadComplete	()V
    //   49: goto -44 -> 5
    //   52: astore_1
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 58	io/netty/handler/codec/http2/Http2MultiplexCodec:parentReadInProgress	Z
    //   58: aload_0
    //   59: getfield 46	io/netty/handler/codec/http2/Http2MultiplexCodec:readCompletePendingQueue	Ljava/util/Queue;
    //   62: invokeinterface 99 1 0
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 101	io/netty/handler/codec/http2/Http2MultiplexCodec:ctx	Lio/netty/channel/ChannelHandlerContext;
    //   72: invokevirtual 105	io/netty/handler/codec/http2/Http2MultiplexCodec:flush0	(Lio/netty/channel/ChannelHandlerContext;)V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	Http2MultiplexCodec
    //   17	29	1	localAbstractHttp2StreamChannel	AbstractHttp2StreamChannel
    //   52	24	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	18	52	finally
    //   45	49	52	finally
  }
  
  public final void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    this.parentReadInProgress = true;
    super.channelRead(paramChannelHandlerContext, paramObject);
  }
  
  public final void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    processPendingReadCompleteQueue();
    channelReadComplete0(paramChannelHandlerContext);
  }
  
  public final void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (paramChannelHandlerContext.channel().isWritable()) {
      forEachActiveStream(AbstractHttp2StreamChannel.WRITABLE_VISITOR);
    }
    super.channelWritabilityChanged(paramChannelHandlerContext);
  }
  
  final void flush0(ChannelHandlerContext paramChannelHandlerContext)
  {
    flush(paramChannelHandlerContext);
  }
  
  public final void handlerAdded0(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (paramChannelHandlerContext.executor() == paramChannelHandlerContext.channel().eventLoop())
    {
      this.ctx = paramChannelHandlerContext;
      return;
    }
    throw new IllegalStateException("EventExecutor must be EventLoop of Channel");
  }
  
  public final void handlerRemoved0(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    super.handlerRemoved0(paramChannelHandlerContext);
    this.readCompletePendingQueue.clear();
  }
  
  final Http2StreamChannel newOutboundStream()
  {
    return new Http2MultiplexCodecStreamChannel(newStream(), null);
  }
  
  final void onHttp2Frame(ChannelHandlerContext paramChannelHandlerContext, Http2Frame paramHttp2Frame)
  {
    if ((paramHttp2Frame instanceof Http2StreamFrame))
    {
      paramChannelHandlerContext = (Http2StreamFrame)paramHttp2Frame;
      ((AbstractHttp2StreamChannel)((Http2FrameCodec.DefaultHttp2FrameStream)paramChannelHandlerContext.stream()).attachment).fireChildRead(paramChannelHandlerContext);
      return;
    }
    if ((paramHttp2Frame instanceof Http2GoAwayFrame)) {
      onHttp2GoAwayFrame(paramChannelHandlerContext, (Http2GoAwayFrame)paramHttp2Frame);
    }
    paramChannelHandlerContext.fireChannelRead(paramHttp2Frame);
  }
  
  final void onHttp2FrameStreamException(ChannelHandlerContext paramChannelHandlerContext, Http2FrameStreamException paramHttp2FrameStreamException)
  {
    paramChannelHandlerContext = (AbstractHttp2StreamChannel)((Http2FrameCodec.DefaultHttp2FrameStream)paramHttp2FrameStreamException.stream()).attachment;
    try
    {
      paramChannelHandlerContext.pipeline().fireExceptionCaught(paramHttp2FrameStreamException.getCause());
      return;
    }
    finally
    {
      paramChannelHandlerContext.unsafe().closeForcibly();
    }
  }
  
  final void onHttp2StreamStateChanged(ChannelHandlerContext paramChannelHandlerContext, Http2FrameCodec.DefaultHttp2FrameStream paramDefaultHttp2FrameStream)
  {
    int i = 2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[paramDefaultHttp2FrameStream.state().ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i != 4) {
          return;
        }
        paramChannelHandlerContext = (AbstractHttp2StreamChannel)paramDefaultHttp2FrameStream.attachment;
        if (paramChannelHandlerContext == null) {
          return;
        }
        paramChannelHandlerContext.streamClosed();
        return;
      }
    }
    else if (paramDefaultHttp2FrameStream.id() != 1) {
      return;
    }
    if (paramDefaultHttp2FrameStream.attachment == null)
    {
      if ((paramDefaultHttp2FrameStream.id() == 1) && (!connection().isServer()))
      {
        paramDefaultHttp2FrameStream = new Http2MultiplexCodecStreamChannel(paramDefaultHttp2FrameStream, this.upgradeStreamHandler);
        paramDefaultHttp2FrameStream.closeOutbound();
      }
      else
      {
        paramDefaultHttp2FrameStream = new Http2MultiplexCodecStreamChannel(paramDefaultHttp2FrameStream, this.inboundStreamHandler);
      }
      paramChannelHandlerContext = paramChannelHandlerContext.channel().eventLoop().register(paramDefaultHttp2FrameStream);
      if (paramChannelHandlerContext.isDone()) {
        Http2MultiplexHandler.registerDone(paramChannelHandlerContext);
      } else {
        paramChannelHandlerContext.addListener(Http2MultiplexHandler.CHILD_CHANNEL_REGISTRATION_LISTENER);
      }
    }
  }
  
  public void onHttpClientUpgrade()
    throws Http2Exception
  {
    if (this.upgradeStreamHandler != null)
    {
      super.onHttpClientUpgrade();
      return;
    }
    throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Client is misconfigured for upgrade requests", new Object[0]);
  }
  
  private final class Http2MultiplexCodecStreamChannel
    extends AbstractHttp2StreamChannel
  {
    Http2MultiplexCodecStreamChannel(Http2FrameCodec.DefaultHttp2FrameStream paramDefaultHttp2FrameStream, ChannelHandler paramChannelHandler)
    {
      super(Http2MultiplexCodec.access$004(Http2MultiplexCodec.this), paramChannelHandler);
    }
    
    protected void addChannelToReadCompletePendingQueue()
    {
      while (!Http2MultiplexCodec.this.readCompletePendingQueue.offer(this)) {
        Http2MultiplexCodec.this.processPendingReadCompleteQueue();
      }
    }
    
    protected void flush0(ChannelHandlerContext paramChannelHandlerContext)
    {
      Http2MultiplexCodec.this.flush0(paramChannelHandlerContext);
    }
    
    protected boolean isParentReadInProgress()
    {
      return Http2MultiplexCodec.this.parentReadInProgress;
    }
    
    protected ChannelHandlerContext parentContext()
    {
      return Http2MultiplexCodec.this.ctx;
    }
    
    protected ChannelFuture write0(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    {
      ChannelPromise localChannelPromise = paramChannelHandlerContext.newPromise();
      Http2MultiplexCodec.this.write(paramChannelHandlerContext, paramObject, localChannelPromise);
      return localChannelPromise;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2MultiplexCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */