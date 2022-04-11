package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel>
  implements Cloneable
{
  static final Map.Entry<AttributeKey<?>, Object>[] EMPTY_ATTRIBUTE_ARRAY = new Map.Entry[0];
  static final Map.Entry<ChannelOption<?>, Object>[] EMPTY_OPTION_ARRAY = new Map.Entry[0];
  private final Map<AttributeKey<?>, Object> attrs;
  private volatile ChannelFactory<? extends C> channelFactory;
  volatile EventLoopGroup group;
  private volatile ChannelHandler handler;
  private volatile SocketAddress localAddress;
  private final Map<ChannelOption<?>, Object> options;
  
  AbstractBootstrap()
  {
    this.options = new LinkedHashMap();
    this.attrs = new ConcurrentHashMap();
  }
  
  AbstractBootstrap(AbstractBootstrap<B, C> paramAbstractBootstrap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    this.options = localLinkedHashMap;
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    this.attrs = localConcurrentHashMap;
    this.group = paramAbstractBootstrap.group;
    this.channelFactory = paramAbstractBootstrap.channelFactory;
    this.handler = paramAbstractBootstrap.handler;
    this.localAddress = paramAbstractBootstrap.localAddress;
    synchronized (paramAbstractBootstrap.options)
    {
      localLinkedHashMap.putAll(paramAbstractBootstrap.options);
      localConcurrentHashMap.putAll(paramAbstractBootstrap.attrs);
      return;
    }
  }
  
  static <K, V> Map<K, V> copiedMap(Map<K, V> paramMap)
  {
    if (paramMap.isEmpty()) {
      return Collections.emptyMap();
    }
    return Collections.unmodifiableMap(new HashMap(paramMap));
  }
  
  private ChannelFuture doBind(final SocketAddress paramSocketAddress)
  {
    final ChannelFuture localChannelFuture = initAndRegister();
    final Channel localChannel = localChannelFuture.channel();
    if (localChannelFuture.cause() != null) {
      return localChannelFuture;
    }
    if (localChannelFuture.isDone())
    {
      localObject = localChannel.newPromise();
      doBind0(localChannelFuture, localChannel, paramSocketAddress, (ChannelPromise)localObject);
      return (ChannelFuture)localObject;
    }
    final Object localObject = new PendingRegistrationPromise(localChannel);
    localChannelFuture.addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        paramAnonymousChannelFuture = paramAnonymousChannelFuture.cause();
        if (paramAnonymousChannelFuture != null)
        {
          localObject.setFailure(paramAnonymousChannelFuture);
        }
        else
        {
          localObject.registered();
          AbstractBootstrap.doBind0(localChannelFuture, localChannel, paramSocketAddress, localObject);
        }
      }
    });
    return (ChannelFuture)localObject;
  }
  
  private static void doBind0(ChannelFuture paramChannelFuture, final Channel paramChannel, final SocketAddress paramSocketAddress, final ChannelPromise paramChannelPromise)
  {
    paramChannel.eventLoop().execute(new Runnable()
    {
      public void run()
      {
        if (this.val$regFuture.isSuccess()) {
          paramChannel.bind(paramSocketAddress, paramChannelPromise).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        } else {
          paramChannelPromise.setFailure(this.val$regFuture.cause());
        }
      }
    });
  }
  
  private B self()
  {
    return this;
  }
  
  static void setAttributes(Channel paramChannel, Map.Entry<AttributeKey<?>, Object>[] paramArrayOfEntry)
  {
    int i = paramArrayOfEntry.length;
    for (int j = 0; j < i; j++)
    {
      Map.Entry<AttributeKey<?>, Object> localEntry = paramArrayOfEntry[j];
      paramChannel.attr((AttributeKey)localEntry.getKey()).set(localEntry.getValue());
    }
  }
  
  /* Error */
  private static void setChannelOption(Channel paramChannel, ChannelOption<?> paramChannelOption, Object paramObject, InternalLogger paramInternalLogger)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 183 1 0
    //   6: aload_1
    //   7: aload_2
    //   8: invokeinterface 189 3 0
    //   13: ifne +47 -> 60
    //   16: aload_3
    //   17: ldc -65
    //   19: aload_1
    //   20: aload_0
    //   21: invokeinterface 197 4 0
    //   26: goto +34 -> 60
    //   29: astore 4
    //   31: aload_3
    //   32: ldc -57
    //   34: iconst_4
    //   35: anewarray 5	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_2
    //   45: aastore
    //   46: dup
    //   47: iconst_2
    //   48: aload_0
    //   49: aastore
    //   50: dup
    //   51: iconst_3
    //   52: aload 4
    //   54: aastore
    //   55: invokeinterface 202 3 0
    //   60: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramChannel	Channel
    //   0	61	1	paramChannelOption	ChannelOption<?>
    //   0	61	2	paramObject	Object
    //   0	61	3	paramInternalLogger	InternalLogger
    //   29	24	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	26	29	finally
  }
  
  static void setChannelOptions(Channel paramChannel, Map.Entry<ChannelOption<?>, Object>[] paramArrayOfEntry, InternalLogger paramInternalLogger)
  {
    int i = paramArrayOfEntry.length;
    for (int j = 0; j < i; j++)
    {
      Map.Entry<ChannelOption<?>, Object> localEntry = paramArrayOfEntry[j];
      setChannelOption(paramChannel, (ChannelOption)localEntry.getKey(), localEntry.getValue(), paramInternalLogger);
    }
  }
  
  public <T> B attr(AttributeKey<T> paramAttributeKey, T paramT)
  {
    ObjectUtil.checkNotNull(paramAttributeKey, "key");
    if (paramT == null) {
      this.attrs.remove(paramAttributeKey);
    } else {
      this.attrs.put(paramAttributeKey, paramT);
    }
    return self();
  }
  
  final Map<AttributeKey<?>, Object> attrs()
  {
    return copiedMap(this.attrs);
  }
  
  final Map<AttributeKey<?>, Object> attrs0()
  {
    return this.attrs;
  }
  
  public ChannelFuture bind()
  {
    validate();
    SocketAddress localSocketAddress = this.localAddress;
    if (localSocketAddress != null) {
      return doBind(localSocketAddress);
    }
    throw new IllegalStateException("localAddress not set");
  }
  
  public ChannelFuture bind(int paramInt)
  {
    return bind(new InetSocketAddress(paramInt));
  }
  
  public ChannelFuture bind(String paramString, int paramInt)
  {
    return bind(SocketUtils.socketAddress(paramString, paramInt));
  }
  
  public ChannelFuture bind(InetAddress paramInetAddress, int paramInt)
  {
    return bind(new InetSocketAddress(paramInetAddress, paramInt));
  }
  
  public ChannelFuture bind(SocketAddress paramSocketAddress)
  {
    validate();
    return doBind((SocketAddress)ObjectUtil.checkNotNull(paramSocketAddress, "localAddress"));
  }
  
  public B channel(Class<? extends C> paramClass)
  {
    return channelFactory(new ReflectiveChannelFactory((Class)ObjectUtil.checkNotNull(paramClass, "channelClass")));
  }
  
  @Deprecated
  public B channelFactory(ChannelFactory<? extends C> paramChannelFactory)
  {
    ObjectUtil.checkNotNull(paramChannelFactory, "channelFactory");
    if (this.channelFactory == null)
    {
      this.channelFactory = paramChannelFactory;
      return self();
    }
    throw new IllegalStateException("channelFactory set already");
  }
  
  public B channelFactory(io.netty.channel.ChannelFactory<? extends C> paramChannelFactory)
  {
    return channelFactory(paramChannelFactory);
  }
  
  final ChannelFactory<? extends C> channelFactory()
  {
    return this.channelFactory;
  }
  
  public abstract B clone();
  
  public abstract AbstractBootstrapConfig<B, C> config();
  
  public B group(EventLoopGroup paramEventLoopGroup)
  {
    ObjectUtil.checkNotNull(paramEventLoopGroup, "group");
    if (this.group == null)
    {
      this.group = paramEventLoopGroup;
      return self();
    }
    throw new IllegalStateException("group set already");
  }
  
  @Deprecated
  public final EventLoopGroup group()
  {
    return this.group;
  }
  
  public B handler(ChannelHandler paramChannelHandler)
  {
    this.handler = ((ChannelHandler)ObjectUtil.checkNotNull(paramChannelHandler, "handler"));
    return self();
  }
  
  final ChannelHandler handler()
  {
    return this.handler;
  }
  
  abstract void init(Channel paramChannel)
    throws Exception;
  
  final ChannelFuture initAndRegister()
  {
    Object localObject = null;
    try
    {
      Channel localChannel = this.channelFactory.newChannel();
      localObject = localChannel;
      init(localChannel);
      localObject = config().group().register(localChannel);
      if (((io.netty.util.concurrent.Future)localObject).cause() != null) {
        if (localChannel.isRegistered()) {
          localChannel.close();
        } else {
          localChannel.unsafe().closeForcibly();
        }
      }
      return (ChannelFuture)localObject;
    }
    finally
    {
      if (localObject != null)
      {
        ((Channel)localObject).unsafe().closeForcibly();
        return new DefaultChannelPromise((Channel)localObject, GlobalEventExecutor.INSTANCE).setFailure(localThrowable);
      }
      return new DefaultChannelPromise(new FailedChannel(), GlobalEventExecutor.INSTANCE).setFailure(localThrowable);
    }
  }
  
  public B localAddress(int paramInt)
  {
    return localAddress(new InetSocketAddress(paramInt));
  }
  
  public B localAddress(String paramString, int paramInt)
  {
    return localAddress(SocketUtils.socketAddress(paramString, paramInt));
  }
  
  public B localAddress(InetAddress paramInetAddress, int paramInt)
  {
    return localAddress(new InetSocketAddress(paramInetAddress, paramInt));
  }
  
  public B localAddress(SocketAddress paramSocketAddress)
  {
    this.localAddress = paramSocketAddress;
    return self();
  }
  
  final SocketAddress localAddress()
  {
    return this.localAddress;
  }
  
  final Map.Entry<ChannelOption<?>, Object>[] newOptionsArray()
  {
    synchronized (this.options)
    {
      Map.Entry[] arrayOfEntry = (Map.Entry[])this.options.entrySet().toArray(EMPTY_OPTION_ARRAY);
      return arrayOfEntry;
    }
  }
  
  public <T> B option(ChannelOption<T> paramChannelOption, T paramT)
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
      return self();
    }
    finally {}
  }
  
  final Map<ChannelOption<?>, Object> options()
  {
    synchronized (this.options)
    {
      Map localMap2 = copiedMap(this.options);
      return localMap2;
    }
  }
  
  final Map<ChannelOption<?>, Object> options0()
  {
    return this.options;
  }
  
  public ChannelFuture register()
  {
    validate();
    return initAndRegister();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    localStringBuilder.append(config());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public B validate()
  {
    if (this.group != null)
    {
      if (this.channelFactory != null) {
        return self();
      }
      throw new IllegalStateException("channel or channelFactory not set");
    }
    throw new IllegalStateException("group not set");
  }
  
  static final class PendingRegistrationPromise
    extends DefaultChannelPromise
  {
    private volatile boolean registered;
    
    PendingRegistrationPromise(Channel paramChannel)
    {
      super();
    }
    
    protected EventExecutor executor()
    {
      if (this.registered) {
        return super.executor();
      }
      return GlobalEventExecutor.INSTANCE;
    }
    
    void registered()
    {
      this.registered = true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\bootstrap\AbstractBootstrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */