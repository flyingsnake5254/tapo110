package uk.co.senab.photoview;

import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.widget.ImageView;

public class b
  implements GestureDetector.OnDoubleTapListener
{
  private d c;
  
  public b(d paramd)
  {
    a(paramd);
  }
  
  public void a(d paramd)
  {
    this.c = paramd;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    d locald = this.c;
    if (locald == null) {
      return false;
    }
    try
    {
      float f1 = locald.A();
      float f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      if (f1 < this.c.w())
      {
        paramMotionEvent = this.c;
        paramMotionEvent.X(paramMotionEvent.w(), f2, f3, true);
      }
      else if ((f1 >= this.c.w()) && (f1 < this.c.v()))
      {
        paramMotionEvent = this.c;
        paramMotionEvent.X(paramMotionEvent.v(), f2, f3, true);
      }
      else
      {
        paramMotionEvent = this.c;
        paramMotionEvent.X(paramMotionEvent.x(), f2, f3, true);
      }
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      for (;;) {}
    }
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return false;
    }
    ImageView localImageView = ((d)localObject).s();
    if (this.c.y() != null)
    {
      localObject = this.c.p();
      if (localObject != null)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if (((RectF)localObject).contains(f1, f2))
        {
          f1 = (f1 - ((RectF)localObject).left) / ((RectF)localObject).width();
          f2 = (f2 - ((RectF)localObject).top) / ((RectF)localObject).height();
          this.c.y().a0(localImageView, f1, f2);
          return true;
        }
        this.c.y().R();
      }
    }
    if (this.c.z() != null) {
      this.c.z().a(localImageView, paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */