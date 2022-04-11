package com.google.common.collect;

import com.google.common.base.n;
import java.util.Comparator;
import java.util.SortedSet;

final class y2
{
  public static <E> Comparator<? super E> a(SortedSet<E> paramSortedSet)
  {
    Comparator localComparator = paramSortedSet.comparator();
    paramSortedSet = localComparator;
    if (localComparator == null) {
      paramSortedSet = a2.g();
    }
    return paramSortedSet;
  }
  
  public static boolean b(Comparator<?> paramComparator, Iterable<?> paramIterable)
  {
    n.o(paramComparator);
    n.o(paramIterable);
    if ((paramIterable instanceof SortedSet))
    {
      paramIterable = a((SortedSet)paramIterable);
    }
    else
    {
      if (!(paramIterable instanceof x2)) {
        break label53;
      }
      paramIterable = ((x2)paramIterable).comparator();
    }
    return paramComparator.equals(paramIterable);
    label53:
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\y2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */