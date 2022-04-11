package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.util.a;

public class z
  implements j
{
  static final byte[] a = e(, 48);
  static final byte[] b = e((byte)92, 48);
  private g c;
  private int d;
  private byte[] e;
  
  public z(g paramg)
  {
    this.c = paramg;
    int i;
    if (paramg.e() == 20) {
      i = 40;
    } else {
      i = 48;
    }
    this.d = i;
  }
  
  private static byte[] e(byte paramByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    a.u(arrayOfByte, paramByte);
    return arrayOfByte;
  }
  
  public int a()
  {
    return this.c.e();
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.b());
    localStringBuilder.append("/SSL3MAC");
    return localStringBuilder.toString();
  }
  
  public void c(byte paramByte)
  {
    this.c.c(paramByte);
  }
  
  public void d(e parame)
  {
    this.e = a.g(((a0)parame).a());
    reset();
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.c.e();
    byte[] arrayOfByte1 = new byte[i];
    this.c.doFinal(arrayOfByte1, 0);
    g localg = this.c;
    byte[] arrayOfByte2 = this.e;
    localg.update(arrayOfByte2, 0, arrayOfByte2.length);
    this.c.update(b, 0, this.d);
    this.c.update(arrayOfByte1, 0, i);
    paramInt = this.c.doFinal(paramArrayOfByte, paramInt);
    reset();
    return paramInt;
  }
  
  public void reset()
  {
    this.c.reset();
    g localg = this.c;
    byte[] arrayOfByte = this.e;
    localg.update(arrayOfByte, 0, arrayOfByte.length);
    this.c.update(a, 0, this.d);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.c.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */