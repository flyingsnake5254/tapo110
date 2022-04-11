package com.tplink.iot.view.quicksetup.plug;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.extension.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbSSIDEmptyActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbSSIDListActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPConnectBulbActivity;
import com.tplink.iot.view.quicksetup.bulb.WifiLocationAllowActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpwifi.TPWifiScanReceiver;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.m;

public final class SoftApPlugGuideActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private TextView H3;
  private TextView I3;
  private String J3 = "";
  private boolean K3 = true;
  private com.tplink.iot.widget.plug.a L3;
  private com.tplink.iot.widget.plug.a M3;
  private TPMaterialDialogV2 N3;
  private Integer O3;
  private Integer P3;
  private io.reactivex.e0.c Q3;
  private io.reactivex.e0.c R3;
  private TPWifiScanReceiver S3;
  private long T3;
  private View p0;
  private ImageView p1;
  private ImageView p2;
  private TPRefreshableButton p3;
  private View z;
  
  private final void A1()
  {
    Object localObject1 = ResourcesCompat.getDrawable(getResources(), com.tplink.iot.view.quicksetup.base.c.I(this.J3), null);
    if (localObject1 != null)
    {
      j.d(localObject1, "ResourcesCompat.getDrawa…ceModel), null) ?: return");
      Object localObject2 = ResourcesCompat.getDrawable(getResources(), com.tplink.iot.view.quicksetup.base.c.B(this.J3), null);
      if (localObject2 != null)
      {
        j.d(localObject2, "ResourcesCompat.getDrawa…ceModel), null) ?: return");
        localObject1 = new com.tplink.iot.widget.plug.a(new Drawable[] { localObject1, localObject2 }, 1000L);
        localObject2 = this.p1;
        if (localObject2 == null) {
          j.t("imgLedFirst");
        }
        ((com.tplink.iot.widget.plug.a)localObject1).a((ImageView)localObject2);
        ((com.tplink.iot.widget.plug.a)localObject1).c();
        localObject2 = p.a;
        this.L3 = ((com.tplink.iot.widget.plug.a)localObject1);
      }
    }
  }
  
  private final void B1()
  {
    this.Q3 = com.tplink.iot.view.quicksetup.base.f.c.h().g(5000L).E(new c(this)).F0();
  }
  
  private final void C1()
  {
    Object localObject1 = ResourcesCompat.getDrawable(getResources(), com.tplink.iot.view.quicksetup.base.c.R(this.J3), null);
    if (localObject1 != null)
    {
      j.d(localObject1, "ResourcesCompat.getDrawa…ceModel), null) ?: return");
      Object localObject2 = ResourcesCompat.getDrawable(getResources(), com.tplink.iot.view.quicksetup.base.c.P(this.J3), null);
      if (localObject2 != null)
      {
        j.d(localObject2, "ResourcesCompat.getDrawa…ceModel), null) ?: return");
        localObject1 = new com.tplink.iot.widget.plug.a(new Drawable[] { localObject1, localObject2 }, 1000L);
        localObject2 = this.p2;
        if (localObject2 == null) {
          j.t("imgLedSecond");
        }
        ((com.tplink.iot.widget.plug.a)localObject1).a((ImageView)localObject2);
        ((com.tplink.iot.widget.plug.a)localObject1).c();
        localObject2 = p.a;
        this.M3 = ((com.tplink.iot.widget.plug.a)localObject1);
      }
    }
  }
  
  private final void D1()
  {
    Object localObject = findViewById(2131363175);
    j.d(localObject, "findViewById(R.id.layout_first)");
    this.z = ((View)localObject);
    localObject = findViewById(2131363195);
    j.d(localObject, "findViewById(R.id.layout_second)");
    this.p0 = ((View)localObject);
    localObject = findViewById(2131362839);
    j.d(localObject, "findViewById(R.id.img_led_first)");
    this.p1 = ((ImageView)localObject);
    localObject = findViewById(2131362840);
    j.d(localObject, "findViewById(R.id.img_led_second)");
    this.p2 = ((ImageView)localObject);
    localObject = findViewById(2131363743);
    j.d(localObject, "findViewById(R.id.quicks…uce_commmon_refresh_next)");
    this.p3 = ((TPRefreshableButton)localObject);
    localObject = findViewById(2131364582);
    j.d(localObject, "findViewById(R.id.tv_power_up_hint)");
    this.I3 = ((TextView)localObject);
    localObject = this.p3;
    if (localObject == null) {
      j.t("btnRefreshNext");
    }
    ((TPRefreshableButton)localObject).setOnClickListener(this);
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    ((ImageView)findViewById(2131362836)).setImageResource(com.tplink.iot.view.quicksetup.base.c.F(this.J3));
    ((ImageView)findViewById(2131362847)).setImageResource(com.tplink.iot.view.quicksetup.base.c.Q(this.J3));
    H1();
    localObject = findViewById(2131364354);
    j.d(localObject, "findViewById(R.id.tv_bottom_tip)");
    localObject = (TextView)localObject;
    this.H3 = ((TextView)localObject);
    if (localObject == null) {
      j.t("tvBottomTip");
    }
    d0.h((TextView)localObject, getString(com.tplink.iot.view.quicksetup.bulb.utils.b.a(this.J3)), ContextCompat.getColor(this, 2131099811), new d(this));
    I1();
    if (com.tplink.iot.view.quicksetup.base.d.U(this)) {
      K1();
    }
  }
  
  private final void E1()
  {
    if (this.S3 == null)
    {
      TPWifiScanReceiver localTPWifiScanReceiver = new TPWifiScanReceiver();
      this.S3 = localTPWifiScanReceiver;
      registerReceiver(localTPWifiScanReceiver, TPWifiScanReceiver.b());
    }
  }
  
  private final boolean F1()
  {
    return com.tplink.libtpnetwork.Utils.o.h0().c("has_refused_location_permission", false);
  }
  
  public static final void G1(Context paramContext, String paramString)
  {
    y.a(paramContext, paramString);
  }
  
  private final void H1()
  {
    if (m.A(this.J3, "P115", false, 2, null))
    {
      Object localObject = this.I3;
      if (localObject == null) {
        j.t("tvPowerUpHint");
      }
      ((TextView)localObject).setText(2131953552);
      localObject = this.p3;
      if (localObject == null) {
        j.t("btnRefreshNext");
      }
      ((TPRefreshableButton)localObject).setText(getString(2131953538));
      h.a(findViewById(2131364506), getString(2131953540));
      h.a(findViewById(2131364507), getString(2131953549));
      h.a(findViewById(2131364508), getString(2131953542));
      h.a(findViewById(2131364509), getString(2131953546));
    }
  }
  
  private final void I1()
  {
    this.K3 = true;
    View localView = this.z;
    if (localView == null) {
      j.t("layoutFirst");
    }
    localView.setVisibility(0);
    localView = this.p0;
    if (localView == null) {
      j.t("layoutSecond");
    }
    localView.setVisibility(8);
    A1();
    p1();
  }
  
  private final void J1()
  {
    this.K3 = false;
    View localView = this.z;
    if (localView == null) {
      j.t("layoutFirst");
    }
    localView.setVisibility(8);
    localView = this.p0;
    if (localView == null) {
      j.t("layoutSecond");
    }
    localView.setVisibility(0);
    C1();
    o1();
  }
  
  private final void K1()
  {
    if (this.N3 == null)
    {
      localObject = new TPMaterialDialogV2.Builder(this);
      ((TPMaterialDialogV2.Builder)localObject).j(getString(2131953615));
      ((TPMaterialDialogV2.Builder)localObject).o(2131952441, 2131099808, null);
      ((TPMaterialDialogV2.Builder)localObject).c(false);
      ((TPMaterialDialogV2.Builder)localObject).b(false);
      ((TPMaterialDialogV2.Builder)localObject).g(8, 8);
      p localp = p.a;
      this.N3 = ((TPMaterialDialogV2.Builder)localObject).a();
    }
    Object localObject = this.N3;
    if (localObject != null) {
      ((TPMaterialDialogV2)localObject).show();
    }
  }
  
  private final void n1()
  {
    if (this.K3) {
      finish();
    } else {
      I1();
    }
  }
  
  private final void o1()
  {
    com.tplink.iot.widget.plug.a locala = this.L3;
    if (locala != null)
    {
      locala.b();
      this.L3 = null;
    }
  }
  
  private final void p1()
  {
    com.tplink.iot.widget.plug.a locala = this.M3;
    if (locala != null)
    {
      locala.b();
      this.M3 = null;
    }
  }
  
  private final void q1()
  {
    if (!com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
    {
      b.d.w.c.a.d("checkWifiScanResult is not AllWiFiPrepared");
      t1();
      return;
    }
    Object localObject = com.tplink.iot.view.quicksetup.base.d.p();
    if (com.tplink.iot.view.quicksetup.base.d.T((String)localObject))
    {
      b.d.w.c.a.d("checkWifiScanResult currentSSID isPlugSSID");
      u1((String)localObject);
      return;
    }
    localObject = this.S3;
    if (localObject == null)
    {
      b.d.w.c.a.d("checkWifiScanResult tpWifiScanReceiver = null");
      t1();
      return;
    }
    if (localObject != null) {
      localObject = ((TPWifiScanReceiver)localObject).a();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = com.tplink.iot.view.quicksetup.base.d.y((List)localObject, EnumDeviceType.PLUG, this.J3);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if (((List)localObject).size() == 1)
        {
          b.d.w.c.a.d("checkWifiScanResult splitScanResultList.size() == 1");
          u1(((ScanResult)((List)localObject).get(0)).SSID);
          return;
        }
        b.d.w.c.a.d("checkWifiScanResult gotoBulbSSIDList");
        w1((List)localObject);
        return;
      }
      b.d.w.c.a.d("checkWifiScanResult split == null || split.isEmpty()");
      t1();
      return;
    }
    b.d.w.c.a.d("checkWifiScanResult scanResultList == null || scanResultList.isEmpty()");
    t1();
  }
  
  private final void r1()
  {
    TPRefreshableButton localTPRefreshableButton = this.p3;
    if (localTPRefreshableButton == null) {
      j.t("btnRefreshNext");
    }
    localTPRefreshableButton.h();
    if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
    {
      b.d.w.c.a.d("isAllWiFiPrepared startScan");
      v1();
    }
    else if (F1())
    {
      b.d.w.c.a.d("HasDenyLocationPermission gotoBulbSSIDListEmpty");
      t1();
    }
    else
    {
      b.d.w.c.a.d("gotoWifiLocationAllowActivity");
      x1();
    }
  }
  
  private final void s1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("device_model");
        if (localObject != null) {
          break label36;
        }
      }
    }
    localObject = "";
    label36:
    this.J3 = ((String)localObject);
  }
  
  private final void t1()
  {
    SoftAPBulbSSIDEmptyActivity.n1(this, new QuickSetupInfoBundle(this.O3, this.P3, this.J3, this.T3));
  }
  
  private final void u1(String paramString)
  {
    SoftAPConnectBulbActivity.q2(this, paramString, new QuickSetupInfoBundle(this.O3, this.P3, this.J3, this.T3));
  }
  
  private final void v1()
  {
    B1();
    Object localObject = this.p3;
    if (localObject == null) {
      j.t("btnRefreshNext");
    }
    ((TPRefreshableButton)localObject).g();
    localObject = this.H3;
    if (localObject == null) {
      j.t("tvBottomTip");
    }
    ((TextView)localObject).setEnabled(false);
    localObject = this.H3;
    if (localObject == null) {
      j.t("tvBottomTip");
    }
    ((TextView)localObject).setAlpha(0.5F);
    com.tplink.libtpwifi.b.k().s();
    y1();
  }
  
  private final void w1(List<ScanResult> paramList)
  {
    Intent localIntent = new Intent(this, SoftAPBulbSSIDListActivity.class);
    if (paramList != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("bulb_ssid_list", (Serializable)paramList);
      localBundle.putSerializable("quick_setup_bundle", new QuickSetupInfoBundle(this.O3, this.P3, this.J3, this.T3));
      localIntent.putExtras(localBundle);
    }
    startActivity(localIntent);
  }
  
  private final void x1()
  {
    WifiLocationAllowActivity.p1(this, new QuickSetupInfoBundle(this.O3, this.P3, this.J3, this.T3));
  }
  
  private final void y1()
  {
    this.R3 = q.d0(1L, 15L, 1L, 1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new b(this));
  }
  
  private final boolean z1()
  {
    boolean bool1 = com.tplink.iot.view.quicksetup.base.wifi.d.a(this);
    boolean bool2 = true;
    if (bool1)
    {
      Object localObject = this.S3;
      if (localObject != null)
      {
        localObject = ((TPWifiScanReceiver)localObject).a();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = this.S3;
          if (localObject != null) {
            localObject = ((TPWifiScanReceiver)localObject).a();
          } else {
            localObject = null;
          }
          localObject = com.tplink.iot.view.quicksetup.base.d.y((List)localObject, EnumDeviceType.PLUG, this.J3);
          j.d(localObject, "QuickSetupUtils.getSplit…ceType.PLUG, deviceModel)");
          if ((((Collection)localObject).isEmpty() ^ true)) {
            return bool2;
          }
        }
      }
    }
    bool2 = false;
    return bool2;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 500) && (paramInt2 == -1))
    {
      v1();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    n1();
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    int i = paramView.getId();
    if (i != 2131362826)
    {
      if (i == 2131363743) {
        r1();
      }
    }
    else {
      n1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558679);
    s1();
    D1();
    E1();
    this.T3 = System.currentTimeMillis();
  }
  
  protected void onDestroy()
  {
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    Object localObject = this.N3;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.N3 = null;
    }
    localObject = this.S3;
    if (localObject != null) {
      unregisterReceiver((BroadcastReceiver)localObject);
    }
    o1();
    p1();
    localObject = this.Q3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    localObject = this.R3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    super.onDestroy();
  }
  
  @SuppressLint({"MissingSuperCall"})
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    j.e(paramBundle, "outState");
  }
  
  protected void onStop()
  {
    Object localObject = this.p3;
    if (localObject == null) {
      j.t("btnRefreshNext");
    }
    ((TPRefreshableButton)localObject).h();
    localObject = this.H3;
    if (localObject == null) {
      j.t("tvBottomTip");
    }
    ((TextView)localObject).setEnabled(true);
    localObject = this.H3;
    if (localObject == null) {
      j.t("tvBottomTip");
    }
    ((TextView)localObject).setAlpha(1.0F);
    localObject = this.Q3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    localObject = this.R3;
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
      Intent localIntent = new Intent(paramContext, SoftApPlugGuideActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putString("device_model", paramString);
      localIntent.putExtras(localBundle);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements g<Long>
  {
    b(SoftApPlugGuideActivity paramSoftApPlugGuideActivity) {}
    
    public final void a(Long paramLong)
    {
      long l1 = paramLong.longValue();
      long l2 = 5;
      if (((l1 <= l2) && (SoftApPlugGuideActivity.i1(this.c) != null) && (SoftApPlugGuideActivity.g1(this.c) != null) && (SoftApPlugGuideActivity.j1(this.c))) || ((paramLong.longValue() > l2) && (SoftApPlugGuideActivity.j1(this.c))) || (paramLong.longValue() == 15L))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleCheckWifiScanResult aLong=");
        localStringBuilder.append(paramLong);
        b.d.w.c.a.d(localStringBuilder.toString());
        SoftApPlugGuideActivity.e1(this.c);
        paramLong = SoftApPlugGuideActivity.h1(this.c);
        if (paramLong != null) {
          paramLong.dispose();
        }
        paramLong = SoftApPlugGuideActivity.f1(this.c);
        if (paramLong != null) {
          paramLong.dispose();
        }
      }
    }
  }
  
  static final class c<T>
    implements g<DeviceLocationInfo>
  {
    c(SoftApPlugGuideActivity paramSoftApPlugGuideActivity) {}
    
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
        SoftApPlugGuideActivity.k1(this.c, paramDeviceLocationInfo.getLatitude());
        SoftApPlugGuideActivity.l1(this.c, paramDeviceLocationInfo.getLongitude());
      }
    }
  }
  
  static final class d
    implements d0.g
  {
    d(SoftApPlugGuideActivity paramSoftApPlugGuideActivity) {}
    
    public final void a()
    {
      SoftApPlugGuideActivity.m1(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\plug\SoftApPlugGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */