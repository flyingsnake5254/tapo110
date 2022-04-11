package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.i;

public final class s
  implements u<BitmapDrawable>, q
{
  private final Resources c;
  private final u<Bitmap> d;
  
  private s(@NonNull Resources paramResources, @NonNull u<Bitmap> paramu)
  {
    this.c = ((Resources)i.d(paramResources));
    this.d = ((u)i.d(paramu));
  }
  
  @Nullable
  public static u<BitmapDrawable> f(@NonNull Resources paramResources, @Nullable u<Bitmap> paramu)
  {
    if (paramu == null) {
      return null;
    }
    return new s(paramResources, paramu);
  }
  
  public int a()
  {
    return this.d.a();
  }
  
  public void b()
  {
    u localu = this.d;
    if ((localu instanceof q)) {
      ((q)localu).b();
    }
  }
  
  public void c()
  {
    this.d.c();
  }
  
  @NonNull
  public BitmapDrawable d()
  {
    return new BitmapDrawable(this.c, (Bitmap)this.d.get());
  }
  
  @NonNull
  public Class<BitmapDrawable> e()
  {
    return BitmapDrawable.class;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */