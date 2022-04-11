package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.z.e;
import java.security.MessageDigest;

public class o
  extends f
{
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(c.a);
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(b);
  }
  
  protected Bitmap c(@NonNull e parame, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return y.e(parame, paramBitmap, paramInt1, paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof o;
  }
  
  public int hashCode()
  {
    return 1572326941;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */