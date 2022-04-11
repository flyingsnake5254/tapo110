package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.tplink.libtpcontrols.l0;
import com.tplink.libtpcontrols.q0;
import com.tplink.libtpcontrols.r0;

@SuppressLint({"ViewConstructor"})
public class IndicatorLayout
  extends FrameLayout
  implements Animation.AnimationListener
{
  private Animation c;
  private Animation d;
  private ImageView f;
  private final Animation q;
  private final Animation x;
  
  public IndicatorLayout(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext);
    this.f = new ImageView(paramContext);
    Drawable localDrawable = getResources().getDrawable(r0.indicator_arrow);
    this.f.setImageDrawable(localDrawable);
    int i = getResources().getDimensionPixelSize(q0.indicator_internal_padding);
    this.f.setPadding(i, i, i, i);
    addView(this.f);
    int j;
    if (a.a[paramMode.ordinal()] != 1)
    {
      j = l0.slide_in_from_top;
      i = l0.slide_out_to_top;
      setBackgroundResource(r0.indicator_bg_top);
    }
    else
    {
      j = l0.slide_in_from_bottom;
      i = l0.slide_out_to_bottom;
      setBackgroundResource(r0.indicator_bg_bottom);
      this.f.setScaleType(ImageView.ScaleType.MATRIX);
      paramMode = new Matrix();
      paramMode.setRotate(180.0F, localDrawable.getIntrinsicWidth() / 2.0F, localDrawable.getIntrinsicHeight() / 2.0F);
      this.f.setImageMatrix(paramMode);
    }
    paramMode = AnimationUtils.loadAnimation(paramContext, j);
    this.c = paramMode;
    paramMode.setAnimationListener(this);
    paramContext = AnimationUtils.loadAnimation(paramContext, i);
    this.d = paramContext;
    paramContext.setAnimationListener(this);
    paramContext = new LinearInterpolator();
    paramMode = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.q = paramMode;
    paramMode.setInterpolator(paramContext);
    paramMode.setDuration(150L);
    paramMode.setFillAfter(true);
    paramMode = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.x = paramMode;
    paramMode.setInterpolator(paramContext);
    paramMode.setDuration(150L);
    paramMode.setFillAfter(true);
  }
  
  public void a()
  {
    startAnimation(this.d);
  }
  
  public final boolean b()
  {
    Animation localAnimation = getAnimation();
    boolean bool1 = true;
    boolean bool2 = true;
    if (localAnimation != null)
    {
      if (this.c != localAnimation) {
        bool2 = false;
      }
      return bool2;
    }
    if (getVisibility() == 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  public void c()
  {
    this.f.startAnimation(this.x);
  }
  
  public void d()
  {
    this.f.startAnimation(this.q);
  }
  
  public void e()
  {
    this.f.clearAnimation();
    startAnimation(this.c);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.d)
    {
      this.f.clearAnimation();
      setVisibility(8);
    }
    else if (paramAnimation == this.c)
    {
      setVisibility(0);
    }
    clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    setVisibility(0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\internal\IndicatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */