package io.reactivex.internal.util;

import io.reactivex.g0.c;
import java.util.List;

public enum ListAddBiConsumer
  implements c<List, Object, List>
{
  static
  {
    ListAddBiConsumer localListAddBiConsumer = new ListAddBiConsumer("INSTANCE", 0);
    INSTANCE = localListAddBiConsumer;
    $VALUES = new ListAddBiConsumer[] { localListAddBiConsumer };
  }
  
  public static <T> c<List<T>, T, List<T>> instance()
  {
    return INSTANCE;
  }
  
  public List apply(List paramList, Object paramObject)
    throws Exception
  {
    paramList.add(paramObject);
    return paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\ListAddBiConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */