package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.f;
import java.util.concurrent.locks.Lock;

final class l
{
  private static final com.bumptech.glide.load.engine.z.e a = new a();
  
  @Nullable
  static u<Bitmap> a(com.bumptech.glide.load.engine.z.e parame, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    paramDrawable = paramDrawable.getCurrent();
    boolean bool = paramDrawable instanceof BitmapDrawable;
    int i = 0;
    if (bool)
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      paramInt1 = i;
    }
    else if (!(paramDrawable instanceof Animatable))
    {
      paramDrawable = b(parame, paramDrawable, paramInt1, paramInt2);
      paramInt1 = 1;
    }
    else
    {
      paramDrawable = null;
      paramInt1 = i;
    }
    if (paramInt1 == 0) {
      parame = a;
    }
    return e.f(paramDrawable, parame);
  }
  
  @Nullable
  private static Bitmap b(com.bumptech.glide.load.engine.z.e parame, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == Integer.MIN_VALUE) && (paramDrawable.getIntrinsicWidth() <= 0))
    {
      if (Log.isLoggable("DrawableToBitmap", 5))
      {
        parame = new StringBuilder();
        parame.append("Unable to draw ");
        parame.append(paramDrawable);
        parame.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
        Log.w("DrawableToBitmap", parame.toString());
      }
      return null;
    }
    if ((paramInt2 == Integer.MIN_VALUE) && (paramDrawable.getIntrinsicHeight() <= 0))
    {
      if (Log.isLoggable("DrawableToBitmap", 5))
      {
        parame = new StringBuilder();
        parame.append("Unable to draw ");
        parame.append(paramDrawable);
        parame.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
        Log.w("DrawableToBitmap", parame.toString());
      }
      return null;
    }
    if (paramDrawable.getIntrinsicWidth() > 0) {
      paramInt1 = paramDrawable.getIntrinsicWidth();
    }
    if (paramDrawable.getIntrinsicHeight() > 0) {
      paramInt2 = paramDrawable.getIntrinsicHeight();
    }
    Lock localLock = y.h();
    localLock.lock();
    Bitmap localBitmap = parame.d(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    try
    {
      parame = new android/graphics/Canvas;
      parame.<init>(localBitmap);
      paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
      paramDrawable.draw(parame);
      parame.setBitmap(null);
      return localBitmap;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  class a
    extends f
  {
    public void c(Bitmap paramBitmap) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */