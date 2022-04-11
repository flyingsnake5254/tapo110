package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerracePresetViewModel;

public abstract class FragmentCloudTerracePresetBinding
  extends ViewDataBinding
{
  @NonNull
  public final RecyclerView c;
  @NonNull
  public final CameraLoadingView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView q;
  @Bindable
  protected CloudTerracePresetViewModel x;
  
  protected FragmentCloudTerracePresetBinding(Object paramObject, View paramView, int paramInt, RecyclerView paramRecyclerView, CameraLoadingView paramCameraLoadingView, ImageView paramImageView, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRecyclerView;
    this.d = paramCameraLoadingView;
    this.f = paramImageView;
    this.q = paramTextView;
  }
  
  public abstract void h(@Nullable CloudTerracePresetViewModel paramCloudTerracePresetViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCloudTerracePresetBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */