package e.a.c.a;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;

public class g
  extends l
{
  private j c;
  private m d;
  private byte[][] f;
  private e.a.c.b.d.a[] p0;
  private byte[] q;
  private byte[][] x;
  private byte[] y;
  private byte[] z;
  
  private g(r paramr)
  {
    if ((paramr.p(0) instanceof j)) {
      this.c = j.m(paramr.p(0));
    } else {
      this.d = m.r(paramr.p(0));
    }
    Object localObject1 = (r)paramr.p(1);
    this.f = new byte[((r)localObject1).size()][];
    for (int i = 0; i < ((r)localObject1).size(); i++) {
      this.f[i] = ((n)((r)localObject1).p(i)).o();
    }
    this.q = ((n)((r)paramr.p(2)).p(0)).o();
    localObject1 = (r)paramr.p(3);
    this.x = new byte[((r)localObject1).size()][];
    for (i = 0; i < ((r)localObject1).size(); i++) {
      this.x[i] = ((n)((r)localObject1).p(i)).o();
    }
    this.y = ((n)((r)paramr.p(4)).p(0)).o();
    this.z = ((n)((r)paramr.p(5)).p(0)).o();
    Object localObject2 = (r)paramr.p(6);
    paramr = new byte[((r)localObject2).size()][][][];
    byte[][][][] arrayOfByte = new byte[((r)localObject2).size()][][][];
    byte[][][] arrayOfByte1 = new byte[((r)localObject2).size()][][];
    localObject1 = new byte[((r)localObject2).size()][];
    int j;
    for (i = 0; i < ((r)localObject2).size(); i++)
    {
      r localr1 = (r)((r)localObject2).p(i);
      r localr2 = (r)localr1.p(0);
      paramr[i] = new byte[localr2.size()][][];
      for (j = 0; j < localr2.size(); j++)
      {
        localr3 = (r)localr2.p(j);
        paramr[i][j] = new byte[localr3.size()][];
        for (k = 0; k < localr3.size(); k++) {
          paramr[i][j][k] = ((n)localr3.p(k)).o();
        }
      }
      r localr3 = (r)localr1.p(1);
      arrayOfByte[i] = new byte[localr3.size()][][];
      for (j = 0; j < localr3.size(); j++)
      {
        localr2 = (r)localr3.p(j);
        arrayOfByte[i][j] = new byte[localr2.size()][];
        for (k = 0; k < localr2.size(); k++) {
          arrayOfByte[i][j][k] = ((n)localr2.p(k)).o();
        }
      }
      localr3 = (r)localr1.p(2);
      arrayOfByte1[i] = new byte[localr3.size()][];
      for (j = 0; j < localr3.size(); j++) {
        arrayOfByte1[i][j] = ((n)localr3.p(j)).o();
      }
      localObject1[i] = ((n)localr1.p(3)).o();
    }
    int k = this.z.length - 1;
    this.p0 = new e.a.c.b.d.a[k];
    for (i = 0; i < k; i = j)
    {
      localObject2 = this.z;
      byte b = localObject2[i];
      j = i + 1;
      localObject2 = new e.a.c.b.d.a(b, localObject2[j], e.a.c.b.d.f.a.f(paramr[i]), e.a.c.b.d.f.a.f(arrayOfByte[i]), e.a.c.b.d.f.a.d(arrayOfByte1[i]), e.a.c.b.d.f.a.b(localObject1[i]));
      this.p0[i] = localObject2;
    }
  }
  
  public g(short[][] paramArrayOfShort1, short[] paramArrayOfShort2, short[][] paramArrayOfShort3, short[] paramArrayOfShort4, int[] paramArrayOfInt, e.a.c.b.d.a[] paramArrayOfa)
  {
    this.c = new j(1L);
    this.f = e.a.c.b.d.f.a.c(paramArrayOfShort1);
    this.q = e.a.c.b.d.f.a.a(paramArrayOfShort2);
    this.x = e.a.c.b.d.f.a.c(paramArrayOfShort3);
    this.y = e.a.c.b.d.f.a.a(paramArrayOfShort4);
    this.z = e.a.c.b.d.f.a.h(paramArrayOfInt);
    this.p0 = paramArrayOfa;
  }
  
  public static g h(Object paramObject)
  {
    if ((paramObject instanceof g)) {
      return (g)paramObject;
    }
    if (paramObject != null) {
      return new g(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf1 = new f();
    Object localObject1 = this.c;
    if (localObject1 == null) {
      localObject1 = this.d;
    }
    localf1.a((e)localObject1);
    f localf2 = new f();
    for (int i = 0;; i++)
    {
      localObject1 = this.f;
      if (i >= localObject1.length) {
        break;
      }
      localf2.a(new x0(localObject1[i]));
    }
    localf1.a(new b1(localf2));
    localObject1 = new f();
    ((f)localObject1).a(new x0(this.q));
    localf1.a(new b1((f)localObject1));
    localf2 = new f();
    for (i = 0;; i++)
    {
      localObject1 = this.x;
      if (i >= localObject1.length) {
        break;
      }
      localf2.a(new x0(localObject1[i]));
    }
    localf1.a(new b1(localf2));
    localObject1 = new f();
    ((f)localObject1).a(new x0(this.y));
    localf1.a(new b1((f)localObject1));
    localObject1 = new f();
    ((f)localObject1).a(new x0(this.z));
    localf1.a(new b1((f)localObject1));
    localObject1 = new f();
    for (i = 0; i < this.p0.length; i++)
    {
      localf2 = new f();
      Object localObject2 = e.a.c.b.d.f.a.e(this.p0[i].a());
      Object localObject3 = new f();
      int k;
      for (int j = 0; j < localObject2.length; j++)
      {
        localObject4 = new f();
        for (k = 0; k < localObject2[j].length; k++) {
          ((f)localObject4).a(new x0(localObject2[j][k]));
        }
        ((f)localObject3).a(new b1((f)localObject4));
      }
      localf2.a(new b1((f)localObject3));
      Object localObject4 = e.a.c.b.d.f.a.e(this.p0[i].b());
      localObject2 = new f();
      for (j = 0; j < localObject4.length; j++)
      {
        localObject3 = new f();
        for (k = 0; k < localObject4[j].length; k++) {
          ((f)localObject3).a(new x0(localObject4[j][k]));
        }
        ((f)localObject2).a(new b1((f)localObject3));
      }
      localf2.a(new b1((f)localObject2));
      localObject3 = e.a.c.b.d.f.a.c(this.p0[i].d());
      localObject2 = new f();
      for (j = 0; j < localObject3.length; j++) {
        ((f)localObject2).a(new x0(localObject3[j]));
      }
      localf2.a(new b1((f)localObject2));
      localf2.a(new x0(e.a.c.b.d.f.a.a(this.p0[i].c())));
      ((f)localObject1).a(new b1(localf2));
    }
    localf1.a(new b1((f)localObject1));
    return new b1(localf1);
  }
  
  public short[] f()
  {
    return e.a.c.b.d.f.a.b(this.q);
  }
  
  public short[] g()
  {
    return e.a.c.b.d.f.a.b(this.y);
  }
  
  public short[][] i()
  {
    return e.a.c.b.d.f.a.d(this.f);
  }
  
  public short[][] j()
  {
    return e.a.c.b.d.f.a.d(this.x);
  }
  
  public e.a.c.b.d.a[] k()
  {
    return this.p0;
  }
  
  public int[] l()
  {
    return e.a.c.b.d.f.a.g(this.z);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */