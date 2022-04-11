package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Group
  extends ConstraintHelper
{
  public Group(Context paramContext)
  {
    super(paramContext);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    super.init(paramAttributeSet);
    this.mUseViewMeasure = false;
  }
  
  public void updatePostLayout(ConstraintLayout paramConstraintLayout)
  {
    paramConstraintLayout = (ConstraintLayout.LayoutParams)getLayoutParams();
    paramConstraintLayout.widget.setWidth(0);
    paramConstraintLayout.widget.setHeight(0);
  }
  
  public void updatePreLayout(ConstraintLayout paramConstraintLayout)
  {
    int i = getVisibility();
    float f;
    if (Build.VERSION.SDK_INT >= 21) {
      f = getElevation();
    } else {
      f = 0.0F;
    }
    for (int j = 0; j < this.mCount; j++)
    {
      View localView = paramConstraintLayout.getViewById(this.mIds[j]);
      if (localView != null)
      {
        localView.setVisibility(i);
        if ((f > 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
          localView.setElevation(f);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\widget\Group.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */