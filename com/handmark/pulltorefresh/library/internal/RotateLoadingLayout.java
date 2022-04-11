package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.tplink.libtpcontrols.r0;
import com.tplink.libtpcontrols.x0;

public class RotateLoadingLayout
  extends LoadingLayout
{
  private final Animation J3;
  private final Matrix K3;
  private float L3;
  private float M3;
  private final boolean N3;
  
  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.N3 = paramTypedArray.getBoolean(x0.PullToRefresh_ptrRotateDrawableWhilePulling, true);
    this.f.setScaleType(ImageView.ScaleType.MATRIX);
    paramContext = new Matrix();
    this.K3 = paramContext;
    this.f.setImageMatrix(paramContext);
    paramContext = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.J3 = paramContext;
    paramContext.setInterpolator(LoadingLayout.c);
    paramContext.setDuration(1200L);
    paramContext.setRepeatCount(-1);
    paramContext.setRepeatMode(1);
  }
  
  private void n()
  {
    Matrix localMatrix = this.K3;
    if (localMatrix != null)
    {
      localMatrix.reset();
      this.f.setImageMatrix(this.K3);
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.L3 = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.M3 = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    }
  }
  
  protected void d(float paramFloat)
  {
    if (this.N3) {
      paramFloat *= 90.0F;
    } else {
      paramFloat = Math.max(0.0F, Math.min(180.0F, paramFloat * 360.0F - 180.0F));
    }
    this.K3.setRotate(paramFloat, this.L3, this.M3);
    this.f.setImageMatrix(this.K3);
  }
  
  protected void f() {}
  
  protected int getDefaultDrawableResId()
  {
    return r0.default_ptr_rotate;
  }
  
  protected void h()
  {
    this.f.startAnimation(this.J3);
  }
  
  protected void j() {}
  
  protected void l()
  {
    this.f.clearAnimation();
    n();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\internal\RotateLoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */