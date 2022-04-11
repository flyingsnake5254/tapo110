package com.tplink.libtpcontrols.wheelpicker.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class c
  implements d
{
  private Scroller a;
  
  c(Context paramContext, Interpolator paramInterpolator)
  {
    this.a = new Scroller(paramContext, paramInterpolator);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public boolean b()
  {
    return this.a.isFinished();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public int d()
  {
    return this.a.getCurrX();
  }
  
  public int e()
  {
    return this.a.getCurrY();
  }
  
  @TargetApi(11)
  public void f(float paramFloat)
  {
    this.a.setFriction(paramFloat);
  }
  
  public void g()
  {
    this.a.abortAnimation();
  }
  
  public boolean h()
  {
    return this.a.computeScrollOffset();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\core\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */