package org.bouncycastle.crypto.u;

import java.util.Vector;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;

public class e
  implements a
{
  private c a;
  private c b;
  private boolean c;
  private int d;
  private byte[] e;
  private Vector f;
  private byte[] g;
  private byte[] h;
  private byte[] i = null;
  private byte[] j = new byte[24];
  private byte[] k = new byte[16];
  private byte[] l;
  private byte[] m;
  private int n;
  private int o;
  private long p;
  private long q;
  private byte[] r;
  private byte[] s;
  private byte[] t = new byte[16];
  private byte[] u;
  private byte[] v;
  
  public e(c paramc1, c paramc2)
  {
    if (paramc1 != null)
    {
      if (paramc1.getBlockSize() == 16)
      {
        if (paramc2 != null)
        {
          if (paramc2.getBlockSize() == 16)
          {
            if (paramc1.b().equals(paramc2.b()))
            {
              this.a = paramc1;
              this.b = paramc2;
              return;
            }
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
          }
          throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        }
        throw new IllegalArgumentException("'mainCipher' cannot be null");
      }
      throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
    }
    throw new IllegalArgumentException("'hashCipher' cannot be null");
  }
  
  protected static byte[] d(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[16];
    arrayOfByte[15] = ((byte)(byte)(135 >>> (1 - n(paramArrayOfByte, arrayOfByte) << 3) ^ arrayOfByte[15]));
    return arrayOfByte;
  }
  
  protected static void e(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)Byte.MIN_VALUE);
    for (;;)
    {
      paramInt++;
      if (paramInt >= 16) {
        break;
      }
      paramArrayOfByte[paramInt] = ((byte)0);
    }
  }
  
  protected static int f(long paramLong)
  {
    if (paramLong == 0L) {
      return 64;
    }
    int i1 = 0;
    while ((1L & paramLong) == 0L)
    {
      i1++;
      paramLong >>>= 1;
    }
    return i1;
  }
  
  protected static int n(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i1 = 16;
    int i3;
    for (int i2 = 0;; i2 = i3 >>> 7 & 0x1)
    {
      i1--;
      if (i1 < 0) {
        break;
      }
      i3 = paramArrayOfByte1[i1] & 0xFF;
      paramArrayOfByte2[i1] = ((byte)(byte)(i2 | i3 << 1));
    }
    return i2;
  }
  
  protected static void p(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    for (int i1 = 15; i1 >= 0; i1--) {
      paramArrayOfByte1[i1] = ((byte)(byte)(paramArrayOfByte1[i1] ^ paramArrayOfByte2[i1]));
    }
  }
  
  public void a(boolean paramBoolean, org.bouncycastle.crypto.e parame)
    throws IllegalArgumentException
  {
    boolean bool = this.c;
    this.c = paramBoolean;
    this.v = null;
    Object localObject1;
    int i1;
    if ((parame instanceof org.bouncycastle.crypto.w.a))
    {
      localObject1 = (org.bouncycastle.crypto.w.a)parame;
      parame = ((org.bouncycastle.crypto.w.a)localObject1).d();
      this.e = ((org.bouncycastle.crypto.w.a)localObject1).a();
      i1 = ((org.bouncycastle.crypto.w.a)localObject1).c();
      if ((i1 >= 64) && (i1 <= 128) && (i1 % 8 == 0))
      {
        this.d = (i1 / 8);
        localObject1 = ((org.bouncycastle.crypto.w.a)localObject1).b();
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
        break label533;
      }
      localObject1 = (b0)parame;
      parame = ((b0)localObject1).a();
      this.e = null;
      this.d = 16;
      localObject1 = (a0)((b0)localObject1).b();
    }
    this.l = new byte[16];
    if (paramBoolean) {
      i1 = 16;
    } else {
      i1 = this.d + 16;
    }
    this.m = new byte[i1];
    Object localObject2 = parame;
    if (parame == null) {
      localObject2 = new byte[0];
    }
    if (localObject2.length <= 15)
    {
      if (localObject1 != null)
      {
        this.a.a(true, (org.bouncycastle.crypto.e)localObject1);
        this.b.a(paramBoolean, (org.bouncycastle.crypto.e)localObject1);
        this.i = null;
      }
      else
      {
        if (bool != paramBoolean) {
          break label513;
        }
      }
      parame = new byte[16];
      this.g = parame;
      this.a.d(parame, 0, parame, 0);
      this.h = d(this.g);
      parame = new Vector();
      this.f = parame;
      parame.addElement(d(this.h));
      i1 = l((byte[])localObject2);
      int i2 = i1 % 8;
      int i3 = i1 / 8;
      if (i2 == 0) {
        System.arraycopy(this.j, i3, this.k, 0, 16);
      } else {
        for (i1 = 0; i1 < 16; i1++)
        {
          parame = this.j;
          int i4 = parame[i3];
          i3++;
          int i5 = parame[i3];
          this.k[i1] = ((byte)(byte)((i5 & 0xFF) >>> 8 - i2 | (i4 & 0xFF) << i2));
        }
      }
      this.n = 0;
      this.o = 0;
      this.p = 0L;
      this.q = 0L;
      this.r = new byte[16];
      this.s = new byte[16];
      System.arraycopy(this.k, 0, this.t, 0, 16);
      this.u = new byte[16];
      parame = this.e;
      if (parame != null) {
        i(parame, 0, parame.length);
      }
      return;
      label513:
      throw new IllegalArgumentException("cannot change encrypting state without providing key.");
    }
    throw new IllegalArgumentException("IV must be no more than 15 bytes");
    label533:
    throw new IllegalArgumentException("invalid parameters passed to OCB");
  }
  
  public int b(int paramInt)
  {
    paramInt += this.o;
    if (this.c) {
      return paramInt + this.d;
    }
    int i1 = this.d;
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
    if (paramArrayOfByte1.length >= paramInt1 + paramInt2)
    {
      int i1 = 0;
      int i3;
      for (int i2 = 0; i1 < paramInt2; i2 = i3)
      {
        byte[] arrayOfByte = this.m;
        i3 = this.o;
        arrayOfByte[i3] = ((byte)paramArrayOfByte1[(paramInt1 + i1)]);
        int i4 = i3 + 1;
        this.o = i4;
        i3 = i2;
        if (i4 == arrayOfByte.length)
        {
          k(paramArrayOfByte2, paramInt3 + i2);
          i3 = i2 + 16;
        }
        i1++;
      }
      return i2;
    }
    throw new DataLengthException("Input buffer too short");
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, InvalidCipherTextException
  {
    int i1;
    byte[] arrayOfByte1;
    if (!this.c)
    {
      i1 = this.o;
      i2 = this.d;
      if (i1 >= i2)
      {
        i1 -= i2;
        this.o = i1;
        arrayOfByte1 = new byte[i2];
        System.arraycopy(this.m, i1, arrayOfByte1, 0, i2);
      }
      else
      {
        throw new InvalidCipherTextException("data too short");
      }
    }
    else
    {
      arrayOfByte1 = null;
    }
    int i2 = this.n;
    if (i2 > 0)
    {
      e(this.l, i2);
      o(this.g);
    }
    i2 = this.o;
    if (i2 > 0)
    {
      if (this.c)
      {
        e(this.m, i2);
        p(this.u, this.m);
      }
      p(this.t, this.g);
      localObject = new byte[16];
      this.a.d(this.t, 0, (byte[])localObject, 0);
      p(this.m, (byte[])localObject);
      i1 = paramArrayOfByte.length;
      i2 = this.o;
      if (i1 >= paramInt + i2)
      {
        System.arraycopy(this.m, 0, paramArrayOfByte, paramInt, i2);
        if (!this.c)
        {
          e(this.m, this.o);
          p(this.u, this.m);
        }
      }
      else
      {
        throw new OutputLengthException("Output buffer too short");
      }
    }
    p(this.u, this.t);
    p(this.u, this.h);
    Object localObject = this.a;
    byte[] arrayOfByte2 = this.u;
    ((c)localObject).d(arrayOfByte2, 0, arrayOfByte2, 0);
    p(this.u, this.s);
    i2 = this.d;
    localObject = new byte[i2];
    this.v = ((byte[])localObject);
    System.arraycopy(this.u, 0, localObject, 0, i2);
    i2 = this.o;
    if (this.c)
    {
      i1 = paramArrayOfByte.length;
      paramInt += i2;
      int i3 = this.d;
      if (i1 >= paramInt + i3)
      {
        System.arraycopy(this.v, 0, paramArrayOfByte, paramInt, i3);
        paramInt = i2 + this.d;
      }
      else
      {
        throw new OutputLengthException("Output buffer too short");
      }
    }
    else
    {
      if (!org.bouncycastle.util.a.o(this.v, arrayOfByte1)) {
        break label430;
      }
      paramInt = i2;
    }
    m(false);
    return paramInt;
    label430:
    throw new InvalidCipherTextException("mac check in OCB failed");
  }
  
  protected void g(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      org.bouncycastle.util.a.u(paramArrayOfByte, (byte)0);
    }
  }
  
  protected byte[] h(int paramInt)
  {
    while (paramInt >= this.f.size())
    {
      Vector localVector = this.f;
      localVector.addElement(d((byte[])localVector.lastElement()));
    }
    return (byte[])this.f.elementAt(paramInt);
  }
  
  public void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (int i1 = 0; i1 < paramInt2; i1++)
    {
      byte[] arrayOfByte = this.l;
      int i2 = this.n;
      arrayOfByte[i2] = ((byte)paramArrayOfByte[(paramInt1 + i1)]);
      i2++;
      this.n = i2;
      if (i2 == arrayOfByte.length) {
        j();
      }
    }
  }
  
  protected void j()
  {
    long l1 = this.p + 1L;
    this.p = l1;
    o(h(f(l1)));
    this.n = 0;
  }
  
  protected void k(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length >= paramInt + 16)
    {
      if (this.c)
      {
        p(this.u, this.m);
        this.o = 0;
      }
      Object localObject = this.t;
      long l1 = this.q + 1L;
      this.q = l1;
      p((byte[])localObject, h(f(l1)));
      p(this.m, this.t);
      localObject = this.b;
      byte[] arrayOfByte = this.m;
      ((c)localObject).d(arrayOfByte, 0, arrayOfByte, 0);
      p(this.m, this.t);
      System.arraycopy(this.m, 0, paramArrayOfByte, paramInt, 16);
      if (!this.c)
      {
        p(this.u, this.m);
        paramArrayOfByte = this.m;
        System.arraycopy(paramArrayOfByte, 16, paramArrayOfByte, 0, this.d);
        this.o = this.d;
      }
      return;
    }
    throw new OutputLengthException("Output buffer too short");
  }
  
  protected int l(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[16];
    int i1 = paramArrayOfByte.length;
    int i2 = paramArrayOfByte.length;
    int i3 = 0;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 16 - i1, i2);
    arrayOfByte[0] = ((byte)(byte)(this.d << 4));
    i2 = 15 - paramArrayOfByte.length;
    arrayOfByte[i2] = ((byte)(byte)(arrayOfByte[i2] | 0x1));
    i1 = arrayOfByte[15];
    arrayOfByte[15] = ((byte)(byte)(arrayOfByte[15] & 0xC0));
    paramArrayOfByte = this.i;
    if ((paramArrayOfByte == null) || (!org.bouncycastle.util.a.c(arrayOfByte, paramArrayOfByte)))
    {
      paramArrayOfByte = new byte[16];
      this.i = arrayOfByte;
      this.a.d(arrayOfByte, 0, paramArrayOfByte, 0);
      System.arraycopy(paramArrayOfByte, 0, this.j, 0, 16);
      while (i3 < 8)
      {
        arrayOfByte = this.j;
        int i4 = paramArrayOfByte[i3];
        i2 = i3 + 1;
        arrayOfByte[(i3 + 16)] = ((byte)(byte)(i4 ^ paramArrayOfByte[i2]));
        i3 = i2;
      }
    }
    return i1 & 0x3F;
  }
  
  protected void m(boolean paramBoolean)
  {
    this.a.reset();
    this.b.reset();
    g(this.l);
    g(this.m);
    this.n = 0;
    this.o = 0;
    this.p = 0L;
    this.q = 0L;
    g(this.r);
    g(this.s);
    System.arraycopy(this.k, 0, this.t, 0, 16);
    g(this.u);
    if (paramBoolean) {
      this.v = null;
    }
    byte[] arrayOfByte = this.e;
    if (arrayOfByte != null) {
      i(arrayOfByte, 0, arrayOfByte.length);
    }
  }
  
  protected void o(byte[] paramArrayOfByte)
  {
    p(this.r, paramArrayOfByte);
    p(this.l, this.r);
    c localc = this.a;
    paramArrayOfByte = this.l;
    localc.d(paramArrayOfByte, 0, paramArrayOfByte, 0);
    p(this.s, this.l);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\u\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */