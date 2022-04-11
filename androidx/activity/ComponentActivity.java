package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

public class ComponentActivity
  extends androidx.core.app.ComponentActivity
  implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner
{
  @LayoutRes
  private int mContentLayoutId;
  private ViewModelProvider.Factory mDefaultFactory;
  private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
  private final OnBackPressedDispatcher mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable()
  {
    public void run()
    {
      ComponentActivity.this.onBackPressed();
    }
  });
  private final SavedStateRegistryController mSavedStateRegistryController = SavedStateRegistryController.create(this);
  private ViewModelStore mViewModelStore;
  
  public ComponentActivity()
  {
    if (getLifecycle() != null)
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 19) {
        getLifecycle().addObserver(new LifecycleEventObserver()
        {
          public void onStateChanged(@NonNull LifecycleOwner paramAnonymousLifecycleOwner, @NonNull Lifecycle.Event paramAnonymousEvent)
          {
            if (paramAnonymousEvent == Lifecycle.Event.ON_STOP)
            {
              paramAnonymousLifecycleOwner = ComponentActivity.this.getWindow();
              if (paramAnonymousLifecycleOwner != null) {
                paramAnonymousLifecycleOwner = paramAnonymousLifecycleOwner.peekDecorView();
              } else {
                paramAnonymousLifecycleOwner = null;
              }
              if (paramAnonymousLifecycleOwner != null) {
                paramAnonymousLifecycleOwner.cancelPendingInputEvents();
              }
            }
          }
        });
      }
      getLifecycle().addObserver(new LifecycleEventObserver()
      {
        public void onStateChanged(@NonNull LifecycleOwner paramAnonymousLifecycleOwner, @NonNull Lifecycle.Event paramAnonymousEvent)
        {
          if ((paramAnonymousEvent == Lifecycle.Event.ON_DESTROY) && (!ComponentActivity.this.isChangingConfigurations())) {
            ComponentActivity.this.getViewModelStore().clear();
          }
        }
      });
      if ((19 <= i) && (i <= 23)) {
        getLifecycle().addObserver(new ImmLeaksCleaner(this));
      }
      return;
    }
    throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
  }
  
  @ContentView
  public ComponentActivity(@LayoutRes int paramInt)
  {
    this();
    this.mContentLayoutId = paramInt;
  }
  
  @NonNull
  public ViewModelProvider.Factory getDefaultViewModelProviderFactory()
  {
    if (getApplication() != null)
    {
      if (this.mDefaultFactory == null)
      {
        Application localApplication = getApplication();
        Bundle localBundle;
        if (getIntent() != null) {
          localBundle = getIntent().getExtras();
        } else {
          localBundle = null;
        }
        this.mDefaultFactory = new SavedStateViewModelFactory(localApplication, this, localBundle);
      }
      return this.mDefaultFactory;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  @Deprecated
  @Nullable
  public Object getLastCustomNonConfigurationInstance()
  {
    Object localObject = (NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localObject != null) {
      localObject = ((NonConfigurationInstances)localObject).custom;
    } else {
      localObject = null;
    }
    return localObject;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @NonNull
  public final OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return this.mOnBackPressedDispatcher;
  }
  
  @NonNull
  public final SavedStateRegistry getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.getSavedStateRegistry();
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (getApplication() != null)
    {
      if (this.mViewModelStore == null)
      {
        NonConfigurationInstances localNonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
        if (localNonConfigurationInstances != null) {
          this.mViewModelStore = localNonConfigurationInstances.viewModelStore;
        }
        if (this.mViewModelStore == null) {
          this.mViewModelStore = new ViewModelStore();
        }
      }
      return this.mViewModelStore;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  @MainThread
  public void onBackPressed()
  {
    this.mOnBackPressedDispatcher.onBackPressed();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSavedStateRegistryController.performRestore(paramBundle);
    ReportFragment.injectIfNeededIn(this);
    int i = this.mContentLayoutId;
    if (i != 0) {
      setContentView(i);
    }
  }
  
  @Deprecated
  @Nullable
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  @Nullable
  public final Object onRetainNonConfigurationInstance()
  {
    Object localObject1 = onRetainCustomNonConfigurationInstance();
    Object localObject2 = this.mViewModelStore;
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      NonConfigurationInstances localNonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
      localObject3 = localObject2;
      if (localNonConfigurationInstances != null) {
        localObject3 = localNonConfigurationInstances.viewModelStore;
      }
    }
    if ((localObject3 == null) && (localObject1 == null)) {
      return null;
    }
    localObject2 = new NonConfigurationInstances();
    ((NonConfigurationInstances)localObject2).custom = localObject1;
    ((NonConfigurationInstances)localObject2).viewModelStore = ((ViewModelStore)localObject3);
    return localObject2;
  }
  
  @CallSuper
  protected void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    Lifecycle localLifecycle = getLifecycle();
    if ((localLifecycle instanceof LifecycleRegistry)) {
      ((LifecycleRegistry)localLifecycle).setCurrentState(Lifecycle.State.CREATED);
    }
    super.onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.performSave(paramBundle);
  }
  
  static final class NonConfigurationInstances
  {
    Object custom;
    ViewModelStore viewModelStore;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\activity\ComponentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */