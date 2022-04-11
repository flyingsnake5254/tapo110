package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityUpnpSettingBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.UpnpSettingViewModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

public class UpnpSettingActivity
  extends BaseActivity
{
  private UpnpSettingViewModel y;
  private ActivityUpnpSettingBinding z;
  
  private void e1()
  {
    b1(2131954387);
    this.z.c.setOnClickListener(new w4(this));
  }
  
  private void h1()
  {
    this.y.d.observe(this, new a());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = ((UpnpSettingViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, getIntent().getStringExtra("device_id_md5"))).get(UpnpSettingViewModel.class));
    paramBundle = (ActivityUpnpSettingBinding)DataBindingUtil.setContentView(this, 2131558704);
    this.z = paramBundle;
    paramBundle.h(this.y);
    e1();
    h1();
  }
  
  class a
    implements Observer<a<String>>
  {
    a() {}
    
    public void a(a<String> parama)
    {
      if ((parama != null) && (!parama.b()))
      {
        parama = (String)parama.a();
        if (!TextUtils.isEmpty(parama)) {
          s0.p(UpnpSettingActivity.this, parama);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\UpnpSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */