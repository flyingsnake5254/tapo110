package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.g.b;

public class TriangularPagerIndicator
  extends View
  implements c
{
  private List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> c;
  private Paint d;
  private int f;
  private float p0;
  private Path p1 = new Path();
  private Interpolator p2 = new LinearInterpolator();
  private float p3;
  private int q;
  private int x;
  private int y;
  private boolean z;
  
  public TriangularPagerIndicator(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    Paint localPaint = new Paint(1);
    this.d = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    this.f = b.a(paramContext, 3.0D);
    this.y = b.a(paramContext, 14.0D);
    this.x = b.a(paramContext, 8.0D);
  }
  
  public void a(List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> paramList)
  {
    this.c = paramList;
  }
  
  public int getLineColor()
  {
    return this.q;
  }
  
  public int getLineHeight()
  {
    return this.f;
  }
  
  public Interpolator getStartInterpolator()
  {
    return this.p2;
  }
  
  public int getTriangleHeight()
  {
    return this.x;
  }
  
  public int getTriangleWidth()
  {
    return this.y;
  }
  
  public float getYOffset()
  {
    return this.p0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.d.setColor(this.q);
    if (this.z) {
      paramCanvas.drawRect(0.0F, getHeight() - this.p0 - this.x, getWidth(), getHeight() - this.p0 - this.x + this.f, this.d);
    } else {
      paramCanvas.drawRect(0.0F, getHeight() - this.f - this.p0, getWidth(), getHeight() - this.p0, this.d);
    }
    this.p1.reset();
    if (this.z)
    {
      this.p1.moveTo(this.p3 - this.y / 2, getHeight() - this.p0 - this.x);
      this.p1.lineTo(this.p3, getHeight() - this.p0);
      this.p1.lineTo(this.p3 + this.y / 2, getHeight() - this.p0 - this.x);
    }
    else
    {
      this.p1.moveTo(this.p3 - this.y / 2, getHeight() - this.p0);
      this.p1.lineTo(this.p3, getHeight() - this.x - this.p0);
      this.p1.lineTo(this.p3 + this.y / 2, getHeight() - this.p0);
    }
    this.p1.close();
    paramCanvas.drawPath(this.p1, this.d);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = this.c;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a locala = net.lucode.hackware.magicindicator.a.a(this.c, paramInt1);
      localObject = net.lucode.hackware.magicindicator.a.a(this.c, paramInt1 + 1);
      paramInt1 = locala.a;
      float f1 = paramInt1 + (locala.c - paramInt1) / 2;
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).a;
      this.p3 = (f1 + (paramInt1 + (((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).c - paramInt1) / 2 - f1) * this.p2.getInterpolation(paramFloat));
      invalidate();
    }
  }
  
  public void onPageSelected(int paramInt) {}
  
  public void setLineColor(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setLineHeight(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setReverse(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void setStartInterpolator(Interpolator paramInterpolator)
  {
    this.p2 = paramInterpolator;
    if (paramInterpolator == null) {
      this.p2 = new LinearInterpolator();
    }
  }
  
  public void setTriangleHeight(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setTriangleWidth(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setYOffset(float paramFloat)
  {
    this.p0 = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\indicators\TriangularPagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */