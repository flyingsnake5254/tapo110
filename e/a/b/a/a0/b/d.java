package e.a.b.a.a0.b;

import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.g;
import e.a.b.c.m;

public class d
  extends h.c
{
  public d(e.a.b.a.d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public d(e.a.b.a.d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  d(e.a.b.a.d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
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
    e.a.b.a.d locald = i();
    Object localObject1 = (c)this.d;
    if (((c)localObject1).i()) {
      return locald.u();
    }
    c localc1 = (c)this.c;
    c localc2 = (c)this.e[0];
    int[] arrayOfInt1 = g.h();
    Object localObject2 = g.h();
    int[] arrayOfInt2 = g.h();
    b.j(((c)localObject1).h, arrayOfInt2);
    int[] arrayOfInt3 = g.h();
    b.j(arrayOfInt2, arrayOfInt3);
    boolean bool = localc2.h();
    Object localObject3 = localc2.h;
    Object localObject4 = localObject3;
    if (!bool)
    {
      b.j((int[])localObject3, (int[])localObject2);
      localObject4 = localObject2;
    }
    b.m(localc1.h, (int[])localObject4, arrayOfInt1);
    b.a(localc1.h, (int[])localObject4, (int[])localObject2);
    b.e((int[])localObject2, arrayOfInt1, (int[])localObject2);
    b.i(g.b((int[])localObject2, (int[])localObject2, (int[])localObject2), (int[])localObject2);
    b.e(arrayOfInt2, localc1.h, arrayOfInt2);
    b.i(m.G(8, arrayOfInt2, 2, 0), arrayOfInt2);
    b.i(m.H(8, arrayOfInt3, 3, 0, arrayOfInt1), arrayOfInt1);
    localObject4 = new c(arrayOfInt3);
    b.j((int[])localObject2, ((c)localObject4).h);
    localObject3 = ((c)localObject4).h;
    b.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = ((c)localObject4).h;
    b.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = new c(arrayOfInt2);
    b.m(arrayOfInt2, ((c)localObject4).h, ((c)localObject3).h);
    arrayOfInt2 = ((c)localObject3).h;
    b.e(arrayOfInt2, (int[])localObject2, arrayOfInt2);
    arrayOfInt2 = ((c)localObject3).h;
    b.m(arrayOfInt2, arrayOfInt1, arrayOfInt2);
    localObject2 = new c((int[])localObject2);
    b.n(((c)localObject1).h, ((c)localObject2).h);
    if (!bool)
    {
      localObject1 = ((c)localObject2).h;
      b.e((int[])localObject1, localc2.h, (int[])localObject1);
    }
    bool = this.f;
    return new d(locald, (e)localObject4, (e)localObject3, new e[] { localObject2 }, bool);
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
    e.a.b.a.d locald = i();
    Object localObject1 = (c)this.c;
    Object localObject2 = (c)this.d;
    Object localObject3 = (c)paramh.q();
    Object localObject4 = (c)paramh.r();
    c localc1 = (c)this.e[0];
    c localc2 = (c)paramh.s(0);
    int[] arrayOfInt1 = g.j();
    int[] arrayOfInt2 = g.h();
    int[] arrayOfInt3 = g.h();
    int[] arrayOfInt4 = g.h();
    boolean bool1 = localc1.h();
    if (bool1)
    {
      paramh = ((c)localObject3).h;
      localObject4 = ((c)localObject4).h;
    }
    else
    {
      b.j(localc1.h, arrayOfInt3);
      b.e(arrayOfInt3, ((c)localObject3).h, arrayOfInt2);
      b.e(arrayOfInt3, localc1.h, arrayOfInt3);
      b.e(arrayOfInt3, ((c)localObject4).h, arrayOfInt3);
      paramh = arrayOfInt2;
      localObject4 = arrayOfInt3;
    }
    boolean bool2 = localc2.h();
    if (bool2)
    {
      localObject1 = ((c)localObject1).h;
      localObject2 = ((c)localObject2).h;
    }
    else
    {
      b.j(localc2.h, arrayOfInt4);
      b.e(arrayOfInt4, ((c)localObject1).h, arrayOfInt1);
      b.e(arrayOfInt4, localc2.h, arrayOfInt4);
      b.e(arrayOfInt4, ((c)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject3 = g.h();
    b.m((int[])localObject1, paramh, (int[])localObject3);
    b.m((int[])localObject2, (int[])localObject4, arrayOfInt2);
    if (g.v((int[])localObject3))
    {
      if (g.v(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    b.j((int[])localObject3, arrayOfInt3);
    localObject4 = g.h();
    b.e(arrayOfInt3, (int[])localObject3, (int[])localObject4);
    b.e(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    b.g((int[])localObject4, (int[])localObject4);
    g.y((int[])localObject2, (int[])localObject4, arrayOfInt1);
    b.i(g.b(arrayOfInt3, arrayOfInt3, (int[])localObject4), (int[])localObject4);
    paramh = new c(arrayOfInt4);
    b.j(arrayOfInt2, paramh.h);
    localObject1 = paramh.h;
    b.m((int[])localObject1, (int[])localObject4, (int[])localObject1);
    localObject4 = new c((int[])localObject4);
    b.m(arrayOfInt3, paramh.h, ((c)localObject4).h);
    b.f(((c)localObject4).h, arrayOfInt2, arrayOfInt1);
    b.h(arrayOfInt1, ((c)localObject4).h);
    localObject1 = new c((int[])localObject3);
    if (!bool1)
    {
      localObject2 = ((c)localObject1).h;
      b.e((int[])localObject2, localc1.h, (int[])localObject2);
    }
    if (!bool2)
    {
      localObject2 = ((c)localObject1).h;
      b.e((int[])localObject2, localc2.h, (int[])localObject2);
    }
    bool1 = this.f;
    return new d(locald, paramh, (e)localObject4, new e[] { localObject1 }, bool1);
  }
  
  protected h d()
  {
    return new d(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new d(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */