package kotlin.collections;

import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.j;

class h0
  extends g0
{
  public static final <T> Set<T> b()
  {
    return EmptySet.INSTANCE;
  }
  
  public static final <T> Set<T> c(Set<? extends T> paramSet)
  {
    j.e(paramSet, "$this$optimizeReadOnlySet");
    int i = paramSet.size();
    if (i != 0)
    {
      if (i == 1) {
        paramSet = g0.a(paramSet.iterator().next());
      }
    }
    else {
      paramSet = b();
    }
    return paramSet;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */