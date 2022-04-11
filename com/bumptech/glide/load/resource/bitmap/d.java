package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.Source;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.f;
import com.bumptech.glide.load.k.a;
import java.io.IOException;

@RequiresApi(api=28)
public final class d
  extends a<Bitmap>
{
  private final com.bumptech.glide.load.engine.z.e b = new f();
  
  protected u<Bitmap> c(ImageDecoder.Source paramSource, int paramInt1, int paramInt2, ImageDecoder.OnHeaderDecodedListener paramOnHeaderDecodedListener)
    throws IOException
  {
    paramSource = ImageDecoder.decodeBitmap(paramSource, paramOnHeaderDecodedListener);
    if (Log.isLoggable("BitmapImageDecoder", 2))
    {
      paramOnHeaderDecodedListener = new StringBuilder();
      paramOnHeaderDecodedListener.append("Decoded [");
      paramOnHeaderDecodedListener.append(paramSource.getWidth());
      paramOnHeaderDecodedListener.append("x");
      paramOnHeaderDecodedListener.append(paramSource.getHeight());
      paramOnHeaderDecodedListener.append("] for [");
      paramOnHeaderDecodedListener.append(paramInt1);
      paramOnHeaderDecodedListener.append("x");
      paramOnHeaderDecodedListener.append(paramInt2);
      paramOnHeaderDecodedListener.append("]");
      Log.v("BitmapImageDecoder", paramOnHeaderDecodedListener.toString());
    }
    return new e(paramSource, this.b);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */