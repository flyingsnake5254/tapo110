package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
  implements f<T>
{
  private final AtomicReference<f<T>> a;
  
  public a(f<? extends T> paramf)
  {
    this.a = new AtomicReference(paramf);
  }
  
  public Iterator<T> iterator()
  {
    f localf = (f)this.a.getAndSet(null);
    if (localf != null) {
      return localf.iterator();
    }
    throw new IllegalStateException("This sequence can be consumed only once.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\sequences\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */