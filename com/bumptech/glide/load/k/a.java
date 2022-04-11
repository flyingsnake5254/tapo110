package com.bumptech.glide.load.k;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.DecodeException;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.OnPartialImageListener;
import android.graphics.ImageDecoder.Source;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.p;
import java.io.IOException;

@RequiresApi(api=28)
public abstract class a<T>
  implements g<ImageDecoder.Source, T>
{
  final p a = p.b();
  
  protected abstract u<T> c(ImageDecoder.Source paramSource, int paramInt1, int paramInt2, ImageDecoder.OnHeaderDecodedListener paramOnHeaderDecodedListener)
    throws IOException;
  
  @Nullable
  public final u<T> d(@NonNull ImageDecoder.Source paramSource, final int paramInt1, final int paramInt2, @NonNull f paramf)
    throws IOException
  {
    final DecodeFormat localDecodeFormat = (DecodeFormat)paramf.c(k.a);
    final DownsampleStrategy localDownsampleStrategy = (DownsampleStrategy)paramf.c(DownsampleStrategy.h);
    e locale = k.e;
    final boolean bool;
    if ((paramf.c(locale) != null) && (((Boolean)paramf.c(locale)).booleanValue())) {
      bool = true;
    } else {
      bool = false;
    }
    return c(paramSource, paramInt1, paramInt2, new a(paramInt1, paramInt2, bool, localDecodeFormat, localDownsampleStrategy, (PreferredColorSpace)paramf.c(k.b)));
  }
  
  public final boolean e(@NonNull ImageDecoder.Source paramSource, @NonNull f paramf)
  {
    return true;
  }
  
  class a
    implements ImageDecoder.OnHeaderDecodedListener
  {
    a(int paramInt1, int paramInt2, boolean paramBoolean, DecodeFormat paramDecodeFormat, DownsampleStrategy paramDownsampleStrategy, PreferredColorSpace paramPreferredColorSpace) {}
    
    @SuppressLint({"Override"})
    public void onHeaderDecoded(ImageDecoder paramImageDecoder, ImageDecoder.ImageInfo paramImageInfo, ImageDecoder.Source paramSource)
    {
      paramSource = a.this.a;
      int i = paramInt1;
      int j = paramInt2;
      boolean bool = bool;
      int k = 0;
      if (paramSource.e(i, j, bool, false)) {
        paramImageDecoder.setAllocator(3);
      } else {
        paramImageDecoder.setAllocator(1);
      }
      if (localDecodeFormat == DecodeFormat.PREFER_RGB_565) {
        paramImageDecoder.setMemorySizePolicy(0);
      }
      paramImageDecoder.setOnPartialImageListener(new a());
      Size localSize = paramImageInfo.getSize();
      j = paramInt1;
      i = j;
      if (j == Integer.MIN_VALUE) {
        i = localSize.getWidth();
      }
      int m = paramInt2;
      j = m;
      if (m == Integer.MIN_VALUE) {
        j = localSize.getHeight();
      }
      float f1 = localDownsampleStrategy.b(localSize.getWidth(), localSize.getHeight(), i, j);
      j = Math.round(localSize.getWidth() * f1);
      i = Math.round(localSize.getHeight() * f1);
      if (Log.isLoggable("ImageDecoder", 2))
      {
        paramSource = new StringBuilder();
        paramSource.append("Resizing from [");
        paramSource.append(localSize.getWidth());
        paramSource.append("x");
        paramSource.append(localSize.getHeight());
        paramSource.append("] to [");
        paramSource.append(j);
        paramSource.append("x");
        paramSource.append(i);
        paramSource.append("] scaleFactor: ");
        paramSource.append(f1);
        Log.v("ImageDecoder", paramSource.toString());
      }
      paramImageDecoder.setTargetSize(j, i);
      i = Build.VERSION.SDK_INT;
      if (i >= 28)
      {
        i = k;
        if (this.f == PreferredColorSpace.DISPLAY_P3)
        {
          i = k;
          if (paramImageInfo.getColorSpace() != null)
          {
            i = k;
            if (paramImageInfo.getColorSpace().isWideGamut()) {
              i = 1;
            }
          }
        }
        if (i != 0) {
          paramImageInfo = ColorSpace.Named.DISPLAY_P3;
        } else {
          paramImageInfo = ColorSpace.Named.SRGB;
        }
        paramImageDecoder.setTargetColorSpace(ColorSpace.get(paramImageInfo));
      }
      else if (i >= 26)
      {
        paramImageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
      }
    }
    
    class a
      implements ImageDecoder.OnPartialImageListener
    {
      a() {}
      
      public boolean onPartialImage(@NonNull ImageDecoder.DecodeException paramDecodeException)
      {
        return false;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */