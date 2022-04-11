package com.tplink.iot.view.iotsensor;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.databinding.ActivitySensorSettingsBinding;
import com.tplink.iot.devicecommon.view.IoTDeviceInfoCommonActivity;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.iotcommon.IoTSettingAvatarActivity;
import com.tplink.iot.view.iotcommon.IoTSettingLocationSelectActivity;
import com.tplink.iot.view.iotcommon.IoTSettingNameActivity;
import com.tplink.iot.viewmodel.iotsensor.SensorSettingViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SensorSettingsActivity
  extends SensorBaseActivity<SensorSettingViewModel>
  implements View.OnClickListener
{
  private ActivitySensorSettingsBinding p0;
  
  public SensorSettingsActivity()
  {
    super(SensorSettingViewModel.class);
  }
  
  private final void k1()
  {
    s0.l(this);
    ((SensorSettingViewModel)f1()).f(e1());
  }
  
  private final void p1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private final void q1()
  {
    if (((SensorSettingViewModel)f1()).z()) {
      s1();
    } else {
      r1();
    }
  }
  
  private final void r1()
  {
    b.d.w.c.a.a("sensor showRemoveOwnerDeviceDialog");
    int i = ((SensorSettingViewModel)f1()).r();
    String str;
    if (i <= 0)
    {
      str = getString(2131953910);
      j.d(str, "getString(R.string.share…e_share_device_no_longer)");
    }
    else if (i == 1)
    {
      str = getString(2131953923, new Object[] { String.valueOf(i) });
      j.d(str, "getString(R.string.share…e_user, count.toString())");
    }
    else
    {
      str = getString(2131953922, new Object[] { String.valueOf(i) });
      j.d(str, "getString(R.string.share…eletes, count.toString())");
    }
    new TPMaterialDialogV2.Builder(this).j(str).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new a(this)).g(8, 8).b(false).c(false).a().show();
  }
  
  private final void s1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953910)).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new b(this)).g(8, 8).b(false).c(false).a().show();
  }
  
  private final void t1()
  {
    s0.l(this);
    ((SensorSettingViewModel)f1()).D(e1());
  }
  
  public void h1()
  {
    Object localObject = DataBindingUtil.setContentView(this, 2131558654);
    j.d(localObject, "DataBindingUtil.setConte…activity_sensor_settings)");
    localObject = (ActivitySensorSettingsBinding)localObject;
    this.p0 = ((ActivitySensorSettingsBinding)localObject);
    if (localObject == null) {
      j.t("mBinding");
    }
    ((ActivitySensorSettingsBinding)localObject).i((SensorSettingViewModel)f1());
    ((ActivitySensorSettingsBinding)localObject).h(this);
    ((ViewDataBinding)localObject).setLifecycleOwner(this);
    b1(2131952403);
  }
  
  public void i1()
  {
    if (j.a((Boolean)((SensorSettingViewModel)f1()).C().getValue(), Boolean.TRUE)) {
      ((SensorSettingViewModel)f1()).s();
    }
  }
  
  public void j1()
  {
    ((SensorSettingViewModel)f1()).t().observe(this, new c(this));
    ((SensorSettingViewModel)f1()).k().observe(this, new d(this));
    ((SensorSettingViewModel)f1()).y().observe(this, new e(this));
    ((SensorSettingViewModel)f1()).t().observe(this, new f(this));
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362956: 
      X0(SensorSetSensitivityActivity.class, e1());
      break;
    case 2131362950: 
      X0(SensorSetReportIntervalActivity.class, e1());
      break;
    case 2131362936: 
      X0(IoTSettingNameActivity.class, e1());
      break;
    case 2131362930: 
      paramView = (BaseALIoTDevice)((SensorSettingViewModel)f1()).l().getValue();
      if (paramView != null)
      {
        paramView = paramView.getDeviceId();
        if (paramView != null) {
          IoTSettingLocationSelectActivity.o1(this, paramView);
        }
      }
      break;
    case 2131362917: 
      X0(IoTFirmwareUpdateActivity.class, e1());
      break;
    case 2131362906: 
      X0(IoTDeviceInfoCommonActivity.class, e1());
      break;
    case 2131362888: 
      X0(IoTSettingAvatarActivity.class, e1());
      break;
    case 2131362097: 
      q1();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    ((SensorSettingViewModel)f1()).p();
    if (com.tplink.iot.Utils.w0.a.g(e1(), EnumIoTComponent.SENSITIVITY)) {
      ((SensorSettingViewModel)f1()).w();
    }
  }
  
  static final class a
    implements TPMaterialDialogV2.d
  {
    a(SensorSettingsActivity paramSensorSettingsActivity) {}
    
    public final void onClick(View paramView)
    {
      SensorSettingsActivity.o1(this.a);
    }
  }
  
  static final class b
    implements TPMaterialDialogV2.d
  {
    b(SensorSettingsActivity paramSensorSettingsActivity) {}
    
    public final void onClick(View paramView)
    {
      SensorSettingsActivity.l1(this.a);
    }
  }
  
  static final class c<T>
    implements Observer<ThingFirmware>
  {
    c(SensorSettingsActivity paramSensorSettingsActivity) {}
    
    public final void a(ThingFirmware paramThingFirmware)
    {
      if (paramThingFirmware != null) {
        SensorSettingsActivity.m1(this.a).q.setNotificationVisible(true);
      }
    }
  }
  
  static final class d<T>
    implements Observer<i<CloudResult<p>>>
  {
    d(SensorSettingsActivity paramSensorSettingsActivity) {}
    
    public final void a(i<CloudResult<p>> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        this.a.Y0();
      } else {
        SensorSettingsActivity.n1(this.a);
      }
    }
  }
  
  static final class e<T>
    implements Observer<i<p>>
  {
    e(SensorSettingsActivity paramSensorSettingsActivity) {}
    
    public final void a(i<p> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        this.a.Y0();
      } else {
        SensorSettingsActivity.n1(this.a);
      }
    }
  }
  
  static final class f<T>
    implements Observer<ThingFirmware>
  {
    f(SensorSettingsActivity paramSensorSettingsActivity) {}
    
    public final void a(ThingFirmware paramThingFirmware)
    {
      ItemSettingLayout localItemSettingLayout = SensorSettingsActivity.m1(this.a).q;
      boolean bool = true;
      if ((paramThingFirmware == null) || (paramThingFirmware.isNeedToUpgrade() != true)) {
        bool = false;
      }
      localItemSettingLayout.setNotificationVisible(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotsensor\SensorSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */