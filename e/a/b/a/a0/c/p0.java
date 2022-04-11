package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.i;
import e.a.b.c.m;

public class p0
  extends h.c
{
  public p0(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public p0(d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  p0(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    super(paramd, parame1, parame2, paramArrayOfe);
    this.f = paramBoolean;
  }
  
  public h H()
  {
    if ((!u()) && (!this.d.i())) {
      return J().a(this);
    }
    return this;
  }
  
  public h J()
  {
    if (u()) {
      return this;
    }
    d locald = i();
    Object localObject1 = (o0)this.d;
    if (((o0)localObject1).i()) {
      return locald.u();
    }
    o0 localo01 = (o0)this.c;
    o0 localo02 = (o0)this.e[0];
    int[] arrayOfInt1 = m.j(12);
    Object localObject2 = m.j(12);
    int[] arrayOfInt2 = m.j(12);
    n0.j(((o0)localObject1).h, arrayOfInt2);
    int[] arrayOfInt3 = m.j(12);
    n0.j(arrayOfInt2, arrayOfInt3);
    boolean bool = localo02.h();
    Object localObject3 = localo02.h;
    Object localObject4 = localObject3;
    if (!bool)
    {
      n0.j((int[])localObject3, (int[])localObject2);
      localObject4 = localObject2;
    }
    n0.m(localo01.h, (int[])localObject4, arrayOfInt1);
    n0.a(localo01.h, (int[])localObject4, (int[])localObject2);
    n0.f((int[])localObject2, arrayOfInt1, (int[])localObject2);
    n0.i(m.c(12, (int[])localObject2, (int[])localObject2, (int[])localObject2), (int[])localObject2);
    n0.f(arrayOfInt2, localo01.h, arrayOfInt2);
    n0.i(m.G(12, arrayOfInt2, 2, 0), arrayOfInt2);
    n0.i(m.H(12, arrayOfInt3, 3, 0, arrayOfInt1), arrayOfInt1);
    localObject4 = new o0(arrayOfInt3);
    n0.j((int[])localObject2, ((o0)localObject4).h);
    localObject3 = ((o0)localObject4).h;
    n0.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = ((o0)localObject4).h;
    n0.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = new o0(arrayOfInt2);
    n0.m(arrayOfInt2, ((o0)localObject4).h, ((o0)localObject3).h);
    arrayOfInt2 = ((o0)localObject3).h;
    n0.f(arrayOfInt2, (int[])localObject2, arrayOfInt2);
    arrayOfInt2 = ((o0)localObject3).h;
    n0.m(arrayOfInt2, arrayOfInt1, arrayOfInt2);
    localObject2 = new o0((int[])localObject2);
    n0.n(((o0)localObject1).h, ((o0)localObject2).h);
    if (!bool)
    {
      localObject1 = ((o0)localObject2).h;
      n0.f((int[])localObject1, localo02.h, (int[])localObject1);
    }
    bool = this.f;
    return new p0(locald, (e)localObject4, (e)localObject3, new e[] { localObject2 }, bool);
  }
  
  public h K(h paramh)
  {
    if (this == paramh) {
      return H();
    }
    if (u()) {
      return paramh;
    }
    if (paramh.u()) {
      return J();
    }
    if (this.d.i()) {
      return paramh;
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
    if (this == paramh) {
      return J();
    }
    d locald = i();
    Object localObject1 = (o0)this.c;
    Object localObject2 = (o0)this.d;
    Object localObject3 = (o0)paramh.q();
    Object localObject4 = (o0)paramh.r();
    o0 localo01 = (o0)this.e[0];
    o0 localo02 = (o0)paramh.s(0);
    int[] arrayOfInt1 = m.j(24);
    int[] arrayOfInt2 = m.j(24);
    int[] arrayOfInt3 = m.j(12);
    int[] arrayOfInt4 = m.j(12);
    boolean bool1 = localo01.h();
    if (bool1)
    {
      localObject3 = ((o0)localObject3).h;
      paramh = ((o0)localObject4).h;
    }
    else
    {
      n0.j(localo01.h, arrayOfInt3);
      n0.f(arrayOfInt3, ((o0)localObject3).h, arrayOfInt2);
      n0.f(arrayOfInt3, localo01.h, arrayOfInt3);
      n0.f(arrayOfInt3, ((o0)localObject4).h, arrayOfInt3);
      localObject3 = arrayOfInt2;
      paramh = arrayOfInt3;
    }
    boolean bool2 = localo02.h();
    if (bool2)
    {
      localObject1 = ((o0)localObject1).h;
      localObject2 = ((o0)localObject2).h;
    }
    else
    {
      n0.j(localo02.h, arrayOfInt4);
      n0.f(arrayOfInt4, ((o0)localObject1).h, arrayOfInt1);
      n0.f(arrayOfInt4, localo02.h, arrayOfInt4);
      n0.f(arrayOfInt4, ((o0)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject4 = m.j(12);
    n0.m((int[])localObject1, (int[])localObject3, (int[])localObject4);
    localObject3 = m.j(12);
    n0.m((int[])localObject2, paramh, (int[])localObject3);
    if (m.w(12, (int[])localObject4))
    {
      if (m.w(12, (int[])localObject3)) {
        return J();
      }
      return locald.u();
    }
    n0.j((int[])localObject4, arrayOfInt3);
    int[] arrayOfInt5 = m.j(12);
    n0.f(arrayOfInt3, (int[])localObject4, arrayOfInt5);
    n0.f(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    n0.g(arrayOfInt5, arrayOfInt5);
    i.a((int[])localObject2, arrayOfInt5, arrayOfInt1);
    n0.i(m.c(12, arrayOfInt3, arrayOfInt3, arrayOfInt5), arrayOfInt5);
    paramh = new o0(arrayOfInt4);
    n0.j((int[])localObject3, paramh.h);
    localObject2 = paramh.h;
    n0.m((int[])localObject2, arrayOfInt5, (int[])localObject2);
    localObject2 = new o0(arrayOfInt5);
    n0.m(arrayOfInt3, paramh.h, ((o0)localObject2).h);
    i.a(((o0)localObject2).h, (int[])localObject3, arrayOfInt2);
    n0.b(arrayOfInt1, arrayOfInt2, arrayOfInt1);
    n0.h(arrayOfInt1, ((o0)localObject2).h);
    localObject3 = new o0((int[])localObject4);
    if (!bool1)
    {
      localObject1 = ((o0)localObject3).h;
      n0.f((int[])localObject1, localo01.h, (int[])localObject1);
    }
    if (!bool2)
    {
      localObject1 = ((o0)localObject3).h;
      n0.f((int[])localObject1, localo02.h, (int[])localObject1);
    }
    bool2 = this.f;
    return new p0(locald, paramh, (e)localObject2, new e[] { localObject3 }, bool2);
  }
  
  protected h d()
  {
    return new p0(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new p0(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\p0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */