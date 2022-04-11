package com.google.android.datatransport.h.u.a;

public final class c<T>
  implements b<T>
{
  private static final c<Object> a = new c(null);
  private final T b;
  
  private c(T paramT)
  {
    this.b = paramT;
  }
  
  public static <T> b<T> a(T paramT)
  {
    return new c(d.c(paramT, "instance cannot be null"));
  }
  
  public T get()
  {
    return (T)this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\u\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */