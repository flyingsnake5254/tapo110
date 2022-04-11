package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.s.c.a.b;
import com.airbnb.lottie.s.c.o;
import com.airbnb.lottie.v.h;
import java.util.ArrayList;
import java.util.List;

public class d
  implements e, m, a.b, com.airbnb.lottie.model.e
{
  private Paint a = new com.airbnb.lottie.s.a();
  private RectF b = new RectF();
  private final Matrix c = new Matrix();
  private final Path d = new Path();
  private final RectF e = new RectF();
  private final String f;
  private final boolean g;
  private final List<c> h;
  private final f i;
  @Nullable
  private List<m> j;
  @Nullable
  private o k;
  
  public d(f paramf, com.airbnb.lottie.model.layer.a parama, com.airbnb.lottie.model.content.j paramj)
  {
    this(paramf, parama, paramj.c(), paramj.d(), f(paramf, parama, paramj.b()), h(paramj.b()));
  }
  
  d(f paramf, com.airbnb.lottie.model.layer.a parama, String paramString, boolean paramBoolean, List<c> paramList, @Nullable l paraml)
  {
    this.f = paramString;
    this.i = paramf;
    this.g = paramBoolean;
    this.h = paramList;
    if (paraml != null)
    {
      paramf = paraml.b();
      this.k = paramf;
      paramf.a(parama);
      this.k.b(this);
    }
    paramf = new ArrayList();
    for (int m = paramList.size() - 1; m >= 0; m--)
    {
      parama = (c)paramList.get(m);
      if ((parama instanceof j)) {
        paramf.add((j)parama);
      }
    }
    for (m = paramf.size() - 1; m >= 0; m--) {
      ((j)paramf.get(m)).f(paramList.listIterator(paramList.size()));
    }
  }
  
  private static List<c> f(f paramf, com.airbnb.lottie.model.layer.a parama, List<b> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    for (int m = 0; m < paramList.size(); m++)
    {
      c localc = ((b)paramList.get(m)).a(paramf, parama);
      if (localc != null) {
        localArrayList.add(localc);
      }
    }
    return localArrayList;
  }
  
  @Nullable
  static l h(List<b> paramList)
  {
    for (int m = 0; m < paramList.size(); m++)
    {
      b localb = (b)paramList.get(m);
      if ((localb instanceof l)) {
        return (l)localb;
      }
    }
    return null;
  }
  
  private boolean k()
  {
    int m = 0;
    int i1;
    for (int n = 0; m < this.h.size(); n = i1)
    {
      i1 = n;
      if ((this.h.get(m) instanceof e))
      {
        n++;
        i1 = n;
        if (n >= 2) {
          return true;
        }
      }
      m++;
    }
    return false;
  }
  
  public void a()
  {
    this.i.invalidateSelf();
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    paramList2 = new ArrayList(paramList1.size() + this.h.size());
    paramList2.addAll(paramList1);
    for (int m = this.h.size() - 1; m >= 0; m--)
    {
      paramList1 = (c)this.h.get(m);
      paramList1.b(paramList2, this.h.subList(0, m));
      paramList2.add(paramList1);
    }
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    o localo = this.k;
    if (localo != null) {
      localo.c(paramT, paramc);
    }
  }
  
  public void d(com.airbnb.lottie.model.d paramd1, int paramInt, List<com.airbnb.lottie.model.d> paramList, com.airbnb.lottie.model.d paramd2)
  {
    if (!paramd1.h(getName(), paramInt)) {
      return;
    }
    com.airbnb.lottie.model.d locald = paramd2;
    if (!"__container".equals(getName()))
    {
      paramd2 = paramd2.a(getName());
      locald = paramd2;
      if (paramd1.c(getName(), paramInt))
      {
        paramList.add(paramd2.j(this));
        locald = paramd2;
      }
    }
    if (paramd1.i(getName(), paramInt))
    {
      int m = paramd1.e(getName(), paramInt);
      for (int n = 0; n < this.h.size(); n++)
      {
        paramd2 = (c)this.h.get(n);
        if ((paramd2 instanceof com.airbnb.lottie.model.e)) {
          ((com.airbnb.lottie.model.e)paramd2).d(paramd1, paramInt + m, paramList, locald);
        }
      }
    }
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    this.c.set(paramMatrix);
    paramMatrix = this.k;
    if (paramMatrix != null) {
      this.c.preConcat(paramMatrix.f());
    }
    this.e.set(0.0F, 0.0F, 0.0F, 0.0F);
    for (int m = this.h.size() - 1; m >= 0; m--)
    {
      paramMatrix = (c)this.h.get(m);
      if ((paramMatrix instanceof e))
      {
        ((e)paramMatrix).e(this.e, this.c, paramBoolean);
        paramRectF.union(this.e);
      }
    }
  }
  
  public void g(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (this.g) {
      return;
    }
    this.c.set(paramMatrix);
    paramMatrix = this.k;
    int m = paramInt;
    if (paramMatrix != null)
    {
      this.c.preConcat(paramMatrix.f());
      if (this.k.h() == null) {
        m = 100;
      } else {
        m = ((Integer)this.k.h().h()).intValue();
      }
      m = (int)(m / 100.0F * paramInt / 255.0F * 255.0F);
    }
    if ((this.i.F()) && (k()) && (m != 255)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      this.b.set(0.0F, 0.0F, 0.0F, 0.0F);
      e(this.b, this.c, true);
      this.a.setAlpha(m);
      h.m(paramCanvas, this.b, this.a);
    }
    if (paramInt != 0) {
      m = 255;
    }
    for (int n = this.h.size() - 1; n >= 0; n--)
    {
      paramMatrix = this.h.get(n);
      if ((paramMatrix instanceof e)) {
        ((e)paramMatrix).g(paramCanvas, this.c, m);
      }
    }
    if (paramInt != 0) {
      paramCanvas.restore();
    }
  }
  
  public String getName()
  {
    return this.f;
  }
  
  public Path getPath()
  {
    this.c.reset();
    Object localObject = this.k;
    if (localObject != null) {
      this.c.set(((o)localObject).f());
    }
    this.d.reset();
    if (this.g) {
      return this.d;
    }
    for (int m = this.h.size() - 1; m >= 0; m--)
    {
      localObject = (c)this.h.get(m);
      if ((localObject instanceof m)) {
        this.d.addPath(((m)localObject).getPath(), this.c);
      }
    }
    return this.d;
  }
  
  List<m> i()
  {
    if (this.j == null)
    {
      this.j = new ArrayList();
      for (int m = 0; m < this.h.size(); m++)
      {
        c localc = (c)this.h.get(m);
        if ((localc instanceof m)) {
          this.j.add((m)localc);
        }
      }
    }
    return this.j;
  }
  
  Matrix j()
  {
    o localo = this.k;
    if (localo != null) {
      return localo.f();
    }
    this.c.reset();
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */