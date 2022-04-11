package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.d2.c;
import org.bouncycastle.asn1.d2.d;
import org.bouncycastle.asn1.d2.e;

public class k
  implements AlgorithmParameterSpec, org.bouncycastle.jce.interfaces.a
{
  private m a;
  private String b;
  private String c;
  private String d;
  
  public k(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    Object localObject2;
    try
    {
      Object localObject1 = new org/bouncycastle/asn1/m;
      ((org.bouncycastle.asn1.m)localObject1).<init>(paramString1);
      localObject1 = c.a((org.bouncycastle.asn1.m)localObject1);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localObject2 = c.b(paramString1);
      if (localObject2 != null)
      {
        paramString1 = ((org.bouncycastle.asn1.m)localObject2).q();
        localObject2 = c.a((org.bouncycastle.asn1.m)localObject2);
      }
      else
      {
        localObject2 = null;
      }
    }
    if (localObject2 != null)
    {
      this.a = new m(((d)localObject2).g(), ((d)localObject2).h(), ((d)localObject2).f());
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramString3;
      return;
    }
    throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
  }
  
  public k(m paramm)
  {
    this.a = paramm;
    this.c = org.bouncycastle.asn1.d2.a.p.q();
    this.d = null;
  }
  
  public static k e(e parame)
  {
    if (parame.g() != null) {
      return new k(parame.i().q(), parame.f().q(), parame.g().q());
    }
    return new k(parame.i().q(), parame.f().q());
  }
  
  public m a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof k;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      Object localObject = (k)paramObject;
      bool3 = bool2;
      if (this.a.equals(((k)localObject).a))
      {
        bool3 = bool2;
        if (this.c.equals(((k)localObject).c))
        {
          paramObject = this.d;
          localObject = ((k)localObject).d;
          if (paramObject != localObject)
          {
            bool3 = bool2;
            if (paramObject != null)
            {
              bool3 = bool2;
              if (!((String)paramObject).equals(localObject)) {}
            }
          }
          else
          {
            bool3 = true;
          }
        }
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    int i = this.a.hashCode();
    int j = this.c.hashCode();
    String str = this.d;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    return i ^ j ^ k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\spec\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */