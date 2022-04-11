package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class Navigator<D extends NavDestination>
{
  @NonNull
  public abstract D createDestination();
  
  @Nullable
  public abstract NavDestination navigate(@NonNull D paramD, @Nullable Bundle paramBundle, @Nullable NavOptions paramNavOptions, @Nullable Extras paramExtras);
  
  public void onRestoreState(@NonNull Bundle paramBundle) {}
  
  @Nullable
  public Bundle onSaveState()
  {
    return null;
  }
  
  public abstract boolean popBackStack();
  
  public static abstract interface Extras {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface Name
  {
    String value();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\Navigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */