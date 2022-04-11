package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.i;
import com.airbnb.lottie.s.c.a.b;
import com.airbnb.lottie.s.c.b;
import com.airbnb.lottie.s.c.p;
import java.util.ArrayList;
import java.util.List;

public class g
  implements e, a.b, k
{
  private final Path a;
  private final Paint b;
  private final com.airbnb.lottie.model.layer.a c;
  private final String d;
  private final boolean e;
  private final List<m> f;
  private final com.airbnb.lottie.s.c.a<Integer, Integer> g;
  private final com.airbnb.lottie.s.c.a<Integer, Integer> h;
  @Nullable
  private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> i;
  private final f j;
  
  public g(f paramf, com.airbnb.lottie.model.layer.a parama, i parami)
  {
    Path localPath = new Path();
    this.a = localPath;
    this.b = new com.airbnb.lottie.s.a(1);
    this.f = new ArrayList();
    this.c = parama;
    this.d = parami.d();
    this.e = parami.f();
    this.j = paramf;
    if ((parami.b() != null) && (parami.e() != null))
    {
      localPath.setFillType(parami.c());
      paramf = parami.b().a();
      this.g = paramf;
      paramf.a(this);
      parama.i(paramf);
      paramf = parami.e().a();
      this.h = paramf;
      paramf.a(this);
      parama.i(paramf);
      return;
    }
    this.g = null;
    this.h = null;
  }
  
  public void a()
  {
    this.j.invalidateSelf();
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    for (int k = 0; k < paramList2.size(); k++)
    {
      paramList1 = (c)paramList2.get(k);
      if ((paramList1 instanceof m)) {
        this.f.add((m)paramList1);
      }
    }
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    if (paramT == com.airbnb.lottie.k.a)
    {
      this.g.m(paramc);
    }
    else if (paramT == com.airbnb.lottie.k.d)
    {
      this.h.m(paramc);
    }
    else if (paramT == com.airbnb.lottie.k.C)
    {
      paramT = this.i;
      if (paramT != null) {
        this.c.C(paramT);
      }
      if (paramc == null)
      {
        this.i = null;
      }
      else
      {
        paramT = new p(paramc);
        this.i = paramT;
        paramT.a(this);
        this.c.i(this.i);
      }
    }
  }
  
  public void d(com.airbnb.lottie.model.d paramd1, int paramInt, List<com.airbnb.lottie.model.d> paramList, com.airbnb.lottie.model.d paramd2)
  {
    com.airbnb.lottie.v.g.l(paramd1, paramInt, paramList, paramd2, this);
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    this.a.reset();
    for (int k = 0; k < this.f.size(); k++) {
      this.a.addPath(((m)this.f.get(k)).getPath(), paramMatrix);
    }
    this.a.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public void g(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (this.e) {
      return;
    }
    com.airbnb.lottie.c.a("FillContent#draw");
    this.b.setColor(((b)this.g).o());
    int k = (int)(paramInt / 255.0F * ((Integer)this.h.h()).intValue() / 100.0F * 255.0F);
    Object localObject = this.b;
    paramInt = 0;
    ((Paint)localObject).setAlpha(com.airbnb.lottie.v.g.c(k, 0, 255));
    localObject = this.i;
    if (localObject != null) {
      this.b.setColorFilter((ColorFilter)((com.airbnb.lottie.s.c.a)localObject).h());
    }
    this.a.reset();
    while (paramInt < this.f.size())
    {
      this.a.addPath(((m)this.f.get(paramInt)).getPath(), paramMatrix);
      paramInt++;
    }
    paramCanvas.drawPath(this.a, this.b);
    com.airbnb.lottie.c.b("FillContent#draw");
  }
  
  public String getName()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */