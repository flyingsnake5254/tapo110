package com.tplink.iot.widget.plug;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.collections.z;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.v.e;

public final class EnergyMonitoringView
  extends FrameLayout
  implements View.OnClickListener
{
  private final String H3;
  private l<? super Integer, kotlin.p> I3;
  private View c;
  private View d;
  private TabLayout f;
  private TextView p0;
  private TextView p1;
  private final String p2;
  private final String p3;
  private ViewPager q;
  private TextView x;
  private TextView y;
  private TextView z;
  
  public EnergyMonitoringView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public EnergyMonitoringView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public EnergyMonitoringView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.getString(2131953408);
    j.d(paramAttributeSet, "context.getString(R.string.power_unit)");
    this.p2 = paramAttributeSet;
    paramAttributeSet = paramContext.getString(2131953409);
    j.d(paramAttributeSet, "context.getString(R.string.power_unit_W)");
    this.p3 = paramAttributeSet;
    paramAttributeSet = paramContext.getString(2131954286);
    j.d(paramAttributeSet, "context.getString(R.string.time_h)");
    this.H3 = paramAttributeSet;
    paramAttributeSet = LayoutInflater.from(paramContext);
    paramAttributeSet.inflate(2131559418, this, true);
    paramContext = paramAttributeSet.inflate(2131559417, this, false);
    Object localObject = paramContext.findViewById(2131363638);
    j.d(localObject, "findViewById<View>(R.id.pem_ll_runtime)");
    ((View)localObject).setVisibility(8);
    localObject = kotlin.p.a;
    j.d(paramContext, "inflater.inflate(R.layou…ity = View.GONE\n        }");
    this.c = paramContext;
    paramContext = paramAttributeSet.inflate(2131559417, this, false);
    paramAttributeSet = paramContext.findViewById(2131363637);
    j.d(paramAttributeSet, "findViewById<View>(R.id.pem_ll_energy)");
    paramAttributeSet.setVisibility(8);
    j.d(paramContext, "inflater.inflate(R.layou…ity = View.GONE\n        }");
    this.d = paramContext;
    paramContext = findViewById(2131363642);
    j.d(paramContext, "findViewById(R.id.pem_tab_layout)");
    this.f = ((TabLayout)paramContext);
    paramContext = findViewById(2131363646);
    j.d(paramContext, "findViewById(R.id.pem_viewpager)");
    this.q = ((ViewPager)paramContext);
    f();
    g();
  }
  
  private final String c(int paramInt)
  {
    Object localObject = kotlin.jvm.internal.p.a;
    localObject = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(paramInt / 60.0F) }, 1));
    j.d(localObject, "java.lang.String.format(format, *args)");
    return (String)localObject;
  }
  
  private final String d(int paramInt)
  {
    float f1 = paramInt / 1000.0F;
    Object localObject;
    if (f1 < 0.1F)
    {
      localObject = "<0.1";
    }
    else
    {
      localObject = kotlin.jvm.internal.p.a;
      localObject = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(f1) }, 1));
      j.d(localObject, "java.lang.String.format(format, *args)");
    }
    return (String)localObject;
  }
  
  private final String e(int paramInt)
  {
    Object localObject = kotlin.jvm.internal.p.a;
    localObject = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(h(paramInt)) }, 1));
    j.d(localObject, "java.lang.String.format(format, *args)");
    return (String)localObject;
  }
  
  private final void f()
  {
    Object localObject1 = this.c;
    Objects.requireNonNull(localObject1, "null cannot be cast to non-null type android.view.ViewGroup");
    localObject1 = (ViewGroup)localObject1;
    Object localObject2 = ((ViewGroup)localObject1).findViewById(2131363630);
    j.d(localObject2, "findViewById(R.id.pem_electricity_today)");
    this.x = ((TextView)localObject2);
    localObject2 = ((ViewGroup)localObject1).findViewById(2131363629);
    j.d(localObject2, "findViewById(R.id.pem_electricity_month)");
    this.y = ((TextView)localObject2);
    localObject2 = ((ViewGroup)localObject1).findViewById(2131363628);
    j.d(localObject2, "findViewById(R.id.pem_electricity_current)");
    this.z = ((TextView)localObject2);
    localObject1 = (LinearLayout)((ViewGroup)localObject1).findViewById(2131363637);
    j.d(localObject1, "ll");
    localObject2 = e.i(0, ((LinearLayout)localObject1).getChildCount()).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinearLayout)localObject1).getChildAt(((z)localObject2).nextInt()).setOnClickListener(this);
    }
    localObject1 = this.d;
    Objects.requireNonNull(localObject1, "null cannot be cast to non-null type android.view.ViewGroup");
    localObject2 = (ViewGroup)localObject1;
    localObject1 = ((ViewGroup)localObject2).findViewById(2131363641);
    j.d(localObject1, "findViewById(R.id.pem_runtime_today)");
    this.p0 = ((TextView)localObject1);
    localObject1 = ((ViewGroup)localObject2).findViewById(2131363640);
    j.d(localObject1, "findViewById(R.id.pem_runtime_month)");
    this.p1 = ((TextView)localObject1);
  }
  
  private final void g()
  {
    PagerAdapter local1 = new PagerAdapter()
    {
      public void destroyItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt, Object paramAnonymousObject)
      {
        j.e(paramAnonymousViewGroup, "container");
        j.e(paramAnonymousObject, "object");
        paramAnonymousViewGroup.removeView((View)paramAnonymousObject);
      }
      
      public int getCount()
      {
        return 2;
      }
      
      public CharSequence getPageTitle(int paramAnonymousInt)
      {
        Context localContext;
        if (paramAnonymousInt == 0)
        {
          localContext = this.a.getContext();
          paramAnonymousInt = 2131954389;
        }
        else
        {
          localContext = this.a.getContext();
          paramAnonymousInt = 2131953388;
        }
        return localContext.getString(paramAnonymousInt);
      }
      
      public Object instantiateItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        j.e(paramAnonymousViewGroup, "container");
        View localView;
        if (paramAnonymousInt == 0) {
          localView = EnergyMonitoringView.a(this.a);
        } else {
          localView = EnergyMonitoringView.b(this.a);
        }
        paramAnonymousViewGroup.addView(localView);
        return localView;
      }
      
      public boolean isViewFromObject(View paramAnonymousView, Object paramAnonymousObject)
      {
        j.e(paramAnonymousView, "view");
        j.e(paramAnonymousObject, "object");
        return j.a(paramAnonymousView, paramAnonymousObject);
      }
    };
    this.q.setAdapter(local1);
    this.f.setupWithViewPager(this.q);
  }
  
  private final float h(int paramInt)
  {
    float f1 = paramInt / 1000.0F;
    float f2 = f1;
    if (f1 < 0.1F) {
      f2 = 0.0F;
    }
    return f2;
  }
  
  private final void i(TextView paramTextView, String paramString1, String paramString2)
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
  
  public final void j(EnergyUsageResult paramEnergyUsageResult)
  {
    if (paramEnergyUsageResult != null)
    {
      TextView localTextView = this.x;
      if (localTextView == null) {
        j.t("mTodayPowerTv");
      }
      i(localTextView, d(paramEnergyUsageResult.getTodayEnergy()), this.p2);
      localTextView = this.y;
      if (localTextView == null) {
        j.t("mMonthPowerTv");
      }
      i(localTextView, d(paramEnergyUsageResult.getMonthEnergy()), this.p2);
      localTextView = this.z;
      if (localTextView == null) {
        j.t("mCurrentPowerTv");
      }
      i(localTextView, e(paramEnergyUsageResult.getCurrentPower()), this.p3);
      localTextView = this.p0;
      if (localTextView == null) {
        j.t("mTodayRuntimeTv");
      }
      i(localTextView, c(paramEnergyUsageResult.getTodayRuntime()), this.H3);
      localTextView = this.p1;
      if (localTextView == null) {
        j.t("mMonthRuntimeTv");
      }
      i(localTextView, c(paramEnergyUsageResult.getMonthRuntime()), this.H3);
    }
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    l locall = this.I3;
    if (locall != null) {
      paramView = (kotlin.p)locall.invoke(Integer.valueOf(paramView.getId()));
    }
  }
  
  public final void setOnItemClickListener(l<? super Integer, kotlin.p> paraml)
  {
    j.e(paraml, "onClick");
    this.I3 = paraml;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\plug\EnergyMonitoringView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */