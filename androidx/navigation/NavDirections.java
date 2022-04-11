package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

public abstract interface NavDirections
{
  @IdRes
  public abstract int getActionId();
  
  @NonNull
  public abstract Bundle getArguments();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavDirections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */