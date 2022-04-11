package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class ViewUtilsApi21
  extends ViewUtilsApi19
{
  private static boolean sTryHiddenSetAnimationMatrix = true;
  private static boolean sTryHiddenTransformMatrixToGlobal = true;
  private static boolean sTryHiddenTransformMatrixToLocal = true;
  
  @SuppressLint({"NewApi"})
  public void setAnimationMatrix(@NonNull View paramView, @Nullable Matrix paramMatrix)
  {
    if (sTryHiddenSetAnimationMatrix) {
      try
      {
        paramView.setAnimationMatrix(paramMatrix);
      }
      catch (NoSuchMethodError paramView)
      {
        sTryHiddenSetAnimationMatrix = false;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public void transformMatrixToGlobal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    if (sTryHiddenTransformMatrixToGlobal) {
      try
      {
        paramView.transformMatrixToGlobal(paramMatrix);
      }
      catch (NoSuchMethodError paramView)
      {
        sTryHiddenTransformMatrixToGlobal = false;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public void transformMatrixToLocal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    if (sTryHiddenTransformMatrixToLocal) {
      try
      {
        paramView.transformMatrixToLocal(paramMatrix);
      }
      catch (NoSuchMethodError paramView)
      {
        sTryHiddenTransformMatrixToLocal = false;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewUtilsApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */