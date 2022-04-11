package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.h.c;
import e.a.b.c.m;

public class j
  extends h.c
{
  public j(e.a.b.a.d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public j(e.a.b.a.d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  j(e.a.b.a.d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    super(paramd, parame1, parame2, paramArrayOfe);
    this.f = paramBoolean;
  }
  
  public e.a.b.a.h H()
  {
    if ((!u()) && (!this.d.i())) {
      return J().a(this);
    }
    return this;
  }
  
  public e.a.b.a.h J()
  {
    if (u()) {
      return this;
    }
    e.a.b.a.d locald = i();
    Object localObject1 = (i)this.d;
    if (((i)localObject1).i()) {
      return locald.u();
    }
    i locali1 = (i)this.c;
    i locali2 = (i)this.e[0];
    int[] arrayOfInt1 = e.a.b.c.d.d();
    Object localObject2 = e.a.b.c.d.d();
    int[] arrayOfInt2 = e.a.b.c.d.d();
    h.i(((i)localObject1).h, arrayOfInt2);
    int[] arrayOfInt3 = e.a.b.c.d.d();
    h.i(arrayOfInt2, arrayOfInt3);
    boolean bool = locali2.h();
    Object localObject3 = locali2.h;
    Object localObject4 = localObject3;
    if (!bool)
    {
      h.i((int[])localObject3, (int[])localObject2);
      localObject4 = localObject2;
    }
    h.k(locali1.h, (int[])localObject4, arrayOfInt1);
    h.a(locali1.h, (int[])localObject4, (int[])localObject2);
    h.d((int[])localObject2, arrayOfInt1, (int[])localObject2);
    h.h(e.a.b.c.d.b((int[])localObject2, (int[])localObject2, (int[])localObject2), (int[])localObject2);
    h.d(arrayOfInt2, locali1.h, arrayOfInt2);
    h.h(m.G(5, arrayOfInt2, 2, 0), arrayOfInt2);
    h.h(m.H(5, arrayOfInt3, 3, 0, arrayOfInt1), arrayOfInt1);
    localObject4 = new i(arrayOfInt3);
    h.i((int[])localObject2, ((i)localObject4).h);
    localObject3 = ((i)localObject4).h;
    h.k((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = ((i)localObject4).h;
    h.k((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = new i(arrayOfInt2);
    h.k(arrayOfInt2, ((i)localObject4).h, ((i)localObject3).h);
    arrayOfInt2 = ((i)localObject3).h;
    h.d(arrayOfInt2, (int[])localObject2, arrayOfInt2);
    arrayOfInt2 = ((i)localObject3).h;
    h.k(arrayOfInt2, arrayOfInt1, arrayOfInt2);
    localObject2 = new i((int[])localObject2);
    h.l(((i)localObject1).h, ((i)localObject2).h);
    if (!bool)
    {
      localObject1 = ((i)localObject2).h;
      h.d((int[])localObject1, locali2.h, (int[])localObject1);
    }
    bool = this.f;
    return new j(locald, (e)localObject4, (e)localObject3, new e[] { localObject2 }, bool);
  }
  
  public e.a.b.a.h K(e.a.b.a.h paramh)
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
  
  public e.a.b.a.h a(e.a.b.a.h paramh)
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
    Object localObject1 = (i)this.c;
    Object localObject2 = (i)this.d;
    Object localObject3 = (i)paramh.q();
    Object localObject4 = (i)paramh.r();
    i locali1 = (i)this.e[0];
    i locali2 = (i)paramh.s(0);
    int[] arrayOfInt1 = e.a.b.c.d.e();
    int[] arrayOfInt2 = e.a.b.c.d.d();
    int[] arrayOfInt3 = e.a.b.c.d.d();
    int[] arrayOfInt4 = e.a.b.c.d.d();
    boolean bool1 = locali1.h();
    if (bool1)
    {
      paramh = ((i)localObject3).h;
      localObject4 = ((i)localObject4).h;
    }
    else
    {
      h.i(locali1.h, arrayOfInt3);
      h.d(arrayOfInt3, ((i)localObject3).h, arrayOfInt2);
      h.d(arrayOfInt3, locali1.h, arrayOfInt3);
      h.d(arrayOfInt3, ((i)localObject4).h, arrayOfInt3);
      paramh = arrayOfInt2;
      localObject4 = arrayOfInt3;
    }
    boolean bool2 = locali2.h();
    if (bool2)
    {
      localObject1 = ((i)localObject1).h;
      localObject2 = ((i)localObject2).h;
    }
    else
    {
      h.i(locali2.h, arrayOfInt4);
      h.d(arrayOfInt4, ((i)localObject1).h, arrayOfInt1);
      h.d(arrayOfInt4, locali2.h, arrayOfInt4);
      h.d(arrayOfInt4, ((i)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject3 = e.a.b.c.d.d();
    h.k((int[])localObject1, paramh, (int[])localObject3);
    h.k((int[])localObject2, (int[])localObject4, arrayOfInt2);
    if (e.a.b.c.d.k((int[])localObject3))
    {
      if (e.a.b.c.d.k(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    h.i((int[])localObject3, arrayOfInt3);
    localObject4 = e.a.b.c.d.d();
    h.d(arrayOfInt3, (int[])localObject3, (int[])localObject4);
    h.d(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    h.f((int[])localObject4, (int[])localObject4);
    e.a.b.c.d.l((int[])localObject2, (int[])localObject4, arrayOfInt1);
    h.h(e.a.b.c.d.b(arrayOfInt3, arrayOfInt3, (int[])localObject4), (int[])localObject4);
    paramh = new i(arrayOfInt4);
    h.i(arrayOfInt2, paramh.h);
    localObject1 = paramh.h;
    h.k((int[])localObject1, (int[])localObject4, (int[])localObject1);
    localObject4 = new i((int[])localObject4);
    h.k(arrayOfInt3, paramh.h, ((i)localObject4).h);
    h.e(((i)localObject4).h, arrayOfInt2, arrayOfInt1);
    h.g(arrayOfInt1, ((i)localObject4).h);
    localObject1 = new i((int[])localObject3);
    if (!bool1)
    {
      localObject2 = ((i)localObject1).h;
      h.d((int[])localObject2, locali1.h, (int[])localObject2);
    }
    if (!bool2)
    {
      localObject2 = ((i)localObject1).h;
      h.d((int[])localObject2, locali2.h, (int[])localObject2);
    }
    bool2 = this.f;
    return new j(locald, paramh, (e)localObject4, new e[] { localObject1 }, bool2);
  }
  
  protected e.a.b.a.h d()
  {
    return new j(null, f(), g());
  }
  
  public e.a.b.a.h z()
  {
    if (u()) {
      return this;
    }
    return new j(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */