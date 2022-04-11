package b.d.d.m;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import b.d.d.j.b;

public class a
{
  public static String a()
  {
    String str2;
    try
    {
      String str1 = b.a.getPackageManager().getPackageInfo(b.a.getPackageName(), 0).versionName;
    }
    catch (Exception localException)
    {
      str2 = "UnKnown";
    }
    return str2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\m\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */