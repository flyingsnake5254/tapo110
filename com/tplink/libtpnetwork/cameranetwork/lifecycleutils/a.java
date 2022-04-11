package com.tplink.libtpnetwork.cameranetwork.lifecycleutils;

import androidx.annotation.Nullable;

public class a<T>
{
  private T a;
  private boolean b = false;
  
  public a(T paramT)
  {
    if (paramT != null)
    {
      this.a = paramT;
      return;
    }
    throw new IllegalArgumentException("null values in Event are not allowed.");
  }
  
  public a(T paramT, boolean paramBoolean)
  {
    if (paramT != null)
    {
      this.a = paramT;
      this.b = paramBoolean;
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
  
  public boolean b()
  {
    return this.b;
  }
  
  public T c()
  {
    return (T)this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\lifecycleutils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */