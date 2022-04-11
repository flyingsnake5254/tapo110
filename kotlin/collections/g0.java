package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.j;

class g0
{
  public static final <T> Set<T> a(T paramT)
  {
    paramT = Collections.singleton(paramT);
    j.d(paramT, "java.util.Collections.singleton(element)");
    return paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */