package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.resolver.DefaultAddressResolverGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class Bootstrap
  extends AbstractBootstrap<Bootstrap, Channel>
{
  private static final AddressResolverGroup<?> DEFAULT_RESOLVER = DefaultAddressResolverGroup.INSTANCE;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(Bootstrap.class);
  private final BootstrapConfig config = new BootstrapConfig(this);
  private volatile SocketAddress remoteAddress;
  private volatile AddressResolverGroup<SocketAddress> resolver = DEFAULT_RESOLVER;
  
  public Bootstrap() {}
  
  private Bootstrap(Bootstrap paramBootstrap)
  {
    super(paramBootstrap);
    this.resolver = paramBootstrap.resolver;
    this.remoteAddress = paramBootstrap.remoteAddress;
  }
  
  private static void doConnect(final SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, final ChannelPromise paramChannelPromise)
  {
    final Channel localChannel = paramChannelPromise.channel();
    localChannel.eventLoop().execute(new Runnable()
    {
      public void run()
      {
        SocketAddress localSocketAddress = this.val$localAddress;
        if (localSocketAddress == null) {
          localChannel.connect(paramSocketAddress1, paramChannelPromise);
        } else {
          localChannel.connect(paramSocketAddress1, localSocketAddress, paramChannelPromise);
        }
        paramChannelPromise.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
      }
    });
  }
  
  private ChannelFuture doResolveAndConnect(final SocketAddress paramSocketAddress1, final SocketAddress paramSocketAddress2)
  {
    ChannelFuture localChannelFuture = initAndRegister();
    final Channel localChannel = localChannelFuture.channel();
    if (localChannelFuture.isDone())
    {
      if (!localChannelFuture.isSuccess()) {
        return localChannelFuture;
      }
      return doResolveAndConnect0(localChannel, paramSocketAddress1, paramSocketAddress2, localChannel.newPromise());
    }
    final AbstractBootstrap.PendingRegistrationPromise localPendingRegistrationPromise = new AbstractBootstrap.PendingRegistrationPromise(localChannel);
    localChannelFuture.addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        paramAnonymousChannelFuture = paramAnonymousChannelFuture.cause();
        if (paramAnonymousChannelFuture != null)
        {
          localPendingRegistrationPromise.setFailure(paramAnonymousChannelFuture);
        }
        else
        {
          localPendingRegistrationPromise.registered();
          Bootstrap.this.doResolveAndConnect0(localChannel, paramSocketAddress1, paramSocketAddress2, localPendingRegistrationPromise);
        }
      }
    });
    return localPendingRegistrationPromise;
  }
  
  private ChannelFuture doResolveAndConnect0(Channel paramChannel, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
  {
    try
    {
      Object localObject = paramChannel.eventLoop();
      try
      {
        localObject = this.resolver.getResolver((EventExecutor)localObject);
        if ((((AddressResolver)localObject).isSupported(paramSocketAddress1)) && (!((AddressResolver)localObject).isResolved(paramSocketAddress1)))
        {
          paramSocketAddress1 = ((AddressResolver)localObject).resolve(paramSocketAddress1);
          if (paramSocketAddress1.isDone())
          {
            localObject = paramSocketAddress1.cause();
            if (localObject != null)
            {
              paramChannel.close();
              paramChannelPromise.setFailure((Throwable)localObject);
            }
            else
            {
              doConnect((SocketAddress)paramSocketAddress1.getNow(), paramSocketAddress2, paramChannelPromise);
            }
            return paramChannelPromise;
          }
          localObject = new io/netty/bootstrap/Bootstrap$2;
          ((2)localObject).<init>(this, paramChannel, paramChannelPromise, paramSocketAddress2);
          paramSocketAddress1.addListener((GenericFutureListener)localObject);
        }
        else
        {
          doConnect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
          return paramChannelPromise;
        }
      }
      finally
      {
        paramChannel.close();
        paramChannel = paramChannelPromise.setFailure(paramSocketAddress1);
        return paramChannel;
      }
      return paramChannelPromise;
    }
    finally
    {
      paramChannelPromise.tryFailure(paramChannel);
    }
  }
  
  public Bootstrap clone()
  {
    return new Bootstrap(this);
  }
  
  public Bootstrap clone(EventLoopGroup paramEventLoopGroup)
  {
    Bootstrap localBootstrap = new Bootstrap(this);
    localBootstrap.group = paramEventLoopGroup;
    return localBootstrap;
  }
  
  public final BootstrapConfig config()
  {
    return this.config;
  }
  
  public ChannelFuture connect()
  {
    validate();
    SocketAddress localSocketAddress = this.remoteAddress;
    if (localSocketAddress != null) {
      return doResolveAndConnect(localSocketAddress, this.config.localAddress());
    }
    throw new IllegalStateException("remoteAddress not set");
  }
  
  public ChannelFuture connect(String paramString, int paramInt)
  {
    return connect(InetSocketAddress.createUnresolved(paramString, paramInt));
  }
  
  public ChannelFuture connect(InetAddress paramInetAddress, int paramInt)
  {
    return connect(new InetSocketAddress(paramInetAddress, paramInt));
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress)
  {
    ObjectUtil.checkNotNull(paramSocketAddress, "remoteAddress");
    validate();
    return doResolveAndConnect(paramSocketAddress, this.config.localAddress());
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
  {
    ObjectUtil.checkNotNull(paramSocketAddress1, "remoteAddress");
    validate();
    return doResolveAndConnect(paramSocketAddress1, paramSocketAddress2);
  }
  
  void init(Channel paramChannel)
  {
    paramChannel.pipeline().addLast(new ChannelHandler[] { this.config.handler() });
    AbstractBootstrap.setChannelOptions(paramChannel, newOptionsArray(), logger);
    AbstractBootstrap.setAttributes(paramChannel, (Map.Entry[])attrs0().entrySet().toArray(AbstractBootstrap.EMPTY_ATTRIBUTE_ARRAY));
  }
  
  public Bootstrap remoteAddress(String paramString, int paramInt)
  {
    this.remoteAddress = InetSocketAddress.createUnresolved(paramString, paramInt);
    return this;
  }
  
  public Bootstrap remoteAddress(InetAddress paramInetAddress, int paramInt)
  {
    this.remoteAddress = new InetSocketAddress(paramInetAddress, paramInt);
    return this;
  }
  
  public Bootstrap remoteAddress(SocketAddress paramSocketAddress)
  {
    this.remoteAddress = paramSocketAddress;
    return this;
  }
  
  final SocketAddress remoteAddress()
  {
    return this.remoteAddress;
  }
  
  public Bootstrap resolver(AddressResolverGroup<?> paramAddressResolverGroup)
  {
    Object localObject = paramAddressResolverGroup;
    if (paramAddressResolverGroup == null) {
      localObject = DEFAULT_RESOLVER;
    }
    this.resolver = ((AddressResolverGroup)localObject);
    return this;
  }
  
  final AddressResolverGroup<?> resolver()
  {
    return this.resolver;
  }
  
  public Bootstrap validate()
  {
    super.validate();
    if (this.config.handler() != null) {
      return this;
    }
    throw new IllegalStateException("handler not set");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\bootstrap\Bootstrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */