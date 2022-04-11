package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;

public final class ColorDrawableKt
{
  public static final ColorDrawable toDrawable(@ColorInt int paramInt)
  {
    return new ColorDrawable(paramInt);
  }
  
  @RequiresApi(26)
  public static final ColorDrawable toDrawable(Color paramColor)
  {
    j.f(paramColor, "$this$toDrawable");
    return new ColorDrawable(paramColor.toArgb());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\drawable\ColorDrawableKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */