package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListPopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ListPopupWindowCompat
{
  @Nullable
  public static View.OnTouchListener createDragToOpenListener(@NonNull ListPopupWindow paramListPopupWindow, @NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramListPopupWindow.createDragToOpenListener(paramView);
    }
    return null;
  }
  
  @Deprecated
  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
  {
    return createDragToOpenListener((ListPopupWindow)paramObject, paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\ListPopupWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */