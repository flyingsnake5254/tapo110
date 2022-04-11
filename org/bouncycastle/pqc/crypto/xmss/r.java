package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.crypto.g;

public final class r
{
  private final q a;
  private final h b;
  private final int c;
  private final int d;
  
  public r(int paramInt, g paramg)
  {
    if (paramInt >= 2)
    {
      Objects.requireNonNull(paramg, "digest == null");
      paramg = new h(new j(paramg));
      this.b = paramg;
      this.c = paramInt;
      this.d = a();
      this.a = c.b(b().b(), c(), g(), paramg.d().c(), paramInt);
      return;
    }
    throw new IllegalArgumentException("height must be >= 2");
  }
  
  private int a()
  {
    for (int i = 2;; i++)
    {
      int j = this.c;
      if (i > j) {
        break;
      }
      if ((j - i) % 2 == 0) {
        return i;
      }
    }
    throw new IllegalStateException("should never happen...");
  }
  
  protected g b()
  {
    return this.b.d().a();
  }
  
  public int c()
  {
    return this.b.d().b();
  }
  
  public int d()
  {
    return this.c;
  }
  
  int e()
  {
    return this.d;
  }
  
  h f()
  {
    return this.b;
  }
  
  public int g()
  {
    return this.b.d().d();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */