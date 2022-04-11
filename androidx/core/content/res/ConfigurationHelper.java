package androidx.core.content.res;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;

public final class ConfigurationHelper
{
  public static int getDensityDpi(@NonNull Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramResources.getConfiguration().densityDpi;
    }
    return paramResources.getDisplayMetrics().densityDpi;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\res\ConfigurationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */