package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;

public abstract class ActivityCameraPreviewBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ActivityCameraPreviewModePartBinding f;
  @Bindable
  protected MutableLiveData<Boolean> p0;
  @Bindable
  protected MutableLiveData<Boolean> p1;
  @NonNull
  public final ActivityCameraPreviewCloudVideoServerBinding q;
  @NonNull
  public final RecyclerView x;
  @NonNull
  public final PullToRefreshContainer y;
  @Bindable
  protected MutableLiveData<Boolean> z;
  
  protected ActivityCameraPreviewBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView, ImageView paramImageView, ActivityCameraPreviewModePartBinding paramActivityCameraPreviewModePartBinding, ActivityCameraPreviewCloudVideoServerBinding paramActivityCameraPreviewCloudVideoServerBinding, RecyclerView paramRecyclerView, PullToRefreshContainer paramPullToRefreshContainer)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView;
    this.d = paramImageView;
    this.f = paramActivityCameraPreviewModePartBinding;
    this.q = paramActivityCameraPreviewCloudVideoServerBinding;
    this.x = paramRecyclerView;
    this.y = paramPullToRefreshContainer;
  }
  
  public abstract void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
  
  public abstract void i(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
  
  public abstract void l(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCameraPreviewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */