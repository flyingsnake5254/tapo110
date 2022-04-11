package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.databinding.ActivityIntrusionScheduleSettingBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AreaIntrusionScheduleViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.Utils.j;
import java.util.ArrayList;
import java.util.List;

public class IntrusionScheduleSettingActivity
  extends AppCompatActivity
  implements View.OnClickListener
{
  private AreaIntrusionScheduleViewModel c;
  private ActivityIntrusionScheduleSettingBinding d;
  
  private void P0()
  {
    this.d.z.setMaxPeriodsNumOneDay(10);
  }
  
  public static void Y0(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, IntrusionScheduleSettingActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("detection_home_mode", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void Z0()
  {
    this.c.w(false);
    this.d.z.setRecordPlanCustomBeans(this.c.h());
    this.d.z.F(false);
  }
  
  private void a1()
  {
    new UniversalDialog.a().q(getString(2131953726)).s(getString(2131952391)).u(getString(2131952395)).t(new r1(this)).l().show(getSupportFragmentManager(), "CLEAR");
  }
  
  private void b1(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Object localObject = this.d.z.getAllRecordPlanBeans();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("savePlans");
      localStringBuilder.append(((ArrayList)localObject).size());
      a.e("ScheduleSettingActivity", localStringBuilder.toString());
      String str = this.c.z((List)localObject);
      if (!TextUtils.isEmpty(str))
      {
        localObject = new UniversalDialog.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131953870, new Object[] { Integer.valueOf(6) }));
        localStringBuilder.append("\n");
        localStringBuilder.append(getString(2131952617, new Object[] { str }));
        ((UniversalDialog.a)localObject).q(localStringBuilder.toString()).u(getString(2131952441)).l().show(getSupportFragmentManager(), "Error");
        return;
      }
    }
    this.c.w(paramBoolean);
    this.d.z.F(paramBoolean);
  }
  
  private void c1()
  {
    this.d.z.setAllWeekRecordPlanByType(1);
  }
  
  private void d1()
  {
    Toolbar localToolbar = this.d.H3;
    if (localToolbar != null)
    {
      setSupportActionBar(localToolbar);
      localToolbar.setNavigationOnClickListener(new p1(this));
    }
  }
  
  public void onBackPressed()
  {
    if (this.c.c.get())
    {
      finish();
      return;
    }
    if (this.c.k()) {
      Z0();
    } else {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363868: 
      b1(this.c.g.get() ^ true);
      break;
    case 2131363784: 
      c1();
      break;
    case 2131363783: 
      a1();
      break;
    case 2131362501: 
      b1(this.c.g.get() ^ true);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    int i = getIntent().getIntExtra("detection_home_mode", 3);
    this.d = ((ActivityIntrusionScheduleSettingBinding)DataBindingUtil.setContentView(this, 2131558545));
    paramBundle = (AreaIntrusionScheduleViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(AreaIntrusionScheduleViewModel.class);
    this.c = paramBundle;
    this.d.i(paramBundle);
    this.d.h(this);
    d1();
    P0();
    this.c.i().observe(this, new q1(this));
    this.c.j(i);
    this.c.v();
    j.c(this.c.i, this, new s1(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\IntrusionScheduleSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */