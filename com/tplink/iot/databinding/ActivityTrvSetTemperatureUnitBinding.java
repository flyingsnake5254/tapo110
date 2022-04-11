package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;

public abstract class ActivityTrvSetTemperatureUnitBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPRadioButton c;
  @NonNull
  public final TPRadioButton d;
  @NonNull
  public final RadioGroup f;
  
  protected ActivityTrvSetTemperatureUnitBinding(Object paramObject, View paramView, int paramInt, TPRadioButton paramTPRadioButton1, TPRadioButton paramTPRadioButton2, RadioGroup paramRadioGroup)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTPRadioButton1;
    this.d = paramTPRadioButton2;
    this.f = paramRadioGroup;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetTemperatureUnitBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */