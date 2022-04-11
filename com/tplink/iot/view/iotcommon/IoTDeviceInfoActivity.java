package com.tplink.iot.view.iotcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotcommon.IoTDeviceInfoViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.DeviceTimeInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

@Deprecated
public class IoTDeviceInfoActivity
  extends BaseActivity
{
  private ItemSettingLayout H3;
  private TextView I3;
  private IoTDeviceInfoViewModel J3;
  private LocalIoTBaseDevice K3;
  private boolean L3 = false;
  private String M3;
  private ItemSettingLayout p0;
  private ItemSettingLayout p1;
  private ItemSettingLayout p2;
  private ItemSettingLayout p3;
  private ItemSettingLayout y;
  private ItemSettingLayout z;
  
  private void g1()
  {
    c1(getString(2131952537));
    Object localObject = (ItemSettingLayout)findViewById(2131362982);
    this.y = ((ItemSettingLayout)localObject);
    ((RelativeLayout)localObject).setVisibility(8);
    this.z = ((ItemSettingLayout)findViewById(2131362990));
    this.p0 = ((ItemSettingLayout)findViewById(2131362934));
    this.p1 = ((ItemSettingLayout)findViewById(2131362927));
    this.p2 = ((ItemSettingLayout)findViewById(2131362931));
    this.p3 = ((ItemSettingLayout)findViewById(2131362921));
    this.H3 = ((ItemSettingLayout)findViewById(2131362917));
    localObject = this.z.getItemRightTextView();
    this.I3 = ((TextView)localObject);
    ((TextView)localObject).setVisibility(0);
    this.I3.setOnClickListener(new a(this));
  }
  
  private void l1()
  {
    this.J3.i().observe(this, new b(this));
    this.J3.j().observe(this, new a());
  }
  
  private void m1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (((paramBaseALIoTDevice instanceof ALIoTDevice)) && (paramBaseALIoTDevice.getLocalIoTDevice() != null))
    {
      LocalIoTBaseDevice localLocalIoTBaseDevice = (LocalIoTBaseDevice)paramBaseALIoTDevice.getLocalIoTDevice();
      this.K3 = localLocalIoTBaseDevice;
      if (this.J3.a.get() >= 2) {
        if (TextUtils.isEmpty(localLocalIoTBaseDevice.getRegion()))
        {
          this.y.setVisibility(8);
        }
        else
        {
          this.y.setVisibility(0);
          this.y.setItemInfo(localLocalIoTBaseDevice.getRegion());
        }
      }
      this.z.setItemInfo(localLocalIoTBaseDevice.getSsid());
      l.q(this, this.I3, localLocalIoTBaseDevice.getSignalLevel(), localLocalIoTBaseDevice.getRssi(), this.L3);
      paramBaseALIoTDevice = this.p0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131951830));
      localStringBuilder.append(" ");
      localStringBuilder.append(localLocalIoTBaseDevice.getModel());
      paramBaseALIoTDevice.setItemInfo(localStringBuilder.toString());
      this.p1.setItemInfo(localLocalIoTBaseDevice.getIp());
      this.p2.setItemInfo(l.a(localLocalIoTBaseDevice.getMac()));
      this.p3.setItemInfo(localLocalIoTBaseDevice.getHwVer());
      this.H3.setItemInfo(localLocalIoTBaseDevice.getFwVer());
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558546);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.J3 = ((IoTDeviceInfoViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(IoTDeviceInfoViewModel.class));
    this.M3 = paramBundle;
    g1();
    l1();
    this.J3.k();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<DeviceTimeInfo>
  {
    a() {}
    
    public void a(@Nullable DeviceTimeInfo paramDeviceTimeInfo)
    {
      if (IoTDeviceInfoActivity.e1(IoTDeviceInfoActivity.this).a.get() == 1) {
        if (paramDeviceTimeInfo != null)
        {
          if (TextUtils.isEmpty(paramDeviceTimeInfo.getRegion()))
          {
            IoTDeviceInfoActivity.f1(IoTDeviceInfoActivity.this).setVisibility(8);
          }
          else
          {
            IoTDeviceInfoActivity.f1(IoTDeviceInfoActivity.this).setVisibility(0);
            IoTDeviceInfoActivity.f1(IoTDeviceInfoActivity.this).setItemInfo(paramDeviceTimeInfo.getRegion());
          }
        }
        else {
          IoTDeviceInfoActivity.f1(IoTDeviceInfoActivity.this).setVisibility(8);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotcommon\IoTDeviceInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */