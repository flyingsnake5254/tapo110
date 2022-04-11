package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.d;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.t;
import org.bouncycastle.asn1.x;
import org.bouncycastle.util.i;

public class k
  extends l
  implements d
{
  e c;
  int d;
  
  public k(x paramx)
  {
    int i = paramx.p();
    this.d = i;
    if (i == 0) {
      paramx = p.g(paramx, false);
    } else {
      paramx = t.o(paramx, false);
    }
    this.c = paramx;
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
  
  public static k g(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof k)))
    {
      if ((paramObject instanceof x)) {
        return new k((x)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (k)paramObject;
  }
  
  public static k h(x paramx, boolean paramBoolean)
  {
    return g(x.n(paramx, true));
  }
  
  public q c()
  {
    return new g1(false, this.d, this.c);
  }
  
  public String toString()
  {
    String str1 = i.d();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("DistributionPointName: [");
    localStringBuffer.append(str1);
    String str2;
    String str3;
    if (this.d == 0)
    {
      str2 = this.c.toString();
      str3 = "fullName";
    }
    else
    {
      str2 = this.c.toString();
      str3 = "nameRelativeToCRLIssuer";
    }
    f(localStringBuffer, str1, str3, str2);
    localStringBuffer.append("]");
    localStringBuffer.append(str1);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */