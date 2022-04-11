package b.d.d.m;

import androidx.annotation.Nullable;

public class f<T>
{
  private T a;
  private boolean b = false;
  
  public f(T paramT)
  {
    if (paramT != null)
    {
      this.a = paramT;
      return;
    }
    throw new IllegalArgumentException("null values in Event are not allowed.");
  }
  
  @Nullable
  public T a()
  {
    if (this.b) {
      return null;
    }
    this.b = true;
    return (T)this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\m\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */