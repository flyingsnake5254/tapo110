package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class PackageInfoCompat
{
  public static long getLongVersionCode(@NonNull PackageInfo paramPackageInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPackageInfo.getLongVersionCode();
    }
    return paramPackageInfo.versionCode;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\pm\PackageInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */