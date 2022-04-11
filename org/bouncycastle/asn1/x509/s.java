package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b;
import org.bouncycastle.asn1.c;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;
import org.bouncycastle.util.i;

public class s
  extends l
{
  private k c;
  private boolean d;
  private boolean f;
  private v q;
  private boolean x;
  private boolean y;
  private r z;
  
  private s(r paramr)
  {
    this.z = paramr;
    for (int i = 0; i != paramr.size(); i++)
    {
      x localx = x.m(paramr.p(i));
      int j = localx.p();
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j == 5) {
                  this.y = c.o(localx, false).q();
                } else {
                  throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
                }
              }
              else {
                this.x = c.o(localx, false).q();
              }
            }
            else {
              this.q = new v(n0.t(localx, false));
            }
          }
          else {
            this.f = c.o(localx, false).q();
          }
        }
        else {
          this.d = c.o(localx, false).q();
        }
      }
      else {
        this.c = k.h(localx, true);
      }
    }
  }
  
  private void f(StringBuffer paramStringBuffer, String paramString1, String paramString2, String paramString3)
  {
    paramStringBuffer.append("    ");
    paramStringBuffer.append(paramString2);
    paramStringBuffer.append(":");
    paramStringBuffer.append(paramString1);
    paramStringBuffer.append("    ");
    paramStringBuffer.append("    ");
    paramStringBuffer.append(paramString3);
    paramStringBuffer.append(paramString1);
  }
  
  private String g(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    return str;
  }
  
  public static s h(Object paramObject)
  {
    if ((paramObject instanceof s)) {
      return (s)paramObject;
    }
    if (paramObject != null) {
      return new s(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    return this.z;
  }
  
  public boolean i()
  {
    return this.x;
  }
  
  public String toString()
  {
    String str = i.d();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("IssuingDistributionPoint: [");
    localStringBuffer.append(str);
    Object localObject = this.c;
    if (localObject != null) {
      f(localStringBuffer, str, "distributionPoint", ((k)localObject).toString());
    }
    boolean bool = this.d;
    if (bool) {
      f(localStringBuffer, str, "onlyContainsUserCerts", g(bool));
    }
    bool = this.f;
    if (bool) {
      f(localStringBuffer, str, "onlyContainsCACerts", g(bool));
    }
    localObject = this.q;
    if (localObject != null) {
      f(localStringBuffer, str, "onlySomeReasons", ((b)localObject).toString());
    }
    bool = this.y;
    if (bool) {
      f(localStringBuffer, str, "onlyContainsAttributeCerts", g(bool));
    }
    bool = this.x;
    if (bool) {
      f(localStringBuffer, str, "indirectCRL", g(bool));
    }
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */