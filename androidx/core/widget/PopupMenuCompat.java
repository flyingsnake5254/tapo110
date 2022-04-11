package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class PopupMenuCompat
{
  @Nullable
  public static View.OnTouchListener getDragToOpenListener(@NonNull Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((PopupMenu)paramObject).getDragToOpenListener();
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\PopupMenuCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */