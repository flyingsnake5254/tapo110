package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavController
{
  private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
  static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
  static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
  static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
  @NonNull
  public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
  private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
  private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
  private static final String TAG = "NavController";
  private Activity mActivity;
  final Deque<NavBackStackEntry> mBackStack = new ArrayDeque();
  private Parcelable[] mBackStackToRestore;
  private final Context mContext;
  private boolean mDeepLinkHandled;
  private boolean mEnableOnBackPressedCallback = true;
  NavGraph mGraph;
  private NavInflater mInflater;
  private final LifecycleObserver mLifecycleObserver = new LifecycleEventObserver()
  {
    public void onStateChanged(@NonNull LifecycleOwner paramAnonymousLifecycleOwner, @NonNull Lifecycle.Event paramAnonymousEvent)
    {
      paramAnonymousLifecycleOwner = NavController.this;
      if (paramAnonymousLifecycleOwner.mGraph != null)
      {
        paramAnonymousLifecycleOwner = paramAnonymousLifecycleOwner.mBackStack.iterator();
        while (paramAnonymousLifecycleOwner.hasNext()) {
          ((NavBackStackEntry)paramAnonymousLifecycleOwner.next()).handleLifecycleEvent(paramAnonymousEvent);
        }
      }
    }
  };
  private LifecycleOwner mLifecycleOwner;
  private NavigatorProvider mNavigatorProvider = new NavigatorProvider();
  private Bundle mNavigatorStateToRestore;
  private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false)
  {
    public void handleOnBackPressed()
    {
      NavController.this.popBackStack();
    }
  };
  private final CopyOnWriteArrayList<OnDestinationChangedListener> mOnDestinationChangedListeners = new CopyOnWriteArrayList();
  private NavControllerViewModel mViewModel;
  
  public NavController(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
    while ((paramContext instanceof ContextWrapper))
    {
      if ((paramContext instanceof Activity))
      {
        this.mActivity = ((Activity)paramContext);
        break;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    paramContext = this.mNavigatorProvider;
    paramContext.addNavigator(new NavGraphNavigator(paramContext));
    this.mNavigatorProvider.addNavigator(new ActivityNavigator(this.mContext));
  }
  
  private boolean dispatchOnDestinationChanged()
  {
    while ((!this.mBackStack.isEmpty()) && ((((NavBackStackEntry)this.mBackStack.peekLast()).getDestination() instanceof NavGraph)) && (popBackStackInternal(((NavBackStackEntry)this.mBackStack.peekLast()).getDestination().getId(), true))) {}
    if (!this.mBackStack.isEmpty())
    {
      Object localObject1 = ((NavBackStackEntry)this.mBackStack.peekLast()).getDestination();
      HashMap localHashMap = null;
      Object localObject2 = localHashMap;
      if ((localObject1 instanceof FloatingWindow))
      {
        localIterator = this.mBackStack.descendingIterator();
        do
        {
          localObject2 = localHashMap;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = ((NavBackStackEntry)localIterator.next()).getDestination();
        } while (((localObject2 instanceof NavGraph)) || ((localObject2 instanceof FloatingWindow)));
      }
      localHashMap = new HashMap();
      Iterator localIterator = this.mBackStack.descendingIterator();
      while (localIterator.hasNext())
      {
        NavBackStackEntry localNavBackStackEntry = (NavBackStackEntry)localIterator.next();
        Lifecycle.State localState = localNavBackStackEntry.getMaxLifecycle();
        Object localObject3 = localNavBackStackEntry.getDestination();
        if ((localObject1 != null) && (((NavDestination)localObject3).getId() == ((NavDestination)localObject1).getId()))
        {
          localObject3 = Lifecycle.State.RESUMED;
          if (localState != localObject3) {
            localHashMap.put(localNavBackStackEntry, localObject3);
          }
          localObject1 = ((NavDestination)localObject1).getParent();
        }
        else if ((localObject2 != null) && (((NavDestination)localObject3).getId() == ((NavDestination)localObject2).getId()))
        {
          if (localState == Lifecycle.State.RESUMED)
          {
            localNavBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
          }
          else
          {
            localObject3 = Lifecycle.State.STARTED;
            if (localState != localObject3) {
              localHashMap.put(localNavBackStackEntry, localObject3);
            }
          }
          localObject2 = ((NavDestination)localObject2).getParent();
        }
        else
        {
          localNavBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
        }
      }
      localIterator = this.mBackStack.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (NavBackStackEntry)localIterator.next();
        localObject2 = (Lifecycle.State)localHashMap.get(localObject1);
        if (localObject2 != null) {
          ((NavBackStackEntry)localObject1).setMaxLifecycle((Lifecycle.State)localObject2);
        } else {
          ((NavBackStackEntry)localObject1).updateState();
        }
      }
      localObject2 = (NavBackStackEntry)this.mBackStack.peekLast();
      localObject1 = this.mOnDestinationChangedListeners.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((OnDestinationChangedListener)((Iterator)localObject1).next()).onDestinationChanged(this, ((NavBackStackEntry)localObject2).getDestination(), ((NavBackStackEntry)localObject2).getArguments());
      }
      return true;
    }
    return false;
  }
  
  @Nullable
  private String findInvalidDestinationDisplayNameInDeepLink(@NonNull int[] paramArrayOfInt)
  {
    Object localObject1 = this.mGraph;
    for (int i = 0;; i++)
    {
      int j = paramArrayOfInt.length;
      Object localObject2 = null;
      if (i >= j) {
        break;
      }
      j = paramArrayOfInt[i];
      if (i == 0)
      {
        if (this.mGraph.getId() == j) {
          localObject2 = this.mGraph;
        }
      }
      else {
        localObject2 = ((NavGraph)localObject1).findNode(j);
      }
      if (localObject2 == null) {
        return NavDestination.getDisplayName(this.mContext, j);
      }
      if (i != paramArrayOfInt.length - 1)
      {
        for (localObject2 = (NavGraph)localObject2; (((NavGraph)localObject2).findNode(((NavGraph)localObject2).getStartDestination()) instanceof NavGraph); localObject2 = (NavGraph)((NavGraph)localObject2).findNode(((NavGraph)localObject2).getStartDestination())) {}
        localObject1 = localObject2;
      }
    }
    return null;
  }
  
  private int getDestinationCountOnBackStack()
  {
    Iterator localIterator = this.mBackStack.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (!(((NavBackStackEntry)localIterator.next()).getDestination() instanceof NavGraph)) {
        i++;
      }
    }
    return i;
  }
  
  private void navigate(@NonNull NavDestination paramNavDestination, @Nullable Bundle paramBundle, @Nullable NavOptions paramNavOptions, @Nullable Navigator.Extras paramExtras)
  {
    int i = 0;
    boolean bool;
    if ((paramNavOptions != null) && (paramNavOptions.getPopUpTo() != -1)) {
      bool = popBackStackInternal(paramNavOptions.getPopUpTo(), paramNavOptions.isPopUpToInclusive());
    } else {
      bool = false;
    }
    Navigator localNavigator = this.mNavigatorProvider.getNavigator(paramNavDestination.getNavigatorName());
    Bundle localBundle = paramNavDestination.addInDefaultArgs(paramBundle);
    paramBundle = localNavigator.navigate(paramNavDestination, localBundle, paramNavOptions, paramExtras);
    while ((!(paramBundle instanceof FloatingWindow)) && (!this.mBackStack.isEmpty()) && ((((NavBackStackEntry)this.mBackStack.peekLast()).getDestination() instanceof FloatingWindow)) && (popBackStackInternal(((NavBackStackEntry)this.mBackStack.peekLast()).getDestination().getId(), true))) {}
    paramExtras = new ArrayDeque();
    if ((paramNavDestination instanceof NavGraph))
    {
      paramNavOptions = paramBundle;
      for (;;)
      {
        paramNavOptions = paramNavOptions.getParent();
        if (paramNavOptions != null)
        {
          paramExtras.addFirst(new NavBackStackEntry(this.mContext, paramNavOptions, localBundle, this.mLifecycleOwner, this.mViewModel));
          if ((!this.mBackStack.isEmpty()) && (((NavBackStackEntry)this.mBackStack.getLast()).getDestination() == paramNavOptions)) {
            popBackStackInternal(paramNavOptions.getId(), true);
          }
        }
        if ((paramNavOptions == null) || (paramNavOptions == paramNavDestination)) {
          break;
        }
      }
    }
    if (paramExtras.isEmpty()) {
      paramNavDestination = paramBundle;
    } else {
      paramNavDestination = ((NavBackStackEntry)paramExtras.getFirst()).getDestination();
    }
    while ((paramNavDestination != null) && (findDestination(paramNavDestination.getId()) == null))
    {
      paramNavOptions = paramNavDestination.getParent();
      paramNavDestination = paramNavOptions;
      if (paramNavOptions != null)
      {
        paramExtras.addFirst(new NavBackStackEntry(this.mContext, paramNavOptions, localBundle, this.mLifecycleOwner, this.mViewModel));
        paramNavDestination = paramNavOptions;
      }
    }
    if (paramExtras.isEmpty()) {
      paramNavDestination = paramBundle;
    }
    while ((!this.mBackStack.isEmpty()) && ((((NavBackStackEntry)this.mBackStack.getLast()).getDestination() instanceof NavGraph)) && (((NavGraph)((NavBackStackEntry)this.mBackStack.getLast()).getDestination()).findNode(paramNavDestination.getId(), false) == null) && (popBackStackInternal(((NavBackStackEntry)this.mBackStack.getLast()).getDestination().getId(), true))) {}
    this.mBackStack.addAll(paramExtras);
    if ((this.mBackStack.isEmpty()) || (((NavBackStackEntry)this.mBackStack.getFirst()).getDestination() != this.mGraph))
    {
      paramNavDestination = new NavBackStackEntry(this.mContext, this.mGraph, localBundle, this.mLifecycleOwner, this.mViewModel);
      this.mBackStack.addFirst(paramNavDestination);
    }
    paramNavDestination = new NavBackStackEntry(this.mContext, paramBundle, paramBundle.addInDefaultArgs(localBundle), this.mLifecycleOwner, this.mViewModel);
    this.mBackStack.add(paramNavDestination);
    int j = i;
    break label621;
    j = i;
    if (paramNavOptions != null)
    {
      j = i;
      if (paramNavOptions.shouldLaunchSingleTop())
      {
        paramNavDestination = (NavBackStackEntry)this.mBackStack.peekLast();
        if (paramNavDestination != null) {
          paramNavDestination.replaceArguments(localBundle);
        }
        j = 1;
      }
    }
    label621:
    updateOnBackPressedCallbackEnabled();
    if ((bool) || (paramBundle != null) || (j != 0)) {
      dispatchOnDestinationChanged();
    }
  }
  
  private void onGraphCreated(@Nullable Bundle paramBundle)
  {
    Object localObject1 = this.mNavigatorStateToRestore;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("android-support-nav:controller:navigatorState:names");
      if (localObject1 != null)
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject1 = this.mNavigatorProvider.getNavigator((String)localObject3);
          localObject3 = this.mNavigatorStateToRestore.getBundle((String)localObject3);
          if (localObject3 != null) {
            ((Navigator)localObject1).onRestoreState((Bundle)localObject3);
          }
        }
      }
    }
    localObject1 = this.mBackStackToRestore;
    int i = 0;
    int k;
    if (localObject1 != null)
    {
      int j = localObject1.length;
      k = 0;
      while (k < j)
      {
        localObject3 = (NavBackStackEntryState)localObject1[k];
        localObject2 = findDestination(((NavBackStackEntryState)localObject3).getDestinationId());
        if (localObject2 != null)
        {
          Bundle localBundle = ((NavBackStackEntryState)localObject3).getArgs();
          if (localBundle != null) {
            localBundle.setClassLoader(this.mContext.getClassLoader());
          }
          localObject2 = new NavBackStackEntry(this.mContext, (NavDestination)localObject2, localBundle, this.mLifecycleOwner, this.mViewModel, ((NavBackStackEntryState)localObject3).getUUID(), ((NavBackStackEntryState)localObject3).getSavedState());
          this.mBackStack.add(localObject2);
          k++;
        }
        else
        {
          paramBundle = NavDestination.getDisplayName(this.mContext, ((NavBackStackEntryState)localObject3).getDestinationId());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Restoring the Navigation back stack failed: destination ");
          ((StringBuilder)localObject1).append(paramBundle);
          ((StringBuilder)localObject1).append(" cannot be found from the current destination ");
          ((StringBuilder)localObject1).append(getCurrentDestination());
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
      }
      updateOnBackPressedCallbackEnabled();
      this.mBackStackToRestore = null;
    }
    if ((this.mGraph != null) && (this.mBackStack.isEmpty()))
    {
      k = i;
      if (!this.mDeepLinkHandled)
      {
        localObject1 = this.mActivity;
        k = i;
        if (localObject1 != null)
        {
          k = i;
          if (handleDeepLink(((Activity)localObject1).getIntent())) {
            k = 1;
          }
        }
      }
      if (k == 0) {
        navigate(this.mGraph, paramBundle, null, null);
      }
    }
    else
    {
      dispatchOnDestinationChanged();
    }
  }
  
  private void updateOnBackPressedCallbackEnabled()
  {
    OnBackPressedCallback localOnBackPressedCallback = this.mOnBackPressedCallback;
    boolean bool1 = this.mEnableOnBackPressedCallback;
    boolean bool2 = true;
    if ((!bool1) || (getDestinationCountOnBackStack() <= 1)) {
      bool2 = false;
    }
    localOnBackPressedCallback.setEnabled(bool2);
  }
  
  public void addOnDestinationChangedListener(@NonNull OnDestinationChangedListener paramOnDestinationChangedListener)
  {
    if (!this.mBackStack.isEmpty())
    {
      NavBackStackEntry localNavBackStackEntry = (NavBackStackEntry)this.mBackStack.peekLast();
      paramOnDestinationChangedListener.onDestinationChanged(this, localNavBackStackEntry.getDestination(), localNavBackStackEntry.getArguments());
    }
    this.mOnDestinationChangedListeners.add(paramOnDestinationChangedListener);
  }
  
  @NonNull
  public NavDeepLinkBuilder createDeepLink()
  {
    return new NavDeepLinkBuilder(this);
  }
  
  void enableOnBackPressed(boolean paramBoolean)
  {
    this.mEnableOnBackPressedCallback = paramBoolean;
    updateOnBackPressedCallbackEnabled();
  }
  
  NavDestination findDestination(@IdRes int paramInt)
  {
    Object localObject = this.mGraph;
    if (localObject == null) {
      return null;
    }
    if (((NavDestination)localObject).getId() == paramInt) {
      return this.mGraph;
    }
    if (this.mBackStack.isEmpty()) {
      localObject = this.mGraph;
    } else {
      localObject = ((NavBackStackEntry)this.mBackStack.getLast()).getDestination();
    }
    if ((localObject instanceof NavGraph)) {
      localObject = (NavGraph)localObject;
    } else {
      localObject = ((NavDestination)localObject).getParent();
    }
    return ((NavGraph)localObject).findNode(paramInt);
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public Deque<NavBackStackEntry> getBackStack()
  {
    return this.mBackStack;
  }
  
  @NonNull
  public NavBackStackEntry getBackStackEntry(@IdRes int paramInt)
  {
    Iterator localIterator = this.mBackStack.descendingIterator();
    while (localIterator.hasNext())
    {
      localObject = (NavBackStackEntry)localIterator.next();
      if (((NavBackStackEntry)localObject).getDestination().getId() == paramInt) {
        break label45;
      }
    }
    Object localObject = null;
    label45:
    if (localObject != null) {
      return (NavBackStackEntry)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No destination with ID ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" is on the NavController's back stack. The current destination is ");
    ((StringBuilder)localObject).append(getCurrentDestination());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  @NonNull
  Context getContext()
  {
    return this.mContext;
  }
  
  @Nullable
  public NavBackStackEntry getCurrentBackStackEntry()
  {
    if (this.mBackStack.isEmpty()) {
      return null;
    }
    return (NavBackStackEntry)this.mBackStack.getLast();
  }
  
  @Nullable
  public NavDestination getCurrentDestination()
  {
    Object localObject = getCurrentBackStackEntry();
    if (localObject != null) {
      localObject = ((NavBackStackEntry)localObject).getDestination();
    } else {
      localObject = null;
    }
    return (NavDestination)localObject;
  }
  
  @NonNull
  public NavGraph getGraph()
  {
    NavGraph localNavGraph = this.mGraph;
    if (localNavGraph != null) {
      return localNavGraph;
    }
    throw new IllegalStateException("You must call setGraph() before calling getGraph()");
  }
  
  @NonNull
  public NavInflater getNavInflater()
  {
    if (this.mInflater == null) {
      this.mInflater = new NavInflater(this.mContext, this.mNavigatorProvider);
    }
    return this.mInflater;
  }
  
  @NonNull
  public NavigatorProvider getNavigatorProvider()
  {
    return this.mNavigatorProvider;
  }
  
  @Nullable
  public NavBackStackEntry getPreviousBackStackEntry()
  {
    Iterator localIterator = this.mBackStack.descendingIterator();
    if (localIterator.hasNext()) {
      localIterator.next();
    }
    while (localIterator.hasNext())
    {
      NavBackStackEntry localNavBackStackEntry = (NavBackStackEntry)localIterator.next();
      if (!(localNavBackStackEntry.getDestination() instanceof NavGraph)) {
        return localNavBackStackEntry;
      }
    }
    return null;
  }
  
  @NonNull
  public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int paramInt)
  {
    if (this.mViewModel != null)
    {
      Object localObject = getBackStackEntry(paramInt);
      if ((((NavBackStackEntry)localObject).getDestination() instanceof NavGraph)) {
        return (ViewModelStoreOwner)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No NavGraph with ID ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" is on the NavController's back stack");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
  }
  
  public boolean handleDeepLink(@Nullable Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    Object localObject1 = paramIntent.getExtras();
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = ((Bundle)localObject1).getIntArray("android-support-nav:controller:deepLinkIds");
    } else {
      localObject2 = null;
    }
    Bundle localBundle = new Bundle();
    if (localObject1 != null) {
      localObject1 = ((Bundle)localObject1).getBundle("android-support-nav:controller:deepLinkExtras");
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      localBundle.putAll((Bundle)localObject1);
    }
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = localObject2;
      if (paramIntent.getData() != null)
      {
        NavDestination.DeepLinkMatch localDeepLinkMatch = this.mGraph.matchDeepLink(new NavDeepLinkRequest(paramIntent));
        localObject1 = localObject2;
        if (localDeepLinkMatch != null)
        {
          localObject2 = localDeepLinkMatch.getDestination();
          localObject1 = ((NavDestination)localObject2).buildDeepLinkIds();
          localBundle.putAll(((NavDestination)localObject2).addInDefaultArgs(localDeepLinkMatch.getMatchingArgs()));
        }
      }
    }
    if ((localObject1 != null) && (localObject1.length != 0))
    {
      localObject2 = findInvalidDestinationDisplayNameInDeepLink((int[])localObject1);
      if (localObject2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Could not find destination ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" in the navigation graph, ignoring the deep link from ");
        ((StringBuilder)localObject1).append(paramIntent);
        Log.i("NavController", ((StringBuilder)localObject1).toString());
        return false;
      }
      localBundle.putParcelable("android-support-nav:controller:deepLinkIntent", paramIntent);
      int i = paramIntent.getFlags();
      int j = 0x10000000 & i;
      if ((j != 0) && ((i & 0x8000) == 0))
      {
        paramIntent.addFlags(32768);
        TaskStackBuilder.create(this.mContext).addNextIntentWithParentStack(paramIntent).startActivities();
        paramIntent = this.mActivity;
        if (paramIntent != null)
        {
          paramIntent.finish();
          this.mActivity.overridePendingTransition(0, 0);
        }
        return true;
      }
      if (j != 0)
      {
        if (!this.mBackStack.isEmpty()) {
          popBackStackInternal(this.mGraph.getId(), true);
        }
        j = 0;
        while (j < localObject1.length)
        {
          i = localObject1[j];
          paramIntent = findDestination(i);
          if (paramIntent != null)
          {
            navigate(paramIntent, localBundle, new NavOptions.Builder().setEnterAnim(0).setExitAnim(0).build(), null);
            j++;
          }
          else
          {
            localObject2 = NavDestination.getDisplayName(this.mContext, i);
            paramIntent = new StringBuilder();
            paramIntent.append("Deep Linking failed: destination ");
            paramIntent.append((String)localObject2);
            paramIntent.append(" cannot be found from the current destination ");
            paramIntent.append(getCurrentDestination());
            throw new IllegalStateException(paramIntent.toString());
          }
        }
        return true;
      }
      paramIntent = this.mGraph;
      j = 0;
      while (j < localObject1.length)
      {
        i = localObject1[j];
        if (j == 0) {
          localObject2 = this.mGraph;
        } else {
          localObject2 = paramIntent.findNode(i);
        }
        if (localObject2 != null)
        {
          if (j != localObject1.length - 1) {
            for (paramIntent = (NavGraph)localObject2; (paramIntent.findNode(paramIntent.getStartDestination()) instanceof NavGraph); paramIntent = (NavGraph)paramIntent.findNode(paramIntent.getStartDestination())) {}
          } else {
            navigate((NavDestination)localObject2, ((NavDestination)localObject2).addInDefaultArgs(localBundle), new NavOptions.Builder().setPopUpTo(this.mGraph.getId(), true).setEnterAnim(0).setExitAnim(0).build(), null);
          }
          j++;
        }
        else
        {
          localObject2 = NavDestination.getDisplayName(this.mContext, i);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Deep Linking failed: destination ");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(" cannot be found in graph ");
          ((StringBuilder)localObject1).append(paramIntent);
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
      }
      this.mDeepLinkHandled = true;
      return true;
    }
    return false;
  }
  
  public void navigate(@IdRes int paramInt)
  {
    navigate(paramInt, null);
  }
  
  public void navigate(@IdRes int paramInt, @Nullable Bundle paramBundle)
  {
    navigate(paramInt, paramBundle, null);
  }
  
  public void navigate(@IdRes int paramInt, @Nullable Bundle paramBundle, @Nullable NavOptions paramNavOptions)
  {
    navigate(paramInt, paramBundle, paramNavOptions, null);
  }
  
  public void navigate(@IdRes int paramInt, @Nullable Bundle paramBundle, @Nullable NavOptions paramNavOptions, @Nullable Navigator.Extras paramExtras)
  {
    Object localObject1;
    if (this.mBackStack.isEmpty()) {
      localObject1 = this.mGraph;
    } else {
      localObject1 = ((NavBackStackEntry)this.mBackStack.getLast()).getDestination();
    }
    if (localObject1 != null)
    {
      NavAction localNavAction = ((NavDestination)localObject1).getAction(paramInt);
      Object localObject2 = null;
      int j;
      Object localObject4;
      if (localNavAction != null)
      {
        localObject3 = paramNavOptions;
        if (paramNavOptions == null) {
          localObject3 = localNavAction.getNavOptions();
        }
        int i = localNavAction.getDestinationId();
        Bundle localBundle = localNavAction.getDefaultArguments();
        paramNavOptions = (NavOptions)localObject2;
        j = i;
        localObject4 = localObject3;
        if (localBundle != null)
        {
          paramNavOptions = new Bundle();
          paramNavOptions.putAll(localBundle);
          j = i;
          localObject4 = localObject3;
        }
      }
      else
      {
        j = paramInt;
        localObject4 = paramNavOptions;
        paramNavOptions = (NavOptions)localObject2;
      }
      Object localObject3 = paramNavOptions;
      if (paramBundle != null)
      {
        localObject3 = paramNavOptions;
        if (paramNavOptions == null) {
          localObject3 = new Bundle();
        }
        ((Bundle)localObject3).putAll(paramBundle);
      }
      if ((j == 0) && (localObject4 != null) && (((NavOptions)localObject4).getPopUpTo() != -1))
      {
        popBackStack(((NavOptions)localObject4).getPopUpTo(), ((NavOptions)localObject4).isPopUpToInclusive());
        return;
      }
      if (j != 0)
      {
        paramBundle = findDestination(j);
        if (paramBundle == null)
        {
          paramBundle = NavDestination.getDisplayName(this.mContext, j);
          if (localNavAction != null)
          {
            paramNavOptions = new StringBuilder();
            paramNavOptions.append("Navigation destination ");
            paramNavOptions.append(paramBundle);
            paramNavOptions.append(" referenced from action ");
            paramNavOptions.append(NavDestination.getDisplayName(this.mContext, paramInt));
            paramNavOptions.append(" cannot be found from the current destination ");
            paramNavOptions.append(localObject1);
            throw new IllegalArgumentException(paramNavOptions.toString());
          }
          paramNavOptions = new StringBuilder();
          paramNavOptions.append("Navigation action/destination ");
          paramNavOptions.append(paramBundle);
          paramNavOptions.append(" cannot be found from the current destination ");
          paramNavOptions.append(localObject1);
          throw new IllegalArgumentException(paramNavOptions.toString());
        }
        navigate(paramBundle, (Bundle)localObject3, (NavOptions)localObject4, paramExtras);
        return;
      }
      throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
    }
    throw new IllegalStateException("no current navigation node");
  }
  
  public void navigate(@NonNull Uri paramUri)
  {
    navigate(new NavDeepLinkRequest(paramUri, null, null));
  }
  
  public void navigate(@NonNull Uri paramUri, @Nullable NavOptions paramNavOptions)
  {
    navigate(new NavDeepLinkRequest(paramUri, null, null), paramNavOptions);
  }
  
  public void navigate(@NonNull Uri paramUri, @Nullable NavOptions paramNavOptions, @Nullable Navigator.Extras paramExtras)
  {
    navigate(new NavDeepLinkRequest(paramUri, null, null), paramNavOptions, paramExtras);
  }
  
  public void navigate(@NonNull NavDeepLinkRequest paramNavDeepLinkRequest)
  {
    navigate(paramNavDeepLinkRequest, null);
  }
  
  public void navigate(@NonNull NavDeepLinkRequest paramNavDeepLinkRequest, @Nullable NavOptions paramNavOptions)
  {
    navigate(paramNavDeepLinkRequest, paramNavOptions, null);
  }
  
  public void navigate(@NonNull NavDeepLinkRequest paramNavDeepLinkRequest, @Nullable NavOptions paramNavOptions, @Nullable Navigator.Extras paramExtras)
  {
    NavDestination.DeepLinkMatch localDeepLinkMatch = this.mGraph.matchDeepLink(paramNavDeepLinkRequest);
    if (localDeepLinkMatch != null)
    {
      paramNavDeepLinkRequest = localDeepLinkMatch.getDestination().addInDefaultArgs(localDeepLinkMatch.getMatchingArgs());
      navigate(localDeepLinkMatch.getDestination(), paramNavDeepLinkRequest, paramNavOptions, paramExtras);
      return;
    }
    paramNavOptions = new StringBuilder();
    paramNavOptions.append("Navigation destination that matches request ");
    paramNavOptions.append(paramNavDeepLinkRequest);
    paramNavOptions.append(" cannot be found in the navigation graph ");
    paramNavOptions.append(this.mGraph);
    throw new IllegalArgumentException(paramNavOptions.toString());
  }
  
  public void navigate(@NonNull NavDirections paramNavDirections)
  {
    navigate(paramNavDirections.getActionId(), paramNavDirections.getArguments());
  }
  
  public void navigate(@NonNull NavDirections paramNavDirections, @Nullable NavOptions paramNavOptions)
  {
    navigate(paramNavDirections.getActionId(), paramNavDirections.getArguments(), paramNavOptions);
  }
  
  public void navigate(@NonNull NavDirections paramNavDirections, @NonNull Navigator.Extras paramExtras)
  {
    navigate(paramNavDirections.getActionId(), paramNavDirections.getArguments(), null, paramExtras);
  }
  
  public boolean navigateUp()
  {
    if (getDestinationCountOnBackStack() == 1)
    {
      Object localObject1 = getCurrentDestination();
      int i = ((NavDestination)localObject1).getId();
      for (localObject1 = ((NavDestination)localObject1).getParent(); localObject1 != null; localObject1 = ((NavDestination)localObject1).getParent())
      {
        if (((NavGraph)localObject1).getStartDestination() != i)
        {
          Bundle localBundle = new Bundle();
          Object localObject2 = this.mActivity;
          if ((localObject2 != null) && (((Activity)localObject2).getIntent() != null) && (this.mActivity.getIntent().getData() != null))
          {
            localBundle.putParcelable("android-support-nav:controller:deepLinkIntent", this.mActivity.getIntent());
            localObject2 = this.mGraph.matchDeepLink(new NavDeepLinkRequest(this.mActivity.getIntent()));
            if (localObject2 != null) {
              localBundle.putAll(((NavDestination.DeepLinkMatch)localObject2).getDestination().addInDefaultArgs(((NavDestination.DeepLinkMatch)localObject2).getMatchingArgs()));
            }
          }
          new NavDeepLinkBuilder(this).setDestination(((NavDestination)localObject1).getId()).setArguments(localBundle).createTaskStackBuilder().startActivities();
          localObject1 = this.mActivity;
          if (localObject1 != null) {
            ((Activity)localObject1).finish();
          }
          return true;
        }
        i = ((NavDestination)localObject1).getId();
      }
      return false;
    }
    return popBackStack();
  }
  
  public boolean popBackStack()
  {
    if (this.mBackStack.isEmpty()) {
      return false;
    }
    return popBackStack(getCurrentDestination().getId(), true);
  }
  
  public boolean popBackStack(@IdRes int paramInt, boolean paramBoolean)
  {
    if ((popBackStackInternal(paramInt, paramBoolean)) && (dispatchOnDestinationChanged())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  boolean popBackStackInternal(@IdRes int paramInt, boolean paramBoolean)
  {
    boolean bool1 = this.mBackStack.isEmpty();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator = this.mBackStack.descendingIterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = ((NavBackStackEntry)localIterator.next()).getDestination();
      localObject3 = this.mNavigatorProvider.getNavigator(((NavDestination)localObject2).getNavigatorName());
      if ((paramBoolean) || (((NavDestination)localObject2).getId() != paramInt)) {
        ((ArrayList)localObject1).add(localObject3);
      }
      if (((NavDestination)localObject2).getId() == paramInt)
      {
        i = 1;
        break label117;
      }
    }
    int i = 0;
    label117:
    if (i == 0)
    {
      localObject3 = NavDestination.getDisplayName(this.mContext, paramInt);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Ignoring popBackStack to destination ");
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append(" as it was not found on the current back stack");
      Log.i("NavController", ((StringBuilder)localObject1).toString());
      return false;
    }
    Object localObject3 = ((ArrayList)localObject1).iterator();
    for (paramBoolean = bool2; (((Iterator)localObject3).hasNext()) && (((Navigator)((Iterator)localObject3).next()).popBackStack()); paramBoolean = true)
    {
      localObject2 = (NavBackStackEntry)this.mBackStack.removeLast();
      ((NavBackStackEntry)localObject2).setMaxLifecycle(Lifecycle.State.DESTROYED);
      localObject1 = this.mViewModel;
      if (localObject1 != null) {
        ((NavControllerViewModel)localObject1).clear(((NavBackStackEntry)localObject2).mId);
      }
    }
    updateOnBackPressedCallbackEnabled();
    return paramBoolean;
  }
  
  public void removeOnDestinationChangedListener(@NonNull OnDestinationChangedListener paramOnDestinationChangedListener)
  {
    this.mOnDestinationChangedListeners.remove(paramOnDestinationChangedListener);
  }
  
  @CallSuper
  public void restoreState(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.setClassLoader(this.mContext.getClassLoader());
    this.mNavigatorStateToRestore = paramBundle.getBundle("android-support-nav:controller:navigatorState");
    this.mBackStackToRestore = paramBundle.getParcelableArray("android-support-nav:controller:backStack");
    this.mDeepLinkHandled = paramBundle.getBoolean("android-support-nav:controller:deepLinkHandled");
  }
  
  @CallSuper
  @Nullable
  public Bundle saveState()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new Bundle();
    Object localObject3 = this.mNavigatorProvider.getNavigators().entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
      String str = (String)((Map.Entry)localObject4).getKey();
      localObject4 = ((Navigator)((Map.Entry)localObject4).getValue()).onSaveState();
      if (localObject4 != null)
      {
        ((ArrayList)localObject1).add(str);
        ((Bundle)localObject2).putBundle(str, (Bundle)localObject4);
      }
    }
    if (!((ArrayList)localObject1).isEmpty())
    {
      localObject3 = new Bundle();
      ((Bundle)localObject2).putStringArrayList("android-support-nav:controller:navigatorState:names", (ArrayList)localObject1);
      ((Bundle)localObject3).putBundle("android-support-nav:controller:navigatorState", (Bundle)localObject2);
    }
    else
    {
      localObject3 = null;
    }
    localObject1 = localObject3;
    if (!this.mBackStack.isEmpty())
    {
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new Bundle();
      }
      localObject2 = new Parcelable[this.mBackStack.size()];
      int i = 0;
      localObject3 = this.mBackStack.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2[i] = new NavBackStackEntryState((NavBackStackEntry)((Iterator)localObject3).next());
        i++;
      }
      ((Bundle)localObject1).putParcelableArray("android-support-nav:controller:backStack", (Parcelable[])localObject2);
    }
    localObject3 = localObject1;
    if (this.mDeepLinkHandled)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new Bundle();
      }
      ((Bundle)localObject3).putBoolean("android-support-nav:controller:deepLinkHandled", this.mDeepLinkHandled);
    }
    return (Bundle)localObject3;
  }
  
  @CallSuper
  public void setGraph(@NavigationRes int paramInt)
  {
    setGraph(paramInt, null);
  }
  
  @CallSuper
  public void setGraph(@NavigationRes int paramInt, @Nullable Bundle paramBundle)
  {
    setGraph(getNavInflater().inflate(paramInt), paramBundle);
  }
  
  @CallSuper
  public void setGraph(@NonNull NavGraph paramNavGraph)
  {
    setGraph(paramNavGraph, null);
  }
  
  @CallSuper
  public void setGraph(@NonNull NavGraph paramNavGraph, @Nullable Bundle paramBundle)
  {
    NavGraph localNavGraph = this.mGraph;
    if (localNavGraph != null) {
      popBackStackInternal(localNavGraph.getId(), true);
    }
    this.mGraph = paramNavGraph;
    onGraphCreated(paramBundle);
  }
  
  void setLifecycleOwner(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    this.mLifecycleOwner = paramLifecycleOwner;
    paramLifecycleOwner.getLifecycle().addObserver(this.mLifecycleObserver);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setNavigatorProvider(@NonNull NavigatorProvider paramNavigatorProvider)
  {
    if (this.mBackStack.isEmpty())
    {
      this.mNavigatorProvider = paramNavigatorProvider;
      return;
    }
    throw new IllegalStateException("NavigatorProvider must be set before setGraph call");
  }
  
  void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher paramOnBackPressedDispatcher)
  {
    if (this.mLifecycleOwner != null)
    {
      this.mOnBackPressedCallback.remove();
      paramOnBackPressedDispatcher.addCallback(this.mLifecycleOwner, this.mOnBackPressedCallback);
      return;
    }
    throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
  }
  
  void setViewModelStore(@NonNull ViewModelStore paramViewModelStore)
  {
    if (this.mBackStack.isEmpty())
    {
      this.mViewModel = NavControllerViewModel.getInstance(paramViewModelStore);
      return;
    }
    throw new IllegalStateException("ViewModelStore should be set before setGraph call");
  }
  
  public static abstract interface OnDestinationChangedListener
  {
    public abstract void onDestinationChanged(@NonNull NavController paramNavController, @NonNull NavDestination paramNavDestination, @Nullable Bundle paramBundle);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */