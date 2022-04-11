package com.bumptech.glide.load.k.e;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;

final class c
  extends b<Drawable>
{
  private c(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  @Nullable
  static u<Drawable> f(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable = new c(paramDrawable);
    } else {
      paramDrawable = null;
    }
    return paramDrawable;
  }
  
  public int a()
  {
    return Math.max(1, this.c.getIntrinsicWidth() * this.c.getIntrinsicHeight() * 4);
  }
  
  public void c() {}
  
  @NonNull
  public Class<Drawable> e()
  {
    return this.c.getClass();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */