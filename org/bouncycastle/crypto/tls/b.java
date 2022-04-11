package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

public abstract class b
  extends e
  implements k0
{
  protected j0 a;
  protected l0 b;
  protected Vector c;
  protected int[] d;
  protected short[] e;
  protected short[] f;
  protected int g;
  protected short h;
  
  public b(j0 paramj0)
  {
    this.a = paramj0;
  }
  
  protected void A(Hashtable paramHashtable, Integer paramInteger)
    throws IOException
  {
    paramHashtable = m1.B(paramHashtable, paramInteger);
    if ((paramHashtable != null) && (!z(paramInteger, paramHashtable))) {
      throw new TlsFatalAlert((short)47);
    }
  }
  
  public x B()
  {
    return x.b;
  }
  
  public x a()
  {
    return x.d;
  }
  
  public void b(short paramShort)
  {
    this.h = ((short)paramShort);
  }
  
  public boolean c()
  {
    return false;
  }
  
  public Vector d()
    throws IOException
  {
    return null;
  }
  
  public void e(l0 paraml0)
  {
    this.b = paraml0;
  }
  
  public o0 f()
    throws IOException
  {
    if (this.h == 0) {
      return new a1();
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void g(Hashtable paramHashtable)
    throws IOException
  {
    if (paramHashtable != null)
    {
      A(paramHashtable, m1.e);
      A(paramHashtable, s0.a);
      if (s0.q(this.g)) {
        this.f = s0.o(paramHashtable);
      } else {
        A(paramHashtable, s0.b);
      }
      A(paramHashtable, u0.e);
    }
  }
  
  public x i()
  {
    return a();
  }
  
  public i0 l()
    throws IOException
  {
    int i = m1.A(this.g);
    int j = m1.E(this.g);
    return this.a.a(this.b, i, j);
  }
  
  public void m(x paramx)
    throws IOException
  {
    if (B().h(paramx)) {
      return;
    }
    throw new TlsFatalAlert((short)70);
  }
  
  public short[] o()
  {
    return new short[] { 0 };
  }
  
  public void q(Vector paramVector)
    throws IOException
  {
    if (paramVector == null) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public i1 r()
  {
    return null;
  }
  
  public void s(byte[] paramArrayOfByte) {}
  
  public void v(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void x(v paramv)
    throws IOException
  {}
  
  public Hashtable y()
    throws IOException
  {
    boolean bool = m1.L(this.b.a());
    Hashtable localHashtable1 = null;
    if (bool)
    {
      this.c = m1.z();
      localHashtable1 = u0.a(null);
      m1.c(localHashtable1, this.c);
    }
    Hashtable localHashtable2 = localHashtable1;
    if (s0.e(j()))
    {
      this.d = new int[] { 23, 24 };
      this.e = new short[] { 0, 1, 2 };
      localHashtable2 = u0.a(localHashtable1);
      s0.a(localHashtable2, this.d);
      s0.b(localHashtable2, this.e);
    }
    return localHashtable2;
  }
  
  protected boolean z(Integer paramInteger, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramInteger.intValue();
    if (i != 10)
    {
      if (i != 11) {
        return false;
      }
      s0.x(paramArrayOfByte);
      return true;
    }
    s0.w(paramArrayOfByte);
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */