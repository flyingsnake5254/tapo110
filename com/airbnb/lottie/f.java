package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.u.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class f
  extends Drawable
  implements Drawable.Callback, Animatable
{
  private static final String c = f.class.getSimpleName();
  @Nullable
  private com.airbnb.lottie.t.b H3;
  @Nullable
  private String I3;
  @Nullable
  private b J3;
  @Nullable
  private com.airbnb.lottie.t.a K3;
  @Nullable
  a L3;
  @Nullable
  r M3;
  private boolean N3;
  @Nullable
  private com.airbnb.lottie.model.layer.b O3;
  private int P3;
  private boolean Q3;
  private boolean R3;
  private boolean S3;
  private boolean T3;
  private final Matrix d = new Matrix();
  private d f;
  private final Set<?> p0;
  private final ArrayList<o> p1;
  private final ValueAnimator.AnimatorUpdateListener p2;
  @Nullable
  private ImageView.ScaleType p3;
  private final com.airbnb.lottie.v.e q;
  private float x;
  private boolean y;
  private boolean z;
  
  public f()
  {
    com.airbnb.lottie.v.e locale = new com.airbnb.lottie.v.e();
    this.q = locale;
    this.x = 1.0F;
    this.y = true;
    this.z = false;
    this.p0 = new HashSet();
    this.p1 = new ArrayList();
    f localf = new f();
    this.p2 = localf;
    this.P3 = 255;
    this.S3 = true;
    this.T3 = false;
    locale.addUpdateListener(localf);
  }
  
  private void d()
  {
    this.O3 = new com.airbnb.lottie.model.layer.b(this, s.a(this.f), this.f.j(), this.f);
  }
  
  private void g(@NonNull Canvas paramCanvas)
  {
    if (ImageView.ScaleType.FIT_XY == this.p3) {
      h(paramCanvas);
    } else {
      i(paramCanvas);
    }
  }
  
  private void h(Canvas paramCanvas)
  {
    if (this.O3 == null) {
      return;
    }
    int i = -1;
    Rect localRect = getBounds();
    float f1 = localRect.width() / this.f.b().width();
    float f2 = localRect.height() / this.f.b().height();
    int j = i;
    float f3 = f1;
    float f4 = f2;
    if (this.S3)
    {
      float f5 = Math.min(f1, f2);
      float f6;
      if (f5 < 1.0F)
      {
        f6 = 1.0F / f5;
        f1 /= f6;
        f2 /= f6;
      }
      else
      {
        f6 = 1.0F;
      }
      j = i;
      f3 = f1;
      f4 = f2;
      if (f6 > 1.0F)
      {
        j = paramCanvas.save();
        f3 = localRect.width() / 2.0F;
        f4 = localRect.height() / 2.0F;
        float f7 = f3 * f5;
        f5 *= f4;
        paramCanvas.translate(f3 - f7, f4 - f5);
        paramCanvas.scale(f6, f6, f7, f5);
        f4 = f2;
        f3 = f1;
      }
    }
    this.d.reset();
    this.d.preScale(f3, f4);
    this.O3.g(paramCanvas, this.d, this.P3);
    if (j > 0) {
      paramCanvas.restoreToCount(j);
    }
  }
  
  private void i(Canvas paramCanvas)
  {
    if (this.O3 == null) {
      return;
    }
    float f1 = this.x;
    float f2 = u(paramCanvas);
    if (f1 > f2)
    {
      f1 = this.x / f2;
    }
    else
    {
      f2 = f1;
      f1 = 1.0F;
    }
    int i = -1;
    if (f1 > 1.0F)
    {
      i = paramCanvas.save();
      float f3 = this.f.b().width() / 2.0F;
      float f4 = this.f.b().height() / 2.0F;
      float f5 = f3 * f2;
      float f6 = f4 * f2;
      paramCanvas.translate(A() * f3 - f5, A() * f4 - f6);
      paramCanvas.scale(f1, f1, f5, f6);
    }
    this.d.reset();
    this.d.preScale(f2, f2);
    this.O3.g(paramCanvas, this.d, this.P3);
    if (i > 0) {
      paramCanvas.restoreToCount(i);
    }
  }
  
  private void i0()
  {
    if (this.f == null) {
      return;
    }
    float f1 = A();
    setBounds(0, 0, (int)(this.f.b().width() * f1), (int)(this.f.b().height() * f1));
  }
  
  @Nullable
  private Context n()
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback == null) {
      return null;
    }
    if ((localCallback instanceof View)) {
      return ((View)localCallback).getContext();
    }
    return null;
  }
  
  private com.airbnb.lottie.t.a o()
  {
    if (getCallback() == null) {
      return null;
    }
    if (this.K3 == null) {
      this.K3 = new com.airbnb.lottie.t.a(getCallback(), this.L3);
    }
    return this.K3;
  }
  
  private com.airbnb.lottie.t.b r()
  {
    if (getCallback() == null) {
      return null;
    }
    com.airbnb.lottie.t.b localb = this.H3;
    if ((localb != null) && (!localb.b(n()))) {
      this.H3 = null;
    }
    if (this.H3 == null) {
      this.H3 = new com.airbnb.lottie.t.b(getCallback(), this.I3, this.J3, this.f.i());
    }
    return this.H3;
  }
  
  private float u(@NonNull Canvas paramCanvas)
  {
    return Math.min(paramCanvas.getWidth() / this.f.b().width(), paramCanvas.getHeight() / this.f.b().height());
  }
  
  public float A()
  {
    return this.x;
  }
  
  public float B()
  {
    return this.q.n();
  }
  
  @Nullable
  public r C()
  {
    return this.M3;
  }
  
  @Nullable
  public Typeface D(String paramString1, String paramString2)
  {
    com.airbnb.lottie.t.a locala = o();
    if (locala != null) {
      return locala.b(paramString1, paramString2);
    }
    return null;
  }
  
  public boolean E()
  {
    com.airbnb.lottie.v.e locale = this.q;
    if (locale == null) {
      return false;
    }
    return locale.isRunning();
  }
  
  public boolean F()
  {
    return this.R3;
  }
  
  public void G()
  {
    this.p1.clear();
    this.q.p();
  }
  
  @MainThread
  public void H()
  {
    if (this.O3 == null)
    {
      this.p1.add(new g());
      return;
    }
    if ((this.y) || (y() == 0)) {
      this.q.q();
    }
    if (!this.y)
    {
      float f1;
      if (B() < 0.0F) {
        f1 = v();
      } else {
        f1 = t();
      }
      N((int)f1);
      this.q.g();
    }
  }
  
  public List<com.airbnb.lottie.model.d> I(com.airbnb.lottie.model.d paramd)
  {
    if (this.O3 == null)
    {
      com.airbnb.lottie.v.d.c("Cannot resolve KeyPath. Composition is not set yet.");
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    this.O3.d(paramd, 0, localArrayList, new com.airbnb.lottie.model.d(new String[0]));
    return localArrayList;
  }
  
  @MainThread
  public void J()
  {
    if (this.O3 == null)
    {
      this.p1.add(new h());
      return;
    }
    if ((this.y) || (y() == 0)) {
      this.q.u();
    }
    if (!this.y)
    {
      float f1;
      if (B() < 0.0F) {
        f1 = v();
      } else {
        f1 = t();
      }
      N((int)f1);
      this.q.g();
    }
  }
  
  public void K(boolean paramBoolean)
  {
    this.R3 = paramBoolean;
  }
  
  public boolean L(d paramd)
  {
    if (this.f == paramd) {
      return false;
    }
    this.T3 = false;
    f();
    this.f = paramd;
    d();
    this.q.w(paramd);
    Z(this.q.getAnimatedFraction());
    d0(this.x);
    i0();
    Iterator localIterator = new ArrayList(this.p1).iterator();
    while (localIterator.hasNext())
    {
      ((o)localIterator.next()).a(paramd);
      localIterator.remove();
    }
    this.p1.clear();
    paramd.u(this.Q3);
    paramd = getCallback();
    if ((paramd instanceof ImageView))
    {
      paramd = (ImageView)paramd;
      paramd.setImageDrawable(null);
      paramd.setImageDrawable(this);
    }
    return true;
  }
  
  public void M(a parama)
  {
    this.L3 = parama;
    com.airbnb.lottie.t.a locala = this.K3;
    if (locala != null) {
      locala.c(parama);
    }
  }
  
  public void N(final int paramInt)
  {
    if (this.f == null)
    {
      this.p1.add(new c(paramInt));
      return;
    }
    this.q.x(paramInt);
  }
  
  public void O(b paramb)
  {
    this.J3 = paramb;
    com.airbnb.lottie.t.b localb = this.H3;
    if (localb != null) {
      localb.d(paramb);
    }
  }
  
  public void P(@Nullable String paramString)
  {
    this.I3 = paramString;
  }
  
  public void Q(final int paramInt)
  {
    if (this.f == null)
    {
      this.p1.add(new k(paramInt));
      return;
    }
    this.q.y(paramInt + 0.99F);
  }
  
  public void R(final String paramString)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      this.p1.add(new n(paramString));
      return;
    }
    localObject = ((d)localObject).k(paramString);
    if (localObject != null)
    {
      Q((int)(((com.airbnb.lottie.model.g)localObject).c + ((com.airbnb.lottie.model.g)localObject).d));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find marker with name ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void S(@FloatRange(from=0.0D, to=1.0D) final float paramFloat)
  {
    d locald = this.f;
    if (locald == null)
    {
      this.p1.add(new l(paramFloat));
      return;
    }
    Q((int)com.airbnb.lottie.v.g.j(locald.o(), this.f.f(), paramFloat));
  }
  
  public void T(final int paramInt1, final int paramInt2)
  {
    if (this.f == null)
    {
      this.p1.add(new b(paramInt1, paramInt2));
      return;
    }
    this.q.z(paramInt1, paramInt2 + 0.99F);
  }
  
  public void U(final String paramString)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      this.p1.add(new a(paramString));
      return;
    }
    localObject = ((d)localObject).k(paramString);
    if (localObject != null)
    {
      int i = (int)((com.airbnb.lottie.model.g)localObject).c;
      T(i, (int)((com.airbnb.lottie.model.g)localObject).d + i);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find marker with name ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void V(final int paramInt)
  {
    if (this.f == null)
    {
      this.p1.add(new i(paramInt));
      return;
    }
    this.q.A(paramInt);
  }
  
  public void W(final String paramString)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      this.p1.add(new m(paramString));
      return;
    }
    localObject = ((d)localObject).k(paramString);
    if (localObject != null)
    {
      V((int)((com.airbnb.lottie.model.g)localObject).c);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find marker with name ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void X(final float paramFloat)
  {
    d locald = this.f;
    if (locald == null)
    {
      this.p1.add(new j(paramFloat));
      return;
    }
    V((int)com.airbnb.lottie.v.g.j(locald.o(), this.f.f(), paramFloat));
  }
  
  public void Y(boolean paramBoolean)
  {
    this.Q3 = paramBoolean;
    d locald = this.f;
    if (locald != null) {
      locald.u(paramBoolean);
    }
  }
  
  public void Z(@FloatRange(from=0.0D, to=1.0D) final float paramFloat)
  {
    if (this.f == null)
    {
      this.p1.add(new d(paramFloat));
      return;
    }
    c.a("Drawable#setProgress");
    this.q.x(com.airbnb.lottie.v.g.j(this.f.o(), this.f.f(), paramFloat));
    c.b("Drawable#setProgress");
  }
  
  public void a0(int paramInt)
  {
    this.q.setRepeatCount(paramInt);
  }
  
  public void b0(int paramInt)
  {
    this.q.setRepeatMode(paramInt);
  }
  
  public <T> void c(final com.airbnb.lottie.model.d paramd, final T paramT, final com.airbnb.lottie.w.c<T> paramc)
  {
    com.airbnb.lottie.model.layer.b localb = this.O3;
    if (localb == null)
    {
      this.p1.add(new e(paramd, paramT, paramc));
      return;
    }
    com.airbnb.lottie.model.d locald = com.airbnb.lottie.model.d.a;
    int i = 1;
    boolean bool;
    if (paramd == locald)
    {
      localb.c(paramT, paramc);
    }
    else if (paramd.d() != null)
    {
      paramd.d().c(paramT, paramc);
    }
    else
    {
      paramd = I(paramd);
      for (i = 0; i < paramd.size(); i++) {
        ((com.airbnb.lottie.model.d)paramd.get(i)).d().c(paramT, paramc);
      }
      bool = true ^ paramd.isEmpty();
    }
    if (bool)
    {
      invalidateSelf();
      if (paramT == k.A) {
        Z(x());
      }
    }
  }
  
  public void c0(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void d0(float paramFloat)
  {
    this.x = paramFloat;
    i0();
  }
  
  /* Error */
  public void draw(@NonNull Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 134	com/airbnb/lottie/f:T3	Z
    //   5: ldc_w 587
    //   8: invokestatic 529	com/airbnb/lottie/c:a	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 113	com/airbnb/lottie/f:z	Z
    //   15: ifeq +22 -> 37
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 589	com/airbnb/lottie/f:g	(Landroid/graphics/Canvas;)V
    //   23: goto +19 -> 42
    //   26: astore_1
    //   27: ldc_w 591
    //   30: aload_1
    //   31: invokestatic 594	com/airbnb/lottie/v/d:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   34: goto +8 -> 42
    //   37: aload_0
    //   38: aload_1
    //   39: invokespecial 589	com/airbnb/lottie/f:g	(Landroid/graphics/Canvas;)V
    //   42: ldc_w 587
    //   45: invokestatic 532	com/airbnb/lottie/c:b	(Ljava/lang/String;)F
    //   48: pop
    //   49: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	f
    //   0	50	1	paramCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   18	23	26	finally
  }
  
  public void e()
  {
    this.p1.clear();
    this.q.cancel();
  }
  
  void e0(ImageView.ScaleType paramScaleType)
  {
    this.p3 = paramScaleType;
  }
  
  public void f()
  {
    if (this.q.isRunning()) {
      this.q.cancel();
    }
    this.f = null;
    this.O3 = null;
    this.H3 = null;
    this.q.f();
    invalidateSelf();
  }
  
  public void f0(float paramFloat)
  {
    this.q.B(paramFloat);
  }
  
  void g0(Boolean paramBoolean)
  {
    this.y = paramBoolean.booleanValue();
  }
  
  public int getAlpha()
  {
    return this.P3;
  }
  
  public int getIntrinsicHeight()
  {
    d locald = this.f;
    int i;
    if (locald == null) {
      i = -1;
    } else {
      i = (int)(locald.b().height() * A());
    }
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    d locald = this.f;
    int i;
    if (locald == null) {
      i = -1;
    } else {
      i = (int)(locald.b().width() * A());
    }
    return i;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void h0(r paramr)
  {
    this.M3 = paramr;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.invalidateDrawable(this);
  }
  
  public void invalidateSelf()
  {
    if (this.T3) {
      return;
    }
    this.T3 = true;
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.invalidateDrawable(this);
    }
  }
  
  public boolean isRunning()
  {
    return E();
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.N3 == paramBoolean) {
      return;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      com.airbnb.lottie.v.d.c("Merge paths are not supported pre-Kit Kat.");
      return;
    }
    this.N3 = paramBoolean;
    if (this.f != null) {
      d();
    }
  }
  
  public boolean j0()
  {
    boolean bool;
    if ((this.M3 == null) && (this.f.c().size() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean k()
  {
    return this.N3;
  }
  
  @MainThread
  public void l()
  {
    this.p1.clear();
    this.q.g();
  }
  
  public d m()
  {
    return this.f;
  }
  
  public int p()
  {
    return (int)this.q.j();
  }
  
  @Nullable
  public Bitmap q(String paramString)
  {
    com.airbnb.lottie.t.b localb = r();
    if (localb != null) {
      return localb.a(paramString);
    }
    return null;
  }
  
  @Nullable
  public String s()
  {
    return this.I3;
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    this.P3 = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    com.airbnb.lottie.v.d.c("Use addColorFilter instead.");
  }
  
  @MainThread
  public void start()
  {
    H();
  }
  
  @MainThread
  public void stop()
  {
    l();
  }
  
  public float t()
  {
    return this.q.l();
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.unscheduleDrawable(this, paramRunnable);
  }
  
  public float v()
  {
    return this.q.m();
  }
  
  @Nullable
  public n w()
  {
    d locald = this.f;
    if (locald != null) {
      return locald.m();
    }
    return null;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float x()
  {
    return this.q.h();
  }
  
  public int y()
  {
    return this.q.getRepeatCount();
  }
  
  public int z()
  {
    return this.q.getRepeatMode();
  }
  
  class a
    implements f.o
  {
    a(String paramString) {}
    
    public void a(d paramd)
    {
      f.this.U(paramString);
    }
  }
  
  class b
    implements f.o
  {
    b(int paramInt1, int paramInt2) {}
    
    public void a(d paramd)
    {
      f.this.T(paramInt1, paramInt2);
    }
  }
  
  class c
    implements f.o
  {
    c(int paramInt) {}
    
    public void a(d paramd)
    {
      f.this.N(paramInt);
    }
  }
  
  class d
    implements f.o
  {
    d(float paramFloat) {}
    
    public void a(d paramd)
    {
      f.this.Z(paramFloat);
    }
  }
  
  class e
    implements f.o
  {
    e(com.airbnb.lottie.model.d paramd, Object paramObject, com.airbnb.lottie.w.c paramc) {}
    
    public void a(d paramd)
    {
      f.this.c(paramd, paramT, paramc);
    }
  }
  
  class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (f.a(f.this) != null) {
        f.a(f.this).G(f.b(f.this).h());
      }
    }
  }
  
  class g
    implements f.o
  {
    g() {}
    
    public void a(d paramd)
    {
      f.this.H();
    }
  }
  
  class h
    implements f.o
  {
    h() {}
    
    public void a(d paramd)
    {
      f.this.J();
    }
  }
  
  class i
    implements f.o
  {
    i(int paramInt) {}
    
    public void a(d paramd)
    {
      f.this.V(paramInt);
    }
  }
  
  class j
    implements f.o
  {
    j(float paramFloat) {}
    
    public void a(d paramd)
    {
      f.this.X(paramFloat);
    }
  }
  
  class k
    implements f.o
  {
    k(int paramInt) {}
    
    public void a(d paramd)
    {
      f.this.Q(paramInt);
    }
  }
  
  class l
    implements f.o
  {
    l(float paramFloat) {}
    
    public void a(d paramd)
    {
      f.this.S(paramFloat);
    }
  }
  
  class m
    implements f.o
  {
    m(String paramString) {}
    
    public void a(d paramd)
    {
      f.this.W(paramString);
    }
  }
  
  class n
    implements f.o
  {
    n(String paramString) {}
    
    public void a(d paramd)
    {
      f.this.R(paramString);
    }
  }
  
  private static abstract interface o
  {
    public abstract void a(d paramd);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */