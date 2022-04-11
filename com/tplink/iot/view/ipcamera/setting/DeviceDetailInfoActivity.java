package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.q.b.l;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDeviceDetailInfoNewIpcBinding;
import com.tplink.iot.view.ipcamera.setting.firmware.FirmwareUpdateNewIpcActivity;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceDetailInfoViewModel;

public class DeviceDetailInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ActivityDeviceDetailInfoNewIpcBinding y;
  private DeviceDetailInfoViewModel z;
  
  private void i1()
  {
    l.e(this.z.j(), new b1(this));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((this.z.s.get()) && ((i == 2131362171) || (i == 2131362175) || (i == 2131362645)))
    {
      Toast.makeText(this, 2131952051, 0).show();
      return;
    }
    switch (i)
    {
    default: 
      break;
    case 2131364043: 
      this.z.f();
      break;
    case 2131362645: 
      if (this.z.o.get())
      {
        paramView = new Intent(this, FirmwareUpdateNewIpcActivity.class);
        paramView.putExtra("device_id_md5", this.z.j());
        startActivity(paramView);
      }
      break;
    case 2131362175: 
      if (this.z.o.get())
      {
        paramView = new Intent(this, DeviceNameEditorActivity.class);
        paramView.putExtra("device_id_md5", this.z.j());
        startActivity(paramView);
      }
      break;
    case 2131362171: 
      if (this.z.o.get()) {
        LocationSettingActivity.j1(this, this.z.j(), this.z.p.get());
      }
      break;
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityDeviceDetailInfoNewIpcBinding)DataBindingUtil.setContentView(this, 2131558496));
    paramBundle = (DeviceDetailInfoViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(DeviceDetailInfoViewModel.class);
    this.z = paramBundle;
    this.y.i(paramBundle);
    this.y.h(this);
    this.y.V3.setNavigationOnClickListener(new c1(this));
    this.z.o.set(getIntent().getBooleanExtra("online", false));
  }
  
  protected void onStart()
  {
    super.onStart();
    this.z.i();
    i1();
    if (this.z.p.get()) {
      h.y(this, this.z.h(), this.y.J3);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\DeviceDetailInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */