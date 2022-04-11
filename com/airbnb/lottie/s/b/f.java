package com.airbnb.lottie.s.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.s.c.a.b;
import com.airbnb.lottie.v.g;
import java.util.List;

public class f
  implements m, a.b, k
{
  private final Path a = new Path();
  private final String b;
  private final com.airbnb.lottie.f c;
  private final com.airbnb.lottie.s.c.a<?, PointF> d;
  private final com.airbnb.lottie.s.c.a<?, PointF> e;
  private final com.airbnb.lottie.model.content.a f;
  private b g = new b();
  private boolean h;
  
  public f(com.airbnb.lottie.f paramf, com.airbnb.lottie.model.layer.a parama, com.airbnb.lottie.model.content.a parama1)
  {
    this.b = parama1.b();
    this.c = paramf;
    com.airbnb.lottie.s.c.a locala = parama1.d().a();
    this.d = locala;
    paramf = parama1.c().a();
    this.e = paramf;
    this.f = parama1;
    parama.i(locala);
    parama.i(paramf);
    locala.a(this);
    paramf.a(this);
  }
  
  private void f()
  {
    this.h = false;
    this.c.invalidateSelf();
  }
  
  public void a()
  {
    f();
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    for (int i = 0; i < paramList1.size(); i++)
    {
      paramList2 = (c)paramList1.get(i);
      if ((paramList2 instanceof s))
      {
        paramList2 = (s)paramList2;
        if (paramList2.i() == ShapeTrimPath.Type.SIMULTANEOUSLY)
        {
          this.g.a(paramList2);
          paramList2.c(this);
        }
      }
    }
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    if (paramT == com.airbnb.lottie.k.g) {
      this.d.m(paramc);
    } else if (paramT == com.airbnb.lottie.k.j) {
      this.e.m(paramc);
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
    if (this.h) {
      return this.a;
    }
    this.a.reset();
    if (this.f.e())
    {
      this.h = true;
      return this.a;
    }
    Object localObject = (PointF)this.d.h();
    float f1 = ((PointF)localObject).x / 2.0F;
    float f2 = ((PointF)localObject).y / 2.0F;
    float f3 = f1 * 0.55228F;
    float f4 = 0.55228F * f2;
    this.a.reset();
    float f5;
    float f7;
    float f8;
    if (this.f.f())
    {
      localObject = this.a;
      f5 = -f2;
      ((Path)localObject).moveTo(0.0F, f5);
      localObject = this.a;
      float f6 = 0.0F - f3;
      f7 = -f1;
      f8 = 0.0F - f4;
      ((Path)localObject).cubicTo(f6, f5, f7, f8, f7, 0.0F);
      localObject = this.a;
      f4 += 0.0F;
      ((Path)localObject).cubicTo(f7, f4, f6, f2, 0.0F, f2);
      localObject = this.a;
      f3 += 0.0F;
      ((Path)localObject).cubicTo(f3, f2, f1, f4, f1, 0.0F);
      this.a.cubicTo(f1, f8, f3, f5, 0.0F, f5);
    }
    else
    {
      localObject = this.a;
      f8 = -f2;
      ((Path)localObject).moveTo(0.0F, f8);
      localObject = this.a;
      f7 = f3 + 0.0F;
      f5 = 0.0F - f4;
      ((Path)localObject).cubicTo(f7, f8, f1, f5, f1, 0.0F);
      localObject = this.a;
      f4 += 0.0F;
      ((Path)localObject).cubicTo(f1, f4, f7, f2, 0.0F, f2);
      localObject = this.a;
      f3 = 0.0F - f3;
      f1 = -f1;
      ((Path)localObject).cubicTo(f3, f2, f1, f4, f1, 0.0F);
      this.a.cubicTo(f1, f5, f3, f8, 0.0F, f8);
    }
    localObject = (PointF)this.e.h();
    this.a.offset(((PointF)localObject).x, ((PointF)localObject).y);
    this.a.close();
    this.g.b(this.a);
    this.h = true;
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */