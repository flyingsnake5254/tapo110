package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;

public abstract class ActivityWhiteLampConfigBinding
  extends ViewDataBinding
{
  @NonNull
  public final SeekBar c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final LinearLayout p0;
  @NonNull
  public final RelativeLayout p1;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final CameraLoadingView z;
  
  protected ActivityWhiteLampConfigBinding(Object paramObject, View paramView, int paramInt, SeekBar paramSeekBar, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5, CameraLoadingView paramCameraLoadingView, LinearLayout paramLinearLayout, RelativeLayout paramRelativeLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramSeekBar;
    this.d = paramTextView1;
    this.f = paramTextView2;
    this.q = paramTextView3;
    this.x = paramTextView4;
    this.y = paramTextView5;
    this.z = paramCameraLoadingView;
    this.p0 = paramLinearLayout;
    this.p1 = paramRelativeLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityWhiteLampConfigBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */