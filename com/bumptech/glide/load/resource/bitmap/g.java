package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.util.a;
import java.io.IOException;
import java.nio.ByteBuffer;

public class g
  implements com.bumptech.glide.load.g<ByteBuffer, Bitmap>
{
  private final k a;
  
  public g(k paramk)
  {
    this.a = paramk;
  }
  
  public u<Bitmap> c(@NonNull ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, @NonNull f paramf)
    throws IOException
  {
    paramByteBuffer = a.f(paramByteBuffer);
    return this.a.f(paramByteBuffer, paramInt1, paramInt2, paramf);
  }
  
  public boolean d(@NonNull ByteBuffer paramByteBuffer, @NonNull f paramf)
  {
    return this.a.q(paramByteBuffer);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */