package kotlin.q;

import java.util.Comparator;
import kotlin.jvm.internal.j;

final class f
  implements Comparator<Comparable<? super Object>>
{
  public static final f c = new f();
  
  public int a(Comparable<Object> paramComparable1, Comparable<Object> paramComparable2)
  {
    j.e(paramComparable1, "a");
    j.e(paramComparable2, "b");
    return paramComparable2.compareTo(paramComparable1);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return e.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\q\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */