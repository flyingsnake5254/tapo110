package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDestination.ClassType;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator.Extras;
import androidx.navigation.Navigator.Name;
import androidx.navigation.NavigatorProvider;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Navigator.Name("fragment")
public class FragmentNavigator
  extends Navigator<Destination>
{
  private static final String KEY_BACK_STACK_IDS = "androidx-nav-fragment:navigator:backStackIds";
  private static final String TAG = "FragmentNavigator";
  private ArrayDeque<Integer> mBackStack = new ArrayDeque();
  private final int mContainerId;
  private final Context mContext;
  private final FragmentManager mFragmentManager;
  
  public FragmentNavigator(@NonNull Context paramContext, @NonNull FragmentManager paramFragmentManager, int paramInt)
  {
    this.mContext = paramContext;
    this.mFragmentManager = paramFragmentManager;
    this.mContainerId = paramInt;
  }
  
  @NonNull
  private String generateBackStackName(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  @NonNull
  public Destination createDestination()
  {
    return new Destination(this);
  }
  
  @Deprecated
  @NonNull
  public Fragment instantiateFragment(@NonNull Context paramContext, @NonNull FragmentManager paramFragmentManager, @NonNull String paramString, @Nullable Bundle paramBundle)
  {
    return paramFragmentManager.getFragmentFactory().instantiate(paramContext.getClassLoader(), paramString);
  }
  
  @Nullable
  public NavDestination navigate(@NonNull Destination paramDestination, @Nullable Bundle paramBundle, @Nullable NavOptions paramNavOptions, @Nullable Navigator.Extras paramExtras)
  {
    if (this.mFragmentManager.isStateSaved())
    {
      Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
      return null;
    }
    String str = paramDestination.getClassName();
    int i = 0;
    Object localObject = str;
    if (str.charAt(0) == '.')
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mContext.getPackageName());
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    localObject = instantiateFragment(this.mContext, this.mFragmentManager, (String)localObject, paramBundle);
    ((Fragment)localObject).setArguments(paramBundle);
    paramBundle = this.mFragmentManager.beginTransaction();
    if (paramNavOptions != null) {
      j = paramNavOptions.getEnterAnim();
    } else {
      j = -1;
    }
    int k;
    if (paramNavOptions != null) {
      k = paramNavOptions.getExitAnim();
    } else {
      k = -1;
    }
    int m;
    if (paramNavOptions != null) {
      m = paramNavOptions.getPopEnterAnim();
    } else {
      m = -1;
    }
    int n;
    if (paramNavOptions != null) {
      n = paramNavOptions.getPopExitAnim();
    } else {
      n = -1;
    }
    if ((j != -1) || (k != -1) || (m != -1) || (n != -1))
    {
      if (j == -1) {
        j = 0;
      }
      if (k == -1) {
        k = 0;
      }
      if (m == -1) {
        m = 0;
      }
      if (n == -1) {
        n = 0;
      }
      paramBundle.setCustomAnimations(j, k, m, n);
    }
    paramBundle.replace(this.mContainerId, (Fragment)localObject);
    paramBundle.setPrimaryNavigationFragment((Fragment)localObject);
    int j = paramDestination.getId();
    boolean bool = this.mBackStack.isEmpty();
    if ((paramNavOptions != null) && (!bool) && (paramNavOptions.shouldLaunchSingleTop()) && (((Integer)this.mBackStack.peekLast()).intValue() == j)) {
      k = 1;
    } else {
      k = 0;
    }
    if (bool) {}
    for (;;)
    {
      k = 1;
      break;
      if (k != 0)
      {
        k = i;
        if (this.mBackStack.size() <= 1) {
          break;
        }
        this.mFragmentManager.popBackStack(generateBackStackName(this.mBackStack.size(), ((Integer)this.mBackStack.peekLast()).intValue()), 1);
        paramBundle.addToBackStack(generateBackStackName(this.mBackStack.size(), j));
        k = i;
        break;
      }
      paramBundle.addToBackStack(generateBackStackName(this.mBackStack.size() + 1, j));
    }
    if ((paramExtras instanceof Extras))
    {
      paramExtras = ((Extras)paramExtras).getSharedElements().entrySet().iterator();
      while (paramExtras.hasNext())
      {
        paramNavOptions = (Map.Entry)paramExtras.next();
        paramBundle.addSharedElement((View)paramNavOptions.getKey(), (String)paramNavOptions.getValue());
      }
    }
    paramBundle.setReorderingAllowed(true);
    paramBundle.commit();
    if (k != 0)
    {
      this.mBackStack.add(Integer.valueOf(j));
      return paramDestination;
    }
    return null;
  }
  
  public void onRestoreState(@Nullable Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getIntArray("androidx-nav-fragment:navigator:backStackIds");
      if (paramBundle != null)
      {
        this.mBackStack.clear();
        int i = paramBundle.length;
        for (int j = 0; j < i; j++)
        {
          int k = paramBundle[j];
          this.mBackStack.add(Integer.valueOf(k));
        }
      }
    }
  }
  
  @Nullable
  public Bundle onSaveState()
  {
    Bundle localBundle = new Bundle();
    int[] arrayOfInt = new int[this.mBackStack.size()];
    Iterator localIterator = this.mBackStack.iterator();
    for (int i = 0; localIterator.hasNext(); i++) {
      arrayOfInt[i] = ((Integer)localIterator.next()).intValue();
    }
    localBundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", arrayOfInt);
    return localBundle;
  }
  
  public boolean popBackStack()
  {
    if (this.mBackStack.isEmpty()) {
      return false;
    }
    if (this.mFragmentManager.isStateSaved())
    {
      Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
      return false;
    }
    this.mFragmentManager.popBackStack(generateBackStackName(this.mBackStack.size(), ((Integer)this.mBackStack.peekLast()).intValue()), 1);
    this.mBackStack.removeLast();
    return true;
  }
  
  @NavDestination.ClassType(Fragment.class)
  public static class Destination
    extends NavDestination
  {
    private String mClassName;
    
    public Destination(@NonNull Navigator<? extends Destination> paramNavigator)
    {
      super();
    }
    
    public Destination(@NonNull NavigatorProvider paramNavigatorProvider)
    {
      this(paramNavigatorProvider.getNavigator(FragmentNavigator.class));
    }
    
    @NonNull
    public final String getClassName()
    {
      String str = this.mClassName;
      if (str != null) {
        return str;
      }
      throw new IllegalStateException("Fragment class was not set");
    }
    
    @CallSuper
    public void onInflate(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
    {
      super.onInflate(paramContext, paramAttributeSet);
      paramAttributeSet = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.FragmentNavigator);
      paramContext = paramAttributeSet.getString(R.styleable.FragmentNavigator_android_name);
      if (paramContext != null) {
        setClassName(paramContext);
      }
      paramAttributeSet.recycle();
    }
    
    @NonNull
    public final Destination setClassName(@NonNull String paramString)
    {
      this.mClassName = paramString;
      return this;
    }
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append(" class=");
      String str = this.mClassName;
      if (str == null) {
        localStringBuilder.append("null");
      } else {
        localStringBuilder.append(str);
      }
      return localStringBuilder.toString();
    }
  }
  
  public static final class Extras
    implements Navigator.Extras
  {
    private final LinkedHashMap<View, String> mSharedElements;
    
    Extras(Map<View, String> paramMap)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      this.mSharedElements = localLinkedHashMap;
      localLinkedHashMap.putAll(paramMap);
    }
    
    @NonNull
    public Map<View, String> getSharedElements()
    {
      return Collections.unmodifiableMap(this.mSharedElements);
    }
    
    public static final class Builder
    {
      private final LinkedHashMap<View, String> mSharedElements = new LinkedHashMap();
      
      @NonNull
      public Builder addSharedElement(@NonNull View paramView, @NonNull String paramString)
      {
        this.mSharedElements.put(paramView, paramString);
        return this;
      }
      
      @NonNull
      public Builder addSharedElements(@NonNull Map<View, String> paramMap)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject = (Map.Entry)paramMap.next();
          View localView = (View)((Map.Entry)localObject).getKey();
          localObject = (String)((Map.Entry)localObject).getValue();
          if ((localView != null) && (localObject != null)) {
            addSharedElement(localView, (String)localObject);
          }
        }
        return this;
      }
      
      @NonNull
      public FragmentNavigator.Extras build()
      {
        return new FragmentNavigator.Extras(this.mSharedElements);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\fragment\FragmentNavigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */