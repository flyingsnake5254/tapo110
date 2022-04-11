package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract interface u1<E>
  extends Collection<E>
{
  @CanIgnoreReturnValue
  public abstract int add(@NullableDecl E paramE, int paramInt);
  
  public abstract boolean contains(@NullableDecl Object paramObject);
  
  public abstract boolean containsAll(Collection<?> paramCollection);
  
  public abstract int count(@CompatibleWith("E") @NullableDecl Object paramObject);
  
  public abstract Set<E> elementSet();
  
  public abstract Set<a<E>> entrySet();
  
  public abstract boolean equals(@NullableDecl Object paramObject);
  
  public abstract int hashCode();
  
  @CanIgnoreReturnValue
  public abstract int remove(@CompatibleWith("E") @NullableDecl Object paramObject, int paramInt);
  
  @CanIgnoreReturnValue
  public abstract boolean remove(@NullableDecl Object paramObject);
  
  @CanIgnoreReturnValue
  public abstract int setCount(E paramE, int paramInt);
  
  @CanIgnoreReturnValue
  public abstract boolean setCount(E paramE, int paramInt1, int paramInt2);
  
  public abstract int size();
  
  public static abstract interface a<E>
  {
    public abstract E a();
    
    public abstract int getCount();
    
    public abstract String toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\u1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */