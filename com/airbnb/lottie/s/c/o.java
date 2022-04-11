package com.airbnb.lottie.s.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.e;
import com.airbnb.lottie.model.i.g;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.model.i.m;
import java.util.Collections;

public class o
{
  private final Matrix a = new Matrix();
  private final Matrix b;
  private final Matrix c;
  private final Matrix d;
  private final float[] e;
  @NonNull
  private a<PointF, PointF> f;
  @NonNull
  private a<?, PointF> g;
  @NonNull
  private a<com.airbnb.lottie.w.d, com.airbnb.lottie.w.d> h;
  @NonNull
  private a<Float, Float> i;
  @NonNull
  private a<Integer, Integer> j;
  @Nullable
  private c k;
  @Nullable
  private c l;
  @Nullable
  private a<?, Float> m;
  @Nullable
  private a<?, Float> n;
  
  public o(l paraml)
  {
    Object localObject;
    if (paraml.c() == null) {
      localObject = null;
    } else {
      localObject = paraml.c().a();
    }
    this.f = ((a)localObject);
    if (paraml.f() == null) {
      localObject = null;
    } else {
      localObject = paraml.f().a();
    }
    this.g = ((a)localObject);
    if (paraml.h() == null) {
      localObject = null;
    } else {
      localObject = paraml.h().a();
    }
    this.h = ((a)localObject);
    if (paraml.g() == null) {
      localObject = null;
    } else {
      localObject = paraml.g().a();
    }
    this.i = ((a)localObject);
    if (paraml.i() == null) {
      localObject = null;
    } else {
      localObject = (c)paraml.i().a();
    }
    this.k = ((c)localObject);
    if (localObject != null)
    {
      this.b = new Matrix();
      this.c = new Matrix();
      this.d = new Matrix();
      this.e = new float[9];
    }
    else
    {
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
    }
    if (paraml.j() == null) {
      localObject = null;
    } else {
      localObject = (c)paraml.j().a();
    }
    this.l = ((c)localObject);
    if (paraml.e() != null) {
      this.j = paraml.e().a();
    }
    if (paraml.k() != null) {
      this.m = paraml.k().a();
    } else {
      this.m = null;
    }
    if (paraml.d() != null) {
      this.n = paraml.d().a();
    } else {
      this.n = null;
    }
  }
  
  private void d()
  {
    for (int i1 = 0; i1 < 9; i1++) {
      this.e[i1] = 0.0F;
    }
  }
  
  public void a(com.airbnb.lottie.model.layer.a parama)
  {
    parama.i(this.j);
    parama.i(this.m);
    parama.i(this.n);
    parama.i(this.f);
    parama.i(this.g);
    parama.i(this.h);
    parama.i(this.i);
    parama.i(this.k);
    parama.i(this.l);
  }
  
  public void b(a.b paramb)
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((a)localObject).a(paramb);
    }
    localObject = this.m;
    if (localObject != null) {
      ((a)localObject).a(paramb);
    }
    localObject = this.n;
    if (localObject != null) {
      ((a)localObject).a(paramb);
    }
    localObject = this.f;
    if (localObject != null) {
      ((a)localObject).a(paramb);
    }
    localObject = this.g;
    if (localObject != null) {
      ((a)localObject).a(paramb);
    }
    localObject = this.h;
    if (localObject != null) {
      ((a)localObject).a(paramb);
    }
    localObject = this.i;
    if (localObject != null) {
      ((a)localObject).a(paramb);
    }
    localObject = this.k;
    if (localObject != null) {
      ((a)localObject).a(paramb);
    }
    localObject = this.l;
    if (localObject != null) {
      ((a)localObject).a(paramb);
    }
  }
  
  public <T> boolean c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    if (paramT == k.e)
    {
      paramT = this.f;
      if (paramT == null) {
        this.f = new p(paramc, new PointF());
      } else {
        paramT.m(paramc);
      }
    }
    else if (paramT == k.f)
    {
      paramT = this.g;
      if (paramT == null) {
        this.g = new p(paramc, new PointF());
      } else {
        paramT.m(paramc);
      }
    }
    else if (paramT == k.k)
    {
      paramT = this.h;
      if (paramT == null) {
        this.h = new p(paramc, new com.airbnb.lottie.w.d());
      } else {
        paramT.m(paramc);
      }
    }
    else if (paramT == k.l)
    {
      paramT = this.i;
      if (paramT == null) {
        this.i = new p(paramc, Float.valueOf(0.0F));
      } else {
        paramT.m(paramc);
      }
    }
    else if (paramT == k.c)
    {
      paramT = this.j;
      if (paramT == null) {
        this.j = new p(paramc, Integer.valueOf(100));
      } else {
        paramT.m(paramc);
      }
    }
    else
    {
      Object localObject;
      if (paramT == k.y)
      {
        localObject = this.m;
        if (localObject != null)
        {
          if (localObject == null)
          {
            this.m = new p(paramc, Integer.valueOf(100));
            break label430;
          }
          ((a)localObject).m(paramc);
          break label430;
        }
      }
      if (paramT == k.z)
      {
        localObject = this.n;
        if (localObject != null)
        {
          if (localObject == null)
          {
            this.n = new p(paramc, Integer.valueOf(100));
            break label430;
          }
          ((a)localObject).m(paramc);
          break label430;
        }
      }
      if (paramT == k.m)
      {
        localObject = this.k;
        if (localObject != null)
        {
          if (localObject == null) {
            this.k = new c(Collections.singletonList(new com.airbnb.lottie.w.a(Float.valueOf(0.0F))));
          }
          this.k.m(paramc);
          break label430;
        }
      }
      if (paramT != k.n) {
        break label432;
      }
      paramT = this.l;
      if (paramT == null) {
        break label432;
      }
      if (paramT == null) {
        this.l = new c(Collections.singletonList(new com.airbnb.lottie.w.a(Float.valueOf(0.0F))));
      }
      this.l.m(paramc);
    }
    label430:
    return true;
    label432:
    return false;
  }
  
  @Nullable
  public a<?, Float> e()
  {
    return this.n;
  }
  
  public Matrix f()
  {
    this.a.reset();
    Object localObject = this.g;
    float f1;
    if (localObject != null)
    {
      localObject = (PointF)((a)localObject).h();
      f1 = ((PointF)localObject).x;
      if ((f1 != 0.0F) || (((PointF)localObject).y != 0.0F)) {
        this.a.preTranslate(f1, ((PointF)localObject).y);
      }
    }
    localObject = this.i;
    if (localObject != null)
    {
      if ((localObject instanceof p)) {
        f1 = ((Float)((a)localObject).h()).floatValue();
      } else {
        f1 = ((c)localObject).o();
      }
      if (f1 != 0.0F) {
        this.a.preRotate(f1);
      }
    }
    if (this.k != null)
    {
      localObject = this.l;
      if (localObject == null) {
        f1 = 0.0F;
      } else {
        f1 = (float)Math.cos(Math.toRadians(-((c)localObject).o() + 90.0F));
      }
      localObject = this.l;
      float f2;
      if (localObject == null) {
        f2 = 1.0F;
      } else {
        f2 = (float)Math.sin(Math.toRadians(-((c)localObject).o() + 90.0F));
      }
      float f3 = (float)Math.tan(Math.toRadians(this.k.o()));
      d();
      localObject = this.e;
      localObject[0] = f1;
      localObject[1] = f2;
      float f4 = -f2;
      localObject[3] = f4;
      localObject[4] = f1;
      localObject[8] = 1.0F;
      this.b.setValues((float[])localObject);
      d();
      localObject = this.e;
      localObject[0] = 1.0F;
      localObject[3] = f3;
      localObject[4] = 1.0F;
      localObject[8] = 1.0F;
      this.c.setValues((float[])localObject);
      d();
      localObject = this.e;
      localObject[0] = f1;
      localObject[1] = f4;
      localObject[3] = f2;
      localObject[4] = f1;
      localObject[8] = 1.0F;
      this.d.setValues((float[])localObject);
      this.c.preConcat(this.b);
      this.d.preConcat(this.c);
      this.a.preConcat(this.d);
    }
    localObject = this.h;
    if (localObject != null)
    {
      localObject = (com.airbnb.lottie.w.d)((a)localObject).h();
      if ((((com.airbnb.lottie.w.d)localObject).b() != 1.0F) || (((com.airbnb.lottie.w.d)localObject).c() != 1.0F)) {
        this.a.preScale(((com.airbnb.lottie.w.d)localObject).b(), ((com.airbnb.lottie.w.d)localObject).c());
      }
    }
    localObject = this.f;
    if (localObject != null)
    {
      localObject = (PointF)((a)localObject).h();
      f1 = ((PointF)localObject).x;
      if ((f1 != 0.0F) || (((PointF)localObject).y != 0.0F)) {
        this.a.preTranslate(-f1, -((PointF)localObject).y);
      }
    }
    return this.a;
  }
  
  public Matrix g(float paramFloat)
  {
    Object localObject1 = this.g;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (PointF)((a)localObject1).h();
    }
    Object localObject3 = this.h;
    if (localObject3 == null) {
      localObject3 = null;
    } else {
      localObject3 = (com.airbnb.lottie.w.d)((a)localObject3).h();
    }
    this.a.reset();
    if (localObject1 != null) {
      this.a.preTranslate(((PointF)localObject1).x * paramFloat, ((PointF)localObject1).y * paramFloat);
    }
    if (localObject3 != null)
    {
      localObject1 = this.a;
      double d1 = ((com.airbnb.lottie.w.d)localObject3).b();
      double d2 = paramFloat;
      ((Matrix)localObject1).preScale((float)Math.pow(d1, d2), (float)Math.pow(((com.airbnb.lottie.w.d)localObject3).c(), d2));
    }
    localObject1 = this.i;
    if (localObject1 != null)
    {
      float f1 = ((Float)((a)localObject1).h()).floatValue();
      localObject1 = this.f;
      if (localObject1 == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = (PointF)((a)localObject1).h();
      }
      localObject3 = this.a;
      float f2 = 0.0F;
      float f3;
      if (localObject1 == null) {
        f3 = 0.0F;
      } else {
        f3 = ((PointF)localObject1).x;
      }
      if (localObject1 != null) {
        f2 = ((PointF)localObject1).y;
      }
      ((Matrix)localObject3).preRotate(f1 * paramFloat, f3, f2);
    }
    return this.a;
  }
  
  @Nullable
  public a<?, Integer> h()
  {
    return this.j;
  }
  
  @Nullable
  public a<?, Float> i()
  {
    return this.m;
  }
  
  public void j(float paramFloat)
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((a)localObject).l(paramFloat);
    }
    localObject = this.m;
    if (localObject != null) {
      ((a)localObject).l(paramFloat);
    }
    localObject = this.n;
    if (localObject != null) {
      ((a)localObject).l(paramFloat);
    }
    localObject = this.f;
    if (localObject != null) {
      ((a)localObject).l(paramFloat);
    }
    localObject = this.g;
    if (localObject != null) {
      ((a)localObject).l(paramFloat);
    }
    localObject = this.h;
    if (localObject != null) {
      ((a)localObject).l(paramFloat);
    }
    localObject = this.i;
    if (localObject != null) {
      ((a)localObject).l(paramFloat);
    }
    localObject = this.k;
    if (localObject != null) {
      ((a)localObject).l(paramFloat);
    }
    localObject = this.l;
    if (localObject != null) {
      ((a)localObject).l(paramFloat);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */