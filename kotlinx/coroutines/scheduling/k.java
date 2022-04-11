package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.v.e;
import kotlinx.coroutines.internal.u;

public final class k
{
  public static final long a = u.g("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
  public static final int b = u.f("kotlinx.coroutines.scheduler.offload.threshold", 96, 0, 128, 4, null);
  public static final int c = u.f("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
  public static final int d;
  public static final int e;
  public static final long f = TimeUnit.SECONDS.toNanos(u.g("kotlinx.coroutines.scheduler.keep.alive.sec", 5L, 0L, 0L, 12, null));
  public static l g = f.a;
  
  static
  {
    int i = u.f("kotlinx.coroutines.scheduler.core.pool.size", e.b(u.a(), 2), 1, 0, 8, null);
    d = i;
    e = u.f("kotlinx.coroutines.scheduler.max.pool.size", e.f(u.a() * 128, i, 2097150), 0, 2097150, 4, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\scheduling\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */