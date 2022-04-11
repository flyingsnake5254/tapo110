package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.j;

class r
  extends q
{
  public static <T extends Comparable<? super T>> void n(List<T> paramList)
  {
    j.e(paramList, "$this$sort");
    if (paramList.size() > 1) {
      Collections.sort(paramList);
    }
  }
  
  public static <T> void o(List<T> paramList, Comparator<? super T> paramComparator)
  {
    j.e(paramList, "$this$sortWith");
    j.e(paramComparator, "comparator");
    if (paramList.size() > 1) {
      Collections.sort(paramList, paramComparator);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */