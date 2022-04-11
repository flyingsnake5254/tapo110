package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.b;
import e.a.b.c.l;
import e.a.b.c.m;

public class v2
  extends h.b
{
  public v2(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public v2(d paramd, e parame1, e parame2, boolean paramBoolean)
  {
    super(paramd, parame1, parame2);
    int i = 1;
    int j;
    if (parame1 == null) {
      j = 1;
    } else {
      j = 0;
    }
    if (parame2 != null) {
      i = 0;
    }
    if (j == i)
    {
      this.f = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("Exactly one of the field elements is null");
  }
  
  v2(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    super(paramd, parame1, parame2, paramArrayOfe);
    this.f = paramBoolean;
  }
  
  public h J()
  {
    if (u()) {
      return this;
    }
    d locald = i();
    r2 localr2 = (r2)this.c;
    if (localr2.i()) {
      return locald.u();
    }
    Object localObject1 = (r2)this.d;
    Object localObject2 = (r2)this.e[0];
    Object localObject3 = l.b();
    Object localObject4 = l.b();
    Object localObject5;
    if (((r2)localObject2).h()) {
      localObject5 = null;
    } else {
      localObject5 = q2.p(((r2)localObject2).g);
    }
    Object localObject6 = ((r2)localObject1).g;
    if (localObject5 == null)
    {
      localObject2 = ((r2)localObject2).g;
    }
    else
    {
      q2.n((long[])localObject6, (long[])localObject5, (long[])localObject3);
      q2.t(((r2)localObject2).g, (long[])localObject4);
      localObject6 = localObject3;
      localObject2 = localObject4;
    }
    long[] arrayOfLong = l.b();
    q2.t(((r2)localObject1).g, arrayOfLong);
    q2.d((long[])localObject6, (long[])localObject2, arrayOfLong);
    if (l.g(arrayOfLong)) {
      return new v2(locald, new r2(arrayOfLong), u2.k, this.f);
    }
    localObject1 = l.c();
    q2.m(arrayOfLong, (long[])localObject6, (long[])localObject1);
    localObject6 = new r2((long[])localObject3);
    q2.t(arrayOfLong, ((r2)localObject6).g);
    localObject3 = new r2(arrayOfLong);
    if (localObject5 != null)
    {
      arrayOfLong = ((r2)localObject3).g;
      q2.l(arrayOfLong, (long[])localObject2, arrayOfLong);
    }
    localObject2 = localr2.g;
    if (localObject5 == null)
    {
      localObject5 = localObject2;
    }
    else
    {
      q2.n((long[])localObject2, (long[])localObject5, (long[])localObject4);
      localObject5 = localObject4;
    }
    q2.u((long[])localObject5, (long[])localObject1);
    q2.q((long[])localObject1, (long[])localObject4);
    q2.d(((r2)localObject6).g, ((r2)localObject3).g, (long[])localObject4);
    localObject4 = new r2((long[])localObject4);
    boolean bool = this.f;
    return new v2(locald, (e)localObject6, (e)localObject4, new e[] { localObject3 }, bool);
  }
  
  public h K(h paramh)
  {
    if (u()) {
      return paramh;
    }
    if (paramh.u()) {
      return J();
    }
    d locald = i();
    Object localObject1 = (r2)this.c;
    if (((r2)localObject1).i()) {
      return paramh;
    }
    Object localObject2 = (r2)paramh.n();
    r2 localr21 = (r2)paramh.s(0);
    if ((!((r2)localObject2).i()) && (localr21.h()))
    {
      Object localObject3 = (r2)this.d;
      r2 localr22 = (r2)this.e[0];
      localr21 = (r2)paramh.o();
      Object localObject4 = l.b();
      long[] arrayOfLong1 = l.b();
      long[] arrayOfLong2 = l.b();
      long[] arrayOfLong3 = l.b();
      q2.t(((r2)localObject1).g, (long[])localObject4);
      q2.t(((r2)localObject3).g, arrayOfLong1);
      q2.t(localr22.g, arrayOfLong2);
      q2.l(((r2)localObject3).g, localr22.g, arrayOfLong3);
      q2.d(arrayOfLong2, arrayOfLong1, arrayOfLong3);
      localObject3 = q2.p(arrayOfLong2);
      q2.n(localr21.g, (long[])localObject3, arrayOfLong2);
      q2.b(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      localObject1 = l.c();
      q2.m(arrayOfLong2, arrayOfLong3, (long[])localObject1);
      q2.o((long[])localObject4, (long[])localObject3, (long[])localObject1);
      q2.q((long[])localObject1, arrayOfLong2);
      q2.n(((r2)localObject2).g, (long[])localObject3, (long[])localObject4);
      q2.b((long[])localObject4, arrayOfLong3, arrayOfLong1);
      q2.t(arrayOfLong1, arrayOfLong1);
      if (l.g(arrayOfLong1))
      {
        if (l.g(arrayOfLong2)) {
          return paramh.J();
        }
        return locald.u();
      }
      if (l.g(arrayOfLong2)) {
        return new v2(locald, new r2(arrayOfLong2), u2.k, this.f);
      }
      paramh = new r2();
      q2.t(arrayOfLong2, paramh.g);
      localObject2 = paramh.g;
      q2.l((long[])localObject2, (long[])localObject4, (long[])localObject2);
      localObject4 = new r2((long[])localObject4);
      q2.l(arrayOfLong2, arrayOfLong1, ((r2)localObject4).g);
      localObject2 = ((r2)localObject4).g;
      q2.n((long[])localObject2, (long[])localObject3, (long[])localObject2);
      localObject2 = new r2(arrayOfLong1);
      q2.b(arrayOfLong2, arrayOfLong1, ((r2)localObject2).g);
      arrayOfLong1 = ((r2)localObject2).g;
      q2.t(arrayOfLong1, arrayOfLong1);
      m.R(18, (long[])localObject1);
      q2.m(((r2)localObject2).g, arrayOfLong3, (long[])localObject1);
      q2.f(localr21.g, arrayOfLong3);
      q2.m(arrayOfLong3, ((r2)localObject4).g, (long[])localObject1);
      q2.q((long[])localObject1, ((r2)localObject2).g);
      boolean bool = this.f;
      return new v2(locald, paramh, (e)localObject2, new e[] { localObject4 }, bool);
    }
    return J().a(paramh);
  }
  
  public h a(h paramh)
  {
    if (u()) {
      return paramh;
    }
    if (paramh.u()) {
      return this;
    }
    d locald = i();
    Object localObject1 = (r2)this.c;
    r2 localr21 = (r2)paramh.n();
    if (((r2)localObject1).i())
    {
      if (localr21.i()) {
        return locald.u();
      }
      return paramh.a(this);
    }
    r2 localr22 = (r2)this.d;
    r2 localr23 = (r2)this.e[0];
    r2 localr24 = (r2)paramh.o();
    Object localObject2 = (r2)paramh.s(0);
    long[] arrayOfLong1 = l.b();
    long[] arrayOfLong2 = l.b();
    long[] arrayOfLong3 = l.b();
    long[] arrayOfLong4 = l.b();
    if (localr23.h()) {
      paramh = null;
    } else {
      paramh = q2.p(localr23.g);
    }
    Object localObject3;
    Object localObject4;
    if (paramh == null)
    {
      localObject3 = localr21.g;
      localObject4 = localr24.g;
    }
    else
    {
      q2.n(localr21.g, paramh, arrayOfLong2);
      q2.n(localr24.g, paramh, arrayOfLong4);
      localObject3 = arrayOfLong2;
      localObject4 = arrayOfLong4;
    }
    if (((r2)localObject2).h()) {
      localObject2 = null;
    } else {
      localObject2 = q2.p(((r2)localObject2).g);
    }
    localObject1 = ((r2)localObject1).g;
    long[] arrayOfLong5;
    if (localObject2 == null)
    {
      arrayOfLong5 = localr22.g;
    }
    else
    {
      q2.n((long[])localObject1, (long[])localObject2, arrayOfLong1);
      q2.n(localr22.g, (long[])localObject2, arrayOfLong3);
      localObject1 = arrayOfLong1;
      arrayOfLong5 = arrayOfLong3;
    }
    q2.b(arrayOfLong5, (long[])localObject4, arrayOfLong3);
    q2.b((long[])localObject1, (long[])localObject3, arrayOfLong4);
    if (l.g(arrayOfLong4))
    {
      if (l.g(arrayOfLong3)) {
        return J();
      }
      return locald.u();
    }
    if (localr21.i())
    {
      paramh = A();
      localObject3 = (r2)paramh.q();
      localObject2 = paramh.r();
      localObject4 = ((e)localObject2).a(localr24).d((e)localObject3);
      paramh = (r2)((e)localObject4).o().a((e)localObject4).a((e)localObject3).b();
      if (paramh.i()) {
        return new v2(locald, paramh, u2.k, this.f);
      }
      localObject2 = (r2)((e)localObject4).j(((r2)localObject3).a(paramh)).a(paramh).a((e)localObject2).d(paramh).a(paramh);
      localObject3 = (r2)locald.n(c.b);
    }
    else
    {
      q2.t(arrayOfLong4, arrayOfLong4);
      arrayOfLong5 = q2.p(arrayOfLong3);
      q2.n((long[])localObject1, arrayOfLong5, arrayOfLong1);
      q2.n((long[])localObject3, arrayOfLong5, arrayOfLong2);
      localObject4 = new r2(arrayOfLong1);
      q2.l(arrayOfLong1, arrayOfLong2, ((r2)localObject4).g);
      if (((r2)localObject4).i()) {
        return new v2(locald, (e)localObject4, u2.k, this.f);
      }
      localObject3 = new r2(arrayOfLong3);
      q2.n(arrayOfLong4, arrayOfLong5, ((r2)localObject3).g);
      if (localObject2 != null)
      {
        localObject1 = ((r2)localObject3).g;
        q2.n((long[])localObject1, (long[])localObject2, (long[])localObject1);
      }
      localObject1 = l.c();
      q2.b(arrayOfLong2, arrayOfLong4, arrayOfLong4);
      q2.u(arrayOfLong4, (long[])localObject1);
      q2.b(localr22.g, localr23.g, arrayOfLong4);
      q2.m(arrayOfLong4, ((r2)localObject3).g, (long[])localObject1);
      localObject2 = new r2(arrayOfLong4);
      q2.q((long[])localObject1, ((r2)localObject2).g);
      if (paramh != null)
      {
        localObject1 = ((r2)localObject3).g;
        q2.n((long[])localObject1, paramh, (long[])localObject1);
      }
      paramh = (h)localObject4;
    }
    boolean bool = this.f;
    return new v2(locald, paramh, (e)localObject2, new e[] { localObject3 }, bool);
  }
  
  protected h d()
  {
    return new v2(null, f(), g());
  }
  
  protected boolean h()
  {
    e locale = n();
    boolean bool1 = locale.i();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (o().s() != locale.s()) {
      bool2 = true;
    }
    return bool2;
  }
  
  public e r()
  {
    e locale1 = this.c;
    e locale2 = this.d;
    if ((!u()) && (!locale1.i()))
    {
      locale1 = locale2.a(locale1).j(locale1);
      e locale3 = this.e[0];
      locale2 = locale1;
      if (!locale3.h()) {
        locale2 = locale1.d(locale3);
      }
      return locale2;
    }
    return locale2;
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    e locale1 = this.c;
    if (locale1.i()) {
      return this;
    }
    e locale2 = this.d;
    e locale3 = this.e[0];
    d locald = this.b;
    locale2 = locale2.a(locale3);
    boolean bool = this.f;
    return new v2(locald, locale1, locale2, new e[] { locale3 }, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\v2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */