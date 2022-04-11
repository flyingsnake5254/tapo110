package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.k.a;
import java.io.IOException;
import java.nio.ByteBuffer;

@RequiresApi(api=28)
public final class h
  implements g<ByteBuffer, Bitmap>
{
  private final d a = new d();
  
  @Nullable
  public u<Bitmap> c(@NonNull ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, @NonNull f paramf)
    throws IOException
  {
    paramByteBuffer = ImageDecoder.createSource(paramByteBuffer);
    return this.a.d(paramByteBuffer, paramInt1, paramInt2, paramf);
  }
  
  public boolean d(@NonNull ByteBuffer paramByteBuffer, @NonNull f paramf)
    throws IOException
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */