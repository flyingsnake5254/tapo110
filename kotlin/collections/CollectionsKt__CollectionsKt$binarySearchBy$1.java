package kotlin.collections;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.q.a;

public final class CollectionsKt__CollectionsKt$binarySearchBy$1
  extends Lambda
  implements l<T, Integer>
{
  public CollectionsKt__CollectionsKt$binarySearchBy$1(l paraml, Comparable paramComparable)
  {
    super(1);
  }
  
  public final int invoke(T paramT)
  {
    return a.a((Comparable)this.$selector.invoke(paramT), this.$key);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\CollectionsKt__CollectionsKt$binarySearchBy$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */