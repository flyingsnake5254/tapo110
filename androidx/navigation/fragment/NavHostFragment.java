package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.annotation.CallSuper;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;

public class NavHostFragment
  extends Fragment
  implements NavHost
{
  private static final String KEY_DEFAULT_NAV_HOST = "android-support-nav:fragment:defaultHost";
  private static final String KEY_GRAPH_ID = "android-support-nav:fragment:graphId";
  private static final String KEY_NAV_CONTROLLER_STATE = "android-support-nav:fragment:navControllerState";
  private static final String KEY_START_DESTINATION_ARGS = "android-support-nav:fragment:startDestinationArgs";
  private boolean mDefaultNavHost;
  private int mGraphId;
  private Boolean mIsPrimaryBeforeOnCreate = null;
  private NavHostController mNavController;
  private View mViewParent;
  
  @NonNull
  public static NavHostFragment create(@NavigationRes int paramInt)
  {
    return create(paramInt, null);
  }
  
  @NonNull
  public static NavHostFragment create(@NavigationRes int paramInt, @Nullable Bundle paramBundle)
  {
    Bundle localBundle1;
    if (paramInt != 0)
    {
      localBundle1 = new Bundle();
      localBundle1.putInt("android-support-nav:fragment:graphId", paramInt);
    }
    else
    {
      localBundle1 = null;
    }
    Bundle localBundle2 = localBundle1;
    if (paramBundle != null)
    {
      localBundle2 = localBundle1;
      if (localBundle1 == null) {
        localBundle2 = new Bundle();
      }
      localBundle2.putBundle("android-support-nav:fragment:startDestinationArgs", paramBundle);
    }
    paramBundle = new NavHostFragment();
    if (localBundle2 != null) {
      paramBundle.setArguments(localBundle2);
    }
    return paramBundle;
  }
  
  @NonNull
  public static NavController findNavController(@NonNull Fragment paramFragment)
  {
    for (Object localObject = paramFragment; localObject != null; localObject = ((Fragment)localObject).getParentFragment())
    {
      if ((localObject instanceof NavHostFragment)) {
        return ((NavHostFragment)localObject).getNavController();
      }
      Fragment localFragment = ((Fragment)localObject).getParentFragmentManager().getPrimaryNavigationFragment();
      if ((localFragment instanceof NavHostFragment)) {
        return ((NavHostFragment)localFragment).getNavController();
      }
    }
    localObject = paramFragment.getView();
    if (localObject != null) {
      return Navigation.findNavController((View)localObject);
    }
    if ((paramFragment instanceof DialogFragment)) {
      localObject = ((DialogFragment)paramFragment).getDialog();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Dialog)localObject).getWindow() != null)) {
      return Navigation.findNavController(((Dialog)localObject).getWindow().getDecorView());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(paramFragment);
    ((StringBuilder)localObject).append(" does not have a NavController set");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private int getContainerId()
  {
    int i = getId();
    if ((i != 0) && (i != -1)) {
      return i;
    }
    return R.id.nav_host_fragment_container;
  }
  
  @Deprecated
  @NonNull
  protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator()
  {
    return new FragmentNavigator(requireContext(), getChildFragmentManager(), getContainerId());
  }
  
  @NonNull
  public final NavController getNavController()
  {
    NavHostController localNavHostController = this.mNavController;
    if (localNavHostController != null) {
      return localNavHostController;
    }
    throw new IllegalStateException("NavController is not available before onCreate()");
  }
  
  @CallSuper
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    if (this.mDefaultNavHost) {
      getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
    }
  }
  
  public void onAttachFragment(@NonNull Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
    ((DialogFragmentNavigator)this.mNavController.getNavigatorProvider().getNavigator(DialogFragmentNavigator.class)).onAttachFragment(paramFragment);
  }
  
  @CallSuper
  public void onCreate(@Nullable Bundle paramBundle)
  {
    Object localObject = new NavHostController(requireContext());
    this.mNavController = ((NavHostController)localObject);
    ((NavHostController)localObject).setLifecycleOwner(this);
    this.mNavController.setOnBackPressedDispatcher(requireActivity().getOnBackPressedDispatcher());
    localObject = this.mNavController;
    Boolean localBoolean = this.mIsPrimaryBeforeOnCreate;
    int i = 0;
    boolean bool;
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      bool = true;
    } else {
      bool = false;
    }
    ((NavHostController)localObject).enableOnBackPressed(bool);
    localBoolean = null;
    this.mIsPrimaryBeforeOnCreate = null;
    this.mNavController.setViewModelStore(getViewModelStore());
    onCreateNavController(this.mNavController);
    if (paramBundle != null)
    {
      localObject = paramBundle.getBundle("android-support-nav:fragment:navControllerState");
      if (paramBundle.getBoolean("android-support-nav:fragment:defaultHost", false))
      {
        this.mDefaultNavHost = true;
        getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
      }
      this.mGraphId = paramBundle.getInt("android-support-nav:fragment:graphId");
    }
    else
    {
      localObject = null;
    }
    if (localObject != null) {
      this.mNavController.restoreState((Bundle)localObject);
    }
    int j = this.mGraphId;
    if (j != 0)
    {
      this.mNavController.setGraph(j);
    }
    else
    {
      Bundle localBundle = getArguments();
      if (localBundle != null) {
        i = localBundle.getInt("android-support-nav:fragment:graphId");
      }
      localObject = localBoolean;
      if (localBundle != null) {
        localObject = localBundle.getBundle("android-support-nav:fragment:startDestinationArgs");
      }
      if (i != 0) {
        this.mNavController.setGraph(i, (Bundle)localObject);
      }
    }
    super.onCreate(paramBundle);
  }
  
  @CallSuper
  protected void onCreateNavController(@NonNull NavController paramNavController)
  {
    paramNavController.getNavigatorProvider().addNavigator(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
    paramNavController.getNavigatorProvider().addNavigator(createFragmentNavigator());
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = new FragmentContainerView(paramLayoutInflater.getContext());
    paramLayoutInflater.setId(getContainerId());
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    View localView = this.mViewParent;
    if ((localView != null) && (Navigation.findNavController(localView) == this.mNavController)) {
      Navigation.setViewNavController(this.mViewParent, null);
    }
    this.mViewParent = null;
  }
  
  @CallSuper
  public void onInflate(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, @Nullable Bundle paramBundle)
  {
    super.onInflate(paramContext, paramAttributeSet, paramBundle);
    paramBundle = paramContext.obtainStyledAttributes(paramAttributeSet, androidx.navigation.R.styleable.NavHost);
    int i = paramBundle.getResourceId(androidx.navigation.R.styleable.NavHost_navGraph, 0);
    if (i != 0) {
      this.mGraphId = i;
    }
    paramBundle.recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.NavHostFragment);
    if (paramContext.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false)) {
      this.mDefaultNavHost = true;
    }
    paramContext.recycle();
  }
  
  @CallSuper
  public void onPrimaryNavigationFragmentChanged(boolean paramBoolean)
  {
    NavHostController localNavHostController = this.mNavController;
    if (localNavHostController != null) {
      localNavHostController.enableOnBackPressed(paramBoolean);
    } else {
      this.mIsPrimaryBeforeOnCreate = Boolean.valueOf(paramBoolean);
    }
  }
  
  @CallSuper
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Bundle localBundle = this.mNavController.saveState();
    if (localBundle != null) {
      paramBundle.putBundle("android-support-nav:fragment:navControllerState", localBundle);
    }
    if (this.mDefaultNavHost) {
      paramBundle.putBoolean("android-support-nav:fragment:defaultHost", true);
    }
    int i = this.mGraphId;
    if (i != 0) {
      paramBundle.putInt("android-support-nav:fragment:graphId", i);
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if ((paramView instanceof ViewGroup))
    {
      Navigation.setViewNavController(paramView, this.mNavController);
      if (paramView.getParent() != null)
      {
        paramView = (View)paramView.getParent();
        this.mViewParent = paramView;
        if (paramView.getId() == getId()) {
          Navigation.setViewNavController(this.mViewParent, this.mNavController);
        }
      }
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("created host view ");
    paramBundle.append(paramView);
    paramBundle.append(" is not a ViewGroup");
    throw new IllegalStateException(paramBundle.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\fragment\NavHostFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */