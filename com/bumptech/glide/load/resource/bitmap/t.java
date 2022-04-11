package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;

@RequiresApi(21)
public final class t
  implements g<ParcelFileDescriptor, Bitmap>
{
  private final k a;
  
  public t(k paramk)
  {
    this.a = paramk;
  }
  
  @Nullable
  public u<Bitmap> c(@NonNull ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, @NonNull f paramf)
    throws IOException
  {
    return this.a.d(paramParcelFileDescriptor, paramInt1, paramInt2, paramf);
  }
  
  public boolean d(@NonNull ParcelFileDescriptor paramParcelFileDescriptor, @NonNull f paramf)
  {
    return this.a.o(paramParcelFileDescriptor);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */