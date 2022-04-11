package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@Navigator.Name("NoOp")
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NoOpNavigator
  extends Navigator<NavDestination>
{
  @NonNull
  public NavDestination createDestination()
  {
    return new NavDestination(this);
  }
  
  @Nullable
  public NavDestination navigate(@NonNull NavDestination paramNavDestination, @Nullable Bundle paramBundle, @Nullable NavOptions paramNavOptions, @Nullable Navigator.Extras paramExtras)
  {
    return paramNavDestination;
  }
  
  public boolean popBackStack()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NoOpNavigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */