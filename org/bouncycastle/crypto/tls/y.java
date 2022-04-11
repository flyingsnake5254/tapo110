package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.crypto.g;
import org.bouncycastle.util.io.a;

class y
{
  private static int a = 16384;
  private g1 b;
  private InputStream c;
  private OutputStream d;
  private o0 e = null;
  private o0 f = null;
  private o0 g = null;
  private i0 h = null;
  private i0 i = null;
  private i0 j = null;
  private b k = new b(null);
  private b l = new b(null);
  private ByteArrayOutputStream m = new ByteArrayOutputStream();
  private v0 n = null;
  private a o = new a();
  private x p = null;
  private x q = null;
  private boolean r = true;
  private int s;
  private int t;
  private int u;
  
  y(g1 paramg1, InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.b = paramg1;
    this.c = paramInputStream;
    this.d = paramOutputStream;
    paramg1 = new a1();
    this.f = paramg1;
    this.g = paramg1;
  }
  
  private static void b(int paramInt1, int paramInt2, short paramShort)
    throws IOException
  {
    if (paramInt1 <= paramInt2) {
      return;
    }
    throw new TlsFatalAlert(paramShort);
  }
  
  private static void c(short paramShort1, short paramShort2)
    throws IOException
  {
    switch (paramShort1)
    {
    default: 
      throw new TlsFatalAlert(paramShort2);
    }
  }
  
  private byte[] g()
  {
    byte[] arrayOfByte = this.m.toByteArray();
    this.m.reset();
    return arrayOfByte;
  }
  
  byte[] d(short paramShort, InputStream paramInputStream, int paramInt)
    throws IOException
  {
    paramInputStream = m1.Z(paramInt, paramInputStream);
    long l1 = this.k.a((short)10);
    byte[] arrayOfByte = this.i.a(l1, paramShort, paramInputStream, 0, paramInputStream.length);
    b(arrayOfByte.length, this.t, (short)22);
    OutputStream localOutputStream = this.f.a(this.m);
    paramInputStream = arrayOfByte;
    if (localOutputStream != this.m)
    {
      localOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
      localOutputStream.flush();
      paramInputStream = g();
    }
    b(paramInputStream.length, this.s, (short)30);
    if ((paramInputStream.length < 1) && (paramShort != 23)) {
      throw new TlsFatalAlert((short)47);
    }
    return paramInputStream;
  }
  
  void e()
    throws IOException
  {
    Object localObject1 = this.f;
    Object localObject2 = this.e;
    if ((localObject1 == localObject2) && (this.g == localObject2))
    {
      localObject2 = this.i;
      localObject1 = this.h;
      if ((localObject2 == localObject1) && (this.j == localObject1))
      {
        this.e = null;
        this.h = null;
        return;
      }
    }
    throw new TlsFatalAlert((short)40);
  }
  
  void f()
    throws IOException
  {
    this.d.flush();
  }
  
  v0 h()
  {
    return this.n;
  }
  
  OutputStream i()
  {
    return this.o;
  }
  
  int j()
  {
    return this.s;
  }
  
  x k()
  {
    return this.p;
  }
  
  void l(p0 paramp0)
  {
    Object localObject = new z0(paramp0);
    this.i = ((i0)localObject);
    this.j = ((i0)localObject);
    localObject = new o();
    this.n = ((v0)localObject);
    ((v0)localObject).a(paramp0);
    t(a);
  }
  
  void m()
  {
    this.n = this.n.g();
  }
  
  v0 n()
  {
    v0 localv0 = this.n;
    this.n = localv0.d();
    return localv0;
  }
  
  boolean o()
    throws IOException
  {
    byte[] arrayOfByte = m1.X(5, this.c);
    if (arrayOfByte == null) {
      return false;
    }
    short s1 = m1.k0(arrayOfByte, 0);
    c(s1, (short)10);
    if (!this.r)
    {
      if ((m1.o0(arrayOfByte, 1) & 0xFF00) != 768) {
        throw new TlsFatalAlert((short)47);
      }
    }
    else
    {
      x localx1 = m1.n0(arrayOfByte, 1);
      x localx2 = this.p;
      if (localx2 == null) {
        this.p = localx1;
      } else {
        if (!localx1.a(localx2)) {
          break label140;
        }
      }
    }
    int i1 = m1.e0(arrayOfByte, 3);
    b(i1, this.u, (short)22);
    arrayOfByte = d(s1, this.c, i1);
    this.b.I(s1, arrayOfByte, 0, arrayOfByte.length);
    return true;
    label140:
    throw new TlsFatalAlert((short)47);
  }
  
  void p()
    throws IOException
  {
    o0 localo0 = this.e;
    if (localo0 != null)
    {
      i0 locali0 = this.h;
      if (locali0 != null)
      {
        this.f = localo0;
        this.i = locali0;
        this.k = new b(null);
        return;
      }
    }
    throw new TlsFatalAlert((short)40);
  }
  
  void q()
  {
    try
    {
      this.c.close();
    }
    catch (IOException localIOException1)
    {
      try
      {
        for (;;)
        {
          this.d.close();
          return;
          localIOException1 = localIOException1;
        }
      }
      catch (IOException localIOException2)
      {
        for (;;) {}
      }
    }
  }
  
  void r()
    throws IOException
  {
    o0 localo0 = this.e;
    if (localo0 != null)
    {
      i0 locali0 = this.h;
      if (locali0 != null)
      {
        this.g = localo0;
        this.j = locali0;
        this.l = new b(null);
        return;
      }
    }
    throw new TlsFatalAlert((short)40);
  }
  
  void s(o0 paramo0, i0 parami0)
  {
    this.e = paramo0;
    this.h = parami0;
  }
  
  void t(int paramInt)
  {
    this.s = paramInt;
    paramInt += 1024;
    this.t = paramInt;
    this.u = (paramInt + 1024);
  }
  
  void u(x paramx)
  {
    this.q = paramx;
  }
  
  void v(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.q == null) {
      return;
    }
    c(paramShort, (short)80);
    b(paramInt2, this.s, (short)80);
    if ((paramInt2 < 1) && (paramShort != 23)) {
      throw new TlsFatalAlert((short)80);
    }
    Object localObject = this.g.b(this.m);
    long l1 = this.l.a((short)80);
    if (localObject == this.m)
    {
      paramArrayOfByte = this.j.b(l1, paramShort, paramArrayOfByte, paramInt1, paramInt2);
    }
    else
    {
      ((OutputStream)localObject).write(paramArrayOfByte, paramInt1, paramInt2);
      ((OutputStream)localObject).flush();
      paramArrayOfByte = g();
      b(paramArrayOfByte.length, paramInt2 + 1024, (short)80);
      paramArrayOfByte = this.j.b(l1, paramShort, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    b(paramArrayOfByte.length, this.u, (short)80);
    localObject = new byte[paramArrayOfByte.length + 5];
    m1.I0(paramShort, (byte[])localObject, 0);
    m1.O0(this.q, (byte[])localObject, 1);
    m1.x0(paramArrayOfByte.length, (byte[])localObject, 3);
    System.arraycopy(paramArrayOfByte, 0, localObject, 5, paramArrayOfByte.length);
    this.d.write((byte[])localObject);
    this.d.flush();
  }
  
  class a
    extends a
  {
    a() {}
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      y.a(y.this).update(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  private static class b
  {
    private long a = 0L;
    private boolean b = false;
    
    long a(short paramShort)
      throws TlsFatalAlert
    {
      try
      {
        if (!this.b)
        {
          long l1 = this.a;
          long l2 = 1L + l1;
          this.a = l2;
          if (l2 == 0L) {
            this.b = true;
          }
          return l1;
        }
        TlsFatalAlert localTlsFatalAlert = new org/bouncycastle/crypto/tls/TlsFatalAlert;
        localTlsFatalAlert.<init>(paramShort);
        throw localTlsFatalAlert;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */