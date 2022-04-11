package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.r.a;

public final class m<T, R>
  implements f<R>
{
  private final f<T> a;
  private final l<T, R> b;
  
  public m(f<? extends T> paramf, l<? super T, ? extends R> paraml)
  {
    this.a = paramf;
    this.b = paraml;
  }
  
  public Iterator<R> iterator()
  {
    return new a(this);
  }
  
  public static final class a
    implements Iterator<R>, a
  {
    private final Iterator<T> c;
    
    a(m paramm)
    {
      this.c = m.a(paramm).iterator();
    }
    
    public boolean hasNext()
    {
      return this.c.hasNext();
    }
    
    public R next()
    {
      return (R)m.b(this.d).invoke(this.c.next());
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\sequences\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */