package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.lifecycle.Lifecycle.State;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
  extends FragmentTransaction
  implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator
{
  private static final String TAG = "FragmentManager";
  boolean mCommitted;
  int mIndex = -1;
  final FragmentManager mManager;
  
  BackStackRecord(@NonNull FragmentManager paramFragmentManager)
  {
    super(localFragmentFactory, (ClassLoader)localObject);
    this.mManager = paramFragmentManager;
  }
  
  private static boolean isFragmentPostponed(FragmentTransaction.Op paramOp)
  {
    paramOp = paramOp.mFragment;
    boolean bool;
    if ((paramOp != null) && (paramOp.mAdded) && (paramOp.mView != null) && (!paramOp.mDetached) && (!paramOp.mHidden) && (paramOp.isPostponed())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void bumpBackStackNesting(int paramInt)
  {
    if (!this.mAddToBackStack) {
      return;
    }
    Object localObject1;
    if (FragmentManager.isLoggingEnabled(2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Bump nesting in ");
      ((StringBuilder)localObject1).append(this);
      ((StringBuilder)localObject1).append(" by ");
      ((StringBuilder)localObject1).append(paramInt);
      Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    int i = this.mOps.size();
    for (int j = 0; j < i; j++)
    {
      localObject1 = (FragmentTransaction.Op)this.mOps.get(j);
      Object localObject2 = ((FragmentTransaction.Op)localObject1).mFragment;
      if (localObject2 != null)
      {
        ((Fragment)localObject2).mBackStackNesting += paramInt;
        if (FragmentManager.isLoggingEnabled(2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Bump nesting of ");
          ((StringBuilder)localObject2).append(((FragmentTransaction.Op)localObject1).mFragment);
          ((StringBuilder)localObject2).append(" to ");
          ((StringBuilder)localObject2).append(((FragmentTransaction.Op)localObject1).mFragment.mBackStackNesting);
          Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public int commit()
  {
    return commitInternal(false);
  }
  
  public int commitAllowingStateLoss()
  {
    return commitInternal(true);
  }
  
  int commitInternal(boolean paramBoolean)
  {
    if (!this.mCommitted)
    {
      if (FragmentManager.isLoggingEnabled(2))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Commit: ");
        ((StringBuilder)localObject).append(this);
        Log.v("FragmentManager", ((StringBuilder)localObject).toString());
        localObject = new PrintWriter(new LogWriter("FragmentManager"));
        dump("  ", (PrintWriter)localObject);
        ((PrintWriter)localObject).close();
      }
      this.mCommitted = true;
      if (this.mAddToBackStack) {
        this.mIndex = this.mManager.allocBackStackIndex();
      } else {
        this.mIndex = -1;
      }
      this.mManager.enqueueAction(this, paramBoolean);
      return this.mIndex;
    }
    throw new IllegalStateException("commit already called");
  }
  
  public void commitNow()
  {
    disallowAddToBackStack();
    this.mManager.execSingleAction(this, false);
  }
  
  public void commitNowAllowingStateLoss()
  {
    disallowAddToBackStack();
    this.mManager.execSingleAction(this, true);
  }
  
  @NonNull
  public FragmentTransaction detach(@NonNull Fragment paramFragment)
  {
    Object localObject = paramFragment.mFragmentManager;
    if ((localObject != null) && (localObject != this.mManager))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
      ((StringBuilder)localObject).append(paramFragment.toString());
      ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return super.detach(paramFragment);
  }
  
  void doAddOp(int paramInt1, Fragment paramFragment, @Nullable String paramString, int paramInt2)
  {
    super.doAddOp(paramInt1, paramFragment, paramString, paramInt2);
    paramFragment.mFragmentManager = this.mManager;
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter)
  {
    dump(paramString, paramPrintWriter, true);
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.mCommitted);
      if (this.mTransition != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.mTransition));
      }
      if ((this.mEnterAnim != 0) || (this.mExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mEnterAnim));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mExitAnim));
      }
      if ((this.mPopEnterAnim != 0) || (this.mPopExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mPopEnterAnim));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mPopExitAnim));
      }
      if ((this.mBreadCrumbTitleRes != 0) || (this.mBreadCrumbTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.mBreadCrumbTitleText);
      }
      if ((this.mBreadCrumbShortTitleRes != 0) || (this.mBreadCrumbShortTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.mBreadCrumbShortTitleText);
      }
    }
    if (!this.mOps.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      int i = this.mOps.size();
      for (int j = 0; j < i; j++)
      {
        FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(j);
        Object localObject;
        switch (localOp.mCmd)
        {
        default: 
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cmd=");
          ((StringBuilder)localObject).append(localOp.mCmd);
          localObject = ((StringBuilder)localObject).toString();
          break;
        case 10: 
          localObject = "OP_SET_MAX_LIFECYCLE";
          break;
        case 9: 
          localObject = "UNSET_PRIMARY_NAV";
          break;
        case 8: 
          localObject = "SET_PRIMARY_NAV";
          break;
        case 7: 
          localObject = "ATTACH";
          break;
        case 6: 
          localObject = "DETACH";
          break;
        case 5: 
          localObject = "SHOW";
          break;
        case 4: 
          localObject = "HIDE";
          break;
        case 3: 
          localObject = "REMOVE";
          break;
        case 2: 
          localObject = "REPLACE";
          break;
        case 1: 
          localObject = "ADD";
          break;
        case 0: 
          localObject = "NULL";
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  Op #");
        paramPrintWriter.print(j);
        paramPrintWriter.print(": ");
        paramPrintWriter.print((String)localObject);
        paramPrintWriter.print(" ");
        paramPrintWriter.println(localOp.mFragment);
        if (paramBoolean)
        {
          if ((localOp.mEnterAnim != 0) || (localOp.mExitAnim != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("enterAnim=#");
            paramPrintWriter.print(Integer.toHexString(localOp.mEnterAnim));
            paramPrintWriter.print(" exitAnim=#");
            paramPrintWriter.println(Integer.toHexString(localOp.mExitAnim));
          }
          if ((localOp.mPopEnterAnim != 0) || (localOp.mPopExitAnim != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("popEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(localOp.mPopEnterAnim));
            paramPrintWriter.print(" popExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(localOp.mPopExitAnim));
          }
        }
      }
    }
  }
  
  void executeOps()
  {
    int i = this.mOps.size();
    Object localObject1;
    for (int j = 0; j < i; j++)
    {
      localObject1 = (FragmentTransaction.Op)this.mOps.get(j);
      Object localObject2 = ((FragmentTransaction.Op)localObject1).mFragment;
      if (localObject2 != null) {
        ((Fragment)localObject2).setNextTransition(this.mTransition);
      }
      switch (((FragmentTransaction.Op)localObject1).mCmd)
      {
      case 2: 
      default: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unknown cmd: ");
        ((StringBuilder)localObject2).append(((FragmentTransaction.Op)localObject1).mCmd);
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      case 10: 
        this.mManager.setMaxLifecycle((Fragment)localObject2, ((FragmentTransaction.Op)localObject1).mCurrentMaxState);
        break;
      case 9: 
        this.mManager.setPrimaryNavigationFragment(null);
        break;
      case 8: 
        this.mManager.setPrimaryNavigationFragment((Fragment)localObject2);
        break;
      case 7: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mEnterAnim);
        this.mManager.setExitAnimationOrder((Fragment)localObject2, false);
        this.mManager.attachFragment((Fragment)localObject2);
        break;
      case 6: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mExitAnim);
        this.mManager.detachFragment((Fragment)localObject2);
        break;
      case 5: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mEnterAnim);
        this.mManager.setExitAnimationOrder((Fragment)localObject2, false);
        this.mManager.showFragment((Fragment)localObject2);
        break;
      case 4: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mExitAnim);
        this.mManager.hideFragment((Fragment)localObject2);
        break;
      case 3: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mExitAnim);
        this.mManager.removeFragment((Fragment)localObject2);
        break;
      case 1: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mEnterAnim);
        this.mManager.setExitAnimationOrder((Fragment)localObject2, false);
        this.mManager.addFragment((Fragment)localObject2);
      }
      if ((!this.mReorderingAllowed) && (((FragmentTransaction.Op)localObject1).mCmd != 1) && (localObject2 != null)) {
        this.mManager.moveFragmentToExpectedState((Fragment)localObject2);
      }
    }
    if (!this.mReorderingAllowed)
    {
      localObject1 = this.mManager;
      ((FragmentManager)localObject1).moveToState(((FragmentManager)localObject1).mCurState, true);
    }
  }
  
  void executePopOps(boolean paramBoolean)
  {
    Object localObject1;
    for (int i = this.mOps.size() - 1; i >= 0; i--)
    {
      localObject1 = (FragmentTransaction.Op)this.mOps.get(i);
      Object localObject2 = ((FragmentTransaction.Op)localObject1).mFragment;
      if (localObject2 != null) {
        ((Fragment)localObject2).setNextTransition(FragmentManager.reverseTransit(this.mTransition));
      }
      switch (((FragmentTransaction.Op)localObject1).mCmd)
      {
      case 2: 
      default: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unknown cmd: ");
        ((StringBuilder)localObject2).append(((FragmentTransaction.Op)localObject1).mCmd);
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      case 10: 
        this.mManager.setMaxLifecycle((Fragment)localObject2, ((FragmentTransaction.Op)localObject1).mOldMaxState);
        break;
      case 9: 
        this.mManager.setPrimaryNavigationFragment((Fragment)localObject2);
        break;
      case 8: 
        this.mManager.setPrimaryNavigationFragment(null);
        break;
      case 7: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mPopExitAnim);
        this.mManager.setExitAnimationOrder((Fragment)localObject2, true);
        this.mManager.detachFragment((Fragment)localObject2);
        break;
      case 6: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mPopEnterAnim);
        this.mManager.attachFragment((Fragment)localObject2);
        break;
      case 5: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mPopExitAnim);
        this.mManager.setExitAnimationOrder((Fragment)localObject2, true);
        this.mManager.hideFragment((Fragment)localObject2);
        break;
      case 4: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mPopEnterAnim);
        this.mManager.showFragment((Fragment)localObject2);
        break;
      case 3: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mPopEnterAnim);
        this.mManager.addFragment((Fragment)localObject2);
        break;
      case 1: 
        ((Fragment)localObject2).setNextAnim(((FragmentTransaction.Op)localObject1).mPopExitAnim);
        this.mManager.setExitAnimationOrder((Fragment)localObject2, true);
        this.mManager.removeFragment((Fragment)localObject2);
      }
      if ((!this.mReorderingAllowed) && (((FragmentTransaction.Op)localObject1).mCmd != 3) && (localObject2 != null)) {
        this.mManager.moveFragmentToExpectedState((Fragment)localObject2);
      }
    }
    if ((!this.mReorderingAllowed) && (paramBoolean))
    {
      localObject1 = this.mManager;
      ((FragmentManager)localObject1).moveToState(((FragmentManager)localObject1).mCurState, true);
    }
  }
  
  Fragment expandOps(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i = 0;
    for (Fragment localFragment1 = paramFragment; i < this.mOps.size(); localFragment1 = paramFragment)
    {
      Object localObject = (FragmentTransaction.Op)this.mOps.get(i);
      int j = ((FragmentTransaction.Op)localObject).mCmd;
      if (j != 1) {
        if (j != 2)
        {
          if ((j != 3) && (j != 6))
          {
            if (j != 7)
            {
              if (j != 8)
              {
                paramFragment = localFragment1;
                j = i;
                break label441;
              }
              this.mOps.add(i, new FragmentTransaction.Op(9, localFragment1));
              j = i + 1;
              paramFragment = ((FragmentTransaction.Op)localObject).mFragment;
              break label441;
            }
          }
          else
          {
            paramArrayList.remove(((FragmentTransaction.Op)localObject).mFragment);
            localObject = ((FragmentTransaction.Op)localObject).mFragment;
            paramFragment = localFragment1;
            j = i;
            if (localObject != localFragment1) {
              break label441;
            }
            this.mOps.add(i, new FragmentTransaction.Op(9, (Fragment)localObject));
            j = i + 1;
            paramFragment = null;
            break label441;
          }
        }
        else
        {
          Fragment localFragment2 = ((FragmentTransaction.Op)localObject).mFragment;
          int k = localFragment2.mContainerId;
          int m = paramArrayList.size() - 1;
          int n = 0;
          j = i;
          paramFragment = localFragment1;
          while (m >= 0)
          {
            Fragment localFragment3 = (Fragment)paramArrayList.get(m);
            localFragment1 = paramFragment;
            i = j;
            int i1 = n;
            if (localFragment3.mContainerId == k) {
              if (localFragment3 == localFragment2)
              {
                i1 = 1;
                localFragment1 = paramFragment;
                i = j;
              }
              else
              {
                localFragment1 = paramFragment;
                i = j;
                if (localFragment3 == paramFragment)
                {
                  this.mOps.add(j, new FragmentTransaction.Op(9, localFragment3));
                  i = j + 1;
                  localFragment1 = null;
                }
                paramFragment = new FragmentTransaction.Op(3, localFragment3);
                paramFragment.mEnterAnim = ((FragmentTransaction.Op)localObject).mEnterAnim;
                paramFragment.mPopEnterAnim = ((FragmentTransaction.Op)localObject).mPopEnterAnim;
                paramFragment.mExitAnim = ((FragmentTransaction.Op)localObject).mExitAnim;
                paramFragment.mPopExitAnim = ((FragmentTransaction.Op)localObject).mPopExitAnim;
                this.mOps.add(i, paramFragment);
                paramArrayList.remove(localFragment3);
                i++;
                i1 = n;
              }
            }
            m--;
            paramFragment = localFragment1;
            j = i;
            n = i1;
          }
          if (n != 0)
          {
            this.mOps.remove(j);
            j--;
            break label441;
          }
          ((FragmentTransaction.Op)localObject).mCmd = 1;
          paramArrayList.add(localFragment2);
          break label441;
        }
      }
      paramArrayList.add(((FragmentTransaction.Op)localObject).mFragment);
      j = i;
      paramFragment = localFragment1;
      label441:
      i = j + 1;
    }
    return localFragment1;
  }
  
  public boolean generateOps(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1)
  {
    if (FragmentManager.isLoggingEnabled(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Run: ");
      localStringBuilder.append(this);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.FALSE);
    if (this.mAddToBackStack) {
      this.mManager.addBackStackState(this);
    }
    return true;
  }
  
  @Nullable
  public CharSequence getBreadCrumbShortTitle()
  {
    if (this.mBreadCrumbShortTitleRes != 0) {
      return this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes);
    }
    return this.mBreadCrumbShortTitleText;
  }
  
  public int getBreadCrumbShortTitleRes()
  {
    return this.mBreadCrumbShortTitleRes;
  }
  
  @Nullable
  public CharSequence getBreadCrumbTitle()
  {
    if (this.mBreadCrumbTitleRes != 0) {
      return this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes);
    }
    return this.mBreadCrumbTitleText;
  }
  
  public int getBreadCrumbTitleRes()
  {
    return this.mBreadCrumbTitleRes;
  }
  
  public int getId()
  {
    return this.mIndex;
  }
  
  @Nullable
  public String getName()
  {
    return this.mName;
  }
  
  @NonNull
  public FragmentTransaction hide(@NonNull Fragment paramFragment)
  {
    Object localObject = paramFragment.mFragmentManager;
    if ((localObject != null) && (localObject != this.mManager))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
      ((StringBuilder)localObject).append(paramFragment.toString());
      ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return super.hide(paramFragment);
  }
  
  boolean interactsWith(int paramInt)
  {
    int i = this.mOps.size();
    for (int j = 0; j < i; j++)
    {
      Fragment localFragment = ((FragmentTransaction.Op)this.mOps.get(j)).mFragment;
      int k;
      if (localFragment != null) {
        k = localFragment.mContainerId;
      } else {
        k = 0;
      }
      if ((k != 0) && (k == paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  boolean interactsWith(ArrayList<BackStackRecord> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return false;
    }
    int i = this.mOps.size();
    int j = -1;
    int k = 0;
    while (k < i)
    {
      Object localObject = ((FragmentTransaction.Op)this.mOps.get(k)).mFragment;
      int m;
      if (localObject != null) {
        m = ((Fragment)localObject).mContainerId;
      } else {
        m = 0;
      }
      int n = j;
      if (m != 0)
      {
        n = j;
        if (m != j)
        {
          for (j = paramInt1; j < paramInt2; j++)
          {
            localObject = (BackStackRecord)paramArrayList.get(j);
            int i1 = ((FragmentTransaction)localObject).mOps.size();
            for (n = 0; n < i1; n++)
            {
              Fragment localFragment = ((FragmentTransaction.Op)((FragmentTransaction)localObject).mOps.get(n)).mFragment;
              int i2;
              if (localFragment != null) {
                i2 = localFragment.mContainerId;
              } else {
                i2 = 0;
              }
              if (i2 == m) {
                return true;
              }
            }
          }
          n = m;
        }
      }
      k++;
      j = n;
    }
    return false;
  }
  
  public boolean isEmpty()
  {
    return this.mOps.isEmpty();
  }
  
  boolean isPostponed()
  {
    for (int i = 0; i < this.mOps.size(); i++) {
      if (isFragmentPostponed((FragmentTransaction.Op)this.mOps.get(i))) {
        return true;
      }
    }
    return false;
  }
  
  @NonNull
  public FragmentTransaction remove(@NonNull Fragment paramFragment)
  {
    Object localObject = paramFragment.mFragmentManager;
    if ((localObject != null) && (localObject != this.mManager))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
      ((StringBuilder)localObject).append(paramFragment.toString());
      ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return super.remove(paramFragment);
  }
  
  public void runOnCommitRunnables()
  {
    if (this.mCommitRunnables != null)
    {
      for (int i = 0; i < this.mCommitRunnables.size(); i++) {
        ((Runnable)this.mCommitRunnables.get(i)).run();
      }
      this.mCommitRunnables = null;
    }
  }
  
  @NonNull
  public FragmentTransaction setMaxLifecycle(@NonNull Fragment paramFragment, @NonNull Lifecycle.State paramState)
  {
    if (paramFragment.mFragmentManager == this.mManager)
    {
      Lifecycle.State localState = Lifecycle.State.CREATED;
      if (paramState.isAtLeast(localState)) {
        return super.setMaxLifecycle(paramFragment, paramState);
      }
      paramFragment = new StringBuilder();
      paramFragment.append("Cannot set maximum Lifecycle below ");
      paramFragment.append(localState);
      throw new IllegalArgumentException(paramFragment.toString());
    }
    paramFragment = new StringBuilder();
    paramFragment.append("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
    paramFragment.append(this.mManager);
    throw new IllegalArgumentException(paramFragment.toString());
  }
  
  void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener paramOnStartEnterTransitionListener)
  {
    for (int i = 0; i < this.mOps.size(); i++)
    {
      FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(i);
      if (isFragmentPostponed(localOp)) {
        localOp.mFragment.setOnStartEnterTransitionListener(paramOnStartEnterTransitionListener);
      }
    }
  }
  
  @NonNull
  public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      Object localObject = paramFragment.mFragmentManager;
      if ((localObject != null) && (localObject != this.mManager))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        ((StringBuilder)localObject).append(paramFragment.toString());
        ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    return super.setPrimaryNavigationFragment(paramFragment);
  }
  
  @NonNull
  public FragmentTransaction show(@NonNull Fragment paramFragment)
  {
    Object localObject = paramFragment.mFragmentManager;
    if ((localObject != null) && (localObject != this.mManager))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot show Fragment attached to a different FragmentManager. Fragment ");
      ((StringBuilder)localObject).append(paramFragment.toString());
      ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return super.show(paramFragment);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.mName != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mName);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  Fragment trackAddedFragmentsInPop(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    for (int i = this.mOps.size() - 1; i >= 0; i--)
    {
      FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(i);
      int j = localOp.mCmd;
      if (j != 1)
      {
        if (j != 3) {}
        switch (j)
        {
        default: 
          break;
        case 10: 
          localOp.mCurrentMaxState = localOp.mOldMaxState;
          break;
        case 9: 
          paramFragment = localOp.mFragment;
          break;
        case 8: 
          paramFragment = null;
          break;
        case 6: 
          paramArrayList.add(localOp.mFragment);
          break;
        }
      }
      else
      {
        paramArrayList.remove(localOp.mFragment);
      }
    }
    return paramFragment;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\BackStackRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */