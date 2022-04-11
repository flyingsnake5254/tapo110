package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.m;

public class t0
  extends h.c
{
  public t0(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public t0(d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  t0(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
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
    Object localObject1 = (s0)this.d;
    if (((s0)localObject1).i()) {
      return locald.u();
    }
    s0 locals01 = (s0)this.c;
    s0 locals02 = (s0)this.e[0];
    int[] arrayOfInt1 = m.j(17);
    Object localObject2 = m.j(17);
    int[] arrayOfInt2 = m.j(17);
    r0.j(((s0)localObject1).h, arrayOfInt2);
    int[] arrayOfInt3 = m.j(17);
    r0.j(arrayOfInt2, arrayOfInt3);
    boolean bool = locals02.h();
    Object localObject3 = locals02.h;
    Object localObject4 = localObject3;
    if (!bool)
    {
      r0.j((int[])localObject3, (int[])localObject2);
      localObject4 = localObject2;
    }
    r0.l(locals01.h, (int[])localObject4, arrayOfInt1);
    r0.a(locals01.h, (int[])localObject4, (int[])localObject2);
    r0.f((int[])localObject2, arrayOfInt1, (int[])localObject2);
    m.c(17, (int[])localObject2, (int[])localObject2, (int[])localObject2);
    r0.i((int[])localObject2);
    r0.f(arrayOfInt2, locals01.h, arrayOfInt2);
    m.G(17, arrayOfInt2, 2, 0);
    r0.i(arrayOfInt2);
    m.H(17, arrayOfInt3, 3, 0, arrayOfInt1);
    r0.i(arrayOfInt1);
    localObject4 = new s0(arrayOfInt3);
    r0.j((int[])localObject2, ((s0)localObject4).h);
    localObject3 = ((s0)localObject4).h;
    r0.l((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = ((s0)localObject4).h;
    r0.l((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = new s0(arrayOfInt2);
    r0.l(arrayOfInt2, ((s0)localObject4).h, ((s0)localObject3).h);
    arrayOfInt2 = ((s0)localObject3).h;
    r0.f(arrayOfInt2, (int[])localObject2, arrayOfInt2);
    arrayOfInt2 = ((s0)localObject3).h;
    r0.l(arrayOfInt2, arrayOfInt1, arrayOfInt2);
    localObject2 = new s0((int[])localObject2);
    r0.m(((s0)localObject1).h, ((s0)localObject2).h);
    if (!bool)
    {
      localObject1 = ((s0)localObject2).h;
      r0.f((int[])localObject1, locals02.h, (int[])localObject1);
    }
    bool = this.f;
    return new t0(locald, (e)localObject4, (e)localObject3, new e[] { localObject2 }, bool);
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
    Object localObject1 = (s0)this.c;
    Object localObject2 = (s0)this.d;
    Object localObject3 = (s0)paramh.q();
    Object localObject4 = (s0)paramh.r();
    s0 locals01 = (s0)this.e[0];
    s0 locals02 = (s0)paramh.s(0);
    int[] arrayOfInt1 = m.j(17);
    int[] arrayOfInt2 = m.j(17);
    int[] arrayOfInt3 = m.j(17);
    int[] arrayOfInt4 = m.j(17);
    boolean bool1 = locals01.h();
    if (bool1)
    {
      localObject3 = ((s0)localObject3).h;
      paramh = ((s0)localObject4).h;
    }
    else
    {
      r0.j(locals01.h, arrayOfInt3);
      r0.f(arrayOfInt3, ((s0)localObject3).h, arrayOfInt2);
      r0.f(arrayOfInt3, locals01.h, arrayOfInt3);
      r0.f(arrayOfInt3, ((s0)localObject4).h, arrayOfInt3);
      localObject3 = arrayOfInt2;
      paramh = arrayOfInt3;
    }
    boolean bool2 = locals02.h();
    if (bool2)
    {
      localObject1 = ((s0)localObject1).h;
      localObject2 = ((s0)localObject2).h;
    }
    else
    {
      r0.j(locals02.h, arrayOfInt4);
      r0.f(arrayOfInt4, ((s0)localObject1).h, arrayOfInt1);
      r0.f(arrayOfInt4, locals02.h, arrayOfInt4);
      r0.f(arrayOfInt4, ((s0)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject4 = m.j(17);
    r0.l((int[])localObject1, (int[])localObject3, (int[])localObject4);
    r0.l((int[])localObject2, paramh, arrayOfInt2);
    if (m.w(17, (int[])localObject4))
    {
      if (m.w(17, arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    r0.j((int[])localObject4, arrayOfInt3);
    localObject3 = m.j(17);
    r0.f(arrayOfInt3, (int[])localObject4, (int[])localObject3);
    r0.f(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    r0.f((int[])localObject2, (int[])localObject3, arrayOfInt1);
    paramh = new s0(arrayOfInt4);
    r0.j(arrayOfInt2, paramh.h);
    localObject2 = paramh.h;
    r0.a((int[])localObject2, (int[])localObject3, (int[])localObject2);
    localObject2 = paramh.h;
    r0.l((int[])localObject2, arrayOfInt3, (int[])localObject2);
    localObject2 = paramh.h;
    r0.l((int[])localObject2, arrayOfInt3, (int[])localObject2);
    localObject3 = new s0((int[])localObject3);
    r0.l(arrayOfInt3, paramh.h, ((s0)localObject3).h);
    r0.f(((s0)localObject3).h, arrayOfInt2, arrayOfInt2);
    r0.l(arrayOfInt2, arrayOfInt1, ((s0)localObject3).h);
    localObject2 = new s0((int[])localObject4);
    if (!bool1)
    {
      localObject1 = ((s0)localObject2).h;
      r0.f((int[])localObject1, locals01.h, (int[])localObject1);
    }
    if (!bool2)
    {
      localObject1 = ((s0)localObject2).h;
      r0.f((int[])localObject1, locals02.h, (int[])localObject1);
    }
    bool1 = this.f;
    return new t0(locald, paramh, (e)localObject3, new e[] { localObject2 }, bool1);
  }
  
  protected h d()
  {
    return new t0(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new t0(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\t0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */