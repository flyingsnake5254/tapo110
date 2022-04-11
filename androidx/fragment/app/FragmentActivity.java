package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import androidx.core.app.ActivityCompat.PermissionCompatDelegate;
import androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator;
import androidx.core.app.SharedElementCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class FragmentActivity
  extends ComponentActivity
  implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator
{
  static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
  static final String FRAGMENTS_TAG = "android:support:fragments";
  static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
  static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
  static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
  private static final String TAG = "FragmentActivity";
  boolean mCreated;
  final LifecycleRegistry mFragmentLifecycleRegistry = new LifecycleRegistry(this);
  final FragmentController mFragments = FragmentController.createController(new HostCallbacks());
  int mNextCandidateRequestIndex;
  SparseArrayCompat<String> mPendingFragmentActivityResults;
  boolean mRequestedPermissionsFromFragment;
  boolean mResumed;
  boolean mStartedActivityFromFragment;
  boolean mStartedIntentSenderFromFragment;
  boolean mStopped = true;
  
  public FragmentActivity() {}
  
  @ContentView
  public FragmentActivity(@LayoutRes int paramInt)
  {
    super(paramInt);
  }
  
  private int allocateRequestIndex(@NonNull Fragment paramFragment)
  {
    if (this.mPendingFragmentActivityResults.size() < 65534)
    {
      while (this.mPendingFragmentActivityResults.indexOfKey(this.mNextCandidateRequestIndex) >= 0) {
        this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
      }
      int i = this.mNextCandidateRequestIndex;
      this.mPendingFragmentActivityResults.put(i, paramFragment.mWho);
      this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
      return i;
    }
    throw new IllegalStateException("Too many pending Fragment activity results.");
  }
  
  static void checkForValidRequestCode(int paramInt)
  {
    if ((paramInt & 0xFFFF0000) == 0) {
      return;
    }
    throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
  }
  
  private void markFragmentsCreated()
  {
    while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED)) {}
  }
  
  private static boolean markState(FragmentManager paramFragmentManager, Lifecycle.State paramState)
  {
    Iterator localIterator = paramFragmentManager.getFragments().iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      paramFragmentManager = (Fragment)localIterator.next();
      if (paramFragmentManager != null)
      {
        boolean bool2 = bool1;
        if (paramFragmentManager.getHost() != null) {
          bool2 = bool1 | markState(paramFragmentManager.getChildFragmentManager(), paramState);
        }
        bool1 = bool2;
        if (paramFragmentManager.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED))
        {
          paramFragmentManager.mLifecycleRegistry.setCurrentState(paramState);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  final View dispatchFragmentsOnCreateView(@Nullable View paramView, @NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return this.mFragments.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void dump(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("  ");
    localObject = ((StringBuilder)localObject).toString();
    paramPrintWriter.print((String)localObject);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    if (getApplication() != null) {
      LoaderManager.getInstance(this).dump((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.getSupportFragmentManager().dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @NonNull
  public FragmentManager getSupportFragmentManager()
  {
    return this.mFragments.getSupportFragmentManager();
  }
  
  @Deprecated
  @NonNull
  public LoaderManager getSupportLoaderManager()
  {
    return LoaderManager.getInstance(this);
  }
  
  @CallSuper
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    this.mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      i--;
      localObject = (String)this.mPendingFragmentActivityResults.get(i);
      this.mPendingFragmentActivityResults.remove(i);
      if (localObject == null)
      {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      }
      Fragment localFragment = this.mFragments.findFragmentByWho((String)localObject);
      if (localFragment == null)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("Activity result no fragment exists for who: ");
        paramIntent.append((String)localObject);
        Log.w("FragmentActivity", paramIntent.toString());
      }
      else
      {
        localFragment.onActivityResult(paramInt1 & 0xFFFF, paramInt2, paramIntent);
      }
      return;
    }
    Object localObject = ActivityCompat.getPermissionCompatDelegate();
    if ((localObject != null) && (((ActivityCompat.PermissionCompatDelegate)localObject).onActivityResult(this, paramInt1, paramInt2, paramIntent))) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(@NonNull Fragment paramFragment) {}
  
  public void onConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.noteStateNotSaved();
    this.mFragments.dispatchConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    this.mFragments.attachHost(null);
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getParcelable("android:support:fragments");
      this.mFragments.restoreSaveState((Parcelable)localObject);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        this.mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
        localObject = paramBundle.getIntArray("android:support:request_indicies");
        String[] arrayOfString = paramBundle.getStringArray("android:support:request_fragment_who");
        int i;
        if ((localObject != null) && (arrayOfString != null) && (localObject.length == arrayOfString.length))
        {
          this.mPendingFragmentActivityResults = new SparseArrayCompat(localObject.length);
          i = 0;
        }
        while (i < localObject.length)
        {
          this.mPendingFragmentActivityResults.put(localObject[i], arrayOfString[i]);
          i++;
          continue;
          Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
        }
      }
    }
    if (this.mPendingFragmentActivityResults == null)
    {
      this.mPendingFragmentActivityResults = new SparseArrayCompat();
      this.mNextCandidateRequestIndex = 0;
    }
    super.onCreate(paramBundle);
    this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    this.mFragments.dispatchCreate();
  }
  
  public boolean onCreatePanelMenu(int paramInt, @NonNull Menu paramMenu)
  {
    if (paramInt == 0) {
      return super.onCreatePanelMenu(paramInt, paramMenu) | this.mFragments.dispatchCreateOptionsMenu(paramMenu, getMenuInflater());
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  @Nullable
  public View onCreateView(@Nullable View paramView, @NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    View localView = dispatchFragmentsOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    if (localView == null) {
      return super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  @Nullable
  public View onCreateView(@NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    View localView = dispatchFragmentsOnCreateView(null, paramString, paramContext, paramAttributeSet);
    if (localView == null) {
      return super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mFragments.dispatchDestroy();
    this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.mFragments.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, @NonNull MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    if (paramInt != 0)
    {
      if (paramInt != 6) {
        return false;
      }
      return this.mFragments.dispatchContextItemSelected(paramMenuItem);
    }
    return this.mFragments.dispatchOptionsItemSelected(paramMenuItem);
  }
  
  @CallSuper
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    this.mFragments.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  @CallSuper
  protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.mFragments.noteStateNotSaved();
  }
  
  public void onPanelClosed(int paramInt, @NonNull Menu paramMenu)
  {
    if (paramInt == 0) {
      this.mFragments.dispatchOptionsMenuClosed(paramMenu);
    }
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mResumed = false;
    this.mFragments.dispatchPause();
    this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
  }
  
  @CallSuper
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.mFragments.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    onResumeFragments();
  }
  
  @Deprecated
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected boolean onPrepareOptionsPanel(@Nullable View paramView, @NonNull Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, @Nullable View paramView, @NonNull Menu paramMenu)
  {
    if (paramInt == 0) {
      return onPrepareOptionsPanel(paramView, paramMenu) | this.mFragments.dispatchPrepareOptionsMenu(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    this.mFragments.noteStateNotSaved();
    int i = paramInt >> 16 & 0xFFFF;
    if (i != 0)
    {
      i--;
      String str = (String)this.mPendingFragmentActivityResults.get(i);
      this.mPendingFragmentActivityResults.remove(i);
      if (str == null)
      {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      }
      Fragment localFragment = this.mFragments.findFragmentByWho(str);
      if (localFragment == null)
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Activity result no fragment exists for who: ");
        paramArrayOfString.append(str);
        Log.w("FragmentActivity", paramArrayOfString.toString());
      }
      else
      {
        localFragment.onRequestPermissionsResult(paramInt & 0xFFFF, paramArrayOfString, paramArrayOfInt);
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mResumed = true;
    this.mFragments.noteStateNotSaved();
    this.mFragments.execPendingActions();
  }
  
  protected void onResumeFragments()
  {
    this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.mFragments.dispatchResume();
  }
  
  protected void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    markFragmentsCreated();
    this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    Object localObject = this.mFragments.saveAllState();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (this.mPendingFragmentActivityResults.size() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", this.mNextCandidateRequestIndex);
      int[] arrayOfInt = new int[this.mPendingFragmentActivityResults.size()];
      localObject = new String[this.mPendingFragmentActivityResults.size()];
      for (int i = 0; i < this.mPendingFragmentActivityResults.size(); i++)
      {
        arrayOfInt[i] = this.mPendingFragmentActivityResults.keyAt(i);
        localObject[i] = ((String)this.mPendingFragmentActivityResults.valueAt(i));
      }
      paramBundle.putIntArray("android:support:request_indicies", arrayOfInt);
      paramBundle.putStringArray("android:support:request_fragment_who", (String[])localObject);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.mStopped = false;
    if (!this.mCreated)
    {
      this.mCreated = true;
      this.mFragments.dispatchActivityCreated();
    }
    this.mFragments.noteStateNotSaved();
    this.mFragments.execPendingActions();
    this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.mFragments.dispatchStart();
  }
  
  public void onStateNotSaved()
  {
    this.mFragments.noteStateNotSaved();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mStopped = true;
    markFragmentsCreated();
    this.mFragments.dispatchStop();
    this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
  }
  
  void requestPermissionsFromFragment(@NonNull Fragment paramFragment, @NonNull String[] paramArrayOfString, int paramInt)
  {
    if (paramInt == -1)
    {
      ActivityCompat.requestPermissions(this, paramArrayOfString, paramInt);
      return;
    }
    checkForValidRequestCode(paramInt);
    try
    {
      this.mRequestedPermissionsFromFragment = true;
      ActivityCompat.requestPermissions(this, paramArrayOfString, (allocateRequestIndex(paramFragment) + 1 << 16) + (paramInt & 0xFFFF));
      return;
    }
    finally
    {
      this.mRequestedPermissionsFromFragment = false;
    }
  }
  
  public void setEnterSharedElementCallback(@Nullable SharedElementCallback paramSharedElementCallback)
  {
    ActivityCompat.setEnterSharedElementCallback(this, paramSharedElementCallback);
  }
  
  public void setExitSharedElementCallback(@Nullable SharedElementCallback paramSharedElementCallback)
  {
    ActivityCompat.setExitSharedElementCallback(this, paramSharedElementCallback);
  }
  
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    if ((!this.mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if ((!this.mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startActivityFromFragment(@NonNull Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void startActivityFromFragment(@NonNull Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    this.mStartedActivityFromFragment = true;
    if (paramInt == -1) {}
    try
    {
      ActivityCompat.startActivityForResult(this, paramIntent, -1, paramBundle);
      return;
    }
    finally
    {
      this.mStartedActivityFromFragment = false;
    }
    checkForValidRequestCode(paramInt);
    ActivityCompat.startActivityForResult(this, paramIntent, (allocateRequestIndex(paramFragment) + 1 << 16) + (paramInt & 0xFFFF), paramBundle);
    this.mStartedActivityFromFragment = false;
  }
  
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
    throws IntentSender.SendIntentException
  {
    if ((!this.mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if ((!this.mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void startIntentSenderFromFragment(@NonNull Fragment paramFragment, @SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    this.mStartedIntentSenderFromFragment = true;
    if (paramInt1 == -1) {}
    try
    {
      ActivityCompat.startIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    finally
    {
      this.mStartedIntentSenderFromFragment = false;
    }
    checkForValidRequestCode(paramInt1);
    ActivityCompat.startIntentSenderForResult(this, paramIntentSender, (allocateRequestIndex(paramFragment) + 1 << 16) + (paramInt1 & 0xFFFF), paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    this.mStartedIntentSenderFromFragment = false;
  }
  
  public void supportFinishAfterTransition()
  {
    ActivityCompat.finishAfterTransition(this);
  }
  
  @Deprecated
  public void supportInvalidateOptionsMenu()
  {
    invalidateOptionsMenu();
  }
  
  public void supportPostponeEnterTransition()
  {
    ActivityCompat.postponeEnterTransition(this);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    ActivityCompat.startPostponedEnterTransition(this);
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt)
  {
    if ((!this.mRequestedPermissionsFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
  }
  
  class HostCallbacks
    extends FragmentHostCallback<FragmentActivity>
    implements ViewModelStoreOwner, OnBackPressedDispatcherOwner
  {
    public HostCallbacks()
    {
      super();
    }
    
    @NonNull
    public Lifecycle getLifecycle()
    {
      return FragmentActivity.this.mFragmentLifecycleRegistry;
    }
    
    @NonNull
    public OnBackPressedDispatcher getOnBackPressedDispatcher()
    {
      return FragmentActivity.this.getOnBackPressedDispatcher();
    }
    
    @NonNull
    public ViewModelStore getViewModelStore()
    {
      return FragmentActivity.this.getViewModelStore();
    }
    
    public void onAttachFragment(@NonNull Fragment paramFragment)
    {
      FragmentActivity.this.onAttachFragment(paramFragment);
    }
    
    public void onDump(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString)
    {
      FragmentActivity.this.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    
    @Nullable
    public View onFindViewById(int paramInt)
    {
      return FragmentActivity.this.findViewById(paramInt);
    }
    
    public FragmentActivity onGetHost()
    {
      return FragmentActivity.this;
    }
    
    @NonNull
    public LayoutInflater onGetLayoutInflater()
    {
      return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
    }
    
    public int onGetWindowAnimations()
    {
      Window localWindow = FragmentActivity.this.getWindow();
      int i;
      if (localWindow == null) {
        i = 0;
      } else {
        i = localWindow.getAttributes().windowAnimations;
      }
      return i;
    }
    
    public boolean onHasView()
    {
      Window localWindow = FragmentActivity.this.getWindow();
      boolean bool;
      if ((localWindow != null) && (localWindow.peekDecorView() != null)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean onHasWindowAnimations()
    {
      boolean bool;
      if (FragmentActivity.this.getWindow() != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void onRequestPermissionsFromFragment(@NonNull Fragment paramFragment, @NonNull String[] paramArrayOfString, int paramInt)
    {
      FragmentActivity.this.requestPermissionsFromFragment(paramFragment, paramArrayOfString, paramInt);
    }
    
    public boolean onShouldSaveFragmentState(@NonNull Fragment paramFragment)
    {
      return FragmentActivity.this.isFinishing() ^ true;
    }
    
    public boolean onShouldShowRequestPermissionRationale(@NonNull String paramString)
    {
      return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, paramString);
    }
    
    public void onStartActivityFromFragment(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt)
    {
      FragmentActivity.this.startActivityFromFragment(paramFragment, paramIntent, paramInt);
    }
    
    public void onStartActivityFromFragment(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
    {
      FragmentActivity.this.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
    }
    
    public void onStartIntentSenderFromFragment(@NonNull Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
      throws IntentSender.SendIntentException
    {
      FragmentActivity.this.startIntentSenderFromFragment(paramFragment, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    }
    
    public void onSupportInvalidateOptionsMenu()
    {
      FragmentActivity.this.supportInvalidateOptionsMenu();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */