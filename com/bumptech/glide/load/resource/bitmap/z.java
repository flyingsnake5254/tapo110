package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.j;

public final class z
  implements g<Bitmap, Bitmap>
{
  public u<Bitmap> c(@NonNull Bitmap paramBitmap, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return new a(paramBitmap);
  }
  
  public boolean d(@NonNull Bitmap paramBitmap, @NonNull f paramf)
  {
    return true;
  }
  
  private static final class a
    implements u<Bitmap>
  {
    private final Bitmap c;
    
    a(@NonNull Bitmap paramBitmap)
    {
      this.c = paramBitmap;
    }
    
    public int a()
    {
      return j.h(this.c);
    }
    
    @NonNull
    public Bitmap b()
    {
      return this.c;
    }
    
    public void c() {}
    
    @NonNull
    public Class<Bitmap> e()
    {
      return Bitmap.class;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */