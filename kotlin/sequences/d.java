package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.r.a;

public final class d<T>
  implements f<T>
{
  private final f<T> a;
  private final boolean b;
  private final l<T, Boolean> c;
  
  public d(f<? extends T> paramf, boolean paramBoolean, l<? super T, Boolean> paraml)
  {
    this.a = paramf;
    this.b = paramBoolean;
    this.c = paraml;
  }
  
  public Iterator<T> iterator()
  {
    return new a(this);
  }
  
  public static final class a
    implements Iterator<T>, a
  {
    private final Iterator<T> c;
    private int d;
    private T f;
    
    a(d paramd)
    {
      this.c = d.c(paramd).iterator();
      this.d = -1;
    }
    
    private final void a()
    {
      while (this.c.hasNext())
      {
        Object localObject = this.c.next();
        if (((Boolean)d.a(this.q).invoke(localObject)).booleanValue() == d.b(this.q))
        {
          this.f = localObject;
          this.d = 1;
          return;
        }
      }
      this.d = 0;
    }
    
    public boolean hasNext()
    {
      if (this.d == -1) {
        a();
      }
      int i = this.d;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return bool;
    }
    
    public T next()
    {
      if (this.d == -1) {
        a();
      }
      if (this.d != 0)
      {
        Object localObject = this.f;
        this.f = null;
        this.d = -1;
        return (T)localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\sequences\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */