package com.tplink.iot.view.quicksetup.bulb;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpwifi.TPWifiScanReceiver;
import com.tplink.libtpwifi.b;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SoftAPBulbGuideSecondActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView H3;
  private ValueAnimator I3;
  private ValueAnimator J3;
  private boolean K3 = false;
  private boolean L3 = false;
  private Integer M3;
  private Integer N3;
  private io.reactivex.e0.c O3 = null;
  private io.reactivex.e0.c P3 = null;
  private String Q3;
  private long R3;
  private TPMaterialDialogV2 S3;
  private TPWifiScanReceiver T3;
  private TPRefreshableButton p0;
  private TextView p1;
  private boolean p2;
  private ImageView p3;
  private View y;
  private View z;
  
  private void A1()
  {
    WifiLocationAllowActivity.p1(this, new QuickSetupInfoBundle(this.M3, this.N3, this.Q3, this.R3));
  }
  
  private void B1()
  {
    this.P3 = q.d0(1L, 15L, 1L, 1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new d());
  }
  
  private boolean C1()
  {
    if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
    {
      TPWifiScanReceiver localTPWifiScanReceiver = this.T3;
      if ((localTPWifiScanReceiver != null) && (localTPWifiScanReceiver.a() != null) && (!this.T3.a().isEmpty()) && (!com.tplink.iot.view.quicksetup.base.d.z(this.T3.a(), this.Q3).isEmpty())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  private void D1()
  {
    this.K3 = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.I3 = localValueAnimator;
    localValueAnimator.addListener(new a());
    this.I3.setRepeatCount(-1);
    this.I3.setRepeatMode(1);
    this.I3.start();
  }
  
  private void E1()
  {
    this.O3 = com.tplink.iot.view.quicksetup.base.f.c.h().g(5000L).E(new c()).F0();
  }
  
  private void F1()
  {
    this.L3 = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.J3 = localValueAnimator;
    localValueAnimator.addListener(new b());
    this.J3.setRepeatCount(-1);
    this.J3.setRepeatMode(1);
    this.J3.start();
  }
  
  private void G1()
  {
    if (this.T3 == null)
    {
      TPWifiScanReceiver localTPWifiScanReceiver = new TPWifiScanReceiver();
      this.T3 = localTPWifiScanReceiver;
      registerReceiver(localTPWifiScanReceiver, TPWifiScanReceiver.b());
    }
  }
  
  private boolean H1()
  {
    return o.h0().c("has_refused_location_permission", false);
  }
  
  public static void I1(Context paramContext, String paramString, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, SoftAPBulbGuideSecondActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("device_model", paramString);
    localBundle.putLong("onboarding_start_time", paramLong);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void J1()
  {
    this.z.setVisibility(0);
    this.y.setVisibility(8);
    this.p2 = true;
  }
  
  private void K1()
  {
    this.z.setVisibility(8);
    this.y.setVisibility(0);
    this.p2 = false;
  }
  
  private void L1()
  {
    if (this.S3 == null)
    {
      TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
      localBuilder.j(getString(2131953615));
      localBuilder.o(2131952441, 2131099808, null);
      localBuilder.c(false);
      localBuilder.b(false);
      localBuilder.g(8, 8);
      this.S3 = localBuilder.a();
    }
    this.S3.show();
  }
  
  private void s1()
  {
    ValueAnimator localValueAnimator = this.I3;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.I3.cancel();
      this.I3 = null;
    }
  }
  
  private void t1()
  {
    ValueAnimator localValueAnimator = this.J3;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.J3.cancel();
      this.J3 = null;
    }
  }
  
  private void u1()
  {
    if (!com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
    {
      b.d.w.c.a.d("checkWifiScanResult is not AllWiFiPrepared");
      x1();
      return;
    }
    Object localObject = com.tplink.iot.view.quicksetup.base.d.p();
    if (com.tplink.iot.view.quicksetup.base.d.M((String)localObject))
    {
      b.d.w.c.a.d("checkWifiScanResult CurrentSSid isBulbSSID");
      y1((String)localObject);
      return;
    }
    localObject = this.T3;
    if (localObject == null)
    {
      b.d.w.c.a.d("checkWifiScanResult tpWifiScanReceiver = null");
      x1();
      return;
    }
    localObject = ((TPWifiScanReceiver)localObject).a();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = com.tplink.iot.view.quicksetup.base.d.z((List)localObject, this.Q3);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if (((List)localObject).size() == 1)
        {
          b.d.w.c.a.d("checkWifiScanResult splitScanResultList.size() == 1");
          y1(((ScanResult)((List)localObject).get(0)).SSID);
          return;
        }
        b.d.w.c.a.d("checkWifiScanResult gotoBulbSSIDList");
        w1((List)localObject);
        return;
      }
      b.d.w.c.a.d("checkWifiScanResult split == null || split.isEmpty()");
      x1();
      return;
    }
    b.d.w.c.a.d("checkWifiScanResult scanResultList == null || scanResultList.isEmpty()");
    x1();
  }
  
  private void v1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.Q3 = ((Bundle)localObject).getString("device_model");
        this.R3 = ((Bundle)localObject).getLong("onboarding_start_time");
      }
    }
  }
  
  private void w1(List<ScanResult> paramList)
  {
    Intent localIntent = new Intent(this, SoftAPBulbSSIDListActivity.class);
    if (paramList != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("bulb_ssid_list", (Serializable)paramList);
      localBundle.putSerializable("quick_setup_bundle", new QuickSetupInfoBundle(this.M3, this.N3, this.Q3, this.R3));
      localIntent.putExtras(localBundle);
    }
    startActivity(localIntent);
  }
  
  private void x1()
  {
    SoftAPBulbSSIDEmptyActivity.n1(this, new QuickSetupInfoBundle(this.M3, this.N3, this.Q3, this.R3));
  }
  
  private void y1(String paramString)
  {
    SoftAPConnectBulbActivity.q2(this, paramString, new QuickSetupInfoBundle(this.M3, this.N3, this.Q3, this.R3));
  }
  
  private void z1()
  {
    E1();
    this.p0.g();
    this.p1.setEnabled(false);
    this.p1.setAlpha(0.5F);
    b.k().s();
    B1();
  }
  
  public void onBackPressed()
  {
    if (this.p2) {
      super.onBackPressed();
    } else {
      J1();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362826)
    {
      if (i != 2131363743)
      {
        if (i == 2131364354) {
          K1();
        }
      }
      else
      {
        this.p0.h();
        if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
        {
          b.d.w.c.a.d("isAllWiFiPrepared startScan");
          z1();
        }
        else if (H1())
        {
          b.d.w.c.a.d("HasDenyLocationPermission gotoBulbSSIDListEmpty");
          x1();
        }
        else
        {
          b.d.w.c.a.d("gotoWifiLocationAllowActivity");
          A1();
        }
      }
    }
    else {
      onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558670);
    v1();
    this.z = findViewById(2131363178);
    this.y = findViewById(2131363192);
    this.p0 = ((TPRefreshableButton)findViewById(2131363743));
    this.p3 = ((ImageView)findViewById(2131363005));
    this.H3 = ((ImageView)findViewById(2131363007));
    this.p0.setOnClickListener(this);
    findViewById(2131362826).setOnClickListener(this);
    paramBundle = (TextView)findViewById(2131364354);
    this.p1 = paramBundle;
    paramBundle.setOnClickListener(this);
    d0.h(this.p1, getString(2131953464), ContextCompat.getColor(this, 2131099811), null);
    G1();
    J1();
    D1();
    F1();
    if (com.tplink.iot.view.quicksetup.base.d.U(this)) {
      L1();
    }
  }
  
  protected void onDestroy()
  {
    s1();
    t1();
    Object localObject = this.S3;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.S3 = null;
    }
    localObject = this.T3;
    if (localObject != null) {
      unregisterReceiver((BroadcastReceiver)localObject);
    }
    localObject = this.O3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    localObject = this.P3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onStop()
  {
    this.p0.h();
    this.p1.setEnabled(true);
    this.p1.setAlpha(1.0F);
    io.reactivex.e0.c localc = this.O3;
    if (localc != null) {
      localc.dispose();
    }
    localc = this.P3;
    if (localc != null) {
      localc.dispose();
    }
    super.onStop();
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      paramAnimator = SoftAPBulbGuideSecondActivity.this;
      SoftAPBulbGuideSecondActivity.f1(paramAnimator, SoftAPBulbGuideSecondActivity.e1(paramAnimator) ^ true);
      paramAnimator = SoftAPBulbGuideSecondActivity.g1(SoftAPBulbGuideSecondActivity.this);
      int i;
      if (SoftAPBulbGuideSecondActivity.e1(SoftAPBulbGuideSecondActivity.this)) {
        i = 2131689533;
      } else {
        i = 2131689532;
      }
      paramAnimator.setImageResource(i);
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class b
    implements Animator.AnimatorListener
  {
    b() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      paramAnimator = SoftAPBulbGuideSecondActivity.this;
      SoftAPBulbGuideSecondActivity.i1(paramAnimator, SoftAPBulbGuideSecondActivity.h1(paramAnimator) ^ true);
      paramAnimator = SoftAPBulbGuideSecondActivity.j1(SoftAPBulbGuideSecondActivity.this);
      int i;
      if (SoftAPBulbGuideSecondActivity.h1(SoftAPBulbGuideSecondActivity.this)) {
        i = 2131689525;
      } else {
        i = 2131689524;
      }
      paramAnimator.setImageResource(i);
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class c
    implements g<DeviceLocationInfo>
  {
    c() {}
    
    public void a(DeviceLocationInfo paramDeviceLocationInfo)
      throws Exception
    {
      if ((paramDeviceLocationInfo != null) && (paramDeviceLocationInfo.getLatitude() != null) && (paramDeviceLocationInfo.getLongitude() != null))
      {
        SoftAPBulbGuideSecondActivity.l1(SoftAPBulbGuideSecondActivity.this, paramDeviceLocationInfo.getLatitude());
        SoftAPBulbGuideSecondActivity.n1(SoftAPBulbGuideSecondActivity.this, paramDeviceLocationInfo.getLongitude());
      }
    }
  }
  
  class d
    implements g<Long>
  {
    d() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      if (((paramLong.longValue() <= 5L) && (SoftAPBulbGuideSecondActivity.m1(SoftAPBulbGuideSecondActivity.this) != null) && (SoftAPBulbGuideSecondActivity.k1(SoftAPBulbGuideSecondActivity.this) != null) && (SoftAPBulbGuideSecondActivity.o1(SoftAPBulbGuideSecondActivity.this))) || ((paramLong.longValue() > 5L) && (SoftAPBulbGuideSecondActivity.o1(SoftAPBulbGuideSecondActivity.this))) || (paramLong.longValue() == 15L))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleCheckWifiScanResult aLong=");
        localStringBuilder.append(paramLong);
        b.d.w.c.a.d(localStringBuilder.toString());
        SoftAPBulbGuideSecondActivity.p1(SoftAPBulbGuideSecondActivity.this);
        if (SoftAPBulbGuideSecondActivity.q1(SoftAPBulbGuideSecondActivity.this) != null) {
          SoftAPBulbGuideSecondActivity.q1(SoftAPBulbGuideSecondActivity.this).dispose();
        }
        if (SoftAPBulbGuideSecondActivity.r1(SoftAPBulbGuideSecondActivity.this) != null) {
          SoftAPBulbGuideSecondActivity.r1(SoftAPBulbGuideSecondActivity.this).dispose();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\SoftAPBulbGuideSecondActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */