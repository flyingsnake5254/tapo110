package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V>
  extends ArrayMap<K, V>
{
  private int c;
  
  public void clear()
  {
    this.c = 0;
    super.clear();
  }
  
  public int hashCode()
  {
    if (this.c == 0) {
      this.c = super.hashCode();
    }
    return this.c;
  }
  
  public V put(K paramK, V paramV)
  {
    this.c = 0;
    return (V)super.put(paramK, paramV);
  }
  
  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap)
  {
    this.c = 0;
    super.putAll(paramSimpleArrayMap);
  }
  
  public V removeAt(int paramInt)
  {
    this.c = 0;
    return (V)super.removeAt(paramInt);
  }
  
  public V setValueAt(int paramInt, V paramV)
  {
    this.c = 0;
    return (V)super.setValueAt(paramInt, paramV);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\CachedHashCodeArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */