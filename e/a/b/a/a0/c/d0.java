package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.f;
import e.a.b.c.m;

public class d0
  extends h.c
{
  public d0(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public d0(d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  d0(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
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
    Object localObject1 = (c0)this.d;
    if (((c0)localObject1).i()) {
      return locald.u();
    }
    c0 localc01 = (c0)this.c;
    c0 localc02 = (c0)this.e[0];
    int[] arrayOfInt1 = f.e();
    Object localObject2 = f.e();
    int[] arrayOfInt2 = f.e();
    b0.j(((c0)localObject1).h, arrayOfInt2);
    int[] arrayOfInt3 = f.e();
    b0.j(arrayOfInt2, arrayOfInt3);
    boolean bool = localc02.h();
    Object localObject3 = localc02.h;
    Object localObject4 = localObject3;
    if (!bool)
    {
      b0.j((int[])localObject3, (int[])localObject2);
      localObject4 = localObject2;
    }
    b0.m(localc01.h, (int[])localObject4, arrayOfInt1);
    b0.a(localc01.h, (int[])localObject4, (int[])localObject2);
    b0.e((int[])localObject2, arrayOfInt1, (int[])localObject2);
    b0.i(f.b((int[])localObject2, (int[])localObject2, (int[])localObject2), (int[])localObject2);
    b0.e(arrayOfInt2, localc01.h, arrayOfInt2);
    b0.i(m.G(7, arrayOfInt2, 2, 0), arrayOfInt2);
    b0.i(m.H(7, arrayOfInt3, 3, 0, arrayOfInt1), arrayOfInt1);
    localObject4 = new c0(arrayOfInt3);
    b0.j((int[])localObject2, ((c0)localObject4).h);
    localObject3 = ((c0)localObject4).h;
    b0.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = ((c0)localObject4).h;
    b0.m((int[])localObject3, arrayOfInt2, (int[])localObject3);
    localObject3 = new c0(arrayOfInt2);
    b0.m(arrayOfInt2, ((c0)localObject4).h, ((c0)localObject3).h);
    arrayOfInt2 = ((c0)localObject3).h;
    b0.e(arrayOfInt2, (int[])localObject2, arrayOfInt2);
    arrayOfInt2 = ((c0)localObject3).h;
    b0.m(arrayOfInt2, arrayOfInt1, arrayOfInt2);
    localObject2 = new c0((int[])localObject2);
    b0.n(((c0)localObject1).h, ((c0)localObject2).h);
    if (!bool)
    {
      localObject1 = ((c0)localObject2).h;
      b0.e((int[])localObject1, localc02.h, (int[])localObject1);
    }
    bool = this.f;
    return new d0(locald, (e)localObject4, (e)localObject3, new e[] { localObject2 }, bool);
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
    Object localObject1 = (c0)this.c;
    Object localObject2 = (c0)this.d;
    Object localObject3 = (c0)paramh.q();
    Object localObject4 = (c0)paramh.r();
    c0 localc01 = (c0)this.e[0];
    c0 localc02 = (c0)paramh.s(0);
    int[] arrayOfInt1 = f.f();
    int[] arrayOfInt2 = f.e();
    int[] arrayOfInt3 = f.e();
    int[] arrayOfInt4 = f.e();
    boolean bool1 = localc01.h();
    if (bool1)
    {
      paramh = ((c0)localObject3).h;
      localObject4 = ((c0)localObject4).h;
    }
    else
    {
      b0.j(localc01.h, arrayOfInt3);
      b0.e(arrayOfInt3, ((c0)localObject3).h, arrayOfInt2);
      b0.e(arrayOfInt3, localc01.h, arrayOfInt3);
      b0.e(arrayOfInt3, ((c0)localObject4).h, arrayOfInt3);
      paramh = arrayOfInt2;
      localObject4 = arrayOfInt3;
    }
    boolean bool2 = localc02.h();
    if (bool2)
    {
      localObject1 = ((c0)localObject1).h;
      localObject2 = ((c0)localObject2).h;
    }
    else
    {
      b0.j(localc02.h, arrayOfInt4);
      b0.e(arrayOfInt4, ((c0)localObject1).h, arrayOfInt1);
      b0.e(arrayOfInt4, localc02.h, arrayOfInt4);
      b0.e(arrayOfInt4, ((c0)localObject2).h, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject3 = f.e();
    b0.m((int[])localObject1, paramh, (int[])localObject3);
    b0.m((int[])localObject2, (int[])localObject4, arrayOfInt2);
    if (f.l((int[])localObject3))
    {
      if (f.l(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    b0.j((int[])localObject3, arrayOfInt3);
    localObject4 = f.e();
    b0.e(arrayOfInt3, (int[])localObject3, (int[])localObject4);
    b0.e(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    b0.g((int[])localObject4, (int[])localObject4);
    f.m((int[])localObject2, (int[])localObject4, arrayOfInt1);
    b0.i(f.b(arrayOfInt3, arrayOfInt3, (int[])localObject4), (int[])localObject4);
    paramh = new c0(arrayOfInt4);
    b0.j(arrayOfInt2, paramh.h);
    localObject1 = paramh.h;
    b0.m((int[])localObject1, (int[])localObject4, (int[])localObject1);
    localObject4 = new c0((int[])localObject4);
    b0.m(arrayOfInt3, paramh.h, ((c0)localObject4).h);
    b0.f(((c0)localObject4).h, arrayOfInt2, arrayOfInt1);
    b0.h(arrayOfInt1, ((c0)localObject4).h);
    localObject1 = new c0((int[])localObject3);
    if (!bool1)
    {
      localObject2 = ((c0)localObject1).h;
      b0.e((int[])localObject2, localc01.h, (int[])localObject2);
    }
    if (!bool2)
    {
      localObject2 = ((c0)localObject1).h;
      b0.e((int[])localObject2, localc02.h, (int[])localObject2);
    }
    bool2 = this.f;
    return new d0(locald, paramh, (e)localObject4, new e[] { localObject1 }, bool2);
  }
  
  protected h d()
  {
    return new d0(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new d0(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */