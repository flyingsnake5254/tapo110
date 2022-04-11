package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class DnsServerAddressStreamProviders
{
  private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(DnsServerAddressStreamProviders.class);
  private static final Constructor<? extends DnsServerAddressStreamProvider> STREAM_PROVIDER_CONSTRUCTOR;
  
  static
  {
    boolean bool = PlatformDependent.isOsx();
    Object localObject1 = null;
    Object localObject2 = localObject1;
    Object localObject3;
    if (bool) {
      try
      {
        localObject2 = new io/netty/resolver/dns/DnsServerAddressStreamProviders$1;
        ((1)localObject2).<init>();
        localObject2 = AccessController.doPrivileged((PrivilegedAction)localObject2);
        if ((localObject2 instanceof Class))
        {
          localObject2 = (Class)localObject2;
          ((Class)localObject2).getMethod("ensureAvailability", new Class[0]).invoke(null, new Object[0]);
          localObject2 = ((Class)localObject2).getConstructor(new Class[0]);
          ((Constructor)localObject2).newInstance(new Object[0]);
        }
        else if ((localObject2 instanceof ClassNotFoundException))
        {
          localObject2 = localObject1;
        }
        else
        {
          throw ((Throwable)localObject2);
        }
      }
      finally
      {
        LOGGER.debug("Unable to use MacOSDnsServerAddressStreamProvider, fallback to system defaults", localThrowable);
        localObject3 = localObject1;
      }
    }
    STREAM_PROVIDER_CONSTRUCTOR = (Constructor)localObject3;
  }
  
  public static DnsServerAddressStreamProvider platformDefault()
  {
    Object localObject = STREAM_PROVIDER_CONSTRUCTOR;
    if (localObject != null) {}
    try
    {
      localObject = (DnsServerAddressStreamProvider)((Constructor)localObject).newInstance(new Object[0]);
      return (DnsServerAddressStreamProvider)localObject;
    }
    catch (IllegalAccessException|InstantiationException|InvocationTargetException localIllegalAccessException)
    {
      for (;;) {}
    }
    return unixDefault();
  }
  
  public static DnsServerAddressStreamProvider unixDefault()
  {
    return DefaultProviderHolder.DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER;
  }
  
  private static final class DefaultProviderHolder
  {
    static final DnsServerAddressStreamProvider DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER = new DnsServerAddressStreamProvider()
    {
      private volatile DnsServerAddressStreamProvider currentProvider = provider();
      private final AtomicLong lastRefresh = new AtomicLong(System.nanoTime());
      
      private DnsServerAddressStreamProvider provider()
      {
        Object localObject;
        if (PlatformDependent.isWindows()) {
          localObject = DefaultDnsServerAddressStreamProvider.INSTANCE;
        } else {
          localObject = UnixResolverDnsServerAddressStreamProvider.parseSilently();
        }
        return (DnsServerAddressStreamProvider)localObject;
      }
      
      public DnsServerAddressStream nameServerAddressStream(String paramAnonymousString)
      {
        long l = this.lastRefresh.get();
        DnsServerAddressStreamProvider localDnsServerAddressStreamProvider1 = this.currentProvider;
        DnsServerAddressStreamProvider localDnsServerAddressStreamProvider2 = localDnsServerAddressStreamProvider1;
        if (System.nanoTime() - l > DnsServerAddressStreamProviders.DefaultProviderHolder.REFRESH_INTERVAL)
        {
          localDnsServerAddressStreamProvider2 = localDnsServerAddressStreamProvider1;
          if (this.lastRefresh.compareAndSet(l, System.nanoTime()))
          {
            localDnsServerAddressStreamProvider2 = provider();
            this.currentProvider = localDnsServerAddressStreamProvider2;
          }
        }
        return localDnsServerAddressStreamProvider2.nameServerAddressStream(paramAnonymousString);
      }
    };
    private static final long REFRESH_INTERVAL = TimeUnit.MINUTES.toNanos(5L);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsServerAddressStreamProviders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */