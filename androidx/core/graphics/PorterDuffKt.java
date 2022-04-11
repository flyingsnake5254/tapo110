package androidx.core.graphics;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import kotlin.jvm.internal.j;

public final class PorterDuffKt
{
  public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode paramMode, int paramInt)
  {
    j.f(paramMode, "$this$toColorFilter");
    return new PorterDuffColorFilter(paramInt, paramMode);
  }
  
  public static final PorterDuffXfermode toXfermode(PorterDuff.Mode paramMode)
  {
    j.f(paramMode, "$this$toXfermode");
    return new PorterDuffXfermode(paramMode);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\PorterDuffKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */