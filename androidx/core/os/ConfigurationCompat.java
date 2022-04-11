package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.util.Locale;

public final class ConfigurationCompat
{
  @NonNull
  public static LocaleListCompat getLocales(@NonNull Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return LocaleListCompat.wrap(paramConfiguration.getLocales());
    }
    return LocaleListCompat.create(new Locale[] { paramConfiguration.locale });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\ConfigurationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */