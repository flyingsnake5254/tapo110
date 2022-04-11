package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.z.e;
import java.security.MessageDigest;

public class j
  extends f
{
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(c.a);
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(b);
  }
  
  protected Bitmap c(@NonNull e parame, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return y.c(parame, paramBitmap, paramInt1, paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof j;
  }
  
  public int hashCode()
  {
    return -670243078;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */