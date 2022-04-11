package androidx.navigation;

import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.j;

public final class ActivityNavigatorExtrasKt
{
  public static final ActivityNavigator.Extras ActivityNavigatorExtras(ActivityOptionsCompat paramActivityOptionsCompat, int paramInt)
  {
    ActivityNavigator.Extras.Builder localBuilder = new ActivityNavigator.Extras.Builder();
    if (paramActivityOptionsCompat != null) {
      localBuilder.setActivityOptions(paramActivityOptionsCompat);
    }
    localBuilder.addFlags(paramInt);
    paramActivityOptionsCompat = localBuilder.build();
    j.b(paramActivityOptionsCompat, "ActivityNavigator.Extras…(flags)\n        }.build()");
    return paramActivityOptionsCompat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ActivityNavigatorExtrasKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */