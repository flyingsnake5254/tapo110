package com.tplink.iot.widget.colorbulb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.annotation.Nullable;
import net.lucode.hackware.magicindicator.g.b;

public class ColorPointHomeView
  extends View
{
  private int H3;
  private int c = 1821695;
  private int d = -1;
  private int f = -1;
  private boolean p0 = false;
  private Paint p1;
  private Bitmap p2;
  private Paint p3;
  private int q = 0;
  private int x;
  private int y;
  private int z;
  
  public ColorPointHomeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorPointHomeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorPointHomeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    Object localObject = new Paint();
    this.p1 = ((Paint)localObject);
    ((Paint)localObject).setAntiAlias(true);
    this.p1.setFilterBitmap(true);
    this.p2 = BitmapFactory.decodeResource(getResources(), 2131689757);
    localObject = new TextPaint();
    this.p3 = ((Paint)localObject);
    ((Paint)localObject).setAntiAlias(true);
    this.p3.setColor(Color.parseColor("#36444B"));
    this.p3.setTextSize(b(paramContext, 12.0F));
    this.p3.setTextAlign(Paint.Align.CENTER);
  }
  
  private int b(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public int getInnerCircleColor()
  {
    return this.f;
  }
  
  public int getOutRingColor()
  {
    return this.c;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.p1.setStyle(Paint.Style.STROKE);
    this.p1.setStrokeWidth(8.0F);
    this.p1.setColor(this.d);
    paramCanvas.drawCircle(this.y, this.z, this.x - 8, this.p1);
    this.p1.setStyle(Paint.Style.FILL);
    this.p1.setColor(this.f);
    paramCanvas.drawCircle(this.y, this.z, this.x - 8, this.p1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((i == 0) || (i == Integer.MIN_VALUE) || (j == 0) || (j == Integer.MIN_VALUE))
    {
      paramInt2 = this.H3;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = b.a(getContext(), 44.0D);
      }
      paramInt2 = paramInt1;
    }
    Bitmap localBitmap = this.p2;
    i = paramInt1;
    j = paramInt2;
    if (localBitmap != null)
    {
      i = paramInt1;
      j = paramInt2;
      if (paramInt1 < localBitmap.getWidth())
      {
        i = paramInt1;
        j = paramInt2;
        if (this.q == 2)
        {
          i = this.p2.getWidth() + b.a(getContext(), 16.0D);
          j = i;
        }
      }
    }
    paramInt1 = Math.max(i, j);
    setMeasuredDimension(paramInt1, paramInt1);
    paramInt1 /= 2;
    this.z = paramInt1;
    this.y = paramInt1;
    this.x = paramInt1;
  }
  
  public void setInnerCircleColor(int paramInt)
  {
    this.f = paramInt;
    invalidate();
  }
  
  public void setOutRingColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOutlineColor(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setSelectedStatus(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
    invalidate();
  }
  
  public void setType(int paramInt)
  {
    this.q = paramInt;
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorPointHomeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */