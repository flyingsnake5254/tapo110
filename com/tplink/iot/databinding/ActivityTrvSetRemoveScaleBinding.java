package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

public abstract class ActivityTrvSetRemoveScaleBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPCircleProgressBar c;
  @NonNull
  public final View d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final RelativeLayout x;
  @NonNull
  public final TPSwitchCompat y;
  @NonNull
  public final TextView z;
  
  protected ActivityTrvSetRemoveScaleBinding(Object paramObject, View paramView1, int paramInt, TPCircleProgressBar paramTPCircleProgressBar, View paramView2, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, RelativeLayout paramRelativeLayout, TPSwitchCompat paramTPSwitchCompat, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramTPCircleProgressBar;
    this.d = paramView2;
    this.f = paramLinearLayout1;
    this.q = paramLinearLayout2;
    this.x = paramRelativeLayout;
    this.y = paramTPSwitchCompat;
    this.z = paramTextView1;
    this.p0 = paramTextView2;
    this.p1 = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetRemoveScaleBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */