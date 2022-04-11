package androidx.navigation.ui;

import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationView;
import kotlin.jvm.internal.j;

public final class NavigationViewKt
{
  public static final void setupWithNavController(NavigationView paramNavigationView, NavController paramNavController)
  {
    j.f(paramNavigationView, "$this$setupWithNavController");
    j.f(paramNavController, "navController");
    NavigationUI.setupWithNavController(paramNavigationView, paramNavController);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\NavigationViewKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */