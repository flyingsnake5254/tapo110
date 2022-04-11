package com.tplink.iot.view.colorbulb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.d.a;
import com.tplink.iot.Utils.k;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseLocationActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.view.cloudconnect.CloudConnectGetStateActivity;
import com.tplink.iot.view.colorbulb.effect.LightEffectConfigActivity;
import com.tplink.iot.view.colorbulb.settings.ColorBulbSettingsActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.feature.AwayModeActivity;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.viewmodel.iotbulb.BulbDetailViewModel;
import com.tplink.iot.viewmodel.iotbulb.LightEffectViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.WaveView;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingNextEventView.d;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.iot.widget.colorbulb.ColorPointView;
import com.tplink.iot.widget.colorbulb.ColorPresetView;
import com.tplink.iot.widget.colorbulb.ColorPresetView.a;
import com.tplink.iot.widget.colorbulb.DetailBottomRuleViewV2;
import com.tplink.iot.widget.colorbulb.DetailBottomRuleViewV2.a;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.iot.widget.colorbulb.light.LightBgAnimView;
import com.tplink.iot.widget.colorbulb.light.LightBulbView;
import com.tplink.iot.widget.colorbulb.light.LightBulbView.d;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.yinglan.scrolllayout.ScrollLayout;
import com.yinglan.scrolllayout.ScrollLayout.Status;
import com.yinglan.scrolllayout.ScrollLayout.g;
import java.util.List;

public class ColorBulbDetailActivity
  extends BaseLocationActivity
  implements View.OnClickListener, LightBulbView.d, EditColorBulbPresetDialog.b, EditAutoDialog.a, DetailBottomRuleViewV2.a
{
  private ImageView H3;
  private CardView I3;
  private CardView J3;
  private TextView K3;
  private TextView L3;
  private TextView M3;
  private TextView N3;
  private TextView O3;
  private SimpleTextSwitcher P3;
  private LightBulbView Q3;
  private ColorPresetView R3;
  private TPSwitchCompat S3;
  private ScrollLayout T3;
  private View U3;
  private View V3;
  private ThingNextEventView W3;
  private ThingUsageView X3;
  private LottieAnimationView Y3;
  private DetailBottomRuleViewV2 Z3;
  private View a4;
  private View b4;
  private View c4;
  private String d4;
  private BulbDetailViewModel e4;
  private LightEffectViewModel f4;
  private IoTBulbDevice g4;
  private BaseALIoTDevice h4;
  private EditColorBulbPresetDialog i4 = null;
  private EditAutoDialog j4 = null;
  private List<LightStateBean> k4;
  private boolean l4 = false;
  private String m4;
  private ColorPresetView.a n4 = new d();
  private ViewGroup o4;
  private View p0;
  private ImageView p1;
  private ImageView p2;
  private ImageView p3;
  private View p4;
  private View q4;
  private WaveView r4;
  private ColorPointView s4;
  private TextView t4;
  private RelativeLayout.LayoutParams u4;
  private int v4 = 0;
  private LightBgAnimView z;
  
  private void L1()
  {
    Object localObject = this.r4;
    if (localObject != null) {
      ((WaveView)localObject).k();
    }
    localObject = this.p4;
    if (localObject != null)
    {
      this.o4.removeView((View)localObject);
      this.p4 = null;
    }
  }
  
  private String M1()
  {
    IoTBulbDevice localIoTBulbDevice = this.g4;
    if (localIoTBulbDevice != null) {
      return localIoTBulbDevice.getAutoMode();
    }
    return "light_track";
  }
  
  private int N1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.h4;
    int i;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceManagerInfo() != null) && (this.h4.getDeviceManagerInfo().getUserInfo() != null) && (this.h4.getDeviceManagerInfo().getUserInfo().size() > 1)) {
      i = this.h4.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  private void O1()
  {
    if (this.h4 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://www.tapo.com/app/#/faqList2?categoryType=");
      localStringBuilder.append(getString(2131951844));
      localStringBuilder.append(com.tplink.iot.model.about.d.a());
      HelpAndFeedbackActivity.k1(this, localStringBuilder.toString(), getString(2131952867), this.h4.getDeviceType(), this.h4.getDeviceModel(), EnumFeedbackCategory.BULB);
    }
  }
  
  private void P1()
  {
    this.R3.setOnColorPresetCheckedListener(this.n4);
    this.S3.setOnSwitchCheckedChangeListener(new k());
  }
  
  private void Q1()
  {
    this.z = ((LightBgAnimView)findViewById(2131362281));
    this.O3 = ((TextView)findViewById(2131364510));
    this.p1 = ((ImageView)findViewById(2131363002));
    this.p2 = ((ImageView)findViewById(2131363121));
    this.p3 = ((ImageView)findViewById(2131363106));
    this.I3 = ((CardView)findViewById(2131362192));
    this.J3 = ((CardView)findViewById(2131362196));
    this.K3 = ((TextView)findViewById(2131364536));
    this.L3 = ((TextView)findViewById(2131364515));
    this.M3 = ((TextView)findViewById(2131364376));
    this.P3 = ((SimpleTextSwitcher)findViewById(2131364199));
    this.Q3 = ((LightBulbView)findViewById(2131362157));
    this.R3 = ((ColorPresetView)findViewById(2131362292));
    this.a4 = findViewById(2131364819);
    this.S3 = ((TPSwitchCompat)findViewById(2131364126));
    this.T3 = ((ScrollLayout)findViewById(2131363972));
    this.V3 = findViewById(2131363879);
    this.U3 = findViewById(2131362908);
    this.N3 = ((TextView)findViewById(2131364573));
    this.H3 = ((ImageView)findViewById(2131363103));
    this.p0 = findViewById(2131363330);
    this.Q3.m(this.z, this.R3, this.P3);
    int i = k.a(this, 50.0F) + com.tplink.iot.view.quicksetup.base.d.A(this);
    Object localObject = this.a4.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.a4.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.T3.setMinOffset(i);
    this.T3.setOnScrollChangedListener(new i());
    this.p0.post(new c(this));
    localObject = (ThingNextEventView)findViewById(2131363543);
    this.W3 = ((ThingNextEventView)localObject);
    ((ThingNextEventView)localObject).setOnNextEventCallback(new j());
    this.X3 = ((ThingUsageView)findViewById(2131362421));
    this.b4 = findViewById(2131363182);
    this.c4 = findViewById(2131363181);
    this.Y3 = ((LottieAnimationView)findViewById(2131363388));
    localObject = (DetailBottomRuleViewV2)findViewById(2131362023);
    this.Z3 = ((DetailBottomRuleViewV2)localObject);
    ((DetailBottomRuleViewV2)localObject).setSupportLightEffect(this.e4.H());
    this.Z3.setOnBottomRuleClickListener(this);
    findViewById(2131364455).setOnClickListener(this);
    findViewById(2131364441).setOnClickListener(this);
    this.Q3.setOnBulbOperationListener(this);
    this.p1.setOnClickListener(this);
    this.p2.setOnClickListener(this);
    this.I3.setOnClickListener(this);
    findViewById(2131363103).setOnClickListener(this);
    this.U3.setOnClickListener(this);
    findViewById(2131362913).setOnClickListener(this);
    P1();
  }
  
  private boolean R1()
  {
    ALIoTDevice localALIoTDevice = com.tplink.iot.Utils.w0.a.b(this.d4);
    boolean bool;
    if ((localALIoTDevice != null) && (localALIoTDevice.getThingDevice() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean S1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.h4;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void Z1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ColorBulbDetailActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void a2(CloudConnectStateResult paramCloudConnectStateResult)
  {
    if (paramCloudConnectStateResult == null) {
      return;
    }
    int i = paramCloudConnectStateResult.getStatus();
    int j = 8;
    if (i == 0)
    {
      this.I3.setVisibility(8);
    }
    else
    {
      paramCloudConnectStateResult = this.I3;
      if (R1()) {
        j = 0;
      }
      paramCloudConnectStateResult.setVisibility(j);
    }
    this.I3.post(new c());
  }
  
  private void b2(int paramInt1, int paramInt2)
  {
    View localView = this.p4;
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = this.u4;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      this.o4.removeView(localView);
      this.o4.addView(this.p4);
    }
  }
  
  private void c2()
  {
    if (getSupportFragmentManager().findFragmentByTag("EditAutoDialog") != null) {
      return;
    }
    EditAutoDialog localEditAutoDialog = EditAutoDialog.G0(M1());
    this.j4 = localEditAutoDialog;
    localEditAutoDialog.show(getSupportFragmentManager(), "EditAutoDialog");
    this.j4.I0(this);
  }
  
  private void d2(int paramInt, LightStateBean paramLightStateBean)
  {
    if (getSupportFragmentManager().findFragmentByTag("EditColorBulbPresetDialog") != null) {
      return;
    }
    paramLightStateBean = EditColorBulbPresetDialog.I0(true, paramInt, paramLightStateBean);
    this.i4 = paramLightStateBean;
    paramLightStateBean.show(getSupportFragmentManager(), "EditColorBulbPresetDialog");
    this.i4.J0(this);
  }
  
  private void e2(int paramInt1, int paramInt2, int paramInt3)
  {
    this.o4 = ((ViewGroup)findViewById(16908290));
    final Object localObject = LayoutInflater.from(this).inflate(2131559113, null);
    this.p4 = ((View)localObject);
    this.s4 = ((ColorPointView)((View)localObject).findViewById(2131362732));
    localObject = (WaveView)this.p4.findViewById(2131364826);
    this.r4 = ((WaveView)localObject);
    ((WaveView)localObject).setColor(getResources().getColor(2131100206));
    this.q4 = this.p4.findViewById(2131363909);
    this.t4 = ((TextView)this.p4.findViewById(2131364473));
    localObject = (TextView)this.p4.findViewById(2131362106);
    this.s4.c(paramInt3, -1, -1);
    this.o4.addView(this.p4, new ViewGroup.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.q4.getLayoutParams();
    this.u4 = localLayoutParams;
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.topMargin = paramInt2;
    this.r4.setDuration(1800L);
    this.r4.j();
    this.p4.setOnTouchListener(new f());
    ((TextView)localObject).setOnClickListener(new g((TextView)localObject));
    this.s4.setOnClickListener(new h((TextView)localObject));
  }
  
  private void f2()
  {
    if ((!o.h0().D()) && (!this.l4) && (this.Q3.getOnStatus()))
    {
      final Object localObject = this.k4;
      if ((localObject != null) && (((List)localObject).size() >= 2))
      {
        o.h0().F0(true);
        localObject = (LightStateBean)this.k4.get(1);
        this.R3.post(new e((LightStateBean)localObject));
      }
    }
  }
  
  private void g2()
  {
    this.z.setLightEffectOn(true);
    this.b4.setVisibility(8);
    this.c4.setVisibility(0);
    String str = this.f4.j(this.m4);
    this.O3.setText(str);
    this.p1.setImageResource(2131689849);
    this.p2.setImageDrawable(getResources().getDrawable(2131689837));
    this.K3.setTextColor(getResources().getColor(2131100206));
    this.L3.setTextColor(getResources().getColor(2131100206));
    this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), 2131689785, null), null, null, null);
    l2();
  }
  
  private void h2()
  {
    ThingContext localThingContext = TPIoTClientManager.k2(this.d4);
    if ((localThingContext != null) && (localThingContext.getIoTDevice() != null)) {
      if (localThingContext.getIoTDevice().isUserRoleTypeDevice())
      {
        this.J3.setVisibility(0);
      }
      else
      {
        this.J3.setVisibility(8);
        i2();
      }
    }
  }
  
  private void i2()
  {
    if ((com.tplink.iot.Utils.w0.a.d(this.d4)) && (R1())) {
      this.e4.x();
    } else {
      this.I3.setVisibility(8);
    }
  }
  
  private void j2()
  {
    m2();
    this.b4.setVisibility(0);
    this.c4.setVisibility(8);
    this.p1.setImageResource(2131689849);
    this.p2.setImageDrawable(getResources().getDrawable(2131689837));
    this.K3.setTextColor(getResources().getColor(2131100206));
    this.L3.setTextColor(getResources().getColor(2131100206));
    this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), 2131689785, null), null, null, null);
    this.M3.setVisibility(4);
  }
  
  private void k2(IoTBulbDevice paramIoTBulbDevice)
  {
    m2();
    this.b4.setVisibility(0);
    this.c4.setVisibility(8);
    this.p1.setImageResource(2131689776);
    this.p2.setImageDrawable(getResources().getDrawable(2131689835));
    this.K3.setTextColor(getResources().getColor(2131099799));
    this.L3.setTextColor(getResources().getColor(2131099799));
    this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), 2131689784, null), null, null, null);
    if ((paramIoTBulbDevice != null) && (paramIoTBulbDevice.getColorTemp() != 0))
    {
      this.M3.setVisibility(0);
      TextView localTextView = this.M3;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramIoTBulbDevice.getColorTemp());
      localStringBuilder.append("K");
      localTextView.setText(localStringBuilder.toString());
    }
    else
    {
      this.M3.setVisibility(4);
    }
  }
  
  private void l2()
  {
    try
    {
      this.Y3.setImageAssetsFolder("images/");
      com.airbnb.lottie.d locald = d.a.a(this, "light_effect_data.json");
      this.Y3.g();
      this.Y3.setProgress(0.0F);
      this.Y3.setComposition(locald);
      this.Y3.o();
      this.Y3.setVisibility(0);
    }
    catch (Exception localException)
    {
      Log.e("lottie", "load local lottie anim error");
    }
  }
  
  private void m2()
  {
    this.Y3.n();
  }
  
  private void n2()
  {
    this.e4.u().observe(this, new l());
    this.e4.y().observe(this, new m());
    this.e4.F().observe(this, new n());
    this.e4.C().observe(this, new o());
    this.e4.r().observe(this, new p());
    this.e4.D().observe(this, new q());
    if (com.tplink.iot.Utils.w0.a.d(this.d4))
    {
      this.e4.v().observe(this, new a());
      this.e4.w().observe(this, new b());
    }
    this.f4.l().observe(this, new b(this));
    this.f4.d.observe(this, new a(this));
  }
  
  private void o2(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    this.h4 = paramBaseALIoTDevice;
    this.K3.setText(l.d(this, paramBaseALIoTDevice.getDeviceType(), paramBaseALIoTDevice.getDeviceName()));
    paramBaseALIoTDevice = l.h(this.h4);
    boolean bool = TextUtils.isEmpty(paramBaseALIoTDevice);
    int i = 8;
    if (bool)
    {
      this.L3.setVisibility(8);
    }
    else
    {
      this.L3.setVisibility(0);
      this.L3.setText(paramBaseALIoTDevice);
    }
    this.S3.setChecked(this.h4.isCommonDevice());
    int j = N1();
    this.N3.setText(String.valueOf(j));
    paramBaseALIoTDevice = this.U3;
    if (!S1()) {
      i = 0;
    }
    paramBaseALIoTDevice.setVisibility(i);
    if (!this.h4.isSupportIoTCloud())
    {
      this.S3.setEnabled(false);
      this.V3.setAlpha(0.5F);
    }
    else
    {
      this.S3.setEnabled(true);
      this.V3.setAlpha(1.0F);
    }
    if ((this.h4.isSupportIoTCloud()) && (this.h4.getCloudIoTDevice() != null) && (!S1()))
    {
      this.K3.setEnabled(true);
      this.L3.setEnabled(true);
      this.U3.setEnabled(true);
      this.U3.setAlpha(1.0F);
    }
    else
    {
      this.K3.setEnabled(false);
      this.L3.setEnabled(false);
      this.U3.setEnabled(false);
      this.U3.setAlpha(0.5F);
    }
  }
  
  private void p2(List<LightStateBean> paramList)
  {
    this.k4 = paramList;
    this.R3.setColorPresets(paramList);
    f2();
  }
  
  private void q2(IoTBulbDevice paramIoTBulbDevice)
  {
    if (paramIoTBulbDevice != null)
    {
      this.m4 = paramIoTBulbDevice.getDynamicLightEffectId();
      int i;
      if (paramIoTBulbDevice.getColorTemp() == 0) {
        i = com.tplink.iot.Utils.z0.i.a(paramIoTBulbDevice.getHue(), paramIoTBulbDevice.getSaturation());
      } else {
        i = -1;
      }
      if ((paramIoTBulbDevice.isDeviceOn()) && (paramIoTBulbDevice.isDynamicLightEffectEnable()))
      {
        g2();
        L1();
      }
      else if (paramIoTBulbDevice.isDeviceOn())
      {
        this.z.setLightEffectOn(false);
        this.Q3.r(paramIoTBulbDevice.isDeviceOn(), paramIoTBulbDevice.getBrightness(), i);
        k2(paramIoTBulbDevice);
        f2();
      }
      else
      {
        this.z.setLightEffectOn(false);
        this.Q3.r(paramIoTBulbDevice.isDeviceOn(), paramIoTBulbDevice.getBrightness(), i);
        j2();
        L1();
      }
    }
  }
  
  public void J(int paramInt, boolean paramBoolean)
  {
    this.e4.O(paramInt);
    if (paramBoolean) {
      com.tplink.iot.Utils.x0.i.D(this.d4, paramInt);
    }
  }
  
  public void J0(String paramString)
  {
    this.e4.N(new AutoLightBean(true, paramString));
  }
  
  public void L(int paramInt)
  {
    this.P3.a(true, paramInt, false);
  }
  
  public void U(LightStateBean paramLightStateBean)
  {
    this.e4.Q(paramLightStateBean);
  }
  
  public void g(int paramInt, LightStateBean paramLightStateBean)
  {
    EditPresetRule localEditPresetRule = new EditPresetRule();
    localEditPresetRule.setIndex(paramInt);
    localEditPresetRule.setState(paramLightStateBean);
    this.e4.o(localEditPresetRule);
    this.e4.Q(paramLightStateBean);
  }
  
  public void h(LightStateBean paramLightStateBean) {}
  
  public void h1()
  {
    this.R3.d();
    this.e4.N(new AutoLightBean(true, M1()));
    c2();
  }
  
  public void onBottomRuleClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363466)
    {
      if (i != 2131363470) {
        switch (i)
        {
        default: 
          break;
        case 2131363464: 
          this.f4.z("L1", true);
          break;
        case 2131363463: 
          this.f4.z("L2", true);
          break;
        case 2131363462: 
          X0(AwayModeActivity.class, this.d4);
          break;
        }
      } else {
        TimerActivity.S1(this, this.d4);
      }
    }
    else {
      ScheduleListActivity.o1(this, this.d4, true);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364455: 
      this.f4.z(null, false);
      break;
    case 2131364441: 
      if ("L2".equals(this.m4)) {
        LightEffectConfigActivity.o1(this, this.d4, "L2");
      } else {
        LightEffectConfigActivity.o1(this, this.d4, "L1");
      }
      break;
    case 2131363121: 
      X0(ColorBulbSettingsActivity.class, this.d4);
      break;
    case 2131363103: 
      if (this.T3.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
        this.T3.r();
      } else if (this.T3.getCurrentStatus() == ScrollLayout.Status.OPENED) {
        this.T3.p();
      }
      break;
    case 2131363002: 
      onBackPressed();
      break;
    case 2131362913: 
      O1();
      com.tplink.iot.Utils.x0.i.w();
      break;
    case 2131362908: 
      ShareDeviceUserListActivity.v1(this, this.d4);
      com.tplink.iot.Utils.x0.i.C();
      break;
    case 2131362192: 
      CloudConnectGetStateActivity.j1(this, this.d4);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558484);
    com.tplink.iot.view.quicksetup.base.d.J(this, findViewById(2131363353));
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.d4 = paramBundle;
    this.e4 = ((BulbDetailViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbDetailViewModel.class));
    this.f4 = ((LightEffectViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, this.d4)).get(LightEffectViewModel.class));
    Q1();
    n2();
    h2();
    com.tplink.iot.Utils.x0.i.s();
  }
  
  protected void onDestroy()
  {
    Object localObject = this.W3;
    if (localObject != null) {
      ((ThingNextEventView)localObject).e();
    }
    localObject = this.Q3;
    if (localObject != null) {
      ((LightBulbView)localObject).p();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.e4.U();
    this.e4.T();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.e4.S();
    this.e4.R();
    this.e4.B();
    this.e4.G();
    this.e4.s();
    if (this.e4.H()) {
      this.f4.k();
    }
  }
  
  public void w0(boolean paramBoolean)
  {
    this.e4.P(paramBoolean);
    com.tplink.iot.Utils.x0.i.e(this.d4, paramBoolean);
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        ColorBulbDetailActivity.q1(ColorBulbDetailActivity.this).setVisibility(8);
      }
    }
  }
  
  class b
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>>
  {
    b() {}
    
    public void a(@Nullable com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> parami)
    {
      if ((parami != null) && (parami.b() == 0)) {
        ColorBulbDetailActivity.r1(ColorBulbDetailActivity.this, (CloudConnectStateResult)parami.a());
      }
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      Rect localRect = new Rect();
      ColorBulbDetailActivity.s1(ColorBulbDetailActivity.this).getGlobalVisibleRect(localRect);
      int i = localRect.left;
      int j = net.lucode.hackware.magicindicator.g.b.a(ColorBulbDetailActivity.this, 90.0D);
      int k = localRect.top;
      int m = net.lucode.hackware.magicindicator.g.b.a(ColorBulbDetailActivity.this, 18.0D);
      ColorBulbDetailActivity.t1(ColorBulbDetailActivity.this, i + j, k - m);
    }
  }
  
  class d
    implements ColorPresetView.a
  {
    d() {}
    
    public void a(int paramInt, LightStateBean paramLightStateBean)
    {
      ColorBulbDetailActivity.z1(ColorBulbDetailActivity.this).Q(paramLightStateBean);
    }
    
    public void b()
    {
      ColorBulbDetailActivity.v1(ColorBulbDetailActivity.this);
    }
    
    public void c(int paramInt1, int paramInt2, LightStateBean paramLightStateBean)
    {
      ColorBulbDetailActivity.u1(ColorBulbDetailActivity.this, paramInt1, paramLightStateBean);
      com.tplink.iot.Utils.x0.i.n(ColorBulbDetailActivity.D1(ColorBulbDetailActivity.this), paramLightStateBean);
    }
    
    public void d()
    {
      ColorBulbDetailActivity localColorBulbDetailActivity = ColorBulbDetailActivity.this;
      localColorBulbDetailActivity.f1(ColorBulbDetailActivity.D1(localColorBulbDetailActivity));
    }
  }
  
  class e
    implements Runnable
  {
    e(LightStateBean paramLightStateBean) {}
    
    public void run()
    {
      Rect localRect = new Rect();
      ColorBulbDetailActivity.s1(ColorBulbDetailActivity.this).getGlobalVisibleRect(localRect);
      int i = localRect.left;
      int j = net.lucode.hackware.magicindicator.g.b.a(ColorBulbDetailActivity.this, 90.0D);
      int k = localRect.top;
      int m = net.lucode.hackware.magicindicator.g.b.a(ColorBulbDetailActivity.this, 18.0D);
      ColorBulbDetailActivity.w1(ColorBulbDetailActivity.this, i + j, k - m, com.tplink.iot.Utils.z0.i.a(localObject.getHue(), localObject.getSaturation()));
    }
  }
  
  class f
    implements View.OnTouchListener
  {
    f() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  class g
    implements View.OnClickListener
  {
    g(TextView paramTextView) {}
    
    public void onClick(View paramView)
    {
      if (!ColorBulbDetailActivity.x1(ColorBulbDetailActivity.this).b())
      {
        localObject.setText(2131951761);
        ColorBulbDetailActivity.y1(ColorBulbDetailActivity.this).setText(2131952522);
        ColorBulbDetailActivity.x1(ColorBulbDetailActivity.this).setSelectedStatus(true);
      }
      else
      {
        ColorBulbDetailActivity.A1(ColorBulbDetailActivity.this);
      }
    }
  }
  
  class h
    implements View.OnClickListener
  {
    h(TextView paramTextView) {}
    
    public void onClick(View paramView)
    {
      if (ColorBulbDetailActivity.B1(ColorBulbDetailActivity.this) == 0)
      {
        ColorBulbDetailActivity.x1(ColorBulbDetailActivity.this).setSelectedStatus(true);
        localObject.setText(2131951761);
        ColorBulbDetailActivity.y1(ColorBulbDetailActivity.this).setText(2131952522);
        ColorBulbDetailActivity.s1(ColorBulbDetailActivity.this).b();
        ColorBulbDetailActivity.C1(ColorBulbDetailActivity.this);
      }
      else
      {
        ColorBulbDetailActivity.A1(ColorBulbDetailActivity.this);
        ColorBulbDetailActivity.s1(ColorBulbDetailActivity.this).b();
      }
    }
  }
  
  class i
    implements ScrollLayout.g
  {
    i() {}
    
    public void a(ScrollLayout.Status paramStatus)
    {
      if (paramStatus == ScrollLayout.Status.OPENED)
      {
        ColorBulbDetailActivity.n1(ColorBulbDetailActivity.this).setImageResource(2131689831);
        ColorBulbDetailActivity.p1(ColorBulbDetailActivity.this, false);
      }
      else if (paramStatus == ScrollLayout.Status.CLOSED)
      {
        ColorBulbDetailActivity.n1(ColorBulbDetailActivity.this).setImageResource(2131689830);
        ColorBulbDetailActivity.p1(ColorBulbDetailActivity.this, true);
      }
    }
    
    public void b(float paramFloat) {}
    
    public void c(int paramInt) {}
  }
  
  class j
    implements ThingNextEventView.d
  {
    j() {}
    
    public void a()
    {
      ColorBulbDetailActivity.z1(ColorBulbDetailActivity.this).M();
    }
  }
  
  class k
    implements TPSwitchCompat.a
  {
    k() {}
    
    public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        ColorBulbDetailActivity.z1(ColorBulbDetailActivity.this).n(paramBoolean1);
        com.tplink.iot.Utils.x0.i.x(ColorBulbDetailActivity.D1(ColorBulbDetailActivity.this), paramBoolean1);
      }
    }
  }
  
  class l
    implements Observer<IoTBulbDevice>
  {
    l() {}
    
    public void a(@Nullable IoTBulbDevice paramIoTBulbDevice)
    {
      ColorBulbDetailActivity.F1(ColorBulbDetailActivity.this, paramIoTBulbDevice);
      paramIoTBulbDevice = ColorBulbDetailActivity.this;
      ColorBulbDetailActivity.G1(paramIoTBulbDevice, ColorBulbDetailActivity.E1(paramIoTBulbDevice));
    }
  }
  
  class m
    implements Observer<List<LightStateBean>>
  {
    m() {}
    
    public void a(@Nullable List<LightStateBean> paramList)
    {
      ColorBulbDetailActivity.H1(ColorBulbDetailActivity.this, paramList);
    }
  }
  
  class n
    implements Observer<BulbNextEvent>
  {
    n() {}
    
    public void a(@Nullable BulbNextEvent paramBulbNextEvent)
    {
      ColorBulbDetailActivity.I1(ColorBulbDetailActivity.this).r(paramBulbNextEvent, ColorBulbDetailActivity.z1(ColorBulbDetailActivity.this).z());
    }
  }
  
  class o
    implements Observer<ThingUsage>
  {
    o() {}
    
    public void a(@Nullable ThingUsage paramThingUsage)
    {
      ColorBulbDetailActivity.J1(ColorBulbDetailActivity.this).o(paramThingUsage);
      com.tplink.iot.Utils.x0.i.t(ColorBulbDetailActivity.D1(ColorBulbDetailActivity.this), paramThingUsage);
    }
  }
  
  class p
    implements Observer<BaseALIoTDevice>
  {
    p() {}
    
    public void a(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
    {
      ColorBulbDetailActivity.K1(ColorBulbDetailActivity.this, paramBaseALIoTDevice);
    }
  }
  
  class q
    implements Observer<ThingFirmware>
  {
    q() {}
    
    public void a(@Nullable ThingFirmware paramThingFirmware)
    {
      ImageView localImageView = ColorBulbDetailActivity.o1(ColorBulbDetailActivity.this);
      int i;
      if ((paramThingFirmware != null) && (paramThingFirmware.isNeedToUpgrade())) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\colorbulb\ColorBulbDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */