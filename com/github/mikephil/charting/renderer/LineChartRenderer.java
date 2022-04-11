package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet.Mode;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LineChartRenderer
  extends LineRadarRenderer
{
  protected Path cubicFillPath = new Path();
  protected Path cubicPath = new Path();
  protected Canvas mBitmapCanvas;
  protected Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
  protected LineDataProvider mChart;
  protected Paint mCirclePaintInner;
  private float[] mCirclesBuffer = new float[2];
  protected WeakReference<Bitmap> mDrawBitmap;
  protected Path mGenerateFilledPathBuffer = new Path();
  private HashMap<IDataSet, DataSetImageCache> mImageCaches = new HashMap();
  private float[] mLineBuffer = new float[4];
  
  public LineChartRenderer(LineDataProvider paramLineDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    this.mChart = paramLineDataProvider;
    paramLineDataProvider = new Paint(1);
    this.mCirclePaintInner = paramLineDataProvider;
    paramLineDataProvider.setStyle(Paint.Style.FILL);
    this.mCirclePaintInner.setColor(-1);
  }
  
  private void generateFilledPath(ILineDataSet paramILineDataSet, int paramInt1, int paramInt2, Path paramPath)
  {
    float f1 = paramILineDataSet.getFillFormatter().getFillLinePosition(paramILineDataSet, this.mChart);
    float f2 = this.mAnimator.getPhaseY();
    int i;
    if (paramILineDataSet.getMode() == LineDataSet.Mode.STEPPED) {
      i = 1;
    } else {
      i = 0;
    }
    paramPath.reset();
    Object localObject = paramILineDataSet.getEntryForIndex(paramInt1);
    paramPath.moveTo(((Entry)localObject).getX(), f1);
    paramPath.lineTo(((Entry)localObject).getX(), ((BaseEntry)localObject).getY() * f2);
    Entry localEntry = null;
    paramInt1++;
    while (paramInt1 <= paramInt2)
    {
      localEntry = paramILineDataSet.getEntryForIndex(paramInt1);
      if (i != 0) {
        paramPath.lineTo(localEntry.getX(), ((BaseEntry)localObject).getY() * f2);
      }
      paramPath.lineTo(localEntry.getX(), localEntry.getY() * f2);
      paramInt1++;
      localObject = localEntry;
    }
    if (localEntry != null) {
      paramPath.lineTo(localEntry.getX(), f1);
    }
    paramPath.close();
  }
  
  protected void drawCircles(Canvas paramCanvas)
  {
    this.mRenderPaint.setStyle(Paint.Style.FILL);
    float f1 = this.mAnimator.getPhaseY();
    Object localObject1 = this.mCirclesBuffer;
    localObject1[0] = 0.0F;
    localObject1[1] = 0.0F;
    List localList = this.mChart.getLineData().getDataSets();
    for (int i = 0; i < localList.size(); i++)
    {
      ILineDataSet localILineDataSet = (ILineDataSet)localList.get(i);
      if ((localILineDataSet.isVisible()) && (localILineDataSet.isDrawCirclesEnabled()) && (localILineDataSet.getEntryCount() != 0))
      {
        this.mCirclePaintInner.setColor(localILineDataSet.getCircleHoleColor());
        Transformer localTransformer = this.mChart.getTransformer(localILineDataSet.getAxisDependency());
        this.mXBounds.set(this.mChart, localILineDataSet);
        float f2 = localILineDataSet.getCircleRadius();
        float f3 = localILineDataSet.getCircleHoleRadius();
        boolean bool1;
        if ((localILineDataSet.isDrawCircleHoleEnabled()) && (f3 < f2) && (f3 > 0.0F)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2;
        if ((bool1) && (localILineDataSet.getCircleHoleColor() == 1122867)) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (this.mImageCaches.containsKey(localILineDataSet))
        {
          localObject1 = (DataSetImageCache)this.mImageCaches.get(localILineDataSet);
        }
        else
        {
          localObject1 = new DataSetImageCache(null);
          this.mImageCaches.put(localILineDataSet, localObject1);
        }
        if (((DataSetImageCache)localObject1).init(localILineDataSet)) {
          ((DataSetImageCache)localObject1).fill(localILineDataSet, bool1, bool2);
        }
        Object localObject2 = this.mXBounds;
        int j = ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).range;
        int k = ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).min;
        for (int m = k; m <= j + k; m++)
        {
          localObject2 = localILineDataSet.getEntryForIndex(m);
          if (localObject2 == null) {
            break;
          }
          this.mCirclesBuffer[0] = ((Entry)localObject2).getX();
          this.mCirclesBuffer[1] = (((BaseEntry)localObject2).getY() * f1);
          localTransformer.pointValuesToPixel(this.mCirclesBuffer);
          if (!this.mViewPortHandler.isInBoundsRight(this.mCirclesBuffer[0])) {
            break;
          }
          if ((this.mViewPortHandler.isInBoundsLeft(this.mCirclesBuffer[0])) && (this.mViewPortHandler.isInBoundsY(this.mCirclesBuffer[1])))
          {
            Bitmap localBitmap = ((DataSetImageCache)localObject1).getBitmap(m);
            if (localBitmap != null)
            {
              localObject2 = this.mCirclesBuffer;
              paramCanvas.drawBitmap(localBitmap, localObject2[0] - f2, localObject2[1] - f2, null);
            }
          }
        }
      }
    }
  }
  
  protected void drawCubicBezier(ILineDataSet paramILineDataSet)
  {
    float f1 = this.mAnimator.getPhaseY();
    Transformer localTransformer = this.mChart.getTransformer(paramILineDataSet.getAxisDependency());
    this.mXBounds.set(this.mChart, paramILineDataSet);
    float f2 = paramILineDataSet.getCubicIntensity();
    this.cubicPath.reset();
    Object localObject1 = this.mXBounds;
    if (((BarLineScatterCandleBubbleRenderer.XBounds)localObject1).range >= 1)
    {
      int i = ((BarLineScatterCandleBubbleRenderer.XBounds)localObject1).min + 1;
      Object localObject2 = paramILineDataSet.getEntryForIndex(Math.max(i - 2, 0));
      Object localObject3 = paramILineDataSet.getEntryForIndex(Math.max(i - 1, 0));
      int j = -1;
      if (localObject3 == null) {
        return;
      }
      this.cubicPath.moveTo(((Entry)localObject3).getX(), ((BaseEntry)localObject3).getY() * f1);
      i = this.mXBounds.min + 1;
      localObject1 = localObject3;
      for (;;)
      {
        Object localObject4 = this.mXBounds;
        if (i > ((BarLineScatterCandleBubbleRenderer.XBounds)localObject4).range + ((BarLineScatterCandleBubbleRenderer.XBounds)localObject4).min) {
          break;
        }
        if (j != i) {
          localObject3 = paramILineDataSet.getEntryForIndex(i);
        }
        int k = i + 1;
        if (k < paramILineDataSet.getEntryCount()) {
          i = k;
        }
        localObject4 = paramILineDataSet.getEntryForIndex(i);
        float f3 = ((Entry)localObject3).getX();
        float f4 = ((Entry)localObject2).getX();
        float f5 = ((BaseEntry)localObject3).getY();
        float f6 = ((BaseEntry)localObject2).getY();
        float f7 = ((Entry)localObject4).getX();
        float f8 = ((Entry)localObject1).getX();
        float f9 = ((BaseEntry)localObject4).getY();
        float f10 = ((BaseEntry)localObject1).getY();
        this.cubicPath.cubicTo(((Entry)localObject1).getX() + (f3 - f4) * f2, (((BaseEntry)localObject1).getY() + (f5 - f6) * f2) * f1, ((Entry)localObject3).getX() - (f7 - f8) * f2, (((BaseEntry)localObject3).getY() - (f9 - f10) * f2) * f1, ((Entry)localObject3).getX(), ((BaseEntry)localObject3).getY() * f1);
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
        j = i;
        i = k;
      }
    }
    if (paramILineDataSet.isDrawFilledEnabled())
    {
      this.cubicFillPath.reset();
      this.cubicFillPath.addPath(this.cubicPath);
      drawCubicFill(this.mBitmapCanvas, paramILineDataSet, this.cubicFillPath, localTransformer, this.mXBounds);
    }
    this.mRenderPaint.setColor(paramILineDataSet.getColor());
    this.mRenderPaint.setStyle(Paint.Style.STROKE);
    localTransformer.pathValueToPixel(this.cubicPath);
    this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
    this.mRenderPaint.setPathEffect(null);
  }
  
  protected void drawCubicFill(Canvas paramCanvas, ILineDataSet paramILineDataSet, Path paramPath, Transformer paramTransformer, BarLineScatterCandleBubbleRenderer.XBounds paramXBounds)
  {
    float f = paramILineDataSet.getFillFormatter().getFillLinePosition(paramILineDataSet, this.mChart);
    paramPath.lineTo(paramILineDataSet.getEntryForIndex(paramXBounds.min + paramXBounds.range).getX(), f);
    paramPath.lineTo(paramILineDataSet.getEntryForIndex(paramXBounds.min).getX(), f);
    paramPath.close();
    paramTransformer.pathValueToPixel(paramPath);
    paramTransformer = paramILineDataSet.getFillDrawable();
    if (paramTransformer != null) {
      drawFilledPath(paramCanvas, paramPath, paramTransformer);
    } else {
      drawFilledPath(paramCanvas, paramPath, paramILineDataSet.getFillColor(), paramILineDataSet.getFillAlpha());
    }
  }
  
  public void drawData(Canvas paramCanvas)
  {
    int i = (int)this.mViewPortHandler.getChartWidth();
    int j = (int)this.mViewPortHandler.getChartHeight();
    Object localObject1 = this.mDrawBitmap;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (Bitmap)((WeakReference)localObject1).get();
    }
    Object localObject2;
    if ((localObject1 != null) && (((Bitmap)localObject1).getWidth() == i))
    {
      localObject2 = localObject1;
      if (((Bitmap)localObject1).getHeight() == j) {}
    }
    else
    {
      if ((i <= 0) || (j <= 0)) {
        return;
      }
      localObject2 = Bitmap.createBitmap(i, j, this.mBitmapConfig);
      this.mDrawBitmap = new WeakReference(localObject2);
      this.mBitmapCanvas = new Canvas((Bitmap)localObject2);
    }
    ((Bitmap)localObject2).eraseColor(0);
    localObject1 = this.mChart.getLineData().getDataSets().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ILineDataSet localILineDataSet = (ILineDataSet)((Iterator)localObject1).next();
      if (localILineDataSet.isVisible()) {
        drawDataSet(paramCanvas, localILineDataSet);
      }
    }
    paramCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, this.mRenderPaint);
  }
  
  protected void drawDataSet(Canvas paramCanvas, ILineDataSet paramILineDataSet)
  {
    if (paramILineDataSet.getEntryCount() < 1) {
      return;
    }
    this.mRenderPaint.setStrokeWidth(paramILineDataSet.getLineWidth());
    this.mRenderPaint.setPathEffect(paramILineDataSet.getDashPathEffect());
    int i = 1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[paramILineDataSet.getMode().ordinal()];
    if (i != 3)
    {
      if (i != 4) {
        drawLinear(paramCanvas, paramILineDataSet);
      } else {
        drawHorizontalBezier(paramILineDataSet);
      }
    }
    else {
      drawCubicBezier(paramILineDataSet);
    }
    this.mRenderPaint.setPathEffect(null);
  }
  
  public void drawExtras(Canvas paramCanvas)
  {
    drawCircles(paramCanvas);
  }
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    LineData localLineData = this.mChart.getLineData();
    int i = paramArrayOfHighlight.length;
    for (int j = 0; j < i; j++)
    {
      Highlight localHighlight = paramArrayOfHighlight[j];
      ILineDataSet localILineDataSet = (ILineDataSet)localLineData.getDataSetByIndex(localHighlight.getDataSetIndex());
      if ((localILineDataSet != null) && (localILineDataSet.isHighlightEnabled()))
      {
        Object localObject = localILineDataSet.getEntryForXValue(localHighlight.getX(), localHighlight.getY());
        if (isInBoundsX((Entry)localObject, localILineDataSet))
        {
          localObject = this.mChart.getTransformer(localILineDataSet.getAxisDependency()).getPixelForValues(((Entry)localObject).getX(), ((BaseEntry)localObject).getY() * this.mAnimator.getPhaseY());
          localHighlight.setDraw((float)((MPPointD)localObject).x, (float)((MPPointD)localObject).y);
          drawHighlightLines(paramCanvas, (float)((MPPointD)localObject).x, (float)((MPPointD)localObject).y, localILineDataSet);
        }
      }
    }
  }
  
  protected void drawHorizontalBezier(ILineDataSet paramILineDataSet)
  {
    float f1 = this.mAnimator.getPhaseY();
    Transformer localTransformer = this.mChart.getTransformer(paramILineDataSet.getAxisDependency());
    this.mXBounds.set(this.mChart, paramILineDataSet);
    this.cubicPath.reset();
    Object localObject1 = this.mXBounds;
    if (((BarLineScatterCandleBubbleRenderer.XBounds)localObject1).range >= 1)
    {
      localObject1 = paramILineDataSet.getEntryForIndex(((BarLineScatterCandleBubbleRenderer.XBounds)localObject1).min);
      this.cubicPath.moveTo(((Entry)localObject1).getX(), ((BaseEntry)localObject1).getY() * f1);
      int i = this.mXBounds.min + 1;
      for (;;)
      {
        Object localObject2 = this.mXBounds;
        if (i > ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).range + ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).min) {
          break;
        }
        localObject2 = paramILineDataSet.getEntryForIndex(i);
        float f2 = ((Entry)localObject1).getX() + (((Entry)localObject2).getX() - ((Entry)localObject1).getX()) / 2.0F;
        this.cubicPath.cubicTo(f2, ((BaseEntry)localObject1).getY() * f1, f2, ((BaseEntry)localObject2).getY() * f1, ((Entry)localObject2).getX(), ((BaseEntry)localObject2).getY() * f1);
        i++;
        localObject1 = localObject2;
      }
    }
    if (paramILineDataSet.isDrawFilledEnabled())
    {
      this.cubicFillPath.reset();
      this.cubicFillPath.addPath(this.cubicPath);
      drawCubicFill(this.mBitmapCanvas, paramILineDataSet, this.cubicFillPath, localTransformer, this.mXBounds);
    }
    this.mRenderPaint.setColor(paramILineDataSet.getColor());
    this.mRenderPaint.setStyle(Paint.Style.STROKE);
    localTransformer.pathValueToPixel(this.cubicPath);
    this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
    this.mRenderPaint.setPathEffect(null);
  }
  
  protected void drawLinear(Canvas paramCanvas, ILineDataSet paramILineDataSet)
  {
    int i = paramILineDataSet.getEntryCount();
    int j;
    if (paramILineDataSet.getMode() == LineDataSet.Mode.STEPPED) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (j != 0) {
      k = 4;
    } else {
      k = 2;
    }
    Transformer localTransformer = this.mChart.getTransformer(paramILineDataSet.getAxisDependency());
    float f = this.mAnimator.getPhaseY();
    this.mRenderPaint.setStyle(Paint.Style.STROKE);
    Canvas localCanvas;
    if (paramILineDataSet.isDashedLineEnabled()) {
      localCanvas = this.mBitmapCanvas;
    } else {
      localCanvas = paramCanvas;
    }
    this.mXBounds.set(this.mChart, paramILineDataSet);
    if ((paramILineDataSet.isDrawFilledEnabled()) && (i > 0)) {
      drawLinearFill(paramCanvas, paramILineDataSet, localTransformer, this.mXBounds);
    }
    Object localObject;
    if (paramILineDataSet.getColors().size() > 1)
    {
      m = this.mLineBuffer.length;
      i = k * 2;
      if (m <= i) {
        this.mLineBuffer = new float[k * 4];
      }
      for (k = this.mXBounds.min;; k++)
      {
        paramCanvas = this.mXBounds;
        if (k > paramCanvas.range + paramCanvas.min) {
          break;
        }
        paramCanvas = paramILineDataSet.getEntryForIndex(k);
        if (paramCanvas != null)
        {
          this.mLineBuffer[0] = paramCanvas.getX();
          this.mLineBuffer[1] = (paramCanvas.getY() * f);
          if (k < this.mXBounds.max)
          {
            localObject = paramILineDataSet.getEntryForIndex(k + 1);
            if (localObject == null) {
              break;
            }
            if (j != 0)
            {
              this.mLineBuffer[2] = ((Entry)localObject).getX();
              paramCanvas = this.mLineBuffer;
              paramCanvas[3] = paramCanvas[1];
              paramCanvas[4] = paramCanvas[2];
              paramCanvas[5] = paramCanvas[3];
              paramCanvas[6] = ((Entry)localObject).getX();
              this.mLineBuffer[7] = (((BaseEntry)localObject).getY() * f);
            }
            else
            {
              this.mLineBuffer[2] = ((Entry)localObject).getX();
              this.mLineBuffer[3] = (((BaseEntry)localObject).getY() * f);
            }
          }
          else
          {
            paramCanvas = this.mLineBuffer;
            paramCanvas[2] = paramCanvas[0];
            paramCanvas[3] = paramCanvas[1];
          }
          localTransformer.pointValuesToPixel(this.mLineBuffer);
          if (!this.mViewPortHandler.isInBoundsRight(this.mLineBuffer[0])) {
            break;
          }
          if ((this.mViewPortHandler.isInBoundsLeft(this.mLineBuffer[2])) && ((this.mViewPortHandler.isInBoundsTop(this.mLineBuffer[1])) || (this.mViewPortHandler.isInBoundsBottom(this.mLineBuffer[3]))))
          {
            this.mRenderPaint.setColor(paramILineDataSet.getColor(k));
            localCanvas.drawLines(this.mLineBuffer, 0, i, this.mRenderPaint);
          }
        }
      }
    }
    int m = this.mLineBuffer.length;
    i *= k;
    if (m < Math.max(i, k) * 2) {
      this.mLineBuffer = new float[Math.max(i, k) * 4];
    }
    if (paramILineDataSet.getEntryForIndex(this.mXBounds.min) != null)
    {
      i = this.mXBounds.min;
      int n;
      for (m = 0;; m = n)
      {
        paramCanvas = this.mXBounds;
        if (i > paramCanvas.range + paramCanvas.min) {
          break;
        }
        if (i == 0) {
          n = 0;
        } else {
          n = i - 1;
        }
        localObject = paramILineDataSet.getEntryForIndex(n);
        paramCanvas = paramILineDataSet.getEntryForIndex(i);
        n = m;
        if (localObject != null) {
          if (paramCanvas == null)
          {
            n = m;
          }
          else
          {
            float[] arrayOfFloat = this.mLineBuffer;
            int i1 = m + 1;
            arrayOfFloat[m] = ((Entry)localObject).getX();
            arrayOfFloat = this.mLineBuffer;
            n = i1 + 1;
            arrayOfFloat[i1] = (((BaseEntry)localObject).getY() * f);
            m = n;
            if (j != 0)
            {
              arrayOfFloat = this.mLineBuffer;
              i1 = n + 1;
              arrayOfFloat[n] = paramCanvas.getX();
              arrayOfFloat = this.mLineBuffer;
              m = i1 + 1;
              arrayOfFloat[i1] = (((BaseEntry)localObject).getY() * f);
              arrayOfFloat = this.mLineBuffer;
              n = m + 1;
              arrayOfFloat[m] = paramCanvas.getX();
              arrayOfFloat = this.mLineBuffer;
              m = n + 1;
              arrayOfFloat[n] = (((BaseEntry)localObject).getY() * f);
            }
            localObject = this.mLineBuffer;
            n = m + 1;
            localObject[m] = paramCanvas.getX();
            this.mLineBuffer[n] = (paramCanvas.getY() * f);
            n++;
          }
        }
        i++;
      }
      if (m > 0)
      {
        localTransformer.pointValuesToPixel(this.mLineBuffer);
        j = Math.max((this.mXBounds.range + 1) * k, k);
        this.mRenderPaint.setColor(paramILineDataSet.getColor());
        localCanvas.drawLines(this.mLineBuffer, 0, j * 2, this.mRenderPaint);
      }
    }
    this.mRenderPaint.setPathEffect(null);
  }
  
  protected void drawLinearFill(Canvas paramCanvas, ILineDataSet paramILineDataSet, Transformer paramTransformer, BarLineScatterCandleBubbleRenderer.XBounds paramXBounds)
  {
    Path localPath = this.mGenerateFilledPathBuffer;
    int i = paramXBounds.min;
    int j = paramXBounds.range + i;
    int k = 0;
    int m;
    int i1;
    do
    {
      m = k * 128 + i;
      int n = m + 128;
      i1 = n;
      if (n > j) {
        i1 = j;
      }
      if (m <= i1)
      {
        generateFilledPath(paramILineDataSet, m, i1, localPath);
        paramTransformer.pathValueToPixel(localPath);
        paramXBounds = paramILineDataSet.getFillDrawable();
        if (paramXBounds != null) {
          drawFilledPath(paramCanvas, localPath, paramXBounds);
        } else {
          drawFilledPath(paramCanvas, localPath, paramILineDataSet.getFillColor(), paramILineDataSet.getFillAlpha());
        }
      }
      k++;
    } while (m <= i1);
  }
  
  public void drawValue(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.mValuePaint.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mValuePaint);
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    if (isDrawingValuesAllowed(this.mChart))
    {
      List localList = this.mChart.getLineData().getDataSets();
      for (int i = 0; i < localList.size(); i++)
      {
        ILineDataSet localILineDataSet = (ILineDataSet)localList.get(i);
        if ((shouldDrawValues(localILineDataSet)) && (localILineDataSet.getEntryCount() >= 1))
        {
          applyValueTextStyle(localILineDataSet);
          Object localObject1 = this.mChart.getTransformer(localILineDataSet.getAxisDependency());
          int j = (int)(localILineDataSet.getCircleRadius() * 1.75F);
          int k = j;
          if (!localILineDataSet.isDrawCirclesEnabled()) {
            k = j / 2;
          }
          j = k;
          this.mXBounds.set(this.mChart, localILineDataSet);
          float f1 = this.mAnimator.getPhaseX();
          float f2 = this.mAnimator.getPhaseY();
          Object localObject2 = this.mXBounds;
          float[] arrayOfFloat = ((Transformer)localObject1).generateTransformedValuesLine(localILineDataSet, f1, f2, ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).min, ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).max);
          localObject1 = localILineDataSet.getValueFormatter();
          MPPointF localMPPointF = MPPointF.getInstance(localILineDataSet.getIconsOffset());
          localMPPointF.x = Utils.convertDpToPixel(localMPPointF.x);
          localMPPointF.y = Utils.convertDpToPixel(localMPPointF.y);
          for (k = 0; k < arrayOfFloat.length; k += 2)
          {
            f2 = arrayOfFloat[k];
            f1 = arrayOfFloat[(k + 1)];
            if (!this.mViewPortHandler.isInBoundsRight(f2)) {
              break;
            }
            if ((this.mViewPortHandler.isInBoundsLeft(f2)) && (this.mViewPortHandler.isInBoundsY(f1)))
            {
              int m = k / 2;
              localObject2 = localILineDataSet.getEntryForIndex(this.mXBounds.min + m);
              if (localILineDataSet.isDrawValuesEnabled()) {
                drawValue(paramCanvas, ((ValueFormatter)localObject1).getPointLabel((Entry)localObject2), f2, f1 - j, localILineDataSet.getValueTextColor(m));
              }
              if ((((BaseEntry)localObject2).getIcon() != null) && (localILineDataSet.isDrawIconsEnabled()))
              {
                localObject2 = ((BaseEntry)localObject2).getIcon();
                Utils.drawImage(paramCanvas, (Drawable)localObject2, (int)(f2 + localMPPointF.x), (int)(f1 + localMPPointF.y), ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
              }
            }
          }
          MPPointF.recycleInstance(localMPPointF);
        }
      }
    }
  }
  
  public Bitmap.Config getBitmapConfig()
  {
    return this.mBitmapConfig;
  }
  
  public void initBuffers() {}
  
  public void releaseBitmap()
  {
    Object localObject = this.mBitmapCanvas;
    if (localObject != null)
    {
      ((Canvas)localObject).setBitmap(null);
      this.mBitmapCanvas = null;
    }
    localObject = this.mDrawBitmap;
    if (localObject != null)
    {
      localObject = (Bitmap)((WeakReference)localObject).get();
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      this.mDrawBitmap.clear();
      this.mDrawBitmap = null;
    }
  }
  
  public void setBitmapConfig(Bitmap.Config paramConfig)
  {
    this.mBitmapConfig = paramConfig;
    releaseBitmap();
  }
  
  private class DataSetImageCache
  {
    private Bitmap[] circleBitmaps;
    private Path mCirclePathBuffer = new Path();
    
    private DataSetImageCache() {}
    
    protected void fill(ILineDataSet paramILineDataSet, boolean paramBoolean1, boolean paramBoolean2)
    {
      int i = paramILineDataSet.getCircleColorCount();
      float f1 = paramILineDataSet.getCircleRadius();
      float f2 = paramILineDataSet.getCircleHoleRadius();
      for (int j = 0; j < i; j++)
      {
        Object localObject = Bitmap.Config.ARGB_4444;
        int k = (int)(f1 * 2.1D);
        Bitmap localBitmap = Bitmap.createBitmap(k, k, (Bitmap.Config)localObject);
        localObject = new Canvas(localBitmap);
        this.circleBitmaps[j] = localBitmap;
        LineChartRenderer.this.mRenderPaint.setColor(paramILineDataSet.getCircleColor(j));
        if (paramBoolean2)
        {
          this.mCirclePathBuffer.reset();
          this.mCirclePathBuffer.addCircle(f1, f1, f1, Path.Direction.CW);
          this.mCirclePathBuffer.addCircle(f1, f1, f2, Path.Direction.CCW);
          ((Canvas)localObject).drawPath(this.mCirclePathBuffer, LineChartRenderer.this.mRenderPaint);
        }
        else
        {
          ((Canvas)localObject).drawCircle(f1, f1, f1, LineChartRenderer.this.mRenderPaint);
          if (paramBoolean1) {
            ((Canvas)localObject).drawCircle(f1, f1, f2, LineChartRenderer.this.mCirclePaintInner);
          }
        }
      }
    }
    
    protected Bitmap getBitmap(int paramInt)
    {
      Bitmap[] arrayOfBitmap = this.circleBitmaps;
      return arrayOfBitmap[(paramInt % arrayOfBitmap.length)];
    }
    
    protected boolean init(ILineDataSet paramILineDataSet)
    {
      int i = paramILineDataSet.getCircleColorCount();
      paramILineDataSet = this.circleBitmaps;
      boolean bool = true;
      if (paramILineDataSet == null) {
        this.circleBitmaps = new Bitmap[i];
      } else if (paramILineDataSet.length != i) {
        this.circleBitmaps = new Bitmap[i];
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\LineChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */