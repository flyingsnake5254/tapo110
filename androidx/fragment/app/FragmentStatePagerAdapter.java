package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle.State;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentStatePagerAdapter
  extends PagerAdapter
{
  public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
  @Deprecated
  public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
  private static final boolean DEBUG = false;
  private static final String TAG = "FragmentStatePagerAdapt";
  private final int mBehavior;
  private FragmentTransaction mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private boolean mExecutingFinishUpdate;
  private final FragmentManager mFragmentManager;
  private ArrayList<Fragment> mFragments = new ArrayList();
  private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();
  
  @Deprecated
  public FragmentStatePagerAdapter(@NonNull FragmentManager paramFragmentManager)
  {
    this(paramFragmentManager, 0);
  }
  
  public FragmentStatePagerAdapter(@NonNull FragmentManager paramFragmentManager, int paramInt)
  {
    this.mFragmentManager = paramFragmentManager;
    this.mBehavior = paramInt;
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    while (this.mSavedState.size() <= paramInt) {
      this.mSavedState.add(null);
    }
    paramObject = this.mSavedState;
    if (localFragment.isAdded()) {
      paramViewGroup = this.mFragmentManager.saveFragmentInstanceState(localFragment);
    } else {
      paramViewGroup = null;
    }
    ((ArrayList)paramObject).set(paramInt, paramViewGroup);
    this.mFragments.set(paramInt, null);
    this.mCurTransaction.remove(localFragment);
    if (localFragment.equals(this.mCurrentPrimaryItem)) {
      this.mCurrentPrimaryItem = null;
    }
  }
  
  public void finishUpdate(@NonNull ViewGroup paramViewGroup)
  {
    paramViewGroup = this.mCurTransaction;
    if (paramViewGroup != null)
    {
      if (!this.mExecutingFinishUpdate) {}
      try
      {
        this.mExecutingFinishUpdate = true;
        paramViewGroup.commitNowAllowingStateLoss();
        this.mExecutingFinishUpdate = false;
      }
      finally
      {
        this.mExecutingFinishUpdate = false;
      }
    }
  }
  
  @NonNull
  public abstract Fragment getItem(int paramInt);
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (this.mFragments.size() > paramInt)
    {
      localObject = (Fragment)this.mFragments.get(paramInt);
      if (localObject != null) {
        return localObject;
      }
    }
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    Fragment localFragment = getItem(paramInt);
    if (this.mSavedState.size() > paramInt)
    {
      localObject = (Fragment.SavedState)this.mSavedState.get(paramInt);
      if (localObject != null) {
        localFragment.setInitialSavedState((Fragment.SavedState)localObject);
      }
    }
    while (this.mFragments.size() <= paramInt) {
      this.mFragments.add(null);
    }
    localFragment.setMenuVisibility(false);
    if (this.mBehavior == 0) {
      localFragment.setUserVisibleHint(false);
    }
    this.mFragments.set(paramInt, localFragment);
    this.mCurTransaction.add(paramViewGroup.getId(), localFragment);
    if (this.mBehavior == 1) {
      this.mCurTransaction.setMaxLifecycle(localFragment, Lifecycle.State.STARTED);
    }
    return localFragment;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    boolean bool;
    if (((Fragment)paramObject).getView() == paramView) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void restoreState(@Nullable Parcelable paramParcelable, @Nullable ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.mSavedState.clear();
      this.mFragments.clear();
      int i;
      if (paramClassLoader != null) {
        for (i = 0; i < paramClassLoader.length; i++) {
          this.mSavedState.add((Fragment.SavedState)paramClassLoader[i]);
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        String str = (String)paramClassLoader.next();
        if (str.startsWith("f"))
        {
          i = Integer.parseInt(str.substring(1));
          Object localObject = this.mFragmentManager.getFragment(paramParcelable, str);
          if (localObject != null)
          {
            while (this.mFragments.size() <= i) {
              this.mFragments.add(null);
            }
            ((Fragment)localObject).setMenuVisibility(false);
            this.mFragments.set(i, localObject);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad fragment at key ");
            ((StringBuilder)localObject).append(str);
            Log.w("FragmentStatePagerAdapt", ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  @Nullable
  public Parcelable saveState()
  {
    Object localObject1;
    Object localObject2;
    if (this.mSavedState.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[this.mSavedState.size()];
      this.mSavedState.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    else
    {
      localObject1 = null;
    }
    int i = 0;
    while (i < this.mFragments.size())
    {
      Fragment localFragment = (Fragment)this.mFragments.get(i);
      localObject2 = localObject1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        if (localFragment.isAdded())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Bundle();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("f");
          ((StringBuilder)localObject1).append(i);
          localObject1 = ((StringBuilder)localObject1).toString();
          this.mFragmentManager.putFragment((Bundle)localObject2, (String)localObject1, localFragment);
        }
      }
      i++;
      localObject1 = localObject2;
    }
    return (Parcelable)localObject1;
  }
  
  public void setPrimaryItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    paramObject = this.mCurrentPrimaryItem;
    if (paramViewGroup != paramObject)
    {
      if (paramObject != null)
      {
        ((Fragment)paramObject).setMenuVisibility(false);
        if (this.mBehavior == 1)
        {
          if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
          }
          this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
        }
        else
        {
          this.mCurrentPrimaryItem.setUserVisibleHint(false);
        }
      }
      paramViewGroup.setMenuVisibility(true);
      if (this.mBehavior == 1)
      {
        if (this.mCurTransaction == null) {
          this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.setMaxLifecycle(paramViewGroup, Lifecycle.State.RESUMED);
      }
      else
      {
        paramViewGroup.setUserVisibleHint(true);
      }
      this.mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(@NonNull ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() != -1) {
      return;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("ViewPager with adapter ");
    paramViewGroup.append(this);
    paramViewGroup.append(" requires a view id");
    throw new IllegalStateException(paramViewGroup.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentStatePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */