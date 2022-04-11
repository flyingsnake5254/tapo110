package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.Source;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ImageDecoderKt
{
  @RequiresApi(28)
  public static final Bitmap decodeBitmap(ImageDecoder.Source paramSource, q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, p> paramq)
  {
    j.f(paramSource, "$this$decodeBitmap");
    j.f(paramq, "action");
    paramSource = ImageDecoder.decodeBitmap(paramSource, new ImageDecoder.OnHeaderDecodedListener()
    {
      public final void onHeaderDecoded(ImageDecoder paramAnonymousImageDecoder, ImageDecoder.ImageInfo paramAnonymousImageInfo, ImageDecoder.Source paramAnonymousSource)
      {
        j.f(paramAnonymousImageDecoder, "decoder");
        j.f(paramAnonymousImageInfo, "info");
        j.f(paramAnonymousSource, "source");
        this.$action.invoke(paramAnonymousImageDecoder, paramAnonymousImageInfo, paramAnonymousSource);
      }
    });
    j.b(paramSource, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
    return paramSource;
  }
  
  @RequiresApi(28)
  public static final Drawable decodeDrawable(ImageDecoder.Source paramSource, q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, p> paramq)
  {
    j.f(paramSource, "$this$decodeDrawable");
    j.f(paramq, "action");
    paramSource = ImageDecoder.decodeDrawable(paramSource, new ImageDecoder.OnHeaderDecodedListener()
    {
      public final void onHeaderDecoded(ImageDecoder paramAnonymousImageDecoder, ImageDecoder.ImageInfo paramAnonymousImageInfo, ImageDecoder.Source paramAnonymousSource)
      {
        j.f(paramAnonymousImageDecoder, "decoder");
        j.f(paramAnonymousImageInfo, "info");
        j.f(paramAnonymousSource, "source");
        this.$action.invoke(paramAnonymousImageDecoder, paramAnonymousImageInfo, paramAnonymousSource);
      }
    });
    j.b(paramSource, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
    return paramSource;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\ImageDecoderKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */