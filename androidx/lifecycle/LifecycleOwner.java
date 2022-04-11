package androidx.lifecycle;

import androidx.annotation.NonNull;

public abstract interface LifecycleOwner
{
  @NonNull
  public abstract Lifecycle getLifecycle();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LifecycleOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */