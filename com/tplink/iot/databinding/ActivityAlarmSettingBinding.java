package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.ScheduleWeekdayTextView;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;

public abstract class ActivityAlarmSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @NonNull
  public final RelativeLayout I3;
  @NonNull
  public final LinearLayout J3;
  @NonNull
  public final View K3;
  @NonNull
  public final TextView L3;
  @NonNull
  public final TextView M3;
  @NonNull
  public final ScheduleWeekdayTextView N3;
  @Bindable
  protected View.OnClickListener O3;
  @Bindable
  protected AlarmSettingViewModel P3;
  @NonNull
  public final CheckBox c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final RadioGroup p2;
  @NonNull
  public final TextView p3;
  @NonNull
  public final RadioButton q;
  @NonNull
  public final RadioButton x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final TextView z;
  
  protected ActivityAlarmSettingBinding(Object paramObject, View paramView1, int paramInt, CheckBox paramCheckBox, RelativeLayout paramRelativeLayout1, TextView paramTextView1, RadioButton paramRadioButton1, RadioButton paramRadioButton2, RelativeLayout paramRelativeLayout2, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, RadioGroup paramRadioGroup, TextView paramTextView5, TextView paramTextView6, RelativeLayout paramRelativeLayout3, LinearLayout paramLinearLayout, View paramView2, TextView paramTextView7, TextView paramTextView8, ScheduleWeekdayTextView paramScheduleWeekdayTextView)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramCheckBox;
    this.d = paramRelativeLayout1;
    this.f = paramTextView1;
    this.q = paramRadioButton1;
    this.x = paramRadioButton2;
    this.y = paramRelativeLayout2;
    this.z = paramTextView2;
    this.p0 = paramTextView3;
    this.p1 = paramTextView4;
    this.p2 = paramRadioGroup;
    this.p3 = paramTextView5;
    this.H3 = paramTextView6;
    this.I3 = paramRelativeLayout3;
    this.J3 = paramLinearLayout;
    this.K3 = paramView2;
    this.L3 = paramTextView7;
    this.M3 = paramTextView8;
    this.N3 = paramScheduleWeekdayTextView;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable AlarmSettingViewModel paramAlarmSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAlarmSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */