package kotlin;

import java.io.Serializable;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

public final class UnsafeLazyImpl<T>
  implements f<T>, Serializable
{
  private Object _value;
  private a<? extends T> initializer;
  
  public UnsafeLazyImpl(a<? extends T> parama)
  {
    this.initializer = parama;
    this._value = o.a;
  }
  
  private final Object writeReplace()
  {
    return new InitializedLazyImpl(getValue());
  }
  
  public T getValue()
  {
    if (this._value == o.a)
    {
      a locala = this.initializer;
      j.c(locala);
      this._value = locala.invoke();
      this.initializer = null;
    }
    return (T)this._value;
  }
  
  public boolean isInitialized()
  {
    boolean bool;
    if (this._value != o.a) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    String str;
    if (isInitialized()) {
      str = String.valueOf(getValue());
    } else {
      str = "Lazy value not initialized yet.";
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\UnsafeLazyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */