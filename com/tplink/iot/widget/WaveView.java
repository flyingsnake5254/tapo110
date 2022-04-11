package com.tplink.iot.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WaveView
  extends View
{
  private Runnable H3 = new a();
  private float c;
  private float d = 0.9F;
  private float f;
  private boolean p0;
  private boolean p1;
  private Paint p2;
  private long p3;
  private long q = 1500L;
  private int x = 1500;
  private Interpolator y = new LinearInterpolator();
  private List<b> z = new ArrayList();
  
  public WaveView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaveView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.p2 = new Paint(1);
    setStyle(Paint.Style.FILL);
  }
  
  private void i()
  {
    long l = System.currentTimeMillis();
    if (l - this.p3 < this.x) {
      return;
    }
    b localb = new b();
    this.z.add(localb);
    invalidate();
    this.p3 = l;
  }
  
  public void j()
  {
    if (!this.p0)
    {
      this.p0 = true;
      this.H3.run();
    }
  }
  
  public void k()
  {
    this.p0 = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (System.currentTimeMillis() - b.a(localb) < this.q)
      {
        this.p2.setAlpha(localb.b());
        paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, localb.c(), this.p2);
      }
      else
      {
        localIterator.remove();
      }
    }
    if (this.z.size() > 0) {
      postInvalidateDelayed(10L);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.p1) {
      this.f = (Math.min(paramInt1, paramInt2) * this.d / 2.0F);
    }
  }
  
  public void setColor(int paramInt)
  {
    this.p2.setColor(paramInt);
  }
  
  public void setDuration(long paramLong)
  {
    this.q = paramLong;
  }
  
  public void setInitialRadius(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.y = paramInterpolator;
    if (paramInterpolator == null) {
      this.y = new LinearInterpolator();
    }
  }
  
  public void setMaxRadius(float paramFloat)
  {
    this.f = paramFloat;
    this.p1 = true;
  }
  
  public void setMaxRadiusRate(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void setSpeed(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setStyle(Paint.Style paramStyle)
  {
    this.p2.setStyle(paramStyle);
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      if (WaveView.a(WaveView.this))
      {
        WaveView.b(WaveView.this);
        WaveView localWaveView = WaveView.this;
        localWaveView.postDelayed(WaveView.c(localWaveView), WaveView.d(WaveView.this));
      }
    }
  }
  
  private class b
  {
    private long a = System.currentTimeMillis();
    
    public b() {}
    
    public int b()
    {
      float f = (float)(System.currentTimeMillis() - this.a) * 1.0F / (float)WaveView.e(WaveView.this);
      return (int)((1.0F - WaveView.f(WaveView.this).getInterpolation(f)) * 255.0F);
    }
    
    public float c()
    {
      float f = (float)(System.currentTimeMillis() - this.a) * 1.0F / (float)WaveView.e(WaveView.this);
      return WaveView.g(WaveView.this) + WaveView.f(WaveView.this).getInterpolation(f) * (WaveView.h(WaveView.this) - WaveView.g(WaveView.this));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\WaveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */