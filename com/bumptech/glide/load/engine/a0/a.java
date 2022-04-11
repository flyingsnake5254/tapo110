package com.bumptech.glide.load.engine.a0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.c;
import java.io.File;

public abstract interface a
{
  public abstract void a(c paramc, b paramb);
  
  @Nullable
  public abstract File b(c paramc);
  
  public static abstract interface a
  {
    @Nullable
    public abstract a build();
  }
  
  public static abstract interface b
  {
    public abstract boolean a(@NonNull File paramFile);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\a0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */