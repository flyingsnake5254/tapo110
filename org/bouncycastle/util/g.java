package org.bouncycastle.util;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;

public class g
{
  private static final ThreadLocal a = new ThreadLocal();
  
  private static String b(String paramString)
  {
    return (String)AccessController.doPrivileged(new a(paramString));
  }
  
  public static boolean c(String paramString)
  {
    try
    {
      paramString = b(paramString);
      if (paramString != null)
      {
        boolean bool = "true".equals(i.f(paramString));
        return bool;
      }
    }
    catch (AccessControlException paramString)
    {
      for (;;) {}
    }
    return false;
  }
  
  static final class a
    implements PrivilegedAction
  {
    a(String paramString) {}
    
    public Object run()
    {
      Map localMap = (Map)g.a().get();
      if (localMap != null) {
        return localMap.get(this.a);
      }
      return System.getProperty(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */