package androidx.navigation.ui;

import androidx.navigation.NavController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.jvm.internal.j;

public final class BottomNavigationViewKt
{
  public static final void setupWithNavController(BottomNavigationView paramBottomNavigationView, NavController paramNavController)
  {
    j.f(paramBottomNavigationView, "$this$setupWithNavController");
    j.f(paramNavController, "navController");
    NavigationUI.setupWithNavController(paramBottomNavigationView, paramNavController);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\BottomNavigationViewKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */