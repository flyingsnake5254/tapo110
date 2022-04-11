package io.reactivex.internal.util;

import io.reactivex.g0.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public enum ArrayListSupplier
  implements Callable<List<Object>>, j<Object, List<Object>>
{
  static
  {
    ArrayListSupplier localArrayListSupplier = new ArrayListSupplier("INSTANCE", 0);
    INSTANCE = localArrayListSupplier;
    $VALUES = new ArrayListSupplier[] { localArrayListSupplier };
  }
  
  public static <T> Callable<List<T>> asCallable()
  {
    return INSTANCE;
  }
  
  public static <T, O> j<O, List<T>> asFunction()
  {
    return INSTANCE;
  }
  
  public List<Object> apply(Object paramObject)
    throws Exception
  {
    return new ArrayList();
  }
  
  public List<Object> call()
    throws Exception
  {
    return new ArrayList();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\ArrayListSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */