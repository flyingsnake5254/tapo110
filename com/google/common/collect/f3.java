package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract interface f3<R, C, V>
{
  public abstract Set<a<R, C, V>> cellSet();
  
  public abstract Set<C> columnKeySet();
  
  public abstract Map<C, Map<R, V>> columnMap();
  
  public abstract Set<R> rowKeySet();
  
  public abstract Map<R, Map<C, V>> rowMap();
  
  public abstract int size();
  
  public static abstract interface a<R, C, V>
  {
    @NullableDecl
    public abstract R a();
    
    @NullableDecl
    public abstract C b();
    
    @NullableDecl
    public abstract V getValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\f3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */