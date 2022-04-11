package androidx.navigation.ui;

import android.view.Menu;
import androidx.customview.widget.Openable;
import androidx.navigation.NavGraph;
import java.util.Set;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class AppBarConfigurationKt
{
  public static final AppBarConfiguration AppBarConfiguration(Menu paramMenu, Openable paramOpenable, a<Boolean> parama)
  {
    j.f(paramMenu, "topLevelMenu");
    j.f(parama, "fallbackOnNavigateUpListener");
    paramMenu = new AppBarConfiguration.Builder(paramMenu).setOpenableLayout(paramOpenable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt.sam.i.androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener.0(parama)).build();
    j.b(paramMenu, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
    return paramMenu;
  }
  
  public static final AppBarConfiguration AppBarConfiguration(NavGraph paramNavGraph, Openable paramOpenable, a<Boolean> parama)
  {
    j.f(paramNavGraph, "navGraph");
    j.f(parama, "fallbackOnNavigateUpListener");
    paramNavGraph = new AppBarConfiguration.Builder(paramNavGraph).setOpenableLayout(paramOpenable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt.sam.i.androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener.0(parama)).build();
    j.b(paramNavGraph, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
    return paramNavGraph;
  }
  
  public static final AppBarConfiguration AppBarConfiguration(Set<Integer> paramSet, Openable paramOpenable, a<Boolean> parama)
  {
    j.f(paramSet, "topLevelDestinationIds");
    j.f(parama, "fallbackOnNavigateUpListener");
    paramSet = new AppBarConfiguration.Builder(paramSet).setOpenableLayout(paramOpenable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt.sam.i.androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener.0(parama)).build();
    j.b(paramSet, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
    return paramSet;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\AppBarConfigurationKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */