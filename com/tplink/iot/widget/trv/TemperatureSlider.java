package com.tplink.iot.widget.trv;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.Objects;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class TemperatureSlider
  extends FrameLayout
{
  private int H3;
  private int I3;
  private final boolean J3;
  private a K3;
  private float L3;
  private float M3;
  private ValueAnimator N3;
  private boolean O3;
  private final float c = k(150);
  private final float d = k(200);
  private final float f = k(360);
  private final Paint p0;
  private int p1;
  private int p2;
  private final int p3;
  private final float q = k(16);
  private final f x = h.b(new d(this));
  private final RectF y = new RectF();
  private final Path z = new Path();
  
  public TemperatureSlider(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public TemperatureSlider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public TemperatureSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new Paint();
    paramAttributeSet.setAntiAlias(true);
    paramAttributeSet.setColor(-1);
    paramContext = p.a;
    this.p0 = paramAttributeSet;
    this.J3 = true;
    setWillNotDraw(false);
    p(5, 30);
  }
  
  private final float d()
  {
    int i = this.I3;
    int j = this.p3;
    float f1 = (i - j) / (this.H3 - j);
    this.M3 = f1;
    return f1;
  }
  
  private final float e()
  {
    return (1.0F - this.M3) * getHeight();
  }
  
  private final void f(boolean paramBoolean)
  {
    a locala = this.K3;
    if (locala != null) {
      locala.N0(this.I3, h());
    }
    if (paramBoolean)
    {
      locala = this.K3;
      if (locala != null) {
        locala.y(this.I3, h());
      }
    }
  }
  
  private final GradientDrawable getMBgGradientDrawable()
  {
    return (GradientDrawable)this.x.getValue();
  }
  
  private final int h()
  {
    int i;
    if (this.J3) {
      i = this.I3 + this.p1 - 1;
    } else {
      i = this.I3 + this.p1;
    }
    return i;
  }
  
  private final int i(int paramInt)
  {
    if (this.J3) {
      paramInt = paramInt - this.p1 + 1;
    } else {
      paramInt -= this.p1;
    }
    return paramInt;
  }
  
  private final ValueAnimator j()
  {
    ValueAnimator localValueAnimator = this.N3;
    if (localValueAnimator != null) {
      return localValueAnimator;
    }
    localValueAnimator = ValueAnimator.ofFloat(new float[] { this.M3, 0.0F });
    localValueAnimator.addUpdateListener(new b(this));
    localValueAnimator.addListener(new c(this));
    localValueAnimator.setDuration(200L);
    this.N3 = localValueAnimator;
    j.d(localValueAnimator, "ValueAnimator.ofFloat(mS…ator = this\n            }");
    return localValueAnimator;
  }
  
  private final float k(int paramInt)
  {
    float f1 = paramInt;
    Object localObject = getContext();
    j.d(localObject, "context");
    localObject = ((Context)localObject).getResources();
    j.d(localObject, "context.resources");
    return TypedValue.applyDimension(1, f1, ((Resources)localObject).getDisplayMetrics());
  }
  
  private final void l()
  {
    int i = this.I3;
    float f1;
    if (i == this.p3) {
      f1 = 0.0F;
    } else if (i == this.H3) {
      f1 = 1.0F;
    } else {
      f1 = this.M3;
    }
    this.M3 = f1;
    invalidate();
    f(true);
  }
  
  private final void o(float paramFloat)
  {
    paramFloat = Math.min(Math.max(0.0F, this.M3 + paramFloat), 1.0F);
    this.M3 = paramFloat;
    this.I3 = kotlin.s.a.b(paramFloat * (this.H3 - this.p3));
    invalidate();
    g(this, false, 1, null);
  }
  
  public final int getMaxProgress()
  {
    return this.H3;
  }
  
  public final int getMaxValue()
  {
    return this.p2;
  }
  
  public final int getMinProgress()
  {
    return this.p3;
  }
  
  public final int getMinValue()
  {
    return this.p1;
  }
  
  public final int getProgress()
  {
    return this.I3;
  }
  
  public final void m(int paramInt, boolean paramBoolean)
  {
    if (!this.O3)
    {
      int i = this.p1;
      int j = this.p2;
      if ((i <= paramInt) && (j >= paramInt))
      {
        this.I3 = i(paramInt);
        if (paramBoolean)
        {
          ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.M3, d() });
          localValueAnimator.addUpdateListener(new e(this));
          localValueAnimator.setDuration(200L);
          localValueAnimator.start();
        }
        else
        {
          d();
          invalidate();
        }
      }
    }
  }
  
  public final void n(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator;
    if (paramBoolean)
    {
      localValueAnimator = j();
      localValueAnimator.setFloatValues(new float[] { this.M3, 0.0F });
      localValueAnimator.start();
    }
    else
    {
      localValueAnimator = this.N3;
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      this.M3 = 0.0F;
      this.I3 = this.p3;
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.clipPath(this.z);
    getMBgGradientDrawable().draw(paramCanvas);
    paramCanvas.drawRect(0.0F, e(), getWidth(), getHeight(), this.p0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.y.set(0.0F, 0.0F, getWidth(), getHeight());
    this.z.reset();
    Path localPath = this.z;
    RectF localRectF = this.y;
    float f1 = this.q;
    localPath.addRoundRect(localRectF, f1, f1, Path.Direction.CW);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(Math.min(getMeasuredWidth(), (int)this.c), Math.max((int)this.d, Math.min(getMeasuredHeight(), (int)this.f)));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    j.e(paramMotionEvent, "event");
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label128;
          }
        }
        else
        {
          this.O3 = true;
          o((this.L3 - paramMotionEvent.getY()) / getHeight());
          this.L3 = paramMotionEvent.getY();
          break label128;
        }
      }
      this.O3 = false;
      this.L3 = 0.0F;
      l();
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    else
    {
      this.O3 = true;
      this.L3 = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    label128:
    return true;
  }
  
  public final void p(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return;
    }
    this.p1 = paramInt1;
    this.p2 = paramInt2;
    if (this.J3) {
      paramInt1 = paramInt2 - paramInt1 + 1;
    } else {
      paramInt1 = paramInt2 - paramInt1;
    }
    this.H3 = paramInt1;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.6F;
    }
    setAlpha(f1);
  }
  
  public final void setOnSliderChangeListener(a parama)
  {
    this.K3 = parama;
  }
  
  public static abstract interface a
  {
    public abstract void N0(int paramInt1, int paramInt2);
    
    public abstract void y(int paramInt1, int paramInt2);
  }
  
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(TemperatureSlider paramTemperatureSlider) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      TemperatureSlider localTemperatureSlider = this.c;
      j.d(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      Objects.requireNonNull(paramValueAnimator, "null cannot be cast to non-null type kotlin.Float");
      TemperatureSlider.c(localTemperatureSlider, ((Float)paramValueAnimator).floatValue());
      this.c.invalidate();
    }
  }
  
  public static final class c
    implements Animator.AnimatorListener
  {
    public c(TemperatureSlider paramTemperatureSlider) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      j.f(paramAnimator, "animator");
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      j.f(paramAnimator, "animator");
      TemperatureSlider.c(this.c, 0.0F);
      paramAnimator = this.c;
      TemperatureSlider.b(paramAnimator, TemperatureSlider.a(paramAnimator));
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      j.f(paramAnimator, "animator");
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      j.f(paramAnimator, "animator");
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<GradientDrawable>
  {
    d(TemperatureSlider paramTemperatureSlider)
    {
      super();
    }
    
    public final GradientDrawable a()
    {
      GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 335544320, 503316480 });
      localGradientDrawable.setBounds(0, 0, this.c.getWidth(), this.c.getHeight());
      return localGradientDrawable;
    }
  }
  
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(TemperatureSlider paramTemperatureSlider) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      TemperatureSlider localTemperatureSlider = this.c;
      j.d(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      Objects.requireNonNull(paramValueAnimator, "null cannot be cast to non-null type kotlin.Float");
      TemperatureSlider.c(localTemperatureSlider, ((Float)paramValueAnimator).floatValue());
      this.c.invalidate();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\trv\TemperatureSlider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */