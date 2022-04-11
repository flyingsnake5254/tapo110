package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r.a;

class l
  extends k
{
  public static <T> Iterable<T> d(f<? extends T> paramf)
  {
    j.e(paramf, "$this$asIterable");
    return new a(paramf);
  }
  
  public static <T, K> f<T> e(f<? extends T> paramf, kotlin.jvm.b.l<? super T, ? extends K> paraml)
  {
    j.e(paramf, "$this$distinctBy");
    j.e(paraml, "selector");
    return new c(paramf, paraml);
  }
  
  public static <T> f<T> f(f<? extends T> paramf, kotlin.jvm.b.l<? super T, Boolean> paraml)
  {
    j.e(paramf, "$this$filterNot");
    j.e(paraml, "predicate");
    return new d(paramf, false, paraml);
  }
  
  public static <T, R> f<R> g(f<? extends T> paramf, kotlin.jvm.b.l<? super T, ? extends R> paraml)
  {
    j.e(paramf, "$this$map");
    j.e(paraml, "transform");
    return new m(paramf, paraml);
  }
  
  public static final <T, C extends Collection<? super T>> C h(f<? extends T> paramf, C paramC)
  {
    j.e(paramf, "$this$toCollection");
    j.e(paramC, "destination");
    paramf = paramf.iterator();
    while (paramf.hasNext()) {
      paramC.add(paramf.next());
    }
    return paramC;
  }
  
  public static <T> List<T> i(f<? extends T> paramf)
  {
    j.e(paramf, "$this$toList");
    return kotlin.collections.l.i(j(paramf));
  }
  
  public static final <T> List<T> j(f<? extends T> paramf)
  {
    j.e(paramf, "$this$toMutableList");
    return (List)h(paramf, new ArrayList());
  }
  
  public static final class a
    implements Iterable<T>, a
  {
    public a(f paramf) {}
    
    public Iterator<T> iterator()
    {
      return this.c.iterator();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\sequences\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */