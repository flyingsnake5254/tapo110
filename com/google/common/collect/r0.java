package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class r0<E>
  extends n0<E>
  implements u1<E>
{
  protected abstract u1<E> a();
  
  @CanIgnoreReturnValue
  public int add(E paramE, int paramInt)
  {
    return a().add(paramE, paramInt);
  }
  
  public int count(Object paramObject)
  {
    return a().count(paramObject);
  }
  
  public abstract Set<u1.a<E>> entrySet();
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool;
    if ((paramObject != this) && (!a().equals(paramObject))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  
  @CanIgnoreReturnValue
  public int remove(Object paramObject, int paramInt)
  {
    return a().remove(paramObject, paramInt);
  }
  
  @CanIgnoreReturnValue
  public int setCount(E paramE, int paramInt)
  {
    return a().setCount(paramE, paramInt);
  }
  
  @CanIgnoreReturnValue
  public boolean setCount(E paramE, int paramInt1, int paramInt2)
  {
    return a().setCount(paramE, paramInt1, paramInt2);
  }
  
  protected boolean standardAddAll(Collection<? extends E> paramCollection)
  {
    return v1.c(this, paramCollection);
  }
  
  protected void standardClear()
  {
    k1.d(entrySet().iterator());
  }
  
  protected boolean standardContains(@NullableDecl Object paramObject)
  {
    boolean bool;
    if (count(paramObject) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean standardRemove(Object paramObject)
  {
    boolean bool = true;
    if (remove(paramObject, 1) <= 0) {
      bool = false;
    }
    return bool;
  }
  
  protected boolean standardRemoveAll(Collection<?> paramCollection)
  {
    return v1.j(this, paramCollection);
  }
  
  protected boolean standardRetainAll(Collection<?> paramCollection)
  {
    return v1.k(this, paramCollection);
  }
  
  protected String standardToString()
  {
    return entrySet().toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\r0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */