package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class a
{
  private final PointF a;
  private final PointF b;
  private final PointF c;
  
  public a()
  {
    this.a = new PointF();
    this.b = new PointF();
    this.c = new PointF();
  }
  
  public a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    this.a = paramPointF1;
    this.b = paramPointF2;
    this.c = paramPointF3;
  }
  
  public PointF a()
  {
    return this.a;
  }
  
  public PointF b()
  {
    return this.b;
  }
  
  public PointF c()
  {
    return this.c;
  }
  
  public void d(float paramFloat1, float paramFloat2)
  {
    this.a.set(paramFloat1, paramFloat2);
  }
  
  public void e(float paramFloat1, float paramFloat2)
  {
    this.b.set(paramFloat1, paramFloat2);
  }
  
  public void f(float paramFloat1, float paramFloat2)
  {
    this.c.set(paramFloat1, paramFloat2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */