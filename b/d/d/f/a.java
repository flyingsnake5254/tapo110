package b.d.d.f;

import android.app.Application;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import b.d.d.j.b;
import b.d.p.d;
import java.io.File;

public class a
{
  private static final String a = "a";
  private static String b = "https://n-wap-dcipc.tplinkcloud.com";
  
  public static String a()
  {
    Object localObject = b();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    localObject = new File((String)localObject, "preview");
    boolean bool = true;
    if (!((File)localObject).exists()) {
      bool = ((File)localObject).mkdir();
    }
    if (bool) {
      return ((File)localObject).getAbsolutePath();
    }
    return "";
  }
  
  private static String b()
  {
    File localFile = b.a.getExternalFilesDir("");
    if (localFile != null) {
      return localFile.getPath();
    }
    return "";
  }
  
  public static String c()
  {
    Object localObject = b();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    localObject = new File((String)localObject, "memory");
    boolean bool = true;
    if (!((File)localObject).exists()) {
      bool = ((File)localObject).mkdir();
    }
    if (bool) {
      return ((File)localObject).getAbsolutePath();
    }
    return "";
  }
  
  public static void d(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    File[] arrayOfFile = new File(a()).listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        File localFile = arrayOfFile[j];
        String str = localFile.getName();
        if ((str.contains(paramString1)) && (!str.contains(paramString2))) {
          localFile.delete();
        }
      }
    }
  }
  
  public static final long f()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    try
    {
      localObject = new StatFs(((File)localObject).getPath());
      return ((StatFs)localObject).getBlockSizeLong() * ((StatFs)localObject).getAvailableBlocksLong();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      d.c(a, Log.getStackTraceString(localIllegalArgumentException));
    }
    return 0L;
  }
  
  public static final long g()
  {
    return f() - 419430400L;
  }
  
  public static String h()
  {
    return b;
  }
  
  public static void i(String paramString)
  {
    b = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */