package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.l.a;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;

public final class g
  implements com.bumptech.glide.load.g<a, Bitmap>
{
  private final com.bumptech.glide.load.engine.z.e a;
  
  public g(com.bumptech.glide.load.engine.z.e parame)
  {
    this.a = parame;
  }
  
  public u<Bitmap> c(@NonNull a parama, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return com.bumptech.glide.load.resource.bitmap.e.f(parama.a(), this.a);
  }
  
  public boolean d(@NonNull a parama, @NonNull f paramf)
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\gif\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */