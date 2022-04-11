package e.a.b.c;

public abstract class k
{
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    g.y(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    g.x(paramArrayOfInt1, 8, paramArrayOfInt2, 8, paramArrayOfInt3, 16);
    int i = g.e(paramArrayOfInt3, 8, paramArrayOfInt3, 16);
    int j = g.c(paramArrayOfInt3, 24, paramArrayOfInt3, 16, g.c(paramArrayOfInt3, 0, paramArrayOfInt3, 8, 0) + i);
    int[] arrayOfInt1 = g.h();
    int[] arrayOfInt2 = g.h();
    int k;
    if (g.l(paramArrayOfInt1, 8, paramArrayOfInt1, 0, arrayOfInt1, 0) != g.l(paramArrayOfInt2, 8, paramArrayOfInt2, 0, arrayOfInt2, 0)) {
      k = 1;
    } else {
      k = 0;
    }
    paramArrayOfInt1 = g.j();
    g.y(arrayOfInt1, arrayOfInt2, paramArrayOfInt1);
    if (k != 0) {
      k = m.d(16, paramArrayOfInt1, 0, paramArrayOfInt3, 8);
    } else {
      k = m.M(16, paramArrayOfInt1, 0, paramArrayOfInt3, 8);
    }
    m.f(32, i + j + k, paramArrayOfInt3, 24);
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    g.F(paramArrayOfInt1, paramArrayOfInt2);
    g.E(paramArrayOfInt1, 8, paramArrayOfInt2, 16);
    int i = g.e(paramArrayOfInt2, 8, paramArrayOfInt2, 16);
    int j = g.c(paramArrayOfInt2, 24, paramArrayOfInt2, 16, g.c(paramArrayOfInt2, 0, paramArrayOfInt2, 8, 0) + i);
    int[] arrayOfInt = g.h();
    g.l(paramArrayOfInt1, 8, paramArrayOfInt1, 0, arrayOfInt, 0);
    paramArrayOfInt1 = g.j();
    g.F(arrayOfInt, paramArrayOfInt1);
    m.f(32, i + j + m.M(16, paramArrayOfInt1, 0, paramArrayOfInt2, 8), paramArrayOfInt2, 24);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */