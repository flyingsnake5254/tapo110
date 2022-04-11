package kotlin.q;

import java.util.Comparator;
import java.util.Objects;

class b
{
  public static <T extends Comparable<?>> int a(T paramT1, T paramT2)
  {
    if (paramT1 == paramT2) {
      return 0;
    }
    if (paramT1 == null) {
      return -1;
    }
    if (paramT2 == null) {
      return 1;
    }
    return paramT1.compareTo(paramT2);
  }
  
  public static <T extends Comparable<? super T>> Comparator<T> b()
  {
    f localf = f.c;
    Objects.requireNonNull(localf, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    return localf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\q\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */