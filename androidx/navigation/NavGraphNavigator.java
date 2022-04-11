package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Navigator.Name("navigation")
public class NavGraphNavigator
  extends Navigator<NavGraph>
{
  private final NavigatorProvider mNavigatorProvider;
  
  public NavGraphNavigator(@NonNull NavigatorProvider paramNavigatorProvider)
  {
    this.mNavigatorProvider = paramNavigatorProvider;
  }
  
  @NonNull
  public NavGraph createDestination()
  {
    return new NavGraph(this);
  }
  
  @Nullable
  public NavDestination navigate(@NonNull NavGraph paramNavGraph, @Nullable Bundle paramBundle, @Nullable NavOptions paramNavOptions, @Nullable Navigator.Extras paramExtras)
  {
    int i = paramNavGraph.getStartDestination();
    if (i != 0)
    {
      NavDestination localNavDestination = paramNavGraph.findNode(i, false);
      if (localNavDestination != null) {
        return this.mNavigatorProvider.getNavigator(localNavDestination.getNavigatorName()).navigate(localNavDestination, localNavDestination.addInDefaultArgs(paramBundle), paramNavOptions, paramExtras);
      }
      paramBundle = paramNavGraph.getStartDestDisplayName();
      paramNavGraph = new StringBuilder();
      paramNavGraph.append("navigation destination ");
      paramNavGraph.append(paramBundle);
      paramNavGraph.append(" is not a direct child of this NavGraph");
      throw new IllegalArgumentException(paramNavGraph.toString());
    }
    paramBundle = new StringBuilder();
    paramBundle.append("no start destination defined via app:startDestination for ");
    paramBundle.append(paramNavGraph.getDisplayName());
    throw new IllegalStateException(paramBundle.toString());
  }
  
  public boolean popBackStack()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavGraphNavigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */