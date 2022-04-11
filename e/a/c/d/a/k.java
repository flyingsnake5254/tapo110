package e.a.c.d.a;

public class k
{
  private b a;
  private i b;
  protected i[] c;
  protected i[] d;
  
  public k(b paramb, i parami)
  {
    this.a = paramb;
    this.b = parami;
    b();
    a();
  }
  
  private void a()
  {
    int i = this.b.g();
    i[] arrayOfi = new i[i];
    int j = i - 1;
    for (int k = j; k >= 0; k--) {
      arrayOfi[k] = new i(this.c[k]);
    }
    this.d = new i[i];
    while (j >= 0)
    {
      this.d[j] = new i(this.a, j);
      j--;
    }
    for (k = 0; k < i; k++)
    {
      int m;
      if (arrayOfi[k].f(k) == 0)
      {
        j = k + 1;
        m = 0;
        while (j < i)
        {
          int n = j;
          if (arrayOfi[j].f(k) != 0)
          {
            d(arrayOfi, k, j);
            d(this.d, k, j);
            n = i;
            m = 1;
          }
          j = n + 1;
        }
        if (m == 0) {
          throw new ArithmeticException("Squaring matrix is not invertible.");
        }
      }
      j = arrayOfi[k].f(k);
      j = this.a.f(j);
      arrayOfi[k].m(j);
      this.d[k].m(j);
      for (j = 0; j < i; j++) {
        if (j != k)
        {
          m = arrayOfi[j].f(k);
          if (m != 0)
          {
            i locali1 = arrayOfi[k].n(m);
            i locali2 = this.d[k].n(m);
            arrayOfi[j].b(locali1);
            this.d[j].b(locali2);
          }
        }
      }
    }
  }
  
  private void b()
  {
    int i = this.b.g();
    this.c = new i[i];
    int m;
    Object localObject;
    for (int j = 0;; j++)
    {
      int k = i >> 1;
      m = k;
      if (j >= k) {
        break;
      }
      m = j << 1;
      localObject = new int[m + 1];
      localObject[m] = 1;
      this.c[j] = new i(this.a, (int[])localObject);
    }
    while (m < i)
    {
      j = m << 1;
      localObject = new int[j + 1];
      localObject[j] = 1;
      localObject = new i(this.a, (int[])localObject);
      this.c[m] = ((i)localObject).k(this.b);
      m++;
    }
  }
  
  private static void d(i[] paramArrayOfi, int paramInt1, int paramInt2)
  {
    i locali = paramArrayOfi[paramInt1];
    paramArrayOfi[paramInt1] = paramArrayOfi[paramInt2];
    paramArrayOfi[paramInt2] = locali;
  }
  
  public i[] c()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */