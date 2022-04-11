package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class w
  extends f
{
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(c.a);
  private final int c;
  
  public w(int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    i.a(bool, "roundingRadius must be greater than 0.");
    this.c = paramInt;
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(b);
    paramMessageDigest.update(ByteBuffer.allocate(4).putInt(this.c).array());
  }
  
  protected Bitmap c(@NonNull e parame, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return y.n(parame, paramBitmap, this.c);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof w;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (w)paramObject;
      bool3 = bool2;
      if (this.c == ((w)paramObject).c) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    return j.o(-569625254, j.n(this.c));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */