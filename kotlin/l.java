package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.b.a;

final class l<T>
  implements f<T>, Serializable
{
  private static final AtomicReferenceFieldUpdater<l<?>, Object> c = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "q");
  public static final a d = new a(null);
  private volatile a<? extends T> f;
  private volatile Object q;
  private final Object x;
  
  public l(a<? extends T> parama)
  {
    this.f = parama;
    parama = o.a;
    this.q = parama;
    this.x = parama;
  }
  
  public boolean a()
  {
    boolean bool;
    if (this.q != o.a) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public T getValue()
  {
    Object localObject = this.q;
    o localo = o.a;
    if (localObject != localo) {
      return (T)localObject;
    }
    localObject = this.f;
    if (localObject != null)
    {
      localObject = ((a)localObject).invoke();
      if (c.compareAndSet(this, localo, localObject))
      {
        this.f = null;
        return (T)localObject;
      }
    }
    return (T)this.q;
  }
  
  public String toString()
  {
    String str;
    if (a()) {
      str = String.valueOf(getValue());
    } else {
      str = "Lazy value not initialized yet.";
    }
    return str;
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */