package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ActivityNavigatorDestinationBuilderKt
{
  public static final void activity(NavGraphBuilder paramNavGraphBuilder, @IdRes int paramInt, l<? super ActivityNavigatorDestinationBuilder, p> paraml)
  {
    j.f(paramNavGraphBuilder, "$this$activity");
    j.f(paraml, "builder");
    Object localObject = paramNavGraphBuilder.getProvider().getNavigator(ActivityNavigator.class);
    j.b(localObject, "getNavigator(clazz.java)");
    localObject = new ActivityNavigatorDestinationBuilder((ActivityNavigator)localObject, paramInt);
    paraml.invoke(localObject);
    paramNavGraphBuilder.destination((NavDestinationBuilder)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ActivityNavigatorDestinationBuilderKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */