package androidx.collection;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class ArrayMapKt
{
  public static final <K, V> ArrayMap<K, V> arrayMapOf()
  {
    return new ArrayMap();
  }
  
  public static final <K, V> ArrayMap<K, V> arrayMapOf(Pair<? extends K, ? extends V>... paramVarArgs)
  {
    j.f(paramVarArgs, "pairs");
    ArrayMap localArrayMap = new ArrayMap(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Pair<? extends K, ? extends V> localPair = paramVarArgs[j];
      localArrayMap.put(localPair.getFirst(), localPair.getSecond());
    }
    return localArrayMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\collection\ArrayMapKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */