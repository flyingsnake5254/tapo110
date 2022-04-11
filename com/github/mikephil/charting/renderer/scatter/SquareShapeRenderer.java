package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class SquareShapeRenderer
  implements IShapeRenderer
{
  public void renderShape(Canvas paramCanvas, IScatterDataSet paramIScatterDataSet, ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    float f1 = paramIScatterDataSet.getScatterShapeSize();
    float f2 = f1 / 2.0F;
    float f3 = Utils.convertDpToPixel(paramIScatterDataSet.getScatterShapeHoleRadius());
    float f4 = (f1 - f3 * 2.0F) / 2.0F;
    float f5 = f4 / 2.0F;
    int i = paramIScatterDataSet.getScatterShapeHoleColor();
    if (f1 > 0.0D)
    {
      paramPaint.setStyle(Paint.Style.STROKE);
      paramPaint.setStrokeWidth(f4);
      f1 = paramFloat1 - f3;
      f4 = paramFloat2 - f3;
      paramFloat1 += f3;
      paramFloat2 += f3;
      paramCanvas.drawRect(f1 - f5, f4 - f5, paramFloat1 + f5, paramFloat2 + f5, paramPaint);
      if (i != 1122867)
      {
        paramPaint.setStyle(Paint.Style.FILL);
        paramPaint.setColor(i);
        paramCanvas.drawRect(f1, f4, paramFloat1, paramFloat2, paramPaint);
      }
    }
    else
    {
      paramPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(paramFloat1 - f2, paramFloat2 - f2, paramFloat1 + f2, paramFloat2 + f2, paramPaint);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\scatter\SquareShapeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */