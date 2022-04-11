package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

final class e<T>
  implements f<T>
{
  private final kotlin.jvm.b.a<T> a;
  private final l<T, T> b;
  
  public e(kotlin.jvm.b.a<? extends T> parama, l<? super T, ? extends T> paraml)
  {
    this.a = parama;
    this.b = paraml;
  }
  
  public Iterator<T> iterator()
  {
    return new a(this);
  }
  
  public static final class a
    implements Iterator<T>, kotlin.jvm.internal.r.a
  {
    private T c;
    private int d = -2;
    
    a(e parame) {}
    
    private final void a()
    {
      Object localObject;
      if (this.d == -2)
      {
        localObject = e.a(this.f).invoke();
      }
      else
      {
        l locall = e.b(this.f);
        localObject = this.c;
        j.c(localObject);
        localObject = locall.invoke(localObject);
      }
      this.c = localObject;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = 1;
      }
      this.d = i;
    }
    
    public boolean hasNext()
    {
      if (this.d < 0) {
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
      if (this.d < 0) {
        a();
      }
      if (this.d != 0)
      {
        Object localObject = this.c;
        Objects.requireNonNull(localObject, "null cannot be cast to non-null type T");
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\sequences\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */