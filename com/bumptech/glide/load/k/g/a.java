package com.bumptech.glide.load.k.g;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.k.d.b;
import java.io.ByteArrayOutputStream;

public class a
  implements e<Bitmap, byte[]>
{
  private final Bitmap.CompressFormat a;
  private final int b;
  
  public a()
  {
    this(Bitmap.CompressFormat.JPEG, 100);
  }
  
  public a(@NonNull Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    this.a = paramCompressFormat;
    this.b = paramInt;
  }
  
  @Nullable
  public u<byte[]> a(@NonNull u<Bitmap> paramu, @NonNull f paramf)
  {
    paramf = new ByteArrayOutputStream();
    ((Bitmap)paramu.get()).compress(this.a, this.b, paramf);
    paramu.c();
    return new b(paramf.toByteArray());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */