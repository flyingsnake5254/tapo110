package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract interface r1<K, V>
{
  public abstract Map<K, Collection<V>> asMap();
  
  public abstract void clear();
  
  public abstract boolean containsEntry(@CompatibleWith("K") @NullableDecl Object paramObject1, @CompatibleWith("V") @NullableDecl Object paramObject2);
  
  public abstract boolean containsKey(@CompatibleWith("K") @NullableDecl Object paramObject);
  
  public abstract Collection<Map.Entry<K, V>> entries();
  
  public abstract Collection<V> get(@NullableDecl K paramK);
  
  public abstract boolean isEmpty();
  
  public abstract Set<K> keySet();
  
  @CanIgnoreReturnValue
  public abstract boolean put(@NullableDecl K paramK, @NullableDecl V paramV);
  
  @CanIgnoreReturnValue
  public abstract boolean remove(@CompatibleWith("K") @NullableDecl Object paramObject1, @CompatibleWith("V") @NullableDecl Object paramObject2);
  
  @CanIgnoreReturnValue
  public abstract Collection<V> removeAll(@CompatibleWith("K") @NullableDecl Object paramObject);
  
  public abstract int size();
  
  public abstract Collection<V> values();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\r1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */