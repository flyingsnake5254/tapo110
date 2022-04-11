package com.tplink.iot.view.iothub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.devicecommon.view.IoTDeviceInfoCommonActivity;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.iotcommon.IoTSettingAvatarActivity;
import com.tplink.iot.view.iotcommon.IoTSettingLocationSelectActivity;
import com.tplink.iot.view.iotcommon.IoTSettingNameActivity;
import com.tplink.iot.view.iotplug.settings.led.LedStatusActivity;
import com.tplink.iot.viewmodel.iothub.HubSettingViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import java.util.List;

public class HubSettingsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ItemSettingLayout H3;
  private ItemSettingLayout I3;
  private String J3;
  private HubSettingViewModel K3;
  private BaseALIoTDevice L3;
  private boolean M3 = true;
  private View p0;
  private ItemSettingLayout p1;
  private ItemSettingLayout p2;
  private ItemSettingLayout p3;
  private ImageView y;
  private View z;
  
  private void A1(IoTHubDevice paramIoTHubDevice)
  {
    if (paramIoTHubDevice != null)
    {
      this.y.setImageResource(p.e(EnumHubAvatarType.fromString(paramIoTHubDevice.getAvatar())));
      this.p1.setItemInfo(l.e(this, EnumDeviceType.HUB.getDeviceType(), this.K3.p(), paramIoTHubDevice.getModel()));
      this.p3.setItemInfo(paramIoTHubDevice.getFwVer());
    }
  }
  
  private void e1()
  {
    s0.l(this);
    this.K3.f(this.J3);
  }
  
  private int q1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.L3;
    int i;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceManagerInfo() != null) && (this.L3.getDeviceManagerInfo().getUserInfo() != null)) {
      i = this.L3.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  private void r1()
  {
    b1(2131952403);
    this.y = ((ImageView)findViewById(2131363673));
    this.p1 = ((ItemSettingLayout)findViewById(2131362936));
    this.p2 = ((ItemSettingLayout)findViewById(2131362930));
    this.p3 = ((ItemSettingLayout)findViewById(2131362917));
    this.H3 = ((ItemSettingLayout)findViewById(2131362928));
    this.p0 = findViewById(2131362477);
    this.I3 = ((ItemSettingLayout)findViewById(2131362932));
    Object localObject = (Button)findViewById(2131362097);
    View localView = findViewById(2131362888);
    this.z = localView;
    localView.setOnClickListener(this);
    this.p1.setOnClickListener(this);
    this.p2.setOnClickListener(this);
    this.p3.setOnClickListener(this);
    this.H3.setOnClickListener(this);
    ((Button)localObject).setOnClickListener(this);
    findViewById(2131362906).setOnClickListener(this);
    boolean bool = a.l(this.J3);
    localObject = this.H3;
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((RelativeLayout)localObject).setVisibility(j);
    localObject = this.p0;
    if (bool) {
      j = i;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
  }
  
  private boolean s1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.L3;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void t1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void u1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    if ((paramBaseALIoTDevice.isSupportIoTCloud()) && (paramBaseALIoTDevice.getCloudIoTDevice() != null) && (!paramBaseALIoTDevice.isUserRoleTypeDevice()))
    {
      this.z.setEnabled(true);
      this.p1.setEnabled(true);
      this.p2.setEnabled(true);
      this.p3.setEnabled(true);
      this.H3.setEnabled(true);
      this.z.setAlpha(1.0F);
      this.p1.setAlpha(1.0F);
      this.p2.setAlpha(1.0F);
      this.p3.setAlpha(1.0F);
      this.H3.setAlpha(1.0F);
      this.I3.setAlpha(1.0F);
    }
    else
    {
      this.z.setEnabled(false);
      this.p1.setEnabled(false);
      this.p2.setEnabled(false);
      this.p3.setEnabled(false);
      this.H3.setEnabled(false);
      this.z.setAlpha(0.5F);
      this.p1.setAlpha(0.5F);
      this.p2.setAlpha(0.5F);
      this.p3.setAlpha(0.5F);
      this.H3.setAlpha(0.5F);
      this.I3.setAlpha(0.5F);
    }
  }
  
  private void v1()
  {
    int i = q1();
    Object localObject;
    if (i <= 0)
    {
      localObject = getString(2131953911);
    }
    else if (i == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      localObject = getString(2131953923, new Object[] { ((StringBuilder)localObject).toString() });
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      localObject = getString(2131953922, new Object[] { ((StringBuilder)localObject).toString() });
    }
    new TPMaterialDialogV2.Builder(this).j((String)localObject).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new h()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void w1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953911)).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new i()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void x1()
  {
    this.K3.u().observe(this, new a());
    this.K3.t().observe(this, new b());
    this.K3.w().observe(this, new c());
    this.K3.n().observe(this, new d());
    this.K3.m().observe(this, new e());
    this.K3.y().observe(this, new f());
    this.K3.x().observe(this, new g());
  }
  
  private void y1()
  {
    s0.l(this);
    this.K3.z(this.J3);
  }
  
  private void z1(LedInfoBean paramLedInfoBean)
  {
    if (paramLedInfoBean != null)
    {
      ItemSettingLayout localItemSettingLayout = this.H3;
      int i;
      if (paramLedInfoBean.getLocalLedStatus()) {
        i = 2131954119;
      } else {
        i = 2131954118;
      }
      localItemSettingLayout.setItemInfo(getString(i));
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362936: 
      X0(IoTSettingNameActivity.class, this.J3);
      break;
    case 2131362930: 
      paramView = this.L3;
      if ((paramView != null) && (paramView.getLocalIoTDevice() != null)) {
        IoTSettingLocationSelectActivity.o1(this, this.L3.getDeviceId());
      }
      break;
    case 2131362928: 
      LedStatusActivity.n1(this, this.J3);
      break;
    case 2131362917: 
      X0(IoTFirmwareUpdateActivity.class, this.J3);
      break;
    case 2131362906: 
      X0(IoTDeviceInfoCommonActivity.class, this.J3);
      break;
    case 2131362888: 
      X0(IoTSettingAvatarActivity.class, this.J3);
      break;
    case 2131362097: 
      if (s1()) {
        w1();
      } else {
        v1();
      }
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558544);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.J3 = paramBundle;
    this.K3 = ((HubSettingViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(HubSettingViewModel.class));
    r1();
    x1();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.K3.r();
    if (a.l(this.J3)) {
      this.K3.v();
    }
    if (this.M3)
    {
      this.K3.s();
      this.K3.o();
      this.M3 = false;
    }
  }
  
  class a
    implements Observer<IoTHubDevice>
  {
    a() {}
    
    public void a(IoTHubDevice paramIoTHubDevice)
    {
      HubSettingsActivity.f1(HubSettingsActivity.this, paramIoTHubDevice);
    }
  }
  
  class b
    implements Observer<ThingFirmware>
  {
    b() {}
    
    public void a(@Nullable ThingFirmware paramThingFirmware)
    {
      if (paramThingFirmware != null) {
        HubSettingsActivity.g1(HubSettingsActivity.this).setNotificationVisible(paramThingFirmware.isNeedToUpgrade());
      }
    }
  }
  
  class c
    implements Observer<LedInfoBean>
  {
    c() {}
    
    public void a(@Nullable LedInfoBean paramLedInfoBean)
    {
      HubSettingsActivity.h1(HubSettingsActivity.this, paramLedInfoBean);
    }
  }
  
  class d
    implements Observer<BaseALIoTDevice>
  {
    d() {}
    
    public void a(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
    {
      if (paramBaseALIoTDevice != null)
      {
        HubSettingsActivity.j1(HubSettingsActivity.this, paramBaseALIoTDevice);
        HubSettingsActivity.k1(HubSettingsActivity.this).setItemInfo(l.h(HubSettingsActivity.i1(HubSettingsActivity.this)));
        paramBaseALIoTDevice = HubSettingsActivity.this;
        HubSettingsActivity.l1(paramBaseALIoTDevice, HubSettingsActivity.i1(paramBaseALIoTDevice));
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
        HubSettingsActivity.this.Y0();
      } else {
        HubSettingsActivity.m1(HubSettingsActivity.this);
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
        HubSettingsActivity.this.Y0();
      } else {
        HubSettingsActivity.m1(HubSettingsActivity.this);
      }
    }
  }
  
  class g
    implements Observer<LoadInfoBean>
  {
    g() {}
    
    public void a(LoadInfoBean paramLoadInfoBean)
    {
      if (paramLoadInfoBean != null) {
        HubSettingsActivity.n1(HubSettingsActivity.this).setItemInfo(HubSettingsActivity.this.getString(p.c(paramLoadInfoBean.getLoadLevel())));
      }
    }
  }
  
  class h
    implements TPMaterialDialogV2.d
  {
    h() {}
    
    public void onClick(View paramView)
    {
      HubSettingsActivity.o1(HubSettingsActivity.this);
    }
  }
  
  class i
    implements TPMaterialDialogV2.d
  {
    i() {}
    
    public void onClick(View paramView)
    {
      HubSettingsActivity.p1(HubSettingsActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\HubSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */