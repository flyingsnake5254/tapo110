package com.tplink.iot.devices.switches.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.q;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBinding;
import com.tplink.iot.databinding.LayoutSwitchDetailBottomExtBinding;
import com.tplink.iot.databinding.LayoutSwitchDetailContentExtBinding;
import com.tplink.iot.devicecommon.feature.NextEventFeature;
import com.tplink.iot.devicecommon.feature.NextEventFeature.a;
import com.tplink.iot.devicecommon.view.IoTDetailBaseActivity;
import com.tplink.iot.devices.switches.viewmodel.SwitchDetailViewModel;
import com.tplink.iot.g.c.a.b;
import com.tplink.iot.view.feature.AwayModeActivity;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.widget.DiffuseViewV2;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.j;

public final class SwitchDetailActivity
  extends IoTDetailBaseActivity<LayoutSwitchDetailContentExtBinding, LayoutSwitchDetailBottomExtBinding, SwitchDetailViewModel>
{
  public static final a K3 = new a(null);
  private long L3;
  private final com.tplink.iot.devicecommon.feature.a M3 = new com.tplink.iot.devicecommon.feature.a();
  private boolean N3 = true;
  
  public SwitchDetailActivity()
  {
    super(SwitchDetailViewModel.class);
  }
  
  private final void Q1(int paramInt)
  {
    if (this.N3)
    {
      this.N3 = false;
      return;
    }
    if (paramInt >= 3) {
      this.M3.b(this, p1());
    }
  }
  
  public static final void R1(Context paramContext, String paramString)
  {
    K3.a(paramContext, paramString);
  }
  
  private final void S1()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    j.d(localFragmentManager, "supportFragmentManager");
    b.e(localFragmentManager, p1());
  }
  
  private final void T1()
  {
    long l = System.currentTimeMillis();
    if (l - this.L3 < 'Ǵ') {
      return;
    }
    this.L3 = l;
    boolean bool = ((SwitchDetailViewModel)v1()).X().get() ^ true;
    u0.a(this, 200L);
    if (bool)
    {
      q.a(this, q1().p3, 2131690258, 2131690259, 800);
      ((LayoutSwitchDetailContentExtBinding)t1()).c.b();
    }
    else
    {
      q1().p3.setBackgroundResource(2131690258);
      ((LayoutSwitchDetailContentExtBinding)t1()).c.c();
    }
    ((SwitchDetailViewModel)v1()).Y(bool);
    i.y(u1(), bool);
  }
  
  private final void U1()
  {
    if (((SwitchDetailViewModel)v1()).X().get())
    {
      q1().p3.setBackgroundResource(2131690259);
      ((LayoutSwitchDetailContentExtBinding)t1()).d.setImageResource(2131690067);
    }
    else
    {
      ((LayoutSwitchDetailContentExtBinding)t1()).c.c();
      q1().p3.setBackgroundResource(2131690258);
      ((LayoutSwitchDetailContentExtBinding)t1()).d.setImageResource(2131690066);
    }
  }
  
  public void A1()
  {
    super.A1();
    ((LayoutSwitchDetailContentExtBinding)t1()).c.setIsAutoStop(true);
    ImageView localImageView = q1().p1;
    j.d(localImageView, "mBinding.imgMoreLocal");
    localImageView.setVisibility(8);
    NextEventFeature.c.a(this, ((LayoutSwitchDetailBottomExtBinding)s1()).y).f(((SwitchDetailViewModel)v1()).U());
    new com.tplink.iot.widget.i.a(0.0F, 0L, 3, null).c(((LayoutSwitchDetailContentExtBinding)t1()).d);
    d0.h(((LayoutSwitchDetailContentExtBinding)t1()).y, getString(2131954179), ContextCompat.getColor(this, 2131099811), new b(this));
  }
  
  public void B1()
  {
    ((SwitchDetailViewModel)v1()).Z(false);
  }
  
  public void J1()
  {
    super.J1();
    ((SwitchDetailViewModel)v1()).O().observe(this, new c(this));
    ((SwitchDetailViewModel)v1()).R().observe(this, new d(this));
    ((SwitchDetailViewModel)v1()).V().observe(this, new e(this));
  }
  
  public int h1()
  {
    return 2131559235;
  }
  
  public int i1()
  {
    LinearLayout localLinearLayout = ((LayoutSwitchDetailBottomExtBinding)s1()).q;
    j.d(localLinearLayout, "mBottomExtBinding.llRules");
    int i = localLinearLayout.getMeasuredHeight();
    localLinearLayout = ((LayoutSwitchDetailBottomExtBinding)s1()).x;
    j.d(localLinearLayout, "mBottomExtBinding.llRules2");
    return i + localLinearLayout.getMeasuredHeight();
  }
  
  public int j1()
  {
    return 2131559236;
  }
  
  public Class<SwitchSettingsActivity> k1()
  {
    return SwitchSettingsActivity.class;
  }
  
  public String l1()
  {
    String str = getString(2131954191);
    j.d(str, "getString(R.string.switch_param)");
    return str;
  }
  
  public String m1()
  {
    String str = getString(2131952883);
    j.d(str, "getString(R.string.iot_switches)");
    return str;
  }
  
  public EnumFeedbackCategory n1(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "device");
    return EnumFeedbackCategory.SWITCH;
  }
  
  public void onClick(View paramView)
  {
    Integer localInteger;
    if (paramView != null) {
      localInteger = Integer.valueOf(paramView.getId());
    } else {
      localInteger = null;
    }
    if (((localInteger != null) && (localInteger.intValue() == 2131363113)) || ((localInteger != null) && (localInteger.intValue() == 2131364615))) {
      ScheduleListActivity.o1(this, u1(), false);
    } else if (((localInteger != null) && (localInteger.intValue() == 2131363000)) || ((localInteger != null) && (localInteger.intValue() == 2131364348))) {
      X0(AwayModeActivity.class, u1());
    } else if (((localInteger != null) && (localInteger.intValue() == 2131363144)) || ((localInteger != null) && (localInteger.intValue() == 2131364673))) {
      X0(TimerActivity.class, u1());
    } else if (((localInteger != null) && (localInteger.intValue() == 2131363139)) || ((localInteger != null) && (localInteger.intValue() == 2131363343))) {
      T1();
    } else if ((localInteger == null) || (localInteger.intValue() != 2131362192)) {
      super.onClick(paramView);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((SwitchDetailViewModel)v1()).Z(true);
  }
  
  protected void onPause()
  {
    ((LayoutSwitchDetailContentExtBinding)t1()).c.c();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    ((SwitchDetailViewModel)v1()).Q();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, SwitchDetailActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b
    implements d0.g
  {
    b(SwitchDetailActivity paramSwitchDetailActivity) {}
    
    public final void a()
    {
      SwitchDetailActivity.O1(this.a);
    }
  }
  
  static final class c<T>
    implements Observer<IoTSubDevice>
  {
    c(SwitchDetailActivity paramSwitchDetailActivity) {}
    
    public final void a(IoTSubDevice paramIoTSubDevice)
    {
      if (paramIoTSubDevice != null)
      {
        SwitchDetailActivity.M1(this.a).X().set(paramIoTSubDevice.isDeviceOn());
        SwitchDetailActivity.P1(this.a);
      }
    }
  }
  
  static final class d<T>
    implements Observer<ThingUsage>
  {
    d(SwitchDetailActivity paramSwitchDetailActivity) {}
    
    public final void a(ThingUsage paramThingUsage)
    {
      if (paramThingUsage != null) {
        SwitchDetailActivity.L1(this.a).z.o(paramThingUsage);
      }
    }
  }
  
  static final class e<T>
    implements Observer<Integer>
  {
    e(SwitchDetailActivity paramSwitchDetailActivity) {}
    
    public final void a(Integer paramInteger)
    {
      if (paramInteger != null) {
        SwitchDetailActivity.N1(this.a, paramInteger.intValue());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\switches\view\SwitchDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */