package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class NavControllerKt
{
  public static final NavGraph createGraph(NavController paramNavController, @IdRes int paramInt1, @IdRes int paramInt2, l<? super NavGraphBuilder, p> paraml)
  {
    j.f(paramNavController, "$this$createGraph");
    j.f(paraml, "builder");
    paramNavController = paramNavController.getNavigatorProvider();
    j.b(paramNavController, "navigatorProvider");
    paramNavController = new NavGraphBuilder(paramNavController, paramInt1, paramInt2);
    paraml.invoke(paramNavController);
    return paramNavController.build();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavControllerKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */