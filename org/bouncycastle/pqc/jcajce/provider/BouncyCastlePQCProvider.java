package org.bouncycastle.pqc.jcajce.provider;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x509.w;

public class BouncyCastlePQCProvider
  extends Provider
  implements org.bouncycastle.jcajce.provider.config.a
{
  private static final String[] ALGORITHMS = { "Rainbow", "McEliece", "SPHINCS", "NH", "XMSS" };
  private static final String ALGORITHM_PACKAGE = "org.bouncycastle.pqc.jcajce.provider.";
  public static final org.bouncycastle.jcajce.provider.config.b CONFIGURATION;
  public static String PROVIDER_NAME = "BCPQC";
  private static String info = "BouncyCastle Post-Quantum Security Provider v1.60";
  private static final Map keyInfoConverters = new HashMap();
  
  public BouncyCastlePQCProvider()
  {
    super(PROVIDER_NAME, 1.6D, info);
    AccessController.doPrivileged(new a());
  }
  
  private static org.bouncycastle.jcajce.provider.util.b getAsymmetricKeyInfoConverter(m paramm)
  {
    synchronized (keyInfoConverters)
    {
      paramm = (org.bouncycastle.jcajce.provider.util.b)???.get(paramm);
      return paramm;
    }
  }
  
  public static PrivateKey getPrivateKey(h paramh)
    throws IOException
  {
    org.bouncycastle.jcajce.provider.util.b localb = getAsymmetricKeyInfoConverter(paramh.h().f());
    if (localb == null) {
      return null;
    }
    return localb.a(paramh);
  }
  
  public static PublicKey getPublicKey(w paramw)
    throws IOException
  {
    org.bouncycastle.jcajce.provider.util.b localb = getAsymmetricKeyInfoConverter(paramw.f().f());
    if (localb == null) {
      return null;
    }
    return localb.b(paramw);
  }
  
  private void loadAlgorithms(String paramString, String[] paramArrayOfString)
  {
    for (int i = 0; i != paramArrayOfString.length; i++)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramArrayOfString[i]);
      ((StringBuilder)localObject).append("$Mappings");
      localObject = loadClass(BouncyCastlePQCProvider.class, ((StringBuilder)localObject).toString());
      if (localObject != null) {
        try
        {
          ((org.bouncycastle.jcajce.provider.util.a)((Class)localObject).newInstance()).a(this);
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cannot create instance of ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(paramArrayOfString[i]);
          ((StringBuilder)localObject).append("$Mappings : ");
          ((StringBuilder)localObject).append(localException);
          throw new InternalError(((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  static Class loadClass(Class paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getClassLoader();
      if (paramClass != null) {
        return paramClass.loadClass(paramString);
      }
      paramClass = new org/bouncycastle/pqc/jcajce/provider/BouncyCastlePQCProvider$b;
      paramClass.<init>(paramString);
      paramClass = (Class)AccessController.doPrivileged(paramClass);
      return paramClass;
    }
    catch (ClassNotFoundException paramClass) {}
    return null;
  }
  
  private void setup()
  {
    loadAlgorithms("org.bouncycastle.pqc.jcajce.provider.", ALGORITHMS);
  }
  
  public void addAlgorithm(String paramString1, String paramString2)
  {
    if (!containsKey(paramString1))
    {
      put(paramString1, paramString2);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("duplicate provider key (");
    paramString2.append(paramString1);
    paramString2.append(") found");
    throw new IllegalStateException(paramString2.toString());
  }
  
  public void addAlgorithm(String paramString1, m paramm, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    if (containsKey(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".");
      localStringBuilder.append(paramm);
      addAlgorithm(localStringBuilder.toString(), paramString2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".OID.");
      localStringBuilder.append(paramm);
      addAlgorithm(localStringBuilder.toString(), paramString2);
      return;
    }
    paramm = new StringBuilder();
    paramm.append("primary key (");
    paramm.append(paramString1);
    paramm.append(".");
    paramm.append(paramString2);
    paramm.append(") not found");
    throw new IllegalStateException(paramm.toString());
  }
  
  public void addAttributes(String paramString, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      if (!containsKey(localObject))
      {
        put(localObject, paramMap.get(str));
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("duplicate provider attribute key (");
        paramString.append((String)localObject);
        paramString.append(") found");
        throw new IllegalStateException(paramString.toString());
      }
    }
  }
  
  public void addKeyInfoConverter(m paramm, org.bouncycastle.jcajce.provider.util.b paramb)
  {
    synchronized (keyInfoConverters)
    {
      ???.put(paramm, paramb);
      return;
    }
  }
  
  public boolean hasAlgorithm(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    if (!containsKey(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (!containsKey(localStringBuilder.toString()))
      {
        bool = false;
        break label95;
      }
    }
    boolean bool = true;
    label95:
    return bool;
  }
  
  public void setParameter(String arg1, Object paramObject)
  {
    synchronized (CONFIGURATION) {}
  }
  
  class a
    implements PrivilegedAction
  {
    a() {}
    
    public Object run()
    {
      BouncyCastlePQCProvider.this.setup();
      return null;
    }
  }
  
  static final class b
    implements PrivilegedAction
  {
    b(String paramString) {}
    
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\BouncyCastlePQCProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */