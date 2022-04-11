package kotlin.u;

import kotlin.jvm.internal.j;

public final class d
{
  public static final String a(Object paramObject1, Object paramObject2)
  {
    j.e(paramObject1, "from");
    j.e(paramObject2, "until");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Random range is empty: [");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramObject2);
    localStringBuilder.append(").");
    return localStringBuilder.toString();
  }
  
  public static final void b(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw new IllegalArgumentException(a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).toString());
  }
  
  public static final int c(int paramInt)
  {
    return 31 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  public static final int d(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 & -paramInt2 >> 31;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\u\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */