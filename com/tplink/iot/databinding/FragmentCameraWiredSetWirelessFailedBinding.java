package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.widget.PointTextView;

public abstract class FragmentCameraWiredSetWirelessFailedBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final LinearLayout f;
  @Bindable
  protected g p0;
  @NonNull
  public final PointTextView q;
  @NonNull
  public final PointTextView x;
  @NonNull
  public final Toolbar y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraWiredSetWirelessFailedBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView, LinearLayout paramLinearLayout, PointTextView paramPointTextView1, PointTextView paramPointTextView2, Toolbar paramToolbar, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView;
    this.f = paramLinearLayout;
    this.q = paramPointTextView1;
    this.x = paramPointTextView2;
    this.y = paramToolbar;
    this.z = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraWiredSetWirelessFailedBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */