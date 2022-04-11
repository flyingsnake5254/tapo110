package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.aidetection.AIDetectionViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

public abstract class ActivityAiDetectionBinding
  extends ViewDataBinding
{
  @Bindable
  protected View.OnClickListener H3;
  @Bindable
  protected SeekBarBindingAdapter.OnStopTrackingTouch I3;
  @NonNull
  public final TextView c;
  @NonNull
  public final NoninteractiveCheckBox d;
  @NonNull
  public final NoninteractiveCheckBox f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final TextView p2;
  @Bindable
  protected AIDetectionViewModel p3;
  @NonNull
  public final CameraLoadingView q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final SeekBar y;
  @NonNull
  public final TextView z;
  
  protected ActivityAiDetectionBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, NoninteractiveCheckBox paramNoninteractiveCheckBox1, NoninteractiveCheckBox paramNoninteractiveCheckBox2, CameraLoadingView paramCameraLoadingView, LinearLayout paramLinearLayout, SeekBar paramSeekBar, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramNoninteractiveCheckBox1;
    this.f = paramNoninteractiveCheckBox2;
    this.q = paramCameraLoadingView;
    this.x = paramLinearLayout;
    this.y = paramSeekBar;
    this.z = paramTextView2;
    this.p0 = paramTextView3;
    this.p1 = paramTextView4;
    this.p2 = paramTextView5;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch paramOnStopTrackingTouch);
  
  public abstract void l(@Nullable AIDetectionViewModel paramAIDetectionViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAiDetectionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */