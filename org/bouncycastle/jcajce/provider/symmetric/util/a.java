package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class a
{
  public static Class a(Class paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getClassLoader();
      if (paramClass != null) {
        return paramClass.loadClass(paramString);
      }
      paramClass = new org/bouncycastle/jcajce/provider/symmetric/util/a$a;
      paramClass.<init>(paramString);
      paramClass = (Class)AccessController.doPrivileged(paramClass);
      return paramClass;
    }
    catch (ClassNotFoundException paramClass) {}
    return null;
  }
  
  static final class a
    implements PrivilegedAction
  {
    a(String paramString) {}
    
    public Object run()
    {
      try
      {
        Class localClass = Class.forName(this.a);
        return localClass;
      }
      catch (Exception localException) {}
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\symmetric\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */