package e.a.c.a;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.util.a;

public class l
  extends org.bouncycastle.asn1.l
{
  private final int c;
  private final byte[] d;
  private final byte[] f;
  private final byte[] q;
  private final byte[] x;
  private final byte[] y;
  
  public l(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    this.c = paramInt;
    this.d = a.g(paramArrayOfByte1);
    this.f = a.g(paramArrayOfByte2);
    this.q = a.g(paramArrayOfByte3);
    this.x = a.g(paramArrayOfByte4);
    this.y = a.g(paramArrayOfByte5);
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */