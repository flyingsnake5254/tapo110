package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.v.g;
import com.airbnb.lottie.v.h;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements com.airbnb.lottie.s.c.a.b, k, e
{
  private final PathMeasure a = new PathMeasure();
  private final Path b = new Path();
  private final Path c = new Path();
  private final RectF d = new RectF();
  private final f e;
  protected final com.airbnb.lottie.model.layer.a f;
  private final List<b> g = new ArrayList();
  private final float[] h;
  final Paint i;
  private final com.airbnb.lottie.s.c.a<?, Float> j;
  private final com.airbnb.lottie.s.c.a<?, Integer> k;
  private final List<com.airbnb.lottie.s.c.a<?, Float>> l;
  @Nullable
  private final com.airbnb.lottie.s.c.a<?, Float> m;
  @Nullable
  private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> n;
  
  a(f paramf, com.airbnb.lottie.model.layer.a parama, Paint.Cap paramCap, Paint.Join paramJoin, float paramFloat, com.airbnb.lottie.model.i.d paramd, b paramb1, List<b> paramList, b paramb2)
  {
    com.airbnb.lottie.s.a locala = new com.airbnb.lottie.s.a(1);
    this.i = locala;
    this.e = paramf;
    this.f = parama;
    locala.setStyle(Paint.Style.STROKE);
    locala.setStrokeCap(paramCap);
    locala.setStrokeJoin(paramJoin);
    locala.setStrokeMiter(paramFloat);
    this.k = paramd.a();
    this.j = paramb1.a();
    if (paramb2 == null) {
      this.m = null;
    } else {
      this.m = paramb2.a();
    }
    this.l = new ArrayList(paramList.size());
    this.h = new float[paramList.size()];
    int i1 = 0;
    for (int i2 = 0; i2 < paramList.size(); i2++) {
      this.l.add(((b)paramList.get(i2)).a());
    }
    parama.i(this.k);
    parama.i(this.j);
    for (i2 = 0; i2 < this.l.size(); i2++) {
      parama.i((com.airbnb.lottie.s.c.a)this.l.get(i2));
    }
    paramf = this.m;
    if (paramf != null) {
      parama.i(paramf);
    }
    this.k.a(this);
    this.j.a(this);
    for (i2 = i1; i2 < paramList.size(); i2++) {
      ((com.airbnb.lottie.s.c.a)this.l.get(i2)).a(this);
    }
    paramf = this.m;
    if (paramf != null) {
      paramf.a(this);
    }
  }
  
  private void f(Matrix paramMatrix)
  {
    com.airbnb.lottie.c.a("StrokeContent#applyDashPattern");
    if (this.l.isEmpty())
    {
      com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
      return;
    }
    float f1 = h.g(paramMatrix);
    for (int i1 = 0; i1 < this.l.size(); i1++)
    {
      this.h[i1] = ((Float)((com.airbnb.lottie.s.c.a)this.l.get(i1)).h()).floatValue();
      if (i1 % 2 == 0)
      {
        paramMatrix = this.h;
        if (paramMatrix[i1] < 1.0F) {
          paramMatrix[i1] = 1.0F;
        }
      }
      else
      {
        paramMatrix = this.h;
        if (paramMatrix[i1] < 0.1F) {
          paramMatrix[i1] = 0.1F;
        }
      }
      paramMatrix = this.h;
      paramMatrix[i1] *= f1;
    }
    paramMatrix = this.m;
    if (paramMatrix == null) {
      f1 = 0.0F;
    } else {
      f1 *= ((Float)paramMatrix.h()).floatValue();
    }
    this.i.setPathEffect(new DashPathEffect(this.h, f1));
    com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
  }
  
  private void h(Canvas paramCanvas, b paramb, Matrix paramMatrix)
  {
    com.airbnb.lottie.c.a("StrokeContent#applyTrimPath");
    if (b.b(paramb) == null)
    {
      com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
      return;
    }
    this.b.reset();
    for (int i1 = b.a(paramb).size() - 1; i1 >= 0; i1--) {
      this.b.addPath(((m)b.a(paramb).get(i1)).getPath(), paramMatrix);
    }
    this.a.setPath(this.b, false);
    for (float f1 = this.a.getLength(); this.a.nextContour(); f1 += this.a.getLength()) {}
    float f2 = ((Float)b.b(paramb).f().h()).floatValue() * f1 / 360.0F;
    float f3 = ((Float)b.b(paramb).h().h()).floatValue() * f1 / 100.0F + f2;
    float f4 = ((Float)b.b(paramb).d().h()).floatValue() * f1 / 100.0F + f2;
    i1 = b.a(paramb).size() - 1;
    f2 = 0.0F;
    while (i1 >= 0)
    {
      this.c.set(((m)b.a(paramb).get(i1)).getPath());
      this.c.transform(paramMatrix);
      this.a.setPath(this.c, false);
      float f5 = this.a.getLength();
      float f6 = 1.0F;
      float f8;
      if (f4 > f1)
      {
        f7 = f4 - f1;
        if ((f7 < f2 + f5) && (f2 < f7))
        {
          if (f3 > f1) {
            f8 = (f3 - f1) / f5;
          } else {
            f8 = 0.0F;
          }
          f6 = Math.min(f7 / f5, 1.0F);
          h.a(this.c, f8, f6, 0.0F);
          paramCanvas.drawPath(this.c, this.i);
          break label502;
        }
      }
      float f7 = f2 + f5;
      if ((f7 >= f3) && (f2 <= f4)) {
        if ((f7 <= f4) && (f3 < f2))
        {
          paramCanvas.drawPath(this.c, this.i);
        }
        else
        {
          if (f3 < f2) {
            f8 = 0.0F;
          } else {
            f8 = (f3 - f2) / f5;
          }
          if (f4 <= f7) {
            f6 = (f4 - f2) / f5;
          }
          h.a(this.c, f8, f6, 0.0F);
          paramCanvas.drawPath(this.c, this.i);
        }
      }
      label502:
      f2 += f5;
      i1--;
    }
    com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
  }
  
  public void a()
  {
    this.e.invalidateSelf();
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    int i1 = paramList1.size() - 1;
    Object localObject2;
    Object localObject3;
    for (Object localObject1 = null; i1 >= 0; localObject1 = localObject3)
    {
      localObject2 = (c)paramList1.get(i1);
      localObject3 = localObject1;
      if ((localObject2 instanceof s))
      {
        localObject2 = (s)localObject2;
        localObject3 = localObject1;
        if (((s)localObject2).i() == ShapeTrimPath.Type.INDIVIDUALLY) {
          localObject3 = localObject2;
        }
      }
      i1--;
    }
    if (localObject1 != null) {
      ((s)localObject1).c(this);
    }
    i1 = paramList2.size() - 1;
    for (paramList1 = null; i1 >= 0; paramList1 = (List<c>)localObject3)
    {
      localObject2 = (c)paramList2.get(i1);
      if ((localObject2 instanceof s))
      {
        s locals = (s)localObject2;
        if (locals.i() == ShapeTrimPath.Type.INDIVIDUALLY)
        {
          if (paramList1 != null) {
            this.g.add(paramList1);
          }
          localObject3 = new b(locals, null);
          locals.c(this);
          break label222;
        }
      }
      localObject3 = paramList1;
      if ((localObject2 instanceof m))
      {
        localObject3 = paramList1;
        if (paramList1 == null) {
          localObject3 = new b((s)localObject1, null);
        }
        b.a((b)localObject3).add((m)localObject2);
      }
      label222:
      i1--;
    }
    if (paramList1 != null) {
      this.g.add(paramList1);
    }
  }
  
  @CallSuper
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    if (paramT == com.airbnb.lottie.k.d)
    {
      this.k.m(paramc);
    }
    else if (paramT == com.airbnb.lottie.k.o)
    {
      this.j.m(paramc);
    }
    else if (paramT == com.airbnb.lottie.k.C)
    {
      paramT = this.n;
      if (paramT != null) {
        this.f.C(paramT);
      }
      if (paramc == null)
      {
        this.n = null;
      }
      else
      {
        paramT = new p(paramc);
        this.n = paramT;
        paramT.a(this);
        this.f.i(this.n);
      }
    }
  }
  
  public void d(com.airbnb.lottie.model.d paramd1, int paramInt, List<com.airbnb.lottie.model.d> paramList, com.airbnb.lottie.model.d paramd2)
  {
    g.l(paramd1, paramInt, paramList, paramd2, this);
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    com.airbnb.lottie.c.a("StrokeContent#getBounds");
    this.b.reset();
    for (int i1 = 0; i1 < this.g.size(); i1++)
    {
      b localb = (b)this.g.get(i1);
      for (int i2 = 0; i2 < b.a(localb).size(); i2++) {
        this.b.addPath(((m)b.a(localb).get(i2)).getPath(), paramMatrix);
      }
    }
    this.b.computeBounds(this.d, false);
    float f1 = ((com.airbnb.lottie.s.c.c)this.j).o();
    paramMatrix = this.d;
    float f2 = paramMatrix.left;
    f1 /= 2.0F;
    paramMatrix.set(f2 - f1, paramMatrix.top - f1, paramMatrix.right + f1, paramMatrix.bottom + f1);
    paramRectF.set(this.d);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
    com.airbnb.lottie.c.b("StrokeContent#getBounds");
  }
  
  public void g(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    com.airbnb.lottie.c.a("StrokeContent#draw");
    if (h.h(paramMatrix))
    {
      com.airbnb.lottie.c.b("StrokeContent#draw");
      return;
    }
    paramInt = (int)(paramInt / 255.0F * ((com.airbnb.lottie.s.c.e)this.k).o() / 100.0F * 255.0F);
    Object localObject = this.i;
    int i1 = 0;
    ((Paint)localObject).setAlpha(g.c(paramInt, 0, 255));
    this.i.setStrokeWidth(((com.airbnb.lottie.s.c.c)this.j).o() * h.g(paramMatrix));
    if (this.i.getStrokeWidth() <= 0.0F)
    {
      com.airbnb.lottie.c.b("StrokeContent#draw");
      return;
    }
    f(paramMatrix);
    localObject = this.n;
    paramInt = i1;
    if (localObject != null) {
      this.i.setColorFilter((ColorFilter)((com.airbnb.lottie.s.c.a)localObject).h());
    }
    for (paramInt = i1; paramInt < this.g.size(); paramInt++)
    {
      localObject = (b)this.g.get(paramInt);
      if (b.b((b)localObject) != null)
      {
        h(paramCanvas, (b)localObject, paramMatrix);
      }
      else
      {
        com.airbnb.lottie.c.a("StrokeContent#buildPath");
        this.b.reset();
        for (i1 = b.a((b)localObject).size() - 1; i1 >= 0; i1--) {
          this.b.addPath(((m)b.a((b)localObject).get(i1)).getPath(), paramMatrix);
        }
        com.airbnb.lottie.c.b("StrokeContent#buildPath");
        com.airbnb.lottie.c.a("StrokeContent#drawPath");
        paramCanvas.drawPath(this.b, this.i);
        com.airbnb.lottie.c.b("StrokeContent#drawPath");
      }
    }
    com.airbnb.lottie.c.b("StrokeContent#draw");
  }
  
  private static final class b
  {
    private final List<m> a = new ArrayList();
    @Nullable
    private final s b;
    
    private b(@Nullable s params)
    {
      this.b = params;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */