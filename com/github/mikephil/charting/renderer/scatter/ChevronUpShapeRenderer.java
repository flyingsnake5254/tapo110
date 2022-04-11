package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ChevronUpShapeRenderer
  implements IShapeRenderer
{
  public void renderShape(Canvas paramCanvas, IScatterDataSet paramIScatterDataSet, ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    float f1 = paramIScatterDataSet.getScatterShapeSize() / 2.0F;
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setStrokeWidth(Utils.convertDpToPixel(1.0F));
    float f2 = f1 * 2.0F;
    f1 = paramFloat2 - f2;
    paramCanvas.drawLine(paramFloat1, f1, paramFloat1 + f2, paramFloat2, paramPaint);
    paramCanvas.drawLine(paramFloat1, f1, paramFloat1 - f2, paramFloat2, paramPaint);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\scatter\ChevronUpShapeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */