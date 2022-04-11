package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.g;
import e.a.b.c.m;

public class h0
  extends h.c
{
  public h0(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public h0(d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  h0(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
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
    Object localObject1 = (g0)this.d;
    if (((g0)localObject1).i()) {
      return locald.u();
    }
    Object localObject2 = (g0)this.c;
    g0 localg0 = (g0)this.e[0];
    int[] arrayOfInt = g.h();
    f0.i(((g0)localObject1).h, arrayOfInt);
    Object localObject3 = g.h();
    f0.i(arrayOfInt, (int[])localObject3);
    Object localObject4 = g.h();
    f0.i(((g0)localObject2).h, (int[])localObject4);
    f0.h(g.b((int[])localObject4, (int[])localObject4, (int[])localObject4), (int[])localObject4);
    f0.d(arrayOfInt, ((g0)localObject2).h, arrayOfInt);
    f0.h(m.G(8, arrayOfInt, 2, 0), arrayOfInt);
    localObject2 = g.h();
    f0.h(m.H(8, (int[])localObject3, 3, 0, (int[])localObject2), (int[])localObject2);
    localObject3 = new g0((int[])localObject3);
    f0.i((int[])localObject4, ((g0)localObject3).h);
    Object localObject5 = ((g0)localObject3).h;
    f0.k((int[])localObject5, arrayOfInt, (int[])localObject5);
    localObject5 = ((g0)localObject3).h;
    f0.k((int[])localObject5, arrayOfInt, (int[])localObject5);
    localObject5 = new g0(arrayOfInt);
    f0.k(arrayOfInt, ((g0)localObject3).h, ((g0)localObject5).h);
    arrayOfInt = ((g0)localObject5).h;
    f0.d(arrayOfInt, (int[])localObject4, arrayOfInt);
    arrayOfInt = ((g0)localObject5).h;
    f0.k(arrayOfInt, (int[])localObject2, arrayOfInt);
    localObject4 = new g0((int[])localObject4);
    f0.l(((g0)localObject1).h, ((g0)localObject4).h);
    if (!localg0.h())
    {
      localObject1 = ((g0)localObject4).h;
      f0.d((int[])localObject1, localg0.h, (int[])localObject1);
    }
    boolean bool = this.f;
    return new h0(locald, (e)localObject3, (e)localObject5, new e[] { localObject4 }, bool);
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
    Object localObject1 = (g0)this.c;
    Object localObject2 = (g0)this.d;
    Object localObject3 = (g0)paramh.q();
    Object localObject4 = (g0)paramh.r();
    g0 localg01 = (g0)this.e[0];
    g0 localg02 = (g0)paramh.s(0);
    int[] arrayOfInt1 = g.j();
    int[] arrayOfInt2 = g.h();
    int[] arrayOfInt3 = g.h();
    int[] arrayOfInt4 = g.h();
    boolean bool1 = localg01.h();
    if (bool1)
    {
      localObject3 = ((g0)localObject3).h;
      paramh = ((g0)localObject4).h;
    }
    else
    {
      f0.i(localg01.h, arrayOfInt3);
      f0.d(arrayOfInt3, ((g0)localObject3).h, arrayOfInt2);
      f0.d(arrayOfInt3, localg01.h, arrayOfInt3);
      f0.d(arrayOfInt3, ((g0)localObject4).h, arrayOfInt3);
      localObject3 = arrayOfInt2;
      paramh = arrayOfInt3;
    }
    boolean bool2 = localg02.h();
    if (bool2)
    {
      localObject1 = ((g0)localObject1).h;
      localObject2 = ((g0)localObject2).h;
    }
    else
    {
      f0.i(localg02.h, arrayOfInt4);
      f0.d(arrayOfInt4, ((g0)localObject1).h, arrayOfInt1);
      f0.d(arrayOfInt4, localg02.h, arrayOfInt4);
      f0.d(arrayOfInt4, ((g0)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject4 = g.h();
    f0.k((int[])localObject1, (int[])localObject3, (int[])localObject4);
    f0.k((int[])localObject2, paramh, arrayOfInt2);
    if (g.v((int[])localObject4))
    {
      if (g.v(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    f0.i((int[])localObject4, arrayOfInt3);
    localObject3 = g.h();
    f0.d(arrayOfInt3, (int[])localObject4, (int[])localObject3);
    f0.d(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    f0.f((int[])localObject3, (int[])localObject3);
    g.y((int[])localObject2, (int[])localObject3, arrayOfInt1);
    f0.h(g.b(arrayOfInt3, arrayOfInt3, (int[])localObject3), (int[])localObject3);
    paramh = new g0(arrayOfInt4);
    f0.i(arrayOfInt2, paramh.h);
    localObject1 = paramh.h;
    f0.k((int[])localObject1, (int[])localObject3, (int[])localObject1);
    localObject3 = new g0((int[])localObject3);
    f0.k(arrayOfInt3, paramh.h, ((g0)localObject3).h);
    f0.e(((g0)localObject3).h, arrayOfInt2, arrayOfInt1);
    f0.g(arrayOfInt1, ((g0)localObject3).h);
    localObject1 = new g0((int[])localObject4);
    if (!bool1)
    {
      localObject2 = ((g0)localObject1).h;
      f0.d((int[])localObject2, localg01.h, (int[])localObject2);
    }
    if (!bool2)
    {
      localObject2 = ((g0)localObject1).h;
      f0.d((int[])localObject2, localg02.h, (int[])localObject2);
    }
    bool2 = this.f;
    return new h0(locald, paramh, (e)localObject3, new e[] { localObject1 }, bool2);
  }
  
  protected h d()
  {
    return new h0(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new h0(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */