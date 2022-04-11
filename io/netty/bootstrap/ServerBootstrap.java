package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.a;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServerBootstrap
  extends AbstractBootstrap<ServerBootstrap, a>
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ServerBootstrap.class);
  private final Map<AttributeKey<?>, Object> childAttrs;
  private volatile EventLoopGroup childGroup;
  private volatile ChannelHandler childHandler;
  private final Map<ChannelOption<?>, Object> childOptions;
  private final ServerBootstrapConfig config;
  
  public ServerBootstrap()
  {
    this.childOptions = new LinkedHashMap();
    this.childAttrs = new ConcurrentHashMap();
    this.config = new ServerBootstrapConfig(this);
  }
  
  private ServerBootstrap(ServerBootstrap paramServerBootstrap)
  {
    super(paramServerBootstrap);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    this.childOptions = localLinkedHashMap;
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    this.childAttrs = localConcurrentHashMap;
    this.config = new ServerBootstrapConfig(this);
    this.childGroup = paramServerBootstrap.childGroup;
    this.childHandler = paramServerBootstrap.childHandler;
    synchronized (paramServerBootstrap.childOptions)
    {
      localLinkedHashMap.putAll(paramServerBootstrap.childOptions);
      localConcurrentHashMap.putAll(paramServerBootstrap.childAttrs);
      return;
    }
  }
  
  public <T> ServerBootstrap childAttr(AttributeKey<T> paramAttributeKey, T paramT)
  {
    ObjectUtil.checkNotNull(paramAttributeKey, "childKey");
    if (paramT == null) {
      this.childAttrs.remove(paramAttributeKey);
    } else {
      this.childAttrs.put(paramAttributeKey, paramT);
    }
    return this;
  }
  
  final Map<AttributeKey<?>, Object> childAttrs()
  {
    return AbstractBootstrap.copiedMap(this.childAttrs);
  }
  
  @Deprecated
  public EventLoopGroup childGroup()
  {
    return this.childGroup;
  }
  
  public ServerBootstrap childHandler(ChannelHandler paramChannelHandler)
  {
    this.childHandler = ((ChannelHandler)ObjectUtil.checkNotNull(paramChannelHandler, "childHandler"));
    return this;
  }
  
  final ChannelHandler childHandler()
  {
    return this.childHandler;
  }
  
  public <T> ServerBootstrap childOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    ObjectUtil.checkNotNull(paramChannelOption, "childOption");
    Map localMap = this.childOptions;
    if (paramT == null) {}
    try
    {
      this.childOptions.remove(paramChannelOption);
      break label44;
      this.childOptions.put(paramChannelOption, paramT);
      label44:
      return this;
    }
    finally {}
  }
  
  final Map<ChannelOption<?>, Object> childOptions()
  {
    synchronized (this.childOptions)
    {
      Map localMap2 = AbstractBootstrap.copiedMap(this.childOptions);
      return localMap2;
    }
  }
  
  public ServerBootstrap clone()
  {
    return new ServerBootstrap(this);
  }
  
  public final ServerBootstrapConfig config()
  {
    return this.config;
  }
  
  public ServerBootstrap group(EventLoopGroup paramEventLoopGroup)
  {
    return group(paramEventLoopGroup, paramEventLoopGroup);
  }
  
  public ServerBootstrap group(EventLoopGroup paramEventLoopGroup1, EventLoopGroup paramEventLoopGroup2)
  {
    super.group(paramEventLoopGroup1);
    if (this.childGroup == null)
    {
      this.childGroup = ((EventLoopGroup)ObjectUtil.checkNotNull(paramEventLoopGroup2, "childGroup"));
      return this;
    }
    throw new IllegalStateException("childGroup set already");
  }
  
  void init(Channel arg1)
  {
    AbstractBootstrap.setChannelOptions(???, newOptionsArray(), logger);
    final Object localObject1 = attrs0().entrySet();
    Map.Entry[] arrayOfEntry1 = AbstractBootstrap.EMPTY_ATTRIBUTE_ARRAY;
    AbstractBootstrap.setAttributes(???, (Map.Entry[])((Set)localObject1).toArray(arrayOfEntry1));
    ChannelPipeline localChannelPipeline = ???.pipeline();
    final EventLoopGroup localEventLoopGroup = this.childGroup;
    localObject1 = this.childHandler;
    synchronized (this.childOptions)
    {
      final Map.Entry[] arrayOfEntry2 = (Map.Entry[])this.childOptions.entrySet().toArray(AbstractBootstrap.EMPTY_OPTION_ARRAY);
      localChannelPipeline.addLast(new ChannelHandler[] { new ChannelInitializer()
      {
        public void initChannel(final Channel paramAnonymousChannel)
        {
          final ChannelPipeline localChannelPipeline = paramAnonymousChannel.pipeline();
          ChannelHandler localChannelHandler = ServerBootstrap.this.config.handler();
          if (localChannelHandler != null) {
            localChannelPipeline.addLast(new ChannelHandler[] { localChannelHandler });
          }
          paramAnonymousChannel.eventLoop().execute(new Runnable()
          {
            public void run()
            {
              ChannelPipeline localChannelPipeline = localChannelPipeline;
              Channel localChannel = paramAnonymousChannel;
              ServerBootstrap.1 local1 = ServerBootstrap.1.this;
              localChannelPipeline.addLast(new ChannelHandler[] { new ServerBootstrap.ServerBootstrapAcceptor(localChannel, local1.val$currentChildGroup, local1.val$currentChildHandler, local1.val$currentChildOptions, local1.val$currentChildAttrs) });
            }
          });
        }
      } });
      return;
    }
  }
  
  public ServerBootstrap validate()
  {
    super.validate();
    if (this.childHandler != null)
    {
      if (this.childGroup == null)
      {
        logger.warn("childGroup is not set. Using parentGroup instead.");
        this.childGroup = this.config.group();
      }
      return this;
    }
    throw new IllegalStateException("childHandler not set");
  }
  
  private static class ServerBootstrapAcceptor
    extends ChannelInboundHandlerAdapter
  {
    private final Map.Entry<AttributeKey<?>, Object>[] childAttrs;
    private final EventLoopGroup childGroup;
    private final ChannelHandler childHandler;
    private final Map.Entry<ChannelOption<?>, Object>[] childOptions;
    private final Runnable enableAutoReadTask;
    
    ServerBootstrapAcceptor(final Channel paramChannel, EventLoopGroup paramEventLoopGroup, ChannelHandler paramChannelHandler, Map.Entry<ChannelOption<?>, Object>[] paramArrayOfEntry, Map.Entry<AttributeKey<?>, Object>[] paramArrayOfEntry1)
    {
      this.childGroup = paramEventLoopGroup;
      this.childHandler = paramChannelHandler;
      this.childOptions = paramArrayOfEntry;
      this.childAttrs = paramArrayOfEntry1;
      this.enableAutoReadTask = new Runnable()
      {
        public void run()
        {
          paramChannel.config().setAutoRead(true);
        }
      };
    }
    
    private static void forceClose(Channel paramChannel, Throwable paramThrowable)
    {
      paramChannel.unsafe().closeForcibly();
      ServerBootstrap.logger.warn("Failed to register an accepted channel: {}", paramChannel, paramThrowable);
    }
    
    /* Error */
    public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    {
      // Byte code:
      //   0: aload_2
      //   1: checkcast 50	io/netty/channel/Channel
      //   4: astore_1
      //   5: aload_1
      //   6: invokeinterface 77 1 0
      //   11: iconst_1
      //   12: anewarray 79	io/netty/channel/ChannelHandler
      //   15: dup
      //   16: iconst_0
      //   17: aload_0
      //   18: getfield 31	io/netty/bootstrap/ServerBootstrap$ServerBootstrapAcceptor:childHandler	Lio/netty/channel/ChannelHandler;
      //   21: aastore
      //   22: invokeinterface 85 2 0
      //   27: pop
      //   28: aload_1
      //   29: aload_0
      //   30: getfield 33	io/netty/bootstrap/ServerBootstrap$ServerBootstrapAcceptor:childOptions	[Ljava/util/Map$Entry;
      //   33: invokestatic 63	io/netty/bootstrap/ServerBootstrap:access$100	()Lio/netty/util/internal/logging/InternalLogger;
      //   36: invokestatic 91	io/netty/bootstrap/AbstractBootstrap:setChannelOptions	(Lio/netty/channel/Channel;[Ljava/util/Map$Entry;Lio/netty/util/internal/logging/InternalLogger;)V
      //   39: aload_1
      //   40: aload_0
      //   41: getfield 35	io/netty/bootstrap/ServerBootstrap$ServerBootstrapAcceptor:childAttrs	[Ljava/util/Map$Entry;
      //   44: invokestatic 95	io/netty/bootstrap/AbstractBootstrap:setAttributes	(Lio/netty/channel/Channel;[Ljava/util/Map$Entry;)V
      //   47: aload_0
      //   48: getfield 29	io/netty/bootstrap/ServerBootstrap$ServerBootstrapAcceptor:childGroup	Lio/netty/channel/EventLoopGroup;
      //   51: aload_1
      //   52: invokeinterface 101 2 0
      //   57: astore_3
      //   58: new 11	io/netty/bootstrap/ServerBootstrap$ServerBootstrapAcceptor$2
      //   61: astore_2
      //   62: aload_2
      //   63: aload_0
      //   64: aload_1
      //   65: invokespecial 102	io/netty/bootstrap/ServerBootstrap$ServerBootstrapAcceptor$2:<init>	(Lio/netty/bootstrap/ServerBootstrap$ServerBootstrapAcceptor;Lio/netty/channel/Channel;)V
      //   68: aload_3
      //   69: aload_2
      //   70: invokeinterface 108 2 0
      //   75: pop
      //   76: goto +9 -> 85
      //   79: astore_2
      //   80: aload_1
      //   81: aload_2
      //   82: invokestatic 48	io/netty/bootstrap/ServerBootstrap$ServerBootstrapAcceptor:forceClose	(Lio/netty/channel/Channel;Ljava/lang/Throwable;)V
      //   85: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	86	0	this	ServerBootstrapAcceptor
      //   0	86	1	paramChannelHandlerContext	ChannelHandlerContext
      //   0	86	2	paramObject	Object
      //   57	12	3	localChannelFuture	ChannelFuture
      // Exception table:
      //   from	to	target	type
      //   47	76	79	finally
    }
    
    public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
      throws Exception
    {
      ChannelConfig localChannelConfig = paramChannelHandlerContext.channel().config();
      if (localChannelConfig.isAutoRead())
      {
        localChannelConfig.setAutoRead(false);
        paramChannelHandlerContext.channel().eventLoop().schedule(this.enableAutoReadTask, 1L, TimeUnit.SECONDS);
      }
      paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\bootstrap\ServerBootstrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */