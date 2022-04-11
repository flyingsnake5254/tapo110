package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.s.c.a.b;
import com.airbnb.lottie.s.c.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class p
  implements e, m, j, a.b, k
{
  private final Matrix a = new Matrix();
  private final Path b = new Path();
  private final f c;
  private final com.airbnb.lottie.model.layer.a d;
  private final String e;
  private final boolean f;
  private final com.airbnb.lottie.s.c.a<Float, Float> g;
  private final com.airbnb.lottie.s.c.a<Float, Float> h;
  private final o i;
  private d j;
  
  public p(f paramf, com.airbnb.lottie.model.layer.a parama, com.airbnb.lottie.model.content.g paramg)
  {
    this.c = paramf;
    this.d = parama;
    this.e = paramg.c();
    this.f = paramg.f();
    paramf = paramg.b().a();
    this.g = paramf;
    parama.i(paramf);
    paramf.a(this);
    paramf = paramg.d().a();
    this.h = paramf;
    parama.i(paramf);
    paramf.a(this);
    paramf = paramg.e().b();
    this.i = paramf;
    paramf.a(parama);
    paramf.b(this);
  }
  
  public void a()
  {
    this.c.invalidateSelf();
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    this.j.b(paramList1, paramList2);
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    if (this.i.c(paramT, paramc)) {
      return;
    }
    if (paramT == com.airbnb.lottie.k.q) {
      this.g.m(paramc);
    } else if (paramT == com.airbnb.lottie.k.r) {
      this.h.m(paramc);
    }
  }
  
  public void d(com.airbnb.lottie.model.d paramd1, int paramInt, List<com.airbnb.lottie.model.d> paramList, com.airbnb.lottie.model.d paramd2)
  {
    com.airbnb.lottie.v.g.l(paramd1, paramInt, paramList, paramd2, this);
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    this.j.e(paramRectF, paramMatrix, paramBoolean);
  }
  
  public void f(ListIterator<c> paramListIterator)
  {
    if (this.j != null) {
      return;
    }
    while ((paramListIterator.hasPrevious()) && (paramListIterator.previous() != this)) {}
    ArrayList localArrayList = new ArrayList();
    while (paramListIterator.hasPrevious())
    {
      localArrayList.add(paramListIterator.previous());
      paramListIterator.remove();
    }
    Collections.reverse(localArrayList);
    this.j = new d(this.c, this.d, "Repeater", this.f, localArrayList, null);
  }
  
  public void g(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    float f1 = ((Float)this.g.h()).floatValue();
    float f2 = ((Float)this.h.h()).floatValue();
    float f3 = ((Float)this.i.i().h()).floatValue() / 100.0F;
    float f4 = ((Float)this.i.e().h()).floatValue() / 100.0F;
    for (int k = (int)f1 - 1; k >= 0; k--)
    {
      this.a.set(paramMatrix);
      Matrix localMatrix = this.a;
      o localo = this.i;
      float f5 = k;
      localMatrix.preConcat(localo.g(f5 + f2));
      float f6 = paramInt;
      f5 = com.airbnb.lottie.v.g.j(f3, f4, f5 / f1);
      this.j.g(paramCanvas, this.a, (int)(f6 * f5));
    }
  }
  
  public String getName()
  {
    return this.e;
  }
  
  public Path getPath()
  {
    Path localPath = this.j.getPath();
    this.b.reset();
    float f1 = ((Float)this.g.h()).floatValue();
    float f2 = ((Float)this.h.h()).floatValue();
    for (int k = (int)f1 - 1; k >= 0; k--)
    {
      this.a.set(this.i.g(k + f2));
      this.b.addPath(localPath, this.a);
    }
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */