package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.i.b;

public abstract class c<E>
  implements v<E>
{
  private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");
  private final g d = new g();
  private volatile Object onCloseHandler = null;
  
  private final int h()
  {
    g localg = this.d;
    Object localObject = localg.A();
    if (localObject != null)
    {
      localObject = (i)localObject;
      int j;
      for (int i = 0; (j.a(localObject, localg) ^ true); i = j)
      {
        j = i;
        if ((localObject instanceof i)) {
          j = i + 1;
        }
        localObject = ((i)localObject).B();
      }
      return i;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  private final Object i(u paramu)
  {
    g localg;
    Object localObject1;
    if (s())
    {
      localg = this.d;
      do
      {
        localObject1 = localg.C();
        if (localObject1 == null) {
          break;
        }
        localObject1 = (i)localObject1;
        if ((localObject1 instanceof s)) {
          return localObject1;
        }
      } while (!((i)localObject1).u(paramu, localg));
      break label142;
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
    else
    {
      localg = this.d;
      localObject1 = new b(paramu, paramu, this);
      int i;
      do
      {
        Object localObject2 = localg.C();
        if (localObject2 == null) {
          break label144;
        }
        localObject2 = (i)localObject2;
        if ((localObject2 instanceof s)) {
          return localObject2;
        }
        i = ((i)localObject2).K(paramu, localg, (i.b)localObject1);
        j = 1;
        if (i == 1) {
          break;
        }
      } while (i != 2);
      int j = 0;
      if (j == 0) {
        return b.d;
      }
    }
    label142:
    return null;
    label144:
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  private final boolean l()
  {
    boolean bool;
    if ((!(this.d.B() instanceof s)) && (t())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final String p()
  {
    i locali1 = this.d.B();
    if (locali1 == this.d) {
      return "EmptyQueue";
    }
    Object localObject1;
    if ((locali1 instanceof k))
    {
      localObject1 = locali1.toString();
    }
    else if ((locali1 instanceof q))
    {
      localObject1 = "ReceiveQueued";
    }
    else if ((locali1 instanceof u))
    {
      localObject1 = "SendQueued";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("UNEXPECTED:");
      ((StringBuilder)localObject1).append(locali1);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    i locali2 = this.d.D();
    Object localObject2 = localObject1;
    if (locali2 != locali1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",queueSize=");
      ((StringBuilder)localObject2).append(h());
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = localObject1;
      if ((locali2 instanceof k))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",closedForSend=");
        ((StringBuilder)localObject2).append(locali2);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    return (String)localObject2;
  }
  
  private final void q(k<?> paramk)
  {
    for (;;)
    {
      i locali = paramk.D();
      if (((locali instanceof g)) || (!(locali instanceof q))) {
        break;
      }
      if (!locali.I()) {
        locali.F();
      } else {
        ((q)locali).L(paramk);
      }
    }
    w(paramk);
  }
  
  private final void r(Throwable paramThrowable)
  {
    Object localObject1 = this.onCloseHandler;
    if (localObject1 != null)
    {
      Object localObject2 = b.i;
      if ((localObject1 != localObject2) && (c.compareAndSet(this, localObject1, localObject2))) {
        ((l)kotlin.jvm.internal.q.b(localObject1, 1)).invoke(paramThrowable);
      }
    }
  }
  
  protected s<E> A()
  {
    g localg = this.d;
    for (;;)
    {
      Object localObject = localg.A();
      if (localObject == null) {
        break;
      }
      localObject = (i)localObject;
      if (localObject == localg) {}
      while (!(localObject instanceof s))
      {
        localObject = null;
        break;
      }
      if ((((s)localObject instanceof k)) || (((i)localObject).I())) {
        return (s)localObject;
      }
      ((i)localObject).E();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  protected final u B()
  {
    g localg = this.d;
    for (;;)
    {
      Object localObject = localg.A();
      if (localObject == null) {
        break;
      }
      localObject = (i)localObject;
      if (localObject == localg) {}
      while (!(localObject instanceof u))
      {
        localObject = null;
        break;
      }
      if ((((u)localObject instanceof k)) || (((i)localObject).I())) {
        return (u)localObject;
      }
      ((i)localObject).E();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  protected String j()
  {
    return "";
  }
  
  protected final k<?> k()
  {
    Object localObject1 = this.d.D();
    boolean bool = localObject1 instanceof k;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    k localk = (k)localObject1;
    localObject1 = localObject2;
    if (localk != null)
    {
      q(localk);
      localObject1 = localk;
    }
    return (k<?>)localObject1;
  }
  
  public boolean m(Throwable paramThrowable)
  {
    k localk = new k(paramThrowable);
    g localg = this.d;
    Object localObject;
    do
    {
      localObject = localg.C();
      if (localObject == null) {
        break label110;
      }
      localObject = (i)localObject;
      if (!(localObject instanceof k ^ true))
      {
        i = 0;
        break;
      }
    } while (!((i)localObject).u(localk, localg));
    int i = 1;
    if (i == 0)
    {
      paramThrowable = this.d.D();
      if (paramThrowable != null)
      {
        q((k)paramThrowable);
        return false;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
    }
    q(localk);
    r(paramThrowable);
    return true;
    label110:
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  public final Object n(E paramE, kotlin.coroutines.c<? super p> paramc)
  {
    if (u(paramE)) {
      return p.a;
    }
    return z(paramE, paramc);
  }
  
  protected final g o()
  {
    return this.d;
  }
  
  protected abstract boolean s();
  
  protected abstract boolean t();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h0.a(this));
    localStringBuilder.append('@');
    localStringBuilder.append(h0.b(this));
    localStringBuilder.append('{');
    localStringBuilder.append(p());
    localStringBuilder.append('}');
    localStringBuilder.append(j());
    return localStringBuilder.toString();
  }
  
  public final boolean u(E paramE)
  {
    paramE = v(paramE);
    if (paramE == b.a) {
      return true;
    }
    if (paramE == b.b)
    {
      paramE = k();
      if (paramE != null)
      {
        paramE = paramE.S();
        if (paramE != null)
        {
          paramE = kotlinx.coroutines.internal.s.j(paramE);
          if (paramE != null) {
            throw paramE;
          }
        }
      }
      return false;
    }
    if ((paramE instanceof k)) {
      throw kotlinx.coroutines.internal.s.j(((k)paramE).S());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("offerInternal returned ");
    localStringBuilder.append(paramE);
    throw new IllegalStateException(localStringBuilder.toString().toString());
  }
  
  protected Object v(E paramE)
  {
    s locals;
    Object localObject;
    do
    {
      locals = A();
      if (locals == null) {
        break;
      }
      localObject = locals.m(paramE, null);
    } while (localObject == null);
    locals.j(localObject);
    return locals.a();
    return b.b;
  }
  
  protected void w(i parami)
  {
    j.f(parami, "closed");
  }
  
  protected final s<?> x(E paramE)
  {
    g localg = this.d;
    paramE = new a(paramE);
    Object localObject;
    do
    {
      localObject = localg.C();
      if (localObject == null) {
        break;
      }
      localObject = (i)localObject;
      if ((localObject instanceof s)) {
        return (s)localObject;
      }
    } while (!((i)localObject).u(paramE, localg));
    return null;
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  public final Object y(E paramE, kotlin.coroutines.c<? super p> paramc)
  {
    if (u(paramE)) {
      return c2.b(paramc);
    }
    return z(paramE, paramc);
  }
  
  public static final class a<E>
    extends u
  {
    public final E q;
    
    public a(E paramE)
    {
      this.q = paramE;
    }
    
    public void L(Object paramObject)
    {
      j.f(paramObject, "token");
      if (g0.a())
      {
        int i;
        if (paramObject == b.h) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          throw new AssertionError();
        }
      }
    }
    
    public Object M()
    {
      return this.q;
    }
    
    public void N(k<?> paramk)
    {
      j.f(paramk, "closed");
    }
    
    public Object O(Object paramObject)
    {
      return b.h;
    }
  }
  
  public static final class b
    extends i.b
  {
    public b(i parami1, i parami2, c paramc)
    {
      super();
    }
    
    public Object h(i parami)
    {
      j.f(parami, "affected");
      if (jdField_this.t()) {
        parami = null;
      } else {
        parami = h.b();
      }
      return parami;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */