package io.netty.util.collection;

import java.util.Map;

public abstract interface CharObjectMap<V>
  extends Map<Character, V>
{
  public abstract boolean containsKey(char paramChar);
  
  public abstract Iterable<PrimitiveEntry<V>> entries();
  
  public abstract V get(char paramChar);
  
  public abstract V put(char paramChar, V paramV);
  
  public abstract V remove(char paramChar);
  
  public static abstract interface PrimitiveEntry<V>
  {
    public abstract char key();
    
    public abstract void setValue(V paramV);
    
    public abstract V value();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\CharObjectMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */