package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
class ViewUtilsApi23
  extends ViewUtilsApi22
{
  private static boolean sTryHiddenSetTransitionVisibility = true;
  
  @SuppressLint({"NewApi"})
  public void setTransitionVisibility(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT == 28) {
      super.setTransitionVisibility(paramView, paramInt);
    } else if (sTryHiddenSetTransitionVisibility) {
      try
      {
        paramView.setTransitionVisibility(paramInt);
      }
      catch (NoSuchMethodError paramView)
      {
        sTryHiddenSetTransitionVisibility = false;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewUtilsApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */