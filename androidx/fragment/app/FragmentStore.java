package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class FragmentStore
{
  private static final String TAG = "FragmentManager";
  private final HashMap<String, FragmentStateManager> mActive = new HashMap();
  private final ArrayList<Fragment> mAdded = new ArrayList();
  
  void addFragment(@NonNull Fragment paramFragment)
  {
    if (!this.mAdded.contains(paramFragment)) {
      synchronized (this.mAdded)
      {
        this.mAdded.add(paramFragment);
        paramFragment.mAdded = true;
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Fragment already added: ");
    ((StringBuilder)???).append(paramFragment);
    throw new IllegalStateException(((StringBuilder)???).toString());
  }
  
  void burpActive()
  {
    this.mActive.values().removeAll(Collections.singleton(null));
  }
  
  boolean containsActiveFragment(@NonNull String paramString)
  {
    return this.mActive.containsKey(paramString);
  }
  
  void dispatchStateChange(int paramInt)
  {
    Object localObject1 = this.mAdded.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Fragment)((Iterator)localObject1).next();
      localObject2 = (FragmentStateManager)this.mActive.get(((Fragment)localObject2).mWho);
      if (localObject2 != null) {
        ((FragmentStateManager)localObject2).setFragmentManagerState(paramInt);
      }
    }
    Object localObject2 = this.mActive.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (FragmentStateManager)((Iterator)localObject2).next();
      if (localObject1 != null) {
        ((FragmentStateManager)localObject1).setFragmentManagerState(paramInt);
      }
    }
  }
  
  void dump(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("    ");
    String str = ((StringBuilder)localObject1).toString();
    if (!this.mActive.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Active Fragments:");
      localObject1 = this.mActive.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (FragmentStateManager)((Iterator)localObject1).next();
        paramPrintWriter.print(paramString);
        if (localObject2 != null)
        {
          localObject2 = ((FragmentStateManager)localObject2).getFragment();
          paramPrintWriter.println(localObject2);
          ((Fragment)localObject2).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
        else
        {
          paramPrintWriter.println("null");
        }
      }
    }
    int i = this.mAdded.size();
    if (i > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      for (int j = 0; j < i; j++)
      {
        paramFileDescriptor = (Fragment)this.mAdded.get(j);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(j);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
      }
    }
  }
  
  @Nullable
  Fragment findActiveFragment(@NonNull String paramString)
  {
    paramString = (FragmentStateManager)this.mActive.get(paramString);
    if (paramString != null) {
      return paramString.getFragment();
    }
    return null;
  }
  
  @Nullable
  Fragment findFragmentById(@IdRes int paramInt)
  {
    for (int i = this.mAdded.size() - 1; i >= 0; i--)
    {
      localObject1 = (Fragment)this.mAdded.get(i);
      if ((localObject1 != null) && (((Fragment)localObject1).mFragmentId == paramInt)) {
        return (Fragment)localObject1;
      }
    }
    Object localObject1 = this.mActive.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (FragmentStateManager)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((FragmentStateManager)localObject2).getFragment();
        if (((Fragment)localObject2).mFragmentId == paramInt) {
          return (Fragment)localObject2;
        }
      }
    }
    return null;
  }
  
  @Nullable
  Fragment findFragmentByTag(@Nullable String paramString)
  {
    Object localObject1;
    if (paramString != null) {
      for (int i = this.mAdded.size() - 1; i >= 0; i--)
      {
        localObject1 = (Fragment)this.mAdded.get(i);
        if ((localObject1 != null) && (paramString.equals(((Fragment)localObject1).mTag))) {
          return (Fragment)localObject1;
        }
      }
    }
    if (paramString != null)
    {
      localObject1 = this.mActive.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (FragmentStateManager)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((FragmentStateManager)localObject2).getFragment();
          if (paramString.equals(((Fragment)localObject2).mTag)) {
            return (Fragment)localObject2;
          }
        }
      }
    }
    return null;
  }
  
  @Nullable
  Fragment findFragmentByWho(@NonNull String paramString)
  {
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FragmentStateManager)localIterator.next();
      if (localObject != null)
      {
        localObject = ((FragmentStateManager)localObject).getFragment().findFragmentByWho(paramString);
        if (localObject != null) {
          return (Fragment)localObject;
        }
      }
    }
    return null;
  }
  
  Fragment findFragmentUnder(@NonNull Fragment paramFragment)
  {
    ViewGroup localViewGroup = paramFragment.mContainer;
    View localView = paramFragment.mView;
    if ((localViewGroup != null) && (localView != null)) {
      for (int i = this.mAdded.indexOf(paramFragment) - 1; i >= 0; i--)
      {
        paramFragment = (Fragment)this.mAdded.get(i);
        if ((paramFragment.mContainer == localViewGroup) && (paramFragment.mView != null)) {
          return paramFragment;
        }
      }
    }
    return null;
  }
  
  int getActiveFragmentCount()
  {
    return this.mActive.size();
  }
  
  @NonNull
  List<Fragment> getActiveFragments()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      FragmentStateManager localFragmentStateManager = (FragmentStateManager)localIterator.next();
      if (localFragmentStateManager != null) {
        localArrayList.add(localFragmentStateManager.getFragment());
      } else {
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }
  
  @Nullable
  FragmentStateManager getFragmentStateManager(@NonNull String paramString)
  {
    return (FragmentStateManager)this.mActive.get(paramString);
  }
  
  @NonNull
  List<Fragment> getFragments()
  {
    if (this.mAdded.isEmpty()) {
      return Collections.emptyList();
    }
    synchronized (this.mAdded)
    {
      ArrayList localArrayList2 = new java/util/ArrayList;
      localArrayList2.<init>(this.mAdded);
      return localArrayList2;
    }
  }
  
  void makeActive(@NonNull FragmentStateManager paramFragmentStateManager)
  {
    this.mActive.put(paramFragmentStateManager.getFragment().mWho, paramFragmentStateManager);
  }
  
  void makeInactive(@NonNull FragmentStateManager paramFragmentStateManager)
  {
    paramFragmentStateManager = paramFragmentStateManager.getFragment();
    Object localObject1 = this.mActive.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (FragmentStateManager)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((FragmentStateManager)localObject2).getFragment();
        if (paramFragmentStateManager.mWho.equals(((Fragment)localObject2).mTargetWho))
        {
          ((Fragment)localObject2).mTarget = paramFragmentStateManager;
          ((Fragment)localObject2).mTargetWho = null;
        }
      }
    }
    this.mActive.put(paramFragmentStateManager.mWho, null);
    localObject1 = paramFragmentStateManager.mTargetWho;
    if (localObject1 != null) {
      paramFragmentStateManager.mTarget = findActiveFragment((String)localObject1);
    }
  }
  
  void removeFragment(@NonNull Fragment paramFragment)
  {
    synchronized (this.mAdded)
    {
      this.mAdded.remove(paramFragment);
      paramFragment.mAdded = false;
      return;
    }
  }
  
  void resetActiveFragments()
  {
    this.mActive.clear();
  }
  
  void restoreAddedFragments(@Nullable List<String> paramList)
  {
    this.mAdded.clear();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        Object localObject = findActiveFragment(paramList);
        if (localObject != null)
        {
          if (FragmentManager.isLoggingEnabled(2))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreSaveState: added (");
            localStringBuilder.append(paramList);
            localStringBuilder.append("): ");
            localStringBuilder.append(localObject);
            Log.v("FragmentManager", localStringBuilder.toString());
          }
          addFragment((Fragment)localObject);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("No instantiated fragment for (");
          ((StringBuilder)localObject).append(paramList);
          ((StringBuilder)localObject).append(")");
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  @NonNull
  ArrayList<FragmentState> saveActiveFragments()
  {
    ArrayList localArrayList = new ArrayList(this.mActive.size());
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FragmentStateManager)localIterator.next();
      if (localObject != null)
      {
        Fragment localFragment = ((FragmentStateManager)localObject).getFragment();
        localObject = ((FragmentStateManager)localObject).saveState();
        localArrayList.add(localObject);
        if (FragmentManager.isLoggingEnabled(2))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Saved state of ");
          localStringBuilder.append(localFragment);
          localStringBuilder.append(": ");
          localStringBuilder.append(((FragmentState)localObject).mSavedFragmentState);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
      }
    }
    return localArrayList;
  }
  
  @Nullable
  ArrayList<String> saveAddedFragments()
  {
    synchronized (this.mAdded)
    {
      if (this.mAdded.isEmpty()) {
        return null;
      }
      ArrayList localArrayList2 = new java/util/ArrayList;
      localArrayList2.<init>(this.mAdded.size());
      Iterator localIterator = this.mAdded.iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        localArrayList2.add(localFragment.mWho);
        if (FragmentManager.isLoggingEnabled(2))
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("saveAllState: adding fragment (");
          localStringBuilder.append(localFragment.mWho);
          localStringBuilder.append("): ");
          localStringBuilder.append(localFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
      }
      return localArrayList2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */