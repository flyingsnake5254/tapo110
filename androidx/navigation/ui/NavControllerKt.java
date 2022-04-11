package androidx.navigation.ui;

import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import kotlin.jvm.internal.j;

public final class NavControllerKt
{
  public static final boolean navigateUp(NavController paramNavController, Openable paramOpenable)
  {
    j.f(paramNavController, "$this$navigateUp");
    Object localObject = paramNavController.getGraph();
    j.b(localObject, "graph");
    AppBarConfigurationKt.AppBarConfiguration.1 local1 = AppBarConfigurationKt.AppBarConfiguration.1.INSTANCE;
    localObject = new AppBarConfiguration.Builder((NavGraph)localObject).setOpenableLayout(paramOpenable);
    paramOpenable = local1;
    if (local1 != null) {
      paramOpenable = new AppBarConfigurationKt.sam.i.androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener.0(local1);
    }
    paramOpenable = ((AppBarConfiguration.Builder)localObject).setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener)paramOpenable).build();
    j.b(paramOpenable, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
    return NavigationUI.navigateUp(paramNavController, paramOpenable);
  }
  
  public static final boolean navigateUp(NavController paramNavController, AppBarConfiguration paramAppBarConfiguration)
  {
    j.f(paramNavController, "$this$navigateUp");
    j.f(paramAppBarConfiguration, "appBarConfiguration");
    return NavigationUI.navigateUp(paramNavController, paramAppBarConfiguration);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\NavControllerKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */