package com.tplink.iot.view.iotplug.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotplug.PlugSettingViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import java.util.List;

public class PlugRemoteControlActivity
  extends BaseActivity
{
  private String p0;
  private TPSwitchCompat p1;
  private PlugSettingViewModel y;
  private BaseALIoTDevice z;
  
  private void e1()
  {
    s0.l(this);
    this.y.f(this.p0);
  }
  
  private int l1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.z;
    int i;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceManagerInfo() != null) && (this.z.getDeviceManagerInfo().getUserInfo() != null)) {
      i = this.z.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  private void m1()
  {
    c1(getString(2131953438));
    Object localObject = (TextView)findViewById(2131362926);
    if (n1()) {
      ((TextView)localObject).setText(getString(2131953447));
    } else {
      ((TextView)localObject).setText(getString(2131953432));
    }
    localObject = (TPSwitchCompat)findViewById(2131364131);
    this.p1 = ((TPSwitchCompat)localObject);
    ((TPSwitchCompat)localObject).setChecked(true);
    this.p1.setOnSwitchCheckedChangeListener(new a());
  }
  
  private boolean n1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.z;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void o1()
  {
    this.p1.setChecked(true);
    s0.p(this, getString(2131952444));
  }
  
  private void p1()
  {
    final boolean bool = n1();
    Object localObject;
    if (bool)
    {
      localObject = getString(2131953433);
    }
    else
    {
      int i = l1();
      if (i <= 0)
      {
        localObject = getString(2131953430);
      }
      else if (i == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("");
        localObject = getString(2131953429, new Object[] { ((StringBuilder)localObject).toString() });
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("");
        localObject = getString(2131953431, new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    new TPMaterialDialogV2.Builder(this).j((String)localObject).l(2131953427, 2131099804, new c()).o(2131953428, 2131099808, new b(bool)).g(8, 8).b(false).c(false).a().show();
  }
  
  private void q1()
  {
    this.y.n().observe(this, new d());
    this.y.m().observe(this, new e());
    this.y.w().observe(this, new f());
  }
  
  private void r1()
  {
    s0.l(this);
    this.y.x(this.p0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558609);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.p0 = paramBundle;
    this.y = ((PlugSettingViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(PlugSettingViewModel.class));
    m1();
    q1();
  }
  
  class a
    implements TPSwitchCompat.a
  {
    a() {}
    
    public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean2) && (!paramBoolean1)) {
        PlugRemoteControlActivity.f1(PlugRemoteControlActivity.this);
      }
    }
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b(boolean paramBoolean) {}
    
    public void onClick(View paramView)
    {
      if (bool) {
        PlugRemoteControlActivity.g1(PlugRemoteControlActivity.this);
      } else {
        PlugRemoteControlActivity.h1(PlugRemoteControlActivity.this);
      }
    }
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      PlugRemoteControlActivity.i1(PlugRemoteControlActivity.this).setChecked(true);
    }
  }
  
  class d
    implements Observer<BaseALIoTDevice>
  {
    d() {}
    
    public void a(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
    {
      if (paramBaseALIoTDevice != null) {
        PlugRemoteControlActivity.j1(PlugRemoteControlActivity.this, paramBaseALIoTDevice);
      }
    }
  }
  
  class e
    implements Observer<i<CloudResult<Void>>>
  {
    e() {}
    
    public void a(@Nullable i<CloudResult<Void>> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        PlugRemoteControlActivity.this.Y0();
      } else {
        PlugRemoteControlActivity.k1(PlugRemoteControlActivity.this);
      }
    }
  }
  
  class f
    implements Observer<i<Void>>
  {
    f() {}
    
    public void a(@Nullable i<Void> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        PlugRemoteControlActivity.this.Y0();
      } else {
        PlugRemoteControlActivity.k1(PlugRemoteControlActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\settings\PlugRemoteControlActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */