package androidx.navigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.TaskStackBuilder;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;

public final class NavDeepLinkBuilder
{
  private Bundle mArgs;
  private final Context mContext;
  private int mDestId;
  private NavGraph mGraph;
  private final Intent mIntent;
  
  public NavDeepLinkBuilder(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
    if ((paramContext instanceof Activity))
    {
      this.mIntent = new Intent(paramContext, paramContext.getClass());
    }
    else
    {
      paramContext = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
      if (paramContext == null) {
        paramContext = new Intent();
      }
      this.mIntent = paramContext;
    }
    this.mIntent.addFlags(268468224);
  }
  
  NavDeepLinkBuilder(@NonNull NavController paramNavController)
  {
    this(paramNavController.getContext());
    this.mGraph = paramNavController.getGraph();
  }
  
  private void fillInIntent()
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.add(this.mGraph);
    Object localObject1 = null;
    while ((!localArrayDeque.isEmpty()) && (localObject1 == null))
    {
      localObject2 = (NavDestination)localArrayDeque.poll();
      if (((NavDestination)localObject2).getId() == this.mDestId)
      {
        localObject1 = localObject2;
      }
      else if ((localObject2 instanceof NavGraph))
      {
        localObject2 = ((NavGraph)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayDeque.add((NavDestination)((Iterator)localObject2).next());
        }
      }
    }
    if (localObject1 != null)
    {
      this.mIntent.putExtra("android-support-nav:controller:deepLinkIds", ((NavDestination)localObject1).buildDeepLinkIds());
      return;
    }
    Object localObject2 = NavDestination.getDisplayName(this.mContext, this.mDestId);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Navigation destination ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(" cannot be found in the navigation graph ");
    ((StringBuilder)localObject1).append(this.mGraph);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  @NonNull
  public PendingIntent createPendingIntent()
  {
    Object localObject1 = this.mArgs;
    int i = 0;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).keySet().iterator();
      for (i = 0; ((Iterator)localObject1).hasNext(); i = i * 31 + j)
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.mArgs.get((String)localObject2);
        if (localObject2 != null) {
          j = localObject2.hashCode();
        } else {
          j = 0;
        }
      }
    }
    int j = this.mDestId;
    return createTaskStackBuilder().getPendingIntent(i * 31 + j, 134217728);
  }
  
  @NonNull
  public TaskStackBuilder createTaskStackBuilder()
  {
    if (this.mIntent.getIntArrayExtra("android-support-nav:controller:deepLinkIds") == null)
    {
      if (this.mGraph == null) {
        throw new IllegalStateException("You must call setGraph() before constructing the deep link");
      }
      throw new IllegalStateException("You must call setDestination() before constructing the deep link");
    }
    TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(this.mContext).addNextIntentWithParentStack(new Intent(this.mIntent));
    for (int i = 0; i < localTaskStackBuilder.getIntentCount(); i++) {
      localTaskStackBuilder.editIntentAt(i).putExtra("android-support-nav:controller:deepLinkIntent", this.mIntent);
    }
    return localTaskStackBuilder;
  }
  
  @NonNull
  public NavDeepLinkBuilder setArguments(@Nullable Bundle paramBundle)
  {
    this.mArgs = paramBundle;
    this.mIntent.putExtra("android-support-nav:controller:deepLinkExtras", paramBundle);
    return this;
  }
  
  @NonNull
  public NavDeepLinkBuilder setComponentName(@NonNull ComponentName paramComponentName)
  {
    this.mIntent.setComponent(paramComponentName);
    return this;
  }
  
  @NonNull
  public NavDeepLinkBuilder setComponentName(@NonNull Class<? extends Activity> paramClass)
  {
    return setComponentName(new ComponentName(this.mContext, paramClass));
  }
  
  @NonNull
  public NavDeepLinkBuilder setDestination(@IdRes int paramInt)
  {
    this.mDestId = paramInt;
    if (this.mGraph != null) {
      fillInIntent();
    }
    return this;
  }
  
  @NonNull
  public NavDeepLinkBuilder setGraph(@NavigationRes int paramInt)
  {
    return setGraph(new NavInflater(this.mContext, new PermissiveNavigatorProvider()).inflate(paramInt));
  }
  
  @NonNull
  public NavDeepLinkBuilder setGraph(@NonNull NavGraph paramNavGraph)
  {
    this.mGraph = paramNavGraph;
    if (this.mDestId != 0) {
      fillInIntent();
    }
    return this;
  }
  
  private static class PermissiveNavigatorProvider
    extends NavigatorProvider
  {
    private final Navigator<NavDestination> mDestNavigator = new Navigator()
    {
      @NonNull
      public NavDestination createDestination()
      {
        return new NavDestination("permissive");
      }
      
      @Nullable
      public NavDestination navigate(@NonNull NavDestination paramAnonymousNavDestination, @Nullable Bundle paramAnonymousBundle, @Nullable NavOptions paramAnonymousNavOptions, @Nullable Navigator.Extras paramAnonymousExtras)
      {
        throw new IllegalStateException("navigate is not supported");
      }
      
      public boolean popBackStack()
      {
        throw new IllegalStateException("popBackStack is not supported");
      }
    };
    
    PermissiveNavigatorProvider()
    {
      addNavigator(new NavGraphNavigator(this));
    }
    
    @NonNull
    public Navigator<? extends NavDestination> getNavigator(@NonNull String paramString)
    {
      try
      {
        paramString = super.getNavigator(paramString);
        return paramString;
      }
      catch (IllegalStateException paramString) {}
      return this.mDestNavigator;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavDeepLinkBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */