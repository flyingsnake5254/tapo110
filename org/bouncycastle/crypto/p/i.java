package org.bouncycastle.crypto.p;

import org.bouncycastle.util.e;
import org.bouncycastle.util.f;

public class i
  extends c
{
  public i() {}
  
  public i(i parami)
  {
    super(parami);
  }
  
  public String b()
  {
    return "SHA-512";
  }
  
  public e copy()
  {
    return new i(this);
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
    f.l(this.l, paramArrayOfByte, paramInt + 48);
    f.l(this.m, paramArrayOfByte, paramInt + 56);
    reset();
    return 64;
  }
  
  public int e()
  {
    return 64;
  }
  
  public void m(e parame)
  {
    u((i)parame);
  }
  
  public void reset()
  {
    super.reset();
    this.f = 7640891576956012808L;
    this.g = -4942790177534073029L;
    this.h = 4354685564936845355L;
    this.i = -6534734903238641935L;
    this.j = 5840696475078001361L;
    this.k = -7276294671716946913L;
    this.l = 2270897969802886507L;
    this.m = 6620516959819538809L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */