package uk.co.senab.photoview;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class a
{
  public static int a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return c(paramInt);
    }
    return b(paramInt);
  }
  
  @TargetApi(5)
  private static int b(int paramInt)
  {
    return (paramInt & 0xFF00) >> 8;
  }
  
  @TargetApi(11)
  private static int c(int paramInt)
  {
    return (paramInt & 0xFF00) >> 8;
  }
  
  public static void d(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      e(paramView, paramRunnable);
    } else {
      paramView.postDelayed(paramRunnable, 16L);
    }
  }
  
  @TargetApi(16)
  private static void e(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */