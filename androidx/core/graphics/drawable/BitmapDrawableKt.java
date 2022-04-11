package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.j;

public final class BitmapDrawableKt
{
  public static final BitmapDrawable toDrawable(Bitmap paramBitmap, Resources paramResources)
  {
    j.f(paramBitmap, "$this$toDrawable");
    j.f(paramResources, "resources");
    return new BitmapDrawable(paramResources, paramBitmap);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\drawable\BitmapDrawableKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */