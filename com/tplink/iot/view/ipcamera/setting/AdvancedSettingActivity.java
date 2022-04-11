package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityAdvancedSettingNewIpcBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.AdvancedSettingViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.DiagnoseSettingViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.LdcSettingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.Utils.j;

public class AdvancedSettingActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private UniversalDialog H3;
  private CloudTerraceControlViewModel p0;
  private LensMaskViewModel p1;
  private LdcSettingViewModel p2;
  private DiagnoseSettingViewModel p3;
  private ActivityAdvancedSettingNewIpcBinding y;
  private AdvancedSettingViewModel z;
  
  private void s1()
  {
    g.q(this.z.d);
  }
  
  private void t1()
  {
    if (this.H3 == null)
    {
      Object localObject = new UniversalDialog.a();
      ((UniversalDialog.a)localObject).q(getString(2131952352));
      ((UniversalDialog.a)localObject).u(getString(2131952353));
      ((UniversalDialog.a)localObject).s(getString(2131951757));
      ((UniversalDialog.a)localObject).t(new c(this));
      ((UniversalDialog.a)localObject).r(new f(this));
      ((UniversalDialog.a)localObject).o(2131558778);
      localObject = ((UniversalDialog.a)localObject).l();
      this.H3 = ((UniversalDialog)localObject);
      ((DialogFragment)localObject).setCancelable(false);
    }
    this.H3.show(getSupportFragmentManager(), "CorrectDialog");
  }
  
  private void u1()
  {
    this.p0.Q3.observe(this, new e(this));
    this.z.t.observe(this, new d(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364751: 
      if (this.z.h())
      {
        paramView = new Intent(this, UpnpSettingActivity.class);
        paramView.putExtra("device_id_md5", this.z.d);
        startActivity(paramView);
      }
      break;
    case 2131363780: 
      paramView = new Intent(this, RecordAudioSettingActivity.class);
      paramView.putExtra("device_id_md5", this.z.d);
      startActivity(paramView);
      break;
    case 2131363700: 
      if (this.p0.y()) {
        TSnackbar.x(this, 2131952356, 3000).N();
      } else if (this.p0.z()) {
        TSnackbar.x(this, 2131952358, 3000).N();
      } else {
        startActivity(new Intent(this, LensMaskActivity.class).putExtra("device_id_md5", this.z.d));
      }
      break;
    case 2131363619: 
      if (this.z.f())
      {
        paramView = new Intent(this, PasswordSettingActivity.class);
        paramView.putExtra("device_id_md5", this.z.d);
        startActivity(paramView);
      }
      break;
    case 2131363601: 
      paramView = new Intent(this, OsdActivity.class);
      paramView.putExtra("device_id_md5", this.z.d);
      startActivity(paramView);
      break;
    case 2131363230: 
      if (this.z.g())
      {
        paramView = new Intent(this, LightFrequencyActivity.class);
        paramView.putExtra("device_id_md5", this.z.d);
        startActivity(paramView);
      }
      break;
    case 2131363217: 
      paramView = new Intent(this, LdcSettingActivity.class);
      paramView.putExtra("device_id_md5", this.z.d);
      startActivity(paramView);
      break;
    case 2131362423: 
      paramView = new Intent(this, DiagnoseSettingActivity.class);
      paramView.putExtra("device_id_md5", this.z.d);
      startActivity(paramView);
      break;
    case 2131362265: 
      s1();
      if (j.h(this.p1.c)) {
        t1();
      } else if (this.p0.z()) {
        TSnackbar.x(this, 2131952358, 3000).N();
      } else {
        this.p0.n(true, new b(this));
      }
      break;
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityAdvancedSettingNewIpcBinding)DataBindingUtil.setContentView(this, 2131558437));
    this.z = ((AdvancedSettingViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(AdvancedSettingViewModel.class));
    Object localObject = (CloudTerraceControlViewModel)ViewModelProviders.of(this).get(CloudTerraceControlViewModel.class);
    this.p0 = ((CloudTerraceControlViewModel)localObject);
    ((CloudTerraceControlViewModel)localObject).o0(false);
    this.p0.m0(paramBundle);
    localObject = (LensMaskViewModel)ViewModelProviders.of(this).get(LensMaskViewModel.class);
    this.p1 = ((LensMaskViewModel)localObject);
    ((LensMaskViewModel)localObject).C(paramBundle);
    this.z.w();
    localObject = (LdcSettingViewModel)ViewModelProviders.of(this).get(LdcSettingViewModel.class);
    this.p2 = ((LdcSettingViewModel)localObject);
    ((LdcSettingViewModel)localObject).o(paramBundle);
    this.p2.p(this);
    localObject = (DiagnoseSettingViewModel)ViewModelProviders.of(this).get(DiagnoseSettingViewModel.class);
    this.p3 = ((DiagnoseSettingViewModel)localObject);
    ((DiagnoseSettingViewModel)localObject).r(paramBundle);
    this.p3.s(this);
    this.y.o(this.z);
    this.y.n(this.p1);
    this.y.i(this.p0);
    this.y.m(this.p2);
    this.y.l(this.p3);
    this.y.h(this);
    this.y.T3.setNavigationOnClickListener(new a(this));
    this.y.setLifecycleOwner(this);
    this.z.j();
    this.p1.D(this);
    u1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    UniversalDialog localUniversalDialog = this.H3;
    if ((localUniversalDialog != null) && (localUniversalDialog.isVisible())) {
      this.H3.dismiss();
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.z.x();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\AdvancedSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */