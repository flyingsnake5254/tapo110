package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;

public final class MenuCompat
{
  @SuppressLint({"NewApi"})
  public static void setGroupDividerEnabled(Menu paramMenu, boolean paramBoolean)
  {
    if ((paramMenu instanceof SupportMenu)) {
      ((SupportMenu)paramMenu).setGroupDividerEnabled(paramBoolean);
    } else if (Build.VERSION.SDK_INT >= 28) {
      paramMenu.setGroupDividerEnabled(paramBoolean);
    }
  }
  
  @Deprecated
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem.setShowAsAction(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\MenuCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */