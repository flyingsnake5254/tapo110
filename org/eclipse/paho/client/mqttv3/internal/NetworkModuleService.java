package org.eclipse.paho.client.mqttv3.internal;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;
import org.eclipse.paho.client.mqttv3.spi.NetworkModuleFactory;

public class NetworkModuleService
{
  private static final Pattern AUTHORITY_PATTERN = Pattern.compile("((.+)@)?([^:]*)(:(\\d+))?");
  private static final int AUTH_GROUP_HOST = 3;
  private static final int AUTH_GROUP_PORT = 5;
  private static final int AUTH_GROUP_USERINFO = 2;
  private static final ServiceLoader<NetworkModuleFactory> FACTORY_SERVICE_LOADER;
  private static Logger LOG = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", NetworkModuleService.class.getSimpleName());
  
  static
  {
    FACTORY_SERVICE_LOADER = ServiceLoader.load(NetworkModuleFactory.class, NetworkModuleService.class.getClassLoader());
  }
  
  public static void applyRFC3986AuthorityPatch(URI paramURI)
  {
    if ((paramURI != null) && (paramURI.getHost() == null) && (paramURI.getAuthority() != null) && (!paramURI.getAuthority().isEmpty()))
    {
      Object localObject = AUTHORITY_PATTERN.matcher(paramURI.getAuthority());
      if (((Matcher)localObject).find())
      {
        setURIField(paramURI, "userInfo", ((Matcher)localObject).group(2));
        setURIField(paramURI, "host", ((Matcher)localObject).group(3));
        localObject = ((Matcher)localObject).group(5);
        int i;
        if (localObject != null) {
          i = Integer.parseInt((String)localObject);
        } else {
          i = -1;
        }
        setURIField(paramURI, "port", Integer.valueOf(i));
      }
    }
  }
  
  /* Error */
  public static NetworkModule createInstance(String paramString1, org.eclipse.paho.client.mqttv3.MqttConnectOptions paramMqttConnectOptions, String paramString2)
    throws org.eclipse.paho.client.mqttv3.MqttException, IllegalArgumentException
  {
    // Byte code:
    //   0: new 68	java/net/URI
    //   3: astore_3
    //   4: aload_3
    //   5: aload_0
    //   6: invokespecial 124	java/net/URI:<init>	(Ljava/lang/String;)V
    //   9: aload_3
    //   10: invokestatic 126	org/eclipse/paho/client/mqttv3/internal/NetworkModuleService:applyRFC3986AuthorityPatch	(Ljava/net/URI;)V
    //   13: aload_3
    //   14: invokevirtual 129	java/net/URI:getScheme	()Ljava/lang/String;
    //   17: invokevirtual 132	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   20: astore 4
    //   22: getstatic 50	org/eclipse/paho/client/mqttv3/internal/NetworkModuleService:FACTORY_SERVICE_LOADER	Ljava/util/ServiceLoader;
    //   25: astore 5
    //   27: aload 5
    //   29: monitorenter
    //   30: aload 5
    //   32: invokevirtual 136	java/util/ServiceLoader:iterator	()Ljava/util/Iterator;
    //   35: astore 6
    //   37: aload 6
    //   39: invokeinterface 141 1 0
    //   44: ifeq +48 -> 92
    //   47: aload 6
    //   49: invokeinterface 145 1 0
    //   54: checkcast 38	org/eclipse/paho/client/mqttv3/spi/NetworkModuleFactory
    //   57: astore 7
    //   59: aload 7
    //   61: invokeinterface 149 1 0
    //   66: aload 4
    //   68: invokeinterface 155 2 0
    //   73: ifeq -36 -> 37
    //   76: aload 7
    //   78: aload_3
    //   79: aload_1
    //   80: aload_2
    //   81: invokeinterface 159 4 0
    //   86: astore_1
    //   87: aload 5
    //   89: monitorexit
    //   90: aload_1
    //   91: areturn
    //   92: aload 5
    //   94: monitorexit
    //   95: new 119	java/lang/IllegalArgumentException
    //   98: astore_1
    //   99: aload_1
    //   100: aload_3
    //   101: invokevirtual 162	java/net/URI:toString	()Ljava/lang/String;
    //   104: invokespecial 163	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload 5
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: new 119	java/lang/IllegalArgumentException
    //   119: dup
    //   120: aload_0
    //   121: aload_1
    //   122: invokespecial 166	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramString1	String
    //   0	126	1	paramMqttConnectOptions	org.eclipse.paho.client.mqttv3.MqttConnectOptions
    //   0	126	2	paramString2	String
    //   3	98	3	localURI	URI
    //   20	47	4	str	String
    //   35	13	6	localIterator	Iterator
    //   57	20	7	localNetworkModuleFactory	NetworkModuleFactory
    // Exception table:
    //   from	to	target	type
    //   30	37	109	finally
    //   37	90	109	finally
    //   92	95	109	finally
    //   110	113	109	finally
    //   0	30	115	java/net/URISyntaxException
    //   95	109	115	java/net/URISyntaxException
    //   113	115	115	java/net/URISyntaxException
  }
  
  private static void setURIField(URI paramURI, String paramString, Object paramObject)
  {
    try
    {
      paramString = URI.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString.set(paramURI, paramObject);
    }
    catch (IllegalAccessException paramString) {}catch (IllegalArgumentException paramString) {}catch (SecurityException paramString) {}catch (NoSuchFieldException paramString) {}
    LOG.warning(NetworkModuleService.class.getName(), "setURIField", "115", new Object[] { paramURI.toString() }, paramString);
  }
  
  public static void validateURI(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      Object localObject1 = new java/net/URI;
      ((URI)localObject1).<init>(paramString);
      String str = ((URI)localObject1).getScheme();
      if ((str != null) && (!str.isEmpty()))
      {
        str = str.toLowerCase();
        synchronized (FACTORY_SERVICE_LOADER)
        {
          Iterator localIterator = ((ServiceLoader)???).iterator();
          while (localIterator.hasNext())
          {
            NetworkModuleFactory localNetworkModuleFactory = (NetworkModuleFactory)localIterator.next();
            if (localNetworkModuleFactory.getSupportedUriSchemes().contains(str))
            {
              localNetworkModuleFactory.validateURI((URI)localObject1);
              return;
            }
          }
          localObject1 = new java/lang/IllegalArgumentException;
          ??? = new java/lang/StringBuilder;
          ((StringBuilder)???).<init>("no NetworkModule installed for scheme \"");
          ((StringBuilder)???).append(str);
          ((StringBuilder)???).append("\" of URI \"");
          ((StringBuilder)???).append(paramString);
          ((StringBuilder)???).append("\"");
          ((IllegalArgumentException)localObject1).<init>(((StringBuilder)???).toString());
          throw ((Throwable)localObject1);
        }
      }
      localObject3 = new java/lang/IllegalArgumentException;
      ??? = new java/lang/StringBuilder;
      ((StringBuilder)???).<init>("missing scheme in broker URI: ");
      ((StringBuilder)???).append(paramString);
      ((IllegalArgumentException)localObject3).<init>(((StringBuilder)???).toString());
      throw ((Throwable)localObject3);
    }
    catch (URISyntaxException localURISyntaxException)
    {
      Object localObject3 = new StringBuilder("Can't parse string to URI \"");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("\"");
      throw new IllegalArgumentException(((StringBuilder)localObject3).toString(), localURISyntaxException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\NetworkModuleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */