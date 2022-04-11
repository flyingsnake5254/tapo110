package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;

class s
  extends r
{
  public static <T> boolean p(Collection<? super T> paramCollection, Iterable<? extends T> paramIterable)
  {
    j.e(paramCollection, "$this$addAll");
    j.e(paramIterable, "elements");
    if ((paramIterable instanceof Collection)) {
      return paramCollection.addAll((Collection)paramIterable);
    }
    boolean bool = false;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (paramCollection.add(paramIterable.next())) {
        bool = true;
      }
    }
    return bool;
  }
  
  private static final <T> boolean q(Iterable<? extends T> paramIterable, kotlin.jvm.b.l<? super T, Boolean> paraml, boolean paramBoolean)
  {
    paramIterable = paramIterable.iterator();
    boolean bool = false;
    while (paramIterable.hasNext()) {
      if (((Boolean)paraml.invoke(paramIterable.next())).booleanValue() == paramBoolean)
      {
        paramIterable.remove();
        bool = true;
      }
    }
    return bool;
  }
  
  public static <T> T r(List<T> paramList)
  {
    j.e(paramList, "$this$removeLast");
    if (!paramList.isEmpty()) {
      return (T)paramList.remove(l.f(paramList));
    }
    throw new NoSuchElementException("List is empty.");
  }
  
  public static <T> boolean s(Iterable<? extends T> paramIterable, kotlin.jvm.b.l<? super T, Boolean> paraml)
  {
    j.e(paramIterable, "$this$retainAll");
    j.e(paraml, "predicate");
    return q(paramIterable, paraml, false);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */