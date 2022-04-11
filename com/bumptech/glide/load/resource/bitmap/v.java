package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.k.e.d;

public class v
  implements g<Uri, Bitmap>
{
  private final d a;
  private final e b;
  
  public v(d paramd, e parame)
  {
    this.a = paramd;
    this.b = parame;
  }
  
  @Nullable
  public u<Bitmap> c(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    paramUri = this.a.c(paramUri, paramInt1, paramInt2, paramf);
    if (paramUri == null) {
      return null;
    }
    paramUri = (Drawable)paramUri.get();
    return l.a(this.b, paramUri, paramInt1, paramInt2);
  }
  
  public boolean d(@NonNull Uri paramUri, @NonNull f paramf)
  {
    return "android.resource".equals(paramUri.getScheme());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */