package b.d.e0;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class a
{
  public static int a;
  public static int b;
  public static float c;
  public static int d;
  public static float e;
  public static float f;
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */