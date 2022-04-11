package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityAlarmSoundBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSoundViewModel;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmSoundType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class AlarmSoundActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private AlarmSoundViewModel p0;
  private String p1;
  private int p2 = 3;
  private ActivityAlarmSoundBinding z;
  
  private final void h1(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivityAlarmSoundBinding)localObject).c;
    j.d(localObject, "binding.alarm");
    ((RadioButton)localObject).setClickable(paramBoolean1);
    localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivityAlarmSoundBinding)localObject).d;
    j.d(localObject, "binding.notice");
    ((RadioButton)localObject).setClickable(paramBoolean2);
  }
  
  private final void i1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.p1 = ((String)localObject);
    this.p2 = getIntent().getIntExtra("detection_home_mode", 3);
    localObject = this.p1;
    if (localObject == null) {
      j.t("deviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(AlarmSoundViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…undViewModel::class.java)");
    this.p0 = ((AlarmSoundViewModel)localObject);
    ActivityAlarmSoundBinding localActivityAlarmSoundBinding = this.z;
    if (localActivityAlarmSoundBinding == null) {
      j.t("binding");
    }
    localObject = this.p0;
    if (localObject == null) {
      j.t("viewModel");
    }
    localActivityAlarmSoundBinding.h((AlarmSoundViewModel)localObject);
    localObject = this.p0;
    if (localObject == null) {
      j.t("viewModel");
    }
    ((AlarmSoundViewModel)localObject).f(this.p2);
  }
  
  private final void j1()
  {
    AlarmSoundViewModel localAlarmSoundViewModel = this.p0;
    if (localAlarmSoundViewModel == null) {
      j.t("viewModel");
    }
    localAlarmSoundViewModel.c.observe(this, new b(this));
    localAlarmSoundViewModel = this.p0;
    if (localAlarmSoundViewModel == null) {
      j.t("viewModel");
    }
    localAlarmSoundViewModel.a.observe(this, new c(this));
    localAlarmSoundViewModel = this.p0;
    if (localAlarmSoundViewModel == null) {
      j.t("viewModel");
    }
    localAlarmSoundViewModel.b.observe(this, new d(this));
  }
  
  private final void k1()
  {
    ActivityAlarmSoundBinding localActivityAlarmSoundBinding = this.z;
    if (localActivityAlarmSoundBinding == null) {
      j.t("binding");
    }
    localActivityAlarmSoundBinding.c.setOnClickListener(new e(this));
    localActivityAlarmSoundBinding = this.z;
    if (localActivityAlarmSoundBinding == null) {
      j.t("binding");
    }
    localActivityAlarmSoundBinding.d.setOnClickListener(new f(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558440);
    j.d(paramBundle, "DataBindingUtil.setConte…out.activity_alarm_sound)");
    this.z = ((ActivityAlarmSoundBinding)paramBundle);
    k1();
    i1();
    j1();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, AlarmSoundActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements Observer<AlarmSoundType>
  {
    b(AlarmSoundActivity paramAlarmSoundActivity) {}
    
    public final void a(AlarmSoundType paramAlarmSoundType)
    {
      int i = 2131361947;
      boolean bool1 = true;
      int j = i;
      if (paramAlarmSoundType != null)
      {
        int k = x4.a[paramAlarmSoundType.ordinal()];
        j = i;
        if (k != 1) {
          if (k == 2) {
            j = 2131363558;
          } else {
            throw new NoWhenBranchMatchedException();
          }
        }
      }
      AlarmSoundActivity.f1(this.a).f.check(j);
      AlarmSoundActivity localAlarmSoundActivity = this.a;
      boolean bool2;
      if (paramAlarmSoundType != AlarmSoundType.ALARM) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (paramAlarmSoundType == AlarmSoundType.NOTICE) {
        bool1 = false;
      }
      AlarmSoundActivity.e1(localAlarmSoundActivity, bool2, bool1);
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(AlarmSoundActivity paramAlarmSoundActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        s0.l(this.a);
      } else {
        s0.g();
      }
    }
  }
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(AlarmSoundActivity paramAlarmSoundActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        TSnackbar.y(paramBoolean, paramBoolean.getString(2131952741), -1).N();
      }
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(AlarmSoundActivity paramAlarmSoundActivity) {}
    
    public final void onClick(View paramView)
    {
      AlarmSoundActivity.g1(this.c).v(AlarmSoundType.ALARM);
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(AlarmSoundActivity paramAlarmSoundActivity) {}
    
    public final void onClick(View paramView)
    {
      AlarmSoundActivity.g1(this.c).v(AlarmSoundType.NOTICE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\AlarmSoundActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */