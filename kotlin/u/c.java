package kotlin.u;

import kotlin.internal.a;
import kotlin.internal.b;

public abstract class c
{
  private static final c a = b.a.b();
  public static final a b = new a(null);
  
  public abstract int b(int paramInt);
  
  public abstract int c();
  
  public int d(int paramInt1, int paramInt2)
  {
    d.b(paramInt1, paramInt2);
    int i = paramInt2 - paramInt1;
    if ((i <= 0) && (i != Integer.MIN_VALUE))
    {
      do
      {
        i = c();
      } while ((paramInt1 > i) || (paramInt2 <= i));
      return i;
    }
    if ((-i & i) == i)
    {
      paramInt2 = b(d.c(i));
    }
    else
    {
      int j;
      do
      {
        j = c() >>> 1;
        paramInt2 = j % i;
      } while (j - paramInt2 + (i - 1) < 0);
    }
    return paramInt1 + paramInt2;
  }
  
  public static final class a
    extends c
  {
    public int b(int paramInt)
    {
      return c.a().b(paramInt);
    }
    
    public int c()
    {
      return c.a().c();
    }
    
    public int d(int paramInt1, int paramInt2)
    {
      return c.a().d(paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\u\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */