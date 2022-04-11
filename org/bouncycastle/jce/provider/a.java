package org.bouncycastle.jce.provider;

import java.security.Permission;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.bouncycastle.jcajce.provider.config.b;
import org.bouncycastle.jce.spec.d;

class a
  implements b
{
  private static Permission a = new ProviderConfigurationPermission("BC", "threadLocalEcImplicitlyCa");
  private static Permission b = new ProviderConfigurationPermission("BC", "ecImplicitlyCa");
  private static Permission c = new ProviderConfigurationPermission("BC", "threadLocalDhDefaultParams");
  private static Permission d = new ProviderConfigurationPermission("BC", "DhDefaultParams");
  private static Permission e = new ProviderConfigurationPermission("BC", "acceptableEcCurves");
  private static Permission f = new ProviderConfigurationPermission("BC", "additionalEcParameters");
  private ThreadLocal g = new ThreadLocal();
  private ThreadLocal h = new ThreadLocal();
  private volatile d i;
  private volatile Object j;
  private volatile Set k = new HashSet();
  private volatile Map l = new HashMap();
  
  public Map a()
  {
    return Collections.unmodifiableMap(this.l);
  }
  
  public d b()
  {
    d locald = (d)this.g.get();
    if (locald != null) {
      return locald;
    }
    return this.i;
  }
  
  public Set c()
  {
    return Collections.unmodifiableSet(this.k);
  }
  
  void d(String paramString, Object paramObject)
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (paramString.equals("threadLocalEcImplicitlyCa"))
    {
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(a);
      }
      if ((!(paramObject instanceof d)) && (paramObject != null)) {
        paramString = org.bouncycastle.jcajce.provider.asymmetric.util.a.h((ECParameterSpec)paramObject, false);
      } else {
        paramString = (d)paramObject;
      }
      if (paramString == null) {
        paramString = this.g;
      }
    }
    do
    {
      paramString.remove();
      return;
      this.g.set(paramString);
      return;
      if (paramString.equals("ecImplicitlyCa"))
      {
        if (localSecurityManager != null) {
          localSecurityManager.checkPermission(b);
        }
        if ((!(paramObject instanceof d)) && (paramObject != null))
        {
          this.i = org.bouncycastle.jcajce.provider.asymmetric.util.a.h((ECParameterSpec)paramObject, false);
          return;
        }
        this.i = ((d)paramObject);
        return;
      }
      if (!paramString.equals("threadLocalDhDefaultParams")) {
        break;
      }
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(c);
      }
      if ((!(paramObject instanceof DHParameterSpec)) && (!(paramObject instanceof DHParameterSpec[])) && (paramObject != null)) {
        throw new IllegalArgumentException("not a valid DHParameterSpec");
      }
      paramString = this.h;
    } while (paramObject == null);
    paramString.set(paramObject);
    return;
    if (paramString.equals("DhDefaultParams"))
    {
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(d);
      }
      if ((!(paramObject instanceof DHParameterSpec)) && (!(paramObject instanceof DHParameterSpec[])) && (paramObject != null)) {
        throw new IllegalArgumentException("not a valid DHParameterSpec or DHParameterSpec[]");
      }
      this.j = paramObject;
    }
    else if (paramString.equals("acceptableEcCurves"))
    {
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(e);
      }
      this.k = ((Set)paramObject);
    }
    else if (paramString.equals("additionalEcParameters"))
    {
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(f);
      }
      this.l = ((Map)paramObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */