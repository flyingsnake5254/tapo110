package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet.ValuePosition;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class PieChartRenderer
  extends DataRenderer
{
  protected Canvas mBitmapCanvas;
  private RectF mCenterTextLastBounds = new RectF();
  private CharSequence mCenterTextLastValue;
  private StaticLayout mCenterTextLayout;
  private TextPaint mCenterTextPaint;
  protected PieChart mChart;
  protected WeakReference<Bitmap> mDrawBitmap;
  protected Path mDrawCenterTextPathBuffer = new Path();
  protected RectF mDrawHighlightedRectF = new RectF();
  private Paint mEntryLabelsPaint;
  private Path mHoleCirclePath = new Path();
  protected Paint mHolePaint;
  private RectF mInnerRectBuffer = new RectF();
  private Path mPathBuffer = new Path();
  private RectF[] mRectBuffer = { new RectF(), new RectF(), new RectF() };
  protected Paint mTransparentCirclePaint;
  protected Paint mValueLinePaint;
  
  public PieChartRenderer(PieChart paramPieChart, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    this.mChart = paramPieChart;
    paramPieChart = new Paint(1);
    this.mHolePaint = paramPieChart;
    paramPieChart.setColor(-1);
    this.mHolePaint.setStyle(Paint.Style.FILL);
    paramPieChart = new Paint(1);
    this.mTransparentCirclePaint = paramPieChart;
    paramPieChart.setColor(-1);
    this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
    this.mTransparentCirclePaint.setAlpha(105);
    paramPieChart = new TextPaint(1);
    this.mCenterTextPaint = paramPieChart;
    paramPieChart.setColor(-16777216);
    this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0F));
    this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0F));
    this.mValuePaint.setColor(-1);
    this.mValuePaint.setTextAlign(Paint.Align.CENTER);
    paramPieChart = new Paint(1);
    this.mEntryLabelsPaint = paramPieChart;
    paramPieChart.setColor(-1);
    this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
    this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0F));
    paramPieChart = new Paint(1);
    this.mValueLinePaint = paramPieChart;
    paramPieChart.setStyle(Paint.Style.STROKE);
  }
  
  protected float calculateMinimumRadiusForSpacedSlice(MPPointF paramMPPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f1 = paramFloat6 / 2.0F;
    float f2 = paramMPPointF.x;
    double d = (paramFloat5 + paramFloat6) * 0.017453292F;
    f2 += (float)Math.cos(d) * paramFloat1;
    float f3 = paramMPPointF.y + (float)Math.sin(d) * paramFloat1;
    paramFloat6 = paramMPPointF.x;
    d = (paramFloat5 + f1) * 0.017453292F;
    paramFloat5 = (float)Math.cos(d);
    float f4 = paramMPPointF.y;
    f1 = (float)Math.sin(d);
    return (float)(paramFloat1 - (float)(Math.sqrt(Math.pow(f2 - paramFloat3, 2.0D) + Math.pow(f3 - paramFloat4, 2.0D)) / 2.0D * Math.tan((180.0D - paramFloat2) / 2.0D * 0.017453292519943295D)) - Math.sqrt(Math.pow(paramFloat6 + paramFloat5 * paramFloat1 - (f2 + paramFloat3) / 2.0F, 2.0D) + Math.pow(f4 + f1 * paramFloat1 - (f3 + paramFloat4) / 2.0F, 2.0D)));
  }
  
  protected void drawCenterText(Canvas paramCanvas)
  {
    Object localObject1 = this.mChart.getCenterText();
    if ((this.mChart.isDrawCenterTextEnabled()) && (localObject1 != null))
    {
      MPPointF localMPPointF1 = this.mChart.getCenterCircleBox();
      MPPointF localMPPointF2 = this.mChart.getCenterTextOffset();
      float f1 = localMPPointF1.x + localMPPointF2.x;
      float f2 = localMPPointF1.y + localMPPointF2.y;
      if ((this.mChart.isDrawHoleEnabled()) && (!this.mChart.isDrawSlicesUnderHoleEnabled())) {
        f3 = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0F);
      } else {
        f3 = this.mChart.getRadius();
      }
      Object localObject2 = this.mRectBuffer;
      RectF localRectF = localObject2[0];
      localRectF.left = (f1 - f3);
      localRectF.top = (f2 - f3);
      localRectF.right = (f1 + f3);
      localRectF.bottom = (f2 + f3);
      localObject2 = localObject2[1];
      ((RectF)localObject2).set(localRectF);
      float f3 = this.mChart.getCenterTextRadiusPercent() / 100.0F;
      if (f3 > 0.0D) {
        ((RectF)localObject2).inset((((RectF)localObject2).width() - ((RectF)localObject2).width() * f3) / 2.0F, (((RectF)localObject2).height() - ((RectF)localObject2).height() * f3) / 2.0F);
      }
      if ((localObject1.equals(this.mCenterTextLastValue)) && (((RectF)localObject2).equals(this.mCenterTextLastBounds))) {
        break label329;
      }
      this.mCenterTextLastBounds.set((RectF)localObject2);
      this.mCenterTextLastValue = ((CharSequence)localObject1);
      f3 = this.mCenterTextLastBounds.width();
      this.mCenterTextLayout = new StaticLayout((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), this.mCenterTextPaint, (int)Math.max(Math.ceil(f3), 1.0D), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      label329:
      f3 = this.mCenterTextLayout.getHeight();
      paramCanvas.save();
      if (Build.VERSION.SDK_INT >= 18)
      {
        localObject1 = this.mDrawCenterTextPathBuffer;
        ((Path)localObject1).reset();
        ((Path)localObject1).addOval(localRectF, Path.Direction.CW);
        paramCanvas.clipPath((Path)localObject1);
      }
      paramCanvas.translate(((RectF)localObject2).left, ((RectF)localObject2).top + (((RectF)localObject2).height() - f3) / 2.0F);
      this.mCenterTextLayout.draw(paramCanvas);
      paramCanvas.restore();
      MPPointF.recycleInstance(localMPPointF1);
      MPPointF.recycleInstance(localMPPointF2);
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
      localObject2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      this.mDrawBitmap = new WeakReference(localObject2);
      this.mBitmapCanvas = new Canvas((Bitmap)localObject2);
    }
    ((Bitmap)localObject2).eraseColor(0);
    localObject1 = ((PieData)this.mChart.getData()).getDataSets().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IPieDataSet)((Iterator)localObject1).next();
      if ((((IDataSet)localObject2).isVisible()) && (((IDataSet)localObject2).getEntryCount() > 0)) {
        drawDataSet(paramCanvas, (IPieDataSet)localObject2);
      }
    }
  }
  
  protected void drawDataSet(Canvas paramCanvas, IPieDataSet paramIPieDataSet)
  {
    Object localObject1 = this;
    Object localObject2 = paramIPieDataSet;
    float f1 = ((PieChartRenderer)localObject1).mChart.getRotationAngle();
    float f2 = ((DataRenderer)localObject1).mAnimator.getPhaseX();
    float f3 = ((DataRenderer)localObject1).mAnimator.getPhaseY();
    RectF localRectF = ((PieChartRenderer)localObject1).mChart.getCircleBox();
    int i = paramIPieDataSet.getEntryCount();
    float[] arrayOfFloat = ((PieChartRenderer)localObject1).mChart.getDrawAngles();
    paramCanvas = ((PieChartRenderer)localObject1).mChart.getCenterCircleBox();
    float f4 = ((PieChartRenderer)localObject1).mChart.getRadius();
    int j;
    if ((((PieChartRenderer)localObject1).mChart.isDrawHoleEnabled()) && (!((PieChartRenderer)localObject1).mChart.isDrawSlicesUnderHoleEnabled())) {
      j = 1;
    } else {
      j = 0;
    }
    float f5;
    if (j != 0) {
      f5 = ((PieChartRenderer)localObject1).mChart.getHoleRadius() / 100.0F * f4;
    } else {
      f5 = 0.0F;
    }
    float f6 = (f4 - ((PieChartRenderer)localObject1).mChart.getHoleRadius() * f4 / 100.0F) / 2.0F;
    Object localObject3 = new RectF();
    int k;
    if ((j != 0) && (((PieChartRenderer)localObject1).mChart.isDrawRoundedSlicesEnabled())) {
      k = 1;
    } else {
      k = 0;
    }
    int m = 0;
    for (int n = 0; m < i; n = i1)
    {
      i1 = n;
      if (Math.abs(((PieEntry)((IDataSet)localObject2).getEntryForIndex(m)).getY()) > Utils.FLOAT_EPSILON) {
        i1 = n + 1;
      }
      m++;
    }
    float f7;
    if (n <= 1) {
      f7 = 0.0F;
    } else {
      f7 = ((PieChartRenderer)localObject1).getSliceSpace((IPieDataSet)localObject2);
    }
    int i1 = 0;
    float f8 = 0.0F;
    m = i;
    for (;;)
    {
      localObject2 = paramIPieDataSet;
      if (i1 >= m) {
        break;
      }
      float f9 = arrayOfFloat[i1];
      float f10 = Math.abs(((IDataSet)localObject2).getEntryForIndex(i1).getY());
      float f11 = Utils.FLOAT_EPSILON;
      if (f10 <= f11) {}
      while ((((PieChartRenderer)localObject1).mChart.needsHighlight(i1)) && (k == 0))
      {
        f10 = f8 + f9 * f2;
        localObject2 = paramCanvas;
        paramCanvas = (Canvas)localObject3;
        localObject3 = localObject2;
        break;
      }
      if ((f7 > 0.0F) && (f9 <= 180.0F)) {
        i = 1;
      } else {
        i = 0;
      }
      ((DataRenderer)localObject1).mRenderPaint.setColor(((IDataSet)localObject2).getColor(i1));
      if (n == 1) {
        f10 = 0.0F;
      } else {
        f10 = f7 / (f4 * 0.017453292F);
      }
      float f12 = f1 + (f8 + f10 / 2.0F) * f3;
      float f13 = (f9 - f10) * f3;
      f10 = f13;
      if (f13 < 0.0F) {
        f10 = 0.0F;
      }
      ((PieChartRenderer)localObject1).mPathBuffer.reset();
      if (k != 0)
      {
        f14 = paramCanvas.x;
        f13 = f4 - f6;
        d = f12 * 0.017453292F;
        f14 += (float)Math.cos(d) * f13;
        f13 = paramCanvas.y + f13 * (float)Math.sin(d);
        ((RectF)localObject3).set(f14 - f6, f13 - f6, f14 + f6, f13 + f6);
      }
      f13 = paramCanvas.x;
      double d = f12 * 0.017453292F;
      float f14 = f13 + (float)Math.cos(d) * f4;
      f13 = paramCanvas.y + (float)Math.sin(d) * f4;
      boolean bool = f10 < 360.0F;
      if ((!bool) && (f10 % 360.0F <= f11))
      {
        ((PieChartRenderer)localObject1).mPathBuffer.addCircle(paramCanvas.x, paramCanvas.y, f4, Path.Direction.CW);
      }
      else
      {
        if (k != 0) {
          ((PieChartRenderer)localObject1).mPathBuffer.arcTo((RectF)localObject3, f12 + 180.0F, -180.0F);
        }
        ((PieChartRenderer)localObject1).mPathBuffer.arcTo(localRectF, f12, f10);
      }
      localObject2 = ((PieChartRenderer)localObject1).mInnerRectBuffer;
      float f15 = paramCanvas.x;
      float f16 = paramCanvas.y;
      ((RectF)localObject2).set(f15 - f5, f16 - f5, f15 + f5, f16 + f5);
      if (j != 0)
      {
        if ((f5 <= 0.0F) && (i == 0)) {
          break label1115;
        }
        if (i != 0)
        {
          f12 = calculateMinimumRadiusForSpacedSlice(paramCanvas, f4, f9 * f3, f14, f13, f12, f10);
          f13 = f12;
          if (f12 < 0.0F) {
            f13 = -f12;
          }
          f13 = Math.max(f5, f13);
        }
        else
        {
          f13 = f5;
        }
        f12 = f13;
        if ((n != 1) && (f12 != 0.0F)) {
          f13 = f7 / (f12 * 0.017453292F);
        } else {
          f13 = 0.0F;
        }
        f15 = f13 / 2.0F;
        f14 = (f9 - f13) * f3;
        f13 = f14;
        if (f14 < 0.0F) {
          f13 = 0.0F;
        }
        f14 = f1 + (f8 + f15) * f3 + f13;
        if ((!bool) && (f10 % 360.0F <= f11))
        {
          this.mPathBuffer.addCircle(paramCanvas.x, paramCanvas.y, f12, Path.Direction.CCW);
        }
        else
        {
          localObject1 = this;
          if (k != 0)
          {
            f10 = paramCanvas.x;
            f12 = f4 - f6;
            d = f14 * 0.017453292F;
            f10 += (float)Math.cos(d) * f12;
            f12 = paramCanvas.y + f12 * (float)Math.sin(d);
            localObject2 = localObject3;
            ((RectF)localObject2).set(f10 - f6, f12 - f6, f10 + f6, f12 + f6);
            ((PieChartRenderer)localObject1).mPathBuffer.arcTo((RectF)localObject2, f14, 180.0F);
          }
          else
          {
            localObject2 = ((PieChartRenderer)localObject1).mPathBuffer;
            f10 = paramCanvas.x;
            d = f14 * 0.017453292F;
            ((Path)localObject2).lineTo(f10 + (float)Math.cos(d) * f12, paramCanvas.y + f12 * (float)Math.sin(d));
          }
          ((PieChartRenderer)localObject1).mPathBuffer.arcTo(((PieChartRenderer)localObject1).mInnerRectBuffer, f14, -f13);
        }
        localObject4 = this;
        localObject5 = paramCanvas;
        paramCanvas = (Canvas)localObject3;
        break label1275;
      }
      label1115:
      localObject2 = paramCanvas;
      paramCanvas = (Canvas)localObject3;
      Object localObject4 = localObject1;
      Object localObject5 = localObject2;
      if (f10 % 360.0F > f11)
      {
        if (i != 0)
        {
          f11 = f10 / 2.0F;
          paramCanvas = (Canvas)localObject3;
          f13 = calculateMinimumRadiusForSpacedSlice((MPPointF)localObject2, f4, f9 * f3, f14, f13, f12, f10);
          f10 = ((MPPointF)localObject2).x;
          d = (f12 + f11) * 0.017453292F;
          f12 = (float)Math.cos(d);
          f14 = ((MPPointF)localObject2).y;
          f11 = (float)Math.sin(d);
          ((PieChartRenderer)localObject1).mPathBuffer.lineTo(f10 + f12 * f13, f14 + f13 * f11);
          localObject3 = localObject2;
        }
        else
        {
          paramCanvas = (Canvas)localObject3;
          ((PieChartRenderer)localObject1).mPathBuffer.lineTo(((MPPointF)localObject2).x, ((MPPointF)localObject2).y);
          localObject3 = localObject2;
        }
      }
      else
      {
        label1275:
        localObject3 = localObject5;
        localObject1 = localObject4;
      }
      ((PieChartRenderer)localObject1).mPathBuffer.close();
      ((PieChartRenderer)localObject1).mBitmapCanvas.drawPath(((PieChartRenderer)localObject1).mPathBuffer, ((DataRenderer)localObject1).mRenderPaint);
      f10 = f8 + f9 * f2;
      i1++;
      localObject2 = paramCanvas;
      paramCanvas = (Canvas)localObject3;
      localObject3 = localObject2;
      f8 = f10;
    }
    MPPointF.recycleInstance(paramCanvas);
  }
  
  protected void drawEntryLabel(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mEntryLabelsPaint);
  }
  
  public void drawExtras(Canvas paramCanvas)
  {
    drawHole(paramCanvas);
    paramCanvas.drawBitmap((Bitmap)this.mDrawBitmap.get(), 0.0F, 0.0F, null);
    drawCenterText(paramCanvas);
  }
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    int i;
    if ((this.mChart.isDrawHoleEnabled()) && (!this.mChart.isDrawSlicesUnderHoleEnabled())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (this.mChart.isDrawRoundedSlicesEnabled())) {
      return;
    }
    float f1 = this.mAnimator.getPhaseX();
    float f2 = this.mAnimator.getPhaseY();
    float f3 = this.mChart.getRotationAngle();
    paramCanvas = this.mChart.getDrawAngles();
    float[] arrayOfFloat = this.mChart.getAbsoluteAngles();
    MPPointF localMPPointF = this.mChart.getCenterCircleBox();
    float f4 = this.mChart.getRadius();
    float f5;
    if (i != 0) {
      f5 = this.mChart.getHoleRadius() / 100.0F * f4;
    } else {
      f5 = 0.0F;
    }
    RectF localRectF = this.mDrawHighlightedRectF;
    localRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
    for (int j = 0;; j++)
    {
      Object localObject1 = paramArrayOfHighlight;
      if (j >= localObject1.length) {
        break;
      }
      int k = (int)localObject1[j].getX();
      if (k < paramCanvas.length)
      {
        localObject1 = ((PieData)this.mChart.getData()).getDataSetByIndex(localObject1[j].getDataSetIndex());
        if ((localObject1 != null) && (((IDataSet)localObject1).isHighlightEnabled()))
        {
          int m = ((IDataSet)localObject1).getEntryCount();
          int n = 0;
          int i2;
          for (int i1 = 0; n < m; i1 = i2)
          {
            i2 = i1;
            if (Math.abs(((PieEntry)((IDataSet)localObject1).getEntryForIndex(n)).getY()) > Utils.FLOAT_EPSILON) {
              i2 = i1 + 1;
            }
            n++;
          }
          float f6;
          if (k == 0) {
            f6 = 0.0F;
          } else {
            f6 = arrayOfFloat[(k - 1)] * f1;
          }
          float f7;
          if (i1 <= 1) {
            f7 = 0.0F;
          } else {
            f7 = ((IPieDataSet)localObject1).getSliceSpace();
          }
          float f8 = paramCanvas[k];
          float f9 = ((IPieDataSet)localObject1).getSelectionShift();
          float f10 = f4 + f9;
          localRectF.set(this.mChart.getCircleBox());
          f9 = -f9;
          localRectF.inset(f9, f9);
          if ((f7 > 0.0F) && (f8 <= 180.0F)) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          this.mRenderPaint.setColor(((IDataSet)localObject1).getColor(k));
          if (i1 == 1) {
            f11 = 0.0F;
          } else {
            f11 = f7 / (f4 * 0.017453292F);
          }
          if (i1 == 1) {
            f9 = 0.0F;
          } else {
            f9 = f7 / (f10 * 0.017453292F);
          }
          float f12 = f3 + (f11 / 2.0F + f6) * f2;
          float f11 = (f8 - f11) * f2;
          if (f11 < 0.0F) {
            f11 = 0.0F;
          }
          float f13 = (f9 / 2.0F + f6) * f2 + f3;
          float f14 = (f8 - f9) * f2;
          f9 = f14;
          if (f14 < 0.0F) {
            f9 = 0.0F;
          }
          this.mPathBuffer.reset();
          boolean bool = f11 < 360.0F;
          double d;
          if ((!bool) && (f11 % 360.0F <= Utils.FLOAT_EPSILON))
          {
            this.mPathBuffer.addCircle(localMPPointF.x, localMPPointF.y, f10, Path.Direction.CW);
          }
          else
          {
            localObject1 = this.mPathBuffer;
            f14 = localMPPointF.x;
            d = f13 * 0.017453292F;
            ((Path)localObject1).moveTo(f14 + (float)Math.cos(d) * f10, localMPPointF.y + f10 * (float)Math.sin(d));
            this.mPathBuffer.arcTo(localRectF, f13, f9);
          }
          if (i2 != 0)
          {
            f9 = localMPPointF.x;
            d = f12 * 0.017453292F;
            f9 = calculateMinimumRadiusForSpacedSlice(localMPPointF, f4, f8 * f2, (float)Math.cos(d) * f4 + f9, localMPPointF.y + (float)Math.sin(d) * f4, f12, f11);
          }
          else
          {
            f9 = 0.0F;
          }
          localObject1 = localMPPointF;
          f14 = f5;
          Object localObject2 = this.mInnerRectBuffer;
          f10 = ((MPPointF)localObject1).x;
          f13 = ((MPPointF)localObject1).y;
          ((RectF)localObject2).set(f10 - f14, f13 - f14, f10 + f14, f13 + f14);
          if ((i != 0) && ((f14 > 0.0F) || (i2 != 0)))
          {
            if (i2 != 0)
            {
              f12 = f9;
              if (f9 < 0.0F) {
                f12 = -f9;
              }
              f9 = Math.max(f14, f12);
            }
            else
            {
              f9 = f14;
            }
            if ((i1 != 1) && (f9 != 0.0F)) {
              f7 /= f9 * 0.017453292F;
            } else {
              f7 = 0.0F;
            }
            f12 = f7 / 2.0F;
            f14 = (f8 - f7) * f2;
            f7 = f14;
            if (f14 < 0.0F) {
              f7 = 0.0F;
            }
            f6 = (f6 + f12) * f2 + f3 + f7;
            if ((!bool) && (f11 % 360.0F <= Utils.FLOAT_EPSILON))
            {
              this.mPathBuffer.addCircle(((MPPointF)localObject1).x, ((MPPointF)localObject1).y, f9, Path.Direction.CCW);
            }
            else
            {
              localObject2 = this.mPathBuffer;
              f11 = ((MPPointF)localObject1).x;
              d = f6 * 0.017453292F;
              ((Path)localObject2).lineTo(f11 + (float)Math.cos(d) * f9, ((MPPointF)localObject1).y + f9 * (float)Math.sin(d));
              this.mPathBuffer.arcTo(this.mInnerRectBuffer, f6, -f7);
            }
          }
          else if (f11 % 360.0F > Utils.FLOAT_EPSILON)
          {
            if (i2 != 0)
            {
              f7 = f11 / 2.0F;
              f6 = ((MPPointF)localObject1).x;
              d = (f12 + f7) * 0.017453292F;
              f14 = (float)Math.cos(d);
              f7 = ((MPPointF)localObject1).y;
              f11 = (float)Math.sin(d);
              this.mPathBuffer.lineTo(f6 + f14 * f9, f7 + f9 * f11);
            }
            else
            {
              this.mPathBuffer.lineTo(((MPPointF)localObject1).x, ((MPPointF)localObject1).y);
            }
          }
          this.mPathBuffer.close();
          this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
        }
      }
    }
    MPPointF.recycleInstance(localMPPointF);
  }
  
  protected void drawHole(Canvas paramCanvas)
  {
    if ((this.mChart.isDrawHoleEnabled()) && (this.mBitmapCanvas != null))
    {
      float f1 = this.mChart.getRadius();
      float f2 = this.mChart.getHoleRadius() / 100.0F * f1;
      paramCanvas = this.mChart.getCenterCircleBox();
      if (Color.alpha(this.mHolePaint.getColor()) > 0) {
        this.mBitmapCanvas.drawCircle(paramCanvas.x, paramCanvas.y, f2, this.mHolePaint);
      }
      if ((Color.alpha(this.mTransparentCirclePaint.getColor()) > 0) && (this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()))
      {
        int i = this.mTransparentCirclePaint.getAlpha();
        float f3 = this.mChart.getTransparentCircleRadius() / 100.0F;
        this.mTransparentCirclePaint.setAlpha((int)(i * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
        this.mHoleCirclePath.reset();
        this.mHoleCirclePath.addCircle(paramCanvas.x, paramCanvas.y, f1 * f3, Path.Direction.CW);
        this.mHoleCirclePath.addCircle(paramCanvas.x, paramCanvas.y, f2, Path.Direction.CCW);
        this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
        this.mTransparentCirclePaint.setAlpha(i);
      }
      MPPointF.recycleInstance(paramCanvas);
    }
  }
  
  protected void drawRoundedSlices(Canvas paramCanvas)
  {
    if (!this.mChart.isDrawRoundedSlicesEnabled()) {
      return;
    }
    IPieDataSet localIPieDataSet = ((PieData)this.mChart.getData()).getDataSet();
    if (!localIPieDataSet.isVisible()) {
      return;
    }
    float f1 = this.mAnimator.getPhaseX();
    float f2 = this.mAnimator.getPhaseY();
    MPPointF localMPPointF = this.mChart.getCenterCircleBox();
    float f3 = this.mChart.getRadius();
    float f4 = (f3 - this.mChart.getHoleRadius() * f3 / 100.0F) / 2.0F;
    paramCanvas = this.mChart.getDrawAngles();
    float f5 = this.mChart.getRotationAngle();
    for (int i = 0; i < localIPieDataSet.getEntryCount(); i++)
    {
      float f6 = paramCanvas[i];
      if (Math.abs(localIPieDataSet.getEntryForIndex(i).getY()) > Utils.FLOAT_EPSILON)
      {
        double d1 = f3 - f4;
        double d2 = (f5 + f6) * f2;
        double d3 = Math.cos(Math.toRadians(d2));
        float f7 = (float)(localMPPointF.x + d3 * d1);
        float f8 = (float)(d1 * Math.sin(Math.toRadians(d2)) + localMPPointF.y);
        this.mRenderPaint.setColor(localIPieDataSet.getColor(i));
        this.mBitmapCanvas.drawCircle(f7, f8, f4, this.mRenderPaint);
      }
      f5 += f6 * f1;
    }
    MPPointF.recycleInstance(localMPPointF);
  }
  
  public void drawValue(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.mValuePaint.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mValuePaint);
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    Object localObject1 = paramCanvas;
    Object localObject2 = this.mChart.getCenterCircleBox();
    float f1 = this.mChart.getRadius();
    float f2 = this.mChart.getRotationAngle();
    Object localObject3 = this.mChart.getDrawAngles();
    Object localObject4 = this.mChart.getAbsoluteAngles();
    float f3 = this.mAnimator.getPhaseX();
    float f4 = this.mAnimator.getPhaseY();
    float f5 = (f1 - this.mChart.getHoleRadius() * f1 / 100.0F) / 2.0F;
    float f6 = this.mChart.getHoleRadius() / 100.0F;
    float f7 = f1 / 10.0F * 3.6F;
    float f8 = f2;
    float f9;
    if (this.mChart.isDrawHoleEnabled())
    {
      f9 = (f1 - f1 * f6) / 2.0F;
      f8 = f2;
      f7 = f9;
      if (!this.mChart.isDrawSlicesUnderHoleEnabled())
      {
        f8 = f2;
        f7 = f9;
        if (this.mChart.isDrawRoundedSlicesEnabled())
        {
          f8 = (float)(f2 + f5 * 360.0F / (f1 * 6.283185307179586D));
          f7 = f9;
        }
      }
    }
    float f10 = f1 - f7;
    PieData localPieData = (PieData)this.mChart.getData();
    Object localObject5 = localPieData.getDataSets();
    float f11 = localPieData.getYValueSum();
    boolean bool1 = this.mChart.isDrawEntryLabelsEnabled();
    paramCanvas.save();
    float f12 = Utils.convertDpToPixel(5.0F);
    int i = 0;
    int j = 0;
    f2 = f8;
    f7 = f4;
    f8 = f1;
    while (j < ((List)localObject5).size())
    {
      Object localObject6 = (IPieDataSet)((List)localObject5).get(j);
      boolean bool2 = ((IDataSet)localObject6).isDrawValuesEnabled();
      Object localObject7;
      Object localObject9;
      if ((!bool2) && (!bool1))
      {
        localObject7 = localObject5;
        f4 = f8;
        localObject8 = localObject3;
        localObject9 = localObject4;
        f1 = f3;
        f8 = f2;
        localObject5 = localObject2;
        f3 = f4;
        localObject3 = localObject7;
        localObject4 = localObject8;
        localObject2 = localObject9;
        f2 = f1;
      }
      else
      {
        PieDataSet.ValuePosition localValuePosition1 = ((IPieDataSet)localObject6).getXValuePosition();
        PieDataSet.ValuePosition localValuePosition2 = ((IPieDataSet)localObject6).getYValuePosition();
        applyValueTextStyle((IDataSet)localObject6);
        float f13 = Utils.calcTextHeight(this.mValuePaint, "Q") + Utils.convertDpToPixel(4.0F);
        ValueFormatter localValueFormatter = ((IDataSet)localObject6).getValueFormatter();
        int k = ((IDataSet)localObject6).getEntryCount();
        this.mValueLinePaint.setColor(((IPieDataSet)localObject6).getValueLineColor());
        this.mValueLinePaint.setStrokeWidth(Utils.convertDpToPixel(((IPieDataSet)localObject6).getValueLineWidth()));
        f4 = getSliceSpace((IPieDataSet)localObject6);
        localObject9 = MPPointF.getInstance(((IDataSet)localObject6).getIconsOffset());
        ((MPPointF)localObject9).x = Utils.convertDpToPixel(((MPPointF)localObject9).x);
        ((MPPointF)localObject9).y = Utils.convertDpToPixel(((MPPointF)localObject9).y);
        int m = 0;
        localObject8 = localObject5;
        localObject1 = localObject4;
        localObject7 = localObject3;
        localObject4 = localObject6;
        while (m < k)
        {
          PieEntry localPieEntry = (PieEntry)((IDataSet)localObject4).getEntryForIndex(m);
          if (i == 0) {
            f1 = 0.0F;
          } else {
            f1 = localObject1[(i - 1)] * f3;
          }
          f5 = f2 + (f1 + (localObject7[i] - f4 / (f10 * 0.017453292F) / 2.0F) / 2.0F) * f7;
          if (this.mChart.isUsePercentValuesEnabled()) {
            f1 = localPieEntry.getY() / f11 * 100.0F;
          } else {
            f1 = localPieEntry.getY();
          }
          String str = localValueFormatter.getPieLabel(f1, localPieEntry);
          localObject3 = localPieEntry.getLabel();
          double d = f5 * 0.017453292F;
          float f14 = (float)Math.cos(d);
          float f15 = (float)Math.sin(d);
          int n;
          if ((bool1) && (localValuePosition1 == PieDataSet.ValuePosition.OUTSIDE_SLICE)) {
            n = 1;
          } else {
            n = 0;
          }
          int i1;
          if ((bool2) && (localValuePosition2 == PieDataSet.ValuePosition.OUTSIDE_SLICE)) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          int i2;
          if ((bool1) && (localValuePosition1 == PieDataSet.ValuePosition.INSIDE_SLICE)) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          int i3;
          if ((bool2) && (localValuePosition2 == PieDataSet.ValuePosition.INSIDE_SLICE)) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          float f16;
          if ((n == 0) && (i1 == 0))
          {
            localObject5 = localObject3;
            localObject3 = paramCanvas;
          }
          else
          {
            f16 = ((IPieDataSet)localObject4).getValueLinePart1Length();
            f1 = ((IPieDataSet)localObject4).getValueLinePart2Length();
            float f17 = ((IPieDataSet)localObject4).getValueLinePart1OffsetPercentage() / 100.0F;
            if (this.mChart.isDrawHoleEnabled())
            {
              f9 = f8 * f6;
              f9 = (f8 - f9) * f17 + f9;
            }
            else
            {
              f9 = f8 * f17;
            }
            if (((IPieDataSet)localObject4).isValueLineVariableLength()) {
              f1 = f1 * f10 * (float)Math.abs(Math.sin(d));
            } else {
              f1 *= f10;
            }
            f17 = ((MPPointF)localObject2).x;
            float f18 = ((MPPointF)localObject2).y;
            f16 = (f16 + 1.0F) * f10;
            float f19 = f16 * f14 + f17;
            f16 = f18 + f16 * f15;
            d = f5 % 360.0D;
            if ((d >= 90.0D) && (d <= 270.0D))
            {
              f1 = f19 - f1;
              this.mValuePaint.setTextAlign(Paint.Align.RIGHT);
              if (n != 0) {
                this.mEntryLabelsPaint.setTextAlign(Paint.Align.RIGHT);
              }
              f5 = f1;
              f1 -= f12;
            }
            else
            {
              f5 = f19 + f1;
              this.mValuePaint.setTextAlign(Paint.Align.LEFT);
              if (n != 0) {
                this.mEntryLabelsPaint.setTextAlign(Paint.Align.LEFT);
              }
              f1 = f5 + f12;
            }
            if (((IPieDataSet)localObject4).getValueLineColor() != 1122867)
            {
              if (((IPieDataSet)localObject4).isUsingSliceColorAsValueLineColor()) {
                this.mValueLinePaint.setColor(((IDataSet)localObject4).getColor(m));
              }
              paramCanvas.drawLine(f9 * f14 + f17, f9 * f15 + f18, f19, f16, this.mValueLinePaint);
              paramCanvas.drawLine(f19, f16, f5, f16, this.mValueLinePaint);
            }
            Object localObject10 = localObject4;
            if ((n != 0) && (i1 != 0))
            {
              drawValue(paramCanvas, str, f1, f16, ((IDataSet)localObject10).getValueTextColor(m));
              if ((m < localPieData.getEntryCount()) && (localObject3 != null))
              {
                drawEntryLabel(paramCanvas, (String)localObject3, f1, f16 + f13);
              }
              else
              {
                localObject6 = paramCanvas;
                localObject5 = localObject3;
                localObject3 = localObject6;
                break label1307;
              }
            }
            else
            {
              localObject5 = paramCanvas;
              localObject6 = localObject3;
              if (n != 0)
              {
                if ((m < localPieData.getEntryCount()) && (localObject6 != null)) {
                  drawEntryLabel((Canvas)localObject5, (String)localObject6, f1, f16 + f13 / 2.0F);
                }
              }
              else if (i1 != 0)
              {
                f9 = f13 / 2.0F;
                n = ((IDataSet)localObject10).getValueTextColor(m);
                localObject3 = localObject5;
                drawValue(paramCanvas, str, f1, f16 + f9, n);
                localObject5 = localObject6;
                break label1307;
              }
            }
            localObject5 = localObject3;
            localObject3 = paramCanvas;
          }
          label1307:
          if ((i2 == 0) && (i3 == 0)) {}
          for (;;)
          {
            break;
            localObject6 = localObject2;
            f9 = f10 * f14 + ((MPPointF)localObject6).x;
            f1 = f10 * f15 + ((MPPointF)localObject6).y;
            this.mValuePaint.setTextAlign(Paint.Align.CENTER);
            if ((i2 != 0) && (i3 != 0))
            {
              drawValue(paramCanvas, str, f9, f1, ((IDataSet)localObject4).getValueTextColor(m));
              if ((m < localPieData.getEntryCount()) && (localObject5 != null)) {
                drawEntryLabel((Canvas)localObject3, (String)localObject5, f9, f1 + f13);
              }
            }
            else if (i2 != 0)
            {
              if ((m < localPieData.getEntryCount()) && (localObject5 != null)) {
                drawEntryLabel((Canvas)localObject3, (String)localObject5, f9, f1 + f13 / 2.0F);
              }
            }
            else if (i3 != 0)
            {
              drawValue(paramCanvas, str, f9, f1 + f13 / 2.0F, ((IDataSet)localObject4).getValueTextColor(m));
            }
          }
          if ((localPieEntry.getIcon() != null) && (((IDataSet)localObject4).isDrawIconsEnabled()))
          {
            localObject5 = localPieEntry.getIcon();
            localObject3 = localObject9;
            f5 = ((MPPointF)localObject3).y;
            f9 = ((MPPointF)localObject2).x;
            f16 = ((MPPointF)localObject2).y;
            f1 = ((MPPointF)localObject3).x;
            Utils.drawImage(paramCanvas, (Drawable)localObject5, (int)((f10 + f5) * f14 + f9), (int)((f5 + f10) * f15 + f16 + f1), ((Drawable)localObject5).getIntrinsicWidth(), ((Drawable)localObject5).getIntrinsicHeight());
          }
          i++;
          m++;
        }
        localObject4 = localObject7;
        localObject7 = localObject1;
        localObject3 = localObject8;
        localObject5 = localObject2;
        f1 = f8;
        localObject1 = paramCanvas;
        MPPointF.recycleInstance((MPPointF)localObject9);
        f8 = f2;
        f2 = f3;
        localObject2 = localObject7;
        f3 = f1;
      }
      j++;
      Object localObject8 = localObject5;
      localObject5 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject2;
      f1 = f2;
      f2 = f8;
      localObject2 = localObject8;
      f8 = f3;
      f3 = f1;
    }
    MPPointF.recycleInstance((MPPointF)localObject2);
    paramCanvas.restore();
  }
  
  public TextPaint getPaintCenterText()
  {
    return this.mCenterTextPaint;
  }
  
  public Paint getPaintEntryLabels()
  {
    return this.mEntryLabelsPaint;
  }
  
  public Paint getPaintHole()
  {
    return this.mHolePaint;
  }
  
  public Paint getPaintTransparentCircle()
  {
    return this.mTransparentCirclePaint;
  }
  
  protected float getSliceSpace(IPieDataSet paramIPieDataSet)
  {
    if (!paramIPieDataSet.isAutomaticallyDisableSliceSpacingEnabled()) {
      return paramIPieDataSet.getSliceSpace();
    }
    float f;
    if (paramIPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > paramIPieDataSet.getYMin() / ((PieData)this.mChart.getData()).getYValueSum() * 2.0F) {
      f = 0.0F;
    } else {
      f = paramIPieDataSet.getSliceSpace();
    }
    return f;
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\PieChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */