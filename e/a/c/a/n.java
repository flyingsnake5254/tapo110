package e.a.c.a;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.util.a;

public class n
  extends l
{
  private final byte[] c;
  private final byte[] d;
  
  private n(r paramr)
  {
    if (j.m(paramr.p(0)).p().equals(BigInteger.valueOf(0L)))
    {
      this.c = a.g(org.bouncycastle.asn1.n.m(paramr.p(1)).o());
      this.d = a.g(org.bouncycastle.asn1.n.m(paramr.p(2)).o());
      return;
    }
    throw new IllegalArgumentException("unknown version of sequence");
  }
  
  public n(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.c = a.g(paramArrayOfByte1);
    this.d = a.g(paramArrayOfByte2);
  }
  
  public static n f(Object paramObject)
  {
    if ((paramObject instanceof n)) {
      return (n)paramObject;
    }
    if (paramObject != null) {
      return new n(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(new j(0L));
    localf.a(new x0(this.c));
    localf.a(new x0(this.d));
    return new b1(localf);
  }
  
  public byte[] g()
  {
    return a.g(this.c);
  }
  
  public byte[] h()
  {
    return a.g(this.d);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */