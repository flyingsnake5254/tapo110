package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.d1.a;

@MainThread
public final class LifecycleController
{
  private final DispatchQueue dispatchQueue;
  private final Lifecycle lifecycle;
  private final Lifecycle.State minState;
  private final LifecycleEventObserver observer;
  
  public LifecycleController(Lifecycle paramLifecycle, Lifecycle.State paramState, DispatchQueue paramDispatchQueue, final d1 paramd1)
  {
    this.lifecycle = paramLifecycle;
    this.minState = paramState;
    this.dispatchQueue = paramDispatchQueue;
    paramState = new LifecycleEventObserver()
    {
      public final void onStateChanged(LifecycleOwner paramAnonymousLifecycleOwner, Lifecycle.Event paramAnonymousEvent)
      {
        j.f(paramAnonymousLifecycleOwner, "source");
        j.f(paramAnonymousEvent, "<anonymous parameter 1>");
        paramAnonymousEvent = paramAnonymousLifecycleOwner.getLifecycle();
        j.b(paramAnonymousEvent, "source.lifecycle");
        if (paramAnonymousEvent.getCurrentState() == Lifecycle.State.DESTROYED)
        {
          paramAnonymousLifecycleOwner = this.this$0;
          d1.a.a(paramd1, null, 1, null);
          paramAnonymousLifecycleOwner.finish();
        }
        else
        {
          paramAnonymousLifecycleOwner = paramAnonymousLifecycleOwner.getLifecycle();
          j.b(paramAnonymousLifecycleOwner, "source.lifecycle");
          if (paramAnonymousLifecycleOwner.getCurrentState().compareTo(LifecycleController.access$getMinState$p(this.this$0)) < 0) {
            LifecycleController.access$getDispatchQueue$p(this.this$0).pause();
          } else {
            LifecycleController.access$getDispatchQueue$p(this.this$0).resume();
          }
        }
      }
    };
    this.observer = paramState;
    if (paramLifecycle.getCurrentState() == Lifecycle.State.DESTROYED)
    {
      d1.a.a(paramd1, null, 1, null);
      finish();
    }
    else
    {
      paramLifecycle.addObserver(paramState);
    }
  }
  
  private final void handleDestroy(d1 paramd1)
  {
    d1.a.a(paramd1, null, 1, null);
    finish();
  }
  
  @MainThread
  public final void finish()
  {
    this.lifecycle.removeObserver(this.observer);
    this.dispatchQueue.finish();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LifecycleController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */