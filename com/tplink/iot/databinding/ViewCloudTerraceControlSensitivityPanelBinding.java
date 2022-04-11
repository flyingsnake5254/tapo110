package com.tplink.iot.databinding;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerCardView;

public abstract class ViewCloudTerraceControlSensitivityPanelBinding
  extends ViewDataBinding
{
  @NonNull
  public final TouchListenerCardView c;
  @NonNull
  public final SeekBar d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected LiveData<Integer> y;
  @Bindable
  protected SeekBarBindingAdapter.OnStopTrackingTouch z;
  
  protected ViewCloudTerraceControlSensitivityPanelBinding(Object paramObject, View paramView, int paramInt, TouchListenerCardView paramTouchListenerCardView, SeekBar paramSeekBar, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTouchListenerCardView;
    this.d = paramSeekBar;
    this.f = paramTextView1;
    this.q = paramTextView2;
    this.x = paramTextView3;
  }
  
  public abstract void h(@Nullable LiveData<Integer> paramLiveData);
  
  public abstract void i(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch paramOnStopTrackingTouch);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ViewCloudTerraceControlSensitivityPanelBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */