package androidx.navigation;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class NavOptionsBuilderKt
{
  public static final NavOptions navOptions(l<? super NavOptionsBuilder, p> paraml)
  {
    j.f(paraml, "optionsBuilder");
    NavOptionsBuilder localNavOptionsBuilder = new NavOptionsBuilder();
    paraml.invoke(localNavOptionsBuilder);
    return localNavOptionsBuilder.build$navigation_common_ktx_release();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavOptionsBuilderKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */