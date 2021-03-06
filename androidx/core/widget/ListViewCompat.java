package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.NonNull;

public final class ListViewCompat
{
  public static boolean canScrollList(@NonNull ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramListView.canScrollList(paramInt);
    }
    int i = paramListView.getChildCount();
    boolean bool1 = false;
    boolean bool2 = false;
    if (i == 0) {
      return false;
    }
    int j = paramListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      paramInt = paramListView.getChildAt(i - 1).getBottom();
      if ((j + i < paramListView.getCount()) || (paramInt > paramListView.getHeight() - paramListView.getListPaddingBottom())) {
        bool2 = true;
      }
      return bool2;
    }
    paramInt = paramListView.getChildAt(0).getTop();
    if (j <= 0)
    {
      bool2 = bool1;
      if (paramInt >= paramListView.getListPaddingTop()) {}
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public static void scrollListBy(@NonNull ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramListView.scrollListBy(paramInt);
    }
    else
    {
      int i = paramListView.getFirstVisiblePosition();
      if (i == -1) {
        return;
      }
      View localView = paramListView.getChildAt(0);
      if (localView == null) {
        return;
      }
      paramListView.setSelectionFromTop(i, localView.getTop() - paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\ListViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */