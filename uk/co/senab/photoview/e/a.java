package uk.co.senab.photoview.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import uk.co.senab.photoview.f.b;

public class a
  implements d
{
  protected e a;
  float b;
  float c;
  final float d;
  final float e;
  private VelocityTracker f;
  private boolean g;
  
  public a(Context paramContext)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.e = paramContext.getScaledMinimumFlingVelocity();
    this.d = paramContext.getScaledTouchSlop();
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public void b(e parame)
  {
    this.a = parame;
  }
  
  public boolean c()
  {
    return false;
  }
  
  float d(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getX();
  }
  
  float e(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getY();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    VelocityTracker localVelocityTracker;
    if (i != 0)
    {
      float f2;
      float f4;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            paramMotionEvent = this.f;
            if (paramMotionEvent != null)
            {
              paramMotionEvent.recycle();
              this.f = null;
            }
          }
        }
        else
        {
          float f1 = d(paramMotionEvent);
          f2 = e(paramMotionEvent);
          float f3 = f1 - this.b;
          f4 = f2 - this.c;
          if (!this.g)
          {
            if (Math.sqrt(f3 * f3 + f4 * f4) >= this.d) {
              bool = true;
            }
            this.g = bool;
          }
          if (this.g)
          {
            this.a.a(f3, f4);
            this.b = f1;
            this.c = f2;
            localVelocityTracker = this.f;
            if (localVelocityTracker != null) {
              localVelocityTracker.addMovement(paramMotionEvent);
            }
          }
        }
      }
      else
      {
        if ((this.g) && (this.f != null))
        {
          this.b = d(paramMotionEvent);
          this.c = e(paramMotionEvent);
          this.f.addMovement(paramMotionEvent);
          this.f.computeCurrentVelocity(1000);
          f2 = this.f.getXVelocity();
          f4 = this.f.getYVelocity();
          if (Math.max(Math.abs(f2), Math.abs(f4)) >= this.e) {
            this.a.c(this.b, this.c, -f2, -f4);
          }
        }
        paramMotionEvent = this.f;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.f = null;
        }
      }
    }
    else
    {
      localVelocityTracker = VelocityTracker.obtain();
      this.f = localVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.addMovement(paramMotionEvent);
      } else {
        uk.co.senab.photoview.f.a.a().b("CupcakeGestureDetector", "Velocity tracker is null");
      }
      this.b = d(paramMotionEvent);
      this.c = e(paramMotionEvent);
      this.g = false;
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */