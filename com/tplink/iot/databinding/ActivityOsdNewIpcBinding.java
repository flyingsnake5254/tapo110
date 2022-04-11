package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.OsdViewModel;
import com.tplink.iot.widget.ErrorBar;

public abstract class ActivityOsdNewIpcBinding
  extends ViewDataBinding
{
  @Bindable
  protected View.OnClickListener H3;
  @NonNull
  public final ConstraintLayout c;
  @NonNull
  public final CameraLoadingView d;
  @NonNull
  public final ErrorBar f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final Toolbar p1;
  @NonNull
  public final TextView p2;
  @Bindable
  protected OsdViewModel p3;
  @NonNull
  public final TextView q;
  @NonNull
  public final CheckBox x;
  @NonNull
  public final CheckBox y;
  @NonNull
  public final CheckBox z;
  
  protected ActivityOsdNewIpcBinding(Object paramObject, View paramView, int paramInt, ConstraintLayout paramConstraintLayout, CameraLoadingView paramCameraLoadingView, ErrorBar paramErrorBar, TextView paramTextView1, CheckBox paramCheckBox1, CheckBox paramCheckBox2, CheckBox paramCheckBox3, TextView paramTextView2, Toolbar paramToolbar, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramConstraintLayout;
    this.d = paramCameraLoadingView;
    this.f = paramErrorBar;
    this.q = paramTextView1;
    this.x = paramCheckBox1;
    this.y = paramCheckBox2;
    this.z = paramCheckBox3;
    this.p0 = paramTextView2;
    this.p1 = paramToolbar;
    this.p2 = paramTextView3;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable OsdViewModel paramOsdViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityOsdNewIpcBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */