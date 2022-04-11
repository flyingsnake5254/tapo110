package io.netty.resolver.dns;

import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.List;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

final class DirContextUtils
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DirContextUtils.class);
  
  static void addNameServers(List<InetSocketAddress> paramList, int paramInt)
  {
    Object localObject1 = new Hashtable();
    ((Hashtable)localObject1).put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
    ((Hashtable)localObject1).put("java.naming.provider.url", "dns://");
    try
    {
      InitialDirContext localInitialDirContext = new javax/naming/directory/InitialDirContext;
      localInitialDirContext.<init>((Hashtable)localObject1);
      localObject1 = (String)localInitialDirContext.getEnvironment().get("java.naming.provider.url");
      if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
        for (localInitialDirContext : ((String)localObject1).split(" ")) {
          try
          {
            Object localObject2 = new java/net/URI;
            ((URI)localObject2).<init>(localInitialDirContext);
            Object localObject3 = new java/net/URI;
            ((URI)localObject3).<init>(localInitialDirContext);
            localObject3 = ((URI)localObject3).getHost();
            if ((localObject3 != null) && (!((String)localObject3).isEmpty()))
            {
              int k = ((URI)localObject2).getPort();
              localObject2 = ((URI)localObject2).getHost();
              int m = k;
              if (k == -1) {
                m = paramInt;
              }
              paramList.add(SocketUtils.socketAddress((String)localObject2, m));
            }
            else
            {
              logger.debug("Skipping a nameserver URI as host portion could not be extracted: {}", localInitialDirContext);
            }
          }
          catch (URISyntaxException localURISyntaxException)
          {
            logger.debug("Skipping a malformed nameserver URI: {}", localInitialDirContext, localURISyntaxException);
          }
        }
      }
      return;
    }
    catch (NamingException paramList)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DirContextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */