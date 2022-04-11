package e.a.b.b;

import java.math.BigInteger;

class g
  implements a
{
  protected final BigInteger a;
  
  g(BigInteger paramBigInteger)
  {
    this.a = paramBigInteger;
  }
  
  public int a()
  {
    return 1;
  }
  
  public BigInteger b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof g)) {
      return false;
    }
    paramObject = (g)paramObject;
    return this.a.equals(((g)paramObject).a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */