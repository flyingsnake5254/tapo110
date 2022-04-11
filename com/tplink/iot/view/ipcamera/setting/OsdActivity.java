package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityOsdNewIpcBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.OsdViewModel;

public class OsdActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ActivityOsdNewIpcBinding y;
  private OsdViewModel z;
  
  private void e1()
  {
    this.z.l.observe(this, new p3(this));
    this.z.m.observe(this, new m3(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.z.D();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362247) {
      OSDTextSettingActivity.y.a(this.z.j, this);
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityOsdNewIpcBinding)DataBindingUtil.setContentView(this, 2131558595));
    OsdViewModel localOsdViewModel = (OsdViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(OsdViewModel.class);
    this.z = localOsdViewModel;
    this.y.i(localOsdViewModel);
    this.y.h(this);
    this.y.p1.setNavigationOnClickListener(new n3(this));
    this.z.z();
    this.y.x.setOnClickListener(new k3(this, paramBundle));
    this.y.z.setOnClickListener(new o3(this, paramBundle));
    this.y.y.setOnClickListener(new l3(this, paramBundle));
    e1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\OsdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */