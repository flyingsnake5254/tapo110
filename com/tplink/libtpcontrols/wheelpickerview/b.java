package com.tplink.libtpcontrols.wheelpickerview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class b
  extends GestureDetector.SimpleOnGestureListener
{
  final LoopView c;
  
  b(LoopView paramLoopView)
  {
    this.c = paramLoopView;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.c.g(paramFloat2);
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpickerview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */