package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.privacymask.PrivacyMaskViewModel;

public abstract class ActivityPrivacyMaskBinding
  extends ViewDataBinding
{
  @Bindable
  protected String H3;
  @NonNull
  public final CameraLoadingView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final FrameLayout f;
  @NonNull
  public final TextView p0;
  @Bindable
  protected PrivacyMaskViewModel p1;
  @Bindable
  protected LiveData<Boolean> p2;
  @Bindable
  protected View.OnClickListener p3;
  @NonNull
  public final ImageView q;
  @NonNull
  public final CheckBox x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final RelativeLayout z;
  
  protected ActivityPrivacyMaskBinding(Object paramObject, View paramView, int paramInt, CameraLoadingView paramCameraLoadingView, TextView paramTextView1, FrameLayout paramFrameLayout, ImageView paramImageView1, CheckBox paramCheckBox, ImageView paramImageView2, RelativeLayout paramRelativeLayout, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCameraLoadingView;
    this.d = paramTextView1;
    this.f = paramFrameLayout;
    this.q = paramImageView1;
    this.x = paramCheckBox;
    this.y = paramImageView2;
    this.z = paramRelativeLayout;
    this.p0 = paramTextView2;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable PrivacyMaskViewModel paramPrivacyMaskViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPrivacyMaskBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */