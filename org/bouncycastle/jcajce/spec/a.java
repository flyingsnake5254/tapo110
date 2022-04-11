package org.bouncycastle.jcajce.spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.w.e;
import org.bouncycastle.crypto.w.h;

public class a
  extends DHParameterSpec
{
  private final BigInteger a;
  private final BigInteger b;
  private final int c;
  private h d;
  
  public a(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, int paramInt)
  {
    this(paramBigInteger1, paramBigInteger2, paramBigInteger3, paramBigInteger4, 0, paramInt);
  }
  
  public a(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, int paramInt1, int paramInt2)
  {
    super(paramBigInteger1, paramBigInteger3, paramInt2);
    this.a = paramBigInteger2;
    this.b = paramBigInteger4;
    this.c = paramInt1;
  }
  
  public a(e parame)
  {
    this(parame.f(), parame.g(), parame.b(), parame.c(), parame.e(), parame.d());
    this.d = parame.h();
  }
  
  public e a()
  {
    return new e(getP(), getG(), this.a, this.c, getL(), this.b, this.d);
  }
  
  public BigInteger b()
  {
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\spec\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */