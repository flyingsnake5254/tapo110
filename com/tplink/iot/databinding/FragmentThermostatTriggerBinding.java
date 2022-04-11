package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

public abstract class FragmentThermostatTriggerBinding
  extends ViewDataBinding
{
  @NonNull
  public final MaterialEditText c;
  @NonNull
  public final MaterialEditText d;
  @NonNull
  public final RadioGroup f;
  @NonNull
  public final RadioButton q;
  @NonNull
  public final RadioButton x;
  @NonNull
  public final RadioButton y;
  
  protected FragmentThermostatTriggerBinding(Object paramObject, View paramView, int paramInt, MaterialEditText paramMaterialEditText1, MaterialEditText paramMaterialEditText2, RadioGroup paramRadioGroup, RadioButton paramRadioButton1, RadioButton paramRadioButton2, RadioButton paramRadioButton3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramMaterialEditText1;
    this.d = paramMaterialEditText2;
    this.f = paramRadioGroup;
    this.q = paramRadioButton1;
    this.x = paramRadioButton2;
    this.y = paramRadioButton3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentThermostatTriggerBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */