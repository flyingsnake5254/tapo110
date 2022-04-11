package androidx.navigation;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class NavDeepLinkDslBuilderKt
{
  public static final NavDeepLink navDeepLink(l<? super NavDeepLinkDslBuilder, p> paraml)
  {
    j.f(paraml, "deepLinkBuilder");
    NavDeepLinkDslBuilder localNavDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
    paraml.invoke(localNavDeepLinkDslBuilder);
    return localNavDeepLinkDslBuilder.build$navigation_common_ktx_release();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavDeepLinkDslBuilderKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */