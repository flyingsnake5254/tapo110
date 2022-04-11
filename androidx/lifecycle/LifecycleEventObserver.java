package androidx.lifecycle;

import androidx.annotation.NonNull;

public abstract interface LifecycleEventObserver
  extends LifecycleObserver
{
  public abstract void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LifecycleEventObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */