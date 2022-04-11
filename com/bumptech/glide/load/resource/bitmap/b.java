package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import java.io.File;

public class b
  implements h<BitmapDrawable>
{
  private final com.bumptech.glide.load.engine.z.e a;
  private final h<Bitmap> b;
  
  public b(com.bumptech.glide.load.engine.z.e parame, h<Bitmap> paramh)
  {
    this.a = parame;
    this.b = paramh;
  }
  
  @NonNull
  public EncodeStrategy b(@NonNull f paramf)
  {
    return this.b.b(paramf);
  }
  
  public boolean c(@NonNull u<BitmapDrawable> paramu, @NonNull File paramFile, @NonNull f paramf)
  {
    return this.b.a(new e(((BitmapDrawable)paramu.get()).getBitmap(), this.a), paramFile, paramf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */