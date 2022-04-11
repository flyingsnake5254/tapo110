package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.j;

class f0
  extends e0
{
  public static <K, V> List<Pair<K, V>> n(Map<? extends K, ? extends V> paramMap)
  {
    j.e(paramMap, "$this$toList");
    if (paramMap.size() == 0) {
      return l.d();
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    if (!localIterator.hasNext()) {
      return l.d();
    }
    Map.Entry localEntry = (Map.Entry)localIterator.next();
    if (!localIterator.hasNext()) {
      return l.b(new Pair(localEntry.getKey(), localEntry.getValue()));
    }
    paramMap = new ArrayList(paramMap.size());
    paramMap.add(new Pair(localEntry.getKey(), localEntry.getValue()));
    do
    {
      localEntry = (Map.Entry)localIterator.next();
      paramMap.add(new Pair(localEntry.getKey(), localEntry.getValue()));
    } while (localIterator.hasNext());
    return paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */