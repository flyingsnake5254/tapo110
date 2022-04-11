package com.tplink.iot.devices.trv.view.chart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.util.TypedValue;
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
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class TemperatureRecordChart
  extends LineChart
{
  private final float H3;
  private final float I3;
  private final float c = c(400);
  private kotlin.jvm.b.l<? super Float, kotlin.p> d;
  private final Paint f;
  private final float p0;
  private final int p1;
  private final float p2;
  private EnumTemperatureUnit p3;
  private final Paint q;
  private final Paint x;
  private final int y;
  private final int z;
  
  public TemperatureRecordChart(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public TemperatureRecordChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public TemperatureRecordChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new Paint();
    paramAttributeSet.setFlags(1);
    paramAttributeSet.setColor((int)4281811706L);
    paramAttributeSet.setStyle(Paint.Style.FILL);
    paramContext = kotlin.p.a;
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
    this.y = ((int)4284800255L);
    this.z = ((int)4293322471L);
    this.p0 = 1.4F;
    this.p1 = ((int)4289178028L);
    this.p2 = 14.0F;
    this.p3 = EnumTemperatureUnit.CELSIUS;
    this.I3 = 32.0F;
  }
  
  private final void b(LimitLine paramLimitLine)
  {
    paramLimitLine.setXOffset(c(2));
    paramLimitLine.setTextColor(this.p1);
    paramLimitLine.setTextSize(this.p2);
    paramLimitLine.setLineWidth(this.p0);
    paramLimitLine.setLineColor(this.z);
  }
  
  private final float c(int paramInt)
  {
    float f1 = paramInt;
    Object localObject = getContext();
    j.d(localObject, "context");
    localObject = ((Context)localObject).getResources();
    j.d(localObject, "context.resources");
    return TypedValue.applyDimension(1, f1, ((Resources)localObject).getDisplayMetrics());
  }
  
  private final void d()
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
    ((AxisBase)localObject).setGridColor(this.z);
    ((AxisBase)localObject).setGridLineWidth(1.0F);
    ((AxisBase)localObject).enableGridDashedLine(16.0F, 12.0F, 0.0F);
    ((AxisBase)localObject).setAxisLineColor(this.z);
    ((AxisBase)localObject).setAxisLineWidth(this.p0);
    ((AxisBase)localObject).setSpaceMin(0.0F);
    ((AxisBase)localObject).setSpaceMax(0.0F);
    ((ComponentBase)localObject).setTextColor(this.p1);
    ((ComponentBase)localObject).setTextSize(this.p2);
    ((AxisBase)localObject).setAxisMinimum(0.0F);
    ((AxisBase)localObject).setAxisMaximum(48.0F);
    ((AxisBase)localObject).setLabelCount(7, true);
    ((AxisBase)localObject).setValueFormatter(new a());
    localObject = getYAxis();
    ((AxisBase)localObject).setDrawGridLines(false);
    ((AxisBase)localObject).setDrawLabels(true);
    ((AxisBase)localObject).setLabelCount(1, true);
    ((AxisBase)localObject).setAxisLineColor(this.z);
    ((AxisBase)localObject).setAxisLineWidth(this.p0);
    ((ComponentBase)localObject).setTextColor(-1);
    ((ComponentBase)localObject).setTextSize(this.p2);
    ((AxisBase)localObject).setValueFormatter(new b(this));
    ViewPortHandler localViewPortHandler = this.mViewPortHandler;
    j.d(localViewPortHandler, "mViewPortHandler");
    YAxis localYAxis = getYAxis();
    j.d(localYAxis, "yAxis");
    localObject = this.mLeftAxisTransformer;
    j.d(localObject, "mLeftAxisTransformer");
    this.mAxisRendererLeft = new b(localViewPortHandler, localYAxis, (Transformer)localObject);
    localObject = this.mAxisRight;
    ((AxisBase)localObject).setDrawGridLines(false);
    ((AxisBase)localObject).setDrawLabels(false);
    ((AxisBase)localObject).setAxisLineColor(this.z);
    ((AxisBase)localObject).setAxisLineWidth(this.p0);
    localObject = this.mAnimator;
    j.d(localObject, "mAnimator");
    localViewPortHandler = this.mViewPortHandler;
    j.d(localViewPortHandler, "mViewPortHandler");
    this.mRenderer = new a(this, (ChartAnimator)localObject, localViewPortHandler);
    setExtraBottomOffset(8.0F);
  }
  
  private final void f(List<Float> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Object localObject = kotlin.collections.l.H(paramList);
    if (localObject != null)
    {
      float f1 = ((Float)localObject).floatValue();
      localObject = kotlin.collections.l.J(paramList);
      if (localObject != null)
      {
        float f2 = ((Float)localObject).floatValue();
        EnumTemperatureUnit localEnumTemperatureUnit = this.p3;
        localObject = EnumTemperatureUnit.FAHRENHEIT;
        int i = 1;
        if (localEnumTemperatureUnit == localObject)
        {
          if (!paramList.isEmpty())
          {
            paramList = paramList.iterator();
            do
            {
              if (!paramList.hasNext()) {
                break;
              }
              if (((Number)paramList.next()).floatValue() <= this.I3) {
                j = 1;
              } else {
                j = 0;
              }
            } while (j == 0);
            j = i;
            break label196;
          }
        }
        else {
          if (!paramList.isEmpty()) {
            break label142;
          }
        }
        label142:
        do
        {
          while (!paramList.hasNext())
          {
            j = 0;
            break;
            paramList = paramList.iterator();
          }
          if (((Number)paramList.next()).floatValue() <= this.H3) {
            j = 1;
          } else {
            j = 0;
          }
        } while (j == 0);
        int j = i;
        label196:
        localObject = getYAxis();
        f1 = (float)Math.ceil(f1);
        f2 = (float)Math.floor(f2);
        ((AxisBase)localObject).setAxisMaximum(f1 + 3.0F);
        ((AxisBase)localObject).setAxisMinimum(f2 - 3.0F);
        ((AxisBase)localObject).removeAllLimitLines();
        paramList = new StringBuilder();
        paramList.append((int)f1);
        paramList.append(getMTempUnitStr());
        paramList = new LimitLine(f1, paramList.toString());
        b(paramList);
        ((AxisBase)localObject).addLimitLine(paramList);
        paramList = new StringBuilder();
        paramList.append((int)f2);
        paramList.append(getMTempUnitStr());
        paramList = new LimitLine(f2, paramList.toString());
        b(paramList);
        ((AxisBase)localObject).addLimitLine(paramList);
        if (j != 0)
        {
          if (this.p3 == EnumTemperatureUnit.FAHRENHEIT)
          {
            paramList = new StringBuilder();
            paramList.append((int)this.I3);
            paramList.append(getMTempUnitStr());
            paramList = paramList.toString();
          }
          else
          {
            paramList = new StringBuilder();
            paramList.append((int)this.H3);
            paramList.append(getMTempUnitStr());
            paramList = paramList.toString();
          }
          paramList = new LimitLine(0.0F, paramList);
          b(paramList);
          paramList.setLineColor(this.y);
          ((AxisBase)localObject).addLimitLine(paramList);
        }
      }
    }
  }
  
  private final String getMTempUnitStr()
  {
    return this.p3.getUnitText();
  }
  
  private final void setupDataSetStyle(LineDataSet paramLineDataSet)
  {
    paramLineDataSet.setHighlightEnabled(true);
    paramLineDataSet.setLineWidth(2.4F);
    paramLineDataSet.setColor((int)4279946239L);
    paramLineDataSet.setDrawCircles(false);
    paramLineDataSet.setDrawFilled(true);
    paramLineDataSet.setFillFormatter(new c(this));
    paramLineDataSet.setFillDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 2098908159, 1756159 }));
  }
  
  public final void e(List<? extends BarEntry> paramList, boolean paramBoolean)
  {
    j.e(paramList, "values");
    Object localObject = new ArrayList(kotlin.collections.l.l(paramList, 10));
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((Collection)localObject).add(Float.valueOf(((BarEntry)localIterator.next()).getY()));
    }
    f((List)localObject);
    localObject = this.mData;
    if (localObject != null)
    {
      j.d(localObject, "mData");
      if (((LineData)localObject).getDataSetCount() > 0)
      {
        localObject = ((LineData)this.mData).getDataSetByIndex(0);
        Objects.requireNonNull(localObject, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
        ((LineDataSet)localObject).setValues(paramList);
        ((LineData)this.mData).notifyDataChanged();
        notifyDataSetChanged();
        break label180;
      }
    }
    paramList = new LineDataSet(paramList, "Temperature");
    setupDataSetStyle(paramList);
    paramList = new LineData(kotlin.collections.l.b(paramList));
    paramList.setDrawValues(false);
    setData(paramList);
    label180:
    if (paramBoolean) {
      animateXY(800, 800);
    }
    invalidate();
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
      int i;
      if (localObject.length == 0) {
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
        if ((localObject != null) && (((Highlight)localObject).getDrawX() <= getContentRect().right) && (((Highlight)localObject).getDrawX() >= getContentRect().left))
        {
          paramCanvas.drawCircle(((Highlight)localObject).getDrawX(), getContentRect().top, 12.0F, this.f);
          paramCanvas.drawCircle(((Highlight)localObject).getDrawX(), getContentRect().bottom - 10.0F, 12.0F, this.x);
          paramCanvas.drawCircle(((Highlight)localObject).getDrawX(), getContentRect().bottom - 10.0F, 16.0F, this.q);
          paramCanvas = this.d;
          if (paramCanvas != null) {
            paramCanvas = (kotlin.p)paramCanvas.invoke(Float.valueOf(((Highlight)localObject).getDrawX()));
          }
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    d();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = Math.min(getMeasuredHeight(), (int)this.c);
    setMeasuredDimension(getMeasuredWidth(), paramInt1);
  }
  
  public final void setOnDrawHighlightLineListener(kotlin.jvm.b.l<? super Float, kotlin.p> paraml)
  {
    j.e(paraml, "action");
    this.d = paraml;
  }
  
  public final void setTemperatureUnit(EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    j.e(paramEnumTemperatureUnit, "unit");
    this.p3 = paramEnumTemperatureUnit;
  }
  
  private static final class a
    extends ValueFormatter
  {
    private final Calendar a;
    
    public a()
    {
      Calendar localCalendar = Calendar.getInstance();
      j.d(localCalendar, "this");
      localCalendar.setTime(new Date());
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      kotlin.p localp = kotlin.p.a;
      this.a = localCalendar;
    }
    
    public String getFormattedValue(float paramFloat)
    {
      Object localObject1 = Calendar.getInstance();
      Object localObject2 = this.a;
      j.d(localObject2, "zeroClockTime");
      ((Calendar)localObject1).setTime(((Calendar)localObject2).getTime());
      ((Calendar)localObject1).add(12, (int)paramFloat * 30);
      localObject2 = new SimpleDateFormat("H:mm", Locale.getDefault());
      j.d(localObject1, "calendar");
      localObject1 = ((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime());
      j.d(localObject1, "SimpleDateFormat(\"H:mm\",…()).format(calendar.time)");
      return (String)localObject1;
    }
  }
  
  public static final class b
    extends ValueFormatter
  {
    b(TemperatureRecordChart paramTemperatureRecordChart) {}
    
    public String getFormattedValue(float paramFloat)
    {
      Object localObject = kotlin.jvm.internal.p.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("%d");
      ((StringBuilder)localObject).append(TemperatureRecordChart.a(this.a));
      localObject = String.format(((StringBuilder)localObject).toString(), Arrays.copyOf(new Object[] { Integer.valueOf((int)paramFloat) }, 1));
      j.d(localObject, "java.lang.String.format(format, *args)");
      return (String)localObject;
    }
  }
  
  static final class c
    implements IFillFormatter
  {
    c(TemperatureRecordChart paramTemperatureRecordChart) {}
    
    public final float getFillLinePosition(ILineDataSet paramILineDataSet, LineDataProvider paramLineDataProvider)
    {
      paramILineDataSet = this.a.getYAxis();
      j.d(paramILineDataSet, "yAxis");
      return paramILineDataSet.getAxisMinimum();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\chart\TemperatureRecordChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */