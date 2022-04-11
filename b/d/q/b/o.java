package b.d.q.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class o
{
  private static String a;
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int b(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    paramContext = new DisplayMetrics();
    int i = 0;
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { paramContext });
      int j = paramContext.heightPixels;
      i = j;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return i;
  }
  
  public static int c(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public static void d(String paramString)
  {
    a = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\q\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */