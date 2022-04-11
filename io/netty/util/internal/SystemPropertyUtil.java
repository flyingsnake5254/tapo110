package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class SystemPropertyUtil
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(SystemPropertyUtil.class);
  
  public static boolean contains(String paramString)
  {
    boolean bool;
    if (get(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static String get(String paramString)
  {
    return get(paramString, null);
  }
  
  public static String get(String paramString1, String paramString2)
  {
    ObjectUtil.checkNotNull(paramString1, "key");
    if (!paramString1.isEmpty())
    {
      Object localObject1 = null;
      try
      {
        Object localObject2;
        if (System.getSecurityManager() == null)
        {
          localObject2 = System.getProperty(paramString1);
          paramString1 = (String)localObject2;
        }
        else
        {
          localObject2 = new io/netty/util/internal/SystemPropertyUtil$1;
          ((1)localObject2).<init>(paramString1);
          localObject2 = (String)AccessController.doPrivileged((PrivilegedAction)localObject2);
          paramString1 = (String)localObject2;
        }
      }
      catch (SecurityException localSecurityException)
      {
        logger.warn("Unable to retrieve a system property '{}'; default values will be used.", paramString1, localSecurityException);
        paramString1 = (String)localObject1;
      }
      if (paramString1 == null) {
        return paramString2;
      }
      return paramString1;
    }
    throw new IllegalArgumentException("key must not be empty.");
  }
  
  public static boolean getBoolean(String paramString, boolean paramBoolean)
  {
    String str = get(paramString);
    if (str == null) {
      return paramBoolean;
    }
    str = str.trim().toLowerCase();
    if (str.isEmpty()) {
      return paramBoolean;
    }
    if ((!"true".equals(str)) && (!"yes".equals(str)) && (!"1".equals(str)))
    {
      if ((!"false".equals(str)) && (!"no".equals(str)) && (!"0".equals(str)))
      {
        logger.warn("Unable to parse the boolean system property '{}':{} - using the default value: {}", new Object[] { paramString, str, Boolean.valueOf(paramBoolean) });
        return paramBoolean;
      }
      return false;
    }
    return true;
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    String str1 = get(paramString);
    if (str1 == null) {
      return paramInt;
    }
    String str2 = str1.trim();
    try
    {
      int i = Integer.parseInt(str2);
      return i;
    }
    catch (Exception localException)
    {
      logger.warn("Unable to parse the integer system property '{}':{} - using the default value: {}", new Object[] { paramString, str2, Integer.valueOf(paramInt) });
    }
    return paramInt;
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    String str = get(paramString);
    if (str == null) {
      return paramLong;
    }
    str = str.trim();
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      logger.warn("Unable to parse the long integer system property '{}':{} - using the default value: {}", new Object[] { paramString, str, Long.valueOf(paramLong) });
    }
    return paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\SystemPropertyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */