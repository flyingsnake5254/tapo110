package io.netty.channel;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

@ChannelHandler.a
public abstract class ChannelInitializer<C extends Channel>
  extends ChannelInboundHandlerAdapter
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelInitializer.class);
  private final Set<ChannelHandlerContext> initMap = Collections.newSetFromMap(new ConcurrentHashMap());
  
  /* Error */
  private boolean initChannel(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	io/netty/channel/ChannelInitializer:initMap	Ljava/util/Set;
    //   4: aload_1
    //   5: invokeinterface 50 2 0
    //   10: ifeq +98 -> 108
    //   13: aload_0
    //   14: aload_1
    //   15: invokeinterface 56 1 0
    //   20: invokevirtual 59	io/netty/channel/ChannelInitializer:initChannel	(Lio/netty/channel/Channel;)V
    //   23: aload_1
    //   24: invokeinterface 63 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: aload_0
    //   32: invokeinterface 69 2 0
    //   37: ifnull +41 -> 78
    //   40: aload_1
    //   41: aload_0
    //   42: invokeinterface 73 2 0
    //   47: pop
    //   48: goto +30 -> 78
    //   51: astore_2
    //   52: aload_0
    //   53: aload_1
    //   54: aload_2
    //   55: invokevirtual 77	io/netty/channel/ChannelInitializer:exceptionCaught	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Throwable;)V
    //   58: aload_1
    //   59: invokeinterface 63 1 0
    //   64: astore_1
    //   65: aload_1
    //   66: aload_0
    //   67: invokeinterface 69 2 0
    //   72: ifnull +6 -> 78
    //   75: goto -35 -> 40
    //   78: iconst_1
    //   79: ireturn
    //   80: astore_2
    //   81: aload_1
    //   82: invokeinterface 63 1 0
    //   87: astore_1
    //   88: aload_1
    //   89: aload_0
    //   90: invokeinterface 69 2 0
    //   95: ifnull +11 -> 106
    //   98: aload_1
    //   99: aload_0
    //   100: invokeinterface 73 2 0
    //   105: pop
    //   106: aload_2
    //   107: athrow
    //   108: iconst_0
    //   109: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	ChannelInitializer
    //   0	110	1	paramChannelHandlerContext	ChannelHandlerContext
    //   51	4	2	localThrowable	Throwable
    //   80	27	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	23	51	finally
    //   52	58	80	finally
  }
  
  private void removeState(final ChannelHandlerContext paramChannelHandlerContext)
  {
    if (paramChannelHandlerContext.isRemoved()) {
      this.initMap.remove(paramChannelHandlerContext);
    } else {
      paramChannelHandlerContext.executor().execute(new Runnable()
      {
        public void run()
        {
          ChannelInitializer.this.initMap.remove(paramChannelHandlerContext);
        }
      });
    }
  }
  
  public final void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (initChannel(paramChannelHandlerContext))
    {
      paramChannelHandlerContext.pipeline().fireChannelRegistered();
      removeState(paramChannelHandlerContext);
    }
    else
    {
      paramChannelHandlerContext.fireChannelRegistered();
    }
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    InternalLogger localInternalLogger = logger;
    if (localInternalLogger.isWarnEnabled())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to initialize a channel. Closing: ");
      localStringBuilder.append(paramChannelHandlerContext.channel());
      localInternalLogger.warn(localStringBuilder.toString(), paramThrowable);
    }
    paramChannelHandlerContext.close();
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if ((paramChannelHandlerContext.channel().isRegistered()) && (initChannel(paramChannelHandlerContext))) {
      removeState(paramChannelHandlerContext);
    }
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.initMap.remove(paramChannelHandlerContext);
  }
  
  protected abstract void initChannel(C paramC)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */