package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.internal.j;

public final class NavGraphKt
{
  public static final boolean contains(NavGraph paramNavGraph, @IdRes int paramInt)
  {
    j.f(paramNavGraph, "$this$contains");
    boolean bool;
    if (paramNavGraph.findNode(paramInt) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final NavDestination get(NavGraph paramNavGraph, @IdRes int paramInt)
  {
    j.f(paramNavGraph, "$this$get");
    Object localObject = paramNavGraph.findNode(paramInt);
    if (localObject != null) {
      return (NavDestination)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No destination for ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" was found in ");
    ((StringBuilder)localObject).append(paramNavGraph);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static final void minusAssign(NavGraph paramNavGraph, NavDestination paramNavDestination)
  {
    j.f(paramNavGraph, "$this$minusAssign");
    j.f(paramNavDestination, "node");
    paramNavGraph.remove(paramNavDestination);
  }
  
  public static final void plusAssign(NavGraph paramNavGraph, NavDestination paramNavDestination)
  {
    j.f(paramNavGraph, "$this$plusAssign");
    j.f(paramNavDestination, "node");
    paramNavGraph.addDestination(paramNavDestination);
  }
  
  public static final void plusAssign(NavGraph paramNavGraph1, NavGraph paramNavGraph2)
  {
    j.f(paramNavGraph1, "$this$plusAssign");
    j.f(paramNavGraph2, "other");
    paramNavGraph1.addAll(paramNavGraph2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavGraphKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */