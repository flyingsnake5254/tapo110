package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

final class WeakReferenceMap<K, V>
  extends ReferenceMap<K, V>
{
  WeakReferenceMap(Map<K, Reference<V>> paramMap)
  {
    super(paramMap);
  }
  
  Reference<V> fold(V paramV)
  {
    return new WeakReference(paramV);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\WeakReferenceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */