package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.MaxBytesExceededException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.f;
import org.bouncycastle.util.i;

public class k
  implements m
{
  private static final int[] a = f.i(i.e("expand 16-byte kexpand 32-byte k"), 0, 8);
  protected static final byte[] b = i.e("expand 32-byte k");
  protected static final byte[] c = i.e("expand 16-byte k");
  protected int d;
  private int e = 0;
  protected int[] f = new int[16];
  protected int[] g = new int[16];
  private byte[] h = new byte[64];
  private boolean i = false;
  private int j;
  private int k;
  private int l;
  
  public k()
  {
    this(20);
  }
  
  public k(int paramInt)
  {
    if ((paramInt > 0) && ((paramInt & 0x1) == 0))
    {
      this.d = paramInt;
      return;
    }
    throw new IllegalArgumentException("'rounds' must be a positive, even number");
  }
  
  private boolean g(int paramInt)
  {
    int m = this.j + paramInt;
    this.j = m;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (m < paramInt)
    {
      bool2 = bool1;
      if (m >= 0)
      {
        paramInt = this.k + 1;
        this.k = paramInt;
        bool2 = bool1;
        if (paramInt == 0)
        {
          paramInt = this.l + 1;
          this.l = paramInt;
          bool2 = bool1;
          if ((paramInt & 0x20) != 0) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  private void k()
  {
    this.j = 0;
    this.k = 0;
    this.l = 0;
  }
  
  protected static int l(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> -paramInt2 | paramInt1 << paramInt2;
  }
  
  public void a(boolean paramBoolean, e parame)
  {
    if ((parame instanceof b0))
    {
      Object localObject = (b0)parame;
      parame = ((b0)localObject).a();
      if ((parame != null) && (parame.length == f()))
      {
        localObject = ((b0)localObject).b();
        if (localObject == null)
        {
          if (this.i)
          {
            m(null, parame);
          }
          else
          {
            parame = new StringBuilder();
            parame.append(e());
            parame.append(" KeyParameter can not be null for first initialisation");
            throw new IllegalStateException(parame.toString());
          }
        }
        else
        {
          if (!(localObject instanceof a0)) {
            break label120;
          }
          m(((a0)localObject).a(), parame);
        }
        i();
        this.i = true;
        return;
        label120:
        parame = new StringBuilder();
        parame.append(e());
        parame.append(" Init parameters must contain a KeyParameter (or null for re-init)");
        throw new IllegalArgumentException(parame.toString());
      }
      parame = new StringBuilder();
      parame.append(e());
      parame.append(" requires exactly ");
      parame.append(f());
      parame.append(" bytes of IV");
      throw new IllegalArgumentException(parame.toString());
    }
    parame = new StringBuilder();
    parame.append(e());
    parame.append(" Init parameters must include an IV");
    throw new IllegalArgumentException(parame.toString());
  }
  
  protected void b()
  {
    throw null;
  }
  
  public int c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (this.i)
    {
      if (paramInt1 + paramInt2 <= paramArrayOfByte1.length)
      {
        if (paramInt3 + paramInt2 <= paramArrayOfByte2.length)
        {
          if (!g(paramInt2))
          {
            for (int m = 0; m < paramInt2; m++)
            {
              byte[] arrayOfByte = this.h;
              int n = this.e;
              paramArrayOfByte2[(m + paramInt3)] = ((byte)(byte)(arrayOfByte[n] ^ paramArrayOfByte1[(m + paramInt1)]));
              n = n + 1 & 0x3F;
              this.e = n;
              if (n == 0)
              {
                b();
                d(this.h);
              }
            }
            return paramInt2;
          }
          throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append(e());
    paramArrayOfByte1.append(" not initialised");
    throw new IllegalStateException(paramArrayOfByte1.toString());
  }
  
  protected void d(byte[] paramArrayOfByte)
  {
    throw null;
  }
  
  public String e()
  {
    throw null;
  }
  
  protected int f()
  {
    throw null;
  }
  
  protected void h(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramInt1 = (paramInt1 - 16) / 4;
    int[] arrayOfInt = a;
    paramArrayOfInt[paramInt2] = arrayOfInt[paramInt1];
    paramArrayOfInt[(paramInt2 + 1)] = arrayOfInt[(paramInt1 + 1)];
    paramArrayOfInt[(paramInt2 + 2)] = arrayOfInt[(paramInt1 + 2)];
    paramArrayOfInt[(paramInt2 + 3)] = arrayOfInt[(paramInt1 + 3)];
  }
  
  public void i()
  {
    this.e = 0;
    k();
    j();
    d(this.h);
  }
  
  protected void j()
  {
    throw null;
  }
  
  protected void m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\engines\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */