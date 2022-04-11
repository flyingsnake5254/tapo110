package com.tplink.iot.devices.lightstrip.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseLocationFragment;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBinding;
import com.tplink.iot.databinding.LayoutLightStripDetailBottomExtBinding;
import com.tplink.iot.databinding.LayoutLightStripDetailContentExtBinding;
import com.tplink.iot.databinding.LayoutLightStripGuidePageBinding;
import com.tplink.iot.devicecommon.feature.NextEventFeature;
import com.tplink.iot.devicecommon.feature.NextEventFeature.a;
import com.tplink.iot.devicecommon.view.DeviceLocationCheckFragment;
import com.tplink.iot.devicecommon.view.DeviceLocationCheckFragment.a;
import com.tplink.iot.devicecommon.view.DeviceLocationCheckFragment.b;
import com.tplink.iot.devicecommon.view.IoTDetailBaseActivity;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter.a;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripDetailViewModel;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.LightStripControllerLayout;
import com.tplink.iot.devices.lightstrip.widget.LightStripControllerLayout.a;
import com.tplink.iot.devices.lightstrip.widget.LightStripDetailBgLayout;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetLayout;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetLayout.b;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.k.c.b.o;
import com.tplink.iot.k.c.b.q;
import com.tplink.iot.musicphonerhythm.activitys.MusicPhoneRhythmActivity;
import com.tplink.iot.view.colorbulb.EditAutoDialog;
import com.tplink.iot.view.colorbulb.EditAutoDialog.a;
import com.tplink.iot.view.feature.AwayModeActivity;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.widget.WaveView;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.iot.widget.viewgroup.MultiFeaturesGridView;
import com.tplink.iot.widget.viewgroup.MultiFeaturesGridView.c;
import com.tplink.iot.widget.viewgroup.MultiFeaturesGridView.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.tdp.bean.BaseTDPDevice;
import com.yinglan.scrolllayout.ScrollLayout;
import com.yinglan.scrolllayout.ScrollLayout.Status;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;
import java.util.Objects;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.n;
import kotlin.p;

public final class LightStripDetailActivity
  extends IoTDetailBaseActivity<LayoutLightStripDetailContentExtBinding, LayoutLightStripDetailBottomExtBinding, LightStripDetailViewModel>
  implements LightStripControllerLayout.a, LightStripLightSettingsFragment.b, LightingEffectPresetLayout.b, DeviceLocationCheckFragment.b, EditAutoDialog.a, MultiFeaturesGridView.e
{
  public static final b L3 = new b(null);
  private final f M3 = h.b(new c(this));
  private final f N3 = h.b(new e(this));
  private int O3 = -1;
  private String P3;
  private IoTLightStripDevice Q3;
  private List<? extends LightStateBean> R3;
  private int S3;
  private final f T3 = h.b(new f(this));
  private EditAutoDialog U3;
  private final f V3 = h.a(LazyThreadSafetyMode.NONE, new d(this));
  private final kotlin.t.d W3;
  private LayoutLightStripGuidePageBinding X3;
  private ViewGroup Y3;
  private View Z3;
  private View a4;
  private WaveView b4;
  private LightingEffectBaseView c4;
  private TextView d4;
  private RelativeLayout.LayoutParams e4;
  private int f4;
  private boolean g4;
  
  public LightStripDetailActivity()
  {
    super(LightStripDetailViewModel.class);
    Object localObject = kotlin.t.a.a;
    localObject = Boolean.TRUE;
    this.W3 = new a(localObject, localObject, this);
  }
  
  private final void A2(int paramInt1, int paramInt2)
  {
    if (!this.g4) {
      return;
    }
    Object localObject1 = this.e4;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("lp");
    }
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = paramInt1;
    localObject1 = this.e4;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("lp");
    }
    ((RelativeLayout.LayoutParams)localObject1).topMargin = paramInt2;
    Object localObject2 = this.Y3;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("contentView");
    }
    localObject1 = this.Z3;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("guideView");
    }
    ((ViewGroup)localObject2).removeView((View)localObject1);
    localObject1 = this.Y3;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("contentView");
    }
    localObject2 = this.Z3;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("guideView");
    }
    ((ViewGroup)localObject1).addView((View)localObject2);
  }
  
  private final void B2(boolean paramBoolean)
  {
    this.W3.a(this, K3[0], Boolean.valueOf(paramBoolean));
  }
  
  private final void C2()
  {
    if (getSupportFragmentManager().findFragmentByTag("EditAutoDialog") != null) {
      return;
    }
    EditAutoDialog localEditAutoDialog = EditAutoDialog.G0(o2());
    localEditAutoDialog.I0(this);
    localEditAutoDialog.show(getSupportFragmentManager(), "EditAutoDialog");
    p localp = p.a;
    this.U3 = localEditAutoDialog;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void D2(int paramInt1, int paramInt2, LightStateBean paramLightStateBean)
  {
    if (this.g4) {
      return;
    }
    Object localObject1 = findViewById(16908290);
    kotlin.jvm.internal.j.d(localObject1, "findViewById(android.R.id.content)");
    this.Y3 = ((ViewGroup)localObject1);
    localObject1 = DataBindingUtil.inflate(getLayoutInflater(), 2131559174, null, false);
    kotlin.jvm.internal.j.d(localObject1, "DataBindingUtil.inflate(…_guide_page, null, false)");
    localObject1 = (LayoutLightStripGuidePageBinding)localObject1;
    this.X3 = ((LayoutLightStripGuidePageBinding)localObject1);
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mPresetGuideBinding");
    }
    localObject1 = ((ViewDataBinding)localObject1).getRoot();
    kotlin.jvm.internal.j.d(localObject1, "mPresetGuideBinding.root");
    this.Z3 = ((View)localObject1);
    localObject1 = this.X3;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mPresetGuideBinding");
    }
    localObject1 = ((LayoutLightStripGuidePageBinding)localObject1).p1;
    kotlin.jvm.internal.j.d(localObject1, "mPresetGuideBinding.waveView");
    this.b4 = ((WaveView)localObject1);
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("waveView");
    }
    ((WaveView)localObject1).setColor(getResources().getColor(2131100206));
    localObject1 = this.X3;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mPresetGuideBinding");
    }
    localObject1 = ((LayoutLightStripGuidePageBinding)localObject1).x;
    kotlin.jvm.internal.j.d(localObject1, "mPresetGuideBinding.rlTop");
    this.a4 = ((View)localObject1);
    localObject1 = this.X3;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mPresetGuideBinding");
    }
    localObject1 = ((LayoutLightStripGuidePageBinding)localObject1).p0;
    kotlin.jvm.internal.j.d(localObject1, "mPresetGuideBinding.tvGuideTips");
    this.d4 = ((TextView)localObject1);
    localObject1 = this.Y3;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("contentView");
    }
    Object localObject2 = this.Z3;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("guideView");
    }
    ((ViewGroup)localObject1).addView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
    localObject1 = this.a4;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("rlTop");
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    Objects.requireNonNull(localObject1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    this.e4 = ((RelativeLayout.LayoutParams)localObject1);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = paramInt1;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("lp");
    }
    ((RelativeLayout.LayoutParams)localObject1).topMargin = paramInt2;
    localObject1 = this.b4;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("waveView");
    }
    ((WaveView)localObject1).setDuration(1800L);
    localObject1 = this.b4;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("waveView");
    }
    ((WaveView)localObject1).j();
    localObject1 = this.Z3;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("guideView");
    }
    ((View)localObject1).setOnTouchListener(j.c);
    localObject2 = paramLightStateBean.getLightingEffectData();
    if (localObject2 != null)
    {
      paramLightStateBean = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.t((LightingEffectData)localObject2);
      if (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.r((LightingEffectData)localObject2))
      {
        localObject1 = com.tplink.iot.devices.lightstrip.lightingeffect.a.b.g(paramLightStateBean);
        paramLightStateBean = (List)((Pair)localObject1).component1();
        localObject1 = (List)((Pair)localObject1).component2();
        localObject2 = this.X3;
        if (localObject2 == null) {
          kotlin.jvm.internal.j.t("mPresetGuideBinding");
        }
        localObject2 = ((LayoutLightStripGuidePageBinding)localObject2).q;
        ((ColorPaintingRingView)localObject2).k(paramLightStateBean, (List)localObject1);
        kotlin.jvm.internal.j.d(localObject2, "this");
        this.c4 = ((LightingEffectBaseView)localObject2);
      }
      else
      {
        localObject1 = PredefinedEffectsAdapter.h.b(((LightingEffectData)localObject2).name);
        localObject2 = ((LightingEffectData)localObject2).custom;
        if ((localObject2 != null) && (((Integer)localObject2).intValue() == 0) && (localObject1 != null))
        {
          paramLightStateBean = this.X3;
          if (paramLightStateBean == null) {
            kotlin.jvm.internal.j.t("mPresetGuideBinding");
          }
          paramLightStateBean = paramLightStateBean.d;
          paramLightStateBean.setImageResource(((com.tplink.iot.g.b.b.d)localObject1).d());
          kotlin.jvm.internal.j.d(paramLightStateBean, "this");
          this.c4 = paramLightStateBean;
        }
        else
        {
          localObject1 = this.X3;
          if (localObject1 == null) {
            kotlin.jvm.internal.j.t("mPresetGuideBinding");
          }
          localObject1 = ((LayoutLightStripGuidePageBinding)localObject1).f;
          ((ColorEffectPlateView)localObject1).k(paramLightStateBean);
          kotlin.jvm.internal.j.d(localObject1, "this");
          this.c4 = ((LightingEffectBaseView)localObject1);
        }
      }
    }
    else
    {
      localObject1 = this.X3;
      if (localObject1 == null) {
        kotlin.jvm.internal.j.t("mPresetGuideBinding");
      }
      localObject1 = ((LayoutLightStripGuidePageBinding)localObject1).z;
      ((SelectableColorPointView)localObject1).setColor(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.v(paramLightStateBean));
      kotlin.jvm.internal.j.d(localObject1, "this");
      this.c4 = ((LightingEffectBaseView)localObject1);
    }
    paramLightStateBean = this.c4;
    if (paramLightStateBean == null) {
      kotlin.jvm.internal.j.t("mPresetExampleView");
    }
    paramLightStateBean.setVisibility(0);
    paramLightStateBean = this.X3;
    if (paramLightStateBean == null) {
      kotlin.jvm.internal.j.t("mPresetGuideBinding");
    }
    paramLightStateBean.c.setOnClickListener(new k(this));
    paramLightStateBean = this.c4;
    if (paramLightStateBean == null) {
      kotlin.jvm.internal.j.t("mPresetExampleView");
    }
    paramLightStateBean.setOnClickListener(new l(this));
    this.g4 = true;
  }
  
  private final void E2()
  {
    if (this.g4) {
      return;
    }
    final Object localObject1 = this.R3;
    if (localObject1 != null)
    {
      Object localObject2 = q1().K3;
      kotlin.jvm.internal.j.d(localObject2, "mBinding.scrollDownLayout");
      int i;
      if (((ScrollLayout)localObject2).getCurrentStatus() == ScrollLayout.Status.CLOSED) {
        i = 1;
      } else {
        i = 0;
      }
      localObject2 = o.h0();
      kotlin.jvm.internal.j.d(localObject2, "SP.instance()");
      if ((!((o)localObject2).T()) && (i == 0))
      {
        localObject2 = p1();
        if ((localObject2 != null) && (((BaseALIoTDevice)localObject2).isDeviceOn() == true) && (((List)localObject1).size() >= 2))
        {
          localObject2 = o.h0();
          kotlin.jvm.internal.j.d(localObject2, "SP.instance()");
          ((o)localObject2).Y0(true);
          localObject1 = (LightStateBean)((List)localObject1).get(1);
          ((LayoutLightStripDetailContentExtBinding)t1()).d.post(new m(this, (LightStateBean)localObject1));
        }
      }
    }
  }
  
  private final void F2()
  {
    int i = getResources().getColor(2131100206);
    ActivityBaseIotDeviceDetailBinding localActivityBaseIotDeviceDetailBinding = q1();
    localActivityBaseIotDeviceDetailBinding.p2.setImageResource(2131689849);
    localActivityBaseIotDeviceDetailBinding.I3.setImageResource(2131689837);
    localActivityBaseIotDeviceDetailBinding.N3.setTextColor(i);
    localActivityBaseIotDeviceDetailBinding.L3.setTextColor(i);
    localActivityBaseIotDeviceDetailBinding.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), 2131689785, null), null, null, null);
    s2().j(false, 0, 0);
    q2().d(false, 0);
    I2(null, i, false);
  }
  
  private final void G2(IoTLightStripDevice paramIoTLightStripDevice)
  {
    int i = r2();
    ActivityBaseIotDeviceDetailBinding localActivityBaseIotDeviceDetailBinding = q1();
    localActivityBaseIotDeviceDetailBinding.p2.setImageResource(2131689776);
    localActivityBaseIotDeviceDetailBinding.I3.setImageResource(2131689835);
    localActivityBaseIotDeviceDetailBinding.N3.setTextColor(i);
    localActivityBaseIotDeviceDetailBinding.L3.setTextColor(i);
    localActivityBaseIotDeviceDetailBinding.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), 2131689784, null), null, null, null);
    if (v2())
    {
      M2();
    }
    else
    {
      int j = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.v(new LightStateBean(paramIoTLightStripDevice.getHue(), paramIoTLightStripDevice.getSaturation(), paramIoTLightStripDevice.getColorTemp(), paramIoTLightStripDevice.getBrightness()));
      I2(null, i, false);
      i = h2(paramIoTLightStripDevice.getColorTemp(), paramIoTLightStripDevice.getColorTempRange());
      H2(kotlin.collections.l.b(Integer.valueOf(j)), paramIoTLightStripDevice.getBrightness(), i);
    }
  }
  
  private final void H2(List<Integer> paramList, int paramInt1, int paramInt2)
  {
    s2().m(paramList);
    q2().f(paramList);
    s2().j(true, paramInt1, paramInt2);
    q2().d(true, paramInt1);
  }
  
  private final void I2(String paramString, int paramInt, boolean paramBoolean)
  {
    TextView localTextView = ((LayoutLightStripDetailContentExtBinding)t1()).z;
    int i;
    if ((paramBoolean ^ true)) {
      i = 4;
    } else {
      i = 0;
    }
    localTextView.setVisibility(i);
    if (paramString == null) {
      paramString = "";
    }
    localTextView.setText(paramString);
    localTextView.setTextColor(paramInt);
  }
  
  private final void J2(boolean paramBoolean)
  {
    IoTLightStripDevice localIoTLightStripDevice = this.Q3;
    Object localObject1;
    if ((w2()) && (!paramBoolean))
    {
      localObject1 = q1().N3;
      kotlin.jvm.internal.j.d(localObject1, "mBinding.tvName");
      ((TextView)localObject1).setVisibility(8);
      localObject1 = q1().M3;
      kotlin.jvm.internal.j.d(localObject1, "mBinding.tvMusicRhythmMode");
      ((TextView)localObject1).setVisibility(0);
      Object localObject2 = q1().M3;
      kotlin.jvm.internal.j.d(localObject2, "mBinding.tvMusicRhythmMode");
      Object localObject3 = null;
      if (localIoTLightStripDevice != null) {
        localObject1 = localIoTLightStripDevice.getMusicRhythmMode();
      } else {
        localObject1 = null;
      }
      ((TextView)localObject2).setText(com.tplink.iot.k.c.b.e((String)localObject1));
      localObject1 = q1().p3;
      kotlin.jvm.internal.j.d(localObject1, "mBinding.ivBg");
      ((View)localObject1).setVisibility(0);
      localObject1 = ((LayoutLightStripDetailContentExtBinding)t1()).x;
      kotlin.jvm.internal.j.d(localObject1, "mContentExtBinding.normalLightstripDetail");
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = ((LayoutLightStripDetailContentExtBinding)t1()).y;
      kotlin.jvm.internal.j.d(localObject1, "mContentExtBinding.rhythmingDetail");
      ((RelativeLayout)localObject1).setVisibility(0);
      ((LayoutLightStripDetailBottomExtBinding)s1()).c.c(4, 0.4F);
      q1().p3.setBackgroundResource(2131690218);
      localObject2 = ((LayoutLightStripDetailContentExtBinding)t1()).f;
      localObject1 = localObject3;
      if (localIoTLightStripDevice != null) {
        localObject1 = localIoTLightStripDevice.getMusicRhythmMode();
      }
      com.tplink.iot.k.c.b.p((LottieAnimationView)localObject2, (String)localObject1);
      ((LayoutLightStripDetailContentExtBinding)t1()).q.setOnClickListener(new q(this));
      F2();
    }
    else
    {
      localObject1 = q1().N3;
      kotlin.jvm.internal.j.d(localObject1, "mBinding.tvName");
      ((TextView)localObject1).setVisibility(0);
      localObject1 = q1().M3;
      kotlin.jvm.internal.j.d(localObject1, "mBinding.tvMusicRhythmMode");
      ((TextView)localObject1).setVisibility(8);
      localObject1 = q1().p3;
      kotlin.jvm.internal.j.d(localObject1, "mBinding.ivBg");
      ((View)localObject1).setVisibility(8);
      localObject1 = q1().N3;
      kotlin.jvm.internal.j.d(localObject1, "mBinding.tvName");
      ((TextView)localObject1).setText((CharSequence)((LightStripDetailViewModel)v1()).s().getValue());
      localObject1 = ((LayoutLightStripDetailContentExtBinding)t1()).x;
      kotlin.jvm.internal.j.d(localObject1, "mContentExtBinding.normalLightstripDetail");
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = ((LayoutLightStripDetailContentExtBinding)t1()).y;
      kotlin.jvm.internal.j.d(localObject1, "mContentExtBinding.rhythmingDetail");
      ((RelativeLayout)localObject1).setVisibility(8);
      if (((LightStripDetailViewModel)v1()).h0()) {
        ((LayoutLightStripDetailBottomExtBinding)s1()).c.c(4, 1.0F);
      }
    }
  }
  
  private final void K2(boolean paramBoolean)
  {
    LightingEffectPresetLayout localLightingEffectPresetLayout = ((LayoutLightStripDetailContentExtBinding)t1()).d;
    kotlin.jvm.internal.j.d(localLightingEffectPresetLayout, "mContentExtBinding.lightingEffectPreset");
    int i;
    if ((paramBoolean ^ true)) {
      i = 4;
    } else {
      i = 0;
    }
    localLightingEffectPresetLayout.setVisibility(i);
    if (!paramBoolean) {
      l2();
    }
  }
  
  private final void L2()
  {
    IoTLightStripDevice localIoTLightStripDevice = this.Q3;
    if ((localIoTLightStripDevice != null) && (localIoTLightStripDevice.isDeviceOn() == true))
    {
      G2(localIoTLightStripDevice);
      K2(true);
      if (!w2()) {
        E2();
      }
    }
    else
    {
      F2();
      K2(false);
      m2();
    }
  }
  
  private final void M2()
  {
    Object localObject1 = this.Q3;
    if (localObject1 != null) {
      localObject1 = ((IoTLightStripDevice)localObject1).getLightingEffectData();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      H2(kotlin.collections.l.d(), 100, 0);
      I2(null, r2(), false);
      return;
    }
    if ((kotlin.jvm.internal.j.a(((LightingEffectData)localObject1).id, this.P3) ^ true)) {
      l2();
    }
    H2(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.u((LightingEffectData)localObject1), com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.p((LightingEffectData)localObject1), 0);
    String str = ((LightingEffectData)localObject1).name;
    Object localObject2 = ((LightingEffectData)localObject1).custom;
    if (localObject2 == null)
    {
      localObject1 = str;
    }
    else
    {
      localObject1 = str;
      if (((Integer)localObject2).intValue() == 0)
      {
        localObject1 = str;
        if (str != null)
        {
          localObject2 = PredefinedEffectsAdapter.h.b(str);
          localObject1 = str;
          if (localObject2 != null)
          {
            localObject2 = ((com.tplink.iot.g.b.b.d)localObject2).h();
            localObject1 = str;
            if (localObject2 != null) {
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    I2((String)localObject1, r2(), true);
  }
  
  private final int h2(int paramInt, int[] paramArrayOfInt)
  {
    int i = paramInt;
    if (paramInt != 0)
    {
      i = paramInt;
      if (com.tplink.iot.g.b.c.c.l(paramArrayOfInt, ((LightStripDetailViewModel)v1()).f0()))
      {
        i = 0;
        I2(getString(2131952379), r2(), true);
      }
    }
    return i;
  }
  
  private final void i2(com.tplink.iot.g.b.b.e.a parama)
  {
    if ((parama instanceof com.tplink.iot.g.b.b.c))
    {
      ((LightStripDetailViewModel)v1()).t0(((com.tplink.iot.g.b.b.c)parama).e());
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.a))
    {
      parama = ((com.tplink.iot.g.b.b.a)parama).g();
      if (parama != null) {
        ((LightStripDetailViewModel)v1()).u0(parama);
      }
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.b))
    {
      parama = ((com.tplink.iot.g.b.b.b)parama).f();
      if (parama != null) {
        ((LightStripDetailViewModel)v1()).u0(parama);
      }
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.d))
    {
      parama = (com.tplink.iot.g.b.b.d)parama;
      if (parama.i())
      {
        parama = parama.c();
        if (parama != null) {
          ((LightStripDetailViewModel)v1()).t0(parama);
        }
      }
      else
      {
        parama = parama.g();
        if (parama != null) {
          ((LightStripDetailViewModel)v1()).u0(parama);
        }
      }
    }
  }
  
  private final List<MultiFeaturesGridView.c> j2()
  {
    List localList = kotlin.collections.l.h(new MultiFeaturesGridView.c[] { new MultiFeaturesGridView.c(2131690278, 2131953389, 0), new MultiFeaturesGridView.c(2131690277, 2131953375, 1), new MultiFeaturesGridView.c(2131690279, 2131953397, 2) });
    if (((LightStripDetailViewModel)v1()).g0()) {
      localList.add(0, new MultiFeaturesGridView.c(2131689883, 2131952944, 3));
    }
    if (((LightStripDetailViewModel)v1()).h0()) {
      localList.add(0, new MultiFeaturesGridView.c(2131690215, 2131953169, 4));
    }
    return localList;
  }
  
  private final Pair<Integer, Integer> k2()
  {
    Rect localRect = new Rect();
    ((LayoutLightStripDetailContentExtBinding)t1()).d.getGlobalVisibleRect(localRect);
    int i = localRect.left;
    int j;
    if (((LightStripDetailViewModel)v1()).e0()) {
      j = 124;
    } else {
      j = 66;
    }
    return n.a(Integer.valueOf(i + p2(j) - p2(12)), Integer.valueOf(localRect.top - p2(12)));
  }
  
  private final void l2()
  {
    this.P3 = null;
    ((LayoutLightStripDetailContentExtBinding)t1()).d.g();
  }
  
  private final void m2()
  {
    if (!this.g4) {
      return;
    }
    this.g4 = false;
    Object localObject = this.b4;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("waveView");
    }
    ((WaveView)localObject).k();
    localObject = this.Y3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("contentView");
    }
    View localView = this.Z3;
    if (localView == null) {
      kotlin.jvm.internal.j.t("guideView");
    }
    ((ViewGroup)localObject).removeView(localView);
  }
  
  private final void n2(int paramInt, LightStateBean paramLightStateBean)
  {
    EditPresetRule localEditPresetRule = new EditPresetRule();
    localEditPresetRule.setIndex(paramInt);
    localEditPresetRule.setState(paramLightStateBean);
    ((LightStripDetailViewModel)v1()).O(localEditPresetRule);
  }
  
  private final String o2()
  {
    Object localObject = this.Q3;
    if (localObject != null)
    {
      localObject = ((IoTLightStripDevice)localObject).getAutoMode();
      if (localObject != null) {}
    }
    else
    {
      localObject = "light_track";
    }
    return (String)localObject;
  }
  
  private final int p2(int paramInt)
  {
    float f = paramInt;
    Resources localResources = getResources();
    kotlin.jvm.internal.j.d(localResources, "resources");
    return (int)TypedValue.applyDimension(1, f, localResources.getDisplayMetrics());
  }
  
  private final LightStripDetailBgLayout q2()
  {
    return (LightStripDetailBgLayout)this.M3.getValue();
  }
  
  private final int r2()
  {
    return ((Number)this.V3.getValue()).intValue();
  }
  
  private final LightStripControllerLayout s2()
  {
    return (LightStripControllerLayout)this.N3.getValue();
  }
  
  private final DeviceLocationCheckFragment t2()
  {
    return (DeviceLocationCheckFragment)this.T3.getValue();
  }
  
  private final void u2()
  {
    List localList = j2();
    int i = localList.size();
    int j = 4;
    if (i != 4) {
      j = 3;
    }
    MultiFeaturesGridView localMultiFeaturesGridView = ((LayoutLightStripDetailBottomExtBinding)s1()).c;
    localMultiFeaturesGridView.d(j);
    localMultiFeaturesGridView.setFeatureData(localList);
    localMultiFeaturesGridView.setOnFeatureItemClickListener(this);
  }
  
  private final boolean v2()
  {
    IoTLightStripDevice localIoTLightStripDevice = this.Q3;
    boolean bool = true;
    if ((localIoTLightStripDevice == null) || (localIoTLightStripDevice.isLightingEffectEnabled() != true)) {
      bool = false;
    }
    return bool;
  }
  
  private final boolean w2()
  {
    if ((((LightStripDetailViewModel)v1()).h0()) && (!((LightStripDetailViewModel)v1()).d0()))
    {
      Object localObject = this.Q3;
      if (localObject != null) {
        localObject = ((IoTLightStripDevice)localObject).isMusicRhythmEnable();
      } else {
        localObject = null;
      }
      if (kotlin.jvm.internal.j.a(localObject, Boolean.TRUE)) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public static final void x2(Context paramContext, String paramString)
  {
    L3.a(paramContext, paramString);
  }
  
  @SuppressLint({"CheckResult"})
  private final void y2()
  {
    s0.m(this, getString(2131952466));
    Object localObject = p1();
    if ((localObject != null) && (((BaseALIoTDevice)localObject).isUserRoleTypeDevice() == true))
    {
      LightStripDetailViewModel localLightStripDetailViewModel = (LightStripDetailViewModel)v1();
      localObject = p1();
      if (localObject != null)
      {
        localObject = ((BaseALIoTDevice)localObject).getDeviceIdMD5();
        if (localObject != null) {}
      }
      else
      {
        localObject = "";
      }
      if (!localLightStripDetailViewModel.i0((String)localObject))
      {
        s0.g();
        com.tplink.iot.k.c.b.o(this);
        return;
      }
    }
    ((LightStripDetailViewModel)v1()).n0(p1()).l0(io.reactivex.d0.b.a.a()).H0(new h(this), new i(this));
  }
  
  private final void z2(List<? extends LightStateBean> paramList)
  {
    paramList = com.tplink.iot.devices.lightstrip.lightingeffect.a.b.f(paramList);
    ((LayoutLightStripDetailContentExtBinding)t1()).d.o(paramList);
    if (!w2()) {
      E2();
    }
  }
  
  public void A(LightStateBean paramLightStateBean)
  {
    kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
    LightStripLightSettingsFragment.b.a.a(this, paramLightStateBean);
  }
  
  public void A1()
  {
    super.A1();
    NextEventFeature.c.a(this, ((LayoutLightStripDetailBottomExtBinding)s1()).d).f(((LightStripDetailViewModel)v1()).b0());
    Object localObject = q1().p3;
    kotlin.jvm.internal.j.d(localObject, "mBinding.ivBg");
    ((View)localObject).setVisibility(8);
    q1().y.addView(q2(), 0, new ViewGroup.LayoutParams(-1, -1));
    LightStripDetailBgLayout localLightStripDetailBgLayout = q2();
    localObject = ((LayoutLightStripDetailContentExtBinding)t1()).d;
    kotlin.jvm.internal.j.d(localObject, "mContentExtBinding.lightingEffectPreset");
    localLightStripDetailBgLayout.b((View)localObject);
    localObject = ((LayoutLightStripDetailContentExtBinding)t1()).d;
    ((LightingEffectPresetLayout)localObject).setAutoLightViewVisible(((LightStripDetailViewModel)v1()).e0());
    ((LightingEffectPresetLayout)localObject).setPresetCallback(this);
    u2();
    s2().setControllerStateListener(this);
    t2().S0(this);
  }
  
  public void B0(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    LightStripLightSettingsFragment.b.a.b(this, paramString);
  }
  
  public void B1()
  {
    if (((LightStripDetailViewModel)v1()).g0())
    {
      ((LightStripDetailViewModel)v1()).k0();
      ((LightStripDetailViewModel)v1()).l0();
    }
  }
  
  protected void C1(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> parami)
  {
    super.C1(parami);
    q1().c.post(new g(this));
  }
  
  public void E(int paramInt)
  {
    q2().d(true, paramInt);
  }
  
  public void I(LightStateBean paramLightStateBean)
  {
    int i = this.O3;
    if ((i != -1) && (paramLightStateBean != null)) {
      n2(i, paramLightStateBean);
    }
  }
  
  public void J0(String paramString)
  {
    if (paramString != null) {
      ((LightStripDetailViewModel)v1()).q0(new AutoLightBean(true, paramString));
    }
  }
  
  public void J1()
  {
    super.J1();
    ((LightStripDetailViewModel)v1()).Q().observe(this, new n(this));
    ((LightStripDetailViewModel)v1()).T().observe(this, new o(this));
    ((LightStripDetailViewModel)v1()).V().observe(this, new p(this));
  }
  
  public void V()
  {
    C2();
  }
  
  public void X()
  {
    ((LayoutLightStripDetailContentExtBinding)t1()).d.j();
    ((LightStripDetailViewModel)v1()).q0(new AutoLightBean(true, o2()));
    C2();
  }
  
  public void c0(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    LightStripLightSettingsFragment.b.a.c(this, paramString);
  }
  
  public int h1()
  {
    return 2131559172;
  }
  
  public int i1()
  {
    return ((LayoutLightStripDetailBottomExtBinding)s1()).c.getFirstRowHeight();
  }
  
  public int j1()
  {
    return 2131559173;
  }
  
  public void k0(LightStateBean paramLightStateBean)
  {
    kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
    LightStripLightSettingsFragment.b.a.d(this, paramLightStateBean);
  }
  
  public Class<? extends AppCompatActivity> k1()
  {
    return LightStripSettingsActivity.class;
  }
  
  public void l0(com.tplink.iot.g.b.b.e.a parama, int paramInt)
  {
    kotlin.jvm.internal.j.e(parama, "data");
    this.P3 = com.tplink.iot.g.b.b.e.b.a(parama);
    if (parama.a())
    {
      if (getSupportFragmentManager().findFragmentByTag("LightSettingDialogFragment") != null) {
        return;
      }
      this.O3 = paramInt;
      parama = (List)((LightStripDetailViewModel)v1()).V().getValue();
      if (parama != null) {
        parama = (LightStateBean)kotlin.collections.l.z(parama, paramInt);
      } else {
        parama = null;
      }
      parama = LightStripLightSettingsFragment.q.a(u1(), 1, parama);
      parama.g1(this);
      parama.show(getSupportFragmentManager(), "LightSettingDialogFragment");
    }
    else
    {
      if (paramInt != ((LayoutLightStripDetailContentExtBinding)t1()).d.getSelectedPresetEffectPos()) {
        i2(parama);
      }
      ((LayoutLightStripDetailContentExtBinding)t1()).d.k(paramInt);
    }
  }
  
  public String l1()
  {
    String str = getString(2131951844);
    kotlin.jvm.internal.j.d(str, "getString(R.string.bulb_param)");
    return str;
  }
  
  public String m1()
  {
    String str = getString(2131952875);
    kotlin.jvm.internal.j.d(str, "getString(R.string.iot_light_strips)");
    return str;
  }
  
  public EnumFeedbackCategory n1(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    kotlin.jvm.internal.j.e(paramBaseALIoTDevice, "device");
    return EnumFeedbackCategory.LIGHT_STRIP;
  }
  
  public void o0(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4) {
              if (!w2()) {
                y2();
              } else {
                com.tplink.iot.k.c.b.m(this);
              }
            }
          }
          else {
            X0(LightStripEffectsActivity.class, u1());
          }
        }
        else {
          X0(TimerActivity.class, u1());
        }
      }
      else {
        X0(AwayModeActivity.class, u1());
      }
    }
    else {
      ScheduleListActivity.o1(this, u1(), true);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    ((LightStripDetailViewModel)v1()).S();
    B2(((LightStripDetailViewModel)v1()).g0());
    if (((LightStripDetailViewModel)v1()).g0()) {
      ((LightStripDetailViewModel)v1()).U();
    }
    if (((LightStripDetailViewModel)v1()).j0()) {
      ((LightStripDetailViewModel)v1()).c0();
    }
    boolean bool = ((LightStripDetailViewModel)v1()).e0();
    ((LayoutLightStripDetailContentExtBinding)t1()).d.setAutoLightViewVisible(bool);
    if (bool) {
      ((LightStripDetailViewModel)v1()).P();
    }
  }
  
  public void q()
  {
    t2().I0(u1());
  }
  
  public void v0(boolean paramBoolean)
  {
    ((LightStripDetailViewModel)v1()).s0(paramBoolean);
    com.tplink.iot.Utils.x0.i.e(u1(), paramBoolean);
  }
  
  public void w(int paramInt, boolean paramBoolean)
  {
    if (v2()) {
      ((LightStripDetailViewModel)v1()).v0(paramInt, paramBoolean);
    } else {
      ((LightStripDetailViewModel)v1()).r0(paramInt, paramBoolean);
    }
    if (paramBoolean) {
      com.tplink.iot.Utils.x0.i.D(u1(), paramInt);
    }
  }
  
  public static final class a
    extends kotlin.t.b<Boolean>
  {
    public a(Object paramObject1, Object paramObject2, LightStripDetailActivity paramLightStripDetailActivity)
    {
      super();
    }
    
    protected void c(kotlin.reflect.j<?> paramj, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      kotlin.jvm.internal.j.e(paramj, "property");
      if (((Boolean)paramBoolean2).booleanValue() != ((Boolean)paramBoolean1).booleanValue()) {
        LightStripDetailActivity.W1(jdField_this);
      }
    }
  }
  
  public static final class b
  {
    public final void a(Context paramContext, String paramString)
    {
      kotlin.jvm.internal.j.e(paramContext, "context");
      kotlin.jvm.internal.j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, LightStripDetailActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<LightStripDetailBgLayout>
  {
    c(LightStripDetailActivity paramLightStripDetailActivity)
    {
      super();
    }
    
    public final LightStripDetailBgLayout a()
    {
      return new LightStripDetailBgLayout(this.c, null, 0, 6, null);
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<Integer>
  {
    d(LightStripDetailActivity paramLightStripDetailActivity)
    {
      super();
    }
    
    public final int a()
    {
      return this.c.getResources().getColor(2131099799);
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<LightStripControllerLayout>
  {
    e(LightStripDetailActivity paramLightStripDetailActivity)
    {
      super();
    }
    
    public final LightStripControllerLayout a()
    {
      return LightStripDetailActivity.Q1(this.c).c;
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.a<DeviceLocationCheckFragment>
  {
    f(LightStripDetailActivity paramLightStripDetailActivity)
    {
      super();
    }
    
    public final DeviceLocationCheckFragment a()
    {
      return DeviceLocationCheckFragment.x.a(this.c);
    }
  }
  
  static final class g
    implements Runnable
  {
    g(LightStripDetailActivity paramLightStripDetailActivity) {}
    
    public final void run()
    {
      Pair localPair = LightStripDetailActivity.L1(this.c);
      int i = ((Number)localPair.component1()).intValue();
      int j = ((Number)localPair.component2()).intValue();
      LightStripDetailActivity.Z1(this.c, i, j);
    }
  }
  
  static final class h<T>
    implements g<TDPIoTDevice>
  {
    h(LightStripDetailActivity paramLightStripDetailActivity) {}
    
    public final void a(TDPIoTDevice paramTDPIoTDevice)
    {
      s0.g();
      kotlin.jvm.internal.j.d(paramTDPIoTDevice, "tdpIoTDevice");
      Object localObject = paramTDPIoTDevice.getIp();
      int i;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject = LightStripDetailActivity.O1(this.c);
        if ((localObject != null) && (((BaseALIoTDevice)localObject).isUserRoleTypeDevice() == true)) {
          MusicPhoneRhythmActivity.e1(this.c, paramTDPIoTDevice.getDeviceIdMd5(), paramTDPIoTDevice.getIp());
        } else {
          MusicPhoneRhythmActivity.e1(this.c, paramTDPIoTDevice.getDeviceIdMd5(), null);
        }
        return;
      }
      paramTDPIoTDevice = this.c;
      com.tplink.iot.k.c.b.h(paramTDPIoTDevice, LightStripDetailActivity.U1(paramTDPIoTDevice), new a(this));
    }
    
    public static final class a
      implements b.o
    {
      a(LightStripDetailActivity.h paramh) {}
      
      public void a()
      {
        LightStripDetailActivity.X1(this.a.c);
        LightStripDetailActivity localLightStripDetailActivity = this.a.c;
        LightStripDetailActivity.d2(localLightStripDetailActivity, LightStripDetailActivity.U1(localLightStripDetailActivity) + 1);
      }
      
      public void cancel()
      {
        LightStripDetailActivity.d2(this.a.c, 0);
      }
    }
  }
  
  static final class i<T>
    implements g<Throwable>
  {
    i(LightStripDetailActivity paramLightStripDetailActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      s0.g();
      paramThrowable = this.c;
      com.tplink.iot.k.c.b.h(paramThrowable, LightStripDetailActivity.U1(paramThrowable), new a(this));
    }
    
    public static final class a
      implements b.o
    {
      a(LightStripDetailActivity.i parami) {}
      
      public void a()
      {
        LightStripDetailActivity.X1(this.a.c);
        LightStripDetailActivity localLightStripDetailActivity = this.a.c;
        LightStripDetailActivity.d2(localLightStripDetailActivity, LightStripDetailActivity.U1(localLightStripDetailActivity) + 1);
      }
      
      public void cancel()
      {
        LightStripDetailActivity.d2(this.a.c, 0);
      }
    }
  }
  
  static final class j
    implements View.OnTouchListener
  {
    public static final j c = new j();
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  static final class k
    implements View.OnClickListener
  {
    k(LightStripDetailActivity paramLightStripDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      if (!LightStripDetailActivity.R1(this.c).isSelected())
      {
        LightStripDetailActivity.S1(this.c).c.setText(2131951761);
        LightStripDetailActivity.V1(this.c).setText(2131952522);
        LightStripDetailActivity.R1(this.c).j(true, true);
        LightStripDetailActivity.R1(this.c).d(true);
      }
      else
      {
        LightStripDetailActivity.M1(this.c);
      }
    }
  }
  
  static final class l
    implements View.OnClickListener
  {
    l(LightStripDetailActivity paramLightStripDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      if (LightStripDetailActivity.N1(this.c) == 0)
      {
        LightStripDetailActivity.S1(this.c).c.setText(2131951761);
        LightStripDetailActivity.R1(this.c).j(true, true);
        LightStripDetailActivity.R1(this.c).d(true);
        LightStripDetailActivity.V1(this.c).setText(2131952522);
        LightStripDetailActivity.Q1(this.c).d.e(1);
        paramView = this.c;
        LightStripDetailActivity.a2(paramView, LightStripDetailActivity.N1(paramView) + 1);
      }
      else
      {
        LightStripDetailActivity.M1(this.c);
        LightStripDetailActivity.Q1(this.c).d.e(1);
      }
    }
  }
  
  static final class m
    implements Runnable
  {
    m(LightStripDetailActivity paramLightStripDetailActivity, LightStateBean paramLightStateBean) {}
    
    public final void run()
    {
      Pair localPair = LightStripDetailActivity.L1(this.c);
      int i = ((Number)localPair.component1()).intValue();
      int j = ((Number)localPair.component2()).intValue();
      LightStripDetailActivity.e2(this.c, i, j, localObject1);
    }
  }
  
  static final class n<T>
    implements Observer<IoTLightStripDevice>
  {
    n(LightStripDetailActivity paramLightStripDetailActivity) {}
    
    public final void a(IoTLightStripDevice paramIoTLightStripDevice)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IoTLightStripDevice LightStripBriefInfo: ");
      String str;
      if (paramIoTLightStripDevice != null) {
        str = com.tplink.libtpnetwork.Utils.l.b(paramIoTLightStripDevice);
      } else {
        str = null;
      }
      localStringBuilder.append(str);
      b.d.w.c.a.n("LightStrip", localStringBuilder.toString());
      LightStripDetailActivity.b2(this.a, paramIoTLightStripDevice);
      LightStripDetailActivity.g2(this.a);
      LightStripDetailActivity.f2(this.a, false);
    }
  }
  
  static final class o<T>
    implements Observer<ThingUsage>
  {
    o(LightStripDetailActivity paramLightStripDetailActivity) {}
    
    public final void a(ThingUsage paramThingUsage)
    {
      if (paramThingUsage != null) {
        LightStripDetailActivity.P1(this.a).f.o(paramThingUsage);
      }
    }
  }
  
  static final class p<T>
    implements Observer<List<LightStateBean>>
  {
    p(LightStripDetailActivity paramLightStripDetailActivity) {}
    
    public final void a(List<LightStateBean> paramList)
    {
      LightStripDetailActivity.c2(this.a, paramList);
      if (paramList != null) {
        LightStripDetailActivity.Y1(this.a, paramList);
      }
    }
  }
  
  static final class q
    implements View.OnClickListener
  {
    q(LightStripDetailActivity paramLightStripDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      com.tplink.iot.k.c.b.n(this.c, new a(this));
    }
    
    static final class a
      implements b.q
    {
      a(LightStripDetailActivity.q paramq) {}
      
      public final void a()
      {
        LightStripDetailActivity.f2(this.a.c, true);
        q localq = LightStripDetailActivity.T1(this.a.c).w0();
        if (localq != null)
        {
          localq = localq.E(new a(this));
          if (localq != null)
          {
            localq = localq.C(new b(this));
            if (localq != null) {
              localq.F0();
            }
          }
        }
      }
      
      static final class a<T>
        implements g<Boolean>
      {
        a(LightStripDetailActivity.q.a parama) {}
        
        public final void a(Boolean paramBoolean)
        {
          LightStripDetailActivity.T1(this.c.a.c).m0();
        }
      }
      
      static final class b<T>
        implements g<Throwable>
      {
        b(LightStripDetailActivity.q.a parama) {}
        
        public final void a(Throwable paramThrowable)
        {
          LightStripDetailActivity.T1(this.c.a.c).m0();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\LightStripDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */