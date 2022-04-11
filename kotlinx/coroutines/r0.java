package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlin.v.e;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.internal.z;

public abstract class r0
  extends s0
{
  private static final AtomicReferenceFieldUpdater q = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_queue");
  private static final AtomicReferenceFieldUpdater x = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_delayed");
  private volatile Object _delayed = null;
  private volatile Object _queue = null;
  private volatile boolean isCompleted;
  
  private final void H()
  {
    if ((g0.a()) && (!this.isCompleted)) {
      throw new AssertionError();
    }
    Object localObject;
    k localk;
    do
    {
      do
      {
        localObject = this._queue;
        if (localObject != null) {
          break;
        }
      } while (!q.compareAndSet(this, null, u0.a()));
      return;
      if ((localObject instanceof k))
      {
        ((k)localObject).g();
        return;
      }
      if (localObject == u0.a()) {
        return;
      }
      localk = new k(8, true);
      localk.d((Runnable)localObject);
    } while (!q.compareAndSet(this, localObject, localk));
  }
  
  private final Runnable I()
  {
    Object localObject1;
    do
    {
      for (;;)
      {
        localObject1 = this._queue;
        if (localObject1 == null) {
          return null;
        }
        if (!(localObject1 instanceof k)) {
          break;
        }
        k localk = (k)localObject1;
        Object localObject2 = localk.m();
        if (localObject2 != k.c) {
          return (Runnable)localObject2;
        }
        q.compareAndSet(this, localObject1, localk.l());
      }
      if (localObject1 == u0.a()) {
        return null;
      }
    } while (!q.compareAndSet(this, localObject1, null));
    return (Runnable)localObject1;
  }
  
  private final boolean K(Runnable paramRunnable)
  {
    Object localObject;
    k localk;
    label91:
    do
    {
      for (;;)
      {
        localObject = this._queue;
        if (this.isCompleted) {
          return false;
        }
        if (localObject == null)
        {
          if (q.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof k)) {
            break label91;
          }
          localk = (k)localObject;
          int i = localk.d(paramRunnable);
          if (i == 0) {
            break;
          }
          if (i != 1)
          {
            if (i == 2) {
              return false;
            }
          }
          else {
            q.compareAndSet(this, localObject, localk.l());
          }
        }
      }
      return true;
      if (localObject == u0.a()) {
        return false;
      }
      localk = new k(8, true);
      localk.d((Runnable)localObject);
      localk.d(paramRunnable);
    } while (!q.compareAndSet(this, localObject, localk));
    return true;
  }
  
  private final void N()
  {
    Object localObject = z1.a();
    long l;
    if (localObject != null) {
      l = ((y1)localObject).nanoTime();
    } else {
      l = System.nanoTime();
    }
    for (;;)
    {
      localObject = (b)this._delayed;
      if (localObject == null) {
        break;
      }
      localObject = (a)((y)localObject).i();
      if (localObject == null) {
        break;
      }
      E(l, (a)localObject);
    }
  }
  
  private final int Q(long paramLong, a parama)
  {
    if (this.isCompleted) {
      return 1;
    }
    Object localObject = (b)this._delayed;
    if (localObject == null)
    {
      x.compareAndSet(this, null, new b(paramLong));
      localObject = this._delayed;
      if (localObject == null) {
        j.n();
      }
      localObject = (b)localObject;
    }
    return parama.f(paramLong, (b)localObject, this);
  }
  
  private final boolean R(a parama)
  {
    Object localObject = (b)this._delayed;
    if (localObject != null) {
      localObject = (a)((y)localObject).e();
    } else {
      localObject = null;
    }
    boolean bool;
    if (localObject == parama) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void J(Runnable paramRunnable)
  {
    j.f(paramRunnable, "task");
    if (K(paramRunnable)) {
      F();
    } else {
      i0.z.J(paramRunnable);
    }
  }
  
  protected boolean L()
  {
    boolean bool1 = B();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject = (b)this._delayed;
    if ((localObject != null) && (!((y)localObject).d())) {
      return false;
    }
    localObject = this._queue;
    if (localObject == null) {}
    do
    {
      bool2 = true;
      break;
      if ((localObject instanceof k))
      {
        bool2 = ((k)localObject).j();
        break;
      }
    } while (localObject == u0.a());
    return bool2;
  }
  
  public long M()
  {
    if (C()) {
      return x();
    }
    b localb = (b)this._delayed;
    if ((localb != null) && (!localb.d()))
    {
      Object localObject1 = z1.a();
      long l;
      if (localObject1 != null) {
        l = ((y1)localObject1).nanoTime();
      } else {
        l = System.nanoTime();
      }
      for (;;)
      {
        try
        {
          z localz = localb.b();
          a locala = null;
          localObject1 = null;
          if (localz != null)
          {
            locala = (a)localz;
            boolean bool;
            if (locala.g(l)) {
              bool = K(locala);
            } else {
              bool = false;
            }
            if (bool) {
              localObject1 = localb.h(0);
            }
          }
          else
          {
            localObject1 = locala;
          }
          if ((a)localObject1 == null) {
            localRunnable = I();
          }
        }
        finally {}
      }
    }
    Runnable localRunnable;
    if (localRunnable != null) {
      localRunnable.run();
    }
    return x();
  }
  
  protected final void O()
  {
    this._queue = null;
    this._delayed = null;
  }
  
  public final void P(long paramLong, a parama)
  {
    j.f(parama, "delayedTask");
    int i = Q(paramLong, parama);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          throw new IllegalStateException("unexpected result".toString());
        }
      }
      else {
        E(paramLong, parama);
      }
    }
    else if (R(parama)) {
      F();
    }
  }
  
  public final void dispatch(f paramf, Runnable paramRunnable)
  {
    j.f(paramf, "context");
    j.f(paramRunnable, "block");
    J(paramRunnable);
  }
  
  protected void shutdown()
  {
    x1.b.b();
    this.isCompleted = true;
    H();
    while (M() <= 0L) {}
    N();
  }
  
  protected long x()
  {
    if (super.x() == 0L) {
      return 0L;
    }
    Object localObject = this._queue;
    if (localObject != null)
    {
      if (!(localObject instanceof k)) {
        break label108;
      }
      if (!((k)localObject).j()) {
        return 0L;
      }
    }
    localObject = (b)this._delayed;
    if (localObject != null)
    {
      localObject = (a)((y)localObject).e();
      if (localObject != null)
      {
        long l1 = ((a)localObject).f;
        localObject = z1.a();
        long l2;
        if (localObject != null) {
          l2 = ((y1)localObject).nanoTime();
        } else {
          l2 = System.nanoTime();
        }
        return e.c(l1 - l2, 0L);
      }
    }
    return Long.MAX_VALUE;
    label108:
    if (localObject == u0.a()) {
      return Long.MAX_VALUE;
    }
    return 0L;
  }
  
  public static abstract class a
    implements Runnable, Comparable<a>, o0, z
  {
    private Object c;
    private int d;
    public long f;
    
    public void a(y<?> paramy)
    {
      int i;
      if (this.c != u0.b()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.c = paramy;
        return;
      }
      throw new IllegalArgumentException("Failed requirement.".toString());
    }
    
    public y<?> b()
    {
      Object localObject1 = this.c;
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof y)) {
        localObject2 = null;
      }
      return (y)localObject2;
    }
    
    public int d()
    {
      return this.d;
    }
    
    public final void dispose()
    {
      try
      {
        Object localObject1 = this.c;
        Object localObject2 = u0.b();
        if (localObject1 == localObject2) {
          return;
        }
        localObject2 = localObject1;
        if (!(localObject1 instanceof r0.b)) {
          localObject2 = null;
        }
        localObject2 = (r0.b)localObject2;
        if (localObject2 != null) {
          ((y)localObject2).g(this);
        }
        this.c = u0.b();
        return;
      }
      finally {}
    }
    
    public int e(a parama)
    {
      j.f(parama, "other");
      boolean bool = this.f - parama.f < 0L;
      int i;
      if (bool) {
        bool = true;
      } else if (bool) {
        i = -1;
      } else {
        i = 0;
      }
      return i;
    }
    
    /* Error */
    public final int f(long paramLong, r0.b paramb, r0 paramr0)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_3
      //   3: ldc 79
      //   5: invokestatic 74	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
      //   8: aload 4
      //   10: ldc 81
      //   12: invokestatic 74	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
      //   15: aload_0
      //   16: getfield 25	kotlinx/coroutines/r0$a:c	Ljava/lang/Object;
      //   19: astore 5
      //   21: invokestatic 31	kotlinx/coroutines/u0:b	()Lkotlinx/coroutines/internal/t;
      //   24: astore 6
      //   26: aload 5
      //   28: aload 6
      //   30: if_acmpne +7 -> 37
      //   33: aload_0
      //   34: monitorexit
      //   35: iconst_2
      //   36: ireturn
      //   37: aload_3
      //   38: monitorenter
      //   39: aload_3
      //   40: invokevirtual 84	kotlinx/coroutines/internal/y:b	()Lkotlinx/coroutines/internal/z;
      //   43: checkcast 2	kotlinx/coroutines/r0$a
      //   46: astore 6
      //   48: aload 4
      //   50: invokestatic 88	kotlinx/coroutines/r0:G	(Lkotlinx/coroutines/r0;)Z
      //   53: istore 7
      //   55: iload 7
      //   57: ifeq +9 -> 66
      //   60: aload_3
      //   61: monitorexit
      //   62: aload_0
      //   63: monitorexit
      //   64: iconst_1
      //   65: ireturn
      //   66: aload 6
      //   68: ifnonnull +11 -> 79
      //   71: aload_3
      //   72: lload_1
      //   73: putfield 90	kotlinx/coroutines/r0$b:c	J
      //   76: goto +41 -> 117
      //   79: aload 6
      //   81: getfield 76	kotlinx/coroutines/r0$a:f	J
      //   84: lstore 8
      //   86: lload 8
      //   88: lload_1
      //   89: lsub
      //   90: lconst_0
      //   91: lcmp
      //   92: iflt +6 -> 98
      //   95: goto +6 -> 101
      //   98: lload 8
      //   100: lstore_1
      //   101: lload_1
      //   102: aload_3
      //   103: getfield 90	kotlinx/coroutines/r0$b:c	J
      //   106: lsub
      //   107: lconst_0
      //   108: lcmp
      //   109: ifle +8 -> 117
      //   112: aload_3
      //   113: lload_1
      //   114: putfield 90	kotlinx/coroutines/r0$b:c	J
      //   117: aload_0
      //   118: getfield 76	kotlinx/coroutines/r0$a:f	J
      //   121: lstore_1
      //   122: aload_3
      //   123: getfield 90	kotlinx/coroutines/r0$b:c	J
      //   126: lstore 8
      //   128: lload_1
      //   129: lload 8
      //   131: lsub
      //   132: lconst_0
      //   133: lcmp
      //   134: ifge +9 -> 143
      //   137: aload_0
      //   138: lload 8
      //   140: putfield 76	kotlinx/coroutines/r0$a:f	J
      //   143: aload_3
      //   144: aload_0
      //   145: invokevirtual 93	kotlinx/coroutines/internal/y:a	(Lkotlinx/coroutines/internal/z;)V
      //   148: aload_3
      //   149: monitorexit
      //   150: aload_0
      //   151: monitorexit
      //   152: iconst_0
      //   153: ireturn
      //   154: astore 4
      //   156: aload_3
      //   157: monitorexit
      //   158: aload 4
      //   160: athrow
      //   161: astore_3
      //   162: aload_0
      //   163: monitorexit
      //   164: aload_3
      //   165: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	166	0	this	a
      //   0	166	1	paramLong	long
      //   0	166	3	paramb	r0.b
      //   0	166	4	paramr0	r0
      //   19	8	5	localObject1	Object
      //   24	56	6	localObject2	Object
      //   53	3	7	bool	boolean
      //   84	55	8	l	long
      // Exception table:
      //   from	to	target	type
      //   39	55	154	finally
      //   71	76	154	finally
      //   79	86	154	finally
      //   101	117	154	finally
      //   117	128	154	finally
      //   137	143	154	finally
      //   143	148	154	finally
      //   2	26	161	finally
      //   37	39	161	finally
      //   60	62	161	finally
      //   148	150	161	finally
      //   156	161	161	finally
    }
    
    public final boolean g(long paramLong)
    {
      boolean bool;
      if (paramLong - this.f >= 0L) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void h(int paramInt)
    {
      this.d = paramInt;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Delayed[nanos=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
  }
  
  public static final class b
    extends y<r0.a>
  {
    public long c;
    
    public b(long paramLong)
    {
      this.c = paramLong;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\r0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */