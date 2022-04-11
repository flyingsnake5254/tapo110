package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.b;
import e.a.b.c.l;

public class t2
  extends h.b
{
  public t2(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public t2(d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  t2(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
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
    e locale1 = this.c;
    if (locale1.i()) {
      return locald.u();
    }
    e locale2 = this.d;
    e locale3 = this.e[0];
    boolean bool = locale3.h();
    e locale4;
    if (bool) {
      locale4 = locale3;
    } else {
      locale4 = locale3.o();
    }
    if (bool) {
      locale5 = locale2.o().a(locale2);
    } else {
      locale5 = locale2.a(locale3).j(locale2);
    }
    if (locale5.i()) {
      return new t2(locald, locale5, locald.p(), this.f);
    }
    e locale6 = locale5.o();
    e locale7;
    if (bool) {
      locale7 = locale5;
    } else {
      locale7 = locale5.j(locale4);
    }
    locale2 = locale2.a(locale1).o();
    if (!bool) {
      locale3 = locale4.o();
    }
    e locale5 = locale2.a(locale5).a(locale4).j(locale2).a(locale3).a(locale6).a(locale7);
    bool = this.f;
    return new t2(locald, locale6, locale5, new e[] { locale7 }, bool);
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
    e locale1 = this.c;
    if (locale1.i()) {
      return paramh;
    }
    e locale2 = paramh.n();
    e locale3 = paramh.s(0);
    if ((!locale2.i()) && (locale3.h()))
    {
      locale3 = this.d;
      e locale4 = this.e[0];
      e locale5 = paramh.o();
      e locale6 = locale1.o();
      e locale7 = locale3.o();
      locale1 = locale4.o();
      locale3 = locale7.a(locale3.j(locale4));
      locale5 = locale5.b();
      locale7 = locale5.j(locale1).a(locale7).l(locale3, locale6, locale1);
      locale6 = locale2.j(locale1);
      locale2 = locale6.a(locale3).o();
      if (locale2.i())
      {
        if (locale7.i()) {
          return paramh.J();
        }
        return locald.u();
      }
      if (locale7.i()) {
        return new t2(locald, locale7, locald.p(), this.f);
      }
      paramh = locale7.o().j(locale6);
      locale1 = locale7.j(locale2).j(locale1);
      locale3 = locale7.a(locale2).o().l(locale3, locale5, locale1);
      boolean bool = this.f;
      return new t2(locald, paramh, locale3, new e[] { locale1 }, bool);
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
      localObject3 = A();
      paramh = (r2)((h)localObject3).q();
      localObject3 = ((h)localObject3).r();
      localObject2 = ((e)localObject3).a(localr24).d(paramh);
      localObject4 = (r2)((e)localObject2).o().a((e)localObject2).a(paramh);
      if (((r2)localObject4).i()) {
        return new t2(locald, (e)localObject4, locald.p(), this.f);
      }
      localObject3 = (r2)((e)localObject2).j(paramh.a((e)localObject4)).a((e)localObject4).a((e)localObject3).d((e)localObject4).a((e)localObject4);
      paramh = (r2)locald.n(c.b);
    }
    else
    {
      q2.t(arrayOfLong4, arrayOfLong4);
      arrayOfLong5 = q2.p(arrayOfLong3);
      q2.n((long[])localObject1, arrayOfLong5, arrayOfLong1);
      q2.n((long[])localObject3, arrayOfLong5, arrayOfLong2);
      localObject3 = new r2(arrayOfLong1);
      q2.l(arrayOfLong1, arrayOfLong2, ((r2)localObject3).g);
      if (((r2)localObject3).i()) {
        return new t2(locald, (e)localObject3, locald.p(), this.f);
      }
      localObject4 = new r2(arrayOfLong3);
      q2.n(arrayOfLong4, arrayOfLong5, ((r2)localObject4).g);
      if (localObject2 != null)
      {
        localObject1 = ((r2)localObject4).g;
        q2.n((long[])localObject1, (long[])localObject2, (long[])localObject1);
      }
      localObject1 = l.c();
      q2.b(arrayOfLong2, arrayOfLong4, arrayOfLong4);
      q2.u(arrayOfLong4, (long[])localObject1);
      q2.b(localr22.g, localr23.g, arrayOfLong4);
      q2.m(arrayOfLong4, ((r2)localObject4).g, (long[])localObject1);
      localObject2 = new r2(arrayOfLong4);
      q2.q((long[])localObject1, ((r2)localObject2).g);
      if (paramh != null)
      {
        localObject1 = ((r2)localObject4).g;
        q2.n((long[])localObject1, paramh, (long[])localObject1);
      }
      paramh = (h)localObject3;
      localObject3 = localObject2;
      localObject2 = localObject4;
      localObject4 = paramh;
      paramh = (h)localObject2;
    }
    boolean bool = this.f;
    return new t2(locald, (e)localObject4, (e)localObject3, new e[] { paramh }, bool);
  }
  
  protected h d()
  {
    return new t2(null, f(), g());
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
    Object localObject = this.c;
    e locale1 = this.d;
    if ((!u()) && (!((e)localObject).i()))
    {
      locale1 = locale1.a((e)localObject).j((e)localObject);
      e locale2 = this.e[0];
      localObject = locale1;
      if (!locale2.h()) {
        localObject = locale1.d(locale2);
      }
      return (e)localObject;
    }
    return locale1;
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
    return new t2(locald, locale1, locale2, new e[] { locale3 }, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\t2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */