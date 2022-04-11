package b.d.q.b;

import android.os.Build.VERSION;

public class j
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
    if (Build.VERSION.SDK_INT >= 29) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\q\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */