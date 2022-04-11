package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.PointTextView;

public abstract class FragmentSubGNoFoundBinding
  extends ViewDataBinding
{
  @NonNull
  public final PointTextView H3;
  @Bindable
  protected SubGViewModel I3;
  @Bindable
  protected g J3;
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final PointTextView p0;
  @NonNull
  public final PointTextView p1;
  @NonNull
  public final PointTextView p2;
  @NonNull
  public final PointTextView p3;
  @NonNull
  public final VariousImageViewLayout q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentSubGNoFoundBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView1, ImageView paramImageView2, VariousImageViewLayout paramVariousImageViewLayout, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2, PointTextView paramPointTextView1, PointTextView paramPointTextView2, PointTextView paramPointTextView3, PointTextView paramPointTextView4, PointTextView paramPointTextView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramVariousImageViewLayout;
    this.x = paramLinearLayout;
    this.y = paramTextView1;
    this.z = paramTextView2;
    this.p0 = paramPointTextView1;
    this.p1 = paramPointTextView2;
    this.p2 = paramPointTextView3;
    this.p3 = paramPointTextView4;
    this.H3 = paramPointTextView5;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGNoFoundBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */