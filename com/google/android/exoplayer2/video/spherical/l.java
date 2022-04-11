package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.annotation.BinderThread;

final class l
  extends GestureDetector.SimpleOnGestureListener
  implements View.OnTouchListener, g.a
{
  private final PointF c = new PointF();
  private final PointF d = new PointF();
  private final a f;
  private final float q;
  private final GestureDetector x;
  private volatile float y;
  
  public l(Context paramContext, a parama, float paramFloat)
  {
    this.f = parama;
    this.q = paramFloat;
    this.x = new GestureDetector(paramContext, this);
    this.y = 3.1415927F;
  }
  
  @BinderThread
  public void a(float[] paramArrayOfFloat, float paramFloat)
  {
    this.y = (-paramFloat);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.c.set(paramMotionEvent.getX(), paramMotionEvent.getY());
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = (paramMotionEvent2.getX() - this.c.x) / this.q;
    paramFloat2 = paramMotionEvent2.getY();
    paramMotionEvent1 = this.c;
    paramFloat2 = (paramFloat2 - paramMotionEvent1.y) / this.q;
    paramMotionEvent1.set(paramMotionEvent2.getX(), paramMotionEvent2.getY());
    double d1 = this.y;
    float f1 = (float)Math.cos(d1);
    float f2 = (float)Math.sin(d1);
    paramMotionEvent1 = this.d;
    paramMotionEvent1.x -= f1 * paramFloat1 - f2 * paramFloat2;
    paramFloat1 = paramMotionEvent1.y + (f2 * paramFloat1 + f1 * paramFloat2);
    paramMotionEvent1.y = paramFloat1;
    paramMotionEvent1.y = Math.max(-45.0F, Math.min(45.0F, paramFloat1));
    this.f.b(this.d);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return this.f.onSingleTapUp(paramMotionEvent);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.x.onTouchEvent(paramMotionEvent);
  }
  
  public static abstract interface a
  {
    public abstract void b(PointF paramPointF);
    
    public abstract boolean onSingleTapUp(MotionEvent paramMotionEvent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\spherical\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */