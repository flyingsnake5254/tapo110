package com.tplink.iot.view.ipcamera.setting.detection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDetectSettingBinding;
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
import com.tplink.iot.view.ipcamera.setting.NotificationCloseDialog;
import com.tplink.iot.view.ipcamera.setting.NotificationCloseDialog.a;
import com.tplink.iot.view.ipcamera.setting.VideoTamperingActivity;
import com.tplink.iot.view.ipcamera.setting.VideoTamperingActivity.a;
import com.tplink.iot.view.ipcamera.setting.aidetection.AIDetectionActivity;
import com.tplink.iot.view.ipcamera.setting.aidetection.AIDetectionActivity.a;
import com.tplink.iot.view.ipcamera.setting.targrttrack.TargetTrackActivity;
import com.tplink.iot.view.ipcamera.setting.targrttrack.TargetTrackActivity.a;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.detection.DetectionSettingsViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

@SuppressLint({"Registered"})
public class DetectionSettingActivity
  extends BaseActivity
{
  protected DetectionSettingsViewModel p0;
  private io.reactivex.e0.b p1 = new io.reactivex.e0.b();
  private final String y = DetectionSettingActivity.class.getSimpleName();
  protected ActivityDetectSettingBinding z;
  
  private void e1()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type:");
    localStringBuilder.append(this.p0.R.get());
    b.d.w.c.a.e("DetectSettingActivity", localStringBuilder.toString());
    int i = com.tplink.iot.view.ipcamera.base.c.b((DeviceModel)this.p0.R.get());
    this.p0.S.set(getResources().getDrawable(i));
  }
  
  private void g1()
  {
    this.p0.A.observe(this, new a(this));
    this.p0.z.observe(this, new c(this));
    this.p0.D.observe(this, new a());
  }
  
  private void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364156: 
      TargetTrackActivity.y.a(this, this.p0.y, 3);
      break;
    case 2131363562: 
      if (this.p0.n.get()) {
        MsgPushActivity.y.a(this, this.p0.y, 3);
      }
      break;
    case 2131363342: 
      if (this.p0.c.get()) {
        VideoTamperingActivity.y.a(this, this.p0.y, 3);
      }
      break;
    case 2131363310: 
      MotionDetectionActivity.y.a(this, this.p0.y, 3);
      break;
    case 2131363304: 
      if (this.p0.e.get()) {
        LineCrossingDetectionActivity.y.a(this, this.p0.y, 3);
      }
      break;
    case 2131363294: 
      if (this.p0.d.get()) {
        AreaIntrusionActivity.y.a(this, this.p0.y, 3);
      }
      break;
    case 2131361949: 
      AlarmSettingActivity.y.a(this, this.p0.y, 3);
      break;
    case 2131361946: 
      AIDetectionActivity.y.a(this, this.p0.y, 3);
    }
  }
  
  public static void s1(Activity paramActivity, String paramString)
  {
    if (paramString == null) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, DetectionSettingActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  public void f1()
  {
    boolean bool = NotificationManagerCompat.from(this).areNotificationsEnabled();
    long l = o.h0().W();
    int i;
    if (System.currentTimeMillis() - l > 86400000L) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!bool) && (i != 0))
    {
      NotificationCloseDialog localNotificationCloseDialog = new NotificationCloseDialog();
      localNotificationCloseDialog.H0(new b());
      localNotificationCloseDialog.show(getSupportFragmentManager(), "");
      o.h0().b1(System.currentTimeMillis());
    }
  }
  
  public void onBackPressed()
  {
    if (this.p0.w())
    {
      new UniversalDialog.a().q(getString(2131952090)).u(getString(2131954369)).s(getString(2131951757)).t(new b(this)).r(new f(this)).l().show(getSupportFragmentManager(), "");
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.z = ((ActivityDetectSettingBinding)DataBindingUtil.setContentView(this, 2131558495));
    if (paramBundle == null) {
      paramBundle = "";
    }
    paramBundle = (DetectionSettingsViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(DetectionSettingsViewModel.class);
    this.p0 = paramBundle;
    this.z.i(paramBundle);
    this.z.h(new d(this));
    setSupportActionBar(this.z.p2);
    this.z.p2.setNavigationOnClickListener(new e(this));
    e1();
    this.p0.X(this);
    this.p0.T();
    g1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.p1.dispose();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.p0.Z();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(Boolean paramBoolean)
    {
      if (org.apache.commons.lang.b.b(paramBoolean)) {
        DetectionSettingActivity.this.f1();
      }
    }
  }
  
  class b
    implements NotificationCloseDialog.a
  {
    b() {}
    
    public void a() {}
    
    public void b()
    {
      try
      {
        Intent localIntent1 = new android/content/Intent;
        localIntent1.<init>();
        localIntent1.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        localIntent1.putExtra("android.provider.extra.APP_PACKAGE", DetectionSettingActivity.this.getPackageName());
        localIntent1.putExtra("android.intent.extra.CHANNEL_ID", DetectionSettingActivity.this.getApplicationInfo().uid);
        localIntent1.putExtra("app_package", DetectionSettingActivity.this.getPackageName());
        localIntent1.putExtra("app_uid", DetectionSettingActivity.this.getApplicationInfo().uid);
        if ("MI 6".equals(Build.MODEL))
        {
          localIntent1.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
          localIntent1.setData(Uri.fromParts("package", DetectionSettingActivity.this.getPackageName(), null));
        }
        DetectionSettingActivity.this.startActivity(localIntent1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Intent localIntent2 = new Intent();
        localIntent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent2.setData(Uri.fromParts("package", DetectionSettingActivity.this.getPackageName(), null));
        DetectionSettingActivity.this.startActivity(localIntent2);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\detection\DetectionSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */