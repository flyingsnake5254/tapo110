package e.a.b.a.b0;

import java.math.BigInteger;

public class d
{
  protected final BigInteger a;
  protected final BigInteger b;
  protected final BigInteger c;
  protected final BigInteger d;
  protected final BigInteger e;
  protected final BigInteger f;
  protected final BigInteger g;
  protected final BigInteger h;
  protected final int i;
  
  public d(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger[] paramArrayOfBigInteger1, BigInteger[] paramArrayOfBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, int paramInt)
  {
    a(paramArrayOfBigInteger1, "v1");
    a(paramArrayOfBigInteger2, "v2");
    this.a = paramBigInteger1;
    this.b = paramBigInteger2;
    this.c = paramArrayOfBigInteger1[0];
    this.d = paramArrayOfBigInteger1[1];
    this.e = paramArrayOfBigInteger2[0];
    this.f = paramArrayOfBigInteger2[1];
    this.g = paramBigInteger3;
    this.h = paramBigInteger4;
    this.i = paramInt;
  }
  
  private static void a(BigInteger[] paramArrayOfBigInteger, String paramString)
  {
    if ((paramArrayOfBigInteger != null) && (paramArrayOfBigInteger.length == 2) && (paramArrayOfBigInteger[0] != null) && (paramArrayOfBigInteger[1] != null)) {
      return;
    }
    paramArrayOfBigInteger = new StringBuilder();
    paramArrayOfBigInteger.append("'");
    paramArrayOfBigInteger.append(paramString);
    paramArrayOfBigInteger.append("' must consist of exactly 2 (non-null) values");
    throw new IllegalArgumentException(paramArrayOfBigInteger.toString());
  }
  
  public BigInteger b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public BigInteger d()
  {
    return this.g;
  }
  
  public BigInteger e()
  {
    return this.h;
  }
  
  public BigInteger f()
  {
    return this.c;
  }
  
  public BigInteger g()
  {
    return this.d;
  }
  
  public BigInteger h()
  {
    return this.e;
  }
  
  public BigInteger i()
  {
    return this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\b0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */