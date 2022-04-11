package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class ActivityLightStripSetLengthBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextInputEditText c;
  @NonNull
  public final TextInputLayout d;
  @NonNull
  public final TextView f;
  
  protected ActivityLightStripSetLengthBinding(Object paramObject, View paramView, int paramInt, TextInputEditText paramTextInputEditText, TextInputLayout paramTextInputLayout, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextInputEditText;
    this.d = paramTextInputLayout;
    this.f = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightStripSetLengthBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */