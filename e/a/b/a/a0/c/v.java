package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.m;

public class v
  extends h.c
{
  public v(d paramd, e.a.b.a.e parame1, e.a.b.a.e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public v(d paramd, e.a.b.a.e parame1, e.a.b.a.e parame2, boolean paramBoolean)
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
  
  v(d paramd, e.a.b.a.e parame1, e.a.b.a.e parame2, e.a.b.a.e[] paramArrayOfe, boolean paramBoolean)
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
    Object localObject1 = (u)this.d;
    if (((u)localObject1).i()) {
      return locald.u();
    }
    u localu1 = (u)this.c;
    u localu2 = (u)this.e[0];
    int[] arrayOfInt1 = e.a.b.c.e.g();
    Object localObject2 = e.a.b.c.e.g();
    int[] arrayOfInt2 = e.a.b.c.e.g();
    t.j(((u)localObject1).h, arrayOfInt2);
    int[] arrayOfInt3 = e.a.b.c.e.g();
    t.j(arrayOfInt2, arrayOfInt3);
    boolean bool = localu2.h();
    Object localObject3 = localu2.h;
    Object localObject4 = localObject3;
    if (!bool)
    {
      t.j((int[])localObject3, (int[])localObject2);
      localObject4 = localObject2;
    }
    t.m(localu1.h, (int[])localObject4, arrayOfInt1);
    t.a(localu1.h, (int[])localObject4, (int[])localObject2);
    t.e((int[])localObject2, arrayOfInt1, (int[])localObject2);
    t.i(e.a.b.c.e.b((int[])localObject2, (int[])localObject2, (int[])localObject2), (int[])localObject2);
    t.e(arrayOfInt2, localu1.h, arrayOfInt2);
    t.i(m.G(6, arrayOfInt2, 2, 0), arrayOfInt2);
    t.i(m.H(6, arrayOfInt3, 3, 0, arrayOfInt1), arrayOfInt1);
    localObject4 = new u(arrayOfInt3);
    t.j((int[])localObject2, ((u)localObject4).h);
    localObject3 = ((u)localObject4).h;
    t.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = ((u)localObject4).h;
    t.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = new u(arrayOfInt2);
    t.m(arrayOfInt2, ((u)localObject4).h, ((u)localObject3).h);
    arrayOfInt2 = ((u)localObject3).h;
    t.e(arrayOfInt2, (int[])localObject2, arrayOfInt2);
    arrayOfInt2 = ((u)localObject3).h;
    t.m(arrayOfInt2, arrayOfInt1, arrayOfInt2);
    localObject2 = new u((int[])localObject2);
    t.n(((u)localObject1).h, ((u)localObject2).h);
    if (!bool)
    {
      localObject1 = ((u)localObject2).h;
      t.e((int[])localObject1, localu2.h, (int[])localObject1);
    }
    bool = this.f;
    return new v(locald, (e.a.b.a.e)localObject4, (e.a.b.a.e)localObject3, new e.a.b.a.e[] { localObject2 }, bool);
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
    Object localObject1 = (u)this.c;
    Object localObject2 = (u)this.d;
    Object localObject3 = (u)paramh.q();
    Object localObject4 = (u)paramh.r();
    u localu1 = (u)this.e[0];
    u localu2 = (u)paramh.s(0);
    int[] arrayOfInt1 = e.a.b.c.e.i();
    int[] arrayOfInt2 = e.a.b.c.e.g();
    int[] arrayOfInt3 = e.a.b.c.e.g();
    int[] arrayOfInt4 = e.a.b.c.e.g();
    boolean bool1 = localu1.h();
    if (bool1)
    {
      localObject3 = ((u)localObject3).h;
      paramh = ((u)localObject4).h;
    }
    else
    {
      t.j(localu1.h, arrayOfInt3);
      t.e(arrayOfInt3, ((u)localObject3).h, arrayOfInt2);
      t.e(arrayOfInt3, localu1.h, arrayOfInt3);
      t.e(arrayOfInt3, ((u)localObject4).h, arrayOfInt3);
      localObject3 = arrayOfInt2;
      paramh = arrayOfInt3;
    }
    boolean bool2 = localu2.h();
    if (bool2)
    {
      localObject1 = ((u)localObject1).h;
      localObject2 = ((u)localObject2).h;
    }
    else
    {
      t.j(localu2.h, arrayOfInt4);
      t.e(arrayOfInt4, ((u)localObject1).h, arrayOfInt1);
      t.e(arrayOfInt4, localu2.h, arrayOfInt4);
      t.e(arrayOfInt4, ((u)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject4 = e.a.b.c.e.g();
    t.m((int[])localObject1, (int[])localObject3, (int[])localObject4);
    t.m((int[])localObject2, paramh, arrayOfInt2);
    if (e.a.b.c.e.u((int[])localObject4))
    {
      if (e.a.b.c.e.u(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    t.j((int[])localObject4, arrayOfInt3);
    localObject3 = e.a.b.c.e.g();
    t.e(arrayOfInt3, (int[])localObject4, (int[])localObject3);
    t.e(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    t.g((int[])localObject3, (int[])localObject3);
    e.a.b.c.e.x((int[])localObject2, (int[])localObject3, arrayOfInt1);
    t.i(e.a.b.c.e.b(arrayOfInt3, arrayOfInt3, (int[])localObject3), (int[])localObject3);
    paramh = new u(arrayOfInt4);
    t.j(arrayOfInt2, paramh.h);
    localObject1 = paramh.h;
    t.m((int[])localObject1, (int[])localObject3, (int[])localObject1);
    localObject3 = new u((int[])localObject3);
    t.m(arrayOfInt3, paramh.h, ((u)localObject3).h);
    t.f(((u)localObject3).h, arrayOfInt2, arrayOfInt1);
    t.h(arrayOfInt1, ((u)localObject3).h);
    localObject1 = new u((int[])localObject4);
    if (!bool1)
    {
      localObject2 = ((u)localObject1).h;
      t.e((int[])localObject2, localu1.h, (int[])localObject2);
    }
    if (!bool2)
    {
      localObject2 = ((u)localObject1).h;
      t.e((int[])localObject2, localu2.h, (int[])localObject2);
    }
    bool1 = this.f;
    return new v(locald, paramh, (e.a.b.a.e)localObject3, new e.a.b.a.e[] { localObject1 }, bool1);
  }
  
  protected h d()
  {
    return new v(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new v(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */