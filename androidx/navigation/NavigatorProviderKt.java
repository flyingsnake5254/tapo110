package androidx.navigation;

import kotlin.jvm.a;
import kotlin.jvm.internal.j;
import kotlin.reflect.c;

public final class NavigatorProviderKt
{
  public static final <T extends Navigator<? extends NavDestination>> T get(NavigatorProvider paramNavigatorProvider, String paramString)
  {
    j.f(paramNavigatorProvider, "$this$get");
    j.f(paramString, "name");
    paramNavigatorProvider = paramNavigatorProvider.getNavigator(paramString);
    j.b(paramNavigatorProvider, "getNavigator(name)");
    return paramNavigatorProvider;
  }
  
  public static final <T extends Navigator<? extends NavDestination>> T get(NavigatorProvider paramNavigatorProvider, c<T> paramc)
  {
    j.f(paramNavigatorProvider, "$this$get");
    j.f(paramc, "clazz");
    paramNavigatorProvider = paramNavigatorProvider.getNavigator(a.a(paramc));
    j.b(paramNavigatorProvider, "getNavigator(clazz.java)");
    return paramNavigatorProvider;
  }
  
  public static final void plusAssign(NavigatorProvider paramNavigatorProvider, Navigator<? extends NavDestination> paramNavigator)
  {
    j.f(paramNavigatorProvider, "$this$plusAssign");
    j.f(paramNavigator, "navigator");
    paramNavigatorProvider.addNavigator(paramNavigator);
  }
  
  public static final Navigator<? extends NavDestination> set(NavigatorProvider paramNavigatorProvider, String paramString, Navigator<? extends NavDestination> paramNavigator)
  {
    j.f(paramNavigatorProvider, "$this$set");
    j.f(paramString, "name");
    j.f(paramNavigator, "navigator");
    return paramNavigatorProvider.addNavigator(paramString, paramNavigator);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavigatorProviderKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */