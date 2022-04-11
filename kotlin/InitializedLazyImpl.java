package kotlin;

import java.io.Serializable;

public final class InitializedLazyImpl<T>
  implements f<T>, Serializable
{
  private final T value;
  
  public InitializedLazyImpl(T paramT)
  {
    this.value = paramT;
  }
  
  public T getValue()
  {
    return (T)this.value;
  }
  
  public boolean isInitialized()
  {
    return true;
  }
  
  public String toString()
  {
    return String.valueOf(getValue());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\InitializedLazyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */