package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import com.tplink.iot.viewmodel.ipcamera.setting.MotionDetectionViewModel;

public abstract class ActivityMotionDetectionBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @NonNull
  public final TextView I3;
  @NonNull
  public final FrameLayout J3;
  @NonNull
  public final ImageView K3;
  @NonNull
  public final LinearLayout L3;
  @NonNull
  public final TextView M3;
  @NonNull
  public final CheckBox N3;
  @Bindable
  protected MotionDetectionViewModel O3;
  @Bindable
  protected SeekBarBindingAdapter.OnStopTrackingTouch P3;
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final ConstraintLayout f;
  @NonNull
  public final RelativeLayout p0;
  @NonNull
  public final SeekBar p1;
  @NonNull
  public final TextView p2;
  @NonNull
  public final TextView p3;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final Toolbar y;
  @NonNull
  public final TextView z;
  
  protected ActivityMotionDetectionBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, ConstraintLayout paramConstraintLayout, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, Toolbar paramToolbar, TextView paramTextView3, RelativeLayout paramRelativeLayout, SeekBar paramSeekBar, TextView paramTextView4, TextView paramTextView5, TextView paramTextView6, TextView paramTextView7, FrameLayout paramFrameLayout, ImageView paramImageView, LinearLayout paramLinearLayout3, TextView paramTextView8, CheckBox paramCheckBox)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramConstraintLayout;
    this.q = paramLinearLayout1;
    this.x = paramLinearLayout2;
    this.y = paramToolbar;
    this.z = paramTextView3;
    this.p0 = paramRelativeLayout;
    this.p1 = paramSeekBar;
    this.p2 = paramTextView4;
    this.p3 = paramTextView5;
    this.H3 = paramTextView6;
    this.I3 = paramTextView7;
    this.J3 = paramFrameLayout;
    this.K3 = paramImageView;
    this.L3 = paramLinearLayout3;
    this.M3 = paramTextView8;
    this.N3 = paramCheckBox;
  }
  
  public abstract void h(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch paramOnStopTrackingTouch);
  
  public abstract void i(@Nullable MotionDetectionViewModel paramMotionDetectionViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMotionDetectionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */