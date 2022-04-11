package androidx.navigation.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import kotlin.jvm.internal.j;

public final class CollapsingToolbarLayoutKt
{
  public static final void setupWithNavController(CollapsingToolbarLayout paramCollapsingToolbarLayout, Toolbar paramToolbar, NavController paramNavController, DrawerLayout paramDrawerLayout)
  {
    j.f(paramCollapsingToolbarLayout, "$this$setupWithNavController");
    j.f(paramToolbar, "toolbar");
    j.f(paramNavController, "navController");
    Object localObject = paramNavController.getGraph();
    j.b(localObject, "navController.graph");
    AppBarConfigurationKt.AppBarConfiguration.1 local1 = AppBarConfigurationKt.AppBarConfiguration.1.INSTANCE;
    localObject = new AppBarConfiguration.Builder((NavGraph)localObject).setOpenableLayout(paramDrawerLayout);
    paramDrawerLayout = local1;
    if (local1 != null) {
      paramDrawerLayout = new AppBarConfigurationKt.sam.i.androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener.0(local1);
    }
    paramDrawerLayout = ((AppBarConfiguration.Builder)localObject).setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener)paramDrawerLayout).build();
    j.b(paramDrawerLayout, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
    NavigationUI.setupWithNavController(paramCollapsingToolbarLayout, paramToolbar, paramNavController, paramDrawerLayout);
  }
  
  public static final void setupWithNavController(CollapsingToolbarLayout paramCollapsingToolbarLayout, Toolbar paramToolbar, NavController paramNavController, AppBarConfiguration paramAppBarConfiguration)
  {
    j.f(paramCollapsingToolbarLayout, "$this$setupWithNavController");
    j.f(paramToolbar, "toolbar");
    j.f(paramNavController, "navController");
    j.f(paramAppBarConfiguration, "configuration");
    NavigationUI.setupWithNavController(paramCollapsingToolbarLayout, paramToolbar, paramNavController, paramAppBarConfiguration);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\CollapsingToolbarLayoutKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */