package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;

public abstract class ActivityLightStripSetDefaultStateBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout c;
  @NonNull
  public final TPRadioButton d;
  @NonNull
  public final TPRadioButton f;
  @NonNull
  public final RadioGroup q;
  
  protected ActivityLightStripSetDefaultStateBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout, TPRadioButton paramTPRadioButton1, TPRadioButton paramTPRadioButton2, RadioGroup paramRadioGroup)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout;
    this.d = paramTPRadioButton1;
    this.f = paramTPRadioButton2;
    this.q = paramRadioGroup;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightStripSetDefaultStateBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */