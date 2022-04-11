package com.tplink.iot.view.colorbulb.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
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
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.OnOffGraduallyBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.List;

public class ColorBulbSettingsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ItemSettingLayout H3;
  private ItemSettingLayout I3;
  private View J3;
  private TPSwitchCompat K3;
  private String L3;
  private BulbSettingViewModel M3;
  private BaseALIoTDevice N3;
  private boolean O3 = true;
  private View p0;
  private View p1;
  private ItemSettingLayout p2;
  private ItemSettingLayout p3;
  private ImageView y;
  private ImageView z;
  
  private void C1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void D1()
  {
    int i = w1();
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
  
  private void E1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953910)).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new i()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void F1()
  {
    this.M3.r().observe(this, new a());
    this.M3.o().observe(this, new b());
    this.M3.n().observe(this, new c());
    this.M3.B().observe(this, new d());
    this.M3.w().observe(this, new e());
    this.M3.z().observe(this, new f());
    this.M3.x().observe(this, new g());
  }
  
  private void G1()
  {
    s0.l(this);
    this.M3.F(this.L3);
  }
  
  private void H1(IoTBulbDevice paramIoTBulbDevice)
  {
    if (paramIoTBulbDevice != null)
    {
      this.y.setImageResource(g.d(EnumBulbAvatarType.fromString(paramIoTBulbDevice.getAvatar())));
      this.p2.setItemInfo(l.d(this, EnumDeviceType.BULB.getDeviceType(), this.M3.t()));
      if (paramIoTBulbDevice.getDefaultStates() != null)
      {
        if (TextUtils.equals(paramIoTBulbDevice.getDefaultStates().getType(), "custom")) {
          this.H3.setItemInfo(getString(2131952399));
        } else {
          this.H3.setItemInfo(getString(2131952892));
        }
      }
      else {
        this.H3.setItemInfo(getString(2131952892));
      }
    }
  }
  
  private void e1()
  {
    s0.l(this);
    this.M3.f(this.L3);
  }
  
  private int w1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.N3;
    int i;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceManagerInfo() != null) && (this.N3.getDeviceManagerInfo().getUserInfo() != null)) {
      i = this.N3.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  private void x1()
  {
    Object localObject = this.N3;
    if (localObject != null)
    {
      localObject = ((BaseALIoTDevice)localObject).getDeviceId();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        DeviceShowGroupListActivity.t1(this, (String)localObject);
      }
    }
  }
  
  private void y1()
  {
    b1(2131952403);
    this.y = ((ImageView)findViewById(2131363673));
    this.p0 = findViewById(2131362888);
    this.p2 = ((ItemSettingLayout)findViewById(2131362936));
    this.p3 = ((ItemSettingLayout)findViewById(2131362930));
    this.I3 = ((ItemSettingLayout)findViewById(2131362918));
    this.H3 = ((ItemSettingLayout)findViewById(2131362901));
    this.J3 = findViewById(2131362938);
    this.K3 = ((TPSwitchCompat)findViewById(2131364128));
    this.p1 = findViewById(2131362915);
    this.z = ((ImageView)findViewById(2131363057));
    Button localButton = (Button)findViewById(2131362097);
    findViewById(2131362888).setOnClickListener(this);
    this.p2.setOnClickListener(this);
    this.p3.setOnClickListener(this);
    this.I3.setOnClickListener(this);
    this.H3.setOnClickListener(this);
    findViewById(2131362906).setOnClickListener(this);
    this.p1.setOnClickListener(this);
    localButton.setOnClickListener(this);
    this.K3.setOnSwitchCheckedChangeListener(new a(this));
  }
  
  private boolean z1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.N3;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362936: 
      X0(IoTSettingNameActivity.class, this.L3);
      break;
    case 2131362930: 
      paramView = this.N3;
      if ((paramView != null) && (paramView.getLocalIoTDevice() != null)) {
        IoTSettingLocationSelectActivity.o1(this, this.N3.getDeviceId());
      }
      break;
    case 2131362918: 
      x1();
      break;
    case 2131362915: 
      X0(IoTFirmwareUpdateActivity.class, this.L3);
      break;
    case 2131362906: 
      X0(IoTDeviceInfoActivity.class, this.L3);
      break;
    case 2131362901: 
      X0(ColorBulbDefaultStateActivity.class, this.L3);
      break;
    case 2131362888: 
      X0(IoTSettingAvatarActivity.class, this.L3);
      break;
    case 2131362097: 
      if (z1()) {
        E1();
      } else {
        D1();
      }
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558487);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.L3 = paramBundle;
    this.M3 = ((BulbSettingViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbSettingViewModel.class));
    y1();
    F1();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.M3.u();
    this.M3.y();
    if (this.O3)
    {
      this.M3.v();
      this.O3 = false;
    }
  }
  
  class a
    implements Observer<IoTBulbDevice>
  {
    a() {}
    
    public void a(@Nullable IoTBulbDevice paramIoTBulbDevice)
    {
      ColorBulbSettingsActivity.f1(ColorBulbSettingsActivity.this, paramIoTBulbDevice);
    }
  }
  
  class b
    implements Observer<BaseALIoTDevice>
  {
    b() {}
    
    public void a(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
    {
      ColorBulbSettingsActivity.i1(ColorBulbSettingsActivity.this, paramBaseALIoTDevice);
      if (ColorBulbSettingsActivity.g1(ColorBulbSettingsActivity.this) != null)
      {
        ColorBulbSettingsActivity.o1(ColorBulbSettingsActivity.this).setItemInfo(l.h(ColorBulbSettingsActivity.g1(ColorBulbSettingsActivity.this)));
        if ((ColorBulbSettingsActivity.g1(ColorBulbSettingsActivity.this).isSupportIoTCloud()) && (ColorBulbSettingsActivity.g1(ColorBulbSettingsActivity.this).getCloudIoTDevice() != null) && (!ColorBulbSettingsActivity.g1(ColorBulbSettingsActivity.this).isUserRoleTypeDevice()))
        {
          ColorBulbSettingsActivity.p1(ColorBulbSettingsActivity.this).setEnabled(true);
          ColorBulbSettingsActivity.q1(ColorBulbSettingsActivity.this).setEnabled(true);
          ColorBulbSettingsActivity.o1(ColorBulbSettingsActivity.this).setEnabled(true);
          ColorBulbSettingsActivity.r1(ColorBulbSettingsActivity.this).setEnabled(true);
          ColorBulbSettingsActivity.s1(ColorBulbSettingsActivity.this).setEnabled(true);
          ColorBulbSettingsActivity.t1(ColorBulbSettingsActivity.this).setEnabled(true);
          ColorBulbSettingsActivity.u1(ColorBulbSettingsActivity.this).setEnabled(true);
          ColorBulbSettingsActivity.p1(ColorBulbSettingsActivity.this).setAlpha(1.0F);
          ColorBulbSettingsActivity.q1(ColorBulbSettingsActivity.this).setAlpha(1.0F);
          ColorBulbSettingsActivity.o1(ColorBulbSettingsActivity.this).setAlpha(1.0F);
          ColorBulbSettingsActivity.r1(ColorBulbSettingsActivity.this).setAlpha(1.0F);
          ColorBulbSettingsActivity.s1(ColorBulbSettingsActivity.this).setAlpha(1.0F);
          ColorBulbSettingsActivity.t1(ColorBulbSettingsActivity.this).setAlpha(1.0F);
        }
        else
        {
          ColorBulbSettingsActivity.p1(ColorBulbSettingsActivity.this).setEnabled(false);
          ColorBulbSettingsActivity.q1(ColorBulbSettingsActivity.this).setEnabled(false);
          ColorBulbSettingsActivity.o1(ColorBulbSettingsActivity.this).setEnabled(false);
          ColorBulbSettingsActivity.r1(ColorBulbSettingsActivity.this).setEnabled(false);
          ColorBulbSettingsActivity.s1(ColorBulbSettingsActivity.this).setEnabled(false);
          ColorBulbSettingsActivity.t1(ColorBulbSettingsActivity.this).setEnabled(false);
          ColorBulbSettingsActivity.u1(ColorBulbSettingsActivity.this).setEnabled(false);
          ColorBulbSettingsActivity.p1(ColorBulbSettingsActivity.this).setAlpha(0.5F);
          ColorBulbSettingsActivity.q1(ColorBulbSettingsActivity.this).setAlpha(0.5F);
          ColorBulbSettingsActivity.o1(ColorBulbSettingsActivity.this).setAlpha(0.5F);
          ColorBulbSettingsActivity.r1(ColorBulbSettingsActivity.this).setAlpha(0.5F);
          ColorBulbSettingsActivity.s1(ColorBulbSettingsActivity.this).setAlpha(0.5F);
          ColorBulbSettingsActivity.t1(ColorBulbSettingsActivity.this).setAlpha(0.5F);
        }
        if ((ColorBulbSettingsActivity.g1(ColorBulbSettingsActivity.this).isSupportIoTCloud()) && (ColorBulbSettingsActivity.g1(ColorBulbSettingsActivity.this).getCloudIoTDevice() != null))
        {
          ColorBulbSettingsActivity.v1(ColorBulbSettingsActivity.this).setEnabled(true);
          ColorBulbSettingsActivity.v1(ColorBulbSettingsActivity.this).setAlpha(1.0F);
        }
        else
        {
          ColorBulbSettingsActivity.v1(ColorBulbSettingsActivity.this).setEnabled(false);
          ColorBulbSettingsActivity.v1(ColorBulbSettingsActivity.this).setAlpha(0.5F);
        }
      }
    }
  }
  
  class c
    implements Observer<i<CloudResult<Void>>>
  {
    c() {}
    
    public void a(@Nullable i<CloudResult<Void>> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        ColorBulbSettingsActivity.this.Y0();
      } else {
        ColorBulbSettingsActivity.h1(ColorBulbSettingsActivity.this);
      }
    }
  }
  
  class d
    implements Observer<i<Void>>
  {
    d() {}
    
    public void a(@Nullable i<Void> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        ColorBulbSettingsActivity.this.Y0();
      } else {
        ColorBulbSettingsActivity.h1(ColorBulbSettingsActivity.this);
      }
    }
  }
  
  class e
    implements Observer<ThingFirmware>
  {
    e() {}
    
    public void a(@Nullable ThingFirmware paramThingFirmware)
    {
      ImageView localImageView = ColorBulbSettingsActivity.j1(ColorBulbSettingsActivity.this);
      int i;
      if ((paramThingFirmware != null) && (paramThingFirmware.isNeedToUpgrade())) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  class f
    implements Observer<OnOffGraduallyBean>
  {
    f() {}
    
    public void a(@Nullable OnOffGraduallyBean paramOnOffGraduallyBean)
    {
      if (paramOnOffGraduallyBean != null) {
        ColorBulbSettingsActivity.u1(ColorBulbSettingsActivity.this).setChecked(paramOnOffGraduallyBean.isEnable());
      }
    }
  }
  
  class g
    implements Observer<List<GroupInfo>>
  {
    g() {}
    
    public void a(List<GroupInfo> paramList)
    {
      ItemSettingLayout localItemSettingLayout = ColorBulbSettingsActivity.v1(ColorBulbSettingsActivity.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ColorBulbSettingsActivity.l1(ColorBulbSettingsActivity.this).s(paramList, ColorBulbSettingsActivity.k1(ColorBulbSettingsActivity.this)));
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
      ColorBulbSettingsActivity.m1(ColorBulbSettingsActivity.this);
    }
  }
  
  class i
    implements TPMaterialDialogV2.d
  {
    i() {}
    
    public void onClick(View paramView)
    {
      ColorBulbSettingsActivity.n1(ColorBulbSettingsActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\colorbulb\settings\ColorBulbSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */