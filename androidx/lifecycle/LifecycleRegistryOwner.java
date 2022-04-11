package androidx.lifecycle;

import androidx.annotation.NonNull;

@Deprecated
public abstract interface LifecycleRegistryOwner
  extends LifecycleOwner
{
  @NonNull
  public abstract LifecycleRegistry getLifecycle();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LifecycleRegistryOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */