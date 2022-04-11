package kotlinx.coroutines.internal;

import kotlin.TypeCastException;
import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.w1;

public final class x
{
  private static final t a = new t("ZERO");
  private static final p<Object, f.b, Object> b = a.c;
  private static final p<w1<?>, f.b, w1<?>> c = b.c;
  private static final p<a0, f.b, a0> d = d.c;
  private static final p<a0, f.b, a0> e = c.c;
  
  public static final void a(f paramf, Object paramObject)
  {
    j.f(paramf, "context");
    if (paramObject == a) {
      return;
    }
    if ((paramObject instanceof a0))
    {
      ((a0)paramObject).c();
      paramf.fold(paramObject, e);
    }
    else
    {
      Object localObject = paramf.fold(null, c);
      if (localObject == null) {
        break label69;
      }
      ((w1)localObject).k(paramf, paramObject);
    }
    return;
    label69:
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
  }
  
  public static final Object b(f paramf)
  {
    j.f(paramf, "context");
    paramf = paramf.fold(Integer.valueOf(0), b);
    if (paramf == null) {
      j.n();
    }
    return paramf;
  }
  
  public static final Object c(f paramf, Object paramObject)
  {
    j.f(paramf, "context");
    if (paramObject == null) {
      paramObject = b(paramf);
    }
    if (paramObject == Integer.valueOf(0))
    {
      paramf = a;
    }
    else if ((paramObject instanceof Integer))
    {
      paramf = paramf.fold(new a0(paramf, ((Number)paramObject).intValue()), d);
    }
    else
    {
      if (paramObject == null) {
        break label85;
      }
      paramf = ((w1)paramObject).s(paramf);
    }
    return paramf;
    label85:
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
  }
  
  static final class a
    extends Lambda
    implements p<Object, f.b, Object>
  {
    public static final a c = new a();
    
    a()
    {
      super();
    }
    
    public final Object a(Object paramObject, f.b paramb)
    {
      j.f(paramb, "element");
      if ((paramb instanceof w1))
      {
        Object localObject = paramObject;
        if (!(paramObject instanceof Integer)) {
          localObject = null;
        }
        paramObject = (Integer)localObject;
        int i;
        if (paramObject != null) {
          i = ((Integer)paramObject).intValue();
        } else {
          i = 1;
        }
        if (i != 0) {
          paramb = Integer.valueOf(i + 1);
        }
        return paramb;
      }
      return paramObject;
    }
  }
  
  static final class b
    extends Lambda
    implements p<w1<?>, f.b, w1<?>>
  {
    public static final b c = new b();
    
    b()
    {
      super();
    }
    
    public final w1<?> a(w1<?> paramw1, f.b paramb)
    {
      j.f(paramb, "element");
      if (paramw1 != null) {
        return paramw1;
      }
      paramw1 = paramb;
      if (!(paramb instanceof w1)) {
        paramw1 = null;
      }
      return (w1)paramw1;
    }
  }
  
  static final class c
    extends Lambda
    implements p<a0, f.b, a0>
  {
    public static final c c = new c();
    
    c()
    {
      super();
    }
    
    public final a0 a(a0 parama0, f.b paramb)
    {
      j.f(parama0, "state");
      j.f(paramb, "element");
      if ((paramb instanceof w1)) {
        ((w1)paramb).k(parama0.b(), parama0.d());
      }
      return parama0;
    }
  }
  
  static final class d
    extends Lambda
    implements p<a0, f.b, a0>
  {
    public static final d c = new d();
    
    d()
    {
      super();
    }
    
    public final a0 a(a0 parama0, f.b paramb)
    {
      j.f(parama0, "state");
      j.f(paramb, "element");
      if ((paramb instanceof w1)) {
        parama0.a(((w1)paramb).s(parama0.b()));
      }
      return parama0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */