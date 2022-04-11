package kotlin.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.j;

class d0
  extends c0
{
  public static int a(int paramInt)
  {
    if (paramInt >= 0) {
      if (paramInt < 3) {
        paramInt++;
      } else if (paramInt < 1073741824) {
        paramInt = (int)(paramInt / 0.75F + 1.0F);
      } else {
        paramInt = Integer.MAX_VALUE;
      }
    }
    return paramInt;
  }
  
  public static <K, V> Map<K, V> b(Pair<? extends K, ? extends V> paramPair)
  {
    j.e(paramPair, "pair");
    paramPair = Collections.singletonMap(paramPair.getFirst(), paramPair.getSecond());
    j.d(paramPair, "java.util.Collections.si…(pair.first, pair.second)");
    return paramPair;
  }
  
  public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> paramMap)
  {
    j.e(paramMap, "$this$toSingletonMap");
    paramMap = (Map.Entry)paramMap.entrySet().iterator().next();
    paramMap = Collections.singletonMap(paramMap.getKey(), paramMap.getValue());
    j.d(paramMap, "with(entries.iterator().…ingletonMap(key, value) }");
    return paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */