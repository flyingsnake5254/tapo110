package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.d0;
import org.bouncycastle.crypto.w.e;
import org.bouncycastle.crypto.w.f;
import org.bouncycastle.crypto.w.g;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.p;
import org.bouncycastle.crypto.w.r;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.util.a;

public class e1
  extends d
{
  protected c1 d;
  protected d1 e;
  protected e f;
  protected int[] g;
  protected short[] h;
  protected short[] i;
  protected byte[] j = null;
  protected byte[] k = null;
  protected f l = null;
  protected g m = null;
  protected r n = null;
  protected s o = null;
  protected org.bouncycastle.crypto.w.b p = null;
  protected d0 q = null;
  protected t0 r = null;
  protected byte[] s;
  
  public e1(int paramInt, Vector paramVector, c1 paramc1, d1 paramd1, e parame, int[] paramArrayOfInt, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    super(paramInt, paramVector);
    if (paramInt != 24) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("unsupported key exchange algorithm");
      }
    }
    this.d = paramc1;
    this.e = paramd1;
    this.f = parame;
    this.g = paramArrayOfInt;
    this.h = paramArrayOfShort1;
    this.i = paramArrayOfShort2;
  }
  
  public void b(InputStream paramInputStream)
    throws IOException
  {
    this.j = m1.a0(paramInputStream);
    int i1 = this.a;
    if (i1 == 14)
    {
      paramInputStream = r0.h(b0.b(paramInputStream).a());
      this.m = paramInputStream;
      this.f = paramInputStream.b();
    }
    else if (i1 == 24)
    {
      n localn = s0.v(this.g, this.h, paramInputStream);
      paramInputStream = m1.c0(paramInputStream);
      this.o = s0.z(s0.j(this.h, localn, paramInputStream));
    }
  }
  
  public void c(i parami)
    throws IOException
  {
    throw new TlsFatalAlert((short)10);
  }
  
  public void e(OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte1 = this.j;
    if (arrayOfByte1 == null) {
      this.d.b();
    } else {
      this.d.c(arrayOfByte1);
    }
    byte[] arrayOfByte2 = this.d.a();
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = this.d.d();
      this.k = arrayOfByte1;
      if (arrayOfByte1 != null)
      {
        m1.t0(arrayOfByte2, paramOutputStream);
        this.c.e().j = a.g(arrayOfByte2);
        int i1 = this.a;
        if (i1 == 14) {
          this.l = r0.e(this.c.c(), this.f, paramOutputStream);
        } else if (i1 == 24) {
          this.n = s0.l(this.c.c(), this.i, this.o.b(), paramOutputStream);
        } else if (i1 == 15) {
          this.s = h1.a(this.c, this.q, paramOutputStream);
        }
        return;
      }
      throw new TlsFatalAlert((short)80);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void g(h paramh)
    throws IOException
  {
    if (this.a == 15)
    {
      if (!paramh.c())
      {
        org.bouncycastle.asn1.x509.h localh = paramh.b(0);
        Object localObject = localh.n();
        try
        {
          localObject = org.bouncycastle.crypto.util.b.a((w)localObject);
          this.p = ((org.bouncycastle.crypto.w.b)localObject);
          if (!((org.bouncycastle.crypto.w.b)localObject).a())
          {
            this.q = m((d0)this.p);
            m1.q0(localh, 32);
            super.g(paramh);
            return;
          }
          throw new TlsFatalAlert((short)80);
        }
        catch (RuntimeException paramh)
        {
          throw new TlsFatalAlert((short)43, paramh);
        }
      }
      throw new TlsFatalAlert((short)42);
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public void h(q0 paramq0)
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  public byte[] i()
    throws IOException
  {
    byte[] arrayOfByte = l(this.k.length);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(arrayOfByte.length + 4 + this.k.length);
    m1.t0(arrayOfByte, localByteArrayOutputStream);
    m1.t0(this.k, localByteArrayOutputStream);
    a.u(this.k, (byte)0);
    this.k = null;
    return localByteArrayOutputStream.toByteArray();
  }
  
  public void j()
    throws IOException
  {
    if (this.a != 15) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public boolean k()
  {
    int i1 = this.a;
    return (i1 == 14) || (i1 == 24);
  }
  
  protected byte[] l(int paramInt)
    throws IOException
  {
    int i1 = this.a;
    Object localObject;
    if (i1 == 14)
    {
      localObject = this.l;
      if (localObject != null) {
        return r0.a(this.m, (f)localObject);
      }
      throw new TlsFatalAlert((short)80);
    }
    if (i1 == 24)
    {
      localObject = this.n;
      if (localObject != null) {
        return s0.c(this.o, (r)localObject);
      }
      throw new TlsFatalAlert((short)80);
    }
    if (i1 == 15) {
      return this.s;
    }
    return new byte[paramInt];
  }
  
  protected d0 m(d0 paramd0)
    throws IOException
  {
    if (paramd0.b().isProbablePrime(2)) {
      return paramd0;
    }
    throw new TlsFatalAlert((short)47);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\e1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */