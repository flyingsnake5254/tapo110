package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public abstract class ActivityTrvSetChildProtectionBinding
  extends ViewDataBinding
{
  @NonNull
  public final RelativeLayout c;
  @NonNull
  public final TPSwitchCompat d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  
  protected ActivityTrvSetChildProtectionBinding(Object paramObject, View paramView, int paramInt, RelativeLayout paramRelativeLayout, TPSwitchCompat paramTPSwitchCompat, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRelativeLayout;
    this.d = paramTPSwitchCompat;
    this.f = paramTextView1;
    this.q = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetChildProtectionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */