package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

class FragmentViewLifecycleOwner
  implements LifecycleOwner
{
  private LifecycleRegistry mLifecycleRegistry = null;
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    initialize();
    return this.mLifecycleRegistry;
  }
  
  void handleLifecycleEvent(@NonNull Lifecycle.Event paramEvent)
  {
    this.mLifecycleRegistry.handleLifecycleEvent(paramEvent);
  }
  
  void initialize()
  {
    if (this.mLifecycleRegistry == null) {
      this.mLifecycleRegistry = new LifecycleRegistry(this);
    }
  }
  
  boolean isInitialized()
  {
    boolean bool;
    if (this.mLifecycleRegistry != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentViewLifecycleOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */