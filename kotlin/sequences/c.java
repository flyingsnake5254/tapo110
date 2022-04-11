package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.b.l;

public final class c<T, K>
  implements f<T>
{
  private final f<T> a;
  private final l<T, K> b;
  
  public c(f<? extends T> paramf, l<? super T, ? extends K> paraml)
  {
    this.a = paramf;
    this.b = paraml;
  }
  
  public Iterator<T> iterator()
  {
    return new b(this.a.iterator(), this.b);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\sequences\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */