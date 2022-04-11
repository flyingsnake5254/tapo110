package e.a.b.a.b0;

import e.a.b.a.i;
import e.a.b.a.q;
import java.math.BigInteger;

public class c
  implements b
{
  protected final e.a.b.a.d a;
  protected final d b;
  protected final i c;
  
  public c(e.a.b.a.d paramd, d paramd1)
  {
    this.a = paramd;
    this.b = paramd1;
    this.c = new q(paramd.n(paramd1.b()));
  }
  
  public boolean a()
  {
    return true;
  }
  
  public i b()
  {
    return this.c;
  }
  
  public BigInteger[] c(BigInteger paramBigInteger)
  {
    int i = this.b.c();
    BigInteger localBigInteger1 = d(paramBigInteger, this.b.d(), i);
    BigInteger localBigInteger2 = d(paramBigInteger, this.b.e(), i);
    d locald = this.b;
    return new BigInteger[] { paramBigInteger.subtract(localBigInteger1.multiply(locald.f()).add(localBigInteger2.multiply(locald.h()))), localBigInteger1.multiply(locald.g()).add(localBigInteger2.multiply(locald.i())).negate() };
  }
  
  protected BigInteger d(BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt)
  {
    int i;
    if (paramBigInteger2.signum() < 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramBigInteger1 = paramBigInteger1.multiply(paramBigInteger2.abs());
    boolean bool = paramBigInteger1.testBit(paramInt - 1);
    paramBigInteger2 = paramBigInteger1.shiftRight(paramInt);
    paramBigInteger1 = paramBigInteger2;
    if (bool) {
      paramBigInteger1 = paramBigInteger2.add(e.a.b.a.c.b);
    }
    paramBigInteger2 = paramBigInteger1;
    if (i != 0) {
      paramBigInteger2 = paramBigInteger1.negate();
    }
    return paramBigInteger2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\b0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */