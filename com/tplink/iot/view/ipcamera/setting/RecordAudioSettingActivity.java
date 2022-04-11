package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityRecordAudioSettingBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordAudioSettingViewModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

public class RecordAudioSettingActivity
  extends BaseActivity
{
  private RecordAudioSettingViewModel y;
  private ActivityRecordAudioSettingBinding z;
  
  private void f1()
  {
    b1(2131952039);
    this.z.c.setOnClickListener(new r3(this));
  }
  
  private void i1()
  {
    this.y.d.observe(this, new a());
  }
  
  private void j1()
  {
    new TPLongMaterialDialogV2.Builder(this).f(2131953645, 2131099799).l(2131953644, 2131099808, new c()).i(2131953643, 2131099804, new b()).b(false).c(false).d(8, 8).t();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = ((RecordAudioSettingViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, getIntent().getStringExtra("device_id_md5"))).get(RecordAudioSettingViewModel.class));
    paramBundle = (ActivityRecordAudioSettingBinding)DataBindingUtil.setContentView(this, 2131558632);
    this.z = paramBundle;
    paramBundle.h(this.y);
    f1();
    i1();
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
          s0.p(RecordAudioSettingActivity.this, parama);
        }
      }
    }
  }
  
  class b
    implements TPLongMaterialDialogV2.d
  {
    b() {}
    
    public void onClick(View paramView)
    {
      RecordAudioSettingActivity.e1(RecordAudioSettingActivity.this).o(false);
    }
  }
  
  class c
    implements TPLongMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      RecordAudioSettingActivity.e1(RecordAudioSettingActivity.this).a.set(true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\RecordAudioSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */