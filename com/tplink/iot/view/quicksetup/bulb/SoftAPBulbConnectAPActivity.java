package com.tplink.iot.view.quicksetup.bulb;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.v;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.bulb.quicksetup.BulbInheritAfterSetQsInfoActivity;
import com.tplink.iot.view.quicksetup.bulb.quicksetup.BulbNickNameInputActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.discovery.DiscoveryDevicePairingFailedActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupInfoResult;
import com.tplink.libtpnetwork.Utils.e0;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class SoftAPBulbConnectAPActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private QuickSetupInfoBundle H3;
  private WirelessInfoParams I3;
  private BulbQuickSetupViewModel J3;
  private boolean K3;
  private long L3;
  private TPRippleBackground p0;
  private TextView p1;
  private ValueAnimator p2;
  private com.tplink.iot.widget.plug.b p3;
  private ImageView y;
  private ImageView z;
  
  private void A1()
  {
    if ("H100".equals(this.H3.getDeviceModel()))
    {
      p1();
      ImageView localImageView = this.z;
      if (localImageView != null)
      {
        localImageView.setVisibility(0);
        this.z.setAlpha(1.0F);
        this.z.setImageResource(2131689689);
      }
    }
  }
  
  private void B1(String paramString)
  {
    Object localObject = this.H3;
    if (localObject != null) {
      localObject = ((QuickSetupInfoBundle)localObject).getDeviceModel();
    } else {
      localObject = null;
    }
    QuickSetupInfoBundle localQuickSetupInfoBundle = this.H3;
    if ((localQuickSetupInfoBundle != null) && (localQuickSetupInfoBundle.isFromQuickDiscovery()))
    {
      DiscoveryDevicePairingFailedActivity.h1(this, (String)localObject, 101);
      v.a(SoftAPBulbConnectAPActivity.class, DiscoveryDevicePairingFailedActivity.class, paramString);
    }
    else
    {
      BulbPairingFailedActivity.n1(this, this.I3, (String)localObject, 101);
      v.a(SoftAPBulbConnectAPActivity.class, BulbPairingFailedActivity.class, paramString);
    }
    int i = (int)((System.currentTimeMillis() - this.L3) / 1000L);
    r.v(this.H3.getDeviceType(), this.H3.getDeviceModel(), this.H3.getDeviceIdMD5(), i);
  }
  
  private void C1()
  {
    com.tplink.iot.view.quicksetup.bulb.utils.a.h(this, this.H3.getDeviceType(), this.H3.getDeviceModel(), "ConnectingWiFiPage");
  }
  
  private void D1()
  {
    Object localObject = com.tplink.iot.view.quicksetup.bulb.utils.b.o(this.H3.getDeviceModel());
    if ((localObject != null) && (localObject.length != 0))
    {
      int i = localObject.length;
      int j = 0;
      if (i == 1)
      {
        this.z.setVisibility(0);
        this.z.setImageResource(localObject[0]);
        localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(500L);
        this.p2 = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).addUpdateListener(new a(this));
        this.p2.setRepeatCount(-1);
        this.p2.setRepeatMode(2);
        this.p2.start();
      }
      else
      {
        this.z.setVisibility(0);
        Drawable[] arrayOfDrawable = new Drawable[localObject.length];
        while (j < localObject.length)
        {
          arrayOfDrawable[j] = getResources().getDrawable(localObject[j]);
          j++;
        }
        localObject = new TransitionDrawable(arrayOfDrawable);
        this.z.setImageDrawable((Drawable)localObject);
        localObject = new com.tplink.iot.widget.plug.b((TransitionDrawable)localObject, 1000L);
        this.p3 = ((com.tplink.iot.widget.plug.b)localObject);
        ((com.tplink.iot.widget.plug.b)localObject).d();
      }
    }
    else
    {
      this.z.setVisibility(8);
    }
  }
  
  private void E1()
  {
    this.J3.c0().observe(this, new b());
    this.J3.U().observe(this, new c());
  }
  
  private void m1()
  {
    Boolean localBoolean = Boolean.TRUE;
    q localq = q.f0(localBoolean);
    TimeUnit localTimeUnit = TimeUnit.SECONDS;
    localq.o(10L, localTimeUnit).l0(io.reactivex.d0.b.a.a()).E(new d()).F0();
    q.f0(localBoolean).o(20L, localTimeUnit).l0(io.reactivex.d0.b.a.a()).E(new e()).F0();
  }
  
  private void n1()
  {
    q.f0(Boolean.TRUE).l0(io.reactivex.d0.b.a.a()).E(new f()).F0();
  }
  
  private void o1()
  {
    TPRippleBackground localTPRippleBackground = this.p0;
    if (localTPRippleBackground != null) {
      localTPRippleBackground.f();
    }
    p1();
  }
  
  private void p1()
  {
    Object localObject = this.p2;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.p2.cancel();
      this.p2 = null;
    }
    localObject = this.p3;
    if (localObject != null)
    {
      ((com.tplink.iot.widget.plug.b)localObject).b();
      this.p3 = null;
    }
  }
  
  private void q1()
  {
    if ((!isFinishing()) && (!isDestroyed()))
    {
      this.p1.setText(2131953484);
      A1();
      this.J3.O(this.H3.getDeviceIdMD5(), this.K3);
    }
  }
  
  private void r1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.H3 = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
        this.I3 = ((WirelessInfoParams)((Bundle)localObject).getSerializable("ap_ssid"));
      }
    }
  }
  
  private void s1()
  {
    BulbNickNameInputActivity.m1(this, this.H3);
    finish();
  }
  
  private void t1(Integer paramInteger)
  {
    if (this.H3 == null) {
      return;
    }
    b.d.w.c.a.n("QuickDiscovery", "handleFindDevice");
    z1();
    int i = (int)((System.currentTimeMillis() - this.L3) / 1000L);
    int j = paramInteger.intValue();
    boolean bool = true;
    if ((j != 1) && (j != 2))
    {
      if (j == 3) {
        r.r(this.H3.getDeviceType(), this.H3.getDeviceModel(), this.H3.getDeviceIdMD5(), i);
      }
    }
    else {
      r.u(this.H3.getDeviceType(), this.H3.getDeviceModel(), this.H3.getDeviceIdMD5(), i);
    }
    if (this.K3)
    {
      if (this.H3.isSetInheritAndSuccess()) {
        com.tplink.iot.view.quicksetup.bulb.utils.a.c(this, this.H3);
      } else {
        s1();
      }
    }
    else
    {
      if (paramInteger.intValue() != 1) {
        bool = false;
      }
      this.H3.setNeedDisplayInherit(bool);
      if (bool) {
        BulbInheritAfterSetQsInfoActivity.l1(this, this.H3);
      } else {
        s1();
      }
    }
  }
  
  private void u1()
  {
    ImageView localImageView = (ImageView)findViewById(2131363728);
    this.y = localImageView;
    if (localImageView != null) {
      localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }
  }
  
  private void v1()
  {
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
    this.z = ((ImageView)findViewById(2131363729));
    this.p1 = ((TextView)findViewById(2131363739));
    if (this.H3.isFromQuickDiscovery()) {
      this.p1.setText(2131953484);
    } else {
      this.p1.setText(getString(2131953599));
    }
    Object localObject = (TPRippleBackground)findViewById(2131363731);
    this.p0 = ((TPRippleBackground)localObject);
    ((TPRippleBackground)localObject).e();
    this.y.setImageResource(com.tplink.iot.view.quicksetup.bulb.utils.b.k(this.H3.getDeviceModel()));
    localObject = this.H3;
    if ((localObject == null) || (!((QuickSetupInfoBundle)localObject).isFromQuickDiscovery())) {
      D1();
    }
    E1();
    BulbQuickSetupViewModel localBulbQuickSetupViewModel = this.J3;
    localObject = this.H3;
    localBulbQuickSetupViewModel.C0((QuickSetupInfoBundle)localObject, localBulbQuickSetupViewModel.E(this, this.I3, (QuickSetupInfoBundle)localObject));
    this.L3 = System.currentTimeMillis();
  }
  
  public static void y1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle, WirelessInfoParams paramWirelessInfoParams)
  {
    Intent localIntent = new Intent(paramContext, SoftAPBulbConnectAPActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    if (paramWirelessInfoParams != null) {
      localBundle.putSerializable("ap_ssid", paramWirelessInfoParams);
    }
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 101) && (paramInt2 == -1))
    {
      q1();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    C1();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362831) {
      C1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558667);
    d.b0(this, 2131099769);
    r1();
    this.K3 = com.tplink.iot.view.quicksetup.bulb.utils.a.e(this.H3);
    paramBundle = this.H3;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getDeviceIdMD5();
    }
    BulbQuickSetupViewModel localBulbQuickSetupViewModel = (BulbQuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbQuickSetupViewModel.class);
    this.J3 = localBulbQuickSetupViewModel;
    paramBundle = this.H3;
    if (paramBundle != null) {
      localBulbQuickSetupViewModel.B0(paramBundle.getDeviceModel());
    }
    u1();
  }
  
  public void onDestroy()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.J3;
    if (localObject != null) {
      ((BulbQuickSetupViewModel)localObject).F();
    }
    o1();
    super.onDestroy();
  }
  
  public void z1()
  {
    b.d.w.c.a.n("QuickDiscovery", "onObdSuccess");
    this.J3.u0(this.H3.getDeviceIdMD5());
    this.J3.D();
  }
  
  class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a() {}
    
    public void onGlobalLayout()
    {
      SoftAPBulbConnectAPActivity.e1(SoftAPBulbConnectAPActivity.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      SoftAPBulbConnectAPActivity.f1(SoftAPBulbConnectAPActivity.this);
    }
  }
  
  class b
    implements Observer<i<QuickSetupInfoResult>>
  {
    b() {}
    
    public void a(@Nullable i<QuickSetupInfoResult> parami)
    {
      if (parami != null)
      {
        v.b("prepare to find device");
        if ((SoftAPBulbConnectAPActivity.g1(SoftAPBulbConnectAPActivity.this).inNeedDisplayInherit()) && (SoftAPBulbConnectAPActivity.g1(SoftAPBulbConnectAPActivity.this).isSelectFollowInherit())) {
          SoftAPBulbConnectAPActivity.g1(SoftAPBulbConnectAPActivity.this).setInheritAndSuccess(true);
        }
        if (SoftAPBulbConnectAPActivity.g1(SoftAPBulbConnectAPActivity.this).isFromQuickDiscovery()) {
          SoftAPBulbConnectAPActivity.h1(SoftAPBulbConnectAPActivity.this);
        } else {
          SoftAPBulbConnectAPActivity.i1(SoftAPBulbConnectAPActivity.this);
        }
      }
    }
  }
  
  class c
    implements Observer<Integer>
  {
    c() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      if ((paramInteger != null) && (paramInteger.intValue() != 0)) {
        SoftAPBulbConnectAPActivity.j1(SoftAPBulbConnectAPActivity.this, paramInteger);
      } else {
        SoftAPBulbConnectAPActivity.k1(SoftAPBulbConnectAPActivity.this, "find device fail");
      }
    }
  }
  
  class d
    implements g<Boolean>
  {
    d() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      e0.a(AppContext.c);
    }
  }
  
  class e
    implements g<Boolean>
  {
    e() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      SoftAPBulbConnectAPActivity.l1(SoftAPBulbConnectAPActivity.this);
    }
  }
  
  class f
    implements g<Boolean>
  {
    f() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      SoftAPBulbConnectAPActivity.l1(SoftAPBulbConnectAPActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\SoftAPBulbConnectAPActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */