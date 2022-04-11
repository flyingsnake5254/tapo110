package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.util.c;
import java.io.IOException;
import java.io.InputStream;

public class x
  implements com.bumptech.glide.load.g<InputStream, Bitmap>
{
  private final k a;
  private final b b;
  
  public x(k paramk, b paramb)
  {
    this.a = paramk;
    this.b = paramb;
  }
  
  public com.bumptech.glide.load.engine.u<Bitmap> c(@NonNull InputStream paramInputStream, int paramInt1, int paramInt2, @NonNull f paramf)
    throws IOException
  {
    int i;
    if ((paramInputStream instanceof u))
    {
      paramInputStream = (u)paramInputStream;
      i = 0;
    }
    else
    {
      paramInputStream = new u(paramInputStream, this.b);
      i = 1;
    }
    c localc = c.c(paramInputStream);
    com.bumptech.glide.util.g localg = new com.bumptech.glide.util.g(localc);
    a locala = new a(paramInputStream, localc);
    try
    {
      paramf = this.a.g(localg, paramInt1, paramInt2, paramf, locala);
      return paramf;
    }
    finally
    {
      localc.e();
      if (i != 0) {
        paramInputStream.e();
      }
    }
  }
  
  public boolean d(@NonNull InputStream paramInputStream, @NonNull f paramf)
  {
    return this.a.p(paramInputStream);
  }
  
  static class a
    implements k.b
  {
    private final u a;
    private final c b;
    
    a(u paramu, c paramc)
    {
      this.a = paramu;
      this.b = paramc;
    }
    
    public void a(e parame, Bitmap paramBitmap)
      throws IOException
    {
      IOException localIOException = this.b.a();
      if (localIOException != null)
      {
        if (paramBitmap != null) {
          parame.c(paramBitmap);
        }
        throw localIOException;
      }
    }
    
    public void b()
    {
      this.a.c();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */