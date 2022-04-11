package androidx.navigation.ui;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import java.util.HashSet;
import java.util.Set;

public final class AppBarConfiguration
{
  @Nullable
  private final OnNavigateUpListener mFallbackOnNavigateUpListener;
  @Nullable
  private final Openable mOpenableLayout;
  @NonNull
  private final Set<Integer> mTopLevelDestinations;
  
  private AppBarConfiguration(@NonNull Set<Integer> paramSet, @Nullable Openable paramOpenable, @Nullable OnNavigateUpListener paramOnNavigateUpListener)
  {
    this.mTopLevelDestinations = paramSet;
    this.mOpenableLayout = paramOpenable;
    this.mFallbackOnNavigateUpListener = paramOnNavigateUpListener;
  }
  
  @Deprecated
  @Nullable
  public DrawerLayout getDrawerLayout()
  {
    Openable localOpenable = this.mOpenableLayout;
    if ((localOpenable instanceof DrawerLayout)) {
      return (DrawerLayout)localOpenable;
    }
    return null;
  }
  
  @Nullable
  public OnNavigateUpListener getFallbackOnNavigateUpListener()
  {
    return this.mFallbackOnNavigateUpListener;
  }
  
  @Nullable
  public Openable getOpenableLayout()
  {
    return this.mOpenableLayout;
  }
  
  @NonNull
  public Set<Integer> getTopLevelDestinations()
  {
    return this.mTopLevelDestinations;
  }
  
  public static final class Builder
  {
    @Nullable
    private AppBarConfiguration.OnNavigateUpListener mFallbackOnNavigateUpListener;
    @Nullable
    private Openable mOpenableLayout;
    @NonNull
    private final Set<Integer> mTopLevelDestinations;
    
    public Builder(@NonNull Menu paramMenu)
    {
      this.mTopLevelDestinations = new HashSet();
      int i = paramMenu.size();
      for (int j = 0; j < i; j++)
      {
        MenuItem localMenuItem = paramMenu.getItem(j);
        this.mTopLevelDestinations.add(Integer.valueOf(localMenuItem.getItemId()));
      }
    }
    
    public Builder(@NonNull NavGraph paramNavGraph)
    {
      HashSet localHashSet = new HashSet();
      this.mTopLevelDestinations = localHashSet;
      localHashSet.add(Integer.valueOf(NavigationUI.findStartDestination(paramNavGraph).getId()));
    }
    
    public Builder(@NonNull Set<Integer> paramSet)
    {
      HashSet localHashSet = new HashSet();
      this.mTopLevelDestinations = localHashSet;
      localHashSet.addAll(paramSet);
    }
    
    public Builder(@NonNull int... paramVarArgs)
    {
      this.mTopLevelDestinations = new HashSet();
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        int k = paramVarArgs[j];
        this.mTopLevelDestinations.add(Integer.valueOf(k));
      }
    }
    
    @SuppressLint({"SyntheticAccessor"})
    @NonNull
    public AppBarConfiguration build()
    {
      return new AppBarConfiguration(this.mTopLevelDestinations, this.mOpenableLayout, this.mFallbackOnNavigateUpListener, null);
    }
    
    @Deprecated
    @NonNull
    public Builder setDrawerLayout(@Nullable DrawerLayout paramDrawerLayout)
    {
      this.mOpenableLayout = paramDrawerLayout;
      return this;
    }
    
    @NonNull
    public Builder setFallbackOnNavigateUpListener(@Nullable AppBarConfiguration.OnNavigateUpListener paramOnNavigateUpListener)
    {
      this.mFallbackOnNavigateUpListener = paramOnNavigateUpListener;
      return this;
    }
    
    @NonNull
    public Builder setOpenableLayout(@Nullable Openable paramOpenable)
    {
      this.mOpenableLayout = paramOpenable;
      return this;
    }
  }
  
  public static abstract interface OnNavigateUpListener
  {
    public abstract boolean onNavigateUp();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ui\AppBarConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */