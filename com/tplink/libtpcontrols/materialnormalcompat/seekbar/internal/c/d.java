package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.NonNull;

public class d
  extends c
  implements Animatable
{
  private Runnable p0 = new a();
  private final int x;
  private boolean y;
  private boolean z;
  
  public d(@NonNull ColorStateList paramColorStateList, int paramInt)
  {
    super(paramColorStateList);
    this.x = paramInt;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (!this.y)
    {
      Rect localRect = getBounds();
      float f = this.x / 2.0F;
      paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f, paramPaint);
    }
  }
  
  public void g()
  {
    this.y = false;
    this.z = false;
    unscheduleSelf(this.p0);
    invalidateSelf();
  }
  
  public int getIntrinsicHeight()
  {
    return this.x;
  }
  
  public int getIntrinsicWidth()
  {
    return this.x;
  }
  
  public void h()
  {
    scheduleSelf(this.p0, SystemClock.uptimeMillis() + 100L);
    this.z = true;
  }
  
  public boolean isRunning()
  {
    return this.z;
  }
  
  public void start() {}
  
  public void stop()
  {
    g();
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      d.e(d.this, true);
      d.this.invalidateSelf();
      d.f(d.this, false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */