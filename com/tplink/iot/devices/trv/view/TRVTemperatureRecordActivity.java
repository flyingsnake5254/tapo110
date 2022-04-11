package com.tplink.iot.devices.trv.view;

import android.annotation.SuppressLint;
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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.tplink.iot.Utils.extension.b;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvTemperatureRecordBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.iot.devices.trv.view.chart.TemperatureRecordChart;
import com.tplink.iot.devices.trv.viewmodel.TRVDetailViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.TRVTemperatureRecordsResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import kotlin.collections.e;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

public final class TRVTemperatureRecordActivity
  extends IoTMVVMBaseActivity<ActivityTrvTemperatureRecordBinding>
  implements OnChartValueSelectedListener
{
  private boolean H3;
  private boolean I3;
  private TRVTemperatureRecordsResult J3;
  private EnumTemperatureUnit K3 = EnumTemperatureUnit.CELSIUS;
  private int L3;
  private TimeZone M3;
  private boolean N3;
  private final f p0 = h.b(new e(this));
  private final f p1 = h.b(new c(this));
  private final f p2 = h.b(new d(this));
  private boolean p3;
  
  public TRVTemperatureRecordActivity()
  {
    TimeZone localTimeZone = TimeZone.getDefault();
    kotlin.jvm.internal.j.d(localTimeZone, "TimeZone.getDefault()");
    this.M3 = localTimeZone;
  }
  
  private final CardView A1()
  {
    return (CardView)this.p2.getValue();
  }
  
  private final TRVDetailViewModel B1()
  {
    return (TRVDetailViewModel)this.p0.getValue();
  }
  
  private final boolean C1()
  {
    TabLayout localTabLayout = ((ActivityTrvTemperatureRecordBinding)f1()).q;
    kotlin.jvm.internal.j.d(localTabLayout, "mBinding.tempTabLayout");
    boolean bool;
    if (localTabLayout.getSelectedTabPosition() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final void D1(float paramFloat)
  {
    CardView localCardView1 = A1();
    kotlin.jvm.internal.j.d(localCardView1, "mMarkerView");
    CardView localCardView2 = A1();
    kotlin.jvm.internal.j.d(localCardView2, "mMarkerView");
    paramFloat = Math.max(paramFloat - localCardView2.getWidth() / 2.0F, 0.0F);
    int i = z1().getWidth();
    localCardView2 = A1();
    kotlin.jvm.internal.j.d(localCardView2, "mMarkerView");
    localCardView1.setTranslationX(Math.min(paramFloat, i - localCardView2.getWidth()));
  }
  
  private final void E1(boolean paramBoolean)
  {
    Object localObject = A1();
    kotlin.jvm.internal.j.d(localObject, "mMarkerView");
    ((CardView)localObject).setCardElevation(0.0F);
    A1().animate().translationX(0.0F).start();
    if (paramBoolean)
    {
      localObject = ((ActivityTrvTemperatureRecordBinding)f1()).x;
      kotlin.jvm.internal.j.d(localObject, "mBinding.tvTemperature");
      ((TextView)localObject).setText("--");
      localObject = ((ActivityTrvTemperatureRecordBinding)f1()).y;
      kotlin.jvm.internal.j.d(localObject, "mBinding.tvTime");
      ((TextView)localObject).setText("--");
    }
    else
    {
      localObject = this.J3;
      if (localObject != null) {
        I1(-1.0F, ((TRVTemperatureRecordsResult)localObject).getCurrentTemp(), true, false);
      }
    }
  }
  
  private final void F1(TextView paramTextView, String paramString1, String paramString2)
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
    paramString1 = p.a;
    paramTextView.setText(paramString2);
  }
  
  private final void G1()
  {
    E1(true);
    H1();
  }
  
  private final void H1()
  {
    Object localObject = this.J3;
    if (localObject != null)
    {
      z1().clear();
      z1().setTemperatureUnit(this.K3);
      List localList1;
      List localList2;
      int i;
      int j;
      if (C1())
      {
        localList1 = ((TRVTemperatureRecordsResult)localObject).getToday();
        if (localList1 != null)
        {
          localList2 = ((TRVTemperatureRecordsResult)localObject).getTodayStatus();
          if (localList2 != null)
          {
            i = Math.min(localList1.size(), localList2.size());
            localObject = new ArrayList();
            for (j = 0; j < i; j++) {
              if (((Number)localList1.get(j)).intValue() != 65336) {
                ((List)localObject).add(new BarEntry(j, ((Number)localList1.get(j)).intValue(), localList2.get(j)));
              }
            }
            z1().e((List)localObject, this.p3 ^ true);
            E1(false);
            this.p3 = true;
            return;
          }
        }
      }
      else
      {
        localList1 = ((TRVTemperatureRecordsResult)localObject).getYesterday();
        if (localList1 != null)
        {
          localList2 = ((TRVTemperatureRecordsResult)localObject).getYesterdayStatus();
          if (localList2 != null)
          {
            i = Math.min(localList1.size(), localList2.size());
            localObject = new ArrayList();
            for (j = 0; j < i; j++) {
              if (((Number)localList1.get(j)).intValue() != 65336) {
                ((List)localObject).add(new BarEntry(j, ((Number)localList1.get(j)).intValue(), localList2.get(j)));
              }
            }
            z1().e((List)localObject, this.H3 ^ true);
            E1(false);
            this.H3 = true;
          }
        }
      }
    }
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private final void I1(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = A1();
    kotlin.jvm.internal.j.d(localObject1, "mMarkerView");
    float f;
    if (paramBoolean2) {
      f = com.tplink.iot.Utils.j.a(this, 4.0F);
    } else {
      f = 0.0F;
    }
    ((CardView)localObject1).setCardElevation(f);
    Object localObject2;
    if ((paramBoolean1) && (this.N3))
    {
      localObject1 = ((ActivityTrvTemperatureRecordBinding)f1()).x;
      kotlin.jvm.internal.j.d(localObject1, "mBinding.tvTemperature");
      ((TextView)localObject1).setText("--");
    }
    else
    {
      int i = (int)paramFloat2;
      if (i == paramFloat2)
      {
        localObject1 = String.valueOf(i);
      }
      else
      {
        localObject1 = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(paramFloat2) }, 1));
        kotlin.jvm.internal.j.d(localObject1, "java.lang.String.format(this, *args)");
      }
      localObject2 = ((ActivityTrvTemperatureRecordBinding)f1()).x;
      kotlin.jvm.internal.j.d(localObject2, "mBinding.tvTemperature");
      F1((TextView)localObject2, (String)localObject1, this.K3.getUnitText());
    }
    Object localObject3 = this.J3;
    if (localObject3 != null)
    {
      paramBoolean2 = this.I3;
      if (paramBoolean2) {
        localObject1 = "H";
      } else {
        localObject1 = "h";
      }
      if (paramBoolean2) {
        localObject2 = "";
      } else {
        localObject2 = " a";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(":mm");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(", MMM dd, yyyy");
      localObject1 = localStringBuilder.toString();
      if (paramBoolean1)
      {
        ((ActivityTrvTemperatureRecordBinding)f1()).z.setText(2131954312);
        localObject2 = ((ActivityTrvTemperatureRecordBinding)f1()).y;
        kotlin.jvm.internal.j.d(localObject2, "mBinding.tvTime");
        ((TextView)localObject2).setText(b.d(new Date(b.e(((TRVTemperatureRecordsResult)localObject3).getLocalTime())), (String)localObject1, this.M3, null, 4, null));
      }
      else
      {
        ((ActivityTrvTemperatureRecordBinding)f1()).z.setText(2131954306);
        localObject2 = Calendar.getInstance(this.M3);
        ((Calendar)localObject2).setTime(new Date(b.e(((TRVTemperatureRecordsResult)localObject3).getLocalTime())));
        ((Calendar)localObject2).set(11, 0);
        ((Calendar)localObject2).set(12, 0);
        ((Calendar)localObject2).set(13, 0);
        ((Calendar)localObject2).add(12, (int)paramFloat1 * 30);
        ((Calendar)localObject2).add(5, y1());
        localObject3 = ((ActivityTrvTemperatureRecordBinding)f1()).y;
        kotlin.jvm.internal.j.d(localObject3, "mBinding.tvTime");
        kotlin.jvm.internal.j.d(localObject2, "calendar");
        localObject2 = ((Calendar)localObject2).getTime();
        kotlin.jvm.internal.j.d(localObject2, "calendar.time");
        ((TextView)localObject3).setText(b.d((Date)localObject2, (String)localObject1, this.M3, null, 4, null));
      }
    }
  }
  
  private final void x1()
  {
    boolean bool = o0.p(this);
    if (bool != this.I3)
    {
      this.I3 = bool;
      if (z1().getHighlighted() != null)
      {
        TemperatureRecordChart localTemperatureRecordChart = z1();
        Object localObject = z1().getHighlighted();
        if (localObject != null) {
          localObject = (Highlight)e.l((Object[])localObject, 0);
        } else {
          localObject = null;
        }
        localTemperatureRecordChart.highlightValue((Highlight)localObject, true);
      }
      else
      {
        H1();
      }
    }
  }
  
  private final int y1()
  {
    int i;
    if (!C1()) {
      i = -1;
    } else {
      i = 0;
    }
    return i;
  }
  
  private final TemperatureRecordChart z1()
  {
    return (TemperatureRecordChart)this.p1.getValue();
  }
  
  public int e1()
  {
    return 2131558702;
  }
  
  public void j1()
  {
    b1(2131954350);
    ((ActivityTrvTemperatureRecordBinding)f1()).q.addOnTabSelectedListener(new a(this));
    z1().setOnChartValueSelectedListener(this);
    z1().setOnDrawHighlightLineListener(new b(this));
  }
  
  public void l1() {}
  
  public void m1()
  {
    B1().W().observe(this, new f(this));
    B1().X().observe(this, new g(this));
    B1().i().observe(this, new h(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.I3 = o0.p(this);
    B1().V();
  }
  
  public void onNothingSelected()
  {
    E1(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    x1();
  }
  
  public void onValueSelected(Entry paramEntry, Highlight paramHighlight)
  {
    if (paramEntry != null)
    {
      float f = kotlin.s.a.b(paramEntry.getY());
      I1(paramEntry.getX(), f, false, true);
    }
  }
  
  public static final class a
    implements TabLayout.OnTabSelectedListener
  {
    a(TRVTemperatureRecordActivity paramTRVTemperatureRecordActivity) {}
    
    public void onTabReselected(TabLayout.Tab paramTab) {}
    
    public void onTabSelected(TabLayout.Tab paramTab)
    {
      TRVTemperatureRecordActivity.v1(this.a);
    }
    
    public void onTabUnselected(TabLayout.Tab paramTab) {}
  }
  
  static final class b
    extends Lambda
    implements l<Float, p>
  {
    b(TRVTemperatureRecordActivity paramTRVTemperatureRecordActivity)
    {
      super();
    }
    
    public final void a(float paramFloat)
    {
      TRVTemperatureRecordActivity.p1(this.c, paramFloat);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<TemperatureRecordChart>
  {
    c(TRVTemperatureRecordActivity paramTRVTemperatureRecordActivity)
    {
      super();
    }
    
    public final TemperatureRecordChart a()
    {
      TemperatureRecordChart localTemperatureRecordChart = TRVTemperatureRecordActivity.n1(this.c).f;
      kotlin.jvm.internal.j.d(localTemperatureRecordChart, "mBinding.tempLineChart");
      return localTemperatureRecordChart;
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<CardView>
  {
    d(TRVTemperatureRecordActivity paramTRVTemperatureRecordActivity)
    {
      super();
    }
    
    public final CardView a()
    {
      return TRVTemperatureRecordActivity.n1(this.c).d;
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<TRVDetailViewModel>
  {
    e(TRVTemperatureRecordActivity paramTRVTemperatureRecordActivity)
    {
      super();
    }
    
    public final TRVDetailViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVTemperatureRecordActivity.o1((TRVTemperatureRecordActivity)localObject))).get(TRVDetailViewModel.class);
      kotlin.jvm.internal.j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVDetailViewModel)localObject;
    }
  }
  
  static final class f<T>
    implements Observer<TRVTemperatureRecordsResult>
  {
    f(TRVTemperatureRecordActivity paramTRVTemperatureRecordActivity) {}
    
    public final void a(TRVTemperatureRecordsResult paramTRVTemperatureRecordsResult)
    {
      TRVTemperatureRecordActivity.t1(this.a, paramTRVTemperatureRecordsResult);
      TRVTemperatureRecordActivity.w1(this.a);
    }
  }
  
  static final class g<T>
    implements Observer<IoTSubDevice>
  {
    g(TRVTemperatureRecordActivity paramTRVTemperatureRecordActivity) {}
    
    public final void a(IoTSubDevice paramIoTSubDevice)
    {
      Object localObject = this.a;
      boolean bool1 = false;
      int i;
      if (paramIoTSubDevice != null) {
        i = paramIoTSubDevice.getTempOffset();
      } else {
        i = 0;
      }
      TRVTemperatureRecordActivity.s1((TRVTemperatureRecordActivity)localObject, i);
      TRVTemperatureRecordActivity localTRVTemperatureRecordActivity = this.a;
      if (paramIoTSubDevice != null)
      {
        localObject = paramIoTSubDevice.getEnumTempUnit();
        if (localObject != null) {}
      }
      else
      {
        localObject = EnumTemperatureUnit.CELSIUS;
      }
      TRVTemperatureRecordActivity.u1(localTRVTemperatureRecordActivity, (EnumTemperatureUnit)localObject);
      localObject = this.a;
      boolean bool2 = bool1;
      if (paramIoTSubDevice != null)
      {
        paramIoTSubDevice = paramIoTSubDevice.getTrvStates();
        bool2 = bool1;
        if (paramIoTSubDevice != null) {
          bool2 = paramIoTSubDevice.contains(EnumTRVState.SHUTDOWN);
        }
      }
      TRVTemperatureRecordActivity.r1((TRVTemperatureRecordActivity)localObject, bool2);
      TRVTemperatureRecordActivity.w1(this.a);
    }
  }
  
  static final class h<T>
    implements Observer<BaseALIoTDevice<?>>
  {
    h(TRVTemperatureRecordActivity paramTRVTemperatureRecordActivity) {}
    
    public final void a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      TRVTemperatureRecordActivity localTRVTemperatureRecordActivity = this.a;
      if (paramBaseALIoTDevice != null) {
        paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceRegion();
      } else {
        paramBaseALIoTDevice = null;
      }
      paramBaseALIoTDevice = p0.d(paramBaseALIoTDevice);
      kotlin.jvm.internal.j.d(paramBaseALIoTDevice, "TimeTransformUtilV2.getD…imeZone(it?.deviceRegion)");
      TRVTemperatureRecordActivity.q1(localTRVTemperatureRecordActivity, paramBaseALIoTDevice);
      TRVTemperatureRecordActivity.w1(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVTemperatureRecordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */