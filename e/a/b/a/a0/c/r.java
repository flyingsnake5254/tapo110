package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.m;

public class r
  extends h.c
{
  public r(d paramd, e.a.b.a.e parame1, e.a.b.a.e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public r(d paramd, e.a.b.a.e parame1, e.a.b.a.e parame2, boolean paramBoolean)
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
  
  r(d paramd, e.a.b.a.e parame1, e.a.b.a.e parame2, e.a.b.a.e[] paramArrayOfe, boolean paramBoolean)
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
    Object localObject1 = (q)this.d;
    if (((q)localObject1).i()) {
      return locald.u();
    }
    Object localObject2 = (q)this.c;
    q localq = (q)this.e[0];
    int[] arrayOfInt = e.a.b.c.e.g();
    p.i(((q)localObject1).h, arrayOfInt);
    Object localObject3 = e.a.b.c.e.g();
    p.i(arrayOfInt, (int[])localObject3);
    Object localObject4 = e.a.b.c.e.g();
    p.i(((q)localObject2).h, (int[])localObject4);
    p.h(e.a.b.c.e.b((int[])localObject4, (int[])localObject4, (int[])localObject4), (int[])localObject4);
    p.d(arrayOfInt, ((q)localObject2).h, arrayOfInt);
    p.h(m.G(6, arrayOfInt, 2, 0), arrayOfInt);
    localObject2 = e.a.b.c.e.g();
    p.h(m.H(6, (int[])localObject3, 3, 0, (int[])localObject2), (int[])localObject2);
    localObject3 = new q((int[])localObject3);
    p.i((int[])localObject4, ((q)localObject3).h);
    Object localObject5 = ((q)localObject3).h;
    p.k((int[])localObject5, arrayOfInt, (int[])localObject5);
    localObject5 = ((q)localObject3).h;
    p.k((int[])localObject5, arrayOfInt, (int[])localObject5);
    localObject5 = new q(arrayOfInt);
    p.k(arrayOfInt, ((q)localObject3).h, ((q)localObject5).h);
    arrayOfInt = ((q)localObject5).h;
    p.d(arrayOfInt, (int[])localObject4, arrayOfInt);
    arrayOfInt = ((q)localObject5).h;
    p.k(arrayOfInt, (int[])localObject2, arrayOfInt);
    localObject4 = new q((int[])localObject4);
    p.l(((q)localObject1).h, ((q)localObject4).h);
    if (!localq.h())
    {
      localObject1 = ((q)localObject4).h;
      p.d((int[])localObject1, localq.h, (int[])localObject1);
    }
    boolean bool = this.f;
    return new r(locald, (e.a.b.a.e)localObject3, (e.a.b.a.e)localObject5, new e.a.b.a.e[] { localObject4 }, bool);
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
    Object localObject1 = (q)this.c;
    Object localObject2 = (q)this.d;
    Object localObject3 = (q)paramh.q();
    Object localObject4 = (q)paramh.r();
    q localq1 = (q)this.e[0];
    q localq2 = (q)paramh.s(0);
    int[] arrayOfInt1 = e.a.b.c.e.i();
    int[] arrayOfInt2 = e.a.b.c.e.g();
    int[] arrayOfInt3 = e.a.b.c.e.g();
    int[] arrayOfInt4 = e.a.b.c.e.g();
    boolean bool1 = localq1.h();
    if (bool1)
    {
      paramh = ((q)localObject3).h;
      localObject4 = ((q)localObject4).h;
    }
    else
    {
      p.i(localq1.h, arrayOfInt3);
      p.d(arrayOfInt3, ((q)localObject3).h, arrayOfInt2);
      p.d(arrayOfInt3, localq1.h, arrayOfInt3);
      p.d(arrayOfInt3, ((q)localObject4).h, arrayOfInt3);
      paramh = arrayOfInt2;
      localObject4 = arrayOfInt3;
    }
    boolean bool2 = localq2.h();
    if (bool2)
    {
      localObject1 = ((q)localObject1).h;
      localObject2 = ((q)localObject2).h;
    }
    else
    {
      p.i(localq2.h, arrayOfInt4);
      p.d(arrayOfInt4, ((q)localObject1).h, arrayOfInt1);
      p.d(arrayOfInt4, localq2.h, arrayOfInt4);
      p.d(arrayOfInt4, ((q)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject3 = e.a.b.c.e.g();
    p.k((int[])localObject1, paramh, (int[])localObject3);
    p.k((int[])localObject2, (int[])localObject4, arrayOfInt2);
    if (e.a.b.c.e.u((int[])localObject3))
    {
      if (e.a.b.c.e.u(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    p.i((int[])localObject3, arrayOfInt3);
    localObject4 = e.a.b.c.e.g();
    p.d(arrayOfInt3, (int[])localObject3, (int[])localObject4);
    p.d(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    p.f((int[])localObject4, (int[])localObject4);
    e.a.b.c.e.x((int[])localObject2, (int[])localObject4, arrayOfInt1);
    p.h(e.a.b.c.e.b(arrayOfInt3, arrayOfInt3, (int[])localObject4), (int[])localObject4);
    paramh = new q(arrayOfInt4);
    p.i(arrayOfInt2, paramh.h);
    localObject2 = paramh.h;
    p.k((int[])localObject2, (int[])localObject4, (int[])localObject2);
    localObject4 = new q((int[])localObject4);
    p.k(arrayOfInt3, paramh.h, ((q)localObject4).h);
    p.e(((q)localObject4).h, arrayOfInt2, arrayOfInt1);
    p.g(arrayOfInt1, ((q)localObject4).h);
    localObject2 = new q((int[])localObject3);
    if (!bool1)
    {
      localObject1 = ((q)localObject2).h;
      p.d((int[])localObject1, localq1.h, (int[])localObject1);
    }
    if (!bool2)
    {
      localObject1 = ((q)localObject2).h;
      p.d((int[])localObject1, localq2.h, (int[])localObject1);
    }
    bool2 = this.f;
    return new r(locald, paramh, (e.a.b.a.e)localObject4, new e.a.b.a.e[] { localObject2 }, bool2);
  }
  
  protected h d()
  {
    return new r(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new r(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */