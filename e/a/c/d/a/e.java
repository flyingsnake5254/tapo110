package e.a.c.d.a;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class e
{
  private static final BigInteger a = BigInteger.valueOf(0L);
  private static final BigInteger b = BigInteger.valueOf(1L);
  private static final BigInteger c = BigInteger.valueOf(2L);
  private static final BigInteger d = BigInteger.valueOf(4L);
  private static final int[] e = { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41 };
  private static SecureRandom f = null;
  private static final int[] g = { 0, 1, 0, -1, 0, -1, 0, 1 };
  
  public static int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = -paramInt;
    }
    paramInt = 0;
    while (i > 0)
    {
      paramInt++;
      i >>>= 8;
    }
    return paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */