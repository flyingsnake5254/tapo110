package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class NavGraphBuilderKt
{
  public static final NavGraph navigation(NavigatorProvider paramNavigatorProvider, @IdRes int paramInt1, @IdRes int paramInt2, l<? super NavGraphBuilder, p> paraml)
  {
    j.f(paramNavigatorProvider, "$this$navigation");
    j.f(paraml, "builder");
    paramNavigatorProvider = new NavGraphBuilder(paramNavigatorProvider, paramInt1, paramInt2);
    paraml.invoke(paramNavigatorProvider);
    return paramNavigatorProvider.build();
  }
  
  public static final void navigation(NavGraphBuilder paramNavGraphBuilder, @IdRes int paramInt1, @IdRes int paramInt2, l<? super NavGraphBuilder, p> paraml)
  {
    j.f(paramNavGraphBuilder, "$this$navigation");
    j.f(paraml, "builder");
    NavGraphBuilder localNavGraphBuilder = new NavGraphBuilder(paramNavGraphBuilder.getProvider(), paramInt1, paramInt2);
    paraml.invoke(localNavGraphBuilder);
    paramNavGraphBuilder.destination(localNavGraphBuilder);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavGraphBuilderKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */