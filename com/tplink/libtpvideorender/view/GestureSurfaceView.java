package com.tplink.libtpvideorender.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import b.d.z.b.b;

public class GestureSurfaceView
  extends GLSurfaceViewGPU
  implements View.OnTouchListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener
{
  private float H3 = 0.0F;
  private float I3 = 0.0F;
  boolean J3 = false;
  private Context K3;
  private GestureDetector p0;
  private ScaleGestureDetector p1;
  private float p2 = 0.0F;
  private float p3 = 0.0F;
  private float q = 4.0F;
  private float x = 1.0F;
  private float y = 1.0F;
  protected boolean z = false;
  
  public GestureSurfaceView(Context paramContext)
  {
    super(paramContext);
    this.K3 = paramContext;
  }
  
  public GestureSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.K3 = paramContext;
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    j(getWidth() / 2.0F * this.y, getHeight() / 2.0F * this.y, paramMotionEvent.getX() * this.y, paramMotionEvent.getY() * this.y);
  }
  
  private void d(Context paramContext)
  {
    setOnTouchListener(this);
    setClickable(true);
    GestureDetector localGestureDetector = new GestureDetector(paramContext, this);
    this.p0 = localGestureDetector;
    localGestureDetector.setOnDoubleTapListener(this);
    this.p1 = new ScaleGestureDetector(paramContext, this);
  }
  
  private float getHeightRange()
  {
    return this.d.d();
  }
  
  private float getWidthRange()
  {
    return this.d.g();
  }
  
  private void j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 = paramFloat1 - paramFloat3;
    paramFloat1 = paramFloat3;
    if (Math.abs(paramFloat3) < 10.0F) {
      paramFloat1 = 0.0F;
    }
    paramFloat3 = paramFloat2 - paramFloat4;
    paramFloat2 = paramFloat3;
    if (Math.abs(paramFloat3) < 10.0F) {
      paramFloat2 = 0.0F;
    }
    this.p2 = (paramFloat1 * 2.0F / getWidth() * this.d.h());
    this.p3 = (paramFloat2 * 2.0F / getHeight() * this.d.e());
    paramFloat4 = getHeightRange();
    float f = getWidthRange();
    paramFloat1 = this.H3 + this.p2;
    paramFloat3 = this.I3 - this.p3;
    paramFloat2 = paramFloat1;
    if (Math.abs(paramFloat1) > f)
    {
      if (paramFloat1 > 0.0F) {
        paramFloat1 = f;
      } else {
        paramFloat1 = -f;
      }
      this.p2 = (paramFloat1 - this.H3);
      paramFloat2 = paramFloat1;
    }
    paramFloat1 = paramFloat3;
    if (Math.abs(paramFloat3) > paramFloat4)
    {
      if (paramFloat3 > 0.0F) {
        paramFloat1 = paramFloat4;
      } else {
        paramFloat1 = -paramFloat4;
      }
      this.p3 = (this.I3 - paramFloat1);
    }
    b localb = this.d;
    if (localb != null)
    {
      localb.p(paramFloat2, paramFloat1);
      requestRender();
    }
  }
  
  public void b()
  {
    super.b();
    d(this.K3);
  }
  
  public boolean e()
  {
    float f1 = getWidthRange();
    float f2 = this.H3;
    boolean bool;
    if ((f2 >= 0.0F) && (Math.abs(f2 - f1) < 0.001D)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean f()
  {
    float f1 = getWidthRange();
    float f2 = this.H3;
    boolean bool;
    if ((f2 <= 0.0F) && (Math.abs(-f2 - f1) < 0.001D)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean g()
  {
    boolean bool;
    if (this.y > this.x) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void h(MotionEvent paramMotionEvent) {}
  
  public void i()
  {
    this.y = this.x;
    this.H3 = 0.0F;
    this.I3 = 0.0F;
    b localb = this.d;
    if (localb != null)
    {
      localb.i();
      requestRender();
    }
  }
  
  public void k(int paramInt1, int paramInt2)
  {
    paramInt1 *= paramInt2;
    if (paramInt1 <= 230400) {
      this.q = 3.0F;
    } else if (paramInt1 <= 921600) {
      this.q = 6.0F;
    } else if (paramInt1 <= 2073600) {
      this.q = 9.0F;
    } else if (paramInt1 <= 2985984) {
      this.q = 11.0F;
    } else {
      this.q = 12.0F;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (g())
    {
      this.y = this.x;
      this.H3 = 0.0F;
      this.I3 = 0.0F;
      this.d.i();
      requestRender();
    }
    else
    {
      float f = this.q;
      this.y = f;
      this.H3 = 0.0F;
      this.I3 = 0.0F;
      this.d.k(f);
      c(paramMotionEvent);
    }
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.z = false;
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(false);
    performLongClick();
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f1 = paramScaleGestureDetector.getScaleFactor();
    float f2 = this.y * f1;
    this.y = f2;
    float f3 = this.q;
    if (f2 > f3) {
      this.y = f3;
    }
    f2 = this.y;
    f3 = this.x;
    if (f2 < f3) {
      this.y = f3;
    }
    this.H3 *= f1;
    this.I3 *= f1;
    f3 = getHeightRange();
    f1 = getWidthRange();
    if (Math.abs(this.H3) > f1)
    {
      if (this.H3 <= 0.0F) {
        f1 = -f1;
      }
      this.H3 = f1;
    }
    if (Math.abs(this.I3) > f3)
    {
      if (this.I3 > 0.0F) {
        f1 = f3;
      } else {
        f1 = -f3;
      }
      this.I3 = f1;
    }
    paramScaleGestureDetector = this.d;
    if (paramScaleGestureDetector != null)
    {
      paramScaleGestureDetector.k(this.y);
      this.d.p(this.H3, this.I3);
      requestRender();
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.z = true;
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (((this.y == 1.0F) && ((paramFloat1 > 20.0F) || (paramFloat1 < -20.0F))) || ((paramFloat1 > 20.0F) && (f())) || ((paramFloat1 < -20.0F) && (e())))
    {
      int i = paramMotionEvent2.getPointerCount();
      int j = 1;
      int k = j;
      if (i == 2)
      {
        i = paramMotionEvent2.getHistorySize() - 1;
        k = j;
        if (i >= 0)
        {
          paramFloat1 = Math.abs(paramMotionEvent2.getHistoricalX(0, i) - paramMotionEvent2.getHistoricalX(1, i));
          k = j;
          if (Math.abs(paramMotionEvent2.getX(0) - paramMotionEvent2.getX(1)) > paramFloat1) {
            k = 0;
          }
        }
      }
      if (k != 0)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        this.J3 = false;
      }
    }
    if (g())
    {
      if (this.z) {
        return false;
      }
      j(paramMotionEvent2.getX(), paramMotionEvent2.getY(), paramMotionEvent1.getX(), paramMotionEvent1.getY());
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    performClick();
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1))
    {
      if (((paramMotionEvent.getAction() == 0) && (this.y > 1.0F)) || ((!this.J3) && (paramMotionEvent.getPointerCount() > 1)))
      {
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        this.J3 = true;
      }
    }
    else {
      this.J3 = false;
    }
    this.p1.onTouchEvent(paramMotionEvent);
    this.p0.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      this.H3 += this.p2;
      this.I3 -= this.p3;
      this.p2 = 0.0F;
      this.p3 = 0.0F;
      h(paramMotionEvent);
    }
    return true;
  }
  
  public void setDeviceIdMD5(String paramString)
  {
    super.setDeviceIdMD5(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpvideorender\view\GestureSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */