package androidx.lifecycle;

import kotlin.jvm.internal.j;

public final class LifecycleOwnerKt
{
  public static final LifecycleCoroutineScope getLifecycleScope(LifecycleOwner paramLifecycleOwner)
  {
    j.f(paramLifecycleOwner, "$this$lifecycleScope");
    paramLifecycleOwner = paramLifecycleOwner.getLifecycle();
    j.b(paramLifecycleOwner, "lifecycle");
    return LifecycleKt.getCoroutineScope(paramLifecycleOwner);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LifecycleOwnerKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */