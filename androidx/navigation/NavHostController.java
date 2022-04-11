package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

public class NavHostController
  extends NavController
{
  public NavHostController(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public final void enableOnBackPressed(boolean paramBoolean)
  {
    super.enableOnBackPressed(paramBoolean);
  }
  
  public final void setLifecycleOwner(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public final void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher paramOnBackPressedDispatcher)
  {
    super.setOnBackPressedDispatcher(paramOnBackPressedDispatcher);
  }
  
  public final void setViewModelStore(@NonNull ViewModelStore paramViewModelStore)
  {
    super.setViewModelStore(paramViewModelStore);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavHostController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */