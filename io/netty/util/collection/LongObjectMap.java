package io.netty.util.collection;

import java.util.Map;

public abstract interface LongObjectMap<V>
  extends Map<Long, V>
{
  public abstract boolean containsKey(long paramLong);
  
  public abstract Iterable<PrimitiveEntry<V>> entries();
  
  public abstract V get(long paramLong);
  
  public abstract V put(long paramLong, V paramV);
  
  public abstract V remove(long paramLong);
  
  public static abstract interface PrimitiveEntry<V>
  {
    public abstract long key();
    
    public abstract void setValue(V paramV);
    
    public abstract V value();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\LongObjectMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */