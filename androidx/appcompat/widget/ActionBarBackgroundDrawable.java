package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

class ActionBarBackgroundDrawable
  extends Drawable
{
  final ActionBarContainer mContainer;
  
  public ActionBarBackgroundDrawable(ActionBarContainer paramActionBarContainer)
  {
    this.mContainer = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.mContainer;
    if (((ActionBarContainer)localObject).mIsSplit)
    {
      localObject = ((ActionBarContainer)localObject).mSplitBackground;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
    else
    {
      localObject = ((ActionBarContainer)localObject).mBackground;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
      localObject = this.mContainer;
      Drawable localDrawable = ((ActionBarContainer)localObject).mStackedBackground;
      if ((localDrawable != null) && (((ActionBarContainer)localObject).mIsStacked)) {
        localDrawable.draw(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  @RequiresApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    Object localObject = this.mContainer;
    if (((ActionBarContainer)localObject).mIsSplit)
    {
      localObject = ((ActionBarContainer)localObject).mSplitBackground;
      if (localObject != null) {
        ((Drawable)localObject).getOutline(paramOutline);
      }
    }
    else
    {
      localObject = ((ActionBarContainer)localObject).mBackground;
      if (localObject != null) {
        ((Drawable)localObject).getOutline(paramOutline);
      }
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ActionBarBackgroundDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */