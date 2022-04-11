package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(api=28)
public final class r
  implements g<InputStream, Bitmap>
{
  private final d a = new d();
  
  @Nullable
  public u<Bitmap> c(@NonNull InputStream paramInputStream, int paramInt1, int paramInt2, @NonNull f paramf)
    throws IOException
  {
    paramInputStream = ImageDecoder.createSource(com.bumptech.glide.util.a.b(paramInputStream));
    return this.a.d(paramInputStream, paramInt1, paramInt2, paramf);
  }
  
  public boolean d(@NonNull InputStream paramInputStream, @NonNull f paramf)
    throws IOException
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */