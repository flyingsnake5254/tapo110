package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.g;
import e.a.b.c.m;

public class l0
  extends h.c
{
  public l0(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public l0(d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  l0(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
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
    Object localObject1 = (k0)this.d;
    if (((k0)localObject1).i()) {
      return locald.u();
    }
    k0 localk01 = (k0)this.c;
    k0 localk02 = (k0)this.e[0];
    int[] arrayOfInt1 = g.h();
    Object localObject2 = g.h();
    int[] arrayOfInt2 = g.h();
    j0.j(((k0)localObject1).h, arrayOfInt2);
    int[] arrayOfInt3 = g.h();
    j0.j(arrayOfInt2, arrayOfInt3);
    boolean bool = localk02.h();
    Object localObject3 = localk02.h;
    Object localObject4 = localObject3;
    if (!bool)
    {
      j0.j((int[])localObject3, (int[])localObject2);
      localObject4 = localObject2;
    }
    j0.m(localk01.h, (int[])localObject4, arrayOfInt1);
    j0.a(localk01.h, (int[])localObject4, (int[])localObject2);
    j0.e((int[])localObject2, arrayOfInt1, (int[])localObject2);
    j0.i(g.b((int[])localObject2, (int[])localObject2, (int[])localObject2), (int[])localObject2);
    j0.e(arrayOfInt2, localk01.h, arrayOfInt2);
    j0.i(m.G(8, arrayOfInt2, 2, 0), arrayOfInt2);
    j0.i(m.H(8, arrayOfInt3, 3, 0, arrayOfInt1), arrayOfInt1);
    localObject4 = new k0(arrayOfInt3);
    j0.j((int[])localObject2, ((k0)localObject4).h);
    localObject3 = ((k0)localObject4).h;
    j0.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = ((k0)localObject4).h;
    j0.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = new k0(arrayOfInt2);
    j0.m(arrayOfInt2, ((k0)localObject4).h, ((k0)localObject3).h);
    arrayOfInt2 = ((k0)localObject3).h;
    j0.e(arrayOfInt2, (int[])localObject2, arrayOfInt2);
    arrayOfInt2 = ((k0)localObject3).h;
    j0.m(arrayOfInt2, arrayOfInt1, arrayOfInt2);
    localObject2 = new k0((int[])localObject2);
    j0.n(((k0)localObject1).h, ((k0)localObject2).h);
    if (!bool)
    {
      localObject1 = ((k0)localObject2).h;
      j0.e((int[])localObject1, localk02.h, (int[])localObject1);
    }
    bool = this.f;
    return new l0(locald, (e)localObject4, (e)localObject3, new e[] { localObject2 }, bool);
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
    Object localObject1 = (k0)this.c;
    Object localObject2 = (k0)this.d;
    Object localObject3 = (k0)paramh.q();
    Object localObject4 = (k0)paramh.r();
    k0 localk01 = (k0)this.e[0];
    k0 localk02 = (k0)paramh.s(0);
    int[] arrayOfInt1 = g.j();
    int[] arrayOfInt2 = g.h();
    int[] arrayOfInt3 = g.h();
    int[] arrayOfInt4 = g.h();
    boolean bool1 = localk01.h();
    if (bool1)
    {
      paramh = ((k0)localObject3).h;
      localObject4 = ((k0)localObject4).h;
    }
    else
    {
      j0.j(localk01.h, arrayOfInt3);
      j0.e(arrayOfInt3, ((k0)localObject3).h, arrayOfInt2);
      j0.e(arrayOfInt3, localk01.h, arrayOfInt3);
      j0.e(arrayOfInt3, ((k0)localObject4).h, arrayOfInt3);
      paramh = arrayOfInt2;
      localObject4 = arrayOfInt3;
    }
    boolean bool2 = localk02.h();
    if (bool2)
    {
      localObject1 = ((k0)localObject1).h;
      localObject2 = ((k0)localObject2).h;
    }
    else
    {
      j0.j(localk02.h, arrayOfInt4);
      j0.e(arrayOfInt4, ((k0)localObject1).h, arrayOfInt1);
      j0.e(arrayOfInt4, localk02.h, arrayOfInt4);
      j0.e(arrayOfInt4, ((k0)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject3 = g.h();
    j0.m((int[])localObject1, paramh, (int[])localObject3);
    j0.m((int[])localObject2, (int[])localObject4, arrayOfInt2);
    if (g.v((int[])localObject3))
    {
      if (g.v(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    j0.j((int[])localObject3, arrayOfInt3);
    localObject4 = g.h();
    j0.e(arrayOfInt3, (int[])localObject3, (int[])localObject4);
    j0.e(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    j0.g((int[])localObject4, (int[])localObject4);
    g.y((int[])localObject2, (int[])localObject4, arrayOfInt1);
    j0.i(g.b(arrayOfInt3, arrayOfInt3, (int[])localObject4), (int[])localObject4);
    paramh = new k0(arrayOfInt4);
    j0.j(arrayOfInt2, paramh.h);
    localObject2 = paramh.h;
    j0.m((int[])localObject2, (int[])localObject4, (int[])localObject2);
    localObject4 = new k0((int[])localObject4);
    j0.m(arrayOfInt3, paramh.h, ((k0)localObject4).h);
    j0.f(((k0)localObject4).h, arrayOfInt2, arrayOfInt1);
    j0.h(arrayOfInt1, ((k0)localObject4).h);
    localObject2 = new k0((int[])localObject3);
    if (!bool1)
    {
      localObject1 = ((k0)localObject2).h;
      j0.e((int[])localObject1, localk01.h, (int[])localObject1);
    }
    if (!bool2)
    {
      localObject1 = ((k0)localObject2).h;
      j0.e((int[])localObject1, localk02.h, (int[])localObject1);
    }
    bool1 = this.f;
    return new l0(locald, paramh, (e)localObject4, new e[] { localObject2 }, bool1);
  }
  
  protected h d()
  {
    return new l0(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new l0(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\l0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */