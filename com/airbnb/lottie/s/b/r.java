package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.ShapeStroke.LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke.LineJoinType;
import com.airbnb.lottie.s.c.b;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.w.c;

public class r
  extends a
{
  private final com.airbnb.lottie.model.layer.a o;
  private final String p;
  private final boolean q;
  private final com.airbnb.lottie.s.c.a<Integer, Integer> r;
  @Nullable
  private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> s;
  
  public r(f paramf, com.airbnb.lottie.model.layer.a parama, ShapeStroke paramShapeStroke)
  {
    super(paramf, parama, paramShapeStroke.b().toPaintCap(), paramShapeStroke.e().toPaintJoin(), paramShapeStroke.g(), paramShapeStroke.i(), paramShapeStroke.j(), paramShapeStroke.f(), paramShapeStroke.d());
    this.o = parama;
    this.p = paramShapeStroke.h();
    this.q = paramShapeStroke.k();
    paramf = paramShapeStroke.c().a();
    this.r = paramf;
    paramf.a(this);
    parama.i(paramf);
  }
  
  public <T> void c(T paramT, @Nullable c<T> paramc)
  {
    super.c(paramT, paramc);
    if (paramT == k.b)
    {
      this.r.m(paramc);
    }
    else if (paramT == k.C)
    {
      paramT = this.s;
      if (paramT != null) {
        this.o.C(paramT);
      }
      if (paramc == null)
      {
        this.s = null;
      }
      else
      {
        paramT = new p(paramc);
        this.s = paramT;
        paramT.a(this);
        this.o.i(this.r);
      }
    }
  }
  
  public void g(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (this.q) {
      return;
    }
    this.i.setColor(((b)this.r).o());
    com.airbnb.lottie.s.c.a locala = this.s;
    if (locala != null) {
      this.i.setColorFilter((ColorFilter)locala.h());
    }
    super.g(paramCanvas, paramMatrix, paramInt);
  }
  
  public String getName()
  {
    return this.p;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */