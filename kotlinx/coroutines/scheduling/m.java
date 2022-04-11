package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.v.e;

public final class m
{
  private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");
  static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");
  static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");
  volatile int consumerIndex = 0;
  private final AtomicReferenceArray<h> d = new AtomicReferenceArray(128);
  private volatile Object lastScheduledTask = null;
  volatile int producerIndex = 0;
  
  private final void d(d paramd, h paramh)
  {
    if (paramd.a(paramh)) {
      return;
    }
    throw new IllegalStateException("GlobalQueue could not be closed yet".toString());
  }
  
  private final void g(d paramd)
  {
    int i = e.b(e() / 2, 1);
    for (int j = 0; j < i; j++)
    {
      int k;
      int m;
      do
      {
        k = this.consumerIndex;
        m = this.producerIndex;
        localh = null;
        if (k - m == 0) {
          break;
        }
        m = k & 0x7F;
      } while (((h)a(this).get(m) == null) || (!c.compareAndSet(this, k, k + 1)));
      h localh = (h)a(this).getAndSet(m, null);
      if (localh == null) {
        break;
      }
      d(paramd, localh);
    }
  }
  
  private final boolean j(h paramh)
  {
    if (e() == 127) {
      return false;
    }
    int i = this.producerIndex & 0x7F;
    if (this.d.get(i) != null) {
      return false;
    }
    this.d.lazySet(i, paramh);
    b.incrementAndGet(this);
    return true;
  }
  
  private final boolean l(long paramLong, m paramm, d paramd)
  {
    h localh = (h)paramm.lastScheduledTask;
    if (localh != null)
    {
      if (paramLong - localh.c < k.a) {
        return false;
      }
      if (a.compareAndSet(paramm, localh, null))
      {
        b(localh, paramd);
        return true;
      }
    }
    return false;
  }
  
  public final boolean b(h paramh, d paramd)
  {
    kotlin.jvm.internal.j.f(paramh, "task");
    kotlin.jvm.internal.j.f(paramd, "globalQueue");
    paramh = (h)a.getAndSet(this, paramh);
    if (paramh != null) {
      return c(paramh, paramd);
    }
    return true;
  }
  
  public final boolean c(h paramh, d paramd)
  {
    kotlin.jvm.internal.j.f(paramh, "task");
    kotlin.jvm.internal.j.f(paramd, "globalQueue");
    for (boolean bool = true; !j(paramh); bool = false) {
      g(paramd);
    }
    return bool;
  }
  
  public final int e()
  {
    return this.producerIndex - this.consumerIndex;
  }
  
  public final void f(d paramd)
  {
    kotlin.jvm.internal.j.f(paramd, "globalQueue");
    h localh = (h)a.getAndSet(this, null);
    if (localh != null) {
      d(paramd, localh);
    }
    for (;;)
    {
      int i = this.consumerIndex;
      if (i - this.producerIndex == 0)
      {
        localh = null;
      }
      else
      {
        int j = i & 0x7F;
        if (((h)a(this).get(j) == null) || (!c.compareAndSet(this, i, i + 1))) {
          continue;
        }
        localh = (h)a(this).getAndSet(j, null);
      }
      if (localh == null) {
        break;
      }
      d(paramd, localh);
    }
  }
  
  public final h h()
  {
    Object localObject1 = a;
    Object localObject2 = null;
    localObject1 = (h)((AtomicReferenceFieldUpdater)localObject1).getAndSet(this, null);
    if (localObject1 != null)
    {
      localObject2 = localObject1;
    }
    else
    {
      int i;
      int j;
      do
      {
        i = this.consumerIndex;
        if (i - this.producerIndex == 0) {
          break;
        }
        j = i & 0x7F;
      } while (((h)a(this).get(j) == null) || (!c.compareAndSet(this, i, i + 1)));
      localObject2 = (h)a(this).getAndSet(j, null);
    }
    return (h)localObject2;
  }
  
  public final int i()
  {
    int i;
    if (this.lastScheduledTask != null) {
      i = e() + 1;
    } else {
      i = e();
    }
    return i;
  }
  
  public final boolean k(m paramm, d paramd)
  {
    kotlin.jvm.internal.j.f(paramm, "victim");
    kotlin.jvm.internal.j.f(paramd, "globalQueue");
    long l = k.g.a();
    int i = paramm.e();
    if (i == 0) {
      return l(l, paramm, paramd);
    }
    int j = e.b(i / 2, 1);
    i = 0;
    for (boolean bool = false; i < j; bool = true)
    {
      int k;
      int n;
      do
      {
        int m;
        h localh2;
        do
        {
          k = paramm.consumerIndex;
          m = paramm.producerIndex;
          localh1 = null;
          if (k - m == 0) {
            break;
          }
          n = k & 0x7F;
          localh2 = (h)a(paramm).get(n);
        } while (localh2 == null);
        if ((l - localh2.c < k.a) && (paramm.e() <= k.b)) {
          m = 0;
        } else {
          m = 1;
        }
        if (m == 0) {
          break;
        }
      } while (!c.compareAndSet(paramm, k, k + 1));
      h localh1 = (h)a(paramm).getAndSet(n, null);
      if (localh1 == null) {
        break;
      }
      b(localh1, paramd);
      i++;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\scheduling\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */