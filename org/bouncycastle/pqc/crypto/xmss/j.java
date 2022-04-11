package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.crypto.g;

final class j
{
  private final q a;
  private final g b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  
  protected j(g paramg)
  {
    Objects.requireNonNull(paramg, "digest == null");
    this.b = paramg;
    int i = u.h(paramg);
    this.c = i;
    this.d = 16;
    int j = (int)Math.ceil(i * 8 / u.n(16));
    this.f = j;
    int k = (int)Math.floor(u.n((16 - 1) * j) / u.n(16)) + 1;
    this.g = k;
    j += k;
    this.e = j;
    Object localObject = i.b(paramg.b(), i, 16, j);
    this.a = ((q)localObject);
    if (localObject != null) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cannot find OID for digest algorithm: ");
    ((StringBuilder)localObject).append(paramg.b());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  protected g a()
  {
    return this.b;
  }
  
  protected int b()
  {
    return this.c;
  }
  
  protected int c()
  {
    return this.e;
  }
  
  protected int d()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */