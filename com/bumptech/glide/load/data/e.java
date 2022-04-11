package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

public abstract interface e<T>
{
  @NonNull
  public abstract T a()
    throws IOException;
  
  public abstract void b();
  
  public static abstract interface a<T>
  {
    @NonNull
    public abstract Class<T> a();
    
    @NonNull
    public abstract e<T> b(@NonNull T paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */