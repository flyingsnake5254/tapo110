package com.airbnb.lottie.w;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.s.c.a;

public class c<T>
{
  private final b<T> a = new b();
  @Nullable
  private a<?, ?> b;
  @Nullable
  protected T c = null;
  
  public c() {}
  
  public c(@Nullable T paramT)
  {
    this.c = paramT;
  }
  
  @Nullable
  public T a(b<T> paramb)
  {
    return (T)this.c;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public final T b(float paramFloat1, float paramFloat2, T paramT1, T paramT2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return (T)a(this.a.a(paramFloat1, paramFloat2, paramT1, paramT2, paramFloat3, paramFloat4, paramFloat5));
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public final void c(@Nullable a<?, ?> parama)
  {
    this.b = parama;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\w\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */