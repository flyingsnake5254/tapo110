package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class c<T>
{
  public static <T> c<T> d(T paramT)
  {
    return new a(null, paramT, Priority.DEFAULT);
  }
  
  public static <T> c<T> e(T paramT)
  {
    return new a(null, paramT, Priority.VERY_LOW);
  }
  
  public static <T> c<T> f(T paramT)
  {
    return new a(null, paramT, Priority.HIGHEST);
  }
  
  @Nullable
  public abstract Integer a();
  
  public abstract T b();
  
  public abstract Priority c();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */