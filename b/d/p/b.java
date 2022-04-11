package b.d.p;

import android.os.Build.VERSION;

public class b
{
  public static boolean a()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean b()
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\p\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */