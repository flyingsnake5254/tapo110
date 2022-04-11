package com.google.common.base;

import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class a<T>
  extends Optional<T>
{
  static final a<Object> c = new a();
  
  static <T> Optional<T> a()
  {
    return c;
  }
  
  public Set<T> asSet()
  {
    return Collections.emptySet();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool;
    if (paramObject == this) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public T get()
  {
    throw new IllegalStateException("Optional.get() cannot be called on an absent value");
  }
  
  public int hashCode()
  {
    return 2040732332;
  }
  
  public boolean isPresent()
  {
    return false;
  }
  
  public Optional<T> or(Optional<? extends T> paramOptional)
  {
    return (Optional)n.o(paramOptional);
  }
  
  public T or(t<? extends T> paramt)
  {
    return (T)n.p(paramt.get(), "use Optional.orNull() instead of a Supplier that returns null");
  }
  
  public T or(T paramT)
  {
    return (T)n.p(paramT, "use Optional.orNull() instead of Optional.or(null)");
  }
  
  @NullableDecl
  public T orNull()
  {
    return null;
  }
  
  public String toString()
  {
    return "Optional.absent()";
  }
  
  public <V> Optional<V> transform(h<? super T, V> paramh)
  {
    n.o(paramh);
    return Optional.absent();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */