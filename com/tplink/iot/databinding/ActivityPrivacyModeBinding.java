package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;

public abstract class ActivityPrivacyModeBinding
  extends ViewDataBinding
{
  @NonNull
  public final CameraLoadingView c;
  @NonNull
  public final View d;
  @NonNull
  public final CheckBox f;
  @Bindable
  protected String p0;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected LensMaskViewModel y;
  @Bindable
  protected LiveData<Boolean> z;
  
  protected ActivityPrivacyModeBinding(Object paramObject, View paramView1, int paramInt, CameraLoadingView paramCameraLoadingView, View paramView2, CheckBox paramCheckBox, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramCameraLoadingView;
    this.d = paramView2;
    this.f = paramCheckBox;
    this.q = paramTextView1;
    this.x = paramTextView2;
  }
  
  public abstract void h(@Nullable String paramString);
  
  public abstract void i(@Nullable LensMaskViewModel paramLensMaskViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPrivacyModeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */