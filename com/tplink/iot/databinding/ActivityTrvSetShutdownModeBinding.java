package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public abstract class ActivityTrvSetShutdownModeBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPRadioButton c;
  @NonNull
  public final TPRadioButton d;
  @NonNull
  public final RadioGroup f;
  @NonNull
  public final RelativeLayout q;
  @NonNull
  public final TPSwitchCompat x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected ActivityTrvSetShutdownModeBinding(Object paramObject, View paramView, int paramInt, TPRadioButton paramTPRadioButton1, TPRadioButton paramTPRadioButton2, RadioGroup paramRadioGroup, RelativeLayout paramRelativeLayout, TPSwitchCompat paramTPSwitchCompat, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTPRadioButton1;
    this.d = paramTPRadioButton2;
    this.f = paramRadioGroup;
    this.q = paramRelativeLayout;
    this.x = paramTPSwitchCompat;
    this.y = paramTextView1;
    this.z = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetShutdownModeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */