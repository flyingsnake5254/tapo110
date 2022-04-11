package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.s.c.a.b;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.v.g;
import java.util.ArrayList;
import java.util.List;

public class h
  implements e, a.b, k
{
  @NonNull
  private final String a;
  private final boolean b;
  private final com.airbnb.lottie.model.layer.a c;
  private final LongSparseArray<LinearGradient> d = new LongSparseArray();
  private final LongSparseArray<RadialGradient> e = new LongSparseArray();
  private final Path f;
  private final Paint g;
  private final RectF h;
  private final List<m> i;
  private final GradientType j;
  private final com.airbnb.lottie.s.c.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> k;
  private final com.airbnb.lottie.s.c.a<Integer, Integer> l;
  private final com.airbnb.lottie.s.c.a<PointF, PointF> m;
  private final com.airbnb.lottie.s.c.a<PointF, PointF> n;
  @Nullable
  private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> o;
  @Nullable
  private p p;
  private final com.airbnb.lottie.f q;
  private final int r;
  
  public h(com.airbnb.lottie.f paramf, com.airbnb.lottie.model.layer.a parama, com.airbnb.lottie.model.content.d paramd)
  {
    Path localPath = new Path();
    this.f = localPath;
    this.g = new com.airbnb.lottie.s.a(1);
    this.h = new RectF();
    this.i = new ArrayList();
    this.c = parama;
    this.a = paramd.f();
    this.b = paramd.i();
    this.q = paramf;
    this.j = paramd.e();
    localPath.setFillType(paramd.c());
    this.r = ((int)(paramf.m().d() / 32.0F));
    paramf = paramd.d().a();
    this.k = paramf;
    paramf.a(this);
    parama.i(paramf);
    paramf = paramd.g().a();
    this.l = paramf;
    paramf.a(this);
    parama.i(paramf);
    paramf = paramd.h().a();
    this.m = paramf;
    paramf.a(this);
    parama.i(paramf);
    paramf = paramd.b().a();
    this.n = paramf;
    paramf.a(this);
    parama.i(paramf);
  }
  
  private int[] f(int[] paramArrayOfInt)
  {
    Object localObject = this.p;
    int[] arrayOfInt = paramArrayOfInt;
    if (localObject != null)
    {
      localObject = (Integer[])((p)localObject).h();
      int i1 = paramArrayOfInt.length;
      int i2 = localObject.length;
      int i3 = 0;
      int i4 = 0;
      if (i1 == i2) {
        for (;;)
        {
          arrayOfInt = paramArrayOfInt;
          if (i4 >= paramArrayOfInt.length) {
            break;
          }
          paramArrayOfInt[i4] = localObject[i4].intValue();
          i4++;
        }
      }
      paramArrayOfInt = new int[localObject.length];
      for (i4 = i3;; i4++)
      {
        arrayOfInt = paramArrayOfInt;
        if (i4 >= localObject.length) {
          break;
        }
        paramArrayOfInt[i4] = localObject[i4].intValue();
      }
    }
    return arrayOfInt;
  }
  
  private int h()
  {
    int i1 = Math.round(this.m.f() * this.r);
    int i2 = Math.round(this.n.f() * this.r);
    int i3 = Math.round(this.k.f() * this.r);
    if (i1 != 0) {
      i4 = 527 * i1;
    } else {
      i4 = 17;
    }
    i1 = i4;
    if (i2 != 0) {
      i1 = i4 * 31 * i2;
    }
    int i4 = i1;
    if (i3 != 0) {
      i4 = i1 * 31 * i3;
    }
    return i4;
  }
  
  private LinearGradient i()
  {
    int i1 = h();
    Object localObject1 = this.d;
    long l1 = i1;
    localObject1 = (LinearGradient)((LongSparseArray)localObject1).get(l1);
    if (localObject1 != null) {
      return (LinearGradient)localObject1;
    }
    PointF localPointF = (PointF)this.m.h();
    localObject1 = (PointF)this.n.h();
    Object localObject2 = (com.airbnb.lottie.model.content.c)this.k.h();
    int[] arrayOfInt = f(((com.airbnb.lottie.model.content.c)localObject2).a());
    localObject2 = ((com.airbnb.lottie.model.content.c)localObject2).b();
    localObject1 = new LinearGradient(localPointF.x, localPointF.y, ((PointF)localObject1).x, ((PointF)localObject1).y, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.d.put(l1, localObject1);
    return (LinearGradient)localObject1;
  }
  
  private RadialGradient j()
  {
    int i1 = h();
    Object localObject1 = this.e;
    long l1 = i1;
    localObject1 = (RadialGradient)((LongSparseArray)localObject1).get(l1);
    if (localObject1 != null) {
      return (RadialGradient)localObject1;
    }
    PointF localPointF1 = (PointF)this.m.h();
    PointF localPointF2 = (PointF)this.n.h();
    Object localObject2 = (com.airbnb.lottie.model.content.c)this.k.h();
    localObject1 = f(((com.airbnb.lottie.model.content.c)localObject2).a());
    localObject2 = ((com.airbnb.lottie.model.content.c)localObject2).b();
    float f1 = localPointF1.x;
    float f2 = localPointF1.y;
    float f3 = localPointF2.x;
    float f4 = localPointF2.y;
    f4 = (float)Math.hypot(f3 - f1, f4 - f2);
    if (f4 <= 0.0F) {
      f4 = 0.001F;
    }
    localObject1 = new RadialGradient(f1, f2, f4, (int[])localObject1, (float[])localObject2, Shader.TileMode.CLAMP);
    this.e.put(l1, localObject1);
    return (RadialGradient)localObject1;
  }
  
  public void a()
  {
    this.q.invalidateSelf();
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    for (int i1 = 0; i1 < paramList2.size(); i1++)
    {
      paramList1 = (c)paramList2.get(i1);
      if ((paramList1 instanceof m)) {
        this.i.add((m)paramList1);
      }
    }
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    if (paramT == com.airbnb.lottie.k.d)
    {
      this.l.m(paramc);
    }
    else if (paramT == com.airbnb.lottie.k.C)
    {
      paramT = this.o;
      if (paramT != null) {
        this.c.C(paramT);
      }
      if (paramc == null)
      {
        this.o = null;
      }
      else
      {
        paramT = new p(paramc);
        this.o = paramT;
        paramT.a(this);
        this.c.i(this.o);
      }
    }
    else if (paramT == com.airbnb.lottie.k.D)
    {
      paramT = this.p;
      if (paramT != null) {
        this.c.C(paramT);
      }
      if (paramc == null)
      {
        this.p = null;
      }
      else
      {
        paramT = new p(paramc);
        this.p = paramT;
        paramT.a(this);
        this.c.i(this.p);
      }
    }
  }
  
  public void d(com.airbnb.lottie.model.d paramd1, int paramInt, List<com.airbnb.lottie.model.d> paramList, com.airbnb.lottie.model.d paramd2)
  {
    g.l(paramd1, paramInt, paramList, paramd2, this);
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    this.f.reset();
    for (int i1 = 0; i1 < this.i.size(); i1++) {
      this.f.addPath(((m)this.i.get(i1)).getPath(), paramMatrix);
    }
    this.f.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public void g(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (this.b) {
      return;
    }
    com.airbnb.lottie.c.a("GradientFillContent#draw");
    this.f.reset();
    for (int i1 = 0; i1 < this.i.size(); i1++) {
      this.f.addPath(((m)this.i.get(i1)).getPath(), paramMatrix);
    }
    this.f.computeBounds(this.h, false);
    Object localObject;
    if (this.j == GradientType.LINEAR) {
      localObject = i();
    } else {
      localObject = j();
    }
    ((Shader)localObject).setLocalMatrix(paramMatrix);
    this.g.setShader((Shader)localObject);
    paramMatrix = this.o;
    if (paramMatrix != null) {
      this.g.setColorFilter((ColorFilter)paramMatrix.h());
    }
    paramInt = (int)(paramInt / 255.0F * ((Integer)this.l.h()).intValue() / 100.0F * 255.0F);
    this.g.setAlpha(g.c(paramInt, 0, 255));
    paramCanvas.drawPath(this.f, this.g);
    com.airbnb.lottie.c.b("GradientFillContent#draw");
  }
  
  public String getName()
  {
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */