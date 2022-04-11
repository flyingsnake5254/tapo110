package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ApplicationProtocolUtil
{
  private static final int DEFAULT_LIST_SIZE = 2;
  
  static List<String> toList(int paramInt, Iterable<String> paramIterable)
  {
    if (paramIterable == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = (String)localIterator.next();
      if ((paramIterable != null) && (!paramIterable.isEmpty())) {
        localArrayList.add(paramIterable);
      } else {
        throw new IllegalArgumentException("protocol cannot be null or empty");
      }
    }
    if (!localArrayList.isEmpty()) {
      return localArrayList;
    }
    throw new IllegalArgumentException("protocols cannot empty");
  }
  
  static List<String> toList(int paramInt, String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = paramVarArgs.length;
    paramInt = 0;
    while (paramInt < i)
    {
      String str = paramVarArgs[paramInt];
      if ((str != null) && (!str.isEmpty()))
      {
        localArrayList.add(str);
        paramInt++;
      }
      else
      {
        throw new IllegalArgumentException("protocol cannot be null or empty");
      }
    }
    if (!localArrayList.isEmpty()) {
      return localArrayList;
    }
    throw new IllegalArgumentException("protocols cannot empty");
  }
  
  static List<String> toList(Iterable<String> paramIterable)
  {
    return toList(2, paramIterable);
  }
  
  static List<String> toList(String... paramVarArgs)
  {
    return toList(2, paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ApplicationProtocolUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */