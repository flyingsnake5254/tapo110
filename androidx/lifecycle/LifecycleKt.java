package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;

public final class LifecycleKt
{
  public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle paramLifecycle)
  {
    j.f(paramLifecycle, "$this$coroutineScope");
    LifecycleCoroutineScopeImpl localLifecycleCoroutineScopeImpl;
    do
    {
      localLifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl)paramLifecycle.mInternalScopeRef.get();
      if (localLifecycleCoroutineScopeImpl != null) {
        return localLifecycleCoroutineScopeImpl;
      }
      localLifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(paramLifecycle, v1.b(null, 1, null).plus(n0.b().u()));
    } while (!paramLifecycle.mInternalScopeRef.compareAndSet(null, localLifecycleCoroutineScopeImpl));
    localLifecycleCoroutineScopeImpl.register();
    return localLifecycleCoroutineScopeImpl;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LifecycleKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */