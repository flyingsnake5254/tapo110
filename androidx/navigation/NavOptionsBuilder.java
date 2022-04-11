package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

@NavOptionsDsl
public final class NavOptionsBuilder
{
  private final NavOptions.Builder builder = new NavOptions.Builder();
  private boolean inclusive;
  private boolean launchSingleTop;
  @IdRes
  private int popUpTo = -1;
  
  public final void anim(l<? super AnimBuilder, p> paraml)
  {
    j.f(paraml, "animBuilder");
    AnimBuilder localAnimBuilder = new AnimBuilder();
    paraml.invoke(localAnimBuilder);
    this.builder.setEnterAnim(localAnimBuilder.getEnter()).setExitAnim(localAnimBuilder.getExit()).setPopEnterAnim(localAnimBuilder.getPopEnter()).setPopExitAnim(localAnimBuilder.getPopExit());
  }
  
  public final NavOptions build$navigation_common_ktx_release()
  {
    Object localObject = this.builder;
    ((NavOptions.Builder)localObject).setLaunchSingleTop(this.launchSingleTop);
    ((NavOptions.Builder)localObject).setPopUpTo(this.popUpTo, this.inclusive);
    localObject = ((NavOptions.Builder)localObject).build();
    j.b(localObject, "builder.apply {\n        … inclusive)\n    }.build()");
    return (NavOptions)localObject;
  }
  
  public final boolean getLaunchSingleTop()
  {
    return this.launchSingleTop;
  }
  
  public final int getPopUpTo()
  {
    return this.popUpTo;
  }
  
  public final void popUpTo(@IdRes int paramInt, l<? super PopUpToBuilder, p> paraml)
  {
    j.f(paraml, "popUpToBuilder");
    setPopUpTo(paramInt);
    PopUpToBuilder localPopUpToBuilder = new PopUpToBuilder();
    paraml.invoke(localPopUpToBuilder);
    this.inclusive = localPopUpToBuilder.getInclusive();
  }
  
  public final void setLaunchSingleTop(boolean paramBoolean)
  {
    this.launchSingleTop = paramBoolean;
  }
  
  public final void setPopUpTo(int paramInt)
  {
    this.popUpTo = paramInt;
    this.inclusive = false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavOptionsBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */