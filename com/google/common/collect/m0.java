package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.n;
import com.google.common.base.o;
import java.util.Iterator;

public abstract class m0<E>
  implements Iterable<E>
{
  private final Optional<Iterable<E>> c;
  
  protected m0()
  {
    this.c = Optional.absent();
  }
  
  m0(Iterable<E> paramIterable)
  {
    n.o(paramIterable);
    if (this == paramIterable) {
      paramIterable = null;
    }
    this.c = Optional.fromNullable(paramIterable);
  }
  
  public static <T> m0<T> a(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    return b(new Iterable[] { paramIterable1, paramIterable2 });
  }
  
  private static <T> m0<T> b(Iterable<? extends T>... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      n.o(paramVarArgs[j]);
    }
    return new b(paramVarArgs);
  }
  
  public static <E> m0<E> d(final Iterable<E> paramIterable)
  {
    if ((paramIterable instanceof m0)) {
      paramIterable = (m0)paramIterable;
    } else {
      paramIterable = new a(paramIterable, paramIterable);
    }
    return paramIterable;
  }
  
  private Iterable<E> e()
  {
    return (Iterable)this.c.or(this);
  }
  
  public final m0<E> c(o<? super E> paramo)
  {
    return d(j1.d(e(), paramo));
  }
  
  public final ImmutableSet<E> f()
  {
    return ImmutableSet.copyOf(e());
  }
  
  public String toString()
  {
    return j1.n(e());
  }
  
  static final class a
    extends m0<E>
  {
    a(Iterable paramIterable1, Iterable paramIterable2)
    {
      super();
    }
    
    public Iterator<E> iterator()
    {
      return paramIterable.iterator();
    }
  }
  
  static final class b
    extends m0<T>
  {
    b(Iterable[] paramArrayOfIterable) {}
    
    public Iterator<T> iterator()
    {
      return k1.e(new a(this.d.length));
    }
    
    class a
      extends b<Iterator<? extends T>>
    {
      a(int paramInt)
      {
        super();
      }
      
      public Iterator<? extends T> b(int paramInt)
      {
        return m0.b.this.d[paramInt].iterator();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\m0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */