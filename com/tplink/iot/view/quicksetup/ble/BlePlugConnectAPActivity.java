package com.tplink.iot.view.quicksetup.ble;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.v;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.common.PlugNickNameInputActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.DeviceTimeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.LoginAccountParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.InheritInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.u;
import com.tplink.tpble.z;
import io.reactivex.g0.g;
import io.reactivex.q;

public class BlePlugConnectAPActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private QuickSetupViewModel H3;
  private io.reactivex.e0.c I3;
  private ValueAnimator J3;
  private boolean K3;
  private Integer L3;
  private Integer M3;
  private String N3;
  private long O3;
  private long P3 = 0L;
  private Handler p0;
  private QuickSetupInfoBean p1;
  private WirelessInfoParams p2;
  private String p3;
  private TPRippleBackground y;
  private ImageView z;
  
  private void A1(String paramString)
  {
    M1(paramString);
  }
  
  private void B1()
  {
    if (com.tplink.iot.view.quicksetup.base.d.L(this.p1))
    {
      Object localObject = this.p1;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((QuickSetupInfoBean)localObject).getDeviceIdMD5();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        QuickSetupViewModel localQuickSetupViewModel = this.H3;
        if (localQuickSetupViewModel != null) {
          localQuickSetupViewModel.k0((String)localObject);
        }
      }
    }
  }
  
  private void C1()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.J3 = localValueAnimator;
    localValueAnimator.addUpdateListener(new a());
    this.J3.setRepeatCount(-1);
    this.J3.setRepeatMode(2);
    this.J3.start();
  }
  
  private void D1()
  {
    this.p3 = com.tplink.iot.view.quicksetup.base.d.q(this.p1);
    this.p0 = new Handler();
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
    ((TextView)findViewById(2131363739)).setText(getString(2131953599));
    ((ImageView)findViewById(2131363728)).setImageResource(com.tplink.iot.view.quicksetup.base.c.d(this.p3));
    Object localObject = (ImageView)findViewById(2131363729);
    this.z = ((ImageView)localObject);
    ((ImageView)localObject).setImageResource(com.tplink.iot.view.quicksetup.base.c.j(this.p3));
    localObject = (TPRippleBackground)findViewById(2131363731);
    this.y = ((TPRippleBackground)localObject);
    ((TPRippleBackground)localObject).e();
    C1();
    L1();
    J1();
  }
  
  private void E1()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.P3;
    int i = (int)((l1 - l2) / 1000L);
    int j;
    if (l2 != 0L)
    {
      j = i;
      if (i >= 0) {}
    }
    else
    {
      j = 0;
    }
    QuickSetupInfoBean localQuickSetupInfoBean = this.p1;
    if (localQuickSetupInfoBean != null) {
      r.s(localQuickSetupInfoBean.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5(), j);
    }
  }
  
  private void G1(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    if (com.tplink.iot.view.quicksetup.base.d.x(paramQuickSetupComponentResult) <= 0)
    {
      H1("parse component fail");
      return;
    }
    QuickSetupInfoBean localQuickSetupInfoBean = this.p1;
    if (localQuickSetupInfoBean != null) {
      localQuickSetupInfoBean.setComponentResult(paramQuickSetupComponentResult);
    }
    J1();
  }
  
  private void H1(String paramString)
  {
    this.H3.close();
    M1(paramString);
  }
  
  private void I1()
  {
    if (com.tplink.iot.view.quicksetup.base.ble.d.b(this)) {
      O1();
    } else {
      this.p0.postDelayed(new e(), 5000L);
    }
  }
  
  private void J1()
  {
    int i;
    if ((z.b(this)) && (this.H3.l0())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      M1("ble break connect");
      return;
    }
    QuickSetupInfoParams localQuickSetupInfoParams = new QuickSetupInfoParams();
    localQuickSetupInfoParams.setTime(v1());
    LoginAccountParams localLoginAccountParams = new LoginAccountParams();
    Object localObject = b.d.s.a.a.f();
    String str1 = "";
    String str2;
    if ((localObject != null) && (b.d.s.a.a.f().c() != null))
    {
      TCAccountBean localTCAccountBean = b.d.s.a.a.f().c();
      if ((localTCAccountBean != null) && (localTCAccountBean.getCloudUserName() != null)) {
        localObject = localTCAccountBean.getCloudUserName();
      } else {
        localObject = "";
      }
      str2 = str1;
      if (localTCAccountBean != null)
      {
        str2 = str1;
        if (localTCAccountBean.getPassword() != null) {
          str2 = localTCAccountBean.getPassword();
        }
      }
    }
    else
    {
      str2 = "";
      localObject = str1;
    }
    localLoginAccountParams.setUsername((String)localObject);
    localLoginAccountParams.setPassword(str2);
    localQuickSetupInfoParams.setAccount(localLoginAccountParams);
    localQuickSetupInfoParams.setWireless(this.p2);
    this.H3.L0(localQuickSetupInfoParams);
    this.P3 = System.currentTimeMillis();
  }
  
  private void K1(int paramInt)
  {
    Intent localIntent = new Intent(this, BlePlugConnectApFailedActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("device_info_bean", this.p1);
    localBundle.putInt("wifi_error_code", paramInt);
    localIntent.putExtras(localBundle);
    startActivityForResult(localIntent, 111);
  }
  
  private void L1()
  {
    this.H3.W().observe(this, new b());
    this.H3.h0().observe(this, new c());
    this.H3.d0().observe(this, new d());
  }
  
  private void M1(String paramString)
  {
    BleNoFindActivity.l1(this, this.p3, 100);
    v.a(BlePlugConnectAPActivity.class, BleNoFindActivity.class, paramString);
  }
  
  private void N1()
  {
    com.tplink.iot.view.quicksetup.base.d.e0(this, new g());
  }
  
  private void O1()
  {
    this.I3 = this.H3.D0().G0(new f());
  }
  
  private void t1()
  {
    TPRippleBackground localTPRippleBackground = this.y;
    if (localTPRippleBackground != null) {
      localTPRippleBackground.f();
    }
  }
  
  private void u1()
  {
    ValueAnimator localValueAnimator = this.J3;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.J3.cancel();
      this.J3 = null;
    }
  }
  
  private DeviceTimeParams v1()
  {
    DeviceTimeParams localDeviceTimeParams = this.H3.a0();
    if ((com.tplink.iot.view.quicksetup.base.d.Y(this.p1)) && (com.tplink.iot.view.quicksetup.base.d.P(this.L3, this.M3)))
    {
      localDeviceTimeParams.setLatitude(this.M3);
      localDeviceTimeParams.setLongitude(this.L3);
    }
    return localDeviceTimeParams;
  }
  
  private void w1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.p1 = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
        this.p2 = ((WirelessInfoParams)((Bundle)localObject).getSerializable("ap_ssid"));
        localObject = this.p1;
        if (localObject != null)
        {
          this.L3 = ((QuickSetupInfoBean)localObject).getLongitude();
          this.M3 = this.p1.getLatitude();
          this.O3 = this.p1.getOnboardingStartTime();
        }
      }
    }
  }
  
  private QuickSetupInfoBean x1()
  {
    Object localObject1 = this.N3;
    Object localObject2 = "";
    if (localObject1 == null) {
      this.N3 = "";
    }
    localObject1 = b.d.w.h.a.g(this.N3);
    if (com.tplink.iot.view.quicksetup.base.d.L(this.p1))
    {
      QuickSetupInfoBean localQuickSetupInfoBean = this.p1;
      if (localQuickSetupInfoBean != null) {
        localObject2 = localQuickSetupInfoBean.getDeviceIdMD5();
      }
      localObject2 = new QuickSetupInfoBean((String)localObject2, this.p2.getSsid(), this.O3);
    }
    else
    {
      localObject2 = new QuickSetupInfoBean((String)localObject1, this.p2.getSsid(), this.O3);
    }
    ((QuickSetupInfoBean)localObject2).setResultDeviceIdMD5((String)localObject1);
    ((QuickSetupInfoBean)localObject2).setResultDeviceId(this.N3);
    localObject1 = this.p1;
    if (localObject1 != null) {
      ((QuickSetupInfoBean)localObject2).setComponentResult(((QuickSetupInfoBean)localObject1).getComponentResult());
    }
    return (QuickSetupInfoBean)localObject2;
  }
  
  private void y1()
  {
    B1();
    PlugInheritAfterSetQsInfoActivity.r1(this, x1());
    finish();
  }
  
  private void z1()
  {
    B1();
    PlugNickNameInputActivity.p1(this, x1());
    finish();
  }
  
  public void F1()
  {
    this.H3.D();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100)
    {
      if (paramInt2 == -1) {
        I1();
      }
    }
    else if (paramInt1 == 111)
    {
      if (paramInt2 == -1)
      {
        J1();
        return;
      }
      if (paramInt2 == 123)
      {
        finish();
        return;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    N1();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362831) {
      N1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558625);
    com.tplink.iot.view.quicksetup.base.d.b0(this, 2131100143);
    w1();
    paramBundle = this.p1;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getDeviceIdMD5();
    }
    this.H3 = ((QuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(QuickSetupViewModel.class));
    D1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.p0;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    if (this.K3) {
      com.tplink.iot.view.quicksetup.base.d.h(this.p1);
    }
    t1();
    u1();
    localObject = this.I3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      BlePlugConnectAPActivity.e1(BlePlugConnectAPActivity.this).setAlpha(f);
    }
  }
  
  class b
    implements Observer<i<QuickSetupComponentResult>>
  {
    b() {}
    
    public void a(@Nullable i<QuickSetupComponentResult> parami)
    {
      if ((parami != null) && (parami.b() == 0)) {
        BlePlugConnectAPActivity.f1(BlePlugConnectAPActivity.this, (QuickSetupComponentResult)parami.a());
      } else {
        BlePlugConnectAPActivity.k1(BlePlugConnectAPActivity.this, "get component fail");
      }
    }
  }
  
  class c
    implements Observer<i<QuickSetupInfoResult>>
  {
    c() {}
    
    public void a(@Nullable i<QuickSetupInfoResult> parami)
    {
      if (parami == null)
      {
        BlePlugConnectAPActivity.l1(BlePlugConnectAPActivity.this, 1);
        return;
      }
      if ((parami.b() == 0) && (parami.a() != null))
      {
        BlePlugConnectAPActivity.m1(BlePlugConnectAPActivity.this, ((QuickSetupInfoResult)parami.a()).getDeviceId());
        if (com.tplink.iot.view.quicksetup.base.d.W(BlePlugConnectAPActivity.n1(BlePlugConnectAPActivity.this))) {
          BlePlugConnectAPActivity.p1(BlePlugConnectAPActivity.this).c0();
        } else {
          BlePlugConnectAPActivity.q1(BlePlugConnectAPActivity.this);
        }
        BlePlugConnectAPActivity.this.F1();
        BlePlugConnectAPActivity.r1(BlePlugConnectAPActivity.this);
      }
      else
      {
        int i = parami.b();
        switch (i)
        {
        default: 
          BlePlugConnectAPActivity.l1(BlePlugConnectAPActivity.this, i);
          break;
        case -1705: 
        case -1704: 
        case -1703: 
          BlePlugConnectAPActivity.this.setResult(i);
          BlePlugConnectAPActivity.this.finish();
        }
      }
    }
  }
  
  class d
    implements Observer<i<InheritInfoResult>>
  {
    d() {}
    
    public void a(@Nullable i<InheritInfoResult> parami)
    {
      if ((parami != null) && (parami.b() == 0))
      {
        parami = (InheritInfoResult)parami.a();
        if (parami != null)
        {
          bool = parami.isInheritStatus();
          break label33;
        }
      }
      boolean bool = false;
      label33:
      if (bool) {
        BlePlugConnectAPActivity.s1(BlePlugConnectAPActivity.this);
      } else {
        BlePlugConnectAPActivity.q1(BlePlugConnectAPActivity.this);
      }
    }
  }
  
  class e
    implements Runnable
  {
    e() {}
    
    public void run()
    {
      if (BlePlugConnectAPActivity.this.isDestroyed()) {
        return;
      }
      BlePlugConnectAPActivity.g1(BlePlugConnectAPActivity.this, "ble disable");
    }
  }
  
  class f
    implements g<u>
  {
    f() {}
    
    public void a(u paramu)
      throws Exception
    {
      if (paramu.b() == 0)
      {
        BlePlugConnectAPActivity.o1(BlePlugConnectAPActivity.this, new QuickSetupInfoBean(paramu.a(), BlePlugConnectAPActivity.h1(BlePlugConnectAPActivity.this)));
        BlePlugConnectAPActivity.p1(BlePlugConnectAPActivity.this).X();
      }
      else if (paramu.b() == 64036)
      {
        BlePlugConnectAPActivity.g1(BlePlugConnectAPActivity.this, "ble scan, no find device");
      }
      else
      {
        BlePlugConnectAPActivity.i1(BlePlugConnectAPActivity.this, "ble connect device fail");
      }
    }
  }
  
  class g
    implements TPMaterialDialogV2.d
  {
    g() {}
    
    public void onClick(View paramView)
    {
      BlePlugConnectAPActivity.j1(BlePlugConnectAPActivity.this, true);
      com.tplink.iot.view.quicksetup.base.d.Z(BlePlugConnectAPActivity.n1(BlePlugConnectAPActivity.this), "ConnectingWiFiPage");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\BlePlugConnectAPActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */