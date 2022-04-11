package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.setting.ScheduleWeekView;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;

public abstract class ActivityScheduleEditBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @Bindable
  protected AlarmSettingViewModel p0;
  @Bindable
  protected View.OnClickListener p1;
  @NonNull
  public final ScheduleWeekView q;
  @NonNull
  public final Button x;
  @NonNull
  public final TextView y;
  @NonNull
  public final Toolbar z;
  
  protected ActivityScheduleEditBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, ScheduleWeekView paramScheduleWeekView, Button paramButton, TextView paramTextView4, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramTextView3;
    this.q = paramScheduleWeekView;
    this.x = paramButton;
    this.y = paramTextView4;
    this.z = paramToolbar;
  }
  
  public abstract void h(@Nullable AlarmSettingViewModel paramAlarmSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityScheduleEditBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */