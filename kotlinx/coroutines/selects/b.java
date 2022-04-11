package kotlinx.coroutines.selects;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.d1.a;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.r;

public final class b<R>
  extends g
  implements a<R>, d<R>, kotlin.coroutines.c<R>, kotlin.coroutines.jvm.internal.c
{
  static final AtomicReferenceFieldUpdater q = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_state");
  static final AtomicReferenceFieldUpdater x = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_result");
  volatile Object _result;
  volatile Object _state;
  private volatile o0 parentHandle;
  private final kotlin.coroutines.c<R> y;
  
  public b(kotlin.coroutines.c<? super R> paramc)
  {
    this.y = paramc;
    this._state = this;
    this._result = e.b();
  }
  
  private final void M()
  {
    Object localObject = this.parentHandle;
    if (localObject != null) {
      ((o0)localObject).dispose();
    }
    localObject = A();
    if (localObject != null)
    {
      for (localObject = (i)localObject; (j.a(localObject, this) ^ true); localObject = ((i)localObject).B()) {
        if ((localObject instanceof b)) {
          ((b)localObject).q.dispose();
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  private final Object O()
  {
    for (;;)
    {
      Object localObject = this._state;
      if (!(localObject instanceof o)) {
        return localObject;
      }
      ((o)localObject).a(this);
    }
  }
  
  private final void Q()
  {
    Object localObject = (d1)getContext().get(d1.h);
    if (localObject != null)
    {
      localObject = d1.a.d((d1)localObject, true, false, new c((d1)localObject), 2, null);
      this.parentHandle = ((o0)localObject);
      if (e()) {
        ((o0)localObject).dispose();
      }
    }
  }
  
  public final Object N()
  {
    if (!e()) {
      Q();
    }
    Object localObject1 = this._result;
    Object localObject2 = localObject1;
    if (localObject1 == e.b())
    {
      if (x.compareAndSet(this, e.b(), kotlin.coroutines.intrinsics.a.d())) {
        return kotlin.coroutines.intrinsics.a.d();
      }
      localObject2 = this._result;
    }
    if (localObject2 != e.a())
    {
      if (!(localObject2 instanceof r)) {
        return localObject2;
      }
      throw ((r)localObject2).b;
    }
    throw new IllegalStateException("Already resumed");
  }
  
  public final void P(Throwable paramThrowable)
  {
    j.f(paramThrowable, "e");
    Object localObject;
    if (g(null))
    {
      localObject = Result.Companion;
      resumeWith(Result.constructor-impl(k.a(paramThrowable)));
    }
    else if (!(paramThrowable instanceof CancellationException))
    {
      localObject = N();
      if ((!(localObject instanceof r)) || (kotlinx.coroutines.internal.s.m(((r)localObject).b) != kotlinx.coroutines.internal.s.m(paramThrowable))) {
        a0.a(getContext(), paramThrowable);
      }
    }
  }
  
  public boolean e()
  {
    boolean bool;
    if (O() != this) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean g(Object paramObject)
  {
    if ((g0.a()) && (!(paramObject instanceof o ^ true))) {
      throw new AssertionError();
    }
    Object localObject;
    do
    {
      localObject = O();
      if (localObject != this) {
        break;
      }
    } while (!q.compareAndSet(this, this, paramObject));
    M();
    return true;
    if (paramObject == null) {
      return false;
    }
    return localObject == paramObject;
  }
  
  public kotlin.coroutines.jvm.internal.c getCallerFrame()
  {
    kotlin.coroutines.c localc1 = this.y;
    kotlin.coroutines.c localc2 = localc1;
    if (!(localc1 instanceof kotlin.coroutines.jvm.internal.c)) {
      localc2 = null;
    }
    return (kotlin.coroutines.jvm.internal.c)localc2;
  }
  
  public f getContext()
  {
    return this.y.getContext();
  }
  
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public void i(Throwable paramThrowable)
  {
    j.f(paramThrowable, "exception");
    if ((g0.a()) && (!e())) {
      throw new AssertionError();
    }
    do
    {
      Object localObject1;
      Object localObject2;
      do
      {
        localObject1 = this._result;
        if (localObject1 != e.b()) {
          break;
        }
        localObject2 = e.b();
        localObject1 = new r(paramThrowable, false, 2, null);
      } while (!x.compareAndSet(this, localObject2, localObject1));
      break;
      if (localObject1 != kotlin.coroutines.intrinsics.a.d()) {
        break label108;
      }
    } while (!x.compareAndSet(this, kotlin.coroutines.intrinsics.a.d(), e.a()));
    l0.e(kotlin.coroutines.intrinsics.a.c(this.y), paramThrowable);
    return;
    label108:
    throw new IllegalStateException("Already resumed");
  }
  
  public void k(o0 paramo0)
  {
    j.f(paramo0, "handle");
    b localb = new b(paramo0);
    if (!e())
    {
      t(localb);
      if (!e()) {
        return;
      }
    }
    paramo0.dispose();
  }
  
  public kotlin.coroutines.c<R> l()
  {
    return this;
  }
  
  public Object n(kotlinx.coroutines.internal.b paramb)
  {
    j.f(paramb, "desc");
    return new a(paramb).a(null);
  }
  
  public <Q> void o(c<? extends Q> paramc, p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> paramp)
  {
    j.f(paramc, "$this$invoke");
    j.f(paramp, "block");
    paramc.a(this, paramp);
  }
  
  public void resumeWith(Object paramObject)
  {
    if ((g0.a()) && (!e())) {
      throw new AssertionError();
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        localObject1 = this._result;
        if (localObject1 != e.b()) {
          break;
        }
        localObject1 = e.b();
        localObject2 = kotlinx.coroutines.s.a(paramObject);
      } while (!x.compareAndSet(this, localObject1, localObject2));
      break;
      if (localObject1 != kotlin.coroutines.intrinsics.a.d()) {
        break label142;
      }
    } while (!x.compareAndSet(this, kotlin.coroutines.intrinsics.a.d(), e.a()));
    if (Result.isFailure-impl(paramObject))
    {
      localObject1 = this.y;
      paramObject = Result.exceptionOrNull-impl(paramObject);
      if (paramObject == null) {
        j.n();
      }
      localObject2 = Result.Companion;
      ((kotlin.coroutines.c)localObject1).resumeWith(Result.constructor-impl(k.a(kotlinx.coroutines.internal.s.k((Throwable)paramObject, (kotlin.coroutines.c)localObject1))));
    }
    else
    {
      this.y.resumeWith(paramObject);
    }
    return;
    label142:
    throw new IllegalStateException("Already resumed");
  }
  
  private final class a
    extends kotlinx.coroutines.internal.d<Object>
  {
    public final kotlinx.coroutines.internal.b b;
    
    public a()
    {
      this.b = ((kotlinx.coroutines.internal.b)localObject);
    }
    
    private final void g(Object paramObject)
    {
      int i;
      if (paramObject == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramObject = null;
      } else {
        paramObject = b.this;
      }
      b localb = b.this;
      if ((b.q.compareAndSet(localb, this, paramObject)) && (i != 0)) {
        b.L(b.this);
      }
    }
    
    public void b(Object paramObject1, Object paramObject2)
    {
      g(paramObject2);
      this.b.a(this, paramObject2);
    }
    
    public Object e(Object paramObject)
    {
      if (paramObject == null)
      {
        paramObject = h();
        if (paramObject != null) {
          return paramObject;
        }
      }
      return this.b.b(this);
    }
    
    public final Object h()
    {
      b localb1 = b.this;
      b localb2;
      do
      {
        Object localObject;
        for (;;)
        {
          localObject = localb1._state;
          if (localObject == this) {
            return null;
          }
          if (!(localObject instanceof o)) {
            break;
          }
          ((o)localObject).a(b.this);
        }
        localb2 = b.this;
        if (localObject != localb2) {
          break;
        }
      } while (!b.q.compareAndSet(localb2, localb2, this));
      return null;
      return e.c();
    }
  }
  
  private static final class b
    extends i
  {
    public final o0 q;
    
    public b(o0 paramo0)
    {
      this.q = paramo0;
    }
  }
  
  private final class c
    extends e1<d1>
  {
    public c()
    {
      super();
    }
    
    public void L(Throwable paramThrowable)
    {
      if (b.this.g(null)) {
        b.this.i(this.q.i());
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SelectOnCancelling[");
      localStringBuilder.append(b.this);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\selects\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */