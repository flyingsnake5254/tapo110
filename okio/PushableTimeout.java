package okio;

import java.util.concurrent.TimeUnit;

final class PushableTimeout
  extends Timeout
{
  private long originalDeadlineNanoTime;
  private boolean originalHasDeadline;
  private long originalTimeoutNanos;
  private Timeout pushed;
  
  void pop()
  {
    this.pushed.timeout(this.originalTimeoutNanos, TimeUnit.NANOSECONDS);
    if (this.originalHasDeadline) {
      this.pushed.deadlineNanoTime(this.originalDeadlineNanoTime);
    } else {
      this.pushed.clearDeadline();
    }
  }
  
  void push(Timeout paramTimeout)
  {
    this.pushed = paramTimeout;
    boolean bool = paramTimeout.hasDeadline();
    this.originalHasDeadline = bool;
    if (bool) {
      l = paramTimeout.deadlineNanoTime();
    } else {
      l = -1L;
    }
    this.originalDeadlineNanoTime = l;
    long l = paramTimeout.timeoutNanos();
    this.originalTimeoutNanos = l;
    paramTimeout.timeout(Timeout.minTimeout(l, timeoutNanos()), TimeUnit.NANOSECONDS);
    if ((this.originalHasDeadline) && (hasDeadline())) {
      paramTimeout.deadlineNanoTime(Math.min(deadlineNanoTime(), this.originalDeadlineNanoTime));
    } else if (hasDeadline()) {
      paramTimeout.deadlineNanoTime(deadlineNanoTime());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\PushableTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */