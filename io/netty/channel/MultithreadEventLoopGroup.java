package io.netty.channel;

import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public abstract class MultithreadEventLoopGroup
  extends MultithreadEventExecutorGroup
  implements EventLoopGroup
{
  private static final int DEFAULT_EVENT_LOOP_THREADS;
  private static final InternalLogger logger;
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(MultithreadEventLoopGroup.class);
    logger = localInternalLogger;
    int i = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
    DEFAULT_EVENT_LOOP_THREADS = i;
    if (localInternalLogger.isDebugEnabled()) {
      localInternalLogger.debug("-Dio.netty.eventLoopThreads: {}", Integer.valueOf(i));
    }
  }
  
  protected MultithreadEventLoopGroup(int paramInt, Executor paramExecutor, EventExecutorChooserFactory paramEventExecutorChooserFactory, Object... paramVarArgs)
  {
    super(i, paramExecutor, paramEventExecutorChooserFactory, paramVarArgs);
  }
  
  protected MultithreadEventLoopGroup(int paramInt, Executor paramExecutor, Object... paramVarArgs)
  {
    super(i, paramExecutor, paramVarArgs);
  }
  
  protected MultithreadEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory, Object... paramVarArgs)
  {
    super(i, paramThreadFactory, paramVarArgs);
  }
  
  protected abstract EventLoop newChild(Executor paramExecutor, Object... paramVarArgs)
    throws Exception;
  
  protected ThreadFactory newDefaultThreadFactory()
  {
    return new DefaultThreadFactory(getClass(), 10);
  }
  
  public EventLoop next()
  {
    return (EventLoop)super.next();
  }
  
  public ChannelFuture register(Channel paramChannel)
  {
    return next().register(paramChannel);
  }
  
  @Deprecated
  public ChannelFuture register(Channel paramChannel, ChannelPromise paramChannelPromise)
  {
    return next().register(paramChannel, paramChannelPromise);
  }
  
  public ChannelFuture register(ChannelPromise paramChannelPromise)
  {
    return next().register(paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\MultithreadEventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */