package com.tplink.iot.view.iotplug.settings;

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
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.view.iotcommon.IoTDeviceInfoActivity;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.iotcommon.IoTSettingAvatarActivity;
import com.tplink.iot.view.iotcommon.IoTSettingLocationSelectActivity;
import com.tplink.iot.view.iotcommon.IoTSettingNameActivity;
import com.tplink.iot.view.iotplug.settings.led.LedStatusActivity;
import com.tplink.iot.viewmodel.iotplug.PlugSettingViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumPowerOnState;
import java.util.List;

public class PlugSettingsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ItemSettingLayout H3;
  private String I3;
  private PlugSettingViewModel J3;
  private BaseALIoTDevice K3;
  private boolean L3 = true;
  private ItemSettingLayout p0;
  private ItemSettingLayout p1;
  private ItemSettingLayout p2;
  private ItemSettingLayout p3;
  private ImageView y;
  private View z;
  
  private void e1()
  {
    s0.l(this);
    this.J3.f(this.I3);
  }
  
  private int p1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.K3;
    int i;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceManagerInfo() != null) && (this.K3.getDeviceManagerInfo().getUserInfo() != null)) {
      i = this.K3.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  private void q1()
  {
    b1(2131952403);
    this.y = ((ImageView)findViewById(2131363673));
    this.p0 = ((ItemSettingLayout)findViewById(2131362936));
    this.p1 = ((ItemSettingLayout)findViewById(2131362930));
    this.p2 = ((ItemSettingLayout)findViewById(2131362917));
    Object localObject1 = (ItemSettingLayout)findViewById(2131362928);
    this.p3 = ((ItemSettingLayout)localObject1);
    ((ItemSettingLayout)localObject1).setItemInfo(getString(2131954119));
    localObject1 = (ItemSettingLayout)findViewById(2131362945);
    this.H3 = ((ItemSettingLayout)localObject1);
    ((ItemSettingLayout)localObject1).setItemInfo(getString(2131952892));
    Button localButton = (Button)findViewById(2131362097);
    localObject1 = findViewById(2131362948);
    Object localObject2 = findViewById(2131362888);
    this.z = ((View)localObject2);
    ((View)localObject2).setOnClickListener(this);
    this.p0.setOnClickListener(this);
    this.p1.setOnClickListener(this);
    this.p2.setOnClickListener(this);
    this.p3.setOnClickListener(this);
    this.H3.setOnClickListener(this);
    localButton.setOnClickListener(this);
    findViewById(2131362906).setOnClickListener(this);
    localObject2 = this.p3;
    boolean bool = a.l(this.I3);
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((RelativeLayout)localObject2).setVisibility(j);
    localObject2 = this.H3;
    if (a.h(this.I3)) {
      j = 0;
    } else {
      j = 8;
    }
    ((RelativeLayout)localObject2).setVisibility(j);
    if (a.c(this.I3)) {
      j = i;
    } else {
      j = 8;
    }
    ((View)localObject1).setVisibility(j);
    ((View)localObject1).setOnClickListener(this);
  }
  
  private boolean r1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.K3;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void s1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void t1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    if (!a.i(paramBaseALIoTDevice.getDeviceIdMD5())) {
      return;
    }
    if ((paramBaseALIoTDevice.isSupportIoTCloud()) && (paramBaseALIoTDevice.getCloudIoTDevice() != null) && (!paramBaseALIoTDevice.isUserRoleTypeDevice()))
    {
      this.z.setEnabled(true);
      this.p0.setEnabled(true);
      this.p1.setEnabled(true);
      this.p2.setEnabled(true);
      this.p3.setEnabled(true);
      this.H3.setEnabled(true);
      this.z.setAlpha(1.0F);
      this.p0.setAlpha(1.0F);
      this.p1.setAlpha(1.0F);
      this.p2.setAlpha(1.0F);
      this.p3.setAlpha(1.0F);
      this.H3.setAlpha(1.0F);
    }
    else
    {
      this.z.setEnabled(false);
      this.p0.setEnabled(false);
      this.p1.setEnabled(false);
      this.p2.setEnabled(false);
      this.p3.setEnabled(false);
      this.H3.setEnabled(false);
      this.z.setAlpha(0.5F);
      this.p0.setAlpha(0.5F);
      this.p1.setAlpha(0.5F);
      this.p2.setAlpha(0.5F);
      this.p3.setAlpha(0.5F);
      this.H3.setAlpha(0.5F);
    }
  }
  
  private void u1()
  {
    int i = p1();
    Object localObject;
    if (i <= 0)
    {
      localObject = getString(2131953910);
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
    new TPMaterialDialogV2.Builder(this).j((String)localObject).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new g()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void v1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953910)).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new h()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void w1()
  {
    this.J3.v().observe(this, new a());
    this.J3.s().observe(this, new b());
    this.J3.u().observe(this, new c());
    this.J3.n().observe(this, new d());
    this.J3.m().observe(this, new e());
    this.J3.w().observe(this, new f());
  }
  
  private void x1()
  {
    s0.l(this);
    this.J3.x(this.I3);
  }
  
  private void y1(LedInfoBean paramLedInfoBean)
  {
    if (paramLedInfoBean != null)
    {
      ItemSettingLayout localItemSettingLayout = this.p3;
      int i;
      if (paramLedInfoBean.getLocalLedStatus()) {
        i = 2131954119;
      } else {
        i = 2131954118;
      }
      localItemSettingLayout.setItemInfo(getString(i));
    }
  }
  
  private void z1(IoTPlugDevice paramIoTPlugDevice)
  {
    if (paramIoTPlugDevice != null)
    {
      this.y.setImageResource(q.h(EnumIoTAvatarType.fromString(paramIoTPlugDevice.getAvatar())));
      this.p0.setItemInfo(l.d(this, EnumDeviceType.PLUG.getDeviceType(), this.J3.o()));
      this.p2.setItemInfo(paramIoTPlugDevice.getFwVer());
      paramIoTPlugDevice = paramIoTPlugDevice.getDefaultStates();
      if ((paramIoTPlugDevice != null) && (!EnumPowerOnState.LAST_STATES.getType().equals(paramIoTPlugDevice.getType())))
      {
        if (paramIoTPlugDevice.getLightState() != null)
        {
          if (paramIoTPlugDevice.getLightState().isOn()) {
            this.H3.setItemInfo(getString(2131954119));
          } else {
            this.H3.setItemInfo(getString(2131954118));
          }
        }
        else {
          this.H3.setItemInfo(getString(2131952892));
        }
      }
      else {
        this.H3.setItemInfo(getString(2131952892));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362948: 
      X0(PlugRemoteControlActivity.class, this.I3);
      break;
    case 2131362945: 
      X0(PlugSettingPowerOnAgainActivity.class, this.I3);
      break;
    case 2131362936: 
      X0(IoTSettingNameActivity.class, this.I3);
      break;
    case 2131362930: 
      paramView = this.K3;
      if ((paramView != null) && (paramView.isSupportIoTCloud())) {
        IoTSettingLocationSelectActivity.o1(this, this.K3.getDeviceId());
      } else {
        X0(PlugSettingLocationActivity.class, this.I3);
      }
      break;
    case 2131362928: 
      LedStatusActivity.n1(this, this.I3);
      break;
    case 2131362917: 
      X0(IoTFirmwareUpdateActivity.class, this.I3);
      break;
    case 2131362906: 
      X0(IoTDeviceInfoActivity.class, this.I3);
      break;
    case 2131362888: 
      X0(IoTSettingAvatarActivity.class, this.I3);
      break;
    case 2131362097: 
      if (r1()) {
        v1();
      } else {
        u1();
      }
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558613);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.I3 = paramBundle;
    this.J3 = ((PlugSettingViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(PlugSettingViewModel.class));
    q1();
    w1();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.J3.p();
    if (a.l(this.I3)) {
      this.J3.t();
    }
    if (this.L3)
    {
      this.J3.r();
      this.L3 = false;
    }
  }
  
  class a
    implements Observer<IoTPlugDevice>
  {
    a() {}
    
    public void a(@Nullable IoTPlugDevice paramIoTPlugDevice)
    {
      PlugSettingsActivity.f1(PlugSettingsActivity.this, paramIoTPlugDevice);
    }
  }
  
  class b
    implements Observer<ThingFirmware>
  {
    b() {}
    
    public void a(@Nullable ThingFirmware paramThingFirmware)
    {
      if (paramThingFirmware != null) {
        PlugSettingsActivity.g1(PlugSettingsActivity.this).setNotificationVisible(paramThingFirmware.isNeedToUpgrade());
      }
    }
  }
  
  class c
    implements Observer<LedInfoBean>
  {
    c() {}
    
    public void a(@Nullable LedInfoBean paramLedInfoBean)
    {
      PlugSettingsActivity.h1(PlugSettingsActivity.this, paramLedInfoBean);
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
        PlugSettingsActivity.j1(PlugSettingsActivity.this, paramBaseALIoTDevice);
        PlugSettingsActivity.k1(PlugSettingsActivity.this).setItemInfo(q.e(PlugSettingsActivity.i1(PlugSettingsActivity.this)));
        paramBaseALIoTDevice = PlugSettingsActivity.this;
        PlugSettingsActivity.l1(paramBaseALIoTDevice, PlugSettingsActivity.i1(paramBaseALIoTDevice));
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
        PlugSettingsActivity.this.Y0();
      } else {
        PlugSettingsActivity.m1(PlugSettingsActivity.this);
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
        PlugSettingsActivity.this.Y0();
      } else {
        PlugSettingsActivity.m1(PlugSettingsActivity.this);
      }
    }
  }
  
  class g
    implements TPMaterialDialogV2.d
  {
    g() {}
    
    public void onClick(View paramView)
    {
      PlugSettingsActivity.n1(PlugSettingsActivity.this);
    }
  }
  
  class h
    implements TPMaterialDialogV2.d
  {
    h() {}
    
    public void onClick(View paramView)
    {
      PlugSettingsActivity.o1(PlugSettingsActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\settings\PlugSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */