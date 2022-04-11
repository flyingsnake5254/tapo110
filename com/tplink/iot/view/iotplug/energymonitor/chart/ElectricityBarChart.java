package com.tplink.iot.view.iotplug.energymonitor.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseDataSet;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ElectricityBarChart
  extends BarChart
{
  public static final a c = new a(null);
  private kotlin.jvm.b.l<? super Float, p> d;
  private final Paint f;
  private Highlight p0;
  private final int q;
  private final float x;
  private final int y;
  private final float z;
  
  public ElectricityBarChart(Context paramContext)
  {
    super(paramContext);
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor((int)4281811706L);
    paramContext.setStyle(Paint.Style.FILL);
    p localp = p.a;
    this.f = paramContext;
    this.q = ((int)4292335833L);
    this.x = 1.6F;
    this.y = ((int)4289178028L);
    this.z = 10.0F;
  }
  
  public ElectricityBarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor((int)4281811706L);
    paramContext.setStyle(Paint.Style.FILL);
    paramAttributeSet = p.a;
    this.f = paramContext;
    this.q = ((int)4292335833L);
    this.x = 1.6F;
    this.y = ((int)4289178028L);
    this.z = 10.0F;
  }
  
  public ElectricityBarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new Paint();
    paramContext.setFlags(1);
    paramContext.setColor((int)4281811706L);
    paramContext.setStyle(Paint.Style.FILL);
    paramAttributeSet = p.a;
    this.f = paramContext;
    this.q = ((int)4292335833L);
    this.x = 1.6F;
    this.y = ((int)4289178028L);
    this.z = 10.0F;
  }
  
  private final void b()
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
    ((AxisBase)localObject).setDrawGridLines(false);
    ((AxisBase)localObject).setAxisLineColor(this.q);
    ((AxisBase)localObject).setAxisLineWidth(this.x);
    ((AxisBase)localObject).setSpaceMin(0.6F);
    ((AxisBase)localObject).setSpaceMax(0.6F);
    ((ComponentBase)localObject).setTextColor(this.y);
    ((ComponentBase)localObject).setTextSize(this.z);
    localObject = getYAxis();
    ((AxisBase)localObject).setDrawGridLines(false);
    ((AxisBase)localObject).setDrawLabels(true);
    ((AxisBase)localObject).setAxisMinimum(0.0F);
    ((AxisBase)localObject).setLabelCount(1, true);
    ((AxisBase)localObject).setAxisLineColor(this.q);
    ((AxisBase)localObject).setAxisLineWidth(this.x);
    ((ComponentBase)localObject).setTextColor(this.y);
    ((ComponentBase)localObject).setTextSize(this.z);
    localObject = this.mAxisRight;
    ((AxisBase)localObject).setDrawGridLines(false);
    ((AxisBase)localObject).setDrawLabels(false);
    ((AxisBase)localObject).setAxisLineColor(this.q);
    ((AxisBase)localObject).setAxisLineWidth(this.x);
    ChartAnimator localChartAnimator = getAnimator();
    j.d(localChartAnimator, "animator");
    localObject = getViewPortHandler();
    j.d(localObject, "viewPortHandler");
    this.mRenderer = new a(this, localChartAnimator, (ViewPortHandler)localObject);
    setExtraBottomOffset(8.0F);
  }
  
  private final void d(float paramFloat)
  {
    YAxis localYAxis = getYAxis();
    localYAxis.setAxisMaximum(paramFloat);
    localYAxis.removeAllLimitLines();
    LimitLine localLimitLine = new LimitLine(paramFloat, "");
    localLimitLine.enableDashedLine(16.0F, 12.0F, 0.0F);
    localLimitLine.setLineWidth(this.x);
    localLimitLine.setLineColor(this.q);
    localYAxis.addLimitLine(localLimitLine);
  }
  
  public final void a()
  {
    Highlight localHighlight = this.p0;
    if (localHighlight != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveViewToHighlight: (");
      ((StringBuilder)localObject).append(localHighlight.getX());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(localHighlight.getY());
      ((StringBuilder)localObject).append(')');
      Log.d("EnergyMonitorBarChart", ((StringBuilder)localObject).toString());
      if ((localHighlight.getDrawX() < getContentRect().left) || (localHighlight.getDrawX() > getContentRect().right))
      {
        ChartTouchListener localChartTouchListener = this.mChartTouchListener;
        localObject = localChartTouchListener;
        if (!(localChartTouchListener instanceof BarLineChartTouchListener)) {
          localObject = null;
        }
        localObject = (BarLineChartTouchListener)localObject;
        if (localObject != null) {
          ((BarLineChartTouchListener)localObject).stopDeceleration();
        }
        centerViewToAnimated(localHighlight.getX(), localHighlight.getY(), YAxis.AxisDependency.LEFT, 400L);
      }
    }
  }
  
  public final void c(List<? extends BarEntry> paramList, boolean paramBoolean)
  {
    j.e(paramList, "values");
    if (paramList.isEmpty()) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = localIterator.hasNext();
    Object localObject1 = null;
    float f3;
    if (!bool)
    {
      localObject2 = null;
    }
    else
    {
      localObject2 = localIterator.next();
      if (localIterator.hasNext())
      {
        f1 = ((BarEntry)localObject2).getY();
        Object localObject3 = localObject2;
        do
        {
          Object localObject4 = localIterator.next();
          float f2 = ((BarEntry)localObject4).getY();
          localObject2 = localObject3;
          f3 = f1;
          if (Float.compare(f1, f2) < 0)
          {
            localObject2 = localObject4;
            f3 = f2;
          }
          localObject3 = localObject2;
          f1 = f3;
        } while (localIterator.hasNext());
      }
    }
    Object localObject2 = (BarEntry)localObject2;
    if (localObject2 != null) {
      f3 = ((BarEntry)localObject2).getY();
    } else {
      f3 = 0.0F;
    }
    float f1 = f3;
    if (f3 == 0.0F) {
      f1 = 1.0F;
    }
    d(f1);
    localObject2 = this.mData;
    if (localObject2 != null)
    {
      j.d(localObject2, "mData");
      if (((BarData)localObject2).getDataSetCount() > 0)
      {
        localObject2 = ((BarData)this.mData).getDataSetByIndex(0);
        Objects.requireNonNull(localObject2, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
        ((BarDataSet)localObject2).setValues(paramList);
        notifyDataSetChanged();
        break label312;
      }
    }
    paramList = new BarDataSet(paramList, "Energy Per Day");
    paramList.setHighlightEnabled(true);
    paramList.setGradientColor((int)4284275455L, (int)4281576191L);
    paramList = new BarData(kotlin.collections.l.b(paramList));
    paramList.setDrawValues(false);
    paramList.setBarWidth(0.55F);
    setData(paramList);
    label312:
    setVisibleXRangeMinimum(7.0F);
    setVisibleXRangeMaximum(7.0F);
    if (paramBoolean) {
      animateXY(800, 800);
    }
    invalidate();
    paramList = this.mChartTouchListener;
    if (!(paramList instanceof BarLineChartTouchListener)) {
      paramList = (List<? extends BarEntry>)localObject1;
    }
    paramList = (BarLineChartTouchListener)paramList;
    if (paramList != null) {
      paramList.stopDeceleration();
    }
    moveViewToX(-1.0F);
  }
  
  public final YAxis getYAxis()
  {
    return this.mAxisLeft;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Object localObject = null;
    this.p0 = null;
    Highlight[] arrayOfHighlight = this.mIndicesToHighlight;
    if (arrayOfHighlight != null)
    {
      int i;
      if (arrayOfHighlight.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0) {
        localObject = arrayOfHighlight;
      }
      if (localObject != null)
      {
        localObject = localObject[0];
        if (localObject != null)
        {
          this.p0 = ((Highlight)localObject);
          if ((((Highlight)localObject).getDrawX() <= getContentRect().right) && (((Highlight)localObject).getDrawX() >= getContentRect().left))
          {
            paramCanvas.drawCircle(((Highlight)localObject).getDrawX(), getContentRect().top, 12.0F, this.f);
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
    b();
  }
  
  public final void setOnDrawHighlightLineListener(kotlin.jvm.b.l<? super Float, p> paraml)
  {
    j.e(paraml, "action");
    this.d = paraml;
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\energymonitor\chart\ElectricityBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */