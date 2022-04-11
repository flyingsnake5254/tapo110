package b.a.a.a.a.a;

import android.os.Build.VERSION;

public class c
{
  public static void a(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static boolean b()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean c()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\a\a\a\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */