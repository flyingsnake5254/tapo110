package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

class o
  extends n
{
  public static <T> int l(Iterable<? extends T> paramIterable, int paramInt)
  {
    j.e(paramIterable, "$this$collectionSizeOrDefault");
    if ((paramIterable instanceof Collection)) {
      paramInt = ((Collection)paramIterable).size();
    }
    return paramInt;
  }
  
  public static <T> List<T> m(Iterable<? extends Iterable<? extends T>> paramIterable)
  {
    j.e(paramIterable, "$this$flatten");
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      l.p(localArrayList, (Iterable)paramIterable.next());
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */