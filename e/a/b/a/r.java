package e.a.b.a;

import java.math.BigInteger;

class r
{
  private final BigInteger a;
  private final int b;
  
  public r(BigInteger paramBigInteger, int paramInt)
  {
    if (paramInt >= 0)
    {
      this.a = paramBigInteger;
      this.b = paramInt;
      return;
    }
    throw new IllegalArgumentException("scale may not be negative");
  }
  
  private void c(r paramr)
  {
    if (this.b == paramr.b) {
      return;
    }
    throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
  }
  
  public r a(r paramr)
  {
    c(paramr);
    return new r(this.a.add(paramr.a), this.b);
  }
  
  public r b(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.b;
      if (paramInt == i) {
        return this;
      }
      return new r(this.a.shiftLeft(paramInt - i), paramInt);
    }
    throw new IllegalArgumentException("scale may not be negative");
  }
  
  public int d(BigInteger paramBigInteger)
  {
    return this.a.compareTo(paramBigInteger.shiftLeft(this.b));
  }
  
  public BigInteger e()
  {
    return this.a.shiftRight(this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof r)) {
      return false;
    }
    paramObject = (r)paramObject;
    if ((!this.a.equals(((r)paramObject).a)) || (this.b != ((r)paramObject).b)) {
      bool = false;
    }
    return bool;
  }
  
  public int f()
  {
    return this.b;
  }
  
  public r g()
  {
    return new r(this.a.negate(), this.b);
  }
  
  public BigInteger h()
  {
    return a(new r(c.b, 1).b(this.b)).e();
  }
  
  public int hashCode()
  {
    return this.a.hashCode() ^ this.b;
  }
  
  public r i(BigInteger paramBigInteger)
  {
    return new r(this.a.subtract(paramBigInteger.shiftLeft(this.b)), this.b);
  }
  
  public r j(r paramr)
  {
    return a(paramr.g());
  }
  
  public String toString()
  {
    if (this.b == 0) {
      return this.a.toString();
    }
    Object localObject1 = e();
    Object localObject2 = this.a.subtract(((BigInteger)localObject1).shiftLeft(this.b));
    Object localObject3 = localObject2;
    if (this.a.signum() == -1) {
      localObject3 = c.b.shiftLeft(this.b).subtract((BigInteger)localObject2);
    }
    localObject2 = localObject1;
    if (((BigInteger)localObject1).signum() == -1)
    {
      localObject2 = localObject1;
      if (!((BigInteger)localObject3).equals(c.a)) {
        localObject2 = ((BigInteger)localObject1).add(c.b);
      }
    }
    localObject2 = ((BigInteger)localObject2).toString();
    localObject1 = new char[this.b];
    localObject3 = ((BigInteger)localObject3).toString(2);
    int i = ((String)localObject3).length();
    int j = this.b - i;
    int k = 0;
    int n;
    for (int m = 0;; m++)
    {
      n = k;
      if (m >= j) {
        break;
      }
      localObject1[m] = ((char)48);
    }
    while (n < i)
    {
      localObject1[(j + n)] = ((String)localObject3).charAt(n);
      n++;
    }
    localObject3 = new String((char[])localObject1);
    localObject2 = new StringBuffer((String)localObject2);
    ((StringBuffer)localObject2).append(".");
    ((StringBuffer)localObject2).append((String)localObject3);
    return ((StringBuffer)localObject2).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */