package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.g.b;

public class LinePagerIndicator
  extends View
  implements c
{
  private RectF H3 = new RectF();
  private int c;
  private Interpolator d = new LinearInterpolator();
  private Interpolator f = new LinearInterpolator();
  private float p0;
  private Paint p1;
  private List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> p2;
  private List<Integer> p3;
  private float q;
  private float x;
  private float y;
  private float z;
  
  public LinePagerIndicator(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    Paint localPaint = new Paint(1);
    this.p1 = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    this.x = b.a(paramContext, 3.0D);
    this.z = b.a(paramContext, 10.0D);
  }
  
  public void a(List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> paramList)
  {
    this.p2 = paramList;
  }
  
  public List<Integer> getColors()
  {
    return this.p3;
  }
  
  public Interpolator getEndInterpolator()
  {
    return this.f;
  }
  
  public float getLineHeight()
  {
    return this.x;
  }
  
  public float getLineWidth()
  {
    return this.z;
  }
  
  public int getMode()
  {
    return this.c;
  }
  
  public Paint getPaint()
  {
    return this.p1;
  }
  
  public float getRoundRadius()
  {
    return this.p0;
  }
  
  public Interpolator getStartInterpolator()
  {
    return this.d;
  }
  
  public float getXOffset()
  {
    return this.y;
  }
  
  public float getYOffset()
  {
    return this.q;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    RectF localRectF = this.H3;
    float f1 = this.p0;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.p1);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = this.p2;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.p3;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramInt2 = net.lucode.hackware.magicindicator.g.a.a(paramFloat, ((Integer)this.p3.get(Math.abs(paramInt1) % this.p3.size())).intValue(), ((Integer)this.p3.get(Math.abs(paramInt1 + 1) % this.p3.size())).intValue());
        this.p1.setColor(paramInt2);
      }
      net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a locala = net.lucode.hackware.magicindicator.a.a(this.p2, paramInt1);
      localObject = net.lucode.hackware.magicindicator.a.a(this.p2, paramInt1 + 1);
      paramInt1 = this.c;
      if (paramInt1 == 0)
      {
        f1 = locala.a;
        f2 = this.y;
        f3 = f1 + f2;
        f4 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).a + f2;
        f1 = locala.c - f2;
      }
      for (paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).c;; paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).g)
      {
        f2 = paramInt1 - f2;
        break label369;
        if (paramInt1 != 1) {
          break;
        }
        f1 = locala.e;
        f2 = this.y;
        f3 = f1 + f2;
        f4 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).e + f2;
        f1 = locala.g - f2;
      }
      float f3 = locala.a + (locala.b() - this.z) / 2.0F;
      float f4 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).a;
      float f5 = (((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).b() - this.z) / 2.0F;
      float f1 = locala.a;
      f1 = (locala.b() + this.z) / 2.0F + f1;
      float f2 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).a;
      f2 = (((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).b() + this.z) / 2.0F + f2;
      f4 += f5;
      label369:
      this.H3.left = (f3 + (f4 - f3) * this.d.getInterpolation(paramFloat));
      this.H3.right = (f1 + (f2 - f1) * this.f.getInterpolation(paramFloat));
      this.H3.top = (getHeight() - this.x - this.q);
      this.H3.bottom = (getHeight() - this.q);
      invalidate();
    }
  }
  
  public void onPageSelected(int paramInt) {}
  
  public void setColors(Integer... paramVarArgs)
  {
    this.p3 = Arrays.asList(paramVarArgs);
  }
  
  public void setEndInterpolator(Interpolator paramInterpolator)
  {
    this.f = paramInterpolator;
    if (paramInterpolator == null) {
      this.f = new LinearInterpolator();
    }
  }
  
  public void setLineHeight(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public void setLineWidth(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  public void setMode(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 0) && (paramInt != 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mode ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" not supported.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.c = paramInt;
  }
  
  public void setRoundRadius(float paramFloat)
  {
    this.p0 = paramFloat;
  }
  
  public void setStartInterpolator(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
    if (paramInterpolator == null) {
      this.d = new LinearInterpolator();
    }
  }
  
  public void setXOffset(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  public void setYOffset(float paramFloat)
  {
    this.q = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\indicators\LinePagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */