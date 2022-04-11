package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.view.animation.Interpolator;
import androidx.annotation.NonNull;

public class f
{
  private final d a;
  
  f(d paramd)
  {
    this.a = paramd;
  }
  
  public void a(final b paramb)
  {
    if (paramb != null) {
      this.a.a(new a(paramb));
    } else {
      this.a.a(null);
    }
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public float c()
  {
    return this.a.c();
  }
  
  public boolean d()
  {
    return this.a.d();
  }
  
  public void e(long paramLong)
  {
    this.a.e(paramLong);
  }
  
  public void f(float paramFloat1, float paramFloat2)
  {
    this.a.f(paramFloat1, paramFloat2);
  }
  
  public void g(Interpolator paramInterpolator)
  {
    this.a.g(paramInterpolator);
  }
  
  public void h()
  {
    this.a.h();
  }
  
  class a
    implements f.d.b
  {
    a(f.b paramb) {}
    
    public void a()
    {
      paramb.a(f.this);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(f paramf);
  }
  
  static abstract interface c
  {
    @NonNull
    public abstract f createAnimator();
  }
  
  static abstract class d
  {
    abstract void a(b paramb);
    
    abstract void b();
    
    abstract float c();
    
    abstract boolean d();
    
    abstract void e(long paramLong);
    
    abstract void f(float paramFloat1, float paramFloat2);
    
    abstract void g(Interpolator paramInterpolator);
    
    abstract void h();
    
    static abstract interface a
    {
      public abstract void a();
      
      public abstract void onAnimationCancel();
      
      public abstract void onAnimationEnd();
    }
    
    static abstract interface b
    {
      public abstract void a();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */