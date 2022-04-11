package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(29)
class ViewUtilsApi29
  extends ViewUtilsApi23
{
  public float getTransitionAlpha(@NonNull View paramView)
  {
    return paramView.getTransitionAlpha();
  }
  
  public void setAnimationMatrix(@NonNull View paramView, @Nullable Matrix paramMatrix)
  {
    paramView.setAnimationMatrix(paramMatrix);
  }
  
  public void setLeftTopRightBottom(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setTransitionAlpha(@NonNull View paramView, float paramFloat)
  {
    paramView.setTransitionAlpha(paramFloat);
  }
  
  public void setTransitionVisibility(@NonNull View paramView, int paramInt)
  {
    paramView.setTransitionVisibility(paramInt);
  }
  
  public void transformMatrixToGlobal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    paramView.transformMatrixToGlobal(paramMatrix);
  }
  
  public void transformMatrixToLocal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    paramView.transformMatrixToLocal(paramMatrix);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewUtilsApi29.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */