package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.g0;

public class i
{
  static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_next");
  static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_prev");
  private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_removedRef");
  volatile Object _next = this;
  volatile Object _prev = this;
  private volatile Object _removedRef = null;
  
  private final i H()
  {
    Object localObject1;
    Object localObject2;
    do
    {
      localObject1 = this._prev;
      if ((localObject1 instanceof p)) {
        return ((p)localObject1).a;
      }
      if (localObject1 == this)
      {
        localObject2 = x();
      }
      else
      {
        if (localObject1 == null) {
          break;
        }
        localObject2 = (i)localObject1;
      }
      localObject2 = ((i)localObject2).J();
    } while (!d.compareAndSet(this, localObject1, localObject2));
    return (i)localObject1;
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  private final p J()
  {
    p localp = (p)this._removedRef;
    if (localp == null)
    {
      localp = new p(this);
      f.lazySet(this, localp);
    }
    return localp;
  }
  
  private final i w(i parami, o paramo)
  {
    Object localObject1 = null;
    Object localObject3;
    label129:
    label139:
    do
    {
      for (;;)
      {
        Object localObject2 = parami._next;
        if (localObject2 == paramo) {
          return parami;
        }
        if ((localObject2 instanceof o))
        {
          ((o)localObject2).a(parami);
        }
        else
        {
          if ((localObject2 instanceof p))
          {
            if (localObject1 != null)
            {
              parami.H();
              c.compareAndSet(localObject1, parami, ((p)localObject2).a);
              parami = (i)localObject1;
              break;
            }
            parami = h.d(parami._prev);
            continue;
          }
          localObject3 = this._prev;
          if ((localObject3 instanceof p)) {
            return null;
          }
          if (localObject2 == this) {
            break label139;
          }
          if (localObject2 == null) {
            break label129;
          }
          localObject2 = (i)localObject2;
          localObject1 = parami;
          parami = (i)localObject2;
        }
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      if (localObject3 == parami) {
        return null;
      }
    } while ((!d.compareAndSet(this, localObject3, parami)) || ((parami._prev instanceof p)));
    return null;
  }
  
  private final i x()
  {
    Object localObject = this;
    for (;;)
    {
      if ((localObject instanceof g)) {
        return (i)localObject;
      }
      i locali = ((i)localObject).B();
      localObject = locali;
      if (g0.a())
      {
        int i;
        if (locali != this) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          break;
        }
        localObject = locali;
      }
    }
    throw new AssertionError();
  }
  
  private final void y(i parami)
  {
    Object localObject;
    do
    {
      localObject = parami._prev;
      if (((localObject instanceof p)) || (A() != parami)) {
        break;
      }
    } while (!d.compareAndSet(parami, localObject, this));
    if ((A() instanceof p)) {
      if (localObject != null) {
        parami.w((i)localObject, null);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      }
    }
  }
  
  private final void z(i parami)
  {
    E();
    parami.w(h.d(this._prev), null);
  }
  
  public final Object A()
  {
    for (;;)
    {
      Object localObject = this._next;
      if (!(localObject instanceof o)) {
        return localObject;
      }
      ((o)localObject).a(this);
    }
  }
  
  public final i B()
  {
    return h.d(A());
  }
  
  public final Object C()
  {
    for (;;)
    {
      Object localObject = this._prev;
      if ((localObject instanceof p)) {
        return localObject;
      }
      if (localObject == null) {
        break;
      }
      i locali = (i)localObject;
      if (locali.A() == this) {
        return localObject;
      }
      w(locali, null);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  public final i D()
  {
    return h.d(C());
  }
  
  public final void E()
  {
    Object localObject1 = H();
    Object localObject2 = this._next;
    if (localObject2 != null)
    {
      i locali = ((p)localObject2).a;
      localObject2 = null;
      label144:
      label154:
      do
      {
        for (;;)
        {
          Object localObject3 = locali.A();
          if ((localObject3 instanceof p))
          {
            locali.H();
            locali = ((p)localObject3).a;
          }
          else
          {
            localObject3 = ((i)localObject1).A();
            if ((localObject3 instanceof p))
            {
              if (localObject2 != null)
              {
                ((i)localObject1).H();
                c.compareAndSet(localObject2, localObject1, ((p)localObject3).a);
                localObject1 = localObject2;
                break;
              }
              localObject1 = h.d(((i)localObject1)._prev);
              continue;
            }
            if (localObject3 == this) {
              break label154;
            }
            if (localObject3 == null) {
              break label144;
            }
            localObject3 = (i)localObject3;
            if (localObject3 == locali) {
              return;
            }
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      } while (!c.compareAndSet(localObject1, this, locali));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
  }
  
  public final void F()
  {
    Object localObject1 = A();
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof p)) {
      localObject2 = null;
    }
    localObject2 = (p)localObject2;
    if (localObject2 != null)
    {
      z(((p)localObject2).a);
      return;
    }
    throw new IllegalStateException("Must be invoked on a removed node".toString());
  }
  
  public final boolean G()
  {
    return A() instanceof p;
  }
  
  public boolean I()
  {
    Object localObject;
    i locali;
    p localp;
    do
    {
      localObject = A();
      if ((localObject instanceof p)) {
        return false;
      }
      if (localObject == this) {
        return false;
      }
      if (localObject == null) {
        break;
      }
      locali = (i)localObject;
      localp = locali.J();
    } while (!c.compareAndSet(this, localObject, localp));
    z(locali);
    return true;
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  public final int K(i parami1, i parami2, b paramb)
  {
    j.f(parami1, "node");
    j.f(parami2, "next");
    j.f(paramb, "condAdd");
    d.lazySet(parami1, this);
    AtomicReferenceFieldUpdater localAtomicReferenceFieldUpdater = c;
    localAtomicReferenceFieldUpdater.lazySet(parami1, parami2);
    paramb.b = parami2;
    if (!localAtomicReferenceFieldUpdater.compareAndSet(this, parami2, paramb)) {
      return 0;
    }
    int i;
    if (paramb.a(this) == null) {
      i = 1;
    } else {
      i = 2;
    }
    return i;
  }
  
  public final void t(i parami)
  {
    j.f(parami, "node");
    Object localObject;
    do
    {
      localObject = C();
      if (localObject == null) {
        break;
      }
    } while (!((i)localObject).u(parami, this));
    return;
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    return localStringBuilder.toString();
  }
  
  public final boolean u(i parami1, i parami2)
  {
    j.f(parami1, "node");
    j.f(parami2, "next");
    d.lazySet(parami1, this);
    AtomicReferenceFieldUpdater localAtomicReferenceFieldUpdater = c;
    localAtomicReferenceFieldUpdater.lazySet(parami1, parami2);
    if (!localAtomicReferenceFieldUpdater.compareAndSet(this, parami2, parami1)) {
      return false;
    }
    parami1.y(parami2);
    return true;
  }
  
  public final boolean v(i parami)
  {
    j.f(parami, "node");
    d.lazySet(parami, this);
    c.lazySet(parami, this);
    do
    {
      if (A() != this) {
        return false;
      }
    } while (!c.compareAndSet(this, this, parami));
    parami.y(this);
    return true;
  }
  
  public static abstract class a
    extends b
  {
    public final void a(d<?> paramd, Object paramObject)
    {
      j.f(paramd, "op");
      int i;
      if (paramObject == null) {
        i = 1;
      } else {
        i = 0;
      }
      i locali1 = e();
      if (locali1 != null)
      {
        i locali2 = f();
        if (locali2 != null)
        {
          if (i != 0) {
            paramObject = j(locali1, locali2);
          } else {
            paramObject = locali2;
          }
          if ((i.c.compareAndSet(locali1, paramd, paramObject)) && (i != 0)) {
            d(locali1, locali2);
          }
          return;
        }
        if ((g0.a()) && ((i ^ 0x1) == 0)) {
          throw new AssertionError();
        }
        return;
      }
      if ((g0.a()) && ((i ^ 0x1) == 0)) {
        throw new AssertionError();
      }
    }
    
    public final Object b(d<?> paramd)
    {
      j.f(paramd, "op");
      Object localObject1;
      do
      {
        Object localObject2;
        Object localObject3;
        do
        {
          do
          {
            for (;;)
            {
              localObject1 = i(paramd);
              localObject2 = ((i)localObject1)._next;
              if (localObject2 == paramd) {
                return null;
              }
              if (paramd.d()) {
                return null;
              }
              if (!(localObject2 instanceof o)) {
                break;
              }
              ((o)localObject2).a(localObject1);
            }
            localObject3 = c((i)localObject1);
            if (localObject3 != null) {
              return localObject3;
            }
          } while (h((i)localObject1, localObject2));
          if (localObject2 == null) {
            break;
          }
          localObject3 = new a((i)localObject2, paramd, this);
        } while (!i.c.compareAndSet(localObject1, localObject2, localObject3));
        localObject1 = ((a)localObject3).a(localObject1);
      } while (localObject1 == h.a());
      return localObject1;
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
    
    protected abstract Object c(i parami);
    
    protected abstract void d(i parami1, i parami2);
    
    protected abstract i e();
    
    protected abstract i f();
    
    protected abstract Object g(i parami1, i parami2);
    
    protected abstract boolean h(i parami, Object paramObject);
    
    protected abstract i i(o paramo);
    
    protected abstract Object j(i parami1, i parami2);
    
    private static final class a
      extends o
    {
      public final i a;
      public final d<i> b;
      public final i.a c;
      
      public a(i parami, d<? super i> paramd, i.a parama)
      {
        this.a = parami;
        this.b = paramd;
        this.c = parama;
      }
      
      public Object a(Object paramObject)
      {
        if (paramObject != null)
        {
          i locali = (i)paramObject;
          paramObject = this.c.g(locali, this.a);
          if (paramObject != null)
          {
            if (paramObject == h.a())
            {
              p localp = i.s(this.a);
              if (i.c.compareAndSet(locali, this, localp)) {
                locali.E();
              }
            }
            else
            {
              this.b.f(paramObject);
              i.c.compareAndSet(locali, this, this.a);
            }
            return paramObject;
          }
          if (this.b.d()) {
            paramObject = this.a;
          } else {
            paramObject = this.b;
          }
          i.c.compareAndSet(locali, this, paramObject);
          return null;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      }
    }
  }
  
  public static abstract class b
    extends d<i>
  {
    public i b;
    public final i c;
    
    public b(i parami)
    {
      this.c = parami;
    }
    
    public void g(i parami, Object paramObject)
    {
      j.f(parami, "affected");
      int i;
      if (paramObject == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramObject = this.c;
      } else {
        paramObject = this.b;
      }
      if ((paramObject != null) && (i.c.compareAndSet(parami, this, paramObject)) && (i != 0))
      {
        paramObject = this.c;
        parami = this.b;
        if (parami == null) {
          j.n();
        }
        i.q((i)paramObject, parami);
      }
    }
  }
  
  public static class c<T>
    extends i.a
  {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_affectedNode");
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_originalNext");
    private volatile Object _affectedNode;
    private volatile Object _originalNext;
    public final i c;
    
    public c(i parami)
    {
      this.c = parami;
      this._affectedNode = null;
      this._originalNext = null;
    }
    
    protected Object c(i parami)
    {
      j.f(parami, "affected");
      if (parami == this.c) {
        parami = h.c();
      } else {
        parami = null;
      }
      return parami;
    }
    
    protected final void d(i parami1, i parami2)
    {
      j.f(parami1, "affected");
      j.f(parami2, "next");
      i.r(parami1, parami2);
    }
    
    protected final i e()
    {
      return (i)this._affectedNode;
    }
    
    protected final i f()
    {
      return (i)this._originalNext;
    }
    
    protected final Object g(i parami1, i parami2)
    {
      j.f(parami1, "affected");
      j.f(parami2, "next");
      if ((g0.a()) && (!(parami1 instanceof g ^ true))) {
        throw new AssertionError();
      }
      if (!l(parami1)) {
        return h.a();
      }
      a.compareAndSet(this, null, parami1);
      b.compareAndSet(this, null, parami2);
      return null;
    }
    
    protected final boolean h(i parami, Object paramObject)
    {
      j.f(parami, "affected");
      j.f(paramObject, "next");
      if (!(paramObject instanceof p)) {
        return false;
      }
      parami.E();
      return true;
    }
    
    protected final i i(o paramo)
    {
      j.f(paramo, "op");
      paramo = this.c.A();
      if (paramo != null) {
        return (i)paramo;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
    
    protected final Object j(i parami1, i parami2)
    {
      j.f(parami1, "affected");
      j.f(parami2, "next");
      return i.s(parami2);
    }
    
    public final T k()
    {
      i locali = e();
      if (locali == null) {
        j.n();
      }
      return locali;
    }
    
    protected boolean l(T paramT)
    {
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */