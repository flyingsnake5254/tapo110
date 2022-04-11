package com.tplink.iot.view.iotplug.energymonitor.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseDataSet;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.LineRadarDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class PowerLineChart
  extends LineChart
{
  public static final a c = new a(null);
  private kotlin.jvm.b.l<? super Float, p> d;
  private final Paint f;
  private final int p0;
  private final float p1;
  private final Paint q;
  private final Paint x;
  private final int y;
  private final float z;
  
  public PowerLineChart(Context paramContext)
  {
    super(paramContext);
    Paint localPaint = new Paint();
    localPaint.setFlags(1);
    localPaint.setColor((int)4281811706L);
    localPaint.setStyle(Paint.Style.FILL);
    paramContext = p.a;
    this.f = localPaint;
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor((int)4279946239L);
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setStrokeWidth(8.0F);
    this.q = paramContext;
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor(-1);
    paramContext.setStyle(Paint.Style.FILL);
    this.x = paramContext;
    this.y = ((int)4292335833L);
    this.z = 1.4F;
    this.p0 = ((int)4289178028L);
    this.p1 = 10.0F;
  }
  
  public PowerLineChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor((int)4281811706L);
    paramContext.setStyle(Paint.Style.FILL);
    paramAttributeSet = p.a;
    this.f = paramContext;
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor((int)4279946239L);
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setStrokeWidth(8.0F);
    this.q = paramContext;
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor(-1);
    paramContext.setStyle(Paint.Style.FILL);
    this.x = paramContext;
    this.y = ((int)4292335833L);
    this.z = 1.4F;
    this.p0 = ((int)4289178028L);
    this.p1 = 10.0F;
  }
  
  public PowerLineChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new Paint();
    paramAttributeSet.setFlags(1);
    paramAttributeSet.setColor((int)4281811706L);
    paramAttributeSet.setStyle(Paint.Style.FILL);
    paramContext = p.a;
    this.f = paramAttributeSet;
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor((int)4279946239L);
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setStrokeWidth(8.0F);
    this.q = paramContext;
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor(-1);
    paramContext.setStyle(Paint.Style.FILL);
    this.x = paramContext;
    this.y = ((int)4292335833L);
    this.z = 1.4F;
    this.p0 = ((int)4289178028L);
    this.p1 = 10.0F;
  }
  
  private final void a()
  {
    Object localObject = this.mLegend;
    j.d(localObject, "mLegend");
    ((ComponentBase)localObject).setEnabled(false);
    localObject = this.mDescription;
    j.d(localObject, "mDescription");
    ((ComponentBase)localObject).setEnabled(false);
    setDragEnabled(true);
    setScaleEnabled(false);
    setNoDataText("");
    localObject = this.mXAxis;
    ((XAxis)localObject).setPosition(XAxis.XAxisPosition.BOTTOM);
    ((AxisBase)localObject).setGridColor(this.y);
    ((AxisBase)localObject).setGridLineWidth(1.0F);
    ((AxisBase)localObject).enableGridDashedLine(16.0F, 12.0F, 0.0F);
    ((AxisBase)localObject).setAxisLineColor(this.y);
    ((AxisBase)localObject).setAxisLineWidth(this.z);
    ((AxisBase)localObject).setSpaceMin(0.0F);
    ((AxisBase)localObject).setSpaceMax(0.0F);
    ((ComponentBase)localObject).setTextColor(this.p0);
    ((ComponentBase)localObject).setTextSize(this.p1);
    localObject = getYAxis();
    ((AxisBase)localObject).setDrawGridLines(false);
    ((AxisBase)localObject).setDrawLabels(true);
    ((AxisBase)localObject).setAxisMinimum(0.0F);
    ((AxisBase)localObject).setLabelCount(1, true);
    ((AxisBase)localObject).setAxisLineColor(this.y);
    ((AxisBase)localObject).setAxisLineWidth(this.z);
    ((ComponentBase)localObject).setTextColor(this.p0);
    ((ComponentBase)localObject).setTextSize(this.p1);
    localObject = this.mAxisRight;
    ((AxisBase)localObject).setDrawGridLines(false);
    ((AxisBase)localObject).setDrawLabels(false);
    ((AxisBase)localObject).setAxisLineColor(this.y);
    ((AxisBase)localObject).setAxisLineWidth(this.z);
    localObject = getAnimator();
    j.d(localObject, "animator");
    ViewPortHandler localViewPortHandler = getViewPortHandler();
    j.d(localViewPortHandler, "viewPortHandler");
    this.mRenderer = new b(this, (ChartAnimator)localObject, localViewPortHandler);
    setExtraBottomOffset(8.0F);
  }
  
  private final void setupDataSetStyle(LineDataSet paramLineDataSet)
  {
    paramLineDataSet.setHighlightEnabled(true);
    paramLineDataSet.setLineWidth(2.4F);
    paramLineDataSet.setColor((int)4279946239L);
    paramLineDataSet.setDrawCircles(false);
    paramLineDataSet.setDrawFilled(true);
    paramLineDataSet.setFillFormatter(new b(this));
    paramLineDataSet.setFillDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 2098908159, 1756159 }));
  }
  
  public final void b(List<? extends BarEntry> paramList, boolean paramBoolean)
  {
    j.e(paramList, "values");
    if (paramList.isEmpty()) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    float f1;
    if (!localIterator.hasNext())
    {
      localObject1 = null;
    }
    else
    {
      localObject1 = localIterator.next();
      if (localIterator.hasNext()) {
        for (;;)
        {
          f1 = ((BarEntry)localObject1).getY();
          Object localObject2 = localObject1;
          do
          {
            Object localObject3 = localIterator.next();
            float f2 = ((BarEntry)localObject3).getY();
            localObject1 = localObject2;
            f3 = f1;
            if (Float.compare(f1, f2) < 0)
            {
              localObject1 = localObject3;
              f3 = f2;
            }
            localObject2 = localObject1;
            f1 = f3;
          } while (localIterator.hasNext());
        }
      }
    }
    Object localObject1 = (BarEntry)localObject1;
    if (localObject1 != null) {
      f1 = ((BarEntry)localObject1).getY();
    } else {
      f1 = 0.0F;
    }
    float f3 = f1;
    if (f1 == 0.0F) {
      f3 = 1.0F;
    }
    c(f3);
    localObject1 = this.mData;
    if (localObject1 != null)
    {
      j.d(localObject1, "mData");
      if (((LineData)localObject1).getDataSetCount() > 0)
      {
        localObject1 = ((LineData)this.mData).getDataSetByIndex(0);
        Objects.requireNonNull(localObject1, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
        ((LineDataSet)localObject1).setValues(paramList);
        ((LineData)this.mData).notifyDataChanged();
        notifyDataSetChanged();
        break label299;
      }
    }
    paramList = new LineDataSet(paramList, "Energy Per Day");
    setupDataSetStyle(paramList);
    paramList = new LineData(kotlin.collections.l.b(paramList));
    paramList.setDrawValues(false);
    setData(paramList);
    label299:
    if (paramBoolean) {
      animateXY(800, 800);
    }
    invalidate();
  }
  
  public final void c(float paramFloat)
  {
    YAxis localYAxis = getYAxis();
    localYAxis.setAxisMaximum(paramFloat);
    localYAxis.removeAllLimitLines();
    LimitLine localLimitLine = new LimitLine(paramFloat, "");
    localLimitLine.enableDashedLine(16.0F, 12.0F, 0.0F);
    localLimitLine.setLineWidth(this.z);
    localLimitLine.setLineColor(this.y);
    localYAxis.addLimitLine(localLimitLine);
  }
  
  public final YAxis getYAxis()
  {
    return this.mAxisLeft;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Object localObject = getHighlighted();
    if (localObject != null)
    {
      int i = localObject.length;
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) == 0) {
        localObject = null;
      }
      if (localObject != null)
      {
        localObject = localObject[0];
        if (localObject != null)
        {
          if ((((Highlight)localObject).getDrawX() <= getContentRect().right + 0.5F) && (((Highlight)localObject).getDrawX() >= getContentRect().left - 0.5F)) {
            i = j;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            paramCanvas.drawCircle(((Highlight)localObject).getDrawX(), getContentRect().top, 12.0F, this.f);
            paramCanvas.drawCircle(((Highlight)localObject).getDrawX(), ((Highlight)localObject).getDrawY(), 12.0F, this.x);
            paramCanvas.drawCircle(((Highlight)localObject).getDrawX(), ((Highlight)localObject).getDrawY(), 16.0F, this.q);
            paramCanvas = this.d;
            if (paramCanvas != null) {
              paramCanvas = (p)paramCanvas.invoke(Float.valueOf(((Highlight)localObject).getDrawX()));
            }
          }
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
  
  public final void setOnDrawHighlightLineListener(kotlin.jvm.b.l<? super Float, p> paraml)
  {
    j.e(paraml, "action");
    this.d = paraml;
  }
  
  public static final class a {}
  
  static final class b
    implements IFillFormatter
  {
    b(PowerLineChart paramPowerLineChart) {}
    
    public final float getFillLinePosition(ILineDataSet paramILineDataSet, LineDataProvider paramLineDataProvider)
    {
      paramILineDataSet = this.a.getYAxis();
      j.d(paramILineDataSet, "yAxis");
      return paramILineDataSet.getAxisMinimum();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\energymonitor\chart\PowerLineChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */