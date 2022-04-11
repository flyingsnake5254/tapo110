package com.tplink.iot.view.quicksetup.softap.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySoftApCommonGuideBinding;
import com.tplink.iot.devices.lightstrip.view.LightStripSoftApResetHintActivity;
import com.tplink.iot.devices.lightstrip.view.LightStripSoftApResetHintActivity.a;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbSSIDEmptyActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbSSIDListActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPConnectBulbActivity;
import com.tplink.iot.view.quicksetup.bulb.WifiLocationAllowActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpwifi.TPWifiScanReceiver;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

public final class SoftApCommonGuideActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private io.reactivex.e0.c H3;
  private io.reactivex.e0.c I3;
  private long J3;
  private ActivitySoftApCommonGuideBinding p0;
  private Integer p1;
  private Integer p2;
  private TPWifiScanReceiver p3;
  private String z;
  
  private final void A1()
  {
    String str = getString(com.tplink.iot.view.quicksetup.bulb.utils.b.a(this.z));
    j.d(str, "getString(SoftApOnboardi…ttomTipText(deviceModel))");
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    d0.h(((ActivitySoftApCommonGuideBinding)localObject).y, str, ContextCompat.getColor(this, 2131099811), new d(this));
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivitySoftApCommonGuideBinding)localObject).p1.setText(com.tplink.iot.view.quicksetup.bulb.utils.b.i(this.z));
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).z;
    j.d(localObject, "binding.tvGuideDesc");
    ((TextView)localObject).setText(com.tplink.iot.view.quicksetup.bulb.utils.b.d(this.z));
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).p0;
    j.d(localObject, "binding.tvGuideTips");
    ((TextView)localObject).setText(com.tplink.iot.view.quicksetup.bulb.utils.b.h(this.z));
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivitySoftApCommonGuideBinding)localObject).c.setText(getString(com.tplink.iot.view.quicksetup.bulb.utils.b.b(this.z)));
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivitySoftApCommonGuideBinding)localObject).f.setImageResource(com.tplink.iot.view.quicksetup.bulb.utils.b.c(this.z));
    F1();
  }
  
  private final void B1()
  {
    if (this.p3 == null)
    {
      TPWifiScanReceiver localTPWifiScanReceiver = new TPWifiScanReceiver();
      this.p3 = localTPWifiScanReceiver;
      registerReceiver(localTPWifiScanReceiver, TPWifiScanReceiver.b());
    }
  }
  
  private final boolean C1()
  {
    return com.tplink.libtpnetwork.Utils.o.h0().c("has_refused_location_permission", false);
  }
  
  public static final void D1(Context paramContext, String paramString)
  {
    y.a(paramContext, paramString);
  }
  
  private final void E1()
  {
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).x;
    j.d(localObject, "it");
    int i;
    if (((View)localObject).getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!((LottieAnimationView)localObject).m())) {
      ((LottieAnimationView)localObject).q();
    }
  }
  
  private final void F1()
  {
    if (!com.tplink.iot.g.b.c.c.j(this.z)) {
      return;
    }
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).f;
    j.d(localObject, "binding.imageCheckLed");
    ((View)localObject).setVisibility(8);
    try
    {
      localObject = this.p0;
      if (localObject == null) {
        j.t("binding");
      }
      localObject = ((ActivitySoftApCommonGuideBinding)localObject).x;
      ((LottieAnimationView)localObject).g();
      ((LottieAnimationView)localObject).setAnimation(2131886083);
      ((LottieAnimationView)localObject).setProgress(0.0F);
      ((LottieAnimationView)localObject).o();
      ((View)localObject).setVisibility(0);
    }
    catch (Exception localException)
    {
      b.d.w.c.a.e("Lottie", "Load local json lottie anim error.");
    }
  }
  
  private final void G1()
  {
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).f;
    j.d(localObject, "binding.imageCheckLed");
    localObject = ((ImageView)localObject).getDrawable();
    j.d(localObject, "binding.imageCheckLed.drawable");
    if ((localObject instanceof AnimationDrawable)) {
      ((AnimationDrawable)localObject).stop();
    }
    H1(false);
  }
  
  private final void H1(boolean paramBoolean)
  {
    ActivitySoftApCommonGuideBinding localActivitySoftApCommonGuideBinding;
    if (paramBoolean)
    {
      localActivitySoftApCommonGuideBinding = this.p0;
      if (localActivitySoftApCommonGuideBinding == null) {
        j.t("binding");
      }
      localActivitySoftApCommonGuideBinding.x.g();
    }
    else
    {
      localActivitySoftApCommonGuideBinding = this.p0;
      if (localActivitySoftApCommonGuideBinding == null) {
        j.t("binding");
      }
      localActivitySoftApCommonGuideBinding.x.n();
    }
  }
  
  private final void n1()
  {
    if (!com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
    {
      b.d.w.c.a.d("checkWifiScanResult is not AllWiFiPrepared");
      p1();
      return;
    }
    Object localObject = com.tplink.iot.view.quicksetup.base.d.p();
    if (com.tplink.iot.view.quicksetup.base.d.R((String)localObject, this.z))
    {
      b.d.w.c.a.d("checkWifiScanResult currentSSID isDeviceSSID");
      q1((String)localObject);
      return;
    }
    localObject = this.p3;
    if (localObject == null)
    {
      b.d.w.c.a.d("checkWifiScanResult tpWifiScanReceiver = null");
      p1();
      return;
    }
    if (localObject != null) {
      localObject = ((TPWifiScanReceiver)localObject).a();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = com.tplink.iot.view.quicksetup.base.d.z((List)localObject, this.z);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if (((List)localObject).size() == 1)
        {
          b.d.w.c.a.d("checkWifiScanResult splitScanResultList.size() == 1");
          q1(((ScanResult)((List)localObject).get(0)).SSID);
          return;
        }
        b.d.w.c.a.d("checkWifiScanResult gotoBulbSSIDList");
        s1((List)localObject);
        return;
      }
      b.d.w.c.a.d("checkWifiScanResult split == null || split.isEmpty()");
      p1();
      return;
    }
    b.d.w.c.a.d("checkWifiScanResult scanResultList == null || scanResultList.isEmpty()");
    p1();
  }
  
  private final void o1()
  {
    ActivitySoftApCommonGuideBinding localActivitySoftApCommonGuideBinding = this.p0;
    if (localActivitySoftApCommonGuideBinding == null) {
      j.t("binding");
    }
    localActivitySoftApCommonGuideBinding.c.h();
    if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
    {
      b.d.w.c.a.d("isAllWiFiPrepared startScan");
      r1();
    }
    else if (C1())
    {
      b.d.w.c.a.d("HasDenyLocationPermission gotoBulbSSIDListEmpty");
      p1();
    }
    else
    {
      b.d.w.c.a.d("gotoWifiLocationAllowActivity");
      u1();
    }
  }
  
  private final void p1()
  {
    SoftAPBulbSSIDEmptyActivity.n1(this, new QuickSetupInfoBundle(this.p1, this.p2, this.z, this.J3));
  }
  
  private final void q1(String paramString)
  {
    SoftAPConnectBulbActivity.q2(this, paramString, new QuickSetupInfoBundle(this.p1, this.p2, this.z, this.J3));
  }
  
  private final void r1()
  {
    z1();
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivitySoftApCommonGuideBinding)localObject).c.g();
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).y;
    j.d(localObject, "binding.tvBottomTip");
    ((TextView)localObject).setEnabled(false);
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).y;
    j.d(localObject, "binding.tvBottomTip");
    ((TextView)localObject).setAlpha(0.5F);
    com.tplink.libtpwifi.b.k().s();
    v1();
  }
  
  private final void s1(List<ScanResult> paramList)
  {
    Intent localIntent = new Intent(this, SoftAPBulbSSIDListActivity.class);
    if (paramList != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("bulb_ssid_list", (Serializable)paramList);
      localBundle.putSerializable("quick_setup_bundle", new QuickSetupInfoBundle(this.p1, this.p2, this.z, this.J3));
      localIntent.putExtras(localBundle);
    }
    startActivity(localIntent);
  }
  
  private final void t1()
  {
    if ((this.z != null) && (com.tplink.iot.view.quicksetup.base.b.d().contains(this.z))) {
      LightStripSoftApResetHintActivity.p0.a(this, this.z);
    } else {
      SoftApResetHintActivity.y.a(this, this.z);
    }
  }
  
  private final void u1()
  {
    WifiLocationAllowActivity.p1(this, new QuickSetupInfoBundle(this.p1, this.p2, this.z, this.J3));
  }
  
  private final void v1()
  {
    this.I3 = q.d0(1L, 15L, 1L, 1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new b(this));
  }
  
  private final boolean w1()
  {
    boolean bool1 = com.tplink.iot.view.quicksetup.base.wifi.d.a(this);
    boolean bool2 = true;
    if (bool1)
    {
      Object localObject = this.p3;
      if (localObject != null)
      {
        localObject = ((TPWifiScanReceiver)localObject).a();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = this.p3;
          if (localObject != null) {
            localObject = ((TPWifiScanReceiver)localObject).a();
          } else {
            localObject = null;
          }
          localObject = com.tplink.iot.view.quicksetup.base.d.z((List)localObject, this.z);
          j.d(localObject, "QuickSetupUtils.getSplit…nResultList, deviceModel)");
          if ((((Collection)localObject).isEmpty() ^ true)) {
            return bool2;
          }
        }
      }
    }
    bool2 = false;
    return bool2;
  }
  
  private final void x1()
  {
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).f;
    j.d(localObject, "binding.imageCheckLed");
    localObject = ((ImageView)localObject).getDrawable();
    j.d(localObject, "binding.imageCheckLed.drawable");
    if ((localObject instanceof AnimationDrawable)) {
      ((AnimationDrawable)localObject).start();
    }
  }
  
  private final void y1()
  {
    this.z = getIntent().getStringExtra("device_model");
    ActivitySoftApCommonGuideBinding localActivitySoftApCommonGuideBinding = this.p0;
    if (localActivitySoftApCommonGuideBinding == null) {
      j.t("binding");
    }
    localActivitySoftApCommonGuideBinding.h(this);
  }
  
  private final void z1()
  {
    this.H3 = com.tplink.iot.view.quicksetup.base.f.c.h().g(5000L).E(new c(this)).F0();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 500) && (paramInt2 == -1))
    {
      r1();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131362826)) {
      onBackPressed();
    } else if ((paramView != null) && (paramView.intValue() == 2131362096)) {
      o1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558664);
    j.d(paramBundle, "DataBindingUtil.setConte…ity_soft_ap_common_guide)");
    this.p0 = ((ActivitySoftApCommonGuideBinding)paramBundle);
    y1();
    A1();
    B1();
    this.J3 = System.currentTimeMillis();
  }
  
  protected void onDestroy()
  {
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    TPWifiScanReceiver localTPWifiScanReceiver = this.p3;
    if (localTPWifiScanReceiver != null) {
      unregisterReceiver(localTPWifiScanReceiver);
    }
    H1(true);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    x1();
    E1();
  }
  
  protected void onStop()
  {
    G1();
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivitySoftApCommonGuideBinding)localObject).c.h();
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).y;
    j.d(localObject, "binding.tvBottomTip");
    ((TextView)localObject).setEnabled(true);
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApCommonGuideBinding)localObject).y;
    j.d(localObject, "binding.tvBottomTip");
    ((TextView)localObject).setAlpha(1.0F);
    localObject = this.H3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    localObject = this.I3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    super.onStop();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      j.e(paramContext, "activity");
      Intent localIntent = new Intent(paramContext, SoftApCommonGuideActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putString("device_model", paramString);
      localIntent.putExtras(localBundle);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements g<Long>
  {
    b(SoftApCommonGuideActivity paramSoftApCommonGuideActivity) {}
    
    public final void a(Long paramLong)
    {
      long l1 = paramLong.longValue();
      long l2 = 5;
      if (((l1 <= l2) && (SoftApCommonGuideActivity.i1(this.c) != null) && (SoftApCommonGuideActivity.g1(this.c) != null) && (SoftApCommonGuideActivity.k1(this.c))) || ((paramLong.longValue() > l2) && (SoftApCommonGuideActivity.k1(this.c))) || (paramLong.longValue() == 15L))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleCheckWifiScanResult aLong=");
        localStringBuilder.append(paramLong);
        b.d.w.c.a.d(localStringBuilder.toString());
        SoftApCommonGuideActivity.e1(this.c);
        paramLong = SoftApCommonGuideActivity.h1(this.c);
        if (paramLong != null) {
          paramLong.dispose();
        }
        paramLong = SoftApCommonGuideActivity.f1(this.c);
        if (paramLong != null) {
          paramLong.dispose();
        }
      }
    }
  }
  
  static final class c<T>
    implements g<DeviceLocationInfo>
  {
    c(SoftApCommonGuideActivity paramSoftApCommonGuideActivity) {}
    
    public final void a(DeviceLocationInfo paramDeviceLocationInfo)
    {
      if ((paramDeviceLocationInfo != null) && (paramDeviceLocationInfo.getLatitude() != null) && (paramDeviceLocationInfo.getLongitude() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SoftApCommonGuideActivity deviceLocationInfo latitude: ");
        localStringBuilder.append(paramDeviceLocationInfo.getLatitude());
        localStringBuilder.append(" longitude: ");
        localStringBuilder.append(paramDeviceLocationInfo.getLongitude());
        b.d.w.c.a.d(localStringBuilder.toString());
        SoftApCommonGuideActivity.l1(this.c, paramDeviceLocationInfo.getLatitude());
        SoftApCommonGuideActivity.m1(this.c, paramDeviceLocationInfo.getLongitude());
      }
    }
  }
  
  static final class d
    implements d0.g
  {
    d(SoftApCommonGuideActivity paramSoftApCommonGuideActivity) {}
    
    public final void a()
    {
      SoftApCommonGuideActivity.j1(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\softap\common\SoftApCommonGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */