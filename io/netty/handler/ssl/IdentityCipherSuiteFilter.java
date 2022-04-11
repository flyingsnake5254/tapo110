package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class IdentityCipherSuiteFilter
  implements CipherSuiteFilter
{
  public static final IdentityCipherSuiteFilter INSTANCE = new IdentityCipherSuiteFilter(true);
  public static final IdentityCipherSuiteFilter INSTANCE_DEFAULTING_TO_SUPPORTED_CIPHERS = new IdentityCipherSuiteFilter(false);
  private final boolean defaultToDefaultCiphers;
  
  private IdentityCipherSuiteFilter(boolean paramBoolean)
  {
    this.defaultToDefaultCiphers = paramBoolean;
  }
  
  public String[] filterCipherSuites(Iterable<String> paramIterable, List<String> paramList, Set<String> paramSet)
  {
    if (paramIterable == null)
    {
      if (this.defaultToDefaultCiphers) {
        paramIterable = (String[])paramList.toArray(new String[0]);
      } else {
        paramIterable = (String[])paramSet.toArray(new String[0]);
      }
      return paramIterable;
    }
    paramList = new ArrayList(paramSet.size());
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramSet = (String)paramIterable.next();
      if (paramSet == null) {
        break;
      }
      paramList.add(paramSet);
    }
    return (String[])paramList.toArray(new String[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\IdentityCipherSuiteFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */