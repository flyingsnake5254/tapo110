package com.google.common.collect;

import com.google.common.base.n;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class u0<E>
  extends n0<E>
  implements Set<E>
{
  protected abstract Set<E> delegate();
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool;
    if ((paramObject != this) && (!delegate().equals(paramObject))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  protected boolean standardEquals(@NullableDecl Object paramObject)
  {
    return u2.a(this, paramObject);
  }
  
  protected int standardHashCode()
  {
    return u2.b(this);
  }
  
  protected boolean standardRemoveAll(Collection<?> paramCollection)
  {
    return u2.g(this, (Collection)n.o(paramCollection));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\u0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */