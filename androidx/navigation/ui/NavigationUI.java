package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.customview.widget.Openable;
import androidx.navigation.ActivityNavigator.Destination;
import androidx.navigation.NavController;
import androidx.navigation.NavController.OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptions.Builder;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import java.lang.ref.WeakReference;
import java.util.Set;

public final class NavigationUI
{
  static BottomSheetBehavior findBottomSheetBehavior(@NonNull View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof CoordinatorLayout.LayoutParams))
    {
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        return findBottomSheetBehavior((View)paramView);
      }
      return null;
    }
    paramView = ((CoordinatorLayout.LayoutParams)localLayoutParams).getBehavior();
    if (!(paramView instanceof BottomSheetBehavior)) {
      return null;
    }
    return (BottomSheetBehavior)paramView;
  }
  
  static NavDestination findStartDestination(@NonNull NavGraph paramNavGraph)
  {
    while ((paramNavGraph instanceof NavGraph))
    {
      paramNavGraph = (NavGraph)paramNavGraph;
      paramNavGraph = paramNavGraph.findNode(paramNavGraph.getStartDestination());
    }
    return paramNavGraph;
  }
  
  static boolean matchDestination(@NonNull NavDestination paramNavDestination, @IdRes int paramInt)
  {
    while ((paramNavDestination.getId() != paramInt) && (paramNavDestination.getParent() != null)) {
      paramNavDestination = paramNavDestination.getParent();
    }
    boolean bool;
    if (paramNavDestination.getId() == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean matchDestinations(@NonNull NavDestination paramNavDestination, @NonNull Set<Integer> paramSet)
  {
    NavGraph localNavGraph;
    do
    {
      if (paramSet.contains(Integer.valueOf(paramNavDestination.getId()))) {
        return true;
      }
      localNavGraph = paramNavDestination.getParent();
      paramNavDestination = localNavGraph;
    } while (localNavGraph != null);
    return false;
  }
  
  public static boolean navigateUp(@NonNull NavController paramNavController, @Nullable Openable paramOpenable)
  {
    return navigateUp(paramNavController, new AppBarConfiguration.Builder(paramNavController.getGraph()).setOpenableLayout(paramOpenable).build());
  }
  
  public static boolean navigateUp(@NonNull NavController paramNavController, @NonNull AppBarConfiguration paramAppBarConfiguration)
  {
    Openable localOpenable = paramAppBarConfiguration.getOpenableLayout();
    NavDestination localNavDestination = paramNavController.getCurrentDestination();
    Set localSet = paramAppBarConfiguration.getTopLevelDestinations();
    if ((localOpenable != null) && (localNavDestination != null) && (matchDestinations(localNavDestination, localSet)))
    {
      localOpenable.open();
      return true;
    }
    if (paramNavController.navigateUp()) {
      return true;
    }
    if (paramAppBarConfiguration.getFallbackOnNavigateUpListener() != null) {
      return paramAppBarConfiguration.getFallbackOnNavigateUpListener().onNavigateUp();
    }
    return false;
  }
  
  public static boolean onNavDestinationSelected(@NonNull MenuItem paramMenuItem, @NonNull NavController paramNavController)
  {
    Object localObject = new NavOptions.Builder().setLaunchSingleTop(true);
    if ((paramNavController.getCurrentDestination().getParent().findNode(paramMenuItem.getItemId()) instanceof ActivityNavigator.Destination)) {
      ((NavOptions.Builder)localObject).setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.nav_default_pop_exit_anim);
    } else {
      ((NavOptions.Builder)localObject).setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim).setPopExitAnim(R.animator.nav_default_pop_exit_anim);
    }
    if ((paramMenuItem.getOrder() & 0x30000) == 0) {
      ((NavOptions.Builder)localObject).setPopUpTo(findStartDestination(paramNavController.getGraph()).getId(), false);
    }
    localObject = ((NavOptions.Builder)localObject).build();
    try
    {
      paramNavController.navigate(paramMenuItem.getItemId(), null, (NavOptions)localObject);
      return true;
    }
    catch (IllegalArgumentException paramMenuItem) {}
    return false;
  }
  
  public static void setupActionBarWithNavController(@NonNull AppCompatActivity paramAppCompatActivity, @NonNull NavController paramNavController)
  {
    setupActionBarWithNavController(paramAppCompatActivity, paramNavController, new AppBarConfiguration.Builder(paramNavController.getGraph()).build());
  }
  
  public static void setupActionBarWithNavController(@NonNull AppCompatActivity paramAppCompatActivity, @NonNull NavController paramNavController, @Nullable Openable paramOpenable)
  {
    setupActionBarWithNavController(paramAppCompatActivity, paramNavController, new AppBarConfiguration.Builder(paramNavController.getGraph()).setOpenableLayout(paramOpenable).build());
  }
  
  public static void setupActionBarWithNavController(@NonNull AppCompatActivity paramAppCompatActivity, @NonNull NavController paramNavController, @NonNull AppBarConfiguration paramAppBarConfiguration)
  {
    paramNavController.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(paramAppCompatActivity, paramAppBarConfiguration));
  }
  
  public static void setupWithNavController(@NonNull Toolbar paramToolbar, @NonNull NavController paramNavController)
  {
    setupWithNavController(paramToolbar, paramNavController, new AppBarConfiguration.Builder(paramNavController.getGraph()).build());
  }
  
  public static void setupWithNavController(@NonNull Toolbar paramToolbar, @NonNull NavController paramNavController, @Nullable Openable paramOpenable)
  {
    setupWithNavController(paramToolbar, paramNavController, new AppBarConfiguration.Builder(paramNavController.getGraph()).setOpenableLayout(paramOpenable).build());
  }
  
  public static void setupWithNavController(@NonNull Toolbar paramToolbar, @NonNull NavController paramNavController, @NonNull final AppBarConfiguration paramAppBarConfiguration)
  {
    paramNavController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(paramToolbar, paramAppBarConfiguration));
    paramToolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        NavigationUI.navigateUp(NavigationUI.this, paramAppBarConfiguration);
      }
    });
  }
  
  public static void setupWithNavController(@NonNull CollapsingToolbarLayout paramCollapsingToolbarLayout, @NonNull Toolbar paramToolbar, @NonNull NavController paramNavController)
  {
    setupWithNavController(paramCollapsingToolbarLayout, paramToolbar, paramNavController, new AppBarConfiguration.Builder(paramNavController.getGraph()).build());
  }
  
  public static void setupWithNavController(@NonNull CollapsingToolbarLayout paramCollapsingToolbarLayout, @NonNull Toolbar paramToolbar, @NonNull NavController paramNavController, @Nullable Openable paramOpenable)
  {
    setupWithNavController(paramCollapsingToolbarLayout, paramToolbar, paramNavController, new AppBarConfiguration.Builder(paramNavController.getGraph()).setOpenableLayout(paramOpenable).build());
  }
  
  public static void setupWithNavController(@NonNull CollapsingToolbarLayout paramCollapsingToolbarLayout, @NonNull Toolbar paramToolbar, @NonNull NavController paramNavController, @NonNull final AppBarConfiguration paramAppBarConfiguration)
  {
    paramNavController.addOnDestinationChangedListener(new CollapsingToolbarOnDestinationChangedListener(paramCollapsingToolbarLayout, paramToolbar, paramAppBarConfiguration));
    paramToolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        NavigationUI.navigateUp(NavigationUI.this, paramAppBarConfiguration);
      }
    });
  }
  
  public static void setupWithNavController(@NonNull BottomNavigationView paramBottomNavigationView, @NonNull final NavController paramNavController)
  {
    paramBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
    {
      public boolean onNavigationItemSelected(@NonNull MenuItem paramAnonymousMenuItem)
      {
        return NavigationUI.onNavDestinationSelected(paramAnonymousMenuItem, NavigationUI.this);
      }
    });
    paramNavController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener()
    {
      public void onDestinationChanged(@NonNull NavController paramAnonymousNavController, @NonNull NavDestination paramAnonymousNavDestination, @Nullable Bundle paramAnonymousBundle)
      {
        paramAnonymousNavController = (BottomNavigationView)NavigationUI.this.get();
        if (paramAnonymousNavController == null)
        {
          paramNavController.removeOnDestinationChangedListener(this);
          return;
        }
        paramAnonymousNavController = paramAnonymousNavController.getMenu();
        int i = 0;
        int j = paramAnonymousNavController.size();
        while (i < j)
        {
          paramAnonymousBundle = paramAnonymousNavController.getItem(i);
          if (NavigationUI.matchDestination(paramAnonymousNavDestination, paramAnonymousBundle.getItemId())) {
            paramAnonymousBundle.setChecked(true);
          }
          i++;
        }
      }
    });
  }
  
  public static void setupWithNavController(@NonNull final NavigationView paramNavigationView, @NonNull final NavController paramNavController)
  {
    paramNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
    {
      public boolean onNavigationItemSelected(@NonNull MenuItem paramAnonymousMenuItem)
      {
        boolean bool = NavigationUI.onNavDestinationSelected(paramAnonymousMenuItem, NavigationUI.this);
        if (bool)
        {
          paramAnonymousMenuItem = paramNavigationView.getParent();
          if ((paramAnonymousMenuItem instanceof Openable))
          {
            ((Openable)paramAnonymousMenuItem).close();
          }
          else
          {
            paramAnonymousMenuItem = NavigationUI.findBottomSheetBehavior(paramNavigationView);
            if (paramAnonymousMenuItem != null) {
              paramAnonymousMenuItem.setState(5);
            }
          }
        }
        return bool;
      }
    });
    paramNavController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener()
    {
      public void onDestinationChanged(@NonNull NavController paramAnonymousNavController, @NonNull NavDestination paramAnonymousNavDestination, @Nullable Bundle paramAnonymousBundle)
      {
        paramAnonymousNavController = (NavigationView)NavigationUI.this.get();
        if (paramAnonymousNavController == null)
        {
          paramNavController.removeOnDestinationChangedListener(this);
          return;
        }
        paramAnonymousBundle = paramAnonymousNavController.getMenu();
        int i = 0;
        int j = paramAnonymousBundle.size();
        while (i < j)
        {
          paramAnonymousNavController = paramAnonymousBundle.getItem(i);
          paramAnonymousNavController.setChecked(NavigationUI.matchDestination(paramAnonymousNavDestination, paramAnonymousNavController.getItemId()));
          i++;
        }
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\NavigationUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */