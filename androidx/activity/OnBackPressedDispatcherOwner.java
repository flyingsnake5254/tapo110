package androidx.activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

public abstract interface OnBackPressedDispatcherOwner
  extends LifecycleOwner
{
  @NonNull
  public abstract OnBackPressedDispatcher getOnBackPressedDispatcher();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\activity\OnBackPressedDispatcherOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */