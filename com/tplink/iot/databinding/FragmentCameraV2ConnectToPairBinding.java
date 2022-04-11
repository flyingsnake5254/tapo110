package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;

public abstract class FragmentCameraV2ConnectToPairBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected g y;
  
  protected FragmentCameraV2ConnectToPairBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramLinearLayout;
    this.q = paramTextView1;
    this.x = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2ConnectToPairBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */