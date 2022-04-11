package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.targettrack.TargetTrackViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

public abstract class ActivityTargetTrackBinding
  extends ViewDataBinding
{
  @NonNull
  public final RelativeLayout c;
  @NonNull
  public final TextView d;
  @NonNull
  public final CheckBox f;
  @NonNull
  public final NoninteractiveCheckBox q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @Bindable
  protected TargetTrackViewModel z;
  
  protected ActivityTargetTrackBinding(Object paramObject, View paramView, int paramInt, RelativeLayout paramRelativeLayout, TextView paramTextView1, CheckBox paramCheckBox, NoninteractiveCheckBox paramNoninteractiveCheckBox, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRelativeLayout;
    this.d = paramTextView1;
    this.f = paramCheckBox;
    this.q = paramNoninteractiveCheckBox;
    this.x = paramTextView2;
    this.y = paramTextView3;
  }
  
  public abstract void h(@Nullable TargetTrackViewModel paramTargetTrackViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTargetTrackBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */