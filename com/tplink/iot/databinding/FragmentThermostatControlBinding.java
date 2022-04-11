package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

public abstract class FragmentThermostatControlBinding
  extends ViewDataBinding
{
  @NonNull
  public final MaterialEditText c;
  @NonNull
  public final RadioGroup d;
  @NonNull
  public final RadioButton f;
  @NonNull
  public final RadioButton q;
  
  protected FragmentThermostatControlBinding(Object paramObject, View paramView, int paramInt, MaterialEditText paramMaterialEditText, RadioGroup paramRadioGroup, RadioButton paramRadioButton1, RadioButton paramRadioButton2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramMaterialEditText;
    this.d = paramRadioGroup;
    this.f = paramRadioButton1;
    this.q = paramRadioButton2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentThermostatControlBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */