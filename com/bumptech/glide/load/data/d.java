package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public abstract interface d<T>
{
  @NonNull
  public abstract Class<T> a();
  
  public abstract void b();
  
  public abstract void cancel();
  
  @NonNull
  public abstract DataSource d();
  
  public abstract void e(@NonNull Priority paramPriority, @NonNull a<? super T> parama);
  
  public static abstract interface a<T>
  {
    public abstract void c(@NonNull Exception paramException);
    
    public abstract void f(@Nullable T paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */