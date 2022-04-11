package androidx.navigation;

import android.app.Activity;
import androidx.annotation.IdRes;
import kotlin.jvm.internal.j;

public final class ActivityKt
{
  public static final NavController findNavController(Activity paramActivity, @IdRes int paramInt)
  {
    j.f(paramActivity, "$this$findNavController");
    paramActivity = Navigation.findNavController(paramActivity, paramInt);
    j.b(paramActivity, "Navigation.findNavController(this, viewId)");
    return paramActivity;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ActivityKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */