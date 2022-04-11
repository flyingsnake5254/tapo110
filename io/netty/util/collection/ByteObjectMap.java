package io.netty.util.collection;

import java.util.Map;

public abstract interface ByteObjectMap<V>
  extends Map<Byte, V>
{
  public abstract boolean containsKey(byte paramByte);
  
  public abstract Iterable<PrimitiveEntry<V>> entries();
  
  public abstract V get(byte paramByte);
  
  public abstract V put(byte paramByte, V paramV);
  
  public abstract V remove(byte paramByte);
  
  public static abstract interface PrimitiveEntry<V>
  {
    public abstract byte key();
    
    public abstract void setValue(V paramV);
    
    public abstract V value();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\ByteObjectMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */