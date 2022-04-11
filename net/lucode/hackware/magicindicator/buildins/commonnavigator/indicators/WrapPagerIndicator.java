package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.g.b;

public class WrapPagerIndicator
  extends View
  implements c
{
  private int c;
  private int d;
  private int f;
  private Paint p0;
  private RectF p1 = new RectF();
  private boolean p2;
  private float q;
  private Interpolator x = new LinearInterpolator();
  private Interpolator y = new LinearInterpolator();
  private List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> z;
  
  public WrapPagerIndicator(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    Paint localPaint = new Paint(1);
    this.p0 = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    this.c = b.a(paramContext, 6.0D);
    this.d = b.a(paramContext, 10.0D);
  }
  
  public void a(List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> paramList)
  {
    this.z = paramList;
  }
  
  public Interpolator getEndInterpolator()
  {
    return this.y;
  }
  
  public int getFillColor()
  {
    return this.f;
  }
  
  public int getHorizontalPadding()
  {
    return this.d;
  }
  
  public Paint getPaint()
  {
    return this.p0;
  }
  
  public float getRoundRadius()
  {
    return this.q;
  }
  
  public Interpolator getStartInterpolator()
  {
    return this.x;
  }
  
  public int getVerticalPadding()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.p0.setColor(this.f);
    RectF localRectF = this.p1;
    float f1 = this.q;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.p0);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject1 = this.z;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = net.lucode.hackware.magicindicator.a.a(this.z, paramInt1);
      Object localObject2 = net.lucode.hackware.magicindicator.a.a(this.z, paramInt1 + 1);
      RectF localRectF = this.p1;
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject1).e;
      localRectF.left = (paramInt1 - this.d + (((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject2).e - paramInt1) * this.y.getInterpolation(paramFloat));
      localRectF = this.p1;
      localRectF.top = (((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject1).f - this.c);
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject1).g;
      localRectF.right = (this.d + paramInt1 + (((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject2).g - paramInt1) * this.x.getInterpolation(paramFloat));
      localObject2 = this.p1;
      ((RectF)localObject2).bottom = (((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject1).h + this.c);
      if (!this.p2) {
        this.q = (((RectF)localObject2).height() / 2.0F);
      }
      invalidate();
    }
  }
  
  public void onPageSelected(int paramInt) {}
  
  public void setEndInterpolator(Interpolator paramInterpolator)
  {
    this.y = paramInterpolator;
    if (paramInterpolator == null) {
      this.y = new LinearInterpolator();
    }
  }
  
  public void setFillColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setRoundRadius(float paramFloat)
  {
    this.q = paramFloat;
    this.p2 = true;
  }
  
  public void setStartInterpolator(Interpolator paramInterpolator)
  {
    this.x = paramInterpolator;
    if (paramInterpolator == null) {
      this.x = new LinearInterpolator();
    }
  }
  
  public void setVerticalPadding(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\indicators\WrapPagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */