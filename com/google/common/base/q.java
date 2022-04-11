package com.google.common.base;

import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class q<T>
  extends Optional<T>
{
  private final T c;
  
  q(T paramT)
  {
    this.c = paramT;
  }
  
  public Set<T> asSet()
  {
    return Collections.singleton(this.c);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof q))
    {
      paramObject = (q)paramObject;
      return this.c.equals(((q)paramObject).c);
    }
    return false;
  }
  
  public T get()
  {
    return (T)this.c;
  }
  
  public int hashCode()
  {
    return this.c.hashCode() + 1502476572;
  }
  
  public boolean isPresent()
  {
    return true;
  }
  
  public Optional<T> or(Optional<? extends T> paramOptional)
  {
    n.o(paramOptional);
    return this;
  }
  
  public T or(t<? extends T> paramt)
  {
    n.o(paramt);
    return (T)this.c;
  }
  
  public T or(T paramT)
  {
    n.p(paramT, "use Optional.orNull() instead of Optional.or(null)");
    return (T)this.c;
  }
  
  public T orNull()
  {
    return (T)this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Optional.of(");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public <V> Optional<V> transform(h<? super T, V> paramh)
  {
    return new q(n.p(paramh.apply(this.c), "the Function passed to Optional.transform() must not return null."));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */