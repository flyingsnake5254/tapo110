package com.google.common.collect;

import com.google.common.base.h;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class a2<T>
  implements Comparator<T>
{
  public static <T> a2<T> a(Comparator<T> paramComparator)
  {
    if ((paramComparator instanceof a2)) {
      paramComparator = (a2)paramComparator;
    } else {
      paramComparator = new b0(paramComparator);
    }
    return paramComparator;
  }
  
  public static <C extends Comparable> a2<C> g()
  {
    return w1.c;
  }
  
  public <E extends T> ImmutableList<E> b(Iterable<E> paramIterable)
  {
    return ImmutableList.sortedCopyOf(this, paramIterable);
  }
  
  @CanIgnoreReturnValue
  public abstract int compare(@NullableDecl T paramT1, @NullableDecl T paramT2);
  
  public <E extends T> E d(@NullableDecl E paramE1, @NullableDecl E paramE2)
  {
    if (compare(paramE1, paramE2) < 0) {
      paramE1 = paramE2;
    }
    return paramE1;
  }
  
  public <E extends T> E f(@NullableDecl E paramE1, @NullableDecl E paramE2)
  {
    if (compare(paramE1, paramE2) > 0) {
      paramE1 = paramE2;
    }
    return paramE1;
  }
  
  <T2 extends T> a2<Map.Entry<T2, ?>> h()
  {
    return i(q1.k());
  }
  
  public <F> a2<F> i(h<F, ? extends T> paramh)
  {
    return new u(paramh, this);
  }
  
  public <S extends T> a2<S> j()
  {
    return new q2(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\a2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */