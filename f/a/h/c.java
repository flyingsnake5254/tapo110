package f.a.h;

import android.util.Log;

public class c
{
  public static boolean a = false;
  
  public static void a(String paramString1, String paramString2)
  {
    if (a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      Log.i("skin-support", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\f\a\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */