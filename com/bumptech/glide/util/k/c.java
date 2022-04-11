package com.bumptech.glide.util.k;

import androidx.annotation.NonNull;

public abstract class c
{
  @NonNull
  public static c a()
  {
    return new b();
  }
  
  abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  private static class b
    extends c
  {
    private volatile boolean a;
    
    b()
    {
      super();
    }
    
    public void b(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public void c()
    {
      if (!this.a) {
        return;
      }
      throw new IllegalStateException("Already released");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\k\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */