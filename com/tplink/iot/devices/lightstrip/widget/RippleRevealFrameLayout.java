package com.tplink.iot.devices.lightstrip.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.FloatRange;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class RippleRevealFrameLayout
  extends FrameLayout
  implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener
{
  private final Path c = new Path();
  private float d = 1.0F;
  private boolean f;
  private boolean q = true;
  private final ValueAnimator x;
  
  public RippleRevealFrameLayout(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public RippleRevealFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public RippleRevealFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramContext.addUpdateListener(this);
    paramContext.addListener(this);
    paramAttributeSet = p.a;
    this.x = paramContext;
  }
  
  private final void e(float paramFloat1, float paramFloat2)
  {
    if (this.f)
    {
      this.x.reverse();
    }
    else
    {
      this.x.setFloatValues(new float[] { paramFloat1, paramFloat2 });
      this.x.start();
    }
  }
  
  private final void setRevealFraction(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.d = paramFloat;
    setAlpha(paramFloat);
    invalidate();
  }
  
  public final void a()
  {
    if (this.q)
    {
      this.q = false;
      e(1.0F, 0.0F);
    }
  }
  
  public final void b()
  {
    this.q = false;
    setRevealFraction(0.0F);
  }
  
  public final void c()
  {
    if (!this.q)
    {
      this.q = true;
      e(0.0F, 1.0F);
    }
  }
  
  public final void d()
  {
    this.q = true;
    setRevealFraction(1.0F);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    j.e(paramCanvas, "canvas");
    if (this.f)
    {
      float f1 = getHeight();
      float f2 = this.d;
      Path localPath = this.c;
      localPath.reset();
      localPath.moveTo(0.0F, getHeight());
      localPath.lineTo(0.0F, f1 * (1.0F - f2));
      localPath.rCubicTo(0.0F, 0.0F, getWidth() / 2.0F, -150.0F, getWidth(), 0.0F);
      localPath.lineTo(getWidth(), getHeight());
      localPath.lineTo(0.0F, getHeight());
      paramCanvas.save();
      paramCanvas.clipPath(this.c);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restore();
      return bool;
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.f = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.f = false;
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.f = true;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.f = true;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    j.e(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    Objects.requireNonNull(paramValueAnimator, "null cannot be cast to non-null type kotlin.Float");
    setRevealFraction(((Float)paramValueAnimator).floatValue());
  }
  
  public final void setAnimDuration(long paramLong)
  {
    ValueAnimator localValueAnimator = this.x;
    j.d(localValueAnimator, "mValueAnimator");
    localValueAnimator.setDuration(paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\RippleRevealFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */