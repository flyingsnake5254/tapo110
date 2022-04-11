package com.tplink.libtpcontrols.mapmarks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.p0;

public class CustomCircleView
  extends View
{
  private int c;
  private Paint d;
  private float f;
  private float q;
  private float x;
  
  public CustomCircleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomCircleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public CustomCircleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.c = ContextCompat.getColor(paramContext, p0.teal_transparency_30);
    paramContext = new Paint();
    this.d = paramContext;
    paramContext.setColor(this.c);
    this.d.setStyle(Paint.Style.FILL);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawCircle(this.f, this.q, this.x, this.d);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
    this.f = (paramInt1 / 2.0F);
    this.q = (paramInt2 / 2.0F);
  }
  
  public void setCircleRadius(float paramFloat)
  {
    this.x = paramFloat;
    postInvalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\mapmarks\CustomCircleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */