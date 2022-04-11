package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.j;

class m
{
  public static final <T> Object[] a(T[] paramArrayOfT, boolean paramBoolean)
  {
    j.e(paramArrayOfT, "$this$copyToArrayOfAny");
    if ((!paramBoolean) || (!j.a(paramArrayOfT.getClass(), Object[].class)))
    {
      paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length, Object[].class);
      j.d(paramArrayOfT, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
    }
    return paramArrayOfT;
  }
  
  public static <T> List<T> b(T paramT)
  {
    paramT = Collections.singletonList(paramT);
    j.d(paramT, "java.util.Collections.singletonList(element)");
    return paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */