package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.j;

class e0
  extends d0
{
  public static <K, V> Map<K, V> d()
  {
    x localx = x.c;
    Objects.requireNonNull(localx, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    return localx;
  }
  
  public static <K, V> HashMap<K, V> e(Pair<? extends K, ? extends V>... paramVarArgs)
  {
    j.e(paramVarArgs, "pairs");
    HashMap localHashMap = new HashMap(b0.a(paramVarArgs.length));
    j(localHashMap, paramVarArgs);
    return localHashMap;
  }
  
  public static <K, V> Map<K, V> f(Pair<? extends K, ? extends V>... paramVarArgs)
  {
    j.e(paramVarArgs, "pairs");
    if (paramVarArgs.length > 0) {
      paramVarArgs = m(paramVarArgs, new LinkedHashMap(b0.a(paramVarArgs.length)));
    } else {
      paramVarArgs = b0.d();
    }
    return paramVarArgs;
  }
  
  public static <K, V> Map<K, V> g(Pair<? extends K, ? extends V>... paramVarArgs)
  {
    j.e(paramVarArgs, "pairs");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(b0.a(paramVarArgs.length));
    j(localLinkedHashMap, paramVarArgs);
    return localLinkedHashMap;
  }
  
  public static final <K, V> Map<K, V> h(Map<K, ? extends V> paramMap)
  {
    j.e(paramMap, "$this$optimizeReadOnlyMap");
    int i = paramMap.size();
    if (i != 0)
    {
      if (i == 1) {
        paramMap = d0.c(paramMap);
      }
    }
    else {
      paramMap = b0.d();
    }
    return paramMap;
  }
  
  public static final <K, V> void i(Map<? super K, ? super V> paramMap, Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    j.e(paramMap, "$this$putAll");
    j.e(paramIterable, "pairs");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Pair localPair = (Pair)paramIterable.next();
      paramMap.put(localPair.component1(), localPair.component2());
    }
  }
  
  public static final <K, V> void j(Map<? super K, ? super V> paramMap, Pair<? extends K, ? extends V>[] paramArrayOfPair)
  {
    j.e(paramMap, "$this$putAll");
    j.e(paramArrayOfPair, "pairs");
    int i = paramArrayOfPair.length;
    for (int j = 0; j < i; j++)
    {
      Pair<? extends K, ? extends V> localPair = paramArrayOfPair[j];
      paramMap.put(localPair.component1(), localPair.component2());
    }
  }
  
  public static <K, V> Map<K, V> k(Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    j.e(paramIterable, "$this$toMap");
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      int i = localCollection.size();
      if (i != 0)
      {
        if (i != 1)
        {
          paramIterable = l(paramIterable, new LinkedHashMap(b0.a(localCollection.size())));
        }
        else
        {
          if ((paramIterable instanceof List)) {
            paramIterable = ((List)paramIterable).get(0);
          } else {
            paramIterable = paramIterable.iterator().next();
          }
          paramIterable = b0.b((Pair)paramIterable);
        }
      }
      else {
        paramIterable = b0.d();
      }
      return paramIterable;
    }
    return h(l(paramIterable, new LinkedHashMap()));
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M l(Iterable<? extends Pair<? extends K, ? extends V>> paramIterable, M paramM)
  {
    j.e(paramIterable, "$this$toMap");
    j.e(paramM, "destination");
    i(paramM, paramIterable);
    return paramM;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M m(Pair<? extends K, ? extends V>[] paramArrayOfPair, M paramM)
  {
    j.e(paramArrayOfPair, "$this$toMap");
    j.e(paramM, "destination");
    j(paramM, paramArrayOfPair);
    return paramM;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */