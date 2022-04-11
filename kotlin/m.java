package kotlin;

import java.io.Serializable;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

final class m<T>
  implements f<T>, Serializable
{
  private a<? extends T> c;
  private volatile Object d;
  private final Object f;
  
  public m(a<? extends T> parama, Object paramObject)
  {
    this.c = parama;
    this.d = o.a;
    if (paramObject == null) {
      paramObject = this;
    }
    this.f = paramObject;
  }
  
  public boolean a()
  {
    boolean bool;
    if (this.d != o.a) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public T getValue()
  {
    Object localObject1 = this.d;
    o localo = o.a;
    if (localObject1 != localo) {
      return (T)localObject1;
    }
    synchronized (this.f)
    {
      localObject1 = this.d;
      if (localObject1 == localo)
      {
        localObject1 = this.c;
        j.c(localObject1);
        localObject1 = ((a)localObject1).invoke();
        this.d = localObject1;
        this.c = null;
      }
      return (T)localObject1;
    }
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */