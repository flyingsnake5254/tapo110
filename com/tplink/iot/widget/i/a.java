package com.tplink.iot.widget.i;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class a
  implements View.OnTouchListener
{
  private float c;
  private final int d;
  private final int f;
  private int q;
  private float x;
  private long y;
  
  public a(float paramFloat, long paramLong)
  {
    this.x = paramFloat;
    this.y = paramLong;
    this.c = 1.0F;
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F)) {
      this.x = 0.8F;
    }
    this.f = 1;
    this.q = 1;
  }
  
  private final void d(final View paramView, float paramFloat1, float paramFloat2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    j.d(localValueAnimator, "animator");
    localValueAnimator.setDuration(this.y);
    localValueAnimator.setInterpolator(new FastOutSlowInInterpolator());
    localValueAnimator.addUpdateListener(new a(this, paramView));
    localValueAnimator.start();
  }
  
  public final void c(View paramView)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(this);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    j.e(paramView, "view");
    j.e(paramMotionEvent, "event");
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label194;
          }
        }
        else
        {
          float f1 = paramView.getWidth();
          float f2 = paramMotionEvent.getX();
          if ((f2 >= 0.0F) && (f2 <= f1))
          {
            f2 = paramView.getHeight();
            f1 = paramMotionEvent.getY();
            if ((f1 >= 0.0F) && (f1 <= f2)) {
              break label194;
            }
          }
          if (this.q != this.d) {
            break label194;
          }
          d(paramView, this.c, 1.0F);
          this.q = this.f;
          break label194;
        }
      }
      if (this.q == this.d)
      {
        d(paramView, this.c, 1.0F);
        this.q = this.f;
      }
    }
    else if (this.q == this.f)
    {
      d(paramView, this.c, this.x);
      this.q = this.d;
    }
    label194:
    return false;
  }
  
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(a parama, View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      a locala = this.c;
      j.d(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      Objects.requireNonNull(paramValueAnimator, "null cannot be cast to non-null type kotlin.Float");
      a.b(locala, ((Float)paramValueAnimator).floatValue());
      paramView.setScaleX(a.a(this.c));
      paramView.setScaleY(a.a(this.c));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */