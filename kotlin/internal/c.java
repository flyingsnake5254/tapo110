package kotlin.internal;

public final class c
{
  private static final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return c(c(paramInt1, paramInt3) - c(paramInt2, paramInt3), paramInt3);
  }
  
  public static final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      if (paramInt1 < paramInt2) {
        paramInt2 -= a(paramInt2, paramInt1, paramInt3);
      }
    }
    else
    {
      if (paramInt3 >= 0) {
        break label48;
      }
      if (paramInt1 > paramInt2) {
        paramInt2 += a(paramInt1, paramInt2, -paramInt3);
      }
    }
    return paramInt2;
    label48:
    throw new IllegalArgumentException("Step is zero.");
  }
  
  private static final int c(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 < 0) {
      paramInt1 += paramInt2;
    }
    return paramInt1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\internal\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */