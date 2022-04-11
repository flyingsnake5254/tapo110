package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.g;

public final class m
{
  private final q a;
  private final r b;
  private final int c;
  private final int d;
  
  public m(int paramInt1, int paramInt2, g paramg)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.b = new r(h(paramInt1, paramInt2), paramg);
    this.a = b.b(a().b(), b(), f(), e(), c(), paramInt2);
  }
  
  private static int h(int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    if (paramInt1 >= 2)
    {
      if (paramInt1 % paramInt2 == 0)
      {
        paramInt1 /= paramInt2;
        if (paramInt1 != 1) {
          return paramInt1;
        }
        throw new IllegalArgumentException("height / layers must be greater than 1");
      }
      throw new IllegalArgumentException("layers must divide totalHeight without remainder");
    }
    throw new IllegalArgumentException("totalHeight must be > 1");
  }
  
  protected g a()
  {
    return this.b.b();
  }
  
  public int b()
  {
    return this.b.c();
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  protected int e()
  {
    return this.b.f().d().c();
  }
  
  public int f()
  {
    return this.b.g();
  }
  
  protected r g()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */