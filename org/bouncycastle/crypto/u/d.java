package org.bouncycastle.crypto.u;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.u.g.b;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.f;

public class d
  implements a
{
  private org.bouncycastle.crypto.c a;
  private org.bouncycastle.crypto.u.g.c b;
  private b c;
  private boolean d;
  private boolean e;
  private int f;
  private byte[] g;
  private byte[] h;
  private byte[] i;
  private byte[] j;
  private byte[] k;
  private byte[] l;
  private byte[] m;
  private byte[] n;
  private byte[] o;
  private byte[] p;
  private byte[] q;
  private int r;
  private int s;
  private long t;
  private byte[] u;
  private int v;
  private long w;
  private long x;
  
  public d(org.bouncycastle.crypto.c paramc)
  {
    this(paramc, null);
  }
  
  public d(org.bouncycastle.crypto.c paramc, org.bouncycastle.crypto.u.g.c paramc1)
  {
    if (paramc.getBlockSize() == 16)
    {
      Object localObject = paramc1;
      if (paramc1 == null) {
        localObject = new org.bouncycastle.crypto.u.g.e();
      }
      this.a = paramc;
      this.b = ((org.bouncycastle.crypto.u.g.c)localObject);
      return;
    }
    throw new IllegalArgumentException("cipher required with a block size of 16.");
  }
  
  private void d()
  {
    if (!this.e)
    {
      if (this.d) {
        throw new IllegalStateException("GCM cipher cannot be reused for encryption");
      }
      throw new IllegalStateException("GCM cipher needs to be initialised");
    }
  }
  
  private void e(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    for (int i1 = 0; i1 < paramInt; i1 += 16) {
      h(paramArrayOfByte1, paramArrayOfByte2, i1, Math.min(paramInt - i1, 16));
    }
  }
  
  private void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    org.bouncycastle.crypto.u.g.d.l(paramArrayOfByte1, paramArrayOfByte2);
    this.b.a(paramArrayOfByte1);
  }
  
  private void g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    org.bouncycastle.crypto.u.g.d.m(paramArrayOfByte1, paramArrayOfByte2, paramInt);
    this.b.a(paramArrayOfByte1);
  }
  
  private void h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    org.bouncycastle.crypto.u.g.d.n(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
    this.b.a(paramArrayOfByte1);
  }
  
  private void i(byte[] paramArrayOfByte)
  {
    int i1 = this.r;
    if (i1 != 0)
    {
      this.r = (i1 - 1);
      byte[] arrayOfByte = this.q;
      i1 = (arrayOfByte[15] & 0xFF) + 1;
      arrayOfByte[15] = ((byte)(byte)i1);
      i1 = (i1 >>> 8) + (arrayOfByte[14] & 0xFF);
      arrayOfByte[14] = ((byte)(byte)i1);
      i1 = (i1 >>> 8) + (arrayOfByte[13] & 0xFF);
      arrayOfByte[13] = ((byte)(byte)i1);
      arrayOfByte[12] = ((byte)(byte)((i1 >>> 8) + (arrayOfByte[12] & 0xFF)));
      this.a.d(arrayOfByte, 0, paramArrayOfByte, 0);
      return;
    }
    throw new IllegalStateException("Attempt to process too many blocks");
  }
  
  private void j()
  {
    if (this.w > 0L)
    {
      System.arraycopy(this.o, 0, this.p, 0, 16);
      this.x = this.w;
    }
    int i1 = this.v;
    if (i1 > 0)
    {
      h(this.p, this.u, 0, i1);
      this.x += this.v;
    }
    if (this.x > 0L) {
      System.arraycopy(this.p, 0, this.n, 0, 16);
    }
  }
  
  private void l(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (paramArrayOfByte2.length - paramInt2 >= 16)
    {
      if (this.t == 0L) {
        j();
      }
      byte[] arrayOfByte = new byte[16];
      i(arrayOfByte);
      if (this.d)
      {
        org.bouncycastle.crypto.u.g.d.m(arrayOfByte, paramArrayOfByte1, paramInt1);
        f(this.n, arrayOfByte);
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, paramInt2, 16);
      }
      else
      {
        g(this.n, paramArrayOfByte1, paramInt1);
        org.bouncycastle.crypto.u.g.d.k(arrayOfByte, 0, paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
      }
      this.t += 16L;
      return;
    }
    throw new OutputLengthException("Output buffer too short");
  }
  
  private void m(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[16];
    i(arrayOfByte);
    if (this.d)
    {
      org.bouncycastle.crypto.u.g.d.j(paramArrayOfByte1, paramInt1, arrayOfByte, 0, paramInt2);
      h(this.n, paramArrayOfByte1, paramInt1, paramInt2);
    }
    else
    {
      h(this.n, paramArrayOfByte1, paramInt1, paramInt2);
      org.bouncycastle.crypto.u.g.d.j(paramArrayOfByte1, paramInt1, arrayOfByte, 0, paramInt2);
    }
    System.arraycopy(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt3, paramInt2);
    this.t += paramInt2;
  }
  
  private void n(boolean paramBoolean)
  {
    this.a.reset();
    this.n = new byte[16];
    this.o = new byte[16];
    this.p = new byte[16];
    this.u = new byte[16];
    this.v = 0;
    this.w = 0L;
    this.x = 0L;
    this.q = org.bouncycastle.util.a.g(this.k);
    this.r = -2;
    this.s = 0;
    this.t = 0L;
    byte[] arrayOfByte = this.l;
    if (arrayOfByte != null) {
      org.bouncycastle.util.a.u(arrayOfByte, (byte)0);
    }
    if (paramBoolean) {
      this.m = null;
    }
    if (this.d)
    {
      this.e = false;
    }
    else
    {
      arrayOfByte = this.i;
      if (arrayOfByte != null) {
        k(arrayOfByte, 0, arrayOfByte.length);
      }
    }
  }
  
  public void a(boolean paramBoolean, org.bouncycastle.crypto.e parame)
    throws IllegalArgumentException
  {
    this.d = paramBoolean;
    this.m = null;
    this.e = true;
    byte[] arrayOfByte1;
    int i1;
    if ((parame instanceof org.bouncycastle.crypto.w.a))
    {
      parame = (org.bouncycastle.crypto.w.a)parame;
      arrayOfByte1 = parame.d();
      this.i = parame.a();
      i1 = parame.c();
      if ((i1 >= 32) && (i1 <= 128) && (i1 % 8 == 0))
      {
        this.f = (i1 / 8);
        parame = parame.b();
      }
      else
      {
        parame = new StringBuilder();
        parame.append("Invalid value for MAC size: ");
        parame.append(i1);
        throw new IllegalArgumentException(parame.toString());
      }
    }
    else
    {
      if (!(parame instanceof b0)) {
        break label545;
      }
      parame = (b0)parame;
      arrayOfByte1 = parame.a();
      this.i = null;
      this.f = 16;
      parame = (a0)parame.b();
    }
    if (paramBoolean) {
      i1 = 16;
    } else {
      i1 = this.f + 16;
    }
    this.l = new byte[i1];
    if ((arrayOfByte1 != null) && (arrayOfByte1.length >= 1))
    {
      if (paramBoolean)
      {
        byte[] arrayOfByte2 = this.h;
        if ((arrayOfByte2 != null) && (org.bouncycastle.util.a.c(arrayOfByte2, arrayOfByte1))) {
          if (parame != null)
          {
            arrayOfByte2 = this.g;
            if ((arrayOfByte2 != null) && (org.bouncycastle.util.a.c(arrayOfByte2, parame.a()))) {
              throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
          }
          else
          {
            throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
          }
        }
      }
      this.h = arrayOfByte1;
      if (parame != null) {
        this.g = parame.a();
      }
      if (parame != null)
      {
        this.a.a(true, parame);
        parame = new byte[16];
        this.j = parame;
        this.a.d(parame, 0, parame, 0);
        this.b.init(this.j);
        this.c = null;
      }
      else
      {
        if (this.j == null) {
          break label525;
        }
      }
      parame = new byte[16];
      this.k = parame;
      arrayOfByte1 = this.h;
      if (arrayOfByte1.length == 12)
      {
        System.arraycopy(arrayOfByte1, 0, parame, 0, arrayOfByte1.length);
        this.k[15] = ((byte)1);
      }
      else
      {
        e(parame, arrayOfByte1, arrayOfByte1.length);
        parame = new byte[16];
        f.l(this.h.length * 8L, parame, 8);
        f(this.k, parame);
      }
      this.n = new byte[16];
      this.o = new byte[16];
      this.p = new byte[16];
      this.u = new byte[16];
      this.v = 0;
      this.w = 0L;
      this.x = 0L;
      this.q = org.bouncycastle.util.a.g(this.k);
      this.r = -2;
      this.s = 0;
      this.t = 0L;
      parame = this.i;
      if (parame != null) {
        k(parame, 0, parame.length);
      }
      return;
      label525:
      throw new IllegalArgumentException("Key must be specified in initial init");
    }
    throw new IllegalArgumentException("IV must be at least 1 byte");
    label545:
    throw new IllegalArgumentException("invalid parameters passed to GCM");
  }
  
  public int b(int paramInt)
  {
    paramInt += this.s;
    if (this.d) {
      return paramInt + this.f;
    }
    int i1 = this.f;
    if (paramInt < i1) {
      paramInt = 0;
    } else {
      paramInt -= i1;
    }
    return paramInt;
  }
  
  public int c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException
  {
    d();
    if (paramArrayOfByte1.length - paramInt1 >= paramInt2)
    {
      int i1;
      int i2;
      byte[] arrayOfByte;
      label120:
      int i3;
      if (this.d)
      {
        i1 = paramInt1;
        i2 = paramInt2;
        if (this.s != 0) {
          for (;;)
          {
            i1 = paramInt1;
            i2 = paramInt2;
            if (paramInt2 <= 0) {
              break;
            }
            paramInt2--;
            arrayOfByte = this.l;
            i2 = this.s;
            i1 = paramInt1 + 1;
            arrayOfByte[i2] = ((byte)paramArrayOfByte1[paramInt1]);
            paramInt1 = i2 + 1;
            this.s = paramInt1;
            if (paramInt1 == 16)
            {
              l(arrayOfByte, 0, paramArrayOfByte2, paramInt3);
              this.s = 0;
              paramInt1 = 16;
              i2 = paramInt2;
              break label120;
            }
            paramInt1 = i1;
          }
        }
        for (paramInt1 = 0; i2 >= 16; paramInt1 += 16)
        {
          l(paramArrayOfByte1, i1, paramArrayOfByte2, paramInt3 + paramInt1);
          i1 += 16;
          i2 -= 16;
        }
        i3 = paramInt1;
        if (i2 > 0)
        {
          System.arraycopy(paramArrayOfByte1, i1, this.l, 0, i2);
          this.s = i2;
          i3 = paramInt1;
        }
      }
      else
      {
        i1 = 0;
        i2 = 0;
        for (;;)
        {
          i3 = i1;
          if (i2 >= paramInt2) {
            break;
          }
          arrayOfByte = this.l;
          i3 = this.s;
          arrayOfByte[i3] = ((byte)paramArrayOfByte1[(paramInt1 + i2)]);
          int i4 = i3 + 1;
          this.s = i4;
          i3 = i1;
          if (i4 == arrayOfByte.length)
          {
            l(arrayOfByte, 0, paramArrayOfByte2, paramInt3 + i1);
            arrayOfByte = this.l;
            System.arraycopy(arrayOfByte, 16, arrayOfByte, 0, this.f);
            this.s = this.f;
            i3 = i1 + 16;
          }
          i2++;
          i1 = i3;
        }
      }
      return i3;
    }
    throw new DataLengthException("Input buffer too short");
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, InvalidCipherTextException
  {
    d();
    if (this.t == 0L) {
      j();
    }
    int i1 = this.s;
    if (this.d)
    {
      if (paramArrayOfByte.length - paramInt < this.f + i1) {
        throw new OutputLengthException("Output buffer too short");
      }
    }
    else
    {
      i2 = this.f;
      if (i1 < i2) {
        break label463;
      }
      i1 -= i2;
      if (paramArrayOfByte.length - paramInt < i1) {
        break label453;
      }
    }
    if (i1 > 0) {
      m(this.l, 0, i1, paramArrayOfByte, paramInt);
    }
    long l1 = this.w;
    int i2 = this.v;
    l1 += i2;
    this.w = l1;
    if (l1 > this.x)
    {
      if (i2 > 0) {
        h(this.o, this.u, 0, i2);
      }
      if (this.x > 0L) {
        org.bouncycastle.crypto.u.g.d.l(this.o, this.p);
      }
      l1 = this.t;
      arrayOfByte = new byte[16];
      if (this.c == null)
      {
        localObject = new org.bouncycastle.crypto.u.g.a();
        this.c = ((b)localObject);
        ((b)localObject).init(this.j);
      }
      this.c.a(l1 * 8L + 127L >>> 7, arrayOfByte);
      org.bouncycastle.crypto.u.g.d.e(this.o, arrayOfByte);
      org.bouncycastle.crypto.u.g.d.l(this.n, this.o);
    }
    Object localObject = new byte[16];
    f.l(this.w * 8L, (byte[])localObject, 0);
    f.l(this.t * 8L, (byte[])localObject, 8);
    f(this.n, (byte[])localObject);
    byte[] arrayOfByte = new byte[16];
    this.a.d(this.k, 0, arrayOfByte, 0);
    org.bouncycastle.crypto.u.g.d.l(arrayOfByte, this.n);
    i2 = this.f;
    localObject = new byte[i2];
    this.m = ((byte[])localObject);
    System.arraycopy(arrayOfByte, 0, localObject, 0, i2);
    if (this.d)
    {
      System.arraycopy(this.m, 0, paramArrayOfByte, paramInt + this.s, this.f);
      i1 += this.f;
    }
    else
    {
      paramInt = this.f;
      paramArrayOfByte = new byte[paramInt];
      System.arraycopy(this.l, i1, paramArrayOfByte, 0, paramInt);
      if (!org.bouncycastle.util.a.o(this.m, paramArrayOfByte)) {
        break label442;
      }
    }
    n(false);
    return i1;
    label442:
    throw new InvalidCipherTextException("mac check in GCM failed");
    label453:
    throw new OutputLengthException("Output buffer too short");
    label463:
    throw new InvalidCipherTextException("data too short");
  }
  
  public void k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    d();
    for (int i1 = 0; i1 < paramInt2; i1++)
    {
      byte[] arrayOfByte = this.u;
      int i2 = this.v;
      arrayOfByte[i2] = ((byte)paramArrayOfByte[(paramInt1 + i1)]);
      i2++;
      this.v = i2;
      if (i2 == 16)
      {
        f(this.o, arrayOfByte);
        this.v = 0;
        this.w += 16L;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\u\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */