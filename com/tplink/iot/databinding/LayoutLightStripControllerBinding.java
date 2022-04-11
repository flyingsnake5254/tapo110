package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.widget.LightStripBrightnessController;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;

public abstract class LayoutLightStripControllerBinding
  extends ViewDataBinding
{
  @NonNull
  public final SimpleTextSwitcher c;
  @NonNull
  public final TPCheckboxCompat d;
  @NonNull
  public final LightStripBrightnessController f;
  @NonNull
  public final TextView q;
  
  protected LayoutLightStripControllerBinding(Object paramObject, View paramView, int paramInt, SimpleTextSwitcher paramSimpleTextSwitcher, TPCheckboxCompat paramTPCheckboxCompat, LightStripBrightnessController paramLightStripBrightnessController, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramSimpleTextSwitcher;
    this.d = paramTPCheckboxCompat;
    this.f = paramLightStripBrightnessController;
    this.q = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripControllerBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */