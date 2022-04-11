package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.jobs.AnimatedMoveViewJob;
import com.github.mikephil.charting.jobs.AnimatedZoomJob;
import com.github.mikephil.charting.jobs.MoveViewJob;
import com.github.mikephil.charting.jobs.ZoomJob;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.AxisRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"RtlHardcoded"})
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>
  extends Chart<T>
  implements BarLineScatterCandleBubbleDataProvider
{
  private long drawCycles = 0L;
  protected boolean mAutoScaleMinMaxEnabled = false;
  protected YAxis mAxisLeft;
  protected YAxisRenderer mAxisRendererLeft;
  protected YAxisRenderer mAxisRendererRight;
  protected YAxis mAxisRight;
  protected Paint mBorderPaint;
  protected boolean mClipValuesToContent = false;
  private boolean mCustomViewPortEnabled = false;
  protected boolean mDoubleTapToZoomEnabled = true;
  private boolean mDragXEnabled = true;
  private boolean mDragYEnabled = true;
  protected boolean mDrawBorders = false;
  protected boolean mDrawGridBackground = false;
  protected OnDrawListener mDrawListener;
  protected Matrix mFitScreenMatrixBuffer = new Matrix();
  protected float[] mGetPositionBuffer = new float[2];
  protected Paint mGridBackgroundPaint;
  protected boolean mHighlightPerDragEnabled = true;
  protected boolean mKeepPositionOnRotation = false;
  protected Transformer mLeftAxisTransformer;
  protected int mMaxVisibleCount = 100;
  protected float mMinOffset = 15.0F;
  private RectF mOffsetsBuffer = new RectF();
  protected float[] mOnSizeChangedBuffer = new float[2];
  protected boolean mPinchZoomEnabled = false;
  protected Transformer mRightAxisTransformer;
  private boolean mScaleXEnabled = true;
  private boolean mScaleYEnabled = true;
  protected XAxisRenderer mXAxisRenderer;
  protected Matrix mZoomMatrixBuffer = new Matrix();
  protected MPPointD posForGetHighestVisibleX = MPPointD.getInstance(0.0D, 0.0D);
  protected MPPointD posForGetLowestVisibleX = MPPointD.getInstance(0.0D, 0.0D);
  private long totalTime = 0L;
  
  public BarLineChartBase(Context paramContext)
  {
    super(paramContext);
  }
  
  public BarLineChartBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BarLineChartBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void autoScale()
  {
    float f1 = getLowestVisibleX();
    float f2 = getHighestVisibleX();
    ((BarLineScatterCandleBubbleData)this.mData).calcMinMaxY(f1, f2);
    this.mXAxis.calculate(((BarLineScatterCandleBubbleData)this.mData).getXMin(), ((BarLineScatterCandleBubbleData)this.mData).getXMax());
    YAxis localYAxis;
    Object localObject1;
    Object localObject2;
    if (this.mAxisLeft.isEnabled())
    {
      localYAxis = this.mAxisLeft;
      localObject1 = (BarLineScatterCandleBubbleData)this.mData;
      localObject2 = YAxis.AxisDependency.LEFT;
      localYAxis.calculate(((ChartData)localObject1).getYMin((YAxis.AxisDependency)localObject2), ((BarLineScatterCandleBubbleData)this.mData).getYMax((YAxis.AxisDependency)localObject2));
    }
    if (this.mAxisRight.isEnabled())
    {
      localYAxis = this.mAxisRight;
      localObject2 = (BarLineScatterCandleBubbleData)this.mData;
      localObject1 = YAxis.AxisDependency.RIGHT;
      localYAxis.calculate(((ChartData)localObject2).getYMin((YAxis.AxisDependency)localObject1), ((BarLineScatterCandleBubbleData)this.mData).getYMax((YAxis.AxisDependency)localObject1));
    }
    calculateOffsets();
  }
  
  protected void calcMinMax()
  {
    this.mXAxis.calculate(((BarLineScatterCandleBubbleData)this.mData).getXMin(), ((BarLineScatterCandleBubbleData)this.mData).getXMax());
    Object localObject1 = this.mAxisLeft;
    BarLineScatterCandleBubbleData localBarLineScatterCandleBubbleData = (BarLineScatterCandleBubbleData)this.mData;
    Object localObject2 = YAxis.AxisDependency.LEFT;
    ((YAxis)localObject1).calculate(localBarLineScatterCandleBubbleData.getYMin((YAxis.AxisDependency)localObject2), ((BarLineScatterCandleBubbleData)this.mData).getYMax((YAxis.AxisDependency)localObject2));
    localObject2 = this.mAxisRight;
    localBarLineScatterCandleBubbleData = (BarLineScatterCandleBubbleData)this.mData;
    localObject1 = YAxis.AxisDependency.RIGHT;
    ((YAxis)localObject2).calculate(localBarLineScatterCandleBubbleData.getYMin((YAxis.AxisDependency)localObject1), ((BarLineScatterCandleBubbleData)this.mData).getYMax((YAxis.AxisDependency)localObject1));
  }
  
  protected void calculateLegendOffsets(RectF paramRectF)
  {
    paramRectF.left = 0.0F;
    paramRectF.right = 0.0F;
    paramRectF.top = 0.0F;
    paramRectF.bottom = 0.0F;
    Legend localLegend = this.mLegend;
    if ((localLegend != null) && (localLegend.isEnabled()) && (!this.mLegend.isDrawInsideEnabled()))
    {
      int i = 2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mLegend.getOrientation().ordinal()];
      if (i != 1)
      {
        if (i == 2)
        {
          i = 2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
          if (i != 1)
          {
            if (i == 2) {
              paramRectF.bottom += Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent()) + this.mLegend.getYOffset();
            }
          }
          else {
            paramRectF.top += Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent()) + this.mLegend.getYOffset();
          }
        }
      }
      else
      {
        i = 2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[this.mLegend.getHorizontalAlignment().ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              i = 2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
              if (i != 1)
              {
                if (i == 2) {
                  paramRectF.bottom += Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent()) + this.mLegend.getYOffset();
                }
              }
              else {
                paramRectF.top += Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent()) + this.mLegend.getYOffset();
              }
            }
          }
          else {
            paramRectF.right += Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent()) + this.mLegend.getXOffset();
          }
        }
        else {
          paramRectF.left += Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent()) + this.mLegend.getXOffset();
        }
      }
    }
  }
  
  public void calculateOffsets()
  {
    if (!this.mCustomViewPortEnabled)
    {
      calculateLegendOffsets(this.mOffsetsBuffer);
      Object localObject = this.mOffsetsBuffer;
      float f1 = ((RectF)localObject).left + 0.0F;
      float f2 = ((RectF)localObject).top + 0.0F;
      float f3 = ((RectF)localObject).right + 0.0F;
      float f4 = ((RectF)localObject).bottom + 0.0F;
      float f5 = f1;
      if (this.mAxisLeft.needsOffset()) {
        f5 = f1 + this.mAxisLeft.getRequiredWidthSpace(this.mAxisRendererLeft.getPaintAxisLabels());
      }
      f1 = f3;
      if (this.mAxisRight.needsOffset()) {
        f1 = f3 + this.mAxisRight.getRequiredWidthSpace(this.mAxisRendererRight.getPaintAxisLabels());
      }
      f3 = f4;
      float f6 = f2;
      if (this.mXAxis.isEnabled())
      {
        f3 = f4;
        f6 = f2;
        if (this.mXAxis.isDrawLabelsEnabled())
        {
          localObject = this.mXAxis;
          float f7 = ((XAxis)localObject).mLabelRotatedHeight + ((ComponentBase)localObject).getYOffset();
          if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM)
          {
            f3 = f4 + f7;
            f6 = f2;
          }
          else
          {
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {}
            for (f3 = f4;; f3 = f4 + f7)
            {
              f6 = f2 + f7;
              break;
              f3 = f4;
              f6 = f2;
              if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTH_SIDED) {
                break;
              }
            }
          }
        }
      }
      f4 = f6 + getExtraTopOffset();
      f1 += getExtraRightOffset();
      f3 += getExtraBottomOffset();
      f5 += getExtraLeftOffset();
      f6 = Utils.convertDpToPixel(this.mMinOffset);
      this.mViewPortHandler.restrainViewPort(Math.max(f6, f5), Math.max(f6, f4), Math.max(f6, f1), Math.max(f6, f3));
      if (this.mLogEnabled)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("offsetLeft: ");
        ((StringBuilder)localObject).append(f5);
        ((StringBuilder)localObject).append(", offsetTop: ");
        ((StringBuilder)localObject).append(f4);
        ((StringBuilder)localObject).append(", offsetRight: ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", offsetBottom: ");
        ((StringBuilder)localObject).append(f3);
        Log.i("MPAndroidChart", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Content: ");
        ((StringBuilder)localObject).append(this.mViewPortHandler.getContentRect().toString());
        Log.i("MPAndroidChart", ((StringBuilder)localObject).toString());
      }
    }
    prepareOffsetMatrix();
    prepareValuePxMatrix();
  }
  
  public void centerViewTo(float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency)
  {
    float f1 = getAxisRange(paramAxisDependency) / this.mViewPortHandler.getScaleY();
    float f2 = getXAxis().mAxisRange / this.mViewPortHandler.getScaleX();
    addViewportJob(MoveViewJob.getInstance(this.mViewPortHandler, paramFloat1 - f2 / 2.0F, paramFloat2 + f1 / 2.0F, getTransformer(paramAxisDependency), this));
  }
  
  @TargetApi(11)
  public void centerViewToAnimated(float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency, long paramLong)
  {
    MPPointD localMPPointD = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), paramAxisDependency);
    float f1 = getAxisRange(paramAxisDependency) / this.mViewPortHandler.getScaleY();
    float f2 = getXAxis().mAxisRange / this.mViewPortHandler.getScaleX();
    addViewportJob(AnimatedMoveViewJob.getInstance(this.mViewPortHandler, paramFloat1 - f2 / 2.0F, paramFloat2 + f1 / 2.0F, getTransformer(paramAxisDependency), this, (float)localMPPointD.x, (float)localMPPointD.y, paramLong));
    MPPointD.recycleInstance(localMPPointD);
  }
  
  public void centerViewToY(float paramFloat, YAxis.AxisDependency paramAxisDependency)
  {
    float f = getAxisRange(paramAxisDependency) / this.mViewPortHandler.getScaleY();
    addViewportJob(MoveViewJob.getInstance(this.mViewPortHandler, 0.0F, paramFloat + f / 2.0F, getTransformer(paramAxisDependency), this));
  }
  
  public void computeScroll()
  {
    ChartTouchListener localChartTouchListener = this.mChartTouchListener;
    if ((localChartTouchListener instanceof BarLineChartTouchListener)) {
      ((BarLineChartTouchListener)localChartTouchListener).computeScroll();
    }
  }
  
  protected void drawGridBackground(Canvas paramCanvas)
  {
    if (this.mDrawGridBackground) {
      paramCanvas.drawRect(this.mViewPortHandler.getContentRect(), this.mGridBackgroundPaint);
    }
    if (this.mDrawBorders) {
      paramCanvas.drawRect(this.mViewPortHandler.getContentRect(), this.mBorderPaint);
    }
  }
  
  public void fitScreen()
  {
    Matrix localMatrix = this.mFitScreenMatrixBuffer;
    this.mViewPortHandler.fitScreen(localMatrix);
    this.mViewPortHandler.refresh(localMatrix, this, false);
    calculateOffsets();
    postInvalidate();
  }
  
  public YAxis getAxis(YAxis.AxisDependency paramAxisDependency)
  {
    if (paramAxisDependency == YAxis.AxisDependency.LEFT) {
      return this.mAxisLeft;
    }
    return this.mAxisRight;
  }
  
  public YAxis getAxisLeft()
  {
    return this.mAxisLeft;
  }
  
  protected float getAxisRange(YAxis.AxisDependency paramAxisDependency)
  {
    if (paramAxisDependency == YAxis.AxisDependency.LEFT) {
      return this.mAxisLeft.mAxisRange;
    }
    return this.mAxisRight.mAxisRange;
  }
  
  public YAxis getAxisRight()
  {
    return this.mAxisRight;
  }
  
  public IBarLineScatterCandleBubbleDataSet getDataSetByTouchPoint(float paramFloat1, float paramFloat2)
  {
    Highlight localHighlight = getHighlightByTouchPoint(paramFloat1, paramFloat2);
    if (localHighlight != null) {
      return (IBarLineScatterCandleBubbleDataSet)((BarLineScatterCandleBubbleData)this.mData).getDataSetByIndex(localHighlight.getDataSetIndex());
    }
    return null;
  }
  
  public OnDrawListener getDrawListener()
  {
    return this.mDrawListener;
  }
  
  public Entry getEntryByTouchPoint(float paramFloat1, float paramFloat2)
  {
    Highlight localHighlight = getHighlightByTouchPoint(paramFloat1, paramFloat2);
    if (localHighlight != null) {
      return ((BarLineScatterCandleBubbleData)this.mData).getEntryForHighlight(localHighlight);
    }
    return null;
  }
  
  public float getHighestVisibleX()
  {
    getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.posForGetHighestVisibleX);
    return (float)Math.min(this.mXAxis.mAxisMaximum, this.posForGetHighestVisibleX.x);
  }
  
  public float getLowestVisibleX()
  {
    getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.posForGetLowestVisibleX);
    return (float)Math.max(this.mXAxis.mAxisMinimum, this.posForGetLowestVisibleX.x);
  }
  
  public int getMaxVisibleCount()
  {
    return this.mMaxVisibleCount;
  }
  
  public float getMinOffset()
  {
    return this.mMinOffset;
  }
  
  public Paint getPaint(int paramInt)
  {
    Paint localPaint = super.getPaint(paramInt);
    if (localPaint != null) {
      return localPaint;
    }
    if (paramInt != 4) {
      return null;
    }
    return this.mGridBackgroundPaint;
  }
  
  public MPPointD getPixelForValues(float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency)
  {
    return getTransformer(paramAxisDependency).getPixelForValues(paramFloat1, paramFloat2);
  }
  
  public MPPointF getPosition(Entry paramEntry, YAxis.AxisDependency paramAxisDependency)
  {
    if (paramEntry == null) {
      return null;
    }
    this.mGetPositionBuffer[0] = paramEntry.getX();
    this.mGetPositionBuffer[1] = paramEntry.getY();
    getTransformer(paramAxisDependency).pointValuesToPixel(this.mGetPositionBuffer);
    paramEntry = this.mGetPositionBuffer;
    return MPPointF.getInstance(paramEntry[0], paramEntry[1]);
  }
  
  public YAxisRenderer getRendererLeftYAxis()
  {
    return this.mAxisRendererLeft;
  }
  
  public YAxisRenderer getRendererRightYAxis()
  {
    return this.mAxisRendererRight;
  }
  
  public XAxisRenderer getRendererXAxis()
  {
    return this.mXAxisRenderer;
  }
  
  public float getScaleX()
  {
    ViewPortHandler localViewPortHandler = this.mViewPortHandler;
    if (localViewPortHandler == null) {
      return 1.0F;
    }
    return localViewPortHandler.getScaleX();
  }
  
  public float getScaleY()
  {
    ViewPortHandler localViewPortHandler = this.mViewPortHandler;
    if (localViewPortHandler == null) {
      return 1.0F;
    }
    return localViewPortHandler.getScaleY();
  }
  
  public Transformer getTransformer(YAxis.AxisDependency paramAxisDependency)
  {
    if (paramAxisDependency == YAxis.AxisDependency.LEFT) {
      return this.mLeftAxisTransformer;
    }
    return this.mRightAxisTransformer;
  }
  
  public MPPointD getValuesByTouchPoint(float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency)
  {
    MPPointD localMPPointD = MPPointD.getInstance(0.0D, 0.0D);
    getValuesByTouchPoint(paramFloat1, paramFloat2, paramAxisDependency, localMPPointD);
    return localMPPointD;
  }
  
  public void getValuesByTouchPoint(float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency, MPPointD paramMPPointD)
  {
    getTransformer(paramAxisDependency).getValuesByTouchPoint(paramFloat1, paramFloat2, paramMPPointD);
  }
  
  public float getVisibleXRange()
  {
    return Math.abs(getHighestVisibleX() - getLowestVisibleX());
  }
  
  public float getYChartMax()
  {
    return Math.max(this.mAxisLeft.mAxisMaximum, this.mAxisRight.mAxisMaximum);
  }
  
  public float getYChartMin()
  {
    return Math.min(this.mAxisLeft.mAxisMinimum, this.mAxisRight.mAxisMinimum);
  }
  
  public boolean hasNoDragOffset()
  {
    return this.mViewPortHandler.hasNoDragOffset();
  }
  
  protected void init()
  {
    super.init();
    this.mAxisLeft = new YAxis(YAxis.AxisDependency.LEFT);
    this.mAxisRight = new YAxis(YAxis.AxisDependency.RIGHT);
    this.mLeftAxisTransformer = new Transformer(this.mViewPortHandler);
    this.mRightAxisTransformer = new Transformer(this.mViewPortHandler);
    this.mAxisRendererLeft = new YAxisRenderer(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
    this.mAxisRendererRight = new YAxisRenderer(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
    this.mXAxisRenderer = new XAxisRenderer(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer);
    setHighlighter(new ChartHighlighter(this));
    this.mChartTouchListener = new BarLineChartTouchListener(this, this.mViewPortHandler.getMatrixTouch(), 3.0F);
    Paint localPaint = new Paint();
    this.mGridBackgroundPaint = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    this.mGridBackgroundPaint.setColor(Color.rgb(240, 240, 240));
    localPaint = new Paint();
    this.mBorderPaint = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    this.mBorderPaint.setColor(-16777216);
    this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0F));
  }
  
  public boolean isAnyAxisInverted()
  {
    if (this.mAxisLeft.isInverted()) {
      return true;
    }
    return this.mAxisRight.isInverted();
  }
  
  public boolean isAutoScaleMinMaxEnabled()
  {
    return this.mAutoScaleMinMaxEnabled;
  }
  
  public boolean isClipValuesToContentEnabled()
  {
    return this.mClipValuesToContent;
  }
  
  public boolean isDoubleTapToZoomEnabled()
  {
    return this.mDoubleTapToZoomEnabled;
  }
  
  public boolean isDragEnabled()
  {
    boolean bool;
    if ((!this.mDragXEnabled) && (!this.mDragYEnabled)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isDragXEnabled()
  {
    return this.mDragXEnabled;
  }
  
  public boolean isDragYEnabled()
  {
    return this.mDragYEnabled;
  }
  
  public boolean isDrawBordersEnabled()
  {
    return this.mDrawBorders;
  }
  
  public boolean isFullyZoomedOut()
  {
    return this.mViewPortHandler.isFullyZoomedOut();
  }
  
  public boolean isHighlightPerDragEnabled()
  {
    return this.mHighlightPerDragEnabled;
  }
  
  public boolean isInverted(YAxis.AxisDependency paramAxisDependency)
  {
    return getAxis(paramAxisDependency).isInverted();
  }
  
  public boolean isKeepPositionOnRotation()
  {
    return this.mKeepPositionOnRotation;
  }
  
  public boolean isPinchZoomEnabled()
  {
    return this.mPinchZoomEnabled;
  }
  
  public boolean isScaleXEnabled()
  {
    return this.mScaleXEnabled;
  }
  
  public boolean isScaleYEnabled()
  {
    return this.mScaleYEnabled;
  }
  
  public void moveViewTo(float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency)
  {
    float f = getAxisRange(paramAxisDependency) / this.mViewPortHandler.getScaleY();
    addViewportJob(MoveViewJob.getInstance(this.mViewPortHandler, paramFloat1, paramFloat2 + f / 2.0F, getTransformer(paramAxisDependency), this));
  }
  
  @TargetApi(11)
  public void moveViewToAnimated(float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency, long paramLong)
  {
    MPPointD localMPPointD = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), paramAxisDependency);
    float f = getAxisRange(paramAxisDependency) / this.mViewPortHandler.getScaleY();
    addViewportJob(AnimatedMoveViewJob.getInstance(this.mViewPortHandler, paramFloat1, paramFloat2 + f / 2.0F, getTransformer(paramAxisDependency), this, (float)localMPPointD.x, (float)localMPPointD.y, paramLong));
    MPPointD.recycleInstance(localMPPointD);
  }
  
  public void moveViewToX(float paramFloat)
  {
    addViewportJob(MoveViewJob.getInstance(this.mViewPortHandler, paramFloat, 0.0F, getTransformer(YAxis.AxisDependency.LEFT), this));
  }
  
  public void notifyDataSetChanged()
  {
    if (this.mData == null)
    {
      if (this.mLogEnabled) {
        Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
      }
      return;
    }
    if (this.mLogEnabled) {
      Log.i("MPAndroidChart", "Preparing...");
    }
    Object localObject1 = this.mRenderer;
    if (localObject1 != null) {
      ((DataRenderer)localObject1).initBuffers();
    }
    calcMinMax();
    localObject1 = this.mAxisRendererLeft;
    Object localObject2 = this.mAxisLeft;
    ((AxisRenderer)localObject1).computeAxis(((AxisBase)localObject2).mAxisMinimum, ((AxisBase)localObject2).mAxisMaximum, ((YAxis)localObject2).isInverted());
    localObject1 = this.mAxisRendererRight;
    localObject2 = this.mAxisRight;
    ((AxisRenderer)localObject1).computeAxis(((AxisBase)localObject2).mAxisMinimum, ((AxisBase)localObject2).mAxisMaximum, ((YAxis)localObject2).isInverted());
    localObject1 = this.mXAxisRenderer;
    localObject2 = this.mXAxis;
    ((XAxisRenderer)localObject1).computeAxis(((AxisBase)localObject2).mAxisMinimum, ((AxisBase)localObject2).mAxisMaximum, false);
    if (this.mLegend != null) {
      this.mLegendRenderer.computeLegend(this.mData);
    }
    calculateOffsets();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mData == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    drawGridBackground(paramCanvas);
    if (this.mAutoScaleMinMaxEnabled) {
      autoScale();
    }
    Object localObject1;
    Object localObject2;
    if (this.mAxisLeft.isEnabled())
    {
      localObject1 = this.mAxisRendererLeft;
      localObject2 = this.mAxisLeft;
      ((AxisRenderer)localObject1).computeAxis(((AxisBase)localObject2).mAxisMinimum, ((AxisBase)localObject2).mAxisMaximum, ((YAxis)localObject2).isInverted());
    }
    if (this.mAxisRight.isEnabled())
    {
      localObject2 = this.mAxisRendererRight;
      localObject1 = this.mAxisRight;
      ((AxisRenderer)localObject2).computeAxis(((AxisBase)localObject1).mAxisMinimum, ((AxisBase)localObject1).mAxisMaximum, ((YAxis)localObject1).isInverted());
    }
    if (this.mXAxis.isEnabled())
    {
      localObject1 = this.mXAxisRenderer;
      localObject2 = this.mXAxis;
      ((XAxisRenderer)localObject1).computeAxis(((AxisBase)localObject2).mAxisMinimum, ((AxisBase)localObject2).mAxisMaximum, false);
    }
    this.mXAxisRenderer.renderAxisLine(paramCanvas);
    this.mAxisRendererLeft.renderAxisLine(paramCanvas);
    this.mAxisRendererRight.renderAxisLine(paramCanvas);
    if (this.mXAxis.isDrawGridLinesBehindDataEnabled()) {
      this.mXAxisRenderer.renderGridLines(paramCanvas);
    }
    if (this.mAxisLeft.isDrawGridLinesBehindDataEnabled()) {
      this.mAxisRendererLeft.renderGridLines(paramCanvas);
    }
    if (this.mAxisRight.isDrawGridLinesBehindDataEnabled()) {
      this.mAxisRendererRight.renderGridLines(paramCanvas);
    }
    if ((this.mXAxis.isEnabled()) && (this.mXAxis.isDrawLimitLinesBehindDataEnabled())) {
      this.mXAxisRenderer.renderLimitLines(paramCanvas);
    }
    if ((this.mAxisLeft.isEnabled()) && (this.mAxisLeft.isDrawLimitLinesBehindDataEnabled())) {
      this.mAxisRendererLeft.renderLimitLines(paramCanvas);
    }
    if ((this.mAxisRight.isEnabled()) && (this.mAxisRight.isDrawLimitLinesBehindDataEnabled())) {
      this.mAxisRendererRight.renderLimitLines(paramCanvas);
    }
    int i = paramCanvas.save();
    paramCanvas.clipRect(this.mViewPortHandler.getContentRect());
    this.mRenderer.drawData(paramCanvas);
    if (!this.mXAxis.isDrawGridLinesBehindDataEnabled()) {
      this.mXAxisRenderer.renderGridLines(paramCanvas);
    }
    if (!this.mAxisLeft.isDrawGridLinesBehindDataEnabled()) {
      this.mAxisRendererLeft.renderGridLines(paramCanvas);
    }
    if (!this.mAxisRight.isDrawGridLinesBehindDataEnabled()) {
      this.mAxisRendererRight.renderGridLines(paramCanvas);
    }
    if (valuesToHighlight()) {
      this.mRenderer.drawHighlighted(paramCanvas, this.mIndicesToHighlight);
    }
    paramCanvas.restoreToCount(i);
    this.mRenderer.drawExtras(paramCanvas);
    if ((this.mXAxis.isEnabled()) && (!this.mXAxis.isDrawLimitLinesBehindDataEnabled())) {
      this.mXAxisRenderer.renderLimitLines(paramCanvas);
    }
    if ((this.mAxisLeft.isEnabled()) && (!this.mAxisLeft.isDrawLimitLinesBehindDataEnabled())) {
      this.mAxisRendererLeft.renderLimitLines(paramCanvas);
    }
    if ((this.mAxisRight.isEnabled()) && (!this.mAxisRight.isDrawLimitLinesBehindDataEnabled())) {
      this.mAxisRendererRight.renderLimitLines(paramCanvas);
    }
    this.mXAxisRenderer.renderAxisLabels(paramCanvas);
    this.mAxisRendererLeft.renderAxisLabels(paramCanvas);
    this.mAxisRendererRight.renderAxisLabels(paramCanvas);
    if (isClipValuesToContentEnabled())
    {
      i = paramCanvas.save();
      paramCanvas.clipRect(this.mViewPortHandler.getContentRect());
      this.mRenderer.drawValues(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
    else
    {
      this.mRenderer.drawValues(paramCanvas);
    }
    this.mLegendRenderer.renderLegend(paramCanvas);
    drawDescription(paramCanvas);
    drawMarkers(paramCanvas);
    if (this.mLogEnabled)
    {
      l1 = System.currentTimeMillis() - l1;
      long l2 = this.totalTime + l1;
      this.totalTime = l2;
      long l3 = this.drawCycles + 1L;
      this.drawCycles = l3;
      l3 = l2 / l3;
      paramCanvas = new StringBuilder();
      paramCanvas.append("Drawtime: ");
      paramCanvas.append(l1);
      paramCanvas.append(" ms, average: ");
      paramCanvas.append(l3);
      paramCanvas.append(" ms, cycles: ");
      paramCanvas.append(this.drawCycles);
      Log.i("MPAndroidChart", paramCanvas.toString());
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.mOnSizeChangedBuffer;
    localObject[1] = 0.0F;
    localObject[0] = 0.0F;
    if (this.mKeepPositionOnRotation)
    {
      localObject[0] = this.mViewPortHandler.contentLeft();
      this.mOnSizeChangedBuffer[1] = this.mViewPortHandler.contentTop();
      getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(this.mOnSizeChangedBuffer);
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mKeepPositionOnRotation)
    {
      getTransformer(YAxis.AxisDependency.LEFT).pointValuesToPixel(this.mOnSizeChangedBuffer);
      this.mViewPortHandler.centerViewPort(this.mOnSizeChangedBuffer, this);
    }
    else
    {
      localObject = this.mViewPortHandler;
      ((ViewPortHandler)localObject).refresh(((ViewPortHandler)localObject).getMatrixTouch(), this, true);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    ChartTouchListener localChartTouchListener = this.mChartTouchListener;
    if ((localChartTouchListener != null) && (this.mData != null))
    {
      if (!this.mTouchEnabled) {
        return false;
      }
      return localChartTouchListener.onTouch(this, paramMotionEvent);
    }
    return false;
  }
  
  protected void prepareOffsetMatrix()
  {
    this.mRightAxisTransformer.prepareMatrixOffset(this.mAxisRight.isInverted());
    this.mLeftAxisTransformer.prepareMatrixOffset(this.mAxisLeft.isInverted());
  }
  
  protected void prepareValuePxMatrix()
  {
    if (this.mLogEnabled)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Preparing Value-Px Matrix, xmin: ");
      ((StringBuilder)localObject1).append(this.mXAxis.mAxisMinimum);
      ((StringBuilder)localObject1).append(", xmax: ");
      ((StringBuilder)localObject1).append(this.mXAxis.mAxisMaximum);
      ((StringBuilder)localObject1).append(", xdelta: ");
      ((StringBuilder)localObject1).append(this.mXAxis.mAxisRange);
      Log.i("MPAndroidChart", ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.mRightAxisTransformer;
    Object localObject2 = this.mXAxis;
    float f1 = ((AxisBase)localObject2).mAxisMinimum;
    float f2 = ((AxisBase)localObject2).mAxisRange;
    localObject2 = this.mAxisRight;
    ((Transformer)localObject1).prepareMatrixValuePx(f1, f2, ((AxisBase)localObject2).mAxisRange, ((AxisBase)localObject2).mAxisMinimum);
    localObject1 = this.mLeftAxisTransformer;
    localObject2 = this.mXAxis;
    f2 = ((AxisBase)localObject2).mAxisMinimum;
    f1 = ((AxisBase)localObject2).mAxisRange;
    localObject2 = this.mAxisLeft;
    ((Transformer)localObject1).prepareMatrixValuePx(f2, f1, ((AxisBase)localObject2).mAxisRange, ((AxisBase)localObject2).mAxisMinimum);
  }
  
  public void resetTracking()
  {
    this.totalTime = 0L;
    this.drawCycles = 0L;
  }
  
  public void resetViewPortOffsets()
  {
    this.mCustomViewPortEnabled = false;
    calculateOffsets();
  }
  
  public void resetZoom()
  {
    this.mViewPortHandler.resetZoom(this.mZoomMatrixBuffer);
    this.mViewPortHandler.refresh(this.mZoomMatrixBuffer, this, false);
    calculateOffsets();
    postInvalidate();
  }
  
  public void setAutoScaleMinMaxEnabled(boolean paramBoolean)
  {
    this.mAutoScaleMinMaxEnabled = paramBoolean;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.mBorderPaint.setColor(paramInt);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(paramFloat));
  }
  
  public void setClipValuesToContent(boolean paramBoolean)
  {
    this.mClipValuesToContent = paramBoolean;
  }
  
  public void setDoubleTapToZoomEnabled(boolean paramBoolean)
  {
    this.mDoubleTapToZoomEnabled = paramBoolean;
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.mDragXEnabled = paramBoolean;
    this.mDragYEnabled = paramBoolean;
  }
  
  public void setDragOffsetX(float paramFloat)
  {
    this.mViewPortHandler.setDragOffsetX(paramFloat);
  }
  
  public void setDragOffsetY(float paramFloat)
  {
    this.mViewPortHandler.setDragOffsetY(paramFloat);
  }
  
  public void setDragXEnabled(boolean paramBoolean)
  {
    this.mDragXEnabled = paramBoolean;
  }
  
  public void setDragYEnabled(boolean paramBoolean)
  {
    this.mDragYEnabled = paramBoolean;
  }
  
  public void setDrawBorders(boolean paramBoolean)
  {
    this.mDrawBorders = paramBoolean;
  }
  
  public void setDrawGridBackground(boolean paramBoolean)
  {
    this.mDrawGridBackground = paramBoolean;
  }
  
  public void setGridBackgroundColor(int paramInt)
  {
    this.mGridBackgroundPaint.setColor(paramInt);
  }
  
  public void setHighlightPerDragEnabled(boolean paramBoolean)
  {
    this.mHighlightPerDragEnabled = paramBoolean;
  }
  
  public void setKeepPositionOnRotation(boolean paramBoolean)
  {
    this.mKeepPositionOnRotation = paramBoolean;
  }
  
  public void setMaxVisibleValueCount(int paramInt)
  {
    this.mMaxVisibleCount = paramInt;
  }
  
  public void setMinOffset(float paramFloat)
  {
    this.mMinOffset = paramFloat;
  }
  
  public void setOnDrawListener(OnDrawListener paramOnDrawListener)
  {
    this.mDrawListener = paramOnDrawListener;
  }
  
  public void setPaint(Paint paramPaint, int paramInt)
  {
    super.setPaint(paramPaint, paramInt);
    if (paramInt == 4) {
      this.mGridBackgroundPaint = paramPaint;
    }
  }
  
  public void setPinchZoom(boolean paramBoolean)
  {
    this.mPinchZoomEnabled = paramBoolean;
  }
  
  public void setRendererLeftYAxis(YAxisRenderer paramYAxisRenderer)
  {
    this.mAxisRendererLeft = paramYAxisRenderer;
  }
  
  public void setRendererRightYAxis(YAxisRenderer paramYAxisRenderer)
  {
    this.mAxisRendererRight = paramYAxisRenderer;
  }
  
  public void setScaleEnabled(boolean paramBoolean)
  {
    this.mScaleXEnabled = paramBoolean;
    this.mScaleYEnabled = paramBoolean;
  }
  
  public void setScaleMinima(float paramFloat1, float paramFloat2)
  {
    this.mViewPortHandler.setMinimumScaleX(paramFloat1);
    this.mViewPortHandler.setMinimumScaleY(paramFloat2);
  }
  
  public void setScaleXEnabled(boolean paramBoolean)
  {
    this.mScaleXEnabled = paramBoolean;
  }
  
  public void setScaleYEnabled(boolean paramBoolean)
  {
    this.mScaleYEnabled = paramBoolean;
  }
  
  public void setViewPortOffsets(final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    this.mCustomViewPortEnabled = true;
    post(new Runnable()
    {
      public void run()
      {
        BarLineChartBase.this.mViewPortHandler.restrainViewPort(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        BarLineChartBase.this.prepareOffsetMatrix();
        BarLineChartBase.this.prepareValuePxMatrix();
      }
    });
  }
  
  public void setVisibleXRange(float paramFloat1, float paramFloat2)
  {
    float f = this.mXAxis.mAxisRange;
    paramFloat1 = f / paramFloat1;
    paramFloat2 = f / paramFloat2;
    this.mViewPortHandler.setMinMaxScaleX(paramFloat1, paramFloat2);
  }
  
  public void setVisibleXRangeMaximum(float paramFloat)
  {
    paramFloat = this.mXAxis.mAxisRange / paramFloat;
    this.mViewPortHandler.setMinimumScaleX(paramFloat);
  }
  
  public void setVisibleXRangeMinimum(float paramFloat)
  {
    paramFloat = this.mXAxis.mAxisRange / paramFloat;
    this.mViewPortHandler.setMaximumScaleX(paramFloat);
  }
  
  public void setVisibleYRange(float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency)
  {
    paramFloat1 = getAxisRange(paramAxisDependency) / paramFloat1;
    paramFloat2 = getAxisRange(paramAxisDependency) / paramFloat2;
    this.mViewPortHandler.setMinMaxScaleY(paramFloat1, paramFloat2);
  }
  
  public void setVisibleYRangeMaximum(float paramFloat, YAxis.AxisDependency paramAxisDependency)
  {
    paramFloat = getAxisRange(paramAxisDependency) / paramFloat;
    this.mViewPortHandler.setMinimumScaleY(paramFloat);
  }
  
  public void setVisibleYRangeMinimum(float paramFloat, YAxis.AxisDependency paramAxisDependency)
  {
    paramFloat = getAxisRange(paramAxisDependency) / paramFloat;
    this.mViewPortHandler.setMaximumScaleY(paramFloat);
  }
  
  public void setXAxisRenderer(XAxisRenderer paramXAxisRenderer)
  {
    this.mXAxisRenderer = paramXAxisRenderer;
  }
  
  public void zoom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mViewPortHandler.zoom(paramFloat1, paramFloat2, paramFloat3, -paramFloat4, this.mZoomMatrixBuffer);
    this.mViewPortHandler.refresh(this.mZoomMatrixBuffer, this, false);
    calculateOffsets();
    postInvalidate();
  }
  
  public void zoom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, YAxis.AxisDependency paramAxisDependency)
  {
    addViewportJob(ZoomJob.getInstance(this.mViewPortHandler, paramFloat1, paramFloat2, paramFloat3, paramFloat4, getTransformer(paramAxisDependency), paramAxisDependency, this));
  }
  
  @TargetApi(11)
  public void zoomAndCenterAnimated(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, YAxis.AxisDependency paramAxisDependency, long paramLong)
  {
    MPPointD localMPPointD = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), paramAxisDependency);
    addViewportJob(AnimatedZoomJob.getInstance(this.mViewPortHandler, this, getTransformer(paramAxisDependency), getAxis(paramAxisDependency), this.mXAxis.mAxisRange, paramFloat1, paramFloat2, this.mViewPortHandler.getScaleX(), this.mViewPortHandler.getScaleY(), paramFloat3, paramFloat4, (float)localMPPointD.x, (float)localMPPointD.y, paramLong));
    MPPointD.recycleInstance(localMPPointD);
  }
  
  public void zoomIn()
  {
    MPPointF localMPPointF = this.mViewPortHandler.getContentCenter();
    this.mViewPortHandler.zoomIn(localMPPointF.x, -localMPPointF.y, this.mZoomMatrixBuffer);
    this.mViewPortHandler.refresh(this.mZoomMatrixBuffer, this, false);
    MPPointF.recycleInstance(localMPPointF);
    calculateOffsets();
    postInvalidate();
  }
  
  public void zoomOut()
  {
    MPPointF localMPPointF = this.mViewPortHandler.getContentCenter();
    this.mViewPortHandler.zoomOut(localMPPointF.x, -localMPPointF.y, this.mZoomMatrixBuffer);
    this.mViewPortHandler.refresh(this.mZoomMatrixBuffer, this, false);
    MPPointF.recycleInstance(localMPPointF);
    calculateOffsets();
    postInvalidate();
  }
  
  public void zoomToCenter(float paramFloat1, float paramFloat2)
  {
    MPPointF localMPPointF = getCenterOffsets();
    Matrix localMatrix = this.mZoomMatrixBuffer;
    this.mViewPortHandler.zoom(paramFloat1, paramFloat2, localMPPointF.x, -localMPPointF.y, localMatrix);
    this.mViewPortHandler.refresh(localMatrix, this, false);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\BarLineChartBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */