package com.airbnb.lottie.s.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape.Type;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.s.c.a.b;
import com.airbnb.lottie.v.g;
import java.util.List;

public class n
  implements m, a.b, k
{
  private final Path a = new Path();
  private final String b;
  private final f c;
  private final PolystarShape.Type d;
  private final boolean e;
  private final com.airbnb.lottie.s.c.a<?, Float> f;
  private final com.airbnb.lottie.s.c.a<?, PointF> g;
  private final com.airbnb.lottie.s.c.a<?, Float> h;
  @Nullable
  private final com.airbnb.lottie.s.c.a<?, Float> i;
  private final com.airbnb.lottie.s.c.a<?, Float> j;
  @Nullable
  private final com.airbnb.lottie.s.c.a<?, Float> k;
  private final com.airbnb.lottie.s.c.a<?, Float> l;
  private b m = new b();
  private boolean n;
  
  public n(f paramf, com.airbnb.lottie.model.layer.a parama, PolystarShape paramPolystarShape)
  {
    this.c = paramf;
    this.b = paramPolystarShape.d();
    PolystarShape.Type localType1 = paramPolystarShape.j();
    this.d = localType1;
    this.e = paramPolystarShape.k();
    paramf = paramPolystarShape.g().a();
    this.f = paramf;
    com.airbnb.lottie.s.c.a locala1 = paramPolystarShape.h().a();
    this.g = locala1;
    com.airbnb.lottie.s.c.a locala2 = paramPolystarShape.i().a();
    this.h = locala2;
    com.airbnb.lottie.s.c.a locala3 = paramPolystarShape.e().a();
    this.j = locala3;
    com.airbnb.lottie.s.c.a locala4 = paramPolystarShape.f().a();
    this.l = locala4;
    PolystarShape.Type localType2 = PolystarShape.Type.STAR;
    if (localType1 == localType2)
    {
      this.i = paramPolystarShape.b().a();
      this.k = paramPolystarShape.c().a();
    }
    else
    {
      this.i = null;
      this.k = null;
    }
    parama.i(paramf);
    parama.i(locala1);
    parama.i(locala2);
    parama.i(locala3);
    parama.i(locala4);
    if (localType1 == localType2)
    {
      parama.i(this.i);
      parama.i(this.k);
    }
    paramf.a(this);
    locala1.a(this);
    locala2.a(this);
    locala3.a(this);
    locala4.a(this);
    if (localType1 == localType2)
    {
      this.i.a(this);
      this.k.a(this);
    }
  }
  
  private void f()
  {
    int i1 = (int)Math.floor(((Float)this.f.h()).floatValue());
    Object localObject = this.h;
    if (localObject == null) {
      d1 = 0.0D;
    } else {
      d1 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue();
    }
    double d2 = Math.toRadians(d1 - 90.0D);
    double d3 = i1;
    float f1 = (float)(6.283185307179586D / d3);
    float f2 = ((Float)this.l.h()).floatValue() / 100.0F;
    float f3 = ((Float)this.j.h()).floatValue();
    double d4 = f3;
    float f4 = (float)(Math.cos(d2) * d4);
    float f5 = (float)(Math.sin(d2) * d4);
    this.a.moveTo(f4, f5);
    double d1 = f1;
    d2 += d1;
    d3 = Math.ceil(d3);
    i1 = 0;
    while (i1 < d3)
    {
      f1 = (float)(Math.cos(d2) * d4);
      float f6 = (float)(d4 * Math.sin(d2));
      if (f2 != 0.0F)
      {
        double d5 = (float)(Math.atan2(f5, f4) - 1.5707963267948966D);
        float f7 = (float)Math.cos(d5);
        float f8 = (float)Math.sin(d5);
        d5 = (float)(Math.atan2(f6, f1) - 1.5707963267948966D);
        float f9 = (float)Math.cos(d5);
        float f10 = (float)Math.sin(d5);
        float f11 = f3 * f2 * 0.25F;
        this.a.cubicTo(f4 - f7 * f11, f5 - f8 * f11, f1 + f9 * f11, f6 + f11 * f10, f1, f6);
      }
      else
      {
        this.a.lineTo(f1, f6);
      }
      d2 += d1;
      i1++;
      f5 = f6;
      f4 = f1;
    }
    localObject = (PointF)this.g.h();
    this.a.offset(((PointF)localObject).x, ((PointF)localObject).y);
    this.a.close();
  }
  
  private void h()
  {
    float f1 = ((Float)this.f.h()).floatValue();
    Object localObject = this.h;
    if (localObject == null) {
      d1 = 0.0D;
    } else {
      d1 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue();
    }
    double d2 = Math.toRadians(d1 - 90.0D);
    double d3 = f1;
    float f2 = (float)(6.283185307179586D / d3);
    float f3 = f2 / 2.0F;
    float f4 = f1 - (int)f1;
    boolean bool1 = f4 < 0.0F;
    double d1 = d2;
    if (bool1) {
      d1 = d2 + (1.0F - f4) * f3;
    }
    float f5 = ((Float)this.j.h()).floatValue();
    float f6 = ((Float)this.i.h()).floatValue();
    localObject = this.k;
    float f7;
    if (localObject != null) {
      f7 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue() / 100.0F;
    } else {
      f7 = 0.0F;
    }
    localObject = this.l;
    if (localObject != null) {
      f1 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue() / 100.0F;
    } else {
      f1 = 0.0F;
    }
    float f8;
    float f9;
    float f10;
    if (bool1)
    {
      f8 = (f5 - f6) * f4 + f6;
      d2 = f8;
      f9 = (float)(d2 * Math.cos(d1));
      f10 = (float)(d2 * Math.sin(d1));
      this.a.moveTo(f9, f10);
      d1 += f2 * f4 / 2.0F;
    }
    else
    {
      d2 = f5;
      f9 = (float)(Math.cos(d1) * d2);
      f10 = (float)(d2 * Math.sin(d1));
      this.a.moveTo(f9, f10);
      d1 += f3;
      f8 = 0.0F;
    }
    d2 = Math.ceil(d3) * 2.0D;
    int i1 = 0;
    int i2 = 0;
    float f11 = f9;
    for (;;)
    {
      d3 = i1;
      if (d3 >= d2) {
        break;
      }
      if (i2 != 0) {
        f9 = f5;
      } else {
        f9 = f6;
      }
      boolean bool2 = f8 < 0.0F;
      float f12;
      if ((bool2) && (d3 == d2 - 2.0D)) {
        f12 = f2 * f4 / 2.0F;
      } else {
        f12 = f3;
      }
      if ((bool2) && (d3 == d2 - 1.0D)) {
        f9 = f8;
      }
      double d4 = f9;
      float f13 = (float)(d4 * Math.cos(d1));
      float f14 = (float)(d4 * Math.sin(d1));
      if ((f7 == 0.0F) && (f1 == 0.0F))
      {
        this.a.lineTo(f13, f14);
      }
      else
      {
        d4 = f10;
        f9 = f7;
        d4 = (float)(Math.atan2(d4, f11) - 1.5707963267948966D);
        float f15 = (float)Math.cos(d4);
        float f16 = (float)Math.sin(d4);
        d4 = (float)(Math.atan2(f14, f13) - 1.5707963267948966D);
        float f17 = (float)Math.cos(d4);
        float f18 = (float)Math.sin(d4);
        if (i2 != 0) {
          f19 = f9;
        } else {
          f19 = f1;
        }
        if (i2 != 0) {
          f9 = f1;
        }
        if (i2 != 0) {
          f20 = f6;
        } else {
          f20 = f5;
        }
        if (i2 != 0) {
          f21 = f5;
        } else {
          f21 = f6;
        }
        float f19 = f20 * f19 * 0.47829F;
        f15 *= f19;
        f16 = f19 * f16;
        f9 = f21 * f9 * 0.47829F;
        f17 *= f9;
        f18 = f9 * f18;
        float f20 = f17;
        f19 = f16;
        float f21 = f18;
        f9 = f15;
        if (bool1) {
          if (i1 == 0)
          {
            f9 = f15 * f4;
            f19 = f16 * f4;
            f20 = f17;
            f21 = f18;
          }
          else
          {
            f20 = f17;
            f19 = f16;
            f21 = f18;
            f9 = f15;
            if (d3 == d2 - 1.0D)
            {
              f20 = f17 * f4;
              f21 = f18 * f4;
              f9 = f15;
              f19 = f16;
            }
          }
        }
        this.a.cubicTo(f11 - f9, f10 - f19, f13 + f20, f14 + f21, f13, f14);
      }
      d1 += f12;
      i2 ^= 0x1;
      i1++;
      f11 = f13;
      f10 = f14;
    }
    localObject = (PointF)this.g.h();
    this.a.offset(((PointF)localObject).x, ((PointF)localObject).y);
    this.a.close();
  }
  
  private void i()
  {
    this.n = false;
    this.c.invalidateSelf();
  }
  
  public void a()
  {
    i();
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    for (int i1 = 0; i1 < paramList1.size(); i1++)
    {
      paramList2 = (c)paramList1.get(i1);
      if ((paramList2 instanceof s))
      {
        paramList2 = (s)paramList2;
        if (paramList2.i() == ShapeTrimPath.Type.SIMULTANEOUSLY)
        {
          this.m.a(paramList2);
          paramList2.c(this);
        }
      }
    }
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    if (paramT == com.airbnb.lottie.k.s)
    {
      this.f.m(paramc);
    }
    else if (paramT == com.airbnb.lottie.k.t)
    {
      this.h.m(paramc);
    }
    else if (paramT == com.airbnb.lottie.k.j)
    {
      this.g.m(paramc);
    }
    else
    {
      com.airbnb.lottie.s.c.a locala;
      if (paramT == com.airbnb.lottie.k.u)
      {
        locala = this.i;
        if (locala != null)
        {
          locala.m(paramc);
          return;
        }
      }
      if (paramT == com.airbnb.lottie.k.v)
      {
        this.j.m(paramc);
      }
      else
      {
        if (paramT == com.airbnb.lottie.k.w)
        {
          locala = this.k;
          if (locala != null)
          {
            locala.m(paramc);
            return;
          }
        }
        if (paramT == com.airbnb.lottie.k.x) {
          this.l.m(paramc);
        }
      }
    }
  }
  
  public void d(d paramd1, int paramInt, List<d> paramList, d paramd2)
  {
    g.l(paramd1, paramInt, paramList, paramd2, this);
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public Path getPath()
  {
    if (this.n) {
      return this.a;
    }
    this.a.reset();
    if (this.e)
    {
      this.n = true;
      return this.a;
    }
    int i1 = a.a[this.d.ordinal()];
    if (i1 != 1)
    {
      if (i1 == 2) {
        f();
      }
    }
    else {
      h();
    }
    this.a.close();
    this.m.b(this.a);
    this.n = true;
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */