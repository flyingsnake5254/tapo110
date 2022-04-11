package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class NavHostKt
{
  public static final NavGraph createGraph(NavHost paramNavHost, @IdRes int paramInt1, @IdRes int paramInt2, l<? super NavGraphBuilder, p> paraml)
  {
    j.f(paramNavHost, "$this$createGraph");
    j.f(paraml, "builder");
    paramNavHost = paramNavHost.getNavController();
    j.b(paramNavHost, "navController");
    paramNavHost = paramNavHost.getNavigatorProvider();
    j.b(paramNavHost, "navigatorProvider");
    paramNavHost = new NavGraphBuilder(paramNavHost, paramInt1, paramInt2);
    paraml.invoke(paramNavHost);
    return paramNavHost.build();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavHostKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */