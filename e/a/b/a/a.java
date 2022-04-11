package e.a.b.a;

import java.math.BigInteger;

public abstract class a
  implements g
{
  public h a(h paramh, BigInteger paramBigInteger)
  {
    int i = paramBigInteger.signum();
    if ((i != 0) && (!paramh.u()))
    {
      paramh = c(paramh, paramBigInteger.abs());
      if (i <= 0) {
        paramh = paramh.z();
      }
      return b(paramh);
    }
    return paramh.i().u();
  }
  
  protected h b(h paramh)
  {
    return b.b(paramh);
  }
  
  protected abstract h c(h paramh, BigInteger paramBigInteger);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */