package com.airbnb.lottie.s.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.s.c.a.b;
import com.airbnb.lottie.v.g;
import java.util.List;

public class o
  implements a.b, k, m
{
  private final Path a = new Path();
  private final RectF b = new RectF();
  private final String c;
  private final boolean d;
  private final com.airbnb.lottie.f e;
  private final com.airbnb.lottie.s.c.a<?, PointF> f;
  private final com.airbnb.lottie.s.c.a<?, PointF> g;
  private final com.airbnb.lottie.s.c.a<?, Float> h;
  private b i = new b();
  private boolean j;
  
  public o(com.airbnb.lottie.f paramf, com.airbnb.lottie.model.layer.a parama, com.airbnb.lottie.model.content.f paramf1)
  {
    this.c = paramf1.c();
    this.d = paramf1.f();
    this.e = paramf;
    paramf = paramf1.d().a();
    this.f = paramf;
    com.airbnb.lottie.s.c.a locala = paramf1.e().a();
    this.g = locala;
    paramf1 = paramf1.b().a();
    this.h = paramf1;
    parama.i(paramf);
    parama.i(locala);
    parama.i(paramf1);
    paramf.a(this);
    locala.a(this);
    paramf1.a(this);
  }
  
  private void f()
  {
    this.j = false;
    this.e.invalidateSelf();
  }
  
  public void a()
  {
    f();
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    for (int k = 0; k < paramList1.size(); k++)
    {
      paramList2 = (c)paramList1.get(k);
      if ((paramList2 instanceof s))
      {
        paramList2 = (s)paramList2;
        if (paramList2.i() == ShapeTrimPath.Type.SIMULTANEOUSLY)
        {
          this.i.a(paramList2);
          paramList2.c(this);
        }
      }
    }
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    if (paramT == com.airbnb.lottie.k.h) {
      this.g.m(paramc);
    } else if (paramT == com.airbnb.lottie.k.j) {
      this.f.m(paramc);
    } else if (paramT == com.airbnb.lottie.k.i) {
      this.h.m(paramc);
    }
  }
  
  public void d(d paramd1, int paramInt, List<d> paramList, d paramd2)
  {
    g.l(paramd1, paramInt, paramList, paramd2, this);
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public Path getPath()
  {
    if (this.j) {
      return this.a;
    }
    this.a.reset();
    if (this.d)
    {
      this.j = true;
      return this.a;
    }
    Object localObject = (PointF)this.g.h();
    float f1 = ((PointF)localObject).x / 2.0F;
    float f2 = ((PointF)localObject).y / 2.0F;
    localObject = this.h;
    float f3;
    if (localObject == null) {
      f3 = 0.0F;
    } else {
      f3 = ((com.airbnb.lottie.s.c.c)localObject).o();
    }
    float f4 = Math.min(f1, f2);
    float f5 = f3;
    if (f3 > f4) {
      f5 = f4;
    }
    localObject = (PointF)this.f.h();
    this.a.moveTo(((PointF)localObject).x + f1, ((PointF)localObject).y - f2 + f5);
    this.a.lineTo(((PointF)localObject).x + f1, ((PointF)localObject).y + f2 - f5);
    boolean bool = f5 < 0.0F;
    RectF localRectF;
    float f6;
    if (bool)
    {
      localRectF = this.b;
      f4 = ((PointF)localObject).x;
      f3 = f5 * 2.0F;
      f6 = ((PointF)localObject).y;
      localRectF.set(f4 + f1 - f3, f6 + f2 - f3, f4 + f1, f6 + f2);
      this.a.arcTo(this.b, 0.0F, 90.0F, false);
    }
    this.a.lineTo(((PointF)localObject).x - f1 + f5, ((PointF)localObject).y + f2);
    if (bool)
    {
      localRectF = this.b;
      f6 = ((PointF)localObject).x;
      f4 = ((PointF)localObject).y;
      f3 = f5 * 2.0F;
      localRectF.set(f6 - f1, f4 + f2 - f3, f6 - f1 + f3, f4 + f2);
      this.a.arcTo(this.b, 90.0F, 90.0F, false);
    }
    this.a.lineTo(((PointF)localObject).x - f1, ((PointF)localObject).y - f2 + f5);
    if (bool)
    {
      localRectF = this.b;
      f3 = ((PointF)localObject).x;
      f6 = ((PointF)localObject).y;
      f4 = f5 * 2.0F;
      localRectF.set(f3 - f1, f6 - f2, f3 - f1 + f4, f6 - f2 + f4);
      this.a.arcTo(this.b, 180.0F, 90.0F, false);
    }
    this.a.lineTo(((PointF)localObject).x + f1 - f5, ((PointF)localObject).y - f2);
    if (bool)
    {
      localRectF = this.b;
      f3 = ((PointF)localObject).x;
      f4 = f5 * 2.0F;
      f5 = ((PointF)localObject).y;
      localRectF.set(f3 + f1 - f4, f5 - f2, f3 + f1, f5 - f2 + f4);
      this.a.arcTo(this.b, 270.0F, 90.0F, false);
    }
    this.a.close();
    this.i.b(this.a);
    this.j = true;
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */