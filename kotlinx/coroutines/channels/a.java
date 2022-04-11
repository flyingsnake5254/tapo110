package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.TypeCastException;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.h.a;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.i.b;
import kotlinx.coroutines.internal.i.c;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.selects.d;

public abstract class a<E>
  extends c<E>
  implements f<E>
{
  private final boolean I(q<? super E> paramq)
  {
    boolean bool1 = K();
    boolean bool2 = false;
    Object localObject1;
    Object localObject2;
    if (bool1)
    {
      localObject1 = o();
      do
      {
        localObject2 = ((i)localObject1).C();
        if (localObject2 == null) {
          break;
        }
        localObject2 = (i)localObject2;
        if (!(localObject2 instanceof u ^ true))
        {
          bool1 = bool2;
          break label158;
        }
      } while (!((i)localObject2).u(paramq, (i)localObject1));
      break label156;
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
    else
    {
      localObject2 = o();
      localObject1 = new g(paramq, paramq, this);
      for (;;)
      {
        Object localObject3 = ((i)localObject2).C();
        if (localObject3 == null) {
          break label168;
        }
        localObject3 = (i)localObject3;
        if (!(localObject3 instanceof u ^ true))
        {
          bool1 = bool2;
          break label158;
        }
        int i = ((i)localObject3).K(paramq, (i)localObject2, (i.b)localObject1);
        if (i == 1) {
          break;
        }
        bool1 = bool2;
        if (i == 2) {
          break label158;
        }
      }
    }
    label156:
    bool1 = true;
    label158:
    if (bool1) {
      O();
    }
    return bool1;
    label168:
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  private final <R> boolean J(d<? super R> paramd, p<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> paramp, int paramInt)
  {
    paramp = new d(this, paramd, paramp, paramInt);
    boolean bool = I(paramp);
    if (bool) {
      paramd.k(paramp);
    }
    return bool;
  }
  
  private final <R> void R(d<? super R> paramd, p<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> paramp)
  {
    label42:
    Object localObject;
    do
    {
      do
      {
        if (paramd.e()) {
          return;
        }
        if (!M()) {
          break label42;
        }
        if (paramp == null) {
          break;
        }
      } while (!J(paramd, paramp, 1));
      return;
      throw new TypeCastException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
      localObject = Q(paramd);
      if (localObject == kotlinx.coroutines.selects.e.c()) {
        return;
      }
    } while (localObject == b.c);
    if ((localObject instanceof k))
    {
      localObject = ((k)localObject).q;
      if (localObject == null)
      {
        if (paramd.g(null)) {
          kotlinx.coroutines.d2.b.c(paramp, null, paramd.l());
        }
        return;
      }
      throw kotlinx.coroutines.internal.s.j((Throwable)localObject);
    }
    kotlinx.coroutines.d2.b.c(paramp, localObject, paramd.l());
  }
  
  private final void S(kotlinx.coroutines.h<?> paramh, q<?> paramq)
  {
    paramh.f(new e(paramq));
  }
  
  protected s<E> A()
  {
    s locals = super.A();
    if ((locals != null) && (!(locals instanceof k))) {
      N();
    }
    return locals;
  }
  
  public boolean F(Throwable paramThrowable)
  {
    boolean bool = m(paramThrowable);
    G();
    return bool;
  }
  
  protected void G()
  {
    k localk = k();
    if (localk != null)
    {
      for (;;)
      {
        u localu = B();
        if (localu == null) {
          break;
        }
        if ((localu instanceof k))
        {
          if (g0.a())
          {
            int i;
            if (localu == localk) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0) {
              throw new AssertionError();
            }
          }
          return;
        }
        localu.N(localk);
      }
      throw new IllegalStateException("Cannot happen".toString());
    }
    throw new IllegalStateException("Cannot happen".toString());
  }
  
  protected final f<E> H()
  {
    return new f(o());
  }
  
  protected abstract boolean K();
  
  protected abstract boolean L();
  
  public final boolean M()
  {
    boolean bool;
    if ((!(o().B() instanceof u)) && (L())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void N() {}
  
  protected void O() {}
  
  protected Object P()
  {
    u localu;
    Object localObject;
    do
    {
      localu = B();
      if (localu == null) {
        break;
      }
      localObject = localu.O(null);
    } while (localObject == null);
    localu.L(localObject);
    return localu.M();
    return b.c;
  }
  
  protected Object Q(d<?> paramd)
  {
    j.f(paramd, "select");
    f localf = H();
    paramd = paramd.n(localf);
    if (paramd != null) {
      return paramd;
    }
    u localu = (u)localf.k();
    paramd = localf.d;
    if (paramd == null) {
      j.n();
    }
    localu.L(paramd);
    return localf.e;
  }
  
  public final void a(CancellationException paramCancellationException)
  {
    if (paramCancellationException == null)
    {
      paramCancellationException = new StringBuilder();
      paramCancellationException.append(h0.a(this));
      paramCancellationException.append(" was cancelled");
      paramCancellationException = new CancellationException(paramCancellationException.toString());
    }
    F(paramCancellationException);
  }
  
  public final kotlinx.coroutines.selects.c<E> e()
  {
    return new h(this);
  }
  
  public final h<E> iterator()
  {
    return new b(this);
  }
  
  private static final class a<E>
  {
    public final Object a;
    public final E b;
    
    public a(Object paramObject, E paramE)
    {
      this.a = paramObject;
      this.b = paramE;
    }
  }
  
  private static final class b<E>
    implements h<E>
  {
    private Object a;
    private final a<E> b;
    
    public b(a<E> parama)
    {
      this.b = parama;
      this.a = b.c;
    }
    
    private final boolean c(Object paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if (((k)paramObject).q == null) {
          return false;
        }
        throw kotlinx.coroutines.internal.s.j(((k)paramObject).R());
      }
      return true;
    }
    
    public Object a(kotlin.coroutines.c<? super Boolean> paramc)
    {
      Object localObject1 = this.a;
      Object localObject2 = b.c;
      if (localObject1 != localObject2) {
        return kotlin.coroutines.jvm.internal.a.a(c(localObject1));
      }
      localObject1 = this.b.P();
      this.a = localObject1;
      if (localObject1 != localObject2) {
        return kotlin.coroutines.jvm.internal.a.a(c(localObject1));
      }
      return d(paramc);
    }
    
    public final a<E> b()
    {
      return this.b;
    }
    
    public final void e(Object paramObject)
    {
      this.a = paramObject;
    }
    
    public E next()
    {
      Object localObject1 = this.a;
      if (!(localObject1 instanceof k))
      {
        Object localObject2 = b.c;
        if (localObject1 != localObject2)
        {
          this.a = localObject2;
          return (E)localObject1;
        }
        throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
      }
      throw kotlinx.coroutines.internal.s.j(((k)localObject1).R());
    }
  }
  
  private static final class c<E>
    extends q<E>
  {
    public final a.b<E> q;
    public final kotlinx.coroutines.h<Boolean> x;
    
    public c(a.b<E> paramb, kotlinx.coroutines.h<? super Boolean> paramh)
    {
      this.q = paramb;
      this.x = paramh;
    }
    
    public void L(k<?> paramk)
    {
      j.f(paramk, "closed");
      Object localObject;
      if (paramk.q == null) {
        localObject = h.a.a(this.x, Boolean.FALSE, null, 2, null);
      } else {
        localObject = this.x.h(kotlinx.coroutines.internal.s.k(paramk.R(), this.x));
      }
      if (localObject != null)
      {
        this.q.e(paramk);
        this.x.p(localObject);
      }
    }
    
    public void j(Object paramObject)
    {
      j.f(paramObject, "token");
      if ((paramObject instanceof a.a))
      {
        a.b localb = this.q;
        paramObject = (a.a)paramObject;
        localb.e(((a.a)paramObject).b);
        this.x.p(((a.a)paramObject).a);
      }
      else
      {
        this.x.p(paramObject);
      }
    }
    
    public Object m(E paramE, Object paramObject)
    {
      Object localObject = this.x.b(Boolean.TRUE, paramObject);
      if (localObject != null)
      {
        if (paramObject != null) {
          return new a.a(localObject, paramE);
        }
        this.q.e(paramE);
      }
      return localObject;
    }
    
    public String toString()
    {
      return "ReceiveHasNext";
    }
  }
  
  private static final class d<R, E>
    extends q<E>
    implements o0
  {
    public final a<E> q;
    public final d<R> x;
    public final p<Object, kotlin.coroutines.c<? super R>, Object> y;
    public final int z;
    
    public d(a<E> parama, d<? super R> paramd, p<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> paramp, int paramInt)
    {
      this.q = parama;
      this.x = paramd;
      this.y = paramp;
      this.z = paramInt;
    }
    
    public void L(k<?> paramk)
    {
      j.f(paramk, "closed");
      if (!this.x.g(null)) {
        return;
      }
      int i = this.z;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            p localp = this.y;
            x.b localb = x.a;
            kotlin.coroutines.e.b(localp, x.a(x.b(new x.a(paramk.q))), this.x.l());
          }
        }
        else if (paramk.q == null) {
          kotlin.coroutines.e.b(this.y, null, this.x.l());
        } else {
          this.x.i(paramk.R());
        }
      }
      else {
        this.x.i(paramk.R());
      }
    }
    
    public void dispose()
    {
      if (I()) {
        this.q.N();
      }
    }
    
    public void j(Object paramObject)
    {
      j.f(paramObject, "token");
      Object localObject = paramObject;
      if (paramObject == b.f) {
        localObject = null;
      }
      p localp = this.y;
      paramObject = localObject;
      if (this.z == 2)
      {
        paramObject = x.a;
        paramObject = x.a(x.b(localObject));
      }
      kotlin.coroutines.e.b(localp, paramObject, this.x.l());
    }
    
    public Object m(E paramE, Object paramObject)
    {
      if (this.x.g(paramObject))
      {
        if (paramE == null) {
          paramE = b.f;
        }
      }
      else {
        paramE = null;
      }
      return paramE;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReceiveSelect[");
      localStringBuilder.append(this.x);
      localStringBuilder.append(",receiveMode=");
      localStringBuilder.append(this.z);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
  }
  
  private final class e
    extends kotlinx.coroutines.f
  {
    private final q<?> c;
    
    public e()
    {
      this.c = ((q)localObject);
    }
    
    public void a(Throwable paramThrowable)
    {
      if (this.c.I()) {
        a.this.N();
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RemoveReceiveOnCancel[");
      localStringBuilder.append(this.c);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
  }
  
  protected static final class f<E>
    extends i.c<u>
  {
    public Object d;
    public E e;
    
    public f(g paramg)
    {
      super();
    }
    
    protected Object c(i parami)
    {
      j.f(parami, "affected");
      if (!(parami instanceof k)) {
        if (!(parami instanceof u)) {
          parami = b.c;
        } else {
          parami = null;
        }
      }
      return parami;
    }
    
    protected boolean m(u paramu)
    {
      j.f(paramu, "node");
      Object localObject = paramu.O(this);
      if (localObject != null)
      {
        this.d = localObject;
        this.e = paramu.M();
        return true;
      }
      return false;
    }
  }
  
  public static final class g
    extends i.b
  {
    public g(i parami1, i parami2, a parama)
    {
      super();
    }
    
    public Object h(i parami)
    {
      j.f(parami, "affected");
      if (jdField_this.L()) {
        parami = null;
      } else {
        parami = kotlinx.coroutines.internal.h.b();
      }
      return parami;
    }
  }
  
  public static final class h
    implements kotlinx.coroutines.selects.c<E>
  {
    h(a parama) {}
    
    public <R> void a(d<? super R> paramd, p<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> paramp)
    {
      j.f(paramd, "select");
      j.f(paramp, "block");
      a.D(this.a, paramd, paramp);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */