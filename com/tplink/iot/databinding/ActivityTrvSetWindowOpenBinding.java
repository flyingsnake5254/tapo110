package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public abstract class ActivityTrvSetWindowOpenBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemSettingLayout c;
  @NonNull
  public final LinearLayout d;
  @NonNull
  public final RelativeLayout f;
  @NonNull
  public final TPSwitchCompat q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected ActivityTrvSetWindowOpenBinding(Object paramObject, View paramView, int paramInt, ItemSettingLayout paramItemSettingLayout, LinearLayout paramLinearLayout, RelativeLayout paramRelativeLayout, TPSwitchCompat paramTPSwitchCompat, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemSettingLayout;
    this.d = paramLinearLayout;
    this.f = paramRelativeLayout;
    this.q = paramTPSwitchCompat;
    this.x = paramTextView1;
    this.y = paramTextView2;
    this.z = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetWindowOpenBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */