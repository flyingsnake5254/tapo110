package com.tplink.iot.devices.trv.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBinding;
import com.tplink.iot.databinding.LayoutTrvDetailBottomExtBinding;
import com.tplink.iot.databinding.LayoutTrvDetailContentExtBinding;
import com.tplink.iot.devicecommon.feature.NextEventFeature;
import com.tplink.iot.devicecommon.feature.NextEventFeature.a;
import com.tplink.iot.devicecommon.view.IoTDetailBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVDetailViewModel;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.widget.trv.RadialGradientBackgroundView;
import com.tplink.iot.widget.trv.TemperatureSlider;
import com.tplink.iot.widget.trv.TemperatureSlider.a;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ChildProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.FrostProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.l;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class TRVDetailActivity
  extends IoTDetailBaseActivity<LayoutTrvDetailContentExtBinding, LayoutTrvDetailBottomExtBinding, TRVDetailViewModel>
  implements TemperatureSlider.a
{
  public static final a K3 = new a(null);
  private final f L3 = h.b(new d(this));
  private final f M3 = h.b(new c(this));
  private final f N3 = h.b(new b(this));
  private final int O3 = Color.rgb(255, 177, 51);
  private final int P3 = Color.rgb(66, 229, 247);
  private final int Q3 = (int)4292079870L;
  private final int R3 = (int)4294113018L;
  private final com.tplink.iot.devicecommon.feature.a S3 = new com.tplink.iot.devicecommon.feature.a();
  private IoTSubDevice T3;
  private IoTSubDevice U3;
  private EnumTemperatureUnit V3 = EnumTemperatureUnit.CELSIUS;
  private FrostProtectionBean W3;
  
  public TRVDetailActivity()
  {
    super(TRVDetailViewModel.class);
  }
  
  private final void U1(IoTSubDevice paramIoTSubDevice)
  {
    if (c2(paramIoTSubDevice, EnumTRVState.FROST_PROTECTION)) {
      V1();
    } else if (c2(paramIoTSubDevice, EnumTRVState.HEATING)) {
      W1(paramIoTSubDevice);
    } else if (b.j(paramIoTSubDevice))
    {
      if (paramIoTSubDevice.isFrostProtectionOn()) {
        V1();
      } else {
        W1(paramIoTSubDevice);
      }
    }
    else {
      i2(this.R3, -1);
    }
  }
  
  private final void V1()
  {
    i2(this.R3, 2131689886);
  }
  
  private final void W1(IoTSubDevice paramIoTSubDevice)
  {
    int i = this.R3;
    float f1 = paramIoTSubDevice.getCurrentTemp();
    float f2 = paramIoTSubDevice.getTargetTemp();
    boolean bool = f1 < f2;
    int j;
    if (bool)
    {
      i = this.O3;
      j = 2131689887;
    }
    else if (j == 0)
    {
      i = this.P3;
      j = 2131689913;
    }
    else if (f1 > f2)
    {
      i = this.P3;
      j = 2131689871;
    }
    else
    {
      j = -1;
    }
    i2(i, j);
  }
  
  private final void X1(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      V1();
    }
    else
    {
      IoTSubDevice localIoTSubDevice = this.U3;
      if (localIoTSubDevice != null)
      {
        localIoTSubDevice.setTargetTemp(paramInt);
        W1(localIoTSubDevice);
      }
    }
  }
  
  private final RadialGradientBackgroundView Y1()
  {
    return (RadialGradientBackgroundView)this.N3.getValue();
  }
  
  private final TemperatureSlider Z1()
  {
    return (TemperatureSlider)this.M3.getValue();
  }
  
  private final TextView a2()
  {
    return (TextView)this.L3.getValue();
  }
  
  private final void b2(int paramInt)
  {
    if (paramInt >= 3) {
      this.S3.b(this, p1());
    }
  }
  
  private final boolean c2(IoTSubDevice paramIoTSubDevice, EnumTRVState paramEnumTRVState)
  {
    paramIoTSubDevice = paramIoTSubDevice.getTrvStates();
    boolean bool;
    if (paramIoTSubDevice != null) {
      bool = paramIoTSubDevice.contains(paramEnumTRVState);
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final boolean d2(int paramInt1, int paramInt2)
  {
    Object localObject = this.W3;
    if (localObject != null) {
      localObject = Integer.valueOf(((FrostProtectionBean)localObject).getMinTemp());
    } else {
      localObject = null;
    }
    boolean bool1 = true;
    if ((localObject != null) && (paramInt2 <= ((Integer)localObject).intValue())) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    boolean bool2 = bool1;
    if (paramInt1 != 0) {
      if (paramInt2 != 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public static final void e2(Context paramContext, String paramString)
  {
    K3.a(paramContext, paramString);
  }
  
  private final void f2(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      Z1().n(paramBoolean3);
    }
    TemperatureSlider localTemperatureSlider = Z1();
    j.d(localTemperatureSlider, "mTempSlider");
    localTemperatureSlider.setEnabled(paramBoolean2);
  }
  
  private final void h2()
  {
    b.o(getSupportFragmentManager(), p1());
  }
  
  private final void i2(int paramInt1, int paramInt2)
  {
    Y1().b(paramInt1);
    ImageView localImageView;
    if (paramInt2 != -1)
    {
      localImageView = ((LayoutTrvDetailContentExtBinding)t1()).d;
      j.d(localImageView, "mContentExtBinding.ivStateIcon");
      localImageView.setVisibility(0);
      ((LayoutTrvDetailContentExtBinding)t1()).d.setImageResource(paramInt2);
    }
    else
    {
      localImageView = ((LayoutTrvDetailContentExtBinding)t1()).d;
      j.d(localImageView, "mContentExtBinding.ivStateIcon");
      localImageView.setVisibility(4);
      ((LayoutTrvDetailContentExtBinding)t1()).d.setImageDrawable(null);
    }
  }
  
  private final void j2(String paramString1, String paramString2, boolean paramBoolean)
  {
    TextView localTextView = a2();
    j.d(localTextView, "mTvTRVState");
    localTextView.setText(paramString1);
    paramString1 = ((LayoutTrvDetailContentExtBinding)t1()).z;
    int i = 0;
    int j;
    if ((paramString2 != null) && (paramString2.length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      i = 4;
    }
    paramString1.setVisibility(i);
    paramString1.setText(paramString2);
    if (paramBoolean)
    {
      paramString1 = ResourcesCompat.getDrawable(getResources(), 2131690254, null);
      a2().setCompoundDrawablesWithIntrinsicBounds(null, null, paramString1, null);
    }
    else
    {
      a2().setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
  }
  
  @SuppressLint({"SetTextI18n"})
  private final void l2(IoTSubDevice paramIoTSubDevice)
  {
    TextView localTextView = ((LayoutTrvDetailContentExtBinding)t1()).x;
    j.d(localTextView, "mContentExtBinding.tvTemperature");
    EnumTRVState localEnumTRVState = EnumTRVState.SHUTDOWN;
    String str;
    if (c2(paramIoTSubDevice, localEnumTRVState)) {
      str = "--";
    } else {
      str = b.c(paramIoTSubDevice.getCurrentTemp(), paramIoTSubDevice.getTempUnit());
    }
    localTextView.setText(str);
    U1(paramIoTSubDevice);
    Z1().p(paramIoTSubDevice.getMinControlTemp(), paramIoTSubDevice.getMaxControlTemp());
    a2().setOnClickListener(null);
    if (c2(paramIoTSubDevice, localEnumTRVState))
    {
      a2().setOnClickListener(new n(this));
      str = getString(2131954349);
      j.d(str, "getString(R.string.trv_sleep_mode_on)");
      k2(this, str, null, true, 2, null);
      g2(this, true, false, false, 4, null);
    }
    else if (c2(paramIoTSubDevice, EnumTRVState.WINDOW_OPEN))
    {
      str = getString(2131954326);
      j.d(str, "getString(R.string.trv_heating_paused)");
      k2(this, str, null, false, 6, null);
      g2(this, true, true, false, 4, null);
    }
    else if (c2(paramIoTSubDevice, EnumTRVState.FROST_PROTECTION))
    {
      m2();
    }
    else if (c2(paramIoTSubDevice, EnumTRVState.HEATING))
    {
      n2(paramIoTSubDevice);
    }
    else if (b.j(paramIoTSubDevice))
    {
      if (paramIoTSubDevice.isFrostProtectionOn()) {
        m2();
      } else {
        n2(paramIoTSubDevice);
      }
    }
    else
    {
      k2(this, "", null, false, 6, null);
      g2(this, true, false, false, 4, null);
    }
    if (c2(paramIoTSubDevice, EnumTRVState.DEVICE_ERROR))
    {
      paramIoTSubDevice = ((LayoutTrvDetailContentExtBinding)t1()).q;
      paramIoTSubDevice.setMessage(2131954314);
      paramIoTSubDevice.setActionText("");
      paramIoTSubDevice.setArrowRightVisible(true);
      paramIoTSubDevice.setOnTipBarClickListener(new i(this));
      paramIoTSubDevice.b();
    }
    else if (c2(paramIoTSubDevice, EnumTRVState.PROGRESS_CALIBRATION))
    {
      paramIoTSubDevice = ((LayoutTrvDetailContentExtBinding)t1()).q;
      paramIoTSubDevice.setMessage(2131954333);
      paramIoTSubDevice.setActionText("");
      paramIoTSubDevice.setArrowRightVisible(true);
      paramIoTSubDevice.setOnTipBarClickListener(new j(this));
      paramIoTSubDevice.b();
      g2(this, true, false, false, 4, null);
    }
    else if (c2(paramIoTSubDevice, EnumTRVState.REMOVING_SCALE))
    {
      paramIoTSubDevice = ((LayoutTrvDetailContentExtBinding)t1()).q;
      paramIoTSubDevice.setMessage(2131954338);
      paramIoTSubDevice.setActionText("");
      paramIoTSubDevice.setArrowRightVisible(true);
      paramIoTSubDevice.setOnTipBarClickListener(new k(this));
      paramIoTSubDevice.b();
      g2(this, true, false, false, 4, null);
    }
    else if (c2(paramIoTSubDevice, EnumTRVState.WINDOW_OPEN))
    {
      paramIoTSubDevice = ((LayoutTrvDetailContentExtBinding)t1()).q;
      paramIoTSubDevice.setMessage(2131954361);
      paramIoTSubDevice.setActionText(2131953902);
      paramIoTSubDevice.setArrowRightVisible(false);
      paramIoTSubDevice.setOnActionTextClickListener(new l(this));
      paramIoTSubDevice.b();
    }
    else if (c2(paramIoTSubDevice, EnumTRVState.LOW_BATTERY))
    {
      paramIoTSubDevice = ((LayoutTrvDetailContentExtBinding)t1()).q;
      paramIoTSubDevice.setMessage(2131954330);
      paramIoTSubDevice.setActionText(2131954328);
      paramIoTSubDevice.setArrowRightVisible(false);
      paramIoTSubDevice.setOnActionTextClickListener(new m(this));
      paramIoTSubDevice.b();
    }
    else
    {
      ((LayoutTrvDetailContentExtBinding)t1()).q.a();
    }
  }
  
  private final void m2()
  {
    String str = getString(2131952440);
    j.d(str, "getString(R.string.common_off)");
    Locale localLocale = Locale.getDefault();
    j.d(localLocale, "Locale.getDefault()");
    Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
    str = str.toUpperCase(localLocale);
    j.d(str, "(this as java.lang.String).toUpperCase(locale)");
    k2(this, str, getString(2131954320), false, 4, null);
    g2(this, true, true, false, 4, null);
  }
  
  private final void n2(IoTSubDevice paramIoTSubDevice)
  {
    String str = getString(2131954342, new Object[] { b.e(paramIoTSubDevice.getTargetTemp(), paramIoTSubDevice.getTempUnit()) });
    j.d(str, "getString(R.string.trv_setting_to_temp, tempText)");
    k2(this, str, null, false, 6, null);
    Z1().m(paramIoTSubDevice.getTargetTemp(), true);
    g2(this, false, true, false, 4, null);
  }
  
  public void A1()
  {
    super.A1();
    NextEventFeature.c.a(this, ((LayoutTrvDetailBottomExtBinding)s1()).y).f(((TRVDetailViewModel)v1()).U());
    Object localObject = q1().p1;
    j.d(localObject, "mBinding.imgMoreLocal");
    ((View)localObject).setVisibility(8);
    localObject = q1().p3;
    j.d(localObject, "mBinding.ivBg");
    ((View)localObject).setVisibility(8);
    FrameLayout localFrameLayout = q1().x;
    j.d(localFrameLayout, "mBinding.flContentExt");
    localObject = localFrameLayout.getLayoutParams();
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    ((ViewGroup.LayoutParams)localObject).height = -1;
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    q1().y.addView(Y1(), 0, new ViewGroup.LayoutParams(-1, -1));
    Z1().setOnSliderChangeListener(this);
  }
  
  public void B1()
  {
    ((TRVDetailViewModel)v1()).Q();
    if (((TRVDetailViewModel)v1()).Y()) {
      ((TRVDetailViewModel)v1()).M();
    }
  }
  
  public void J1()
  {
    super.J1();
    ((TRVDetailViewModel)v1()).X().observe(this, new e(this));
    ((TRVDetailViewModel)v1()).N().observe(this, new f(this));
    ((TRVDetailViewModel)v1()).R().observe(this, new g(this));
    ((TRVDetailViewModel)v1()).O().observe(this, new h(this));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void N0(int paramInt1, int paramInt2)
  {
    String str;
    if (d2(paramInt1, paramInt2))
    {
      str = getString(2131952440);
      j.d(str, "getString(R.string.common_off)");
      Locale localLocale = Locale.getDefault();
      j.d(localLocale, "Locale.getDefault()");
      Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
      str = str.toUpperCase(localLocale);
      j.d(str, "(this as java.lang.String).toUpperCase(locale)");
      k2(this, str, getString(2131954320), false, 4, null);
      X1(true, paramInt2);
    }
    else
    {
      str = getString(2131954342, new Object[] { b.d(paramInt2, this.V3) });
      j.d(str, "getString(R.string.trv_setting_to_temp, tempText)");
      k2(this, str, null, false, 6, null);
      X1(false, paramInt2);
    }
  }
  
  public int h1()
  {
    return 2131559239;
  }
  
  public int i1()
  {
    LinearLayout localLinearLayout = ((LayoutTrvDetailBottomExtBinding)s1()).q;
    j.d(localLinearLayout, "mBottomExtBinding.llRules");
    int i = localLinearLayout.getMeasuredHeight();
    localLinearLayout = ((LayoutTrvDetailBottomExtBinding)s1()).x;
    j.d(localLinearLayout, "mBottomExtBinding.llRules2");
    return i + localLinearLayout.getMeasuredHeight();
  }
  
  public int j1()
  {
    return 2131559240;
  }
  
  public Class<? extends AppCompatActivity> k1()
  {
    return TRVSettingsActivity.class;
  }
  
  public String l1()
  {
    String str = getString(2131954280);
    j.d(str, "getString(R.string.thermostat_param)");
    return str;
  }
  
  public String m1()
  {
    String str = getString(2131952884);
    j.d(str, "getString(R.string.iot_thermostats)");
    return str;
  }
  
  public EnumFeedbackCategory n1(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "device");
    return EnumFeedbackCategory.TRV;
  }
  
  public void onClick(View paramView)
  {
    Integer localInteger;
    if (paramView != null) {
      localInteger = Integer.valueOf(paramView.getId());
    } else {
      localInteger = null;
    }
    if ((localInteger != null) && (localInteger.intValue() == 2131362895))
    {
      paramView = p1();
      if ((paramView != null) && (!paramView.isUserRoleTypeDevice())) {
        X0(TRVSetChildProtectionActivity.class, u1());
      }
    }
    else if (((localInteger != null) && (localInteger.intValue() == 2131363113)) || ((localInteger != null) && (localInteger.intValue() == 2131364615)))
    {
      ScheduleListActivity.o1(this, u1(), false);
    }
    else if (((localInteger != null) && (localInteger.intValue() == 2131363144)) || ((localInteger != null) && (localInteger.intValue() == 2131364673)))
    {
      X0(TimerActivity.class, u1());
    }
    else if (((localInteger != null) && (localInteger.intValue() == 2131363104)) || ((localInteger != null) && (localInteger.intValue() == 2131364589)))
    {
      X0(TRVTemperatureRecordActivity.class, u1());
    }
    else if ((localInteger == null) || (localInteger.intValue() != 2131362192))
    {
      super.onClick(paramView);
    }
  }
  
  public void y(int paramInt1, int paramInt2)
  {
    if (d2(paramInt1, paramInt2))
    {
      ((TRVDetailViewModel)v1()).Z(true);
      g2(this, true, true, false, 4, null);
    }
    else
    {
      ((TRVDetailViewModel)v1()).a0(paramInt2, this.V3);
    }
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, TRVDetailActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<RadialGradientBackgroundView>
  {
    b(TRVDetailActivity paramTRVDetailActivity)
    {
      super();
    }
    
    public final RadialGradientBackgroundView a()
    {
      return new RadialGradientBackgroundView(this.c, null, 0, 6, null);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<TemperatureSlider>
  {
    c(TRVDetailActivity paramTRVDetailActivity)
    {
      super();
    }
    
    public final TemperatureSlider a()
    {
      return TRVDetailActivity.L1(this.c).f;
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<TextView>
  {
    d(TRVDetailActivity paramTRVDetailActivity)
    {
      super();
    }
    
    public final TextView a()
    {
      return TRVDetailActivity.L1(this.c).y;
    }
  }
  
  static final class e<T>
    implements Observer<IoTSubDevice>
  {
    e(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void a(IoTSubDevice paramIoTSubDevice)
    {
      TRVDetailActivity.P1(this.a, paramIoTSubDevice);
      TRVDetailActivity.Q1(this.a, b.a(paramIoTSubDevice));
      if (paramIoTSubDevice != null)
      {
        TRVDetailActivity localTRVDetailActivity = this.a;
        localObject = paramIoTSubDevice.getEnumTempUnit();
        j.d(localObject, "it.enumTempUnit");
        TRVDetailActivity.R1(localTRVDetailActivity, (EnumTemperatureUnit)localObject);
        TRVDetailActivity.T1(this.a, paramIoTSubDevice);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TRV Brief Info: ");
      ((StringBuilder)localObject).append(l.j(paramIoTSubDevice));
      b.d.w.c.a.n("TRV", ((StringBuilder)localObject).toString());
    }
  }
  
  static final class f<T>
    implements Observer<ChildProtectionBean>
  {
    f(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void a(ChildProtectionBean paramChildProtectionBean)
    {
      ImageView localImageView = TRVDetailActivity.L1(this.a).c;
      j.d(localImageView, "mContentExtBinding.itemChildProtection");
      int i = 0;
      boolean bool;
      if (paramChildProtectionBean != null) {
        bool = paramChildProtectionBean.getEnable();
      } else {
        bool = false;
      }
      if (!bool) {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  static final class g<T>
    implements Observer<FrostProtectionBean>
  {
    g(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void a(FrostProtectionBean paramFrostProtectionBean)
    {
      TRVDetailActivity.O1(this.a, paramFrostProtectionBean);
    }
  }
  
  static final class h<T>
    implements Observer<Integer>
  {
    h(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void a(Integer paramInteger)
    {
      if (paramInteger != null) {
        TRVDetailActivity.N1(this.a, paramInteger.intValue());
      }
    }
  }
  
  static final class i
    implements View.OnClickListener
  {
    i(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      new TRVErrorTroubleShootingFragment().show(this.c.getSupportFragmentManager(), null);
    }
  }
  
  static final class j
    implements View.OnClickListener
  {
    j(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      paramView.X0(TRVSetProgressCalibrationActivity.class, TRVDetailActivity.M1(paramView));
    }
  }
  
  static final class k
    implements View.OnClickListener
  {
    k(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      paramView.X0(TRVSetRemoveScaleActivity.class, TRVDetailActivity.M1(paramView));
    }
  }
  
  static final class l
    implements View.OnClickListener
  {
    l(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      TRVDetailActivity.L1(this.c).q.a();
    }
  }
  
  static final class m
    implements View.OnClickListener
  {
    m(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      TRVDetailActivity.S1(this.c);
    }
  }
  
  static final class n
    implements View.OnClickListener
  {
    n(TRVDetailActivity paramTRVDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      TRVSetShutdownModeActivity.a locala = TRVSetShutdownModeActivity.p0;
      paramView = this.c;
      locala.a(paramView, TRVDetailActivity.M1(paramView), true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */