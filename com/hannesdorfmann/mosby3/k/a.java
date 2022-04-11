package com.hannesdorfmann.mosby3.k;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

public abstract interface a<V extends b>
{
  @UiThread
  public abstract void a(@NonNull V paramV);
  
  @UiThread
  public abstract void b();
  
  @UiThread
  public abstract void destroy();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */