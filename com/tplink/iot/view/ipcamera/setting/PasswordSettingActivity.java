package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;

public class PasswordSettingActivity
  extends BaseActivity
{
  private PasswordSettingViewModel y;
  
  public PasswordSettingViewModel e1()
  {
    return this.y;
  }
  
  public void f1(int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            localObject = null;
          } else {
            localObject = new DeviceResetFragment();
          }
        }
        else {
          localObject = new CloudPasswordCheckFragment();
        }
      }
      else {
        localObject = new DevicePasswordCheckFragment();
      }
    }
    else {
      localObject = new DevicePasswordSettingFragment();
    }
    getSupportFragmentManager().beginTransaction().replace(2131362323, (Fragment)localObject, "f1").commit();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    setContentView(2131558457);
    paramBundle = (PasswordSettingViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(PasswordSettingViewModel.class);
    this.y = paramBundle;
    paramBundle.k();
    f1(this.y.l());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\PasswordSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */