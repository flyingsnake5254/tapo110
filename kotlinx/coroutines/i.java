package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.j;
import kotlin.p;

public class i<T>
  extends m0<T>
  implements h<T>, kotlin.coroutines.jvm.internal.c
{
  private static final AtomicIntegerFieldUpdater q = AtomicIntegerFieldUpdater.newUpdater(i.class, "_decision");
  private static final AtomicReferenceFieldUpdater x = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_state");
  private volatile int _decision;
  private volatile Object _state;
  private volatile o0 parentHandle;
  private final kotlin.coroutines.f y;
  private final kotlin.coroutines.c<T> z;
  
  public i(kotlin.coroutines.c<? super T> paramc, int paramInt)
  {
    super(paramInt);
    this.z = paramc;
    this.y = paramc.getContext();
    this._decision = 0;
    this._state = b.c;
  }
  
  private final void k(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Already resumed, but proposed with update ");
    localStringBuilder.append(paramObject);
    throw new IllegalStateException(localStringBuilder.toString().toString());
  }
  
  private final void m(int paramInt)
  {
    if (y()) {
      return;
    }
    l0.b(this, paramInt);
  }
  
  private final void n()
  {
    o0 localo0 = this.parentHandle;
    if (localo0 != null)
    {
      localo0.dispose();
      this.parentHandle = o1.c;
    }
  }
  
  private final void s()
  {
    if (t()) {
      return;
    }
    Object localObject = (d1)this.z.getContext().get(d1.h);
    if (localObject != null)
    {
      ((d1)localObject).start();
      localObject = d1.a.d((d1)localObject, true, false, new l((d1)localObject, this), 2, null);
      this.parentHandle = ((o0)localObject);
      if (t())
      {
        ((o0)localObject).dispose();
        this.parentHandle = o1.c;
      }
    }
  }
  
  private final f u(kotlin.jvm.b.l<? super Throwable, p> paraml)
  {
    if ((paraml instanceof f)) {
      paraml = (f)paraml;
    } else {
      paraml = new a1(paraml);
    }
    return paraml;
  }
  
  private final void v(kotlin.jvm.b.l<? super Throwable, p> paraml, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("It's prohibited to register multiple handlers, tried to register ");
    localStringBuilder.append(paraml);
    localStringBuilder.append(", already has ");
    localStringBuilder.append(paramObject);
    throw new IllegalStateException(localStringBuilder.toString().toString());
  }
  
  private final k x(Object paramObject, int paramInt)
  {
    for (;;)
    {
      Object localObject = this._state;
      if ((localObject instanceof p1))
      {
        if (x.compareAndSet(this, localObject, paramObject))
        {
          n();
          m(paramInt);
          return null;
        }
      }
      else
      {
        if ((localObject instanceof k))
        {
          localObject = (k)localObject;
          if (((k)localObject).c()) {
            return (k)localObject;
          }
        }
        k(paramObject);
      }
    }
  }
  
  private final boolean y()
  {
    do
    {
      int i = this._decision;
      if (i != 0)
      {
        if (i == 1) {
          return false;
        }
        throw new IllegalStateException("Already resumed".toString());
      }
    } while (!q.compareAndSet(this, 0, 2));
    return true;
  }
  
  private final boolean z()
  {
    do
    {
      int i = this._decision;
      if (i != 0)
      {
        if (i == 2) {
          return false;
        }
        throw new IllegalStateException("Already suspended".toString());
      }
    } while (!q.compareAndSet(this, 0, 1));
    return true;
  }
  
  public Object b(T paramT, Object paramObject)
  {
    Object localObject1;
    do
    {
      localObject1 = this._state;
      if (!(localObject1 instanceof p1)) {
        break;
      }
      if (paramObject == null) {
        localObject2 = paramT;
      } else {
        localObject2 = new t(paramObject, paramT, (p1)localObject1);
      }
    } while (!x.compareAndSet(this, localObject1, localObject2));
    n();
    return localObject1;
    boolean bool = localObject1 instanceof t;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (bool)
    {
      localObject1 = (t)localObject1;
      localObject2 = localObject3;
      if (((t)localObject1).a == paramObject)
      {
        if (g0.a())
        {
          int i;
          if (((t)localObject1).b == paramT) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0) {
            throw new AssertionError();
          }
        }
        localObject2 = ((t)localObject1).c;
      }
    }
    return localObject2;
  }
  
  /* Error */
  public void c(Object paramObject, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc -31
    //   3: invokestatic 56	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: instanceof 227
    //   10: ifeq +63 -> 73
    //   13: aload_1
    //   14: checkcast 227	kotlinx/coroutines/u
    //   17: getfield 230	kotlinx/coroutines/u:b	Lkotlin/jvm/b/l;
    //   20: aload_2
    //   21: invokeinterface 236 2 0
    //   26: pop
    //   27: goto +46 -> 73
    //   30: astore_2
    //   31: aload_0
    //   32: invokevirtual 237	kotlinx/coroutines/i:getContext	()Lkotlin/coroutines/f;
    //   35: astore_3
    //   36: new 85	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   43: astore_1
    //   44: aload_1
    //   45: ldc -17
    //   47: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: new 241	kotlinx/coroutines/CompletionHandlerException
    //   61: dup
    //   62: aload_1
    //   63: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: aload_2
    //   67: invokespecial 244	kotlinx/coroutines/CompletionHandlerException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: invokestatic 249	kotlinx/coroutines/a0:a	(Lkotlin/coroutines/f;Ljava/lang/Throwable;)V
    //   73: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	i
    //   0	74	1	paramObject	Object
    //   0	74	2	paramThrowable	Throwable
    //   35	23	3	localf	kotlin.coroutines.f
    // Exception table:
    //   from	to	target	type
    //   13	27	30	finally
  }
  
  public final kotlin.coroutines.c<T> d()
  {
    return this.z;
  }
  
  public void f(kotlin.jvm.b.l<? super Throwable, p> paraml)
  {
    j.f(paraml, "handler");
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      localObject3 = this._state;
      if ((localObject3 instanceof b))
      {
        if (localObject2 != null) {
          localObject4 = localObject2;
        } else {
          localObject4 = u(paraml);
        }
        localObject2 = localObject4;
        if (!x.compareAndSet(this, localObject3, localObject4)) {}
      }
      else
      {
        if (!(localObject3 instanceof f)) {
          break;
        }
        v(paraml, localObject3);
      }
    }
    if ((localObject3 instanceof k))
    {
      if (!((k)localObject3).b()) {
        v(paraml, localObject3);
      }
      localObject2 = localObject3;
      try
      {
        if (!(localObject3 instanceof r)) {
          localObject2 = null;
        }
        localObject4 = (r)localObject2;
        localObject2 = localObject1;
        if (localObject4 != null) {
          localObject2 = ((r)localObject4).b;
        }
        paraml.invoke(localObject2);
      }
      finally
      {
        localObject4 = getContext();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Exception in cancellation handler for ");
        ((StringBuilder)localObject2).append(this);
        a0.a((kotlin.coroutines.f)localObject4, new CompletionHandlerException(((StringBuilder)localObject2).toString(), paraml));
      }
    }
  }
  
  public <T> T g(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof t))
    {
      localObject = ((t)paramObject).b;
    }
    else
    {
      localObject = paramObject;
      if ((paramObject instanceof u)) {
        localObject = ((u)paramObject).a;
      }
    }
    return (T)localObject;
  }
  
  public kotlin.coroutines.jvm.internal.c getCallerFrame()
  {
    kotlin.coroutines.c localc1 = this.z;
    kotlin.coroutines.c localc2 = localc1;
    if (!(localc1 instanceof kotlin.coroutines.jvm.internal.c)) {
      localc2 = null;
    }
    return (kotlin.coroutines.jvm.internal.c)localc2;
  }
  
  public kotlin.coroutines.f getContext()
  {
    return this.y;
  }
  
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public Object h(Throwable paramThrowable)
  {
    j.f(paramThrowable, "exception");
    Object localObject;
    r localr;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof p1)) {
        break;
      }
      localr = new r(paramThrowable, false, 2, null);
    } while (!x.compareAndSet(this, localObject, localr));
    n();
    return localObject;
    return null;
  }
  
  public Object j()
  {
    return r();
  }
  
  /* Error */
  public boolean l(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	kotlinx/coroutines/i:_state	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: instanceof 179
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_2
    //   15: instanceof 163
    //   18: istore_3
    //   19: new 189	kotlinx/coroutines/k
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: iload_3
    //   26: invokespecial 288	kotlinx/coroutines/k:<init>	(Lkotlin/coroutines/c;Ljava/lang/Throwable;Z)V
    //   29: astore 4
    //   31: getstatic 45	kotlinx/coroutines/i:x	Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   34: aload_0
    //   35: aload_2
    //   36: aload 4
    //   38: invokevirtual 183	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   41: ifne +6 -> 47
    //   44: goto -44 -> 0
    //   47: iload_3
    //   48: ifeq +61 -> 109
    //   51: aload_2
    //   52: checkcast 163	kotlinx/coroutines/f
    //   55: aload_1
    //   56: invokevirtual 293	kotlinx/coroutines/g:a	(Ljava/lang/Throwable;)V
    //   59: goto +50 -> 109
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual 237	kotlinx/coroutines/i:getContext	()Lkotlin/coroutines/f;
    //   67: astore_2
    //   68: new 85	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   75: astore 4
    //   77: aload 4
    //   79: ldc -17
    //   81: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 4
    //   87: aload_0
    //   88: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: new 241	kotlinx/coroutines/CompletionHandlerException
    //   96: dup
    //   97: aload 4
    //   99: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aload_1
    //   103: invokespecial 244	kotlinx/coroutines/CompletionHandlerException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: invokestatic 249	kotlinx/coroutines/a0:a	(Lkotlin/coroutines/f;Ljava/lang/Throwable;)V
    //   109: aload_0
    //   110: invokespecial 185	kotlinx/coroutines/i:n	()V
    //   113: aload_0
    //   114: iconst_0
    //   115: invokespecial 187	kotlinx/coroutines/i:m	(I)V
    //   118: iconst_1
    //   119: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	i
    //   0	120	1	paramThrowable	Throwable
    //   4	89	2	localObject1	Object
    //   18	30	3	bool	boolean
    //   29	69	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   51	59	62	finally
  }
  
  public Throwable o(d1 paramd1)
  {
    j.f(paramd1, "parent");
    return paramd1.i();
  }
  
  public void p(Object paramObject)
  {
    j.f(paramObject, "token");
    m(this.f);
  }
  
  public final Object q()
  {
    s();
    if (z()) {
      return a.d();
    }
    Object localObject1 = r();
    if (!(localObject1 instanceof r))
    {
      if (this.f == 1)
      {
        Object localObject2 = (d1)getContext().get(d1.h);
        if ((localObject2 != null) && (!((d1)localObject2).isActive()))
        {
          localObject2 = ((d1)localObject2).i();
          c(localObject1, (Throwable)localObject2);
          throw kotlinx.coroutines.internal.s.k((Throwable)localObject2, this);
        }
      }
      return g(localObject1);
    }
    throw kotlinx.coroutines.internal.s.k(((r)localObject1).b, this);
  }
  
  public final Object r()
  {
    return this._state;
  }
  
  public void resumeWith(Object paramObject)
  {
    x(s.a(paramObject), this.f);
  }
  
  public boolean t()
  {
    return r() instanceof p1 ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(w());
    localStringBuilder.append('(');
    localStringBuilder.append(h0.c(this.z));
    localStringBuilder.append("){");
    localStringBuilder.append(r());
    localStringBuilder.append("}@");
    localStringBuilder.append(h0.b(this));
    return localStringBuilder.toString();
  }
  
  protected String w()
  {
    return "CancellableContinuation";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */