package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.b;

public class d1
  extends h.b
{
  public d1(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public d1(d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  d1(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
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
    if (bool) {
      locale4 = locale2;
    } else {
      locale4 = locale2.j(locale3);
    }
    e locale5;
    if (bool) {
      locale5 = locale3;
    } else {
      locale5 = locale3.o();
    }
    e locale6 = locald.o();
    if (!bool) {
      locale6 = locale6.j(locale5);
    }
    locale2 = locale2.o().a(locale4).a(locale6);
    if (locale2.i()) {
      return new d1(locald, locale2, locald.p().n(), this.f);
    }
    e locale7 = locale2.o();
    if (bool) {
      locale5 = locale2;
    } else {
      locale5 = locale2.j(locale5);
    }
    if (bool) {
      locale6 = locale1;
    } else {
      locale6 = locale1.j(locale3);
    }
    e locale4 = locale6.p(locale2, locale4).a(locale7).a(locale5);
    bool = this.f;
    return new d1(locald, locale7, locale4, new e[] { locale5 }, bool);
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
      e locale4 = this.d;
      locale3 = this.e[0];
      e locale5 = paramh.o();
      e locale6 = locale1.o();
      e locale7 = locale4.o();
      locale1 = locale3.o();
      locale3 = locale4.j(locale3);
      locale3 = locald.o().j(locale1).a(locale7).a(locale3);
      locale5 = locale5.b();
      locale6 = locald.o().a(locale5).j(locale1).a(locale7).l(locale3, locale6, locale1);
      locale7 = locale2.j(locale1);
      locale2 = locale7.a(locale3).o();
      if (locale2.i())
      {
        if (locale6.i()) {
          return paramh.J();
        }
        return locald.u();
      }
      if (locale6.i()) {
        return new d1(locald, locale6, locald.p().n(), this.f);
      }
      paramh = locale6.o().j(locale7);
      locale1 = locale6.j(locale2).j(locale1);
      locale2 = locale6.a(locale2).o().l(locale3, locale5, locale1);
      boolean bool = this.f;
      return new d1(locald, paramh, locale2, new e[] { locale1 }, bool);
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
    Object localObject1 = this.c;
    e locale1 = paramh.n();
    if (((e)localObject1).i())
    {
      if (locale1.i()) {
        return locald.u();
      }
      return paramh.a(this);
    }
    e locale2 = this.d;
    e locale3 = this.e[0];
    e locale4 = paramh.o();
    e locale5 = paramh.s(0);
    boolean bool1 = locale3.h();
    if (!bool1)
    {
      paramh = locale1.j(locale3);
      localObject2 = locale4.j(locale3);
    }
    else
    {
      paramh = locale1;
      localObject2 = locale4;
    }
    boolean bool2 = locale5.h();
    if (!bool2)
    {
      localObject1 = ((e)localObject1).j(locale5);
      locale6 = locale2.j(locale5);
    }
    else
    {
      locale6 = locale2;
    }
    e locale6 = locale6.a((e)localObject2);
    Object localObject2 = ((e)localObject1).a(paramh);
    if (((e)localObject2).i())
    {
      if (locale6.i()) {
        return J();
      }
      return locald.u();
    }
    if (locale1.i())
    {
      paramh = A();
      localObject2 = paramh.q();
      localObject1 = paramh.r();
      locale6 = ((e)localObject1).a(locale4).d((e)localObject2);
      paramh = locale6.o().a(locale6).a((e)localObject2).a(locald.o());
      if (paramh.i()) {
        return new d1(locald, paramh, locald.p().n(), this.f);
      }
      localObject1 = locale6.j(((e)localObject2).a(paramh)).a(paramh).a((e)localObject1).d(paramh).a(paramh);
      localObject2 = locald.n(c.b);
    }
    else
    {
      localObject2 = ((e)localObject2).o();
      localObject1 = locale6.j((e)localObject1);
      locale4 = locale6.j(paramh);
      localObject1 = ((e)localObject1).j(locale4);
      if (((e)localObject1).i()) {
        return new d1(locald, (e)localObject1, locald.p().n(), this.f);
      }
      paramh = locale6.j((e)localObject2);
      if (!bool2) {
        paramh = paramh.j(locale5);
      }
      locale6 = locale4.a((e)localObject2).p(paramh, locale2.a(locale3));
      localObject2 = paramh;
      if (!bool1) {
        localObject2 = paramh.j(locale3);
      }
      paramh = (h)localObject1;
      localObject1 = locale6;
    }
    bool2 = this.f;
    return new d1(locald, paramh, (e)localObject1, new e[] { localObject2 }, bool2);
  }
  
  protected h d()
  {
    return new d1(null, f(), g());
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
    return new d1(locald, locale1, locale2, new e[] { locale3 }, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\d1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */