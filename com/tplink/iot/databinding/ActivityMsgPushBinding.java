package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.ScheduleWeekdayTextView;
import com.tplink.iot.viewmodel.ipcamera.setting.MsgPushViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

public abstract class ActivityMsgPushBinding
  extends ViewDataBinding
{
  @NonNull
  public final View H3;
  @NonNull
  public final ScheduleWeekdayTextView I3;
  @Bindable
  protected View.OnClickListener J3;
  @Bindable
  protected MsgPushViewModel K3;
  @NonNull
  public final RadioButton c;
  @NonNull
  public final RadioButton d;
  @NonNull
  public final RelativeLayout f;
  @NonNull
  public final CheckBox p0;
  @NonNull
  public final NoninteractiveCheckBox p1;
  @NonNull
  public final RadioGroup p2;
  @NonNull
  public final LinearLayout p3;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final LinearLayout z;
  
  protected ActivityMsgPushBinding(Object paramObject, View paramView1, int paramInt, RadioButton paramRadioButton1, RadioButton paramRadioButton2, RelativeLayout paramRelativeLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, LinearLayout paramLinearLayout1, CheckBox paramCheckBox, NoninteractiveCheckBox paramNoninteractiveCheckBox, RadioGroup paramRadioGroup, LinearLayout paramLinearLayout2, View paramView2, ScheduleWeekdayTextView paramScheduleWeekdayTextView)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramRadioButton1;
    this.d = paramRadioButton2;
    this.f = paramRelativeLayout;
    this.q = paramTextView1;
    this.x = paramTextView2;
    this.y = paramTextView3;
    this.z = paramLinearLayout1;
    this.p0 = paramCheckBox;
    this.p1 = paramNoninteractiveCheckBox;
    this.p2 = paramRadioGroup;
    this.p3 = paramLinearLayout2;
    this.H3 = paramView2;
    this.I3 = paramScheduleWeekdayTextView;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable MsgPushViewModel paramMsgPushViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMsgPushBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */