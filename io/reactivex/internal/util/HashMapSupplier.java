package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public enum HashMapSupplier
  implements Callable<Map<Object, Object>>
{
  static
  {
    HashMapSupplier localHashMapSupplier = new HashMapSupplier("INSTANCE", 0);
    INSTANCE = localHashMapSupplier;
    $VALUES = new HashMapSupplier[] { localHashMapSupplier };
  }
  
  public static <K, V> Callable<Map<K, V>> asCallable()
  {
    return INSTANCE;
  }
  
  public Map<Object, Object> call()
    throws Exception
  {
    return new HashMap();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\HashMapSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */