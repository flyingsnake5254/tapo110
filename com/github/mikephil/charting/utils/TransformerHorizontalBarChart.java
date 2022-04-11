package com.github.mikephil.charting.utils;

import android.graphics.Matrix;

public class TransformerHorizontalBarChart
  extends Transformer
{
  public TransformerHorizontalBarChart(ViewPortHandler paramViewPortHandler)
  {
    super(paramViewPortHandler);
  }
  
  public void prepareMatrixOffset(boolean paramBoolean)
  {
    this.mMatrixOffset.reset();
    if (!paramBoolean)
    {
      this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
    }
    else
    {
      this.mMatrixOffset.setTranslate(-(this.mViewPortHandler.getChartWidth() - this.mViewPortHandler.offsetRight()), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
      this.mMatrixOffset.postScale(-1.0F, 1.0F);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\TransformerHorizontalBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */