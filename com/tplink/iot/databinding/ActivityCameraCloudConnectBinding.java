package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class ActivityCameraCloudConnectBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPRefreshableButton c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final TextView q;
  @Bindable
  protected MutableLiveData<Boolean> x;
  
  protected ActivityCameraCloudConnectBinding(Object paramObject, View paramView, int paramInt, TPRefreshableButton paramTPRefreshableButton, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTPRefreshableButton;
    this.d = paramImageView;
    this.f = paramLinearLayout;
    this.q = paramTextView;
  }
  
  public abstract void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCameraCloudConnectBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */