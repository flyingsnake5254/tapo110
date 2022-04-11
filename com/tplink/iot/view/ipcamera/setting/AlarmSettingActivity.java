package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityAlarmSettingBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;
import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDay;
import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDayUtils;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class AlarmSettingActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private HashMap H3;
  private ActivityAlarmSettingBinding p0;
  private AlarmSettingViewModel p1;
  private String p2;
  private int p3 = 3;
  private final int z = 10001;
  
  private final void g1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.p2 = ((String)localObject);
    this.p3 = getIntent().getIntExtra("detection_home_mode", 3);
    localObject = this.p2;
    if (localObject == null) {
      j.t("deviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(AlarmSettingViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…ingViewModel::class.java)");
    this.p1 = ((AlarmSettingViewModel)localObject);
    ActivityAlarmSettingBinding localActivityAlarmSettingBinding = this.p0;
    if (localActivityAlarmSettingBinding == null) {
      j.t("binding");
    }
    localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    localActivityAlarmSettingBinding.i((AlarmSettingViewModel)localObject);
    localObject = this.p0;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivityAlarmSettingBinding)localObject).h(this);
    localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    ((AlarmSettingViewModel)localObject).l(this.p3);
  }
  
  private final void h1()
  {
    AlarmSettingViewModel localAlarmSettingViewModel = this.p1;
    if (localAlarmSettingViewModel == null) {
      j.t("viewModel");
    }
    localAlarmSettingViewModel.a.observe(this, new b(this));
    localAlarmSettingViewModel = this.p1;
    if (localAlarmSettingViewModel == null) {
      j.t("viewModel");
    }
    localAlarmSettingViewModel.b.observe(this, new c(this));
    localAlarmSettingViewModel = this.p1;
    if (localAlarmSettingViewModel == null) {
      j.t("viewModel");
    }
    localAlarmSettingViewModel.c.observe(this, new d(this));
  }
  
  private final void i1()
  {
    b1(2131951858);
  }
  
  private final List<BitwiseWeekDay> k1(boolean[] paramArrayOfBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = BitwiseWeekDayUtils.getAllDays();
    if (paramArrayOfBoolean.length == localList.size())
    {
      int i = 0;
      int j = paramArrayOfBoolean.length;
      while (i < j)
      {
        if (paramArrayOfBoolean[i] != 0) {
          localArrayList.add(localList.get(i));
        }
        i++;
      }
    }
    return localArrayList;
  }
  
  public View e1(int paramInt)
  {
    if (this.H3 == null) {
      this.H3 = new HashMap();
    }
    View localView1 = (View)this.H3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.H3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public final void j1()
  {
    Intent localIntent = new Intent(this, ScheduleEditActivity.class);
    localIntent.putExtra("canPastMidnight", true);
    localIntent.putExtra("mode", "modify");
    localIntent.putExtra("deletable", false);
    Object localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    localIntent.putExtra("startTime", (String)((AlarmSettingViewModel)localObject).h.get());
    localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    localIntent.putExtra("endTime", (String)((AlarmSettingViewModel)localObject).i.get());
    localObject = this.p2;
    if (localObject == null) {
      j.t("deviceIdMD5");
    }
    localIntent.putExtra("device_id_md5", (String)localObject);
    localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    localObject = ((AlarmSettingViewModel)localObject).j();
    j.d(localObject, "viewModel.alarmSchedule");
    int i = 127;
    if (localObject != null) {
      i = ((com.tplink.libtpnetwork.cameranetwork.business.model.a)localObject).b().getType();
    }
    localObject = this.p1;
    if (localObject == null) {
      j.t("viewModel");
    }
    localIntent.putExtra("weekDayArr", ((AlarmSettingViewModel)localObject).Q(i));
    startActivityForResult(localIntent, this.z);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramInt2 == 101))
    {
      String str = paramIntent.getStringExtra("startTime");
      Object localObject1 = "";
      if (str == null) {
        str = "";
      }
      j.d(str, "data.getStringExtra(\"startTime\") ?: \"\"");
      Object localObject2 = paramIntent.getStringExtra("endTime");
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      j.d(localObject1, "data.getStringExtra(\"endTime\") ?: \"\"");
      paramIntent = paramIntent.getSerializableExtra("weekDayArr");
      Objects.requireNonNull(paramIntent, "null cannot be cast to non-null type kotlin.BooleanArray");
      localObject2 = (boolean[])paramIntent;
      paramIntent = this.p1;
      if (paramIntent == null) {
        j.t("viewModel");
      }
      paramIntent.U(true, str, (String)localObject1, k1((boolean[])localObject2));
    }
  }
  
  public void onClick(View paramView)
  {
    int i = com.tplink.iot.a.alarm_switch;
    Object localObject;
    if (j.a(paramView, (CheckBox)e1(i)))
    {
      localObject = this.p1;
      if (localObject == null) {
        j.t("viewModel");
      }
      paramView = (CheckBox)e1(i);
      j.d(paramView, "alarm_switch");
      ((AlarmSettingViewModel)localObject).T(paramView.isChecked());
    }
    else if (j.a(paramView, (RelativeLayout)e1(com.tplink.iot.a.alert_type)))
    {
      localObject = AlarmTypeActivity.y;
      paramView = this.p2;
      if (paramView == null) {
        j.t("deviceIdMD5");
      }
      ((AlarmTypeActivity.a)localObject).a(this, paramView, this.p3);
    }
    else if (j.a(paramView, (RelativeLayout)e1(com.tplink.iot.a.sound_type)))
    {
      localObject = AlarmSoundActivity.y;
      paramView = this.p2;
      if (paramView == null) {
        j.t("deviceIdMD5");
      }
      ((AlarmSoundActivity.a)localObject).a(this, paramView, this.p3);
    }
    else if (j.a(paramView, (RadioButton)e1(com.tplink.iot.a.all_day_item)))
    {
      paramView = this.p1;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.O();
    }
    else if (j.a(paramView, (RadioButton)e1(com.tplink.iot.a.custom_item)))
    {
      paramView = this.p1;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.P();
    }
    else if (j.a(paramView, (RelativeLayout)e1(com.tplink.iot.a.item_schedule_container)))
    {
      j1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558439);
    j.d(paramBundle, "DataBindingUtil.setConte…t.activity_alarm_setting)");
    this.p0 = ((ActivityAlarmSettingBinding)paramBundle);
    i1();
    g1();
    h1();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    AlarmSettingViewModel localAlarmSettingViewModel = this.p1;
    if (localAlarmSettingViewModel == null) {
      j.t("viewModel");
    }
    localAlarmSettingViewModel.N();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, AlarmSettingActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements Observer<Boolean>
  {
    b(AlarmSettingActivity paramAlarmSettingActivity) {}
    
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
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(AlarmSettingActivity paramAlarmSettingActivity) {}
    
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
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(AlarmSettingActivity paramAlarmSettingActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        AlarmSettingActivity.f1(this.a).p2.check(2131362346);
        paramBoolean = AlarmSettingActivity.f1(this.a).q;
        j.d(paramBoolean, "binding.allDayItem");
        paramBoolean.setClickable(true);
        paramBoolean = AlarmSettingActivity.f1(this.a).x;
        j.d(paramBoolean, "binding.customItem");
        paramBoolean.setClickable(false);
        paramBoolean = AlarmSettingActivity.f1(this.a).y;
        j.d(paramBoolean, "binding.itemScheduleContainer");
        paramBoolean.setVisibility(0);
      }
      else
      {
        AlarmSettingActivity.f1(this.a).p2.check(2131361958);
        paramBoolean = AlarmSettingActivity.f1(this.a).q;
        j.d(paramBoolean, "binding.allDayItem");
        paramBoolean.setClickable(false);
        paramBoolean = AlarmSettingActivity.f1(this.a).x;
        j.d(paramBoolean, "binding.customItem");
        paramBoolean.setClickable(true);
        paramBoolean = AlarmSettingActivity.f1(this.a).y;
        j.d(paramBoolean, "binding.itemScheduleContainer");
        paramBoolean.setVisibility(8);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\AlarmSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */