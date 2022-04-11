package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ScrollView;

public class TPFlexiblaScrollView
  extends ScrollView
{
  private static String c = TPFlexiblaScrollView.class.getSimpleName();
  private float d = 0.35F;
  private View f;
  private boolean p0 = true;
  int p1 = 0;
  int p2 = 0;
  long p3 = 0L;
  private float q;
  private Rect x = new Rect();
  private boolean y = false;
  boolean z = false;
  
  public TPFlexiblaScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPFlexiblaScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TPFlexiblaScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e(boolean paramBoolean, int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, Math.min(paramInt / 100 + 10, 150) });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new c0(this, paramBoolean));
    localValueAnimator.addListener(new a());
    localValueAnimator.start();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.f != null) {
      f(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void f(MotionEvent paramMotionEvent)
  {
    if (this.y) {
      return;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          float f1 = this.q;
          float f2 = paramMotionEvent.getRawY();
          i = (int)((f1 - f2) * this.d);
          this.q = f2;
          if (h())
          {
            int j = this.f.getTop();
            paramMotionEvent = this.f;
            paramMotionEvent.layout(paramMotionEvent.getLeft(), j - i, this.f.getRight(), this.f.getBottom() - i);
          }
        }
      }
      else
      {
        this.z = true;
        if (g()) {
          o();
        }
      }
    }
    else
    {
      this.q = paramMotionEvent.getRawY();
      this.z = false;
    }
  }
  
  public boolean g()
  {
    return this.x.isEmpty() ^ true;
  }
  
  public boolean h()
  {
    int i = this.f.getMeasuredHeight();
    int j = getHeight();
    int k = getScrollY();
    boolean bool;
    if ((k != 0) && (k != i - j)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void o()
  {
    this.p0 = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.x.top - this.f.getTop(), 0 });
    localValueAnimator.addUpdateListener(new b0(this));
    localValueAnimator.addListener(new b());
    localValueAnimator.setDuration(Math.abs((this.x.top - this.f.getTop()) / 2) + 200);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.start();
    this.y = true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      this.f = localView;
      localView.post(new a0(this));
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (((paramInt2 == 0) || (paramInt2 == computeVerticalScrollRange() - getMeasuredHeight())) && (this.z))
    {
      paramBoolean1 = false;
      this.z = false;
      paramInt1 = (paramInt2 - this.p2) * 1000 / (int)(System.currentTimeMillis() - this.p3);
      if (paramInt2 == 0) {
        paramBoolean1 = true;
      }
      e(paramBoolean1, Math.abs(paramInt1));
    }
    this.p2 = paramInt2;
    this.p3 = System.currentTimeMillis();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    getScrollY();
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      paramAnimator = TPFlexiblaScrollView.this;
      paramAnimator.z = true;
      paramAnimator.o();
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = TPFlexiblaScrollView.this;
      paramAnimator.z = true;
      paramAnimator.o();
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class b
    implements Animator.AnimatorListener
  {
    b() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      TPFlexiblaScrollView.d(TPFlexiblaScrollView.this).layout(TPFlexiblaScrollView.c(TPFlexiblaScrollView.this).left, TPFlexiblaScrollView.c(TPFlexiblaScrollView.this).top, TPFlexiblaScrollView.c(TPFlexiblaScrollView.this).right, TPFlexiblaScrollView.c(TPFlexiblaScrollView.this).bottom);
      TPFlexiblaScrollView.a(TPFlexiblaScrollView.this, false);
      TPFlexiblaScrollView.this.z = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPFlexiblaScrollView.a(TPFlexiblaScrollView.this, false);
      TPFlexiblaScrollView.b(TPFlexiblaScrollView.this, true);
      TPFlexiblaScrollView.this.z = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      TPFlexiblaScrollView.a(TPFlexiblaScrollView.this, true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPFlexiblaScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */