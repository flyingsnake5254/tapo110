package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDeviceNameEditorBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceNameEditorViewModel;
import com.tplink.iot.widget.DrawableEditText;
import io.reactivex.q;

public class DeviceNameEditorActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ActivityDeviceNameEditorBinding y;
  private DeviceNameEditorViewModel z;
  
  private void k1()
  {
    g.c(this.z.c);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363954)
    {
      k1();
      paramView = this.y.x.getText().toString().trim();
      this.z.a.set(true);
      this.z.h(paramView).H0(new f1(this, paramView), new d1(this));
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityDeviceNameEditorBinding)DataBindingUtil.setContentView(this, 2131558499));
    paramBundle = (DeviceNameEditorViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(DeviceNameEditorViewModel.class);
    this.z = paramBundle;
    paramBundle.g();
    this.y.i(this.z);
    this.y.h(this);
    this.y.z.setNavigationOnClickListener(new e1(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\DeviceNameEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */