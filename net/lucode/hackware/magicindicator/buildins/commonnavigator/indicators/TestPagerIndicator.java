package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;

public class TestPagerIndicator
  extends View
  implements c
{
  private Paint c;
  private int d;
  private int f;
  private RectF q = new RectF();
  private RectF x = new RectF();
  private List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> y;
  
  public TestPagerIndicator(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    paramContext = new Paint(1);
    this.c = paramContext;
    paramContext.setStyle(Paint.Style.STROKE);
    this.d = -65536;
    this.f = -16711936;
  }
  
  public void a(List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> paramList)
  {
    this.y = paramList;
  }
  
  public int getInnerRectColor()
  {
    return this.f;
  }
  
  public int getOutRectColor()
  {
    return this.d;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.c.setColor(this.d);
    paramCanvas.drawRect(this.q, this.c);
    this.c.setColor(this.f);
    paramCanvas.drawRect(this.x, this.c);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = this.y;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = net.lucode.hackware.magicindicator.a.a(this.y, paramInt1);
      net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a locala = net.lucode.hackware.magicindicator.a.a(this.y, paramInt1 + 1);
      RectF localRectF = this.q;
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).a;
      localRectF.left = (paramInt1 + (locala.a - paramInt1) * paramFloat);
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).b;
      localRectF.top = (paramInt1 + (locala.b - paramInt1) * paramFloat);
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).c;
      localRectF.right = (paramInt1 + (locala.c - paramInt1) * paramFloat);
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).d;
      localRectF.bottom = (paramInt1 + (locala.d - paramInt1) * paramFloat);
      localRectF = this.x;
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).e;
      localRectF.left = (paramInt1 + (locala.e - paramInt1) * paramFloat);
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).f;
      localRectF.top = (paramInt1 + (locala.f - paramInt1) * paramFloat);
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).g;
      localRectF.right = (paramInt1 + (locala.g - paramInt1) * paramFloat);
      paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).h;
      localRectF.bottom = (paramInt1 + (locala.h - paramInt1) * paramFloat);
      invalidate();
    }
  }
  
  public void onPageSelected(int paramInt) {}
  
  public void setInnerRectColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setOutRectColor(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\indicators\TestPagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */