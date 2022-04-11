package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.l.a.a;
import com.bumptech.glide.load.engine.z.e;

public final class b
  implements a.a
{
  private final e a;
  @Nullable
  private final com.bumptech.glide.load.engine.z.b b;
  
  public b(e parame, @Nullable com.bumptech.glide.load.engine.z.b paramb)
  {
    this.a = parame;
    this.b = paramb;
  }
  
  public void a(@NonNull Bitmap paramBitmap)
  {
    this.a.c(paramBitmap);
  }
  
  @NonNull
  public byte[] b(int paramInt)
  {
    com.bumptech.glide.load.engine.z.b localb = this.b;
    if (localb == null) {
      return new byte[paramInt];
    }
    return (byte[])localb.c(paramInt, byte[].class);
  }
  
  @NonNull
  public Bitmap c(int paramInt1, int paramInt2, @NonNull Bitmap.Config paramConfig)
  {
    return this.a.e(paramInt1, paramInt2, paramConfig);
  }
  
  @NonNull
  public int[] d(int paramInt)
  {
    com.bumptech.glide.load.engine.z.b localb = this.b;
    if (localb == null) {
      return new int[paramInt];
    }
    return (int[])localb.c(paramInt, int[].class);
  }
  
  public void e(@NonNull byte[] paramArrayOfByte)
  {
    com.bumptech.glide.load.engine.z.b localb = this.b;
    if (localb == null) {
      return;
    }
    localb.e(paramArrayOfByte);
  }
  
  public void f(@NonNull int[] paramArrayOfInt)
  {
    com.bumptech.glide.load.engine.z.b localb = this.b;
    if (localb == null) {
      return;
    }
    localb.e(paramArrayOfInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\gif\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */