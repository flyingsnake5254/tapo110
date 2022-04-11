package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.g.b;

public class BezierPagerIndicator
  extends View
  implements c
{
  private Interpolator H3 = new AccelerateInterpolator();
  private Interpolator I3 = new DecelerateInterpolator();
  private List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> c;
  private float d;
  private float f;
  private float p0;
  private Paint p1;
  private Path p2 = new Path();
  private List<Integer> p3;
  private float q;
  private float x;
  private float y;
  private float z;
  
  public BezierPagerIndicator(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  private void b(Canvas paramCanvas)
  {
    this.p2.reset();
    float f1 = getHeight() - this.y - this.z;
    this.p2.moveTo(this.x, f1);
    this.p2.lineTo(this.x, f1 - this.q);
    Path localPath = this.p2;
    float f2 = this.x;
    float f3 = this.f;
    localPath.quadTo(f2 + (f3 - f2) / 2.0F, f1, f3, f1 - this.d);
    this.p2.lineTo(this.f, this.d + f1);
    localPath = this.p2;
    f2 = this.x;
    localPath.quadTo((this.f - f2) / 2.0F + f2, f1, f2, this.q + f1);
    this.p2.close();
    paramCanvas.drawPath(this.p2, this.p1);
  }
  
  private void c(Context paramContext)
  {
    Paint localPaint = new Paint(1);
    this.p1 = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    this.z = b.a(paramContext, 3.5D);
    this.p0 = b.a(paramContext, 2.0D);
    this.y = b.a(paramContext, 1.5D);
  }
  
  public void a(List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> paramList)
  {
    this.c = paramList;
  }
  
  public float getMaxCircleRadius()
  {
    return this.z;
  }
  
  public float getMinCircleRadius()
  {
    return this.p0;
  }
  
  public float getYOffset()
  {
    return this.y;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.f, getHeight() - this.y - this.z, this.d, this.p1);
    paramCanvas.drawCircle(this.x, getHeight() - this.y - this.z, this.q, this.p1);
    b(paramCanvas);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = this.c;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.p3;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramInt2 = net.lucode.hackware.magicindicator.g.a.a(paramFloat, ((Integer)this.p3.get(Math.abs(paramInt1) % this.p3.size())).intValue(), ((Integer)this.p3.get(Math.abs(paramInt1 + 1) % this.p3.size())).intValue());
        this.p1.setColor(paramInt2);
      }
      localObject = net.lucode.hackware.magicindicator.a.a(this.c, paramInt1);
      net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a locala = net.lucode.hackware.magicindicator.a.a(this.c, paramInt1 + 1);
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).a;
      float f1 = paramInt1 + (((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).c - paramInt1) / 2;
      paramInt1 = locala.a;
      float f2 = paramInt1 + (locala.c - paramInt1) / 2 - f1;
      this.f = (this.H3.getInterpolation(paramFloat) * f2 + f1);
      this.x = (f1 + f2 * this.I3.getInterpolation(paramFloat));
      f2 = this.z;
      this.d = (f2 + (this.p0 - f2) * this.I3.getInterpolation(paramFloat));
      f2 = this.p0;
      this.q = (f2 + (this.z - f2) * this.H3.getInterpolation(paramFloat));
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
    this.I3 = paramInterpolator;
    if (paramInterpolator == null) {
      this.I3 = new DecelerateInterpolator();
    }
  }
  
  public void setMaxCircleRadius(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  public void setMinCircleRadius(float paramFloat)
  {
    this.p0 = paramFloat;
  }
  
  public void setStartInterpolator(Interpolator paramInterpolator)
  {
    this.H3 = paramInterpolator;
    if (paramInterpolator == null) {
      this.H3 = new AccelerateInterpolator();
    }
  }
  
  public void setYOffset(float paramFloat)
  {
    this.y = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\indicators\BezierPagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */