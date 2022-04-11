package com.bumptech.glide.load.k.g;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.bitmap.s;
import com.bumptech.glide.util.i;

public class b
  implements e<Bitmap, BitmapDrawable>
{
  private final Resources a;
  
  public b(@NonNull Resources paramResources)
  {
    this.a = ((Resources)i.d(paramResources));
  }
  
  @Nullable
  public u<BitmapDrawable> a(@NonNull u<Bitmap> paramu, @NonNull f paramf)
  {
    return s.f(this.a, paramu);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */