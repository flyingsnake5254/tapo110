package io.netty.resolver.dns.macos;

import io.netty.resolver.dns.DnsServerAddressStream;
import io.netty.resolver.dns.DnsServerAddressStreamProvider;
import io.netty.resolver.dns.DnsServerAddressStreamProviders;
import io.netty.resolver.dns.DnsServerAddresses;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class MacOSDnsServerAddressStreamProvider
  implements DnsServerAddressStreamProvider
{
  private static final long REFRESH_INTERVAL;
  private static final Throwable UNAVAILABILITY_CAUSE;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(MacOSDnsServerAddressStreamProvider.class);
  private volatile Map<String, DnsServerAddresses> currentMappings = retrieveCurrentMappings();
  private final AtomicLong lastRefresh = new AtomicLong(System.nanoTime());
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokestatic 25	io/netty/util/internal/logging/InternalLoggerFactory:getInstance	(Ljava/lang/Class;)Lio/netty/util/internal/logging/InternalLogger;
    //   5: putstatic 27	io/netty/resolver/dns/macos/MacOSDnsServerAddressStreamProvider:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   8: getstatic 33	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   11: ldc2_w 34
    //   14: invokevirtual 39	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   17: putstatic 41	io/netty/resolver/dns/macos/MacOSDnsServerAddressStreamProvider:REFRESH_INTERVAL	J
    //   20: invokestatic 44	io/netty/resolver/dns/macos/MacOSDnsServerAddressStreamProvider:loadNativeLibrary	()V
    //   23: aconst_null
    //   24: astore_0
    //   25: goto +4 -> 29
    //   28: astore_0
    //   29: aload_0
    //   30: putstatic 46	io/netty/resolver/dns/macos/MacOSDnsServerAddressStreamProvider:UNAVAILABILITY_CAUSE	Ljava/lang/Throwable;
    //   33: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	1	0	localObject	Object
    //   28	2	0	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   20	23	28	finally
  }
  
  public MacOSDnsServerAddressStreamProvider()
  {
    ensureAvailability();
  }
  
  public static void ensureAvailability()
  {
    Throwable localThrowable = UNAVAILABILITY_CAUSE;
    if (localThrowable == null) {
      return;
    }
    throw ((Error)new UnsatisfiedLinkError("failed to load the required native library").initCause(localThrowable));
  }
  
  public static boolean isAvailable()
  {
    boolean bool;
    if (UNAVAILABILITY_CAUSE == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static void loadNativeLibrary()
  {
    if (SystemPropertyUtil.get("os.name").toLowerCase(Locale.UK).trim().startsWith("mac"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("netty_resolver_dns_native_macos");
      localStringBuilder.append('_');
      localStringBuilder.append(PlatformDependent.normalizedArch());
      String str = localStringBuilder.toString();
      ClassLoader localClassLoader = PlatformDependent.getClassLoader(MacOSDnsServerAddressStreamProvider.class);
      try
      {
        NativeLibraryLoader.load(str, localClassLoader);
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {}
      try
      {
        NativeLibraryLoader.load("netty_resolver_dns_native_macos", localClassLoader);
        logger.debug("Failed to load {}", str, localUnsatisfiedLinkError1);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        ThrowableUtil.addSuppressed(localUnsatisfiedLinkError1, localUnsatisfiedLinkError2);
        throw localUnsatisfiedLinkError1;
      }
    }
    throw new IllegalStateException("Only supported on MacOS");
  }
  
  private static native DnsResolver[] resolvers();
  
  private static Map<String, DnsServerAddresses> retrieveCurrentMappings()
  {
    DnsResolver[] arrayOfDnsResolver = resolvers();
    if ((arrayOfDnsResolver != null) && (arrayOfDnsResolver.length != 0))
    {
      HashMap localHashMap = new HashMap(arrayOfDnsResolver.length);
      int i = arrayOfDnsResolver.length;
      for (int j = 0; j < i; j++)
      {
        DnsResolver localDnsResolver = arrayOfDnsResolver[j];
        if (!"mdns".equalsIgnoreCase(localDnsResolver.options()))
        {
          Object localObject = localDnsResolver.nameservers();
          if ((localObject != null) && (localObject.length != 0))
          {
            String str = localDnsResolver.domain();
            localObject = str;
            if (str == null) {
              localObject = "";
            }
            InetSocketAddress[] arrayOfInetSocketAddress = localDnsResolver.nameservers();
            for (int k = 0; k < arrayOfInetSocketAddress.length; k++)
            {
              str = arrayOfInetSocketAddress[k];
              if (str.getPort() == 0)
              {
                int m = localDnsResolver.port();
                int n = m;
                if (m == 0) {
                  n = 53;
                }
                arrayOfInetSocketAddress[k] = new InetSocketAddress(str.getAddress(), n);
              }
            }
            localHashMap.put(localObject, DnsServerAddresses.sequential(arrayOfInetSocketAddress));
          }
        }
      }
      return localHashMap;
    }
    return Collections.emptyMap();
  }
  
  public static Throwable unavailabilityCause()
  {
    return UNAVAILABILITY_CAUSE;
  }
  
  public DnsServerAddressStream nameServerAddressStream(String paramString)
  {
    long l = this.lastRefresh.get();
    Object localObject1 = this.currentMappings;
    Object localObject2 = localObject1;
    if (System.nanoTime() - l > REFRESH_INTERVAL)
    {
      localObject2 = localObject1;
      if (this.lastRefresh.compareAndSet(l, System.nanoTime()))
      {
        localObject2 = retrieveCurrentMappings();
        this.currentMappings = ((Map)localObject2);
      }
    }
    int i;
    for (localObject1 = paramString;; localObject1 = ((String)localObject1).substring(i + 1))
    {
      i = ((String)localObject1).indexOf('.', 1);
      if ((i < 0) || (i == ((String)localObject1).length() - 1)) {
        break;
      }
      DnsServerAddresses localDnsServerAddresses = (DnsServerAddresses)((Map)localObject2).get(localObject1);
      if (localDnsServerAddresses != null) {
        return localDnsServerAddresses.stream();
      }
    }
    localObject2 = (DnsServerAddresses)((Map)localObject2).get("");
    if (localObject2 != null) {
      return ((DnsServerAddresses)localObject2).stream();
    }
    return DnsServerAddressStreamProviders.unixDefault().nameServerAddressStream(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\macos\MacOSDnsServerAddressStreamProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */