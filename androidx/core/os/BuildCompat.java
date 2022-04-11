package androidx.core.os;

import android.os.Build.VERSION;

public class BuildCompat
{
  @Deprecated
  public static boolean isAtLeastN()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public static boolean isAtLeastNMR1()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 25) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public static boolean isAtLeastO()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 26) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public static boolean isAtLeastOMR1()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 27) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public static boolean isAtLeastP()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public static boolean isAtLeastQ()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 29) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isAtLeastR()
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT < 30) && (!Build.VERSION.CODENAME.equals("R"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\BuildCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */