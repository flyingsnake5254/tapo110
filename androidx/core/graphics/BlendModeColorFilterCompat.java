package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BlendModeColorFilterCompat
{
  @Nullable
  public static ColorFilter createBlendModeColorFilterCompat(int paramInt, @NonNull BlendModeCompat paramBlendModeCompat)
  {
    int i = Build.VERSION.SDK_INT;
    BlendMode localBlendMode = null;
    PorterDuff.Mode localMode = null;
    if (i >= 29)
    {
      localBlendMode = BlendModeUtils.obtainBlendModeFromCompat(paramBlendModeCompat);
      paramBlendModeCompat = localMode;
      if (localBlendMode != null) {
        paramBlendModeCompat = new BlendModeColorFilter(paramInt, localBlendMode);
      }
      return paramBlendModeCompat;
    }
    localMode = BlendModeUtils.obtainPorterDuffFromCompat(paramBlendModeCompat);
    paramBlendModeCompat = localBlendMode;
    if (localMode != null) {
      paramBlendModeCompat = new PorterDuffColorFilter(paramInt, localMode);
    }
    return paramBlendModeCompat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\BlendModeColorFilterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */