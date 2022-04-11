package e.a.c.a;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;

public class f
  extends l
{
  private static final BigInteger c = BigInteger.valueOf(0L);
  private int d;
  private int[] f;
  private int[] q;
  private int[] x;
  
  public q c()
  {
    org.bouncycastle.asn1.f localf1 = new org.bouncycastle.asn1.f();
    org.bouncycastle.asn1.f localf2 = new org.bouncycastle.asn1.f();
    org.bouncycastle.asn1.f localf3 = new org.bouncycastle.asn1.f();
    for (int i = 0;; i++)
    {
      localObject = this.f;
      if (i >= localObject.length) {
        break;
      }
      localf1.a(new j(localObject[i]));
      localf2.a(new j(this.q[i]));
      localf3.a(new j(this.x[i]));
    }
    Object localObject = new org.bouncycastle.asn1.f();
    ((org.bouncycastle.asn1.f)localObject).a(new j(this.d));
    ((org.bouncycastle.asn1.f)localObject).a(new b1(localf1));
    ((org.bouncycastle.asn1.f)localObject).a(new b1(localf2));
    ((org.bouncycastle.asn1.f)localObject).a(new b1(localf3));
    return new b1((org.bouncycastle.asn1.f)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */