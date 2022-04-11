package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;

public abstract class FragmentCloudTerraceControlBinding
  extends ViewDataBinding
{
  @NonNull
  public final ConstraintLayout c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @Bindable
  protected CloudTerraceControlViewModel p2;
  @Bindable
  protected Boolean p3;
  @NonNull
  public final CameraLoadingView q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final CloudTerraceControlPanel y;
  @NonNull
  public final ImageView z;
  
  protected FragmentCloudTerraceControlBinding(Object paramObject, View paramView, int paramInt, ConstraintLayout paramConstraintLayout, ImageView paramImageView1, ImageView paramImageView2, CameraLoadingView paramCameraLoadingView, ImageView paramImageView3, CloudTerraceControlPanel paramCloudTerraceControlPanel, ImageView paramImageView4, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramConstraintLayout;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramCameraLoadingView;
    this.x = paramImageView3;
    this.y = paramCloudTerraceControlPanel;
    this.z = paramImageView4;
    this.p0 = paramTextView1;
    this.p1 = paramTextView2;
  }
  
  public abstract void h(@Nullable CloudTerraceControlViewModel paramCloudTerraceControlViewModel);
  
  public abstract void i(@Nullable Boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCloudTerraceControlBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */