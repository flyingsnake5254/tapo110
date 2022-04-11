package e.a.b.a;

import java.math.BigInteger;

public class m
  extends a
{
  protected final d a;
  protected final e.a.b.a.b0.b b;
  
  public m(d paramd, e.a.b.a.b0.b paramb)
  {
    if ((paramd != null) && (paramd.w() != null))
    {
      this.a = paramd;
      this.b = paramb;
      return;
    }
    throw new IllegalArgumentException("Need curve with known group order");
  }
  
  protected h c(h paramh, BigInteger paramBigInteger)
  {
    if (this.a.m(paramh.i()))
    {
      Object localObject = paramh.i().w();
      localObject = this.b.c(paramBigInteger.mod((BigInteger)localObject));
      paramBigInteger = localObject[0];
      localObject = localObject[1];
      i locali = this.b.b();
      if (this.b.a()) {
        return b.d(paramh, paramBigInteger, locali, (BigInteger)localObject);
      }
      return b.c(paramh, paramBigInteger, locali.a(paramh), (BigInteger)localObject);
    }
    throw new IllegalStateException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */