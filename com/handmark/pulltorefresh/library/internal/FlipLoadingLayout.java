package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.tplink.libtpcontrols.r0;

@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout
  extends LoadingLayout
{
  private final Animation J3;
  private final Animation K3;
  
  public FlipLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    int i;
    if (paramMode == PullToRefreshBase.Mode.PULL_FROM_START) {
      i = 65356;
    } else {
      i = 180;
    }
    float f = i;
    paramMode = new RotateAnimation(0.0F, f, 1, 0.5F, 1, 0.5F);
    this.J3 = paramMode;
    paramContext = LoadingLayout.c;
    paramMode.setInterpolator(paramContext);
    paramMode.setDuration(150L);
    paramMode.setFillAfter(true);
    paramMode = new RotateAnimation(f, 0.0F, 1, 0.5F, 1, 0.5F);
    this.K3 = paramMode;
    paramMode.setInterpolator(paramContext);
    paramMode.setDuration(150L);
    paramMode.setFillAfter(true);
  }
  
  private float getDrawableRotationAngle()
  {
    int i = a.a[this.p1.ordinal()];
    float f;
    if (i != 1)
    {
      if ((i == 2) && (this.p2 == PullToRefreshBase.Orientation.HORIZONTAL)) {
        f = 270.0F;
      } else {
        f = 0.0F;
      }
    }
    else if (this.p2 == PullToRefreshBase.Orientation.HORIZONTAL) {
      f = 90.0F;
    } else {
      f = 180.0F;
    }
    return f;
  }
  
  protected void b(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicHeight();
      int j = paramDrawable.getIntrinsicWidth();
      ViewGroup.LayoutParams localLayoutParams = this.f.getLayoutParams();
      int k = Math.max(i, j);
      localLayoutParams.height = k;
      localLayoutParams.width = k;
      this.f.requestLayout();
      this.f.setScaleType(ImageView.ScaleType.MATRIX);
      paramDrawable = new Matrix();
      paramDrawable.postTranslate((localLayoutParams.width - j) / 2.0F, (localLayoutParams.height - i) / 2.0F);
      paramDrawable.postRotate(getDrawableRotationAngle(), localLayoutParams.width / 2.0F, localLayoutParams.height / 2.0F);
      this.f.setImageMatrix(paramDrawable);
    }
  }
  
  protected void d(float paramFloat) {}
  
  protected void f()
  {
    if (this.J3 == this.f.getAnimation()) {
      this.f.startAnimation(this.K3);
    }
  }
  
  protected int getDefaultDrawableResId()
  {
    return r0.default_ptr_flip;
  }
  
  protected void h()
  {
    this.f.clearAnimation();
    this.f.setVisibility(4);
    this.q.setVisibility(0);
  }
  
  protected void j()
  {
    this.f.startAnimation(this.J3);
  }
  
  protected void l()
  {
    this.f.clearAnimation();
    this.q.setVisibility(8);
    this.f.setVisibility(0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\internal\FlipLoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */