package kotlin.jvm.internal;

import java.util.Iterator;

public final class b
{
  public static final <T> Iterator<T> a(T[] paramArrayOfT)
  {
    j.e(paramArrayOfT, "array");
    return new a(paramArrayOfT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */