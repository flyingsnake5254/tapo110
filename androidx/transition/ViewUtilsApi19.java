package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
class ViewUtilsApi19
  extends ViewUtilsBase
{
  private static boolean sTryHiddenTransitionAlpha = true;
  
  public void clearNonTransitionAlpha(@NonNull View paramView) {}
  
  @SuppressLint({"NewApi"})
  public float getTransitionAlpha(@NonNull View paramView)
  {
    if (sTryHiddenTransitionAlpha) {
      try
      {
        float f = paramView.getTransitionAlpha();
        return f;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        sTryHiddenTransitionAlpha = false;
      }
    }
    return paramView.getAlpha();
  }
  
  public void saveNonTransitionAlpha(@NonNull View paramView) {}
  
  @SuppressLint({"NewApi"})
  public void setTransitionAlpha(@NonNull View paramView, float paramFloat)
  {
    if (sTryHiddenTransitionAlpha) {
      try
      {
        paramView.setTransitionAlpha(paramFloat);
        return;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        sTryHiddenTransitionAlpha = false;
      }
    }
    paramView.setAlpha(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewUtilsApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */