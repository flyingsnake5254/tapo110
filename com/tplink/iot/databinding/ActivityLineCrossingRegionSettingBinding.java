package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingViewModel;

public abstract class ActivityLineCrossingRegionSettingBinding
  extends ViewDataBinding
{
  @Nullable
  public final View H3;
  @Nullable
  public final ImageView I3;
  @Nullable
  public final FrameLayout J3;
  @Nullable
  public final ImageView K3;
  @Nullable
  public final View L3;
  @Nullable
  public final FrameLayout M3;
  @Nullable
  public final ImageView N3;
  @Nullable
  public final RelativeLayout O3;
  @Nullable
  public final ImageView P3;
  @Nullable
  public final ImageView Q3;
  @NonNull
  public final View R3;
  @NonNull
  public final FrameLayout S3;
  @NonNull
  public final ImageView T3;
  @Nullable
  public final TextView U3;
  @Nullable
  public final Toolbar V3;
  @Bindable
  protected LineCrossingViewModel W3;
  @Bindable
  protected View.OnClickListener X3;
  @NonNull
  public final View c;
  @Nullable
  public final View d;
  @Nullable
  public final View f;
  @Nullable
  public final View p0;
  @Nullable
  public final FrameLayout p1;
  @Nullable
  public final ImageView p2;
  @Nullable
  public final View p3;
  @Nullable
  public final FrameLayout q;
  @Nullable
  public final ImageView x;
  @Nullable
  public final FrameLayout y;
  @Nullable
  public final ImageView z;
  
  protected ActivityLineCrossingRegionSettingBinding(Object paramObject, View paramView1, int paramInt, View paramView2, View paramView3, View paramView4, FrameLayout paramFrameLayout1, ImageView paramImageView1, FrameLayout paramFrameLayout2, ImageView paramImageView2, View paramView5, FrameLayout paramFrameLayout3, ImageView paramImageView3, View paramView6, View paramView7, ImageView paramImageView4, FrameLayout paramFrameLayout4, ImageView paramImageView5, View paramView8, FrameLayout paramFrameLayout5, ImageView paramImageView6, RelativeLayout paramRelativeLayout, ImageView paramImageView7, ImageView paramImageView8, View paramView9, FrameLayout paramFrameLayout6, ImageView paramImageView9, TextView paramTextView, Toolbar paramToolbar)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramView3;
    this.f = paramView4;
    this.q = paramFrameLayout1;
    this.x = paramImageView1;
    this.y = paramFrameLayout2;
    this.z = paramImageView2;
    this.p0 = paramView5;
    this.p1 = paramFrameLayout3;
    this.p2 = paramImageView3;
    this.p3 = paramView6;
    this.H3 = paramView7;
    this.I3 = paramImageView4;
    this.J3 = paramFrameLayout4;
    this.K3 = paramImageView5;
    this.L3 = paramView8;
    this.M3 = paramFrameLayout5;
    this.N3 = paramImageView6;
    this.O3 = paramRelativeLayout;
    this.P3 = paramImageView7;
    this.Q3 = paramImageView8;
    this.R3 = paramView9;
    this.S3 = paramFrameLayout6;
    this.T3 = paramImageView9;
    this.U3 = paramTextView;
    this.V3 = paramToolbar;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable LineCrossingViewModel paramLineCrossingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLineCrossingRegionSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */