package androidx.savedstate;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

public abstract interface SavedStateRegistryOwner
  extends LifecycleOwner
{
  @NonNull
  public abstract SavedStateRegistry getSavedStateRegistry();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\savedstate\SavedStateRegistryOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */