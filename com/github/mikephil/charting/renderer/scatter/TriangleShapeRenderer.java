package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class TriangleShapeRenderer
  implements IShapeRenderer
{
  protected Path mTrianglePathBuffer = new Path();
  
  public void renderShape(Canvas paramCanvas, IScatterDataSet paramIScatterDataSet, ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    float f1 = paramIScatterDataSet.getScatterShapeSize();
    float f2 = f1 / 2.0F;
    float f3 = (f1 - Utils.convertDpToPixel(paramIScatterDataSet.getScatterShapeHoleRadius()) * 2.0F) / 2.0F;
    int i = paramIScatterDataSet.getScatterShapeHoleColor();
    paramPaint.setStyle(Paint.Style.FILL);
    paramIScatterDataSet = this.mTrianglePathBuffer;
    paramIScatterDataSet.reset();
    float f4 = paramFloat2 - f2;
    paramIScatterDataSet.moveTo(paramFloat1, f4);
    float f5 = paramFloat1 + f2;
    paramFloat2 += f2;
    paramIScatterDataSet.lineTo(f5, paramFloat2);
    f2 = paramFloat1 - f2;
    paramIScatterDataSet.lineTo(f2, paramFloat2);
    boolean bool = f1 < 0.0D;
    if (bool)
    {
      paramIScatterDataSet.lineTo(paramFloat1, f4);
      float f6 = f2 + f3;
      f1 = paramFloat2 - f3;
      paramIScatterDataSet.moveTo(f6, f1);
      paramIScatterDataSet.lineTo(f5 - f3, f1);
      paramIScatterDataSet.lineTo(paramFloat1, f4 + f3);
      paramIScatterDataSet.lineTo(f6, f1);
    }
    paramIScatterDataSet.close();
    paramCanvas.drawPath(paramIScatterDataSet, paramPaint);
    paramIScatterDataSet.reset();
    if ((bool) && (i != 1122867))
    {
      paramPaint.setColor(i);
      paramIScatterDataSet.moveTo(paramFloat1, f4 + f3);
      paramFloat1 = paramFloat2 - f3;
      paramIScatterDataSet.lineTo(f5 - f3, paramFloat1);
      paramIScatterDataSet.lineTo(f2 + f3, paramFloat1);
      paramIScatterDataSet.close();
      paramCanvas.drawPath(paramIScatterDataSet, paramPaint);
      paramIScatterDataSet.reset();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\scatter\TriangleShapeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */