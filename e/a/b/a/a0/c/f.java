package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.c;

public class f
  extends h.c
{
  public f(e.a.b.a.d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public f(e.a.b.a.d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  f(e.a.b.a.d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
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
    Object localObject1 = (m)this.d;
    if (((m)localObject1).i()) {
      return locald.u();
    }
    Object localObject2 = (m)this.c;
    m localm = (m)this.e[0];
    int[] arrayOfInt = e.a.b.c.d.d();
    l.i(((m)localObject1).h, arrayOfInt);
    Object localObject3 = e.a.b.c.d.d();
    l.i(arrayOfInt, (int[])localObject3);
    Object localObject4 = e.a.b.c.d.d();
    l.i(((m)localObject2).h, (int[])localObject4);
    l.h(e.a.b.c.d.b((int[])localObject4, (int[])localObject4, (int[])localObject4), (int[])localObject4);
    l.d(arrayOfInt, ((m)localObject2).h, arrayOfInt);
    l.h(e.a.b.c.m.G(5, arrayOfInt, 2, 0), arrayOfInt);
    localObject2 = e.a.b.c.d.d();
    l.h(e.a.b.c.m.H(5, (int[])localObject3, 3, 0, (int[])localObject2), (int[])localObject2);
    localObject3 = new m((int[])localObject3);
    l.i((int[])localObject4, ((m)localObject3).h);
    Object localObject5 = ((m)localObject3).h;
    l.k((int[])localObject5, arrayOfInt, (int[])localObject5);
    localObject5 = ((m)localObject3).h;
    l.k((int[])localObject5, arrayOfInt, (int[])localObject5);
    localObject5 = new m(arrayOfInt);
    l.k(arrayOfInt, ((m)localObject3).h, ((m)localObject5).h);
    arrayOfInt = ((m)localObject5).h;
    l.d(arrayOfInt, (int[])localObject4, arrayOfInt);
    arrayOfInt = ((m)localObject5).h;
    l.k(arrayOfInt, (int[])localObject2, arrayOfInt);
    localObject4 = new m((int[])localObject4);
    l.l(((m)localObject1).h, ((m)localObject4).h);
    if (!localm.h())
    {
      localObject1 = ((m)localObject4).h;
      l.d((int[])localObject1, localm.h, (int[])localObject1);
    }
    boolean bool = this.f;
    return new f(locald, (e)localObject3, (e)localObject5, new e[] { localObject4 }, bool);
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
    Object localObject1 = (m)this.c;
    Object localObject2 = (m)this.d;
    Object localObject3 = (m)paramh.q();
    Object localObject4 = (m)paramh.r();
    m localm1 = (m)this.e[0];
    m localm2 = (m)paramh.s(0);
    int[] arrayOfInt1 = e.a.b.c.d.e();
    int[] arrayOfInt2 = e.a.b.c.d.d();
    int[] arrayOfInt3 = e.a.b.c.d.d();
    int[] arrayOfInt4 = e.a.b.c.d.d();
    boolean bool1 = localm1.h();
    if (bool1)
    {
      localObject3 = ((m)localObject3).h;
      paramh = ((m)localObject4).h;
    }
    else
    {
      l.i(localm1.h, arrayOfInt3);
      l.d(arrayOfInt3, ((m)localObject3).h, arrayOfInt2);
      l.d(arrayOfInt3, localm1.h, arrayOfInt3);
      l.d(arrayOfInt3, ((m)localObject4).h, arrayOfInt3);
      localObject3 = arrayOfInt2;
      paramh = arrayOfInt3;
    }
    boolean bool2 = localm2.h();
    if (bool2)
    {
      localObject1 = ((m)localObject1).h;
      localObject2 = ((m)localObject2).h;
    }
    else
    {
      l.i(localm2.h, arrayOfInt4);
      l.d(arrayOfInt4, ((m)localObject1).h, arrayOfInt1);
      l.d(arrayOfInt4, localm2.h, arrayOfInt4);
      l.d(arrayOfInt4, ((m)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject4 = e.a.b.c.d.d();
    l.k((int[])localObject1, (int[])localObject3, (int[])localObject4);
    l.k((int[])localObject2, paramh, arrayOfInt2);
    if (e.a.b.c.d.k((int[])localObject4))
    {
      if (e.a.b.c.d.k(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    l.i((int[])localObject4, arrayOfInt3);
    localObject3 = e.a.b.c.d.d();
    l.d(arrayOfInt3, (int[])localObject4, (int[])localObject3);
    l.d(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    l.f((int[])localObject3, (int[])localObject3);
    e.a.b.c.d.l((int[])localObject2, (int[])localObject3, arrayOfInt1);
    l.h(e.a.b.c.d.b(arrayOfInt3, arrayOfInt3, (int[])localObject3), (int[])localObject3);
    paramh = new m(arrayOfInt4);
    l.i(arrayOfInt2, paramh.h);
    localObject2 = paramh.h;
    l.k((int[])localObject2, (int[])localObject3, (int[])localObject2);
    localObject3 = new m((int[])localObject3);
    l.k(arrayOfInt3, paramh.h, ((m)localObject3).h);
    l.e(((m)localObject3).h, arrayOfInt2, arrayOfInt1);
    l.g(arrayOfInt1, ((m)localObject3).h);
    localObject2 = new m((int[])localObject4);
    if (!bool1)
    {
      localObject1 = ((m)localObject2).h;
      l.d((int[])localObject1, localm1.h, (int[])localObject1);
    }
    if (!bool2)
    {
      localObject1 = ((m)localObject2).h;
      l.d((int[])localObject1, localm2.h, (int[])localObject1);
    }
    bool1 = this.f;
    return new f(locald, paramh, (e)localObject3, new e[] { localObject2 }, bool1);
  }
  
  protected h d()
  {
    return new f(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new f(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */