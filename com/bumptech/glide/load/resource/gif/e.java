package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import java.security.MessageDigest;

public class e
  implements com.bumptech.glide.load.i<GifDrawable>
{
  private final com.bumptech.glide.load.i<Bitmap> b;
  
  public e(com.bumptech.glide.load.i<Bitmap> parami)
  {
    this.b = ((com.bumptech.glide.load.i)com.bumptech.glide.util.i.d(parami));
  }
  
  @NonNull
  public u<GifDrawable> a(@NonNull Context paramContext, @NonNull u<GifDrawable> paramu, int paramInt1, int paramInt2)
  {
    GifDrawable localGifDrawable = (GifDrawable)paramu.get();
    Object localObject = com.bumptech.glide.c.c(paramContext).f();
    localObject = new com.bumptech.glide.load.resource.bitmap.e(localGifDrawable.e(), (com.bumptech.glide.load.engine.z.e)localObject);
    paramContext = this.b.a(paramContext, (u)localObject, paramInt1, paramInt2);
    if (!localObject.equals(paramContext)) {
      ((u)localObject).c();
    }
    paramContext = (Bitmap)paramContext.get();
    localGifDrawable.m(this.b, paramContext);
    return paramu;
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    this.b.b(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      return this.b.equals(((e)paramObject).b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\gif\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */