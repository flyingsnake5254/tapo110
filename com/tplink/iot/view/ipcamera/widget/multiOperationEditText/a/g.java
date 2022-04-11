package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

class g
  extends f.d
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  private long b;
  private boolean c;
  private float d;
  private final int[] e = new int[2];
  private final float[] f = new float[2];
  private long g = 200L;
  private Interpolator h;
  private ArrayList<f.d.a> i;
  private ArrayList<f.d.b> j;
  private final Runnable k = new a();
  
  private void i()
  {
    ArrayList localArrayList = this.i;
    if (localArrayList != null)
    {
      int m = 0;
      int n = localArrayList.size();
      while (m < n)
      {
        ((f.d.a)this.i.get(m)).onAnimationCancel();
        m++;
      }
    }
  }
  
  private void j()
  {
    ArrayList localArrayList = this.i;
    if (localArrayList != null)
    {
      int m = 0;
      int n = localArrayList.size();
      while (m < n)
      {
        ((f.d.a)this.i.get(m)).onAnimationEnd();
        m++;
      }
    }
  }
  
  private void k()
  {
    ArrayList localArrayList = this.i;
    if (localArrayList != null)
    {
      int m = 0;
      int n = localArrayList.size();
      while (m < n)
      {
        ((f.d.a)this.i.get(m)).a();
        m++;
      }
    }
  }
  
  private void l()
  {
    ArrayList localArrayList = this.j;
    if (localArrayList != null)
    {
      int m = 0;
      int n = localArrayList.size();
      while (m < n)
      {
        ((f.d.b)this.j.get(m)).a();
        m++;
      }
    }
  }
  
  public void a(f.d.b paramb)
  {
    if (this.j == null) {
      this.j = new ArrayList();
    }
    this.j.add(paramb);
  }
  
  public void b()
  {
    this.c = false;
    a.removeCallbacks(this.k);
    i();
    j();
  }
  
  public float c()
  {
    float[] arrayOfFloat = this.f;
    return a.a(arrayOfFloat[0], arrayOfFloat[1], m());
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public void e(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void f(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.f;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
  }
  
  public void g(Interpolator paramInterpolator)
  {
    this.h = paramInterpolator;
  }
  
  public void h()
  {
    if (this.c) {
      return;
    }
    if (this.h == null) {
      this.h = new AccelerateDecelerateInterpolator();
    }
    this.c = true;
    this.d = 0.0F;
    n();
  }
  
  public float m()
  {
    return this.d;
  }
  
  final void n()
  {
    this.b = SystemClock.uptimeMillis();
    l();
    k();
    a.postDelayed(this.k, 10L);
  }
  
  final void o()
  {
    if (this.c)
    {
      float f1 = d.a((float)(SystemClock.uptimeMillis() - this.b) / (float)this.g, 0.0F, 1.0F);
      Interpolator localInterpolator = this.h;
      float f2 = f1;
      if (localInterpolator != null) {
        f2 = localInterpolator.getInterpolation(f1);
      }
      this.d = f2;
      l();
      if (SystemClock.uptimeMillis() >= this.b + this.g)
      {
        this.c = false;
        j();
      }
    }
    if (this.c) {
      a.postDelayed(this.k, 10L);
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      g.this.o();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */