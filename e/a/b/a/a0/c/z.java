package e.a.b.a.a0.c;

import e.a.b.a.d;
import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.f;
import e.a.b.c.m;

public class z
  extends h.c
{
  public z(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, false);
  }
  
  public z(d paramd, e parame1, e parame2, boolean paramBoolean)
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
  
  z(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
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
    Object localObject1 = (y)this.d;
    if (((y)localObject1).i()) {
      return locald.u();
    }
    Object localObject2 = (y)this.c;
    y localy = (y)this.e[0];
    int[] arrayOfInt = f.e();
    x.i(((y)localObject1).i, arrayOfInt);
    Object localObject3 = f.e();
    x.i(arrayOfInt, (int[])localObject3);
    Object localObject4 = f.e();
    x.i(((y)localObject2).i, (int[])localObject4);
    x.h(f.b((int[])localObject4, (int[])localObject4, (int[])localObject4), (int[])localObject4);
    x.d(arrayOfInt, ((y)localObject2).i, arrayOfInt);
    x.h(m.G(7, arrayOfInt, 2, 0), arrayOfInt);
    localObject2 = f.e();
    x.h(m.H(7, (int[])localObject3, 3, 0, (int[])localObject2), (int[])localObject2);
    localObject3 = new y((int[])localObject3);
    x.i((int[])localObject4, ((y)localObject3).i);
    Object localObject5 = ((y)localObject3).i;
    x.k((int[])localObject5, arrayOfInt, (int[])localObject5);
    localObject5 = ((y)localObject3).i;
    x.k((int[])localObject5, arrayOfInt, (int[])localObject5);
    localObject5 = new y(arrayOfInt);
    x.k(arrayOfInt, ((y)localObject3).i, ((y)localObject5).i);
    arrayOfInt = ((y)localObject5).i;
    x.d(arrayOfInt, (int[])localObject4, arrayOfInt);
    arrayOfInt = ((y)localObject5).i;
    x.k(arrayOfInt, (int[])localObject2, arrayOfInt);
    localObject4 = new y((int[])localObject4);
    x.l(((y)localObject1).i, ((y)localObject4).i);
    if (!localy.h())
    {
      localObject1 = ((y)localObject4).i;
      x.d((int[])localObject1, localy.i, (int[])localObject1);
    }
    boolean bool = this.f;
    return new z(locald, (e)localObject3, (e)localObject5, new e[] { localObject4 }, bool);
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
    Object localObject1 = (y)this.c;
    Object localObject2 = (y)this.d;
    Object localObject3 = (y)paramh.q();
    Object localObject4 = (y)paramh.r();
    y localy1 = (y)this.e[0];
    y localy2 = (y)paramh.s(0);
    int[] arrayOfInt1 = f.f();
    int[] arrayOfInt2 = f.e();
    int[] arrayOfInt3 = f.e();
    int[] arrayOfInt4 = f.e();
    boolean bool1 = localy1.h();
    if (bool1)
    {
      localObject3 = ((y)localObject3).i;
      paramh = ((y)localObject4).i;
    }
    else
    {
      x.i(localy1.i, arrayOfInt3);
      x.d(arrayOfInt3, ((y)localObject3).i, arrayOfInt2);
      x.d(arrayOfInt3, localy1.i, arrayOfInt3);
      x.d(arrayOfInt3, ((y)localObject4).i, arrayOfInt3);
      localObject3 = arrayOfInt2;
      paramh = arrayOfInt3;
    }
    boolean bool2 = localy2.h();
    if (bool2)
    {
      localObject1 = ((y)localObject1).i;
      localObject2 = ((y)localObject2).i;
    }
    else
    {
      x.i(localy2.i, arrayOfInt4);
      x.d(arrayOfInt4, ((y)localObject1).i, arrayOfInt1);
      x.d(arrayOfInt4, localy2.i, arrayOfInt4);
      x.d(arrayOfInt4, ((y)localObject2).i, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject4 = f.e();
    x.k((int[])localObject1, (int[])localObject3, (int[])localObject4);
    x.k((int[])localObject2, paramh, arrayOfInt2);
    if (f.l((int[])localObject4))
    {
      if (f.l(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    x.i((int[])localObject4, arrayOfInt3);
    localObject3 = f.e();
    x.d(arrayOfInt3, (int[])localObject4, (int[])localObject3);
    x.d(arrayOfInt3, (int[])localObject1, arrayOfInt3);
    x.f((int[])localObject3, (int[])localObject3);
    f.m((int[])localObject2, (int[])localObject3, arrayOfInt1);
    x.h(f.b(arrayOfInt3, arrayOfInt3, (int[])localObject3), (int[])localObject3);
    paramh = new y(arrayOfInt4);
    x.i(arrayOfInt2, paramh.i);
    localObject2 = paramh.i;
    x.k((int[])localObject2, (int[])localObject3, (int[])localObject2);
    localObject3 = new y((int[])localObject3);
    x.k(arrayOfInt3, paramh.i, ((y)localObject3).i);
    x.e(((y)localObject3).i, arrayOfInt2, arrayOfInt1);
    x.g(arrayOfInt1, ((y)localObject3).i);
    localObject2 = new y((int[])localObject4);
    if (!bool1)
    {
      localObject1 = ((y)localObject2).i;
      x.d((int[])localObject1, localy1.i, (int[])localObject1);
    }
    if (!bool2)
    {
      localObject1 = ((y)localObject2).i;
      x.d((int[])localObject1, localy2.i, (int[])localObject1);
    }
    bool2 = this.f;
    return new z(locald, paramh, (e)localObject3, new e[] { localObject2 }, bool2);
  }
  
  protected h d()
  {
    return new z(null, f(), g());
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new z(this.b, this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */