package io.netty.util.collection;

import java.util.Map;

public abstract interface IntObjectMap<V>
  extends Map<Integer, V>
{
  public abstract boolean containsKey(int paramInt);
  
  public abstract Iterable<PrimitiveEntry<V>> entries();
  
  public abstract V get(int paramInt);
  
  public abstract V put(int paramInt, V paramV);
  
  public abstract V remove(int paramInt);
  
  public static abstract interface PrimitiveEntry<V>
  {
    public abstract int key();
    
    public abstract void setValue(V paramV);
    
    public abstract V value();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\IntObjectMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */