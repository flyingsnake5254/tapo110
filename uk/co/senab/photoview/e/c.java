package uk.co.senab.photoview.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

@TargetApi(8)
public class c
  extends b
{
  protected final ScaleGestureDetector j = new ScaleGestureDetector(paramContext, new a());
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean c()
  {
    return this.j.isInProgress();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      this.j.onTouchEvent(paramMotionEvent);
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return true;
  }
  
  class a
    implements ScaleGestureDetector.OnScaleGestureListener
  {
    a() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      float f = paramScaleGestureDetector.getScaleFactor();
      if ((!Float.isNaN(f)) && (!Float.isInfinite(f)))
      {
        c.this.a.b(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        return true;
      }
      return false;
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */