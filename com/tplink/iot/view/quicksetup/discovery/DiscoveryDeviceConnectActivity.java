package com.tplink.iot.view.quicksetup.discovery;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.v;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.bulb.BulbInheritBeforeSetQsInfoActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbConnectAPActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.InheritInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class DiscoveryDeviceConnectActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView H3;
  private TPRippleBackground I3;
  private TPRippleBackground J3;
  private TextView K3;
  private ValueAnimator L3;
  private com.tplink.iot.widget.plug.b M3;
  private Handler N3;
  private volatile boolean O3;
  private BulbQuickSetupViewModel P3;
  private c Q3;
  private QuickSetupInfoBundle R3;
  private String S3;
  private boolean T3;
  private boolean U3;
  private ImageView p0;
  private ImageView p1;
  private ImageView p2;
  private ImageView p3;
  private ImageView y;
  private ImageView z;
  
  private void A1()
  {
    com.tplink.iot.view.quicksetup.bulb.utils.a.h(this, this.R3.getDeviceType(), this.R3.getDeviceModel(), "SearchDevicePage");
  }
  
  private void B1()
  {
    m1();
    y1();
    this.I3.e();
    this.J3.e();
    C1();
    this.P3.Y();
  }
  
  private void C1()
  {
    this.Q3 = q.W0(120L, TimeUnit.SECONDS).l0(io.reactivex.d0.b.a.a()).G0(new d());
  }
  
  private void D1()
  {
    this.P3.Z().observe(this, new b());
    this.P3.W().observe(this, new c());
  }
  
  private void m1()
  {
    TPRippleBackground localTPRippleBackground = this.J3;
    if (localTPRippleBackground != null) {
      localTPRippleBackground.f();
    }
    localTPRippleBackground = this.I3;
    if (localTPRippleBackground != null) {
      localTPRippleBackground.f();
    }
    n1();
  }
  
  private void n1()
  {
    Object localObject = this.L3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.L3.cancel();
      this.L3 = null;
    }
    localObject = this.M3;
    if (localObject != null)
    {
      ((com.tplink.iot.widget.plug.b)localObject).b();
      this.M3 = null;
    }
  }
  
  private void o1()
  {
    if (this.U3) {
      s1();
    } else {
      r1();
    }
  }
  
  private void p1()
  {
    if (this.T3)
    {
      this.T3 = false;
      this.P3.V();
    }
    else
    {
      r1();
    }
  }
  
  private void q1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.R3 = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
      }
    }
  }
  
  private void r1()
  {
    if (this.O3) {
      return;
    }
    this.O3 = true;
    if (this.R3 == null) {
      this.R3 = new QuickSetupInfoBundle();
    }
    this.R3.setDeviceIdMD5(this.S3);
    QuickSetupInfoBundle localQuickSetupInfoBundle = this.R3;
    localQuickSetupInfoBundle.setOnBoardingType(com.tplink.iot.view.quicksetup.bulb.utils.b.t(localQuickSetupInfoBundle.getDeviceModel()));
    this.R3.setNeedDisplayInherit(this.U3);
    SoftAPBulbConnectAPActivity.y1(this, this.R3, null);
  }
  
  private void s1()
  {
    BulbInheritBeforeSetQsInfoActivity.h1(this, this.R3, null);
  }
  
  private void t1(String paramString)
  {
    if (this.O3) {
      return;
    }
    this.O3 = true;
    Object localObject1 = this.Q3;
    if (localObject1 != null) {
      ((c)localObject1).dispose();
    }
    Object localObject2 = this.N3;
    localObject1 = null;
    if (localObject2 != null) {
      ((Handler)localObject2).removeCallbacksAndMessages(null);
    }
    localObject2 = this.R3;
    if (localObject2 != null) {
      localObject1 = ((QuickSetupInfoBundle)localObject2).getDeviceModel();
    }
    DiscoveryDevicePairingFailedActivity.h1(this, (String)localObject1, 103);
    v.a(DiscoveryDeviceConnectActivity.class, DiscoveryDevicePairingFailedActivity.class, paramString);
  }
  
  private void u1()
  {
    this.N3 = new Handler();
    this.p0 = ((ImageView)findViewById(2131361979));
    ImageView localImageView = (ImageView)findViewById(2131363730);
    this.y = localImageView;
    if (localImageView != null) {
      localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }
  }
  
  private void v1()
  {
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
    this.z = ((ImageView)findViewById(2131363729));
    this.p1 = ((ImageView)findViewById(2131363734));
    this.p2 = ((ImageView)findViewById(2131363737));
    this.p3 = ((ImageView)findViewById(2131362814));
    this.H3 = ((ImageView)findViewById(2131362815));
    this.K3 = ((TextView)findViewById(2131363739));
    this.J3 = ((TPRippleBackground)findViewById(2131363733));
    this.I3 = ((TPRippleBackground)findViewById(2131363732));
    this.y.setImageResource(com.tplink.iot.view.quicksetup.bulb.utils.b.k(this.R3.getDeviceModel()));
    D1();
    this.S3 = this.R3.getDeviceIdMD5();
    this.P3.f0(this.R3.getDeviceIdMD5());
    B1();
  }
  
  public static void w1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    Intent localIntent = new Intent(paramContext, DiscoveryDeviceConnectActivity.class);
    Bundle localBundle = new Bundle();
    if (paramQuickSetupInfoBundle != null) {
      localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    }
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void x1(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    if (d.x(paramQuickSetupComponentResult) <= 0)
    {
      b.d.w.c.a.d("parseComponentResult fail");
      z1("parse component fail");
      return;
    }
    if (this.R3 == null) {
      this.R3 = new QuickSetupInfoBundle();
    }
    this.R3.setComponentResult(paramQuickSetupComponentResult);
    this.T3 = com.tplink.iot.view.quicksetup.bulb.utils.a.e(this.R3);
    p1();
  }
  
  private void y1()
  {
    this.p3.setVisibility(4);
    this.p3.setTranslationY(0.0F);
    this.H3.setVisibility(4);
    this.H3.setTranslationY(0.0F);
    this.p0.setImageResource(2131100200);
    this.p0.setVisibility(0);
    this.p0.setTranslationY(0.0F);
    this.p0.setAlpha(1.0F);
    this.I3.setVisibility(0);
    this.I3.setTranslationY(0.0F);
    this.y.setVisibility(0);
    this.y.setAlpha(1.0F);
    this.p1.setVisibility(0);
    this.p1.setAlpha(1.0F);
    this.p2.setVisibility(0);
    this.p2.setAlpha(1.0F);
    this.K3.setText(getString(2131953578));
  }
  
  private void z1(String paramString)
  {
    t1(paramString);
  }
  
  public void finish()
  {
    this.O3 = true;
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 103) {
      B1();
    }
  }
  
  public void onBackPressed()
  {
    A1();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362831) {
      A1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558678);
    d.b0(this, 2131099769);
    q1();
    paramBundle = (BulbQuickSetupViewModel)ViewModelProviders.of(this).get(BulbQuickSetupViewModel.class);
    this.P3 = paramBundle;
    paramBundle.B0(this.R3.getDeviceModel());
    u1();
  }
  
  public void onDestroy()
  {
    this.O3 = true;
    Object localObject = this.N3;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.N3 = null;
    }
    m1();
    localObject = this.Q3;
    if (localObject != null) {
      ((c)localObject).dispose();
    }
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.O3 = false;
  }
  
  class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a() {}
    
    public void onGlobalLayout()
    {
      DiscoveryDeviceConnectActivity.e1(DiscoveryDeviceConnectActivity.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      DiscoveryDeviceConnectActivity.f1(DiscoveryDeviceConnectActivity.this);
    }
  }
  
  class b
    implements Observer<i<QuickSetupComponentResult>>
  {
    b() {}
    
    public void a(@Nullable i<QuickSetupComponentResult> parami)
    {
      if ((parami != null) && (parami.b() == 0))
      {
        DiscoveryDeviceConnectActivity.g1(DiscoveryDeviceConnectActivity.this, (QuickSetupComponentResult)parami.a());
      }
      else
      {
        b.d.w.c.a.d("getQsComponentResultLiveData fail");
        DiscoveryDeviceConnectActivity.h1(DiscoveryDeviceConnectActivity.this, "get component fail");
      }
    }
  }
  
  class c
    implements Observer<i<InheritInfoResult>>
  {
    c() {}
    
    public void a(@Nullable i<InheritInfoResult> parami)
    {
      boolean bool1 = false;
      if ((parami != null) && (parami.b() == 0))
      {
        InheritInfoResult localInheritInfoResult = (InheritInfoResult)parami.a();
        parami = DiscoveryDeviceConnectActivity.this;
        boolean bool2 = bool1;
        if (localInheritInfoResult != null)
        {
          bool2 = bool1;
          if (localInheritInfoResult.isInheritStatus()) {
            bool2 = true;
          }
        }
        DiscoveryDeviceConnectActivity.i1(parami, bool2);
      }
      else
      {
        DiscoveryDeviceConnectActivity.i1(DiscoveryDeviceConnectActivity.this, false);
      }
      DiscoveryDeviceConnectActivity.j1(DiscoveryDeviceConnectActivity.this);
    }
  }
  
  class d
    implements g<Long>
  {
    d() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      if (DiscoveryDeviceConnectActivity.k1(DiscoveryDeviceConnectActivity.this)) {
        return;
      }
      DiscoveryDeviceConnectActivity.l1(DiscoveryDeviceConnectActivity.this, "total timeout, exceed 2min");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\discovery\DiscoveryDeviceConnectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */