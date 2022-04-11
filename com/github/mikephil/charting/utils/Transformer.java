package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

public class Transformer
{
  private Matrix mMBuffer1 = new Matrix();
  private Matrix mMBuffer2 = new Matrix();
  protected Matrix mMatrixOffset = new Matrix();
  protected Matrix mMatrixValueToPx = new Matrix();
  protected Matrix mPixelToValueMatrixBuffer = new Matrix();
  protected ViewPortHandler mViewPortHandler;
  float[] ptsBuffer = new float[2];
  protected float[] valuePointsForGenerateTransformedValuesBubble = new float[1];
  protected float[] valuePointsForGenerateTransformedValuesCandle = new float[1];
  protected float[] valuePointsForGenerateTransformedValuesLine = new float[1];
  protected float[] valuePointsForGenerateTransformedValuesScatter = new float[1];
  
  public Transformer(ViewPortHandler paramViewPortHandler)
  {
    this.mViewPortHandler = paramViewPortHandler;
  }
  
  public float[] generateTransformedValuesBubble(IBubbleDataSet paramIBubbleDataSet, float paramFloat, int paramInt1, int paramInt2)
  {
    int i = (paramInt2 - paramInt1 + 1) * 2;
    if (this.valuePointsForGenerateTransformedValuesBubble.length != i) {
      this.valuePointsForGenerateTransformedValuesBubble = new float[i];
    }
    float[] arrayOfFloat = this.valuePointsForGenerateTransformedValuesBubble;
    for (paramInt2 = 0; paramInt2 < i; paramInt2 += 2)
    {
      Entry localEntry = paramIBubbleDataSet.getEntryForIndex(paramInt2 / 2 + paramInt1);
      if (localEntry != null)
      {
        arrayOfFloat[paramInt2] = localEntry.getX();
        arrayOfFloat[(paramInt2 + 1)] = (localEntry.getY() * paramFloat);
      }
      else
      {
        arrayOfFloat[paramInt2] = 0.0F;
        arrayOfFloat[(paramInt2 + 1)] = 0.0F;
      }
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] generateTransformedValuesCandle(ICandleDataSet paramICandleDataSet, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = (int)((paramInt2 - paramInt1) * paramFloat1 + 1.0F) * 2;
    if (this.valuePointsForGenerateTransformedValuesCandle.length != i) {
      this.valuePointsForGenerateTransformedValuesCandle = new float[i];
    }
    float[] arrayOfFloat = this.valuePointsForGenerateTransformedValuesCandle;
    for (paramInt2 = 0; paramInt2 < i; paramInt2 += 2)
    {
      CandleEntry localCandleEntry = (CandleEntry)paramICandleDataSet.getEntryForIndex(paramInt2 / 2 + paramInt1);
      if (localCandleEntry != null)
      {
        arrayOfFloat[paramInt2] = localCandleEntry.getX();
        arrayOfFloat[(paramInt2 + 1)] = (localCandleEntry.getHigh() * paramFloat2);
      }
      else
      {
        arrayOfFloat[paramInt2] = 0.0F;
        arrayOfFloat[(paramInt2 + 1)] = 0.0F;
      }
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] generateTransformedValuesLine(ILineDataSet paramILineDataSet, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = ((int)((paramInt2 - paramInt1) * paramFloat1) + 1) * 2;
    if (this.valuePointsForGenerateTransformedValuesLine.length != i) {
      this.valuePointsForGenerateTransformedValuesLine = new float[i];
    }
    float[] arrayOfFloat = this.valuePointsForGenerateTransformedValuesLine;
    for (paramInt2 = 0; paramInt2 < i; paramInt2 += 2)
    {
      Entry localEntry = paramILineDataSet.getEntryForIndex(paramInt2 / 2 + paramInt1);
      if (localEntry != null)
      {
        arrayOfFloat[paramInt2] = localEntry.getX();
        arrayOfFloat[(paramInt2 + 1)] = (localEntry.getY() * paramFloat2);
      }
      else
      {
        arrayOfFloat[paramInt2] = 0.0F;
        arrayOfFloat[(paramInt2 + 1)] = 0.0F;
      }
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] generateTransformedValuesScatter(IScatterDataSet paramIScatterDataSet, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = (int)((paramInt2 - paramInt1) * paramFloat1 + 1.0F) * 2;
    if (this.valuePointsForGenerateTransformedValuesScatter.length != i) {
      this.valuePointsForGenerateTransformedValuesScatter = new float[i];
    }
    float[] arrayOfFloat = this.valuePointsForGenerateTransformedValuesScatter;
    for (paramInt2 = 0; paramInt2 < i; paramInt2 += 2)
    {
      Entry localEntry = paramIScatterDataSet.getEntryForIndex(paramInt2 / 2 + paramInt1);
      if (localEntry != null)
      {
        arrayOfFloat[paramInt2] = localEntry.getX();
        arrayOfFloat[(paramInt2 + 1)] = (localEntry.getY() * paramFloat2);
      }
      else
      {
        arrayOfFloat[paramInt2] = 0.0F;
        arrayOfFloat[(paramInt2 + 1)] = 0.0F;
      }
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public Matrix getOffsetMatrix()
  {
    return this.mMatrixOffset;
  }
  
  public MPPointD getPixelForValues(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.ptsBuffer;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    pointValuesToPixel(arrayOfFloat);
    arrayOfFloat = this.ptsBuffer;
    return MPPointD.getInstance(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public Matrix getPixelToValueMatrix()
  {
    getValueToPixelMatrix().invert(this.mMBuffer2);
    return this.mMBuffer2;
  }
  
  public Matrix getValueMatrix()
  {
    return this.mMatrixValueToPx;
  }
  
  public Matrix getValueToPixelMatrix()
  {
    this.mMBuffer1.set(this.mMatrixValueToPx);
    this.mMBuffer1.postConcat(this.mViewPortHandler.mMatrixTouch);
    this.mMBuffer1.postConcat(this.mMatrixOffset);
    return this.mMBuffer1;
  }
  
  public MPPointD getValuesByTouchPoint(float paramFloat1, float paramFloat2)
  {
    MPPointD localMPPointD = MPPointD.getInstance(0.0D, 0.0D);
    getValuesByTouchPoint(paramFloat1, paramFloat2, localMPPointD);
    return localMPPointD;
  }
  
  public void getValuesByTouchPoint(float paramFloat1, float paramFloat2, MPPointD paramMPPointD)
  {
    float[] arrayOfFloat = this.ptsBuffer;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    pixelsToValue(arrayOfFloat);
    arrayOfFloat = this.ptsBuffer;
    paramMPPointD.x = arrayOfFloat[0];
    paramMPPointD.y = arrayOfFloat[1];
  }
  
  public void pathValueToPixel(Path paramPath)
  {
    paramPath.transform(this.mMatrixValueToPx);
    paramPath.transform(this.mViewPortHandler.getMatrixTouch());
    paramPath.transform(this.mMatrixOffset);
  }
  
  public void pathValuesToPixel(List<Path> paramList)
  {
    for (int i = 0; i < paramList.size(); i++) {
      pathValueToPixel((Path)paramList.get(i));
    }
  }
  
  public void pixelsToValue(float[] paramArrayOfFloat)
  {
    Matrix localMatrix = this.mPixelToValueMatrixBuffer;
    localMatrix.reset();
    this.mMatrixOffset.invert(localMatrix);
    localMatrix.mapPoints(paramArrayOfFloat);
    this.mViewPortHandler.getMatrixTouch().invert(localMatrix);
    localMatrix.mapPoints(paramArrayOfFloat);
    this.mMatrixValueToPx.invert(localMatrix);
    localMatrix.mapPoints(paramArrayOfFloat);
  }
  
  public void pointValuesToPixel(float[] paramArrayOfFloat)
  {
    this.mMatrixValueToPx.mapPoints(paramArrayOfFloat);
    this.mViewPortHandler.getMatrixTouch().mapPoints(paramArrayOfFloat);
    this.mMatrixOffset.mapPoints(paramArrayOfFloat);
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
      this.mMatrixOffset.setTranslate(this.mViewPortHandler.offsetLeft(), -this.mViewPortHandler.offsetTop());
      this.mMatrixOffset.postScale(1.0F, -1.0F);
    }
  }
  
  public void prepareMatrixValuePx(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = this.mViewPortHandler.contentWidth() / paramFloat2;
    float f2 = this.mViewPortHandler.contentHeight() / paramFloat3;
    paramFloat2 = f1;
    if (Float.isInfinite(f1)) {
      paramFloat2 = 0.0F;
    }
    paramFloat3 = f2;
    if (Float.isInfinite(f2)) {
      paramFloat3 = 0.0F;
    }
    this.mMatrixValueToPx.reset();
    this.mMatrixValueToPx.postTranslate(-paramFloat1, -paramFloat4);
    this.mMatrixValueToPx.postScale(paramFloat2, -paramFloat3);
  }
  
  public void rectToPixelPhase(RectF paramRectF, float paramFloat)
  {
    paramRectF.top *= paramFloat;
    paramRectF.bottom *= paramFloat;
    this.mMatrixValueToPx.mapRect(paramRectF);
    this.mViewPortHandler.getMatrixTouch().mapRect(paramRectF);
    this.mMatrixOffset.mapRect(paramRectF);
  }
  
  public void rectToPixelPhaseHorizontal(RectF paramRectF, float paramFloat)
  {
    paramRectF.left *= paramFloat;
    paramRectF.right *= paramFloat;
    this.mMatrixValueToPx.mapRect(paramRectF);
    this.mViewPortHandler.getMatrixTouch().mapRect(paramRectF);
    this.mMatrixOffset.mapRect(paramRectF);
  }
  
  public void rectValueToPixel(RectF paramRectF)
  {
    this.mMatrixValueToPx.mapRect(paramRectF);
    this.mViewPortHandler.getMatrixTouch().mapRect(paramRectF);
    this.mMatrixOffset.mapRect(paramRectF);
  }
  
  public void rectValueToPixelHorizontal(RectF paramRectF)
  {
    this.mMatrixValueToPx.mapRect(paramRectF);
    this.mViewPortHandler.getMatrixTouch().mapRect(paramRectF);
    this.mMatrixOffset.mapRect(paramRectF);
  }
  
  public void rectValueToPixelHorizontal(RectF paramRectF, float paramFloat)
  {
    paramRectF.left *= paramFloat;
    paramRectF.right *= paramFloat;
    this.mMatrixValueToPx.mapRect(paramRectF);
    this.mViewPortHandler.getMatrixTouch().mapRect(paramRectF);
    this.mMatrixOffset.mapRect(paramRectF);
  }
  
  public void rectValuesToPixel(List<RectF> paramList)
  {
    Matrix localMatrix = getValueToPixelMatrix();
    for (int i = 0; i < paramList.size(); i++) {
      localMatrix.mapRect((RectF)paramList.get(i));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\Transformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */