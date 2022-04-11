package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.k.j;

public abstract interface f<R>
{
  public abstract boolean g(@Nullable GlideException paramGlideException, Object paramObject, j<R> paramj, boolean paramBoolean);
  
  public abstract boolean i(R paramR, Object paramObject, j<R> paramj, DataSource paramDataSource, boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */