package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Optional<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  
  public static <T> Optional<T> absent()
  {
    return a.a();
  }
  
  public static <T> Optional<T> fromNullable(@NullableDecl T paramT)
  {
    if (paramT == null) {
      paramT = absent();
    } else {
      paramT = new q(paramT);
    }
    return paramT;
  }
  
  public static <T> Optional<T> of(T paramT)
  {
    return new q(n.o(paramT));
  }
  
  public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> paramIterable)
  {
    n.o(paramIterable);
    return new a(paramIterable);
  }
  
  public abstract Set<T> asSet();
  
  public abstract boolean equals(@NullableDecl Object paramObject);
  
  public abstract T get();
  
  public abstract int hashCode();
  
  public abstract boolean isPresent();
  
  public abstract Optional<T> or(Optional<? extends T> paramOptional);
  
  public abstract T or(t<? extends T> paramt);
  
  public abstract T or(T paramT);
  
  @NullableDecl
  public abstract T orNull();
  
  public abstract String toString();
  
  public abstract <V> Optional<V> transform(h<? super T, V> paramh);
  
  static final class a
    implements Iterable<T>
  {
    a(Iterable paramIterable) {}
    
    public Iterator<T> iterator()
    {
      return new a();
    }
    
    class a
      extends b<T>
    {
      private final Iterator<? extends Optional<? extends T>> f = (Iterator)n.o(Optional.a.this.c.iterator());
      
      a() {}
      
      protected T a()
      {
        while (this.f.hasNext())
        {
          Optional localOptional = (Optional)this.f.next();
          if (localOptional.isPresent()) {
            return (T)localOptional.get();
          }
        }
        return (T)b();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\Optional.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */