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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDiagnoseStatusBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.DiagnoseSettingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

public class DiagnoseSettingActivity
  extends BaseActivity
{
  private String p0;
  private DiagnoseSettingViewModel y;
  private ActivityDiagnoseStatusBinding z;
  
  private void f1()
  {
    this.p0 = getIntent().getStringExtra("device_id_md5");
    DiagnoseSettingViewModel localDiagnoseSettingViewModel = (DiagnoseSettingViewModel)ViewModelProviders.of(this).get(DiagnoseSettingViewModel.class);
    this.y = localDiagnoseSettingViewModel;
    localDiagnoseSettingViewModel.s(this);
    this.y.r(this.p0);
  }
  
  private void g1()
  {
    o1 localo1 = new o1(this);
    this.y.g.observe(this, localo1);
    this.y.h.observe(this, new b());
  }
  
  private void h1()
  {
    ActivityDiagnoseStatusBinding localActivityDiagnoseStatusBinding = (ActivityDiagnoseStatusBinding)DataBindingUtil.setContentView(this, 2131558510);
    this.z = localActivityDiagnoseStatusBinding;
    localActivityDiagnoseStatusBinding.setLifecycleOwner(this);
    this.z.h(this.y);
    this.z.d.setOnCheckedChangeListener(new a());
  }
  
  private void k1()
  {
    setTitle(2131952580);
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
      if (paramBoolean == ((Boolean)j.e(DiagnoseSettingActivity.e1(DiagnoseSettingActivity.this).a, Boolean.FALSE)).booleanValue()) {
        return;
      }
      DiagnoseSettingActivity.e1(DiagnoseSettingActivity.this).f(paramBoolean);
    }
  }
  
  class b
    implements Observer<a<Boolean>>
  {
    b() {}
    
    public void a(@Nullable a<Boolean> parama)
    {
      if ((parama != null) && (!parama.b()))
      {
        parama = (Boolean)parama.a();
        if ((parama != null) && (parama.booleanValue())) {
          new UniversalDialog.a().w(DiagnoseSettingActivity.this.getString(2131953214)).q(DiagnoseSettingActivity.this.getString(2131953213)).u(DiagnoseSettingActivity.this.getString(2131951761)).l().show(DiagnoseSettingActivity.this.getSupportFragmentManager(), "");
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\DiagnoseSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */