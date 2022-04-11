package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLdcSettingBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.LdcSettingViewModel;
import com.tplink.libtpnetwork.Utils.j;

public class LdcSettingActivity
  extends BaseActivity
{
  private String p0;
  private LdcSettingViewModel y;
  private ActivityLdcSettingBinding z;
  
  private void f1()
  {
    this.p0 = getIntent().getStringExtra("device_id_md5");
    LdcSettingViewModel localLdcSettingViewModel = (LdcSettingViewModel)ViewModelProviders.of(this).get(LdcSettingViewModel.class);
    this.y = localLdcSettingViewModel;
    localLdcSettingViewModel.p(this);
    this.y.o(this.p0);
  }
  
  private void g1()
  {
    t1 localt1 = new t1(this);
    this.y.g.observe(this, localt1);
  }
  
  private void h1()
  {
    ActivityLdcSettingBinding localActivityLdcSettingBinding = (ActivityLdcSettingBinding)DataBindingUtil.setContentView(this, 2131558552);
    this.z = localActivityLdcSettingBinding;
    localActivityLdcSettingBinding.setLifecycleOwner(this);
    this.z.h(this.y);
    this.z.d.setOnCheckedChangeListener(new a());
  }
  
  private void k1()
  {
    setTitle(2131952590);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f1();
    h1();
    g1();
    k1();
  }
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (!paramCompoundButton.isPressed()) {
        return;
      }
      if (paramBoolean == ((Boolean)j.e(LdcSettingActivity.e1(LdcSettingActivity.this).a, Boolean.FALSE)).booleanValue()) {
        return;
      }
      LdcSettingActivity.e1(LdcSettingActivity.this).f(paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\LdcSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */