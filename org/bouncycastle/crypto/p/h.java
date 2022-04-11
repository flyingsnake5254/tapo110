package org.bouncycastle.crypto.p;

import org.bouncycastle.util.e;
import org.bouncycastle.util.f;

public class h
  extends c
{
  public h() {}
  
  public h(h paramh)
  {
    super(paramh);
  }
  
  public String b()
  {
    return "SHA-384";
  }
  
  public e copy()
  {
    return new h(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    v();
    f.l(this.f, paramArrayOfByte, paramInt);
    f.l(this.g, paramArrayOfByte, paramInt + 8);
    f.l(this.h, paramArrayOfByte, paramInt + 16);
    f.l(this.i, paramArrayOfByte, paramInt + 24);
    f.l(this.j, paramArrayOfByte, paramInt + 32);
    f.l(this.k, paramArrayOfByte, paramInt + 40);
    reset();
    return 48;
  }
  
  public int e()
  {
    return 48;
  }
  
  public void m(e parame)
  {
    super.u((h)parame);
  }
  
  public void reset()
  {
    super.reset();
    this.f = -3766243637369397544L;
    this.g = 7105036623409894663L;
    this.h = -7973340178411365097L;
    this.i = 1526699215303891257L;
    this.j = 7436329637833083697L;
    this.k = -8163818279084223215L;
    this.l = -2662702644619276377L;
    this.m = 5167115440072839076L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */