package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.p;
import kotlin.v.e;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.y1;
import kotlinx.coroutines.z1;

public final class CoroutineScheduler
  implements Executor, Closeable
{
  private static final AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
  static final AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
  private static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
  private static final t p0;
  public static final a p1 = new a(null);
  private static final int q;
  private static final int x;
  private static final int y;
  private static final int z;
  private final b[] H3;
  private final Random I3;
  private final int J3;
  private final int K3;
  private final long L3;
  private final String M3;
  private volatile int _isTerminated;
  volatile long controlState;
  private final d p2;
  private final Semaphore p3;
  private volatile long parkedWorkersStack;
  
  static
  {
    int i = u.f("kotlinx.coroutines.scheduler.spins", 1000, 1, 0, 8, null);
    q = i;
    x = i + u.f("kotlinx.coroutines.scheduler.yields", 0, 0, 0, 8, null);
    i = (int)TimeUnit.SECONDS.toNanos(1L);
    y = i;
    z = (int)e.e(e.c(k.a / 4, 10L), i);
    p0 = new t("NOT_IN_STACK");
  }
  
  public CoroutineScheduler(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    this.J3 = paramInt1;
    this.K3 = paramInt2;
    this.L3 = paramLong;
    this.M3 = paramString;
    int i;
    if (paramInt1 >= 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= 2097150) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (paramLong > 0L) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            this.p2 = new d();
            this.p3 = new Semaphore(paramInt1, false);
            this.parkedWorkersStack = 0L;
            this.H3 = new b[paramInt2 + 1];
            this.controlState = 0L;
            this.I3 = new Random();
            this._isTerminated = 0;
            return;
          }
          paramString = new StringBuilder();
          paramString.append("Idle worker keep alive time ");
          paramString.append(paramLong);
          paramString.append(" must be positive");
          throw new IllegalArgumentException(paramString.toString().toString());
        }
        paramString = new StringBuilder();
        paramString.append("Max pool size ");
        paramString.append(paramInt2);
        paramString.append(" should not exceed maximal supported number of threads 2097150");
        throw new IllegalArgumentException(paramString.toString().toString());
      }
      paramString = new StringBuilder();
      paramString.append("Max pool size ");
      paramString.append(paramInt2);
      paramString.append(" should be greater than or equals to core pool size ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString().toString());
    }
    paramString = new StringBuilder();
    paramString.append("Core pool size ");
    paramString.append(paramInt1);
    paramString.append(" should be at least 1");
    throw new IllegalArgumentException(paramString.toString().toString());
  }
  
  private final int C()
  {
    synchronized (this.H3)
    {
      boolean bool = isTerminated();
      if (bool) {
        return -1;
      }
      long l = this.controlState;
      int i = (int)(l & 0x1FFFFF);
      int j = i - (int)((l & 0x3FFFFE00000) >> 21);
      int k = this.J3;
      int m = 0;
      if (j >= k) {
        return 0;
      }
      if ((i < this.K3) && (this.p3.availablePermits() != 0))
      {
        k = (int)(this.controlState & 0x1FFFFF) + 1;
        if ((k > 0) && (this.H3[k] == null)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          localObject1 = new kotlinx/coroutines/scheduling/CoroutineScheduler$b;
          ((b)localObject1).<init>(this, k);
          ((Thread)localObject1).start();
          i = m;
          if (k == (int)(0x1FFFFF & d.incrementAndGet(this))) {
            i = 1;
          }
          if (i != 0)
          {
            this.H3[k] = localObject1;
            return j + 1;
          }
          localObject1 = new java/lang/IllegalArgumentException;
          ((IllegalArgumentException)localObject1).<init>("Failed requirement.".toString());
          throw ((Throwable)localObject1);
        }
        Object localObject1 = new java/lang/IllegalArgumentException;
        ((IllegalArgumentException)localObject1).<init>("Failed requirement.".toString());
        throw ((Throwable)localObject1);
      }
      return 0;
    }
  }
  
  private final b E()
  {
    Object localObject1 = Thread.currentThread();
    boolean bool = localObject1 instanceof b;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    b localb = (b)localObject1;
    localObject1 = localObject2;
    if (localb != null)
    {
      localObject1 = localObject2;
      if (kotlin.jvm.internal.j.a(localb.l(), this)) {
        localObject1 = localb;
      }
    }
    return (b)localObject1;
  }
  
  private final int H()
  {
    return (int)(this.controlState & 0x1FFFFF);
  }
  
  private final int I(b paramb)
  {
    for (paramb = paramb.k();; paramb = paramb.k())
    {
      if (paramb == p0) {
        return -1;
      }
      if (paramb == null) {
        return 0;
      }
      paramb = (b)paramb;
      int i = paramb.i();
      if (i != 0) {
        return i;
      }
    }
  }
  
  private final b J()
  {
    long l;
    int i;
    b localb;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      localb = this.H3[i];
      if (localb == null) {
        break;
      }
      i = I(localb);
    } while ((i < 0) || (!c.compareAndSet(this, l, i | 2097152L + l & 0xFFFFFFFFFFE00000)));
    localb.t(p0);
    return localb;
    return null;
  }
  
  private final void K(b paramb)
  {
    if (paramb.k() != p0) {
      return;
    }
    long l;
    int j;
    do
    {
      l = this.parkedWorkersStack;
      int i = (int)(0x1FFFFF & l);
      j = paramb.i();
      if (g0.a())
      {
        int k;
        if (j != 0) {
          k = 1;
        } else {
          k = 0;
        }
        if (k == 0) {
          throw new AssertionError();
        }
      }
      paramb.t(this.H3[i]);
    } while (!c.compareAndSet(this, l, j | 2097152L + l & 0xFFFFFFFFFFE00000));
  }
  
  private final void L(b paramb, int paramInt1, int paramInt2)
  {
    long l;
    int j;
    do
    {
      l = this.parkedWorkersStack;
      int i = (int)(0x1FFFFF & l);
      j = i;
      if (i == paramInt1) {
        if (paramInt2 == 0) {
          j = I(paramb);
        } else {
          j = paramInt2;
        }
      }
    } while ((j < 0) || (!c.compareAndSet(this, l, 2097152L + l & 0xFFFFFFFFFFE00000 | j)));
  }
  
  private final void M()
  {
    if (this.p3.availablePermits() == 0)
    {
      Q();
      return;
    }
    if (Q()) {
      return;
    }
    long l = this.controlState;
    if ((int)(0x1FFFFF & l) - (int)((l & 0x3FFFFE00000) >> 21) < this.J3)
    {
      int i = C();
      if ((i == 1) && (this.J3 > 1)) {
        C();
      }
      if (i > 0) {
        return;
      }
    }
    Q();
  }
  
  /* Error */
  private final void N(h paramh)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 312 1 0
    //   6: invokestatic 317	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +46 -> 57
    //   14: aload_1
    //   15: invokeinterface 321 1 0
    //   20: goto +37 -> 57
    //   23: astore_1
    //   24: invokestatic 250	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   27: astore_2
    //   28: aload_2
    //   29: ldc_w 323
    //   32: invokestatic 325	kotlin/jvm/internal/j:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   35: aload_2
    //   36: invokevirtual 329	java/lang/Thread:getUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   39: aload_2
    //   40: aload_1
    //   41: invokeinterface 335 3 0
    //   46: invokestatic 317	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +6 -> 57
    //   54: goto -40 -> 14
    //   57: return
    //   58: astore_1
    //   59: invokestatic 317	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +9 -> 73
    //   67: aload_2
    //   68: invokeinterface 321 1 0
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	CoroutineScheduler
    //   0	75	1	paramh	h
    //   27	41	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	23	finally
    //   24	46	58	finally
  }
  
  private final int P(h paramh, boolean paramBoolean)
  {
    b localb = E();
    if (localb != null)
    {
      if (localb.m() == WorkerState.TERMINATED) {
        return 1;
      }
      int i = -1;
      int j = i;
      if (paramh.a() == TaskMode.NON_BLOCKING) {
        if (localb.p())
        {
          j = 0;
        }
        else
        {
          j = i;
          if (!localb.u()) {
            return 1;
          }
        }
      }
      if (paramBoolean) {
        paramBoolean = localb.j().c(paramh, this.p2);
      } else {
        paramBoolean = localb.j().b(paramh, this.p2);
      }
      if (paramBoolean)
      {
        if (localb.j().e() > k.b) {
          return 0;
        }
        return j;
      }
      return 0;
    }
    return 1;
  }
  
  private final boolean Q()
  {
    b localb;
    boolean bool;
    do
    {
      localb = J();
      if (localb == null) {
        break;
      }
      localb.o();
      bool = localb.q();
      LockSupport.unpark(localb);
    } while ((!bool) || (!localb.v()));
    return true;
    return false;
  }
  
  private final boolean isTerminated()
  {
    boolean bool;
    if (this._isTerminated != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final h D(Runnable paramRunnable, i parami)
  {
    kotlin.jvm.internal.j.f(paramRunnable, "block");
    kotlin.jvm.internal.j.f(parami, "taskContext");
    long l = k.g.a();
    if ((paramRunnable instanceof h))
    {
      paramRunnable = (h)paramRunnable;
      paramRunnable.c = l;
      paramRunnable.d = parami;
      return paramRunnable;
    }
    return new j(paramRunnable, l, parami);
  }
  
  public final void F(Runnable paramRunnable, i parami, boolean paramBoolean)
  {
    kotlin.jvm.internal.j.f(paramRunnable, "block");
    kotlin.jvm.internal.j.f(parami, "taskContext");
    y1 localy1 = z1.a();
    if (localy1 != null) {
      localy1.e();
    }
    paramRunnable = D(paramRunnable, parami);
    int i = P(paramRunnable, paramBoolean);
    if (i != -1)
    {
      if (i != 1)
      {
        M();
      }
      else
      {
        if (!this.p2.a(paramRunnable)) {
          break label81;
        }
        M();
      }
      return;
      label81:
      paramRunnable = new StringBuilder();
      paramRunnable.append(this.M3);
      paramRunnable.append(" was terminated");
      throw new RejectedExecutionException(paramRunnable.toString());
    }
  }
  
  public final void O(long paramLong)
  {
    ??? = f;
    int i = 0;
    if (!((AtomicIntegerFieldUpdater)???).compareAndSet(this, 0, 1)) {
      return;
    }
    b localb1 = E();
    synchronized (this.H3)
    {
      long l = this.controlState;
      int j = (int)(l & 0x1FFFFF);
      int k;
      if (1 <= j) {
        for (k = 1;; k++)
        {
          b localb2 = this.H3[k];
          if (localb2 == null) {
            kotlin.jvm.internal.j.n();
          }
          if (localb2 != localb1)
          {
            while (localb2.isAlive())
            {
              LockSupport.unpark(localb2);
              localb2.join(paramLong);
            }
            ??? = localb2.m();
            if (g0.a())
            {
              int m;
              if (??? == WorkerState.TERMINATED) {
                m = 1;
              } else {
                m = 0;
              }
              if (m == 0) {
                throw new AssertionError();
              }
            }
            localb2.j().f(this.p2);
          }
          if (k == j) {
            break;
          }
        }
      }
      this.p2.b();
      for (;;)
      {
        if (localb1 != null)
        {
          ??? = localb1.g();
          if (??? != null) {}
        }
        else
        {
          ??? = (h)this.p2.d();
        }
        if (??? == null) {
          break;
        }
        N((h)???);
      }
      if (localb1 != null) {
        localb1.w(WorkerState.TERMINATED);
      }
      if (g0.a())
      {
        k = i;
        if (this.p3.availablePermits() == this.J3) {
          k = 1;
        }
        if (k == 0) {
          throw new AssertionError();
        }
      }
      this.parkedWorkersStack = 0L;
      this.controlState = 0L;
      return;
    }
  }
  
  public void close()
  {
    O(10000L);
  }
  
  public void execute(Runnable paramRunnable)
  {
    kotlin.jvm.internal.j.f(paramRunnable, "command");
    G(this, paramRunnable, null, false, 6, null);
  }
  
  public String toString()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.H3;
    int i = localObject1.length;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i6;
    for (int i2 = 0; j < i; i2 = i6)
    {
      Object localObject2 = localObject1[j];
      int i3;
      int i4;
      int i5;
      if (localObject2 == null)
      {
        i3 = k;
        i4 = m;
        i5 = n;
        i6 = i2;
      }
      else
      {
        int i7 = ((b)localObject2).j().i();
        localObject2 = ((b)localObject2).m();
        i3 = a.a[localObject2.ordinal()];
        if (i3 != 1)
        {
          if (i3 != 2)
          {
            if (i3 != 3)
            {
              if (i3 != 4)
              {
                if (i3 != 5)
                {
                  i3 = k;
                  i4 = m;
                  i5 = n;
                  i6 = i2;
                }
                else
                {
                  i6 = i2 + 1;
                  i3 = k;
                  i4 = m;
                  i5 = n;
                }
              }
              else
              {
                int i8 = i1 + 1;
                i3 = k;
                i4 = m;
                i5 = n;
                i1 = i8;
                i6 = i2;
                if (i7 > 0)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(String.valueOf(i7));
                  ((StringBuilder)localObject2).append("r");
                  localArrayList.add(((StringBuilder)localObject2).toString());
                  i3 = k;
                  i4 = m;
                  i5 = n;
                  i1 = i8;
                  i6 = i2;
                }
              }
            }
            else
            {
              i3 = k + 1;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(String.valueOf(i7));
              ((StringBuilder)localObject2).append("c");
              localArrayList.add(((StringBuilder)localObject2).toString());
              i4 = m;
              i5 = n;
              i6 = i2;
            }
          }
          else
          {
            i4 = m + 1;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(String.valueOf(i7));
            ((StringBuilder)localObject2).append("b");
            localArrayList.add(((StringBuilder)localObject2).toString());
            i3 = k;
            i5 = n;
            i6 = i2;
          }
        }
        else
        {
          i5 = n + 1;
          i6 = i2;
          i4 = m;
          i3 = k;
        }
      }
      j++;
      k = i3;
      m = i4;
      n = i5;
    }
    long l = this.controlState;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.M3);
    ((StringBuilder)localObject1).append('@');
    ((StringBuilder)localObject1).append(h0.b(this));
    ((StringBuilder)localObject1).append('[');
    ((StringBuilder)localObject1).append("Pool Size {");
    ((StringBuilder)localObject1).append("core = ");
    ((StringBuilder)localObject1).append(this.J3);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append("max = ");
    ((StringBuilder)localObject1).append(this.K3);
    ((StringBuilder)localObject1).append("}, ");
    ((StringBuilder)localObject1).append("Worker States {");
    ((StringBuilder)localObject1).append("CPU = ");
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append("blocking = ");
    ((StringBuilder)localObject1).append(m);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append("parked = ");
    ((StringBuilder)localObject1).append(n);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append("retired = ");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append("terminated = ");
    ((StringBuilder)localObject1).append(i2);
    ((StringBuilder)localObject1).append("}, ");
    ((StringBuilder)localObject1).append("running workers queues = ");
    ((StringBuilder)localObject1).append(localArrayList);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append("global queue size = ");
    ((StringBuilder)localObject1).append(this.p2.c());
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append("Control State Workers {");
    ((StringBuilder)localObject1).append("created = ");
    ((StringBuilder)localObject1).append((int)(0x1FFFFF & l));
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append("blocking = ");
    ((StringBuilder)localObject1).append((int)((l & 0x3FFFFE00000) >> 21));
    ((StringBuilder)localObject1).append('}');
    ((StringBuilder)localObject1).append("]");
    return ((StringBuilder)localObject1).toString();
  }
  
  public static enum WorkerState
  {
    static
    {
      WorkerState localWorkerState1 = new WorkerState("CPU_ACQUIRED", 0);
      CPU_ACQUIRED = localWorkerState1;
      WorkerState localWorkerState2 = new WorkerState("BLOCKING", 1);
      BLOCKING = localWorkerState2;
      WorkerState localWorkerState3 = new WorkerState("PARKING", 2);
      PARKING = localWorkerState3;
      WorkerState localWorkerState4 = new WorkerState("RETIRING", 3);
      RETIRING = localWorkerState4;
      WorkerState localWorkerState5 = new WorkerState("TERMINATED", 4);
      TERMINATED = localWorkerState5;
      $VALUES = new WorkerState[] { localWorkerState1, localWorkerState2, localWorkerState3, localWorkerState4, localWorkerState5 };
    }
  }
  
  public static final class a {}
  
  public final class b
    extends Thread
  {
    private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(b.class, "terminationState");
    private final m d;
    private long f;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private long q;
    private volatile int spins;
    private volatile CoroutineScheduler.WorkerState state;
    private volatile int terminationState;
    private int x;
    private int y;
    private int z;
    
    private b()
    {
      setDaemon(true);
      this.d = new m();
      this.state = CoroutineScheduler.WorkerState.RETIRING;
      this.terminationState = 0;
      this.nextParkedWorker = CoroutineScheduler.t();
      this.x = CoroutineScheduler.s();
      this.y = CoroutineScheduler.u(CoroutineScheduler.this).nextInt();
    }
    
    public b()
    {
      this();
      int i;
      s(i);
    }
    
    private final void a(TaskMode paramTaskMode)
    {
      if (paramTaskMode != TaskMode.NON_BLOCKING)
      {
        paramTaskMode = CoroutineScheduler.this;
        CoroutineScheduler.d.addAndGet(paramTaskMode, -2097152L);
        paramTaskMode = this.state;
        if (paramTaskMode != CoroutineScheduler.WorkerState.TERMINATED)
        {
          if (g0.a())
          {
            int i;
            if (paramTaskMode == CoroutineScheduler.WorkerState.BLOCKING) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0) {
              throw new AssertionError();
            }
          }
          this.state = CoroutineScheduler.WorkerState.RETIRING;
        }
      }
    }
    
    private final void b(TaskMode paramTaskMode, long paramLong)
    {
      if (paramTaskMode != TaskMode.NON_BLOCKING)
      {
        paramTaskMode = CoroutineScheduler.this;
        CoroutineScheduler.d.addAndGet(paramTaskMode, 2097152L);
        if (w(CoroutineScheduler.WorkerState.BLOCKING)) {
          CoroutineScheduler.A(CoroutineScheduler.this);
        }
        return;
      }
      if (CoroutineScheduler.c(CoroutineScheduler.this).availablePermits() == 0) {
        return;
      }
      long l1 = k.g.a();
      long l2 = k.a;
      if ((l1 - paramLong >= l2) && (l1 - this.q >= l2 * 5))
      {
        this.q = l1;
        CoroutineScheduler.A(CoroutineScheduler.this);
      }
    }
    
    private final boolean c()
    {
      h localh = CoroutineScheduler.g(CoroutineScheduler.this).e(TaskMode.PROBABLY_BLOCKING);
      if (localh != null)
      {
        this.d.b(localh, CoroutineScheduler.g(CoroutineScheduler.this));
        return false;
      }
      return true;
    }
    
    private final void d()
    {
      w(CoroutineScheduler.WorkerState.PARKING);
      if (!c()) {
        return;
      }
      this.terminationState = 0;
      if (this.f == 0L) {
        this.f = (System.nanoTime() + CoroutineScheduler.i(CoroutineScheduler.this));
      }
      if (!f(CoroutineScheduler.i(CoroutineScheduler.this))) {
        return;
      }
      if (System.nanoTime() - this.f >= 0L)
      {
        this.f = 0L;
        y();
      }
    }
    
    private final void e()
    {
      int i = this.spins;
      if (i <= CoroutineScheduler.l())
      {
        this.spins = (i + 1);
        if (i >= CoroutineScheduler.k()) {
          Thread.yield();
        }
      }
      else
      {
        if (this.x < CoroutineScheduler.j()) {
          this.x = e.d(this.x * 3 >>> 1, CoroutineScheduler.j());
        }
        w(CoroutineScheduler.WorkerState.PARKING);
        f(this.x);
      }
    }
    
    private final boolean f(long paramLong)
    {
      CoroutineScheduler.y(CoroutineScheduler.this, this);
      if (!c()) {
        return false;
      }
      LockSupport.parkNanos(paramLong);
      return true;
    }
    
    private final h h()
    {
      int i;
      if (r(CoroutineScheduler.a(CoroutineScheduler.this) * 2) == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localh = CoroutineScheduler.g(CoroutineScheduler.this).e(TaskMode.NON_BLOCKING);
        if (localh != null) {
          return localh;
        }
      }
      h localh = this.d.h();
      if (localh != null) {
        return localh;
      }
      if (i == 0)
      {
        localh = (h)CoroutineScheduler.g(CoroutineScheduler.this).d();
        if (localh != null) {
          return localh;
        }
      }
      return x();
    }
    
    private final void n(TaskMode paramTaskMode)
    {
      this.f = 0L;
      this.z = 0;
      if (this.state == CoroutineScheduler.WorkerState.PARKING)
      {
        if (g0.a())
        {
          int i;
          if (paramTaskMode == TaskMode.PROBABLY_BLOCKING) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0) {
            throw new AssertionError();
          }
        }
        this.state = CoroutineScheduler.WorkerState.BLOCKING;
        this.x = CoroutineScheduler.s();
      }
      this.spins = 0;
    }
    
    private final h x()
    {
      int i = CoroutineScheduler.e(CoroutineScheduler.this);
      if (i < 2) {
        return null;
      }
      int j = this.z;
      int k = j;
      if (j == 0) {
        k = r(i);
      }
      j = 1;
      k++;
      if (k > i) {
        k = j;
      }
      this.z = k;
      b localb = CoroutineScheduler.w(CoroutineScheduler.this)[k];
      if ((localb != null) && (localb != this) && (this.d.k(localb.d, CoroutineScheduler.g(CoroutineScheduler.this)))) {
        return this.d.h();
      }
      return null;
    }
    
    private final void y()
    {
      synchronized (CoroutineScheduler.w(CoroutineScheduler.this))
      {
        boolean bool = CoroutineScheduler.x(CoroutineScheduler.this);
        if (bool) {
          return;
        }
        int i = CoroutineScheduler.e(CoroutineScheduler.this);
        int j = CoroutineScheduler.a(CoroutineScheduler.this);
        if (i <= j) {
          return;
        }
        bool = c();
        if (!bool) {
          return;
        }
        bool = c.compareAndSet(this, 0, 1);
        if (!bool) {
          return;
        }
        i = this.indexInArray;
        s(0);
        CoroutineScheduler.z(CoroutineScheduler.this, this, i, 0);
        Object localObject1 = CoroutineScheduler.this;
        j = (int)(CoroutineScheduler.d.getAndDecrement(localObject1) & 0x1FFFFF);
        if (j != i)
        {
          localObject1 = CoroutineScheduler.w(CoroutineScheduler.this)[j];
          if (localObject1 == null) {
            kotlin.jvm.internal.j.n();
          }
          CoroutineScheduler.w(CoroutineScheduler.this)[i] = localObject1;
          ((b)localObject1).s(i);
          CoroutineScheduler.z(CoroutineScheduler.this, (b)localObject1, j, i);
        }
        CoroutineScheduler.w(CoroutineScheduler.this)[j] = null;
        localObject1 = p.a;
        this.state = CoroutineScheduler.WorkerState.TERMINATED;
        return;
      }
    }
    
    public final h g()
    {
      if (u()) {
        return h();
      }
      h localh = this.d.h();
      if (localh == null) {
        localh = CoroutineScheduler.g(CoroutineScheduler.this).e(TaskMode.PROBABLY_BLOCKING);
      }
      return localh;
    }
    
    public final int i()
    {
      return this.indexInArray;
    }
    
    public final m j()
    {
      return this.d;
    }
    
    public final Object k()
    {
      return this.nextParkedWorker;
    }
    
    public final CoroutineScheduler l()
    {
      return CoroutineScheduler.this;
    }
    
    public final CoroutineScheduler.WorkerState m()
    {
      return this.state;
    }
    
    public final void o()
    {
      this.x = CoroutineScheduler.s();
      this.spins = 0;
    }
    
    public final boolean p()
    {
      boolean bool;
      if (this.state == CoroutineScheduler.WorkerState.BLOCKING) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final boolean q()
    {
      boolean bool;
      if (this.state == CoroutineScheduler.WorkerState.PARKING) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final int r(int paramInt)
    {
      int i = this.y;
      i ^= i << 13;
      this.y = i;
      i ^= i >> 17;
      this.y = i;
      i ^= i << 5;
      this.y = i;
      int j = paramInt - 1;
      if ((j & paramInt) == 0) {
        return i & j;
      }
      return (i & 0x7FFFFFFF) % paramInt;
    }
    
    public void run()
    {
      int i = 0;
      while ((!CoroutineScheduler.x(CoroutineScheduler.this)) && (this.state != CoroutineScheduler.WorkerState.TERMINATED))
      {
        h localh = g();
        if (localh == null)
        {
          if (this.state == CoroutineScheduler.WorkerState.CPU_ACQUIRED) {
            e();
          } else {
            d();
          }
          i = 1;
        }
        else
        {
          TaskMode localTaskMode = localh.a();
          int j = i;
          if (i != 0)
          {
            n(localTaskMode);
            j = 0;
          }
          b(localTaskMode, localh.c);
          CoroutineScheduler.B(CoroutineScheduler.this, localh);
          a(localTaskMode);
          i = j;
        }
      }
      w(CoroutineScheduler.WorkerState.TERMINATED);
    }
    
    public final void s(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(CoroutineScheduler.v(CoroutineScheduler.this));
      localStringBuilder.append("-worker-");
      String str;
      if (paramInt == 0) {
        str = "TERMINATED";
      } else {
        str = String.valueOf(paramInt);
      }
      localStringBuilder.append(str);
      setName(localStringBuilder.toString());
      this.indexInArray = paramInt;
    }
    
    public final void t(Object paramObject)
    {
      this.nextParkedWorker = paramObject;
    }
    
    public final boolean u()
    {
      CoroutineScheduler.WorkerState localWorkerState1 = this.state;
      CoroutineScheduler.WorkerState localWorkerState2 = CoroutineScheduler.WorkerState.CPU_ACQUIRED;
      boolean bool = true;
      if (localWorkerState1 != localWorkerState2) {
        if (CoroutineScheduler.c(CoroutineScheduler.this).tryAcquire()) {
          this.state = localWorkerState2;
        } else {
          bool = false;
        }
      }
      return bool;
    }
    
    public final boolean v()
    {
      int i = this.terminationState;
      boolean bool = false;
      if ((i != 1) && (i != -1))
      {
        if (i == 0) {
          bool = c.compareAndSet(this, 0, -1);
        }
      }
      else {
        return bool;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid terminationState = ");
      localStringBuilder.append(i);
      throw new IllegalStateException(localStringBuilder.toString().toString());
    }
    
    public final boolean w(CoroutineScheduler.WorkerState paramWorkerState)
    {
      kotlin.jvm.internal.j.f(paramWorkerState, "newState");
      CoroutineScheduler.WorkerState localWorkerState = this.state;
      boolean bool;
      if (localWorkerState == CoroutineScheduler.WorkerState.CPU_ACQUIRED) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        CoroutineScheduler.c(CoroutineScheduler.this).release();
      }
      if (localWorkerState != paramWorkerState) {
        this.state = paramWorkerState;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\scheduling\CoroutineScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */