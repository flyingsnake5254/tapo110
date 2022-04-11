package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class PieChart
  extends PieRadarChartBase<PieData>
{
  private float[] mAbsoluteAngles = new float[1];
  private CharSequence mCenterText = "";
  private MPPointF mCenterTextOffset = MPPointF.getInstance(0.0F, 0.0F);
  private float mCenterTextRadiusPercent = 100.0F;
  private RectF mCircleBox = new RectF();
  private float[] mDrawAngles = new float[1];
  private boolean mDrawCenterText = true;
  private boolean mDrawEntryLabels = true;
  private boolean mDrawHole = true;
  private boolean mDrawRoundedSlices = false;
  private boolean mDrawSlicesUnderHole = false;
  private float mHoleRadiusPercent = 50.0F;
  protected float mMaxAngle = 360.0F;
  private float mMinAngleForSlices = 0.0F;
  protected float mTransparentCircleRadiusPercent = 55.0F;
  private boolean mUsePercentValues = false;
  
  public PieChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public PieChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PieChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float calcAngle(float paramFloat)
  {
    return calcAngle(paramFloat, ((PieData)this.mData).getYValueSum());
  }
  
  private float calcAngle(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 / paramFloat2 * this.mMaxAngle;
  }
  
  private void calcAngles()
  {
    int i = ((PieData)this.mData).getEntryCount();
    int j;
    if (this.mDrawAngles.length != i) {
      this.mDrawAngles = new float[i];
    } else {
      for (j = 0; j < i; j++) {
        this.mDrawAngles[j] = 0.0F;
      }
    }
    if (this.mAbsoluteAngles.length != i) {
      this.mAbsoluteAngles = new float[i];
    } else {
      for (j = 0; j < i; j++) {
        this.mAbsoluteAngles[j] = 0.0F;
      }
    }
    float f1 = ((PieData)this.mData).getYValueSum();
    Object localObject = ((PieData)this.mData).getDataSets();
    float f2 = this.mMinAngleForSlices;
    if ((f2 != 0.0F) && (i * f2 <= this.mMaxAngle)) {
      j = 1;
    } else {
      j = 0;
    }
    float[] arrayOfFloat1 = new float[i];
    int k = 0;
    float f3 = 0.0F;
    f2 = 0.0F;
    int m = 0;
    while (k < ((PieData)this.mData).getDataSetCount())
    {
      IPieDataSet localIPieDataSet = (IPieDataSet)((List)localObject).get(k);
      int n = 0;
      while (n < localIPieDataSet.getEntryCount())
      {
        float f4 = calcAngle(Math.abs(((PieEntry)localIPieDataSet.getEntryForIndex(n)).getY()), f1);
        float f5 = f3;
        float f6 = f2;
        if (j != 0)
        {
          f6 = this.mMinAngleForSlices;
          f5 = f4 - f6;
          if (f5 <= 0.0F)
          {
            arrayOfFloat1[m] = f6;
            f5 = f3 + -f5;
            f6 = f2;
          }
          else
          {
            arrayOfFloat1[m] = f4;
            f6 = f2 + f5;
            f5 = f3;
          }
        }
        float[] arrayOfFloat2 = this.mDrawAngles;
        arrayOfFloat2[m] = f4;
        if (m == 0)
        {
          this.mAbsoluteAngles[m] = arrayOfFloat2[m];
        }
        else
        {
          float[] arrayOfFloat3 = this.mAbsoluteAngles;
          arrayOfFloat3[m] = (arrayOfFloat3[(m - 1)] + arrayOfFloat2[m]);
        }
        m++;
        n++;
        f3 = f5;
        f2 = f6;
      }
      k++;
    }
    if (j != 0)
    {
      for (j = 0; j < i; j++)
      {
        arrayOfFloat1[j] -= (arrayOfFloat1[j] - this.mMinAngleForSlices) / f2 * f3;
        if (j == 0)
        {
          this.mAbsoluteAngles[0] = arrayOfFloat1[0];
        }
        else
        {
          localObject = this.mAbsoluteAngles;
          localObject[j] = (localObject[(j - 1)] + arrayOfFloat1[j]);
        }
      }
      this.mDrawAngles = arrayOfFloat1;
    }
  }
  
  protected void calcMinMax()
  {
    calcAngles();
  }
  
  public void calculateOffsets()
  {
    super.calculateOffsets();
    if (this.mData == null) {
      return;
    }
    float f1 = getDiameter() / 2.0F;
    MPPointF localMPPointF = getCenterOffsets();
    float f2 = ((PieData)this.mData).getDataSet().getSelectionShift();
    RectF localRectF = this.mCircleBox;
    float f3 = localMPPointF.x;
    float f4 = localMPPointF.y;
    localRectF.set(f3 - f1 + f2, f4 - f1 + f2, f3 + f1 - f2, f4 + f1 - f2);
    MPPointF.recycleInstance(localMPPointF);
  }
  
  public float[] getAbsoluteAngles()
  {
    return this.mAbsoluteAngles;
  }
  
  public MPPointF getCenterCircleBox()
  {
    return MPPointF.getInstance(this.mCircleBox.centerX(), this.mCircleBox.centerY());
  }
  
  public CharSequence getCenterText()
  {
    return this.mCenterText;
  }
  
  public MPPointF getCenterTextOffset()
  {
    MPPointF localMPPointF = this.mCenterTextOffset;
    return MPPointF.getInstance(localMPPointF.x, localMPPointF.y);
  }
  
  public float getCenterTextRadiusPercent()
  {
    return this.mCenterTextRadiusPercent;
  }
  
  public RectF getCircleBox()
  {
    return this.mCircleBox;
  }
  
  public int getDataSetIndexForIndex(int paramInt)
  {
    List localList = ((PieData)this.mData).getDataSets();
    for (int i = 0; i < localList.size(); i++) {
      if (((IPieDataSet)localList.get(i)).getEntryForXValue(paramInt, NaN.0F) != null) {
        return i;
      }
    }
    return -1;
  }
  
  public float[] getDrawAngles()
  {
    return this.mDrawAngles;
  }
  
  public float getHoleRadius()
  {
    return this.mHoleRadiusPercent;
  }
  
  public int getIndexForAngle(float paramFloat)
  {
    paramFloat = Utils.getNormalizedAngle(paramFloat - getRotationAngle());
    for (int i = 0;; i++)
    {
      float[] arrayOfFloat = this.mAbsoluteAngles;
      if (i >= arrayOfFloat.length) {
        break;
      }
      if (arrayOfFloat[i] > paramFloat) {
        return i;
      }
    }
    return -1;
  }
  
  protected float[] getMarkerPosition(Highlight paramHighlight)
  {
    MPPointF localMPPointF = getCenterCircleBox();
    float f1 = getRadius();
    float f2 = f1 / 10.0F * 3.6F;
    if (isDrawHoleEnabled()) {
      f2 = (f1 - f1 / 100.0F * getHoleRadius()) / 2.0F;
    }
    float f3 = getRotationAngle();
    int i = (int)paramHighlight.getX();
    float f4 = this.mDrawAngles[i] / 2.0F;
    double d = f1 - f2;
    f2 = (float)(Math.cos(Math.toRadians((this.mAbsoluteAngles[i] + f3 - f4) * this.mAnimator.getPhaseY())) * d + localMPPointF.x);
    f1 = (float)(d * Math.sin(Math.toRadians((f3 + this.mAbsoluteAngles[i] - f4) * this.mAnimator.getPhaseY())) + localMPPointF.y);
    MPPointF.recycleInstance(localMPPointF);
    return new float[] { f2, f1 };
  }
  
  public float getMaxAngle()
  {
    return this.mMaxAngle;
  }
  
  public float getMinAngleForSlices()
  {
    return this.mMinAngleForSlices;
  }
  
  public float getRadius()
  {
    RectF localRectF = this.mCircleBox;
    if (localRectF == null) {
      return 0.0F;
    }
    return Math.min(localRectF.width() / 2.0F, this.mCircleBox.height() / 2.0F);
  }
  
  protected float getRequiredBaseOffset()
  {
    return 0.0F;
  }
  
  protected float getRequiredLegendOffset()
  {
    return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0F;
  }
  
  public float getTransparentCircleRadius()
  {
    return this.mTransparentCircleRadiusPercent;
  }
  
  @Deprecated
  public XAxis getXAxis()
  {
    throw new RuntimeException("PieChart has no XAxis");
  }
  
  protected void init()
  {
    super.init();
    this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    this.mXAxis = null;
    this.mHighlighter = new PieHighlighter(this);
  }
  
  public boolean isDrawCenterTextEnabled()
  {
    return this.mDrawCenterText;
  }
  
  public boolean isDrawEntryLabelsEnabled()
  {
    return this.mDrawEntryLabels;
  }
  
  public boolean isDrawHoleEnabled()
  {
    return this.mDrawHole;
  }
  
  public boolean isDrawRoundedSlicesEnabled()
  {
    return this.mDrawRoundedSlices;
  }
  
  public boolean isDrawSlicesUnderHoleEnabled()
  {
    return this.mDrawSlicesUnderHole;
  }
  
  public boolean isUsePercentValuesEnabled()
  {
    return this.mUsePercentValues;
  }
  
  public boolean needsHighlight(int paramInt)
  {
    if (!valuesToHighlight()) {
      return false;
    }
    for (int i = 0;; i++)
    {
      Highlight[] arrayOfHighlight = this.mIndicesToHighlight;
      if (i >= arrayOfHighlight.length) {
        break;
      }
      if ((int)arrayOfHighlight[i].getX() == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    DataRenderer localDataRenderer = this.mRenderer;
    if ((localDataRenderer != null) && ((localDataRenderer instanceof PieChartRenderer))) {
      ((PieChartRenderer)localDataRenderer).releaseBitmap();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mData == null) {
      return;
    }
    this.mRenderer.drawData(paramCanvas);
    if (valuesToHighlight()) {
      this.mRenderer.drawHighlighted(paramCanvas, this.mIndicesToHighlight);
    }
    this.mRenderer.drawExtras(paramCanvas);
    this.mRenderer.drawValues(paramCanvas);
    this.mLegendRenderer.renderLegend(paramCanvas);
    drawDescription(paramCanvas);
    drawMarkers(paramCanvas);
  }
  
  public void setCenterText(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      this.mCenterText = "";
    } else {
      this.mCenterText = paramCharSequence;
    }
  }
  
  public void setCenterTextColor(int paramInt)
  {
    ((PieChartRenderer)this.mRenderer).getPaintCenterText().setColor(paramInt);
  }
  
  public void setCenterTextOffset(float paramFloat1, float paramFloat2)
  {
    this.mCenterTextOffset.x = Utils.convertDpToPixel(paramFloat1);
    this.mCenterTextOffset.y = Utils.convertDpToPixel(paramFloat2);
  }
  
  public void setCenterTextRadiusPercent(float paramFloat)
  {
    this.mCenterTextRadiusPercent = paramFloat;
  }
  
  public void setCenterTextSize(float paramFloat)
  {
    ((PieChartRenderer)this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(paramFloat));
  }
  
  public void setCenterTextSizePixels(float paramFloat)
  {
    ((PieChartRenderer)this.mRenderer).getPaintCenterText().setTextSize(paramFloat);
  }
  
  public void setCenterTextTypeface(Typeface paramTypeface)
  {
    ((PieChartRenderer)this.mRenderer).getPaintCenterText().setTypeface(paramTypeface);
  }
  
  public void setDrawCenterText(boolean paramBoolean)
  {
    this.mDrawCenterText = paramBoolean;
  }
  
  public void setDrawEntryLabels(boolean paramBoolean)
  {
    this.mDrawEntryLabels = paramBoolean;
  }
  
  public void setDrawHoleEnabled(boolean paramBoolean)
  {
    this.mDrawHole = paramBoolean;
  }
  
  public void setDrawRoundedSlices(boolean paramBoolean)
  {
    this.mDrawRoundedSlices = paramBoolean;
  }
  
  @Deprecated
  public void setDrawSliceText(boolean paramBoolean)
  {
    this.mDrawEntryLabels = paramBoolean;
  }
  
  public void setDrawSlicesUnderHole(boolean paramBoolean)
  {
    this.mDrawSlicesUnderHole = paramBoolean;
  }
  
  public void setEntryLabelColor(int paramInt)
  {
    ((PieChartRenderer)this.mRenderer).getPaintEntryLabels().setColor(paramInt);
  }
  
  public void setEntryLabelTextSize(float paramFloat)
  {
    ((PieChartRenderer)this.mRenderer).getPaintEntryLabels().setTextSize(Utils.convertDpToPixel(paramFloat));
  }
  
  public void setEntryLabelTypeface(Typeface paramTypeface)
  {
    ((PieChartRenderer)this.mRenderer).getPaintEntryLabels().setTypeface(paramTypeface);
  }
  
  public void setHoleColor(int paramInt)
  {
    ((PieChartRenderer)this.mRenderer).getPaintHole().setColor(paramInt);
  }
  
  public void setHoleRadius(float paramFloat)
  {
    this.mHoleRadiusPercent = paramFloat;
  }
  
  public void setMaxAngle(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 360.0F) {
      f = 360.0F;
    }
    paramFloat = f;
    if (f < 90.0F) {
      paramFloat = 90.0F;
    }
    this.mMaxAngle = paramFloat;
  }
  
  public void setMinAngleForSlices(float paramFloat)
  {
    float f = this.mMaxAngle;
    if (paramFloat > f / 2.0F)
    {
      f /= 2.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.mMinAngleForSlices = f;
  }
  
  public void setTransparentCircleAlpha(int paramInt)
  {
    ((PieChartRenderer)this.mRenderer).getPaintTransparentCircle().setAlpha(paramInt);
  }
  
  public void setTransparentCircleColor(int paramInt)
  {
    Paint localPaint = ((PieChartRenderer)this.mRenderer).getPaintTransparentCircle();
    int i = localPaint.getAlpha();
    localPaint.setColor(paramInt);
    localPaint.setAlpha(i);
  }
  
  public void setTransparentCircleRadius(float paramFloat)
  {
    this.mTransparentCircleRadiusPercent = paramFloat;
  }
  
  public void setUsePercentValues(boolean paramBoolean)
  {
    this.mUsePercentValues = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\PieChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */