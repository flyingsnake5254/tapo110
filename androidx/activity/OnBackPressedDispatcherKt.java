package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class OnBackPressedDispatcherKt
{
  public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher paramOnBackPressedDispatcher, LifecycleOwner paramLifecycleOwner, final boolean paramBoolean, l<? super OnBackPressedCallback, p> paraml)
  {
    j.f(paramOnBackPressedDispatcher, "$this$addCallback");
    j.f(paraml, "onBackPressed");
    paraml = new OnBackPressedCallback(paraml)
    {
      public void handleOnBackPressed()
      {
        this.$onBackPressed.invoke(this);
      }
    };
    if (paramLifecycleOwner != null) {
      paramOnBackPressedDispatcher.addCallback(paramLifecycleOwner, paraml);
    } else {
      paramOnBackPressedDispatcher.addCallback(paraml);
    }
    return paraml;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\activity\OnBackPressedDispatcherKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */