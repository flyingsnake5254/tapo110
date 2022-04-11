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
import com.tplink.iot.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityAlarmTypeBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmTypeViewModel;
import com.tplink.libtpnetwork.cameranetwork.business.model.AlertOption;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class AlarmTypeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private AlarmTypeViewModel p0;
  private String p1;
  private int p2 = 3;
  private HashMap p3;
  private ActivityAlarmTypeBinding z;
  
  private final void h1(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivityAlarmTypeBinding)localObject).f;
    j.d(localObject, "binding.sound");
    ((RadioButton)localObject).setClickable(paramBoolean1);
    localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivityAlarmTypeBinding)localObject).c;
    j.d(localObject, "binding.light");
    ((RadioButton)localObject).setClickable(paramBoolean2);
    localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivityAlarmTypeBinding)localObject).q;
    j.d(localObject, "binding.soundLight");
    ((RadioButton)localObject).setClickable(paramBoolean3);
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
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(AlarmTypeViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…ypeViewModel::class.java)");
    this.p0 = ((AlarmTypeViewModel)localObject);
    ActivityAlarmTypeBinding localActivityAlarmTypeBinding = this.z;
    if (localActivityAlarmTypeBinding == null) {
      j.t("binding");
    }
    localObject = this.p0;
    if (localObject == null) {
      j.t("viewModel");
    }
    localActivityAlarmTypeBinding.i((AlarmTypeViewModel)localObject);
    localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivityAlarmTypeBinding)localObject).h(this);
    localObject = this.p0;
    if (localObject == null) {
      j.t("viewModel");
    }
    ((AlarmTypeViewModel)localObject).g(this.p2);
  }
  
  private final void j1()
  {
    AlarmTypeViewModel localAlarmTypeViewModel = this.p0;
    if (localAlarmTypeViewModel == null) {
      j.t("viewModel");
    }
    localAlarmTypeViewModel.c.observe(this, new b(this));
    localAlarmTypeViewModel = this.p0;
    if (localAlarmTypeViewModel == null) {
      j.t("viewModel");
    }
    localAlarmTypeViewModel.a.observe(this, new c(this));
    localAlarmTypeViewModel = this.p0;
    if (localAlarmTypeViewModel == null) {
      j.t("viewModel");
    }
    localAlarmTypeViewModel.b.observe(this, new d(this));
  }
  
  public View e1(int paramInt)
  {
    if (this.p3 == null) {
      this.p3 = new HashMap();
    }
    View localView1 = (View)this.p3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.p3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void onClick(View paramView)
  {
    if (j.a(paramView, (RadioButton)e1(a.sound)))
    {
      paramView = this.p0;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.w(AlertOption.SOUND);
    }
    else if (j.a(paramView, (RadioButton)e1(a.light)))
    {
      paramView = this.p0;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.w(AlertOption.LIGHT);
    }
    else if (j.a(paramView, (RadioButton)e1(a.sound_light)))
    {
      paramView = this.p0;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.w(AlertOption.BOTH);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558441);
    j.d(paramBundle, "DataBindingUtil.setConte…yout.activity_alarm_type)");
    this.z = ((ActivityAlarmTypeBinding)paramBundle);
    i1();
    j1();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, AlarmTypeActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements Observer<AlertOption>
  {
    b(AlarmTypeActivity paramAlarmTypeActivity) {}
    
    public final void a(AlertOption paramAlertOption)
    {
      if (paramAlertOption != null)
      {
        int i = y4.a[paramAlertOption.ordinal()];
        boolean bool1 = true;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              i = 2131364075;
            } else {
              throw new NoWhenBranchMatchedException();
            }
          }
          else {
            i = 2131363227;
          }
        }
        else {
          i = 2131364073;
        }
        AlarmTypeActivity.g1(this.a).d.check(i);
        AlarmTypeActivity localAlarmTypeActivity = this.a;
        boolean bool2;
        if (paramAlertOption != AlertOption.SOUND) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        boolean bool3;
        if (paramAlertOption != AlertOption.LIGHT) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        if (paramAlertOption == AlertOption.BOTH) {
          bool1 = false;
        }
        AlarmTypeActivity.f1(localAlarmTypeActivity, bool2, bool3, bool1);
      }
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(AlarmTypeActivity paramAlarmTypeActivity) {}
    
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
    d(AlarmTypeActivity paramAlarmTypeActivity) {}
    
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\AlarmTypeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */