package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class LineRadarRenderer
  extends LineScatterCandleRadarRenderer
{
  public LineRadarRenderer(ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
  }
  
  private boolean clipPathSupported()
  {
    boolean bool;
    if (Utils.getSDKInt() >= 18) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void drawFilledPath(Canvas paramCanvas, Path paramPath, int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt1 & 0xFFFFFF | paramInt2 << 24;
    if (clipPathSupported())
    {
      paramInt2 = paramCanvas.save();
      paramCanvas.clipPath(paramPath);
      paramCanvas.drawColor(paramInt1);
      paramCanvas.restoreToCount(paramInt2);
    }
    else
    {
      Paint.Style localStyle = this.mRenderPaint.getStyle();
      paramInt2 = this.mRenderPaint.getColor();
      this.mRenderPaint.setStyle(Paint.Style.FILL);
      this.mRenderPaint.setColor(paramInt1);
      paramCanvas.drawPath(paramPath, this.mRenderPaint);
      this.mRenderPaint.setColor(paramInt2);
      this.mRenderPaint.setStyle(localStyle);
    }
  }
  
  protected void drawFilledPath(Canvas paramCanvas, Path paramPath, Drawable paramDrawable)
  {
    if (clipPathSupported())
    {
      int i = paramCanvas.save();
      paramCanvas.clipPath(paramPath);
      paramDrawable.setBounds((int)this.mViewPortHandler.contentLeft(), (int)this.mViewPortHandler.contentTop(), (int)this.mViewPortHandler.contentRight(), (int)this.mViewPortHandler.contentBottom());
      paramDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    paramCanvas = new StringBuilder();
    paramCanvas.append("Fill-drawables not (yet) supported below API level 18, this code was run on API level ");
    paramCanvas.append(Utils.getSDKInt());
    paramCanvas.append(".");
    throw new RuntimeException(paramCanvas.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\LineRadarRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */