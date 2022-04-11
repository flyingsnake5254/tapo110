package com.tplink.iot.widget.colorbulb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
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

public class ColorPointView
  extends View
{
  private Paint H3;
  private int I3;
  private int c = 1821695;
  private int d = -1315861;
  private int f = -1;
  private int p0;
  private boolean p1 = false;
  private Paint p2;
  private Bitmap p3;
  private int q = 0;
  private int x = -1;
  private int y;
  private int z;
  
  public ColorPointView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorPointView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramContext);
    this.I3 = paramInt1;
    this.f = paramInt3;
  }
  
  public ColorPointView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramContext);
    this.I3 = paramInt1;
  }
  
  public ColorPointView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorPointView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, com.tplink.iot.b.ColorPointView, paramInt, 0);
    if (paramAttributeSet != null)
    {
      this.c = paramAttributeSet.getColor(3, this.c);
      this.d = paramAttributeSet.getColor(4, this.d);
      this.f = paramAttributeSet.getColor(1, this.f);
      this.q = paramAttributeSet.getInt(0, this.q);
      this.x = paramAttributeSet.getResourceId(2, -1);
      paramAttributeSet.recycle();
    }
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    Object localObject = new Paint();
    this.p2 = ((Paint)localObject);
    ((Paint)localObject).setAntiAlias(true);
    this.p2.setFilterBitmap(true);
    if (this.x == -1) {
      this.p3 = BitmapFactory.decodeResource(getResources(), 2131689757);
    } else {
      this.p3 = BitmapFactory.decodeResource(getResources(), this.x);
    }
    localObject = new TextPaint();
    this.H3 = ((Paint)localObject);
    ((Paint)localObject).setAntiAlias(true);
    this.H3.setColor(Color.parseColor("#36444B"));
    this.H3.setTextSize(d(paramContext, 12.0F));
    this.H3.setTextAlign(Paint.Align.CENTER);
  }
  
  private int d(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public boolean b()
  {
    return this.p1;
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.d = paramInt2;
    this.c = paramInt3;
    invalidate();
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
    this.p2.setStyle(Paint.Style.STROKE);
    this.p2.setStrokeWidth(8.0F);
    this.p2.setColor(this.d);
    paramCanvas.drawCircle(this.z, this.p0, this.y - 20, this.p2);
    this.p2.setStyle(Paint.Style.FILL);
    this.p2.setColor(this.f);
    paramCanvas.drawCircle(this.z, this.p0, this.y - 20, this.p2);
    int i = this.q;
    if (i == 1)
    {
      i = (int)((getHeight() - (this.H3.descent() - this.H3.ascent())) / 2.0F - this.H3.ascent());
      paramCanvas.drawText("Auto", this.z, i, this.H3);
    }
    else if (((i == 2) && (b())) || (this.q == 3))
    {
      i = (getWidth() - this.p3.getWidth()) / 2;
      int j = (getHeight() - this.p3.getHeight()) / 2;
      paramCanvas.drawBitmap(this.p3, i, j, this.p2);
    }
    if (this.p1)
    {
      this.p2.setStyle(Paint.Style.STROKE);
      this.p2.setStrokeWidth(6.0F);
      this.p2.setColor(this.c);
      paramCanvas.drawCircle(this.z, this.p0, this.y - 6, this.p2);
    }
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
      paramInt2 = this.I3;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = net.lucode.hackware.magicindicator.g.b.a(getContext(), 44.0D);
      }
      paramInt2 = paramInt1;
    }
    Bitmap localBitmap = this.p3;
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
          i = this.p3.getWidth() + net.lucode.hackware.magicindicator.g.b.a(getContext(), 16.0D);
          j = i;
        }
      }
    }
    paramInt1 = Math.max(i, j);
    setMeasuredDimension(paramInt1, paramInt1);
    paramInt1 /= 2;
    this.p0 = paramInt1;
    this.z = paramInt1;
    this.y = paramInt1;
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
    this.p1 = paramBoolean;
    invalidate();
  }
  
  public void setType(int paramInt)
  {
    this.q = paramInt;
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorPointView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */