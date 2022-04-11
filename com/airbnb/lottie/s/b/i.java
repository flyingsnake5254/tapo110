package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.d;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke.LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke.LineJoinType;
import com.airbnb.lottie.model.content.e;
import com.airbnb.lottie.s.c.p;

public class i
  extends a
{
  private final String o;
  private final boolean p;
  private final LongSparseArray<LinearGradient> q = new LongSparseArray();
  private final LongSparseArray<RadialGradient> r = new LongSparseArray();
  private final RectF s = new RectF();
  private final GradientType t;
  private final int u;
  private final com.airbnb.lottie.s.c.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> v;
  private final com.airbnb.lottie.s.c.a<PointF, PointF> w;
  private final com.airbnb.lottie.s.c.a<PointF, PointF> x;
  @Nullable
  private p y;
  
  public i(com.airbnb.lottie.f paramf, com.airbnb.lottie.model.layer.a parama, e parame)
  {
    super(paramf, parama, parame.b().toPaintCap(), parame.g().toPaintJoin(), parame.i(), parame.k(), parame.m(), parame.h(), parame.c());
    this.o = parame.j();
    this.t = parame.f();
    this.p = parame.n();
    this.u = ((int)(paramf.m().d() / 32.0F));
    paramf = parame.e().a();
    this.v = paramf;
    paramf.a(this);
    parama.i(paramf);
    paramf = parame.l().a();
    this.w = paramf;
    paramf.a(this);
    parama.i(paramf);
    paramf = parame.d().a();
    this.x = paramf;
    paramf.a(this);
    parama.i(paramf);
  }
  
  private int[] i(int[] paramArrayOfInt)
  {
    Object localObject = this.y;
    int[] arrayOfInt = paramArrayOfInt;
    if (localObject != null)
    {
      localObject = (Integer[])((p)localObject).h();
      int i = paramArrayOfInt.length;
      int j = localObject.length;
      int k = 0;
      int m = 0;
      if (i == j) {
        for (;;)
        {
          arrayOfInt = paramArrayOfInt;
          if (m >= paramArrayOfInt.length) {
            break;
          }
          paramArrayOfInt[m] = localObject[m].intValue();
          m++;
        }
      }
      paramArrayOfInt = new int[localObject.length];
      for (m = k;; m++)
      {
        arrayOfInt = paramArrayOfInt;
        if (m >= localObject.length) {
          break;
        }
        paramArrayOfInt[m] = localObject[m].intValue();
      }
    }
    return arrayOfInt;
  }
  
  private int j()
  {
    int i = Math.round(this.w.f() * this.u);
    int j = Math.round(this.x.f() * this.u);
    int k = Math.round(this.v.f() * this.u);
    if (i != 0) {
      m = 527 * i;
    } else {
      m = 17;
    }
    i = m;
    if (j != 0) {
      i = m * 31 * j;
    }
    int m = i;
    if (k != 0) {
      m = i * 31 * k;
    }
    return m;
  }
  
  private LinearGradient k()
  {
    int i = j();
    Object localObject1 = this.q;
    long l = i;
    localObject1 = (LinearGradient)((LongSparseArray)localObject1).get(l);
    if (localObject1 != null) {
      return (LinearGradient)localObject1;
    }
    PointF localPointF1 = (PointF)this.w.h();
    PointF localPointF2 = (PointF)this.x.h();
    Object localObject2 = (com.airbnb.lottie.model.content.c)this.v.h();
    localObject1 = i(((com.airbnb.lottie.model.content.c)localObject2).a());
    localObject2 = ((com.airbnb.lottie.model.content.c)localObject2).b();
    localObject1 = new LinearGradient(localPointF1.x, localPointF1.y, localPointF2.x, localPointF2.y, (int[])localObject1, (float[])localObject2, Shader.TileMode.CLAMP);
    this.q.put(l, localObject1);
    return (LinearGradient)localObject1;
  }
  
  private RadialGradient l()
  {
    int i = j();
    Object localObject1 = this.r;
    long l = i;
    localObject1 = (RadialGradient)((LongSparseArray)localObject1).get(l);
    if (localObject1 != null) {
      return (RadialGradient)localObject1;
    }
    localObject1 = (PointF)this.w.h();
    PointF localPointF = (PointF)this.x.h();
    Object localObject2 = (com.airbnb.lottie.model.content.c)this.v.h();
    int[] arrayOfInt = i(((com.airbnb.lottie.model.content.c)localObject2).a());
    localObject2 = ((com.airbnb.lottie.model.content.c)localObject2).b();
    float f1 = ((PointF)localObject1).x;
    float f2 = ((PointF)localObject1).y;
    float f3 = localPointF.x;
    float f4 = localPointF.y;
    localObject1 = new RadialGradient(f1, f2, (float)Math.hypot(f3 - f1, f4 - f2), arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.r.put(l, localObject1);
    return (RadialGradient)localObject1;
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    super.c(paramT, paramc);
    if (paramT == k.D)
    {
      paramT = this.y;
      if (paramT != null) {
        this.f.C(paramT);
      }
      if (paramc == null)
      {
        this.y = null;
      }
      else
      {
        paramT = new p(paramc);
        this.y = paramT;
        paramT.a(this);
        this.f.i(this.y);
      }
    }
  }
  
  public void g(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (this.p) {
      return;
    }
    e(this.s, paramMatrix, false);
    Object localObject;
    if (this.t == GradientType.LINEAR) {
      localObject = k();
    } else {
      localObject = l();
    }
    ((Shader)localObject).setLocalMatrix(paramMatrix);
    this.i.setShader((Shader)localObject);
    super.g(paramCanvas, paramMatrix, paramInt);
  }
  
  public String getName()
  {
    return this.o;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */