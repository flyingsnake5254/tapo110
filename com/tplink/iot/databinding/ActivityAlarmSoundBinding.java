package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSoundViewModel;

public abstract class ActivityAlarmSoundBinding
  extends ViewDataBinding
{
  @NonNull
  public final RadioButton c;
  @NonNull
  public final RadioButton d;
  @NonNull
  public final RadioGroup f;
  @NonNull
  public final Toolbar q;
  @Bindable
  protected AlarmSoundViewModel x;
  
  protected ActivityAlarmSoundBinding(Object paramObject, View paramView, int paramInt, RadioButton paramRadioButton1, RadioButton paramRadioButton2, RadioGroup paramRadioGroup, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRadioButton1;
    this.d = paramRadioButton2;
    this.f = paramRadioGroup;
    this.q = paramToolbar;
  }
  
  public abstract void h(@Nullable AlarmSoundViewModel paramAlarmSoundViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAlarmSoundBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */