package org.bouncycastle.crypto.u;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.w.b0;

public class c
  implements a
{
  private org.bouncycastle.crypto.c a;
  private int b;
  private boolean c;
  private byte[] d;
  private byte[] e;
  private int f;
  private e g;
  private byte[] h;
  private a i = new a();
  private a j = new a();
  
  public c(org.bouncycastle.crypto.c paramc)
  {
    this.a = paramc;
    int k = paramc.getBlockSize();
    this.b = k;
    this.h = new byte[k];
    if (k == 16) {
      return;
    }
    throw new IllegalArgumentException("cipher required with a block size of 16.");
  }
  
  private int d(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    org.bouncycastle.crypto.t.a locala = new org.bouncycastle.crypto.t.a(this.a, this.f * 8);
    locala.d(this.g);
    byte[] arrayOfByte1 = new byte[16];
    if (f()) {
      arrayOfByte1[0] = ((byte)(byte)(arrayOfByte1[0] | 0x40));
    }
    int k = arrayOfByte1[0];
    int m = locala.a();
    int n = 2;
    arrayOfByte1[0] = ((byte)(byte)(k | ((m - 2) / 2 & 0x7) << 3));
    m = arrayOfByte1[0];
    byte[] arrayOfByte2 = this.d;
    arrayOfByte1[0] = ((byte)(byte)(m | 15 - arrayOfByte2.length - 1 & 0x7));
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 1, arrayOfByte2.length);
    k = paramInt2;
    for (m = 1; k > 0; m++)
    {
      arrayOfByte1[(16 - m)] = ((byte)(byte)(k & 0xFF));
      k >>>= 8;
    }
    locala.update(arrayOfByte1, 0, 16);
    if (f())
    {
      k = e();
      if (k < 65280)
      {
        locala.c((byte)(k >> 8));
        locala.c((byte)k);
        m = n;
      }
      else
      {
        locala.c((byte)-1);
        locala.c((byte)-2);
        locala.c((byte)(k >> 24));
        locala.c((byte)(k >> 16));
        locala.c((byte)(k >> 8));
        locala.c((byte)k);
        m = 6;
      }
      arrayOfByte1 = this.e;
      if (arrayOfByte1 != null) {
        locala.update(arrayOfByte1, 0, arrayOfByte1.length);
      }
      if (this.i.size() > 0) {
        locala.update(this.i.a(), 0, this.i.size());
      }
      m = (m + k) % 16;
      if (m != 0) {
        while (m != 16)
        {
          locala.c((byte)0);
          m++;
        }
      }
    }
    locala.update(paramArrayOfByte1, paramInt1, paramInt2);
    return locala.doFinal(paramArrayOfByte2, 0);
  }
  
  private int e()
  {
    int k = this.i.size();
    byte[] arrayOfByte = this.e;
    int m;
    if (arrayOfByte == null) {
      m = 0;
    } else {
      m = arrayOfByte.length;
    }
    return k + m;
  }
  
  private boolean f()
  {
    boolean bool;
    if (e() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void a(boolean paramBoolean, e parame)
    throws IllegalArgumentException
  {
    this.c = paramBoolean;
    if ((parame instanceof org.bouncycastle.crypto.w.a))
    {
      parame = (org.bouncycastle.crypto.w.a)parame;
      this.d = parame.d();
      this.e = parame.a();
      this.f = (parame.c() / 8);
      parame = parame.b();
    }
    else
    {
      if (!(parame instanceof b0)) {
        break label140;
      }
      parame = (b0)parame;
      this.d = parame.a();
      this.e = null;
      this.f = (this.h.length / 2);
      parame = parame.b();
    }
    if (parame != null) {
      this.g = parame;
    }
    parame = this.d;
    if ((parame != null) && (parame.length >= 7) && (parame.length <= 13))
    {
      h();
      return;
    }
    throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
    label140:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameters passed to CCM: ");
    localStringBuilder.append(parame.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int b(int paramInt)
  {
    paramInt += this.j.size();
    if (this.c) {
      return paramInt + this.f;
    }
    int k = this.f;
    if (paramInt < k) {
      paramInt = 0;
    } else {
      paramInt -= k;
    }
    return paramInt;
  }
  
  public int c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException, IllegalStateException
  {
    if (paramArrayOfByte1.length >= paramInt1 + paramInt2)
    {
      this.j.write(paramArrayOfByte1, paramInt1, paramInt2);
      return 0;
    }
    throw new DataLengthException("Input buffer too short");
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, InvalidCipherTextException
  {
    paramInt = g(this.j.a(), 0, this.j.size(), paramArrayOfByte, paramInt);
    h();
    return paramInt;
  }
  
  public int g(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws IllegalStateException, InvalidCipherTextException, DataLengthException
  {
    if (this.g != null)
    {
      Object localObject = this.d;
      int k = 15 - localObject.length;
      if ((k < 4) && (paramInt2 >= 1 << k * 8)) {
        throw new IllegalStateException("CCM packet too large for choice of q.");
      }
      byte[] arrayOfByte1 = new byte[this.b];
      arrayOfByte1[0] = ((byte)(byte)(k - 1 & 0x7));
      System.arraycopy(localObject, 0, arrayOfByte1, 1, localObject.length);
      localObject = new f(this.a);
      ((org.bouncycastle.crypto.c)localObject).a(this.c, new b0(this.g, arrayOfByte1));
      int m;
      int n;
      int i2;
      if (this.c)
      {
        m = this.f + paramInt2;
        if (paramArrayOfByte2.length >= m + paramInt3)
        {
          d(paramArrayOfByte1, paramInt1, paramInt2, this.h);
          arrayOfByte1 = new byte[this.b];
          ((org.bouncycastle.crypto.c)localObject).d(this.h, 0, arrayOfByte1, 0);
          k = paramInt1;
          n = paramInt3;
          int i1;
          for (;;)
          {
            i1 = paramInt1 + paramInt2;
            i2 = this.b;
            if (k >= i1 - i2) {
              break;
            }
            ((org.bouncycastle.crypto.c)localObject).d(paramArrayOfByte1, k, paramArrayOfByte2, n);
            i2 = this.b;
            n += i2;
            k += i2;
          }
          byte[] arrayOfByte2 = new byte[i2];
          paramInt1 = i1 - k;
          System.arraycopy(paramArrayOfByte1, k, arrayOfByte2, 0, paramInt1);
          ((org.bouncycastle.crypto.c)localObject).d(arrayOfByte2, 0, arrayOfByte2, 0);
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte2, n, paramInt1);
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte2, paramInt3 + paramInt2, this.f);
          paramInt1 = m;
        }
        else
        {
          throw new OutputLengthException("Output buffer too short.");
        }
      }
      else
      {
        k = this.f;
        if (paramInt2 < k) {
          break label586;
        }
        n = paramInt2 - k;
        if (paramArrayOfByte2.length < n + paramInt3) {
          break label576;
        }
        m = paramInt1 + n;
        System.arraycopy(paramArrayOfByte1, m, this.h, 0, k);
        arrayOfByte1 = this.h;
        ((org.bouncycastle.crypto.c)localObject).d(arrayOfByte1, 0, arrayOfByte1, 0);
        for (paramInt2 = this.f;; paramInt2++)
        {
          arrayOfByte1 = this.h;
          if (paramInt2 == arrayOfByte1.length) {
            break;
          }
          arrayOfByte1[paramInt2] = ((byte)0);
        }
        k = paramInt1;
        paramInt2 = paramInt3;
        for (;;)
        {
          i2 = this.b;
          if (k >= m - i2) {
            break;
          }
          ((org.bouncycastle.crypto.c)localObject).d(paramArrayOfByte1, k, paramArrayOfByte2, paramInt2);
          i2 = this.b;
          paramInt2 += i2;
          k += i2;
        }
        arrayOfByte1 = new byte[i2];
        paramInt1 = n - (k - paramInt1);
        System.arraycopy(paramArrayOfByte1, k, arrayOfByte1, 0, paramInt1);
        ((org.bouncycastle.crypto.c)localObject).d(arrayOfByte1, 0, arrayOfByte1, 0);
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte2, paramInt2, paramInt1);
        paramArrayOfByte1 = new byte[this.b];
        d(paramArrayOfByte2, paramInt3, n, paramArrayOfByte1);
        if (!org.bouncycastle.util.a.o(this.h, paramArrayOfByte1)) {
          break label566;
        }
        paramInt1 = n;
      }
      return paramInt1;
      label566:
      throw new InvalidCipherTextException("mac check in CCM failed");
      label576:
      throw new OutputLengthException("Output buffer too short.");
      label586:
      throw new InvalidCipherTextException("data too short");
    }
    throw new IllegalStateException("CCM cipher unitialized.");
  }
  
  public void h()
  {
    this.a.reset();
    this.i.reset();
    this.j.reset();
  }
  
  private class a
    extends ByteArrayOutputStream
  {
    public a() {}
    
    public byte[] a()
    {
      return this.buf;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\u\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */