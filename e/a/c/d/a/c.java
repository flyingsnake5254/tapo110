package e.a.c.d.a;

public final class c
{
  public static a a(b paramb, i parami)
  {
    int i = paramb.d();
    int j = 1 << i;
    int k = parami.g();
    int[][] arrayOfInt1 = new int[k][j];
    int[][] arrayOfInt2 = new int[k][j];
    for (int m = 0; m < j; m++) {
      arrayOfInt2[0][m] = paramb.f(parami.e(m));
    }
    int n;
    for (m = 1; m < k; m++) {
      for (n = 0; n < j; n++) {
        arrayOfInt2[m][n] = paramb.h(arrayOfInt2[(m - 1)][n], n);
      }
    }
    int i1;
    for (m = 0; m < k; m++) {
      for (n = 0; n < j; n++) {
        for (i1 = 0; i1 <= m; i1++) {
          arrayOfInt1[m][n] = paramb.a(arrayOfInt1[m][n], paramb.h(arrayOfInt2[i1][n], parami.f(k + i1 - m)));
        }
      }
    }
    paramb = new int[k * i][j + 31 >>> 5];
    for (m = 0; m < j; m++)
    {
      int i2 = m >>> 5;
      for (n = 0; n < k; n++)
      {
        int i3 = arrayOfInt1[n][m];
        for (i1 = 0; i1 < i; i1++) {
          if ((i3 >>> i1 & 0x1) != 0)
          {
            parami = paramb[((n + 1) * i - i1 - 1)];
            parami[i2] ^= 1 << (m & 0x1F);
          }
        }
      }
    }
    return new a(j, paramb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */