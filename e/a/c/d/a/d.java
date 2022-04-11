package e.a.c.d.a;

public final class d
{
  public static int[] a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public static boolean b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
      return false;
    }
    int i = paramArrayOfInt1.length - 1;
    boolean bool1 = true;
    while (i >= 0)
    {
      boolean bool2;
      if (paramArrayOfInt1[i] == paramArrayOfInt2[i]) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 &= bool2;
      i--;
    }
    return bool1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\d\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */