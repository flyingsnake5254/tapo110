package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentCameraControlBinding
  extends ViewDataBinding
{
  @NonNull
  public final RadioButton c;
  @NonNull
  public final RadioButton d;
  @NonNull
  public final RadioGroup f;
  
  protected FragmentCameraControlBinding(Object paramObject, View paramView, int paramInt, RadioButton paramRadioButton1, RadioButton paramRadioButton2, RadioGroup paramRadioGroup)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRadioButton1;
    this.d = paramRadioButton2;
    this.f = paramRadioGroup;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraControlBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */