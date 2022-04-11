package com.tplink.iot.view.bulb.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.view.group.device.DeviceShowGroupListActivity;
import com.tplink.iot.view.iotcommon.IoTDeviceInfoActivity;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.iotcommon.IoTSettingAvatarActivity;
import com.tplink.iot.view.iotcommon.IoTSettingLocationSelectActivity;
import com.tplink.iot.view.iotcommon.IoTSettingNameActivity;
import com.tplink.iot.viewmodel.iotbulb.BulbSettingViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean.BrightnessBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.List;

public class BulbSettingsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ItemSettingLayout H3;
  private ItemSettingLayout I3;
  private View J3;
  private String K3;
  private BulbSettingViewModel L3;
  private BaseALIoTDevice M3;
  private boolean N3 = true;
  private View p0;
  private View p1;
  private ItemSettingLayout p2;
  private ItemSettingLayout p3;
  private ImageView y;
  private ImageView z;
  
  private void A1()
  {
    int i = v1();
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
    new TPMaterialDialogV2.Builder(this).j((String)localObject).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new h()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void B1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953910)).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new i()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void C1()
  {
    this.L3.r().observe(this, new a());
    this.L3.o().observe(this, new b());
    this.L3.p().observe(this, new c());
    this.L3.n().observe(this, new d());
    this.L3.B().observe(this, new e());
    this.L3.w().observe(this, new f());
    this.L3.x().observe(this, new g());
  }
  
  private void D1()
  {
    s0.l(this);
    this.L3.F(this.K3);
  }
  
  private void E1(IoTBulbDevice paramIoTBulbDevice)
  {
    if (paramIoTBulbDevice != null)
    {
      this.y.setImageResource(g.d(EnumBulbAvatarType.fromString(paramIoTBulbDevice.getAvatar())));
      this.p2.setItemInfo(l.d(this, EnumDeviceType.BULB.getDeviceType(), this.L3.t()));
      if ((paramIoTBulbDevice.getDefaultStates() != null) && (paramIoTBulbDevice.getDefaultStates().getBrightness() != null)) {
        if (TextUtils.equals(paramIoTBulbDevice.getDefaultStates().getBrightness().getType(), "custom"))
        {
          paramIoTBulbDevice = String.format("%s%%", new Object[] { String.valueOf(paramIoTBulbDevice.getDefaultStates().getBrightness().getValue()) });
          this.H3.setItemInfo(paramIoTBulbDevice);
        }
        else
        {
          this.H3.setItemInfo(getString(2131952892));
        }
      }
    }
  }
  
  private void e1()
  {
    s0.l(this);
    this.L3.f(this.K3);
  }
  
  private int v1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.M3;
    int i;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceManagerInfo() != null) && (this.M3.getDeviceManagerInfo().getUserInfo() != null)) {
      i = this.M3.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  private void w1()
  {
    Object localObject = this.M3;
    if (localObject != null)
    {
      localObject = ((BaseALIoTDevice)localObject).getDeviceId();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        DeviceShowGroupListActivity.t1(this, (String)localObject);
      }
    }
  }
  
  private void x1()
  {
    b1(2131952403);
    this.y = ((ImageView)findViewById(2131363673));
    this.p0 = findViewById(2131362888);
    this.p2 = ((ItemSettingLayout)findViewById(2131362936));
    this.p3 = ((ItemSettingLayout)findViewById(2131362930));
    this.I3 = ((ItemSettingLayout)findViewById(2131362918));
    this.J3 = findViewById(2131362891);
    this.H3 = ((ItemSettingLayout)findViewById(2131362901));
    this.p1 = findViewById(2131362915);
    this.z = ((ImageView)findViewById(2131363057));
    Button localButton = (Button)findViewById(2131362097);
    findViewById(2131362888).setOnClickListener(this);
    this.p2.setOnClickListener(this);
    this.p3.setOnClickListener(this);
    this.I3.setOnClickListener(this);
    this.J3.setOnClickListener(this);
    this.H3.setOnClickListener(this);
    findViewById(2131362906).setOnClickListener(this);
    this.p1.setOnClickListener(this);
    localButton.setOnClickListener(this);
  }
  
  private boolean y1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.M3;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void z1()
  {
    s0.p(this, getString(2131952444));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362936: 
      X0(IoTSettingNameActivity.class, this.K3);
      break;
    case 2131362930: 
      paramView = this.M3;
      if ((paramView != null) && (paramView.getLocalIoTDevice() != null)) {
        IoTSettingLocationSelectActivity.o1(this, this.M3.getDeviceId());
      }
      break;
    case 2131362918: 
      w1();
      break;
    case 2131362915: 
      X0(IoTFirmwareUpdateActivity.class, this.K3);
      break;
    case 2131362906: 
      X0(IoTDeviceInfoActivity.class, this.K3);
      break;
    case 2131362901: 
      X0(BulbDefaultStateActivity.class, this.K3);
      break;
    case 2131362891: 
      X0(BulbBrightnessPresetActivity.class, this.K3);
      break;
    case 2131362888: 
      X0(IoTSettingAvatarActivity.class, this.K3);
      break;
    case 2131362097: 
      if (y1()) {
        B1();
      } else {
        A1();
      }
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558469);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.K3 = paramBundle;
    this.L3 = ((BulbSettingViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbSettingViewModel.class));
    x1();
    C1();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.L3.u();
    this.L3.A();
    if (this.N3)
    {
      this.L3.v();
      this.N3 = false;
    }
  }
  
  class a
    implements Observer<IoTBulbDevice>
  {
    a() {}
    
    public void a(@Nullable IoTBulbDevice paramIoTBulbDevice)
    {
      BulbSettingsActivity.f1(BulbSettingsActivity.this, paramIoTBulbDevice);
    }
  }
  
  class b
    implements Observer<BaseALIoTDevice>
  {
    b() {}
    
    public void a(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
    {
      BulbSettingsActivity.i1(BulbSettingsActivity.this, paramBaseALIoTDevice);
      if (BulbSettingsActivity.g1(BulbSettingsActivity.this) != null)
      {
        BulbSettingsActivity.n1(BulbSettingsActivity.this).setItemInfo(l.h(BulbSettingsActivity.g1(BulbSettingsActivity.this)));
        if ((BulbSettingsActivity.g1(BulbSettingsActivity.this).isSupportIoTCloud()) && (BulbSettingsActivity.g1(BulbSettingsActivity.this).getCloudIoTDevice() != null) && (!BulbSettingsActivity.g1(BulbSettingsActivity.this).isUserRoleTypeDevice()))
        {
          BulbSettingsActivity.o1(BulbSettingsActivity.this).setEnabled(true);
          BulbSettingsActivity.p1(BulbSettingsActivity.this).setEnabled(true);
          BulbSettingsActivity.n1(BulbSettingsActivity.this).setEnabled(true);
          BulbSettingsActivity.q1(BulbSettingsActivity.this).setEnabled(true);
          BulbSettingsActivity.r1(BulbSettingsActivity.this).setEnabled(true);
          BulbSettingsActivity.s1(BulbSettingsActivity.this).setEnabled(true);
          BulbSettingsActivity.o1(BulbSettingsActivity.this).setAlpha(1.0F);
          BulbSettingsActivity.p1(BulbSettingsActivity.this).setAlpha(1.0F);
          BulbSettingsActivity.n1(BulbSettingsActivity.this).setAlpha(1.0F);
          BulbSettingsActivity.q1(BulbSettingsActivity.this).setAlpha(1.0F);
          BulbSettingsActivity.r1(BulbSettingsActivity.this).setAlpha(1.0F);
          BulbSettingsActivity.s1(BulbSettingsActivity.this).setAlpha(1.0F);
        }
        else
        {
          BulbSettingsActivity.o1(BulbSettingsActivity.this).setEnabled(false);
          BulbSettingsActivity.p1(BulbSettingsActivity.this).setEnabled(false);
          BulbSettingsActivity.n1(BulbSettingsActivity.this).setEnabled(false);
          BulbSettingsActivity.q1(BulbSettingsActivity.this).setEnabled(false);
          BulbSettingsActivity.r1(BulbSettingsActivity.this).setEnabled(false);
          BulbSettingsActivity.s1(BulbSettingsActivity.this).setEnabled(false);
          BulbSettingsActivity.o1(BulbSettingsActivity.this).setAlpha(0.5F);
          BulbSettingsActivity.p1(BulbSettingsActivity.this).setAlpha(0.5F);
          BulbSettingsActivity.n1(BulbSettingsActivity.this).setAlpha(0.5F);
          BulbSettingsActivity.q1(BulbSettingsActivity.this).setAlpha(0.5F);
          BulbSettingsActivity.r1(BulbSettingsActivity.this).setAlpha(0.5F);
          BulbSettingsActivity.s1(BulbSettingsActivity.this).setAlpha(0.5F);
        }
        if ((BulbSettingsActivity.g1(BulbSettingsActivity.this).isSupportIoTCloud()) && (BulbSettingsActivity.g1(BulbSettingsActivity.this).getCloudIoTDevice() != null))
        {
          BulbSettingsActivity.t1(BulbSettingsActivity.this).setEnabled(true);
          BulbSettingsActivity.t1(BulbSettingsActivity.this).setAlpha(1.0F);
        }
        else
        {
          BulbSettingsActivity.t1(BulbSettingsActivity.this).setEnabled(false);
          BulbSettingsActivity.t1(BulbSettingsActivity.this).setAlpha(0.5F);
        }
      }
    }
  }
  
  class c
    implements Observer<List<Integer>>
  {
    c() {}
    
    public void a(@Nullable List<Integer> paramList) {}
  }
  
  class d
    implements Observer<i<CloudResult<Void>>>
  {
    d() {}
    
    public void a(@Nullable i<CloudResult<Void>> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        BulbSettingsActivity.this.Y0();
      } else {
        BulbSettingsActivity.u1(BulbSettingsActivity.this);
      }
    }
  }
  
  class e
    implements Observer<i<Void>>
  {
    e() {}
    
    public void a(@Nullable i<Void> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        BulbSettingsActivity.this.Y0();
      } else {
        BulbSettingsActivity.u1(BulbSettingsActivity.this);
      }
    }
  }
  
  class f
    implements Observer<ThingFirmware>
  {
    f() {}
    
    public void a(@Nullable ThingFirmware paramThingFirmware)
    {
      ImageView localImageView = BulbSettingsActivity.h1(BulbSettingsActivity.this);
      int i;
      if ((paramThingFirmware != null) && (paramThingFirmware.isNeedToUpgrade())) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  class g
    implements Observer<List<GroupInfo>>
  {
    g() {}
    
    public void a(List<GroupInfo> paramList)
    {
      ItemSettingLayout localItemSettingLayout = BulbSettingsActivity.t1(BulbSettingsActivity.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BulbSettingsActivity.k1(BulbSettingsActivity.this).s(paramList, BulbSettingsActivity.j1(BulbSettingsActivity.this)));
      localStringBuilder.append("");
      localItemSettingLayout.setItemInfo(localStringBuilder.toString());
    }
  }
  
  class h
    implements TPMaterialDialogV2.d
  {
    h() {}
    
    public void onClick(View paramView)
    {
      BulbSettingsActivity.l1(BulbSettingsActivity.this);
    }
  }
  
  class i
    implements TPMaterialDialogV2.d
  {
    i() {}
    
    public void onClick(View paramView)
    {
      BulbSettingsActivity.m1(BulbSettingsActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\bulb\settings\BulbSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */