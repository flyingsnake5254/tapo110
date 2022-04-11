package kotlinx.coroutines.internal;

import kotlin.TypeCastException;
import kotlin.collections.e;
import kotlin.jvm.internal.j;

public class a<T>
{
  private Object[] a = new Object[16];
  private int b;
  private int c;
  
  private final void b()
  {
    Object[] arrayOfObject1 = this.a;
    int i = arrayOfObject1.length;
    Object[] arrayOfObject2 = new Object[i << 1];
    e.d(arrayOfObject1, arrayOfObject2, 0, this.b, 0, 10, null);
    arrayOfObject1 = this.a;
    int j = arrayOfObject1.length;
    int k = this.b;
    e.d(arrayOfObject1, arrayOfObject2, j - k, 0, k, 4, null);
    this.a = arrayOfObject2;
    this.b = 0;
    this.c = i;
  }
  
  public final void a(T paramT)
  {
    j.f(paramT, "element");
    Object[] arrayOfObject = this.a;
    int i = this.c;
    arrayOfObject[i] = paramT;
    i = arrayOfObject.length - 1 & i + 1;
    this.c = i;
    if (i == this.b) {
      b();
    }
  }
  
  public final boolean c()
  {
    boolean bool;
    if (this.b == this.c) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final T d()
  {
    int i = this.b;
    if (i == this.c) {
      return null;
    }
    Object[] arrayOfObject = this.a;
    Object localObject = arrayOfObject[i];
    arrayOfObject[i] = null;
    this.b = (i + 1 & arrayOfObject.length - 1);
    if (localObject != null) {
      return (T)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type T");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */