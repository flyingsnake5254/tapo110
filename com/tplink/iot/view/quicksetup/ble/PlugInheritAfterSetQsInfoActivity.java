package com.tplink.iot.view.quicksetup.ble;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.view.quicksetup.common.PlugNickNameInputActivity;
import com.tplink.iot.view.quicksetup.common.SetupSuccessActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.InheritInfoParams;

public class PlugInheritAfterSetQsInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private QuickSetupViewModel p0;
  private String p1;
  private long p2 = 0L;
  private QuickSetupInfoBean y;
  private boolean z;
  
  private void k1()
  {
    this.p2 = System.currentTimeMillis();
    this.p0.P(this.y.getResultDeviceIdMD5(), this.z, true);
  }
  
  private void l1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.y = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
      }
    }
  }
  
  private void m1()
  {
    ConnectWiFiPairActivity.r1(this, this.y, null);
    finish();
  }
  
  private void n1()
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      if (this.z) {
        ((QuickSetupInfoBean)localObject).setDeviceIdMD5(((QuickSetupInfoBean)localObject).getResultDeviceIdMD5());
      }
      localObject = new CommonQuickSetupBean(this.y.getDeviceIdMD5(), this.y.getComponentResult(), this.y.isKeepInherit());
    }
    else
    {
      localObject = null;
    }
    SetupSuccessActivity.p1(this, (CommonQuickSetupBean)localObject, null, 0L);
    q1();
    finish();
  }
  
  private void o1()
  {
    PlugNickNameInputActivity.p1(this, this.y);
  }
  
  private void p1()
  {
    ((Button)findViewById(2131362063)).setOnClickListener(this);
    ((TextView)findViewById(2131364631)).setOnClickListener(this);
  }
  
  private void q1()
  {
    if (this.y != null)
    {
      int i = (int)((System.currentTimeMillis() - this.p2) / 1000L);
      r.u(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), i);
    }
  }
  
  public static void r1(Context paramContext, QuickSetupInfoBean paramQuickSetupInfoBean)
  {
    Intent localIntent = new Intent(paramContext, PlugInheritAfterSetQsInfoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("device_info_bean", paramQuickSetupInfoBean);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void s1(boolean paramBoolean)
  {
    s0.l(this);
    this.p0.K0(new InheritInfoParams(paramBoolean));
  }
  
  private void t1()
  {
    this.p0.g0().observe(this, new a());
    this.p0.b0().observe(this, new b());
  }
  
  public void onBackPressed() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362063)
    {
      if (i == 2131364631) {
        s1(false);
      }
    }
    else
    {
      paramView = this.y;
      if (paramView != null) {
        paramView.setKeepInherit(true);
      }
      s1(true);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558607);
    l1();
    paramBundle = this.y;
    if (paramBundle != null) {
      this.p1 = paramBundle.getDeviceIdMD5();
    }
    boolean bool = d.L(this.y);
    this.z = bool;
    if (bool)
    {
      paramBundle = this.y;
      if (paramBundle == null) {
        paramBundle = "";
      } else {
        paramBundle = paramBundle.getDeviceIdMD5();
      }
      this.p0 = ((QuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(QuickSetupViewModel.class));
    }
    p1();
    t1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.I(this);
    if (this.z) {
      this.p0.F0(this.p1);
    }
  }
  
  class a
    implements Observer<i<Boolean>>
  {
    a() {}
    
    public void a(@Nullable i<Boolean> parami)
    {
      if ((parami != null) && (((Boolean)parami.a()).booleanValue()))
      {
        PlugInheritAfterSetQsInfoActivity.f1(PlugInheritAfterSetQsInfoActivity.this).F0(PlugInheritAfterSetQsInfoActivity.e1(PlugInheritAfterSetQsInfoActivity.this));
        PlugInheritAfterSetQsInfoActivity.g1(PlugInheritAfterSetQsInfoActivity.this);
      }
      else
      {
        s0.g();
        PlugInheritAfterSetQsInfoActivity.h1(PlugInheritAfterSetQsInfoActivity.this);
      }
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        PlugInheritAfterSetQsInfoActivity.i1(PlugInheritAfterSetQsInfoActivity.this);
      } else {
        PlugInheritAfterSetQsInfoActivity.j1(PlugInheritAfterSetQsInfoActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\PlugInheritAfterSetQsInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */