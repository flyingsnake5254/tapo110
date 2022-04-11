package com.bumptech.glide.load.k.g;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public final class c
  implements e<Drawable, byte[]>
{
  private final com.bumptech.glide.load.engine.z.e a;
  private final e<Bitmap, byte[]> b;
  private final e<GifDrawable, byte[]> c;
  
  public c(@NonNull com.bumptech.glide.load.engine.z.e parame, @NonNull e<Bitmap, byte[]> parame1, @NonNull e<GifDrawable, byte[]> parame2)
  {
    this.a = parame;
    this.b = parame1;
    this.c = parame2;
  }
  
  @NonNull
  private static u<GifDrawable> b(@NonNull u<Drawable> paramu)
  {
    return paramu;
  }
  
  @Nullable
  public u<byte[]> a(@NonNull u<Drawable> paramu, @NonNull f paramf)
  {
    Drawable localDrawable = (Drawable)paramu.get();
    if ((localDrawable instanceof BitmapDrawable)) {
      return this.b.a(com.bumptech.glide.load.resource.bitmap.e.f(((BitmapDrawable)localDrawable).getBitmap(), this.a), paramf);
    }
    if ((localDrawable instanceof GifDrawable)) {
      return this.c.a(b(paramu), paramf);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */