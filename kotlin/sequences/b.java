package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.c;
import kotlin.jvm.b.l;

final class b<T, K>
  extends c<T>
{
  private final HashSet<K> f;
  private final Iterator<T> q;
  private final l<T, K> x;
  
  public b(Iterator<? extends T> paramIterator, l<? super T, ? extends K> paraml)
  {
    this.q = paramIterator;
    this.x = paraml;
    this.f = new HashSet();
  }
  
  protected void a()
  {
    while (this.q.hasNext())
    {
      Object localObject1 = this.q.next();
      Object localObject2 = this.x.invoke(localObject1);
      if (this.f.add(localObject2))
      {
        c(localObject1);
        return;
      }
    }
    b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\sequences\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */