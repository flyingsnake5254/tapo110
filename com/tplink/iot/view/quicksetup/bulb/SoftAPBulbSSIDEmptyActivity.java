package com.tplink.iot.view.quicksetup.bulb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.bulb.utils.b;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.libtpnetwork.IoTNetwork.u;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;

public class SoftAPBulbSSIDEmptyActivity
  extends BaseActivity
{
  private Handler H3;
  private boolean I3;
  private c p0;
  private Animation p1;
  private ImageView p2;
  private TextView p3;
  private QuickSetupInfoBundle y;
  private BulbQuickSetupViewModel z;
  
  private void i1()
  {
    if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
    {
      String str = com.tplink.iot.view.quicksetup.base.d.p();
      if (com.tplink.iot.view.quicksetup.base.d.O(str, this.y.getDeviceModel()))
      {
        l1(str);
      }
      else
      {
        p1();
        j1();
      }
    }
    else
    {
      p1();
      o1();
    }
  }
  
  private void j1()
  {
    Handler localHandler = this.H3;
    if (localHandler == null) {
      return;
    }
    localHandler.postDelayed(new c(), 2000L);
  }
  
  private void k1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.y = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
      }
    }
  }
  
  private void l1(String paramString)
  {
    SoftAPConnectBulbActivity.q2(this, paramString, this.y);
  }
  
  private void m1()
  {
    this.H3 = new Handler();
    this.p1 = AnimationUtils.loadAnimation(this, 2130771982);
    this.p2 = ((ImageView)findViewById(2131363029));
    Object localObject = (TextView)findViewById(2131364354);
    this.p3 = ((TextView)localObject);
    d0.h((TextView)localObject, getString(2131953492), ContextCompat.getColor(this, 2131099811), new a());
    TextView localTextView = (TextView)findViewById(2131364410);
    localObject = (ImageView)findViewById(2131363032);
    localTextView.setText(getString(2131953478, new Object[] { b.v(this.y.getDeviceModel()) }));
    ((ImageView)localObject).setImageResource(b.u(this.y.getDeviceModel()));
  }
  
  public static void n1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    Intent localIntent = new Intent(paramContext, SoftAPBulbSSIDEmptyActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void o1()
  {
    this.p0 = this.z.t0(b.l(this.y.getDeviceModel())).G0(new b());
  }
  
  private void p1()
  {
    Object localObject = this.p2;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(0);
      this.p2.startAnimation(this.p1);
    }
    localObject = this.p3;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  private void q1()
  {
    Object localObject = this.p2;
    if (localObject != null)
    {
      ((ImageView)localObject).clearAnimation();
      this.p2.setVisibility(8);
    }
    localObject = this.p3;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558676);
    c1("");
    k1();
    paramBundle = (BulbQuickSetupViewModel)ViewModelProviders.of(this).get(BulbQuickSetupViewModel.class);
    this.z = paramBundle;
    paramBundle.B0(this.y.getDeviceModel());
    m1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.I3 = true;
    Object localObject = this.p0;
    if (localObject != null) {
      ((c)localObject).dispose();
    }
    localObject = this.H3;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    q1();
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      SoftAPBulbSSIDEmptyActivity.e1(SoftAPBulbSSIDEmptyActivity.this);
    }
  }
  
  class b
    implements g<u>
  {
    b() {}
    
    public void a(u paramu)
      throws Exception
    {
      if (paramu.d()) {
        SoftAPBulbSSIDEmptyActivity.f1(SoftAPBulbSSIDEmptyActivity.this, null);
      } else {
        SoftAPBulbSSIDEmptyActivity.g1(SoftAPBulbSSIDEmptyActivity.this);
      }
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      if (SoftAPBulbSSIDEmptyActivity.h1(SoftAPBulbSSIDEmptyActivity.this)) {
        return;
      }
      SoftAPBulbSSIDEmptyActivity.g1(SoftAPBulbSSIDEmptyActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\SoftAPBulbSSIDEmptyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */