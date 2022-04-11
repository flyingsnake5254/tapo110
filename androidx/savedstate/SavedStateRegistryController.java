package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;

public final class SavedStateRegistryController
{
  private final SavedStateRegistryOwner mOwner;
  private final SavedStateRegistry mRegistry;
  
  private SavedStateRegistryController(SavedStateRegistryOwner paramSavedStateRegistryOwner)
  {
    this.mOwner = paramSavedStateRegistryOwner;
    this.mRegistry = new SavedStateRegistry();
  }
  
  @NonNull
  public static SavedStateRegistryController create(@NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner)
  {
    return new SavedStateRegistryController(paramSavedStateRegistryOwner);
  }
  
  @NonNull
  public SavedStateRegistry getSavedStateRegistry()
  {
    return this.mRegistry;
  }
  
  @MainThread
  public void performRestore(@Nullable Bundle paramBundle)
  {
    Lifecycle localLifecycle = this.mOwner.getLifecycle();
    if (localLifecycle.getCurrentState() == Lifecycle.State.INITIALIZED)
    {
      localLifecycle.addObserver(new Recreator(this.mOwner));
      this.mRegistry.performRestore(localLifecycle, paramBundle);
      return;
    }
    throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
  }
  
  @MainThread
  public void performSave(@NonNull Bundle paramBundle)
  {
    this.mRegistry.performSave(paramBundle);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\savedstate\SavedStateRegistryController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */