package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDestination.ClassType;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator.Extras;
import androidx.navigation.Navigator.Name;
import androidx.navigation.NavigatorProvider;
import java.util.HashSet;

@Navigator.Name("dialog")
public final class DialogFragmentNavigator
  extends Navigator<Destination>
{
  private static final String DIALOG_TAG = "androidx-nav-fragment:navigator:dialog:";
  private static final String KEY_DIALOG_COUNT = "androidx-nav-dialogfragment:navigator:count";
  private static final String TAG = "DialogFragmentNavigator";
  private final Context mContext;
  private int mDialogCount = 0;
  private final FragmentManager mFragmentManager;
  private LifecycleEventObserver mObserver = new LifecycleEventObserver()
  {
    public void onStateChanged(@NonNull LifecycleOwner paramAnonymousLifecycleOwner, @NonNull Lifecycle.Event paramAnonymousEvent)
    {
      if (paramAnonymousEvent == Lifecycle.Event.ON_STOP)
      {
        paramAnonymousLifecycleOwner = (DialogFragment)paramAnonymousLifecycleOwner;
        if (!paramAnonymousLifecycleOwner.requireDialog().isShowing()) {
          NavHostFragment.findNavController(paramAnonymousLifecycleOwner).popBackStack();
        }
      }
    }
  };
  private final HashSet<String> mRestoredTagsAwaitingAttach = new HashSet();
  
  public DialogFragmentNavigator(@NonNull Context paramContext, @NonNull FragmentManager paramFragmentManager)
  {
    this.mContext = paramContext;
    this.mFragmentManager = paramFragmentManager;
  }
  
  @NonNull
  public Destination createDestination()
  {
    return new Destination(this);
  }
  
  @Nullable
  public NavDestination navigate(@NonNull Destination paramDestination, @Nullable Bundle paramBundle, @Nullable NavOptions paramNavOptions, @Nullable Navigator.Extras paramExtras)
  {
    if (this.mFragmentManager.isStateSaved())
    {
      Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
      return null;
    }
    paramExtras = paramDestination.getClassName();
    paramNavOptions = paramExtras;
    if (paramExtras.charAt(0) == '.')
    {
      paramNavOptions = new StringBuilder();
      paramNavOptions.append(this.mContext.getPackageName());
      paramNavOptions.append(paramExtras);
      paramNavOptions = paramNavOptions.toString();
    }
    paramNavOptions = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), paramNavOptions);
    if (DialogFragment.class.isAssignableFrom(paramNavOptions.getClass()))
    {
      paramNavOptions = (DialogFragment)paramNavOptions;
      paramNavOptions.setArguments(paramBundle);
      paramNavOptions.getLifecycle().addObserver(this.mObserver);
      paramBundle = this.mFragmentManager;
      paramExtras = new StringBuilder();
      paramExtras.append("androidx-nav-fragment:navigator:dialog:");
      int i = this.mDialogCount;
      this.mDialogCount = (i + 1);
      paramExtras.append(i);
      paramNavOptions.show(paramBundle, paramExtras.toString());
      return paramDestination;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Dialog destination ");
    paramBundle.append(paramDestination.getClassName());
    paramBundle.append(" is not an instance of DialogFragment");
    throw new IllegalArgumentException(paramBundle.toString());
  }
  
  void onAttachFragment(@NonNull Fragment paramFragment)
  {
    if (this.mRestoredTagsAwaitingAttach.remove(paramFragment.getTag())) {
      paramFragment.getLifecycle().addObserver(this.mObserver);
    }
  }
  
  public void onRestoreState(@Nullable Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = 0;
      this.mDialogCount = paramBundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
      while (i < this.mDialogCount)
      {
        Object localObject = this.mFragmentManager;
        paramBundle = new StringBuilder();
        paramBundle.append("androidx-nav-fragment:navigator:dialog:");
        paramBundle.append(i);
        paramBundle = (DialogFragment)((FragmentManager)localObject).findFragmentByTag(paramBundle.toString());
        if (paramBundle != null)
        {
          paramBundle.getLifecycle().addObserver(this.mObserver);
        }
        else
        {
          paramBundle = this.mRestoredTagsAwaitingAttach;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("androidx-nav-fragment:navigator:dialog:");
          ((StringBuilder)localObject).append(i);
          paramBundle.add(((StringBuilder)localObject).toString());
        }
        i++;
      }
    }
  }
  
  @Nullable
  public Bundle onSaveState()
  {
    if (this.mDialogCount == 0) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("androidx-nav-dialogfragment:navigator:count", this.mDialogCount);
    return localBundle;
  }
  
  public boolean popBackStack()
  {
    if (this.mDialogCount == 0) {
      return false;
    }
    if (this.mFragmentManager.isStateSaved())
    {
      Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
      return false;
    }
    FragmentManager localFragmentManager = this.mFragmentManager;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("androidx-nav-fragment:navigator:dialog:");
    int i = this.mDialogCount - 1;
    this.mDialogCount = i;
    ((StringBuilder)localObject).append(i);
    localObject = localFragmentManager.findFragmentByTag(((StringBuilder)localObject).toString());
    if (localObject != null)
    {
      ((Fragment)localObject).getLifecycle().removeObserver(this.mObserver);
      ((DialogFragment)localObject).dismiss();
    }
    return true;
  }
  
  @NavDestination.ClassType(DialogFragment.class)
  public static class Destination
    extends NavDestination
    implements FloatingWindow
  {
    private String mClassName;
    
    public Destination(@NonNull Navigator<? extends Destination> paramNavigator)
    {
      super();
    }
    
    public Destination(@NonNull NavigatorProvider paramNavigatorProvider)
    {
      this(paramNavigatorProvider.getNavigator(DialogFragmentNavigator.class));
    }
    
    @NonNull
    public final String getClassName()
    {
      String str = this.mClassName;
      if (str != null) {
        return str;
      }
      throw new IllegalStateException("DialogFragment class was not set");
    }
    
    @CallSuper
    public void onInflate(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
    {
      super.onInflate(paramContext, paramAttributeSet);
      paramAttributeSet = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.DialogFragmentNavigator);
      paramContext = paramAttributeSet.getString(R.styleable.DialogFragmentNavigator_android_name);
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
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\fragment\DialogFragmentNavigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */