package com.bumptech.glide.load.engine;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;

abstract interface f
{
  public abstract boolean b();
  
  public abstract void cancel();
  
  public static abstract interface a
  {
    public abstract void a(c paramc, Exception paramException, d<?> paramd, DataSource paramDataSource);
    
    public abstract void c();
    
    public abstract void e(c paramc1, @Nullable Object paramObject, d<?> paramd, DataSource paramDataSource, c paramc2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */