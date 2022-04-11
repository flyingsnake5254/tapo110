package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.i;
import com.bumptech.glide.util.j;

public abstract class f
  implements i<Bitmap>
{
  @NonNull
  public final u<Bitmap> a(@NonNull Context paramContext, @NonNull u<Bitmap> paramu, int paramInt1, int paramInt2)
  {
    if (j.u(paramInt1, paramInt2))
    {
      com.bumptech.glide.load.engine.z.e locale = c.c(paramContext).f();
      Bitmap localBitmap = (Bitmap)paramu.get();
      int i = paramInt1;
      if (paramInt1 == Integer.MIN_VALUE) {
        i = localBitmap.getWidth();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == Integer.MIN_VALUE) {
        paramInt1 = localBitmap.getHeight();
      }
      paramContext = c(locale, localBitmap, i, paramInt1);
      if (!localBitmap.equals(paramContext)) {
        paramu = e.f(paramContext, locale);
      }
      return paramu;
    }
    paramContext = new StringBuilder();
    paramContext.append("Cannot apply transformation on width: ");
    paramContext.append(paramInt1);
    paramContext.append(" or height: ");
    paramContext.append(paramInt2);
    paramContext.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  protected abstract Bitmap c(@NonNull com.bumptech.glide.load.engine.z.e parame, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */