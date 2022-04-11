package com.tplink.iot.view.quicksetup.ble;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.view.quicksetup.common.SetupSuccessActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;

public class ConnectWiFiPairActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String H3;
  private TextView I3;
  private Animation J3;
  private ImageView K3;
  private TPMaterialDialogV2 L3;
  private long M3 = 0L;
  private QuickSetupViewModel p0;
  private boolean p1;
  private boolean p2;
  private boolean p3;
  private QuickSetupInfoBean y;
  private QuickSetupDeviceInfoBean z;
  
  private void j1()
  {
    this.K3.setVisibility(0);
    this.K3.startAnimation(this.J3);
    this.I3.setText(getString(2131953598));
    this.I3.setTextColor(getResources().getColor(2131099791));
    k1();
  }
  
  private void k1()
  {
    this.M3 = System.currentTimeMillis();
    this.p0.P(this.y.getResultDeviceIdMD5(), this.p1, this.p2);
  }
  
  private void l1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.y = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
        this.z = ((QuickSetupDeviceInfoBean)((Bundle)localObject).getSerializable("device_info"));
      }
    }
  }
  
  private void m1()
  {
    FindDeviceFailedActivity.m1(this, this.y, this.z);
    p1();
    finish();
  }
  
  private void n1()
  {
    if (this.p1) {
      this.p3 = true;
    }
    s1();
  }
  
  private void o1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131364644);
    Object localObject1 = this.y;
    if (localObject1 != null) {
      localObject1 = ((QuickSetupInfoBean)localObject1).getSsid();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    d0.a(localTextView, getString(2131953618, new Object[] { localObject2 }), (String)localObject2, ContextCompat.getColor(this, 2131099811));
    this.K3 = ((ImageView)findViewById(2131363029));
    localObject1 = (TextView)findViewById(2131364354);
    this.I3 = ((TextView)localObject1);
    d0.h((TextView)localObject1, getString(2131953492), ContextCompat.getColor(this, 2131099811), new a());
  }
  
  private void p1()
  {
    if (this.y != null)
    {
      int i = (int)((System.currentTimeMillis() - this.M3) / 1000L);
      r.v(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), i);
    }
  }
  
  private void q1()
  {
    if (this.y != null)
    {
      int i = (int)((System.currentTimeMillis() - this.M3) / 1000L);
      r.u(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), i);
    }
  }
  
  public static void r1(Context paramContext, QuickSetupInfoBean paramQuickSetupInfoBean, QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean)
  {
    Intent localIntent = new Intent(paramContext, ConnectWiFiPairActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("device_info_bean", paramQuickSetupInfoBean);
    localBundle.putSerializable("device_info", paramQuickSetupDeviceInfoBean);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void s1()
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      if (this.p1) {
        ((QuickSetupInfoBean)localObject).setDeviceIdMD5(((QuickSetupInfoBean)localObject).getResultDeviceIdMD5());
      }
      localObject = new CommonQuickSetupBean(this.y.getDeviceIdMD5(), this.y.getComponentResult());
    }
    else
    {
      localObject = null;
    }
    SetupSuccessActivity.p1(this, (CommonQuickSetupBean)localObject, this.z, 0L);
    q1();
    finish();
  }
  
  private void t1()
  {
    this.p0.b0().observe(this, new b());
  }
  
  private void u1()
  {
    this.L3 = d.h0(this, new c());
  }
  
  public void onBackPressed()
  {
    u1();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362826) {
      u1();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558490);
    this.J3 = AnimationUtils.loadAnimation(this, 2130771982);
    l1();
    paramBundle = this.y;
    if (paramBundle != null) {
      this.H3 = paramBundle.getDeviceIdMD5();
    }
    this.p1 = d.L(this.y);
    this.p2 = d.W(this.y);
    if (this.p1)
    {
      paramBundle = this.y;
      if (paramBundle == null) {
        paramBundle = "";
      } else {
        paramBundle = paramBundle.getDeviceIdMD5();
      }
      this.p0 = ((QuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(QuickSetupViewModel.class));
    }
    else
    {
      this.p0 = ((QuickSetupViewModel)ViewModelProviders.of(this).get(QuickSetupViewModel.class));
    }
    o1();
    t1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (o.a() == 0) {
      return;
    }
    Object localObject = this.L3;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.L3.dismiss();
    }
    this.p0.F();
    if (this.p3) {
      this.p0.F0(this.H3);
    }
    localObject = this.K3;
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      ConnectWiFiPairActivity.e1(ConnectWiFiPairActivity.this);
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        ConnectWiFiPairActivity.f1(ConnectWiFiPairActivity.this);
      } else {
        ConnectWiFiPairActivity.g1(ConnectWiFiPairActivity.this);
      }
    }
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      if (ConnectWiFiPairActivity.h1(ConnectWiFiPairActivity.this)) {
        ConnectWiFiPairActivity.i1(ConnectWiFiPairActivity.this, true);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\ConnectWiFiPairActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */