package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Map;

final class SoftReferenceMap<K, V>
  extends ReferenceMap<K, V>
{
  SoftReferenceMap(Map<K, Reference<V>> paramMap)
  {
    super(paramMap);
  }
  
  Reference<V> fold(V paramV)
  {
    return new SoftReference(paramV);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\SoftReferenceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */