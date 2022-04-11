package com.tplink.iot.view.iotplug.energymonitor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
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
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityPlugPowerStatisticBinding;
import com.tplink.iot.view.iotplug.energymonitor.chart.PowerLineChart;
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
import kotlin.collections.e;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;

public final class PlugPowerStatisticActivity
  extends BaseActivity
  implements OnChartValueSelectedListener
{
  private EnergyUsageResult H3;
  private boolean I3;
  private boolean J3;
  private boolean K3;
  private final f p0 = h.b(new f(this));
  private final f p1 = h.b(new g(this));
  private final f p2 = h.b(new j(this));
  private final f p3 = h.b(new h(this));
  private String y = "";
  private ActivityPlugPowerStatisticBinding z;
  
  private final void A1()
  {
    Object localObject1 = this.H3;
    if (localObject1 != null)
    {
      l1().clear();
      Object localObject2;
      int i;
      Object localObject3;
      Object localObject4;
      int j;
      if (s1())
      {
        localObject2 = ((EnergyUsageResult)localObject1).getPast24h();
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0) {
          return;
        }
        localObject2 = new ArrayList();
        localObject3 = ((EnergyUsageResult)localObject1).getPast24h().iterator();
        for (i = 0; ((Iterator)localObject3).hasNext(); i++)
        {
          localObject4 = ((Iterator)localObject3).next();
          if (i < 0) {
            kotlin.collections.l.k();
          }
          j = ((Number)localObject4).intValue();
          ((List)localObject2).add(new BarEntry(i, v1(j)));
        }
        localObject3 = l1();
        kotlin.jvm.internal.j.d(localObject3, "mLineChart");
        localObject3 = ((Chart)localObject3).getXAxis();
        kotlin.jvm.internal.j.d(localObject3, "mLineChart.xAxis");
        ((AxisBase)localObject3).setValueFormatter(new c(((EnergyUsageResult)localObject1).getLocalTimeInMS(), ((EnergyUsageResult)localObject1).getPast24h().size()));
        localObject1 = l1();
        kotlin.jvm.internal.j.d(localObject1, "mLineChart");
        localObject1 = ((Chart)localObject1).getXAxis();
        kotlin.jvm.internal.j.d(localObject1, "mLineChart.xAxis");
        ((AxisBase)localObject1).setLabelCount(5);
        l1().b((List)localObject2, this.I3 ^ true);
        w1(false);
        this.I3 = true;
      }
      else
      {
        localObject2 = ((EnergyUsageResult)localObject1).getPast7d();
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0) {
          return;
        }
        localObject2 = new ArrayList();
        localObject3 = Calendar.getInstance();
        ((Calendar)localObject3).setTime(new Date(((EnergyUsageResult)localObject1).getLocalTimeInMS()));
        ((Calendar)localObject3).add(5, 1);
        ((Calendar)localObject3).set(11, 0);
        localObject4 = kotlin.collections.l.m(((EnergyUsageResult)localObject1).getPast7d()).iterator();
        for (i = 0; ((Iterator)localObject4).hasNext(); i++)
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (i < 0) {
            kotlin.collections.l.k();
          }
          j = ((Number)localObject5).intValue();
          ((List)localObject2).add(new BarEntry(i, v1(j)));
        }
        ((List)localObject2).add(new BarEntry(((List)localObject2).size(), 0.0F));
        localObject4 = l1();
        kotlin.jvm.internal.j.d(localObject4, "mLineChart");
        localObject4 = ((Chart)localObject4).getXAxis();
        kotlin.jvm.internal.j.d(localObject4, "mLineChart.xAxis");
        kotlin.jvm.internal.j.d(localObject3, "calendar");
        localObject3 = ((Calendar)localObject3).getTime();
        kotlin.jvm.internal.j.d(localObject3, "calendar.time");
        ((AxisBase)localObject4).setValueFormatter(new b(((Date)localObject3).getTime(), ((EnergyUsageResult)localObject1).getPast7dCount()));
        localObject1 = l1();
        kotlin.jvm.internal.j.d(localObject1, "mLineChart");
        ((Chart)localObject1).getXAxis().setLabelCount(8, true);
        l1().b((List)localObject2, this.J3 ^ true);
        w1(false);
        this.J3 = true;
      }
    }
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private final void B1(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = m1();
    kotlin.jvm.internal.j.d(localObject1, "mMarkerView");
    float f;
    if (paramBoolean2) {
      f = com.tplink.iot.Utils.j.a(this, 4.0F);
    } else {
      f = 0.0F;
    }
    ((CardView)localObject1).setCardElevation(f);
    localObject1 = this.z;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mViewBinding");
    }
    localObject1 = ((ActivityPlugPowerStatisticBinding)localObject1).x;
    kotlin.jvm.internal.j.d(localObject1, "mViewBinding.tvPower");
    Object localObject2 = kotlin.jvm.internal.p.a;
    localObject2 = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(paramFloat2) }, 1));
    kotlin.jvm.internal.j.d(localObject2, "java.lang.String.format(format, *args)");
    x1((TextView)localObject1, (String)localObject2, o1());
    Object localObject3 = this.H3;
    if (localObject3 != null)
    {
      if (o0.p(this)) {
        localObject1 = "H";
      } else {
        localObject1 = "h";
      }
      if (o0.p(this)) {
        localObject2 = "";
      } else {
        localObject2 = " a";
      }
      Object localObject4;
      Object localObject5;
      if (paramBoolean1)
      {
        localObject4 = this.z;
        if (localObject4 == null) {
          kotlin.jvm.internal.j.t("mViewBinding");
        }
        localObject5 = ((ActivityPlugPowerStatisticBinding)localObject4).y;
        kotlin.jvm.internal.j.d(localObject5, "mViewBinding.tvTime");
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(":mm");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(", MMM dd, yyyy");
        ((TextView)localObject5).setText(new SimpleDateFormat(((StringBuilder)localObject4).toString()).format(new Date(((EnergyUsageResult)localObject3).getLocalTimeInMS())));
      }
      else if (s1())
      {
        localObject4 = Calendar.getInstance();
        ((Calendar)localObject4).setTime(new Date(((EnergyUsageResult)localObject3).getLocalTimeInMS()));
        ((Calendar)localObject4).add(10, -(((EnergyUsageResult)localObject3).getPast24h().size() - (int)paramFloat1 - 1));
        localObject3 = this.z;
        if (localObject3 == null) {
          kotlin.jvm.internal.j.t("mViewBinding");
        }
        localObject3 = ((ActivityPlugPowerStatisticBinding)localObject3).y;
        kotlin.jvm.internal.j.d(localObject3, "mViewBinding.tvTime");
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject1);
        ((StringBuilder)localObject5).append(":30");
        ((StringBuilder)localObject5).append((String)localObject2);
        ((StringBuilder)localObject5).append(", MMM dd, yyyy");
        localObject1 = new SimpleDateFormat(((StringBuilder)localObject5).toString());
        kotlin.jvm.internal.j.d(localObject4, "calendar");
        ((TextView)localObject3).setText(((SimpleDateFormat)localObject1).format(((Calendar)localObject4).getTime()));
      }
      else
      {
        localObject4 = Calendar.getInstance();
        ((Calendar)localObject4).setTime(new Date(((EnergyUsageResult)localObject3).getLocalTimeInMS()));
        ((Calendar)localObject4).add(5, 1);
        ((Calendar)localObject4).set(11, 0);
        ((Calendar)localObject4).add(10, -(((EnergyUsageResult)localObject3).getPast7dCount() - (int)paramFloat1));
        localObject3 = this.z;
        if (localObject3 == null) {
          kotlin.jvm.internal.j.t("mViewBinding");
        }
        localObject3 = ((ActivityPlugPowerStatisticBinding)localObject3).y;
        kotlin.jvm.internal.j.d(localObject3, "mViewBinding.tvTime");
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject1);
        ((StringBuilder)localObject5).append(":30");
        ((StringBuilder)localObject5).append((String)localObject2);
        ((StringBuilder)localObject5).append(", MMM dd, yyyy");
        localObject1 = new SimpleDateFormat(((StringBuilder)localObject5).toString());
        kotlin.jvm.internal.j.d(localObject4, "calendar");
        ((TextView)localObject3).setText(((SimpleDateFormat)localObject1).format(((Calendar)localObject4).getTime()));
      }
    }
  }
  
  private final void k1()
  {
    boolean bool = o0.p(this);
    if (bool != this.K3)
    {
      this.K3 = bool;
      Object localObject = l1();
      kotlin.jvm.internal.j.d(localObject, "mLineChart");
      if (((Chart)localObject).getHighlighted() != null)
      {
        PowerLineChart localPowerLineChart = l1();
        localObject = l1();
        kotlin.jvm.internal.j.d(localObject, "mLineChart");
        localObject = ((Chart)localObject).getHighlighted();
        if (localObject != null) {
          localObject = (Highlight)e.l((Object[])localObject, 0);
        } else {
          localObject = null;
        }
        localPowerLineChart.highlightValue((Highlight)localObject, true);
      }
      else
      {
        A1();
      }
    }
  }
  
  private final PowerLineChart l1()
  {
    return (PowerLineChart)this.p0.getValue();
  }
  
  private final CardView m1()
  {
    return (CardView)this.p1.getValue();
  }
  
  private final PlugEnergyMonitorViewModel n1()
  {
    return (PlugEnergyMonitorViewModel)this.p3.getValue();
  }
  
  private final String o1()
  {
    return (String)this.p2.getValue();
  }
  
  private final void p1()
  {
    l1().setOnChartValueSelectedListener(this);
    YAxis localYAxis = l1().getYAxis();
    kotlin.jvm.internal.j.d(localYAxis, "mLineChart.yAxis");
    localYAxis.setValueFormatter(new a());
    l1().setOnDrawHighlightLineListener(new d(this));
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
    this.y = ((String)localObject);
  }
  
  private final void r1()
  {
    b1(2131953387);
    ActivityPlugPowerStatisticBinding localActivityPlugPowerStatisticBinding = this.z;
    if (localActivityPlugPowerStatisticBinding == null) {
      kotlin.jvm.internal.j.t("mViewBinding");
    }
    localActivityPlugPowerStatisticBinding.q.addOnTabSelectedListener(new e(this));
    p1();
  }
  
  private final boolean s1()
  {
    Object localObject = this.z;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewBinding");
    }
    localObject = ((ActivityPlugPowerStatisticBinding)localObject).q;
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
      i.l(this.y);
    } else {
      i.m(this.y);
    }
  }
  
  private final void u1(float paramFloat)
  {
    CardView localCardView = m1();
    kotlin.jvm.internal.j.d(localCardView, "mMarkerView");
    Object localObject = m1();
    kotlin.jvm.internal.j.d(localObject, "mMarkerView");
    paramFloat = Math.max(paramFloat - ((FrameLayout)localObject).getWidth() / 2.0F, 0.0F);
    localObject = l1();
    kotlin.jvm.internal.j.d(localObject, "mLineChart");
    int i = ((ViewGroup)localObject).getWidth();
    localObject = m1();
    kotlin.jvm.internal.j.d(localObject, "mMarkerView");
    localCardView.setTranslationX(Math.min(paramFloat, i - ((FrameLayout)localObject).getWidth()));
  }
  
  private final float v1(int paramInt)
  {
    float f1 = paramInt;
    float f2 = f1;
    if (f1 < 0.1F) {
      f2 = 0.0F;
    }
    return f2;
  }
  
  private final void w1(boolean paramBoolean)
  {
    Object localObject = m1();
    kotlin.jvm.internal.j.d(localObject, "mMarkerView");
    ((CardView)localObject).setCardElevation(0.0F);
    m1().animate().translationX(0.0F).start();
    if (paramBoolean)
    {
      localObject = this.z;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewBinding");
      }
      localObject = ((ActivityPlugPowerStatisticBinding)localObject).x;
      kotlin.jvm.internal.j.d(localObject, "mViewBinding.tvPower");
      ((TextView)localObject).setText("--");
      localObject = this.z;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewBinding");
      }
      localObject = ((ActivityPlugPowerStatisticBinding)localObject).y;
      kotlin.jvm.internal.j.d(localObject, "mViewBinding.tvTime");
      ((TextView)localObject).setText("--");
    }
    else
    {
      localObject = this.H3;
      if (localObject != null) {
        B1(-1.0F, ((EnergyUsageResult)localObject).getCurrentPower() / 1000.0F, true, false);
      }
    }
  }
  
  private final void x1(TextView paramTextView, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramString2);
    paramString2 = new SpannableString(((StringBuilder)localObject).toString());
    RelativeSizeSpan localRelativeSizeSpan = new RelativeSizeSpan(1.6F);
    localObject = new StyleSpan(1);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan((int)4281545523L);
    paramString2.setSpan(localRelativeSizeSpan, 0, paramString1.length(), 33);
    paramString2.setSpan(localObject, 0, paramString1.length(), 33);
    paramString2.setSpan(localForegroundColorSpan, 0, paramString1.length(), 33);
    paramString1 = kotlin.p.a;
    paramTextView.setText(paramString2);
  }
  
  private final void y1()
  {
    n1().h().observe(this, new i(this));
  }
  
  private final void z1()
  {
    w1(true);
    A1();
    t1();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558608);
    kotlin.jvm.internal.j.d(paramBundle, "DataBindingUtil.setConte…ity_plug_power_statistic)");
    this.z = ((ActivityPlugPowerStatisticBinding)paramBundle);
    q1();
    r1();
    y1();
    this.K3 = o0.p(this);
  }
  
  public void onNothingSelected()
  {
    w1(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    n1().f();
    k1();
  }
  
  public void onValueSelected(Entry paramEntry, Highlight paramHighlight)
  {
    if (paramEntry != null) {
      B1(paramEntry.getX(), paramEntry.getY(), false, true);
    }
  }
  
  private static final class a
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
      localCalendar.add(10, -(this.b - (int)paramFloat - 1));
      Object localObject = new SimpleDateFormat("dd");
      kotlin.jvm.internal.j.d(localCalendar, "calendar");
      localObject = ((SimpleDateFormat)localObject).format(localCalendar.getTime());
      kotlin.jvm.internal.j.d(localObject, "SimpleDateFormat(\"dd\").format(calendar.time)");
      return (String)localObject;
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
      ((Calendar)localObject).add(10, -(this.b - (int)paramFloat - 1));
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("kk:30");
      kotlin.jvm.internal.j.d(localObject, "calendar");
      localObject = localSimpleDateFormat.format(((Calendar)localObject).getTime());
      kotlin.jvm.internal.j.d(localObject, "SimpleDateFormat(\"kk:30\").format(calendar.time)");
      return (String)localObject;
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.l<Float, kotlin.p>
  {
    d(PlugPowerStatisticActivity paramPlugPowerStatisticActivity)
    {
      super();
    }
    
    public final void a(float paramFloat)
    {
      PlugPowerStatisticActivity.g1(this.c, paramFloat);
    }
  }
  
  public static final class e
    implements TabLayout.OnTabSelectedListener
  {
    e(PlugPowerStatisticActivity paramPlugPowerStatisticActivity) {}
    
    public void onTabReselected(TabLayout.Tab paramTab) {}
    
    public void onTabSelected(TabLayout.Tab paramTab)
    {
      PlugPowerStatisticActivity.i1(this.a);
    }
    
    public void onTabUnselected(TabLayout.Tab paramTab) {}
  }
  
  static final class f
    extends Lambda
    implements a<PowerLineChart>
  {
    f(PlugPowerStatisticActivity paramPlugPowerStatisticActivity)
    {
      super();
    }
    
    public final PowerLineChart a()
    {
      return PlugPowerStatisticActivity.f1(this.c).d;
    }
  }
  
  static final class g
    extends Lambda
    implements a<CardView>
  {
    g(PlugPowerStatisticActivity paramPlugPowerStatisticActivity)
    {
      super();
    }
    
    public final CardView a()
    {
      return PlugPowerStatisticActivity.f1(this.c).f;
    }
  }
  
  static final class h
    extends Lambda
    implements a<PlugEnergyMonitorViewModel>
  {
    h(PlugPowerStatisticActivity paramPlugPowerStatisticActivity)
    {
      super();
    }
    
    public final PlugEnergyMonitorViewModel a()
    {
      PlugPowerStatisticActivity localPlugPowerStatisticActivity = this.c;
      return (PlugEnergyMonitorViewModel)new ViewModelProvider(localPlugPowerStatisticActivity, new IoTViewModelFactory(localPlugPowerStatisticActivity, PlugPowerStatisticActivity.e1(localPlugPowerStatisticActivity))).get(PlugEnergyMonitorViewModel.class);
    }
  }
  
  static final class i<T>
    implements Observer<EnergyUsageResult>
  {
    i(PlugPowerStatisticActivity paramPlugPowerStatisticActivity) {}
    
    public final void a(EnergyUsageResult paramEnergyUsageResult)
    {
      PlugPowerStatisticActivity.h1(this.a, paramEnergyUsageResult);
      PlugPowerStatisticActivity.j1(this.a);
    }
  }
  
  static final class j
    extends Lambda
    implements a<String>
  {
    j(PlugPowerStatisticActivity paramPlugPowerStatisticActivity)
    {
      super();
    }
    
    public final String a()
    {
      String str = this.c.getString(2131953409);
      kotlin.jvm.internal.j.d(str, "getString(R.string.power_unit_W)");
      return str;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\energymonitor\PlugPowerStatisticActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */