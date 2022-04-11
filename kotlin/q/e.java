package kotlin.q;

import java.util.Comparator;
import kotlin.jvm.internal.j;

final class e
  implements Comparator<Comparable<? super Object>>
{
  public static final e c = new e();
  
  public int a(Comparable<Object> paramComparable1, Comparable<Object> paramComparable2)
  {
    j.e(paramComparable1, "a");
    j.e(paramComparable2, "b");
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return f.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\q\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */