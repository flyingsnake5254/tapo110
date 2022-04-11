package e.a.c.a;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.util.a;

public class m
  extends l
{
  private final int c;
  private final byte[] d;
  private final byte[] f;
  private final byte[] q;
  private final byte[] x;
  private final byte[] y;
  
  public m(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    this.c = paramInt;
    this.d = a.g(paramArrayOfByte1);
    this.f = a.g(paramArrayOfByte2);
    this.q = a.g(paramArrayOfByte3);
    this.x = a.g(paramArrayOfByte4);
    this.y = a.g(paramArrayOfByte5);
  }
  
  private m(r paramr)
  {
    if (j.m(paramr.p(0)).p().equals(BigInteger.valueOf(0L)))
    {
      if ((paramr.size() != 2) && (paramr.size() != 3)) {
        throw new IllegalArgumentException("key sequence wrong size");
      }
      r localr = r.m(paramr.p(1));
      this.c = j.m(localr.p(0)).p().intValue();
      this.d = a.g(n.m(localr.p(1)).o());
      this.f = a.g(n.m(localr.p(2)).o());
      this.q = a.g(n.m(localr.p(3)).o());
      this.x = a.g(n.m(localr.p(4)).o());
      if (paramr.size() == 3) {
        this.y = a.g(n.n(x.m(paramr.p(2)), true).o());
      } else {
        this.y = null;
      }
      return;
    }
    throw new IllegalArgumentException("unknown version of sequence");
  }
  
  public static m h(Object paramObject)
  {
    if ((paramObject instanceof m)) {
      return (m)paramObject;
    }
    if (paramObject != null) {
      return new m(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf1 = new f();
    localf1.a(new j(0L));
    f localf2 = new f();
    localf2.a(new j(this.c));
    localf2.a(new x0(this.d));
    localf2.a(new x0(this.f));
    localf2.a(new x0(this.q));
    localf2.a(new x0(this.x));
    localf1.a(new b1(localf2));
    localf1.a(new g1(true, 0, new x0(this.y)));
    return new b1(localf1);
  }
  
  public byte[] f()
  {
    return a.g(this.y);
  }
  
  public int g()
  {
    return this.c;
  }
  
  public byte[] i()
  {
    return a.g(this.q);
  }
  
  public byte[] j()
  {
    return a.g(this.x);
  }
  
  public byte[] k()
  {
    return a.g(this.f);
  }
  
  public byte[] l()
  {
    return a.g(this.d);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */