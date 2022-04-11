package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;

public class ClipPagerTitleView
  extends View
  implements net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
{
  private String c;
  private int d;
  private int f;
  private boolean q;
  private float x;
  private Paint y;
  private Rect z = new Rect();
  
  public ClipPagerTitleView(Context paramContext)
  {
    super(paramContext);
    e(paramContext);
  }
  
  private void e(Context paramContext)
  {
    int i = net.lucode.hackware.magicindicator.g.b.a(paramContext, 16.0D);
    Paint localPaint = new Paint(1);
    this.y = localPaint;
    localPaint.setTextSize(i);
    i = net.lucode.hackware.magicindicator.g.b.a(paramContext, 10.0D);
    setPadding(i, 0, i, 0);
  }
  
  private int f(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i != Integer.MIN_VALUE)
    {
      if (i == 0) {
        paramInt = this.z.height() + getPaddingTop() + getPaddingBottom();
      }
    }
    else {
      paramInt = Math.min(this.z.height() + getPaddingTop() + getPaddingBottom(), paramInt);
    }
    return paramInt;
  }
  
  private void g()
  {
    Paint localPaint = this.y;
    String str = this.c;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.length();
    }
    localPaint.getTextBounds(str, 0, i, this.z);
  }
  
  private int h(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i != Integer.MIN_VALUE)
    {
      if (i == 0) {
        paramInt = this.z.width() + getPaddingLeft() + getPaddingRight();
      }
    }
    else {
      paramInt = Math.min(this.z.width() + getPaddingLeft() + getPaddingRight(), paramInt);
    }
    return paramInt;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void b(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    this.q = paramBoolean;
    this.x = paramFloat;
    invalidate();
  }
  
  public void c(int paramInt1, int paramInt2) {}
  
  public void d(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    this.q = (paramBoolean ^ true);
    this.x = (1.0F - paramFloat);
    invalidate();
  }
  
  public int getClipColor()
  {
    return this.f;
  }
  
  public int getContentBottom()
  {
    Paint.FontMetrics localFontMetrics = this.y.getFontMetrics();
    float f1 = localFontMetrics.bottom;
    float f2 = localFontMetrics.top;
    return (int)(getHeight() / 2 + (f1 - f2) / 2.0F);
  }
  
  public int getContentLeft()
  {
    int i = this.z.width();
    return getLeft() + getWidth() / 2 - i / 2;
  }
  
  public int getContentRight()
  {
    int i = this.z.width();
    return getLeft() + getWidth() / 2 + i / 2;
  }
  
  public int getContentTop()
  {
    Paint.FontMetrics localFontMetrics = this.y.getFontMetrics();
    float f1 = localFontMetrics.bottom;
    float f2 = localFontMetrics.top;
    return (int)(getHeight() / 2 - (f1 - f2) / 2.0F);
  }
  
  public String getText()
  {
    return this.c;
  }
  
  public int getTextColor()
  {
    return this.d;
  }
  
  public float getTextSize()
  {
    return this.y.getTextSize();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = (getWidth() - this.z.width()) / 2;
    Object localObject = this.y.getFontMetrics();
    int j = (int)((getHeight() - ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F);
    this.y.setColor(this.d);
    localObject = this.c;
    float f1 = i;
    float f2 = j;
    paramCanvas.drawText((String)localObject, f1, f2, this.y);
    paramCanvas.save();
    if (this.q) {
      paramCanvas.clipRect(0.0F, 0.0F, getWidth() * this.x, getHeight());
    } else {
      paramCanvas.clipRect(getWidth() * (1.0F - this.x), 0.0F, getWidth(), getHeight());
    }
    this.y.setColor(this.f);
    paramCanvas.drawText(this.c, f1, f2, this.y);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    g();
    setMeasuredDimension(h(paramInt1), f(paramInt2));
  }
  
  public void setClipColor(int paramInt)
  {
    this.f = paramInt;
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.c = paramString;
    requestLayout();
  }
  
  public void setTextColor(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setTextSize(float paramFloat)
  {
    this.y.setTextSize(paramFloat);
    requestLayout();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\titles\ClipPagerTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */