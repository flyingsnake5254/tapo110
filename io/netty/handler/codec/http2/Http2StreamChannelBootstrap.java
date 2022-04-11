package io.netty.handler.codec.http2;

import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

public final class Http2StreamChannelBootstrap
{
  private static final Map.Entry<AttributeKey<?>, Object>[] EMPTY_ATTRIBUTE_ARRAY = new Map.Entry[0];
  private static final Map.Entry<ChannelOption<?>, Object>[] EMPTY_OPTION_ARRAY;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2StreamChannelBootstrap.class);
  private final Map<AttributeKey<?>, Object> attrs = new ConcurrentHashMap();
  private final Channel channel;
  private volatile ChannelHandler handler;
  private volatile ChannelHandlerContext multiplexCtx;
  private final Map<ChannelOption<?>, Object> options = new LinkedHashMap();
  
  static
  {
    EMPTY_OPTION_ARRAY = new Map.Entry[0];
  }
  
  public Http2StreamChannelBootstrap(Channel paramChannel)
  {
    this.channel = ((Channel)ObjectUtil.checkNotNull(paramChannel, "channel"));
  }
  
  private ChannelHandlerContext findCtx()
    throws ClosedChannelException
  {
    Object localObject = this.multiplexCtx;
    if ((localObject != null) && (!((ChannelHandlerContext)localObject).isRemoved())) {
      return (ChannelHandlerContext)localObject;
    }
    ChannelPipeline localChannelPipeline = this.channel.pipeline();
    ChannelHandlerContext localChannelHandlerContext = localChannelPipeline.context(Http2MultiplexCodec.class);
    localObject = localChannelHandlerContext;
    if (localChannelHandlerContext == null) {
      localObject = localChannelPipeline.context(Http2MultiplexHandler.class);
    }
    if (localObject == null)
    {
      if (this.channel.isActive())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(StringUtil.simpleClassName(Http2MultiplexCodec.class));
        ((StringBuilder)localObject).append(" or ");
        ((StringBuilder)localObject).append(StringUtil.simpleClassName(Http2MultiplexHandler.class));
        ((StringBuilder)localObject).append(" must be in the ChannelPipeline of Channel ");
        ((StringBuilder)localObject).append(this.channel);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      throw new ClosedChannelException();
    }
    this.multiplexCtx = ((ChannelHandlerContext)localObject);
    return (ChannelHandlerContext)localObject;
  }
  
  private void init(Channel paramChannel)
  {
    Object localObject1 = paramChannel.pipeline();
    ??? = this.handler;
    if (??? != null) {
      ((ChannelPipeline)localObject1).addLast(new ChannelHandler[] { ??? });
    }
    synchronized (this.options)
    {
      localObject1 = (Map.Entry[])this.options.entrySet().toArray(EMPTY_OPTION_ARRAY);
      setChannelOptions(paramChannel, (Map.Entry[])localObject1);
      setAttributes(paramChannel, (Map.Entry[])this.attrs.entrySet().toArray(EMPTY_ATTRIBUTE_ARRAY));
      return;
    }
  }
  
  private static void setAttributes(Channel paramChannel, Map.Entry<AttributeKey<?>, Object>[] paramArrayOfEntry)
  {
    int i = paramArrayOfEntry.length;
    for (int j = 0; j < i; j++)
    {
      Map.Entry<AttributeKey<?>, Object> localEntry = paramArrayOfEntry[j];
      paramChannel.attr((AttributeKey)localEntry.getKey()).set(localEntry.getValue());
    }
  }
  
  /* Error */
  private static void setChannelOption(Channel paramChannel, ChannelOption<?> paramChannelOption, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 189 1 0
    //   6: aload_1
    //   7: aload_2
    //   8: invokeinterface 195 3 0
    //   13: ifne +49 -> 62
    //   16: getstatic 39	io/netty/handler/codec/http2/Http2StreamChannelBootstrap:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   19: ldc -59
    //   21: aload_1
    //   22: aload_0
    //   23: invokeinterface 203 4 0
    //   28: goto +34 -> 62
    //   31: astore_3
    //   32: getstatic 39	io/netty/handler/codec/http2/Http2StreamChannelBootstrap:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   35: ldc -51
    //   37: iconst_4
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_1
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_2
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: aload_0
    //   52: aastore
    //   53: dup
    //   54: iconst_3
    //   55: aload_3
    //   56: aastore
    //   57: invokeinterface 208 3 0
    //   62: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramChannel	Channel
    //   0	63	1	paramChannelOption	ChannelOption<?>
    //   0	63	2	paramObject	Object
    //   31	25	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	28	31	finally
  }
  
  private static void setChannelOptions(Channel paramChannel, Map.Entry<ChannelOption<?>, Object>[] paramArrayOfEntry)
  {
    int i = paramArrayOfEntry.length;
    for (int j = 0; j < i; j++)
    {
      Map.Entry<ChannelOption<?>, Object> localEntry = paramArrayOfEntry[j];
      setChannelOption(paramChannel, (ChannelOption)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public <T> Http2StreamChannelBootstrap attr(AttributeKey<T> paramAttributeKey, T paramT)
  {
    ObjectUtil.checkNotNull(paramAttributeKey, "key");
    if (paramT == null) {
      this.attrs.remove(paramAttributeKey);
    } else {
      this.attrs.put(paramAttributeKey, paramT);
    }
    return this;
  }
  
  public Http2StreamChannelBootstrap handler(ChannelHandler paramChannelHandler)
  {
    this.handler = ((ChannelHandler)ObjectUtil.checkNotNull(paramChannelHandler, "handler"));
    return this;
  }
  
  public io.netty.util.concurrent.Future<Http2StreamChannel> open()
  {
    return open(this.channel.eventLoop().newPromise());
  }
  
  public io.netty.util.concurrent.Future<Http2StreamChannel> open(Promise<Http2StreamChannel> paramPromise)
  {
    try
    {
      ChannelHandlerContext localChannelHandlerContext = findCtx();
      EventExecutor localEventExecutor = localChannelHandlerContext.executor();
      if (localEventExecutor.inEventLoop())
      {
        open0(localChannelHandlerContext, paramPromise);
      }
      else
      {
        Runnable local1 = new io/netty/handler/codec/http2/Http2StreamChannelBootstrap$1;
        local1.<init>(this, localChannelHandlerContext, paramPromise);
        localEventExecutor.execute(local1);
      }
    }
    finally
    {
      paramPromise.setFailure(localThrowable);
    }
    return paramPromise;
  }
  
  @Deprecated
  public void open0(ChannelHandlerContext paramChannelHandlerContext, final Promise<Http2StreamChannel> paramPromise)
  {
    if (!paramPromise.setUncancellable()) {
      return;
    }
    final Http2StreamChannel localHttp2StreamChannel;
    if ((paramChannelHandlerContext.handler() instanceof Http2MultiplexCodec)) {
      localHttp2StreamChannel = ((Http2MultiplexCodec)paramChannelHandlerContext.handler()).newOutboundStream();
    } else {
      localHttp2StreamChannel = ((Http2MultiplexHandler)paramChannelHandlerContext.handler()).newOutboundStream();
    }
    try
    {
      init(localHttp2StreamChannel);
      paramChannelHandlerContext.channel().eventLoop().register(localHttp2StreamChannel).addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        {
          if (paramAnonymousChannelFuture.isSuccess())
          {
            paramPromise.setSuccess(localHttp2StreamChannel);
          }
          else if (paramAnonymousChannelFuture.isCancelled())
          {
            paramPromise.cancel(false);
          }
          else
          {
            if (localHttp2StreamChannel.isRegistered()) {
              localHttp2StreamChannel.close();
            } else {
              localHttp2StreamChannel.unsafe().closeForcibly();
            }
            paramPromise.setFailure(paramAnonymousChannelFuture.cause());
          }
        }
      });
      return;
    }
    catch (Exception paramChannelHandlerContext)
    {
      localHttp2StreamChannel.unsafe().closeForcibly();
      paramPromise.setFailure(paramChannelHandlerContext);
    }
  }
  
  public <T> Http2StreamChannelBootstrap option(ChannelOption<T> paramChannelOption, T paramT)
  {
    ObjectUtil.checkNotNull(paramChannelOption, "option");
    Map localMap = this.options;
    if (paramT == null) {}
    try
    {
      this.options.remove(paramChannelOption);
      break label45;
      this.options.put(paramChannelOption, paramT);
      label45:
      return this;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2StreamChannelBootstrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */