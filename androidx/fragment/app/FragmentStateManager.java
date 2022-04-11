package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.R.id;
import androidx.lifecycle.ViewModelStoreOwner;

class FragmentStateManager
{
  private static final String TAG = "FragmentManager";
  private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  private static final String TARGET_STATE_TAG = "android:target_state";
  private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  private static final String VIEW_STATE_TAG = "android:view_state";
  private final FragmentLifecycleCallbacksDispatcher mDispatcher;
  @NonNull
  private final Fragment mFragment;
  private int mFragmentManagerState = -1;
  
  FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher paramFragmentLifecycleCallbacksDispatcher, @NonNull Fragment paramFragment)
  {
    this.mDispatcher = paramFragmentLifecycleCallbacksDispatcher;
    this.mFragment = paramFragment;
  }
  
  FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher paramFragmentLifecycleCallbacksDispatcher, @NonNull Fragment paramFragment, @NonNull FragmentState paramFragmentState)
  {
    this.mDispatcher = paramFragmentLifecycleCallbacksDispatcher;
    this.mFragment = paramFragment;
    paramFragment.mSavedViewState = null;
    paramFragment.mBackStackNesting = 0;
    paramFragment.mInLayout = false;
    paramFragment.mAdded = false;
    paramFragmentLifecycleCallbacksDispatcher = paramFragment.mTarget;
    if (paramFragmentLifecycleCallbacksDispatcher != null) {
      paramFragmentLifecycleCallbacksDispatcher = paramFragmentLifecycleCallbacksDispatcher.mWho;
    } else {
      paramFragmentLifecycleCallbacksDispatcher = null;
    }
    paramFragment.mTargetWho = paramFragmentLifecycleCallbacksDispatcher;
    paramFragment.mTarget = null;
    paramFragmentLifecycleCallbacksDispatcher = paramFragmentState.mSavedFragmentState;
    if (paramFragmentLifecycleCallbacksDispatcher != null) {
      paramFragment.mSavedFragmentState = paramFragmentLifecycleCallbacksDispatcher;
    } else {
      paramFragment.mSavedFragmentState = new Bundle();
    }
  }
  
  FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher paramFragmentLifecycleCallbacksDispatcher, @NonNull ClassLoader paramClassLoader, @NonNull FragmentFactory paramFragmentFactory, @NonNull FragmentState paramFragmentState)
  {
    this.mDispatcher = paramFragmentLifecycleCallbacksDispatcher;
    paramFragmentLifecycleCallbacksDispatcher = paramFragmentFactory.instantiate(paramClassLoader, paramFragmentState.mClassName);
    this.mFragment = paramFragmentLifecycleCallbacksDispatcher;
    paramFragmentFactory = paramFragmentState.mArguments;
    if (paramFragmentFactory != null) {
      paramFragmentFactory.setClassLoader(paramClassLoader);
    }
    paramFragmentLifecycleCallbacksDispatcher.setArguments(paramFragmentState.mArguments);
    paramFragmentLifecycleCallbacksDispatcher.mWho = paramFragmentState.mWho;
    paramFragmentLifecycleCallbacksDispatcher.mFromLayout = paramFragmentState.mFromLayout;
    paramFragmentLifecycleCallbacksDispatcher.mRestored = true;
    paramFragmentLifecycleCallbacksDispatcher.mFragmentId = paramFragmentState.mFragmentId;
    paramFragmentLifecycleCallbacksDispatcher.mContainerId = paramFragmentState.mContainerId;
    paramFragmentLifecycleCallbacksDispatcher.mTag = paramFragmentState.mTag;
    paramFragmentLifecycleCallbacksDispatcher.mRetainInstance = paramFragmentState.mRetainInstance;
    paramFragmentLifecycleCallbacksDispatcher.mRemoving = paramFragmentState.mRemoving;
    paramFragmentLifecycleCallbacksDispatcher.mDetached = paramFragmentState.mDetached;
    paramFragmentLifecycleCallbacksDispatcher.mHidden = paramFragmentState.mHidden;
    paramFragmentLifecycleCallbacksDispatcher.mMaxState = androidx.lifecycle.Lifecycle.State.values()[paramFragmentState.mMaxLifecycleState];
    paramClassLoader = paramFragmentState.mSavedFragmentState;
    if (paramClassLoader != null) {
      paramFragmentLifecycleCallbacksDispatcher.mSavedFragmentState = paramClassLoader;
    } else {
      paramFragmentLifecycleCallbacksDispatcher.mSavedFragmentState = new Bundle();
    }
    if (FragmentManager.isLoggingEnabled(2))
    {
      paramClassLoader = new StringBuilder();
      paramClassLoader.append("Instantiated fragment ");
      paramClassLoader.append(paramFragmentLifecycleCallbacksDispatcher);
      Log.v("FragmentManager", paramClassLoader.toString());
    }
  }
  
  private Bundle saveBasicState()
  {
    Object localObject1 = new Bundle();
    this.mFragment.performSaveInstanceState((Bundle)localObject1);
    this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, (Bundle)localObject1, false);
    Object localObject2 = localObject1;
    if (((Bundle)localObject1).isEmpty()) {
      localObject2 = null;
    }
    if (this.mFragment.mView != null) {
      saveViewState();
    }
    localObject1 = localObject2;
    if (this.mFragment.mSavedViewState != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putSparseParcelableArray("android:view_state", this.mFragment.mSavedViewState);
    }
    localObject2 = localObject1;
    if (!this.mFragment.mUserVisibleHint)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android:user_visible_hint", this.mFragment.mUserVisibleHint);
    }
    return (Bundle)localObject2;
  }
  
  void activityCreated()
  {
    if (FragmentManager.isLoggingEnabled(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto ACTIVITY_CREATED: ");
      ((StringBuilder)localObject).append(this.mFragment);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mFragment;
    ((Fragment)localObject).performActivityCreated(((Fragment)localObject).mSavedFragmentState);
    localObject = this.mDispatcher;
    Fragment localFragment = this.mFragment;
    ((FragmentLifecycleCallbacksDispatcher)localObject).dispatchOnFragmentActivityCreated(localFragment, localFragment.mSavedFragmentState, false);
  }
  
  void attach(@NonNull FragmentHostCallback<?> paramFragmentHostCallback, @NonNull FragmentManager paramFragmentManager, @Nullable Fragment paramFragment)
  {
    Fragment localFragment = this.mFragment;
    localFragment.mHost = paramFragmentHostCallback;
    localFragment.mParentFragment = paramFragment;
    localFragment.mFragmentManager = paramFragmentManager;
    this.mDispatcher.dispatchOnFragmentPreAttached(localFragment, paramFragmentHostCallback.getContext(), false);
    this.mFragment.performAttach();
    paramFragment = this.mFragment;
    paramFragmentManager = paramFragment.mParentFragment;
    if (paramFragmentManager == null) {
      paramFragmentHostCallback.onAttachFragment(paramFragment);
    } else {
      paramFragmentManager.onAttachFragment(paramFragment);
    }
    this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, paramFragmentHostCallback.getContext(), false);
  }
  
  int computeMaxState()
  {
    int i = this.mFragmentManagerState;
    Fragment localFragment = this.mFragment;
    int j = i;
    if (localFragment.mFromLayout) {
      if (localFragment.mInLayout) {
        j = Math.max(i, 1);
      } else if (i < 2) {
        j = Math.min(i, localFragment.mState);
      } else {
        j = Math.min(i, 1);
      }
    }
    i = j;
    if (!this.mFragment.mAdded) {
      i = Math.min(j, 1);
    }
    localFragment = this.mFragment;
    j = i;
    if (localFragment.mRemoving) {
      if (localFragment.isInBackStack()) {
        j = Math.min(i, 1);
      } else {
        j = Math.min(i, -1);
      }
    }
    localFragment = this.mFragment;
    i = j;
    if (localFragment.mDeferStart)
    {
      i = j;
      if (localFragment.mState < 3) {
        i = Math.min(j, 2);
      }
    }
    int k = 1.$SwitchMap$androidx$lifecycle$Lifecycle$State[this.mFragment.mMaxState.ordinal()];
    j = i;
    if (k != 1) {
      if (k != 2)
      {
        if (k != 3) {
          j = Math.min(i, -1);
        } else {
          j = Math.min(i, 1);
        }
      }
      else {
        j = Math.min(i, 3);
      }
    }
    return j;
  }
  
  void create()
  {
    if (FragmentManager.isLoggingEnabled(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto CREATED: ");
      ((StringBuilder)localObject).append(this.mFragment);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mFragment;
    if (!((Fragment)localObject).mIsCreated)
    {
      this.mDispatcher.dispatchOnFragmentPreCreated((Fragment)localObject, ((Fragment)localObject).mSavedFragmentState, false);
      localObject = this.mFragment;
      ((Fragment)localObject).performCreate(((Fragment)localObject).mSavedFragmentState);
      FragmentLifecycleCallbacksDispatcher localFragmentLifecycleCallbacksDispatcher = this.mDispatcher;
      localObject = this.mFragment;
      localFragmentLifecycleCallbacksDispatcher.dispatchOnFragmentCreated((Fragment)localObject, ((Fragment)localObject).mSavedFragmentState, false);
    }
    else
    {
      ((Fragment)localObject).restoreChildFragmentState(((Fragment)localObject).mSavedFragmentState);
      this.mFragment.mState = 1;
    }
  }
  
  void createView(@NonNull FragmentContainer paramFragmentContainer)
  {
    if (this.mFragment.mFromLayout) {
      return;
    }
    if (FragmentManager.isLoggingEnabled(3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("moveto CREATE_VIEW: ");
      ((StringBuilder)localObject1).append(this.mFragment);
      Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Fragment localFragment = this.mFragment;
    Object localObject1 = localFragment.mContainer;
    if (localObject1 == null)
    {
      int i = localFragment.mContainerId;
      localObject1 = localObject2;
      if (i != 0) {
        if (i != -1)
        {
          paramFragmentContainer = (ViewGroup)paramFragmentContainer.onFindViewById(i);
          localObject1 = paramFragmentContainer;
          if (paramFragmentContainer == null)
          {
            localObject1 = this.mFragment;
            if (((Fragment)localObject1).mRestored)
            {
              localObject1 = paramFragmentContainer;
            }
            else
            {
              try
              {
                paramFragmentContainer = ((Fragment)localObject1).getResources().getResourceName(this.mFragment.mContainerId);
              }
              catch (Resources.NotFoundException paramFragmentContainer)
              {
                paramFragmentContainer = "unknown";
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("No view found for id 0x");
              ((StringBuilder)localObject1).append(Integer.toHexString(this.mFragment.mContainerId));
              ((StringBuilder)localObject1).append(" (");
              ((StringBuilder)localObject1).append(paramFragmentContainer);
              ((StringBuilder)localObject1).append(") for fragment ");
              ((StringBuilder)localObject1).append(this.mFragment);
              throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
            }
          }
        }
        else
        {
          paramFragmentContainer = new StringBuilder();
          paramFragmentContainer.append("Cannot create fragment ");
          paramFragmentContainer.append(this.mFragment);
          paramFragmentContainer.append(" for a container view with no id");
          throw new IllegalArgumentException(paramFragmentContainer.toString());
        }
      }
    }
    paramFragmentContainer = this.mFragment;
    paramFragmentContainer.mContainer = ((ViewGroup)localObject1);
    paramFragmentContainer.performCreateView(paramFragmentContainer.performGetLayoutInflater(paramFragmentContainer.mSavedFragmentState), (ViewGroup)localObject1, this.mFragment.mSavedFragmentState);
    paramFragmentContainer = this.mFragment.mView;
    if (paramFragmentContainer != null)
    {
      boolean bool1 = false;
      paramFragmentContainer.setSaveFromParentEnabled(false);
      paramFragmentContainer = this.mFragment;
      paramFragmentContainer.mView.setTag(R.id.fragment_container_view_tag, paramFragmentContainer);
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView(this.mFragment.mView);
      }
      paramFragmentContainer = this.mFragment;
      if (paramFragmentContainer.mHidden) {
        paramFragmentContainer.mView.setVisibility(8);
      }
      ViewCompat.requestApplyInsets(this.mFragment.mView);
      paramFragmentContainer = this.mFragment;
      paramFragmentContainer.onViewCreated(paramFragmentContainer.mView, paramFragmentContainer.mSavedFragmentState);
      paramFragmentContainer = this.mDispatcher;
      localObject1 = this.mFragment;
      paramFragmentContainer.dispatchOnFragmentViewCreated((Fragment)localObject1, ((Fragment)localObject1).mView, ((Fragment)localObject1).mSavedFragmentState, false);
      paramFragmentContainer = this.mFragment;
      boolean bool2 = bool1;
      if (paramFragmentContainer.mView.getVisibility() == 0)
      {
        bool2 = bool1;
        if (this.mFragment.mContainer != null) {
          bool2 = true;
        }
      }
      paramFragmentContainer.mIsNewlyAdded = bool2;
    }
  }
  
  void destroy(@NonNull FragmentHostCallback<?> paramFragmentHostCallback, @NonNull FragmentManagerViewModel paramFragmentManagerViewModel)
  {
    if (FragmentManager.isLoggingEnabled(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("movefrom CREATED: ");
      ((StringBuilder)localObject).append(this.mFragment);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mFragment;
    boolean bool1 = ((Fragment)localObject).mRemoving;
    boolean bool2 = true;
    int i;
    if ((bool1) && (!((Fragment)localObject).isInBackStack())) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((i == 0) && (!paramFragmentManagerViewModel.shouldDestroy(this.mFragment))) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0)
    {
      if ((paramFragmentHostCallback instanceof ViewModelStoreOwner)) {
        bool2 = paramFragmentManagerViewModel.isCleared();
      } else if ((paramFragmentHostCallback.getContext() instanceof Activity)) {
        bool2 = true ^ ((Activity)paramFragmentHostCallback.getContext()).isChangingConfigurations();
      }
      if ((i != 0) || (bool2)) {
        paramFragmentManagerViewModel.clearNonConfigState(this.mFragment);
      }
      this.mFragment.performDestroy();
      this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
    }
    else
    {
      this.mFragment.mState = 0;
    }
  }
  
  void detach(@NonNull FragmentManagerViewModel paramFragmentManagerViewModel)
  {
    if (FragmentManager.isLoggingEnabled(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("movefrom ATTACHED: ");
      ((StringBuilder)localObject).append(this.mFragment);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    this.mFragment.performDetach();
    FragmentLifecycleCallbacksDispatcher localFragmentLifecycleCallbacksDispatcher = this.mDispatcher;
    Object localObject = this.mFragment;
    int i = 0;
    localFragmentLifecycleCallbacksDispatcher.dispatchOnFragmentDetached((Fragment)localObject, false);
    localObject = this.mFragment;
    ((Fragment)localObject).mState = -1;
    ((Fragment)localObject).mHost = null;
    ((Fragment)localObject).mParentFragment = null;
    ((Fragment)localObject).mFragmentManager = null;
    int j = i;
    if (((Fragment)localObject).mRemoving)
    {
      j = i;
      if (!((Fragment)localObject).isInBackStack()) {
        j = 1;
      }
    }
    if ((j != 0) || (paramFragmentManagerViewModel.shouldDestroy(this.mFragment)))
    {
      if (FragmentManager.isLoggingEnabled(3))
      {
        paramFragmentManagerViewModel = new StringBuilder();
        paramFragmentManagerViewModel.append("initState called for fragment: ");
        paramFragmentManagerViewModel.append(this.mFragment);
        Log.d("FragmentManager", paramFragmentManagerViewModel.toString());
      }
      this.mFragment.initState();
    }
  }
  
  void ensureInflatedView()
  {
    Object localObject = this.mFragment;
    if ((((Fragment)localObject).mFromLayout) && (((Fragment)localObject).mInLayout) && (!((Fragment)localObject).mPerformedCreateView))
    {
      if (FragmentManager.isLoggingEnabled(3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("moveto CREATE_VIEW: ");
        ((StringBuilder)localObject).append(this.mFragment);
        Log.d("FragmentManager", ((StringBuilder)localObject).toString());
      }
      localObject = this.mFragment;
      ((Fragment)localObject).performCreateView(((Fragment)localObject).performGetLayoutInflater(((Fragment)localObject).mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
      localObject = this.mFragment.mView;
      if (localObject != null)
      {
        ((View)localObject).setSaveFromParentEnabled(false);
        localObject = this.mFragment;
        ((Fragment)localObject).mView.setTag(R.id.fragment_container_view_tag, localObject);
        localObject = this.mFragment;
        if (((Fragment)localObject).mHidden) {
          ((Fragment)localObject).mView.setVisibility(8);
        }
        localObject = this.mFragment;
        ((Fragment)localObject).onViewCreated(((Fragment)localObject).mView, ((Fragment)localObject).mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher localFragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        localObject = this.mFragment;
        localFragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated((Fragment)localObject, ((Fragment)localObject).mView, ((Fragment)localObject).mSavedFragmentState, false);
      }
    }
  }
  
  @NonNull
  Fragment getFragment()
  {
    return this.mFragment;
  }
  
  void pause()
  {
    if (FragmentManager.isLoggingEnabled(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("movefrom RESUMED: ");
      localStringBuilder.append(this.mFragment);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    this.mFragment.performPause();
    this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
  }
  
  void restoreState(@NonNull ClassLoader paramClassLoader)
  {
    Object localObject = this.mFragment.mSavedFragmentState;
    if (localObject == null) {
      return;
    }
    ((Bundle)localObject).setClassLoader(paramClassLoader);
    paramClassLoader = this.mFragment;
    paramClassLoader.mSavedViewState = paramClassLoader.mSavedFragmentState.getSparseParcelableArray("android:view_state");
    paramClassLoader = this.mFragment;
    paramClassLoader.mTargetWho = paramClassLoader.mSavedFragmentState.getString("android:target_state");
    paramClassLoader = this.mFragment;
    if (paramClassLoader.mTargetWho != null) {
      paramClassLoader.mTargetRequestCode = paramClassLoader.mSavedFragmentState.getInt("android:target_req_state", 0);
    }
    paramClassLoader = this.mFragment;
    localObject = paramClassLoader.mSavedUserVisibleHint;
    if (localObject != null)
    {
      paramClassLoader.mUserVisibleHint = ((Boolean)localObject).booleanValue();
      this.mFragment.mSavedUserVisibleHint = null;
    }
    else
    {
      paramClassLoader.mUserVisibleHint = paramClassLoader.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
    }
    paramClassLoader = this.mFragment;
    if (!paramClassLoader.mUserVisibleHint) {
      paramClassLoader.mDeferStart = true;
    }
  }
  
  void restoreViewState()
  {
    if (FragmentManager.isLoggingEnabled(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto RESTORE_VIEW_STATE: ");
      ((StringBuilder)localObject).append(this.mFragment);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mFragment;
    if (((Fragment)localObject).mView != null) {
      ((Fragment)localObject).restoreViewState(((Fragment)localObject).mSavedFragmentState);
    }
    this.mFragment.mSavedFragmentState = null;
  }
  
  void resume()
  {
    if (FragmentManager.isLoggingEnabled(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto RESUMED: ");
      ((StringBuilder)localObject).append(this.mFragment);
      Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    this.mFragment.performResume();
    this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
    Object localObject = this.mFragment;
    ((Fragment)localObject).mSavedFragmentState = null;
    ((Fragment)localObject).mSavedViewState = null;
  }
  
  @Nullable
  Fragment.SavedState saveInstanceState()
  {
    int i = this.mFragment.mState;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (i > -1)
    {
      Bundle localBundle = saveBasicState();
      localObject2 = localObject1;
      if (localBundle != null) {
        localObject2 = new Fragment.SavedState(localBundle);
      }
    }
    return (Fragment.SavedState)localObject2;
  }
  
  @NonNull
  FragmentState saveState()
  {
    FragmentState localFragmentState = new FragmentState(this.mFragment);
    Object localObject = this.mFragment;
    if ((((Fragment)localObject).mState > -1) && (localFragmentState.mSavedFragmentState == null))
    {
      localObject = saveBasicState();
      localFragmentState.mSavedFragmentState = ((Bundle)localObject);
      if (this.mFragment.mTargetWho != null)
      {
        if (localObject == null) {
          localFragmentState.mSavedFragmentState = new Bundle();
        }
        localFragmentState.mSavedFragmentState.putString("android:target_state", this.mFragment.mTargetWho);
        int i = this.mFragment.mTargetRequestCode;
        if (i != 0) {
          localFragmentState.mSavedFragmentState.putInt("android:target_req_state", i);
        }
      }
    }
    else
    {
      localFragmentState.mSavedFragmentState = ((Fragment)localObject).mSavedFragmentState;
    }
    return localFragmentState;
  }
  
  void saveViewState()
  {
    if (this.mFragment.mView == null) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    this.mFragment.mView.saveHierarchyState(localSparseArray);
    if (localSparseArray.size() > 0) {
      this.mFragment.mSavedViewState = localSparseArray;
    }
  }
  
  void setFragmentManagerState(int paramInt)
  {
    this.mFragmentManagerState = paramInt;
  }
  
  void start()
  {
    if (FragmentManager.isLoggingEnabled(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveto STARTED: ");
      localStringBuilder.append(this.mFragment);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    this.mFragment.performStart();
    this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
  }
  
  void stop()
  {
    if (FragmentManager.isLoggingEnabled(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("movefrom STARTED: ");
      localStringBuilder.append(this.mFragment);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    this.mFragment.performStop();
    this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentStateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */