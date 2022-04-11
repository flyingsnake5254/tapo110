package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.databinding.ActivityScheduleSettingBinding;
import com.tplink.iot.view.ipcamera.setting.detection.DetectionSettingActivity;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordPlanViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordTypeDialogFragment;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordTypeDialogFragment.a;
import com.tplink.iot.viewmodel.ipcamera.setting.l9;
import com.tplink.iot.viewmodel.ipcamera.setting.m9;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.Utils.j;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

public class ScheduleSettingActivity
  extends AppCompatActivity
  implements RecordTypeDialogFragment.a, View.OnClickListener
{
  private RecordPlanViewModel c;
  private ActivityScheduleSettingBinding d;
  
  private void Q0()
  {
    if ((!this.c.j()) && (this.c.i()) && (this.c.k()))
    {
      a.e("ScheduleSettingActivity", "detect disable");
      new UniversalDialog.a().q(getString(2131952554)).u(getString(2131952527)).s(getString(2131951757)).r(new a4(this)).t(new d4(this)).l().show(getSupportFragmentManager(), "");
    }
    else if ((!this.c.j()) && (this.c.i()))
    {
      a.e("ScheduleSettingActivity", "detect disable but detect required");
      final DetectionCloseDialog localDetectionCloseDialog = new DetectionCloseDialog();
      localDetectionCloseDialog.H0(new a(localDetectionCloseDialog));
      localDetectionCloseDialog.show(getSupportFragmentManager(), "");
    }
    else if ((!this.c.i()) && (!this.c.k()))
    {
      a.e("ScheduleSettingActivity", "schedule table is empty");
      new UniversalDialog.a().q(getString(2131952547)).u(getString(2131952387)).s(getString(2131951757)).t(new y3(this)).r(new c4(this)).l().show(getSupportFragmentManager(), "");
    }
    else
    {
      a.e("ScheduleSettingActivity", "normal exit");
      finish();
    }
  }
  
  private void R0()
  {
    this.d.p2.setMaxPeriodsNumOneDay(10);
  }
  
  public static void j1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ScheduleSettingActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void k1()
  {
    this.c.D(false);
    this.d.p2.setRecordPlanCustomBeans(this.c.h());
    this.d.p2.F(false);
  }
  
  private void l1()
  {
    new UniversalDialog.a().q(getString(2131953726)).s(getString(2131952391)).u(getString(2131952395)).t(new e4(this)).l().show(getSupportFragmentManager(), "CLEAR");
  }
  
  private void m1(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Object localObject1 = this.d.p2.getAllRecordPlanBeans();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("savePlans");
      ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
      a.e("ScheduleSettingActivity", ((StringBuilder)localObject2).toString());
      localObject2 = this.c.F((List)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new UniversalDialog.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131954376, new Object[] { Integer.valueOf(10) }));
        localStringBuilder.append("\n");
        localStringBuilder.append(getString(2131952617, new Object[] { localObject2 }));
        ((UniversalDialog.a)localObject1).q(localStringBuilder.toString()).u(getString(2131952441)).l().show(getSupportFragmentManager(), "Error");
        return;
      }
    }
    this.c.D(paramBoolean);
    this.d.p2.F(paramBoolean);
    l9.a().b(this.c.g()).U();
  }
  
  private void n1()
  {
    new RecordTypeDialogFragment().show(getSupportFragmentManager(), "SELECT-ALL");
  }
  
  private void o1()
  {
    Toolbar localToolbar = this.d.K3;
    if (localToolbar != null)
    {
      setSupportActionBar(localToolbar);
      localToolbar.setNavigationOnClickListener(new f4(this));
    }
  }
  
  private void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = 1;
    if (paramInt != 2131362935) {
      paramInt = i;
    } else {
      paramInt = 2;
    }
    this.d.p2.setCurrentRecordType(paramInt);
  }
  
  public void Y(int paramInt)
  {
    this.d.p2.setAllWeekRecordPlanByType(paramInt);
  }
  
  public void onBackPressed()
  {
    if (this.c.a.get())
    {
      finish();
      return;
    }
    if (this.c.l()) {
      k1();
    } else {
      Q0();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363868: 
      m1(this.c.c.get() ^ true);
      break;
    case 2131363784: 
      n1();
      break;
    case 2131363783: 
      l1();
      break;
    case 2131362501: 
      m1(this.c.c.get() ^ true);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.d = ((ActivityScheduleSettingBinding)DataBindingUtil.setContentView(this, 2131558643));
    Object localObject = (RecordPlanViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(RecordPlanViewModel.class);
    this.c = ((RecordPlanViewModel)localObject);
    this.d.l((RecordPlanViewModel)localObject);
    this.d.i(this);
    this.d.h(new g4(this));
    o1();
    R0();
    RecordPlanViewModel localRecordPlanViewModel = this.c;
    localObject = this.d.p2;
    localObject.getClass();
    localRecordPlanViewModel.H(this, new q3((RecordCustomSettingView)localObject));
    this.c.a.set(true);
    this.c.C(paramBundle);
    j.c(this.c.m, this, new z3(this));
  }
  
  class a
    implements DetectionCloseDialog.a
  {
    a(DetectionCloseDialog paramDetectionCloseDialog) {}
    
    public void a()
    {
      ScheduleSettingActivity.P0(ScheduleSettingActivity.this).a.set(true);
      ScheduleSettingActivity.P0(ScheduleSettingActivity.this).f().G0(new x3(this));
      localDetectionCloseDialog.dismiss();
    }
    
    public void b()
    {
      ScheduleSettingActivity localScheduleSettingActivity = ScheduleSettingActivity.this;
      DetectionSettingActivity.s1(localScheduleSettingActivity, ScheduleSettingActivity.P0(localScheduleSettingActivity).g());
      localDetectionCloseDialog.dismiss();
      ScheduleSettingActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\ScheduleSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */