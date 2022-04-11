package com.tplink.iot.view.iotplug.energymonitor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityPlugElectricityStatisticBinding;
import com.tplink.iot.view.iotplug.energymonitor.chart.ElectricityBarChart;
import com.tplink.iot.viewmodel.iotplug.PlugEnergyMonitorViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;

public final class PlugElectricityStatisticActivity
  extends BaseActivity
  implements OnChartValueSelectedListener
{
  public static final a y = new a(null);
  private final f H3 = h.b(new j(this));
  private EnergyUsageResult I3;
  private boolean J3;
  private boolean K3;
  private ActivityPlugElectricityStatisticBinding p0;
  private final f p1 = h.b(new h(this));
  private final f p2 = h.b(new i(this));
  private final f p3 = h.b(new l(this));
  private String z = "";
  
  private final void A1()
  {
    x1(true);
    B1();
    t1();
  }
  
  private final void B1()
  {
    EnergyUsageResult localEnergyUsageResult = this.I3;
    if (localEnergyUsageResult != null)
    {
      l1().clear();
      Object localObject1;
      int i;
      Object localObject2;
      Object localObject3;
      int j;
      if (s1())
      {
        localObject1 = localEnergyUsageResult.getPast30d();
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0) {
          return;
        }
        localObject1 = new ArrayList();
        localObject2 = localEnergyUsageResult.getPast30d().iterator();
        for (i = 0; ((Iterator)localObject2).hasNext(); i++)
        {
          localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            kotlin.collections.l.k();
          }
          j = ((Number)localObject3).intValue();
          ((List)localObject1).add(new BarEntry(i, w1(j), Long.valueOf(localEnergyUsageResult.getLocalTimeInMS())));
        }
        localObject2 = l1().getXAxis();
        kotlin.jvm.internal.j.d(localObject2, "mBarChart.xAxis");
        ((AxisBase)localObject2).setValueFormatter(new b(localEnergyUsageResult.getLocalTimeInMS(), localEnergyUsageResult.getPast30d().size()));
        l1().c((List)localObject1, this.J3 ^ true);
        l1().centerViewToAnimated(kotlin.collections.l.f(localEnergyUsageResult.getPast30d()), 0.0F, YAxis.AxisDependency.LEFT, 400L);
        x1(false);
        this.J3 = true;
      }
      else
      {
        localObject1 = localEnergyUsageResult.getPast1y();
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0) {
          return;
        }
        localObject1 = new ArrayList();
        localObject2 = localEnergyUsageResult.getPast1y().iterator();
        for (i = 0; ((Iterator)localObject2).hasNext(); i++)
        {
          localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            kotlin.collections.l.k();
          }
          j = ((Number)localObject3).intValue();
          ((List)localObject1).add(new BarEntry(i, w1(j), Long.valueOf(localEnergyUsageResult.getLocalTimeInMS())));
        }
        localObject2 = l1().getXAxis();
        kotlin.jvm.internal.j.d(localObject2, "mBarChart.xAxis");
        ((AxisBase)localObject2).setValueFormatter(new c(localEnergyUsageResult.getLocalTimeInMS(), localEnergyUsageResult.getPast1y().size()));
        l1().c((List)localObject1, this.K3 ^ true);
        l1().centerViewToAnimated(kotlin.collections.l.f(localEnergyUsageResult.getPast1y()), 0.0F, YAxis.AxisDependency.LEFT, 400L);
        x1(false);
        this.K3 = true;
      }
    }
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private final void C1(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      m1().setCardElevation(com.tplink.iot.Utils.j.a(this, 4.0F));
    }
    Object localObject1;
    if (paramFloat2 < 0.1F)
    {
      localObject1 = "<0.1";
    }
    else
    {
      localObject1 = kotlin.jvm.internal.p.a;
      localObject1 = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(paramFloat2) }, 1));
      kotlin.jvm.internal.j.d(localObject1, "java.lang.String.format(format, *args)");
    }
    Object localObject2 = this.p0;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("mViewBinding");
    }
    localObject2 = ((ActivityPlugElectricityStatisticBinding)localObject2).x;
    kotlin.jvm.internal.j.d(localObject2, "mViewBinding.tvPower");
    y1((TextView)localObject2, (String)localObject1, o1());
    localObject2 = this.I3;
    if (localObject2 != null)
    {
      TextView localTextView;
      if (s1())
      {
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTime(new Date(((EnergyUsageResult)localObject2).getLocalTimeInMS()));
        ((Calendar)localObject1).add(5, -(((EnergyUsageResult)localObject2).getPast30d().size() - (int)paramFloat1 - 1));
        localObject2 = this.p0;
        if (localObject2 == null) {
          kotlin.jvm.internal.j.t("mViewBinding");
        }
        localTextView = ((ActivityPlugElectricityStatisticBinding)localObject2).y;
        kotlin.jvm.internal.j.d(localTextView, "mViewBinding.tvTime");
        localObject2 = new SimpleDateFormat("MMM dd, yyyy");
        kotlin.jvm.internal.j.d(localObject1, "calendar");
        localTextView.setText(((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime()));
      }
      else
      {
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTime(new Date(((EnergyUsageResult)localObject2).getLocalTimeInMS()));
        ((Calendar)localObject1).add(2, -(((EnergyUsageResult)localObject2).getPast1y().size() - (int)paramFloat1 - 1));
        localObject2 = this.p0;
        if (localObject2 == null) {
          kotlin.jvm.internal.j.t("mViewBinding");
        }
        localTextView = ((ActivityPlugElectricityStatisticBinding)localObject2).y;
        kotlin.jvm.internal.j.d(localTextView, "mViewBinding.tvTime");
        localObject2 = new SimpleDateFormat("MMM yyyy");
        kotlin.jvm.internal.j.d(localObject1, "calendar");
        localTextView.setText(((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime()));
      }
    }
  }
  
  private final ElectricityBarChart l1()
  {
    return (ElectricityBarChart)this.p1.getValue();
  }
  
  private final CardView m1()
  {
    return (CardView)this.p2.getValue();
  }
  
  private final PlugEnergyMonitorViewModel n1()
  {
    return (PlugEnergyMonitorViewModel)this.H3.getValue();
  }
  
  private final String o1()
  {
    return (String)this.p3.getValue();
  }
  
  private final void p1()
  {
    l1().setOnChartValueSelectedListener(this);
    YAxis localYAxis = l1().getYAxis();
    kotlin.jvm.internal.j.d(localYAxis, "mBarChart.yAxis");
    localYAxis.setValueFormatter(new d());
    l1().setOnDrawHighlightLineListener(new e(this));
  }
  
  private final void q1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("device_id_md5");
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    this.z = ((String)localObject);
  }
  
  private final void r1()
  {
    b1(2131953374);
    Object localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewBinding");
    }
    ((ActivityPlugElectricityStatisticBinding)localObject).q.addOnTabSelectedListener(new f(this));
    localObject = getIntent();
    int i = 0;
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("PageType", 0);
    }
    localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewBinding");
    }
    localObject = ((ActivityPlugElectricityStatisticBinding)localObject).q;
    ActivityPlugElectricityStatisticBinding localActivityPlugElectricityStatisticBinding = this.p0;
    if (localActivityPlugElectricityStatisticBinding == null) {
      kotlin.jvm.internal.j.t("mViewBinding");
    }
    ((TabLayout)localObject).selectTab(localActivityPlugElectricityStatisticBinding.q.getTabAt(i));
    m1().setOnClickListener(new g(this));
    p1();
  }
  
  private final boolean s1()
  {
    Object localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewBinding");
    }
    localObject = ((ActivityPlugElectricityStatisticBinding)localObject).q;
    kotlin.jvm.internal.j.d(localObject, "mViewBinding.pemTabLayout");
    boolean bool;
    if (((TabLayout)localObject).getSelectedTabPosition() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final void t1()
  {
    if (s1()) {
      i.k(this.z);
    } else {
      i.j(this.z);
    }
  }
  
  private final void u1(float paramFloat)
  {
    m1().setTranslationX(Math.min(Math.max(paramFloat - m1().getWidth() / 2.0F, 0.0F), l1().getWidth() - m1().getWidth()));
  }
  
  public static final void v1(Context paramContext, String paramString)
  {
    y.a(paramContext, paramString);
  }
  
  private final float w1(int paramInt)
  {
    return paramInt / 1000.0F;
  }
  
  private final void x1(boolean paramBoolean)
  {
    m1().setCardElevation(0.0F);
    m1().animate().translationX(0.0F).start();
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.p0;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewBinding");
      }
      localObject = ((ActivityPlugElectricityStatisticBinding)localObject).x;
      kotlin.jvm.internal.j.d(localObject, "mViewBinding.tvPower");
      ((TextView)localObject).setText("--");
      localObject = this.p0;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewBinding");
      }
      localObject = ((ActivityPlugElectricityStatisticBinding)localObject).y;
      kotlin.jvm.internal.j.d(localObject, "mViewBinding.tvTime");
      ((TextView)localObject).setText("--");
    }
    else
    {
      localObject = this.I3;
      if (localObject != null)
      {
        paramBoolean = s1();
        int i = 1;
        int j = 1;
        List localList;
        int k;
        if (paramBoolean)
        {
          localList = ((EnergyUsageResult)localObject).getPast30d();
          k = j;
          if (localList != null) {
            if (localList.isEmpty()) {
              k = j;
            } else {
              k = 0;
            }
          }
          if (k != 0) {
            return;
          }
          C1(kotlin.collections.l.f(((EnergyUsageResult)localObject).getPast30d()), w1(((Number)kotlin.collections.l.F(((EnergyUsageResult)localObject).getPast30d())).intValue()), false);
        }
        else
        {
          localList = ((EnergyUsageResult)localObject).getPast1y();
          k = i;
          if (localList != null) {
            if (localList.isEmpty()) {
              k = i;
            } else {
              k = 0;
            }
          }
          if (k != 0) {
            return;
          }
          C1(kotlin.collections.l.f(((EnergyUsageResult)localObject).getPast1y()), w1(((Number)kotlin.collections.l.F(((EnergyUsageResult)localObject).getPast1y())).intValue()), false);
        }
      }
    }
  }
  
  private final void y1(TextView paramTextView, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramString2);
    paramString2 = new SpannableString(((StringBuilder)localObject).toString());
    localObject = new RelativeSizeSpan(1.6F);
    StyleSpan localStyleSpan = new StyleSpan(1);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan((int)4281545523L);
    paramString2.setSpan(localObject, 0, paramString1.length(), 33);
    paramString2.setSpan(localStyleSpan, 0, paramString1.length(), 33);
    paramString2.setSpan(localForegroundColorSpan, 0, paramString1.length(), 33);
    paramString1 = kotlin.p.a;
    paramTextView.setText(paramString2);
  }
  
  private final void z1()
  {
    n1().h().observe(this, new k(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558606);
    kotlin.jvm.internal.j.d(paramBundle, "DataBindingUtil.setConte…ug_electricity_statistic)");
    this.p0 = ((ActivityPlugElectricityStatisticBinding)paramBundle);
    q1();
    r1();
    z1();
  }
  
  public void onNothingSelected()
  {
    x1(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    n1().f();
  }
  
  public void onValueSelected(Entry paramEntry, Highlight paramHighlight)
  {
    if (paramEntry != null) {
      C1(paramEntry.getX(), paramEntry.getY(), true);
    }
  }
  
  public static final class a
  {
    private final Intent b(Context paramContext, int paramInt, String paramString)
    {
      paramContext = new Intent(paramContext, PlugElectricityStatisticActivity.class);
      paramContext.putExtra("PageType", paramInt);
      paramContext.putExtra("device_id_md5", paramString);
      return paramContext;
    }
    
    public final void a(Context paramContext, String paramString)
    {
      kotlin.jvm.internal.j.e(paramContext, "context");
      kotlin.jvm.internal.j.e(paramString, "deviceIdMD5");
      paramContext.startActivity(b(paramContext, 0, paramString));
    }
  }
  
  private static final class b
    extends ValueFormatter
  {
    private long a;
    private int b;
    
    public b(long paramLong, int paramInt)
    {
      this.a = paramLong;
      this.b = paramInt;
    }
    
    @SuppressLint({"SimpleDateFormat"})
    public String getFormattedValue(float paramFloat)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(new Date(this.a));
      localCalendar.add(5, -(this.b - (int)paramFloat - 1));
      if (localCalendar.get(5) == 1)
      {
        Object localObject = new SimpleDateFormat("d MMM");
        kotlin.jvm.internal.j.d(localCalendar, "calendar");
        localObject = ((SimpleDateFormat)localObject).format(localCalendar.getTime());
        kotlin.jvm.internal.j.d(localObject, "SimpleDateFormat(\"d MMM\").format(calendar.time)");
        return (String)localObject;
      }
      return String.valueOf(localCalendar.get(5));
    }
  }
  
  private static final class c
    extends ValueFormatter
  {
    private long a;
    private int b;
    
    public c(long paramLong, int paramInt)
    {
      this.a = paramLong;
      this.b = paramInt;
    }
    
    @SuppressLint({"SimpleDateFormat"})
    public String getFormattedValue(float paramFloat)
    {
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(new Date(this.a));
      ((Calendar)localObject).add(2, -(this.b - (int)paramFloat - 1));
      SimpleDateFormat localSimpleDateFormat;
      if (((Calendar)localObject).get(2) == 0)
      {
        localSimpleDateFormat = new SimpleDateFormat("MMM yyyy");
        kotlin.jvm.internal.j.d(localObject, "calendar");
        localObject = localSimpleDateFormat.format(((Calendar)localObject).getTime());
        kotlin.jvm.internal.j.d(localObject, "SimpleDateFormat(\"MMM yyyy\").format(calendar.time)");
      }
      else
      {
        localSimpleDateFormat = new SimpleDateFormat("MMM");
        kotlin.jvm.internal.j.d(localObject, "calendar");
        localObject = localSimpleDateFormat.format(((Calendar)localObject).getTime());
        kotlin.jvm.internal.j.d(localObject, "SimpleDateFormat(\"MMM\").format(calendar.time)");
      }
      return (String)localObject;
    }
  }
  
  private static final class d
    extends ValueFormatter
  {
    public String getFormattedValue(float paramFloat)
    {
      if (paramFloat <= 0.0F) {
        return "";
      }
      Object localObject = kotlin.jvm.internal.p.a;
      localObject = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(paramFloat) }, 1));
      kotlin.jvm.internal.j.d(localObject, "java.lang.String.format(format, *args)");
      return (String)localObject;
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.l<Float, kotlin.p>
  {
    e(PlugElectricityStatisticActivity paramPlugElectricityStatisticActivity)
    {
      super();
    }
    
    public final void a(float paramFloat)
    {
      PlugElectricityStatisticActivity.h1(this.c, paramFloat);
    }
  }
  
  public static final class f
    implements TabLayout.OnTabSelectedListener
  {
    f(PlugElectricityStatisticActivity paramPlugElectricityStatisticActivity) {}
    
    public void onTabReselected(TabLayout.Tab paramTab) {}
    
    public void onTabSelected(TabLayout.Tab paramTab)
    {
      PlugElectricityStatisticActivity.j1(this.a);
    }
    
    public void onTabUnselected(TabLayout.Tab paramTab) {}
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(PlugElectricityStatisticActivity paramPlugElectricityStatisticActivity) {}
    
    public final void onClick(View paramView)
    {
      PlugElectricityStatisticActivity.e1(this.c).a();
    }
  }
  
  static final class h
    extends Lambda
    implements kotlin.jvm.b.a<ElectricityBarChart>
  {
    h(PlugElectricityStatisticActivity paramPlugElectricityStatisticActivity)
    {
      super();
    }
    
    public final ElectricityBarChart a()
    {
      ElectricityBarChart localElectricityBarChart = PlugElectricityStatisticActivity.g1(this.c).c;
      kotlin.jvm.internal.j.d(localElectricityBarChart, "mViewBinding.pemBarChart");
      return localElectricityBarChart;
    }
  }
  
  static final class i
    extends Lambda
    implements kotlin.jvm.b.a<CardView>
  {
    i(PlugElectricityStatisticActivity paramPlugElectricityStatisticActivity)
    {
      super();
    }
    
    public final CardView a()
    {
      CardView localCardView = PlugElectricityStatisticActivity.g1(this.c).f;
      kotlin.jvm.internal.j.d(localCardView, "mViewBinding.pemMarkerView");
      return localCardView;
    }
  }
  
  static final class j
    extends Lambda
    implements kotlin.jvm.b.a<PlugEnergyMonitorViewModel>
  {
    j(PlugElectricityStatisticActivity paramPlugElectricityStatisticActivity)
    {
      super();
    }
    
    public final PlugEnergyMonitorViewModel a()
    {
      PlugElectricityStatisticActivity localPlugElectricityStatisticActivity = this.c;
      return (PlugEnergyMonitorViewModel)new ViewModelProvider(localPlugElectricityStatisticActivity, new IoTViewModelFactory(localPlugElectricityStatisticActivity, PlugElectricityStatisticActivity.f1(localPlugElectricityStatisticActivity))).get(PlugEnergyMonitorViewModel.class);
    }
  }
  
  static final class k<T>
    implements Observer<EnergyUsageResult>
  {
    k(PlugElectricityStatisticActivity paramPlugElectricityStatisticActivity) {}
    
    public final void a(EnergyUsageResult paramEnergyUsageResult)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EnergyUsage Result：");
      localStringBuilder.append(paramEnergyUsageResult);
      b.d.w.c.a.a(localStringBuilder.toString());
      PlugElectricityStatisticActivity.i1(this.a, paramEnergyUsageResult);
      PlugElectricityStatisticActivity.k1(this.a);
    }
  }
  
  static final class l
    extends Lambda
    implements kotlin.jvm.b.a<String>
  {
    l(PlugElectricityStatisticActivity paramPlugElectricityStatisticActivity)
    {
      super();
    }
    
    public final String a()
    {
      String str = this.c.getString(2131953408);
      kotlin.jvm.internal.j.d(str, "getString(R.string.power_unit)");
      return str;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\energymonitor\PlugElectricityStatisticActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */