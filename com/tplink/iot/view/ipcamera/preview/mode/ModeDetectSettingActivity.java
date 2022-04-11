package com.tplink.iot.view.ipcamera.preview.mode;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityModeDetectSettingBinding;
import com.tplink.iot.view.ipcamera.setting.AlarmSettingActivity;
import com.tplink.iot.view.ipcamera.setting.AlarmSettingActivity.a;
import com.tplink.iot.view.ipcamera.setting.AreaIntrusionActivity;
import com.tplink.iot.view.ipcamera.setting.AreaIntrusionActivity.a;
import com.tplink.iot.view.ipcamera.setting.LineCrossingDetectionActivity;
import com.tplink.iot.view.ipcamera.setting.LineCrossingDetectionActivity.a;
import com.tplink.iot.view.ipcamera.setting.MotionDetectionActivity;
import com.tplink.iot.view.ipcamera.setting.MotionDetectionActivity.a;
import com.tplink.iot.view.ipcamera.setting.MsgPushActivity;
import com.tplink.iot.view.ipcamera.setting.MsgPushActivity.a;
import com.tplink.iot.view.ipcamera.setting.VideoTamperingActivity;
import com.tplink.iot.view.ipcamera.setting.VideoTamperingActivity.a;
import com.tplink.iot.view.ipcamera.setting.aidetection.AIDetectionActivity;
import com.tplink.iot.view.ipcamera.setting.aidetection.AIDetectionActivity.a;
import com.tplink.iot.view.ipcamera.setting.targrttrack.TargetTrackActivity;
import com.tplink.iot.view.ipcamera.setting.targrttrack.TargetTrackActivity.a;
import com.tplink.iot.viewmodel.ipcamera.play.ModeDetectionSettingsViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class ModeDetectSettingActivity
  extends BaseActivity
{
  private String p0;
  private boolean p1;
  private ActivityModeDetectSettingBinding y;
  private ModeDetectionSettingsViewModel z;
  
  private void e1()
  {
    int i = com.tplink.iot.view.ipcamera.base.c.b((DeviceModel)this.z.G.get());
    this.z.H.set(getResources().getDrawable(i));
  }
  
  public static void m1(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, ModeDetectSettingActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("detection_home_mode", paramBoolean);
    paramActivity.startActivity(localIntent);
  }
  
  private void onClick(View paramView)
  {
    int i = paramView.getId();
    int j = 1;
    int k = 1;
    int m = 1;
    int n = 1;
    int i1 = 1;
    int i2 = 1;
    int i3 = 1;
    int i4 = 1;
    Object localObject;
    switch (i)
    {
    default: 
      break;
    case 2131364156: 
      paramView = TargetTrackActivity.y;
      localObject = this.p0;
      if (!this.p1) {
        i4 = 2;
      }
      paramView.a(this, (String)localObject, i4);
      break;
    case 2131363562: 
      if (this.z.v.get())
      {
        localObject = MsgPushActivity.y;
        paramView = this.p0;
        if (this.p1) {
          i4 = j;
        } else {
          i4 = 2;
        }
        ((MsgPushActivity.a)localObject).a(this, paramView, i4);
      }
      break;
    case 2131363342: 
      if (this.z.n.get())
      {
        if (this.p1) {
          i4 = k;
        } else {
          i4 = 2;
        }
        VideoTamperingActivity.y.a(this, this.p0, i4);
      }
      break;
    case 2131363310: 
      paramView = MotionDetectionActivity.y;
      localObject = this.p0;
      if (this.p1) {
        i4 = m;
      } else {
        i4 = 2;
      }
      paramView.a(this, (String)localObject, i4);
      break;
    case 2131363304: 
      if (this.z.p.get())
      {
        if (this.p1) {
          i4 = n;
        } else {
          i4 = 2;
        }
        LineCrossingDetectionActivity.y.a(this, this.p0, i4);
      }
      break;
    case 2131363294: 
      if (this.z.o.get())
      {
        if (this.p1) {
          i4 = i1;
        } else {
          i4 = 2;
        }
        AreaIntrusionActivity.y.a(this, this.p0, i4);
      }
      break;
    case 2131361949: 
      localObject = AlarmSettingActivity.y;
      paramView = this.p0;
      if (this.p1) {
        i4 = i2;
      } else {
        i4 = 2;
      }
      ((AlarmSettingActivity.a)localObject).a(this, paramView, i4);
      break;
    case 2131361946: 
      paramView = AIDetectionActivity.y;
      localObject = this.p0;
      if (this.p1) {
        i4 = i3;
      } else {
        i4 = 2;
      }
      paramView.a(this, (String)localObject, i4);
    }
  }
  
  public void onBackPressed()
  {
    if (this.z.m())
    {
      new UniversalDialog.a().q(getString(2131952090)).u(getString(2131954369)).s(getString(2131951757)).t(new c(this)).r(new d(this)).l().show(getSupportFragmentManager(), "");
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.p1 = getIntent().getBooleanExtra("detection_home_mode", true);
    this.p0 = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityModeDetectSettingBinding)DataBindingUtil.setContentView(this, 2131558582));
    paramBundle = (ModeDetectionSettingsViewModel)ViewModelProviders.of(this).get(ModeDetectionSettingsViewModel.class);
    this.z = paramBundle;
    this.y.i(paramBundle);
    this.y.h(new b(this));
    setSupportActionBar(this.y.p2);
    this.y.p2.setNavigationOnClickListener(new a(this));
    e1();
    this.z.k(this.p0, this.p1);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.z.y();
    this.z.i();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\mode\ModeDetectSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */