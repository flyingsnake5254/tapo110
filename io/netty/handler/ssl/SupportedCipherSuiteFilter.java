package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class SupportedCipherSuiteFilter
  implements CipherSuiteFilter
{
  public static final SupportedCipherSuiteFilter INSTANCE = new SupportedCipherSuiteFilter();
  
  public String[] filterCipherSuites(Iterable<String> paramIterable, List<String> paramList, Set<String> paramSet)
  {
    ObjectUtil.checkNotNull(paramList, "defaultCiphers");
    ObjectUtil.checkNotNull(paramSet, "supportedCiphers");
    Object localObject;
    if (paramIterable == null)
    {
      localObject = new ArrayList(paramList.size());
      paramIterable = paramList;
      paramList = (List<String>)localObject;
    }
    else
    {
      paramList = new ArrayList(paramSet.size());
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localObject = (String)paramIterable.next();
      if (localObject == null) {
        break;
      }
      if (paramSet.contains(localObject)) {
        paramList.add(localObject);
      }
    }
    return (String[])paramList.toArray(new String[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SupportedCipherSuiteFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */