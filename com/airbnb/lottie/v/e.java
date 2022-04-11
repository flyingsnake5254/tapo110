package com.airbnb.lottie.v;

import android.animation.ValueAnimator;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;

public class e
  extends a
  implements Choreographer.FrameCallback
{
  private float f = 1.0F;
  private float p0 = -2.14748365E9F;
  private float p1 = 2.14748365E9F;
  @Nullable
  private d p2;
  @VisibleForTesting
  protected boolean p3 = false;
  private boolean q = false;
  private long x = 0L;
  private float y = 0.0F;
  private int z = 0;
  
  private void C()
  {
    if (this.p2 == null) {
      return;
    }
    float f1 = this.y;
    if ((f1 >= this.p0) && (f1 <= this.p1)) {
      return;
    }
    throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[] { Float.valueOf(this.p0), Float.valueOf(this.p1), Float.valueOf(this.y) }));
  }
  
  private float k()
  {
    d locald = this.p2;
    if (locald == null) {
      return Float.MAX_VALUE;
    }
    return 1.0E9F / locald.h() / Math.abs(this.f);
  }
  
  private boolean o()
  {
    boolean bool;
    if (n() < 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void A(int paramInt)
  {
    z(paramInt, (int)this.p1);
  }
  
  public void B(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  @MainThread
  public void cancel()
  {
    a();
    s();
  }
  
  public void doFrame(long paramLong)
  {
    r();
    if ((this.p2 != null) && (isRunning()))
    {
      c.a("LottieValueAnimator#doFrame");
      long l1 = this.x;
      long l2 = 0L;
      if (l1 != 0L) {
        l2 = paramLong - l1;
      }
      float f1 = k();
      float f2 = (float)l2 / f1;
      float f3 = this.y;
      f1 = f2;
      if (o()) {
        f1 = -f2;
      }
      f1 = f3 + f1;
      this.y = f1;
      boolean bool = g.d(f1, m(), l());
      this.y = g.b(this.y, m(), l());
      this.x = paramLong;
      e();
      if ((bool ^ true)) {
        if ((getRepeatCount() != -1) && (this.z >= getRepeatCount()))
        {
          if (this.f < 0.0F) {
            f1 = m();
          } else {
            f1 = l();
          }
          this.y = f1;
          s();
          b(o());
        }
        else
        {
          c();
          this.z += 1;
          if (getRepeatMode() == 2)
          {
            this.q ^= true;
            v();
          }
          else
          {
            if (o()) {
              f1 = l();
            } else {
              f1 = m();
            }
            this.y = f1;
          }
          this.x = paramLong;
        }
      }
      C();
      c.b("LottieValueAnimator#doFrame");
    }
  }
  
  public void f()
  {
    this.p2 = null;
    this.p0 = -2.14748365E9F;
    this.p1 = 2.14748365E9F;
  }
  
  @MainThread
  public void g()
  {
    s();
    b(o());
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getAnimatedFraction()
  {
    if (this.p2 == null) {
      return 0.0F;
    }
    float f1;
    float f2;
    if (o())
    {
      f1 = l() - this.y;
      f2 = l();
    }
    for (float f3 = m();; f3 = m())
    {
      return f1 / (f2 - f3);
      f1 = this.y - m();
      f2 = l();
    }
  }
  
  public Object getAnimatedValue()
  {
    return Float.valueOf(h());
  }
  
  public long getDuration()
  {
    d locald = this.p2;
    long l;
    if (locald == null) {
      l = 0L;
    } else {
      l = locald.d();
    }
    return l;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float h()
  {
    d locald = this.p2;
    if (locald == null) {
      return 0.0F;
    }
    return (this.y - locald.o()) / (this.p2.f() - this.p2.o());
  }
  
  public boolean isRunning()
  {
    return this.p3;
  }
  
  public float j()
  {
    return this.y;
  }
  
  public float l()
  {
    d locald = this.p2;
    if (locald == null) {
      return 0.0F;
    }
    float f1 = this.p1;
    float f2 = f1;
    if (f1 == 2.14748365E9F) {
      f2 = locald.f();
    }
    return f2;
  }
  
  public float m()
  {
    d locald = this.p2;
    if (locald == null) {
      return 0.0F;
    }
    float f1 = this.p0;
    float f2 = f1;
    if (f1 == -2.14748365E9F) {
      f2 = locald.o();
    }
    return f2;
  }
  
  public float n()
  {
    return this.f;
  }
  
  @MainThread
  public void p()
  {
    s();
  }
  
  @MainThread
  public void q()
  {
    this.p3 = true;
    d(o());
    float f1;
    if (o()) {
      f1 = l();
    } else {
      f1 = m();
    }
    x((int)f1);
    this.x = 0L;
    this.z = 0;
    r();
  }
  
  protected void r()
  {
    if (isRunning())
    {
      t(false);
      Choreographer.getInstance().postFrameCallback(this);
    }
  }
  
  @MainThread
  protected void s()
  {
    t(true);
  }
  
  public void setRepeatMode(int paramInt)
  {
    super.setRepeatMode(paramInt);
    if ((paramInt != 2) && (this.q))
    {
      this.q = false;
      v();
    }
  }
  
  @MainThread
  protected void t(boolean paramBoolean)
  {
    Choreographer.getInstance().removeFrameCallback(this);
    if (paramBoolean) {
      this.p3 = false;
    }
  }
  
  @MainThread
  public void u()
  {
    this.p3 = true;
    r();
    this.x = 0L;
    if ((o()) && (j() == m())) {
      this.y = l();
    } else if ((!o()) && (j() == l())) {
      this.y = m();
    }
  }
  
  public void v()
  {
    B(-n());
  }
  
  public void w(d paramd)
  {
    int i;
    if (this.p2 == null) {
      i = 1;
    } else {
      i = 0;
    }
    this.p2 = paramd;
    if (i != 0) {
      z((int)Math.max(this.p0, paramd.o()), (int)Math.min(this.p1, paramd.f()));
    } else {
      z((int)paramd.o(), (int)paramd.f());
    }
    float f1 = this.y;
    this.y = 0.0F;
    x((int)f1);
    e();
  }
  
  public void x(float paramFloat)
  {
    if (this.y == paramFloat) {
      return;
    }
    this.y = g.b(paramFloat, m(), l());
    this.x = 0L;
    e();
  }
  
  public void y(float paramFloat)
  {
    z(this.p0, paramFloat);
  }
  
  public void z(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 <= paramFloat2)
    {
      d locald = this.p2;
      float f1;
      if (locald == null) {
        f1 = -3.4028235E38F;
      } else {
        f1 = locald.o();
      }
      locald = this.p2;
      float f2;
      if (locald == null) {
        f2 = Float.MAX_VALUE;
      } else {
        f2 = locald.f();
      }
      this.p0 = g.b(paramFloat1, f1, f2);
      this.p1 = g.b(paramFloat2, f1, f2);
      x((int)g.b(this.y, paramFloat1, paramFloat2));
      return;
    }
    throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\v\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */