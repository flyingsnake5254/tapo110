package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import kotlin.jvm.internal.j;

public final class MenuItemKt
{
  public static final boolean onNavDestinationSelected(MenuItem paramMenuItem, NavController paramNavController)
  {
    j.f(paramMenuItem, "$this$onNavDestinationSelected");
    j.f(paramNavController, "navController");
    return NavigationUI.onNavDestinationSelected(paramMenuItem, paramNavController);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\MenuItemKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */