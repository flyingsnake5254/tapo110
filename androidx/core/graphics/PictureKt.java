package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class PictureKt
{
  public static final Picture record(Picture paramPicture, int paramInt1, int paramInt2, l<? super Canvas, p> paraml)
  {
    j.f(paramPicture, "$this$record");
    j.f(paraml, "block");
    Canvas localCanvas = paramPicture.beginRecording(paramInt1, paramInt2);
    try
    {
      j.b(localCanvas, "c");
      paraml.invoke(localCanvas);
      return paramPicture;
    }
    finally
    {
      i.b(1);
      paramPicture.endRecording();
      i.a(1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\PictureKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */