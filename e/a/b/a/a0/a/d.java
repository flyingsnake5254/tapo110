package e.a.b.a.a0.a;

import e.a.b.a.e;
import e.a.b.a.h;
import e.a.b.a.h.c;
import e.a.b.c.g;

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
    if (u()) {
      return this;
    }
    if (this.d.i()) {
      return this;
    }
    return N(false).a(this);
  }
  
  public h J()
  {
    if (u()) {
      return this;
    }
    e.a.b.a.d locald = i();
    if (this.d.i()) {
      return locald.u();
    }
    return N(true);
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
    return N(false).a(paramh);
  }
  
  protected c L(c paramc, int[] paramArrayOfInt)
  {
    c localc1 = (c)i().o();
    if (paramc.h()) {
      return localc1;
    }
    c localc2 = new c();
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null)
    {
      arrayOfInt = localc2.i;
      b.j(paramc.i, arrayOfInt);
    }
    b.j(arrayOfInt, localc2.i);
    paramc = localc2.i;
    b.e(paramc, localc1.i, paramc);
    return localc2;
  }
  
  protected c M()
  {
    e[] arrayOfe = this.e;
    c localc1 = (c)arrayOfe[1];
    c localc2 = localc1;
    if (localc1 == null)
    {
      localc2 = L((c)arrayOfe[0], null);
      arrayOfe[1] = localc2;
    }
    return localc2;
  }
  
  protected d N(boolean paramBoolean)
  {
    Object localObject1 = (c)this.c;
    Object localObject2 = (c)this.d;
    c localc = (c)this.e[0];
    Object localObject3 = M();
    int[] arrayOfInt1 = g.h();
    b.j(((c)localObject1).i, arrayOfInt1);
    b.i(g.b(arrayOfInt1, arrayOfInt1, arrayOfInt1) + g.d(((c)localObject3).i, arrayOfInt1), arrayOfInt1);
    Object localObject4 = g.h();
    b.o(((c)localObject2).i, (int[])localObject4);
    Object localObject5 = g.h();
    b.e((int[])localObject4, ((c)localObject2).i, (int[])localObject5);
    int[] arrayOfInt2 = g.h();
    b.e((int[])localObject5, ((c)localObject1).i, arrayOfInt2);
    b.o(arrayOfInt2, arrayOfInt2);
    localObject2 = g.h();
    b.j((int[])localObject5, (int[])localObject2);
    b.o((int[])localObject2, (int[])localObject2);
    localObject5 = new c((int[])localObject5);
    b.j(arrayOfInt1, ((c)localObject5).i);
    localObject1 = ((c)localObject5).i;
    b.n((int[])localObject1, arrayOfInt2, (int[])localObject1);
    localObject1 = ((c)localObject5).i;
    b.n((int[])localObject1, arrayOfInt2, (int[])localObject1);
    localObject1 = new c(arrayOfInt2);
    b.n(arrayOfInt2, ((c)localObject5).i, ((c)localObject1).i);
    arrayOfInt2 = ((c)localObject1).i;
    b.e(arrayOfInt2, arrayOfInt1, arrayOfInt2);
    arrayOfInt1 = ((c)localObject1).i;
    b.n(arrayOfInt1, (int[])localObject2, arrayOfInt1);
    localObject4 = new c((int[])localObject4);
    if (!g.t(localc.i))
    {
      arrayOfInt1 = ((c)localObject4).i;
      b.e(arrayOfInt1, localc.i, arrayOfInt1);
    }
    localc = null;
    if (paramBoolean)
    {
      localc = new c((int[])localObject2);
      localObject2 = localc.i;
      b.e((int[])localObject2, ((c)localObject3).i, (int[])localObject2);
      localObject3 = localc.i;
      b.o((int[])localObject3, (int[])localObject3);
    }
    localObject3 = i();
    paramBoolean = this.f;
    return new d((e.a.b.a.d)localObject3, (e)localObject5, (e)localObject1, new e[] { localObject4, localc }, paramBoolean);
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
    c localc1 = (c)this.e[0];
    Object localObject3 = (c)paramh.q();
    Object localObject4 = (c)paramh.r();
    c localc2 = (c)paramh.s(0);
    int[] arrayOfInt1 = g.j();
    int[] arrayOfInt2 = g.h();
    int[] arrayOfInt3 = g.h();
    int[] arrayOfInt4 = g.h();
    boolean bool1 = localc1.h();
    if (bool1)
    {
      paramh = ((c)localObject3).i;
      localObject4 = ((c)localObject4).i;
    }
    else
    {
      b.j(localc1.i, arrayOfInt3);
      b.e(arrayOfInt3, ((c)localObject3).i, arrayOfInt2);
      b.e(arrayOfInt3, localc1.i, arrayOfInt3);
      b.e(arrayOfInt3, ((c)localObject4).i, arrayOfInt3);
      paramh = arrayOfInt2;
      localObject4 = arrayOfInt3;
    }
    boolean bool2 = localc2.h();
    if (bool2)
    {
      localObject1 = ((c)localObject1).i;
      localObject2 = ((c)localObject2).i;
    }
    else
    {
      b.j(localc2.i, arrayOfInt4);
      b.e(arrayOfInt4, ((c)localObject1).i, arrayOfInt1);
      b.e(arrayOfInt4, localc2.i, arrayOfInt4);
      b.e(arrayOfInt4, ((c)localObject2).i, arrayOfInt4);
      localObject1 = arrayOfInt1;
      localObject2 = arrayOfInt4;
    }
    localObject3 = g.h();
    b.n((int[])localObject1, paramh, (int[])localObject3);
    b.n((int[])localObject2, (int[])localObject4, arrayOfInt2);
    if (g.v((int[])localObject3))
    {
      if (g.v(arrayOfInt2)) {
        return J();
      }
      return locald.u();
    }
    paramh = g.h();
    b.j((int[])localObject3, paramh);
    int[] arrayOfInt5 = g.h();
    b.e(paramh, (int[])localObject3, arrayOfInt5);
    b.e(paramh, (int[])localObject1, arrayOfInt3);
    b.g(arrayOfInt5, arrayOfInt5);
    g.y((int[])localObject2, arrayOfInt5, arrayOfInt1);
    b.i(g.b(arrayOfInt3, arrayOfInt3, arrayOfInt5), arrayOfInt5);
    localObject4 = new c(arrayOfInt4);
    b.j(arrayOfInt2, ((c)localObject4).i);
    localObject2 = ((c)localObject4).i;
    b.n((int[])localObject2, arrayOfInt5, (int[])localObject2);
    localObject2 = new c(arrayOfInt5);
    b.n(arrayOfInt3, ((c)localObject4).i, ((c)localObject2).i);
    b.f(((c)localObject2).i, arrayOfInt2, arrayOfInt1);
    b.h(arrayOfInt1, ((c)localObject2).i);
    localObject1 = new c((int[])localObject3);
    if (!bool1)
    {
      arrayOfInt2 = ((c)localObject1).i;
      b.e(arrayOfInt2, localc1.i, arrayOfInt2);
    }
    if (!bool2)
    {
      arrayOfInt2 = ((c)localObject1).i;
      b.e(arrayOfInt2, localc2.i, arrayOfInt2);
    }
    if ((!bool1) || (!bool2)) {
      paramh = null;
    }
    paramh = L((c)localObject1, paramh);
    bool2 = this.f;
    return new d(locald, (e)localObject4, (e)localObject2, new e[] { localObject1, paramh }, bool2);
  }
  
  protected h d()
  {
    return new d(null, f(), g());
  }
  
  public e s(int paramInt)
  {
    if (paramInt == 1) {
      return M();
    }
    return super.s(paramInt);
  }
  
  public h z()
  {
    if (u()) {
      return this;
    }
    return new d(i(), this.c, this.d.m(), this.e, this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */