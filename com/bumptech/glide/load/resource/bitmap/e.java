package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.j;

public class e
  implements u<Bitmap>, q
{
  private final Bitmap c;
  private final com.bumptech.glide.load.engine.z.e d;
  
  public e(@NonNull Bitmap paramBitmap, @NonNull com.bumptech.glide.load.engine.z.e parame)
  {
    this.c = ((Bitmap)i.e(paramBitmap, "Bitmap must not be null"));
    this.d = ((com.bumptech.glide.load.engine.z.e)i.e(parame, "BitmapPool must not be null"));
  }
  
  @Nullable
  public static e f(@Nullable Bitmap paramBitmap, @NonNull com.bumptech.glide.load.engine.z.e parame)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new e(paramBitmap, parame);
  }
  
  public int a()
  {
    return j.h(this.c);
  }
  
  public void b()
  {
    this.c.prepareToDraw();
  }
  
  public void c()
  {
    this.d.c(this.c);
  }
  
  @NonNull
  public Bitmap d()
  {
    return this.c;
  }
  
  @NonNull
  public Class<Bitmap> e()
  {
    return Bitmap.class;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */