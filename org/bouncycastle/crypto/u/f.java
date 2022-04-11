package org.bouncycastle.crypto.u;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.l;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.a;

public class f
  extends l
  implements m
{
  private final c b;
  private final int c;
  private byte[] d;
  private byte[] e;
  private byte[] f;
  private int g;
  
  public f(c paramc)
  {
    super(paramc);
    this.b = paramc;
    int i = paramc.getBlockSize();
    this.c = i;
    this.d = new byte[i];
    this.e = new byte[i];
    this.f = new byte[i];
    this.g = 0;
  }
  
  private void f()
  {
    if (this.d.length < this.c)
    {
      for (int i = 0;; i++)
      {
        byte[] arrayOfByte = this.d;
        if (i == arrayOfByte.length) {
          return;
        }
        if (this.e[i] != arrayOfByte[i]) {
          break;
        }
      }
      throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
    }
  }
  
  private void g(int paramInt)
  {
    paramInt = this.e.length - paramInt;
    int i;
    do
    {
      paramInt--;
      if (paramInt < 0) {
        break;
      }
      byte[] arrayOfByte = this.e;
      i = (byte)(arrayOfByte[paramInt] + 1);
      arrayOfByte[paramInt] = ((byte)i);
    } while (i == 0);
  }
  
  public void a(boolean paramBoolean, e parame)
    throws IllegalArgumentException
  {
    if ((parame instanceof b0))
    {
      b0 localb0 = (b0)parame;
      parame = a.g(localb0.a());
      this.d = parame;
      int i = this.c;
      if (i >= parame.length)
      {
        int j = i / 2;
        int k = 8;
        if (8 > j) {
          k = i / 2;
        }
        if (i - parame.length <= k)
        {
          if (localb0.b() != null) {
            this.b.a(true, localb0.b());
          }
          reset();
          return;
        }
        parame = new StringBuilder();
        parame.append("CTR/SIC mode requires IV of at least: ");
        parame.append(this.c - k);
        parame.append(" bytes.");
        throw new IllegalArgumentException(parame.toString());
      }
      parame = new StringBuilder();
      parame.append("CTR/SIC mode requires IV no greater than: ");
      parame.append(this.c);
      parame.append(" bytes.");
      throw new IllegalArgumentException(parame.toString());
    }
    throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.b());
    localStringBuilder.append("/SIC");
    return localStringBuilder.toString();
  }
  
  public int d(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    c(paramArrayOfByte1, paramInt1, this.c, paramArrayOfByte2, paramInt2);
    return this.c;
  }
  
  protected byte e(byte paramByte)
    throws DataLengthException, IllegalStateException
  {
    int i = this.g;
    if (i == 0)
    {
      this.b.d(this.e, 0, this.f, 0);
      arrayOfByte = this.f;
      j = this.g;
      this.g = (j + 1);
      return (byte)(paramByte ^ arrayOfByte[j]);
    }
    byte[] arrayOfByte = this.f;
    int j = i + 1;
    this.g = j;
    byte b1 = (byte)(paramByte ^ arrayOfByte[i]);
    if (j == this.e.length)
    {
      this.g = 0;
      g(0);
      f();
    }
    return b1;
  }
  
  public int getBlockSize()
  {
    return this.b.getBlockSize();
  }
  
  public void reset()
  {
    a.u(this.e, (byte)0);
    byte[] arrayOfByte = this.d;
    System.arraycopy(arrayOfByte, 0, this.e, 0, arrayOfByte.length);
    this.b.reset();
    this.g = 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\u\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */