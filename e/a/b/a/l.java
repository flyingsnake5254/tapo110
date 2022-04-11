package e.a.b.a;

import java.math.BigInteger;

public class l
{
  public static int a(d paramd)
  {
    BigInteger localBigInteger = paramd.w();
    int i;
    if (localBigInteger == null) {
      i = paramd.t() + 1;
    } else {
      i = localBigInteger.bitLength();
    }
    return i;
  }
  
  public static k b(final h paramh)
  {
    d locald = paramh.i();
    return (k)locald.B(paramh, "bc_fixed_point", new a(locald, paramh));
  }
  
  static final class a
    implements o
  {
    a(d paramd, h paramh) {}
    
    private boolean b(k paramk, int paramInt)
    {
      boolean bool;
      if ((paramk != null) && (c(paramk.a(), paramInt))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private boolean c(f paramf, int paramInt)
    {
      boolean bool;
      if ((paramf != null) && (paramf.a() >= paramInt)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public p a(p paramp)
    {
      if ((paramp instanceof k)) {
        paramp = (k)paramp;
      } else {
        paramp = null;
      }
      int i = l.a(this.a);
      int j;
      if (i > 257) {
        j = 6;
      } else {
        j = 5;
      }
      int k = 1 << j;
      if (b(paramp, k)) {
        return paramp;
      }
      int m = (i + j - 1) / j;
      h[] arrayOfh = new h[j + 1];
      arrayOfh[0] = paramh;
      for (i = 1; i < j; i++) {
        arrayOfh[i] = arrayOfh[(i - 1)].I(m);
      }
      arrayOfh[j] = arrayOfh[0].G(arrayOfh[1]);
      this.a.z(arrayOfh);
      paramp = new h[k];
      paramp[0] = arrayOfh[0];
      for (i = j - 1; i >= 0; i--)
      {
        localObject = arrayOfh[i];
        int n = 1 << i;
        m = n;
        while (m < k)
        {
          paramp[m] = paramp[(m - n)].a((h)localObject);
          m += (n << 1);
        }
      }
      this.a.z(paramp);
      Object localObject = new k();
      ((k)localObject).d(this.a.e(paramp, 0, k));
      ((k)localObject).e(arrayOfh[j]);
      ((k)localObject).f(j);
      return (p)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */