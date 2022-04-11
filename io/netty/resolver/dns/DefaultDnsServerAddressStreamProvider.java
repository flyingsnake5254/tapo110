package io.netty.resolver.dns;

import io.netty.util.NetUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DefaultDnsServerAddressStreamProvider
  implements DnsServerAddressStreamProvider
{
  private static final DnsServerAddresses DEFAULT_NAME_SERVERS;
  private static final List<InetSocketAddress> DEFAULT_NAME_SERVER_LIST;
  static final int DNS_PORT = 53;
  public static final DefaultDnsServerAddressStreamProvider INSTANCE;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultDnsServerAddressStreamProvider.class);
  
  static
  {
    INSTANCE = new DefaultDnsServerAddressStreamProvider();
    Object localObject1 = new ArrayList(2);
    if (!PlatformDependent.isAndroid()) {
      DirContextUtils.addNameServers((List)localObject1, 53);
    }
    if ((PlatformDependent.javaVersion() < 9) && (((List)localObject1).isEmpty())) {
      try
      {
        Object localObject2 = Class.forName("sun.net.dns.ResolverConfiguration");
        Object localObject3 = ((Class)localObject2).getMethod("open", new Class[0]);
        Iterator localIterator = ((List)((Class)localObject2).getMethod("nameservers", new Class[0]).invoke(((Method)localObject3).invoke(null, new Object[0]), new Object[0])).iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          if (localObject2 != null)
          {
            localObject3 = new java/net/InetSocketAddress;
            ((InetSocketAddress)localObject3).<init>(SocketUtils.addressByName((String)localObject2), 53);
            ((List)localObject1).add(localObject3);
          }
        }
        if (((List)localObject1).isEmpty()) {
          break label191;
        }
      }
      catch (Exception localException) {}
    }
    InternalLogger localInternalLogger = logger;
    if (localInternalLogger.isDebugEnabled())
    {
      localInternalLogger.debug("Default DNS servers: {} (sun.net.dns.ResolverConfiguration)", localObject1);
      break label298;
      label191:
      if ((!NetUtil.isIpV6AddressesPreferred()) && ((!(NetUtil.LOCALHOST instanceof Inet6Address)) || (NetUtil.isIpV4StackPreferred()))) {
        Collections.addAll((Collection)localObject1, new InetSocketAddress[] { SocketUtils.socketAddress("8.8.8.8", 53), SocketUtils.socketAddress("8.8.4.4", 53) });
      } else {
        Collections.addAll((Collection)localObject1, new InetSocketAddress[] { SocketUtils.socketAddress("2001:4860:4860::8888", 53), SocketUtils.socketAddress("2001:4860:4860::8844", 53) });
      }
      localInternalLogger = logger;
      if (localInternalLogger.isWarnEnabled()) {
        localInternalLogger.warn("Default DNS servers: {} (Google Public DNS as a fallback)", localObject1);
      }
    }
    label298:
    localObject1 = Collections.unmodifiableList((List)localObject1);
    DEFAULT_NAME_SERVER_LIST = (List)localObject1;
    DEFAULT_NAME_SERVERS = DnsServerAddresses.sequential((Iterable)localObject1);
  }
  
  public static List<InetSocketAddress> defaultAddressList()
  {
    return DEFAULT_NAME_SERVER_LIST;
  }
  
  public static DnsServerAddresses defaultAddresses()
  {
    return DEFAULT_NAME_SERVERS;
  }
  
  public DnsServerAddressStream nameServerAddressStream(String paramString)
  {
    return DEFAULT_NAME_SERVERS.stream();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DefaultDnsServerAddressStreamProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */