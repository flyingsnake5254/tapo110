package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y;

public final class DispatchQueue
{
  private boolean finished;
  private boolean isDraining;
  private boolean paused = true;
  private final Queue<Runnable> queue = new ArrayDeque();
  
  @MainThread
  private final boolean canRun()
  {
    boolean bool;
    if ((!this.finished) && (this.paused)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @MainThread
  private final void enqueue(Runnable paramRunnable)
  {
    if (this.queue.offer(paramRunnable))
    {
      drainQueue();
      return;
    }
    throw new IllegalStateException("cannot enqueue any more runnables".toString());
  }
  
  @MainThread
  public final void drainQueue()
  {
    if (this.isDraining) {
      return;
    }
    try
    {
      this.isDraining = true;
      while (((this.queue.isEmpty() ^ true)) && (canRun()))
      {
        Runnable localRunnable = (Runnable)this.queue.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      return;
    }
    finally
    {
      this.isDraining = false;
    }
  }
  
  @MainThread
  public final void finish()
  {
    this.finished = true;
    drainQueue();
  }
  
  @MainThread
  public final void pause()
  {
    this.paused = true;
  }
  
  @MainThread
  public final void resume()
  {
    if (!this.paused) {
      return;
    }
    if ((this.finished ^ true))
    {
      this.paused = false;
      drainQueue();
      return;
    }
    throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
  }
  
  @SuppressLint({"WrongThread"})
  @AnyThread
  public final void runOrEnqueue(final Runnable paramRunnable)
  {
    j.f(paramRunnable, "runnable");
    m1 localm1 = n0.b().u();
    EmptyCoroutineContext localEmptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
    if (localm1.isDispatchNeeded(localEmptyCoroutineContext)) {
      localm1.dispatch(localEmptyCoroutineContext, new Runnable()
      {
        public final void run()
        {
          DispatchQueue.access$enqueue(this.this$0, paramRunnable);
        }
      });
    } else {
      enqueue(paramRunnable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\DispatchQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */