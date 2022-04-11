package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmTypeViewModel;

public abstract class ActivityAlarmTypeBinding
  extends ViewDataBinding
{
  @NonNull
  public final RadioButton c;
  @NonNull
  public final RadioGroup d;
  @NonNull
  public final RadioButton f;
  @NonNull
  public final RadioButton q;
  @NonNull
  public final Toolbar x;
  @Bindable
  protected View.OnClickListener y;
  @Bindable
  protected AlarmTypeViewModel z;
  
  protected ActivityAlarmTypeBinding(Object paramObject, View paramView, int paramInt, RadioButton paramRadioButton1, RadioGroup paramRadioGroup, RadioButton paramRadioButton2, RadioButton paramRadioButton3, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRadioButton1;
    this.d = paramRadioGroup;
    this.f = paramRadioButton2;
    this.q = paramRadioButton3;
    this.x = paramToolbar;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable AlarmTypeViewModel paramAlarmTypeViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAlarmTypeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */