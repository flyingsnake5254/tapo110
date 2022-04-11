package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.annotation.NonNull;

public class f
  implements e
{
  public void a(int paramInt) {}
  
  public void b() {}
  
  public void c(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
  
  @NonNull
  public Bitmap d(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }
  
  @NonNull
  public Bitmap e(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return d(paramInt1, paramInt2, paramConfig);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\z\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */