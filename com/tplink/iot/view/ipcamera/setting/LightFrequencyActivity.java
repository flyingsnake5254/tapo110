package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightAdjustBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.LightFrequencyViewModel;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.LightFrequencyMode;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.c;
import io.reactivex.q;

public class LightFrequencyActivity
  extends BaseActivity
{
  private LightFrequencyMode p0;
  private c p1;
  private ActivityLightAdjustBinding y;
  private LightFrequencyViewModel z;
  
  private void e1()
  {
    LightFrequencyMode localLightFrequencyMode = this.z.c.x().getLightFrequencyMode();
    this.p0 = localLightFrequencyMode;
    if (localLightFrequencyMode != null)
    {
      int i = a.a[localLightFrequencyMode.ordinal()];
      if (i != 1)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            this.y.f.setClickable(false);
            this.y.x.check(2131362793);
          }
        }
        else
        {
          this.y.d.setClickable(false);
          this.y.x.check(2131362792);
        }
      }
      else
      {
        this.y.c.setClickable(false);
        this.y.x.check(2131361986);
      }
    }
  }
  
  private void f1()
  {
    this.y.c.setOnClickListener(new b2(this));
    this.y.d.setOnClickListener(new f2(this));
    this.y.f.setOnClickListener(new g2(this));
  }
  
  private void s1()
  {
    LightFrequencyMode localLightFrequencyMode = this.p0;
    if (localLightFrequencyMode != null)
    {
      int i = a.a[localLightFrequencyMode.ordinal()];
      if (i != 1)
      {
        if (i != 3)
        {
          if (i == 4) {
            this.y.x.check(2131362793);
          }
        }
        else {
          this.y.x.check(2131362792);
        }
      }
      else {
        this.y.x.check(2131361986);
      }
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityLightAdjustBinding)DataBindingUtil.setContentView(this, 2131558559));
    this.z = ((LightFrequencyViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(LightFrequencyViewModel.class));
    this.y.y.setNavigationOnClickListener(new c2(this));
    this.y.h(this.z);
    e1();
    f1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c localc = this.p1;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public void t1(LightFrequencyMode paramLightFrequencyMode)
  {
    this.z.b.set(true);
    this.p1 = this.z.c.B1(paramLightFrequencyMode.getRaw()).H0(new e2(this, paramLightFrequencyMode), new d2(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\LightFrequencyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */