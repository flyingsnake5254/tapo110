package com.tplink.libtpcontrols.tpwheelview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class d
  extends GestureDetector.SimpleOnGestureListener
{
  final LoopView c;
  
  d(LoopView paramLoopView)
  {
    this.c = paramLoopView;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.c.b(paramMotionEvent);
    return false;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    this.c.a();
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.c.l(paramFloat2);
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.c.j(paramMotionEvent);
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpwheelview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */