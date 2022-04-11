package androidx.core.widget;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.NonNull;

public class ListViewAutoScrollHelper
  extends AutoScrollHelper
{
  private final ListView mTarget;
  
  public ListViewAutoScrollHelper(@NonNull ListView paramListView)
  {
    super(paramListView);
    this.mTarget = paramListView;
  }
  
  public boolean canTargetScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public boolean canTargetScrollVertically(int paramInt)
  {
    ListView localListView = this.mTarget;
    int i = localListView.getCount();
    if (i == 0) {
      return false;
    }
    int j = localListView.getChildCount();
    int k = localListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      if ((k + j >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight())) {
        return false;
      }
    }
    else
    {
      if (paramInt >= 0) {
        break label85;
      }
      if ((k <= 0) && (localListView.getChildAt(0).getTop() >= 0)) {
        return false;
      }
    }
    return true;
    label85:
    return false;
  }
  
  public void scrollTargetBy(int paramInt1, int paramInt2)
  {
    ListViewCompat.scrollListBy(this.mTarget, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\ListViewAutoScrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */