package com.bumptech.glide.load.k;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.i;

public class b<T>
  implements u<T>
{
  protected final T c;
  
  public b(@NonNull T paramT)
  {
    this.c = i.d(paramT);
  }
  
  public final int a()
  {
    return 1;
  }
  
  public void c() {}
  
  @NonNull
  public Class<T> e()
  {
    return this.c.getClass();
  }
  
  @NonNull
  public final T get()
  {
    return (T)this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */