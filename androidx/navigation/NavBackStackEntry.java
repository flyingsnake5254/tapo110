package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.UUID;

public final class NavBackStackEntry
  implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner
{
  private Bundle mArgs;
  private final Context mContext;
  private ViewModelProvider.Factory mDefaultFactory;
  private final NavDestination mDestination;
  private Lifecycle.State mHostLifecycle;
  @NonNull
  final UUID mId;
  private final LifecycleRegistry mLifecycle = new LifecycleRegistry(this);
  private Lifecycle.State mMaxLifecycle;
  private NavControllerViewModel mNavControllerViewModel;
  private SavedStateHandle mSavedStateHandle;
  private final SavedStateRegistryController mSavedStateRegistryController;
  
  NavBackStackEntry(@NonNull Context paramContext, @NonNull NavDestination paramNavDestination, @Nullable Bundle paramBundle, @Nullable LifecycleOwner paramLifecycleOwner, @Nullable NavControllerViewModel paramNavControllerViewModel)
  {
    this(paramContext, paramNavDestination, paramBundle, paramLifecycleOwner, paramNavControllerViewModel, UUID.randomUUID(), null);
  }
  
  NavBackStackEntry(@NonNull Context paramContext, @NonNull NavDestination paramNavDestination, @Nullable Bundle paramBundle1, @Nullable LifecycleOwner paramLifecycleOwner, @Nullable NavControllerViewModel paramNavControllerViewModel, @NonNull UUID paramUUID, @Nullable Bundle paramBundle2)
  {
    SavedStateRegistryController localSavedStateRegistryController = SavedStateRegistryController.create(this);
    this.mSavedStateRegistryController = localSavedStateRegistryController;
    this.mHostLifecycle = Lifecycle.State.CREATED;
    this.mMaxLifecycle = Lifecycle.State.RESUMED;
    this.mContext = paramContext;
    this.mId = paramUUID;
    this.mDestination = paramNavDestination;
    this.mArgs = paramBundle1;
    this.mNavControllerViewModel = paramNavControllerViewModel;
    localSavedStateRegistryController.performRestore(paramBundle2);
    if (paramLifecycleOwner != null) {
      this.mHostLifecycle = paramLifecycleOwner.getLifecycle().getCurrentState();
    }
  }
  
  @NonNull
  private static Lifecycle.State getStateAfter(@NonNull Lifecycle.Event paramEvent)
  {
    switch (1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[paramEvent.ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected event value ");
      localStringBuilder.append(paramEvent);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 6: 
      return Lifecycle.State.DESTROYED;
    case 5: 
      return Lifecycle.State.RESUMED;
    case 3: 
    case 4: 
      return Lifecycle.State.STARTED;
    }
    return Lifecycle.State.CREATED;
  }
  
  @Nullable
  public Bundle getArguments()
  {
    return this.mArgs;
  }
  
  @NonNull
  public ViewModelProvider.Factory getDefaultViewModelProviderFactory()
  {
    if (this.mDefaultFactory == null) {
      this.mDefaultFactory = new SavedStateViewModelFactory((Application)this.mContext.getApplicationContext(), this, this.mArgs);
    }
    return this.mDefaultFactory;
  }
  
  @NonNull
  public NavDestination getDestination()
  {
    return this.mDestination;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.mLifecycle;
  }
  
  @NonNull
  Lifecycle.State getMaxLifecycle()
  {
    return this.mMaxLifecycle;
  }
  
  @NonNull
  public SavedStateHandle getSavedStateHandle()
  {
    if (this.mSavedStateHandle == null) {
      this.mSavedStateHandle = ((SavedStateViewModel)new ViewModelProvider(this, new NavResultSavedStateFactory(this, null)).get(SavedStateViewModel.class)).getHandle();
    }
    return this.mSavedStateHandle;
  }
  
  @NonNull
  public SavedStateRegistry getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.getSavedStateRegistry();
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    NavControllerViewModel localNavControllerViewModel = this.mNavControllerViewModel;
    if (localNavControllerViewModel != null) {
      return localNavControllerViewModel.getViewModelStore(this.mId);
    }
    throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
  }
  
  void handleLifecycleEvent(@NonNull Lifecycle.Event paramEvent)
  {
    this.mHostLifecycle = getStateAfter(paramEvent);
    updateState();
  }
  
  void replaceArguments(@Nullable Bundle paramBundle)
  {
    this.mArgs = paramBundle;
  }
  
  void saveState(@NonNull Bundle paramBundle)
  {
    this.mSavedStateRegistryController.performSave(paramBundle);
  }
  
  void setMaxLifecycle(@NonNull Lifecycle.State paramState)
  {
    this.mMaxLifecycle = paramState;
    updateState();
  }
  
  void updateState()
  {
    if (this.mHostLifecycle.ordinal() < this.mMaxLifecycle.ordinal()) {
      this.mLifecycle.setCurrentState(this.mHostLifecycle);
    } else {
      this.mLifecycle.setCurrentState(this.mMaxLifecycle);
    }
  }
  
  private static class NavResultSavedStateFactory
    extends AbstractSavedStateViewModelFactory
  {
    NavResultSavedStateFactory(@NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner, @Nullable Bundle paramBundle)
    {
      super(paramBundle);
    }
    
    @NonNull
    protected <T extends ViewModel> T create(@NonNull String paramString, @NonNull Class<T> paramClass, @NonNull SavedStateHandle paramSavedStateHandle)
    {
      return new NavBackStackEntry.SavedStateViewModel(paramSavedStateHandle);
    }
  }
  
  private static class SavedStateViewModel
    extends ViewModel
  {
    private SavedStateHandle mHandle;
    
    SavedStateViewModel(SavedStateHandle paramSavedStateHandle)
    {
      this.mHandle = paramSavedStateHandle;
    }
    
    public SavedStateHandle getHandle()
    {
      return this.mHandle;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavBackStackEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */