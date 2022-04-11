package io.reactivex.internal.schedulers;

import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.ThreadFactory;

public final class g
  extends w
{
  private static final RxThreadFactory c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
  final ThreadFactory d;
  
  public g()
  {
    this(c);
  }
  
  public g(ThreadFactory paramThreadFactory)
  {
    this.d = paramThreadFactory;
  }
  
  public w.c b()
  {
    return new h(this.d);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */