package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class NestedScrollingParentHelper
{
  private int mNestedScrollAxesNonTouch;
  private int mNestedScrollAxesTouch;
  
  public NestedScrollingParentHelper(@NonNull ViewGroup paramViewGroup) {}
  
  public int getNestedScrollAxes()
  {
    return this.mNestedScrollAxesTouch | this.mNestedScrollAxesNonTouch;
  }
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt)
  {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {
      this.mNestedScrollAxesNonTouch = paramInt1;
    } else {
      this.mNestedScrollAxesTouch = paramInt1;
    }
  }
  
  public void onStopNestedScroll(@NonNull View paramView)
  {
    onStopNestedScroll(paramView, 0);
  }
  
  public void onStopNestedScroll(@NonNull View paramView, int paramInt)
  {
    if (paramInt == 1) {
      this.mNestedScrollAxesNonTouch = 0;
    } else {
      this.mNestedScrollAxesTouch = 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\NestedScrollingParentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */