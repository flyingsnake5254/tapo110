package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
class ViewUtilsApi22
  extends ViewUtilsApi21
{
  private static boolean sTryHiddenSetLeftTopRightBottom = true;
  
  @SuppressLint({"NewApi"})
  public void setLeftTopRightBottom(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (sTryHiddenSetLeftTopRightBottom) {
      try
      {
        paramView.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      catch (NoSuchMethodError paramView)
      {
        sTryHiddenSetLeftTopRightBottom = false;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewUtilsApi22.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */