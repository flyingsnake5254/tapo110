package com.tplink.iot.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

public class FullScreenControlShowView
  extends LinearLayout
  implements View.OnClickListener
{
  private View c;
  private boolean d = true;
  private View f;
  private View q;
  private boolean x = false;
  private boolean y = false;
  private int z;
  
  public FullScreenControlShowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FullScreenControlShowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FullScreenControlShowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559421, this, true);
    this.c = findViewById(2131363187);
    this.f = findViewById(2131364814);
    this.q = findViewById(2131364789);
    this.c.setOnClickListener(this);
  }
  
  private void d()
  {
    if (this.x) {
      return;
    }
    if (this.d) {
      f(this);
    } else {
      e(this);
    }
    this.d ^= true;
    this.y = false;
  }
  
  public void e(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { getMeasuredWidth() - this.c.getMeasuredWidth(), 0.0F });
    paramView.setDuration(500L);
    paramView.addListener(new b());
    paramView.start();
  }
  
  public void f(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, getMeasuredWidth() - this.c.getMeasuredWidth() });
    paramView.setDuration(500L);
    paramView.addListener(new a());
    paramView.start();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363187) {
      d();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    if (i != 0)
    {
      if (i == 1)
      {
        if ((this.y) && (Math.abs(j - this.z) > 5))
        {
          i = this.z;
          if (((j > i) && (this.d)) || ((j < i) && (!this.d))) {
            d();
          }
        }
        this.y = false;
      }
    }
    else if ((j > 0) && (j < this.c.getMeasuredWidth()))
    {
      this.y = true;
      this.z = j;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      FullScreenControlShowView.b(FullScreenControlShowView.this).setVisibility(0);
      FullScreenControlShowView.c(FullScreenControlShowView.this).setVisibility(4);
      FullScreenControlShowView.a(FullScreenControlShowView.this, false);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      FullScreenControlShowView.a(FullScreenControlShowView.this, true);
    }
  }
  
  class b
    implements Animator.AnimatorListener
  {
    b() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      FullScreenControlShowView.b(FullScreenControlShowView.this).setVisibility(4);
      FullScreenControlShowView.c(FullScreenControlShowView.this).setVisibility(0);
      FullScreenControlShowView.a(FullScreenControlShowView.this, false);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      FullScreenControlShowView.a(FullScreenControlShowView.this, true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\FullScreenControlShowView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */