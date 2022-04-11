package uk.co.senab.photoview.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

@TargetApi(5)
public class b
  extends a
{
  private int h = -1;
  private int i = 0;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  float d(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getX(this.i);
      return f;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getX();
  }
  
  float e(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getY(this.i);
      return f;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getY();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction() & 0xFF;
    int k = 0;
    if (j != 0)
    {
      if ((j != 1) && (j != 3))
      {
        if (j == 6)
        {
          j = uk.co.senab.photoview.a.a(paramMotionEvent.getAction());
          if (paramMotionEvent.getPointerId(j) == this.h)
          {
            if (j == 0) {
              j = 1;
            } else {
              j = 0;
            }
            this.h = paramMotionEvent.getPointerId(j);
            this.b = paramMotionEvent.getX(j);
            this.c = paramMotionEvent.getY(j);
          }
        }
      }
      else {
        this.h = -1;
      }
    }
    else {
      this.h = paramMotionEvent.getPointerId(0);
    }
    int m = this.h;
    j = k;
    if (m != -1) {
      j = m;
    }
    this.i = paramMotionEvent.findPointerIndex(j);
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */