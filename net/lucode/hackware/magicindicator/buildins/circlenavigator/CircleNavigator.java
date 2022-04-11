package net.lucode.hackware.magicindicator.buildins.circlenavigator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.f.a;
import net.lucode.hackware.magicindicator.g.b;

public class CircleNavigator
  extends View
  implements a
{
  private a H3;
  private float I3;
  private float J3;
  private int K3;
  private boolean L3 = true;
  private int c;
  private int d;
  private int f;
  private Paint p0 = new Paint(1);
  private List<PointF> p1 = new ArrayList();
  private float p2;
  private boolean p3;
  private int q;
  private int x;
  private int y;
  private Interpolator z = new LinearInterpolator();
  
  public CircleNavigator(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.p0.setStyle(Paint.Style.STROKE);
    this.p0.setStrokeWidth(this.f);
    int i = this.p1.size();
    for (int j = 0; j < i; j++)
    {
      PointF localPointF = (PointF)this.p1.get(j);
      paramCanvas.drawCircle(localPointF.x, localPointF.y, this.c, this.p0);
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    this.p0.setStyle(Paint.Style.FILL);
    if (this.p1.size() > 0) {
      paramCanvas.drawCircle(this.p2, (int)(getHeight() / 2.0F + 0.5F), this.c, this.p0);
    }
  }
  
  private void c(Context paramContext)
  {
    this.K3 = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.c = b.a(paramContext, 3.0D);
    this.q = b.a(paramContext, 8.0D);
    this.f = b.a(paramContext, 1.0D);
  }
  
  private int d(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if ((i != Integer.MIN_VALUE) && (i != 0))
    {
      if (i != 1073741824) {
        paramInt = 0;
      }
    }
    else {
      paramInt = this.c * 2 + this.f * 2 + getPaddingTop() + getPaddingBottom();
    }
    return paramInt;
  }
  
  private int g(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if ((i != Integer.MIN_VALUE) && (i != 0))
    {
      if (i != 1073741824) {
        paramInt = 0;
      }
    }
    else
    {
      int j = this.y;
      i = this.c;
      paramInt = this.q;
      int k = getPaddingLeft();
      int m = getPaddingRight();
      paramInt = this.f * 2 + (i * j * 2 + (j - 1) * paramInt + k + m);
    }
    return paramInt;
  }
  
  private void h()
  {
    this.p1.clear();
    if (this.y > 0)
    {
      int i = (int)(getHeight() / 2.0F + 0.5F);
      int j = this.c;
      int k = this.q;
      int m = j + (int)(this.f / 2.0F + 0.5F) + getPaddingLeft();
      for (int n = 0; n < this.y; n++)
      {
        PointF localPointF = new PointF(m, i);
        this.p1.add(localPointF);
        m += j * 2 + k;
      }
      this.p2 = ((PointF)this.p1.get(this.x)).x;
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public a getCircleClickListener()
  {
    return this.H3;
  }
  
  public int getCircleColor()
  {
    return this.d;
  }
  
  public int getCircleCount()
  {
    return this.y;
  }
  
  public int getCircleSpacing()
  {
    return this.q;
  }
  
  public int getRadius()
  {
    return this.c;
  }
  
  public Interpolator getStartInterpolator()
  {
    return this.z;
  }
  
  public int getStrokeWidth()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.p0.setColor(this.d);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(g(paramInt1), d(paramInt2));
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.L3)
    {
      if (this.p1.isEmpty()) {
        return;
      }
      paramInt2 = Math.min(this.p1.size() - 1, paramInt1);
      paramInt1 = Math.min(this.p1.size() - 1, paramInt1 + 1);
      PointF localPointF1 = (PointF)this.p1.get(paramInt2);
      PointF localPointF2 = (PointF)this.p1.get(paramInt1);
      float f1 = localPointF1.x;
      this.p2 = (f1 + (localPointF2.x - f1) * this.z.getInterpolation(paramFloat));
      invalidate();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.x = paramInt;
    if (!this.L3)
    {
      this.p2 = ((PointF)this.p1.get(paramInt)).x;
      invalidate();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) && (this.H3 != null) && (Math.abs(f1 - this.I3) <= this.K3) && (Math.abs(f2 - this.J3) <= this.K3))
      {
        float f3 = Float.MAX_VALUE;
        i = 0;
        int j = 0;
        while (i < this.p1.size())
        {
          float f4 = Math.abs(((PointF)this.p1.get(i)).x - f1);
          f2 = f3;
          if (f4 < f3)
          {
            j = i;
            f2 = f4;
          }
          i++;
          f3 = f2;
        }
        this.H3.a(j);
      }
    }
    else if (this.p3)
    {
      this.I3 = f1;
      this.J3 = f2;
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCircleClickListener(a parama)
  {
    if (!this.p3) {
      this.p3 = true;
    }
    this.H3 = parama;
  }
  
  public void setCircleColor(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setCircleCount(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setCircleSpacing(int paramInt)
  {
    this.q = paramInt;
    h();
    invalidate();
  }
  
  public void setFollowTouch(boolean paramBoolean)
  {
    this.L3 = paramBoolean;
  }
  
  public void setRadius(int paramInt)
  {
    this.c = paramInt;
    h();
    invalidate();
  }
  
  public void setStartInterpolator(Interpolator paramInterpolator)
  {
    this.z = paramInterpolator;
    if (paramInterpolator == null) {
      this.z = new LinearInterpolator();
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.f = paramInt;
    invalidate();
  }
  
  public void setTouchable(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\circlenavigator\CircleNavigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */