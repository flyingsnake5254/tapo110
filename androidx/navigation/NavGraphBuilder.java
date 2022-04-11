package androidx.navigation;

import androidx.annotation.IdRes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

@NavDestinationDsl
public class NavGraphBuilder
  extends NavDestinationBuilder<NavGraph>
{
  private final List<NavDestination> destinations;
  private final NavigatorProvider provider;
  private int startDestination;
  
  public NavGraphBuilder(NavigatorProvider paramNavigatorProvider, @IdRes int paramInt1, @IdRes int paramInt2)
  {
    super(localNavigator, paramInt1);
    this.provider = paramNavigatorProvider;
    this.startDestination = paramInt2;
    this.destinations = new ArrayList();
  }
  
  public final void addDestination(NavDestination paramNavDestination)
  {
    j.f(paramNavDestination, "destination");
    this.destinations.add(paramNavDestination);
  }
  
  public NavGraph build()
  {
    NavGraph localNavGraph = (NavGraph)super.build();
    localNavGraph.addDestinations(this.destinations);
    int i = this.startDestination;
    if (i != 0)
    {
      localNavGraph.setStartDestination(i);
      return localNavGraph;
    }
    throw new IllegalStateException("You must set a startDestination");
  }
  
  public final <D extends NavDestination> void destination(NavDestinationBuilder<? extends D> paramNavDestinationBuilder)
  {
    j.f(paramNavDestinationBuilder, "navDestination");
    this.destinations.add(paramNavDestinationBuilder.build());
  }
  
  public final NavigatorProvider getProvider()
  {
    return this.provider;
  }
  
  public final void unaryPlus(NavDestination paramNavDestination)
  {
    j.f(paramNavDestination, "$this$unaryPlus");
    addDestination(paramNavDestination);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavGraphBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */